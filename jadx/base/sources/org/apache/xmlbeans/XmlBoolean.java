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
public interface XmlBoolean extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_boolean");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Factory {
        private Factory() {
        }

        public static XmlBoolean newInstance() {
            return (XmlBoolean) XmlBeans.getContextTypeLoader().newInstance(XmlBoolean.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlBoolean.type, null);
        }

        public static XmlBoolean newValue(Object obj) {
            return (XmlBoolean) XmlBoolean.type.newValue(obj);
        }

        public static XmlBoolean parse(String str) {
            return (XmlBoolean) XmlBeans.getContextTypeLoader().parse(str, XmlBoolean.type, (XmlOptions) null);
        }

        public static XmlBoolean newInstance(XmlOptions xmlOptions) {
            return (XmlBoolean) XmlBeans.getContextTypeLoader().newInstance(XmlBoolean.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlBoolean.type, xmlOptions);
        }

        public static XmlBoolean parse(String str, XmlOptions xmlOptions) {
            return (XmlBoolean) XmlBeans.getContextTypeLoader().parse(str, XmlBoolean.type, xmlOptions);
        }

        public static XmlBoolean parse(File file) {
            return (XmlBoolean) XmlBeans.getContextTypeLoader().parse(file, XmlBoolean.type, (XmlOptions) null);
        }

        public static XmlBoolean parse(File file, XmlOptions xmlOptions) {
            return (XmlBoolean) XmlBeans.getContextTypeLoader().parse(file, XmlBoolean.type, xmlOptions);
        }

        public static XmlBoolean parse(URL url) {
            return (XmlBoolean) XmlBeans.getContextTypeLoader().parse(url, XmlBoolean.type, (XmlOptions) null);
        }

        public static XmlBoolean parse(URL url, XmlOptions xmlOptions) {
            return (XmlBoolean) XmlBeans.getContextTypeLoader().parse(url, XmlBoolean.type, xmlOptions);
        }

        public static XmlBoolean parse(InputStream inputStream) {
            return (XmlBoolean) XmlBeans.getContextTypeLoader().parse(inputStream, XmlBoolean.type, (XmlOptions) null);
        }

        public static XmlBoolean parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (XmlBoolean) XmlBeans.getContextTypeLoader().parse(inputStream, XmlBoolean.type, xmlOptions);
        }

        public static XmlBoolean parse(Reader reader) {
            return (XmlBoolean) XmlBeans.getContextTypeLoader().parse(reader, XmlBoolean.type, (XmlOptions) null);
        }

        public static XmlBoolean parse(Reader reader, XmlOptions xmlOptions) {
            return (XmlBoolean) XmlBeans.getContextTypeLoader().parse(reader, XmlBoolean.type, xmlOptions);
        }

        public static XmlBoolean parse(Node node) {
            return (XmlBoolean) XmlBeans.getContextTypeLoader().parse(node, XmlBoolean.type, (XmlOptions) null);
        }

        public static XmlBoolean parse(Node node, XmlOptions xmlOptions) {
            return (XmlBoolean) XmlBeans.getContextTypeLoader().parse(node, XmlBoolean.type, xmlOptions);
        }

        public static XmlBoolean parse(XMLInputStream xMLInputStream) {
            return (XmlBoolean) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlBoolean.type, (XmlOptions) null);
        }

        public static XmlBoolean parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (XmlBoolean) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlBoolean.type, xmlOptions);
        }

        public static XmlBoolean parse(XMLStreamReader xMLStreamReader) {
            return (XmlBoolean) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlBoolean.type, (XmlOptions) null);
        }

        public static XmlBoolean parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (XmlBoolean) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlBoolean.type, xmlOptions);
        }
    }

    boolean booleanValue();

    boolean getBooleanValue();

    void set(boolean z);

    void setBooleanValue(boolean z);
}
