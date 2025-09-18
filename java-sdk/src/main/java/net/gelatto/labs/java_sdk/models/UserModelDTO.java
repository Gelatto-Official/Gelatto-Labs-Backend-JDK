package net.gelatto.labs.java_sdk.models;

import java.util.List;
import java.util.Map;

public class UserModelDTO {
    public String id;
    public String email;
    public String recoveryEmail;
    public String username;
    public String password;
    public String userRole;
    public String subUserParentUserId;
    public List<String> subUserIds;
    public String planId;
    public Long planStartDate;
    public Long planEndDate;
    public String displayName;
    public String profilePictureUrl;
    public String firstName;
    public String lastName;
    public String phoneNumber;
    public String address;
    public String city;
    public String country;
    public String postalCode;
    public String website;
    public Long createdAt;
    public Long updatedAt;
    public Map<String, Boolean> emailVerifyMethods;
    public java.util.List<net.gelatto.labs.java_sdk.models.IngredientsModel> ingredients;
    public java.util.List<net.gelatto.labs.java_sdk.models.CustomIngredientsModel> customIngredients;
    public java.util.List<net.gelatto.labs.java_sdk.models.RecipeModel> recipes;
    public Boolean active;
    public Boolean privateProfile;
    public Boolean is2FAEnabled;
    public Map<String, Boolean> oauthProviders;

    public UserModelDTO() {
    }

    public UserModelDTO(String id, String email, String recoveryEmail, String username, String password, String userRole, String subUserParentUserId, List<String> subUserIds, String planId, Long planStartDate, Long planEndDate, String displayName, String profilePictureUrl, String firstName, String lastName, String phoneNumber, String address, String city, String country, String postalCode, String website, Long createdAt, Long updatedAt, Map<String, Boolean> emailVerifyMethods, List<IngredientsModel> ingredients, List<CustomIngredientsModel> customIngredients, List<RecipeModel> recipes, Boolean active, Boolean privateProfile, Boolean is2FAEnabled, Map<String, Boolean> oauthProviders) {
        this.id = id;
        this.email = email;
        this.recoveryEmail = recoveryEmail;
        this.username = username;
        this.password = password;
        this.userRole = userRole;
        this.subUserParentUserId = subUserParentUserId;
        this.subUserIds = subUserIds;
        this.planId = planId;
        this.planStartDate = planStartDate;
        this.planEndDate = planEndDate;
        this.displayName = displayName;
        this.profilePictureUrl = profilePictureUrl;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.city = city;
        this.country = country;
        this.postalCode = postalCode;
        this.website = website;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.emailVerifyMethods = emailVerifyMethods;
        this.ingredients = ingredients;
        this.customIngredients = customIngredients;
        this.recipes = recipes;
        this.active = active;
        this.privateProfile = privateProfile;
        this.is2FAEnabled = is2FAEnabled;
        this.oauthProviders = oauthProviders;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRecoveryEmail() {
        return recoveryEmail;
    }

    public void setRecoveryEmail(String recoveryEmail) {
        this.recoveryEmail = recoveryEmail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getSubUserParentUserId() {
        return subUserParentUserId;
    }

    public void setSubUserParentUserId(String subUserParentUserId) {
        this.subUserParentUserId = subUserParentUserId;
    }

    public List<String> getSubUserIds() {
        return subUserIds;
    }

    public void setSubUserIds(List<String> subUserIds) {
        this.subUserIds = subUserIds;
    }

    public String getPlanId() {
        return planId;
    }

    public void setPlanId(String planId) {
        this.planId = planId;
    }

    public Long getPlanStartDate() {
        return planStartDate;
    }

    public void setPlanStartDate(Long planStartDate) {
        this.planStartDate = planStartDate;
    }

    public Long getPlanEndDate() {
        return planEndDate;
    }

    public void setPlanEndDate(Long planEndDate) {
        this.planEndDate = planEndDate;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Map<String, Boolean> getEmailVerifyMethods() {
        return emailVerifyMethods;
    }

    public void setEmailVerifyMethods(Map<String, Boolean> emailVerifyMethods) {
        this.emailVerifyMethods = emailVerifyMethods;
    }

    public List<IngredientsModel> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientsModel> ingredients) {
        this.ingredients = ingredients;
    }

    public List<CustomIngredientsModel> getCustomIngredients() {
        return customIngredients;
    }

    public void setCustomIngredients(List<CustomIngredientsModel> customIngredients) {
        this.customIngredients = customIngredients;
    }

    public List<RecipeModel> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<RecipeModel> recipes) {
        this.recipes = recipes;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getPrivateProfile() {
        return privateProfile;
    }

    public void setPrivateProfile(Boolean privateProfile) {
        this.privateProfile = privateProfile;
    }

    public Boolean getIs2FAEnabled() {
        return is2FAEnabled;
    }

    public void setIs2FAEnabled(Boolean is2FAEnabled) {
        this.is2FAEnabled = is2FAEnabled;
    }

    public Map<String, Boolean> getOauthProviders() {
        return oauthProviders;
    }

    public void setOauthProviders(Map<String, Boolean> oauthProviders) {
        this.oauthProviders = oauthProviders;
    }
}

