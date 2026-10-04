package org.apache.xmlbeans.impl.p229xb.xsdschema;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import kotlin.collections.AbstractC12991c;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlNonNegativeInteger;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface All extends ExplicitGroup {
    public static final SchemaType type;

    /* JADX INFO: renamed from: org.apache.xmlbeans.impl.xb.xsdschema.All$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    /* synthetic */ class C141891 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$All;
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$All$MaxOccurs;
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$All$MinOccurs;

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

        public static All newInstance() {
            return (All) XmlBeans.getContextTypeLoader().newInstance(All.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, All.type, null);
        }

        public static All parse(String str) {
            return (All) XmlBeans.getContextTypeLoader().parse(str, All.type, (XmlOptions) null);
        }

        public static All newInstance(XmlOptions xmlOptions) {
            return (All) XmlBeans.getContextTypeLoader().newInstance(All.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, All.type, xmlOptions);
        }

        public static All parse(String str, XmlOptions xmlOptions) {
            return (All) XmlBeans.getContextTypeLoader().parse(str, All.type, xmlOptions);
        }

        public static All parse(File file) {
            return (All) XmlBeans.getContextTypeLoader().parse(file, All.type, (XmlOptions) null);
        }

        public static All parse(File file, XmlOptions xmlOptions) {
            return (All) XmlBeans.getContextTypeLoader().parse(file, All.type, xmlOptions);
        }

        public static All parse(URL url) {
            return (All) XmlBeans.getContextTypeLoader().parse(url, All.type, (XmlOptions) null);
        }

        public static All parse(URL url, XmlOptions xmlOptions) {
            return (All) XmlBeans.getContextTypeLoader().parse(url, All.type, xmlOptions);
        }

        public static All parse(InputStream inputStream) {
            return (All) XmlBeans.getContextTypeLoader().parse(inputStream, All.type, (XmlOptions) null);
        }

        public static All parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (All) XmlBeans.getContextTypeLoader().parse(inputStream, All.type, xmlOptions);
        }

        public static All parse(Reader reader) {
            return (All) XmlBeans.getContextTypeLoader().parse(reader, All.type, (XmlOptions) null);
        }

        public static All parse(Reader reader, XmlOptions xmlOptions) {
            return (All) XmlBeans.getContextTypeLoader().parse(reader, All.type, xmlOptions);
        }

        public static All parse(XMLStreamReader xMLStreamReader) {
            return (All) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, All.type, (XmlOptions) null);
        }

        public static All parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (All) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, All.type, xmlOptions);
        }

        public static All parse(Node node) {
            return (All) XmlBeans.getContextTypeLoader().parse(node, All.type, (XmlOptions) null);
        }

        public static All parse(Node node, XmlOptions xmlOptions) {
            return (All) XmlBeans.getContextTypeLoader().parse(node, All.type, xmlOptions);
        }

        public static All parse(XMLInputStream xMLInputStream) {
            return (All) XmlBeans.getContextTypeLoader().parse(xMLInputStream, All.type, (XmlOptions) null);
        }

        public static All parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (All) XmlBeans.getContextTypeLoader().parse(xMLInputStream, All.type, xmlOptions);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface MaxOccurs extends AllNNI {
        public static final SchemaType type;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static final class Factory {
            private Factory() {
            }

            public static MaxOccurs newInstance() {
                return (MaxOccurs) XmlBeans.getContextTypeLoader().newInstance(MaxOccurs.type, null);
            }

            public static MaxOccurs newValue(Object obj) {
                return (MaxOccurs) MaxOccurs.type.newValue(obj);
            }

            public static MaxOccurs newInstance(XmlOptions xmlOptions) {
                return (MaxOccurs) XmlBeans.getContextTypeLoader().newInstance(MaxOccurs.type, xmlOptions);
            }
        }

        static {
            Class clsClass$ = C141891.class$org$apache$xmlbeans$impl$xb$xsdschema$All$MaxOccurs;
            if (clsClass$ == null) {
                clsClass$ = C141891.class$("org.apache.xmlbeans.impl.xb.xsdschema.All$MaxOccurs");
                C141891.class$org$apache$xmlbeans$impl$xb$xsdschema$All$MaxOccurs = clsClass$;
            }
            type = (SchemaType) AbstractC4539a.m3202l(clsClass$, "schemaorg_apache_xmlbeans.system.sXMLSCHEMA", "maxoccurse8b1attrtype");
        }

        @Override // org.apache.xmlbeans.impl.p229xb.xsdschema.AllNNI
        Object getObjectValue();

        @Override // org.apache.xmlbeans.impl.p229xb.xsdschema.AllNNI
        SchemaType instanceType();

        @Override // org.apache.xmlbeans.impl.p229xb.xsdschema.AllNNI
        void objectSet(Object obj);

        @Override // org.apache.xmlbeans.impl.p229xb.xsdschema.AllNNI
        Object objectValue();

        @Override // org.apache.xmlbeans.impl.p229xb.xsdschema.AllNNI
        void setObjectValue(Object obj);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface MinOccurs extends XmlNonNegativeInteger {
        public static final SchemaType type;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static final class Factory {
            private Factory() {
            }

            public static MinOccurs newInstance() {
                return (MinOccurs) XmlBeans.getContextTypeLoader().newInstance(MinOccurs.type, null);
            }

            public static MinOccurs newValue(Object obj) {
                return (MinOccurs) MinOccurs.type.newValue(obj);
            }

            public static MinOccurs newInstance(XmlOptions xmlOptions) {
                return (MinOccurs) XmlBeans.getContextTypeLoader().newInstance(MinOccurs.type, xmlOptions);
            }
        }

        static {
            Class clsClass$ = C141891.class$org$apache$xmlbeans$impl$xb$xsdschema$All$MinOccurs;
            if (clsClass$ == null) {
                clsClass$ = C141891.class$("org.apache.xmlbeans.impl.xb.xsdschema.All$MinOccurs");
                C141891.class$org$apache$xmlbeans$impl$xb$xsdschema$All$MinOccurs = clsClass$;
            }
            type = (SchemaType) AbstractC4539a.m3202l(clsClass$, "schemaorg_apache_xmlbeans.system.sXMLSCHEMA", "minoccurs9283attrtype");
        }
    }

    static {
        Class clsClass$ = C141891.class$org$apache$xmlbeans$impl$xb$xsdschema$All;
        if (clsClass$ == null) {
            clsClass$ = C141891.class$("org.apache.xmlbeans.impl.xb.xsdschema.All");
            C141891.class$org$apache$xmlbeans$impl$xb$xsdschema$All = clsClass$;
        }
        type = (SchemaType) AbstractC4539a.m3202l(clsClass$, "schemaorg_apache_xmlbeans.system.sXMLSCHEMA", "all3c04type");
    }
}
