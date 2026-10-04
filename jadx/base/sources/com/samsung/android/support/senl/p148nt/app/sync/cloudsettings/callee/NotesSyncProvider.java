package com.samsung.android.support.senl.p148nt.app.sync.cloudsettings.callee;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.common.SyncInitState$InitState;
import com.samsung.android.app.notes.sync.saccount.samsungaccountclient.C6875b;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.app.sync.SyncInitializer;
import com.samsung.android.support.senl.p148nt.base.common.constants.SettingsConstants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.StorageUtils;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesContentEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import java.io.File;
import java.util.Iterator;
import p026F1.C0099c;
import p042J1.C0145c;
import p044K.AbstractC0159b;
import p044K.C0158a;
import p207n1.C13541h;
import p244u1.C14477a;
import p259y0.AbstractC14517a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class NotesSyncProvider extends ContentProvider {
    public static final int FORCE_SYNC_START = 4;
    public static final int FORCE_SYNC_START_IGNORE_WIFI = 5;
    public static final String GET_DB = "GETDB";
    public static final String KEY = "key";
    public static final String NETWORK_MODE = "NetworkMode";
    public static final String REQUEST_SYNC_STATE = "RequestSyncState";
    public static final String SET_DB = "SETDB";
    public static final int STOP = 0;
    public static final int SYNCING = 2;
    public static final int SYNC_CANCEL = 3;
    public static final int SYNC_START = 1;
    private static final String TAG = "#NotesSyncProvider";
    public static final String UPLOAD_SAMSUNG_NOTE = "UploadSamsungnote";
    public static final String UPLOAD_SNOTE = "UploadSnote";
    public static final String VALUE = "value";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface METHOD {
        public static final String IS_ENABLED_ITEM_WIFI_ONLY = "isEnabledItemWifiOnly";
        public static final String IS_SYNC = "isSync";
        public static final String IS_SYNCABLE = "isSyncable";
        public static final String IS_SYNC_WHEN_ROAMING = "isSyncWhenRoaming";
        public static final String LAST_SYNC_TIME = "LastSyncTime";
        public static final String NOTE_DATA_SIZE = "NoteDataSize";
        public static final String SYNC = "Sync";
        public static final String SYNCBYUSER = "SyncByUser";
        public static final String SYNC_BLOCKED = "SyncBlocked";
        public static final String SYNC_NOW = "SyncNow";
    }

    private Bundle LastSyncTime(String str, Bundle bundle, Bundle bundle2) {
        String string = bundle != null ? bundle.getString("key") : null;
        if (string == null) {
            Debugger.m8609e(TAG, "LastSyncTime : no key!");
            return bundle2;
        }
        if (isValidUploadKey(string) && GET_DB.equals(str)) {
            long jM15161u = AbstractC14517a.m15161u();
            bundle2.putLong("value", jM15161u);
            Debugger.m8607d(TAG, "LastSyncTime = " + Long.toString(jM15161u));
        }
        return bundle2;
    }

    private Bundle NoteDataSize(String str, Bundle bundle) {
        if (GET_DB.equals(str)) {
            bundle.putLong("value", getSDocDataSize() + getContentDataSize());
        }
        return bundle;
    }

    private Bundle Sync(String str, Bundle bundle, Bundle bundle2) {
        String string = bundle != null ? bundle.getString("key") : null;
        if (string == null) {
            Debugger.m8609e(TAG, "Sync : no key!");
            return bundle2;
        }
        if (isValidUploadKey(string) && SET_DB.equals(str)) {
            int i = bundle.getInt("value");
            StringBuilder sb = new StringBuilder("setSyncEnable : ");
            sb.append(i == 1);
            sb.append(" as auto sync enable");
            Debugger.m8615i(TAG, sb.toString());
            C14477a.m15065b().f10283a.mo5090b(i == 1, false);
        }
        return bundle2;
    }

    private Bundle SyncBlocked(String str, Bundle bundle, Bundle bundle2) {
        String string = bundle != null ? bundle.getString("key") : null;
        if (string == null) {
            Debugger.m8609e(TAG, "SyncBlocked : no key!");
            return bundle2;
        }
        if (isValidUploadKey(string)) {
            if (SET_DB.equals(str)) {
                int i = bundle.getInt("value");
                StringBuilder sb = new StringBuilder("setSyncBlockedState : ");
                sb.append(i == 1);
                Debugger.m8615i(TAG, sb.toString());
                C0145c.m304L("Settings", SettingsConstants.SETTINGS_BLOCKING_SYNC, i == 1);
                return bundle2;
            }
            if (GET_DB.equals(str)) {
                boolean zM294B = C0145c.m294B();
                bundle2.putBoolean("value", zM294B);
                Debugger.m8607d(TAG, "isSyncBlockedState = " + zM294B);
            }
        }
        return bundle2;
    }

    private Bundle SyncByUser(String str, Bundle bundle, Bundle bundle2) {
        String string = bundle != null ? bundle.getString("key") : null;
        if (string == null) {
            Debugger.m8609e(TAG, "SyncByUser : no key!");
            return bundle2;
        }
        if (isValidUploadKey(string) && SET_DB.equals(str)) {
            int i = bundle.getInt("value");
            StringBuilder sb = new StringBuilder("setSyncEnable : ");
            sb.append(i == 1);
            sb.append(" as manual sync enable");
            Debugger.m8615i(TAG, sb.toString());
            C14477a.m15065b().f10283a.mo5090b(i == 1, true);
        }
        return bundle2;
    }

    private Bundle SyncNow(String str, Bundle bundle, Bundle bundle2) {
        String string;
        int i;
        if (SET_DB.equals(str)) {
            if (bundle != null) {
                string = bundle.getString("key");
                i = bundle.getInt("value");
            } else {
                string = null;
                i = -1;
            }
            if (REQUEST_SYNC_STATE.equals(string)) {
                if (i == 1) {
                    Debugger.m8615i(TAG, "requestSyncByManual by SCloud setting.");
                    new SenlThreadFactory("RequestSyncByManualBySCloud").newThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.sync.cloudsettings.callee.NotesSyncProvider.1
                        @Override // java.lang.Runnable
                        public void run() {
                            C14477a c14477aM15065b = C14477a.m15065b();
                            c14477aM15065b.getClass();
                            Debugger.m8615i("SyncManager", "requestSyncByManual()");
                            c14477aM15065b.f10283a.m5100j(new C0099c(64));
                        }
                    }).start();
                    return bundle2;
                }
                if (i == 3) {
                    Debugger.m8615i(TAG, "staticStopSync by Scloud setting.");
                    C14477a.m15065b().m15076l(103);
                    return bundle2;
                }
                if (i == 4) {
                    Debugger.m8615i(TAG, "requestSyncByForce force sync now by SCloud setting.");
                    new SenlThreadFactory("requestSyncByForceBySCloud").newThread(new Runnable() { // from class: com.samsung.android.support.senl.nt.app.sync.cloudsettings.callee.NotesSyncProvider.2
                        @Override // java.lang.Runnable
                        public void run() {
                            C14477a.m15065b().m15072h();
                        }
                    }).start();
                    return bundle2;
                }
                if (i != 5) {
                    Debugger.m8609e(TAG, "Not supported by Scloud setting!!");
                    return bundle2;
                }
                Debugger.m8609e(TAG, "FORCE_SYNC_START_IGNORE_WIFI is not supported by Scloud setting!");
                return bundle2;
            }
        } else if (GET_DB.equals(str)) {
            if (C14477a.m15065b().f10283a.m5099h()) {
                bundle2.putInt("value", 0);
                Debugger.m8607d(TAG, "sync state is stopped");
                return bundle2;
            }
            bundle2.putInt("value", 2);
            Debugger.m8607d(TAG, "sync state is syncing");
        }
        return bundle2;
    }

    private long getContentDataSize() {
        Iterator<NotesContentEntity> it = NotesDataRepositoryFactory.newInstance(getContext()).createDocumentContentRepository().getAllDataList().iterator();
        long length = 0;
        while (it.hasNext()) {
            String filePath = it.next().getFilePath();
            if (filePath.endsWith(".jpg") || filePath.endsWith(".png")) {
                File file = new File(filePath);
                if (file.exists()) {
                    length = file.length() + length;
                }
            }
        }
        Debugger.m8607d(TAG, "getContentDataSize : " + length);
        return length;
    }

    private long getSDocDataSize() {
        Iterator<String> it = NotesDataRepositoryFactory.newInstance(getContext()).createDocumentDataRepository().getAllPathList().iterator();
        long sdocStorage = 0;
        while (it.hasNext()) {
            sdocStorage += StorageUtils.getSdocStorage(it.next());
        }
        Debugger.m8607d(TAG, "getSDocDataSize : " + sdocStorage);
        return sdocStorage;
    }

    private boolean init() {
        try {
            Context applicationContext = getContext().getApplicationContext();
            C13541h.f9587g = applicationContext;
            C6875b.f4373v = applicationContext;
            SyncInitializer.lazyInitialize(getContext().getApplicationContext());
            if (AbstractC0159b.f493a == SyncInitState$InitState.initialized) {
                return true;
            }
            Debugger.m8615i(TAG, "Not initialized!!");
            return false;
        } catch (Error | Exception unused) {
            return false;
        }
    }

    private Bundle isEnabledItemWifiOnly(String str, Bundle bundle, Bundle bundle2) {
        String string = bundle != null ? bundle.getString("key") : null;
        if (string == null) {
            Debugger.m8609e(TAG, "isEnabledItemWifiOnly : no key!");
            return bundle2;
        }
        Context applicationContext = getContext().getApplicationContext();
        if (isValidUploadKey(string)) {
            if (GET_DB.equals(str)) {
                boolean zM299G = C0145c.m299G(applicationContext);
                bundle2.putInt("value", zM299G ? 1 : 0);
                Debugger.m8607d(TAG, "getWiFiSyncOnly : " + (zM299G ? 1 : 0));
                return bundle2;
            }
            if (SET_DB.equals(str)) {
                boolean z = bundle.getInt("value") != 0;
                Debugger.m8607d(TAG, "setWiFiSyncOnly : " + z);
                C14477a c14477aM15065b = C14477a.m15065b();
                if (applicationContext != null) {
                    c14477aM15065b.f10283a.m5103m(applicationContext, z, true);
                    return bundle2;
                }
                c14477aM15065b.getClass();
                Debugger.m8609e("SyncManager", "setWiFiSyncOnlyByCloudSetting() : context is null!");
                return bundle2;
            }
        } else if (NETWORK_MODE.equals(string)) {
            if (GET_DB.equals(str)) {
                boolean zM299G2 = C0145c.m299G(applicationContext);
                bundle2.putInt("value", zM299G2 ? 1 : 0);
                Debugger.m8609e(TAG, "Not Supported : GET NETWORK_MODE = " + (zM299G2 ? 1 : 0));
                return bundle2;
            }
            if (SET_DB.equals(str)) {
                StringBuilder sb = new StringBuilder("Not Supported : SET NETWORK_MODE = ");
                sb.append(bundle.getInt("value") != 0);
                Debugger.m8609e(TAG, sb.toString());
            }
        }
        return bundle2;
    }

    private Bundle isSync(String str, Bundle bundle) {
        if (GET_DB.equals(str)) {
            boolean zM417k = C0158a.m407a().m417k();
            bundle.putBoolean("value", zM417k);
            AbstractC4539a.m3215y("isSyncEnableMode = ", TAG, zM417k);
        }
        return bundle;
    }

    private Bundle isSyncable(String str, Bundle bundle) {
        if (GET_DB.equals(str)) {
            boolean zIsSupportedSync = DeviceUtils.isSupportedSync(C0158a.m407a().f492a);
            bundle.putBoolean("value", zIsSupportedSync);
            Debugger.m8607d(TAG, "isSyncable = " + zIsSupportedSync);
        }
        return bundle;
    }

    private boolean isValidUploadKey(String str) {
        return UPLOAD_SNOTE.equals(str) || UPLOAD_SAMSUNG_NOTE.equals(str);
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Bundle call(@NonNull String str, String str2, Bundle bundle) {
        StringBuilder sbM12325j = AbstractC11014a.m12325j("Scloud settings calls ", str);
        sbM12325j.append(GET_DB.equals(str2) ? " (GET)" : " (SET)");
        Debugger.m8607d(TAG, sbM12325j.toString());
        if (getContext() == null) {
            Debugger.m8609e(TAG, "Invalid context");
            return null;
        }
        if (getContext().getApplicationContext() == null) {
            Debugger.m8609e(TAG, "Invalid appContext");
            return null;
        }
        Bundle bundle2 = new Bundle();
        if (!init()) {
            return null;
        }
        str.getClass();
        switch (str) {
            case "NoteDataSize":
                bundle2 = NoteDataSize(str2, bundle2);
                break;
            case "isSync":
                bundle2 = isSync(str2, bundle2);
                break;
            case "SyncByUser":
                bundle2 = SyncByUser(str2, bundle, bundle2);
                break;
            case "SyncNow":
                bundle2 = SyncNow(str2, bundle, bundle2);
                break;
            case "Sync":
                bundle2 = Sync(str2, bundle, bundle2);
                break;
            case "SyncBlocked":
                bundle2 = SyncBlocked(str2, bundle, bundle2);
                break;
            case "LastSyncTime":
                bundle2 = LastSyncTime(str2, bundle, bundle2);
                break;
            case "isEnabledItemWifiOnly":
                bundle2 = isEnabledItemWifiOnly(str2, bundle, bundle2);
                break;
            case "isSyncable":
                bundle2 = isSyncable(str2, bundle2);
                break;
            default:
                Debugger.m8609e(TAG, "invalid call!");
                break;
        }
        StringBuilder sbM12325j2 = AbstractC11014a.m12325j("Scloud settings finishes to call ", str);
        sbM12325j2.append(GET_DB.equals(str2) ? " (GET)" : " (SET)");
        Debugger.m8607d(TAG, sbM12325j2.toString());
        return bundle2;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
