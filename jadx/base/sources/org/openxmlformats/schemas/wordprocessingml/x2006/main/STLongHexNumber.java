package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlHexBinary;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface STLongHexNumber extends XmlHexBinary {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STLongHexNumber.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "stlonghexnumberd6batype");

    public static final class Factory {
        private Factory() {
        }

        public static STLongHexNumber newInstance() {
            return (STLongHexNumber) POIXMLTypeLoader.newInstance(STLongHexNumber.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STLongHexNumber.type, null);
        }

        public static STLongHexNumber newValue(Object obj) {
            return (STLongHexNumber) STLongHexNumber.type.newValue(obj);
        }

        public static STLongHexNumber parse(File file) {
            return (STLongHexNumber) POIXMLTypeLoader.parse(file, STLongHexNumber.type, (XmlOptions) null);
        }

        public static STLongHexNumber newInstance(XmlOptions xmlOptions) {
            return (STLongHexNumber) POIXMLTypeLoader.newInstance(STLongHexNumber.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STLongHexNumber.type, xmlOptions);
        }

        public static STLongHexNumber parse(File file, XmlOptions xmlOptions) {
            return (STLongHexNumber) POIXMLTypeLoader.parse(file, STLongHexNumber.type, xmlOptions);
        }

        public static STLongHexNumber parse(InputStream inputStream) {
            return (STLongHexNumber) POIXMLTypeLoader.parse(inputStream, STLongHexNumber.type, (XmlOptions) null);
        }

        public static STLongHexNumber parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STLongHexNumber) POIXMLTypeLoader.parse(inputStream, STLongHexNumber.type, xmlOptions);
        }

        public static STLongHexNumber parse(Reader reader) {
            return (STLongHexNumber) POIXMLTypeLoader.parse(reader, STLongHexNumber.type, (XmlOptions) null);
        }

        public static STLongHexNumber parse(Reader reader, XmlOptions xmlOptions) {
            return (STLongHexNumber) POIXMLTypeLoader.parse(reader, STLongHexNumber.type, xmlOptions);
        }

        public static STLongHexNumber parse(String str) {
            return (STLongHexNumber) POIXMLTypeLoader.parse(str, STLongHexNumber.type, (XmlOptions) null);
        }

        public static STLongHexNumber parse(String str, XmlOptions xmlOptions) {
            return (STLongHexNumber) POIXMLTypeLoader.parse(str, STLongHexNumber.type, xmlOptions);
        }

        public static STLongHexNumber parse(URL url) {
            return (STLongHexNumber) POIXMLTypeLoader.parse(url, STLongHexNumber.type, (XmlOptions) null);
        }

        public static STLongHexNumber parse(URL url, XmlOptions xmlOptions) {
            return (STLongHexNumber) POIXMLTypeLoader.parse(url, STLongHexNumber.type, xmlOptions);
        }

        public static STLongHexNumber parse(XMLStreamReader xMLStreamReader) {
            return (STLongHexNumber) POIXMLTypeLoader.parse(xMLStreamReader, STLongHexNumber.type, (XmlOptions) null);
        }

        public static STLongHexNumber parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STLongHexNumber) POIXMLTypeLoader.parse(xMLStreamReader, STLongHexNumber.type, xmlOptions);
        }

        public static STLongHexNumber parse(XMLInputStream xMLInputStream) {
            return (STLongHexNumber) POIXMLTypeLoader.parse(xMLInputStream, STLongHexNumber.type, (XmlOptions) null);
        }

        public static STLongHexNumber parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STLongHexNumber) POIXMLTypeLoader.parse(xMLInputStream, STLongHexNumber.type, xmlOptions);
        }

        public static STLongHexNumber parse(Node node) {
            return (STLongHexNumber) POIXMLTypeLoader.parse(node, STLongHexNumber.type, (XmlOptions) null);
        }

        public static STLongHexNumber parse(Node node, XmlOptions xmlOptions) {
            return (STLongHexNumber) POIXMLTypeLoader.parse(node, STLongHexNumber.type, xmlOptions);
        }
    }
}
