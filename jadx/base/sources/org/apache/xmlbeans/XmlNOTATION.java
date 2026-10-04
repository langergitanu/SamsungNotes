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
public interface XmlNOTATION extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_NOTATION");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Factory {
        private Factory() {
        }

        public static XmlNOTATION newInstance() {
            return (XmlNOTATION) XmlBeans.getContextTypeLoader().newInstance(XmlNOTATION.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlNOTATION.type, null);
        }

        public static XmlNOTATION newValue(Object obj) {
            return (XmlNOTATION) XmlNOTATION.type.newValue(obj);
        }

        public static XmlNOTATION parse(String str) {
            return (XmlNOTATION) XmlBeans.getContextTypeLoader().parse(str, XmlNOTATION.type, (XmlOptions) null);
        }

        public static XmlNOTATION newInstance(XmlOptions xmlOptions) {
            return (XmlNOTATION) XmlBeans.getContextTypeLoader().newInstance(XmlNOTATION.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlNOTATION.type, xmlOptions);
        }

        public static XmlNOTATION parse(String str, XmlOptions xmlOptions) {
            return (XmlNOTATION) XmlBeans.getContextTypeLoader().parse(str, XmlNOTATION.type, xmlOptions);
        }

        public static XmlNOTATION parse(File file) {
            return (XmlNOTATION) XmlBeans.getContextTypeLoader().parse(file, XmlNOTATION.type, (XmlOptions) null);
        }

        public static XmlNOTATION parse(File file, XmlOptions xmlOptions) {
            return (XmlNOTATION) XmlBeans.getContextTypeLoader().parse(file, XmlNOTATION.type, xmlOptions);
        }

        public static XmlNOTATION parse(URL url) {
            return (XmlNOTATION) XmlBeans.getContextTypeLoader().parse(url, XmlNOTATION.type, (XmlOptions) null);
        }

        public static XmlNOTATION parse(URL url, XmlOptions xmlOptions) {
            return (XmlNOTATION) XmlBeans.getContextTypeLoader().parse(url, XmlNOTATION.type, xmlOptions);
        }

        public static XmlNOTATION parse(InputStream inputStream) {
            return (XmlNOTATION) XmlBeans.getContextTypeLoader().parse(inputStream, XmlNOTATION.type, (XmlOptions) null);
        }

        public static XmlNOTATION parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (XmlNOTATION) XmlBeans.getContextTypeLoader().parse(inputStream, XmlNOTATION.type, xmlOptions);
        }

        public static XmlNOTATION parse(Reader reader) {
            return (XmlNOTATION) XmlBeans.getContextTypeLoader().parse(reader, XmlNOTATION.type, (XmlOptions) null);
        }

        public static XmlNOTATION parse(Reader reader, XmlOptions xmlOptions) {
            return (XmlNOTATION) XmlBeans.getContextTypeLoader().parse(reader, XmlNOTATION.type, xmlOptions);
        }

        public static XmlNOTATION parse(Node node) {
            return (XmlNOTATION) XmlBeans.getContextTypeLoader().parse(node, XmlNOTATION.type, (XmlOptions) null);
        }

        public static XmlNOTATION parse(Node node, XmlOptions xmlOptions) {
            return (XmlNOTATION) XmlBeans.getContextTypeLoader().parse(node, XmlNOTATION.type, xmlOptions);
        }

        public static XmlNOTATION parse(XMLInputStream xMLInputStream) {
            return (XmlNOTATION) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlNOTATION.type, (XmlOptions) null);
        }

        public static XmlNOTATION parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (XmlNOTATION) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlNOTATION.type, xmlOptions);
        }

        public static XmlNOTATION parse(XMLStreamReader xMLStreamReader) {
            return (XmlNOTATION) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlNOTATION.type, (XmlOptions) null);
        }

        public static XmlNOTATION parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (XmlNOTATION) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlNOTATION.type, xmlOptions);
        }
    }
}
