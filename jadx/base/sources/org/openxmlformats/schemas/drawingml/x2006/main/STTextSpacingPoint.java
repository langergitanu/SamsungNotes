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
public interface STTextSpacingPoint extends XmlInt {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STTextSpacingPoint.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "sttextspacingpointdd05type");

    public static final class Factory {
        private Factory() {
        }

        public static STTextSpacingPoint newInstance() {
            return (STTextSpacingPoint) POIXMLTypeLoader.newInstance(STTextSpacingPoint.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextSpacingPoint.type, null);
        }

        public static STTextSpacingPoint newValue(Object obj) {
            return (STTextSpacingPoint) STTextSpacingPoint.type.newValue(obj);
        }

        public static STTextSpacingPoint parse(File file) {
            return (STTextSpacingPoint) POIXMLTypeLoader.parse(file, STTextSpacingPoint.type, (XmlOptions) null);
        }

        public static STTextSpacingPoint newInstance(XmlOptions xmlOptions) {
            return (STTextSpacingPoint) POIXMLTypeLoader.newInstance(STTextSpacingPoint.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextSpacingPoint.type, xmlOptions);
        }

        public static STTextSpacingPoint parse(File file, XmlOptions xmlOptions) {
            return (STTextSpacingPoint) POIXMLTypeLoader.parse(file, STTextSpacingPoint.type, xmlOptions);
        }

        public static STTextSpacingPoint parse(InputStream inputStream) {
            return (STTextSpacingPoint) POIXMLTypeLoader.parse(inputStream, STTextSpacingPoint.type, (XmlOptions) null);
        }

        public static STTextSpacingPoint parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STTextSpacingPoint) POIXMLTypeLoader.parse(inputStream, STTextSpacingPoint.type, xmlOptions);
        }

        public static STTextSpacingPoint parse(Reader reader) {
            return (STTextSpacingPoint) POIXMLTypeLoader.parse(reader, STTextSpacingPoint.type, (XmlOptions) null);
        }

        public static STTextSpacingPoint parse(Reader reader, XmlOptions xmlOptions) {
            return (STTextSpacingPoint) POIXMLTypeLoader.parse(reader, STTextSpacingPoint.type, xmlOptions);
        }

        public static STTextSpacingPoint parse(String str) {
            return (STTextSpacingPoint) POIXMLTypeLoader.parse(str, STTextSpacingPoint.type, (XmlOptions) null);
        }

        public static STTextSpacingPoint parse(String str, XmlOptions xmlOptions) {
            return (STTextSpacingPoint) POIXMLTypeLoader.parse(str, STTextSpacingPoint.type, xmlOptions);
        }

        public static STTextSpacingPoint parse(URL url) {
            return (STTextSpacingPoint) POIXMLTypeLoader.parse(url, STTextSpacingPoint.type, (XmlOptions) null);
        }

        public static STTextSpacingPoint parse(URL url, XmlOptions xmlOptions) {
            return (STTextSpacingPoint) POIXMLTypeLoader.parse(url, STTextSpacingPoint.type, xmlOptions);
        }

        public static STTextSpacingPoint parse(XMLStreamReader xMLStreamReader) {
            return (STTextSpacingPoint) POIXMLTypeLoader.parse(xMLStreamReader, STTextSpacingPoint.type, (XmlOptions) null);
        }

        public static STTextSpacingPoint parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STTextSpacingPoint) POIXMLTypeLoader.parse(xMLStreamReader, STTextSpacingPoint.type, xmlOptions);
        }

        public static STTextSpacingPoint parse(XMLInputStream xMLInputStream) {
            return (STTextSpacingPoint) POIXMLTypeLoader.parse(xMLInputStream, STTextSpacingPoint.type, (XmlOptions) null);
        }

        public static STTextSpacingPoint parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STTextSpacingPoint) POIXMLTypeLoader.parse(xMLInputStream, STTextSpacingPoint.type, xmlOptions);
        }

        public static STTextSpacingPoint parse(Node node) {
            return (STTextSpacingPoint) POIXMLTypeLoader.parse(node, STTextSpacingPoint.type, (XmlOptions) null);
        }

        public static STTextSpacingPoint parse(Node node, XmlOptions xmlOptions) {
            return (STTextSpacingPoint) POIXMLTypeLoader.parse(node, STTextSpacingPoint.type, xmlOptions);
        }
    }
}
