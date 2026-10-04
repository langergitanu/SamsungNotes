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
public interface XmlENTITY extends XmlNCName {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_ENTITY");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Factory {
        private Factory() {
        }

        public static XmlENTITY newInstance() {
            return (XmlENTITY) XmlBeans.getContextTypeLoader().newInstance(XmlENTITY.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlENTITY.type, null);
        }

        public static XmlENTITY newValue(Object obj) {
            return (XmlENTITY) XmlENTITY.type.newValue(obj);
        }

        public static XmlENTITY parse(String str) {
            return (XmlENTITY) XmlBeans.getContextTypeLoader().parse(str, XmlENTITY.type, (XmlOptions) null);
        }

        public static XmlENTITY newInstance(XmlOptions xmlOptions) {
            return (XmlENTITY) XmlBeans.getContextTypeLoader().newInstance(XmlENTITY.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlENTITY.type, xmlOptions);
        }

        public static XmlENTITY parse(String str, XmlOptions xmlOptions) {
            return (XmlENTITY) XmlBeans.getContextTypeLoader().parse(str, XmlENTITY.type, xmlOptions);
        }

        public static XmlENTITY parse(File file) {
            return (XmlENTITY) XmlBeans.getContextTypeLoader().parse(file, XmlENTITY.type, (XmlOptions) null);
        }

        public static XmlENTITY parse(File file, XmlOptions xmlOptions) {
            return (XmlENTITY) XmlBeans.getContextTypeLoader().parse(file, XmlENTITY.type, xmlOptions);
        }

        public static XmlENTITY parse(URL url) {
            return (XmlENTITY) XmlBeans.getContextTypeLoader().parse(url, XmlENTITY.type, (XmlOptions) null);
        }

        public static XmlENTITY parse(URL url, XmlOptions xmlOptions) {
            return (XmlENTITY) XmlBeans.getContextTypeLoader().parse(url, XmlENTITY.type, xmlOptions);
        }

        public static XmlENTITY parse(InputStream inputStream) {
            return (XmlENTITY) XmlBeans.getContextTypeLoader().parse(inputStream, XmlENTITY.type, (XmlOptions) null);
        }

        public static XmlENTITY parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (XmlENTITY) XmlBeans.getContextTypeLoader().parse(inputStream, XmlENTITY.type, xmlOptions);
        }

        public static XmlENTITY parse(Reader reader) {
            return (XmlENTITY) XmlBeans.getContextTypeLoader().parse(reader, XmlENTITY.type, (XmlOptions) null);
        }

        public static XmlENTITY parse(Reader reader, XmlOptions xmlOptions) {
            return (XmlENTITY) XmlBeans.getContextTypeLoader().parse(reader, XmlENTITY.type, xmlOptions);
        }

        public static XmlENTITY parse(Node node) {
            return (XmlENTITY) XmlBeans.getContextTypeLoader().parse(node, XmlENTITY.type, (XmlOptions) null);
        }

        public static XmlENTITY parse(Node node, XmlOptions xmlOptions) {
            return (XmlENTITY) XmlBeans.getContextTypeLoader().parse(node, XmlENTITY.type, xmlOptions);
        }

        public static XmlENTITY parse(XMLInputStream xMLInputStream) {
            return (XmlENTITY) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlENTITY.type, (XmlOptions) null);
        }

        public static XmlENTITY parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (XmlENTITY) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlENTITY.type, xmlOptions);
        }

        public static XmlENTITY parse(XMLStreamReader xMLStreamReader) {
            return (XmlENTITY) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlENTITY.type, (XmlOptions) null);
        }

        public static XmlENTITY parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (XmlENTITY) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlENTITY.type, xmlOptions);
        }
    }
}
