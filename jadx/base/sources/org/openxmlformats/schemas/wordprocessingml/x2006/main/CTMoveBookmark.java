package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.Calendar;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTMoveBookmark extends CTBookmark {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTMoveBookmark.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctmovebookmarkf7a1type");

    public static final class Factory {
        private Factory() {
        }

        public static CTMoveBookmark newInstance() {
            return (CTMoveBookmark) POIXMLTypeLoader.newInstance(CTMoveBookmark.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTMoveBookmark.type, null);
        }

        public static CTMoveBookmark parse(File file) {
            return (CTMoveBookmark) POIXMLTypeLoader.parse(file, CTMoveBookmark.type, (XmlOptions) null);
        }

        public static CTMoveBookmark newInstance(XmlOptions xmlOptions) {
            return (CTMoveBookmark) POIXMLTypeLoader.newInstance(CTMoveBookmark.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTMoveBookmark.type, xmlOptions);
        }

        public static CTMoveBookmark parse(File file, XmlOptions xmlOptions) {
            return (CTMoveBookmark) POIXMLTypeLoader.parse(file, CTMoveBookmark.type, xmlOptions);
        }

        public static CTMoveBookmark parse(InputStream inputStream) {
            return (CTMoveBookmark) POIXMLTypeLoader.parse(inputStream, CTMoveBookmark.type, (XmlOptions) null);
        }

        public static CTMoveBookmark parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTMoveBookmark) POIXMLTypeLoader.parse(inputStream, CTMoveBookmark.type, xmlOptions);
        }

        public static CTMoveBookmark parse(Reader reader) {
            return (CTMoveBookmark) POIXMLTypeLoader.parse(reader, CTMoveBookmark.type, (XmlOptions) null);
        }

        public static CTMoveBookmark parse(Reader reader, XmlOptions xmlOptions) {
            return (CTMoveBookmark) POIXMLTypeLoader.parse(reader, CTMoveBookmark.type, xmlOptions);
        }

        public static CTMoveBookmark parse(String str) {
            return (CTMoveBookmark) POIXMLTypeLoader.parse(str, CTMoveBookmark.type, (XmlOptions) null);
        }

        public static CTMoveBookmark parse(String str, XmlOptions xmlOptions) {
            return (CTMoveBookmark) POIXMLTypeLoader.parse(str, CTMoveBookmark.type, xmlOptions);
        }

        public static CTMoveBookmark parse(URL url) {
            return (CTMoveBookmark) POIXMLTypeLoader.parse(url, CTMoveBookmark.type, (XmlOptions) null);
        }

        public static CTMoveBookmark parse(URL url, XmlOptions xmlOptions) {
            return (CTMoveBookmark) POIXMLTypeLoader.parse(url, CTMoveBookmark.type, xmlOptions);
        }

        public static CTMoveBookmark parse(XMLStreamReader xMLStreamReader) {
            return (CTMoveBookmark) POIXMLTypeLoader.parse(xMLStreamReader, CTMoveBookmark.type, (XmlOptions) null);
        }

        public static CTMoveBookmark parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTMoveBookmark) POIXMLTypeLoader.parse(xMLStreamReader, CTMoveBookmark.type, xmlOptions);
        }

        public static CTMoveBookmark parse(XMLInputStream xMLInputStream) {
            return (CTMoveBookmark) POIXMLTypeLoader.parse(xMLInputStream, CTMoveBookmark.type, (XmlOptions) null);
        }

        public static CTMoveBookmark parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTMoveBookmark) POIXMLTypeLoader.parse(xMLInputStream, CTMoveBookmark.type, xmlOptions);
        }

        public static CTMoveBookmark parse(Node node) {
            return (CTMoveBookmark) POIXMLTypeLoader.parse(node, CTMoveBookmark.type, (XmlOptions) null);
        }

        public static CTMoveBookmark parse(Node node, XmlOptions xmlOptions) {
            return (CTMoveBookmark) POIXMLTypeLoader.parse(node, CTMoveBookmark.type, xmlOptions);
        }
    }

    String getAuthor();

    Calendar getDate();

    void setAuthor(String str);

    void setDate(Calendar calendar);

    STString xgetAuthor();

    STDateTime xgetDate();

    void xsetAuthor(STString sTString);

    void xsetDate(STDateTime sTDateTime);
}
