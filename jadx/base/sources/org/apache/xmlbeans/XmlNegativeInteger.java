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
public interface XmlNegativeInteger extends XmlNonPositiveInteger {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_negativeInteger");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Factory {
        private Factory() {
        }

        public static XmlNegativeInteger newInstance() {
            return (XmlNegativeInteger) XmlBeans.getContextTypeLoader().newInstance(XmlNegativeInteger.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlNegativeInteger.type, null);
        }

        public static XmlNegativeInteger newValue(Object obj) {
            return (XmlNegativeInteger) XmlNegativeInteger.type.newValue(obj);
        }

        public static XmlNegativeInteger parse(String str) {
            return (XmlNegativeInteger) XmlBeans.getContextTypeLoader().parse(str, XmlNegativeInteger.type, (XmlOptions) null);
        }

        public static XmlNegativeInteger newInstance(XmlOptions xmlOptions) {
            return (XmlNegativeInteger) XmlBeans.getContextTypeLoader().newInstance(XmlNegativeInteger.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlNegativeInteger.type, xmlOptions);
        }

        public static XmlNegativeInteger parse(String str, XmlOptions xmlOptions) {
            return (XmlNegativeInteger) XmlBeans.getContextTypeLoader().parse(str, XmlNegativeInteger.type, xmlOptions);
        }

        public static XmlNegativeInteger parse(File file) {
            return (XmlNegativeInteger) XmlBeans.getContextTypeLoader().parse(file, XmlNegativeInteger.type, (XmlOptions) null);
        }

        public static XmlNegativeInteger parse(File file, XmlOptions xmlOptions) {
            return (XmlNegativeInteger) XmlBeans.getContextTypeLoader().parse(file, XmlNegativeInteger.type, xmlOptions);
        }

        public static XmlNegativeInteger parse(URL url) {
            return (XmlNegativeInteger) XmlBeans.getContextTypeLoader().parse(url, XmlNegativeInteger.type, (XmlOptions) null);
        }

        public static XmlNegativeInteger parse(URL url, XmlOptions xmlOptions) {
            return (XmlNegativeInteger) XmlBeans.getContextTypeLoader().parse(url, XmlNegativeInteger.type, xmlOptions);
        }

        public static XmlNegativeInteger parse(InputStream inputStream) {
            return (XmlNegativeInteger) XmlBeans.getContextTypeLoader().parse(inputStream, XmlNegativeInteger.type, (XmlOptions) null);
        }

        public static XmlNegativeInteger parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (XmlNegativeInteger) XmlBeans.getContextTypeLoader().parse(inputStream, XmlNegativeInteger.type, xmlOptions);
        }

        public static XmlNegativeInteger parse(Reader reader) {
            return (XmlNegativeInteger) XmlBeans.getContextTypeLoader().parse(reader, XmlNegativeInteger.type, (XmlOptions) null);
        }

        public static XmlNegativeInteger parse(Reader reader, XmlOptions xmlOptions) {
            return (XmlNegativeInteger) XmlBeans.getContextTypeLoader().parse(reader, XmlNegativeInteger.type, xmlOptions);
        }

        public static XmlNegativeInteger parse(Node node) {
            return (XmlNegativeInteger) XmlBeans.getContextTypeLoader().parse(node, XmlNegativeInteger.type, (XmlOptions) null);
        }

        public static XmlNegativeInteger parse(Node node, XmlOptions xmlOptions) {
            return (XmlNegativeInteger) XmlBeans.getContextTypeLoader().parse(node, XmlNegativeInteger.type, xmlOptions);
        }

        public static XmlNegativeInteger parse(XMLInputStream xMLInputStream) {
            return (XmlNegativeInteger) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlNegativeInteger.type, (XmlOptions) null);
        }

        public static XmlNegativeInteger parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (XmlNegativeInteger) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlNegativeInteger.type, xmlOptions);
        }

        public static XmlNegativeInteger parse(XMLStreamReader xMLStreamReader) {
            return (XmlNegativeInteger) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlNegativeInteger.type, (XmlOptions) null);
        }

        public static XmlNegativeInteger parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (XmlNegativeInteger) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlNegativeInteger.type, xmlOptions);
        }
    }
}
