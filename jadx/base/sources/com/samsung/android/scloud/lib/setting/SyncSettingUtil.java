package com.samsung.android.scloud.lib.setting;

import android.os.Bundle;
import com.samsung.android.scloud.lib.setting.RPCSyncSettingContract;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
class SyncSettingUtil {
    public static Bundle getRequestExtra(String str) {
        return getRequestExtra(str, true);
    }

    public static Bundle getRequestExtra(String str, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putString("authority", str);
        bundle.putLong("library_version", RPCSyncSettingContract.Version.EDP_SUPPORTED_VERSION);
        bundle.putBoolean(RPCSyncSettingContract.Parameter.IS_SYNC_SETTING_REQUIRED, z);
        return bundle;
    }
}
