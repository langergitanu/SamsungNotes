package com.samsung.android.scloud.lib.setting;

import android.app.Activity;
import android.os.Bundle;
import com.samsung.android.scloud.rpc.SamsungCloudRPCStatusObserver;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
interface ISyncSetting {
    void addSyncStatusObserver(SamsungCloudRPCStatusObserver samsungCloudRPCStatusObserver, String str);

    void cancelSync();

    boolean getAutoSync();

    boolean getContentSync(String str);

    int getEdpState();

    int getNetworkOption();

    Bundle getProfile();

    boolean isSyncActive();

    void loadPerformancePolicy();

    void notifySupportedStatus(boolean z);

    void notifySyncStatus(String str, int i);

    void removeSyncStatusObserver();

    void requestFastSync(ArrayList<String> arrayList);

    void requestLocalSync(List<String> list);

    void requestSingleRecordDownload(Bundle bundle);

    void requestSync();

    void requestSync(ArrayList<String> arrayList, boolean z);

    void setAutoSync(boolean z);

    void setNetworkOption(int i);

    void showSetting();

    void showSetting(int i);

    void showSetting(Activity activity, int i);
}
