package net.gelatto.labs.java_sdk.managers;

import net.gelatto.labs.java_sdk.ApiClient;
import net.gelatto.labs.java_sdk.ApiException;
import net.gelatto.labs.java_sdk.apis.UserApi;
import net.gelatto.labs.java_sdk.models.*;

import java.util.List;

/**
 * High-level manager that wraps UserApi so callers don't need to build request objects manually.
 * All methods accept an apiKey (string) or model objects and return deserialized results or throw ApiException.
 */
public class UserManager {
    private final UserApi api;

    public UserManager() {
        this(ApiClient.getDefault());
    }

    public UserManager(ApiClient client) {
        this.api = new UserApi(client);
    }

    // Retrieve profile by apiKey
    public UserModelDTO getProfile(String apiKey) throws ApiException {
        ApiKeyRequest req = new ApiKeyRequest();
        req.apiKey = apiKey;
        return api.getUserProfile(req);
    }

    // Update own profile: user model + apiKey
    public Object updateProfile(UserModelDTO user, String apiKey) throws ApiException {
        UpdateUserWithApiKeyRequest req = new UpdateUserWithApiKeyRequest();
        req.user = user;
        req.apiKey = apiKey;
        return api.updateMyProfile(req);
    }

    // List my custom ingredients
    public List<CustomIngredientsModel> listCustomIngredients(String apiKey) throws ApiException {
        ApiKeyRequest req = new ApiKeyRequest();
        req.apiKey = apiKey;
        return api.getMyCustomIngredients(req);
    }

    // Add a custom ingredient
    public CustomIngredientsModel addCustomIngredient(CustomIngredientsModel custom, String apiKey) throws ApiException {
        CustomIngredientWithApiKeyRequest req = new CustomIngredientWithApiKeyRequest();
        req.customIngredient = custom;
        req.apiKey = apiKey;
        return api.addMyCustomIngredient(req);
    }

    // Update an existing custom ingredient by id
    public Object updateCustomIngredient(String customIngredientId, CustomIngredientsModel custom, String apiKey) throws ApiException {
        CustomIngredientWithApiKeyRequest req = new CustomIngredientWithApiKeyRequest();
        req.customIngredient = custom;
        req.apiKey = apiKey;
        return api.updateMyCustomIngredient(customIngredientId, req);
    }

    // Delete a custom ingredient by id
    public Object deleteCustomIngredient(String customIngredientId, String apiKey) throws ApiException {
        ApiKeyRequest req = new ApiKeyRequest();
        req.apiKey = apiKey;
        return api.deleteMyCustomIngredient(customIngredientId, req);
    }

    // Toggle 2FA (enable/disable)
    public Object toggleTwoFa(boolean enabled, String apiKey) throws ApiException {
        TwoFaRequest req = new TwoFaRequest();
        req.apiKey = apiKey;
        req.enabled = enabled;
        return api.toggleTwoFA(req);
    }

    // Update privacy (private profile)
    public Object updatePrivacy(boolean isPrivateProfile, String apiKey) throws ApiException {
        PrivacyRequest req = new PrivacyRequest();
        req.apiKey = apiKey;
        req.isPrivateProfile = isPrivateProfile;
        return api.updateMyPrivacy(req);
    }

    // Get my plan info
    public Object getMyPlan(String apiKey) throws ApiException {
        return api.getMyPlan(apiKey);
    }
}
