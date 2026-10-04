package com.samsung.context.sdk.samsunganalytics.internal.setting;

import android.content.Context;
import android.content.SharedPreferences;
import com.samsung.context.sdk.samsunganalytics.internal.util.Debug;
import com.samsung.context.sdk.samsunganalytics.internal.util.Preferences;
import com.samsung.context.sdk.samsunganalytics.internal.util.Utils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SettingLogRegister {
    private final Context context;

    public SettingLogRegister(Context context) {
        this.context = context;
    }

    public void registerLog(Map<String, Set<String>> map) {
        Debug.LogI("register setting status");
        SharedPreferences preferences = Preferences.getPreferences(this.context);
        Set<String> stringSet = preferences.getStringSet(Preferences.APP_PREF_NAMES, new HashSet());
        HashSet hashSet = new HashSet();
        if (Utils.isAppVersionChanged(this.context, Preferences.PREFS_KEY_APP_VERSION_FOR_SETTING)) {
            Iterator<String> it = stringSet.iterator();
            while (it.hasNext()) {
                preferences.edit().remove(it.next()).apply();
            }
            preferences.edit().remove(Preferences.APP_PREF_NAMES).apply();
        } else {
            hashSet.addAll(stringSet);
        }
        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            String key = entry.getKey();
            hashSet.add(key);
            HashSet hashSet2 = new HashSet();
            hashSet2.addAll(preferences.getStringSet(key, new HashSet()));
            hashSet2.addAll(entry.getValue());
            preferences.edit().putStringSet(key, hashSet2).apply();
        }
        preferences.edit().putStringSet(Preferences.APP_PREF_NAMES, hashSet).apply();
    }
}
