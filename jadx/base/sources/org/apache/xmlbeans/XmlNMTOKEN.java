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
public interface XmlNMTOKEN extends XmlToken {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_NMTOKEN");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Factory {
        private Factory() {
        }

        public static XmlNMTOKEN newInstance() {
            return (XmlNMTOKEN) XmlBeans.getContextTypeLoader().newInstance(XmlNMTOKEN.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlNMTOKEN.type, null);
        }

        public static XmlNMTOKEN newValue(Object obj) {
            return (XmlNMTOKEN) XmlNMTOKEN.type.newValue(obj);
        }

        public static XmlNMTOKEN parse(String str) {
            return (XmlNMTOKEN) XmlBeans.getContextTypeLoader().parse(str, XmlNMTOKEN.type, (XmlOptions) null);
        }

        public static XmlNMTOKEN newInstance(XmlOptions xmlOptions) {
            return (XmlNMTOKEN) XmlBeans.getContextTypeLoader().newInstance(XmlNMTOKEN.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlNMTOKEN.type, xmlOptions);
        }

        public static XmlNMTOKEN parse(String str, XmlOptions xmlOptions) {
            return (XmlNMTOKEN) XmlBeans.getContextTypeLoader().parse(str, XmlNMTOKEN.type, xmlOptions);
        }

        public static XmlNMTOKEN parse(File file) {
            return (XmlNMTOKEN) XmlBeans.getContextTypeLoader().parse(file, XmlNMTOKEN.type, (XmlOptions) null);
        }

        public static XmlNMTOKEN parse(File file, XmlOptions xmlOptions) {
            return (XmlNMTOKEN) XmlBeans.getContextTypeLoader().parse(file, XmlNMTOKEN.type, xmlOptions);
        }

        public static XmlNMTOKEN parse(URL url) {
            return (XmlNMTOKEN) XmlBeans.getContextTypeLoader().parse(url, XmlNMTOKEN.type, (XmlOptions) null);
        }

        public static XmlNMTOKEN parse(URL url, XmlOptions xmlOptions) {
            return (XmlNMTOKEN) XmlBeans.getContextTypeLoader().parse(url, XmlNMTOKEN.type, xmlOptions);
        }

        public static XmlNMTOKEN parse(InputStream inputStream) {
            return (XmlNMTOKEN) XmlBeans.getContextTypeLoader().parse(inputStream, XmlNMTOKEN.type, (XmlOptions) null);
        }

        public static XmlNMTOKEN parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (XmlNMTOKEN) XmlBeans.getContextTypeLoader().parse(inputStream, XmlNMTOKEN.type, xmlOptions);
        }

        public static XmlNMTOKEN parse(Reader reader) {
            return (XmlNMTOKEN) XmlBeans.getContextTypeLoader().parse(reader, XmlNMTOKEN.type, (XmlOptions) null);
        }

        public static XmlNMTOKEN parse(Reader reader, XmlOptions xmlOptions) {
            return (XmlNMTOKEN) XmlBeans.getContextTypeLoader().parse(reader, XmlNMTOKEN.type, xmlOptions);
        }

        public static XmlNMTOKEN parse(Node node) {
            return (XmlNMTOKEN) XmlBeans.getContextTypeLoader().parse(node, XmlNMTOKEN.type, (XmlOptions) null);
        }

        public static XmlNMTOKEN parse(Node node, XmlOptions xmlOptions) {
            return (XmlNMTOKEN) XmlBeans.getContextTypeLoader().parse(node, XmlNMTOKEN.type, xmlOptions);
        }

        public static XmlNMTOKEN parse(XMLInputStream xMLInputStream) {
            return (XmlNMTOKEN) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlNMTOKEN.type, (XmlOptions) null);
        }

        public static XmlNMTOKEN parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (XmlNMTOKEN) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlNMTOKEN.type, xmlOptions);
        }

        public static XmlNMTOKEN parse(XMLStreamReader xMLStreamReader) {
            return (XmlNMTOKEN) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlNMTOKEN.type, (XmlOptions) null);
        }

        public static XmlNMTOKEN parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (XmlNMTOKEN) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlNMTOKEN.type, xmlOptions);
        }
    }
}
