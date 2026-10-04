package com.samsung.android.mcf.continuity.impl;

import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.samsung.android.mcf.continuity.api.ContinuityNearbyMyDevice;
import com.samsung.android.mcf.continuity.api.ContinuityNetworkPolicy;
import com.samsung.android.mcf.continuity.api.ContinuitySessionFileManager;
import com.samsung.android.mcf.continuity.api.ContinuitySessionManager;
import com.samsung.android.mcf.continuity.api.ContinuitySessionMessageManager;
import com.samsung.android.mcf.continuity.common.DLog;
import com.samsung.android.mcf.continuity.common.ExecutorUtil;
import com.samsung.android.mcf.continuity.common.VersionUtil;
import java.util.Objects;
import p012C1.RunnableC0050f;
import p014C3.RunnableC0054a;
import p066P2.RunnableC0201c;
import p070Q1.RunnableC0218a;
import p122b2.RunnableC4180c;
import p122b2.RunnableC4195r;
import p122b2.RunnableC4199v;
import p122b2.RunnableC4200w;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ContinuitySessionManagerImpl implements ContinuitySessionManager {
    private static final String TAG = "ContinuitySessionManagerImpl";

    @NonNull
    private final ContinuitySession mContinuitySession;

    @NonNull
    private final ContinuitySessionFileManagerImpl mContinuitySessionFileManagerImpl;

    @NonNull
    private final ContinuitySessionMessageManagerImpl mContinuitySessionMessageManagerImpl;

    /* JADX INFO: renamed from: com.samsung.android.mcf.continuity.impl.ContinuitySessionManagerImpl$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C72031 extends ContinuitySessionManager.SessionStatusListener {
        public final /* synthetic */ ContinuitySessionManager.SessionStatusListener val$sessionStatusListener;

        public C72031(ContinuitySessionManager.SessionStatusListener sessionStatusListener) {
            this.val$sessionStatusListener = sessionStatusListener;
        }

        @Override // com.samsung.android.mcf.continuity.api.ContinuitySessionManager.SessionStatusListener
        public void onSessionStatusChanged(int i) {
            ExecutorUtil.executeOnCallback(new RunnableC0050f(this.val$sessionStatusListener, i, 7));
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.mcf.continuity.impl.ContinuitySessionManagerImpl$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C72042 extends ContinuitySessionManager.PeerConnectionRequestListener {
        public final /* synthetic */ ContinuitySessionManager.PeerConnectionRequestListener val$peerConnectionRequestListener;

        public C72042(ContinuitySessionManager.PeerConnectionRequestListener peerConnectionRequestListener) {
            this.val$peerConnectionRequestListener = peerConnectionRequestListener;
        }

        @Override // com.samsung.android.mcf.continuity.api.ContinuitySessionManager.PeerConnectionRequestListener
        public void onPeerConnectionRequested(@NonNull ContinuityNearbyMyDevice continuityNearbyMyDevice, @NonNull ContinuityNetworkPolicy continuityNetworkPolicy) {
            ExecutorUtil.executeOnCallback(new RunnableC0201c(this.val$peerConnectionRequestListener, 16, continuityNearbyMyDevice, continuityNetworkPolicy));
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.mcf.continuity.impl.ContinuitySessionManagerImpl$3 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C72053 extends ContinuitySessionManager.PeerStatusListener {
        public final /* synthetic */ ContinuitySessionManager.PeerStatusListener val$peerStatusListener;

        public C72053(ContinuitySessionManager.PeerStatusListener peerStatusListener) {
            this.val$peerStatusListener = peerStatusListener;
        }

        @Override // com.samsung.android.mcf.continuity.api.ContinuitySessionManager.PeerStatusListener
        public void onPeerStatusChanged(int i, @NonNull ContinuityNearbyMyDevice continuityNearbyMyDevice) {
            ExecutorUtil.executeOnCallback(new RunnableC4200w(this.val$peerStatusListener, i, continuityNearbyMyDevice, 0));
        }
    }

    /* JADX INFO: renamed from: com.samsung.android.mcf.continuity.impl.ContinuitySessionManagerImpl$4 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C72064 extends ContinuitySessionManager.PeerStatusListener {
        public final /* synthetic */ ContinuitySessionManager.PeerStatusListener val$peerStatusListener;

        public C72064(ContinuitySessionManager.PeerStatusListener peerStatusListener) {
            this.val$peerStatusListener = peerStatusListener;
        }

        @Override // com.samsung.android.mcf.continuity.api.ContinuitySessionManager.PeerStatusListener
        public void onPeerStatusChanged(int i, @NonNull ContinuityNearbyMyDevice continuityNearbyMyDevice) {
            ExecutorUtil.executeOnCallback(new RunnableC4200w(this.val$peerStatusListener, i, continuityNearbyMyDevice, 1));
        }
    }

    public ContinuitySessionManagerImpl(@NonNull ContinuitySessionMessageManagerImpl continuitySessionMessageManagerImpl, @NonNull ContinuitySessionFileManagerImpl continuitySessionFileManagerImpl, @NonNull ContinuitySession continuitySession) {
        this.mContinuitySessionMessageManagerImpl = continuitySessionMessageManagerImpl;
        this.mContinuitySessionFileManagerImpl = continuitySessionFileManagerImpl;
        this.mContinuitySession = continuitySession;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$disconnect$4(String str) {
        this.mContinuitySession.forceDisconnect(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$openSession$0(ContinuitySessionManager.SessionStatusListener sessionStatusListener) {
        this.mContinuitySession.open(new C72031(sessionStatusListener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$registerPeerConnectionRequestListener$1(ContinuitySessionManager.PeerConnectionRequestListener peerConnectionRequestListener) {
        this.mContinuitySession.registerPeerConnectionRequestListener(new C72042(peerConnectionRequestListener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$requestConnect$2(String str, ContinuityNetworkPolicy continuityNetworkPolicy, ContinuitySessionManager.PeerStatusListener peerStatusListener) {
        this.mContinuitySession.requestConnect(str, continuityNetworkPolicy, new C72053(peerStatusListener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$responseConnect$3(int i, String str, ContinuityNetworkPolicy continuityNetworkPolicy, ContinuitySessionManager.PeerStatusListener peerStatusListener) {
        this.mContinuitySession.responseConnect(i, str, continuityNetworkPolicy, peerStatusListener == null ? null : new C72064(peerStatusListener));
    }

    @Override // com.samsung.android.mcf.continuity.api.ContinuitySessionManager
    public boolean closeSession() {
        DLog.m5610i(TAG, "closeSession", CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
        ContinuitySession continuitySession = this.mContinuitySession;
        Objects.requireNonNull(continuitySession);
        return ExecutorUtil.executeOnMain(new RunnableC4195r(continuitySession, 3));
    }

    @MainThread
    public void destroy() {
        this.mContinuitySessionMessageManagerImpl.destroy();
        this.mContinuitySessionFileManagerImpl.destroy();
        this.mContinuitySession.destroy();
    }

    @Override // com.samsung.android.mcf.continuity.api.ContinuitySessionManager
    public boolean disconnect(@NonNull String str) {
        DLog.m5610i(TAG, "disconnect", CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
        return ExecutorUtil.executeOnMain(new RunnableC0054a(this, str, 28));
    }

    @Override // com.samsung.android.mcf.continuity.api.ContinuitySessionManager
    @Nullable
    public ContinuitySessionFileManager getContinuitySessionFileManager() {
        if (VersionUtil.isNetworkTypeSupported(12)) {
            return this.mContinuitySessionFileManagerImpl;
        }
        return null;
    }

    @Override // com.samsung.android.mcf.continuity.api.ContinuitySessionManager
    @Nullable
    public ContinuitySessionMessageManager getContinuitySessionMessageManager() {
        return this.mContinuitySessionMessageManagerImpl;
    }

    @Override // com.samsung.android.mcf.continuity.api.ContinuitySessionManager
    public boolean openSession(@NonNull ContinuitySessionManager.SessionStatusListener sessionStatusListener) {
        DLog.m5610i(TAG, "openSession", CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
        return ExecutorUtil.executeOnMain(new RunnableC0054a(this, sessionStatusListener, 29));
    }

    @Override // com.samsung.android.mcf.continuity.api.ContinuitySessionManager
    public boolean registerPeerConnectionRequestListener(@NonNull ContinuitySessionManager.PeerConnectionRequestListener peerConnectionRequestListener) {
        DLog.m5610i(TAG, "registerPeerConnectionRequestListener", CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
        return ExecutorUtil.executeOnMain(new RunnableC4199v(this, peerConnectionRequestListener, 0));
    }

    @Override // com.samsung.android.mcf.continuity.api.ContinuitySessionManager
    public boolean requestConnect(@NonNull String str, @NonNull ContinuityNetworkPolicy continuityNetworkPolicy, @NonNull ContinuitySessionManager.PeerStatusListener peerStatusListener) {
        DLog.m5610i(TAG, "requestConnect", CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
        return ExecutorUtil.executeOnMain(new RunnableC0218a(this, str, continuityNetworkPolicy, peerStatusListener, 4));
    }

    @Override // com.samsung.android.mcf.continuity.api.ContinuitySessionManager
    public boolean responseConnect(int i, @NonNull String str, @NonNull ContinuityNetworkPolicy continuityNetworkPolicy, @Nullable ContinuitySessionManager.PeerStatusListener peerStatusListener) {
        DLog.m5610i(TAG, "responseConnect", CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
        if (i != 0 || peerStatusListener != null) {
            return ExecutorUtil.executeOnMain(new RunnableC4180c(this, i, str, continuityNetworkPolicy, peerStatusListener, 1));
        }
        DLog.m5611w(TAG, "responseConnect", "CONFIRM_ACCEPT, but null peerStatusListener");
        return false;
    }

    @Override // com.samsung.android.mcf.continuity.api.ContinuitySessionManager
    public void unregisterPeerConnectionRequestListener() {
        DLog.m5610i(TAG, "unregisterPeerConnectionRequestListener", CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
        ContinuitySession continuitySession = this.mContinuitySession;
        Objects.requireNonNull(continuitySession);
        ExecutorUtil.executeOnMain(new RunnableC4195r(continuitySession, 2));
    }
}
