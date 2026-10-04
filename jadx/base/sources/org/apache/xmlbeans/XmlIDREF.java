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
public interface XmlIDREF extends XmlNCName {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_IDREF");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Factory {
        private Factory() {
        }

        public static XmlIDREF newInstance() {
            return (XmlIDREF) XmlBeans.getContextTypeLoader().newInstance(XmlIDREF.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlIDREF.type, null);
        }

        public static XmlIDREF newValue(Object obj) {
            return (XmlIDREF) XmlIDREF.type.newValue(obj);
        }

        public static XmlIDREF parse(String str) {
            return (XmlIDREF) XmlBeans.getContextTypeLoader().parse(str, XmlIDREF.type, (XmlOptions) null);
        }

        public static XmlIDREF newInstance(XmlOptions xmlOptions) {
            return (XmlIDREF) XmlBeans.getContextTypeLoader().newInstance(XmlIDREF.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlIDREF.type, xmlOptions);
        }

        public static XmlIDREF parse(String str, XmlOptions xmlOptions) {
            return (XmlIDREF) XmlBeans.getContextTypeLoader().parse(str, XmlIDREF.type, xmlOptions);
        }

        public static XmlIDREF parse(File file) {
            return (XmlIDREF) XmlBeans.getContextTypeLoader().parse(file, XmlIDREF.type, (XmlOptions) null);
        }

        public static XmlIDREF parse(File file, XmlOptions xmlOptions) {
            return (XmlIDREF) XmlBeans.getContextTypeLoader().parse(file, XmlIDREF.type, xmlOptions);
        }

        public static XmlIDREF parse(URL url) {
            return (XmlIDREF) XmlBeans.getContextTypeLoader().parse(url, XmlIDREF.type, (XmlOptions) null);
        }

        public static XmlIDREF parse(URL url, XmlOptions xmlOptions) {
            return (XmlIDREF) XmlBeans.getContextTypeLoader().parse(url, XmlIDREF.type, xmlOptions);
        }

        public static XmlIDREF parse(InputStream inputStream) {
            return (XmlIDREF) XmlBeans.getContextTypeLoader().parse(inputStream, XmlIDREF.type, (XmlOptions) null);
        }

        public static XmlIDREF parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (XmlIDREF) XmlBeans.getContextTypeLoader().parse(inputStream, XmlIDREF.type, xmlOptions);
        }

        public static XmlIDREF parse(Reader reader) {
            return (XmlIDREF) XmlBeans.getContextTypeLoader().parse(reader, XmlIDREF.type, (XmlOptions) null);
        }

        public static XmlIDREF parse(Reader reader, XmlOptions xmlOptions) {
            return (XmlIDREF) XmlBeans.getContextTypeLoader().parse(reader, XmlIDREF.type, xmlOptions);
        }

        public static XmlIDREF parse(Node node) {
            return (XmlIDREF) XmlBeans.getContextTypeLoader().parse(node, XmlIDREF.type, (XmlOptions) null);
        }

        public static XmlIDREF parse(Node node, XmlOptions xmlOptions) {
            return (XmlIDREF) XmlBeans.getContextTypeLoader().parse(node, XmlIDREF.type, xmlOptions);
        }

        public static XmlIDREF parse(XMLInputStream xMLInputStream) {
            return (XmlIDREF) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlIDREF.type, (XmlOptions) null);
        }

        public static XmlIDREF parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (XmlIDREF) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlIDREF.type, xmlOptions);
        }

        public static XmlIDREF parse(XMLStreamReader xMLStreamReader) {
            return (XmlIDREF) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlIDREF.type, (XmlOptions) null);
        }

        public static XmlIDREF parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (XmlIDREF) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlIDREF.type, xmlOptions);
        }
    }
}
