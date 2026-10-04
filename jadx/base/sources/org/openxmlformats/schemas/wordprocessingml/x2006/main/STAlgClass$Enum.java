package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: classes11.dex */
public final class STAlgClass$Enum extends StringEnumAbstractBase {
    static final int INT_HASH = 1;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STAlgClass$Enum[]{new STAlgClass$Enum("hash", 1)});

    private STAlgClass$Enum(String str, int i) {
        super(str, i);
    }

    public static STAlgClass$Enum forInt(int i) {
        return (STAlgClass$Enum) table.forInt(i);
    }

    public static STAlgClass$Enum forString(String str) {
        return (STAlgClass$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
