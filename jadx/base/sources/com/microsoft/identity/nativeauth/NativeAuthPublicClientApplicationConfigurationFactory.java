package com.microsoft.identity.nativeauth;

import android.content.Context;
import androidx.annotation.WorkerThread;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.microsoft.identity.client.Logger;
import com.microsoft.identity.client.PublicClientApplicationConfiguration;
import com.microsoft.identity.client.PublicClientApplicationConfigurationFactory;
import com.microsoft.identity.client.exception.MsalClientException;
import com.microsoft.identity.client.internal.configuration.LogLevelDeserializer;
import com.microsoft.identity.common.components.AndroidPlatformComponentsFactory;
import com.microsoft.identity.common.internal.authorities.AzureActiveDirectoryAudienceDeserializer;
import com.microsoft.identity.common.java.authorities.Authority;
import com.microsoft.identity.common.java.authorities.AuthorityDeserializer;
import com.microsoft.identity.common.java.authorities.AzureActiveDirectoryAudience;
import com.microsoft.identity.common.java.cache.MsalOAuth2TokenCache;
import com.microsoft.identity.common.java.configuration.LibraryConfiguration;
import com.microsoft.identity.common.java.interfaces.IPlatformComponents;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.nativeauth.BuildValues;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAccount;
import com.microsoft.identity.common.java.providers.microsoft.MicrosoftRefreshToken;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsAuthorizationRequest;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsOAuth2Strategy;
import com.microsoft.identity.common.java.providers.microsoft.microsoftsts.MicrosoftStsTokenResponse;
import com.microsoft.identity.msal.C6452R;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p196io.CloseableKt;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m13886d2 = {"Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplicationConfigurationFactory;", "Lcom/microsoft/identity/client/PublicClientApplicationConfigurationFactory;", "()V", "Companion", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class NativeAuthPublicClientApplicationConfigurationFactory extends PublicClientApplicationConfigurationFactory {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "NativeAuthPublicClientApplicationConfigurationFactory";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0006\u001a \u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0018\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\u001a\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0003J\u0018\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bH\u0003J\u0010\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0003J\u0018\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0003J\u0010\u0010\"\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0003R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006#"}, m13886d2 = {"Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplicationConfigurationFactory$Companion;", "", "()V", SearchConstants.TargetContents.TAG, "", "kotlin.jvm.PlatformType", "createCache", "Lcom/microsoft/identity/common/java/cache/MsalOAuth2TokenCache;", "Lcom/microsoft/identity/common/java/providers/microsoft/microsoftsts/MicrosoftStsOAuth2Strategy;", "Lcom/microsoft/identity/common/java/providers/microsoft/microsoftsts/MicrosoftStsAuthorizationRequest;", "Lcom/microsoft/identity/common/java/providers/microsoft/microsoftsts/MicrosoftStsTokenResponse;", "Lcom/microsoft/identity/common/java/providers/microsoft/MicrosoftAccount;", "Lcom/microsoft/identity/common/java/providers/microsoft/MicrosoftRefreshToken;", "components", "Lcom/microsoft/identity/common/java/interfaces/IPlatformComponents;", "getGsonForLoadingConfiguration", "Lcom/google/gson/Gson;", "initializeBuildValues", "", "developerConfig", "Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplicationConfiguration;", "initializeNativeAuthConfiguration", "context", "Landroid/content/Context;", "configFile", "Ljava/io/File;", "configResourceId", "", "initializeNativeAuthConfigurationInternal", "loadConfiguration", "configStream", "Ljava/io/InputStream;", "isDefaultConfiguration", "", "loadDefaultNativeAuthConfiguration", "msal_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final MsalOAuth2TokenCache<MicrosoftStsOAuth2Strategy, MicrosoftStsAuthorizationRequest, MicrosoftStsTokenResponse, MicrosoftAccount, MicrosoftRefreshToken> createCache(IPlatformComponents components) {
            Logger.verbose(NativeAuthPublicClientApplicationConfigurationFactory.TAG + ":createCache", "Creating MsalOAuth2TokenCache");
            MsalOAuth2TokenCache<MicrosoftStsOAuth2Strategy, MicrosoftStsAuthorizationRequest, MicrosoftStsTokenResponse, MicrosoftAccount, MicrosoftRefreshToken> msalOAuth2TokenCacheCreate = MsalOAuth2TokenCache.create(components);
            Intrinsics.checkNotNullExpressionValue(msalOAuth2TokenCacheCreate, "create(components)");
            return msalOAuth2TokenCacheCreate;
        }

        private final Gson getGsonForLoadingConfiguration() {
            Gson gsonCreate = new GsonBuilder().registerTypeAdapter(Authority.class, new AuthorityDeserializer()).registerTypeAdapter(AzureActiveDirectoryAudience.class, new AzureActiveDirectoryAudienceDeserializer()).registerTypeAdapter(Logger.LogLevel.class, new LogLevelDeserializer()).create();
            Intrinsics.checkNotNullExpressionValue(gsonCreate, "GsonBuilder()\n          …                .create()");
            return gsonCreate;
        }

        private final void initializeBuildValues(NativeAuthPublicClientApplicationConfiguration developerConfig) {
            String dc = developerConfig != null ? developerConfig.getDc() : null;
            Boolean useMockAuthority = developerConfig != null ? developerConfig.getUseMockAuthority() : null;
            if (dc != null) {
                BuildValues.setDC(dc);
            }
            if (useMockAuthority != null) {
                BuildValues.setUseMockApiForNativeAuth(useMockAuthority);
            }
        }

        @WorkerThread
        private final NativeAuthPublicClientApplicationConfiguration initializeNativeAuthConfigurationInternal(Context context, NativeAuthPublicClientApplicationConfiguration developerConfig) throws MsalClientException {
            PublicClientApplicationConfiguration publicClientApplicationConfigurationLoadConfiguration = PublicClientApplicationConfigurationFactory.loadConfiguration(context, C6452R.raw.msal_default_config);
            Intrinsics.checkNotNullExpressionValue(publicClientApplicationConfigurationLoadConfiguration, "loadConfiguration(contex….raw.msal_default_config)");
            NativeAuthPublicClientApplicationConfiguration nativeAuthPublicClientApplicationConfigurationLoadDefaultNativeAuthConfiguration = loadDefaultNativeAuthConfiguration(context);
            NativeAuthPublicClientApplicationConfiguration nativeAuthPublicClientApplicationConfiguration = new NativeAuthPublicClientApplicationConfiguration();
            nativeAuthPublicClientApplicationConfiguration.setAppContext(context);
            nativeAuthPublicClientApplicationConfiguration.mergeConfiguration(publicClientApplicationConfigurationLoadConfiguration);
            nativeAuthPublicClientApplicationConfiguration.mergeConfiguration(nativeAuthPublicClientApplicationConfigurationLoadDefaultNativeAuthConfiguration);
            nativeAuthPublicClientApplicationConfiguration.getAuthorities().clear();
            if (developerConfig != null) {
                nativeAuthPublicClientApplicationConfiguration.mergeConfiguration(developerConfig);
                nativeAuthPublicClientApplicationConfiguration.validateConfiguration();
            }
            LibraryConfiguration.LibraryConfigurationBuilder libraryConfigurationBuilderBuilder = LibraryConfiguration.builder();
            Boolean boolAuthorizationInCurrentTask = nativeAuthPublicClientApplicationConfiguration.authorizationInCurrentTask();
            Intrinsics.checkNotNullExpressionValue(boolAuthorizationInCurrentTask, "config.authorizationInCurrentTask()");
            LibraryConfiguration.intializeLibraryConfiguration(libraryConfigurationBuilderBuilder.authorizationInCurrentTask(boolAuthorizationInCurrentTask.booleanValue()).build());
            IPlatformComponents iPlatformComponentsCreateFromContext = AndroidPlatformComponentsFactory.createFromContext(context);
            Intrinsics.checkNotNullExpressionValue(iPlatformComponentsCreateFromContext, "createFromContext(context)");
            nativeAuthPublicClientApplicationConfiguration.setOAuth2TokenCache(createCache(iPlatformComponentsCreateFromContext));
            initializeBuildValues(developerConfig);
            return nativeAuthPublicClientApplicationConfiguration;
        }

        @WorkerThread
        private final NativeAuthPublicClientApplicationConfiguration loadConfiguration(Context context, int configResourceId) {
            InputStream inputStreamOpenRawResource = context.getResources().openRawResource(configResourceId);
            Intrinsics.checkNotNullExpressionValue(inputStreamOpenRawResource, "context.resources.openRa…esource(configResourceId)");
            return loadConfiguration(inputStreamOpenRawResource, configResourceId == C6452R.raw.msal_native_auth_default_config);
        }

        @WorkerThread
        private final NativeAuthPublicClientApplicationConfiguration loadDefaultNativeAuthConfiguration(Context context) {
            com.microsoft.identity.common.java.logging.Logger.verbose(NativeAuthPublicClientApplicationConfigurationFactory.TAG + ":loadDefaultNativeAuthConfiguration", "Loading default native auth configuration");
            return loadConfiguration(context, C6452R.raw.msal_native_auth_default_config);
        }

        @WorkerThread
        @NotNull
        public final NativeAuthPublicClientApplicationConfiguration initializeNativeAuthConfiguration(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return initializeNativeAuthConfigurationInternal(context, null);
        }

        private Companion() {
        }

        @WorkerThread
        @NotNull
        public final NativeAuthPublicClientApplicationConfiguration initializeNativeAuthConfiguration(@NotNull Context context, int configResourceId) {
            Intrinsics.checkNotNullParameter(context, "context");
            return initializeNativeAuthConfigurationInternal(context, loadConfiguration(context, configResourceId));
        }

        @WorkerThread
        @NotNull
        public final NativeAuthPublicClientApplicationConfiguration initializeNativeAuthConfiguration(@NotNull Context context, @NotNull File configFile) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(configFile, "configFile");
            return initializeNativeAuthConfigurationInternal(context, loadConfiguration(configFile));
        }

        @WorkerThread
        private final NativeAuthPublicClientApplicationConfiguration loadConfiguration(File configFile) {
            try {
                return loadConfiguration((InputStream) new FileInputStream(configFile), false);
            } catch (FileNotFoundException unused) {
                throw new IllegalArgumentException("Provided configuration file path=" + configFile.getPath() + " not found.");
            }
        }

        @WorkerThread
        private final NativeAuthPublicClientApplicationConfiguration loadConfiguration(InputStream configStream, boolean isDefaultConfiguration) {
            String unused = NativeAuthPublicClientApplicationConfigurationFactory.TAG;
            try {
                try {
                    byte[] bArr = new byte[configStream.available()];
                    configStream.read(bArr);
                    CloseableKt.closeFinally(configStream, null);
                    try {
                        Object objFromJson = getGsonForLoadingConfiguration().fromJson(new String(bArr, Charsets.UTF_8), (Class<Object>) NativeAuthPublicClientApplicationConfiguration.class);
                        Intrinsics.checkNotNullExpressionValue(objFromJson, "{\n                gson.f…class.java)\n            }");
                        return (NativeAuthPublicClientApplicationConfiguration) objFromJson;
                    } catch (Exception e) {
                        if (e instanceof InterruptedException) {
                            Thread.currentThread().interrupt();
                        }
                        throw new IllegalArgumentException("Error while processing configuration", e);
                    }
                } finally {
                }
            } catch (IOException e2) {
                if (isDefaultConfiguration) {
                    throw new IllegalStateException("Unable to open default native auth configuration file.", e2);
                }
                throw new IllegalArgumentException("Unable to open provided native auth configuration file.", e2);
            }
        }
    }
}
