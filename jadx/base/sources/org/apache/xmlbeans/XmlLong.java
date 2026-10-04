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
public interface XmlLong extends XmlInteger {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_long");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Factory {
        private Factory() {
        }

        public static XmlLong newInstance() {
            return (XmlLong) XmlBeans.getContextTypeLoader().newInstance(XmlLong.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlLong.type, null);
        }

        public static XmlLong newValue(Object obj) {
            return (XmlLong) XmlLong.type.newValue(obj);
        }

        public static XmlLong parse(String str) {
            return (XmlLong) XmlBeans.getContextTypeLoader().parse(str, XmlLong.type, (XmlOptions) null);
        }

        public static XmlLong newInstance(XmlOptions xmlOptions) {
            return (XmlLong) XmlBeans.getContextTypeLoader().newInstance(XmlLong.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlLong.type, xmlOptions);
        }

        public static XmlLong parse(String str, XmlOptions xmlOptions) {
            return (XmlLong) XmlBeans.getContextTypeLoader().parse(str, XmlLong.type, xmlOptions);
        }

        public static XmlLong parse(File file) {
            return (XmlLong) XmlBeans.getContextTypeLoader().parse(file, XmlLong.type, (XmlOptions) null);
        }

        public static XmlLong parse(File file, XmlOptions xmlOptions) {
            return (XmlLong) XmlBeans.getContextTypeLoader().parse(file, XmlLong.type, xmlOptions);
        }

        public static XmlLong parse(URL url) {
            return (XmlLong) XmlBeans.getContextTypeLoader().parse(url, XmlLong.type, (XmlOptions) null);
        }

        public static XmlLong parse(URL url, XmlOptions xmlOptions) {
            return (XmlLong) XmlBeans.getContextTypeLoader().parse(url, XmlLong.type, xmlOptions);
        }

        public static XmlLong parse(InputStream inputStream) {
            return (XmlLong) XmlBeans.getContextTypeLoader().parse(inputStream, XmlLong.type, (XmlOptions) null);
        }

        public static XmlLong parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (XmlLong) XmlBeans.getContextTypeLoader().parse(inputStream, XmlLong.type, xmlOptions);
        }

        public static XmlLong parse(Reader reader) {
            return (XmlLong) XmlBeans.getContextTypeLoader().parse(reader, XmlLong.type, (XmlOptions) null);
        }

        public static XmlLong parse(Reader reader, XmlOptions xmlOptions) {
            return (XmlLong) XmlBeans.getContextTypeLoader().parse(reader, XmlLong.type, xmlOptions);
        }

        public static XmlLong parse(Node node) {
            return (XmlLong) XmlBeans.getContextTypeLoader().parse(node, XmlLong.type, (XmlOptions) null);
        }

        public static XmlLong parse(Node node, XmlOptions xmlOptions) {
            return (XmlLong) XmlBeans.getContextTypeLoader().parse(node, XmlLong.type, xmlOptions);
        }

        public static XmlLong parse(XMLInputStream xMLInputStream) {
            return (XmlLong) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlLong.type, (XmlOptions) null);
        }

        public static XmlLong parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (XmlLong) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlLong.type, xmlOptions);
        }

        public static XmlLong parse(XMLStreamReader xMLStreamReader) {
            return (XmlLong) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlLong.type, (XmlOptions) null);
        }

        public static XmlLong parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (XmlLong) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlLong.type, xmlOptions);
        }
    }

    long getLongValue();

    long longValue();

    void set(long j);

    void setLongValue(long j);
}
