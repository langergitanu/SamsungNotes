package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTBookmark extends CTBookmarkRange {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTBookmark.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctbookmarkd672type");

    public static final class Factory {
        private Factory() {
        }

        public static CTBookmark newInstance() {
            return (CTBookmark) POIXMLTypeLoader.newInstance(CTBookmark.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTBookmark.type, null);
        }

        public static CTBookmark parse(File file) {
            return (CTBookmark) POIXMLTypeLoader.parse(file, CTBookmark.type, (XmlOptions) null);
        }

        public static CTBookmark newInstance(XmlOptions xmlOptions) {
            return (CTBookmark) POIXMLTypeLoader.newInstance(CTBookmark.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTBookmark.type, xmlOptions);
        }

        public static CTBookmark parse(File file, XmlOptions xmlOptions) {
            return (CTBookmark) POIXMLTypeLoader.parse(file, CTBookmark.type, xmlOptions);
        }

        public static CTBookmark parse(InputStream inputStream) {
            return (CTBookmark) POIXMLTypeLoader.parse(inputStream, CTBookmark.type, (XmlOptions) null);
        }

        public static CTBookmark parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTBookmark) POIXMLTypeLoader.parse(inputStream, CTBookmark.type, xmlOptions);
        }

        public static CTBookmark parse(Reader reader) {
            return (CTBookmark) POIXMLTypeLoader.parse(reader, CTBookmark.type, (XmlOptions) null);
        }

        public static CTBookmark parse(Reader reader, XmlOptions xmlOptions) {
            return (CTBookmark) POIXMLTypeLoader.parse(reader, CTBookmark.type, xmlOptions);
        }

        public static CTBookmark parse(String str) {
            return (CTBookmark) POIXMLTypeLoader.parse(str, CTBookmark.type, (XmlOptions) null);
        }

        public static CTBookmark parse(String str, XmlOptions xmlOptions) {
            return (CTBookmark) POIXMLTypeLoader.parse(str, CTBookmark.type, xmlOptions);
        }

        public static CTBookmark parse(URL url) {
            return (CTBookmark) POIXMLTypeLoader.parse(url, CTBookmark.type, (XmlOptions) null);
        }

        public static CTBookmark parse(URL url, XmlOptions xmlOptions) {
            return (CTBookmark) POIXMLTypeLoader.parse(url, CTBookmark.type, xmlOptions);
        }

        public static CTBookmark parse(XMLStreamReader xMLStreamReader) {
            return (CTBookmark) POIXMLTypeLoader.parse(xMLStreamReader, CTBookmark.type, (XmlOptions) null);
        }

        public static CTBookmark parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTBookmark) POIXMLTypeLoader.parse(xMLStreamReader, CTBookmark.type, xmlOptions);
        }

        public static CTBookmark parse(XMLInputStream xMLInputStream) {
            return (CTBookmark) POIXMLTypeLoader.parse(xMLInputStream, CTBookmark.type, (XmlOptions) null);
        }

        public static CTBookmark parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTBookmark) POIXMLTypeLoader.parse(xMLInputStream, CTBookmark.type, xmlOptions);
        }

        public static CTBookmark parse(Node node) {
            return (CTBookmark) POIXMLTypeLoader.parse(node, CTBookmark.type, (XmlOptions) null);
        }

        public static CTBookmark parse(Node node, XmlOptions xmlOptions) {
            return (CTBookmark) POIXMLTypeLoader.parse(node, CTBookmark.type, xmlOptions);
        }
    }

    String getName();

    void setName(String str);

    STString xgetName();

    void xsetName(STString sTString);
}
