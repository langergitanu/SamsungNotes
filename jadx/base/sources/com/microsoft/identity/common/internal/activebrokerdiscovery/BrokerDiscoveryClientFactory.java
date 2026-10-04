package com.microsoft.identity.common.internal.activebrokerdiscovery;

import android.content.Context;
import com.microsoft.identity.common.internal.cache.IClientActiveBrokerCache;
import com.microsoft.identity.common.java.interfaces.IPlatformComponents;
import com.microsoft.identity.common.logging.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m13886d2 = {"Lcom/microsoft/identity/common/internal/activebrokerdiscovery/BrokerDiscoveryClientFactory;", "", "()V", "Companion", "common_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class BrokerDiscoveryClientFactory {
    private static volatile boolean IS_NEW_DISCOVERY_ENABLED;

    @Nullable
    private static volatile IBrokerDiscoveryClient brokerSdkInstance;

    @Nullable
    private static volatile IBrokerDiscoveryClient clientSdkInstance;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static final String TAG = Reflection.getOrCreateKotlinClass(BrokerDiscoveryClientFactory.class).getSimpleName();

    @NotNull
    private static final Mutex lock = MutexKt.Mutex$default(false, 1, null);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0003J\u0018\u0010\u0013\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\b\u0010\u0015\u001a\u00020\u0004H\u0007J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m13886d2 = {"Lcom/microsoft/identity/common/internal/activebrokerdiscovery/BrokerDiscoveryClientFactory$Companion;", "", "()V", "IS_NEW_DISCOVERY_ENABLED", "", SearchConstants.TargetContents.TAG, "", "brokerSdkInstance", "Lcom/microsoft/identity/common/internal/activebrokerdiscovery/IBrokerDiscoveryClient;", "clientSdkInstance", "lock", "Lkotlinx/coroutines/sync/Mutex;", "getInstance", "context", "Landroid/content/Context;", "platformComponents", "Lcom/microsoft/identity/common/java/interfaces/IPlatformComponents;", "cache", "Lcom/microsoft/identity/common/internal/cache/IClientActiveBrokerCache;", "getInstanceForBrokerSdk", "getInstanceForClientSdk", "isNewBrokerDiscoveryEnabled", "setNewBrokerDiscoveryEnabled", "", "isEnabled", "common_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final IBrokerDiscoveryClient getInstance(Context context, IPlatformComponents platformComponents, IClientActiveBrokerCache cache) {
            String str = BrokerDiscoveryClientFactory.TAG + ":getInstance";
            if (isNewBrokerDiscoveryEnabled()) {
                Logger.info(str, "Broker Discovery is enabled. Use the new logic on the SDK side");
                return new BrokerDiscoveryClient(context, platformComponents, cache);
            }
            Logger.info(str, "Broker Discovery is disabled. Use AccountManager on the SDK side.");
            return new LegacyBrokerDiscoveryClient(context);
        }

        @JvmStatic
        @NotNull
        public final IBrokerDiscoveryClient getInstanceForBrokerSdk(@NotNull Context context, @NotNull IPlatformComponents platformComponents) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(platformComponents, "platformComponents");
            if (BrokerDiscoveryClientFactory.brokerSdkInstance == null) {
                BuildersKt__BuildersKt.runBlocking$default(null, new BrokerDiscoveryClientFactory$Companion$getInstanceForBrokerSdk$1(context, platformComponents, null), 1, null);
            }
            IBrokerDiscoveryClient iBrokerDiscoveryClient = BrokerDiscoveryClientFactory.brokerSdkInstance;
            Intrinsics.checkNotNull(iBrokerDiscoveryClient);
            return iBrokerDiscoveryClient;
        }

        @JvmStatic
        @NotNull
        public final IBrokerDiscoveryClient getInstanceForClientSdk(@NotNull Context context, @NotNull IPlatformComponents platformComponents) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(platformComponents, "platformComponents");
            if (BrokerDiscoveryClientFactory.clientSdkInstance == null) {
                BuildersKt__BuildersKt.runBlocking$default(null, new BrokerDiscoveryClientFactory$Companion$getInstanceForClientSdk$1(context, platformComponents, null), 1, null);
            }
            IBrokerDiscoveryClient iBrokerDiscoveryClient = BrokerDiscoveryClientFactory.clientSdkInstance;
            Intrinsics.checkNotNull(iBrokerDiscoveryClient);
            return iBrokerDiscoveryClient;
        }

        @JvmStatic
        public final boolean isNewBrokerDiscoveryEnabled() {
            return BrokerDiscoveryClientFactory.IS_NEW_DISCOVERY_ENABLED;
        }

        @JvmStatic
        public final void setNewBrokerDiscoveryEnabled(boolean isEnabled) {
            if (isEnabled != BrokerDiscoveryClientFactory.IS_NEW_DISCOVERY_ENABLED) {
                BrokerDiscoveryClientFactory.clientSdkInstance = null;
                BrokerDiscoveryClientFactory.brokerSdkInstance = null;
                BrokerDiscoveryClientFactory.IS_NEW_DISCOVERY_ENABLED = isEnabled;
            }
        }

        private Companion() {
        }
    }

    @JvmStatic
    private static final IBrokerDiscoveryClient getInstance(Context context, IPlatformComponents iPlatformComponents, IClientActiveBrokerCache iClientActiveBrokerCache) {
        return INSTANCE.getInstance(context, iPlatformComponents, iClientActiveBrokerCache);
    }

    @JvmStatic
    @NotNull
    public static final IBrokerDiscoveryClient getInstanceForBrokerSdk(@NotNull Context context, @NotNull IPlatformComponents iPlatformComponents) {
        return INSTANCE.getInstanceForBrokerSdk(context, iPlatformComponents);
    }

    @JvmStatic
    @NotNull
    public static final IBrokerDiscoveryClient getInstanceForClientSdk(@NotNull Context context, @NotNull IPlatformComponents iPlatformComponents) {
        return INSTANCE.getInstanceForClientSdk(context, iPlatformComponents);
    }

    @JvmStatic
    public static final boolean isNewBrokerDiscoveryEnabled() {
        return INSTANCE.isNewBrokerDiscoveryEnabled();
    }

    @JvmStatic
    public static final void setNewBrokerDiscoveryEnabled(boolean z) {
        INSTANCE.setNewBrokerDiscoveryEnabled(z);
    }
}
