package com.microsoft.identity.common.components;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.microsoft.identity.common.crypto.AndroidAuthSdkStorageEncryptionManager;
import com.microsoft.identity.common.internal.net.cache.HttpCache;
import com.microsoft.identity.common.internal.p131ui.AndroidAuthorizationStrategyFactory;
import com.microsoft.identity.common.internal.platform.AndroidBroadcaster;
import com.microsoft.identity.common.internal.platform.AndroidDeviceMetadata;
import com.microsoft.identity.common.internal.platform.AndroidPlatformUtil;
import com.microsoft.identity.common.internal.providers.oauth2.AndroidTaskStateGenerator;
import com.microsoft.identity.common.java.interfaces.IPlatformComponents;
import com.microsoft.identity.common.java.interfaces.PlatformComponents;
import com.microsoft.identity.common.java.net.DefaultHttpClientWrapper;
import com.microsoft.identity.common.java.platform.Device;
import com.microsoft.identity.common.logging.Logger;
import java.io.File;
import lombok.NonNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class AndroidPlatformComponentsFactory {
    private static final String TAG = "AndroidPlatformComponentsFactory";
    private static boolean sGlobalStateInitalized = false;

    private static IPlatformComponents create(@NonNull Context context, @Nullable Activity activity, @Nullable Fragment fragment) {
        if (context == null) {
            throw new NullPointerException("context is marked non-null but is null");
        }
        initializeGlobalStates(context);
        PlatformComponents.PlatformComponentsBuilder<?, ?> platformComponentsBuilderBuilder = PlatformComponents.builder();
        fillBuilderWithBasicImplementations(platformComponentsBuilderBuilder, context, activity, fragment);
        return platformComponentsBuilderBuilder.build();
    }

    public static IPlatformComponents createFromActivity(@NonNull Activity activity, @Nullable Fragment fragment) {
        if (activity != null) {
            return create(activity.getApplicationContext(), activity, fragment);
        }
        throw new NullPointerException("activity is marked non-null but is null");
    }

    public static IPlatformComponents createFromContext(@NonNull Context context) {
        if (context != null) {
            return create(context, null, null);
        }
        throw new NullPointerException("context is marked non-null but is null");
    }

    public static void fillBuilderWithBasicImplementations(@NonNull PlatformComponents.PlatformComponentsBuilder platformComponentsBuilder, @NonNull Context context, @Nullable Activity activity, @Nullable Fragment fragment) {
        if (platformComponentsBuilder == null) {
            throw new NullPointerException("builder is marked non-null but is null");
        }
        if (context == null) {
            throw new NullPointerException("context is marked non-null but is null");
        }
        platformComponentsBuilder.clockSkewManager(new AndroidClockSkewManager(context)).broadcaster(new AndroidBroadcaster(context)).popManagerLoader(new AndroidPopManagerSupplier(context)).storageSupplier(new AndroidStorageSupplier(context, new AndroidAuthSdkStorageEncryptionManager(context))).platformUtil(new AndroidPlatformUtil(context, activity)).httpClientWrapper(new DefaultHttpClientWrapper());
        if (activity != null) {
            platformComponentsBuilder.authorizationStrategyFactory(AndroidAuthorizationStrategyFactory.builder().context(activity.getApplicationContext()).activity(activity).fragment(fragment).build()).stateGenerator(new AndroidTaskStateGenerator(activity.getTaskId()));
        }
    }

    public static synchronized void initializeGlobalStates(@NonNull Context context) {
        try {
            if (context == null) {
                throw new NullPointerException("context is marked non-null but is null");
            }
            String str = TAG + ":initializeGlobalStates";
            if (!sGlobalStateInitalized) {
                HttpCache.initialize(context);
                Device.setDeviceMetadata(new AndroidDeviceMetadata());
                Logger.setAndroidLogger();
                File cacheDir = context.getCacheDir();
                if (cacheDir != null) {
                    HttpCache.initialize(cacheDir);
                } else {
                    Logger.warn(str, "Http caching is not enabled because the cache dir is null");
                }
                sGlobalStateInitalized = true;
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
