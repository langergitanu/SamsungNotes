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
public interface FootnotesDocument extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(FootnotesDocument.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "footnotes8773doctype");

    public static final class Factory {
        private Factory() {
        }

        public static FootnotesDocument newInstance() {
            return (FootnotesDocument) POIXMLTypeLoader.newInstance(FootnotesDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, FootnotesDocument.type, null);
        }

        public static FootnotesDocument parse(File file) {
            return (FootnotesDocument) POIXMLTypeLoader.parse(file, FootnotesDocument.type, (XmlOptions) null);
        }

        public static FootnotesDocument newInstance(XmlOptions xmlOptions) {
            return (FootnotesDocument) POIXMLTypeLoader.newInstance(FootnotesDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, FootnotesDocument.type, xmlOptions);
        }

        public static FootnotesDocument parse(File file, XmlOptions xmlOptions) {
            return (FootnotesDocument) POIXMLTypeLoader.parse(file, FootnotesDocument.type, xmlOptions);
        }

        public static FootnotesDocument parse(InputStream inputStream) {
            return (FootnotesDocument) POIXMLTypeLoader.parse(inputStream, FootnotesDocument.type, (XmlOptions) null);
        }

        public static FootnotesDocument parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (FootnotesDocument) POIXMLTypeLoader.parse(inputStream, FootnotesDocument.type, xmlOptions);
        }

        public static FootnotesDocument parse(Reader reader) {
            return (FootnotesDocument) POIXMLTypeLoader.parse(reader, FootnotesDocument.type, (XmlOptions) null);
        }

        public static FootnotesDocument parse(Reader reader, XmlOptions xmlOptions) {
            return (FootnotesDocument) POIXMLTypeLoader.parse(reader, FootnotesDocument.type, xmlOptions);
        }

        public static FootnotesDocument parse(String str) {
            return (FootnotesDocument) POIXMLTypeLoader.parse(str, FootnotesDocument.type, (XmlOptions) null);
        }

        public static FootnotesDocument parse(String str, XmlOptions xmlOptions) {
            return (FootnotesDocument) POIXMLTypeLoader.parse(str, FootnotesDocument.type, xmlOptions);
        }

        public static FootnotesDocument parse(URL url) {
            return (FootnotesDocument) POIXMLTypeLoader.parse(url, FootnotesDocument.type, (XmlOptions) null);
        }

        public static FootnotesDocument parse(URL url, XmlOptions xmlOptions) {
            return (FootnotesDocument) POIXMLTypeLoader.parse(url, FootnotesDocument.type, xmlOptions);
        }

        public static FootnotesDocument parse(XMLStreamReader xMLStreamReader) {
            return (FootnotesDocument) POIXMLTypeLoader.parse(xMLStreamReader, FootnotesDocument.type, (XmlOptions) null);
        }

        public static FootnotesDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (FootnotesDocument) POIXMLTypeLoader.parse(xMLStreamReader, FootnotesDocument.type, xmlOptions);
        }

        public static FootnotesDocument parse(XMLInputStream xMLInputStream) {
            return (FootnotesDocument) POIXMLTypeLoader.parse(xMLInputStream, FootnotesDocument.type, (XmlOptions) null);
        }

        public static FootnotesDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (FootnotesDocument) POIXMLTypeLoader.parse(xMLInputStream, FootnotesDocument.type, xmlOptions);
        }

        public static FootnotesDocument parse(Node node) {
            return (FootnotesDocument) POIXMLTypeLoader.parse(node, FootnotesDocument.type, (XmlOptions) null);
        }

        public static FootnotesDocument parse(Node node, XmlOptions xmlOptions) {
            return (FootnotesDocument) POIXMLTypeLoader.parse(node, FootnotesDocument.type, xmlOptions);
        }
    }

    CTFootnotes addNewFootnotes();

    CTFootnotes getFootnotes();

    void setFootnotes(CTFootnotes cTFootnotes);
}
