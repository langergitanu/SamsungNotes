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
public interface XmlGMonthDay extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_gMonthDay");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Factory {
        private Factory() {
        }

        public static XmlGMonthDay newInstance() {
            return (XmlGMonthDay) XmlBeans.getContextTypeLoader().newInstance(XmlGMonthDay.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlGMonthDay.type, null);
        }

        public static XmlGMonthDay newValue(Object obj) {
            return (XmlGMonthDay) XmlGMonthDay.type.newValue(obj);
        }

        public static XmlGMonthDay parse(String str) {
            return (XmlGMonthDay) XmlBeans.getContextTypeLoader().parse(str, XmlGMonthDay.type, (XmlOptions) null);
        }

        public static XmlGMonthDay newInstance(XmlOptions xmlOptions) {
            return (XmlGMonthDay) XmlBeans.getContextTypeLoader().newInstance(XmlGMonthDay.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlGMonthDay.type, xmlOptions);
        }

        public static XmlGMonthDay parse(String str, XmlOptions xmlOptions) {
            return (XmlGMonthDay) XmlBeans.getContextTypeLoader().parse(str, XmlGMonthDay.type, xmlOptions);
        }

        public static XmlGMonthDay parse(File file) {
            return (XmlGMonthDay) XmlBeans.getContextTypeLoader().parse(file, XmlGMonthDay.type, (XmlOptions) null);
        }

        public static XmlGMonthDay parse(File file, XmlOptions xmlOptions) {
            return (XmlGMonthDay) XmlBeans.getContextTypeLoader().parse(file, XmlGMonthDay.type, xmlOptions);
        }

        public static XmlGMonthDay parse(URL url) {
            return (XmlGMonthDay) XmlBeans.getContextTypeLoader().parse(url, XmlGMonthDay.type, (XmlOptions) null);
        }

        public static XmlGMonthDay parse(URL url, XmlOptions xmlOptions) {
            return (XmlGMonthDay) XmlBeans.getContextTypeLoader().parse(url, XmlGMonthDay.type, xmlOptions);
        }

        public static XmlGMonthDay parse(InputStream inputStream) {
            return (XmlGMonthDay) XmlBeans.getContextTypeLoader().parse(inputStream, XmlGMonthDay.type, (XmlOptions) null);
        }

        public static XmlGMonthDay parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (XmlGMonthDay) XmlBeans.getContextTypeLoader().parse(inputStream, XmlGMonthDay.type, xmlOptions);
        }

        public static XmlGMonthDay parse(Reader reader) {
            return (XmlGMonthDay) XmlBeans.getContextTypeLoader().parse(reader, XmlGMonthDay.type, (XmlOptions) null);
        }

        public static XmlGMonthDay parse(Reader reader, XmlOptions xmlOptions) {
            return (XmlGMonthDay) XmlBeans.getContextTypeLoader().parse(reader, XmlGMonthDay.type, xmlOptions);
        }

        public static XmlGMonthDay parse(Node node) {
            return (XmlGMonthDay) XmlBeans.getContextTypeLoader().parse(node, XmlGMonthDay.type, (XmlOptions) null);
        }

        public static XmlGMonthDay parse(Node node, XmlOptions xmlOptions) {
            return (XmlGMonthDay) XmlBeans.getContextTypeLoader().parse(node, XmlGMonthDay.type, xmlOptions);
        }

        public static XmlGMonthDay parse(XMLInputStream xMLInputStream) {
            return (XmlGMonthDay) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlGMonthDay.type, (XmlOptions) null);
        }

        public static XmlGMonthDay parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (XmlGMonthDay) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlGMonthDay.type, xmlOptions);
        }

        public static XmlGMonthDay parse(XMLStreamReader xMLStreamReader) {
            return (XmlGMonthDay) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlGMonthDay.type, (XmlOptions) null);
        }

        public static XmlGMonthDay parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (XmlGMonthDay) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlGMonthDay.type, xmlOptions);
        }
    }

    Calendar calendarValue();

    GDate gDateValue();

    Calendar getCalendarValue();

    GDate getGDateValue();

    void set(Calendar calendar);

    void set(GDateSpecification gDateSpecification);

    void setCalendarValue(Calendar calendar);

    void setGDateValue(GDate gDate);
}
