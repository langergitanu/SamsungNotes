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
public interface CTSlideMasterIdListEntry extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTSlideMasterIdListEntry.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctslidemasteridlistentryae7ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTSlideMasterIdListEntry newInstance() {
            return (CTSlideMasterIdListEntry) POIXMLTypeLoader.newInstance(CTSlideMasterIdListEntry.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSlideMasterIdListEntry.type, null);
        }

        public static CTSlideMasterIdListEntry parse(File file) {
            return (CTSlideMasterIdListEntry) POIXMLTypeLoader.parse(file, CTSlideMasterIdListEntry.type, (XmlOptions) null);
        }

        public static CTSlideMasterIdListEntry newInstance(XmlOptions xmlOptions) {
            return (CTSlideMasterIdListEntry) POIXMLTypeLoader.newInstance(CTSlideMasterIdListEntry.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSlideMasterIdListEntry.type, xmlOptions);
        }

        public static CTSlideMasterIdListEntry parse(File file, XmlOptions xmlOptions) {
            return (CTSlideMasterIdListEntry) POIXMLTypeLoader.parse(file, CTSlideMasterIdListEntry.type, xmlOptions);
        }

        public static CTSlideMasterIdListEntry parse(InputStream inputStream) {
            return (CTSlideMasterIdListEntry) POIXMLTypeLoader.parse(inputStream, CTSlideMasterIdListEntry.type, (XmlOptions) null);
        }

        public static CTSlideMasterIdListEntry parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTSlideMasterIdListEntry) POIXMLTypeLoader.parse(inputStream, CTSlideMasterIdListEntry.type, xmlOptions);
        }

        public static CTSlideMasterIdListEntry parse(Reader reader) {
            return (CTSlideMasterIdListEntry) POIXMLTypeLoader.parse(reader, CTSlideMasterIdListEntry.type, (XmlOptions) null);
        }

        public static CTSlideMasterIdListEntry parse(Reader reader, XmlOptions xmlOptions) {
            return (CTSlideMasterIdListEntry) POIXMLTypeLoader.parse(reader, CTSlideMasterIdListEntry.type, xmlOptions);
        }

        public static CTSlideMasterIdListEntry parse(String str) {
            return (CTSlideMasterIdListEntry) POIXMLTypeLoader.parse(str, CTSlideMasterIdListEntry.type, (XmlOptions) null);
        }

        public static CTSlideMasterIdListEntry parse(String str, XmlOptions xmlOptions) {
            return (CTSlideMasterIdListEntry) POIXMLTypeLoader.parse(str, CTSlideMasterIdListEntry.type, xmlOptions);
        }

        public static CTSlideMasterIdListEntry parse(URL url) {
            return (CTSlideMasterIdListEntry) POIXMLTypeLoader.parse(url, CTSlideMasterIdListEntry.type, (XmlOptions) null);
        }

        public static CTSlideMasterIdListEntry parse(URL url, XmlOptions xmlOptions) {
            return (CTSlideMasterIdListEntry) POIXMLTypeLoader.parse(url, CTSlideMasterIdListEntry.type, xmlOptions);
        }

        public static CTSlideMasterIdListEntry parse(XMLStreamReader xMLStreamReader) {
            return (CTSlideMasterIdListEntry) POIXMLTypeLoader.parse(xMLStreamReader, CTSlideMasterIdListEntry.type, (XmlOptions) null);
        }

        public static CTSlideMasterIdListEntry parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTSlideMasterIdListEntry) POIXMLTypeLoader.parse(xMLStreamReader, CTSlideMasterIdListEntry.type, xmlOptions);
        }

        public static CTSlideMasterIdListEntry parse(XMLInputStream xMLInputStream) {
            return (CTSlideMasterIdListEntry) POIXMLTypeLoader.parse(xMLInputStream, CTSlideMasterIdListEntry.type, (XmlOptions) null);
        }

        public static CTSlideMasterIdListEntry parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTSlideMasterIdListEntry) POIXMLTypeLoader.parse(xMLInputStream, CTSlideMasterIdListEntry.type, xmlOptions);
        }

        public static CTSlideMasterIdListEntry parse(Node node) {
            return (CTSlideMasterIdListEntry) POIXMLTypeLoader.parse(node, CTSlideMasterIdListEntry.type, (XmlOptions) null);
        }

        public static CTSlideMasterIdListEntry parse(Node node, XmlOptions xmlOptions) {
            return (CTSlideMasterIdListEntry) POIXMLTypeLoader.parse(node, CTSlideMasterIdListEntry.type, xmlOptions);
        }
    }

    CTExtensionList addNewExtLst();

    CTExtensionList getExtLst();

    long getId();

    String getId2();

    boolean isSetExtLst();

    boolean isSetId();

    void setExtLst(CTExtensionList cTExtensionList);

    void setId(long j);

    void setId2(String str);

    void unsetExtLst();

    void unsetId();

    STSlideMasterId xgetId();

    STRelationshipId xgetId2();

    void xsetId(STSlideMasterId sTSlideMasterId);

    void xsetId2(STRelationshipId sTRelationshipId);
}
