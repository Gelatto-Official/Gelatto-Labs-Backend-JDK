package net.gelatto.labs.java_sdk.examples;

import net.gelatto.labs.java_sdk.ApiClient;
import net.gelatto.labs.java_sdk.ApiException;
import net.gelatto.labs.java_sdk.apis.UserApi;
import net.gelatto.labs.java_sdk.managers.UserManager;
import net.gelatto.labs.java_sdk.models.UserModelDTO;

public class ExampleMain {
    // Simple example showing how to initialize the default client and call the manager
    public static void main(String[] args) {
        String apiKey = "your_api_key_here"; // Replace with a valid API key

        // Optionally initialize default client early (custom base URL)
        // For future implementations
        ApiClient custom = new ApiClient.Builder()
                .basePath("https://api-labs.gelatto.net")
                .addDefaultHeader("User-Agent", "gelatto-labs-jdk/1.0.0")
                .build();
        ApiClient.initDefault(custom);

        UserManager userManager = new UserManager(); // uses default client
        try {
            UserModelDTO profile = userManager.getProfile(apiKey);
            System.out.println("Email: " + (profile != null ? profile.email : "null"));
            System.out.println("Username: " + (profile != null ? profile.username : "null"));
            System.out.println("User Role: " + (profile != null ? profile.userRole : "null"));
        } catch (ApiException e) {
            System.err.println("API error: " + e.getMessage());
        }
    }
}

