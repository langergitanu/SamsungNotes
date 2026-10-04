package org.apache.poi.xwpf.usermodel;

import java.util.HashMap;
import java.util.Map;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public enum LineSpacingRule {
    AUTO(1),
    EXACT(2),
    AT_LEAST(3);

    private static Map<Integer, LineSpacingRule> imap = new HashMap();
    private final int value;

    static {
        for (LineSpacingRule lineSpacingRule : values()) {
            imap.put(Integer.valueOf(lineSpacingRule.getValue()), lineSpacingRule);
        }
    }

    LineSpacingRule(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }

    public static LineSpacingRule valueOf(int i) {
        LineSpacingRule lineSpacingRule = imap.get(Integer.valueOf(i));
        if (lineSpacingRule != null) {
            return lineSpacingRule;
        }
        throw new IllegalArgumentException(AbstractC0000a.m11h(i, "Unknown line type: "));
    }
}
