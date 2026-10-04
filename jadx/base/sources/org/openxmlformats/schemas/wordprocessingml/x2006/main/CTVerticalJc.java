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
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STVerticalJc;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTVerticalJc extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTVerticalJc.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctverticaljca439type");

    public static final class Factory {
        private Factory() {
        }

        public static CTVerticalJc newInstance() {
            return (CTVerticalJc) POIXMLTypeLoader.newInstance(CTVerticalJc.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTVerticalJc.type, null);
        }

        public static CTVerticalJc parse(File file) {
            return (CTVerticalJc) POIXMLTypeLoader.parse(file, CTVerticalJc.type, (XmlOptions) null);
        }

        public static CTVerticalJc newInstance(XmlOptions xmlOptions) {
            return (CTVerticalJc) POIXMLTypeLoader.newInstance(CTVerticalJc.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTVerticalJc.type, xmlOptions);
        }

        public static CTVerticalJc parse(File file, XmlOptions xmlOptions) {
            return (CTVerticalJc) POIXMLTypeLoader.parse(file, CTVerticalJc.type, xmlOptions);
        }

        public static CTVerticalJc parse(InputStream inputStream) {
            return (CTVerticalJc) POIXMLTypeLoader.parse(inputStream, CTVerticalJc.type, (XmlOptions) null);
        }

        public static CTVerticalJc parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTVerticalJc) POIXMLTypeLoader.parse(inputStream, CTVerticalJc.type, xmlOptions);
        }

        public static CTVerticalJc parse(Reader reader) {
            return (CTVerticalJc) POIXMLTypeLoader.parse(reader, CTVerticalJc.type, (XmlOptions) null);
        }

        public static CTVerticalJc parse(Reader reader, XmlOptions xmlOptions) {
            return (CTVerticalJc) POIXMLTypeLoader.parse(reader, CTVerticalJc.type, xmlOptions);
        }

        public static CTVerticalJc parse(String str) {
            return (CTVerticalJc) POIXMLTypeLoader.parse(str, CTVerticalJc.type, (XmlOptions) null);
        }

        public static CTVerticalJc parse(String str, XmlOptions xmlOptions) {
            return (CTVerticalJc) POIXMLTypeLoader.parse(str, CTVerticalJc.type, xmlOptions);
        }

        public static CTVerticalJc parse(URL url) {
            return (CTVerticalJc) POIXMLTypeLoader.parse(url, CTVerticalJc.type, (XmlOptions) null);
        }

        public static CTVerticalJc parse(URL url, XmlOptions xmlOptions) {
            return (CTVerticalJc) POIXMLTypeLoader.parse(url, CTVerticalJc.type, xmlOptions);
        }

        public static CTVerticalJc parse(XMLStreamReader xMLStreamReader) {
            return (CTVerticalJc) POIXMLTypeLoader.parse(xMLStreamReader, CTVerticalJc.type, (XmlOptions) null);
        }

        public static CTVerticalJc parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTVerticalJc) POIXMLTypeLoader.parse(xMLStreamReader, CTVerticalJc.type, xmlOptions);
        }

        public static CTVerticalJc parse(XMLInputStream xMLInputStream) {
            return (CTVerticalJc) POIXMLTypeLoader.parse(xMLInputStream, CTVerticalJc.type, (XmlOptions) null);
        }

        public static CTVerticalJc parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTVerticalJc) POIXMLTypeLoader.parse(xMLInputStream, CTVerticalJc.type, xmlOptions);
        }

        public static CTVerticalJc parse(Node node) {
            return (CTVerticalJc) POIXMLTypeLoader.parse(node, CTVerticalJc.type, (XmlOptions) null);
        }

        public static CTVerticalJc parse(Node node, XmlOptions xmlOptions) {
            return (CTVerticalJc) POIXMLTypeLoader.parse(node, CTVerticalJc.type, xmlOptions);
        }
    }

    STVerticalJc.Enum getVal();

    void setVal(STVerticalJc.Enum r12);

    STVerticalJc xgetVal();

    void xsetVal(STVerticalJc sTVerticalJc);
}
