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
public interface CTAudioFile extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTAudioFile.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctaudiofile1563type");

    public static final class Factory {
        private Factory() {
        }

        public static CTAudioFile newInstance() {
            return (CTAudioFile) POIXMLTypeLoader.newInstance(CTAudioFile.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTAudioFile.type, null);
        }

        public static CTAudioFile parse(File file) {
            return (CTAudioFile) POIXMLTypeLoader.parse(file, CTAudioFile.type, (XmlOptions) null);
        }

        public static CTAudioFile newInstance(XmlOptions xmlOptions) {
            return (CTAudioFile) POIXMLTypeLoader.newInstance(CTAudioFile.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTAudioFile.type, xmlOptions);
        }

        public static CTAudioFile parse(File file, XmlOptions xmlOptions) {
            return (CTAudioFile) POIXMLTypeLoader.parse(file, CTAudioFile.type, xmlOptions);
        }

        public static CTAudioFile parse(InputStream inputStream) {
            return (CTAudioFile) POIXMLTypeLoader.parse(inputStream, CTAudioFile.type, (XmlOptions) null);
        }

        public static CTAudioFile parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTAudioFile) POIXMLTypeLoader.parse(inputStream, CTAudioFile.type, xmlOptions);
        }

        public static CTAudioFile parse(Reader reader) {
            return (CTAudioFile) POIXMLTypeLoader.parse(reader, CTAudioFile.type, (XmlOptions) null);
        }

        public static CTAudioFile parse(Reader reader, XmlOptions xmlOptions) {
            return (CTAudioFile) POIXMLTypeLoader.parse(reader, CTAudioFile.type, xmlOptions);
        }

        public static CTAudioFile parse(String str) {
            return (CTAudioFile) POIXMLTypeLoader.parse(str, CTAudioFile.type, (XmlOptions) null);
        }

        public static CTAudioFile parse(String str, XmlOptions xmlOptions) {
            return (CTAudioFile) POIXMLTypeLoader.parse(str, CTAudioFile.type, xmlOptions);
        }

        public static CTAudioFile parse(URL url) {
            return (CTAudioFile) POIXMLTypeLoader.parse(url, CTAudioFile.type, (XmlOptions) null);
        }

        public static CTAudioFile parse(URL url, XmlOptions xmlOptions) {
            return (CTAudioFile) POIXMLTypeLoader.parse(url, CTAudioFile.type, xmlOptions);
        }

        public static CTAudioFile parse(XMLStreamReader xMLStreamReader) {
            return (CTAudioFile) POIXMLTypeLoader.parse(xMLStreamReader, CTAudioFile.type, (XmlOptions) null);
        }

        public static CTAudioFile parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTAudioFile) POIXMLTypeLoader.parse(xMLStreamReader, CTAudioFile.type, xmlOptions);
        }

        public static CTAudioFile parse(XMLInputStream xMLInputStream) {
            return (CTAudioFile) POIXMLTypeLoader.parse(xMLInputStream, CTAudioFile.type, (XmlOptions) null);
        }

        public static CTAudioFile parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTAudioFile) POIXMLTypeLoader.parse(xMLInputStream, CTAudioFile.type, xmlOptions);
        }

        public static CTAudioFile parse(Node node) {
            return (CTAudioFile) POIXMLTypeLoader.parse(node, CTAudioFile.type, (XmlOptions) null);
        }

        public static CTAudioFile parse(Node node, XmlOptions xmlOptions) {
            return (CTAudioFile) POIXMLTypeLoader.parse(node, CTAudioFile.type, xmlOptions);
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
