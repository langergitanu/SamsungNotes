package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: classes11.dex */
public final class STJc$Enum extends StringEnumAbstractBase {
    static final int INT_BOTH = 4;
    static final int INT_CENTER = 2;
    static final int INT_DISTRIBUTE = 6;
    static final int INT_HIGH_KASHIDA = 8;
    static final int INT_LEFT = 1;
    static final int INT_LOW_KASHIDA = 9;
    static final int INT_MEDIUM_KASHIDA = 5;
    static final int INT_NUM_TAB = 7;
    static final int INT_RIGHT = 3;
    static final int INT_THAI_DISTRIBUTE = 10;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STJc$Enum[]{new STJc$Enum("left", 1), new STJc$Enum("center", 2), new STJc$Enum("right", 3), new STJc$Enum("both", 4), new STJc$Enum("mediumKashida", 5), new STJc$Enum("distribute", 6), new STJc$Enum("numTab", 7), new STJc$Enum("highKashida", 8), new STJc$Enum("lowKashida", 9), new STJc$Enum("thaiDistribute", 10)});

    private STJc$Enum(String str, int i) {
        super(str, i);
    }

    public static STJc$Enum forInt(int i) {
        return (STJc$Enum) table.forInt(i);
    }

    public static STJc$Enum forString(String str) {
        return (STJc$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
