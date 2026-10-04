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
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface AllDocument extends XmlObject {
    public static final SchemaType type;

    /* JADX INFO: renamed from: org.apache.xmlbeans.impl.xb.xsdschema.AllDocument$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    /* synthetic */ class C141901 {
        static /* synthetic */ Class class$org$apache$xmlbeans$impl$xb$xsdschema$AllDocument;

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

        public static AllDocument newInstance() {
            return (AllDocument) XmlBeans.getContextTypeLoader().newInstance(AllDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, AllDocument.type, null);
        }

        public static AllDocument parse(String str) {
            return (AllDocument) XmlBeans.getContextTypeLoader().parse(str, AllDocument.type, (XmlOptions) null);
        }

        public static AllDocument newInstance(XmlOptions xmlOptions) {
            return (AllDocument) XmlBeans.getContextTypeLoader().newInstance(AllDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, AllDocument.type, xmlOptions);
        }

        public static AllDocument parse(String str, XmlOptions xmlOptions) {
            return (AllDocument) XmlBeans.getContextTypeLoader().parse(str, AllDocument.type, xmlOptions);
        }

        public static AllDocument parse(File file) {
            return (AllDocument) XmlBeans.getContextTypeLoader().parse(file, AllDocument.type, (XmlOptions) null);
        }

        public static AllDocument parse(File file, XmlOptions xmlOptions) {
            return (AllDocument) XmlBeans.getContextTypeLoader().parse(file, AllDocument.type, xmlOptions);
        }

        public static AllDocument parse(URL url) {
            return (AllDocument) XmlBeans.getContextTypeLoader().parse(url, AllDocument.type, (XmlOptions) null);
        }

        public static AllDocument parse(URL url, XmlOptions xmlOptions) {
            return (AllDocument) XmlBeans.getContextTypeLoader().parse(url, AllDocument.type, xmlOptions);
        }

        public static AllDocument parse(InputStream inputStream) {
            return (AllDocument) XmlBeans.getContextTypeLoader().parse(inputStream, AllDocument.type, (XmlOptions) null);
        }

        public static AllDocument parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (AllDocument) XmlBeans.getContextTypeLoader().parse(inputStream, AllDocument.type, xmlOptions);
        }

        public static AllDocument parse(Reader reader) {
            return (AllDocument) XmlBeans.getContextTypeLoader().parse(reader, AllDocument.type, (XmlOptions) null);
        }

        public static AllDocument parse(Reader reader, XmlOptions xmlOptions) {
            return (AllDocument) XmlBeans.getContextTypeLoader().parse(reader, AllDocument.type, xmlOptions);
        }

        public static AllDocument parse(XMLStreamReader xMLStreamReader) {
            return (AllDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, AllDocument.type, (XmlOptions) null);
        }

        public static AllDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (AllDocument) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, AllDocument.type, xmlOptions);
        }

        public static AllDocument parse(Node node) {
            return (AllDocument) XmlBeans.getContextTypeLoader().parse(node, AllDocument.type, (XmlOptions) null);
        }

        public static AllDocument parse(Node node, XmlOptions xmlOptions) {
            return (AllDocument) XmlBeans.getContextTypeLoader().parse(node, AllDocument.type, xmlOptions);
        }

        public static AllDocument parse(XMLInputStream xMLInputStream) {
            return (AllDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, AllDocument.type, (XmlOptions) null);
        }

        public static AllDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (AllDocument) XmlBeans.getContextTypeLoader().parse(xMLInputStream, AllDocument.type, xmlOptions);
        }
    }

    static {
        Class clsClass$ = C141901.class$org$apache$xmlbeans$impl$xb$xsdschema$AllDocument;
        if (clsClass$ == null) {
            clsClass$ = C141901.class$("org.apache.xmlbeans.impl.xb.xsdschema.AllDocument");
            C141901.class$org$apache$xmlbeans$impl$xb$xsdschema$AllDocument = clsClass$;
        }
        type = (SchemaType) AbstractC4539a.m3202l(clsClass$, "schemaorg_apache_xmlbeans.system.sXMLSCHEMA", "all7214doctype");
    }

    All addNewAll();

    All getAll();

    void setAll(All all);
}
