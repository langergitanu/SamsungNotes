package org.openxmlformats.schemas.drawingml.x2006.main;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTFontCollection extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTFontCollection.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctfontcollectiondd68type");

    public static final class Factory {
        private Factory() {
        }

        public static CTFontCollection newInstance() {
            return (CTFontCollection) POIXMLTypeLoader.newInstance(CTFontCollection.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTFontCollection.type, null);
        }

        public static CTFontCollection parse(File file) {
            return (CTFontCollection) POIXMLTypeLoader.parse(file, CTFontCollection.type, (XmlOptions) null);
        }

        public static CTFontCollection newInstance(XmlOptions xmlOptions) {
            return (CTFontCollection) POIXMLTypeLoader.newInstance(CTFontCollection.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTFontCollection.type, xmlOptions);
        }

        public static CTFontCollection parse(File file, XmlOptions xmlOptions) {
            return (CTFontCollection) POIXMLTypeLoader.parse(file, CTFontCollection.type, xmlOptions);
        }

        public static CTFontCollection parse(InputStream inputStream) {
            return (CTFontCollection) POIXMLTypeLoader.parse(inputStream, CTFontCollection.type, (XmlOptions) null);
        }

        public static CTFontCollection parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTFontCollection) POIXMLTypeLoader.parse(inputStream, CTFontCollection.type, xmlOptions);
        }

        public static CTFontCollection parse(Reader reader) {
            return (CTFontCollection) POIXMLTypeLoader.parse(reader, CTFontCollection.type, (XmlOptions) null);
        }

        public static CTFontCollection parse(Reader reader, XmlOptions xmlOptions) {
            return (CTFontCollection) POIXMLTypeLoader.parse(reader, CTFontCollection.type, xmlOptions);
        }

        public static CTFontCollection parse(String str) {
            return (CTFontCollection) POIXMLTypeLoader.parse(str, CTFontCollection.type, (XmlOptions) null);
        }

        public static CTFontCollection parse(String str, XmlOptions xmlOptions) {
            return (CTFontCollection) POIXMLTypeLoader.parse(str, CTFontCollection.type, xmlOptions);
        }

        public static CTFontCollection parse(URL url) {
            return (CTFontCollection) POIXMLTypeLoader.parse(url, CTFontCollection.type, (XmlOptions) null);
        }

        public static CTFontCollection parse(URL url, XmlOptions xmlOptions) {
            return (CTFontCollection) POIXMLTypeLoader.parse(url, CTFontCollection.type, xmlOptions);
        }

        public static CTFontCollection parse(XMLStreamReader xMLStreamReader) {
            return (CTFontCollection) POIXMLTypeLoader.parse(xMLStreamReader, CTFontCollection.type, (XmlOptions) null);
        }

        public static CTFontCollection parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTFontCollection) POIXMLTypeLoader.parse(xMLStreamReader, CTFontCollection.type, xmlOptions);
        }

        public static CTFontCollection parse(XMLInputStream xMLInputStream) {
            return (CTFontCollection) POIXMLTypeLoader.parse(xMLInputStream, CTFontCollection.type, (XmlOptions) null);
        }

        public static CTFontCollection parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTFontCollection) POIXMLTypeLoader.parse(xMLInputStream, CTFontCollection.type, xmlOptions);
        }

        public static CTFontCollection parse(Node node) {
            return (CTFontCollection) POIXMLTypeLoader.parse(node, CTFontCollection.type, (XmlOptions) null);
        }

        public static CTFontCollection parse(Node node, XmlOptions xmlOptions) {
            return (CTFontCollection) POIXMLTypeLoader.parse(node, CTFontCollection.type, xmlOptions);
        }
    }

    CTTextFont addNewCs();

    CTTextFont addNewEa();

    CTOfficeArtExtensionList addNewExtLst();

    CTSupplementalFont addNewFont();

    CTTextFont addNewLatin();

    CTTextFont getCs();

    CTTextFont getEa();

    CTOfficeArtExtensionList getExtLst();

    CTSupplementalFont getFontArray(int i);

    CTSupplementalFont[] getFontArray();

    List<CTSupplementalFont> getFontList();

    CTTextFont getLatin();

    CTSupplementalFont insertNewFont(int i);

    boolean isSetExtLst();

    void removeFont(int i);

    void setCs(CTTextFont cTTextFont);

    void setEa(CTTextFont cTTextFont);

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setFontArray(int i, CTSupplementalFont cTSupplementalFont);

    void setFontArray(CTSupplementalFont[] cTSupplementalFontArr);

    void setLatin(CTTextFont cTTextFont);

    int sizeOfFontArray();

    void unsetExtLst();
}
