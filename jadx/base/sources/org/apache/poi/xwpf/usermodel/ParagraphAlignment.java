package org.apache.poi.xwpf.usermodel;

import java.util.HashMap;
import java.util.Map;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public enum ParagraphAlignment {
    LEFT(1),
    CENTER(2),
    RIGHT(3),
    BOTH(4),
    MEDIUM_KASHIDA(5),
    DISTRIBUTE(6),
    NUM_TAB(7),
    HIGH_KASHIDA(8),
    LOW_KASHIDA(9),
    THAI_DISTRIBUTE(10);

    private static Map<Integer, ParagraphAlignment> imap = new HashMap();
    private final int value;

    static {
        for (ParagraphAlignment paragraphAlignment : values()) {
            imap.put(Integer.valueOf(paragraphAlignment.getValue()), paragraphAlignment);
        }
    }

    ParagraphAlignment(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static ParagraphAlignment valueOf(int i) {
        ParagraphAlignment paragraphAlignment = imap.get(Integer.valueOf(i));
        if (paragraphAlignment != null) {
            return paragraphAlignment;
        }
        throw new IllegalArgumentException(AbstractC0000a.m11h(i, "Unknown paragraph alignment: "));
    }
}
