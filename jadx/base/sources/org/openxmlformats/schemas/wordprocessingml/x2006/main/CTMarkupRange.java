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
public interface CTMarkupRange extends CTMarkup {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTMarkupRange.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctmarkuprangeba3dtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTMarkupRange newInstance() {
            return (CTMarkupRange) POIXMLTypeLoader.newInstance(CTMarkupRange.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTMarkupRange.type, null);
        }

        public static CTMarkupRange parse(File file) {
            return (CTMarkupRange) POIXMLTypeLoader.parse(file, CTMarkupRange.type, (XmlOptions) null);
        }

        public static CTMarkupRange newInstance(XmlOptions xmlOptions) {
            return (CTMarkupRange) POIXMLTypeLoader.newInstance(CTMarkupRange.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTMarkupRange.type, xmlOptions);
        }

        public static CTMarkupRange parse(File file, XmlOptions xmlOptions) {
            return (CTMarkupRange) POIXMLTypeLoader.parse(file, CTMarkupRange.type, xmlOptions);
        }

        public static CTMarkupRange parse(InputStream inputStream) {
            return (CTMarkupRange) POIXMLTypeLoader.parse(inputStream, CTMarkupRange.type, (XmlOptions) null);
        }

        public static CTMarkupRange parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTMarkupRange) POIXMLTypeLoader.parse(inputStream, CTMarkupRange.type, xmlOptions);
        }

        public static CTMarkupRange parse(Reader reader) {
            return (CTMarkupRange) POIXMLTypeLoader.parse(reader, CTMarkupRange.type, (XmlOptions) null);
        }

        public static CTMarkupRange parse(Reader reader, XmlOptions xmlOptions) {
            return (CTMarkupRange) POIXMLTypeLoader.parse(reader, CTMarkupRange.type, xmlOptions);
        }

        public static CTMarkupRange parse(String str) {
            return (CTMarkupRange) POIXMLTypeLoader.parse(str, CTMarkupRange.type, (XmlOptions) null);
        }

        public static CTMarkupRange parse(String str, XmlOptions xmlOptions) {
            return (CTMarkupRange) POIXMLTypeLoader.parse(str, CTMarkupRange.type, xmlOptions);
        }

        public static CTMarkupRange parse(URL url) {
            return (CTMarkupRange) POIXMLTypeLoader.parse(url, CTMarkupRange.type, (XmlOptions) null);
        }

        public static CTMarkupRange parse(URL url, XmlOptions xmlOptions) {
            return (CTMarkupRange) POIXMLTypeLoader.parse(url, CTMarkupRange.type, xmlOptions);
        }

        public static CTMarkupRange parse(XMLStreamReader xMLStreamReader) {
            return (CTMarkupRange) POIXMLTypeLoader.parse(xMLStreamReader, CTMarkupRange.type, (XmlOptions) null);
        }

        public static CTMarkupRange parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTMarkupRange) POIXMLTypeLoader.parse(xMLStreamReader, CTMarkupRange.type, xmlOptions);
        }

        public static CTMarkupRange parse(XMLInputStream xMLInputStream) {
            return (CTMarkupRange) POIXMLTypeLoader.parse(xMLInputStream, CTMarkupRange.type, (XmlOptions) null);
        }

        public static CTMarkupRange parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTMarkupRange) POIXMLTypeLoader.parse(xMLInputStream, CTMarkupRange.type, xmlOptions);
        }

        public static CTMarkupRange parse(Node node) {
            return (CTMarkupRange) POIXMLTypeLoader.parse(node, CTMarkupRange.type, (XmlOptions) null);
        }

        public static CTMarkupRange parse(Node node, XmlOptions xmlOptions) {
            return (CTMarkupRange) POIXMLTypeLoader.parse(node, CTMarkupRange.type, xmlOptions);
        }
    }

    STDisplacedByCustomXml$Enum getDisplacedByCustomXml();

    boolean isSetDisplacedByCustomXml();

    void setDisplacedByCustomXml(STDisplacedByCustomXml$Enum sTDisplacedByCustomXml$Enum);

    void unsetDisplacedByCustomXml();

    STDisplacedByCustomXml xgetDisplacedByCustomXml();

    void xsetDisplacedByCustomXml(STDisplacedByCustomXml sTDisplacedByCustomXml);
}
