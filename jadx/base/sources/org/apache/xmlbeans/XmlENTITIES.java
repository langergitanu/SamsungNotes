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
public interface XmlENTITIES extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_ENTITIES");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Factory {
        private Factory() {
        }

        public static XmlENTITIES newInstance() {
            return (XmlENTITIES) XmlBeans.getContextTypeLoader().newInstance(XmlENTITIES.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlENTITIES.type, null);
        }

        public static XmlENTITIES newValue(Object obj) {
            return (XmlENTITIES) XmlENTITIES.type.newValue(obj);
        }

        public static XmlENTITIES parse(String str) {
            return (XmlENTITIES) XmlBeans.getContextTypeLoader().parse(str, XmlENTITIES.type, (XmlOptions) null);
        }

        public static XmlENTITIES newInstance(XmlOptions xmlOptions) {
            return (XmlENTITIES) XmlBeans.getContextTypeLoader().newInstance(XmlENTITIES.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlENTITIES.type, xmlOptions);
        }

        public static XmlENTITIES parse(String str, XmlOptions xmlOptions) {
            return (XmlENTITIES) XmlBeans.getContextTypeLoader().parse(str, XmlENTITIES.type, xmlOptions);
        }

        public static XmlENTITIES parse(File file) {
            return (XmlENTITIES) XmlBeans.getContextTypeLoader().parse(file, XmlENTITIES.type, (XmlOptions) null);
        }

        public static XmlENTITIES parse(File file, XmlOptions xmlOptions) {
            return (XmlENTITIES) XmlBeans.getContextTypeLoader().parse(file, XmlENTITIES.type, xmlOptions);
        }

        public static XmlENTITIES parse(URL url) {
            return (XmlENTITIES) XmlBeans.getContextTypeLoader().parse(url, XmlENTITIES.type, (XmlOptions) null);
        }

        public static XmlENTITIES parse(URL url, XmlOptions xmlOptions) {
            return (XmlENTITIES) XmlBeans.getContextTypeLoader().parse(url, XmlENTITIES.type, xmlOptions);
        }

        public static XmlENTITIES parse(InputStream inputStream) {
            return (XmlENTITIES) XmlBeans.getContextTypeLoader().parse(inputStream, XmlENTITIES.type, (XmlOptions) null);
        }

        public static XmlENTITIES parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (XmlENTITIES) XmlBeans.getContextTypeLoader().parse(inputStream, XmlENTITIES.type, xmlOptions);
        }

        public static XmlENTITIES parse(Reader reader) {
            return (XmlENTITIES) XmlBeans.getContextTypeLoader().parse(reader, XmlENTITIES.type, (XmlOptions) null);
        }

        public static XmlENTITIES parse(Reader reader, XmlOptions xmlOptions) {
            return (XmlENTITIES) XmlBeans.getContextTypeLoader().parse(reader, XmlENTITIES.type, xmlOptions);
        }

        public static XmlENTITIES parse(Node node) {
            return (XmlENTITIES) XmlBeans.getContextTypeLoader().parse(node, XmlENTITIES.type, (XmlOptions) null);
        }

        public static XmlENTITIES parse(Node node, XmlOptions xmlOptions) {
            return (XmlENTITIES) XmlBeans.getContextTypeLoader().parse(node, XmlENTITIES.type, xmlOptions);
        }

        public static XmlENTITIES parse(XMLInputStream xMLInputStream) {
            return (XmlENTITIES) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlENTITIES.type, (XmlOptions) null);
        }

        public static XmlENTITIES parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (XmlENTITIES) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlENTITIES.type, xmlOptions);
        }

        public static XmlENTITIES parse(XMLStreamReader xMLStreamReader) {
            return (XmlENTITIES) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlENTITIES.type, (XmlOptions) null);
        }

        public static XmlENTITIES parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (XmlENTITIES) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlENTITIES.type, xmlOptions);
        }
    }

    List getListValue();

    List listValue();

    void set(List list);

    void setListValue(List list);

    List xgetListValue();

    List xlistValue();
}
