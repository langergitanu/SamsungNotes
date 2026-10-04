package org.apache.poi.xwpf.usermodel;

import java.util.HashMap;
import java.util.Map;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public enum BreakClear {
    NONE(1),
    LEFT(2),
    RIGHT(3),
    ALL(4);

    private static Map<Integer, BreakClear> imap = new HashMap();
    private final int value;

    static {
        for (BreakClear breakClear : values()) {
            imap.put(Integer.valueOf(breakClear.getValue()), breakClear);
        }
    }

    BreakClear(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static BreakClear valueOf(int i) {
        BreakClear breakClear = imap.get(Integer.valueOf(i));
        if (breakClear != null) {
            return breakClear;
        }
        throw new IllegalArgumentException(AbstractC0000a.m11h(i, "Unknown break clear type: "));
    }
}
