package com.samsung.context.sdk.samsunganalytics.internal.property;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.samsung.context.sdk.samsunganalytics.internal.util.Preferences;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class PropertyLogRegister {
    private final Context context;

    public PropertyLogRegister(Context context) {
        this.context = context;
    }

    public void registerLog(Map<String, String> map) {
        map.remove("t");
        SharedPreferences propertyPreferences = Preferences.getPropertyPreferences(this.context);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (TextUtils.isEmpty(entry.getValue())) {
                propertyPreferences.edit().remove(entry.getKey()).apply();
            } else {
                propertyPreferences.edit().putString(entry.getKey(), entry.getValue()).apply();
            }
        }
    }
}
