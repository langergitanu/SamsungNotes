package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlInteger;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface STDecimalNumber extends XmlInteger {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STDecimalNumber.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "stdecimalnumber8d28type");

    public static final class Factory {
        private Factory() {
        }

        public static STDecimalNumber newInstance() {
            return (STDecimalNumber) POIXMLTypeLoader.newInstance(STDecimalNumber.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STDecimalNumber.type, null);
        }

        public static STDecimalNumber newValue(Object obj) {
            return (STDecimalNumber) STDecimalNumber.type.newValue(obj);
        }

        public static STDecimalNumber parse(File file) {
            return (STDecimalNumber) POIXMLTypeLoader.parse(file, STDecimalNumber.type, (XmlOptions) null);
        }

        public static STDecimalNumber newInstance(XmlOptions xmlOptions) {
            return (STDecimalNumber) POIXMLTypeLoader.newInstance(STDecimalNumber.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STDecimalNumber.type, xmlOptions);
        }

        public static STDecimalNumber parse(File file, XmlOptions xmlOptions) {
            return (STDecimalNumber) POIXMLTypeLoader.parse(file, STDecimalNumber.type, xmlOptions);
        }

        public static STDecimalNumber parse(InputStream inputStream) {
            return (STDecimalNumber) POIXMLTypeLoader.parse(inputStream, STDecimalNumber.type, (XmlOptions) null);
        }

        public static STDecimalNumber parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STDecimalNumber) POIXMLTypeLoader.parse(inputStream, STDecimalNumber.type, xmlOptions);
        }

        public static STDecimalNumber parse(Reader reader) {
            return (STDecimalNumber) POIXMLTypeLoader.parse(reader, STDecimalNumber.type, (XmlOptions) null);
        }

        public static STDecimalNumber parse(Reader reader, XmlOptions xmlOptions) {
            return (STDecimalNumber) POIXMLTypeLoader.parse(reader, STDecimalNumber.type, xmlOptions);
        }

        public static STDecimalNumber parse(String str) {
            return (STDecimalNumber) POIXMLTypeLoader.parse(str, STDecimalNumber.type, (XmlOptions) null);
        }

        public static STDecimalNumber parse(String str, XmlOptions xmlOptions) {
            return (STDecimalNumber) POIXMLTypeLoader.parse(str, STDecimalNumber.type, xmlOptions);
        }

        public static STDecimalNumber parse(URL url) {
            return (STDecimalNumber) POIXMLTypeLoader.parse(url, STDecimalNumber.type, (XmlOptions) null);
        }

        public static STDecimalNumber parse(URL url, XmlOptions xmlOptions) {
            return (STDecimalNumber) POIXMLTypeLoader.parse(url, STDecimalNumber.type, xmlOptions);
        }

        public static STDecimalNumber parse(XMLStreamReader xMLStreamReader) {
            return (STDecimalNumber) POIXMLTypeLoader.parse(xMLStreamReader, STDecimalNumber.type, (XmlOptions) null);
        }

        public static STDecimalNumber parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STDecimalNumber) POIXMLTypeLoader.parse(xMLStreamReader, STDecimalNumber.type, xmlOptions);
        }

        public static STDecimalNumber parse(XMLInputStream xMLInputStream) {
            return (STDecimalNumber) POIXMLTypeLoader.parse(xMLInputStream, STDecimalNumber.type, (XmlOptions) null);
        }

        public static STDecimalNumber parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STDecimalNumber) POIXMLTypeLoader.parse(xMLInputStream, STDecimalNumber.type, xmlOptions);
        }

        public static STDecimalNumber parse(Node node) {
            return (STDecimalNumber) POIXMLTypeLoader.parse(node, STDecimalNumber.type, (XmlOptions) null);
        }

        public static STDecimalNumber parse(Node node, XmlOptions xmlOptions) {
            return (STDecimalNumber) POIXMLTypeLoader.parse(node, STDecimalNumber.type, xmlOptions);
        }
    }
}
