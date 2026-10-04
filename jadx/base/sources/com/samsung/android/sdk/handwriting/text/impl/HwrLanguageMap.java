package com.samsung.android.sdk.handwriting.text.impl;

import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class HwrLanguageMap {
    private static final String TAG = "HwrLanguageMap";
    private static final Map<String, String> mHwrLocaleMap = new HashMap<String, String>() { // from class: com.samsung.android.sdk.handwriting.text.impl.HwrLanguageMap.1
        {
            put("en_IN", "en_GB");
        }
    };

    public static String getInternalLocale(String str) {
        Map<String, String> map = mHwrLocaleMap;
        if (!map.containsKey(str)) {
            return str;
        }
        String str2 = map.get(str);
        Log.i(TAG, AbstractC0541b.m775q("getInternalLocale : [", str, "] -> [", str2, "]"));
        return str2;
    }

    public static List<String> getModifiedLanguageList(List<String> list) {
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(list);
        for (Map.Entry<String, String> entry : mHwrLocaleMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (!list.contains(key) && list.contains(value)) {
                arrayList.add(entry.getKey());
            }
        }
        return arrayList;
    }
}
