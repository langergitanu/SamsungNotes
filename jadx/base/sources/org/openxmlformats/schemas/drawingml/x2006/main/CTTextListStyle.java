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
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTTextListStyle extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTextListStyle.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttextliststyleab77type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextListStyle newInstance() {
            return (CTTextListStyle) POIXMLTypeLoader.newInstance(CTTextListStyle.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextListStyle.type, null);
        }

        public static CTTextListStyle parse(File file) {
            return (CTTextListStyle) POIXMLTypeLoader.parse(file, CTTextListStyle.type, (XmlOptions) null);
        }

        public static CTTextListStyle newInstance(XmlOptions xmlOptions) {
            return (CTTextListStyle) POIXMLTypeLoader.newInstance(CTTextListStyle.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextListStyle.type, xmlOptions);
        }

        public static CTTextListStyle parse(File file, XmlOptions xmlOptions) {
            return (CTTextListStyle) POIXMLTypeLoader.parse(file, CTTextListStyle.type, xmlOptions);
        }

        public static CTTextListStyle parse(InputStream inputStream) {
            return (CTTextListStyle) POIXMLTypeLoader.parse(inputStream, CTTextListStyle.type, (XmlOptions) null);
        }

        public static CTTextListStyle parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTextListStyle) POIXMLTypeLoader.parse(inputStream, CTTextListStyle.type, xmlOptions);
        }

        public static CTTextListStyle parse(Reader reader) {
            return (CTTextListStyle) POIXMLTypeLoader.parse(reader, CTTextListStyle.type, (XmlOptions) null);
        }

        public static CTTextListStyle parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTextListStyle) POIXMLTypeLoader.parse(reader, CTTextListStyle.type, xmlOptions);
        }

        public static CTTextListStyle parse(String str) {
            return (CTTextListStyle) POIXMLTypeLoader.parse(str, CTTextListStyle.type, (XmlOptions) null);
        }

        public static CTTextListStyle parse(String str, XmlOptions xmlOptions) {
            return (CTTextListStyle) POIXMLTypeLoader.parse(str, CTTextListStyle.type, xmlOptions);
        }

        public static CTTextListStyle parse(URL url) {
            return (CTTextListStyle) POIXMLTypeLoader.parse(url, CTTextListStyle.type, (XmlOptions) null);
        }

        public static CTTextListStyle parse(URL url, XmlOptions xmlOptions) {
            return (CTTextListStyle) POIXMLTypeLoader.parse(url, CTTextListStyle.type, xmlOptions);
        }

        public static CTTextListStyle parse(XMLStreamReader xMLStreamReader) {
            return (CTTextListStyle) POIXMLTypeLoader.parse(xMLStreamReader, CTTextListStyle.type, (XmlOptions) null);
        }

        public static CTTextListStyle parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTextListStyle) POIXMLTypeLoader.parse(xMLStreamReader, CTTextListStyle.type, xmlOptions);
        }

        public static CTTextListStyle parse(XMLInputStream xMLInputStream) {
            return (CTTextListStyle) POIXMLTypeLoader.parse(xMLInputStream, CTTextListStyle.type, (XmlOptions) null);
        }

        public static CTTextListStyle parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTextListStyle) POIXMLTypeLoader.parse(xMLInputStream, CTTextListStyle.type, xmlOptions);
        }

        public static CTTextListStyle parse(Node node) {
            return (CTTextListStyle) POIXMLTypeLoader.parse(node, CTTextListStyle.type, (XmlOptions) null);
        }

        public static CTTextListStyle parse(Node node, XmlOptions xmlOptions) {
            return (CTTextListStyle) POIXMLTypeLoader.parse(node, CTTextListStyle.type, xmlOptions);
        }
    }

    CTTextParagraphProperties addNewDefPPr();

    CTOfficeArtExtensionList addNewExtLst();

    CTTextParagraphProperties addNewLvl1PPr();

    CTTextParagraphProperties addNewLvl2PPr();

    CTTextParagraphProperties addNewLvl3PPr();

    CTTextParagraphProperties addNewLvl4PPr();

    CTTextParagraphProperties addNewLvl5PPr();

    CTTextParagraphProperties addNewLvl6PPr();

    CTTextParagraphProperties addNewLvl7PPr();

    CTTextParagraphProperties addNewLvl8PPr();

    CTTextParagraphProperties addNewLvl9PPr();

    CTTextParagraphProperties getDefPPr();

    CTOfficeArtExtensionList getExtLst();

    CTTextParagraphProperties getLvl1PPr();

    CTTextParagraphProperties getLvl2PPr();

    CTTextParagraphProperties getLvl3PPr();

    CTTextParagraphProperties getLvl4PPr();

    CTTextParagraphProperties getLvl5PPr();

    CTTextParagraphProperties getLvl6PPr();

    CTTextParagraphProperties getLvl7PPr();

    CTTextParagraphProperties getLvl8PPr();

    CTTextParagraphProperties getLvl9PPr();

    boolean isSetDefPPr();

    boolean isSetExtLst();

    boolean isSetLvl1PPr();

    boolean isSetLvl2PPr();

    boolean isSetLvl3PPr();

    boolean isSetLvl4PPr();

    boolean isSetLvl5PPr();

    boolean isSetLvl6PPr();

    boolean isSetLvl7PPr();

    boolean isSetLvl8PPr();

    boolean isSetLvl9PPr();

    void setDefPPr(CTTextParagraphProperties cTTextParagraphProperties);

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setLvl1PPr(CTTextParagraphProperties cTTextParagraphProperties);

    void setLvl2PPr(CTTextParagraphProperties cTTextParagraphProperties);

    void setLvl3PPr(CTTextParagraphProperties cTTextParagraphProperties);

    void setLvl4PPr(CTTextParagraphProperties cTTextParagraphProperties);

    void setLvl5PPr(CTTextParagraphProperties cTTextParagraphProperties);

    void setLvl6PPr(CTTextParagraphProperties cTTextParagraphProperties);

    void setLvl7PPr(CTTextParagraphProperties cTTextParagraphProperties);

    void setLvl8PPr(CTTextParagraphProperties cTTextParagraphProperties);

    void setLvl9PPr(CTTextParagraphProperties cTTextParagraphProperties);

    void unsetDefPPr();

    void unsetExtLst();

    void unsetLvl1PPr();

    void unsetLvl2PPr();

    void unsetLvl3PPr();

    void unsetLvl4PPr();

    void unsetLvl5PPr();

    void unsetLvl6PPr();

    void unsetLvl7PPr();

    void unsetLvl8PPr();

    void unsetLvl9PPr();
}
