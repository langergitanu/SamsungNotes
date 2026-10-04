package com.samsung.android.scloud.lib.setting;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.samsung.android.scloud.lib.setting.RPCSyncSettingContract;
import com.samsung.android.scloud.rpc.SamsungCloudRPCStatusObserver;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class SyncSettingProviderClient implements ISyncSetting, ISyncSummary {
    private static final String DELIMITER = ";";
    private static int ERROR_CODE_IDX = 1;
    private static String TAG;
    private int applicationType;
    private String authority;
    private Context context;
    private Uri rpcUri;
    private String settingProvider;
    private LibSyncScheduleManager syncScheduleManager;
    private ContentObserver syncStatusObserver;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class SyncSettingIntent implements Function<String, Intent> {
        int flags;

        public SyncSettingIntent(int i) {
            this.flags = i;
        }

        @Override // java.util.function.Function
        public Intent apply(String str) {
            Log.d(SyncSettingProviderClient.TAG, "Intent - authority: " + str);
            Intent intent = "media".equals(str) ? new Intent(RPCSyncSettingContract.Action.SHOW_GALLERY_SETTING) : RPCSyncSettingContract.Authority.Setting.equals(str) ? new Intent(RPCSyncSettingContract.Action.SHOW_SYNC_SETTING_DASHBOARD) : new Intent(RPCSyncSettingContract.Action.SHOW_SETTING);
            intent.setPackage("com.samsung.android.scloud");
            intent.putExtra("authority", str);
            intent.addFlags(this.flags);
            return intent;
        }
    }

    public SyncSettingProviderClient(Context context, Uri uri, String str, String str2, String str3) {
        this.applicationType = 1;
        this.context = context;
        this.rpcUri = uri;
        this.authority = str;
        this.settingProvider = str2;
        this.syncScheduleManager = new LibSyncScheduleManager(context, uri, str);
        TAG = str3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$loadPerformancePolicy$2(SyncPerformancePolicy syncPerformancePolicy) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$requestFastSync$1(AtomicReference atomicReference, String str) {
        atomicReference.set(((String) atomicReference.get()) + str + ";");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$requestSync$0(AtomicReference atomicReference, String str) {
        atomicReference.set(((String) atomicReference.get()) + str + ";");
    }

    @Override // com.samsung.android.scloud.lib.setting.ISyncSetting
    public void addSyncStatusObserver(final SamsungCloudRPCStatusObserver samsungCloudRPCStatusObserver, String str) {
        if (this.syncStatusObserver != null) {
            return;
        }
        this.syncStatusObserver = new ContentObserver(new Handler(Looper.getMainLooper())) { // from class: com.samsung.android.scloud.lib.setting.SyncSettingProviderClient.1
            @Override // android.database.ContentObserver
            public void onChange(boolean z, Uri uri) {
                try {
                    Log.i(SyncSettingProviderClient.TAG, "syncStatusObserver : " + uri.toString());
                    String str2 = uri.getPathSegments().get(0);
                    if ("complete".equals(str2)) {
                        Bundle bundle = new Bundle();
                        bundle.putString("rcode", uri.getPathSegments().get(SyncSettingProviderClient.ERROR_CODE_IDX));
                        samsungCloudRPCStatusObserver.onComplete(bundle);
                    } else if ("progress".equals(str2)) {
                        samsungCloudRPCStatusObserver.onProgress();
                    } else if ("start".equals(str2)) {
                        samsungCloudRPCStatusObserver.onStart();
                    } else if ("cancel".equals(str2)) {
                        samsungCloudRPCStatusObserver.onCancel();
                    }
                } catch (Exception e) {
                    Log.e(SyncSettingProviderClient.TAG, e.getMessage());
                }
            }
        };
        this.context.getContentResolver().registerContentObserver(Uri.parse(AuthenticationConstants.BrokerContentProvider.CONTENT_SCHEME + this.settingProvider), true, this.syncStatusObserver);
    }

    @Override // com.samsung.android.scloud.lib.setting.ISyncSetting
    public void cancelSync() {
        try {
            Log.i(TAG, "cancelSync");
            Bundle bundle = new Bundle();
            bundle.putString("authority", this.authority);
            bundle.putLong("library_version", RPCSyncSettingContract.Version.EDP_SUPPORTED_VERSION);
            this.context.getContentResolver().call(this.rpcUri, RPCSyncSettingContract.Method.CANCEL_SYNC, (String) null, bundle);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.ISyncSetting
    public boolean getAutoSync() {
        try {
            Log.i(TAG, "getAutoSync");
            Bundle bundle = new Bundle();
            bundle.putString("authority", this.authority);
            bundle.putInt(RPCSyncSettingContract.Parameter.APPLICATION_TYPE, this.applicationType);
            bundle.putLong("library_version", RPCSyncSettingContract.Version.EDP_SUPPORTED_VERSION);
            return this.context.getContentResolver().call(this.rpcUri, RPCSyncSettingContract.Method.GET_AUTO_SYNC, (String) null, bundle).getBoolean(RPCSyncSettingContract.Parameter.AUTO_SYNC, false);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
            return false;
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.ISyncSetting
    public boolean getContentSync(String str) {
        try {
            Log.i(TAG, "getIsContentSyncable");
            Bundle bundle = new Bundle();
            bundle.putString("authority", this.authority);
            bundle.putString(RPCSyncSettingContract.Parameter.CONTENT_ID, str);
            bundle.putInt(RPCSyncSettingContract.Parameter.APPLICATION_TYPE, this.applicationType);
            bundle.putLong("library_version", RPCSyncSettingContract.Version.EDP_SUPPORTED_VERSION);
            return this.context.getContentResolver().call(this.rpcUri, RPCSyncSettingContract.Method.GET_CONTENT_SYNC, (String) null, bundle).getBoolean(RPCSyncSettingContract.Parameter.AUTO_SYNC, false);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
            return false;
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.ISyncSetting
    public int getEdpState() {
        try {
            Log.i(TAG, "getEdpState");
            Bundle bundle = new Bundle();
            bundle.putString("authority", this.authority);
            bundle.putLong("library_version", RPCSyncSettingContract.Version.EDP_SUPPORTED_VERSION);
            return this.context.getContentResolver().call(this.rpcUri, RPCSyncSettingContract.Method.GET_EDP_STATE, (String) null, bundle).getInt(RPCSyncSettingContract.Parameter.EDP_STATE);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
            return -1;
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.ISyncSetting
    public int getNetworkOption() {
        try {
            Log.i(TAG, "getNetworkOption");
            Bundle bundle = new Bundle();
            bundle.putString("authority", this.authority);
            bundle.putLong("library_version", RPCSyncSettingContract.Version.EDP_SUPPORTED_VERSION);
            return this.context.getContentResolver().call(this.rpcUri, RPCSyncSettingContract.Method.GET_NETWORK_OPTION, (String) null, bundle).getInt(RPCSyncSettingContract.Parameter.NETWORK_OPTION);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
            return 1;
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.ISyncSetting
    public Bundle getProfile() {
        try {
            Bundle bundle = new Bundle();
            bundle.putString("authority", this.authority);
            bundle.putInt(RPCSyncSettingContract.Parameter.APPLICATION_TYPE, this.applicationType);
            bundle.putLong("library_version", RPCSyncSettingContract.Version.EDP_SUPPORTED_VERSION);
            Log.i(TAG, "getProfile: " + this.authority + SQLKeyword.COMMA + this.applicationType);
            return this.context.getContentResolver().call(this.rpcUri, RPCSyncSettingContract.Method.GET_PROFILE, (String) null, bundle);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
            return null;
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.ISyncSummary
    public ArrayList<String> getSyncableAppList() {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            Log.i(TAG, "getSyncableAppList");
            Bundle bundle = new Bundle();
            bundle.putString("authority", this.authority);
            bundle.putInt(RPCSyncSettingContract.Parameter.APPLICATION_TYPE, this.applicationType);
            return this.context.getContentResolver().call(this.rpcUri, RPCSyncSettingContract.Method.GET_SYNCABLE_APP_LIST, (String) null, bundle).getStringArrayList(RPCSyncSettingContract.Parameter.SYNCABLE_APP_LIST);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
            return arrayList;
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.ISyncSetting
    public boolean isSyncActive() {
        try {
            Log.i(TAG, "isSyncActive");
            Bundle bundle = new Bundle();
            bundle.putString("authority", this.authority);
            bundle.putLong("library_version", RPCSyncSettingContract.Version.EDP_SUPPORTED_VERSION);
            return this.context.getContentResolver().call(this.rpcUri, "is_sync_active", (String) null, bundle).getBoolean("is_sync_active");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.ISyncSetting
    public void loadPerformancePolicy() {
        try {
            new SyncPerformancePolicyManager(this.context, this.rpcUri, this.authority).loadPolicy(new C7219a(2));
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.ISyncSetting
    public void notifySupportedStatus(boolean z) {
        try {
            Log.i(TAG, "notifySupportedStatus: " + z);
            Bundle bundle = new Bundle();
            bundle.putString("authority", this.authority);
            bundle.putBoolean(RPCSyncSettingContract.Parameter.SUPPORTED, z);
            bundle.putLong("library_version", RPCSyncSettingContract.Version.EDP_SUPPORTED_VERSION);
            this.context.getContentResolver().call(this.rpcUri, RPCSyncSettingContract.Method.SET_SUPPORTED, (String) null, bundle);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.ISyncSetting
    public void notifySyncStatus(String str, int i) {
        Log.i(TAG, "notifySyncStatus");
        str.getClass();
        switch (str) {
            case "cancel":
                this.context.getContentResolver().notifyChange(Uri.parse(AuthenticationConstants.BrokerContentProvider.CONTENT_SCHEME + this.settingProvider + "/cancel"), null);
                break;
            case "progress":
                this.context.getContentResolver().notifyChange(Uri.parse(AuthenticationConstants.BrokerContentProvider.CONTENT_SCHEME + this.settingProvider + "/progress"), null);
                break;
            case "complete":
                this.context.getContentResolver().notifyChange(Uri.parse(AuthenticationConstants.BrokerContentProvider.CONTENT_SCHEME + this.settingProvider + "/complete/" + i), null);
                break;
            case "start":
                this.context.getContentResolver().notifyChange(Uri.parse(AuthenticationConstants.BrokerContentProvider.CONTENT_SCHEME + this.settingProvider + "/start"), null);
                break;
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.ISyncSetting
    public void removeSyncStatusObserver() {
        try {
            if (this.syncStatusObserver != null) {
                this.context.getContentResolver().unregisterContentObserver(this.syncStatusObserver);
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.ISyncSetting
    public void requestFastSync(ArrayList<String> arrayList) {
        try {
            Log.i(TAG, "requestFastSync: " + arrayList.toString());
            Bundle bundle = new Bundle();
            bundle.putString("authority", this.authority);
            AtomicReference atomicReference = new AtomicReference("");
            arrayList.forEach(new C7225g(atomicReference, 1));
            bundle.putString(RPCSyncSettingContract.Parameter.CONTENT_IDS, (String) atomicReference.get());
            bundle.putLong("library_version", RPCSyncSettingContract.Version.EDP_SUPPORTED_VERSION);
            if (this.settingProvider != null) {
                bundle.putString(RPCSyncSettingContract.Parameter.CALLBACK_URI, AuthenticationConstants.BrokerContentProvider.CONTENT_SCHEME + this.settingProvider);
            }
            this.context.getContentResolver().call(this.rpcUri, RPCSyncSettingContract.Method.REQUEST_FAST_SYNC, (String) null, bundle);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.ISyncSetting
    public void requestLocalSync(List<String> list) {
        try {
            Log.i(TAG, "requestLocalSync: start - " + list);
            this.syncScheduleManager.request(list);
            Log.i(TAG, "requestLocalSync: finish");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.ISyncSetting
    public void requestSingleRecordDownload(Bundle bundle) {
        try {
            Log.i(TAG, "requestSingleRecordDownload: " + bundle.toString());
            bundle.putString("authority", this.authority);
            bundle.putLong("library_version", RPCSyncSettingContract.Version.EDP_SUPPORTED_VERSION);
            this.context.getContentResolver().call(this.rpcUri, RPCSyncSettingContract.Method.REQUEST_SINGLE_RECORD_DOWNLOAD, (String) null, bundle);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.ISyncSetting
    public void requestSync() {
        try {
            Log.i(TAG, "requestSync");
            Bundle bundle = new Bundle();
            bundle.putString("authority", this.authority);
            bundle.putLong("library_version", RPCSyncSettingContract.Version.EDP_SUPPORTED_VERSION);
            if (this.settingProvider != null) {
                bundle.putString(RPCSyncSettingContract.Parameter.CALLBACK_URI, AuthenticationConstants.BrokerContentProvider.CONTENT_SCHEME + this.settingProvider);
            }
            this.context.getContentResolver().call(this.rpcUri, RPCSyncSettingContract.Method.REQUEST_SYNC, (String) null, bundle);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.ISyncSetting
    public void setAutoSync(boolean z) {
        try {
            Log.i(TAG, "setAutoSync");
            Bundle bundle = new Bundle();
            bundle.putString("authority", this.authority);
            bundle.putBoolean(RPCSyncSettingContract.Parameter.AUTO_SYNC, z);
            bundle.putLong("library_version", RPCSyncSettingContract.Version.EDP_SUPPORTED_VERSION);
            this.context.getContentResolver().call(this.rpcUri, RPCSyncSettingContract.Method.SET_AUTO_SYNC, (String) null, bundle);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.ISyncSetting
    public void setNetworkOption(int i) {
        try {
            Log.i(TAG, "setNetworkOption");
            Bundle bundle = new Bundle();
            bundle.putString("authority", this.authority);
            bundle.putInt(RPCSyncSettingContract.Parameter.NETWORK_OPTION, i);
            bundle.putLong("library_version", RPCSyncSettingContract.Version.EDP_SUPPORTED_VERSION);
            this.context.getContentResolver().call(this.rpcUri, RPCSyncSettingContract.Method.SET_NETWORK_OPTION, (String) null, bundle);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.ISyncSetting
    public void showSetting() {
        try {
            Log.i(TAG, "showSetting");
            this.context.startActivity(new SyncSettingIntent(268435456).apply(this.authority));
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.ISyncSetting
    public void showSetting(int i) {
        try {
            Log.i(TAG, "showSetting - flag:" + i);
            this.context.startActivity(new SyncSettingIntent(i).apply(this.authority));
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.ISyncSetting
    public void showSetting(Activity activity, int i) {
        try {
            Log.i(TAG, "showSetting - flag:" + i);
            activity.startActivityForResult(new SyncSettingIntent(i).apply(this.authority), 0);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.ISyncSetting
    public void requestSync(ArrayList<String> arrayList, boolean z) {
        try {
            Log.i(TAG, "requestSync: " + arrayList.toString() + ", forceSync: " + z);
            Bundle bundle = new Bundle();
            bundle.putString("authority", this.authority);
            AtomicReference atomicReference = new AtomicReference("");
            arrayList.forEach(new C7225g(atomicReference, 0));
            bundle.putString(RPCSyncSettingContract.Parameter.CONTENT_IDS, (String) atomicReference.get());
            bundle.putBoolean(RPCSyncSettingContract.Parameter.FORCE_SYNC, z);
            bundle.putLong("library_version", RPCSyncSettingContract.Version.EDP_SUPPORTED_VERSION);
            if (this.settingProvider != null) {
                bundle.putString(RPCSyncSettingContract.Parameter.CALLBACK_URI, AuthenticationConstants.BrokerContentProvider.CONTENT_SCHEME + this.settingProvider);
            }
            this.context.getContentResolver().call(this.rpcUri, RPCSyncSettingContract.Method.REQUEST_SYNC_BY_CONTENT_ID, (String) null, bundle);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SyncSettingProviderClient(Context context, Uri uri, String str, String str2, int i, String str3) {
        this.context = context;
        this.rpcUri = uri;
        this.authority = str;
        this.settingProvider = str2;
        this.applicationType = i;
        this.syncScheduleManager = new LibSyncScheduleManager(context, uri, str);
        TAG = str3;
    }

    @Override // com.samsung.android.scloud.lib.setting.ISyncSummary
    public boolean getAutoSync(String str) {
        try {
            Log.i(TAG, "getAutoSync: " + str);
            Bundle bundle = new Bundle();
            bundle.putString("authority", this.authority);
            bundle.putInt(RPCSyncSettingContract.Parameter.APPLICATION_TYPE, this.applicationType);
            bundle.putString(RPCSyncSettingContract.Parameter.QUERIED_AUTHORITY, str);
            return this.context.getContentResolver().call(this.rpcUri, RPCSyncSettingContract.Method.GET_AUTO_SYNC, (String) null, bundle).getBoolean(RPCSyncSettingContract.Parameter.AUTO_SYNC, false);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
            return false;
        }
    }
}
