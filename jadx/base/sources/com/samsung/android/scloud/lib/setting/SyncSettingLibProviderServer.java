package com.samsung.android.scloud.lib.setting;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.scloud.lib.setting.RPCSyncSettingContract;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class SyncSettingLibProviderServer extends ContentProvider {
    private static final String TAG = "[scsettingv2][2.0.33.0]";
    private static volatile Context applicationContext;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$call$0(Bundle bundle) {
        Log.i(TAG, "notifyPerformancePolicy: " + SyncPerformancePolicyManager.onPolicyUpdatedByCloud(bundle));
    }

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, final Bundle bundle) {
        SamsungCloudRPCProperty.waitForInitCompleted();
        Bundle bundle2 = new Bundle();
        if (RPCSyncSettingContract.Method.SET_NETWORK_OPTION.equals(str)) {
            if (bundle != null) {
                int i = bundle.getInt(RPCSyncSettingContract.Parameter.NETWORK_OPTION);
                Log.i(TAG, "notifyNetworkOption: " + i);
                notifyNetworkOption(i);
                return bundle2;
            }
        } else if (RPCSyncSettingContract.Method.SET_AUTO_SYNC.equals(str)) {
            if (bundle != null) {
                boolean z = bundle.getBoolean(RPCSyncSettingContract.Parameter.AUTO_SYNC);
                Log.i(TAG, "notifyAutoSync: " + z);
                notifyAutoSync(z);
                return bundle2;
            }
        } else if (RPCSyncSettingContract.Method.SET_CONTENT_SYNC.equals(str)) {
            if (bundle != null) {
                String string = bundle.getString(RPCSyncSettingContract.Parameter.CONTENT_ID);
                boolean z2 = bundle.getBoolean(RPCSyncSettingContract.Parameter.AUTO_SYNC);
                Log.i(TAG, "notifyContentSync[" + string + "] : " + z2);
                notifyContentSync(string, z2);
                return bundle2;
            }
        } else {
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
            } else if (RPCSyncSettingContract.Method.NOTIFY_PERFORMANCE_POLICY.equals(str)) {
                new Thread(new Runnable() { // from class: com.samsung.android.scloud.lib.setting.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        SyncSettingLibProviderServer.lambda$call$0(bundle);
                    }
                }).start();
            }
        }
        return bundle2;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public abstract boolean isSupported();

    public abstract void notifyAutoSync(boolean z);

    public abstract void notifyContentSync(String str, boolean z);

    public abstract void notifyEdpStateChanged(int i);

    public abstract void notifyNetworkOption(int i);

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        Log.i(TAG, "onCreate: ");
        synchronized (SyncSettingLibProviderServer.class) {
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

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
