package net.gelatto.labs.java_sdk.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import net.gelatto.labs.java_sdk.ApiClient;
import net.gelatto.labs.java_sdk.managers.UserManager;

public class UserModule extends AbstractModule {
    private final String basePath;

    public UserModule() {
        this(null);
    }

    public UserModule(String basePath) {
        this.basePath = basePath;
    }

    @Override
    protected void configure() {
        // nothing here; providers supply singletons
    }

    @Provides
    @Singleton
    public ApiClient provideApiClient() {
        ApiClient.Builder b = new ApiClient.Builder();
        if (basePath != null && !basePath.isEmpty()) b.basePath(basePath);
        // add sensible default header
        b.addDefaultHeader("User-Agent", "gelatto-labs-jdk-guice/1.0.0");
        ApiClient client = b.build();
        // initialize default so other code relying on ApiClient.getDefault() gets the same instance
        ApiClient.initDefault(client);
        return client;
    }

    @Provides
    @Singleton
    public UserManager provideUserManager(ApiClient client) {
        return new UserManager(client);
    }
}
