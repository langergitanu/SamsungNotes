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
public interface XmlUnsignedShort extends XmlUnsignedInt {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_unsignedShort");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Factory {
        private Factory() {
        }

        public static XmlUnsignedShort newInstance() {
            return (XmlUnsignedShort) XmlBeans.getContextTypeLoader().newInstance(XmlUnsignedShort.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlUnsignedShort.type, null);
        }

        public static XmlUnsignedShort newValue(Object obj) {
            return (XmlUnsignedShort) XmlUnsignedShort.type.newValue(obj);
        }

        public static XmlUnsignedShort parse(String str) {
            return (XmlUnsignedShort) XmlBeans.getContextTypeLoader().parse(str, XmlUnsignedShort.type, (XmlOptions) null);
        }

        public static XmlUnsignedShort newInstance(XmlOptions xmlOptions) {
            return (XmlUnsignedShort) XmlBeans.getContextTypeLoader().newInstance(XmlUnsignedShort.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlUnsignedShort.type, xmlOptions);
        }

        public static XmlUnsignedShort parse(String str, XmlOptions xmlOptions) {
            return (XmlUnsignedShort) XmlBeans.getContextTypeLoader().parse(str, XmlUnsignedShort.type, xmlOptions);
        }

        public static XmlUnsignedShort parse(File file) {
            return (XmlUnsignedShort) XmlBeans.getContextTypeLoader().parse(file, XmlUnsignedShort.type, (XmlOptions) null);
        }

        public static XmlUnsignedShort parse(File file, XmlOptions xmlOptions) {
            return (XmlUnsignedShort) XmlBeans.getContextTypeLoader().parse(file, XmlUnsignedShort.type, xmlOptions);
        }

        public static XmlUnsignedShort parse(URL url) {
            return (XmlUnsignedShort) XmlBeans.getContextTypeLoader().parse(url, XmlUnsignedShort.type, (XmlOptions) null);
        }

        public static XmlUnsignedShort parse(URL url, XmlOptions xmlOptions) {
            return (XmlUnsignedShort) XmlBeans.getContextTypeLoader().parse(url, XmlUnsignedShort.type, xmlOptions);
        }

        public static XmlUnsignedShort parse(InputStream inputStream) {
            return (XmlUnsignedShort) XmlBeans.getContextTypeLoader().parse(inputStream, XmlUnsignedShort.type, (XmlOptions) null);
        }

        public static XmlUnsignedShort parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (XmlUnsignedShort) XmlBeans.getContextTypeLoader().parse(inputStream, XmlUnsignedShort.type, xmlOptions);
        }

        public static XmlUnsignedShort parse(Reader reader) {
            return (XmlUnsignedShort) XmlBeans.getContextTypeLoader().parse(reader, XmlUnsignedShort.type, (XmlOptions) null);
        }

        public static XmlUnsignedShort parse(Reader reader, XmlOptions xmlOptions) {
            return (XmlUnsignedShort) XmlBeans.getContextTypeLoader().parse(reader, XmlUnsignedShort.type, xmlOptions);
        }

        public static XmlUnsignedShort parse(Node node) {
            return (XmlUnsignedShort) XmlBeans.getContextTypeLoader().parse(node, XmlUnsignedShort.type, (XmlOptions) null);
        }

        public static XmlUnsignedShort parse(Node node, XmlOptions xmlOptions) {
            return (XmlUnsignedShort) XmlBeans.getContextTypeLoader().parse(node, XmlUnsignedShort.type, xmlOptions);
        }

        public static XmlUnsignedShort parse(XMLInputStream xMLInputStream) {
            return (XmlUnsignedShort) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlUnsignedShort.type, (XmlOptions) null);
        }

        public static XmlUnsignedShort parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (XmlUnsignedShort) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlUnsignedShort.type, xmlOptions);
        }

        public static XmlUnsignedShort parse(XMLStreamReader xMLStreamReader) {
            return (XmlUnsignedShort) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlUnsignedShort.type, (XmlOptions) null);
        }

        public static XmlUnsignedShort parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (XmlUnsignedShort) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlUnsignedShort.type, xmlOptions);
        }
    }

    int getIntValue();

    int intValue();

    void set(int i);

    void setIntValue(int i);
}
