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
public interface XmlUnsignedLong extends XmlNonNegativeInteger {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_unsignedLong");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Factory {
        private Factory() {
        }

        public static XmlUnsignedLong newInstance() {
            return (XmlUnsignedLong) XmlBeans.getContextTypeLoader().newInstance(XmlUnsignedLong.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlUnsignedLong.type, null);
        }

        public static XmlUnsignedLong newValue(Object obj) {
            return (XmlUnsignedLong) XmlUnsignedLong.type.newValue(obj);
        }

        public static XmlUnsignedLong parse(String str) {
            return (XmlUnsignedLong) XmlBeans.getContextTypeLoader().parse(str, XmlUnsignedLong.type, (XmlOptions) null);
        }

        public static XmlUnsignedLong newInstance(XmlOptions xmlOptions) {
            return (XmlUnsignedLong) XmlBeans.getContextTypeLoader().newInstance(XmlUnsignedLong.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlUnsignedLong.type, xmlOptions);
        }

        public static XmlUnsignedLong parse(String str, XmlOptions xmlOptions) {
            return (XmlUnsignedLong) XmlBeans.getContextTypeLoader().parse(str, XmlUnsignedLong.type, xmlOptions);
        }

        public static XmlUnsignedLong parse(File file) {
            return (XmlUnsignedLong) XmlBeans.getContextTypeLoader().parse(file, XmlUnsignedLong.type, (XmlOptions) null);
        }

        public static XmlUnsignedLong parse(File file, XmlOptions xmlOptions) {
            return (XmlUnsignedLong) XmlBeans.getContextTypeLoader().parse(file, XmlUnsignedLong.type, xmlOptions);
        }

        public static XmlUnsignedLong parse(URL url) {
            return (XmlUnsignedLong) XmlBeans.getContextTypeLoader().parse(url, XmlUnsignedLong.type, (XmlOptions) null);
        }

        public static XmlUnsignedLong parse(URL url, XmlOptions xmlOptions) {
            return (XmlUnsignedLong) XmlBeans.getContextTypeLoader().parse(url, XmlUnsignedLong.type, xmlOptions);
        }

        public static XmlUnsignedLong parse(InputStream inputStream) {
            return (XmlUnsignedLong) XmlBeans.getContextTypeLoader().parse(inputStream, XmlUnsignedLong.type, (XmlOptions) null);
        }

        public static XmlUnsignedLong parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (XmlUnsignedLong) XmlBeans.getContextTypeLoader().parse(inputStream, XmlUnsignedLong.type, xmlOptions);
        }

        public static XmlUnsignedLong parse(Reader reader) {
            return (XmlUnsignedLong) XmlBeans.getContextTypeLoader().parse(reader, XmlUnsignedLong.type, (XmlOptions) null);
        }

        public static XmlUnsignedLong parse(Reader reader, XmlOptions xmlOptions) {
            return (XmlUnsignedLong) XmlBeans.getContextTypeLoader().parse(reader, XmlUnsignedLong.type, xmlOptions);
        }

        public static XmlUnsignedLong parse(Node node) {
            return (XmlUnsignedLong) XmlBeans.getContextTypeLoader().parse(node, XmlUnsignedLong.type, (XmlOptions) null);
        }

        public static XmlUnsignedLong parse(Node node, XmlOptions xmlOptions) {
            return (XmlUnsignedLong) XmlBeans.getContextTypeLoader().parse(node, XmlUnsignedLong.type, xmlOptions);
        }

        public static XmlUnsignedLong parse(XMLInputStream xMLInputStream) {
            return (XmlUnsignedLong) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlUnsignedLong.type, (XmlOptions) null);
        }

        public static XmlUnsignedLong parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (XmlUnsignedLong) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlUnsignedLong.type, xmlOptions);
        }

        public static XmlUnsignedLong parse(XMLStreamReader xMLStreamReader) {
            return (XmlUnsignedLong) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlUnsignedLong.type, (XmlOptions) null);
        }

        public static XmlUnsignedLong parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (XmlUnsignedLong) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlUnsignedLong.type, xmlOptions);
        }
    }
}
