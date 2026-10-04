package org.apache.xmlbeans;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface XmlDecimal extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_decimal");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Factory {
        private Factory() {
        }

        public static XmlDecimal newInstance() {
            return (XmlDecimal) XmlBeans.getContextTypeLoader().newInstance(XmlDecimal.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlDecimal.type, null);
        }

        public static XmlDecimal newValue(Object obj) {
            return (XmlDecimal) XmlDecimal.type.newValue(obj);
        }

        public static XmlDecimal parse(String str) {
            return (XmlDecimal) XmlBeans.getContextTypeLoader().parse(str, XmlDecimal.type, (XmlOptions) null);
        }

        public static XmlDecimal newInstance(XmlOptions xmlOptions) {
            return (XmlDecimal) XmlBeans.getContextTypeLoader().newInstance(XmlDecimal.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlDecimal.type, xmlOptions);
        }

        public static XmlDecimal parse(String str, XmlOptions xmlOptions) {
            return (XmlDecimal) XmlBeans.getContextTypeLoader().parse(str, XmlDecimal.type, xmlOptions);
        }

        public static XmlDecimal parse(File file) {
            return (XmlDecimal) XmlBeans.getContextTypeLoader().parse(file, XmlDecimal.type, (XmlOptions) null);
        }

        public static XmlDecimal parse(File file, XmlOptions xmlOptions) {
            return (XmlDecimal) XmlBeans.getContextTypeLoader().parse(file, XmlDecimal.type, xmlOptions);
        }

        public static XmlDecimal parse(URL url) {
            return (XmlDecimal) XmlBeans.getContextTypeLoader().parse(url, XmlDecimal.type, (XmlOptions) null);
        }

        public static XmlDecimal parse(URL url, XmlOptions xmlOptions) {
            return (XmlDecimal) XmlBeans.getContextTypeLoader().parse(url, XmlDecimal.type, xmlOptions);
        }

        public static XmlDecimal parse(InputStream inputStream) {
            return (XmlDecimal) XmlBeans.getContextTypeLoader().parse(inputStream, XmlDecimal.type, (XmlOptions) null);
        }

        public static XmlDecimal parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (XmlDecimal) XmlBeans.getContextTypeLoader().parse(inputStream, XmlDecimal.type, xmlOptions);
        }

        public static XmlDecimal parse(Reader reader) {
            return (XmlDecimal) XmlBeans.getContextTypeLoader().parse(reader, XmlDecimal.type, (XmlOptions) null);
        }

        public static XmlDecimal parse(Reader reader, XmlOptions xmlOptions) {
            return (XmlDecimal) XmlBeans.getContextTypeLoader().parse(reader, XmlDecimal.type, xmlOptions);
        }

        public static XmlDecimal parse(Node node) {
            return (XmlDecimal) XmlBeans.getContextTypeLoader().parse(node, XmlDecimal.type, (XmlOptions) null);
        }

        public static XmlDecimal parse(Node node, XmlOptions xmlOptions) {
            return (XmlDecimal) XmlBeans.getContextTypeLoader().parse(node, XmlDecimal.type, xmlOptions);
        }

        public static XmlDecimal parse(XMLInputStream xMLInputStream) {
            return (XmlDecimal) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlDecimal.type, (XmlOptions) null);
        }

        public static XmlDecimal parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (XmlDecimal) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlDecimal.type, xmlOptions);
        }

        public static XmlDecimal parse(XMLStreamReader xMLStreamReader) {
            return (XmlDecimal) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlDecimal.type, (XmlOptions) null);
        }

        public static XmlDecimal parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (XmlDecimal) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlDecimal.type, xmlOptions);
        }
    }

    BigDecimal bigDecimalValue();

    BigDecimal getBigDecimalValue();

    void set(BigDecimal bigDecimal);

    void setBigDecimalValue(BigDecimal bigDecimal);
}
