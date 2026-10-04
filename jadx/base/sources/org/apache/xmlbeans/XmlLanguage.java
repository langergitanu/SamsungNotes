package org.apache.xmlbeans;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface XmlLanguage extends XmlToken {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_language");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Factory {
        private Factory() {
        }

        public static XmlLanguage newInstance() {
            return (XmlLanguage) XmlBeans.getContextTypeLoader().newInstance(XmlLanguage.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlLanguage.type, null);
        }

        public static XmlLanguage newValue(Object obj) {
            return (XmlLanguage) XmlLanguage.type.newValue(obj);
        }

        public static XmlLanguage parse(String str) {
            return (XmlLanguage) XmlBeans.getContextTypeLoader().parse(str, XmlLanguage.type, (XmlOptions) null);
        }

        public static XmlLanguage newInstance(XmlOptions xmlOptions) {
            return (XmlLanguage) XmlBeans.getContextTypeLoader().newInstance(XmlLanguage.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlLanguage.type, xmlOptions);
        }

        public static XmlLanguage parse(String str, XmlOptions xmlOptions) {
            return (XmlLanguage) XmlBeans.getContextTypeLoader().parse(str, XmlLanguage.type, xmlOptions);
        }

        public static XmlLanguage parse(File file) {
            return (XmlLanguage) XmlBeans.getContextTypeLoader().parse(file, XmlLanguage.type, (XmlOptions) null);
        }

        public static XmlLanguage parse(File file, XmlOptions xmlOptions) {
            return (XmlLanguage) XmlBeans.getContextTypeLoader().parse(file, XmlLanguage.type, xmlOptions);
        }

        public static XmlLanguage parse(URL url) {
            return (XmlLanguage) XmlBeans.getContextTypeLoader().parse(url, XmlLanguage.type, (XmlOptions) null);
        }

        public static XmlLanguage parse(URL url, XmlOptions xmlOptions) {
            return (XmlLanguage) XmlBeans.getContextTypeLoader().parse(url, XmlLanguage.type, xmlOptions);
        }

        public static XmlLanguage parse(InputStream inputStream) {
            return (XmlLanguage) XmlBeans.getContextTypeLoader().parse(inputStream, XmlLanguage.type, (XmlOptions) null);
        }

        public static XmlLanguage parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (XmlLanguage) XmlBeans.getContextTypeLoader().parse(inputStream, XmlLanguage.type, xmlOptions);
        }

        public static XmlLanguage parse(Reader reader) {
            return (XmlLanguage) XmlBeans.getContextTypeLoader().parse(reader, XmlLanguage.type, (XmlOptions) null);
        }

        public static XmlLanguage parse(Reader reader, XmlOptions xmlOptions) {
            return (XmlLanguage) XmlBeans.getContextTypeLoader().parse(reader, XmlLanguage.type, xmlOptions);
        }

        public static XmlLanguage parse(Node node) {
            return (XmlLanguage) XmlBeans.getContextTypeLoader().parse(node, XmlLanguage.type, (XmlOptions) null);
        }

        public static XmlLanguage parse(Node node, XmlOptions xmlOptions) {
            return (XmlLanguage) XmlBeans.getContextTypeLoader().parse(node, XmlLanguage.type, xmlOptions);
        }

        public static XmlLanguage parse(XMLInputStream xMLInputStream) {
            return (XmlLanguage) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlLanguage.type, (XmlOptions) null);
        }

        public static XmlLanguage parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (XmlLanguage) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlLanguage.type, xmlOptions);
        }

        public static XmlLanguage parse(XMLStreamReader xMLStreamReader) {
            return (XmlLanguage) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlLanguage.type, (XmlOptions) null);
        }

        public static XmlLanguage parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (XmlLanguage) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlLanguage.type, xmlOptions);
        }
    }
}
