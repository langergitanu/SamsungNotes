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
public interface XmlNonNegativeInteger extends XmlInteger {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_nonNegativeInteger");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Factory {
        private Factory() {
        }

        public static XmlNonNegativeInteger newInstance() {
            return (XmlNonNegativeInteger) XmlBeans.getContextTypeLoader().newInstance(XmlNonNegativeInteger.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlNonNegativeInteger.type, null);
        }

        public static XmlNonNegativeInteger newValue(Object obj) {
            return (XmlNonNegativeInteger) XmlNonNegativeInteger.type.newValue(obj);
        }

        public static XmlNonNegativeInteger parse(String str) {
            return (XmlNonNegativeInteger) XmlBeans.getContextTypeLoader().parse(str, XmlNonNegativeInteger.type, (XmlOptions) null);
        }

        public static XmlNonNegativeInteger newInstance(XmlOptions xmlOptions) {
            return (XmlNonNegativeInteger) XmlBeans.getContextTypeLoader().newInstance(XmlNonNegativeInteger.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlNonNegativeInteger.type, xmlOptions);
        }

        public static XmlNonNegativeInteger parse(String str, XmlOptions xmlOptions) {
            return (XmlNonNegativeInteger) XmlBeans.getContextTypeLoader().parse(str, XmlNonNegativeInteger.type, xmlOptions);
        }

        public static XmlNonNegativeInteger parse(File file) {
            return (XmlNonNegativeInteger) XmlBeans.getContextTypeLoader().parse(file, XmlNonNegativeInteger.type, (XmlOptions) null);
        }

        public static XmlNonNegativeInteger parse(File file, XmlOptions xmlOptions) {
            return (XmlNonNegativeInteger) XmlBeans.getContextTypeLoader().parse(file, XmlNonNegativeInteger.type, xmlOptions);
        }

        public static XmlNonNegativeInteger parse(URL url) {
            return (XmlNonNegativeInteger) XmlBeans.getContextTypeLoader().parse(url, XmlNonNegativeInteger.type, (XmlOptions) null);
        }

        public static XmlNonNegativeInteger parse(URL url, XmlOptions xmlOptions) {
            return (XmlNonNegativeInteger) XmlBeans.getContextTypeLoader().parse(url, XmlNonNegativeInteger.type, xmlOptions);
        }

        public static XmlNonNegativeInteger parse(InputStream inputStream) {
            return (XmlNonNegativeInteger) XmlBeans.getContextTypeLoader().parse(inputStream, XmlNonNegativeInteger.type, (XmlOptions) null);
        }

        public static XmlNonNegativeInteger parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (XmlNonNegativeInteger) XmlBeans.getContextTypeLoader().parse(inputStream, XmlNonNegativeInteger.type, xmlOptions);
        }

        public static XmlNonNegativeInteger parse(Reader reader) {
            return (XmlNonNegativeInteger) XmlBeans.getContextTypeLoader().parse(reader, XmlNonNegativeInteger.type, (XmlOptions) null);
        }

        public static XmlNonNegativeInteger parse(Reader reader, XmlOptions xmlOptions) {
            return (XmlNonNegativeInteger) XmlBeans.getContextTypeLoader().parse(reader, XmlNonNegativeInteger.type, xmlOptions);
        }

        public static XmlNonNegativeInteger parse(Node node) {
            return (XmlNonNegativeInteger) XmlBeans.getContextTypeLoader().parse(node, XmlNonNegativeInteger.type, (XmlOptions) null);
        }

        public static XmlNonNegativeInteger parse(Node node, XmlOptions xmlOptions) {
            return (XmlNonNegativeInteger) XmlBeans.getContextTypeLoader().parse(node, XmlNonNegativeInteger.type, xmlOptions);
        }

        public static XmlNonNegativeInteger parse(XMLInputStream xMLInputStream) {
            return (XmlNonNegativeInteger) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlNonNegativeInteger.type, (XmlOptions) null);
        }

        public static XmlNonNegativeInteger parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (XmlNonNegativeInteger) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlNonNegativeInteger.type, xmlOptions);
        }

        public static XmlNonNegativeInteger parse(XMLStreamReader xMLStreamReader) {
            return (XmlNonNegativeInteger) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlNonNegativeInteger.type, (XmlOptions) null);
        }

        public static XmlNonNegativeInteger parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (XmlNonNegativeInteger) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlNonNegativeInteger.type, xmlOptions);
        }
    }
}
