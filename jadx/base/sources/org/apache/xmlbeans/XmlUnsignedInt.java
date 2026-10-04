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
public interface XmlUnsignedInt extends XmlUnsignedLong {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_unsignedInt");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Factory {
        private Factory() {
        }

        public static XmlUnsignedInt newInstance() {
            return (XmlUnsignedInt) XmlBeans.getContextTypeLoader().newInstance(XmlUnsignedInt.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlUnsignedInt.type, null);
        }

        public static XmlUnsignedInt newValue(Object obj) {
            return (XmlUnsignedInt) XmlUnsignedInt.type.newValue(obj);
        }

        public static XmlUnsignedInt parse(String str) {
            return (XmlUnsignedInt) XmlBeans.getContextTypeLoader().parse(str, XmlUnsignedInt.type, (XmlOptions) null);
        }

        public static XmlUnsignedInt newInstance(XmlOptions xmlOptions) {
            return (XmlUnsignedInt) XmlBeans.getContextTypeLoader().newInstance(XmlUnsignedInt.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlUnsignedInt.type, xmlOptions);
        }

        public static XmlUnsignedInt parse(String str, XmlOptions xmlOptions) {
            return (XmlUnsignedInt) XmlBeans.getContextTypeLoader().parse(str, XmlUnsignedInt.type, xmlOptions);
        }

        public static XmlUnsignedInt parse(File file) {
            return (XmlUnsignedInt) XmlBeans.getContextTypeLoader().parse(file, XmlUnsignedInt.type, (XmlOptions) null);
        }

        public static XmlUnsignedInt parse(File file, XmlOptions xmlOptions) {
            return (XmlUnsignedInt) XmlBeans.getContextTypeLoader().parse(file, XmlUnsignedInt.type, xmlOptions);
        }

        public static XmlUnsignedInt parse(URL url) {
            return (XmlUnsignedInt) XmlBeans.getContextTypeLoader().parse(url, XmlUnsignedInt.type, (XmlOptions) null);
        }

        public static XmlUnsignedInt parse(URL url, XmlOptions xmlOptions) {
            return (XmlUnsignedInt) XmlBeans.getContextTypeLoader().parse(url, XmlUnsignedInt.type, xmlOptions);
        }

        public static XmlUnsignedInt parse(InputStream inputStream) {
            return (XmlUnsignedInt) XmlBeans.getContextTypeLoader().parse(inputStream, XmlUnsignedInt.type, (XmlOptions) null);
        }

        public static XmlUnsignedInt parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (XmlUnsignedInt) XmlBeans.getContextTypeLoader().parse(inputStream, XmlUnsignedInt.type, xmlOptions);
        }

        public static XmlUnsignedInt parse(Reader reader) {
            return (XmlUnsignedInt) XmlBeans.getContextTypeLoader().parse(reader, XmlUnsignedInt.type, (XmlOptions) null);
        }

        public static XmlUnsignedInt parse(Reader reader, XmlOptions xmlOptions) {
            return (XmlUnsignedInt) XmlBeans.getContextTypeLoader().parse(reader, XmlUnsignedInt.type, xmlOptions);
        }

        public static XmlUnsignedInt parse(Node node) {
            return (XmlUnsignedInt) XmlBeans.getContextTypeLoader().parse(node, XmlUnsignedInt.type, (XmlOptions) null);
        }

        public static XmlUnsignedInt parse(Node node, XmlOptions xmlOptions) {
            return (XmlUnsignedInt) XmlBeans.getContextTypeLoader().parse(node, XmlUnsignedInt.type, xmlOptions);
        }

        public static XmlUnsignedInt parse(XMLInputStream xMLInputStream) {
            return (XmlUnsignedInt) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlUnsignedInt.type, (XmlOptions) null);
        }

        public static XmlUnsignedInt parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (XmlUnsignedInt) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlUnsignedInt.type, xmlOptions);
        }

        public static XmlUnsignedInt parse(XMLStreamReader xMLStreamReader) {
            return (XmlUnsignedInt) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlUnsignedInt.type, (XmlOptions) null);
        }

        public static XmlUnsignedInt parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (XmlUnsignedInt) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlUnsignedInt.type, xmlOptions);
        }
    }

    long getLongValue();

    long longValue();

    void set(long j);

    void setLongValue(long j);
}
