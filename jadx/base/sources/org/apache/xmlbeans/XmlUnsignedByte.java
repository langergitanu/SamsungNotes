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
public interface XmlUnsignedByte extends XmlUnsignedShort {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_unsignedByte");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Factory {
        private Factory() {
        }

        public static XmlUnsignedByte newInstance() {
            return (XmlUnsignedByte) XmlBeans.getContextTypeLoader().newInstance(XmlUnsignedByte.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlUnsignedByte.type, null);
        }

        public static XmlUnsignedByte newValue(Object obj) {
            return (XmlUnsignedByte) XmlUnsignedByte.type.newValue(obj);
        }

        public static XmlUnsignedByte parse(String str) {
            return (XmlUnsignedByte) XmlBeans.getContextTypeLoader().parse(str, XmlUnsignedByte.type, (XmlOptions) null);
        }

        public static XmlUnsignedByte newInstance(XmlOptions xmlOptions) {
            return (XmlUnsignedByte) XmlBeans.getContextTypeLoader().newInstance(XmlUnsignedByte.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlUnsignedByte.type, xmlOptions);
        }

        public static XmlUnsignedByte parse(String str, XmlOptions xmlOptions) {
            return (XmlUnsignedByte) XmlBeans.getContextTypeLoader().parse(str, XmlUnsignedByte.type, xmlOptions);
        }

        public static XmlUnsignedByte parse(File file) {
            return (XmlUnsignedByte) XmlBeans.getContextTypeLoader().parse(file, XmlUnsignedByte.type, (XmlOptions) null);
        }

        public static XmlUnsignedByte parse(File file, XmlOptions xmlOptions) {
            return (XmlUnsignedByte) XmlBeans.getContextTypeLoader().parse(file, XmlUnsignedByte.type, xmlOptions);
        }

        public static XmlUnsignedByte parse(URL url) {
            return (XmlUnsignedByte) XmlBeans.getContextTypeLoader().parse(url, XmlUnsignedByte.type, (XmlOptions) null);
        }

        public static XmlUnsignedByte parse(URL url, XmlOptions xmlOptions) {
            return (XmlUnsignedByte) XmlBeans.getContextTypeLoader().parse(url, XmlUnsignedByte.type, xmlOptions);
        }

        public static XmlUnsignedByte parse(InputStream inputStream) {
            return (XmlUnsignedByte) XmlBeans.getContextTypeLoader().parse(inputStream, XmlUnsignedByte.type, (XmlOptions) null);
        }

        public static XmlUnsignedByte parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (XmlUnsignedByte) XmlBeans.getContextTypeLoader().parse(inputStream, XmlUnsignedByte.type, xmlOptions);
        }

        public static XmlUnsignedByte parse(Reader reader) {
            return (XmlUnsignedByte) XmlBeans.getContextTypeLoader().parse(reader, XmlUnsignedByte.type, (XmlOptions) null);
        }

        public static XmlUnsignedByte parse(Reader reader, XmlOptions xmlOptions) {
            return (XmlUnsignedByte) XmlBeans.getContextTypeLoader().parse(reader, XmlUnsignedByte.type, xmlOptions);
        }

        public static XmlUnsignedByte parse(Node node) {
            return (XmlUnsignedByte) XmlBeans.getContextTypeLoader().parse(node, XmlUnsignedByte.type, (XmlOptions) null);
        }

        public static XmlUnsignedByte parse(Node node, XmlOptions xmlOptions) {
            return (XmlUnsignedByte) XmlBeans.getContextTypeLoader().parse(node, XmlUnsignedByte.type, xmlOptions);
        }

        public static XmlUnsignedByte parse(XMLInputStream xMLInputStream) {
            return (XmlUnsignedByte) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlUnsignedByte.type, (XmlOptions) null);
        }

        public static XmlUnsignedByte parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (XmlUnsignedByte) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlUnsignedByte.type, xmlOptions);
        }

        public static XmlUnsignedByte parse(XMLStreamReader xMLStreamReader) {
            return (XmlUnsignedByte) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlUnsignedByte.type, (XmlOptions) null);
        }

        public static XmlUnsignedByte parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (XmlUnsignedByte) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlUnsignedByte.type, xmlOptions);
        }
    }

    short getShortValue();

    void set(short s);

    void setShortValue(short s);

    short shortValue();
}
