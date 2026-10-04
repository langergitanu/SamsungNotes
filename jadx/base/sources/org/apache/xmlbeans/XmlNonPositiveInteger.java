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
public interface XmlNonPositiveInteger extends XmlInteger {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_nonPositiveInteger");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Factory {
        private Factory() {
        }

        public static XmlNonPositiveInteger newInstance() {
            return (XmlNonPositiveInteger) XmlBeans.getContextTypeLoader().newInstance(XmlNonPositiveInteger.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlNonPositiveInteger.type, null);
        }

        public static XmlNonPositiveInteger newValue(Object obj) {
            return (XmlNonPositiveInteger) XmlNonPositiveInteger.type.newValue(obj);
        }

        public static XmlNonPositiveInteger parse(String str) {
            return (XmlNonPositiveInteger) XmlBeans.getContextTypeLoader().parse(str, XmlNonPositiveInteger.type, (XmlOptions) null);
        }

        public static XmlNonPositiveInteger newInstance(XmlOptions xmlOptions) {
            return (XmlNonPositiveInteger) XmlBeans.getContextTypeLoader().newInstance(XmlNonPositiveInteger.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlNonPositiveInteger.type, xmlOptions);
        }

        public static XmlNonPositiveInteger parse(String str, XmlOptions xmlOptions) {
            return (XmlNonPositiveInteger) XmlBeans.getContextTypeLoader().parse(str, XmlNonPositiveInteger.type, xmlOptions);
        }

        public static XmlNonPositiveInteger parse(File file) {
            return (XmlNonPositiveInteger) XmlBeans.getContextTypeLoader().parse(file, XmlNonPositiveInteger.type, (XmlOptions) null);
        }

        public static XmlNonPositiveInteger parse(File file, XmlOptions xmlOptions) {
            return (XmlNonPositiveInteger) XmlBeans.getContextTypeLoader().parse(file, XmlNonPositiveInteger.type, xmlOptions);
        }

        public static XmlNonPositiveInteger parse(URL url) {
            return (XmlNonPositiveInteger) XmlBeans.getContextTypeLoader().parse(url, XmlNonPositiveInteger.type, (XmlOptions) null);
        }

        public static XmlNonPositiveInteger parse(URL url, XmlOptions xmlOptions) {
            return (XmlNonPositiveInteger) XmlBeans.getContextTypeLoader().parse(url, XmlNonPositiveInteger.type, xmlOptions);
        }

        public static XmlNonPositiveInteger parse(InputStream inputStream) {
            return (XmlNonPositiveInteger) XmlBeans.getContextTypeLoader().parse(inputStream, XmlNonPositiveInteger.type, (XmlOptions) null);
        }

        public static XmlNonPositiveInteger parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (XmlNonPositiveInteger) XmlBeans.getContextTypeLoader().parse(inputStream, XmlNonPositiveInteger.type, xmlOptions);
        }

        public static XmlNonPositiveInteger parse(Reader reader) {
            return (XmlNonPositiveInteger) XmlBeans.getContextTypeLoader().parse(reader, XmlNonPositiveInteger.type, (XmlOptions) null);
        }

        public static XmlNonPositiveInteger parse(Reader reader, XmlOptions xmlOptions) {
            return (XmlNonPositiveInteger) XmlBeans.getContextTypeLoader().parse(reader, XmlNonPositiveInteger.type, xmlOptions);
        }

        public static XmlNonPositiveInteger parse(Node node) {
            return (XmlNonPositiveInteger) XmlBeans.getContextTypeLoader().parse(node, XmlNonPositiveInteger.type, (XmlOptions) null);
        }

        public static XmlNonPositiveInteger parse(Node node, XmlOptions xmlOptions) {
            return (XmlNonPositiveInteger) XmlBeans.getContextTypeLoader().parse(node, XmlNonPositiveInteger.type, xmlOptions);
        }

        public static XmlNonPositiveInteger parse(XMLInputStream xMLInputStream) {
            return (XmlNonPositiveInteger) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlNonPositiveInteger.type, (XmlOptions) null);
        }

        public static XmlNonPositiveInteger parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (XmlNonPositiveInteger) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlNonPositiveInteger.type, xmlOptions);
        }

        public static XmlNonPositiveInteger parse(XMLStreamReader xMLStreamReader) {
            return (XmlNonPositiveInteger) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlNonPositiveInteger.type, (XmlOptions) null);
        }

        public static XmlNonPositiveInteger parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (XmlNonPositiveInteger) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlNonPositiveInteger.type, xmlOptions);
        }
    }
}
