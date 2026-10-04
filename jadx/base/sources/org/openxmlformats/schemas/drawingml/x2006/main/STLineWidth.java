package org.openxmlformats.schemas.drawingml.x2006.main;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface STLineWidth extends STCoordinate32 {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STLineWidth.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "stlinewidth8313type");

    public static final class Factory {
        private Factory() {
        }

        public static STLineWidth newInstance() {
            return (STLineWidth) POIXMLTypeLoader.newInstance(STLineWidth.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STLineWidth.type, null);
        }

        public static STLineWidth newValue(Object obj) {
            return (STLineWidth) STLineWidth.type.newValue(obj);
        }

        public static STLineWidth parse(File file) {
            return (STLineWidth) POIXMLTypeLoader.parse(file, STLineWidth.type, (XmlOptions) null);
        }

        public static STLineWidth newInstance(XmlOptions xmlOptions) {
            return (STLineWidth) POIXMLTypeLoader.newInstance(STLineWidth.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STLineWidth.type, xmlOptions);
        }

        public static STLineWidth parse(File file, XmlOptions xmlOptions) {
            return (STLineWidth) POIXMLTypeLoader.parse(file, STLineWidth.type, xmlOptions);
        }

        public static STLineWidth parse(InputStream inputStream) {
            return (STLineWidth) POIXMLTypeLoader.parse(inputStream, STLineWidth.type, (XmlOptions) null);
        }

        public static STLineWidth parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STLineWidth) POIXMLTypeLoader.parse(inputStream, STLineWidth.type, xmlOptions);
        }

        public static STLineWidth parse(Reader reader) {
            return (STLineWidth) POIXMLTypeLoader.parse(reader, STLineWidth.type, (XmlOptions) null);
        }

        public static STLineWidth parse(Reader reader, XmlOptions xmlOptions) {
            return (STLineWidth) POIXMLTypeLoader.parse(reader, STLineWidth.type, xmlOptions);
        }

        public static STLineWidth parse(String str) {
            return (STLineWidth) POIXMLTypeLoader.parse(str, STLineWidth.type, (XmlOptions) null);
        }

        public static STLineWidth parse(String str, XmlOptions xmlOptions) {
            return (STLineWidth) POIXMLTypeLoader.parse(str, STLineWidth.type, xmlOptions);
        }

        public static STLineWidth parse(URL url) {
            return (STLineWidth) POIXMLTypeLoader.parse(url, STLineWidth.type, (XmlOptions) null);
        }

        public static STLineWidth parse(URL url, XmlOptions xmlOptions) {
            return (STLineWidth) POIXMLTypeLoader.parse(url, STLineWidth.type, xmlOptions);
        }

        public static STLineWidth parse(XMLStreamReader xMLStreamReader) {
            return (STLineWidth) POIXMLTypeLoader.parse(xMLStreamReader, STLineWidth.type, (XmlOptions) null);
        }

        public static STLineWidth parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STLineWidth) POIXMLTypeLoader.parse(xMLStreamReader, STLineWidth.type, xmlOptions);
        }

        public static STLineWidth parse(XMLInputStream xMLInputStream) {
            return (STLineWidth) POIXMLTypeLoader.parse(xMLInputStream, STLineWidth.type, (XmlOptions) null);
        }

        public static STLineWidth parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STLineWidth) POIXMLTypeLoader.parse(xMLInputStream, STLineWidth.type, xmlOptions);
        }

        public static STLineWidth parse(Node node) {
            return (STLineWidth) POIXMLTypeLoader.parse(node, STLineWidth.type, (XmlOptions) null);
        }

        public static STLineWidth parse(Node node, XmlOptions xmlOptions) {
            return (STLineWidth) POIXMLTypeLoader.parse(node, STLineWidth.type, xmlOptions);
        }
    }
}
