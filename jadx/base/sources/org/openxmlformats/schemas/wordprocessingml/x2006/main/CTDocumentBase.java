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
public interface CTDocumentBase extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTDocumentBase.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctdocumentbasedf5ctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTDocumentBase newInstance() {
            return (CTDocumentBase) POIXMLTypeLoader.newInstance(CTDocumentBase.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTDocumentBase.type, null);
        }

        public static CTDocumentBase parse(File file) {
            return (CTDocumentBase) POIXMLTypeLoader.parse(file, CTDocumentBase.type, (XmlOptions) null);
        }

        public static CTDocumentBase newInstance(XmlOptions xmlOptions) {
            return (CTDocumentBase) POIXMLTypeLoader.newInstance(CTDocumentBase.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTDocumentBase.type, xmlOptions);
        }

        public static CTDocumentBase parse(File file, XmlOptions xmlOptions) {
            return (CTDocumentBase) POIXMLTypeLoader.parse(file, CTDocumentBase.type, xmlOptions);
        }

        public static CTDocumentBase parse(InputStream inputStream) {
            return (CTDocumentBase) POIXMLTypeLoader.parse(inputStream, CTDocumentBase.type, (XmlOptions) null);
        }

        public static CTDocumentBase parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTDocumentBase) POIXMLTypeLoader.parse(inputStream, CTDocumentBase.type, xmlOptions);
        }

        public static CTDocumentBase parse(Reader reader) {
            return (CTDocumentBase) POIXMLTypeLoader.parse(reader, CTDocumentBase.type, (XmlOptions) null);
        }

        public static CTDocumentBase parse(Reader reader, XmlOptions xmlOptions) {
            return (CTDocumentBase) POIXMLTypeLoader.parse(reader, CTDocumentBase.type, xmlOptions);
        }

        public static CTDocumentBase parse(String str) {
            return (CTDocumentBase) POIXMLTypeLoader.parse(str, CTDocumentBase.type, (XmlOptions) null);
        }

        public static CTDocumentBase parse(String str, XmlOptions xmlOptions) {
            return (CTDocumentBase) POIXMLTypeLoader.parse(str, CTDocumentBase.type, xmlOptions);
        }

        public static CTDocumentBase parse(URL url) {
            return (CTDocumentBase) POIXMLTypeLoader.parse(url, CTDocumentBase.type, (XmlOptions) null);
        }

        public static CTDocumentBase parse(URL url, XmlOptions xmlOptions) {
            return (CTDocumentBase) POIXMLTypeLoader.parse(url, CTDocumentBase.type, xmlOptions);
        }

        public static CTDocumentBase parse(XMLStreamReader xMLStreamReader) {
            return (CTDocumentBase) POIXMLTypeLoader.parse(xMLStreamReader, CTDocumentBase.type, (XmlOptions) null);
        }

        public static CTDocumentBase parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTDocumentBase) POIXMLTypeLoader.parse(xMLStreamReader, CTDocumentBase.type, xmlOptions);
        }

        public static CTDocumentBase parse(XMLInputStream xMLInputStream) {
            return (CTDocumentBase) POIXMLTypeLoader.parse(xMLInputStream, CTDocumentBase.type, (XmlOptions) null);
        }

        public static CTDocumentBase parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTDocumentBase) POIXMLTypeLoader.parse(xMLInputStream, CTDocumentBase.type, xmlOptions);
        }

        public static CTDocumentBase parse(Node node) {
            return (CTDocumentBase) POIXMLTypeLoader.parse(node, CTDocumentBase.type, (XmlOptions) null);
        }

        public static CTDocumentBase parse(Node node, XmlOptions xmlOptions) {
            return (CTDocumentBase) POIXMLTypeLoader.parse(node, CTDocumentBase.type, xmlOptions);
        }
    }

    CTBackground addNewBackground();

    CTBackground getBackground();

    boolean isSetBackground();

    void setBackground(CTBackground cTBackground);

    void unsetBackground();
}
