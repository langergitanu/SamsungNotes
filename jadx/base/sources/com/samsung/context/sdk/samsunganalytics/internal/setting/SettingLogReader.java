package com.samsung.context.sdk.samsunganalytics.internal.setting;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.context.sdk.samsunganalytics.internal.policy.Validation;
import com.samsung.context.sdk.samsunganalytics.internal.util.Preferences;
import com.samsung.context.sdk.samsunganalytics.internal.util.Utils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class SettingLogReader {
    private static final int STATUS_LOG_BODY_LENGTH_LIMIT = 512;
    private final Set<String> appPrefNames;
    private final Context context;
    private final String threeDepthCollectionDelimiter;
    private final String twoDepthCollectionDelimiter;
    private final String twoDepthKeyValueDelimiter;

    public SettingLogReader(Context context) {
        this.context = context;
        this.appPrefNames = Preferences.getPreferences(context).getStringSet(Preferences.APP_PREF_NAMES, new HashSet());
        Utils.Depth depth = Utils.Depth.TWO_DEPTH;
        this.twoDepthKeyValueDelimiter = depth.getKeyValueDLM();
        this.twoDepthCollectionDelimiter = depth.getCollectionDLM();
        this.threeDepthCollectionDelimiter = Utils.Depth.THREE_DEPTH.getCollectionDLM();
    }

    private String convertSetToString(Set<String> set) {
        String strM756B = "";
        for (String str : set) {
            if (!TextUtils.isEmpty(strM756B)) {
                StringBuilder sbM1324q = AbstractC1974b.m1324q(strM756B);
                sbM1324q.append(this.threeDepthCollectionDelimiter);
                strM756B = sbM1324q.toString();
            }
            strM756B = AbstractC0541b.m756B(strM756B, str);
            if (strM756B.length() >= 1024) {
                break;
            }
        }
        return strM756B;
    }

    private Map<String, String> getKeyValues(String str) {
        TreeMap treeMap = new TreeMap();
        Iterator<String> it = Preferences.getPreferences(this.context).getStringSet(str, new HashSet()).iterator();
        while (it.hasNext()) {
            String[] strArrSplit = it.next().split(this.threeDepthCollectionDelimiter, 2);
            treeMap.put(strArrSplit[0], strArrSplit.length == 2 ? strArrSplit[1] : "");
        }
        return treeMap;
    }

    private SharedPreferences getPreference(String str) {
        return this.context.getSharedPreferences(str, 0);
    }

    public List<String> read() {
        if (this.appPrefNames.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        String strM756B = "";
        for (String str : this.appPrefNames) {
            Map<String, ?> all = getPreference(str).getAll();
            for (Map.Entry<String, String> entry : getKeyValues(str).entrySet()) {
                Object obj = all.get(entry.getKey());
                String strM1170p = AbstractC0622a.m1170p(this.twoDepthKeyValueDelimiter, Validation.checkSizeLimit(obj == null ? entry.getValue() : !(obj instanceof Set) ? String.valueOf(obj) : convertSetToString((Set) obj), 1024), AbstractC1974b.m1324q(Validation.checkSizeLimit(entry.getKey(), 100)));
                if (!TextUtils.isEmpty(strM756B)) {
                    if (strM1170p.length() + strM756B.length() > 512) {
                        arrayList.add(strM756B);
                        strM756B = "";
                    } else {
                        StringBuilder sbM1324q = AbstractC1974b.m1324q(strM756B);
                        sbM1324q.append(this.twoDepthCollectionDelimiter);
                        strM756B = sbM1324q.toString();
                    }
                }
                strM756B = AbstractC0541b.m756B(strM756B, strM1170p);
            }
        }
        if (!strM756B.isEmpty()) {
            arrayList.add(strM756B);
        }
        return arrayList;
    }
}
