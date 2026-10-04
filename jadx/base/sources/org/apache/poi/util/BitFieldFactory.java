package org.apache.poi.util;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class BitFieldFactory {
    private static Map<Integer, BitField> instances = new HashMap();

    public static BitField getInstance(int i) {
        BitField bitField = instances.get(Integer.valueOf(i));
        if (bitField != null) {
            return bitField;
        }
        BitField bitField2 = new BitField(i);
        instances.put(Integer.valueOf(i), bitField2);
        return bitField2;
    }
}
