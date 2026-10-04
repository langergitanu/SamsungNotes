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
public interface XmlDuration extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_duration");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Factory {
        private Factory() {
        }

        public static XmlDuration newInstance() {
            return (XmlDuration) XmlBeans.getContextTypeLoader().newInstance(XmlDuration.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlDuration.type, null);
        }

        public static XmlDuration newValue(Object obj) {
            return (XmlDuration) XmlDuration.type.newValue(obj);
        }

        public static XmlDuration parse(String str) {
            return (XmlDuration) XmlBeans.getContextTypeLoader().parse(str, XmlDuration.type, (XmlOptions) null);
        }

        public static XmlDuration newInstance(XmlOptions xmlOptions) {
            return (XmlDuration) XmlBeans.getContextTypeLoader().newInstance(XmlDuration.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlDuration.type, xmlOptions);
        }

        public static XmlDuration parse(String str, XmlOptions xmlOptions) {
            return (XmlDuration) XmlBeans.getContextTypeLoader().parse(str, XmlDuration.type, xmlOptions);
        }

        public static XmlDuration parse(File file) {
            return (XmlDuration) XmlBeans.getContextTypeLoader().parse(file, XmlDuration.type, (XmlOptions) null);
        }

        public static XmlDuration parse(File file, XmlOptions xmlOptions) {
            return (XmlDuration) XmlBeans.getContextTypeLoader().parse(file, XmlDuration.type, xmlOptions);
        }

        public static XmlDuration parse(URL url) {
            return (XmlDuration) XmlBeans.getContextTypeLoader().parse(url, XmlDuration.type, (XmlOptions) null);
        }

        public static XmlDuration parse(URL url, XmlOptions xmlOptions) {
            return (XmlDuration) XmlBeans.getContextTypeLoader().parse(url, XmlDuration.type, xmlOptions);
        }

        public static XmlDuration parse(InputStream inputStream) {
            return (XmlDuration) XmlBeans.getContextTypeLoader().parse(inputStream, XmlDuration.type, (XmlOptions) null);
        }

        public static XmlDuration parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (XmlDuration) XmlBeans.getContextTypeLoader().parse(inputStream, XmlDuration.type, xmlOptions);
        }

        public static XmlDuration parse(Reader reader) {
            return (XmlDuration) XmlBeans.getContextTypeLoader().parse(reader, XmlDuration.type, (XmlOptions) null);
        }

        public static XmlDuration parse(Reader reader, XmlOptions xmlOptions) {
            return (XmlDuration) XmlBeans.getContextTypeLoader().parse(reader, XmlDuration.type, xmlOptions);
        }

        public static XmlDuration parse(Node node) {
            return (XmlDuration) XmlBeans.getContextTypeLoader().parse(node, XmlDuration.type, (XmlOptions) null);
        }

        public static XmlDuration parse(Node node, XmlOptions xmlOptions) {
            return (XmlDuration) XmlBeans.getContextTypeLoader().parse(node, XmlDuration.type, xmlOptions);
        }

        public static XmlDuration parse(XMLInputStream xMLInputStream) {
            return (XmlDuration) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlDuration.type, (XmlOptions) null);
        }

        public static XmlDuration parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (XmlDuration) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlDuration.type, xmlOptions);
        }

        public static XmlDuration parse(XMLStreamReader xMLStreamReader) {
            return (XmlDuration) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlDuration.type, (XmlOptions) null);
        }

        public static XmlDuration parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (XmlDuration) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlDuration.type, xmlOptions);
        }
    }

    GDuration gDurationValue();

    GDuration getGDurationValue();

    void set(GDurationSpecification gDurationSpecification);

    void setGDurationValue(GDuration gDuration);
}
