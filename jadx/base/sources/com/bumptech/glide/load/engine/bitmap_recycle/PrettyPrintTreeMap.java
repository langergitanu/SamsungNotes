package com.bumptech.glide.load.engine.bitmap_recycle;

import androidx.compose.runtime.AbstractC1974b;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
class PrettyPrintTreeMap<K, V> extends TreeMap<K, V> {
    @Override // java.util.AbstractMap
    public String toString() {
        StringBuilder sbM1324q = AbstractC1974b.m1324q("( ");
        for (Map.Entry<K, V> entry : entrySet()) {
            sbM1324q.append('{');
            sbM1324q.append(entry.getKey());
            sbM1324q.append(':');
            sbM1324q.append(entry.getValue());
            sbM1324q.append("}, ");
        }
        if (!isEmpty()) {
            sbM1324q.replace(sbM1324q.length() - 2, sbM1324q.length(), "");
        }
        sbM1324q.append(" )");
        return sbM1324q.toString();
    }
}
