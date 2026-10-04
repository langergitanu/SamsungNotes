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
public interface XmlInt extends XmlLong {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_int");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Factory {
        private Factory() {
        }

        public static XmlInt newInstance() {
            return (XmlInt) XmlBeans.getContextTypeLoader().newInstance(XmlInt.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlInt.type, null);
        }

        public static XmlInt newValue(Object obj) {
            return (XmlInt) XmlInt.type.newValue(obj);
        }

        public static XmlInt parse(String str) {
            return (XmlInt) XmlBeans.getContextTypeLoader().parse(str, XmlInt.type, (XmlOptions) null);
        }

        public static XmlInt newInstance(XmlOptions xmlOptions) {
            return (XmlInt) XmlBeans.getContextTypeLoader().newInstance(XmlInt.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlInt.type, xmlOptions);
        }

        public static XmlInt parse(String str, XmlOptions xmlOptions) {
            return (XmlInt) XmlBeans.getContextTypeLoader().parse(str, XmlInt.type, xmlOptions);
        }

        public static XmlInt parse(File file) {
            return (XmlInt) XmlBeans.getContextTypeLoader().parse(file, XmlInt.type, (XmlOptions) null);
        }

        public static XmlInt parse(File file, XmlOptions xmlOptions) {
            return (XmlInt) XmlBeans.getContextTypeLoader().parse(file, XmlInt.type, xmlOptions);
        }

        public static XmlInt parse(URL url) {
            return (XmlInt) XmlBeans.getContextTypeLoader().parse(url, XmlInt.type, (XmlOptions) null);
        }

        public static XmlInt parse(URL url, XmlOptions xmlOptions) {
            return (XmlInt) XmlBeans.getContextTypeLoader().parse(url, XmlInt.type, xmlOptions);
        }

        public static XmlInt parse(InputStream inputStream) {
            return (XmlInt) XmlBeans.getContextTypeLoader().parse(inputStream, XmlInt.type, (XmlOptions) null);
        }

        public static XmlInt parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (XmlInt) XmlBeans.getContextTypeLoader().parse(inputStream, XmlInt.type, xmlOptions);
        }

        public static XmlInt parse(Reader reader) {
            return (XmlInt) XmlBeans.getContextTypeLoader().parse(reader, XmlInt.type, (XmlOptions) null);
        }

        public static XmlInt parse(Reader reader, XmlOptions xmlOptions) {
            return (XmlInt) XmlBeans.getContextTypeLoader().parse(reader, XmlInt.type, xmlOptions);
        }

        public static XmlInt parse(Node node) {
            return (XmlInt) XmlBeans.getContextTypeLoader().parse(node, XmlInt.type, (XmlOptions) null);
        }

        public static XmlInt parse(Node node, XmlOptions xmlOptions) {
            return (XmlInt) XmlBeans.getContextTypeLoader().parse(node, XmlInt.type, xmlOptions);
        }

        public static XmlInt parse(XMLInputStream xMLInputStream) {
            return (XmlInt) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlInt.type, (XmlOptions) null);
        }

        public static XmlInt parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (XmlInt) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlInt.type, xmlOptions);
        }

        public static XmlInt parse(XMLStreamReader xMLStreamReader) {
            return (XmlInt) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlInt.type, (XmlOptions) null);
        }

        public static XmlInt parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (XmlInt) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlInt.type, xmlOptions);
        }
    }

    int getIntValue();

    int intValue();

    void set(int i);

    void setIntValue(int i);
}
