package com.microsoft.identity.common.internal.cache;

import com.microsoft.identity.common.java.interfaces.INameValueStorage;
import com.microsoft.identity.common.java.interfaces.IStorageSupplier;
import com.sec.android.diagmonagent.log.provider.utils.BundleContract;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u00012\u00020\u0002:\u0001\tB\u001d\b\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, m13886d2 = {"Lcom/microsoft/identity/common/internal/cache/ClientActiveBrokerCache;", "Lcom/microsoft/identity/common/internal/cache/BaseActiveBrokerCache;", "Lcom/microsoft/identity/common/internal/cache/IClientActiveBrokerCache;", BundleContract.STORAGE, "Lcom/microsoft/identity/common/java/interfaces/INameValueStorage;", "", "lock", "Lkotlinx/coroutines/sync/Mutex;", "(Lcom/microsoft/identity/common/java/interfaces/INameValueStorage;Lkotlinx/coroutines/sync/Mutex;)V", "Companion", "common_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
public final class ClientActiveBrokerCache extends BaseActiveBrokerCache implements IClientActiveBrokerCache {

    @NotNull
    private static final String BROKER_METADATA_CACHE_STORE_ON_BROKER_SDK_SIDE_STORAGE_NAME = "BROKER_METADATA_CACHE_STORE_ON_BROKER_SDK_SIDE";

    @NotNull
    private static final String BROKER_METADATA_CACHE_STORE_ON_CLIENT_SDK_SIDE_STORAGE_NAME = "BROKER_METADATA_CACHE_STORE_ON_CLIENT_SDK_SIDE";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Mutex sBrokerSdkSideLock = MutexKt.Mutex$default(false, 1, null);

    @NotNull
    private static final Mutex sClientSdkSideLock = MutexKt.Mutex$default(false, 1, null);

    @NotNull
    private final Mutex lock;

    @NotNull
    private final INameValueStorage<String> storage;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m13886d2 = {"Lcom/microsoft/identity/common/internal/cache/ClientActiveBrokerCache$Companion;", "", "()V", "BROKER_METADATA_CACHE_STORE_ON_BROKER_SDK_SIDE_STORAGE_NAME", "", "BROKER_METADATA_CACHE_STORE_ON_CLIENT_SDK_SIDE_STORAGE_NAME", "sBrokerSdkSideLock", "Lkotlinx/coroutines/sync/Mutex;", "sClientSdkSideLock", "getBrokerSdkCache", "Lcom/microsoft/identity/common/internal/cache/IClientActiveBrokerCache;", "storageSupplier", "Lcom/microsoft/identity/common/java/interfaces/IStorageSupplier;", "getClientSdkCache", "common_distRelease"}, m13887k = 1, m13888mv = {1, 7, 1}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final IClientActiveBrokerCache getBrokerSdkCache(@NotNull IStorageSupplier storageSupplier) {
            Intrinsics.checkNotNullParameter(storageSupplier, "storageSupplier");
            return new ClientActiveBrokerCache(storageSupplier.getEncryptedNameValueStore(ClientActiveBrokerCache.BROKER_METADATA_CACHE_STORE_ON_BROKER_SDK_SIDE_STORAGE_NAME, String.class), ClientActiveBrokerCache.sBrokerSdkSideLock);
        }

        @JvmStatic
        @NotNull
        public final IClientActiveBrokerCache getClientSdkCache(@NotNull IStorageSupplier storageSupplier) {
            Intrinsics.checkNotNullParameter(storageSupplier, "storageSupplier");
            return new ClientActiveBrokerCache(storageSupplier.getEncryptedNameValueStore(ClientActiveBrokerCache.BROKER_METADATA_CACHE_STORE_ON_CLIENT_SDK_SIDE_STORAGE_NAME, String.class), ClientActiveBrokerCache.sClientSdkSideLock);
        }

        private Companion() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClientActiveBrokerCache(@NotNull INameValueStorage<String> storage, @NotNull Mutex lock) {
        super(storage, lock);
        Intrinsics.checkNotNullParameter(storage, "storage");
        Intrinsics.checkNotNullParameter(lock, "lock");
        this.storage = storage;
        this.lock = lock;
    }

    @JvmStatic
    @NotNull
    public static final IClientActiveBrokerCache getBrokerSdkCache(@NotNull IStorageSupplier iStorageSupplier) {
        return INSTANCE.getBrokerSdkCache(iStorageSupplier);
    }

    @JvmStatic
    @NotNull
    public static final IClientActiveBrokerCache getClientSdkCache(@NotNull IStorageSupplier iStorageSupplier) {
        return INSTANCE.getClientSdkCache(iStorageSupplier);
    }
}
