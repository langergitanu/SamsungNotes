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
public interface CTJc extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTJc.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctjc158ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTJc newInstance() {
            return (CTJc) POIXMLTypeLoader.newInstance(CTJc.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTJc.type, null);
        }

        public static CTJc parse(File file) {
            return (CTJc) POIXMLTypeLoader.parse(file, CTJc.type, (XmlOptions) null);
        }

        public static CTJc newInstance(XmlOptions xmlOptions) {
            return (CTJc) POIXMLTypeLoader.newInstance(CTJc.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTJc.type, xmlOptions);
        }

        public static CTJc parse(File file, XmlOptions xmlOptions) {
            return (CTJc) POIXMLTypeLoader.parse(file, CTJc.type, xmlOptions);
        }

        public static CTJc parse(InputStream inputStream) {
            return (CTJc) POIXMLTypeLoader.parse(inputStream, CTJc.type, (XmlOptions) null);
        }

        public static CTJc parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTJc) POIXMLTypeLoader.parse(inputStream, CTJc.type, xmlOptions);
        }

        public static CTJc parse(Reader reader) {
            return (CTJc) POIXMLTypeLoader.parse(reader, CTJc.type, (XmlOptions) null);
        }

        public static CTJc parse(Reader reader, XmlOptions xmlOptions) {
            return (CTJc) POIXMLTypeLoader.parse(reader, CTJc.type, xmlOptions);
        }

        public static CTJc parse(String str) {
            return (CTJc) POIXMLTypeLoader.parse(str, CTJc.type, (XmlOptions) null);
        }

        public static CTJc parse(String str, XmlOptions xmlOptions) {
            return (CTJc) POIXMLTypeLoader.parse(str, CTJc.type, xmlOptions);
        }

        public static CTJc parse(URL url) {
            return (CTJc) POIXMLTypeLoader.parse(url, CTJc.type, (XmlOptions) null);
        }

        public static CTJc parse(URL url, XmlOptions xmlOptions) {
            return (CTJc) POIXMLTypeLoader.parse(url, CTJc.type, xmlOptions);
        }

        public static CTJc parse(XMLStreamReader xMLStreamReader) {
            return (CTJc) POIXMLTypeLoader.parse(xMLStreamReader, CTJc.type, (XmlOptions) null);
        }

        public static CTJc parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTJc) POIXMLTypeLoader.parse(xMLStreamReader, CTJc.type, xmlOptions);
        }

        public static CTJc parse(XMLInputStream xMLInputStream) {
            return (CTJc) POIXMLTypeLoader.parse(xMLInputStream, CTJc.type, (XmlOptions) null);
        }

        public static CTJc parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTJc) POIXMLTypeLoader.parse(xMLInputStream, CTJc.type, xmlOptions);
        }

        public static CTJc parse(Node node) {
            return (CTJc) POIXMLTypeLoader.parse(node, CTJc.type, (XmlOptions) null);
        }

        public static CTJc parse(Node node, XmlOptions xmlOptions) {
            return (CTJc) POIXMLTypeLoader.parse(node, CTJc.type, xmlOptions);
        }
    }

    STJc$Enum getVal();

    void setVal(STJc$Enum sTJc$Enum);

    STJc xgetVal();

    void xsetVal(STJc sTJc);
}
