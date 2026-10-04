package org.apache.xmlbeans;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface XmlIDREFS extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_IDREFS");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Factory {
        private Factory() {
        }

        public static XmlIDREFS newInstance() {
            return (XmlIDREFS) XmlBeans.getContextTypeLoader().newInstance(XmlIDREFS.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlIDREFS.type, null);
        }

        public static XmlIDREFS newValue(Object obj) {
            return (XmlIDREFS) XmlIDREFS.type.newValue(obj);
        }

        public static XmlIDREFS parse(String str) {
            return (XmlIDREFS) XmlBeans.getContextTypeLoader().parse(str, XmlIDREFS.type, (XmlOptions) null);
        }

        public static XmlIDREFS newInstance(XmlOptions xmlOptions) {
            return (XmlIDREFS) XmlBeans.getContextTypeLoader().newInstance(XmlIDREFS.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlIDREFS.type, xmlOptions);
        }

        public static XmlIDREFS parse(String str, XmlOptions xmlOptions) {
            return (XmlIDREFS) XmlBeans.getContextTypeLoader().parse(str, XmlIDREFS.type, xmlOptions);
        }

        public static XmlIDREFS parse(File file) {
            return (XmlIDREFS) XmlBeans.getContextTypeLoader().parse(file, XmlIDREFS.type, (XmlOptions) null);
        }

        public static XmlIDREFS parse(File file, XmlOptions xmlOptions) {
            return (XmlIDREFS) XmlBeans.getContextTypeLoader().parse(file, XmlIDREFS.type, xmlOptions);
        }

        public static XmlIDREFS parse(URL url) {
            return (XmlIDREFS) XmlBeans.getContextTypeLoader().parse(url, XmlIDREFS.type, (XmlOptions) null);
        }

        public static XmlIDREFS parse(URL url, XmlOptions xmlOptions) {
            return (XmlIDREFS) XmlBeans.getContextTypeLoader().parse(url, XmlIDREFS.type, xmlOptions);
        }

        public static XmlIDREFS parse(InputStream inputStream) {
            return (XmlIDREFS) XmlBeans.getContextTypeLoader().parse(inputStream, XmlIDREFS.type, (XmlOptions) null);
        }

        public static XmlIDREFS parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (XmlIDREFS) XmlBeans.getContextTypeLoader().parse(inputStream, XmlIDREFS.type, xmlOptions);
        }

        public static XmlIDREFS parse(Reader reader) {
            return (XmlIDREFS) XmlBeans.getContextTypeLoader().parse(reader, XmlIDREFS.type, (XmlOptions) null);
        }

        public static XmlIDREFS parse(Reader reader, XmlOptions xmlOptions) {
            return (XmlIDREFS) XmlBeans.getContextTypeLoader().parse(reader, XmlIDREFS.type, xmlOptions);
        }

        public static XmlIDREFS parse(Node node) {
            return (XmlIDREFS) XmlBeans.getContextTypeLoader().parse(node, XmlIDREFS.type, (XmlOptions) null);
        }

        public static XmlIDREFS parse(Node node, XmlOptions xmlOptions) {
            return (XmlIDREFS) XmlBeans.getContextTypeLoader().parse(node, XmlIDREFS.type, xmlOptions);
        }

        public static XmlIDREFS parse(XMLInputStream xMLInputStream) {
            return (XmlIDREFS) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlIDREFS.type, (XmlOptions) null);
        }

        public static XmlIDREFS parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (XmlIDREFS) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlIDREFS.type, xmlOptions);
        }

        public static XmlIDREFS parse(XMLStreamReader xMLStreamReader) {
            return (XmlIDREFS) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlIDREFS.type, (XmlOptions) null);
        }

        public static XmlIDREFS parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (XmlIDREFS) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlIDREFS.type, xmlOptions);
        }
    }

    List getListValue();

    List listValue();

    void set(List list);

    void setListValue(List list);

    List xgetListValue();

    List xlistValue();
}
