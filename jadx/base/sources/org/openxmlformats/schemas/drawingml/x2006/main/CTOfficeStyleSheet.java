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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTOfficeStyleSheet extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTOfficeStyleSheet.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctofficestylesheetce25type");

    public static final class Factory {
        private Factory() {
        }

        public static CTOfficeStyleSheet newInstance() {
            return (CTOfficeStyleSheet) POIXMLTypeLoader.newInstance(CTOfficeStyleSheet.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTOfficeStyleSheet.type, null);
        }

        public static CTOfficeStyleSheet parse(File file) {
            return (CTOfficeStyleSheet) POIXMLTypeLoader.parse(file, CTOfficeStyleSheet.type, (XmlOptions) null);
        }

        public static CTOfficeStyleSheet newInstance(XmlOptions xmlOptions) {
            return (CTOfficeStyleSheet) POIXMLTypeLoader.newInstance(CTOfficeStyleSheet.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTOfficeStyleSheet.type, xmlOptions);
        }

        public static CTOfficeStyleSheet parse(File file, XmlOptions xmlOptions) {
            return (CTOfficeStyleSheet) POIXMLTypeLoader.parse(file, CTOfficeStyleSheet.type, xmlOptions);
        }

        public static CTOfficeStyleSheet parse(InputStream inputStream) {
            return (CTOfficeStyleSheet) POIXMLTypeLoader.parse(inputStream, CTOfficeStyleSheet.type, (XmlOptions) null);
        }

        public static CTOfficeStyleSheet parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTOfficeStyleSheet) POIXMLTypeLoader.parse(inputStream, CTOfficeStyleSheet.type, xmlOptions);
        }

        public static CTOfficeStyleSheet parse(Reader reader) {
            return (CTOfficeStyleSheet) POIXMLTypeLoader.parse(reader, CTOfficeStyleSheet.type, (XmlOptions) null);
        }

        public static CTOfficeStyleSheet parse(Reader reader, XmlOptions xmlOptions) {
            return (CTOfficeStyleSheet) POIXMLTypeLoader.parse(reader, CTOfficeStyleSheet.type, xmlOptions);
        }

        public static CTOfficeStyleSheet parse(String str) {
            return (CTOfficeStyleSheet) POIXMLTypeLoader.parse(str, CTOfficeStyleSheet.type, (XmlOptions) null);
        }

        public static CTOfficeStyleSheet parse(String str, XmlOptions xmlOptions) {
            return (CTOfficeStyleSheet) POIXMLTypeLoader.parse(str, CTOfficeStyleSheet.type, xmlOptions);
        }

        public static CTOfficeStyleSheet parse(URL url) {
            return (CTOfficeStyleSheet) POIXMLTypeLoader.parse(url, CTOfficeStyleSheet.type, (XmlOptions) null);
        }

        public static CTOfficeStyleSheet parse(URL url, XmlOptions xmlOptions) {
            return (CTOfficeStyleSheet) POIXMLTypeLoader.parse(url, CTOfficeStyleSheet.type, xmlOptions);
        }

        public static CTOfficeStyleSheet parse(XMLStreamReader xMLStreamReader) {
            return (CTOfficeStyleSheet) POIXMLTypeLoader.parse(xMLStreamReader, CTOfficeStyleSheet.type, (XmlOptions) null);
        }

        public static CTOfficeStyleSheet parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTOfficeStyleSheet) POIXMLTypeLoader.parse(xMLStreamReader, CTOfficeStyleSheet.type, xmlOptions);
        }

        public static CTOfficeStyleSheet parse(XMLInputStream xMLInputStream) {
            return (CTOfficeStyleSheet) POIXMLTypeLoader.parse(xMLInputStream, CTOfficeStyleSheet.type, (XmlOptions) null);
        }

        public static CTOfficeStyleSheet parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTOfficeStyleSheet) POIXMLTypeLoader.parse(xMLInputStream, CTOfficeStyleSheet.type, xmlOptions);
        }

        public static CTOfficeStyleSheet parse(Node node) {
            return (CTOfficeStyleSheet) POIXMLTypeLoader.parse(node, CTOfficeStyleSheet.type, (XmlOptions) null);
        }

        public static CTOfficeStyleSheet parse(Node node, XmlOptions xmlOptions) {
            return (CTOfficeStyleSheet) POIXMLTypeLoader.parse(node, CTOfficeStyleSheet.type, xmlOptions);
        }
    }

    CTCustomColorList addNewCustClrLst();

    CTOfficeArtExtensionList addNewExtLst();

    CTColorSchemeList addNewExtraClrSchemeLst();

    CTObjectStyleDefaults addNewObjectDefaults();

    CTBaseStyles addNewThemeElements();

    CTCustomColorList getCustClrLst();

    CTOfficeArtExtensionList getExtLst();

    CTColorSchemeList getExtraClrSchemeLst();

    String getName();

    CTObjectStyleDefaults getObjectDefaults();

    CTBaseStyles getThemeElements();

    boolean isSetCustClrLst();

    boolean isSetExtLst();

    boolean isSetExtraClrSchemeLst();

    boolean isSetName();

    boolean isSetObjectDefaults();

    void setCustClrLst(CTCustomColorList cTCustomColorList);

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setExtraClrSchemeLst(CTColorSchemeList cTColorSchemeList);

    void setName(String str);

    void setObjectDefaults(CTObjectStyleDefaults cTObjectStyleDefaults);

    void setThemeElements(CTBaseStyles cTBaseStyles);

    void unsetCustClrLst();

    void unsetExtLst();

    void unsetExtraClrSchemeLst();

    void unsetName();

    void unsetObjectDefaults();

    XmlString xgetName();

    void xsetName(XmlString xmlString);
}
