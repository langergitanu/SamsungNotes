package com.microsoft.schemas.vml;

import com.google.android.gms.common.data.AbstractC4539a;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlString;

/* JADX INFO: loaded from: classes6.dex */
public interface STTrueFalse extends XmlString {
    public static final int INT_F = 2;
    public static final int INT_FALSE = 4;
    public static final int INT_T = 1;
    public static final int INT_TRUE = 3;
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STTrueFalse.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "sttruefalse4ab9type");

    /* JADX INFO: renamed from: T */
    public static final Enum f3618T = Enum.forString("t");

    /* JADX INFO: renamed from: F */
    public static final Enum f3617F = Enum.forString("f");
    public static final Enum TRUE = Enum.forString("true");
    public static final Enum FALSE = Enum.forString("false");

    public static final class Enum extends StringEnumAbstractBase {
        static final int INT_F = 2;
        static final int INT_FALSE = 4;
        static final int INT_T = 1;
        static final int INT_TRUE = 3;
        private static final long serialVersionUID = 1;
        public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("t", 1), new Enum("f", 2), new Enum("true", 3), new Enum("false", 4)});

        private Enum(String str, int i) {
            super(str, i);
        }

        public static Enum forInt(int i) {
            return (Enum) table.forInt(i);
        }

        public static Enum forString(String str) {
            return (Enum) table.forString(str);
        }

        private Object readResolve() {
            return forInt(intValue());
        }
    }

    StringEnumAbstractBase enumValue();

    void set(StringEnumAbstractBase stringEnumAbstractBase);
}
