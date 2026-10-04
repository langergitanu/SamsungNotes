package com.samsung.android.mcf.continuity.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.samsung.android.mcf.continuity.api.ContinuityAdapter;
import com.samsung.android.mcf.continuity.api.ContinuityDiscoveryManager;
import com.samsung.android.mcf.continuity.api.ContinuitySessionManager;
import com.samsung.android.mcf.continuity.common.DLog;
import com.samsung.android.mcf.continuity.common.ExecutorUtil;
import com.samsung.android.mcf.continuity.common.FeatureUtil;
import com.samsung.android.mcf.continuity.common.SettingUtil;
import com.samsung.android.mcf.continuity.common.VersionUtil;
import com.samsung.android.mcf.continuity.interfaces.ContinuityInterfaceConst;
import com.samsung.android.mcf.continuity.interfaces.IContinuitySdkCommand;
import java.util.Objects;
import p012C1.RunnableC0050f;
import p014C3.RunnableC0054a;
import p066P2.RunnableC0201c;
import p070Q1.RunnableC0218a;
import p122b2.RunnableC4178a;
import p122b2.RunnableC4179b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ContinuityAdapterImpl implements ContinuityAdapter {
    private static final String MCFDS_PACKAGE_NAME = "com.samsung.android.mcfds";
    private static final String MCFDS_SERVICE_NAME = "com.samsung.android.mcfds.McfDeviceSyncService";
    private static final int SERVICE_STATE_AVAILABLE = 5;

    @VisibleForTesting
    public static final int SERVICE_STATE_CONNECTED = 3;

    @VisibleForTesting
    public static final int SERVICE_STATE_DISCONNECTED = 1;

    @VisibleForTesting
    public static final int SERVICE_STATE_NONE = 0;

    @VisibleForTesting
    public static final int SERVICE_STATE_REQUESTED = 2;
    private static final int SERVICE_STATE_UNAVAILABLE = 4;
    private static final String TAG = "ContinuityAdapterImpl";

    @NonNull
    private final ContinuityCallbackManager mContinuityCallbackManager;

    @NonNull
    private final ContinuityCommandManager mContinuityCommandManager;

    @NonNull
    private final ContinuityDiscoveryManagerImpl mContinuityDiscoveryManagerImpl;

    @NonNull
    private final ContinuitySessionManagerImpl mContinuitySessionManagerImpl;

    @Nullable
    private ServiceConnection mServiceConnection;
    private volatile int mServiceState = 0;
    private int mAppId = 0;

    /* JADX INFO: renamed from: com.samsung.android.mcf.continuity.impl.ContinuityAdapterImpl$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ServiceConnectionC71851 implements ServiceConnection {
        public final /* synthetic */ Context val$context;
        public final /* synthetic */ ContinuityAdapter.ServiceStateListener val$serviceStateListener;

        public ServiceConnectionC71851(Context context, ContinuityAdapter.ServiceStateListener serviceStateListener) {
            this.val$context = context;
            this.val$serviceStateListener = serviceStateListener;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onServiceConnected$0(Context context, IBinder iBinder, ContinuityAdapter.ServiceStateListener serviceStateListener) {
            if (ContinuityAdapterImpl.this.mServiceState == 1) {
                DLog.m5611w(ContinuityAdapterImpl.TAG, "onServiceConnected", "rebound case -> unbindService");
                ContinuityAdapterImpl.this.unbindServiceImpl(context);
                return;
            }
            if (ContinuityAdapterImpl.this.mContinuityCommandManager.initialize(ContinuityAdapterImpl.this.mAppId, IContinuitySdkCommand.Stub.asInterface(iBinder))) {
                DLog.m5610i(ContinuityAdapterImpl.TAG, "onServiceConnected", "SERVICE_STATE_CONNECTED");
                ContinuityAdapterImpl.this.mServiceState = 3;
                Objects.requireNonNull(serviceStateListener);
                ExecutorUtil.executeOnCallback(new RunnableC4178a(serviceStateListener, 1));
                return;
            }
            DLog.m5611w(ContinuityAdapterImpl.TAG, "onServiceConnected", "fail to initialize");
            ContinuityAdapterImpl.this.unbindServiceImpl(context);
            Objects.requireNonNull(serviceStateListener);
            ExecutorUtil.executeOnCallback(new RunnableC4178a(serviceStateListener, 0));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$onServiceDisconnected$1(ContinuityAdapter.ServiceStateListener serviceStateListener) {
            DLog.m5611w(ContinuityAdapterImpl.TAG, "onServiceDisconnected", CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
            ContinuityAdapterImpl.this.mServiceState = 1;
            ContinuityAdapterImpl.this.destroy();
            Objects.requireNonNull(serviceStateListener);
            ExecutorUtil.executeOnCallback(new RunnableC4178a(serviceStateListener, 0));
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(@Nullable ComponentName componentName, @Nullable IBinder iBinder) {
            ExecutorUtil.executeOnMain(new RunnableC0218a(2, this, this.val$context, iBinder, this.val$serviceStateListener));
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(@Nullable ComponentName componentName) {
            ExecutorUtil.executeOnMain(new RunnableC0054a(this, this.val$serviceStateListener, 21));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class SingletonHolder {
        private static final ContinuityAdapterImpl INSTANCE = new ContinuityAdapterImpl();

        private SingletonHolder() {
        }
    }

    @VisibleForTesting
    public ContinuityAdapterImpl() {
        ContinuityCallbackManager continuityCallbackManagerCreateContinuityCallbackManager = Injection.createContinuityCallbackManager();
        this.mContinuityCallbackManager = continuityCallbackManagerCreateContinuityCallbackManager;
        ContinuityCommandManager continuityCommandManagerCreateContinuityCommandManager = Injection.createContinuityCommandManager(continuityCallbackManagerCreateContinuityCallbackManager.createIContinuitySdkCallback());
        this.mContinuityCommandManager = continuityCommandManagerCreateContinuityCommandManager;
        this.mContinuityDiscoveryManagerImpl = Injection.createContinuityDiscoveryManagerImpl(continuityCommandManagerCreateContinuityCommandManager, continuityCallbackManagerCreateContinuityCallbackManager, Injection.createContinuitySimpleMessageManagerImpl(continuityCommandManagerCreateContinuityCommandManager, continuityCallbackManagerCreateContinuityCallbackManager));
        ContinuitySession continuitySessionCreateContinuitySession = Injection.createContinuitySession(continuityCommandManagerCreateContinuityCommandManager, continuityCallbackManagerCreateContinuityCallbackManager);
        this.mContinuitySessionManagerImpl = Injection.createContinuitySessionManagerImpl(Injection.createContinuitySessionMessageManagerImpl(continuitySessionCreateContinuitySession), Injection.createContinuitySessionFileManagerImpl(continuitySessionCreateContinuitySession), continuitySessionCreateContinuitySession);
    }

    @NonNull
    private ServiceConnection createServiceConnection(@NonNull Context context, @NonNull ContinuityAdapter.ServiceStateListener serviceStateListener) {
        return new ServiceConnectionC71851(context, serviceStateListener);
    }

    @NonNull
    private static Intent createStartIntent(@NonNull Context context) {
        Intent intent = new Intent(ContinuityInterfaceConst.ACTION_START_FROM_CONTINUITY_SDK);
        intent.setComponent(new ComponentName("com.samsung.android.mcfds", MCFDS_SERVICE_NAME));
        intent.putExtra("Caller", context.getPackageName());
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void destroy() {
        this.mContinuityCommandManager.destroy();
        this.mContinuityCallbackManager.destroy();
        this.mContinuityDiscoveryManagerImpl.destroy();
        this.mContinuitySessionManagerImpl.destroy();
    }

    @NonNull
    public static ContinuityAdapterImpl getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$bindService$2(ContinuityAdapter.ServiceStateListener serviceStateListener, Context context) {
        if (this.mAppId == 0) {
            DLog.m5611w(TAG, "bindService", "Please initialize first");
            Objects.requireNonNull(serviceStateListener);
            ExecutorUtil.executeOnCallback(new RunnableC4178a(serviceStateListener, 0));
            return;
        }
        if (this.mServiceState != 0) {
            DLog.m5611w(TAG, "bindService", "invalid service state " + this.mServiceState);
            Objects.requireNonNull(serviceStateListener);
            ExecutorUtil.executeOnCallback(new RunnableC4178a(serviceStateListener, 0));
            return;
        }
        Intent intentCreateStartIntent = createStartIntent(context);
        ServiceConnection serviceConnectionCreateServiceConnection = createServiceConnection(context, serviceStateListener);
        this.mServiceConnection = serviceConnectionCreateServiceConnection;
        if (context.bindService(intentCreateStartIntent, serviceConnectionCreateServiceConnection, 0)) {
            DLog.m5610i(TAG, "bindService", "start bindService");
            this.mServiceState = 2;
            return;
        }
        DLog.m5611w(TAG, "bindService", "fail bindService");
        context.unbindService(this.mServiceConnection);
        this.mServiceConnection = null;
        this.mServiceState = 0;
        Objects.requireNonNull(serviceStateListener);
        ExecutorUtil.executeOnCallback(new RunnableC4178a(serviceStateListener, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$initialize$0(int i) {
        DLog.m5610i(TAG, "initialize", "INIT_SUCCESS");
        ExecutorUtil.start();
        this.mAppId = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$release$1(Context context) {
        DLog.m5610i(TAG, "release", CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
        unbindServiceImpl(context);
        this.mAppId = 0;
        ExecutorUtil.shutdown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$unbindService$3(Context context) {
        DLog.m5610i(TAG, "unbindService", CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
        unbindServiceImpl(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @MainThread
    public void unbindServiceImpl(@NonNull Context context) {
        if (this.mAppId == 0) {
            DLog.m5611w(TAG, "unbindServiceImpl", "Please initialize first");
            return;
        }
        if (this.mServiceState == 0) {
            DLog.m5611w(TAG, "unbindServiceImpl", "invalid service state " + this.mServiceState);
            return;
        }
        if (this.mServiceState == 3) {
            DLog.m5610i(TAG, "unbindServiceImpl", "connected, unregister callback");
            this.mContinuityCommandManager.sendUnregisterCallbackCommand();
        }
        ServiceConnection serviceConnection = this.mServiceConnection;
        if (serviceConnection != null) {
            context.unbindService(serviceConnection);
            this.mServiceConnection = null;
        }
        this.mServiceState = 0;
        destroy();
    }

    @Override // com.samsung.android.mcf.continuity.api.ContinuityAdapter
    public boolean bindService(@NonNull Context context, @NonNull ContinuityAdapter.ServiceStateListener serviceStateListener) {
        return ExecutorUtil.executeOnMain(new RunnableC0201c(this, 12, serviceStateListener, context));
    }

    @VisibleForTesting(otherwise = 5)
    public int getAppId() {
        return this.mAppId;
    }

    @Override // com.samsung.android.mcf.continuity.api.ContinuityAdapter
    @Nullable
    public ContinuityDiscoveryManager getContinuityDiscoveryManager() {
        if (this.mServiceState == 3) {
            return this.mContinuityDiscoveryManagerImpl;
        }
        DLog.m5611w(TAG, "getContinuityDiscoveryManager", "invalid state " + this.mServiceState);
        return null;
    }

    @Override // com.samsung.android.mcf.continuity.api.ContinuityAdapter
    @Nullable
    public ContinuitySessionManager getContinuitySessionManager() {
        if (this.mServiceState == 3) {
            return this.mContinuitySessionManagerImpl;
        }
        DLog.m5611w(TAG, "getContinuitySessionManager", "invalid state " + this.mServiceState);
        return null;
    }

    @VisibleForTesting(otherwise = 5)
    public ServiceConnection getServiceConnection() {
        return this.mServiceConnection;
    }

    @VisibleForTesting(otherwise = 5)
    public int getServiceState() {
        return this.mServiceState;
    }

    @Override // com.samsung.android.mcf.continuity.api.ContinuityAdapter
    public int initialize(@NonNull Context context, int i) {
        if (!FeatureUtil.isContinuityFeatureEnabled()) {
            DLog.m5611w(TAG, "initialize", "INIT_FAIL_FEATURE_NOT_ENABLED");
            return 901;
        }
        if (!SettingUtil.isContinuitySettingEnabled(context)) {
            DLog.m5611w(TAG, "initialize", "INIT_FAIL_SETTING_NOT_ENABLED");
            return 902;
        }
        VersionUtil.initServiceSupportFeatures(context);
        if (VersionUtil.isServiceSupportAppId(i)) {
            ExecutorUtil.executeOnMain(new RunnableC0050f(this, i, 3));
            return 900;
        }
        DLog.m5611w(TAG, "initialize", "INIT_FAIL_APP_ID_NOT_SUPPORTED");
        return 903;
    }

    @Override // com.samsung.android.mcf.continuity.api.ContinuityAdapter
    public void release(@NonNull Context context) {
        ExecutorUtil.executeOnMain(new RunnableC4179b(this, context, 1));
    }

    @Override // com.samsung.android.mcf.continuity.api.ContinuityAdapter
    public void unbindService(@NonNull Context context) {
        ExecutorUtil.executeOnMain(new RunnableC4179b(this, context, 0));
    }
}
