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
public interface STGuid extends XmlToken {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STGuid.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "stguidd0f4type");

    public static final class Factory {
        private Factory() {
        }

        public static STGuid newInstance() {
            return (STGuid) POIXMLTypeLoader.newInstance(STGuid.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STGuid.type, null);
        }

        public static STGuid newValue(Object obj) {
            return (STGuid) STGuid.type.newValue(obj);
        }

        public static STGuid parse(File file) {
            return (STGuid) POIXMLTypeLoader.parse(file, STGuid.type, (XmlOptions) null);
        }

        public static STGuid newInstance(XmlOptions xmlOptions) {
            return (STGuid) POIXMLTypeLoader.newInstance(STGuid.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STGuid.type, xmlOptions);
        }

        public static STGuid parse(File file, XmlOptions xmlOptions) {
            return (STGuid) POIXMLTypeLoader.parse(file, STGuid.type, xmlOptions);
        }

        public static STGuid parse(InputStream inputStream) {
            return (STGuid) POIXMLTypeLoader.parse(inputStream, STGuid.type, (XmlOptions) null);
        }

        public static STGuid parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STGuid) POIXMLTypeLoader.parse(inputStream, STGuid.type, xmlOptions);
        }

        public static STGuid parse(Reader reader) {
            return (STGuid) POIXMLTypeLoader.parse(reader, STGuid.type, (XmlOptions) null);
        }

        public static STGuid parse(Reader reader, XmlOptions xmlOptions) {
            return (STGuid) POIXMLTypeLoader.parse(reader, STGuid.type, xmlOptions);
        }

        public static STGuid parse(String str) {
            return (STGuid) POIXMLTypeLoader.parse(str, STGuid.type, (XmlOptions) null);
        }

        public static STGuid parse(String str, XmlOptions xmlOptions) {
            return (STGuid) POIXMLTypeLoader.parse(str, STGuid.type, xmlOptions);
        }

        public static STGuid parse(URL url) {
            return (STGuid) POIXMLTypeLoader.parse(url, STGuid.type, (XmlOptions) null);
        }

        public static STGuid parse(URL url, XmlOptions xmlOptions) {
            return (STGuid) POIXMLTypeLoader.parse(url, STGuid.type, xmlOptions);
        }

        public static STGuid parse(XMLStreamReader xMLStreamReader) {
            return (STGuid) POIXMLTypeLoader.parse(xMLStreamReader, STGuid.type, (XmlOptions) null);
        }

        public static STGuid parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STGuid) POIXMLTypeLoader.parse(xMLStreamReader, STGuid.type, xmlOptions);
        }

        public static STGuid parse(XMLInputStream xMLInputStream) {
            return (STGuid) POIXMLTypeLoader.parse(xMLInputStream, STGuid.type, (XmlOptions) null);
        }

        public static STGuid parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STGuid) POIXMLTypeLoader.parse(xMLInputStream, STGuid.type, xmlOptions);
        }

        public static STGuid parse(Node node) {
            return (STGuid) POIXMLTypeLoader.parse(node, STGuid.type, (XmlOptions) null);
        }

        public static STGuid parse(Node node, XmlOptions xmlOptions) {
            return (STGuid) POIXMLTypeLoader.parse(node, STGuid.type, xmlOptions);
        }
    }
}
