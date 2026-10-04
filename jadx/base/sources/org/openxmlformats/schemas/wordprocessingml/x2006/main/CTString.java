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
public interface CTString extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTString.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctstring9c37type");

    public static final class Factory {
        private Factory() {
        }

        public static CTString newInstance() {
            return (CTString) POIXMLTypeLoader.newInstance(CTString.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTString.type, null);
        }

        public static CTString parse(File file) {
            return (CTString) POIXMLTypeLoader.parse(file, CTString.type, (XmlOptions) null);
        }

        public static CTString newInstance(XmlOptions xmlOptions) {
            return (CTString) POIXMLTypeLoader.newInstance(CTString.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTString.type, xmlOptions);
        }

        public static CTString parse(File file, XmlOptions xmlOptions) {
            return (CTString) POIXMLTypeLoader.parse(file, CTString.type, xmlOptions);
        }

        public static CTString parse(InputStream inputStream) {
            return (CTString) POIXMLTypeLoader.parse(inputStream, CTString.type, (XmlOptions) null);
        }

        public static CTString parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTString) POIXMLTypeLoader.parse(inputStream, CTString.type, xmlOptions);
        }

        public static CTString parse(Reader reader) {
            return (CTString) POIXMLTypeLoader.parse(reader, CTString.type, (XmlOptions) null);
        }

        public static CTString parse(Reader reader, XmlOptions xmlOptions) {
            return (CTString) POIXMLTypeLoader.parse(reader, CTString.type, xmlOptions);
        }

        public static CTString parse(String str) {
            return (CTString) POIXMLTypeLoader.parse(str, CTString.type, (XmlOptions) null);
        }

        public static CTString parse(String str, XmlOptions xmlOptions) {
            return (CTString) POIXMLTypeLoader.parse(str, CTString.type, xmlOptions);
        }

        public static CTString parse(URL url) {
            return (CTString) POIXMLTypeLoader.parse(url, CTString.type, (XmlOptions) null);
        }

        public static CTString parse(URL url, XmlOptions xmlOptions) {
            return (CTString) POIXMLTypeLoader.parse(url, CTString.type, xmlOptions);
        }

        public static CTString parse(XMLStreamReader xMLStreamReader) {
            return (CTString) POIXMLTypeLoader.parse(xMLStreamReader, CTString.type, (XmlOptions) null);
        }

        public static CTString parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTString) POIXMLTypeLoader.parse(xMLStreamReader, CTString.type, xmlOptions);
        }

        public static CTString parse(XMLInputStream xMLInputStream) {
            return (CTString) POIXMLTypeLoader.parse(xMLInputStream, CTString.type, (XmlOptions) null);
        }

        public static CTString parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTString) POIXMLTypeLoader.parse(xMLInputStream, CTString.type, xmlOptions);
        }

        public static CTString parse(Node node) {
            return (CTString) POIXMLTypeLoader.parse(node, CTString.type, (XmlOptions) null);
        }

        public static CTString parse(Node node, XmlOptions xmlOptions) {
            return (CTString) POIXMLTypeLoader.parse(node, CTString.type, xmlOptions);
        }
    }

    String getVal();

    void setVal(String str);

    STString xgetVal();

    void xsetVal(STString sTString);
}
