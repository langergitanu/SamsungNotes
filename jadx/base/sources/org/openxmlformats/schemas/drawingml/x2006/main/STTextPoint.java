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
public interface STTextPoint extends XmlInt {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STTextPoint.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "sttextpoint4284type");

    public static final class Factory {
        private Factory() {
        }

        public static STTextPoint newInstance() {
            return (STTextPoint) POIXMLTypeLoader.newInstance(STTextPoint.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextPoint.type, null);
        }

        public static STTextPoint newValue(Object obj) {
            return (STTextPoint) STTextPoint.type.newValue(obj);
        }

        public static STTextPoint parse(File file) {
            return (STTextPoint) POIXMLTypeLoader.parse(file, STTextPoint.type, (XmlOptions) null);
        }

        public static STTextPoint newInstance(XmlOptions xmlOptions) {
            return (STTextPoint) POIXMLTypeLoader.newInstance(STTextPoint.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextPoint.type, xmlOptions);
        }

        public static STTextPoint parse(File file, XmlOptions xmlOptions) {
            return (STTextPoint) POIXMLTypeLoader.parse(file, STTextPoint.type, xmlOptions);
        }

        public static STTextPoint parse(InputStream inputStream) {
            return (STTextPoint) POIXMLTypeLoader.parse(inputStream, STTextPoint.type, (XmlOptions) null);
        }

        public static STTextPoint parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STTextPoint) POIXMLTypeLoader.parse(inputStream, STTextPoint.type, xmlOptions);
        }

        public static STTextPoint parse(Reader reader) {
            return (STTextPoint) POIXMLTypeLoader.parse(reader, STTextPoint.type, (XmlOptions) null);
        }

        public static STTextPoint parse(Reader reader, XmlOptions xmlOptions) {
            return (STTextPoint) POIXMLTypeLoader.parse(reader, STTextPoint.type, xmlOptions);
        }

        public static STTextPoint parse(String str) {
            return (STTextPoint) POIXMLTypeLoader.parse(str, STTextPoint.type, (XmlOptions) null);
        }

        public static STTextPoint parse(String str, XmlOptions xmlOptions) {
            return (STTextPoint) POIXMLTypeLoader.parse(str, STTextPoint.type, xmlOptions);
        }

        public static STTextPoint parse(URL url) {
            return (STTextPoint) POIXMLTypeLoader.parse(url, STTextPoint.type, (XmlOptions) null);
        }

        public static STTextPoint parse(URL url, XmlOptions xmlOptions) {
            return (STTextPoint) POIXMLTypeLoader.parse(url, STTextPoint.type, xmlOptions);
        }

        public static STTextPoint parse(XMLStreamReader xMLStreamReader) {
            return (STTextPoint) POIXMLTypeLoader.parse(xMLStreamReader, STTextPoint.type, (XmlOptions) null);
        }

        public static STTextPoint parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STTextPoint) POIXMLTypeLoader.parse(xMLStreamReader, STTextPoint.type, xmlOptions);
        }

        public static STTextPoint parse(XMLInputStream xMLInputStream) {
            return (STTextPoint) POIXMLTypeLoader.parse(xMLInputStream, STTextPoint.type, (XmlOptions) null);
        }

        public static STTextPoint parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STTextPoint) POIXMLTypeLoader.parse(xMLInputStream, STTextPoint.type, xmlOptions);
        }

        public static STTextPoint parse(Node node) {
            return (STTextPoint) POIXMLTypeLoader.parse(node, STTextPoint.type, (XmlOptions) null);
        }

        public static STTextPoint parse(Node node, XmlOptions xmlOptions) {
            return (STTextPoint) POIXMLTypeLoader.parse(node, STTextPoint.type, xmlOptions);
        }
    }
}
