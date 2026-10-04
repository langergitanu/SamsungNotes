package org.apache.xmlbeans;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface XmlDateTime extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_dateTime");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Factory {
        private Factory() {
        }

        public static XmlDateTime newInstance() {
            return (XmlDateTime) XmlBeans.getContextTypeLoader().newInstance(XmlDateTime.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlDateTime.type, null);
        }

        public static XmlDateTime newValue(Object obj) {
            return (XmlDateTime) XmlDateTime.type.newValue(obj);
        }

        public static XmlDateTime parse(String str) {
            return (XmlDateTime) XmlBeans.getContextTypeLoader().parse(str, XmlDateTime.type, (XmlOptions) null);
        }

        public static XmlDateTime newInstance(XmlOptions xmlOptions) {
            return (XmlDateTime) XmlBeans.getContextTypeLoader().newInstance(XmlDateTime.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlDateTime.type, xmlOptions);
        }

        public static XmlDateTime parse(String str, XmlOptions xmlOptions) {
            return (XmlDateTime) XmlBeans.getContextTypeLoader().parse(str, XmlDateTime.type, xmlOptions);
        }

        public static XmlDateTime parse(File file) {
            return (XmlDateTime) XmlBeans.getContextTypeLoader().parse(file, XmlDateTime.type, (XmlOptions) null);
        }

        public static XmlDateTime parse(File file, XmlOptions xmlOptions) {
            return (XmlDateTime) XmlBeans.getContextTypeLoader().parse(file, XmlDateTime.type, xmlOptions);
        }

        public static XmlDateTime parse(URL url) {
            return (XmlDateTime) XmlBeans.getContextTypeLoader().parse(url, XmlDateTime.type, (XmlOptions) null);
        }

        public static XmlDateTime parse(URL url, XmlOptions xmlOptions) {
            return (XmlDateTime) XmlBeans.getContextTypeLoader().parse(url, XmlDateTime.type, xmlOptions);
        }

        public static XmlDateTime parse(InputStream inputStream) {
            return (XmlDateTime) XmlBeans.getContextTypeLoader().parse(inputStream, XmlDateTime.type, (XmlOptions) null);
        }

        public static XmlDateTime parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (XmlDateTime) XmlBeans.getContextTypeLoader().parse(inputStream, XmlDateTime.type, xmlOptions);
        }

        public static XmlDateTime parse(Reader reader) {
            return (XmlDateTime) XmlBeans.getContextTypeLoader().parse(reader, XmlDateTime.type, (XmlOptions) null);
        }

        public static XmlDateTime parse(Reader reader, XmlOptions xmlOptions) {
            return (XmlDateTime) XmlBeans.getContextTypeLoader().parse(reader, XmlDateTime.type, xmlOptions);
        }

        public static XmlDateTime parse(Node node) {
            return (XmlDateTime) XmlBeans.getContextTypeLoader().parse(node, XmlDateTime.type, (XmlOptions) null);
        }

        public static XmlDateTime parse(Node node, XmlOptions xmlOptions) {
            return (XmlDateTime) XmlBeans.getContextTypeLoader().parse(node, XmlDateTime.type, xmlOptions);
        }

        public static XmlDateTime parse(XMLInputStream xMLInputStream) {
            return (XmlDateTime) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlDateTime.type, (XmlOptions) null);
        }

        public static XmlDateTime parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (XmlDateTime) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlDateTime.type, xmlOptions);
        }

        public static XmlDateTime parse(XMLStreamReader xMLStreamReader) {
            return (XmlDateTime) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlDateTime.type, (XmlOptions) null);
        }

        public static XmlDateTime parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (XmlDateTime) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlDateTime.type, xmlOptions);
        }
    }

    Calendar calendarValue();

    Date dateValue();

    GDate gDateValue();

    Calendar getCalendarValue();

    Date getDateValue();

    GDate getGDateValue();

    void set(Calendar calendar);

    void set(Date date);

    void set(GDateSpecification gDateSpecification);

    void setCalendarValue(Calendar calendar);

    void setDateValue(Date date);

    void setGDateValue(GDate gDate);
}
