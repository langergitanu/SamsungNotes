package org.openxmlformats.schemas.officeDocument.x2006.math;

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
public interface CTOMathParaPr extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTOMathParaPr.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctomathparapr8d43type");

    public static final class Factory {
        private Factory() {
        }

        public static CTOMathParaPr newInstance() {
            return (CTOMathParaPr) POIXMLTypeLoader.newInstance(CTOMathParaPr.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTOMathParaPr.type, null);
        }

        public static CTOMathParaPr parse(File file) {
            return (CTOMathParaPr) POIXMLTypeLoader.parse(file, CTOMathParaPr.type, (XmlOptions) null);
        }

        public static CTOMathParaPr newInstance(XmlOptions xmlOptions) {
            return (CTOMathParaPr) POIXMLTypeLoader.newInstance(CTOMathParaPr.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTOMathParaPr.type, xmlOptions);
        }

        public static CTOMathParaPr parse(File file, XmlOptions xmlOptions) {
            return (CTOMathParaPr) POIXMLTypeLoader.parse(file, CTOMathParaPr.type, xmlOptions);
        }

        public static CTOMathParaPr parse(InputStream inputStream) {
            return (CTOMathParaPr) POIXMLTypeLoader.parse(inputStream, CTOMathParaPr.type, (XmlOptions) null);
        }

        public static CTOMathParaPr parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTOMathParaPr) POIXMLTypeLoader.parse(inputStream, CTOMathParaPr.type, xmlOptions);
        }

        public static CTOMathParaPr parse(Reader reader) {
            return (CTOMathParaPr) POIXMLTypeLoader.parse(reader, CTOMathParaPr.type, (XmlOptions) null);
        }

        public static CTOMathParaPr parse(Reader reader, XmlOptions xmlOptions) {
            return (CTOMathParaPr) POIXMLTypeLoader.parse(reader, CTOMathParaPr.type, xmlOptions);
        }

        public static CTOMathParaPr parse(String str) {
            return (CTOMathParaPr) POIXMLTypeLoader.parse(str, CTOMathParaPr.type, (XmlOptions) null);
        }

        public static CTOMathParaPr parse(String str, XmlOptions xmlOptions) {
            return (CTOMathParaPr) POIXMLTypeLoader.parse(str, CTOMathParaPr.type, xmlOptions);
        }

        public static CTOMathParaPr parse(URL url) {
            return (CTOMathParaPr) POIXMLTypeLoader.parse(url, CTOMathParaPr.type, (XmlOptions) null);
        }

        public static CTOMathParaPr parse(URL url, XmlOptions xmlOptions) {
            return (CTOMathParaPr) POIXMLTypeLoader.parse(url, CTOMathParaPr.type, xmlOptions);
        }

        public static CTOMathParaPr parse(XMLStreamReader xMLStreamReader) {
            return (CTOMathParaPr) POIXMLTypeLoader.parse(xMLStreamReader, CTOMathParaPr.type, (XmlOptions) null);
        }

        public static CTOMathParaPr parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTOMathParaPr) POIXMLTypeLoader.parse(xMLStreamReader, CTOMathParaPr.type, xmlOptions);
        }

        public static CTOMathParaPr parse(XMLInputStream xMLInputStream) {
            return (CTOMathParaPr) POIXMLTypeLoader.parse(xMLInputStream, CTOMathParaPr.type, (XmlOptions) null);
        }

        public static CTOMathParaPr parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTOMathParaPr) POIXMLTypeLoader.parse(xMLInputStream, CTOMathParaPr.type, xmlOptions);
        }

        public static CTOMathParaPr parse(Node node) {
            return (CTOMathParaPr) POIXMLTypeLoader.parse(node, CTOMathParaPr.type, (XmlOptions) null);
        }

        public static CTOMathParaPr parse(Node node, XmlOptions xmlOptions) {
            return (CTOMathParaPr) POIXMLTypeLoader.parse(node, CTOMathParaPr.type, xmlOptions);
        }
    }

    CTOMathJc addNewJc();

    CTOMathJc getJc();

    boolean isSetJc();

    void setJc(CTOMathJc cTOMathJc);

    void unsetJc();
}
