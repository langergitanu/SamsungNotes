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
public interface CTFontScheme extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTFontScheme.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctfontscheme232ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTFontScheme newInstance() {
            return (CTFontScheme) POIXMLTypeLoader.newInstance(CTFontScheme.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTFontScheme.type, null);
        }

        public static CTFontScheme parse(File file) {
            return (CTFontScheme) POIXMLTypeLoader.parse(file, CTFontScheme.type, (XmlOptions) null);
        }

        public static CTFontScheme newInstance(XmlOptions xmlOptions) {
            return (CTFontScheme) POIXMLTypeLoader.newInstance(CTFontScheme.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTFontScheme.type, xmlOptions);
        }

        public static CTFontScheme parse(File file, XmlOptions xmlOptions) {
            return (CTFontScheme) POIXMLTypeLoader.parse(file, CTFontScheme.type, xmlOptions);
        }

        public static CTFontScheme parse(InputStream inputStream) {
            return (CTFontScheme) POIXMLTypeLoader.parse(inputStream, CTFontScheme.type, (XmlOptions) null);
        }

        public static CTFontScheme parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTFontScheme) POIXMLTypeLoader.parse(inputStream, CTFontScheme.type, xmlOptions);
        }

        public static CTFontScheme parse(Reader reader) {
            return (CTFontScheme) POIXMLTypeLoader.parse(reader, CTFontScheme.type, (XmlOptions) null);
        }

        public static CTFontScheme parse(Reader reader, XmlOptions xmlOptions) {
            return (CTFontScheme) POIXMLTypeLoader.parse(reader, CTFontScheme.type, xmlOptions);
        }

        public static CTFontScheme parse(String str) {
            return (CTFontScheme) POIXMLTypeLoader.parse(str, CTFontScheme.type, (XmlOptions) null);
        }

        public static CTFontScheme parse(String str, XmlOptions xmlOptions) {
            return (CTFontScheme) POIXMLTypeLoader.parse(str, CTFontScheme.type, xmlOptions);
        }

        public static CTFontScheme parse(URL url) {
            return (CTFontScheme) POIXMLTypeLoader.parse(url, CTFontScheme.type, (XmlOptions) null);
        }

        public static CTFontScheme parse(URL url, XmlOptions xmlOptions) {
            return (CTFontScheme) POIXMLTypeLoader.parse(url, CTFontScheme.type, xmlOptions);
        }

        public static CTFontScheme parse(XMLStreamReader xMLStreamReader) {
            return (CTFontScheme) POIXMLTypeLoader.parse(xMLStreamReader, CTFontScheme.type, (XmlOptions) null);
        }

        public static CTFontScheme parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTFontScheme) POIXMLTypeLoader.parse(xMLStreamReader, CTFontScheme.type, xmlOptions);
        }

        public static CTFontScheme parse(XMLInputStream xMLInputStream) {
            return (CTFontScheme) POIXMLTypeLoader.parse(xMLInputStream, CTFontScheme.type, (XmlOptions) null);
        }

        public static CTFontScheme parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTFontScheme) POIXMLTypeLoader.parse(xMLInputStream, CTFontScheme.type, xmlOptions);
        }

        public static CTFontScheme parse(Node node) {
            return (CTFontScheme) POIXMLTypeLoader.parse(node, CTFontScheme.type, (XmlOptions) null);
        }

        public static CTFontScheme parse(Node node, XmlOptions xmlOptions) {
            return (CTFontScheme) POIXMLTypeLoader.parse(node, CTFontScheme.type, xmlOptions);
        }
    }

    CTOfficeArtExtensionList addNewExtLst();

    CTFontCollection addNewMajorFont();

    CTFontCollection addNewMinorFont();

    CTOfficeArtExtensionList getExtLst();

    CTFontCollection getMajorFont();

    CTFontCollection getMinorFont();

    String getName();

    boolean isSetExtLst();

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setMajorFont(CTFontCollection cTFontCollection);

    void setMinorFont(CTFontCollection cTFontCollection);

    void setName(String str);

    void unsetExtLst();

    XmlString xgetName();

    void xsetName(XmlString xmlString);
}
