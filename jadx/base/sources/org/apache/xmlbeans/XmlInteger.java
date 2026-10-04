package org.apache.xmlbeans;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigInteger;
import java.net.URL;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface XmlInteger extends XmlDecimal {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_integer");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Factory {
        private Factory() {
        }

        public static XmlInteger newInstance() {
            return (XmlInteger) XmlBeans.getContextTypeLoader().newInstance(XmlInteger.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlInteger.type, null);
        }

        public static XmlInteger newValue(Object obj) {
            return (XmlInteger) XmlInteger.type.newValue(obj);
        }

        public static XmlInteger parse(String str) {
            return (XmlInteger) XmlBeans.getContextTypeLoader().parse(str, XmlInteger.type, (XmlOptions) null);
        }

        public static XmlInteger newInstance(XmlOptions xmlOptions) {
            return (XmlInteger) XmlBeans.getContextTypeLoader().newInstance(XmlInteger.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlInteger.type, xmlOptions);
        }

        public static XmlInteger parse(String str, XmlOptions xmlOptions) {
            return (XmlInteger) XmlBeans.getContextTypeLoader().parse(str, XmlInteger.type, xmlOptions);
        }

        public static XmlInteger parse(File file) {
            return (XmlInteger) XmlBeans.getContextTypeLoader().parse(file, XmlInteger.type, (XmlOptions) null);
        }

        public static XmlInteger parse(File file, XmlOptions xmlOptions) {
            return (XmlInteger) XmlBeans.getContextTypeLoader().parse(file, XmlInteger.type, xmlOptions);
        }

        public static XmlInteger parse(URL url) {
            return (XmlInteger) XmlBeans.getContextTypeLoader().parse(url, XmlInteger.type, (XmlOptions) null);
        }

        public static XmlInteger parse(URL url, XmlOptions xmlOptions) {
            return (XmlInteger) XmlBeans.getContextTypeLoader().parse(url, XmlInteger.type, xmlOptions);
        }

        public static XmlInteger parse(InputStream inputStream) {
            return (XmlInteger) XmlBeans.getContextTypeLoader().parse(inputStream, XmlInteger.type, (XmlOptions) null);
        }

        public static XmlInteger parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (XmlInteger) XmlBeans.getContextTypeLoader().parse(inputStream, XmlInteger.type, xmlOptions);
        }

        public static XmlInteger parse(Reader reader) {
            return (XmlInteger) XmlBeans.getContextTypeLoader().parse(reader, XmlInteger.type, (XmlOptions) null);
        }

        public static XmlInteger parse(Reader reader, XmlOptions xmlOptions) {
            return (XmlInteger) XmlBeans.getContextTypeLoader().parse(reader, XmlInteger.type, xmlOptions);
        }

        public static XmlInteger parse(Node node) {
            return (XmlInteger) XmlBeans.getContextTypeLoader().parse(node, XmlInteger.type, (XmlOptions) null);
        }

        public static XmlInteger parse(Node node, XmlOptions xmlOptions) {
            return (XmlInteger) XmlBeans.getContextTypeLoader().parse(node, XmlInteger.type, xmlOptions);
        }

        public static XmlInteger parse(XMLInputStream xMLInputStream) {
            return (XmlInteger) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlInteger.type, (XmlOptions) null);
        }

        public static XmlInteger parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (XmlInteger) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlInteger.type, xmlOptions);
        }

        public static XmlInteger parse(XMLStreamReader xMLStreamReader) {
            return (XmlInteger) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlInteger.type, (XmlOptions) null);
        }

        public static XmlInteger parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (XmlInteger) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlInteger.type, xmlOptions);
        }
    }

    BigInteger bigIntegerValue();

    BigInteger getBigIntegerValue();

    void set(BigInteger bigInteger);

    void setBigIntegerValue(BigInteger bigInteger);
}
