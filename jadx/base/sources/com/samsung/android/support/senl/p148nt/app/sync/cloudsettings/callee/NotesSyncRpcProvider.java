package com.samsung.android.support.senl.p148nt.app.sync.cloudsettings.callee;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.common.SyncInitState$InitState;
import com.samsung.android.app.notes.sync.saccount.samsungaccountclient.C6875b;
import com.samsung.android.app.notes.sync.scloud.pam.SCloudPamHelper;
import com.samsung.android.scloud.lib.setting.SyncSettingStdProviderServer;
import com.samsung.android.scloud.rpc.SamsungCloudRPCStatusObserver;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.p146os.UserManagerCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.sync.SyncInitializer;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import java.util.ArrayList;
import p001A.AbstractC0000a;
import p042J1.C0145c;
import p044K.AbstractC0159b;
import p044K.C0158a;
import p192j1.C12936a;
import p207n1.C13541h;
import p244u1.C14477a;
import p259y0.AbstractC14517a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class NotesSyncRpcProvider extends SyncSettingStdProviderServer {
    public static final String FORCE_SYNC = "force";
    private static final String PROVIDER_AUTHORITY = "com.samsung.android.app.notes.syncv2";
    private static final String TAG = "NotesSyncRpcProvider";
    boolean isDigitalLegacySyncRequested = false;
    boolean isDigitalLegacyPendingSyncChecked = false;
    final Object digitalLegacyLock = new Object();

    private boolean init() {
        Context applicationContext;
        try {
            applicationContext = getContext().getApplicationContext();
        } catch (Exception e) {
            AbstractC0000a.m22s("init() : getContext().getApplicationContext() fail, ", e, TAG);
            applicationContext = null;
        }
        if (applicationContext == null) {
            Debugger.m8609e(TAG, "init() : getContext().getApplicationContext() is null!");
            applicationContext = BaseUtils.getApplicationContext();
            if (applicationContext == null) {
                Debugger.m8609e(TAG, "init() : fail to get the appContext");
                return false;
            }
        }
        C13541h.f9587g = applicationContext;
        C6875b.f4373v = applicationContext;
        try {
            SyncInitializer.lazyInitialize(applicationContext);
            if (AbstractC0159b.f493a == SyncInitState$InitState.initialized) {
                return true;
            }
            Debugger.m8615i(TAG, "init() : Not initialized!!");
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private void resumeDigitalLegacyDownloadAfterForceClose(final Context context) {
        synchronized (this.digitalLegacyLock) {
            try {
                if (this.isDigitalLegacySyncRequested) {
                    return;
                }
                if (this.isDigitalLegacyPendingSyncChecked) {
                    return;
                }
                this.isDigitalLegacyPendingSyncChecked = true;
                if (!C0145c.m323h("SyncService", "SyncCompletedStatus", true) && UserManagerCompat.getInstance().isDigitalLegacyMode(context) && C14477a.m15065b().f10283a.m5099h()) {
                    Debugger.m8615i(TAG, "resumeDigitalLegacyDownloadAfterForceClose() : executed");
                    this.isDigitalLegacySyncRequested = true;
                    if (!init()) {
                    } else {
                        new SenlThreadFactory("resumeDigitalLegacyDownloadAfterForceClose").newThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.sync.cloudsettings.callee.NotesSyncRpcProvider.3
                            @Override // java.lang.Runnable
                            public void run() {
                                C14477a.m15065b().m15077m(context);
                            }
                        }).start();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.SyncSettingStdProviderServer
    public void cancelSync() {
        Debugger.m8615i(TAG, "cancelSync()");
        if (init()) {
            new SenlThreadFactory("RequestCancelSyncBySCloud").newThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.sync.cloudsettings.callee.NotesSyncRpcProvider.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        C14477a.m15065b().m15076l(103);
                    } catch (Exception e) {
                        AbstractC0000a.m21r(e, new StringBuilder("cancelSync() : "), NotesSyncRpcProvider.TAG);
                    }
                }
            }).start();
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.SyncSettingStdProviderServer
    public String getAuthority() {
        Debugger.m8615i(TAG, "getAuthority()");
        return PROVIDER_AUTHORITY;
    }

    @Override // com.samsung.android.scloud.lib.setting.SyncSettingStdProviderServer
    public boolean getAutoSync() {
        boolean zM417k = false;
        if (!init()) {
            return false;
        }
        try {
            zM417k = C0158a.m407a().m417k();
        } catch (Exception e) {
            AbstractC0000a.m21r(e, new StringBuilder("getAutoSync() : "), TAG);
        }
        Debugger.m8615i(TAG, "getAutoSync() : " + zM417k);
        return zM417k;
    }

    @Override // com.samsung.android.scloud.lib.setting.SyncSettingStdProviderServer
    public ArrayList<String> getDeniedPermissions() {
        C12936a.m13839c().getClass();
        ArrayList<String> arrayListM13840e = C12936a.m13840e();
        Debugger.m8615i(TAG, "getDeniedPermissions() : " + arrayListM13840e.toString());
        return arrayListM13840e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v5 */
    @Override // com.samsung.android.scloud.lib.setting.SyncSettingStdProviderServer
    public int getIsSyncable() {
        ?? IsSupportedSync;
        Context applicationContext = getContext().getApplicationContext();
        try {
            C0158a.m407a().getClass();
            IsSupportedSync = DeviceUtils.isSupportedSync(applicationContext);
        } catch (Exception e) {
            AbstractC0000a.m21r(e, new StringBuilder("getIsSyncable() : "), TAG);
            IsSupportedSync = 1;
        }
        AbstractC0000a.m17n(IsSupportedSync, "getIsSyncable() : ", TAG);
        resumeDigitalLegacyDownloadAfterForceClose(applicationContext);
        return IsSupportedSync;
    }

    @Override // com.samsung.android.scloud.lib.setting.SyncSettingStdProviderServer
    public long getLastSuccessTime() {
        long jM15161u = AbstractC14517a.m15161u();
        Debugger.m8615i(TAG, "getLastSuccessTime() : " + jM15161u);
        return jM15161u;
    }

    @Override // com.samsung.android.scloud.lib.setting.SyncSettingStdProviderServer
    public int getNetworkOption() {
        boolean zM299G = C0145c.m299G(getContext().getApplicationContext());
        AbstractC0000a.m0A(zM299G ? 1 : 0, "getNetworkOption() : ", TAG);
        return zM299G ? 1 : 0;
    }

    @Override // com.samsung.android.scloud.lib.setting.SyncSettingStdProviderServer
    public boolean isPermissionGranted() {
        C12936a.m13839c().getClass();
        boolean zIsEmpty = C12936a.m13840e().isEmpty();
        Debugger.m8615i(TAG, "isPermissionGranted() : " + zIsEmpty);
        return zIsEmpty;
    }

    @Override // com.samsung.android.scloud.lib.setting.SyncSettingStdProviderServer
    public boolean isSupported() {
        boolean zIsSupportedSync;
        Context applicationContext = getContext().getApplicationContext();
        try {
            C0158a.m407a().getClass();
            zIsSupportedSync = DeviceUtils.isSupportedSync(applicationContext);
        } catch (Exception e) {
            AbstractC0000a.m21r(e, new StringBuilder("isSupported() : "), TAG);
            zIsSupportedSync = true;
        }
        Debugger.m8615i(TAG, "isSupported() : " + zIsSupportedSync);
        return zIsSupportedSync;
    }

    @Override // com.samsung.android.scloud.lib.setting.SyncSettingStdProviderServer
    public boolean isSyncActive() {
        boolean z = !C14477a.m15065b().f10283a.m5099h();
        Debugger.m8615i(TAG, "isSyncActive() : " + z);
        return z;
    }

    @Override // com.samsung.android.scloud.lib.setting.SyncSettingStdProviderServer
    public boolean isSyncInEdpSupported() {
        boolean zM3210t = AbstractC4539a.m3210t();
        AbstractC4539a.m3215y("isSyncInEdpSupported() : ", TAG, zM3210t);
        return zM3210t;
    }

    @Override // com.samsung.android.scloud.lib.setting.SyncSettingStdProviderServer
    public void notifyEdpStateChanged(int i) {
        AbstractC0000a.m17n(i, "notifyEdpStateChanged() : ", TAG);
    }

    @Override // com.samsung.android.scloud.lib.setting.SyncSettingStdProviderServer, android.content.ContentProvider
    public boolean onCreate() {
        Debugger.m8615i(TAG, "onCreate()");
        return super.onCreate();
    }

    @Override // com.samsung.android.scloud.lib.setting.SyncSettingStdProviderServer
    public void requestSync(final Bundle bundle, SamsungCloudRPCStatusObserver samsungCloudRPCStatusObserver) {
        Debugger.m8615i(TAG, "[SCS] requestSync()");
        if (init()) {
            new SenlThreadFactory("RequestSyncBackgroundBySCloud").newThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.sync.cloudsettings.callee.NotesSyncRpcProvider.1
                @Override // java.lang.Runnable
                public void run() {
                    Bundle bundle2 = bundle;
                    if ((bundle2 == null || !bundle2.containsKey(NotesSyncRpcProvider.FORCE_SYNC)) ? false : bundle.getBoolean(NotesSyncRpcProvider.FORCE_SYNC)) {
                        C14477a.m15065b().m15072h();
                    } else if (C0158a.m407a().m413c()) {
                        C14477a.m15065b().m15071g("requestSync() : requested by the cloud setting!");
                    } else {
                        Debugger.m8609e(NotesSyncRpcProvider.TAG, "requestSync() : fail to requestSync due to the impossible autosync!");
                    }
                }
            }).start();
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.SyncSettingStdProviderServer
    public void requestSyncForDigitalLegacy(Bundle bundle, SamsungCloudRPCStatusObserver samsungCloudRPCStatusObserver) {
        Debugger.m8615i(TAG, "requestSyncForDigitalLegacy()");
        if (UserManagerCompat.getInstance().isFeatureSupportDigitalLegacy()) {
            SCloudPamHelper.handleExpiredCloudToken();
            requestSync(bundle, samsungCloudRPCStatusObserver);
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.SyncSettingStdProviderServer
    public void setAutoSync(boolean z) {
        Debugger.m8615i(TAG, "[SCS] setAutoSync() : " + z);
        if (init()) {
            C14477a.m15065b().f10283a.mo5090b(z, false);
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.SyncSettingStdProviderServer
    public void setNetworkOption(int i) {
        boolean z = i != 0;
        Debugger.m8615i(TAG, "[SCS] setNetworkOption() : " + z);
        if (init()) {
            Context applicationContext = getContext().getApplicationContext();
            C14477a c14477aM15065b = C14477a.m15065b();
            if (applicationContext != null) {
                c14477aM15065b.f10283a.m5103m(applicationContext, z, true);
            } else {
                c14477aM15065b.getClass();
                Debugger.m8609e("SyncManager", "setWiFiSyncOnlyByCloudSetting() : context is null!");
            }
        }
    }
}
