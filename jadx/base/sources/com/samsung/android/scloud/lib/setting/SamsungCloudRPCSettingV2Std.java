package com.samsung.android.scloud.lib.setting;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.samsung.android.scloud.lib.setting.RPCSyncSettingContract;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SamsungCloudRPCSettingV2Std implements ISamsungCloudRPCSettingV2Std {
    private static final String TAG = "[scsettingv2std][2.0.33.0]";
    private ISyncSetting iSyncSetting;

    public SamsungCloudRPCSettingV2Std(Context context, String str, String str2) {
        this.iSyncSetting = new SyncSettingProviderClient(context, RPCSyncSettingContract.Method.CONTENT_URI, str, str2, TAG);
    }

    @Override // com.samsung.android.scloud.lib.setting.ISamsungCloudRPCSettingV2Std
    public Bundle getProfile() {
        return this.iSyncSetting.getProfile();
    }

    @Override // com.samsung.android.scloud.lib.setting.ISamsungCloudRPCSettingV2Std
    public void notifyAutoSyncChanged(boolean z) {
        ISyncSetting iSyncSetting = this.iSyncSetting;
        if (iSyncSetting != null) {
            iSyncSetting.setAutoSync(z);
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.ISamsungCloudRPCSettingV2Std
    public void notifyNetworkOptionChanged(int i) {
        ISyncSetting iSyncSetting = this.iSyncSetting;
        if (iSyncSetting != null) {
            iSyncSetting.setNetworkOption(i);
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.ISamsungCloudRPCSettingV2Std
    public void notifySupportedChanged(boolean z) {
        ISyncSetting iSyncSetting = this.iSyncSetting;
        if (iSyncSetting != null) {
            iSyncSetting.notifySupportedStatus(z);
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.ISamsungCloudRPCSettingV2Std
    public void notifySyncStatusChanged(String str, int i) {
        ISyncSetting iSyncSetting = this.iSyncSetting;
        if (iSyncSetting != null) {
            iSyncSetting.notifySyncStatus(str, i);
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.ISamsungCloudRPCSettingV2Std
    public void showSetting() {
        ISyncSetting iSyncSetting = this.iSyncSetting;
        if (iSyncSetting != null) {
            iSyncSetting.showSetting();
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.ISamsungCloudRPCSettingV2Std
    public void showSetting(int i) {
        ISyncSetting iSyncSetting = this.iSyncSetting;
        if (iSyncSetting != null) {
            iSyncSetting.showSetting(i);
        }
    }

    public SamsungCloudRPCSettingV2Std(Context context, Uri uri, String str, String str2) {
        this.iSyncSetting = new SyncSettingProviderClient(context, uri, str, str2, TAG);
    }

    @Override // com.samsung.android.scloud.lib.setting.ISamsungCloudRPCSettingV2Std
    public void showSetting(Activity activity, int i) {
        ISyncSetting iSyncSetting = this.iSyncSetting;
        if (iSyncSetting != null) {
            iSyncSetting.showSetting(activity, i);
        }
    }
}
