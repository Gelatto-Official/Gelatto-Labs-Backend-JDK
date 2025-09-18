package net.gelatto.labs.java_sdk.guice.examples;

import com.google.inject.Guice;
import com.google.inject.Injector;
import net.gelatto.labs.java_sdk.ApiException;
import net.gelatto.labs.java_sdk.guice.UserModule;
import net.gelatto.labs.java_sdk.managers.UserManager;
import net.gelatto.labs.java_sdk.models.UserModelDTO;

/**
 * FOR USE THIS 'IMPLEMENTATION' GUICE DEPENDENCY INSTEAD OF 'COMPILE_ONLY'
 * Simple example showing how to use Guice with UserModule to obtain a UserManager instance.
 */
public class ExampleGuiceMain {
    public static void main(String[] args) {
        String apiKey = "your_api_key_here"; // Replace with a valid API key

        // Create injector with optional basePath (null uses default)
        Injector injector = Guice.createInjector(new UserModule("https://api-labs.gelatto.net"));

        // UserManager is provided as a singleton by the module
        UserManager userManager = injector.getInstance(UserManager.class);

        try {
            UserModelDTO profile = userManager.getProfile(apiKey);
            System.out.println("Email: " + (profile != null ? profile.getEmail() : "null"));
            System.out.println("Username: " + (profile != null ? profile.getUsername() : "null"));
            System.out.println("User Role: " + (profile != null ? profile.userRole : "null"));
        } catch (ApiException e) {
            System.err.println("API error: " + e.getMessage());
        }
    }
}

