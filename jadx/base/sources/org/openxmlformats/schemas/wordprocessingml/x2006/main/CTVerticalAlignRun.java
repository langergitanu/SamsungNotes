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
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STVerticalAlignRun;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTVerticalAlignRun extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTVerticalAlignRun.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctverticalalignruncb8ctype");

    public static final class Factory {
        private Factory() {
        }

        public static CTVerticalAlignRun newInstance() {
            return (CTVerticalAlignRun) POIXMLTypeLoader.newInstance(CTVerticalAlignRun.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTVerticalAlignRun.type, null);
        }

        public static CTVerticalAlignRun parse(File file) {
            return (CTVerticalAlignRun) POIXMLTypeLoader.parse(file, CTVerticalAlignRun.type, (XmlOptions) null);
        }

        public static CTVerticalAlignRun newInstance(XmlOptions xmlOptions) {
            return (CTVerticalAlignRun) POIXMLTypeLoader.newInstance(CTVerticalAlignRun.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTVerticalAlignRun.type, xmlOptions);
        }

        public static CTVerticalAlignRun parse(File file, XmlOptions xmlOptions) {
            return (CTVerticalAlignRun) POIXMLTypeLoader.parse(file, CTVerticalAlignRun.type, xmlOptions);
        }

        public static CTVerticalAlignRun parse(InputStream inputStream) {
            return (CTVerticalAlignRun) POIXMLTypeLoader.parse(inputStream, CTVerticalAlignRun.type, (XmlOptions) null);
        }

        public static CTVerticalAlignRun parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTVerticalAlignRun) POIXMLTypeLoader.parse(inputStream, CTVerticalAlignRun.type, xmlOptions);
        }

        public static CTVerticalAlignRun parse(Reader reader) {
            return (CTVerticalAlignRun) POIXMLTypeLoader.parse(reader, CTVerticalAlignRun.type, (XmlOptions) null);
        }

        public static CTVerticalAlignRun parse(Reader reader, XmlOptions xmlOptions) {
            return (CTVerticalAlignRun) POIXMLTypeLoader.parse(reader, CTVerticalAlignRun.type, xmlOptions);
        }

        public static CTVerticalAlignRun parse(String str) {
            return (CTVerticalAlignRun) POIXMLTypeLoader.parse(str, CTVerticalAlignRun.type, (XmlOptions) null);
        }

        public static CTVerticalAlignRun parse(String str, XmlOptions xmlOptions) {
            return (CTVerticalAlignRun) POIXMLTypeLoader.parse(str, CTVerticalAlignRun.type, xmlOptions);
        }

        public static CTVerticalAlignRun parse(URL url) {
            return (CTVerticalAlignRun) POIXMLTypeLoader.parse(url, CTVerticalAlignRun.type, (XmlOptions) null);
        }

        public static CTVerticalAlignRun parse(URL url, XmlOptions xmlOptions) {
            return (CTVerticalAlignRun) POIXMLTypeLoader.parse(url, CTVerticalAlignRun.type, xmlOptions);
        }

        public static CTVerticalAlignRun parse(XMLStreamReader xMLStreamReader) {
            return (CTVerticalAlignRun) POIXMLTypeLoader.parse(xMLStreamReader, CTVerticalAlignRun.type, (XmlOptions) null);
        }

        public static CTVerticalAlignRun parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTVerticalAlignRun) POIXMLTypeLoader.parse(xMLStreamReader, CTVerticalAlignRun.type, xmlOptions);
        }

        public static CTVerticalAlignRun parse(XMLInputStream xMLInputStream) {
            return (CTVerticalAlignRun) POIXMLTypeLoader.parse(xMLInputStream, CTVerticalAlignRun.type, (XmlOptions) null);
        }

        public static CTVerticalAlignRun parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTVerticalAlignRun) POIXMLTypeLoader.parse(xMLInputStream, CTVerticalAlignRun.type, xmlOptions);
        }

        public static CTVerticalAlignRun parse(Node node) {
            return (CTVerticalAlignRun) POIXMLTypeLoader.parse(node, CTVerticalAlignRun.type, (XmlOptions) null);
        }

        public static CTVerticalAlignRun parse(Node node, XmlOptions xmlOptions) {
            return (CTVerticalAlignRun) POIXMLTypeLoader.parse(node, CTVerticalAlignRun.type, xmlOptions);
        }
    }

    STVerticalAlignRun.Enum getVal();

    void setVal(STVerticalAlignRun.Enum r12);

    STVerticalAlignRun xgetVal();

    void xsetVal(STVerticalAlignRun sTVerticalAlignRun);
}
