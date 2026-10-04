package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: classes11.dex */
public final class STBrClear$Enum extends StringEnumAbstractBase {
    static final int INT_ALL = 4;
    static final int INT_LEFT = 2;
    static final int INT_NONE = 1;
    static final int INT_RIGHT = 3;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STBrClear$Enum[]{new STBrClear$Enum("none", 1), new STBrClear$Enum("left", 2), new STBrClear$Enum("right", 3), new STBrClear$Enum("all", 4)});

    private STBrClear$Enum(String str, int i) {
        super(str, i);
    }

    public static STBrClear$Enum forInt(int i) {
        return (STBrClear$Enum) table.forInt(i);
    }

    public static STBrClear$Enum forString(String str) {
        return (STBrClear$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
