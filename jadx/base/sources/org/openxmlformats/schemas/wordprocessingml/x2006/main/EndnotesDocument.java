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
public interface EndnotesDocument extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(EndnotesDocument.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "endnotes960edoctype");

    public static final class Factory {
        private Factory() {
        }

        public static EndnotesDocument newInstance() {
            return (EndnotesDocument) POIXMLTypeLoader.newInstance(EndnotesDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, EndnotesDocument.type, null);
        }

        public static EndnotesDocument parse(File file) {
            return (EndnotesDocument) POIXMLTypeLoader.parse(file, EndnotesDocument.type, (XmlOptions) null);
        }

        public static EndnotesDocument newInstance(XmlOptions xmlOptions) {
            return (EndnotesDocument) POIXMLTypeLoader.newInstance(EndnotesDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, EndnotesDocument.type, xmlOptions);
        }

        public static EndnotesDocument parse(File file, XmlOptions xmlOptions) {
            return (EndnotesDocument) POIXMLTypeLoader.parse(file, EndnotesDocument.type, xmlOptions);
        }

        public static EndnotesDocument parse(InputStream inputStream) {
            return (EndnotesDocument) POIXMLTypeLoader.parse(inputStream, EndnotesDocument.type, (XmlOptions) null);
        }

        public static EndnotesDocument parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (EndnotesDocument) POIXMLTypeLoader.parse(inputStream, EndnotesDocument.type, xmlOptions);
        }

        public static EndnotesDocument parse(Reader reader) {
            return (EndnotesDocument) POIXMLTypeLoader.parse(reader, EndnotesDocument.type, (XmlOptions) null);
        }

        public static EndnotesDocument parse(Reader reader, XmlOptions xmlOptions) {
            return (EndnotesDocument) POIXMLTypeLoader.parse(reader, EndnotesDocument.type, xmlOptions);
        }

        public static EndnotesDocument parse(String str) {
            return (EndnotesDocument) POIXMLTypeLoader.parse(str, EndnotesDocument.type, (XmlOptions) null);
        }

        public static EndnotesDocument parse(String str, XmlOptions xmlOptions) {
            return (EndnotesDocument) POIXMLTypeLoader.parse(str, EndnotesDocument.type, xmlOptions);
        }

        public static EndnotesDocument parse(URL url) {
            return (EndnotesDocument) POIXMLTypeLoader.parse(url, EndnotesDocument.type, (XmlOptions) null);
        }

        public static EndnotesDocument parse(URL url, XmlOptions xmlOptions) {
            return (EndnotesDocument) POIXMLTypeLoader.parse(url, EndnotesDocument.type, xmlOptions);
        }

        public static EndnotesDocument parse(XMLStreamReader xMLStreamReader) {
            return (EndnotesDocument) POIXMLTypeLoader.parse(xMLStreamReader, EndnotesDocument.type, (XmlOptions) null);
        }

        public static EndnotesDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (EndnotesDocument) POIXMLTypeLoader.parse(xMLStreamReader, EndnotesDocument.type, xmlOptions);
        }

        public static EndnotesDocument parse(XMLInputStream xMLInputStream) {
            return (EndnotesDocument) POIXMLTypeLoader.parse(xMLInputStream, EndnotesDocument.type, (XmlOptions) null);
        }

        public static EndnotesDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (EndnotesDocument) POIXMLTypeLoader.parse(xMLInputStream, EndnotesDocument.type, xmlOptions);
        }

        public static EndnotesDocument parse(Node node) {
            return (EndnotesDocument) POIXMLTypeLoader.parse(node, EndnotesDocument.type, (XmlOptions) null);
        }

        public static EndnotesDocument parse(Node node, XmlOptions xmlOptions) {
            return (EndnotesDocument) POIXMLTypeLoader.parse(node, EndnotesDocument.type, xmlOptions);
        }
    }

    CTEndnotes addNewEndnotes();

    CTEndnotes getEndnotes();

    void setEndnotes(CTEndnotes cTEndnotes);
}
