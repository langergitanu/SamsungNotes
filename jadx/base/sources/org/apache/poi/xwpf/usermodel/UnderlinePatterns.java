package org.apache.poi.xwpf.usermodel;

import java.util.HashMap;
import java.util.Map;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public enum UnderlinePatterns {
    SINGLE(1),
    WORDS(2),
    DOUBLE(3),
    THICK(4),
    DOTTED(5),
    DOTTED_HEAVY(6),
    DASH(7),
    DASHED_HEAVY(8),
    DASH_LONG(9),
    DASH_LONG_HEAVY(10),
    DOT_DASH(11),
    DASH_DOT_HEAVY(12),
    DOT_DOT_DASH(13),
    DASH_DOT_DOT_HEAVY(14),
    WAVE(15),
    WAVY_HEAVY(16),
    WAVY_DOUBLE(17),
    NONE(18);

    private static Map<Integer, UnderlinePatterns> imap = new HashMap();
    private final int value;

    static {
        for (UnderlinePatterns underlinePatterns : values()) {
            imap.put(Integer.valueOf(underlinePatterns.getValue()), underlinePatterns);
        }
    }

    UnderlinePatterns(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static UnderlinePatterns valueOf(int i) {
        UnderlinePatterns underlinePatterns = imap.get(Integer.valueOf(i));
        if (underlinePatterns != null) {
            return underlinePatterns;
        }
        throw new IllegalArgumentException(AbstractC0000a.m11h(i, "Unknown underline pattern: "));
    }
}
