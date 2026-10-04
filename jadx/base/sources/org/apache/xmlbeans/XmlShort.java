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
public interface XmlShort extends XmlInt {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_short");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Factory {
        private Factory() {
        }

        public static XmlShort newInstance() {
            return (XmlShort) XmlBeans.getContextTypeLoader().newInstance(XmlShort.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlShort.type, null);
        }

        public static XmlShort newValue(Object obj) {
            return (XmlShort) XmlShort.type.newValue(obj);
        }

        public static XmlShort parse(String str) {
            return (XmlShort) XmlBeans.getContextTypeLoader().parse(str, XmlShort.type, (XmlOptions) null);
        }

        public static XmlShort newInstance(XmlOptions xmlOptions) {
            return (XmlShort) XmlBeans.getContextTypeLoader().newInstance(XmlShort.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlShort.type, xmlOptions);
        }

        public static XmlShort parse(String str, XmlOptions xmlOptions) {
            return (XmlShort) XmlBeans.getContextTypeLoader().parse(str, XmlShort.type, xmlOptions);
        }

        public static XmlShort parse(File file) {
            return (XmlShort) XmlBeans.getContextTypeLoader().parse(file, XmlShort.type, (XmlOptions) null);
        }

        public static XmlShort parse(File file, XmlOptions xmlOptions) {
            return (XmlShort) XmlBeans.getContextTypeLoader().parse(file, XmlShort.type, xmlOptions);
        }

        public static XmlShort parse(URL url) {
            return (XmlShort) XmlBeans.getContextTypeLoader().parse(url, XmlShort.type, (XmlOptions) null);
        }

        public static XmlShort parse(URL url, XmlOptions xmlOptions) {
            return (XmlShort) XmlBeans.getContextTypeLoader().parse(url, XmlShort.type, xmlOptions);
        }

        public static XmlShort parse(InputStream inputStream) {
            return (XmlShort) XmlBeans.getContextTypeLoader().parse(inputStream, XmlShort.type, (XmlOptions) null);
        }

        public static XmlShort parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (XmlShort) XmlBeans.getContextTypeLoader().parse(inputStream, XmlShort.type, xmlOptions);
        }

        public static XmlShort parse(Reader reader) {
            return (XmlShort) XmlBeans.getContextTypeLoader().parse(reader, XmlShort.type, (XmlOptions) null);
        }

        public static XmlShort parse(Reader reader, XmlOptions xmlOptions) {
            return (XmlShort) XmlBeans.getContextTypeLoader().parse(reader, XmlShort.type, xmlOptions);
        }

        public static XmlShort parse(Node node) {
            return (XmlShort) XmlBeans.getContextTypeLoader().parse(node, XmlShort.type, (XmlOptions) null);
        }

        public static XmlShort parse(Node node, XmlOptions xmlOptions) {
            return (XmlShort) XmlBeans.getContextTypeLoader().parse(node, XmlShort.type, xmlOptions);
        }

        public static XmlShort parse(XMLInputStream xMLInputStream) {
            return (XmlShort) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlShort.type, (XmlOptions) null);
        }

        public static XmlShort parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (XmlShort) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlShort.type, xmlOptions);
        }

        public static XmlShort parse(XMLStreamReader xMLStreamReader) {
            return (XmlShort) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlShort.type, (XmlOptions) null);
        }

        public static XmlShort parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (XmlShort) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlShort.type, xmlOptions);
        }
    }

    short getShortValue();

    void set(short s);

    void setShortValue(short s);

    short shortValue();
}
