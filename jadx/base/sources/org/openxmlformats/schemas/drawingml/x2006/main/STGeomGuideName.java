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
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface STGeomGuideName extends XmlToken {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STGeomGuideName.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "stgeomguidename366ctype");

    public static final class Factory {
        private Factory() {
        }

        public static STGeomGuideName newInstance() {
            return (STGeomGuideName) POIXMLTypeLoader.newInstance(STGeomGuideName.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STGeomGuideName.type, null);
        }

        public static STGeomGuideName newValue(Object obj) {
            return (STGeomGuideName) STGeomGuideName.type.newValue(obj);
        }

        public static STGeomGuideName parse(File file) {
            return (STGeomGuideName) POIXMLTypeLoader.parse(file, STGeomGuideName.type, (XmlOptions) null);
        }

        public static STGeomGuideName newInstance(XmlOptions xmlOptions) {
            return (STGeomGuideName) POIXMLTypeLoader.newInstance(STGeomGuideName.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STGeomGuideName.type, xmlOptions);
        }

        public static STGeomGuideName parse(File file, XmlOptions xmlOptions) {
            return (STGeomGuideName) POIXMLTypeLoader.parse(file, STGeomGuideName.type, xmlOptions);
        }

        public static STGeomGuideName parse(InputStream inputStream) {
            return (STGeomGuideName) POIXMLTypeLoader.parse(inputStream, STGeomGuideName.type, (XmlOptions) null);
        }

        public static STGeomGuideName parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STGeomGuideName) POIXMLTypeLoader.parse(inputStream, STGeomGuideName.type, xmlOptions);
        }

        public static STGeomGuideName parse(Reader reader) {
            return (STGeomGuideName) POIXMLTypeLoader.parse(reader, STGeomGuideName.type, (XmlOptions) null);
        }

        public static STGeomGuideName parse(Reader reader, XmlOptions xmlOptions) {
            return (STGeomGuideName) POIXMLTypeLoader.parse(reader, STGeomGuideName.type, xmlOptions);
        }

        public static STGeomGuideName parse(String str) {
            return (STGeomGuideName) POIXMLTypeLoader.parse(str, STGeomGuideName.type, (XmlOptions) null);
        }

        public static STGeomGuideName parse(String str, XmlOptions xmlOptions) {
            return (STGeomGuideName) POIXMLTypeLoader.parse(str, STGeomGuideName.type, xmlOptions);
        }

        public static STGeomGuideName parse(URL url) {
            return (STGeomGuideName) POIXMLTypeLoader.parse(url, STGeomGuideName.type, (XmlOptions) null);
        }

        public static STGeomGuideName parse(URL url, XmlOptions xmlOptions) {
            return (STGeomGuideName) POIXMLTypeLoader.parse(url, STGeomGuideName.type, xmlOptions);
        }

        public static STGeomGuideName parse(XMLStreamReader xMLStreamReader) {
            return (STGeomGuideName) POIXMLTypeLoader.parse(xMLStreamReader, STGeomGuideName.type, (XmlOptions) null);
        }

        public static STGeomGuideName parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STGeomGuideName) POIXMLTypeLoader.parse(xMLStreamReader, STGeomGuideName.type, xmlOptions);
        }

        public static STGeomGuideName parse(XMLInputStream xMLInputStream) {
            return (STGeomGuideName) POIXMLTypeLoader.parse(xMLInputStream, STGeomGuideName.type, (XmlOptions) null);
        }

        public static STGeomGuideName parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STGeomGuideName) POIXMLTypeLoader.parse(xMLInputStream, STGeomGuideName.type, xmlOptions);
        }

        public static STGeomGuideName parse(Node node) {
            return (STGeomGuideName) POIXMLTypeLoader.parse(node, STGeomGuideName.type, (XmlOptions) null);
        }

        public static STGeomGuideName parse(Node node, XmlOptions xmlOptions) {
            return (STGeomGuideName) POIXMLTypeLoader.parse(node, STGeomGuideName.type, xmlOptions);
        }
    }
}
