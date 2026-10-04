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
public interface XmlName extends XmlToken {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_Name");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Factory {
        private Factory() {
        }

        public static XmlName newInstance() {
            return (XmlName) XmlBeans.getContextTypeLoader().newInstance(XmlName.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlName.type, null);
        }

        public static XmlName newValue(Object obj) {
            return (XmlName) XmlName.type.newValue(obj);
        }

        public static XmlName parse(String str) {
            return (XmlName) XmlBeans.getContextTypeLoader().parse(str, XmlName.type, (XmlOptions) null);
        }

        public static XmlName newInstance(XmlOptions xmlOptions) {
            return (XmlName) XmlBeans.getContextTypeLoader().newInstance(XmlName.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlName.type, xmlOptions);
        }

        public static XmlName parse(String str, XmlOptions xmlOptions) {
            return (XmlName) XmlBeans.getContextTypeLoader().parse(str, XmlName.type, xmlOptions);
        }

        public static XmlName parse(File file) {
            return (XmlName) XmlBeans.getContextTypeLoader().parse(file, XmlName.type, (XmlOptions) null);
        }

        public static XmlName parse(File file, XmlOptions xmlOptions) {
            return (XmlName) XmlBeans.getContextTypeLoader().parse(file, XmlName.type, xmlOptions);
        }

        public static XmlName parse(URL url) {
            return (XmlName) XmlBeans.getContextTypeLoader().parse(url, XmlName.type, (XmlOptions) null);
        }

        public static XmlName parse(URL url, XmlOptions xmlOptions) {
            return (XmlName) XmlBeans.getContextTypeLoader().parse(url, XmlName.type, xmlOptions);
        }

        public static XmlName parse(InputStream inputStream) {
            return (XmlName) XmlBeans.getContextTypeLoader().parse(inputStream, XmlName.type, (XmlOptions) null);
        }

        public static XmlName parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (XmlName) XmlBeans.getContextTypeLoader().parse(inputStream, XmlName.type, xmlOptions);
        }

        public static XmlName parse(Reader reader) {
            return (XmlName) XmlBeans.getContextTypeLoader().parse(reader, XmlName.type, (XmlOptions) null);
        }

        public static XmlName parse(Reader reader, XmlOptions xmlOptions) {
            return (XmlName) XmlBeans.getContextTypeLoader().parse(reader, XmlName.type, xmlOptions);
        }

        public static XmlName parse(Node node) {
            return (XmlName) XmlBeans.getContextTypeLoader().parse(node, XmlName.type, (XmlOptions) null);
        }

        public static XmlName parse(Node node, XmlOptions xmlOptions) {
            return (XmlName) XmlBeans.getContextTypeLoader().parse(node, XmlName.type, xmlOptions);
        }

        public static XmlName parse(XMLInputStream xMLInputStream) {
            return (XmlName) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlName.type, (XmlOptions) null);
        }

        public static XmlName parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (XmlName) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlName.type, xmlOptions);
        }

        public static XmlName parse(XMLStreamReader xMLStreamReader) {
            return (XmlName) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlName.type, (XmlOptions) null);
        }

        public static XmlName parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (XmlName) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlName.type, xmlOptions);
        }
    }
}
