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
public interface XmlTime extends XmlAnySimpleType {
    public static final SchemaType type = XmlBeans.getBuiltinTypeSystem().typeForHandle("_BI_time");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Factory {
        private Factory() {
        }

        public static XmlTime newInstance() {
            return (XmlTime) XmlBeans.getContextTypeLoader().newInstance(XmlTime.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlTime.type, null);
        }

        public static XmlTime newValue(Object obj) {
            return (XmlTime) XmlTime.type.newValue(obj);
        }

        public static XmlTime parse(String str) {
            return (XmlTime) XmlBeans.getContextTypeLoader().parse(str, XmlTime.type, (XmlOptions) null);
        }

        public static XmlTime newInstance(XmlOptions xmlOptions) {
            return (XmlTime) XmlBeans.getContextTypeLoader().newInstance(XmlTime.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return XmlBeans.getContextTypeLoader().newValidatingXMLInputStream(xMLInputStream, XmlTime.type, xmlOptions);
        }

        public static XmlTime parse(String str, XmlOptions xmlOptions) {
            return (XmlTime) XmlBeans.getContextTypeLoader().parse(str, XmlTime.type, xmlOptions);
        }

        public static XmlTime parse(File file) {
            return (XmlTime) XmlBeans.getContextTypeLoader().parse(file, XmlTime.type, (XmlOptions) null);
        }

        public static XmlTime parse(File file, XmlOptions xmlOptions) {
            return (XmlTime) XmlBeans.getContextTypeLoader().parse(file, XmlTime.type, xmlOptions);
        }

        public static XmlTime parse(URL url) {
            return (XmlTime) XmlBeans.getContextTypeLoader().parse(url, XmlTime.type, (XmlOptions) null);
        }

        public static XmlTime parse(URL url, XmlOptions xmlOptions) {
            return (XmlTime) XmlBeans.getContextTypeLoader().parse(url, XmlTime.type, xmlOptions);
        }

        public static XmlTime parse(InputStream inputStream) {
            return (XmlTime) XmlBeans.getContextTypeLoader().parse(inputStream, XmlTime.type, (XmlOptions) null);
        }

        public static XmlTime parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (XmlTime) XmlBeans.getContextTypeLoader().parse(inputStream, XmlTime.type, xmlOptions);
        }

        public static XmlTime parse(Reader reader) {
            return (XmlTime) XmlBeans.getContextTypeLoader().parse(reader, XmlTime.type, (XmlOptions) null);
        }

        public static XmlTime parse(Reader reader, XmlOptions xmlOptions) {
            return (XmlTime) XmlBeans.getContextTypeLoader().parse(reader, XmlTime.type, xmlOptions);
        }

        public static XmlTime parse(Node node) {
            return (XmlTime) XmlBeans.getContextTypeLoader().parse(node, XmlTime.type, (XmlOptions) null);
        }

        public static XmlTime parse(Node node, XmlOptions xmlOptions) {
            return (XmlTime) XmlBeans.getContextTypeLoader().parse(node, XmlTime.type, xmlOptions);
        }

        public static XmlTime parse(XMLInputStream xMLInputStream) {
            return (XmlTime) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlTime.type, (XmlOptions) null);
        }

        public static XmlTime parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (XmlTime) XmlBeans.getContextTypeLoader().parse(xMLInputStream, XmlTime.type, xmlOptions);
        }

        public static XmlTime parse(XMLStreamReader xMLStreamReader) {
            return (XmlTime) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlTime.type, (XmlOptions) null);
        }

        public static XmlTime parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (XmlTime) XmlBeans.getContextTypeLoader().parse(xMLStreamReader, XmlTime.type, xmlOptions);
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
