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
public interface XmlNMTOKENS extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_NMTOKENS");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Factory {
        private Factory() {
        }

        public static XmlNMTOKENS newInstance() {
            return (XmlNMTOKENS) XmlBeans.getContextTypeLoader().newInstance(XmlNMTOKENS.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlNMTOKENS.type, null);
        }

        public static XmlNMTOKENS newValue(Object obj) {
            return (XmlNMTOKENS) XmlNMTOKENS.type.newValue(obj);
        }

        public static XmlNMTOKENS parse(String str) {
            return (XmlNMTOKENS) XmlBeans.getContextTypeLoader().parse(str, XmlNMTOKENS.type, (XmlOptions) null);
        }

        public static XmlNMTOKENS newInstance(XmlOptions xmlOptions) {
            return (XmlNMTOKENS) XmlBeans.getContextTypeLoader().newInstance(XmlNMTOKENS.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlNMTOKENS.type, xmlOptions);
        }

        public static XmlNMTOKENS parse(String str, XmlOptions xmlOptions) {
            return (XmlNMTOKENS) XmlBeans.getContextTypeLoader().parse(str, XmlNMTOKENS.type, xmlOptions);
        }

        public static XmlNMTOKENS parse(File file) {
            return (XmlNMTOKENS) XmlBeans.getContextTypeLoader().parse(file, XmlNMTOKENS.type, (XmlOptions) null);
        }

        public static XmlNMTOKENS parse(File file, XmlOptions xmlOptions) {
            return (XmlNMTOKENS) XmlBeans.getContextTypeLoader().parse(file, XmlNMTOKENS.type, xmlOptions);
        }

        public static XmlNMTOKENS parse(URL url) {
            return (XmlNMTOKENS) XmlBeans.getContextTypeLoader().parse(url, XmlNMTOKENS.type, (XmlOptions) null);
        }

        public static XmlNMTOKENS parse(URL url, XmlOptions xmlOptions) {
            return (XmlNMTOKENS) XmlBeans.getContextTypeLoader().parse(url, XmlNMTOKENS.type, xmlOptions);
        }

        public static XmlNMTOKENS parse(InputStream inputStream) {
            return (XmlNMTOKENS) XmlBeans.getContextTypeLoader().parse(inputStream, XmlNMTOKENS.type, (XmlOptions) null);
        }

        public static XmlNMTOKENS parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (XmlNMTOKENS) XmlBeans.getContextTypeLoader().parse(inputStream, XmlNMTOKENS.type, xmlOptions);
        }

        public static XmlNMTOKENS parse(Reader reader) {
            return (XmlNMTOKENS) XmlBeans.getContextTypeLoader().parse(reader, XmlNMTOKENS.type, (XmlOptions) null);
        }

        public static XmlNMTOKENS parse(Reader reader, XmlOptions xmlOptions) {
            return (XmlNMTOKENS) XmlBeans.getContextTypeLoader().parse(reader, XmlNMTOKENS.type, xmlOptions);
        }

        public static XmlNMTOKENS parse(Node node) {
            return (XmlNMTOKENS) XmlBeans.getContextTypeLoader().parse(node, XmlNMTOKENS.type, (XmlOptions) null);
        }

        public static XmlNMTOKENS parse(Node node, XmlOptions xmlOptions) {
            return (XmlNMTOKENS) XmlBeans.getContextTypeLoader().parse(node, XmlNMTOKENS.type, xmlOptions);
        }

        public static XmlNMTOKENS parse(XMLInputStream xMLInputStream) {
            return (XmlNMTOKENS) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlNMTOKENS.type, (XmlOptions) null);
        }

        public static XmlNMTOKENS parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (XmlNMTOKENS) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlNMTOKENS.type, xmlOptions);
        }

        public static XmlNMTOKENS parse(XMLStreamReader xMLStreamReader) {
            return (XmlNMTOKENS) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlNMTOKENS.type, (XmlOptions) null);
        }

        public static XmlNMTOKENS parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (XmlNMTOKENS) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlNMTOKENS.type, xmlOptions);
        }
    }

    List getListValue();

    List listValue();

    void set(List list);

    void setListValue(List list);

    List xgetListValue();

    List xlistValue();
}
