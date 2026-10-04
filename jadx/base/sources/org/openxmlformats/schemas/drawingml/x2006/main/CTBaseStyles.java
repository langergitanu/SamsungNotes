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
public interface CTBaseStyles extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTBaseStyles.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctbasestyles122etype");

    public static final class Factory {
        private Factory() {
        }

        public static CTBaseStyles newInstance() {
            return (CTBaseStyles) POIXMLTypeLoader.newInstance(CTBaseStyles.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTBaseStyles.type, null);
        }

        public static CTBaseStyles parse(File file) {
            return (CTBaseStyles) POIXMLTypeLoader.parse(file, CTBaseStyles.type, (XmlOptions) null);
        }

        public static CTBaseStyles newInstance(XmlOptions xmlOptions) {
            return (CTBaseStyles) POIXMLTypeLoader.newInstance(CTBaseStyles.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTBaseStyles.type, xmlOptions);
        }

        public static CTBaseStyles parse(File file, XmlOptions xmlOptions) {
            return (CTBaseStyles) POIXMLTypeLoader.parse(file, CTBaseStyles.type, xmlOptions);
        }

        public static CTBaseStyles parse(InputStream inputStream) {
            return (CTBaseStyles) POIXMLTypeLoader.parse(inputStream, CTBaseStyles.type, (XmlOptions) null);
        }

        public static CTBaseStyles parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTBaseStyles) POIXMLTypeLoader.parse(inputStream, CTBaseStyles.type, xmlOptions);
        }

        public static CTBaseStyles parse(Reader reader) {
            return (CTBaseStyles) POIXMLTypeLoader.parse(reader, CTBaseStyles.type, (XmlOptions) null);
        }

        public static CTBaseStyles parse(Reader reader, XmlOptions xmlOptions) {
            return (CTBaseStyles) POIXMLTypeLoader.parse(reader, CTBaseStyles.type, xmlOptions);
        }

        public static CTBaseStyles parse(String str) {
            return (CTBaseStyles) POIXMLTypeLoader.parse(str, CTBaseStyles.type, (XmlOptions) null);
        }

        public static CTBaseStyles parse(String str, XmlOptions xmlOptions) {
            return (CTBaseStyles) POIXMLTypeLoader.parse(str, CTBaseStyles.type, xmlOptions);
        }

        public static CTBaseStyles parse(URL url) {
            return (CTBaseStyles) POIXMLTypeLoader.parse(url, CTBaseStyles.type, (XmlOptions) null);
        }

        public static CTBaseStyles parse(URL url, XmlOptions xmlOptions) {
            return (CTBaseStyles) POIXMLTypeLoader.parse(url, CTBaseStyles.type, xmlOptions);
        }

        public static CTBaseStyles parse(XMLStreamReader xMLStreamReader) {
            return (CTBaseStyles) POIXMLTypeLoader.parse(xMLStreamReader, CTBaseStyles.type, (XmlOptions) null);
        }

        public static CTBaseStyles parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTBaseStyles) POIXMLTypeLoader.parse(xMLStreamReader, CTBaseStyles.type, xmlOptions);
        }

        public static CTBaseStyles parse(XMLInputStream xMLInputStream) {
            return (CTBaseStyles) POIXMLTypeLoader.parse(xMLInputStream, CTBaseStyles.type, (XmlOptions) null);
        }

        public static CTBaseStyles parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTBaseStyles) POIXMLTypeLoader.parse(xMLInputStream, CTBaseStyles.type, xmlOptions);
        }

        public static CTBaseStyles parse(Node node) {
            return (CTBaseStyles) POIXMLTypeLoader.parse(node, CTBaseStyles.type, (XmlOptions) null);
        }

        public static CTBaseStyles parse(Node node, XmlOptions xmlOptions) {
            return (CTBaseStyles) POIXMLTypeLoader.parse(node, CTBaseStyles.type, xmlOptions);
        }
    }

    CTColorScheme addNewClrScheme();

    CTOfficeArtExtensionList addNewExtLst();

    CTStyleMatrix addNewFmtScheme();

    CTFontScheme addNewFontScheme();

    CTColorScheme getClrScheme();

    CTOfficeArtExtensionList getExtLst();

    CTStyleMatrix getFmtScheme();

    CTFontScheme getFontScheme();

    boolean isSetExtLst();

    void setClrScheme(CTColorScheme cTColorScheme);

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setFmtScheme(CTStyleMatrix cTStyleMatrix);

    void setFontScheme(CTFontScheme cTFontScheme);

    void unsetExtLst();
}
