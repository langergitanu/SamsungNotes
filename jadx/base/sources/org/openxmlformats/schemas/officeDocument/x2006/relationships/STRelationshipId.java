package org.openxmlformats.schemas.officeDocument.x2006.relationships;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface STRelationshipId extends XmlString {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STRelationshipId.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "strelationshipid1e94type");

    public static final class Factory {
        private Factory() {
        }

        public static STRelationshipId newInstance() {
            return (STRelationshipId) POIXMLTypeLoader.newInstance(STRelationshipId.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STRelationshipId.type, null);
        }

        public static STRelationshipId newValue(Object obj) {
            return (STRelationshipId) STRelationshipId.type.newValue(obj);
        }

        public static STRelationshipId parse(File file) {
            return (STRelationshipId) POIXMLTypeLoader.parse(file, STRelationshipId.type, (XmlOptions) null);
        }

        public static STRelationshipId newInstance(XmlOptions xmlOptions) {
            return (STRelationshipId) POIXMLTypeLoader.newInstance(STRelationshipId.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STRelationshipId.type, xmlOptions);
        }

        public static STRelationshipId parse(File file, XmlOptions xmlOptions) {
            return (STRelationshipId) POIXMLTypeLoader.parse(file, STRelationshipId.type, xmlOptions);
        }

        public static STRelationshipId parse(InputStream inputStream) {
            return (STRelationshipId) POIXMLTypeLoader.parse(inputStream, STRelationshipId.type, (XmlOptions) null);
        }

        public static STRelationshipId parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STRelationshipId) POIXMLTypeLoader.parse(inputStream, STRelationshipId.type, xmlOptions);
        }

        public static STRelationshipId parse(Reader reader) {
            return (STRelationshipId) POIXMLTypeLoader.parse(reader, STRelationshipId.type, (XmlOptions) null);
        }

        public static STRelationshipId parse(Reader reader, XmlOptions xmlOptions) {
            return (STRelationshipId) POIXMLTypeLoader.parse(reader, STRelationshipId.type, xmlOptions);
        }

        public static STRelationshipId parse(String str) {
            return (STRelationshipId) POIXMLTypeLoader.parse(str, STRelationshipId.type, (XmlOptions) null);
        }

        public static STRelationshipId parse(String str, XmlOptions xmlOptions) {
            return (STRelationshipId) POIXMLTypeLoader.parse(str, STRelationshipId.type, xmlOptions);
        }

        public static STRelationshipId parse(URL url) {
            return (STRelationshipId) POIXMLTypeLoader.parse(url, STRelationshipId.type, (XmlOptions) null);
        }

        public static STRelationshipId parse(URL url, XmlOptions xmlOptions) {
            return (STRelationshipId) POIXMLTypeLoader.parse(url, STRelationshipId.type, xmlOptions);
        }

        public static STRelationshipId parse(XMLStreamReader xMLStreamReader) {
            return (STRelationshipId) POIXMLTypeLoader.parse(xMLStreamReader, STRelationshipId.type, (XmlOptions) null);
        }

        public static STRelationshipId parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STRelationshipId) POIXMLTypeLoader.parse(xMLStreamReader, STRelationshipId.type, xmlOptions);
        }

        public static STRelationshipId parse(XMLInputStream xMLInputStream) {
            return (STRelationshipId) POIXMLTypeLoader.parse(xMLInputStream, STRelationshipId.type, (XmlOptions) null);
        }

        public static STRelationshipId parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STRelationshipId) POIXMLTypeLoader.parse(xMLInputStream, STRelationshipId.type, xmlOptions);
        }

        public static STRelationshipId parse(Node node) {
            return (STRelationshipId) POIXMLTypeLoader.parse(node, STRelationshipId.type, (XmlOptions) null);
        }

        public static STRelationshipId parse(Node node, XmlOptions xmlOptions) {
            return (STRelationshipId) POIXMLTypeLoader.parse(node, STRelationshipId.type, xmlOptions);
        }
    }
}
