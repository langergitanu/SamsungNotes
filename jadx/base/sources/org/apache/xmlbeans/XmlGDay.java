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
public interface XmlGDay extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_gDay");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Factory {
        private Factory() {
        }

        public static XmlGDay newInstance() {
            return (XmlGDay) XmlBeans.getContextTypeLoader().newInstance(XmlGDay.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlGDay.type, null);
        }

        public static XmlGDay newValue(Object obj) {
            return (XmlGDay) XmlGDay.type.newValue(obj);
        }

        public static XmlGDay parse(String str) {
            return (XmlGDay) XmlBeans.getContextTypeLoader().parse(str, XmlGDay.type, (XmlOptions) null);
        }

        public static XmlGDay newInstance(XmlOptions xmlOptions) {
            return (XmlGDay) XmlBeans.getContextTypeLoader().newInstance(XmlGDay.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlGDay.type, xmlOptions);
        }

        public static XmlGDay parse(String str, XmlOptions xmlOptions) {
            return (XmlGDay) XmlBeans.getContextTypeLoader().parse(str, XmlGDay.type, xmlOptions);
        }

        public static XmlGDay parse(File file) {
            return (XmlGDay) XmlBeans.getContextTypeLoader().parse(file, XmlGDay.type, (XmlOptions) null);
        }

        public static XmlGDay parse(File file, XmlOptions xmlOptions) {
            return (XmlGDay) XmlBeans.getContextTypeLoader().parse(file, XmlGDay.type, xmlOptions);
        }

        public static XmlGDay parse(URL url) {
            return (XmlGDay) XmlBeans.getContextTypeLoader().parse(url, XmlGDay.type, (XmlOptions) null);
        }

        public static XmlGDay parse(URL url, XmlOptions xmlOptions) {
            return (XmlGDay) XmlBeans.getContextTypeLoader().parse(url, XmlGDay.type, xmlOptions);
        }

        public static XmlGDay parse(InputStream inputStream) {
            return (XmlGDay) XmlBeans.getContextTypeLoader().parse(inputStream, XmlGDay.type, (XmlOptions) null);
        }

        public static XmlGDay parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (XmlGDay) XmlBeans.getContextTypeLoader().parse(inputStream, XmlGDay.type, xmlOptions);
        }

        public static XmlGDay parse(Reader reader) {
            return (XmlGDay) XmlBeans.getContextTypeLoader().parse(reader, XmlGDay.type, (XmlOptions) null);
        }

        public static XmlGDay parse(Reader reader, XmlOptions xmlOptions) {
            return (XmlGDay) XmlBeans.getContextTypeLoader().parse(reader, XmlGDay.type, xmlOptions);
        }

        public static XmlGDay parse(Node node) {
            return (XmlGDay) XmlBeans.getContextTypeLoader().parse(node, XmlGDay.type, (XmlOptions) null);
        }

        public static XmlGDay parse(Node node, XmlOptions xmlOptions) {
            return (XmlGDay) XmlBeans.getContextTypeLoader().parse(node, XmlGDay.type, xmlOptions);
        }

        public static XmlGDay parse(XMLInputStream xMLInputStream) {
            return (XmlGDay) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlGDay.type, (XmlOptions) null);
        }

        public static XmlGDay parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (XmlGDay) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlGDay.type, xmlOptions);
        }

        public static XmlGDay parse(XMLStreamReader xMLStreamReader) {
            return (XmlGDay) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlGDay.type, (XmlOptions) null);
        }

        public static XmlGDay parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (XmlGDay) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlGDay.type, xmlOptions);
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
