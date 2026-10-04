package com.samsung.android.scloud.lib.setting;

import android.content.Context;
import android.os.Bundle;
import com.samsung.android.scloud.rpc.ISamsungCloudRPCCallback;
import com.samsung.android.scloud.rpc.SamsungCloudRPCCallback;
import com.samsung.android.scloud.rpc.SamsungCloudRPCProfile;
import com.samsung.android.scloud.rpc.SamsungCloudRPCStatus;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SamsungCloudRPCSetting {
    public static String SYNC = "SYNC";
    private static final String TAG = "[scsetting][2.0.33.0]";
    private ISetting iSetting;

    public SamsungCloudRPCSetting(Context context, String str) {
        if (SYNC.equals(str)) {
            this.iSetting = new SyncSetting(context, TAG);
        }
    }

    public void cancel(String str, final SamsungCloudRPCCallback samsungCloudRPCCallback) {
        this.iSetting.cancel(str, new ISamsungCloudRPCCallback.Stub() { // from class: com.samsung.android.scloud.lib.setting.SamsungCloudRPCSetting.2
            @Override // com.samsung.android.scloud.rpc.ISamsungCloudRPCCallback
            public void onComplete(String str2, Bundle bundle) {
                samsungCloudRPCCallback.onComplete(str2, bundle);
            }

            @Override // com.samsung.android.scloud.rpc.ISamsungCloudRPCCallback
            public void onProgress(String str2, int i) {
                samsungCloudRPCCallback.onProgress(str2, i);
            }

            @Override // com.samsung.android.scloud.rpc.ISamsungCloudRPCCallback
            public void onStart(String str2) {
                samsungCloudRPCCallback.onStart(str2);
            }
        });
    }

    public void close(Context context) {
        this.iSetting.close(context);
    }

    public Bundle getProfile(String str, SamsungCloudRPCProfile samsungCloudRPCProfile) {
        return this.iSetting.getProfile(str, samsungCloudRPCProfile);
    }

    public void showSetting(String str) {
        this.iSetting.showSetting(str);
    }

    public void start(String str, final SamsungCloudRPCCallback samsungCloudRPCCallback) {
        this.iSetting.start(str, new ISamsungCloudRPCCallback.Stub() { // from class: com.samsung.android.scloud.lib.setting.SamsungCloudRPCSetting.1
            @Override // com.samsung.android.scloud.rpc.ISamsungCloudRPCCallback
            public void onComplete(String str2, Bundle bundle) {
                samsungCloudRPCCallback.onComplete(str2, bundle);
            }

            @Override // com.samsung.android.scloud.rpc.ISamsungCloudRPCCallback
            public void onProgress(String str2, int i) {
                samsungCloudRPCCallback.onProgress(str2, i);
            }

            @Override // com.samsung.android.scloud.rpc.ISamsungCloudRPCCallback
            public void onStart(String str2) {
                samsungCloudRPCCallback.onStart(str2);
            }
        });
    }

    public Bundle switchOnOff(String str, int i) {
        return this.iSetting.switchOnOff(str, i);
    }

    public SamsungCloudRPCSetting(Context context, SamsungCloudRPCStatus samsungCloudRPCStatus) {
        if ("SYNC".equals(samsungCloudRPCStatus.getServiceType())) {
            this.iSetting = new SyncSetting(context, TAG, samsungCloudRPCStatus);
        }
    }
}
