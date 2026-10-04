package com.samsung.android.scloud.lib.setting;

import android.content.Context;
import android.os.Bundle;
import com.samsung.android.scloud.lib.setting.RPCSyncSettingContract;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SamsungCloudRPCSettingStatus {
    private static final String TAG = "[scsettingstatus][2.0.33.0]";
    private ISyncSummary iSyncSummary;

    public SamsungCloudRPCSettingStatus(Context context) {
        this.iSyncSummary = new SyncSettingProviderClient(context, RPCSyncSettingContract.Method.CONTENT_URI, RPCSyncSettingContract.Authority.Setting, null, 2, TAG);
    }

    public boolean getAutoSync(String str) {
        ISyncSummary iSyncSummary = this.iSyncSummary;
        if (iSyncSummary != null) {
            return iSyncSummary.getAutoSync(str);
        }
        return false;
    }

    public Bundle getProfile() {
        return this.iSyncSummary.getProfile();
    }

    public ArrayList<String> getSyncableAppList() {
        ISyncSummary iSyncSummary = this.iSyncSummary;
        return iSyncSummary != null ? iSyncSummary.getSyncableAppList() : new ArrayList<>();
    }

    public void showSetting() {
        ISyncSummary iSyncSummary = this.iSyncSummary;
        if (iSyncSummary != null) {
            iSyncSummary.showSetting();
        }
    }
}
