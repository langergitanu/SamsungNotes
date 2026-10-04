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
public interface XmlDouble extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_double");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Factory {
        private Factory() {
        }

        public static XmlDouble newInstance() {
            return (XmlDouble) XmlBeans.getContextTypeLoader().newInstance(XmlDouble.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlDouble.type, null);
        }

        public static XmlDouble newValue(Object obj) {
            return (XmlDouble) XmlDouble.type.newValue(obj);
        }

        public static XmlDouble parse(String str) {
            return (XmlDouble) XmlBeans.getContextTypeLoader().parse(str, XmlDouble.type, (XmlOptions) null);
        }

        public static XmlDouble newInstance(XmlOptions xmlOptions) {
            return (XmlDouble) XmlBeans.getContextTypeLoader().newInstance(XmlDouble.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlDouble.type, xmlOptions);
        }

        public static XmlDouble parse(String str, XmlOptions xmlOptions) {
            return (XmlDouble) XmlBeans.getContextTypeLoader().parse(str, XmlDouble.type, xmlOptions);
        }

        public static XmlDouble parse(File file) {
            return (XmlDouble) XmlBeans.getContextTypeLoader().parse(file, XmlDouble.type, (XmlOptions) null);
        }

        public static XmlDouble parse(File file, XmlOptions xmlOptions) {
            return (XmlDouble) XmlBeans.getContextTypeLoader().parse(file, XmlDouble.type, xmlOptions);
        }

        public static XmlDouble parse(URL url) {
            return (XmlDouble) XmlBeans.getContextTypeLoader().parse(url, XmlDouble.type, (XmlOptions) null);
        }

        public static XmlDouble parse(URL url, XmlOptions xmlOptions) {
            return (XmlDouble) XmlBeans.getContextTypeLoader().parse(url, XmlDouble.type, xmlOptions);
        }

        public static XmlDouble parse(InputStream inputStream) {
            return (XmlDouble) XmlBeans.getContextTypeLoader().parse(inputStream, XmlDouble.type, (XmlOptions) null);
        }

        public static XmlDouble parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (XmlDouble) XmlBeans.getContextTypeLoader().parse(inputStream, XmlDouble.type, xmlOptions);
        }

        public static XmlDouble parse(Reader reader) {
            return (XmlDouble) XmlBeans.getContextTypeLoader().parse(reader, XmlDouble.type, (XmlOptions) null);
        }

        public static XmlDouble parse(Reader reader, XmlOptions xmlOptions) {
            return (XmlDouble) XmlBeans.getContextTypeLoader().parse(reader, XmlDouble.type, xmlOptions);
        }

        public static XmlDouble parse(Node node) {
            return (XmlDouble) XmlBeans.getContextTypeLoader().parse(node, XmlDouble.type, (XmlOptions) null);
        }

        public static XmlDouble parse(Node node, XmlOptions xmlOptions) {
            return (XmlDouble) XmlBeans.getContextTypeLoader().parse(node, XmlDouble.type, xmlOptions);
        }

        public static XmlDouble parse(XMLInputStream xMLInputStream) {
            return (XmlDouble) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlDouble.type, (XmlOptions) null);
        }

        public static XmlDouble parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (XmlDouble) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlDouble.type, xmlOptions);
        }

        public static XmlDouble parse(XMLStreamReader xMLStreamReader) {
            return (XmlDouble) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlDouble.type, (XmlOptions) null);
        }

        public static XmlDouble parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (XmlDouble) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlDouble.type, xmlOptions);
        }
    }

    double doubleValue();

    double getDoubleValue();

    void set(double d);

    void setDoubleValue(double d);
}
