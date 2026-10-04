package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: classes11.dex */
public final class STCryptProv$Enum extends StringEnumAbstractBase {
    static final int INT_RSA_AES = 1;
    static final int INT_RSA_FULL = 2;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STCryptProv$Enum[]{new STCryptProv$Enum("rsaAES", 1), new STCryptProv$Enum("rsaFull", 2)});

    private STCryptProv$Enum(String str, int i) {
        super(str, i);
    }

    public static STCryptProv$Enum forInt(int i) {
        return (STCryptProv$Enum) table.forInt(i);
    }

    public static STCryptProv$Enum forString(String str) {
        return (STCryptProv$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
