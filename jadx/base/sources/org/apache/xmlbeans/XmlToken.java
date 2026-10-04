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
public interface XmlToken extends XmlNormalizedString {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_token");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Factory {
        private Factory() {
        }

        public static XmlToken newInstance() {
            return (XmlToken) XmlBeans.getContextTypeLoader().newInstance(XmlToken.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlToken.type, null);
        }

        public static XmlToken newValue(Object obj) {
            return (XmlToken) XmlToken.type.newValue(obj);
        }

        public static XmlToken parse(String str) {
            return (XmlToken) XmlBeans.getContextTypeLoader().parse(str, XmlToken.type, (XmlOptions) null);
        }

        public static XmlToken newInstance(XmlOptions xmlOptions) {
            return (XmlToken) XmlBeans.getContextTypeLoader().newInstance(XmlToken.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlToken.type, xmlOptions);
        }

        public static XmlToken parse(String str, XmlOptions xmlOptions) {
            return (XmlToken) XmlBeans.getContextTypeLoader().parse(str, XmlToken.type, xmlOptions);
        }

        public static XmlToken parse(File file) {
            return (XmlToken) XmlBeans.getContextTypeLoader().parse(file, XmlToken.type, (XmlOptions) null);
        }

        public static XmlToken parse(File file, XmlOptions xmlOptions) {
            return (XmlToken) XmlBeans.getContextTypeLoader().parse(file, XmlToken.type, xmlOptions);
        }

        public static XmlToken parse(URL url) {
            return (XmlToken) XmlBeans.getContextTypeLoader().parse(url, XmlToken.type, (XmlOptions) null);
        }

        public static XmlToken parse(URL url, XmlOptions xmlOptions) {
            return (XmlToken) XmlBeans.getContextTypeLoader().parse(url, XmlToken.type, xmlOptions);
        }

        public static XmlToken parse(InputStream inputStream) {
            return (XmlToken) XmlBeans.getContextTypeLoader().parse(inputStream, XmlToken.type, (XmlOptions) null);
        }

        public static XmlToken parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (XmlToken) XmlBeans.getContextTypeLoader().parse(inputStream, XmlToken.type, xmlOptions);
        }

        public static XmlToken parse(Reader reader) {
            return (XmlToken) XmlBeans.getContextTypeLoader().parse(reader, XmlToken.type, (XmlOptions) null);
        }

        public static XmlToken parse(Reader reader, XmlOptions xmlOptions) {
            return (XmlToken) XmlBeans.getContextTypeLoader().parse(reader, XmlToken.type, xmlOptions);
        }

        public static XmlToken parse(Node node) {
            return (XmlToken) XmlBeans.getContextTypeLoader().parse(node, XmlToken.type, (XmlOptions) null);
        }

        public static XmlToken parse(Node node, XmlOptions xmlOptions) {
            return (XmlToken) XmlBeans.getContextTypeLoader().parse(node, XmlToken.type, xmlOptions);
        }

        public static XmlToken parse(XMLInputStream xMLInputStream) {
            return (XmlToken) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlToken.type, (XmlOptions) null);
        }

        public static XmlToken parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (XmlToken) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlToken.type, xmlOptions);
        }

        public static XmlToken parse(XMLStreamReader xMLStreamReader) {
            return (XmlToken) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlToken.type, (XmlOptions) null);
        }

        public static XmlToken parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (XmlToken) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlToken.type, xmlOptions);
        }
    }
}
