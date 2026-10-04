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
public interface XmlGYearMonth extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_gYearMonth");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Factory {
        private Factory() {
        }

        public static XmlGYearMonth newInstance() {
            return (XmlGYearMonth) XmlBeans.getContextTypeLoader().newInstance(XmlGYearMonth.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlGYearMonth.type, null);
        }

        public static XmlGYearMonth newValue(Object obj) {
            return (XmlGYearMonth) XmlGYearMonth.type.newValue(obj);
        }

        public static XmlGYearMonth parse(String str) {
            return (XmlGYearMonth) XmlBeans.getContextTypeLoader().parse(str, XmlGYearMonth.type, (XmlOptions) null);
        }

        public static XmlGYearMonth newInstance(XmlOptions xmlOptions) {
            return (XmlGYearMonth) XmlBeans.getContextTypeLoader().newInstance(XmlGYearMonth.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlGYearMonth.type, xmlOptions);
        }

        public static XmlGYearMonth parse(String str, XmlOptions xmlOptions) {
            return (XmlGYearMonth) XmlBeans.getContextTypeLoader().parse(str, XmlGYearMonth.type, xmlOptions);
        }

        public static XmlGYearMonth parse(File file) {
            return (XmlGYearMonth) XmlBeans.getContextTypeLoader().parse(file, XmlGYearMonth.type, (XmlOptions) null);
        }

        public static XmlGYearMonth parse(File file, XmlOptions xmlOptions) {
            return (XmlGYearMonth) XmlBeans.getContextTypeLoader().parse(file, XmlGYearMonth.type, xmlOptions);
        }

        public static XmlGYearMonth parse(URL url) {
            return (XmlGYearMonth) XmlBeans.getContextTypeLoader().parse(url, XmlGYearMonth.type, (XmlOptions) null);
        }

        public static XmlGYearMonth parse(URL url, XmlOptions xmlOptions) {
            return (XmlGYearMonth) XmlBeans.getContextTypeLoader().parse(url, XmlGYearMonth.type, xmlOptions);
        }

        public static XmlGYearMonth parse(InputStream inputStream) {
            return (XmlGYearMonth) XmlBeans.getContextTypeLoader().parse(inputStream, XmlGYearMonth.type, (XmlOptions) null);
        }

        public static XmlGYearMonth parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (XmlGYearMonth) XmlBeans.getContextTypeLoader().parse(inputStream, XmlGYearMonth.type, xmlOptions);
        }

        public static XmlGYearMonth parse(Reader reader) {
            return (XmlGYearMonth) XmlBeans.getContextTypeLoader().parse(reader, XmlGYearMonth.type, (XmlOptions) null);
        }

        public static XmlGYearMonth parse(Reader reader, XmlOptions xmlOptions) {
            return (XmlGYearMonth) XmlBeans.getContextTypeLoader().parse(reader, XmlGYearMonth.type, xmlOptions);
        }

        public static XmlGYearMonth parse(Node node) {
            return (XmlGYearMonth) XmlBeans.getContextTypeLoader().parse(node, XmlGYearMonth.type, (XmlOptions) null);
        }

        public static XmlGYearMonth parse(Node node, XmlOptions xmlOptions) {
            return (XmlGYearMonth) XmlBeans.getContextTypeLoader().parse(node, XmlGYearMonth.type, xmlOptions);
        }

        public static XmlGYearMonth parse(XMLInputStream xMLInputStream) {
            return (XmlGYearMonth) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlGYearMonth.type, (XmlOptions) null);
        }

        public static XmlGYearMonth parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (XmlGYearMonth) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlGYearMonth.type, xmlOptions);
        }

        public static XmlGYearMonth parse(XMLStreamReader xMLStreamReader) {
            return (XmlGYearMonth) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlGYearMonth.type, (XmlOptions) null);
        }

        public static XmlGYearMonth parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (XmlGYearMonth) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlGYearMonth.type, xmlOptions);
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
