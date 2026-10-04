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
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface AppinfoDocument extends XmlObject {
    public static final SchemaType type;

    /* JADX INFO: renamed from: org.apache.xmlbeans.impl.xb.xsdschema.AppinfoDocument$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    /* synthetic */ class C141921 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$AppinfoDocument;

        /* JADX INFO: renamed from: class$org$apache$xmlbeans$impl$xb$xsdschema$AppinfoDocument$Appinfo */
        static /* synthetic */ Class f10179x40e32f57;

        public static /* synthetic */ Class class$(String str) throws Throwable {
            try {
                return Class.forName(str);
            } catch (ClassNotFoundException e) {
                throw AbstractC12991c.m13994o(e);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Appinfo extends XmlObject {
        public static final SchemaType type;

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        public static final class Factory {
            private Factory() {
            }

            public static Appinfo newInstance() {
                return (Appinfo) XmlBeans.getContextTypeLoader().newInstance(Appinfo.type, null);
            }

            public static Appinfo newInstance(XmlOptions xmlOptions) {
                return (Appinfo) XmlBeans.getContextTypeLoader().newInstance(Appinfo.type, xmlOptions);
            }
        }

        static {
            Class clsClass$ = C141921.f10179x40e32f57;
            if (clsClass$ == null) {
                clsClass$ = C141921.class$("org.apache.xmlbeans.impl.xb.xsdschema.AppinfoDocument$Appinfo");
                C141921.f10179x40e32f57 = clsClass$;
            }
            type = (SchemaType) AbstractC4539a.m3202l(clsClass$, "schemaorg_apache_xmlbeans.system.sXMLSCHEMA", "appinfo650belemtype");
        }

        String getSource();

        boolean isSetSource();

        void setSource(String str);

        void unsetSource();

        XmlAnyURI xgetSource();

        void xsetSource(XmlAnyURI xmlAnyURI);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Factory {
        private Factory() {
        }

        public static AppinfoDocument newInstance() {
            return (AppinfoDocument) XmlBeans.getContextTypeLoader().newInstance(AppinfoDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, AppinfoDocument.type, null);
        }

        public static AppinfoDocument parse(String str) {
            return (AppinfoDocument) XmlBeans.getContextTypeLoader().parse(str, AppinfoDocument.type, (XmlOptions) null);
        }

        public static AppinfoDocument newInstance(XmlOptions xmlOptions) {
            return (AppinfoDocument) XmlBeans.getContextTypeLoader().newInstance(AppinfoDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, AppinfoDocument.type, xmlOptions);
        }

        public static AppinfoDocument parse(String str, XmlOptions xmlOptions) {
            return (AppinfoDocument) XmlBeans.getContextTypeLoader().parse(str, AppinfoDocument.type, xmlOptions);
        }

        public static AppinfoDocument parse(File file) {
            return (AppinfoDocument) XmlBeans.getContextTypeLoader().parse(file, AppinfoDocument.type, (XmlOptions) null);
        }

        public static AppinfoDocument parse(File file, XmlOptions xmlOptions) {
            return (AppinfoDocument) XmlBeans.getContextTypeLoader().parse(file, AppinfoDocument.type, xmlOptions);
        }

        public static AppinfoDocument parse(URL url) {
            return (AppinfoDocument) XmlBeans.getContextTypeLoader().parse(url, AppinfoDocument.type, (XmlOptions) null);
        }

        public static AppinfoDocument parse(URL url, XmlOptions xmlOptions) {
            return (AppinfoDocument) XmlBeans.getContextTypeLoader().parse(url, AppinfoDocument.type, xmlOptions);
        }

        public static AppinfoDocument parse(InputStream inputStream) {
            return (AppinfoDocument) XmlBeans.getContextTypeLoader().parse(inputStream, AppinfoDocument.type, (XmlOptions) null);
        }

        public static AppinfoDocument parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (AppinfoDocument) XmlBeans.getContextTypeLoader().parse(inputStream, AppinfoDocument.type, xmlOptions);
        }

        public static AppinfoDocument parse(Reader reader) {
            return (AppinfoDocument) XmlBeans.getContextTypeLoader().parse(reader, AppinfoDocument.type, (XmlOptions) null);
        }

        public static AppinfoDocument parse(Reader reader, XmlOptions xmlOptions) {
            return (AppinfoDocument) XmlBeans.getContextTypeLoader().parse(reader, AppinfoDocument.type, xmlOptions);
        }

        public static AppinfoDocument parse(XMLStreamReader xMLStreamReader) {
            return (AppinfoDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, AppinfoDocument.type, (XmlOptions) null);
        }

        public static AppinfoDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (AppinfoDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, AppinfoDocument.type, xmlOptions);
        }

        public static AppinfoDocument parse(Node node) {
            return (AppinfoDocument) XmlBeans.getContextTypeLoader().parse(node, AppinfoDocument.type, (XmlOptions) null);
        }

        public static AppinfoDocument parse(Node node, XmlOptions xmlOptions) {
            return (AppinfoDocument) XmlBeans.getContextTypeLoader().parse(node, AppinfoDocument.type, xmlOptions);
        }

        public static AppinfoDocument parse(XMLInputStream xMLInputStream) {
            return (AppinfoDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, AppinfoDocument.type, (XmlOptions) null);
        }

        public static AppinfoDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (AppinfoDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, AppinfoDocument.type, xmlOptions);
        }
    }

    static {
        Class clsClass$ = C141921.class$org$apache$xmlbeans$impl$xb$xsdschema$AppinfoDocument;
        if (clsClass$ == null) {
            clsClass$ = C141921.class$("org.apache.xmlbeans.impl.xb.xsdschema.AppinfoDocument");
            C141921.class$org$apache$xmlbeans$impl$xb$xsdschema$AppinfoDocument = clsClass$;
        }
        type = (SchemaType) AbstractC4539a.m3202l(clsClass$, "schemaorg_apache_xmlbeans.system.sXMLSCHEMA", "appinfo2ea6doctype");
    }

    Appinfo addNewAppinfo();

    Appinfo getAppinfo();

    void setAppinfo(Appinfo appinfo);
}
