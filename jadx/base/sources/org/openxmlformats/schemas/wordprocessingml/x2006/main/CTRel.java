package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTRel extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTRel.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctrel4519type");

    public static final class Factory {
        private Factory() {
        }

        public static CTRel newInstance() {
            return (CTRel) POIXMLTypeLoader.newInstance(CTRel.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTRel.type, null);
        }

        public static CTRel parse(File file) {
            return (CTRel) POIXMLTypeLoader.parse(file, CTRel.type, (XmlOptions) null);
        }

        public static CTRel newInstance(XmlOptions xmlOptions) {
            return (CTRel) POIXMLTypeLoader.newInstance(CTRel.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTRel.type, xmlOptions);
        }

        public static CTRel parse(File file, XmlOptions xmlOptions) {
            return (CTRel) POIXMLTypeLoader.parse(file, CTRel.type, xmlOptions);
        }

        public static CTRel parse(InputStream inputStream) {
            return (CTRel) POIXMLTypeLoader.parse(inputStream, CTRel.type, (XmlOptions) null);
        }

        public static CTRel parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTRel) POIXMLTypeLoader.parse(inputStream, CTRel.type, xmlOptions);
        }

        public static CTRel parse(Reader reader) {
            return (CTRel) POIXMLTypeLoader.parse(reader, CTRel.type, (XmlOptions) null);
        }

        public static CTRel parse(Reader reader, XmlOptions xmlOptions) {
            return (CTRel) POIXMLTypeLoader.parse(reader, CTRel.type, xmlOptions);
        }

        public static CTRel parse(String str) {
            return (CTRel) POIXMLTypeLoader.parse(str, CTRel.type, (XmlOptions) null);
        }

        public static CTRel parse(String str, XmlOptions xmlOptions) {
            return (CTRel) POIXMLTypeLoader.parse(str, CTRel.type, xmlOptions);
        }

        public static CTRel parse(URL url) {
            return (CTRel) POIXMLTypeLoader.parse(url, CTRel.type, (XmlOptions) null);
        }

        public static CTRel parse(URL url, XmlOptions xmlOptions) {
            return (CTRel) POIXMLTypeLoader.parse(url, CTRel.type, xmlOptions);
        }

        public static CTRel parse(XMLStreamReader xMLStreamReader) {
            return (CTRel) POIXMLTypeLoader.parse(xMLStreamReader, CTRel.type, (XmlOptions) null);
        }

        public static CTRel parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTRel) POIXMLTypeLoader.parse(xMLStreamReader, CTRel.type, xmlOptions);
        }

        public static CTRel parse(XMLInputStream xMLInputStream) {
            return (CTRel) POIXMLTypeLoader.parse(xMLInputStream, CTRel.type, (XmlOptions) null);
        }

        public static CTRel parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTRel) POIXMLTypeLoader.parse(xMLInputStream, CTRel.type, xmlOptions);
        }

        public static CTRel parse(Node node) {
            return (CTRel) POIXMLTypeLoader.parse(node, CTRel.type, (XmlOptions) null);
        }

        public static CTRel parse(Node node, XmlOptions xmlOptions) {
            return (CTRel) POIXMLTypeLoader.parse(node, CTRel.type, xmlOptions);
        }
    }

    String getId();

    void setId(String str);

    STRelationshipId xgetId();

    void xsetId(STRelationshipId sTRelationshipId);
}
