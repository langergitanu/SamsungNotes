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
public interface CTDocument1 extends CTDocumentBase {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTDocument1.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctdocument64adtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTDocument1 newInstance() {
            return (CTDocument1) POIXMLTypeLoader.newInstance(CTDocument1.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTDocument1.type, null);
        }

        public static CTDocument1 parse(File file) {
            return (CTDocument1) POIXMLTypeLoader.parse(file, CTDocument1.type, (XmlOptions) null);
        }

        public static CTDocument1 newInstance(XmlOptions xmlOptions) {
            return (CTDocument1) POIXMLTypeLoader.newInstance(CTDocument1.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTDocument1.type, xmlOptions);
        }

        public static CTDocument1 parse(File file, XmlOptions xmlOptions) {
            return (CTDocument1) POIXMLTypeLoader.parse(file, CTDocument1.type, xmlOptions);
        }

        public static CTDocument1 parse(InputStream inputStream) {
            return (CTDocument1) POIXMLTypeLoader.parse(inputStream, CTDocument1.type, (XmlOptions) null);
        }

        public static CTDocument1 parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTDocument1) POIXMLTypeLoader.parse(inputStream, CTDocument1.type, xmlOptions);
        }

        public static CTDocument1 parse(Reader reader) {
            return (CTDocument1) POIXMLTypeLoader.parse(reader, CTDocument1.type, (XmlOptions) null);
        }

        public static CTDocument1 parse(Reader reader, XmlOptions xmlOptions) {
            return (CTDocument1) POIXMLTypeLoader.parse(reader, CTDocument1.type, xmlOptions);
        }

        public static CTDocument1 parse(String str) {
            return (CTDocument1) POIXMLTypeLoader.parse(str, CTDocument1.type, (XmlOptions) null);
        }

        public static CTDocument1 parse(String str, XmlOptions xmlOptions) {
            return (CTDocument1) POIXMLTypeLoader.parse(str, CTDocument1.type, xmlOptions);
        }

        public static CTDocument1 parse(URL url) {
            return (CTDocument1) POIXMLTypeLoader.parse(url, CTDocument1.type, (XmlOptions) null);
        }

        public static CTDocument1 parse(URL url, XmlOptions xmlOptions) {
            return (CTDocument1) POIXMLTypeLoader.parse(url, CTDocument1.type, xmlOptions);
        }

        public static CTDocument1 parse(XMLStreamReader xMLStreamReader) {
            return (CTDocument1) POIXMLTypeLoader.parse(xMLStreamReader, CTDocument1.type, (XmlOptions) null);
        }

        public static CTDocument1 parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTDocument1) POIXMLTypeLoader.parse(xMLStreamReader, CTDocument1.type, xmlOptions);
        }

        public static CTDocument1 parse(XMLInputStream xMLInputStream) {
            return (CTDocument1) POIXMLTypeLoader.parse(xMLInputStream, CTDocument1.type, (XmlOptions) null);
        }

        public static CTDocument1 parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTDocument1) POIXMLTypeLoader.parse(xMLInputStream, CTDocument1.type, xmlOptions);
        }

        public static CTDocument1 parse(Node node) {
            return (CTDocument1) POIXMLTypeLoader.parse(node, CTDocument1.type, (XmlOptions) null);
        }

        public static CTDocument1 parse(Node node, XmlOptions xmlOptions) {
            return (CTDocument1) POIXMLTypeLoader.parse(node, CTDocument1.type, xmlOptions);
        }
    }

    CTBody addNewBody();

    CTBody getBody();

    boolean isSetBody();

    void setBody(CTBody cTBody);

    void unsetBody();
}
