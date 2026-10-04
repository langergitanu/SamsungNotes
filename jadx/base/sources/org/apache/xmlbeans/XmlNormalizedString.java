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
public interface XmlNormalizedString extends XmlString {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_normalizedString");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Factory {
        private Factory() {
        }

        public static XmlNormalizedString newInstance() {
            return (XmlNormalizedString) XmlBeans.getContextTypeLoader().newInstance(XmlNormalizedString.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlNormalizedString.type, null);
        }

        public static XmlNormalizedString newValue(Object obj) {
            return (XmlNormalizedString) XmlNormalizedString.type.newValue(obj);
        }

        public static XmlNormalizedString parse(String str) {
            return (XmlNormalizedString) XmlBeans.getContextTypeLoader().parse(str, XmlNormalizedString.type, (XmlOptions) null);
        }

        public static XmlNormalizedString newInstance(XmlOptions xmlOptions) {
            return (XmlNormalizedString) XmlBeans.getContextTypeLoader().newInstance(XmlNormalizedString.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlNormalizedString.type, xmlOptions);
        }

        public static XmlNormalizedString parse(String str, XmlOptions xmlOptions) {
            return (XmlNormalizedString) XmlBeans.getContextTypeLoader().parse(str, XmlNormalizedString.type, xmlOptions);
        }

        public static XmlNormalizedString parse(File file) {
            return (XmlNormalizedString) XmlBeans.getContextTypeLoader().parse(file, XmlNormalizedString.type, (XmlOptions) null);
        }

        public static XmlNormalizedString parse(File file, XmlOptions xmlOptions) {
            return (XmlNormalizedString) XmlBeans.getContextTypeLoader().parse(file, XmlNormalizedString.type, xmlOptions);
        }

        public static XmlNormalizedString parse(URL url) {
            return (XmlNormalizedString) XmlBeans.getContextTypeLoader().parse(url, XmlNormalizedString.type, (XmlOptions) null);
        }

        public static XmlNormalizedString parse(URL url, XmlOptions xmlOptions) {
            return (XmlNormalizedString) XmlBeans.getContextTypeLoader().parse(url, XmlNormalizedString.type, xmlOptions);
        }

        public static XmlNormalizedString parse(InputStream inputStream) {
            return (XmlNormalizedString) XmlBeans.getContextTypeLoader().parse(inputStream, XmlNormalizedString.type, (XmlOptions) null);
        }

        public static XmlNormalizedString parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (XmlNormalizedString) XmlBeans.getContextTypeLoader().parse(inputStream, XmlNormalizedString.type, xmlOptions);
        }

        public static XmlNormalizedString parse(Reader reader) {
            return (XmlNormalizedString) XmlBeans.getContextTypeLoader().parse(reader, XmlNormalizedString.type, (XmlOptions) null);
        }

        public static XmlNormalizedString parse(Reader reader, XmlOptions xmlOptions) {
            return (XmlNormalizedString) XmlBeans.getContextTypeLoader().parse(reader, XmlNormalizedString.type, xmlOptions);
        }

        public static XmlNormalizedString parse(Node node) {
            return (XmlNormalizedString) XmlBeans.getContextTypeLoader().parse(node, XmlNormalizedString.type, (XmlOptions) null);
        }

        public static XmlNormalizedString parse(Node node, XmlOptions xmlOptions) {
            return (XmlNormalizedString) XmlBeans.getContextTypeLoader().parse(node, XmlNormalizedString.type, xmlOptions);
        }

        public static XmlNormalizedString parse(XMLInputStream xMLInputStream) {
            return (XmlNormalizedString) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlNormalizedString.type, (XmlOptions) null);
        }

        public static XmlNormalizedString parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (XmlNormalizedString) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlNormalizedString.type, xmlOptions);
        }

        public static XmlNormalizedString parse(XMLStreamReader xMLStreamReader) {
            return (XmlNormalizedString) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlNormalizedString.type, (XmlOptions) null);
        }

        public static XmlNormalizedString parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (XmlNormalizedString) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlNormalizedString.type, xmlOptions);
        }
    }
}
