package com.microsoft.identity.client;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import androidx.collection.AbstractC0622a;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.microsoft.identity.client.Logger;
import com.microsoft.identity.client.internal.MsalUtils;
import com.microsoft.identity.client.internal.configuration.LogLevelDeserializer;
import com.microsoft.identity.common.components.AndroidPlatformComponentsFactory;
import com.microsoft.identity.common.internal.authorities.AzureActiveDirectoryAudienceDeserializer;
import com.microsoft.identity.common.java.authorities.Authority;
import com.microsoft.identity.common.java.authorities.AuthorityDeserializer;
import com.microsoft.identity.common.java.authorities.AzureActiveDirectoryAudience;
import com.microsoft.identity.common.java.cache.MsalOAuth2TokenCache;
import com.microsoft.identity.common.java.configuration.LibraryConfiguration;
import com.microsoft.identity.msal.C6452R;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class PublicClientApplicationConfigurationFactory {
    private static final String TAG = "PublicClientApplicationConfigurationFactory";

    private static Gson getGsonForLoadingConfiguration() {
        return new GsonBuilder().registerTypeAdapter(Authority.class, new AuthorityDeserializer()).registerTypeAdapter(AzureActiveDirectoryAudience.class, new AzureActiveDirectoryAudienceDeserializer()).registerTypeAdapter(Logger.LogLevel.class, new LogLevelDeserializer()).create();
    }

    @WorkerThread
    public static PublicClientApplicationConfiguration initializeConfiguration(@NonNull Context context) {
        return initializeConfigurationInternal(context, null);
    }

    @WorkerThread
    private static PublicClientApplicationConfiguration initializeConfigurationInternal(@NonNull Context context, @Nullable PublicClientApplicationConfiguration publicClientApplicationConfiguration) {
        MsalUtils.validateNonNullArgument(context, "context");
        PublicClientApplicationConfiguration publicClientApplicationConfigurationLoadDefaultConfiguration = loadDefaultConfiguration(context);
        if (publicClientApplicationConfiguration != null) {
            publicClientApplicationConfigurationLoadDefaultConfiguration.mergeConfiguration(publicClientApplicationConfiguration);
            publicClientApplicationConfigurationLoadDefaultConfiguration.validateConfiguration();
        }
        LibraryConfiguration.intializeLibraryConfiguration(LibraryConfiguration.builder().authorizationInCurrentTask(publicClientApplicationConfigurationLoadDefaultConfiguration.authorizationInCurrentTask().booleanValue()).build());
        publicClientApplicationConfigurationLoadDefaultConfiguration.setOAuth2TokenCache(MsalOAuth2TokenCache.create(AndroidPlatformComponentsFactory.createFromContext(context)));
        return publicClientApplicationConfigurationLoadDefaultConfiguration;
    }

    @VisibleForTesting
    @WorkerThread
    public static PublicClientApplicationConfiguration loadConfiguration(@NonNull Context context, int i) {
        return loadConfiguration(context.getResources().openRawResource(i), i == C6452R.raw.msal_default_config);
    }

    @WorkerThread
    private static PublicClientApplicationConfiguration loadDefaultConfiguration(@NonNull Context context) {
        com.microsoft.identity.common.logging.Logger.verbose(TAG + ":loadDefaultConfiguration", "Loading default configuration");
        PublicClientApplicationConfiguration publicClientApplicationConfigurationLoadConfiguration = loadConfiguration(context, C6452R.raw.msal_default_config);
        publicClientApplicationConfigurationLoadConfiguration.setAppContext(context);
        return publicClientApplicationConfigurationLoadConfiguration;
    }

    @WorkerThread
    public static PublicClientApplicationConfiguration initializeConfiguration(@NonNull Context context, int i) {
        return initializeConfigurationInternal(context, loadConfiguration(context, i));
    }

    @WorkerThread
    public static PublicClientApplicationConfiguration initializeConfiguration(@NonNull Context context, @NonNull File file) {
        MsalUtils.validateNonNullArgument(file, "configFile");
        return initializeConfigurationInternal(context, loadConfiguration(file));
    }

    @VisibleForTesting
    @WorkerThread
    public static PublicClientApplicationConfiguration loadConfiguration(@NonNull File file) {
        try {
            return loadConfiguration((InputStream) new FileInputStream(file), false);
        } catch (FileNotFoundException unused) {
            throw new IllegalArgumentException("Provided configuration file path=" + file.getPath() + " not found.");
        }
    }

    @WorkerThread
    private static PublicClientApplicationConfiguration loadConfiguration(@NonNull InputStream inputStream, boolean z) {
        String strM1170p = AbstractC0622a.m1170p(TAG, ":loadConfiguration", new StringBuilder());
        try {
            try {
                byte[] bArr = new byte[inputStream.available()];
                inputStream.read(bArr);
                try {
                    return (PublicClientApplicationConfiguration) getGsonForLoadingConfiguration().fromJson(new String(bArr), PublicClientApplicationConfiguration.class);
                } catch (Exception e) {
                    if (e instanceof InterruptedException) {
                        Thread.currentThread().interrupt();
                    }
                    throw new IllegalArgumentException("Error while processing configuration", e);
                }
            } catch (IOException e2) {
                if (z) {
                    throw new IllegalStateException("Unable to open default configuration file.", e2);
                }
                throw new IllegalArgumentException("Unable to open provided configuration file.", e2);
            }
        } finally {
            try {
                inputStream.close();
            } catch (IOException unused) {
                if (z) {
                    com.microsoft.identity.common.logging.Logger.warn(strM1170p, "Unable to close default configuration file. This can cause memory leak.");
                } else {
                    com.microsoft.identity.common.logging.Logger.warn(strM1170p, "Unable to close provided configuration file. This can cause memory leak.");
                }
            }
        }
    }
}
