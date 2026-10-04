package org.apache.xmlbeans.impl.p229xb.xsdschema;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import kotlin.collections.AbstractC12991c;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface DerivationSet extends XmlAnySimpleType {
    public static final SchemaType type;

    /* JADX INFO: renamed from: org.apache.xmlbeans.impl.xb.xsdschema.DerivationSet$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    /* synthetic */ class C141941 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$DerivationSet;
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$DerivationSet$Member;

        /* JADX INFO: renamed from: class$org$apache$xmlbeans$impl$xb$xsdschema$DerivationSet$Member2 */
        static /* synthetic */ Class f10180xa0de8901;

        public static /* synthetic */ Class class$(String str) throws Throwable {
            try {
                return Class.forName(str);
            } catch (ClassNotFoundException e) {
                throw AbstractC12991c.m13994o(e);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Factory {
        private Factory() {
        }

        public static DerivationSet newInstance() {
            return (DerivationSet) XmlBeans.getContextTypeLoader().newInstance(DerivationSet.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, DerivationSet.type, null);
        }

        public static DerivationSet newValue(Object obj) {
            return (DerivationSet) DerivationSet.type.newValue(obj);
        }

        public static DerivationSet parse(String str) {
            return (DerivationSet) XmlBeans.getContextTypeLoader().parse(str, DerivationSet.type, (XmlOptions) null);
        }

        public static DerivationSet newInstance(XmlOptions xmlOptions) {
            return (DerivationSet) XmlBeans.getContextTypeLoader().newInstance(DerivationSet.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, DerivationSet.type, xmlOptions);
        }

        public static DerivationSet parse(String str, XmlOptions xmlOptions) {
            return (DerivationSet) XmlBeans.getContextTypeLoader().parse(str, DerivationSet.type, xmlOptions);
        }

        public static DerivationSet parse(File file) {
            return (DerivationSet) XmlBeans.getContextTypeLoader().parse(file, DerivationSet.type, (XmlOptions) null);
        }

        public static DerivationSet parse(File file, XmlOptions xmlOptions) {
            return (DerivationSet) XmlBeans.getContextTypeLoader().parse(file, DerivationSet.type, xmlOptions);
        }

        public static DerivationSet parse(URL url) {
            return (DerivationSet) XmlBeans.getContextTypeLoader().parse(url, DerivationSet.type, (XmlOptions) null);
        }

        public static DerivationSet parse(URL url, XmlOptions xmlOptions) {
            return (DerivationSet) XmlBeans.getContextTypeLoader().parse(url, DerivationSet.type, xmlOptions);
        }

        public static DerivationSet parse(InputStream inputStream) {
            return (DerivationSet) XmlBeans.getContextTypeLoader().parse(inputStream, DerivationSet.type, (XmlOptions) null);
        }

        public static DerivationSet parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (DerivationSet) XmlBeans.getContextTypeLoader().parse(inputStream, DerivationSet.type, xmlOptions);
        }

        public static DerivationSet parse(Reader reader) {
            return (DerivationSet) XmlBeans.getContextTypeLoader().parse(reader, DerivationSet.type, (XmlOptions) null);
        }

        public static DerivationSet parse(Reader reader, XmlOptions xmlOptions) {
            return (DerivationSet) XmlBeans.getContextTypeLoader().parse(reader, DerivationSet.type, xmlOptions);
        }

        public static DerivationSet parse(XMLStreamReader xMLStreamReader) {
            return (DerivationSet) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, DerivationSet.type, (XmlOptions) null);
        }

        public static DerivationSet parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (DerivationSet) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, DerivationSet.type, xmlOptions);
        }

        public static DerivationSet parse(Node node) {
            return (DerivationSet) XmlBeans.getContextTypeLoader().parse(node, DerivationSet.type, (XmlOptions) null);
        }

        public static DerivationSet parse(Node node, XmlOptions xmlOptions) {
            return (DerivationSet) XmlBeans.getContextTypeLoader().parse(node, DerivationSet.type, xmlOptions);
        }

        public static DerivationSet parse(XMLInputStream xMLInputStream) {
            return (DerivationSet) XmlBeans.getContextTypeLoader().parse(xMLInputStream, DerivationSet.type, (XmlOptions) null);
        }

        public static DerivationSet parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (DerivationSet) XmlBeans.getContextTypeLoader().parse(xMLInputStream, DerivationSet.type, xmlOptions);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Member extends XmlToken {
        public static final Enum ALL;
        public static final int INT_ALL = 1;
        public static final SchemaType type;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static final class Enum extends StringEnumAbstractBase {
            static final int INT_ALL = 1;
            private static final long serialVersionUID = 1;
            public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("#all", 1)});

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

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static final class Factory {
            private Factory() {
            }

            public static Member newInstance() {
                return (Member) XmlBeans.getContextTypeLoader().newInstance(Member.type, null);
            }

            public static Member newValue(Object obj) {
                return (Member) Member.type.newValue(obj);
            }

            public static Member newInstance(XmlOptions xmlOptions) {
                return (Member) XmlBeans.getContextTypeLoader().newInstance(Member.type, xmlOptions);
            }
        }

        static {
            Class clsClass$ = C141941.class$org$apache$xmlbeans$impl$xb$xsdschema$DerivationSet$Member;
            if (clsClass$ == null) {
                clsClass$ = C141941.class$("org.apache.xmlbeans.impl.xb.xsdschema.DerivationSet$Member");
                C141941.class$org$apache$xmlbeans$impl$xb$xsdschema$DerivationSet$Member = clsClass$;
            }
            type = (SchemaType) AbstractC4539a.m3202l(clsClass$, "schemaorg_apache_xmlbeans.system.sXMLSCHEMA", "anoned75type");
            ALL = Enum.forString("#all");
        }

        StringEnumAbstractBase enumValue();

        void set(StringEnumAbstractBase stringEnumAbstractBase);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Member2 extends XmlAnySimpleType {
        public static final SchemaType type;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static final class Factory {
            private Factory() {
            }

            public static Member2 newInstance() {
                return (Member2) XmlBeans.getContextTypeLoader().newInstance(Member2.type, null);
            }

            public static Member2 newValue(Object obj) {
                return (Member2) Member2.type.newValue(obj);
            }

            public static Member2 newInstance(XmlOptions xmlOptions) {
                return (Member2) XmlBeans.getContextTypeLoader().newInstance(Member2.type, xmlOptions);
            }
        }

        static {
            Class clsClass$ = C141941.f10180xa0de8901;
            if (clsClass$ == null) {
                clsClass$ = C141941.class$("org.apache.xmlbeans.impl.xb.xsdschema.DerivationSet$Member2");
                C141941.f10180xa0de8901 = clsClass$;
            }
            type = (SchemaType) AbstractC4539a.m3202l(clsClass$, "schemaorg_apache_xmlbeans.system.sXMLSCHEMA", "anon9394type");
        }

        List getListValue();

        List listValue();

        void set(List list);

        void setListValue(List list);

        List xgetListValue();

        List xlistValue();
    }

    static {
        Class clsClass$ = C141941.class$org$apache$xmlbeans$impl$xb$xsdschema$DerivationSet;
        if (clsClass$ == null) {
            clsClass$ = C141941.class$("org.apache.xmlbeans.impl.xb.xsdschema.DerivationSet");
            C141941.class$org$apache$xmlbeans$impl$xb$xsdschema$DerivationSet = clsClass$;
        }
        type = (SchemaType) AbstractC4539a.m3202l(clsClass$, "schemaorg_apache_xmlbeans.system.sXMLSCHEMA", "derivationset037atype");
    }

    Object getObjectValue();

    SchemaType instanceType();

    void objectSet(Object obj);

    Object objectValue();

    void setObjectValue(Object obj);
}
