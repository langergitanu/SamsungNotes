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
public interface XmlGMonth extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_gMonth");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Factory {
        private Factory() {
        }

        public static XmlGMonth newInstance() {
            return (XmlGMonth) XmlBeans.getContextTypeLoader().newInstance(XmlGMonth.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlGMonth.type, null);
        }

        public static XmlGMonth newValue(Object obj) {
            return (XmlGMonth) XmlGMonth.type.newValue(obj);
        }

        public static XmlGMonth parse(String str) {
            return (XmlGMonth) XmlBeans.getContextTypeLoader().parse(str, XmlGMonth.type, (XmlOptions) null);
        }

        public static XmlGMonth newInstance(XmlOptions xmlOptions) {
            return (XmlGMonth) XmlBeans.getContextTypeLoader().newInstance(XmlGMonth.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlGMonth.type, xmlOptions);
        }

        public static XmlGMonth parse(String str, XmlOptions xmlOptions) {
            return (XmlGMonth) XmlBeans.getContextTypeLoader().parse(str, XmlGMonth.type, xmlOptions);
        }

        public static XmlGMonth parse(File file) {
            return (XmlGMonth) XmlBeans.getContextTypeLoader().parse(file, XmlGMonth.type, (XmlOptions) null);
        }

        public static XmlGMonth parse(File file, XmlOptions xmlOptions) {
            return (XmlGMonth) XmlBeans.getContextTypeLoader().parse(file, XmlGMonth.type, xmlOptions);
        }

        public static XmlGMonth parse(URL url) {
            return (XmlGMonth) XmlBeans.getContextTypeLoader().parse(url, XmlGMonth.type, (XmlOptions) null);
        }

        public static XmlGMonth parse(URL url, XmlOptions xmlOptions) {
            return (XmlGMonth) XmlBeans.getContextTypeLoader().parse(url, XmlGMonth.type, xmlOptions);
        }

        public static XmlGMonth parse(InputStream inputStream) {
            return (XmlGMonth) XmlBeans.getContextTypeLoader().parse(inputStream, XmlGMonth.type, (XmlOptions) null);
        }

        public static XmlGMonth parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (XmlGMonth) XmlBeans.getContextTypeLoader().parse(inputStream, XmlGMonth.type, xmlOptions);
        }

        public static XmlGMonth parse(Reader reader) {
            return (XmlGMonth) XmlBeans.getContextTypeLoader().parse(reader, XmlGMonth.type, (XmlOptions) null);
        }

        public static XmlGMonth parse(Reader reader, XmlOptions xmlOptions) {
            return (XmlGMonth) XmlBeans.getContextTypeLoader().parse(reader, XmlGMonth.type, xmlOptions);
        }

        public static XmlGMonth parse(Node node) {
            return (XmlGMonth) XmlBeans.getContextTypeLoader().parse(node, XmlGMonth.type, (XmlOptions) null);
        }

        public static XmlGMonth parse(Node node, XmlOptions xmlOptions) {
            return (XmlGMonth) XmlBeans.getContextTypeLoader().parse(node, XmlGMonth.type, xmlOptions);
        }

        public static XmlGMonth parse(XMLInputStream xMLInputStream) {
            return (XmlGMonth) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlGMonth.type, (XmlOptions) null);
        }

        public static XmlGMonth parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (XmlGMonth) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlGMonth.type, xmlOptions);
        }

        public static XmlGMonth parse(XMLStreamReader xMLStreamReader) {
            return (XmlGMonth) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlGMonth.type, (XmlOptions) null);
        }

        public static XmlGMonth parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (XmlGMonth) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlGMonth.type, xmlOptions);
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
