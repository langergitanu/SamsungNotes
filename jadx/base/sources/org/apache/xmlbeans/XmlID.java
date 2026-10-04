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
public interface XmlID extends XmlNCName {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_ID");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Factory {
        private Factory() {
        }

        public static XmlID newInstance() {
            return (XmlID) XmlBeans.getContextTypeLoader().newInstance(XmlID.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlID.type, null);
        }

        public static XmlID newValue(Object obj) {
            return (XmlID) XmlID.type.newValue(obj);
        }

        public static XmlID parse(String str) {
            return (XmlID) XmlBeans.getContextTypeLoader().parse(str, XmlID.type, (XmlOptions) null);
        }

        public static XmlID newInstance(XmlOptions xmlOptions) {
            return (XmlID) XmlBeans.getContextTypeLoader().newInstance(XmlID.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlID.type, xmlOptions);
        }

        public static XmlID parse(String str, XmlOptions xmlOptions) {
            return (XmlID) XmlBeans.getContextTypeLoader().parse(str, XmlID.type, xmlOptions);
        }

        public static XmlID parse(File file) {
            return (XmlID) XmlBeans.getContextTypeLoader().parse(file, XmlID.type, (XmlOptions) null);
        }

        public static XmlID parse(File file, XmlOptions xmlOptions) {
            return (XmlID) XmlBeans.getContextTypeLoader().parse(file, XmlID.type, xmlOptions);
        }

        public static XmlID parse(URL url) {
            return (XmlID) XmlBeans.getContextTypeLoader().parse(url, XmlID.type, (XmlOptions) null);
        }

        public static XmlID parse(URL url, XmlOptions xmlOptions) {
            return (XmlID) XmlBeans.getContextTypeLoader().parse(url, XmlID.type, xmlOptions);
        }

        public static XmlID parse(InputStream inputStream) {
            return (XmlID) XmlBeans.getContextTypeLoader().parse(inputStream, XmlID.type, (XmlOptions) null);
        }

        public static XmlID parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (XmlID) XmlBeans.getContextTypeLoader().parse(inputStream, XmlID.type, xmlOptions);
        }

        public static XmlID parse(Reader reader) {
            return (XmlID) XmlBeans.getContextTypeLoader().parse(reader, XmlID.type, (XmlOptions) null);
        }

        public static XmlID parse(Reader reader, XmlOptions xmlOptions) {
            return (XmlID) XmlBeans.getContextTypeLoader().parse(reader, XmlID.type, xmlOptions);
        }

        public static XmlID parse(Node node) {
            return (XmlID) XmlBeans.getContextTypeLoader().parse(node, XmlID.type, (XmlOptions) null);
        }

        public static XmlID parse(Node node, XmlOptions xmlOptions) {
            return (XmlID) XmlBeans.getContextTypeLoader().parse(node, XmlID.type, xmlOptions);
        }

        public static XmlID parse(XMLInputStream xMLInputStream) {
            return (XmlID) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlID.type, (XmlOptions) null);
        }

        public static XmlID parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (XmlID) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlID.type, xmlOptions);
        }

        public static XmlID parse(XMLStreamReader xMLStreamReader) {
            return (XmlID) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlID.type, (XmlOptions) null);
        }

        public static XmlID parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (XmlID) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlID.type, xmlOptions);
        }
    }
}
