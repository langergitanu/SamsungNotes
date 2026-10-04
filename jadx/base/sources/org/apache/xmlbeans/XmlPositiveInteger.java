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
public interface XmlPositiveInteger extends XmlNonNegativeInteger {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_positiveInteger");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Factory {
        private Factory() {
        }

        public static XmlPositiveInteger newInstance() {
            return (XmlPositiveInteger) XmlBeans.getContextTypeLoader().newInstance(XmlPositiveInteger.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlPositiveInteger.type, null);
        }

        public static XmlPositiveInteger newValue(Object obj) {
            return (XmlPositiveInteger) XmlPositiveInteger.type.newValue(obj);
        }

        public static XmlPositiveInteger parse(String str) {
            return (XmlPositiveInteger) XmlBeans.getContextTypeLoader().parse(str, XmlPositiveInteger.type, (XmlOptions) null);
        }

        public static XmlPositiveInteger newInstance(XmlOptions xmlOptions) {
            return (XmlPositiveInteger) XmlBeans.getContextTypeLoader().newInstance(XmlPositiveInteger.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlPositiveInteger.type, xmlOptions);
        }

        public static XmlPositiveInteger parse(String str, XmlOptions xmlOptions) {
            return (XmlPositiveInteger) XmlBeans.getContextTypeLoader().parse(str, XmlPositiveInteger.type, xmlOptions);
        }

        public static XmlPositiveInteger parse(File file) {
            return (XmlPositiveInteger) XmlBeans.getContextTypeLoader().parse(file, XmlPositiveInteger.type, (XmlOptions) null);
        }

        public static XmlPositiveInteger parse(File file, XmlOptions xmlOptions) {
            return (XmlPositiveInteger) XmlBeans.getContextTypeLoader().parse(file, XmlPositiveInteger.type, xmlOptions);
        }

        public static XmlPositiveInteger parse(URL url) {
            return (XmlPositiveInteger) XmlBeans.getContextTypeLoader().parse(url, XmlPositiveInteger.type, (XmlOptions) null);
        }

        public static XmlPositiveInteger parse(URL url, XmlOptions xmlOptions) {
            return (XmlPositiveInteger) XmlBeans.getContextTypeLoader().parse(url, XmlPositiveInteger.type, xmlOptions);
        }

        public static XmlPositiveInteger parse(InputStream inputStream) {
            return (XmlPositiveInteger) XmlBeans.getContextTypeLoader().parse(inputStream, XmlPositiveInteger.type, (XmlOptions) null);
        }

        public static XmlPositiveInteger parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (XmlPositiveInteger) XmlBeans.getContextTypeLoader().parse(inputStream, XmlPositiveInteger.type, xmlOptions);
        }

        public static XmlPositiveInteger parse(Reader reader) {
            return (XmlPositiveInteger) XmlBeans.getContextTypeLoader().parse(reader, XmlPositiveInteger.type, (XmlOptions) null);
        }

        public static XmlPositiveInteger parse(Reader reader, XmlOptions xmlOptions) {
            return (XmlPositiveInteger) XmlBeans.getContextTypeLoader().parse(reader, XmlPositiveInteger.type, xmlOptions);
        }

        public static XmlPositiveInteger parse(Node node) {
            return (XmlPositiveInteger) XmlBeans.getContextTypeLoader().parse(node, XmlPositiveInteger.type, (XmlOptions) null);
        }

        public static XmlPositiveInteger parse(Node node, XmlOptions xmlOptions) {
            return (XmlPositiveInteger) XmlBeans.getContextTypeLoader().parse(node, XmlPositiveInteger.type, xmlOptions);
        }

        public static XmlPositiveInteger parse(XMLInputStream xMLInputStream) {
            return (XmlPositiveInteger) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlPositiveInteger.type, (XmlOptions) null);
        }

        public static XmlPositiveInteger parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (XmlPositiveInteger) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlPositiveInteger.type, xmlOptions);
        }

        public static XmlPositiveInteger parse(XMLStreamReader xMLStreamReader) {
            return (XmlPositiveInteger) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlPositiveInteger.type, (XmlOptions) null);
        }

        public static XmlPositiveInteger parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (XmlPositiveInteger) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlPositiveInteger.type, xmlOptions);
        }
    }
}
