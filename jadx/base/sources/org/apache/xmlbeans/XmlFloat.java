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
public interface XmlFloat extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_float");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Factory {
        private Factory() {
        }

        public static XmlFloat newInstance() {
            return (XmlFloat) XmlBeans.getContextTypeLoader().newInstance(XmlFloat.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlFloat.type, null);
        }

        public static XmlFloat newValue(Object obj) {
            return (XmlFloat) XmlFloat.type.newValue(obj);
        }

        public static XmlFloat parse(String str) {
            return (XmlFloat) XmlBeans.getContextTypeLoader().parse(str, XmlFloat.type, (XmlOptions) null);
        }

        public static XmlFloat newInstance(XmlOptions xmlOptions) {
            return (XmlFloat) XmlBeans.getContextTypeLoader().newInstance(XmlFloat.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlFloat.type, xmlOptions);
        }

        public static XmlFloat parse(String str, XmlOptions xmlOptions) {
            return (XmlFloat) XmlBeans.getContextTypeLoader().parse(str, XmlFloat.type, xmlOptions);
        }

        public static XmlFloat parse(File file) {
            return (XmlFloat) XmlBeans.getContextTypeLoader().parse(file, XmlFloat.type, (XmlOptions) null);
        }

        public static XmlFloat parse(File file, XmlOptions xmlOptions) {
            return (XmlFloat) XmlBeans.getContextTypeLoader().parse(file, XmlFloat.type, xmlOptions);
        }

        public static XmlFloat parse(URL url) {
            return (XmlFloat) XmlBeans.getContextTypeLoader().parse(url, XmlFloat.type, (XmlOptions) null);
        }

        public static XmlFloat parse(URL url, XmlOptions xmlOptions) {
            return (XmlFloat) XmlBeans.getContextTypeLoader().parse(url, XmlFloat.type, xmlOptions);
        }

        public static XmlFloat parse(InputStream inputStream) {
            return (XmlFloat) XmlBeans.getContextTypeLoader().parse(inputStream, XmlFloat.type, (XmlOptions) null);
        }

        public static XmlFloat parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (XmlFloat) XmlBeans.getContextTypeLoader().parse(inputStream, XmlFloat.type, xmlOptions);
        }

        public static XmlFloat parse(Reader reader) {
            return (XmlFloat) XmlBeans.getContextTypeLoader().parse(reader, XmlFloat.type, (XmlOptions) null);
        }

        public static XmlFloat parse(Reader reader, XmlOptions xmlOptions) {
            return (XmlFloat) XmlBeans.getContextTypeLoader().parse(reader, XmlFloat.type, xmlOptions);
        }

        public static XmlFloat parse(Node node) {
            return (XmlFloat) XmlBeans.getContextTypeLoader().parse(node, XmlFloat.type, (XmlOptions) null);
        }

        public static XmlFloat parse(Node node, XmlOptions xmlOptions) {
            return (XmlFloat) XmlBeans.getContextTypeLoader().parse(node, XmlFloat.type, xmlOptions);
        }

        public static XmlFloat parse(XMLInputStream xMLInputStream) {
            return (XmlFloat) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlFloat.type, (XmlOptions) null);
        }

        public static XmlFloat parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (XmlFloat) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlFloat.type, xmlOptions);
        }

        public static XmlFloat parse(XMLStreamReader xMLStreamReader) {
            return (XmlFloat) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlFloat.type, (XmlOptions) null);
        }

        public static XmlFloat parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (XmlFloat) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlFloat.type, xmlOptions);
        }
    }

    float floatValue();

    float getFloatValue();

    void set(float f);

    void setFloatValue(float f);
}
