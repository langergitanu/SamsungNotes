package org.openxmlformats.schemas.presentationml.x2006.main;

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
public interface PresentationDocument extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(PresentationDocument.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "presentation02f7doctype");

    public static final class Factory {
        private Factory() {
        }

        public static PresentationDocument newInstance() {
            return (PresentationDocument) POIXMLTypeLoader.newInstance(PresentationDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, PresentationDocument.type, null);
        }

        public static PresentationDocument parse(File file) {
            return (PresentationDocument) POIXMLTypeLoader.parse(file, PresentationDocument.type, (XmlOptions) null);
        }

        public static PresentationDocument newInstance(XmlOptions xmlOptions) {
            return (PresentationDocument) POIXMLTypeLoader.newInstance(PresentationDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, PresentationDocument.type, xmlOptions);
        }

        public static PresentationDocument parse(File file, XmlOptions xmlOptions) {
            return (PresentationDocument) POIXMLTypeLoader.parse(file, PresentationDocument.type, xmlOptions);
        }

        public static PresentationDocument parse(InputStream inputStream) {
            return (PresentationDocument) POIXMLTypeLoader.parse(inputStream, PresentationDocument.type, (XmlOptions) null);
        }

        public static PresentationDocument parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (PresentationDocument) POIXMLTypeLoader.parse(inputStream, PresentationDocument.type, xmlOptions);
        }

        public static PresentationDocument parse(Reader reader) {
            return (PresentationDocument) POIXMLTypeLoader.parse(reader, PresentationDocument.type, (XmlOptions) null);
        }

        public static PresentationDocument parse(Reader reader, XmlOptions xmlOptions) {
            return (PresentationDocument) POIXMLTypeLoader.parse(reader, PresentationDocument.type, xmlOptions);
        }

        public static PresentationDocument parse(String str) {
            return (PresentationDocument) POIXMLTypeLoader.parse(str, PresentationDocument.type, (XmlOptions) null);
        }

        public static PresentationDocument parse(String str, XmlOptions xmlOptions) {
            return (PresentationDocument) POIXMLTypeLoader.parse(str, PresentationDocument.type, xmlOptions);
        }

        public static PresentationDocument parse(URL url) {
            return (PresentationDocument) POIXMLTypeLoader.parse(url, PresentationDocument.type, (XmlOptions) null);
        }

        public static PresentationDocument parse(URL url, XmlOptions xmlOptions) {
            return (PresentationDocument) POIXMLTypeLoader.parse(url, PresentationDocument.type, xmlOptions);
        }

        public static PresentationDocument parse(XMLStreamReader xMLStreamReader) {
            return (PresentationDocument) POIXMLTypeLoader.parse(xMLStreamReader, PresentationDocument.type, (XmlOptions) null);
        }

        public static PresentationDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (PresentationDocument) POIXMLTypeLoader.parse(xMLStreamReader, PresentationDocument.type, xmlOptions);
        }

        public static PresentationDocument parse(XMLInputStream xMLInputStream) {
            return (PresentationDocument) POIXMLTypeLoader.parse(xMLInputStream, PresentationDocument.type, (XmlOptions) null);
        }

        public static PresentationDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (PresentationDocument) POIXMLTypeLoader.parse(xMLInputStream, PresentationDocument.type, xmlOptions);
        }

        public static PresentationDocument parse(Node node) {
            return (PresentationDocument) POIXMLTypeLoader.parse(node, PresentationDocument.type, (XmlOptions) null);
        }

        public static PresentationDocument parse(Node node, XmlOptions xmlOptions) {
            return (PresentationDocument) POIXMLTypeLoader.parse(node, PresentationDocument.type, xmlOptions);
        }
    }

    CTPresentation addNewPresentation();

    CTPresentation getPresentation();

    void setPresentation(CTPresentation cTPresentation);
}
