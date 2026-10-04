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
public interface XmlNCName extends XmlName {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_NCName");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Factory {
        private Factory() {
        }

        public static XmlNCName newInstance() {
            return (XmlNCName) XmlBeans.getContextTypeLoader().newInstance(XmlNCName.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlNCName.type, null);
        }

        public static XmlNCName newValue(Object obj) {
            return (XmlNCName) XmlNCName.type.newValue(obj);
        }

        public static XmlNCName parse(String str) {
            return (XmlNCName) XmlBeans.getContextTypeLoader().parse(str, XmlNCName.type, (XmlOptions) null);
        }

        public static XmlNCName newInstance(XmlOptions xmlOptions) {
            return (XmlNCName) XmlBeans.getContextTypeLoader().newInstance(XmlNCName.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlNCName.type, xmlOptions);
        }

        public static XmlNCName parse(String str, XmlOptions xmlOptions) {
            return (XmlNCName) XmlBeans.getContextTypeLoader().parse(str, XmlNCName.type, xmlOptions);
        }

        public static XmlNCName parse(File file) {
            return (XmlNCName) XmlBeans.getContextTypeLoader().parse(file, XmlNCName.type, (XmlOptions) null);
        }

        public static XmlNCName parse(File file, XmlOptions xmlOptions) {
            return (XmlNCName) XmlBeans.getContextTypeLoader().parse(file, XmlNCName.type, xmlOptions);
        }

        public static XmlNCName parse(URL url) {
            return (XmlNCName) XmlBeans.getContextTypeLoader().parse(url, XmlNCName.type, (XmlOptions) null);
        }

        public static XmlNCName parse(URL url, XmlOptions xmlOptions) {
            return (XmlNCName) XmlBeans.getContextTypeLoader().parse(url, XmlNCName.type, xmlOptions);
        }

        public static XmlNCName parse(InputStream inputStream) {
            return (XmlNCName) XmlBeans.getContextTypeLoader().parse(inputStream, XmlNCName.type, (XmlOptions) null);
        }

        public static XmlNCName parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (XmlNCName) XmlBeans.getContextTypeLoader().parse(inputStream, XmlNCName.type, xmlOptions);
        }

        public static XmlNCName parse(Reader reader) {
            return (XmlNCName) XmlBeans.getContextTypeLoader().parse(reader, XmlNCName.type, (XmlOptions) null);
        }

        public static XmlNCName parse(Reader reader, XmlOptions xmlOptions) {
            return (XmlNCName) XmlBeans.getContextTypeLoader().parse(reader, XmlNCName.type, xmlOptions);
        }

        public static XmlNCName parse(Node node) {
            return (XmlNCName) XmlBeans.getContextTypeLoader().parse(node, XmlNCName.type, (XmlOptions) null);
        }

        public static XmlNCName parse(Node node, XmlOptions xmlOptions) {
            return (XmlNCName) XmlBeans.getContextTypeLoader().parse(node, XmlNCName.type, xmlOptions);
        }

        public static XmlNCName parse(XMLInputStream xMLInputStream) {
            return (XmlNCName) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlNCName.type, (XmlOptions) null);
        }

        public static XmlNCName parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (XmlNCName) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlNCName.type, xmlOptions);
        }

        public static XmlNCName parse(XMLStreamReader xMLStreamReader) {
            return (XmlNCName) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlNCName.type, (XmlOptions) null);
        }

        public static XmlNCName parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (XmlNCName) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlNCName.type, xmlOptions);
        }
    }
}
