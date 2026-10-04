package org.apache.poi.xwpf.usermodel;

import java.util.HashMap;
import java.util.Map;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public enum BreakType {
    PAGE(1),
    COLUMN(2),
    TEXT_WRAPPING(3);

    private static Map<Integer, BreakType> imap = new HashMap();
    private final int value;

    static {
        for (BreakType breakType : values()) {
            imap.put(Integer.valueOf(breakType.getValue()), breakType);
        }
    }

    BreakType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static BreakType valueOf(int i) {
        BreakType breakType = imap.get(Integer.valueOf(i));
        if (breakType != null) {
            return breakType;
        }
        throw new IllegalArgumentException(AbstractC0000a.m11h(i, "Unknown break type: "));
    }
}
