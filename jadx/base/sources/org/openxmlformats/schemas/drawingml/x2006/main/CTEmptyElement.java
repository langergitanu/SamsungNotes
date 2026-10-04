package org.openxmlformats.schemas.drawingml.x2006.main;

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
public interface CTEmptyElement extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTEmptyElement.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctemptyelement05catype");

    public static final class Factory {
        private Factory() {
        }

        public static CTEmptyElement newInstance() {
            return (CTEmptyElement) POIXMLTypeLoader.newInstance(CTEmptyElement.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTEmptyElement.type, null);
        }

        public static CTEmptyElement parse(File file) {
            return (CTEmptyElement) POIXMLTypeLoader.parse(file, CTEmptyElement.type, (XmlOptions) null);
        }

        public static CTEmptyElement newInstance(XmlOptions xmlOptions) {
            return (CTEmptyElement) POIXMLTypeLoader.newInstance(CTEmptyElement.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTEmptyElement.type, xmlOptions);
        }

        public static CTEmptyElement parse(File file, XmlOptions xmlOptions) {
            return (CTEmptyElement) POIXMLTypeLoader.parse(file, CTEmptyElement.type, xmlOptions);
        }

        public static CTEmptyElement parse(InputStream inputStream) {
            return (CTEmptyElement) POIXMLTypeLoader.parse(inputStream, CTEmptyElement.type, (XmlOptions) null);
        }

        public static CTEmptyElement parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTEmptyElement) POIXMLTypeLoader.parse(inputStream, CTEmptyElement.type, xmlOptions);
        }

        public static CTEmptyElement parse(Reader reader) {
            return (CTEmptyElement) POIXMLTypeLoader.parse(reader, CTEmptyElement.type, (XmlOptions) null);
        }

        public static CTEmptyElement parse(Reader reader, XmlOptions xmlOptions) {
            return (CTEmptyElement) POIXMLTypeLoader.parse(reader, CTEmptyElement.type, xmlOptions);
        }

        public static CTEmptyElement parse(String str) {
            return (CTEmptyElement) POIXMLTypeLoader.parse(str, CTEmptyElement.type, (XmlOptions) null);
        }

        public static CTEmptyElement parse(String str, XmlOptions xmlOptions) {
            return (CTEmptyElement) POIXMLTypeLoader.parse(str, CTEmptyElement.type, xmlOptions);
        }

        public static CTEmptyElement parse(URL url) {
            return (CTEmptyElement) POIXMLTypeLoader.parse(url, CTEmptyElement.type, (XmlOptions) null);
        }

        public static CTEmptyElement parse(URL url, XmlOptions xmlOptions) {
            return (CTEmptyElement) POIXMLTypeLoader.parse(url, CTEmptyElement.type, xmlOptions);
        }

        public static CTEmptyElement parse(XMLStreamReader xMLStreamReader) {
            return (CTEmptyElement) POIXMLTypeLoader.parse(xMLStreamReader, CTEmptyElement.type, (XmlOptions) null);
        }

        public static CTEmptyElement parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTEmptyElement) POIXMLTypeLoader.parse(xMLStreamReader, CTEmptyElement.type, xmlOptions);
        }

        public static CTEmptyElement parse(XMLInputStream xMLInputStream) {
            return (CTEmptyElement) POIXMLTypeLoader.parse(xMLInputStream, CTEmptyElement.type, (XmlOptions) null);
        }

        public static CTEmptyElement parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTEmptyElement) POIXMLTypeLoader.parse(xMLInputStream, CTEmptyElement.type, xmlOptions);
        }

        public static CTEmptyElement parse(Node node) {
            return (CTEmptyElement) POIXMLTypeLoader.parse(node, CTEmptyElement.type, (XmlOptions) null);
        }

        public static CTEmptyElement parse(Node node, XmlOptions xmlOptions) {
            return (CTEmptyElement) POIXMLTypeLoader.parse(node, CTEmptyElement.type, xmlOptions);
        }
    }
}
