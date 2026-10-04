package org.openxmlformats.schemas.presentationml.x2006.main;

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
public interface CTSlideIdListEntry extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTSlideIdListEntry.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctslideidlistentry427dtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTSlideIdListEntry newInstance() {
            return (CTSlideIdListEntry) POIXMLTypeLoader.newInstance(CTSlideIdListEntry.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSlideIdListEntry.type, null);
        }

        public static CTSlideIdListEntry parse(File file) {
            return (CTSlideIdListEntry) POIXMLTypeLoader.parse(file, CTSlideIdListEntry.type, (XmlOptions) null);
        }

        public static CTSlideIdListEntry newInstance(XmlOptions xmlOptions) {
            return (CTSlideIdListEntry) POIXMLTypeLoader.newInstance(CTSlideIdListEntry.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSlideIdListEntry.type, xmlOptions);
        }

        public static CTSlideIdListEntry parse(File file, XmlOptions xmlOptions) {
            return (CTSlideIdListEntry) POIXMLTypeLoader.parse(file, CTSlideIdListEntry.type, xmlOptions);
        }

        public static CTSlideIdListEntry parse(InputStream inputStream) {
            return (CTSlideIdListEntry) POIXMLTypeLoader.parse(inputStream, CTSlideIdListEntry.type, (XmlOptions) null);
        }

        public static CTSlideIdListEntry parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTSlideIdListEntry) POIXMLTypeLoader.parse(inputStream, CTSlideIdListEntry.type, xmlOptions);
        }

        public static CTSlideIdListEntry parse(Reader reader) {
            return (CTSlideIdListEntry) POIXMLTypeLoader.parse(reader, CTSlideIdListEntry.type, (XmlOptions) null);
        }

        public static CTSlideIdListEntry parse(Reader reader, XmlOptions xmlOptions) {
            return (CTSlideIdListEntry) POIXMLTypeLoader.parse(reader, CTSlideIdListEntry.type, xmlOptions);
        }

        public static CTSlideIdListEntry parse(String str) {
            return (CTSlideIdListEntry) POIXMLTypeLoader.parse(str, CTSlideIdListEntry.type, (XmlOptions) null);
        }

        public static CTSlideIdListEntry parse(String str, XmlOptions xmlOptions) {
            return (CTSlideIdListEntry) POIXMLTypeLoader.parse(str, CTSlideIdListEntry.type, xmlOptions);
        }

        public static CTSlideIdListEntry parse(URL url) {
            return (CTSlideIdListEntry) POIXMLTypeLoader.parse(url, CTSlideIdListEntry.type, (XmlOptions) null);
        }

        public static CTSlideIdListEntry parse(URL url, XmlOptions xmlOptions) {
            return (CTSlideIdListEntry) POIXMLTypeLoader.parse(url, CTSlideIdListEntry.type, xmlOptions);
        }

        public static CTSlideIdListEntry parse(XMLStreamReader xMLStreamReader) {
            return (CTSlideIdListEntry) POIXMLTypeLoader.parse(xMLStreamReader, CTSlideIdListEntry.type, (XmlOptions) null);
        }

        public static CTSlideIdListEntry parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTSlideIdListEntry) POIXMLTypeLoader.parse(xMLStreamReader, CTSlideIdListEntry.type, xmlOptions);
        }

        public static CTSlideIdListEntry parse(XMLInputStream xMLInputStream) {
            return (CTSlideIdListEntry) POIXMLTypeLoader.parse(xMLInputStream, CTSlideIdListEntry.type, (XmlOptions) null);
        }

        public static CTSlideIdListEntry parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTSlideIdListEntry) POIXMLTypeLoader.parse(xMLInputStream, CTSlideIdListEntry.type, xmlOptions);
        }

        public static CTSlideIdListEntry parse(Node node) {
            return (CTSlideIdListEntry) POIXMLTypeLoader.parse(node, CTSlideIdListEntry.type, (XmlOptions) null);
        }

        public static CTSlideIdListEntry parse(Node node, XmlOptions xmlOptions) {
            return (CTSlideIdListEntry) POIXMLTypeLoader.parse(node, CTSlideIdListEntry.type, xmlOptions);
        }
    }

    CTExtensionList addNewExtLst();

    CTExtensionList getExtLst();

    long getId();

    String getId2();

    boolean isSetExtLst();

    void setExtLst(CTExtensionList cTExtensionList);

    void setId(long j);

    void setId2(String str);

    void unsetExtLst();

    STSlideId xgetId();

    STRelationshipId xgetId2();

    void xsetId(STSlideId sTSlideId);

    void xsetId2(STRelationshipId sTRelationshipId);
}
