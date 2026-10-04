package org.apache.xmlbeans.impl.p229xb.xsdschema;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import kotlin.collections.AbstractC12991c;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnyURI;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlLanguage;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface DocumentationDocument extends XmlObject {
    public static final SchemaType type;

    /* JADX INFO: renamed from: org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    /* synthetic */ class C141951 {

        /* JADX INFO: renamed from: class$org$apache$xmlbeans$impl$xb$xsdschema$DocumentationDocument */
        static /* synthetic */ Class f10181x206dd5b7;

        /* JADX INFO: renamed from: class$org$apache$xmlbeans$impl$xb$xsdschema$DocumentationDocument$Documentation */
        static /* synthetic */ Class f10182x7a5b766d;

        public static /* synthetic */ Class class$(String str) throws Throwable {
            try {
                return Class.forName(str);
            } catch (ClassNotFoundException e) {
                throw AbstractC12991c.m13994o(e);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Documentation extends XmlObject {
        public static final SchemaType type;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static final class Factory {
            private Factory() {
            }

            public static Documentation newInstance() {
                return (Documentation) XmlBeans.getContextTypeLoader().newInstance(Documentation.type, null);
            }

            public static Documentation newInstance(XmlOptions xmlOptions) {
                return (Documentation) XmlBeans.getContextTypeLoader().newInstance(Documentation.type, xmlOptions);
            }
        }

        static {
            Class clsClass$ = C141951.f10182x7a5b766d;
            if (clsClass$ == null) {
                clsClass$ = C141951.class$("org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument$Documentation");
                C141951.f10182x7a5b766d = clsClass$;
            }
            type = (SchemaType) AbstractC4539a.m3202l(clsClass$, "schemaorg_apache_xmlbeans.system.sXMLSCHEMA", "documentationa475elemtype");
        }

        String getLang();

        String getSource();

        boolean isSetLang();

        boolean isSetSource();

        void setLang(String str);

        void setSource(String str);

        void unsetLang();

        void unsetSource();

        XmlLanguage xgetLang();

        XmlAnyURI xgetSource();

        void xsetLang(XmlLanguage xmlLanguage);

        void xsetSource(XmlAnyURI xmlAnyURI);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Factory {
        private Factory() {
        }

        public static DocumentationDocument newInstance() {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().newInstance(DocumentationDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, DocumentationDocument.type, null);
        }

        public static DocumentationDocument parse(String str) {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().parse(str, DocumentationDocument.type, (XmlOptions) null);
        }

        public static DocumentationDocument newInstance(XmlOptions xmlOptions) {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().newInstance(DocumentationDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, DocumentationDocument.type, xmlOptions);
        }

        public static DocumentationDocument parse(String str, XmlOptions xmlOptions) {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().parse(str, DocumentationDocument.type, xmlOptions);
        }

        public static DocumentationDocument parse(File file) {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().parse(file, DocumentationDocument.type, (XmlOptions) null);
        }

        public static DocumentationDocument parse(File file, XmlOptions xmlOptions) {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().parse(file, DocumentationDocument.type, xmlOptions);
        }

        public static DocumentationDocument parse(URL url) {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().parse(url, DocumentationDocument.type, (XmlOptions) null);
        }

        public static DocumentationDocument parse(URL url, XmlOptions xmlOptions) {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().parse(url, DocumentationDocument.type, xmlOptions);
        }

        public static DocumentationDocument parse(InputStream inputStream) {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().parse(inputStream, DocumentationDocument.type, (XmlOptions) null);
        }

        public static DocumentationDocument parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().parse(inputStream, DocumentationDocument.type, xmlOptions);
        }

        public static DocumentationDocument parse(Reader reader) {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().parse(reader, DocumentationDocument.type, (XmlOptions) null);
        }

        public static DocumentationDocument parse(Reader reader, XmlOptions xmlOptions) {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().parse(reader, DocumentationDocument.type, xmlOptions);
        }

        public static DocumentationDocument parse(XMLStreamReader xMLStreamReader) {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, DocumentationDocument.type, (XmlOptions) null);
        }

        public static DocumentationDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, DocumentationDocument.type, xmlOptions);
        }

        public static DocumentationDocument parse(Node node) {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().parse(node, DocumentationDocument.type, (XmlOptions) null);
        }

        public static DocumentationDocument parse(Node node, XmlOptions xmlOptions) {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().parse(node, DocumentationDocument.type, xmlOptions);
        }

        public static DocumentationDocument parse(XMLInputStream xMLInputStream) {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, DocumentationDocument.type, (XmlOptions) null);
        }

        public static DocumentationDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (DocumentationDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, DocumentationDocument.type, xmlOptions);
        }
    }

    static {
        Class clsClass$ = C141951.f10181x206dd5b7;
        if (clsClass$ == null) {
            clsClass$ = C141951.class$("org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument");
            C141951.f10181x206dd5b7 = clsClass$;
        }
        type = (SchemaType) AbstractC4539a.m3202l(clsClass$, "schemaorg_apache_xmlbeans.system.sXMLSCHEMA", "documentation6cdbdoctype");
    }

    Documentation addNewDocumentation();

    Documentation getDocumentation();

    void setDocumentation(Documentation documentation);
}
