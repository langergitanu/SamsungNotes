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
public interface XmlDate extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_date");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Factory {
        private Factory() {
        }

        public static XmlDate newInstance() {
            return (XmlDate) XmlBeans.getContextTypeLoader().newInstance(XmlDate.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlDate.type, null);
        }

        public static XmlDate newValue(Object obj) {
            return (XmlDate) XmlDate.type.newValue(obj);
        }

        public static XmlDate parse(String str) {
            return (XmlDate) XmlBeans.getContextTypeLoader().parse(str, XmlDate.type, (XmlOptions) null);
        }

        public static XmlDate newInstance(XmlOptions xmlOptions) {
            return (XmlDate) XmlBeans.getContextTypeLoader().newInstance(XmlDate.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlDate.type, xmlOptions);
        }

        public static XmlDate parse(String str, XmlOptions xmlOptions) {
            return (XmlDate) XmlBeans.getContextTypeLoader().parse(str, XmlDate.type, xmlOptions);
        }

        public static XmlDate parse(File file) {
            return (XmlDate) XmlBeans.getContextTypeLoader().parse(file, XmlDate.type, (XmlOptions) null);
        }

        public static XmlDate parse(File file, XmlOptions xmlOptions) {
            return (XmlDate) XmlBeans.getContextTypeLoader().parse(file, XmlDate.type, xmlOptions);
        }

        public static XmlDate parse(URL url) {
            return (XmlDate) XmlBeans.getContextTypeLoader().parse(url, XmlDate.type, (XmlOptions) null);
        }

        public static XmlDate parse(URL url, XmlOptions xmlOptions) {
            return (XmlDate) XmlBeans.getContextTypeLoader().parse(url, XmlDate.type, xmlOptions);
        }

        public static XmlDate parse(InputStream inputStream) {
            return (XmlDate) XmlBeans.getContextTypeLoader().parse(inputStream, XmlDate.type, (XmlOptions) null);
        }

        public static XmlDate parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (XmlDate) XmlBeans.getContextTypeLoader().parse(inputStream, XmlDate.type, xmlOptions);
        }

        public static XmlDate parse(Reader reader) {
            return (XmlDate) XmlBeans.getContextTypeLoader().parse(reader, XmlDate.type, (XmlOptions) null);
        }

        public static XmlDate parse(Reader reader, XmlOptions xmlOptions) {
            return (XmlDate) XmlBeans.getContextTypeLoader().parse(reader, XmlDate.type, xmlOptions);
        }

        public static XmlDate parse(Node node) {
            return (XmlDate) XmlBeans.getContextTypeLoader().parse(node, XmlDate.type, (XmlOptions) null);
        }

        public static XmlDate parse(Node node, XmlOptions xmlOptions) {
            return (XmlDate) XmlBeans.getContextTypeLoader().parse(node, XmlDate.type, xmlOptions);
        }

        public static XmlDate parse(XMLInputStream xMLInputStream) {
            return (XmlDate) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlDate.type, (XmlOptions) null);
        }

        public static XmlDate parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (XmlDate) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlDate.type, xmlOptions);
        }

        public static XmlDate parse(XMLStreamReader xMLStreamReader) {
            return (XmlDate) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlDate.type, (XmlOptions) null);
        }

        public static XmlDate parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (XmlDate) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlDate.type, xmlOptions);
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
