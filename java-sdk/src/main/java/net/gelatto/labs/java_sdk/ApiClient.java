package net.gelatto.labs.java_sdk;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.concurrent.atomic.AtomicReference;
import java.util.Objects;

public class ApiClient {
    private final String basePath;
    private final Gson gson = new Gson();
    private final Map<String, String> defaultHeaders;

    // single shared instance
    private static final AtomicReference<ApiClient> DEFAULT = new AtomicReference<>();

    /**
     * Returns the shared default ApiClient. If not initialized, creates one with default settings.
     */
    public static ApiClient getDefault() {
        ApiClient inst = DEFAULT.get();
        if (inst != null) return inst;
        ApiClient created = new Builder().build();
        if (DEFAULT.compareAndSet(null, created)) return created;
        return DEFAULT.get();
    }

    /**
     * Initialize the default ApiClient if none exists. Returns true if set, false if already initialized.
     */
    public static boolean initDefault(ApiClient client) {
        Objects.requireNonNull(client, "client");
        return DEFAULT.compareAndSet(null, client);
    }

    /**
     * Replace the default ApiClient unconditionally.
     */
    public static void setDefault(ApiClient client) {
        Objects.requireNonNull(client, "client");
        DEFAULT.set(client);
    }

    // private constructor to enforce builder usage
    private ApiClient(String basePath, Map<String, String> defaultHeaders) {
        this.basePath = basePath;
        this.defaultHeaders = defaultHeaders == null ? Collections.emptyMap() : Collections.unmodifiableMap(new HashMap<>(defaultHeaders));
    }

    /**
     * Builder for ApiClient to ensure safe/immutable configuration.
     */
    public static class Builder {
        private String basePath = "https://api-labs.gelatto.net";
        private Map<String, String> defaultHeaders = new HashMap<>();

        public Builder basePath(String basePath) {
            this.basePath = basePath;
            return this;
        }

        public Builder addDefaultHeader(String name, String value) {
            this.defaultHeaders.put(name, value);
            return this;
        }

        public ApiClient build() {
            return new ApiClient(basePath, defaultHeaders);
        }
    }

    // instance methods (immutable client)
    public String getBasePath() {
        return basePath;
    }

    public Map<String, String> getDefaultHeaders() {
        return defaultHeaders;
    }

    private String buildUrl(String path, Map<String, String> query) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append(basePath);
        if (!path.startsWith("/")) sb.append('/');
        sb.append(path);
        if (query != null && !query.isEmpty()) {
            StringJoiner sj = new StringJoiner("&");
            for (Map.Entry<String, String> e : query.entrySet()) {
                sj.add(URLEncoder.encode(e.getKey(), StandardCharsets.UTF_8.name()) + "=" + URLEncoder.encode(e.getValue(), StandardCharsets.UTF_8.name()));
            }
            sb.append('?').append(sj);
        }
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    public <T> T invokeAPI(String path, String method, Map<String, String> queryParams, Object body, Map<String, String> headers, Class<T> returnType) throws ApiException {
        try {
            String urlStr = buildUrl(path, queryParams);
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(method);
            conn.setConnectTimeout(15000);
            conn.setReadTimeout(15000);
            conn.setDoInput(true);

            // merge headers (defaults from immutable map)
            Map<String, String> allHeaders = new HashMap<>(defaultHeaders);
            if (headers != null) allHeaders.putAll(headers);
            allHeaders.putIfAbsent("Accept", "application/json");

            boolean hasBody = body != null && ("POST".equals(method) || "PUT".equals(method) || "PATCH".equals(method) || "DELETE".equals(method));
            if (hasBody) {
                allHeaders.putIfAbsent("Content-Type", "application/json; charset=UTF-8");
                conn.setDoOutput(true);
            }

            for (Map.Entry<String, String> h : allHeaders.entrySet()) {
                conn.setRequestProperty(h.getKey(), h.getValue());
            }

            if (hasBody) {
                String json = gson.toJson(body);
                byte[] out = json.getBytes(StandardCharsets.UTF_8);
                conn.setFixedLengthStreamingMode(out.length);
                try (OutputStream os = conn.getOutputStream()) {
                    os.write(out);
                }
            }

            int status = conn.getResponseCode();
            InputStream is = (status >= 200 && status < 300) ? conn.getInputStream() : conn.getErrorStream();
            String responseText = null;
            if (is != null) {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
                    StringBuilder respSb = new StringBuilder();
                    String line;
                    while ((line = br.readLine()) != null) respSb.append(line).append('\n');
                    responseText = respSb.toString().trim();
                }
            }

            if (status < 200 || status >= 300) {
                throw new ApiException(status, responseText != null ? responseText : "HTTP error code: " + status);
            }

            if (returnType == null || responseText == null || responseText.isEmpty()) return null;

            // try to parse json
            JsonElement el = JsonParser.parseString(responseText);
            if (returnType == String.class) {
                // return raw string
                return (T) responseText;
            }
            return gson.fromJson(el, returnType);
        } catch (ApiException e) {
            throw e;
        } catch (Exception e) {
            throw new ApiException(e.getMessage());
        }
    }

    // convenience shortcuts
    public <T> T get(String path, Map<String, String> queryParams, Map<String, String> headers, Class<T> returnType) throws ApiException {
        return invokeAPI(path, "GET", queryParams, null, headers, returnType);
    }

    public <T> T post(String path, Object body, Map<String, String> headers, Class<T> returnType) throws ApiException {
        return invokeAPI(path, "POST", null, body, headers, returnType);
    }

    public <T> T put(String path, Object body, Map<String, String> headers, Class<T> returnType) throws ApiException {
        return invokeAPI(path, "PUT", null, body, headers, returnType);
    }

    public <T> T delete(String path, Object body, Map<String, String> headers, Class<T> returnType) throws ApiException {
        return invokeAPI(path, "DELETE", null, body, headers, returnType);
    }
}
