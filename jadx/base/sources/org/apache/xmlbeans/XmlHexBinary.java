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
public interface XmlHexBinary extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_hexBinary");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Factory {
        private Factory() {
        }

        public static XmlHexBinary newInstance() {
            return (XmlHexBinary) XmlBeans.getContextTypeLoader().newInstance(XmlHexBinary.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlHexBinary.type, null);
        }

        public static XmlHexBinary newValue(Object obj) {
            return (XmlHexBinary) XmlHexBinary.type.newValue(obj);
        }

        public static XmlHexBinary parse(String str) {
            return (XmlHexBinary) XmlBeans.getContextTypeLoader().parse(str, XmlHexBinary.type, (XmlOptions) null);
        }

        public static XmlHexBinary newInstance(XmlOptions xmlOptions) {
            return (XmlHexBinary) XmlBeans.getContextTypeLoader().newInstance(XmlHexBinary.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlHexBinary.type, xmlOptions);
        }

        public static XmlHexBinary parse(String str, XmlOptions xmlOptions) {
            return (XmlHexBinary) XmlBeans.getContextTypeLoader().parse(str, XmlHexBinary.type, xmlOptions);
        }

        public static XmlHexBinary parse(File file) {
            return (XmlHexBinary) XmlBeans.getContextTypeLoader().parse(file, XmlHexBinary.type, (XmlOptions) null);
        }

        public static XmlHexBinary parse(File file, XmlOptions xmlOptions) {
            return (XmlHexBinary) XmlBeans.getContextTypeLoader().parse(file, XmlHexBinary.type, xmlOptions);
        }

        public static XmlHexBinary parse(URL url) {
            return (XmlHexBinary) XmlBeans.getContextTypeLoader().parse(url, XmlHexBinary.type, (XmlOptions) null);
        }

        public static XmlHexBinary parse(URL url, XmlOptions xmlOptions) {
            return (XmlHexBinary) XmlBeans.getContextTypeLoader().parse(url, XmlHexBinary.type, xmlOptions);
        }

        public static XmlHexBinary parse(InputStream inputStream) {
            return (XmlHexBinary) XmlBeans.getContextTypeLoader().parse(inputStream, XmlHexBinary.type, (XmlOptions) null);
        }

        public static XmlHexBinary parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (XmlHexBinary) XmlBeans.getContextTypeLoader().parse(inputStream, XmlHexBinary.type, xmlOptions);
        }

        public static XmlHexBinary parse(Reader reader) {
            return (XmlHexBinary) XmlBeans.getContextTypeLoader().parse(reader, XmlHexBinary.type, (XmlOptions) null);
        }

        public static XmlHexBinary parse(Reader reader, XmlOptions xmlOptions) {
            return (XmlHexBinary) XmlBeans.getContextTypeLoader().parse(reader, XmlHexBinary.type, xmlOptions);
        }

        public static XmlHexBinary parse(Node node) {
            return (XmlHexBinary) XmlBeans.getContextTypeLoader().parse(node, XmlHexBinary.type, (XmlOptions) null);
        }

        public static XmlHexBinary parse(Node node, XmlOptions xmlOptions) {
            return (XmlHexBinary) XmlBeans.getContextTypeLoader().parse(node, XmlHexBinary.type, xmlOptions);
        }

        public static XmlHexBinary parse(XMLInputStream xMLInputStream) {
            return (XmlHexBinary) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlHexBinary.type, (XmlOptions) null);
        }

        public static XmlHexBinary parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (XmlHexBinary) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlHexBinary.type, xmlOptions);
        }

        public static XmlHexBinary parse(XMLStreamReader xMLStreamReader) {
            return (XmlHexBinary) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlHexBinary.type, (XmlOptions) null);
        }

        public static XmlHexBinary parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (XmlHexBinary) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlHexBinary.type, xmlOptions);
        }
    }

    byte[] byteArrayValue();

    byte[] getByteArrayValue();

    void set(byte[] bArr);

    void setByteArrayValue(byte[] bArr);
}
