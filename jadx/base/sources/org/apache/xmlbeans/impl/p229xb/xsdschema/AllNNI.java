package org.apache.xmlbeans.impl.p229xb.xsdschema;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import kotlin.collections.AbstractC12991c;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.StringEnumAbstractBase;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlNMTOKEN;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface AllNNI extends XmlAnySimpleType {
    public static final SchemaType type;

    /* JADX INFO: renamed from: org.apache.xmlbeans.impl.xb.xsdschema.AllNNI$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    /* synthetic */ class C141911 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$AllNNI;
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$AllNNI$Member;

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

        public static AllNNI newInstance() {
            return (AllNNI) XmlBeans.getContextTypeLoader().newInstance(AllNNI.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, AllNNI.type, null);
        }

        public static AllNNI newValue(Object obj) {
            return (AllNNI) AllNNI.type.newValue(obj);
        }

        public static AllNNI parse(String str) {
            return (AllNNI) XmlBeans.getContextTypeLoader().parse(str, AllNNI.type, (XmlOptions) null);
        }

        public static AllNNI newInstance(XmlOptions xmlOptions) {
            return (AllNNI) XmlBeans.getContextTypeLoader().newInstance(AllNNI.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, AllNNI.type, xmlOptions);
        }

        public static AllNNI parse(String str, XmlOptions xmlOptions) {
            return (AllNNI) XmlBeans.getContextTypeLoader().parse(str, AllNNI.type, xmlOptions);
        }

        public static AllNNI parse(File file) {
            return (AllNNI) XmlBeans.getContextTypeLoader().parse(file, AllNNI.type, (XmlOptions) null);
        }

        public static AllNNI parse(File file, XmlOptions xmlOptions) {
            return (AllNNI) XmlBeans.getContextTypeLoader().parse(file, AllNNI.type, xmlOptions);
        }

        public static AllNNI parse(URL url) {
            return (AllNNI) XmlBeans.getContextTypeLoader().parse(url, AllNNI.type, (XmlOptions) null);
        }

        public static AllNNI parse(URL url, XmlOptions xmlOptions) {
            return (AllNNI) XmlBeans.getContextTypeLoader().parse(url, AllNNI.type, xmlOptions);
        }

        public static AllNNI parse(InputStream inputStream) {
            return (AllNNI) XmlBeans.getContextTypeLoader().parse(inputStream, AllNNI.type, (XmlOptions) null);
        }

        public static AllNNI parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (AllNNI) XmlBeans.getContextTypeLoader().parse(inputStream, AllNNI.type, xmlOptions);
        }

        public static AllNNI parse(Reader reader) {
            return (AllNNI) XmlBeans.getContextTypeLoader().parse(reader, AllNNI.type, (XmlOptions) null);
        }

        public static AllNNI parse(Reader reader, XmlOptions xmlOptions) {
            return (AllNNI) XmlBeans.getContextTypeLoader().parse(reader, AllNNI.type, xmlOptions);
        }

        public static AllNNI parse(XMLStreamReader xMLStreamReader) {
            return (AllNNI) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, AllNNI.type, (XmlOptions) null);
        }

        public static AllNNI parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (AllNNI) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, AllNNI.type, xmlOptions);
        }

        public static AllNNI parse(Node node) {
            return (AllNNI) XmlBeans.getContextTypeLoader().parse(node, AllNNI.type, (XmlOptions) null);
        }

        public static AllNNI parse(Node node, XmlOptions xmlOptions) {
            return (AllNNI) XmlBeans.getContextTypeLoader().parse(node, AllNNI.type, xmlOptions);
        }

        public static AllNNI parse(XMLInputStream xMLInputStream) {
            return (AllNNI) XmlBeans.getContextTypeLoader().parse(xMLInputStream, AllNNI.type, (XmlOptions) null);
        }

        public static AllNNI parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (AllNNI) XmlBeans.getContextTypeLoader().parse(xMLInputStream, AllNNI.type, xmlOptions);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Member extends XmlNMTOKEN {
        public static final int INT_UNBOUNDED = 1;
        public static final Enum UNBOUNDED;
        public static final SchemaType type;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static final class Enum extends StringEnumAbstractBase {
            static final int INT_UNBOUNDED = 1;
            private static final long serialVersionUID = 1;
            public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new Enum[]{new Enum("unbounded", 1)});

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
            Class clsClass$ = C141911.class$org$apache$xmlbeans$impl$xb$xsdschema$AllNNI$Member;
            if (clsClass$ == null) {
                clsClass$ = C141911.class$("org.apache.xmlbeans.impl.xb.xsdschema.AllNNI$Member");
                C141911.class$org$apache$xmlbeans$impl$xb$xsdschema$AllNNI$Member = clsClass$;
            }
            type = (SchemaType) AbstractC4539a.m3202l(clsClass$, "schemaorg_apache_xmlbeans.system.sXMLSCHEMA", "anon0330type");
            UNBOUNDED = Enum.forString("unbounded");
        }

        StringEnumAbstractBase enumValue();

        void set(StringEnumAbstractBase stringEnumAbstractBase);
    }

    static {
        Class clsClass$ = C141911.class$org$apache$xmlbeans$impl$xb$xsdschema$AllNNI;
        if (clsClass$ == null) {
            clsClass$ = C141911.class$("org.apache.xmlbeans.impl.xb.xsdschema.AllNNI");
            C141911.class$org$apache$xmlbeans$impl$xb$xsdschema$AllNNI = clsClass$;
        }
        type = (SchemaType) AbstractC4539a.m3202l(clsClass$, "schemaorg_apache_xmlbeans.system.sXMLSCHEMA", "allnni78cbtype");
    }

    Object getObjectValue();

    SchemaType instanceType();

    void objectSet(Object obj);

    Object objectValue();

    void setObjectValue(Object obj);
}
