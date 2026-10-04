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
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTSym extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTSym.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctsym0dabtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTSym newInstance() {
            return (CTSym) POIXMLTypeLoader.newInstance(CTSym.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSym.type, null);
        }

        public static CTSym parse(File file) {
            return (CTSym) POIXMLTypeLoader.parse(file, CTSym.type, (XmlOptions) null);
        }

        public static CTSym newInstance(XmlOptions xmlOptions) {
            return (CTSym) POIXMLTypeLoader.newInstance(CTSym.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSym.type, xmlOptions);
        }

        public static CTSym parse(File file, XmlOptions xmlOptions) {
            return (CTSym) POIXMLTypeLoader.parse(file, CTSym.type, xmlOptions);
        }

        public static CTSym parse(InputStream inputStream) {
            return (CTSym) POIXMLTypeLoader.parse(inputStream, CTSym.type, (XmlOptions) null);
        }

        public static CTSym parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTSym) POIXMLTypeLoader.parse(inputStream, CTSym.type, xmlOptions);
        }

        public static CTSym parse(Reader reader) {
            return (CTSym) POIXMLTypeLoader.parse(reader, CTSym.type, (XmlOptions) null);
        }

        public static CTSym parse(Reader reader, XmlOptions xmlOptions) {
            return (CTSym) POIXMLTypeLoader.parse(reader, CTSym.type, xmlOptions);
        }

        public static CTSym parse(String str) {
            return (CTSym) POIXMLTypeLoader.parse(str, CTSym.type, (XmlOptions) null);
        }

        public static CTSym parse(String str, XmlOptions xmlOptions) {
            return (CTSym) POIXMLTypeLoader.parse(str, CTSym.type, xmlOptions);
        }

        public static CTSym parse(URL url) {
            return (CTSym) POIXMLTypeLoader.parse(url, CTSym.type, (XmlOptions) null);
        }

        public static CTSym parse(URL url, XmlOptions xmlOptions) {
            return (CTSym) POIXMLTypeLoader.parse(url, CTSym.type, xmlOptions);
        }

        public static CTSym parse(XMLStreamReader xMLStreamReader) {
            return (CTSym) POIXMLTypeLoader.parse(xMLStreamReader, CTSym.type, (XmlOptions) null);
        }

        public static CTSym parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTSym) POIXMLTypeLoader.parse(xMLStreamReader, CTSym.type, xmlOptions);
        }

        public static CTSym parse(XMLInputStream xMLInputStream) {
            return (CTSym) POIXMLTypeLoader.parse(xMLInputStream, CTSym.type, (XmlOptions) null);
        }

        public static CTSym parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTSym) POIXMLTypeLoader.parse(xMLInputStream, CTSym.type, xmlOptions);
        }

        public static CTSym parse(Node node) {
            return (CTSym) POIXMLTypeLoader.parse(node, CTSym.type, (XmlOptions) null);
        }

        public static CTSym parse(Node node, XmlOptions xmlOptions) {
            return (CTSym) POIXMLTypeLoader.parse(node, CTSym.type, xmlOptions);
        }
    }

    byte[] getChar();

    String getFont();

    boolean isSetChar();

    boolean isSetFont();

    void setChar(byte[] bArr);

    void setFont(String str);

    void unsetChar();

    void unsetFont();

    STShortHexNumber xgetChar();

    STString xgetFont();

    void xsetChar(STShortHexNumber sTShortHexNumber);

    void xsetFont(STString sTString);
}
