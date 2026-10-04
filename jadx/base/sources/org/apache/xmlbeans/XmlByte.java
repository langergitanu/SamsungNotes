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
public interface XmlByte extends XmlShort {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_byte");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Factory {
        private Factory() {
        }

        public static XmlByte newInstance() {
            return (XmlByte) XmlBeans.getContextTypeLoader().newInstance(XmlByte.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlByte.type, null);
        }

        public static XmlByte newValue(Object obj) {
            return (XmlByte) XmlByte.type.newValue(obj);
        }

        public static XmlByte parse(String str) {
            return (XmlByte) XmlBeans.getContextTypeLoader().parse(str, XmlByte.type, (XmlOptions) null);
        }

        public static XmlByte newInstance(XmlOptions xmlOptions) {
            return (XmlByte) XmlBeans.getContextTypeLoader().newInstance(XmlByte.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlByte.type, xmlOptions);
        }

        public static XmlByte parse(String str, XmlOptions xmlOptions) {
            return (XmlByte) XmlBeans.getContextTypeLoader().parse(str, XmlByte.type, xmlOptions);
        }

        public static XmlByte parse(File file) {
            return (XmlByte) XmlBeans.getContextTypeLoader().parse(file, XmlByte.type, (XmlOptions) null);
        }

        public static XmlByte parse(File file, XmlOptions xmlOptions) {
            return (XmlByte) XmlBeans.getContextTypeLoader().parse(file, XmlByte.type, xmlOptions);
        }

        public static XmlByte parse(URL url) {
            return (XmlByte) XmlBeans.getContextTypeLoader().parse(url, XmlByte.type, (XmlOptions) null);
        }

        public static XmlByte parse(URL url, XmlOptions xmlOptions) {
            return (XmlByte) XmlBeans.getContextTypeLoader().parse(url, XmlByte.type, xmlOptions);
        }

        public static XmlByte parse(InputStream inputStream) {
            return (XmlByte) XmlBeans.getContextTypeLoader().parse(inputStream, XmlByte.type, (XmlOptions) null);
        }

        public static XmlByte parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (XmlByte) XmlBeans.getContextTypeLoader().parse(inputStream, XmlByte.type, xmlOptions);
        }

        public static XmlByte parse(Reader reader) {
            return (XmlByte) XmlBeans.getContextTypeLoader().parse(reader, XmlByte.type, (XmlOptions) null);
        }

        public static XmlByte parse(Reader reader, XmlOptions xmlOptions) {
            return (XmlByte) XmlBeans.getContextTypeLoader().parse(reader, XmlByte.type, xmlOptions);
        }

        public static XmlByte parse(Node node) {
            return (XmlByte) XmlBeans.getContextTypeLoader().parse(node, XmlByte.type, (XmlOptions) null);
        }

        public static XmlByte parse(Node node, XmlOptions xmlOptions) {
            return (XmlByte) XmlBeans.getContextTypeLoader().parse(node, XmlByte.type, xmlOptions);
        }

        public static XmlByte parse(XMLInputStream xMLInputStream) {
            return (XmlByte) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlByte.type, (XmlOptions) null);
        }

        public static XmlByte parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (XmlByte) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlByte.type, xmlOptions);
        }

        public static XmlByte parse(XMLStreamReader xMLStreamReader) {
            return (XmlByte) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlByte.type, (XmlOptions) null);
        }

        public static XmlByte parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (XmlByte) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlByte.type, xmlOptions);
        }
    }

    byte byteValue();

    byte getByteValue();

    void set(byte b);

    void setByteValue(byte b);
}
