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
public interface STTextIndentLevelType extends XmlInt {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STTextIndentLevelType.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "sttextindentleveltypeaf86type");

    public static final class Factory {
        private Factory() {
        }

        public static STTextIndentLevelType newInstance() {
            return (STTextIndentLevelType) POIXMLTypeLoader.newInstance(STTextIndentLevelType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextIndentLevelType.type, null);
        }

        public static STTextIndentLevelType newValue(Object obj) {
            return (STTextIndentLevelType) STTextIndentLevelType.type.newValue(obj);
        }

        public static STTextIndentLevelType parse(File file) {
            return (STTextIndentLevelType) POIXMLTypeLoader.parse(file, STTextIndentLevelType.type, (XmlOptions) null);
        }

        public static STTextIndentLevelType newInstance(XmlOptions xmlOptions) {
            return (STTextIndentLevelType) POIXMLTypeLoader.newInstance(STTextIndentLevelType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextIndentLevelType.type, xmlOptions);
        }

        public static STTextIndentLevelType parse(File file, XmlOptions xmlOptions) {
            return (STTextIndentLevelType) POIXMLTypeLoader.parse(file, STTextIndentLevelType.type, xmlOptions);
        }

        public static STTextIndentLevelType parse(InputStream inputStream) {
            return (STTextIndentLevelType) POIXMLTypeLoader.parse(inputStream, STTextIndentLevelType.type, (XmlOptions) null);
        }

        public static STTextIndentLevelType parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STTextIndentLevelType) POIXMLTypeLoader.parse(inputStream, STTextIndentLevelType.type, xmlOptions);
        }

        public static STTextIndentLevelType parse(Reader reader) {
            return (STTextIndentLevelType) POIXMLTypeLoader.parse(reader, STTextIndentLevelType.type, (XmlOptions) null);
        }

        public static STTextIndentLevelType parse(Reader reader, XmlOptions xmlOptions) {
            return (STTextIndentLevelType) POIXMLTypeLoader.parse(reader, STTextIndentLevelType.type, xmlOptions);
        }

        public static STTextIndentLevelType parse(String str) {
            return (STTextIndentLevelType) POIXMLTypeLoader.parse(str, STTextIndentLevelType.type, (XmlOptions) null);
        }

        public static STTextIndentLevelType parse(String str, XmlOptions xmlOptions) {
            return (STTextIndentLevelType) POIXMLTypeLoader.parse(str, STTextIndentLevelType.type, xmlOptions);
        }

        public static STTextIndentLevelType parse(URL url) {
            return (STTextIndentLevelType) POIXMLTypeLoader.parse(url, STTextIndentLevelType.type, (XmlOptions) null);
        }

        public static STTextIndentLevelType parse(URL url, XmlOptions xmlOptions) {
            return (STTextIndentLevelType) POIXMLTypeLoader.parse(url, STTextIndentLevelType.type, xmlOptions);
        }

        public static STTextIndentLevelType parse(XMLStreamReader xMLStreamReader) {
            return (STTextIndentLevelType) POIXMLTypeLoader.parse(xMLStreamReader, STTextIndentLevelType.type, (XmlOptions) null);
        }

        public static STTextIndentLevelType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STTextIndentLevelType) POIXMLTypeLoader.parse(xMLStreamReader, STTextIndentLevelType.type, xmlOptions);
        }

        public static STTextIndentLevelType parse(XMLInputStream xMLInputStream) {
            return (STTextIndentLevelType) POIXMLTypeLoader.parse(xMLInputStream, STTextIndentLevelType.type, (XmlOptions) null);
        }

        public static STTextIndentLevelType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STTextIndentLevelType) POIXMLTypeLoader.parse(xMLInputStream, STTextIndentLevelType.type, xmlOptions);
        }

        public static STTextIndentLevelType parse(Node node) {
            return (STTextIndentLevelType) POIXMLTypeLoader.parse(node, STTextIndentLevelType.type, (XmlOptions) null);
        }

        public static STTextIndentLevelType parse(Node node, XmlOptions xmlOptions) {
            return (STTextIndentLevelType) POIXMLTypeLoader.parse(node, STTextIndentLevelType.type, xmlOptions);
        }
    }
}
