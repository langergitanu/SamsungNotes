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
public interface CTEmpty extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTEmpty.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctempty3fa5type");

    public static final class Factory {
        private Factory() {
        }

        public static CTEmpty newInstance() {
            return (CTEmpty) POIXMLTypeLoader.newInstance(CTEmpty.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTEmpty.type, null);
        }

        public static CTEmpty parse(File file) {
            return (CTEmpty) POIXMLTypeLoader.parse(file, CTEmpty.type, (XmlOptions) null);
        }

        public static CTEmpty newInstance(XmlOptions xmlOptions) {
            return (CTEmpty) POIXMLTypeLoader.newInstance(CTEmpty.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTEmpty.type, xmlOptions);
        }

        public static CTEmpty parse(File file, XmlOptions xmlOptions) {
            return (CTEmpty) POIXMLTypeLoader.parse(file, CTEmpty.type, xmlOptions);
        }

        public static CTEmpty parse(InputStream inputStream) {
            return (CTEmpty) POIXMLTypeLoader.parse(inputStream, CTEmpty.type, (XmlOptions) null);
        }

        public static CTEmpty parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTEmpty) POIXMLTypeLoader.parse(inputStream, CTEmpty.type, xmlOptions);
        }

        public static CTEmpty parse(Reader reader) {
            return (CTEmpty) POIXMLTypeLoader.parse(reader, CTEmpty.type, (XmlOptions) null);
        }

        public static CTEmpty parse(Reader reader, XmlOptions xmlOptions) {
            return (CTEmpty) POIXMLTypeLoader.parse(reader, CTEmpty.type, xmlOptions);
        }

        public static CTEmpty parse(String str) {
            return (CTEmpty) POIXMLTypeLoader.parse(str, CTEmpty.type, (XmlOptions) null);
        }

        public static CTEmpty parse(String str, XmlOptions xmlOptions) {
            return (CTEmpty) POIXMLTypeLoader.parse(str, CTEmpty.type, xmlOptions);
        }

        public static CTEmpty parse(URL url) {
            return (CTEmpty) POIXMLTypeLoader.parse(url, CTEmpty.type, (XmlOptions) null);
        }

        public static CTEmpty parse(URL url, XmlOptions xmlOptions) {
            return (CTEmpty) POIXMLTypeLoader.parse(url, CTEmpty.type, xmlOptions);
        }

        public static CTEmpty parse(XMLStreamReader xMLStreamReader) {
            return (CTEmpty) POIXMLTypeLoader.parse(xMLStreamReader, CTEmpty.type, (XmlOptions) null);
        }

        public static CTEmpty parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTEmpty) POIXMLTypeLoader.parse(xMLStreamReader, CTEmpty.type, xmlOptions);
        }

        public static CTEmpty parse(XMLInputStream xMLInputStream) {
            return (CTEmpty) POIXMLTypeLoader.parse(xMLInputStream, CTEmpty.type, (XmlOptions) null);
        }

        public static CTEmpty parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTEmpty) POIXMLTypeLoader.parse(xMLInputStream, CTEmpty.type, xmlOptions);
        }

        public static CTEmpty parse(Node node) {
            return (CTEmpty) POIXMLTypeLoader.parse(node, CTEmpty.type, (XmlOptions) null);
        }

        public static CTEmpty parse(Node node, XmlOptions xmlOptions) {
            return (CTEmpty) POIXMLTypeLoader.parse(node, CTEmpty.type, xmlOptions);
        }
    }
}
