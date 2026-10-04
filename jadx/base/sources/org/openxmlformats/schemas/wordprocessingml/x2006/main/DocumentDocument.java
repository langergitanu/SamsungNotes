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
public interface DocumentDocument extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(DocumentDocument.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "document2bd9doctype");

    public static final class Factory {
        private Factory() {
        }

        public static DocumentDocument newInstance() {
            return (DocumentDocument) POIXMLTypeLoader.newInstance(DocumentDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, DocumentDocument.type, null);
        }

        public static DocumentDocument parse(File file) {
            return (DocumentDocument) POIXMLTypeLoader.parse(file, DocumentDocument.type, (XmlOptions) null);
        }

        public static DocumentDocument newInstance(XmlOptions xmlOptions) {
            return (DocumentDocument) POIXMLTypeLoader.newInstance(DocumentDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, DocumentDocument.type, xmlOptions);
        }

        public static DocumentDocument parse(File file, XmlOptions xmlOptions) {
            return (DocumentDocument) POIXMLTypeLoader.parse(file, DocumentDocument.type, xmlOptions);
        }

        public static DocumentDocument parse(InputStream inputStream) {
            return (DocumentDocument) POIXMLTypeLoader.parse(inputStream, DocumentDocument.type, (XmlOptions) null);
        }

        public static DocumentDocument parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (DocumentDocument) POIXMLTypeLoader.parse(inputStream, DocumentDocument.type, xmlOptions);
        }

        public static DocumentDocument parse(Reader reader) {
            return (DocumentDocument) POIXMLTypeLoader.parse(reader, DocumentDocument.type, (XmlOptions) null);
        }

        public static DocumentDocument parse(Reader reader, XmlOptions xmlOptions) {
            return (DocumentDocument) POIXMLTypeLoader.parse(reader, DocumentDocument.type, xmlOptions);
        }

        public static DocumentDocument parse(String str) {
            return (DocumentDocument) POIXMLTypeLoader.parse(str, DocumentDocument.type, (XmlOptions) null);
        }

        public static DocumentDocument parse(String str, XmlOptions xmlOptions) {
            return (DocumentDocument) POIXMLTypeLoader.parse(str, DocumentDocument.type, xmlOptions);
        }

        public static DocumentDocument parse(URL url) {
            return (DocumentDocument) POIXMLTypeLoader.parse(url, DocumentDocument.type, (XmlOptions) null);
        }

        public static DocumentDocument parse(URL url, XmlOptions xmlOptions) {
            return (DocumentDocument) POIXMLTypeLoader.parse(url, DocumentDocument.type, xmlOptions);
        }

        public static DocumentDocument parse(XMLStreamReader xMLStreamReader) {
            return (DocumentDocument) POIXMLTypeLoader.parse(xMLStreamReader, DocumentDocument.type, (XmlOptions) null);
        }

        public static DocumentDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (DocumentDocument) POIXMLTypeLoader.parse(xMLStreamReader, DocumentDocument.type, xmlOptions);
        }

        public static DocumentDocument parse(XMLInputStream xMLInputStream) {
            return (DocumentDocument) POIXMLTypeLoader.parse(xMLInputStream, DocumentDocument.type, (XmlOptions) null);
        }

        public static DocumentDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (DocumentDocument) POIXMLTypeLoader.parse(xMLInputStream, DocumentDocument.type, xmlOptions);
        }

        public static DocumentDocument parse(Node node) {
            return (DocumentDocument) POIXMLTypeLoader.parse(node, DocumentDocument.type, (XmlOptions) null);
        }

        public static DocumentDocument parse(Node node, XmlOptions xmlOptions) {
            return (DocumentDocument) POIXMLTypeLoader.parse(node, DocumentDocument.type, xmlOptions);
        }
    }

    CTDocument1 addNewDocument();

    CTDocument1 getDocument();

    void setDocument(CTDocument1 cTDocument1);
}
