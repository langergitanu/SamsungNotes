package com.samsung.android.scloud.lib.setting;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.samsung.android.scloud.lib.setting.RPCSyncSettingContract;
import com.samsung.android.scloud.rpc.SamsungCloudRPCStatusObserver;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class SyncSettingStdProviderServer extends ContentProvider {
    private static final String TAG = "[scsettingv2std][2.0.33.0]";
    private static volatile Context applicationContext;

    private SamsungCloudRPCStatusObserver getRPCStatusObserver() {
        return new SamsungCloudRPCStatusObserver() { // from class: com.samsung.android.scloud.lib.setting.SyncSettingStdProviderServer.1
            @Override // com.samsung.android.scloud.rpc.SamsungCloudRPCStatusObserver
            public void onCancel() {
                Log.i(SyncSettingStdProviderServer.TAG, "onCancel: ");
                SyncSettingStdProviderServer.this.getContext().getContentResolver().notifyChange(Uri.parse(AuthenticationConstants.BrokerContentProvider.CONTENT_SCHEME + SyncSettingStdProviderServer.this.getAuthority() + "/cancel"), null);
            }

            @Override // com.samsung.android.scloud.rpc.SamsungCloudRPCStatusObserver
            public void onComplete(Bundle bundle) {
                Log.i(SyncSettingStdProviderServer.TAG, "onComplete: ");
                String string = bundle.getString("rcode");
                SyncSettingStdProviderServer.this.getContext().getContentResolver().notifyChange(Uri.parse(AuthenticationConstants.BrokerContentProvider.CONTENT_SCHEME + SyncSettingStdProviderServer.this.getAuthority() + "/complete/" + string), null);
            }

            @Override // com.samsung.android.scloud.rpc.SamsungCloudRPCStatusObserver
            public void onProgress() {
                Log.i(SyncSettingStdProviderServer.TAG, "onProgress: ");
                SyncSettingStdProviderServer.this.getContext().getContentResolver().notifyChange(Uri.parse(AuthenticationConstants.BrokerContentProvider.CONTENT_SCHEME + SyncSettingStdProviderServer.this.getAuthority() + "/progress"), null);
            }

            @Override // com.samsung.android.scloud.rpc.SamsungCloudRPCStatusObserver
            public void onStart() {
                Log.i(SyncSettingStdProviderServer.TAG, "onStart: ");
                SyncSettingStdProviderServer.this.getContext().getContentResolver().notifyChange(Uri.parse(AuthenticationConstants.BrokerContentProvider.CONTENT_SCHEME + SyncSettingStdProviderServer.this.getAuthority() + "/start"), null);
            }
        };
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        SamsungCloudRPCProperty.waitForInitCompleted();
        Bundle bundle2 = new Bundle();
        if (RPCSyncSettingContract.Method.GET_NETWORK_OPTION.equals(str)) {
            int networkOption = getNetworkOption();
            AbstractC2322a.m1631u(networkOption, "getNetworkOption: ", TAG);
            bundle2.putInt(RPCSyncSettingContract.Parameter.NETWORK_OPTION, networkOption);
            return bundle2;
        }
        if (RPCSyncSettingContract.Method.SET_NETWORK_OPTION.equals(str)) {
            if (bundle != null) {
                int i = bundle.getInt(RPCSyncSettingContract.Parameter.NETWORK_OPTION);
                Log.i(TAG, "setNetworkOption: " + i);
                setNetworkOption(i);
                return bundle2;
            }
        } else {
            if (RPCSyncSettingContract.Method.GET_AUTO_SYNC.equals(str)) {
                boolean autoSync = getAutoSync();
                AbstractC4539a.m3208r("getAutoSync: ", TAG, autoSync);
                bundle2.putBoolean(RPCSyncSettingContract.Parameter.AUTO_SYNC, autoSync);
                return bundle2;
            }
            if (RPCSyncSettingContract.Method.SET_AUTO_SYNC.equals(str)) {
                if (bundle != null) {
                    boolean z = bundle.getBoolean(RPCSyncSettingContract.Parameter.AUTO_SYNC);
                    Log.i(TAG, "setAutoSync: " + z);
                    setAutoSync(z);
                    return bundle2;
                }
            } else {
                if ("is_sync_active".equals(str)) {
                    boolean zIsSyncActive = isSyncActive();
                    AbstractC4539a.m3208r("isSyncActive: ", TAG, zIsSyncActive);
                    bundle2.putBoolean("is_sync_active", zIsSyncActive);
                    return bundle2;
                }
                if (RPCSyncSettingContract.Method.REQUEST_SYNC.equals(str)) {
                    if (bundle != null && !isSyncActive()) {
                        requestSync(bundle, getRPCStatusObserver());
                        return bundle2;
                    }
                } else if (RPCSyncSettingContract.Method.REQUEST_SYNC_FOR_DIGITAL_LEGACY.equals(str)) {
                    if (bundle != null) {
                        requestSyncForDigitalLegacy(bundle, getRPCStatusObserver());
                        return bundle2;
                    }
                } else {
                    if (RPCSyncSettingContract.Method.CANCEL_SYNC.equals(str)) {
                        Log.i(TAG, "cancelSync: ");
                        cancelSync();
                        return bundle2;
                    }
                    if (RPCSyncSettingContract.Method.GET_LAST_SUCCESS_TIME.equals(str)) {
                        long lastSuccessTime = getLastSuccessTime();
                        Log.i(TAG, "getLastSuccessTime: " + lastSuccessTime);
                        bundle2.putLong(RPCSyncSettingContract.Parameter.LAST_SUCCESS_TIME, lastSuccessTime);
                        return bundle2;
                    }
                    if ("is_syncable".equals(str)) {
                        int isSyncable = getIsSyncable();
                        AbstractC2322a.m1631u(isSyncable, "getIsSyncable: ", TAG);
                        bundle2.putInt("is_syncable", isSyncable);
                        return bundle2;
                    }
                    if ("is_permission_granted".equals(str)) {
                        boolean zIsPermissionGranted = isPermissionGranted();
                        AbstractC4539a.m3208r("isPermissionGranted: ", TAG, zIsPermissionGranted);
                        bundle2.putBoolean("is_permission_granted", zIsPermissionGranted);
                        return bundle2;
                    }
                    if (RPCSyncSettingContract.Method.GET_DENIED_PERMISSIONS.equals(str)) {
                        ArrayList<String> deniedPermissions = getDeniedPermissions();
                        if (deniedPermissions != null) {
                            Log.i(TAG, "getDeniedPermissions: " + deniedPermissions.toString());
                        }
                        bundle2.putStringArrayList(RPCSyncSettingContract.Parameter.DENIED_PERMISSIONS, deniedPermissions);
                        return bundle2;
                    }
                    if (RPCSyncSettingContract.Method.IS_SUPPORTED.equals(str)) {
                        boolean zIsSupported = isSupported();
                        AbstractC4539a.m3208r("isSupported: ", TAG, zIsSupported);
                        bundle2.putBoolean(RPCSyncSettingContract.Parameter.SUPPORTED, zIsSupported);
                        return bundle2;
                    }
                    if (RPCSyncSettingContract.Method.NOTIFY_EDP_STATE.equals(str)) {
                        if (bundle != null) {
                            int i2 = bundle.getInt(RPCSyncSettingContract.Parameter.EDP_STATE);
                            Log.i(TAG, "notifyEdpStateChanged: " + i2);
                            notifyEdpStateChanged(i2);
                            return bundle2;
                        }
                    } else if (RPCSyncSettingContract.Method.IS_SYNC_IN_EDP_SUPPORTED.equals(str)) {
                        boolean zIsSyncInEdpSupported = isSyncInEdpSupported();
                        AbstractC4539a.m3208r("isSyncInEdpSupported: ", TAG, zIsSyncInEdpSupported);
                        bundle2.putBoolean(RPCSyncSettingContract.Parameter.SUPPORTED, zIsSyncInEdpSupported);
                    }
                }
            }
        }
        return bundle2;
    }

    public abstract void cancelSync();

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public abstract String getAuthority();

    public abstract boolean getAutoSync();

    public abstract ArrayList<String> getDeniedPermissions();

    public abstract int getIsSyncable();

    public abstract long getLastSuccessTime();

    public abstract int getNetworkOption();

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public abstract boolean isPermissionGranted();

    public abstract boolean isSupported();

    public abstract boolean isSyncActive();

    public abstract boolean isSyncInEdpSupported();

    public abstract void notifyEdpStateChanged(int i);

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Log.i(TAG, "onCreate: ");
        synchronized (SyncSettingStdProviderServer.class) {
            try {
                if (applicationContext == null) {
                    applicationContext = getContext().getApplicationContext();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return true;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public abstract void requestSync(Bundle bundle, SamsungCloudRPCStatusObserver samsungCloudRPCStatusObserver);

    public abstract void requestSyncForDigitalLegacy(Bundle bundle, SamsungCloudRPCStatusObserver samsungCloudRPCStatusObserver);

    public abstract void setAutoSync(boolean z);

    public abstract void setNetworkOption(int i);

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
