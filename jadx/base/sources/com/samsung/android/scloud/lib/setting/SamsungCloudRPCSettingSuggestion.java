package com.samsung.android.scloud.lib.setting;

import android.content.Context;
import android.net.Uri;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class SamsungCloudRPCSettingSuggestion {
    private static final String TAG = "[scsettingv2suggestion][2.0.33.0]";
    private ISettingSuggestion settingSuggestion;

    public SamsungCloudRPCSettingSuggestion(Context context) {
        this.settingSuggestion = new SettingSuggestionProviderClient(context, TAG);
    }

    public int getStatus(String str) {
        return this.settingSuggestion.getStatus(str);
    }

    public int getStatusByTag(String str) {
        return this.settingSuggestion.getStatusByTag(str);
    }

    public Uri getStatusChangedUri(String str) {
        return this.settingSuggestion.getStatusChangedUri(str);
    }

    public ArrayList<String> getStatusIds(String str) {
        return this.settingSuggestion.getStatusIds(str);
    }
}
