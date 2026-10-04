package org.openxmlformats.schemas.drawingml.x2006.main;

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
public interface CTVideoFile extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTVideoFile.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctvideofile85c8type");

    public static final class Factory {
        private Factory() {
        }

        public static CTVideoFile newInstance() {
            return (CTVideoFile) POIXMLTypeLoader.newInstance(CTVideoFile.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTVideoFile.type, null);
        }

        public static CTVideoFile parse(File file) {
            return (CTVideoFile) POIXMLTypeLoader.parse(file, CTVideoFile.type, (XmlOptions) null);
        }

        public static CTVideoFile newInstance(XmlOptions xmlOptions) {
            return (CTVideoFile) POIXMLTypeLoader.newInstance(CTVideoFile.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTVideoFile.type, xmlOptions);
        }

        public static CTVideoFile parse(File file, XmlOptions xmlOptions) {
            return (CTVideoFile) POIXMLTypeLoader.parse(file, CTVideoFile.type, xmlOptions);
        }

        public static CTVideoFile parse(InputStream inputStream) {
            return (CTVideoFile) POIXMLTypeLoader.parse(inputStream, CTVideoFile.type, (XmlOptions) null);
        }

        public static CTVideoFile parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTVideoFile) POIXMLTypeLoader.parse(inputStream, CTVideoFile.type, xmlOptions);
        }

        public static CTVideoFile parse(Reader reader) {
            return (CTVideoFile) POIXMLTypeLoader.parse(reader, CTVideoFile.type, (XmlOptions) null);
        }

        public static CTVideoFile parse(Reader reader, XmlOptions xmlOptions) {
            return (CTVideoFile) POIXMLTypeLoader.parse(reader, CTVideoFile.type, xmlOptions);
        }

        public static CTVideoFile parse(String str) {
            return (CTVideoFile) POIXMLTypeLoader.parse(str, CTVideoFile.type, (XmlOptions) null);
        }

        public static CTVideoFile parse(String str, XmlOptions xmlOptions) {
            return (CTVideoFile) POIXMLTypeLoader.parse(str, CTVideoFile.type, xmlOptions);
        }

        public static CTVideoFile parse(URL url) {
            return (CTVideoFile) POIXMLTypeLoader.parse(url, CTVideoFile.type, (XmlOptions) null);
        }

        public static CTVideoFile parse(URL url, XmlOptions xmlOptions) {
            return (CTVideoFile) POIXMLTypeLoader.parse(url, CTVideoFile.type, xmlOptions);
        }

        public static CTVideoFile parse(XMLStreamReader xMLStreamReader) {
            return (CTVideoFile) POIXMLTypeLoader.parse(xMLStreamReader, CTVideoFile.type, (XmlOptions) null);
        }

        public static CTVideoFile parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTVideoFile) POIXMLTypeLoader.parse(xMLStreamReader, CTVideoFile.type, xmlOptions);
        }

        public static CTVideoFile parse(XMLInputStream xMLInputStream) {
            return (CTVideoFile) POIXMLTypeLoader.parse(xMLInputStream, CTVideoFile.type, (XmlOptions) null);
        }

        public static CTVideoFile parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTVideoFile) POIXMLTypeLoader.parse(xMLInputStream, CTVideoFile.type, xmlOptions);
        }

        public static CTVideoFile parse(Node node) {
            return (CTVideoFile) POIXMLTypeLoader.parse(node, CTVideoFile.type, (XmlOptions) null);
        }

        public static CTVideoFile parse(Node node, XmlOptions xmlOptions) {
            return (CTVideoFile) POIXMLTypeLoader.parse(node, CTVideoFile.type, xmlOptions);
        }
    }

    CTOfficeArtExtensionList addNewExtLst();

    CTOfficeArtExtensionList getExtLst();

    String getLink();

    boolean isSetExtLst();

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setLink(String str);

    void unsetExtLst();

    STRelationshipId xgetLink();

    void xsetLink(STRelationshipId sTRelationshipId);
}
