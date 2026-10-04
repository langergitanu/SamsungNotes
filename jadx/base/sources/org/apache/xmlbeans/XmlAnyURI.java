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
public interface XmlAnyURI extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_anyURI");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Factory {
        private Factory() {
        }

        public static XmlAnyURI newInstance() {
            return (XmlAnyURI) XmlBeans.getContextTypeLoader().newInstance(XmlAnyURI.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlAnyURI.type, null);
        }

        public static XmlAnyURI newValue(Object obj) {
            return (XmlAnyURI) XmlAnyURI.type.newValue(obj);
        }

        public static XmlAnyURI parse(String str) {
            return (XmlAnyURI) XmlBeans.getContextTypeLoader().parse(str, XmlAnyURI.type, (XmlOptions) null);
        }

        public static XmlAnyURI newInstance(XmlOptions xmlOptions) {
            return (XmlAnyURI) XmlBeans.getContextTypeLoader().newInstance(XmlAnyURI.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlAnyURI.type, xmlOptions);
        }

        public static XmlAnyURI parse(String str, XmlOptions xmlOptions) {
            return (XmlAnyURI) XmlBeans.getContextTypeLoader().parse(str, XmlAnyURI.type, xmlOptions);
        }

        public static XmlAnyURI parse(File file) {
            return (XmlAnyURI) XmlBeans.getContextTypeLoader().parse(file, XmlAnyURI.type, (XmlOptions) null);
        }

        public static XmlAnyURI parse(File file, XmlOptions xmlOptions) {
            return (XmlAnyURI) XmlBeans.getContextTypeLoader().parse(file, XmlAnyURI.type, xmlOptions);
        }

        public static XmlAnyURI parse(URL url) {
            return (XmlAnyURI) XmlBeans.getContextTypeLoader().parse(url, XmlAnyURI.type, (XmlOptions) null);
        }

        public static XmlAnyURI parse(URL url, XmlOptions xmlOptions) {
            return (XmlAnyURI) XmlBeans.getContextTypeLoader().parse(url, XmlAnyURI.type, xmlOptions);
        }

        public static XmlAnyURI parse(InputStream inputStream) {
            return (XmlAnyURI) XmlBeans.getContextTypeLoader().parse(inputStream, XmlAnyURI.type, (XmlOptions) null);
        }

        public static XmlAnyURI parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (XmlAnyURI) XmlBeans.getContextTypeLoader().parse(inputStream, XmlAnyURI.type, xmlOptions);
        }

        public static XmlAnyURI parse(Reader reader) {
            return (XmlAnyURI) XmlBeans.getContextTypeLoader().parse(reader, XmlAnyURI.type, (XmlOptions) null);
        }

        public static XmlAnyURI parse(Reader reader, XmlOptions xmlOptions) {
            return (XmlAnyURI) XmlBeans.getContextTypeLoader().parse(reader, XmlAnyURI.type, xmlOptions);
        }

        public static XmlAnyURI parse(Node node) {
            return (XmlAnyURI) XmlBeans.getContextTypeLoader().parse(node, XmlAnyURI.type, (XmlOptions) null);
        }

        public static XmlAnyURI parse(Node node, XmlOptions xmlOptions) {
            return (XmlAnyURI) XmlBeans.getContextTypeLoader().parse(node, XmlAnyURI.type, xmlOptions);
        }

        public static XmlAnyURI parse(XMLInputStream xMLInputStream) {
            return (XmlAnyURI) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlAnyURI.type, (XmlOptions) null);
        }

        public static XmlAnyURI parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (XmlAnyURI) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlAnyURI.type, xmlOptions);
        }

        public static XmlAnyURI parse(XMLStreamReader xMLStreamReader) {
            return (XmlAnyURI) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlAnyURI.type, (XmlOptions) null);
        }

        public static XmlAnyURI parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (XmlAnyURI) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlAnyURI.type, xmlOptions);
        }
    }
}
