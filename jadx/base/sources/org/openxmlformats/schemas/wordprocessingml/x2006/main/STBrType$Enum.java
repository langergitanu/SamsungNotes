package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: classes11.dex */
public final class STBrType$Enum extends StringEnumAbstractBase {
    static final int INT_COLUMN = 2;
    static final int INT_PAGE = 1;
    static final int INT_TEXT_WRAPPING = 3;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STBrType$Enum[]{new STBrType$Enum("page", 1), new STBrType$Enum("column", 2), new STBrType$Enum("textWrapping", 3)});

    private STBrType$Enum(String str, int i) {
        super(str, i);
    }

    public static STBrType$Enum forInt(int i) {
        return (STBrType$Enum) table.forInt(i);
    }

    public static STBrType$Enum forString(String str) {
        return (STBrType$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
