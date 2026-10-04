package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTheme;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTFonts extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTFonts.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctfonts124etype");

    public static final class Factory {
        private Factory() {
        }

        public static CTFonts newInstance() {
            return (CTFonts) POIXMLTypeLoader.newInstance(CTFonts.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTFonts.type, null);
        }

        public static CTFonts parse(File file) {
            return (CTFonts) POIXMLTypeLoader.parse(file, CTFonts.type, (XmlOptions) null);
        }

        public static CTFonts newInstance(XmlOptions xmlOptions) {
            return (CTFonts) POIXMLTypeLoader.newInstance(CTFonts.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTFonts.type, xmlOptions);
        }

        public static CTFonts parse(File file, XmlOptions xmlOptions) {
            return (CTFonts) POIXMLTypeLoader.parse(file, CTFonts.type, xmlOptions);
        }

        public static CTFonts parse(InputStream inputStream) {
            return (CTFonts) POIXMLTypeLoader.parse(inputStream, CTFonts.type, (XmlOptions) null);
        }

        public static CTFonts parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTFonts) POIXMLTypeLoader.parse(inputStream, CTFonts.type, xmlOptions);
        }

        public static CTFonts parse(Reader reader) {
            return (CTFonts) POIXMLTypeLoader.parse(reader, CTFonts.type, (XmlOptions) null);
        }

        public static CTFonts parse(Reader reader, XmlOptions xmlOptions) {
            return (CTFonts) POIXMLTypeLoader.parse(reader, CTFonts.type, xmlOptions);
        }

        public static CTFonts parse(String str) {
            return (CTFonts) POIXMLTypeLoader.parse(str, CTFonts.type, (XmlOptions) null);
        }

        public static CTFonts parse(String str, XmlOptions xmlOptions) {
            return (CTFonts) POIXMLTypeLoader.parse(str, CTFonts.type, xmlOptions);
        }

        public static CTFonts parse(URL url) {
            return (CTFonts) POIXMLTypeLoader.parse(url, CTFonts.type, (XmlOptions) null);
        }

        public static CTFonts parse(URL url, XmlOptions xmlOptions) {
            return (CTFonts) POIXMLTypeLoader.parse(url, CTFonts.type, xmlOptions);
        }

        public static CTFonts parse(XMLStreamReader xMLStreamReader) {
            return (CTFonts) POIXMLTypeLoader.parse(xMLStreamReader, CTFonts.type, (XmlOptions) null);
        }

        public static CTFonts parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTFonts) POIXMLTypeLoader.parse(xMLStreamReader, CTFonts.type, xmlOptions);
        }

        public static CTFonts parse(XMLInputStream xMLInputStream) {
            return (CTFonts) POIXMLTypeLoader.parse(xMLInputStream, CTFonts.type, (XmlOptions) null);
        }

        public static CTFonts parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTFonts) POIXMLTypeLoader.parse(xMLInputStream, CTFonts.type, xmlOptions);
        }

        public static CTFonts parse(Node node) {
            return (CTFonts) POIXMLTypeLoader.parse(node, CTFonts.type, (XmlOptions) null);
        }

        public static CTFonts parse(Node node, XmlOptions xmlOptions) {
            return (CTFonts) POIXMLTypeLoader.parse(node, CTFonts.type, xmlOptions);
        }
    }

    String getAscii();

    STTheme.Enum getAsciiTheme();

    String getCs();

    STTheme.Enum getCstheme();

    String getEastAsia();

    STTheme.Enum getEastAsiaTheme();

    String getHAnsi();

    STTheme.Enum getHAnsiTheme();

    STHint$Enum getHint();

    boolean isSetAscii();

    boolean isSetAsciiTheme();

    boolean isSetCs();

    boolean isSetCstheme();

    boolean isSetEastAsia();

    boolean isSetEastAsiaTheme();

    boolean isSetHAnsi();

    boolean isSetHAnsiTheme();

    boolean isSetHint();

    void setAscii(String str);

    void setAsciiTheme(STTheme.Enum r12);

    void setCs(String str);

    void setCstheme(STTheme.Enum r12);

    void setEastAsia(String str);

    void setEastAsiaTheme(STTheme.Enum r12);

    void setHAnsi(String str);

    void setHAnsiTheme(STTheme.Enum r12);

    void setHint(STHint$Enum sTHint$Enum);

    void unsetAscii();

    void unsetAsciiTheme();

    void unsetCs();

    void unsetCstheme();

    void unsetEastAsia();

    void unsetEastAsiaTheme();

    void unsetHAnsi();

    void unsetHAnsiTheme();

    void unsetHint();

    STString xgetAscii();

    STTheme xgetAsciiTheme();

    STString xgetCs();

    STTheme xgetCstheme();

    STString xgetEastAsia();

    STTheme xgetEastAsiaTheme();

    STString xgetHAnsi();

    STTheme xgetHAnsiTheme();

    STHint xgetHint();

    void xsetAscii(STString sTString);

    void xsetAsciiTheme(STTheme sTTheme);

    void xsetCs(STString sTString);

    void xsetCstheme(STTheme sTTheme);

    void xsetEastAsia(STString sTString);

    void xsetEastAsiaTheme(STTheme sTTheme);

    void xsetHAnsi(STString sTString);

    void xsetHAnsiTheme(STTheme sTTheme);

    void xsetHint(STHint sTHint);
}
