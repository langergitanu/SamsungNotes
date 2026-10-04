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
public interface STCoordinate extends XmlLong {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STCoordinate.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "stcoordinatefae3type");

    public static final class Factory {
        private Factory() {
        }

        public static STCoordinate newInstance() {
            return (STCoordinate) POIXMLTypeLoader.newInstance(STCoordinate.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STCoordinate.type, null);
        }

        public static STCoordinate newValue(Object obj) {
            return (STCoordinate) STCoordinate.type.newValue(obj);
        }

        public static STCoordinate parse(File file) {
            return (STCoordinate) POIXMLTypeLoader.parse(file, STCoordinate.type, (XmlOptions) null);
        }

        public static STCoordinate newInstance(XmlOptions xmlOptions) {
            return (STCoordinate) POIXMLTypeLoader.newInstance(STCoordinate.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STCoordinate.type, xmlOptions);
        }

        public static STCoordinate parse(File file, XmlOptions xmlOptions) {
            return (STCoordinate) POIXMLTypeLoader.parse(file, STCoordinate.type, xmlOptions);
        }

        public static STCoordinate parse(InputStream inputStream) {
            return (STCoordinate) POIXMLTypeLoader.parse(inputStream, STCoordinate.type, (XmlOptions) null);
        }

        public static STCoordinate parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STCoordinate) POIXMLTypeLoader.parse(inputStream, STCoordinate.type, xmlOptions);
        }

        public static STCoordinate parse(Reader reader) {
            return (STCoordinate) POIXMLTypeLoader.parse(reader, STCoordinate.type, (XmlOptions) null);
        }

        public static STCoordinate parse(Reader reader, XmlOptions xmlOptions) {
            return (STCoordinate) POIXMLTypeLoader.parse(reader, STCoordinate.type, xmlOptions);
        }

        public static STCoordinate parse(String str) {
            return (STCoordinate) POIXMLTypeLoader.parse(str, STCoordinate.type, (XmlOptions) null);
        }

        public static STCoordinate parse(String str, XmlOptions xmlOptions) {
            return (STCoordinate) POIXMLTypeLoader.parse(str, STCoordinate.type, xmlOptions);
        }

        public static STCoordinate parse(URL url) {
            return (STCoordinate) POIXMLTypeLoader.parse(url, STCoordinate.type, (XmlOptions) null);
        }

        public static STCoordinate parse(URL url, XmlOptions xmlOptions) {
            return (STCoordinate) POIXMLTypeLoader.parse(url, STCoordinate.type, xmlOptions);
        }

        public static STCoordinate parse(XMLStreamReader xMLStreamReader) {
            return (STCoordinate) POIXMLTypeLoader.parse(xMLStreamReader, STCoordinate.type, (XmlOptions) null);
        }

        public static STCoordinate parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STCoordinate) POIXMLTypeLoader.parse(xMLStreamReader, STCoordinate.type, xmlOptions);
        }

        public static STCoordinate parse(XMLInputStream xMLInputStream) {
            return (STCoordinate) POIXMLTypeLoader.parse(xMLInputStream, STCoordinate.type, (XmlOptions) null);
        }

        public static STCoordinate parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STCoordinate) POIXMLTypeLoader.parse(xMLInputStream, STCoordinate.type, xmlOptions);
        }

        public static STCoordinate parse(Node node) {
            return (STCoordinate) POIXMLTypeLoader.parse(node, STCoordinate.type, (XmlOptions) null);
        }

        public static STCoordinate parse(Node node, XmlOptions xmlOptions) {
            return (STCoordinate) POIXMLTypeLoader.parse(node, STCoordinate.type, xmlOptions);
        }
    }
}
