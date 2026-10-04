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
public interface XmlAnySimpleType extends XmlObject {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_anySimpleType");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Factory {
        private Factory() {
        }

        public static XmlAnySimpleType newInstance() {
            return (XmlAnySimpleType) XmlBeans.getContextTypeLoader().newInstance(XmlAnySimpleType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlAnySimpleType.type, null);
        }

        public static XmlAnySimpleType newValue(Object obj) {
            return XmlAnySimpleType.type.newValue(obj);
        }

        public static XmlAnySimpleType parse(String str) {
            return (XmlAnySimpleType) XmlBeans.getContextTypeLoader().parse(str, XmlAnySimpleType.type, (XmlOptions) null);
        }

        public static XmlAnySimpleType newInstance(XmlOptions xmlOptions) {
            return (XmlAnySimpleType) XmlBeans.getContextTypeLoader().newInstance(XmlAnySimpleType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlAnySimpleType.type, xmlOptions);
        }

        public static XmlAnySimpleType parse(String str, XmlOptions xmlOptions) {
            return (XmlAnySimpleType) XmlBeans.getContextTypeLoader().parse(str, XmlAnySimpleType.type, xmlOptions);
        }

        public static XmlAnySimpleType parse(File file) {
            return (XmlAnySimpleType) XmlBeans.getContextTypeLoader().parse(file, XmlAnySimpleType.type, (XmlOptions) null);
        }

        public static XmlAnySimpleType parse(File file, XmlOptions xmlOptions) {
            return (XmlAnySimpleType) XmlBeans.getContextTypeLoader().parse(file, XmlAnySimpleType.type, xmlOptions);
        }

        public static XmlAnySimpleType parse(URL url) {
            return (XmlAnySimpleType) XmlBeans.getContextTypeLoader().parse(url, XmlAnySimpleType.type, (XmlOptions) null);
        }

        public static XmlAnySimpleType parse(URL url, XmlOptions xmlOptions) {
            return (XmlAnySimpleType) XmlBeans.getContextTypeLoader().parse(url, XmlAnySimpleType.type, xmlOptions);
        }

        public static XmlAnySimpleType parse(InputStream inputStream) {
            return (XmlAnySimpleType) XmlBeans.getContextTypeLoader().parse(inputStream, XmlAnySimpleType.type, (XmlOptions) null);
        }

        public static XmlAnySimpleType parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (XmlAnySimpleType) XmlBeans.getContextTypeLoader().parse(inputStream, XmlAnySimpleType.type, xmlOptions);
        }

        public static XmlAnySimpleType parse(Reader reader) {
            return (XmlAnySimpleType) XmlBeans.getContextTypeLoader().parse(reader, XmlAnySimpleType.type, (XmlOptions) null);
        }

        public static XmlAnySimpleType parse(Reader reader, XmlOptions xmlOptions) {
            return (XmlAnySimpleType) XmlBeans.getContextTypeLoader().parse(reader, XmlAnySimpleType.type, xmlOptions);
        }

        public static XmlAnySimpleType parse(Node node) {
            return (XmlAnySimpleType) XmlBeans.getContextTypeLoader().parse(node, XmlAnySimpleType.type, (XmlOptions) null);
        }

        public static XmlAnySimpleType parse(Node node, XmlOptions xmlOptions) {
            return (XmlAnySimpleType) XmlBeans.getContextTypeLoader().parse(node, XmlAnySimpleType.type, xmlOptions);
        }

        public static XmlAnySimpleType parse(XMLInputStream xMLInputStream) {
            return (XmlAnySimpleType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlAnySimpleType.type, (XmlOptions) null);
        }

        public static XmlAnySimpleType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (XmlAnySimpleType) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlAnySimpleType.type, xmlOptions);
        }

        public static XmlAnySimpleType parse(XMLStreamReader xMLStreamReader) {
            return (XmlAnySimpleType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlAnySimpleType.type, (XmlOptions) null);
        }

        public static XmlAnySimpleType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (XmlAnySimpleType) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlAnySimpleType.type, xmlOptions);
        }
    }

    String getStringValue();

    void set(String str);

    void setStringValue(String str);

    String stringValue();
}
