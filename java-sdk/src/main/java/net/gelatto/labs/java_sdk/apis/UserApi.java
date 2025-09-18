package net.gelatto.labs.java_sdk.apis;

import net.gelatto.labs.java_sdk.ApiClient;
import net.gelatto.labs.java_sdk.ApiException;
import net.gelatto.labs.java_sdk.models.*;

import java.util.HashMap;
import java.util.Map;

public class UserApi {
    private final ApiClient client;

    public UserApi() {
        this(ApiClient.getDefault());
    }

    public UserApi(ApiClient client) {
        this.client = client;
    }

    public UserModelDTO getUserProfile(ApiKeyRequest req) throws ApiException {
        String path = "/api/users/profile";
        return client.post(path, req, null, UserModelDTO.class);
    }

    public Object updateMyProfile(UpdateUserWithApiKeyRequest body) throws ApiException {
        String path = "/api/users/me/profile";
        return client.put(path, body, null, Object.class);
    }

    public Object updateMyCustomIngredient(String customIngredientId, CustomIngredientWithApiKeyRequest body) throws ApiException {
        String path = "/api/users/custom-ingredients/" + customIngredientId;
        return client.put(path, body, null, Object.class);
    }

    public Object deleteMyCustomIngredient(String customIngredientId, ApiKeyRequest body) throws ApiException {
        String path = "/api/users/custom-ingredients/" + customIngredientId;
        return client.delete(path, body, null, Object.class);
    }

    public Object updateMyPrivacy(PrivacyRequest body) throws ApiException {
        String path = "/api/users/me/privacy";
        return client.post(path, body, null, Object.class);
    }

    public Object toggleTwoFA(TwoFaRequest body) throws ApiException {
        String path = "/api/users/me/2fa";
        return client.post(path, body, null, Object.class);
    }

    public java.util.List<CustomIngredientsModel> getMyCustomIngredients(ApiKeyRequest body) throws ApiException {
        String path = "/api/users/custom-ingredients";
        CustomIngredientsModel[] arr = client.post(path, body, null, CustomIngredientsModel[].class);
        if (arr == null) return null;
        return java.util.Arrays.asList(arr);
    }

    public CustomIngredientsModel addMyCustomIngredient(CustomIngredientWithApiKeyRequest body) throws ApiException {
        String path = "/api/users/custom-ingredients/create";
        return client.post(path, body, null, CustomIngredientsModel.class);
    }

    public Object getMyPlan(String apiKey) throws ApiException {
        String path = "/api/users/me/plan";
        Map<String, String> q = new HashMap<>();
        q.put("apiKey", apiKey);
        return client.get(path, q, null, Object.class);
    }
}
