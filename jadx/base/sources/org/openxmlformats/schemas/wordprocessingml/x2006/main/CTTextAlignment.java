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
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTextAlignment;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTTextAlignment extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTextAlignment.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttextalignment495ctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextAlignment newInstance() {
            return (CTTextAlignment) POIXMLTypeLoader.newInstance(CTTextAlignment.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextAlignment.type, null);
        }

        public static CTTextAlignment parse(File file) {
            return (CTTextAlignment) POIXMLTypeLoader.parse(file, CTTextAlignment.type, (XmlOptions) null);
        }

        public static CTTextAlignment newInstance(XmlOptions xmlOptions) {
            return (CTTextAlignment) POIXMLTypeLoader.newInstance(CTTextAlignment.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextAlignment.type, xmlOptions);
        }

        public static CTTextAlignment parse(File file, XmlOptions xmlOptions) {
            return (CTTextAlignment) POIXMLTypeLoader.parse(file, CTTextAlignment.type, xmlOptions);
        }

        public static CTTextAlignment parse(InputStream inputStream) {
            return (CTTextAlignment) POIXMLTypeLoader.parse(inputStream, CTTextAlignment.type, (XmlOptions) null);
        }

        public static CTTextAlignment parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTextAlignment) POIXMLTypeLoader.parse(inputStream, CTTextAlignment.type, xmlOptions);
        }

        public static CTTextAlignment parse(Reader reader) {
            return (CTTextAlignment) POIXMLTypeLoader.parse(reader, CTTextAlignment.type, (XmlOptions) null);
        }

        public static CTTextAlignment parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTextAlignment) POIXMLTypeLoader.parse(reader, CTTextAlignment.type, xmlOptions);
        }

        public static CTTextAlignment parse(String str) {
            return (CTTextAlignment) POIXMLTypeLoader.parse(str, CTTextAlignment.type, (XmlOptions) null);
        }

        public static CTTextAlignment parse(String str, XmlOptions xmlOptions) {
            return (CTTextAlignment) POIXMLTypeLoader.parse(str, CTTextAlignment.type, xmlOptions);
        }

        public static CTTextAlignment parse(URL url) {
            return (CTTextAlignment) POIXMLTypeLoader.parse(url, CTTextAlignment.type, (XmlOptions) null);
        }

        public static CTTextAlignment parse(URL url, XmlOptions xmlOptions) {
            return (CTTextAlignment) POIXMLTypeLoader.parse(url, CTTextAlignment.type, xmlOptions);
        }

        public static CTTextAlignment parse(XMLStreamReader xMLStreamReader) {
            return (CTTextAlignment) POIXMLTypeLoader.parse(xMLStreamReader, CTTextAlignment.type, (XmlOptions) null);
        }

        public static CTTextAlignment parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTextAlignment) POIXMLTypeLoader.parse(xMLStreamReader, CTTextAlignment.type, xmlOptions);
        }

        public static CTTextAlignment parse(XMLInputStream xMLInputStream) {
            return (CTTextAlignment) POIXMLTypeLoader.parse(xMLInputStream, CTTextAlignment.type, (XmlOptions) null);
        }

        public static CTTextAlignment parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTextAlignment) POIXMLTypeLoader.parse(xMLInputStream, CTTextAlignment.type, xmlOptions);
        }

        public static CTTextAlignment parse(Node node) {
            return (CTTextAlignment) POIXMLTypeLoader.parse(node, CTTextAlignment.type, (XmlOptions) null);
        }

        public static CTTextAlignment parse(Node node, XmlOptions xmlOptions) {
            return (CTTextAlignment) POIXMLTypeLoader.parse(node, CTTextAlignment.type, xmlOptions);
        }
    }

    STTextAlignment.Enum getVal();

    void setVal(STTextAlignment.Enum r12);

    STTextAlignment xgetVal();

    void xsetVal(STTextAlignment sTTextAlignment);
}
