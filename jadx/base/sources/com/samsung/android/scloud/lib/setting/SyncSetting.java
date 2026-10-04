package com.samsung.android.scloud.lib.setting;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import com.samsung.android.scloud.rpc.ISamsungCloudRPC;
import com.samsung.android.scloud.rpc.ISamsungCloudRPCCallback;
import com.samsung.android.scloud.rpc.SamsungCloudRPCProfile;
import com.samsung.android.scloud.rpc.SamsungCloudRPCStatus;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class SyncSetting implements ISetting {
    private static String TAG;
    private ISamsungCloudRPC iSamsungCloudRPC;
    private SamsungCloudRPCStatus samsungCloudRPCStatus;
    private String ACTION_NAME = "com.samsung.android.scloud.RPC_SYNC_SETTING";
    private String PACKAGE_NAME = "com.samsung.android.scloud";
    private String CLASS_NAME = "com.samsung.android.scloud.app.service.RPCSyncService";
    private ServiceConnection mConnection = new ServiceConnection() { // from class: com.samsung.android.scloud.lib.setting.SyncSetting.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            SyncSetting.this.iSamsungCloudRPC = ISamsungCloudRPC.Stub.asInterface(iBinder);
            SyncSetting.this.samsungCloudRPCStatus.onBind(true);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            SyncSetting.this.iSamsungCloudRPC = null;
        }
    };

    public SyncSetting(Context context, String str) {
        TAG = str;
        Intent intent = new Intent(this.ACTION_NAME);
        intent.setClassName(this.PACKAGE_NAME, this.CLASS_NAME);
        if (context.bindService(intent, this.mConnection, 1)) {
            Log.i(TAG, "binding success");
        } else {
            Log.i(TAG, "binding failure");
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.ISetting
    public void cancel(String str, ISamsungCloudRPCCallback iSamsungCloudRPCCallback) {
        try {
            Log.i(TAG, "cancel");
            this.iSamsungCloudRPC.cancel(str, iSamsungCloudRPCCallback);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.ISetting
    public void close(Context context) {
        try {
            context.unbindService(this.mConnection);
            Log.i(TAG, "unbindService: success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.ISetting
    public Bundle getProfile(String str, SamsungCloudRPCProfile samsungCloudRPCProfile) {
        try {
            Log.i(TAG, "getProfile");
            return this.iSamsungCloudRPC.getProfile(str, samsungCloudRPCProfile);
        } catch (Exception e) {
            e.printStackTrace();
            Bundle bundle = new Bundle();
            bundle.putString("rcode", String.valueOf(SamsungCloudRPCStatus.Value.FAILED_INTERNAL_AGENT_ERROR));
            return bundle;
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.ISetting
    public void showSetting(String str) {
        try {
            Log.i(TAG, "showSetting");
            this.iSamsungCloudRPC.showSetting(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.ISetting
    public void start(String str, ISamsungCloudRPCCallback iSamsungCloudRPCCallback) {
        try {
            Log.i(TAG, "start");
            this.iSamsungCloudRPC.start(str, iSamsungCloudRPCCallback);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.ISetting
    public Bundle switchOnOff(String str, int i) {
        try {
            Log.i(TAG, "switchOnOff");
            return this.iSamsungCloudRPC.switchOnOff(str, i);
        } catch (Exception e) {
            e.printStackTrace();
            Bundle bundle = new Bundle();
            bundle.putString("rcode", String.valueOf(SamsungCloudRPCStatus.Value.FAILED_INTERNAL_AGENT_ERROR));
            return bundle;
        }
    }

    public SyncSetting(Context context, String str, SamsungCloudRPCStatus samsungCloudRPCStatus) {
        TAG = str;
        this.samsungCloudRPCStatus = samsungCloudRPCStatus;
        Intent intent = new Intent(this.ACTION_NAME);
        intent.setClassName(this.PACKAGE_NAME, this.CLASS_NAME);
        if (context.bindService(intent, this.mConnection, 1)) {
            Log.i(TAG, "binding success");
        } else {
            samsungCloudRPCStatus.onBind(false);
            Log.i(TAG, "binding failure");
        }
    }
}
