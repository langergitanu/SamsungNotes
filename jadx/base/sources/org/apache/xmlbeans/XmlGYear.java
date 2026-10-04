package org.apache.xmlbeans;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.Calendar;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface XmlGYear extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_gYear");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Factory {
        private Factory() {
        }

        public static XmlGYear newInstance() {
            return (XmlGYear) XmlBeans.getContextTypeLoader().newInstance(XmlGYear.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlGYear.type, null);
        }

        public static XmlGYear newValue(Object obj) {
            return (XmlGYear) XmlGYear.type.newValue(obj);
        }

        public static XmlGYear parse(String str) {
            return (XmlGYear) XmlBeans.getContextTypeLoader().parse(str, XmlGYear.type, (XmlOptions) null);
        }

        public static XmlGYear newInstance(XmlOptions xmlOptions) {
            return (XmlGYear) XmlBeans.getContextTypeLoader().newInstance(XmlGYear.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlGYear.type, xmlOptions);
        }

        public static XmlGYear parse(String str, XmlOptions xmlOptions) {
            return (XmlGYear) XmlBeans.getContextTypeLoader().parse(str, XmlGYear.type, xmlOptions);
        }

        public static XmlGYear parse(File file) {
            return (XmlGYear) XmlBeans.getContextTypeLoader().parse(file, XmlGYear.type, (XmlOptions) null);
        }

        public static XmlGYear parse(File file, XmlOptions xmlOptions) {
            return (XmlGYear) XmlBeans.getContextTypeLoader().parse(file, XmlGYear.type, xmlOptions);
        }

        public static XmlGYear parse(URL url) {
            return (XmlGYear) XmlBeans.getContextTypeLoader().parse(url, XmlGYear.type, (XmlOptions) null);
        }

        public static XmlGYear parse(URL url, XmlOptions xmlOptions) {
            return (XmlGYear) XmlBeans.getContextTypeLoader().parse(url, XmlGYear.type, xmlOptions);
        }

        public static XmlGYear parse(InputStream inputStream) {
            return (XmlGYear) XmlBeans.getContextTypeLoader().parse(inputStream, XmlGYear.type, (XmlOptions) null);
        }

        public static XmlGYear parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (XmlGYear) XmlBeans.getContextTypeLoader().parse(inputStream, XmlGYear.type, xmlOptions);
        }

        public static XmlGYear parse(Reader reader) {
            return (XmlGYear) XmlBeans.getContextTypeLoader().parse(reader, XmlGYear.type, (XmlOptions) null);
        }

        public static XmlGYear parse(Reader reader, XmlOptions xmlOptions) {
            return (XmlGYear) XmlBeans.getContextTypeLoader().parse(reader, XmlGYear.type, xmlOptions);
        }

        public static XmlGYear parse(Node node) {
            return (XmlGYear) XmlBeans.getContextTypeLoader().parse(node, XmlGYear.type, (XmlOptions) null);
        }

        public static XmlGYear parse(Node node, XmlOptions xmlOptions) {
            return (XmlGYear) XmlBeans.getContextTypeLoader().parse(node, XmlGYear.type, xmlOptions);
        }

        public static XmlGYear parse(XMLInputStream xMLInputStream) {
            return (XmlGYear) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlGYear.type, (XmlOptions) null);
        }

        public static XmlGYear parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (XmlGYear) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlGYear.type, xmlOptions);
        }

        public static XmlGYear parse(XMLStreamReader xMLStreamReader) {
            return (XmlGYear) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlGYear.type, (XmlOptions) null);
        }

        public static XmlGYear parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (XmlGYear) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlGYear.type, xmlOptions);
        }
    }

    Calendar calendarValue();

    GDate gDateValue();

    Calendar getCalendarValue();

    GDate getGDateValue();

    int getIntValue();

    int intValue();

    void set(int i);

    void set(Calendar calendar);

    void set(GDateSpecification gDateSpecification);

    void setCalendarValue(Calendar calendar);

    void setGDateValue(GDate gDate);

    void setIntValue(int i);
}
