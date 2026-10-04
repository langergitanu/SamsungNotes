package org.apache.xmlbeans;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface XmlQName extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_QName");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Factory {
        private Factory() {
        }

        public static XmlQName newInstance() {
            return (XmlQName) XmlBeans.getContextTypeLoader().newInstance(XmlQName.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlQName.type, null);
        }

        public static XmlQName newValue(Object obj) {
            return (XmlQName) XmlQName.type.newValue(obj);
        }

        public static XmlQName parse(String str) {
            return (XmlQName) XmlBeans.getContextTypeLoader().parse(str, XmlQName.type, (XmlOptions) null);
        }

        public static XmlQName newInstance(XmlOptions xmlOptions) {
            return (XmlQName) XmlBeans.getContextTypeLoader().newInstance(XmlQName.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlQName.type, xmlOptions);
        }

        public static XmlQName parse(String str, XmlOptions xmlOptions) {
            return (XmlQName) XmlBeans.getContextTypeLoader().parse(str, XmlQName.type, xmlOptions);
        }

        public static XmlQName parse(File file) {
            return (XmlQName) XmlBeans.getContextTypeLoader().parse(file, XmlQName.type, (XmlOptions) null);
        }

        public static XmlQName parse(File file, XmlOptions xmlOptions) {
            return (XmlQName) XmlBeans.getContextTypeLoader().parse(file, XmlQName.type, xmlOptions);
        }

        public static XmlQName parse(URL url) {
            return (XmlQName) XmlBeans.getContextTypeLoader().parse(url, XmlQName.type, (XmlOptions) null);
        }

        public static XmlQName parse(URL url, XmlOptions xmlOptions) {
            return (XmlQName) XmlBeans.getContextTypeLoader().parse(url, XmlQName.type, xmlOptions);
        }

        public static XmlQName parse(InputStream inputStream) {
            return (XmlQName) XmlBeans.getContextTypeLoader().parse(inputStream, XmlQName.type, (XmlOptions) null);
        }

        public static XmlQName parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (XmlQName) XmlBeans.getContextTypeLoader().parse(inputStream, XmlQName.type, xmlOptions);
        }

        public static XmlQName parse(Reader reader) {
            return (XmlQName) XmlBeans.getContextTypeLoader().parse(reader, XmlQName.type, (XmlOptions) null);
        }

        public static XmlQName parse(Reader reader, XmlOptions xmlOptions) {
            return (XmlQName) XmlBeans.getContextTypeLoader().parse(reader, XmlQName.type, xmlOptions);
        }

        public static XmlQName parse(Node node) {
            return (XmlQName) XmlBeans.getContextTypeLoader().parse(node, XmlQName.type, (XmlOptions) null);
        }

        public static XmlQName parse(Node node, XmlOptions xmlOptions) {
            return (XmlQName) XmlBeans.getContextTypeLoader().parse(node, XmlQName.type, xmlOptions);
        }

        public static XmlQName parse(XMLInputStream xMLInputStream) {
            return (XmlQName) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlQName.type, (XmlOptions) null);
        }

        public static XmlQName parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (XmlQName) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlQName.type, xmlOptions);
        }

        public static XmlQName parse(XMLStreamReader xMLStreamReader) {
            return (XmlQName) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlQName.type, (XmlOptions) null);
        }

        public static XmlQName parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (XmlQName) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlQName.type, xmlOptions);
        }
    }

    QName getQNameValue();

    QName qNameValue();

    void set(QName qName);

    void setQNameValue(QName qName);
}
