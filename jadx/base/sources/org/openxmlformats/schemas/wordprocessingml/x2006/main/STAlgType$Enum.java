package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: classes11.dex */
public final class STAlgType$Enum extends StringEnumAbstractBase {
    static final int INT_TYPE_ANY = 1;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STAlgType$Enum[]{new STAlgType$Enum("typeAny", 1)});

    private STAlgType$Enum(String str, int i) {
        super(str, i);
    }

    public static STAlgType$Enum forInt(int i) {
        return (STAlgType$Enum) table.forInt(i);
    }

    public static STAlgType$Enum forString(String str) {
        return (STAlgType$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
