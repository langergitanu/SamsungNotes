package com.samsung.android.scloud.lib.setting;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
interface ISyncSummary extends ISyncSetting {
    boolean getAutoSync(String str);

    ArrayList<String> getSyncableAppList();
}
