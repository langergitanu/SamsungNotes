package com.samsung.android.scloud.lib.setting;

import android.app.Activity;
import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public interface ISamsungCloudRPCSettingV2Std {
    Bundle getProfile();

    void notifyAutoSyncChanged(boolean z);

    void notifyNetworkOptionChanged(int i);

    void notifySupportedChanged(boolean z);

    void notifySyncStatusChanged(String str, int i);

    void showSetting();

    void showSetting(int i);

    void showSetting(Activity activity, int i);
}
