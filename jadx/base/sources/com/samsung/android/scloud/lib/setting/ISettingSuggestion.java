package com.samsung.android.scloud.lib.setting;

import android.net.Uri;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
interface ISettingSuggestion {
    int getStatus(String str);

    int getStatusByTag(String str);

    Uri getStatusChangedUri(String str);

    ArrayList<String> getStatusIds(String str);
}
