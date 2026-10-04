package org.openxmlformats.schemas.drawingml.x2006.main;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface STTextFontSize extends XmlInt {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STTextFontSize.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "sttextfontsizeb3a8type");

    public static final class Factory {
        private Factory() {
        }

        public static STTextFontSize newInstance() {
            return (STTextFontSize) POIXMLTypeLoader.newInstance(STTextFontSize.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextFontSize.type, null);
        }

        public static STTextFontSize newValue(Object obj) {
            return (STTextFontSize) STTextFontSize.type.newValue(obj);
        }

        public static STTextFontSize parse(File file) {
            return (STTextFontSize) POIXMLTypeLoader.parse(file, STTextFontSize.type, (XmlOptions) null);
        }

        public static STTextFontSize newInstance(XmlOptions xmlOptions) {
            return (STTextFontSize) POIXMLTypeLoader.newInstance(STTextFontSize.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextFontSize.type, xmlOptions);
        }

        public static STTextFontSize parse(File file, XmlOptions xmlOptions) {
            return (STTextFontSize) POIXMLTypeLoader.parse(file, STTextFontSize.type, xmlOptions);
        }

        public static STTextFontSize parse(InputStream inputStream) {
            return (STTextFontSize) POIXMLTypeLoader.parse(inputStream, STTextFontSize.type, (XmlOptions) null);
        }

        public static STTextFontSize parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STTextFontSize) POIXMLTypeLoader.parse(inputStream, STTextFontSize.type, xmlOptions);
        }

        public static STTextFontSize parse(Reader reader) {
            return (STTextFontSize) POIXMLTypeLoader.parse(reader, STTextFontSize.type, (XmlOptions) null);
        }

        public static STTextFontSize parse(Reader reader, XmlOptions xmlOptions) {
            return (STTextFontSize) POIXMLTypeLoader.parse(reader, STTextFontSize.type, xmlOptions);
        }

        public static STTextFontSize parse(String str) {
            return (STTextFontSize) POIXMLTypeLoader.parse(str, STTextFontSize.type, (XmlOptions) null);
        }

        public static STTextFontSize parse(String str, XmlOptions xmlOptions) {
            return (STTextFontSize) POIXMLTypeLoader.parse(str, STTextFontSize.type, xmlOptions);
        }

        public static STTextFontSize parse(URL url) {
            return (STTextFontSize) POIXMLTypeLoader.parse(url, STTextFontSize.type, (XmlOptions) null);
        }

        public static STTextFontSize parse(URL url, XmlOptions xmlOptions) {
            return (STTextFontSize) POIXMLTypeLoader.parse(url, STTextFontSize.type, xmlOptions);
        }

        public static STTextFontSize parse(XMLStreamReader xMLStreamReader) {
            return (STTextFontSize) POIXMLTypeLoader.parse(xMLStreamReader, STTextFontSize.type, (XmlOptions) null);
        }

        public static STTextFontSize parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STTextFontSize) POIXMLTypeLoader.parse(xMLStreamReader, STTextFontSize.type, xmlOptions);
        }

        public static STTextFontSize parse(XMLInputStream xMLInputStream) {
            return (STTextFontSize) POIXMLTypeLoader.parse(xMLInputStream, STTextFontSize.type, (XmlOptions) null);
        }

        public static STTextFontSize parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STTextFontSize) POIXMLTypeLoader.parse(xMLInputStream, STTextFontSize.type, xmlOptions);
        }

        public static STTextFontSize parse(Node node) {
            return (STTextFontSize) POIXMLTypeLoader.parse(node, STTextFontSize.type, (XmlOptions) null);
        }

        public static STTextFontSize parse(Node node, XmlOptions xmlOptions) {
            return (STTextFontSize) POIXMLTypeLoader.parse(node, STTextFontSize.type, xmlOptions);
        }
    }
}
