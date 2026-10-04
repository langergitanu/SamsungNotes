package com.samsung.android.mcf.continuity.impl;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.samsung.android.mcf.continuity.api.ContinuityDiscoveryManager;
import com.samsung.android.mcf.continuity.api.ContinuityNearbyMyDevice;
import com.samsung.android.mcf.continuity.api.ContinuitySimpleMessageManager;
import com.samsung.android.mcf.continuity.common.DLog;
import com.samsung.android.mcf.continuity.common.ExecutorUtil;
import java.util.List;
import p004A2.RunnableC0015b;
import p014C3.RunnableC0054a;
import p027F3.RunnableC0101a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ContinuityDiscoveryManagerImpl implements ContinuityDiscoveryManager {
    private static final String TAG = "ContinuityDiscoveryManagerImpl";

    @NonNull
    private final ContinuityCallbackManager mContinuityCallbackManager;

    @NonNull
    private final ContinuityCommandManager mContinuityCommandManager;

    @NonNull
    private final ContinuitySimpleMessageManagerImpl mContinuitySimpleMessageManagerImpl;

    /* JADX INFO: renamed from: com.samsung.android.mcf.continuity.impl.ContinuityDiscoveryManagerImpl$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C71911 extends ContinuityDiscoveryManager.DiscoveryListener {
        public final /* synthetic */ ContinuityDiscoveryManager.DiscoveryListener val$discoveryListener;

        public C71911(ContinuityDiscoveryManager.DiscoveryListener discoveryListener) {
            this.val$discoveryListener = discoveryListener;
        }

        @Override // com.samsung.android.mcf.continuity.api.ContinuityDiscoveryManager.DiscoveryListener
        public void onDiscovered(int i, @NonNull ContinuityNearbyMyDevice continuityNearbyMyDevice) {
            ExecutorUtil.executeOnCallback(new RunnableC0101a(this.val$discoveryListener, i, continuityNearbyMyDevice, 4));
        }
    }

    public ContinuityDiscoveryManagerImpl(@NonNull ContinuityCommandManager continuityCommandManager, @NonNull ContinuityCallbackManager continuityCallbackManager, @NonNull ContinuitySimpleMessageManagerImpl continuitySimpleMessageManagerImpl) {
        this.mContinuityCommandManager = continuityCommandManager;
        this.mContinuityCallbackManager = continuityCallbackManager;
        this.mContinuitySimpleMessageManagerImpl = continuitySimpleMessageManagerImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$startDiscovery$0(ContinuityDiscoveryManager.DiscoveryListener discoveryListener) {
        this.mContinuityCallbackManager.setDiscoveryListener(new C71911(discoveryListener));
        if (this.mContinuityCommandManager.sendStartDiscoveryCommand()) {
            return;
        }
        DLog.m5611w(TAG, "startDiscovery", "fail sendStartDiscoveryCommand");
        this.mContinuityCallbackManager.setDiscoveryListener(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$stopDiscovery$1() {
        this.mContinuityCallbackManager.setDiscoveryListener(null);
        this.mContinuityCommandManager.sendStopDiscoveryCommand();
    }

    @MainThread
    public void destroy() {
        this.mContinuityCallbackManager.setDiscoveryListener(null);
        this.mContinuitySimpleMessageManagerImpl.destroy();
    }

    @Override // com.samsung.android.mcf.continuity.api.ContinuityDiscoveryManager
    @NonNull
    public ContinuitySimpleMessageManager getContinuitySimpleMessageManager() {
        return this.mContinuitySimpleMessageManagerImpl;
    }

    @Override // com.samsung.android.mcf.continuity.api.ContinuityDiscoveryManager
    @NonNull
    public List<ContinuityNearbyMyDevice> getNearbyMyDevices() {
        DLog.m5610i(TAG, "getNearbyMyDevices", CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
        return this.mContinuityCommandManager.getNearbyMyDevices();
    }

    @Override // com.samsung.android.mcf.continuity.api.ContinuityDiscoveryManager
    public boolean startAdvertisement() {
        DLog.m5610i(TAG, "startAdvertisement", CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
        this.mContinuityCommandManager.sendStartAdvertisementCommand();
        return true;
    }

    @Override // com.samsung.android.mcf.continuity.api.ContinuityDiscoveryManager
    public boolean startDiscovery(@NonNull ContinuityDiscoveryManager.DiscoveryListener discoveryListener) {
        DLog.m5610i(TAG, "startDiscovery", CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
        return ExecutorUtil.executeOnMain(new RunnableC0054a(this, discoveryListener, 23));
    }

    @Override // com.samsung.android.mcf.continuity.api.ContinuityDiscoveryManager
    public boolean stopAdvertisement() {
        DLog.m5610i(TAG, "stopAdvertisement", CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
        this.mContinuityCommandManager.sendStopAdvertisementCommand();
        return true;
    }

    @Override // com.samsung.android.mcf.continuity.api.ContinuityDiscoveryManager
    public boolean stopDiscovery() {
        DLog.m5610i(TAG, "stopDiscovery", CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
        return ExecutorUtil.executeOnMain(new RunnableC0015b(this, 26));
    }

    @Override // com.samsung.android.mcf.continuity.api.ContinuityDiscoveryManager
    public boolean updateAdvertisement(@Nullable byte[] bArr) {
        DLog.m5610i(TAG, "updateAdvertisement", CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
        return this.mContinuityCommandManager.sendUpdateAdvertisementCommand(bArr);
    }
}
