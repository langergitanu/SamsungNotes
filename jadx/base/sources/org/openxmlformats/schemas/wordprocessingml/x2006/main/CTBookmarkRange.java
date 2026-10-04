package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigInteger;
import java.net.URL;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTBookmarkRange extends CTMarkupRange {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTBookmarkRange.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctbookmarkranged88btype");

    public static final class Factory {
        private Factory() {
        }

        public static CTBookmarkRange newInstance() {
            return (CTBookmarkRange) POIXMLTypeLoader.newInstance(CTBookmarkRange.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTBookmarkRange.type, null);
        }

        public static CTBookmarkRange parse(File file) {
            return (CTBookmarkRange) POIXMLTypeLoader.parse(file, CTBookmarkRange.type, (XmlOptions) null);
        }

        public static CTBookmarkRange newInstance(XmlOptions xmlOptions) {
            return (CTBookmarkRange) POIXMLTypeLoader.newInstance(CTBookmarkRange.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTBookmarkRange.type, xmlOptions);
        }

        public static CTBookmarkRange parse(File file, XmlOptions xmlOptions) {
            return (CTBookmarkRange) POIXMLTypeLoader.parse(file, CTBookmarkRange.type, xmlOptions);
        }

        public static CTBookmarkRange parse(InputStream inputStream) {
            return (CTBookmarkRange) POIXMLTypeLoader.parse(inputStream, CTBookmarkRange.type, (XmlOptions) null);
        }

        public static CTBookmarkRange parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTBookmarkRange) POIXMLTypeLoader.parse(inputStream, CTBookmarkRange.type, xmlOptions);
        }

        public static CTBookmarkRange parse(Reader reader) {
            return (CTBookmarkRange) POIXMLTypeLoader.parse(reader, CTBookmarkRange.type, (XmlOptions) null);
        }

        public static CTBookmarkRange parse(Reader reader, XmlOptions xmlOptions) {
            return (CTBookmarkRange) POIXMLTypeLoader.parse(reader, CTBookmarkRange.type, xmlOptions);
        }

        public static CTBookmarkRange parse(String str) {
            return (CTBookmarkRange) POIXMLTypeLoader.parse(str, CTBookmarkRange.type, (XmlOptions) null);
        }

        public static CTBookmarkRange parse(String str, XmlOptions xmlOptions) {
            return (CTBookmarkRange) POIXMLTypeLoader.parse(str, CTBookmarkRange.type, xmlOptions);
        }

        public static CTBookmarkRange parse(URL url) {
            return (CTBookmarkRange) POIXMLTypeLoader.parse(url, CTBookmarkRange.type, (XmlOptions) null);
        }

        public static CTBookmarkRange parse(URL url, XmlOptions xmlOptions) {
            return (CTBookmarkRange) POIXMLTypeLoader.parse(url, CTBookmarkRange.type, xmlOptions);
        }

        public static CTBookmarkRange parse(XMLStreamReader xMLStreamReader) {
            return (CTBookmarkRange) POIXMLTypeLoader.parse(xMLStreamReader, CTBookmarkRange.type, (XmlOptions) null);
        }

        public static CTBookmarkRange parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTBookmarkRange) POIXMLTypeLoader.parse(xMLStreamReader, CTBookmarkRange.type, xmlOptions);
        }

        public static CTBookmarkRange parse(XMLInputStream xMLInputStream) {
            return (CTBookmarkRange) POIXMLTypeLoader.parse(xMLInputStream, CTBookmarkRange.type, (XmlOptions) null);
        }

        public static CTBookmarkRange parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTBookmarkRange) POIXMLTypeLoader.parse(xMLInputStream, CTBookmarkRange.type, xmlOptions);
        }

        public static CTBookmarkRange parse(Node node) {
            return (CTBookmarkRange) POIXMLTypeLoader.parse(node, CTBookmarkRange.type, (XmlOptions) null);
        }

        public static CTBookmarkRange parse(Node node, XmlOptions xmlOptions) {
            return (CTBookmarkRange) POIXMLTypeLoader.parse(node, CTBookmarkRange.type, xmlOptions);
        }
    }

    BigInteger getColFirst();

    BigInteger getColLast();

    boolean isSetColFirst();

    boolean isSetColLast();

    void setColFirst(BigInteger bigInteger);

    void setColLast(BigInteger bigInteger);

    void unsetColFirst();

    void unsetColLast();

    STDecimalNumber xgetColFirst();

    STDecimalNumber xgetColLast();

    void xsetColFirst(STDecimalNumber sTDecimalNumber);

    void xsetColLast(STDecimalNumber sTDecimalNumber);
}
