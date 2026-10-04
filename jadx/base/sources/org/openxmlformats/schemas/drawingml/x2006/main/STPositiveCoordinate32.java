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
public interface STPositiveCoordinate32 extends STCoordinate32 {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STPositiveCoordinate32.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "stpositivecoordinate321b9btype");

    public static final class Factory {
        private Factory() {
        }

        public static STPositiveCoordinate32 newInstance() {
            return (STPositiveCoordinate32) POIXMLTypeLoader.newInstance(STPositiveCoordinate32.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STPositiveCoordinate32.type, null);
        }

        public static STPositiveCoordinate32 newValue(Object obj) {
            return (STPositiveCoordinate32) STPositiveCoordinate32.type.newValue(obj);
        }

        public static STPositiveCoordinate32 parse(File file) {
            return (STPositiveCoordinate32) POIXMLTypeLoader.parse(file, STPositiveCoordinate32.type, (XmlOptions) null);
        }

        public static STPositiveCoordinate32 newInstance(XmlOptions xmlOptions) {
            return (STPositiveCoordinate32) POIXMLTypeLoader.newInstance(STPositiveCoordinate32.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STPositiveCoordinate32.type, xmlOptions);
        }

        public static STPositiveCoordinate32 parse(File file, XmlOptions xmlOptions) {
            return (STPositiveCoordinate32) POIXMLTypeLoader.parse(file, STPositiveCoordinate32.type, xmlOptions);
        }

        public static STPositiveCoordinate32 parse(InputStream inputStream) {
            return (STPositiveCoordinate32) POIXMLTypeLoader.parse(inputStream, STPositiveCoordinate32.type, (XmlOptions) null);
        }

        public static STPositiveCoordinate32 parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STPositiveCoordinate32) POIXMLTypeLoader.parse(inputStream, STPositiveCoordinate32.type, xmlOptions);
        }

        public static STPositiveCoordinate32 parse(Reader reader) {
            return (STPositiveCoordinate32) POIXMLTypeLoader.parse(reader, STPositiveCoordinate32.type, (XmlOptions) null);
        }

        public static STPositiveCoordinate32 parse(Reader reader, XmlOptions xmlOptions) {
            return (STPositiveCoordinate32) POIXMLTypeLoader.parse(reader, STPositiveCoordinate32.type, xmlOptions);
        }

        public static STPositiveCoordinate32 parse(String str) {
            return (STPositiveCoordinate32) POIXMLTypeLoader.parse(str, STPositiveCoordinate32.type, (XmlOptions) null);
        }

        public static STPositiveCoordinate32 parse(String str, XmlOptions xmlOptions) {
            return (STPositiveCoordinate32) POIXMLTypeLoader.parse(str, STPositiveCoordinate32.type, xmlOptions);
        }

        public static STPositiveCoordinate32 parse(URL url) {
            return (STPositiveCoordinate32) POIXMLTypeLoader.parse(url, STPositiveCoordinate32.type, (XmlOptions) null);
        }

        public static STPositiveCoordinate32 parse(URL url, XmlOptions xmlOptions) {
            return (STPositiveCoordinate32) POIXMLTypeLoader.parse(url, STPositiveCoordinate32.type, xmlOptions);
        }

        public static STPositiveCoordinate32 parse(XMLStreamReader xMLStreamReader) {
            return (STPositiveCoordinate32) POIXMLTypeLoader.parse(xMLStreamReader, STPositiveCoordinate32.type, (XmlOptions) null);
        }

        public static STPositiveCoordinate32 parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STPositiveCoordinate32) POIXMLTypeLoader.parse(xMLStreamReader, STPositiveCoordinate32.type, xmlOptions);
        }

        public static STPositiveCoordinate32 parse(XMLInputStream xMLInputStream) {
            return (STPositiveCoordinate32) POIXMLTypeLoader.parse(xMLInputStream, STPositiveCoordinate32.type, (XmlOptions) null);
        }

        public static STPositiveCoordinate32 parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STPositiveCoordinate32) POIXMLTypeLoader.parse(xMLInputStream, STPositiveCoordinate32.type, xmlOptions);
        }

        public static STPositiveCoordinate32 parse(Node node) {
            return (STPositiveCoordinate32) POIXMLTypeLoader.parse(node, STPositiveCoordinate32.type, (XmlOptions) null);
        }

        public static STPositiveCoordinate32 parse(Node node, XmlOptions xmlOptions) {
            return (STPositiveCoordinate32) POIXMLTypeLoader.parse(node, STPositiveCoordinate32.type, xmlOptions);
        }
    }
}
