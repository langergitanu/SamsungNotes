package com.samsung.android.scloud.lib.setting;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.samsung.android.scloud.lib.setting.RPCSyncSettingContract;
import com.samsung.android.scloud.rpc.SamsungCloudRPCStatusObserver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SamsungCloudRPCSettingV2 implements ISamsungCloudRPCSettingV2 {
    private static final String TAG = "[scsettingv2][2.0.33.0]";
    private ISyncSetting iSyncSetting;

    public SamsungCloudRPCSettingV2(Context context, String str, String str2) {
        this.iSyncSetting = new SyncSettingProviderClient(context, RPCSyncSettingContract.Method.CONTENT_URI, str, str2, TAG);
    }

    @Override // com.samsung.android.scloud.lib.setting.ISamsungCloudRPCSettingV2
    public void addSyncStatusObserver(SamsungCloudRPCStatusObserver samsungCloudRPCStatusObserver) {
        ISyncSetting iSyncSetting = this.iSyncSetting;
        if (iSyncSetting != null) {
            iSyncSetting.addSyncStatusObserver(samsungCloudRPCStatusObserver, RPCSyncSettingContract.MetaData.SETTING_LIB_PROVIDER);
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.ISamsungCloudRPCSettingV2
    public void cancelSync() {
        ISyncSetting iSyncSetting = this.iSyncSetting;
        if (iSyncSetting != null) {
            iSyncSetting.cancelSync();
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.ISamsungCloudRPCSettingV2
    public boolean getAutoSync() {
        return this.iSyncSetting.getAutoSync();
    }

    @Override // com.samsung.android.scloud.lib.setting.ISamsungCloudRPCSettingV2
    public boolean getContentSync(String str) {
        return this.iSyncSetting.getContentSync(str);
    }

    @Override // com.samsung.android.scloud.lib.setting.ISamsungCloudRPCSettingV2
    public int getNetworkOption() {
        return this.iSyncSetting.getNetworkOption();
    }

    @Override // com.samsung.android.scloud.lib.setting.ISamsungCloudRPCSettingV2
    public Bundle getProfile() {
        return this.iSyncSetting.getProfile();
    }

    @Override // com.samsung.android.scloud.lib.setting.ISamsungCloudRPCSettingV2
    public boolean isSyncActive() {
        return this.iSyncSetting.isSyncActive();
    }

    @Override // com.samsung.android.scloud.lib.setting.ISamsungCloudRPCSettingV2
    public void loadPerformancePolicy() {
        this.iSyncSetting.loadPerformancePolicy();
    }

    @Override // com.samsung.android.scloud.lib.setting.ISamsungCloudRPCSettingV2
    public void notifySupportedChanged(boolean z) {
        ISyncSetting iSyncSetting = this.iSyncSetting;
        if (iSyncSetting != null) {
            iSyncSetting.notifySupportedStatus(z);
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.ISamsungCloudRPCSettingV2
    public void removeSyncStatusObserver() {
        ISyncSetting iSyncSetting = this.iSyncSetting;
        if (iSyncSetting != null) {
            iSyncSetting.removeSyncStatusObserver();
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.ISamsungCloudRPCSettingV2
    public void requestFastSync(ArrayList<String> arrayList) {
        ISyncSetting iSyncSetting = this.iSyncSetting;
        if (iSyncSetting != null) {
            iSyncSetting.requestFastSync(arrayList);
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.ISamsungCloudRPCSettingV2
    public void requestLocalSync(String str) {
        ISyncSetting iSyncSetting = this.iSyncSetting;
        if (iSyncSetting != null) {
            iSyncSetting.requestLocalSync(Collections.singletonList(str));
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.ISamsungCloudRPCSettingV2
    public void requestSingleRecordDownload(Bundle bundle) {
        ISyncSetting iSyncSetting = this.iSyncSetting;
        if (iSyncSetting != null) {
            iSyncSetting.requestSingleRecordDownload(bundle);
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.ISamsungCloudRPCSettingV2
    public void requestSync() {
        ISyncSetting iSyncSetting = this.iSyncSetting;
        if (iSyncSetting != null) {
            iSyncSetting.requestSync();
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.ISamsungCloudRPCSettingV2
    public void setAutoSync(boolean z) {
        ISyncSetting iSyncSetting = this.iSyncSetting;
        if (iSyncSetting != null) {
            iSyncSetting.setAutoSync(z);
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.ISamsungCloudRPCSettingV2
    public void setNetworkOption(int i) {
        ISyncSetting iSyncSetting = this.iSyncSetting;
        if (iSyncSetting != null) {
            iSyncSetting.setNetworkOption(i);
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.ISamsungCloudRPCSettingV2
    public void showSetting() {
        ISyncSetting iSyncSetting = this.iSyncSetting;
        if (iSyncSetting != null) {
            iSyncSetting.showSetting();
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.ISamsungCloudRPCSettingV2
    public void requestSync(ArrayList<String> arrayList, boolean z) {
        ISyncSetting iSyncSetting = this.iSyncSetting;
        if (iSyncSetting != null) {
            iSyncSetting.requestSync(arrayList, z);
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.ISamsungCloudRPCSettingV2
    public void showSetting(int i) {
        ISyncSetting iSyncSetting = this.iSyncSetting;
        if (iSyncSetting != null) {
            iSyncSetting.showSetting(i);
        }
    }

    public SamsungCloudRPCSettingV2(Context context, Uri uri, String str, String str2) {
        this.iSyncSetting = new SyncSettingProviderClient(context, uri, str, str2, TAG);
    }

    @Override // com.samsung.android.scloud.lib.setting.ISamsungCloudRPCSettingV2
    public void requestLocalSync(List<String> list) {
        ISyncSetting iSyncSetting = this.iSyncSetting;
        if (iSyncSetting != null) {
            iSyncSetting.requestLocalSync(list);
        }
    }

    @Override // com.samsung.android.scloud.lib.setting.ISamsungCloudRPCSettingV2
    public void showSetting(Activity activity, int i) {
        ISyncSetting iSyncSetting = this.iSyncSetting;
        if (iSyncSetting != null) {
            iSyncSetting.showSetting(activity, i);
        }
    }
}
