package org.openxmlformats.schemas.drawingml.x2006.main;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.openxmlformats.schemas.officeDocument.x2006.relationships.STRelationshipId;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTHyperlink extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTHyperlink.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cthyperlink4457type");

    public static final class Factory {
        private Factory() {
        }

        public static CTHyperlink newInstance() {
            return (CTHyperlink) POIXMLTypeLoader.newInstance(CTHyperlink.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTHyperlink.type, null);
        }

        public static CTHyperlink parse(File file) {
            return (CTHyperlink) POIXMLTypeLoader.parse(file, CTHyperlink.type, (XmlOptions) null);
        }

        public static CTHyperlink newInstance(XmlOptions xmlOptions) {
            return (CTHyperlink) POIXMLTypeLoader.newInstance(CTHyperlink.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTHyperlink.type, xmlOptions);
        }

        public static CTHyperlink parse(File file, XmlOptions xmlOptions) {
            return (CTHyperlink) POIXMLTypeLoader.parse(file, CTHyperlink.type, xmlOptions);
        }

        public static CTHyperlink parse(InputStream inputStream) {
            return (CTHyperlink) POIXMLTypeLoader.parse(inputStream, CTHyperlink.type, (XmlOptions) null);
        }

        public static CTHyperlink parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTHyperlink) POIXMLTypeLoader.parse(inputStream, CTHyperlink.type, xmlOptions);
        }

        public static CTHyperlink parse(Reader reader) {
            return (CTHyperlink) POIXMLTypeLoader.parse(reader, CTHyperlink.type, (XmlOptions) null);
        }

        public static CTHyperlink parse(Reader reader, XmlOptions xmlOptions) {
            return (CTHyperlink) POIXMLTypeLoader.parse(reader, CTHyperlink.type, xmlOptions);
        }

        public static CTHyperlink parse(String str) {
            return (CTHyperlink) POIXMLTypeLoader.parse(str, CTHyperlink.type, (XmlOptions) null);
        }

        public static CTHyperlink parse(String str, XmlOptions xmlOptions) {
            return (CTHyperlink) POIXMLTypeLoader.parse(str, CTHyperlink.type, xmlOptions);
        }

        public static CTHyperlink parse(URL url) {
            return (CTHyperlink) POIXMLTypeLoader.parse(url, CTHyperlink.type, (XmlOptions) null);
        }

        public static CTHyperlink parse(URL url, XmlOptions xmlOptions) {
            return (CTHyperlink) POIXMLTypeLoader.parse(url, CTHyperlink.type, xmlOptions);
        }

        public static CTHyperlink parse(XMLStreamReader xMLStreamReader) {
            return (CTHyperlink) POIXMLTypeLoader.parse(xMLStreamReader, CTHyperlink.type, (XmlOptions) null);
        }

        public static CTHyperlink parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTHyperlink) POIXMLTypeLoader.parse(xMLStreamReader, CTHyperlink.type, xmlOptions);
        }

        public static CTHyperlink parse(XMLInputStream xMLInputStream) {
            return (CTHyperlink) POIXMLTypeLoader.parse(xMLInputStream, CTHyperlink.type, (XmlOptions) null);
        }

        public static CTHyperlink parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTHyperlink) POIXMLTypeLoader.parse(xMLInputStream, CTHyperlink.type, xmlOptions);
        }

        public static CTHyperlink parse(Node node) {
            return (CTHyperlink) POIXMLTypeLoader.parse(node, CTHyperlink.type, (XmlOptions) null);
        }

        public static CTHyperlink parse(Node node, XmlOptions xmlOptions) {
            return (CTHyperlink) POIXMLTypeLoader.parse(node, CTHyperlink.type, xmlOptions);
        }
    }

    CTOfficeArtExtensionList addNewExtLst();

    CTEmbeddedWAVAudioFile addNewSnd();

    String getAction();

    boolean getEndSnd();

    CTOfficeArtExtensionList getExtLst();

    boolean getHighlightClick();

    boolean getHistory();

    String getId();

    String getInvalidUrl();

    CTEmbeddedWAVAudioFile getSnd();

    String getTgtFrame();

    String getTooltip();

    boolean isSetAction();

    boolean isSetEndSnd();

    boolean isSetExtLst();

    boolean isSetHighlightClick();

    boolean isSetHistory();

    boolean isSetId();

    boolean isSetInvalidUrl();

    boolean isSetSnd();

    boolean isSetTgtFrame();

    boolean isSetTooltip();

    void setAction(String str);

    void setEndSnd(boolean z);

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setHighlightClick(boolean z);

    void setHistory(boolean z);

    void setId(String str);

    void setInvalidUrl(String str);

    void setSnd(CTEmbeddedWAVAudioFile cTEmbeddedWAVAudioFile);

    void setTgtFrame(String str);

    void setTooltip(String str);

    void unsetAction();

    void unsetEndSnd();

    void unsetExtLst();

    void unsetHighlightClick();

    void unsetHistory();

    void unsetId();

    void unsetInvalidUrl();

    void unsetSnd();

    void unsetTgtFrame();

    void unsetTooltip();

    XmlString xgetAction();

    XmlBoolean xgetEndSnd();

    XmlBoolean xgetHighlightClick();

    XmlBoolean xgetHistory();

    STRelationshipId xgetId();

    XmlString xgetInvalidUrl();

    XmlString xgetTgtFrame();

    XmlString xgetTooltip();

    void xsetAction(XmlString xmlString);

    void xsetEndSnd(XmlBoolean xmlBoolean);

    void xsetHighlightClick(XmlBoolean xmlBoolean);

    void xsetHistory(XmlBoolean xmlBoolean);

    void xsetId(STRelationshipId sTRelationshipId);

    void xsetInvalidUrl(XmlString xmlString);

    void xsetTgtFrame(XmlString xmlString);

    void xsetTooltip(XmlString xmlString);
}
