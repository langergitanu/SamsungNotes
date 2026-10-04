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
public interface XmlString extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_string");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Factory {
        private Factory() {
        }

        public static XmlString newInstance() {
            return (XmlString) XmlBeans.getContextTypeLoader().newInstance(XmlString.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlString.type, null);
        }

        public static XmlString newValue(Object obj) {
            return (XmlString) XmlString.type.newValue(obj);
        }

        public static XmlString parse(String str) {
            return (XmlString) XmlBeans.getContextTypeLoader().parse(str, XmlString.type, (XmlOptions) null);
        }

        public static XmlString newInstance(XmlOptions xmlOptions) {
            return (XmlString) XmlBeans.getContextTypeLoader().newInstance(XmlString.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlString.type, xmlOptions);
        }

        public static XmlString parse(String str, XmlOptions xmlOptions) {
            return (XmlString) XmlBeans.getContextTypeLoader().parse(str, XmlString.type, xmlOptions);
        }

        public static XmlString parse(File file) {
            return (XmlString) XmlBeans.getContextTypeLoader().parse(file, XmlString.type, (XmlOptions) null);
        }

        public static XmlString parse(File file, XmlOptions xmlOptions) {
            return (XmlString) XmlBeans.getContextTypeLoader().parse(file, XmlString.type, xmlOptions);
        }

        public static XmlString parse(URL url) {
            return (XmlString) XmlBeans.getContextTypeLoader().parse(url, XmlString.type, (XmlOptions) null);
        }

        public static XmlString parse(URL url, XmlOptions xmlOptions) {
            return (XmlString) XmlBeans.getContextTypeLoader().parse(url, XmlString.type, xmlOptions);
        }

        public static XmlString parse(InputStream inputStream) {
            return (XmlString) XmlBeans.getContextTypeLoader().parse(inputStream, XmlString.type, (XmlOptions) null);
        }

        public static XmlString parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (XmlString) XmlBeans.getContextTypeLoader().parse(inputStream, XmlString.type, xmlOptions);
        }

        public static XmlString parse(Reader reader) {
            return (XmlString) XmlBeans.getContextTypeLoader().parse(reader, XmlString.type, (XmlOptions) null);
        }

        public static XmlString parse(Reader reader, XmlOptions xmlOptions) {
            return (XmlString) XmlBeans.getContextTypeLoader().parse(reader, XmlString.type, xmlOptions);
        }

        public static XmlString parse(Node node) {
            return (XmlString) XmlBeans.getContextTypeLoader().parse(node, XmlString.type, (XmlOptions) null);
        }

        public static XmlString parse(Node node, XmlOptions xmlOptions) {
            return (XmlString) XmlBeans.getContextTypeLoader().parse(node, XmlString.type, xmlOptions);
        }

        public static XmlString parse(XMLInputStream xMLInputStream) {
            return (XmlString) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlString.type, (XmlOptions) null);
        }

        public static XmlString parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (XmlString) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlString.type, xmlOptions);
        }

        public static XmlString parse(XMLStreamReader xMLStreamReader) {
            return (XmlString) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlString.type, (XmlOptions) null);
        }

        public static XmlString parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (XmlString) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlString.type, xmlOptions);
        }
    }
}
