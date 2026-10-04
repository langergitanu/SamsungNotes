package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedLong;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface STUnsignedDecimalNumber extends XmlUnsignedLong {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STUnsignedDecimalNumber.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "stunsigneddecimalnumber74fdtype");

    public static final class Factory {
        private Factory() {
        }

        public static STUnsignedDecimalNumber newInstance() {
            return (STUnsignedDecimalNumber) POIXMLTypeLoader.newInstance(STUnsignedDecimalNumber.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STUnsignedDecimalNumber.type, null);
        }

        public static STUnsignedDecimalNumber newValue(Object obj) {
            return (STUnsignedDecimalNumber) STUnsignedDecimalNumber.type.newValue(obj);
        }

        public static STUnsignedDecimalNumber parse(File file) {
            return (STUnsignedDecimalNumber) POIXMLTypeLoader.parse(file, STUnsignedDecimalNumber.type, (XmlOptions) null);
        }

        public static STUnsignedDecimalNumber newInstance(XmlOptions xmlOptions) {
            return (STUnsignedDecimalNumber) POIXMLTypeLoader.newInstance(STUnsignedDecimalNumber.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STUnsignedDecimalNumber.type, xmlOptions);
        }

        public static STUnsignedDecimalNumber parse(File file, XmlOptions xmlOptions) {
            return (STUnsignedDecimalNumber) POIXMLTypeLoader.parse(file, STUnsignedDecimalNumber.type, xmlOptions);
        }

        public static STUnsignedDecimalNumber parse(InputStream inputStream) {
            return (STUnsignedDecimalNumber) POIXMLTypeLoader.parse(inputStream, STUnsignedDecimalNumber.type, (XmlOptions) null);
        }

        public static STUnsignedDecimalNumber parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STUnsignedDecimalNumber) POIXMLTypeLoader.parse(inputStream, STUnsignedDecimalNumber.type, xmlOptions);
        }

        public static STUnsignedDecimalNumber parse(Reader reader) {
            return (STUnsignedDecimalNumber) POIXMLTypeLoader.parse(reader, STUnsignedDecimalNumber.type, (XmlOptions) null);
        }

        public static STUnsignedDecimalNumber parse(Reader reader, XmlOptions xmlOptions) {
            return (STUnsignedDecimalNumber) POIXMLTypeLoader.parse(reader, STUnsignedDecimalNumber.type, xmlOptions);
        }

        public static STUnsignedDecimalNumber parse(String str) {
            return (STUnsignedDecimalNumber) POIXMLTypeLoader.parse(str, STUnsignedDecimalNumber.type, (XmlOptions) null);
        }

        public static STUnsignedDecimalNumber parse(String str, XmlOptions xmlOptions) {
            return (STUnsignedDecimalNumber) POIXMLTypeLoader.parse(str, STUnsignedDecimalNumber.type, xmlOptions);
        }

        public static STUnsignedDecimalNumber parse(URL url) {
            return (STUnsignedDecimalNumber) POIXMLTypeLoader.parse(url, STUnsignedDecimalNumber.type, (XmlOptions) null);
        }

        public static STUnsignedDecimalNumber parse(URL url, XmlOptions xmlOptions) {
            return (STUnsignedDecimalNumber) POIXMLTypeLoader.parse(url, STUnsignedDecimalNumber.type, xmlOptions);
        }

        public static STUnsignedDecimalNumber parse(XMLStreamReader xMLStreamReader) {
            return (STUnsignedDecimalNumber) POIXMLTypeLoader.parse(xMLStreamReader, STUnsignedDecimalNumber.type, (XmlOptions) null);
        }

        public static STUnsignedDecimalNumber parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STUnsignedDecimalNumber) POIXMLTypeLoader.parse(xMLStreamReader, STUnsignedDecimalNumber.type, xmlOptions);
        }

        public static STUnsignedDecimalNumber parse(XMLInputStream xMLInputStream) {
            return (STUnsignedDecimalNumber) POIXMLTypeLoader.parse(xMLInputStream, STUnsignedDecimalNumber.type, (XmlOptions) null);
        }

        public static STUnsignedDecimalNumber parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STUnsignedDecimalNumber) POIXMLTypeLoader.parse(xMLInputStream, STUnsignedDecimalNumber.type, xmlOptions);
        }

        public static STUnsignedDecimalNumber parse(Node node) {
            return (STUnsignedDecimalNumber) POIXMLTypeLoader.parse(node, STUnsignedDecimalNumber.type, (XmlOptions) null);
        }

        public static STUnsignedDecimalNumber parse(Node node, XmlOptions xmlOptions) {
            return (STUnsignedDecimalNumber) POIXMLTypeLoader.parse(node, STUnsignedDecimalNumber.type, xmlOptions);
        }
    }
}
