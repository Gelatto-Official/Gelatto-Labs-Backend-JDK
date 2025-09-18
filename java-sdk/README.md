# Java SDK (apiKey-only)

This module provides a small Java SDK for Gelatto Labs Backend user-level endpoints (apiKey). It exposes a high-level `UserManager` so callers don't need to build HTTP requests manually.

Provider pattern for ApiClient

- The SDK uses an `ApiClientProvider` to manage a shared `ApiClient` instance instead of embedding a static singleton inside `ApiClient`.
- This gives explicit control to initialize or replace the default client during application startup.

How to use

- Default usage (shared client created on first use):

  UserManager manager = new UserManager();
  UserModelDTO profile = manager.getProfile("YOUR_API_KEY");

Notes

- Only user-level endpoints that accept an API key are included. Admin endpoints that require a JWT Authorization header were removed from this SDK.
- Error handling: methods throw `ApiException` for non-2xx responses or connectivity issues.

If you want, I can add an example integration test or create a small example program that calls the real API (requires a valid apiKey).
