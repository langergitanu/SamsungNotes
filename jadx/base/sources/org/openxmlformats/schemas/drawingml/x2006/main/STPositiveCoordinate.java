package org.openxmlformats.schemas.drawingml.x2006.main;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlLong;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface STPositiveCoordinate extends XmlLong {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STPositiveCoordinate.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "stpositivecoordinatecbfctype");

    public static final class Factory {
        private Factory() {
        }

        public static STPositiveCoordinate newInstance() {
            return (STPositiveCoordinate) POIXMLTypeLoader.newInstance(STPositiveCoordinate.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STPositiveCoordinate.type, null);
        }

        public static STPositiveCoordinate newValue(Object obj) {
            return (STPositiveCoordinate) STPositiveCoordinate.type.newValue(obj);
        }

        public static STPositiveCoordinate parse(File file) {
            return (STPositiveCoordinate) POIXMLTypeLoader.parse(file, STPositiveCoordinate.type, (XmlOptions) null);
        }

        public static STPositiveCoordinate newInstance(XmlOptions xmlOptions) {
            return (STPositiveCoordinate) POIXMLTypeLoader.newInstance(STPositiveCoordinate.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STPositiveCoordinate.type, xmlOptions);
        }

        public static STPositiveCoordinate parse(File file, XmlOptions xmlOptions) {
            return (STPositiveCoordinate) POIXMLTypeLoader.parse(file, STPositiveCoordinate.type, xmlOptions);
        }

        public static STPositiveCoordinate parse(InputStream inputStream) {
            return (STPositiveCoordinate) POIXMLTypeLoader.parse(inputStream, STPositiveCoordinate.type, (XmlOptions) null);
        }

        public static STPositiveCoordinate parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STPositiveCoordinate) POIXMLTypeLoader.parse(inputStream, STPositiveCoordinate.type, xmlOptions);
        }

        public static STPositiveCoordinate parse(Reader reader) {
            return (STPositiveCoordinate) POIXMLTypeLoader.parse(reader, STPositiveCoordinate.type, (XmlOptions) null);
        }

        public static STPositiveCoordinate parse(Reader reader, XmlOptions xmlOptions) {
            return (STPositiveCoordinate) POIXMLTypeLoader.parse(reader, STPositiveCoordinate.type, xmlOptions);
        }

        public static STPositiveCoordinate parse(String str) {
            return (STPositiveCoordinate) POIXMLTypeLoader.parse(str, STPositiveCoordinate.type, (XmlOptions) null);
        }

        public static STPositiveCoordinate parse(String str, XmlOptions xmlOptions) {
            return (STPositiveCoordinate) POIXMLTypeLoader.parse(str, STPositiveCoordinate.type, xmlOptions);
        }

        public static STPositiveCoordinate parse(URL url) {
            return (STPositiveCoordinate) POIXMLTypeLoader.parse(url, STPositiveCoordinate.type, (XmlOptions) null);
        }

        public static STPositiveCoordinate parse(URL url, XmlOptions xmlOptions) {
            return (STPositiveCoordinate) POIXMLTypeLoader.parse(url, STPositiveCoordinate.type, xmlOptions);
        }

        public static STPositiveCoordinate parse(XMLStreamReader xMLStreamReader) {
            return (STPositiveCoordinate) POIXMLTypeLoader.parse(xMLStreamReader, STPositiveCoordinate.type, (XmlOptions) null);
        }

        public static STPositiveCoordinate parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STPositiveCoordinate) POIXMLTypeLoader.parse(xMLStreamReader, STPositiveCoordinate.type, xmlOptions);
        }

        public static STPositiveCoordinate parse(XMLInputStream xMLInputStream) {
            return (STPositiveCoordinate) POIXMLTypeLoader.parse(xMLInputStream, STPositiveCoordinate.type, (XmlOptions) null);
        }

        public static STPositiveCoordinate parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STPositiveCoordinate) POIXMLTypeLoader.parse(xMLInputStream, STPositiveCoordinate.type, xmlOptions);
        }

        public static STPositiveCoordinate parse(Node node) {
            return (STPositiveCoordinate) POIXMLTypeLoader.parse(node, STPositiveCoordinate.type, (XmlOptions) null);
        }

        public static STPositiveCoordinate parse(Node node, XmlOptions xmlOptions) {
            return (STPositiveCoordinate) POIXMLTypeLoader.parse(node, STPositiveCoordinate.type, xmlOptions);
        }
    }
}
