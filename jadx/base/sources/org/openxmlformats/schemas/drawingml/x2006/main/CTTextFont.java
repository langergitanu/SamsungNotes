package org.openxmlformats.schemas.drawingml.x2006.main;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlByte;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTTextFont extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTextFont.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttextfont92b7type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextFont newInstance() {
            return (CTTextFont) POIXMLTypeLoader.newInstance(CTTextFont.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextFont.type, null);
        }

        public static CTTextFont parse(File file) {
            return (CTTextFont) POIXMLTypeLoader.parse(file, CTTextFont.type, (XmlOptions) null);
        }

        public static CTTextFont newInstance(XmlOptions xmlOptions) {
            return (CTTextFont) POIXMLTypeLoader.newInstance(CTTextFont.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextFont.type, xmlOptions);
        }

        public static CTTextFont parse(File file, XmlOptions xmlOptions) {
            return (CTTextFont) POIXMLTypeLoader.parse(file, CTTextFont.type, xmlOptions);
        }

        public static CTTextFont parse(InputStream inputStream) {
            return (CTTextFont) POIXMLTypeLoader.parse(inputStream, CTTextFont.type, (XmlOptions) null);
        }

        public static CTTextFont parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTextFont) POIXMLTypeLoader.parse(inputStream, CTTextFont.type, xmlOptions);
        }

        public static CTTextFont parse(Reader reader) {
            return (CTTextFont) POIXMLTypeLoader.parse(reader, CTTextFont.type, (XmlOptions) null);
        }

        public static CTTextFont parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTextFont) POIXMLTypeLoader.parse(reader, CTTextFont.type, xmlOptions);
        }

        public static CTTextFont parse(String str) {
            return (CTTextFont) POIXMLTypeLoader.parse(str, CTTextFont.type, (XmlOptions) null);
        }

        public static CTTextFont parse(String str, XmlOptions xmlOptions) {
            return (CTTextFont) POIXMLTypeLoader.parse(str, CTTextFont.type, xmlOptions);
        }

        public static CTTextFont parse(URL url) {
            return (CTTextFont) POIXMLTypeLoader.parse(url, CTTextFont.type, (XmlOptions) null);
        }

        public static CTTextFont parse(URL url, XmlOptions xmlOptions) {
            return (CTTextFont) POIXMLTypeLoader.parse(url, CTTextFont.type, xmlOptions);
        }

        public static CTTextFont parse(XMLStreamReader xMLStreamReader) {
            return (CTTextFont) POIXMLTypeLoader.parse(xMLStreamReader, CTTextFont.type, (XmlOptions) null);
        }

        public static CTTextFont parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTextFont) POIXMLTypeLoader.parse(xMLStreamReader, CTTextFont.type, xmlOptions);
        }

        public static CTTextFont parse(XMLInputStream xMLInputStream) {
            return (CTTextFont) POIXMLTypeLoader.parse(xMLInputStream, CTTextFont.type, (XmlOptions) null);
        }

        public static CTTextFont parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTextFont) POIXMLTypeLoader.parse(xMLInputStream, CTTextFont.type, xmlOptions);
        }

        public static CTTextFont parse(Node node) {
            return (CTTextFont) POIXMLTypeLoader.parse(node, CTTextFont.type, (XmlOptions) null);
        }

        public static CTTextFont parse(Node node, XmlOptions xmlOptions) {
            return (CTTextFont) POIXMLTypeLoader.parse(node, CTTextFont.type, xmlOptions);
        }
    }

    byte getCharset();

    byte[] getPanose();

    byte getPitchFamily();

    String getTypeface();

    boolean isSetCharset();

    boolean isSetPanose();

    boolean isSetPitchFamily();

    boolean isSetTypeface();

    void setCharset(byte b);

    void setPanose(byte[] bArr);

    void setPitchFamily(byte b);

    void setTypeface(String str);

    void unsetCharset();

    void unsetPanose();

    void unsetPitchFamily();

    void unsetTypeface();

    XmlByte xgetCharset();

    STPanose xgetPanose();

    XmlByte xgetPitchFamily();

    STTextTypeface xgetTypeface();

    void xsetCharset(XmlByte xmlByte);

    void xsetPanose(STPanose sTPanose);

    void xsetPitchFamily(XmlByte xmlByte);

    void xsetTypeface(STTextTypeface sTTextTypeface);
}
