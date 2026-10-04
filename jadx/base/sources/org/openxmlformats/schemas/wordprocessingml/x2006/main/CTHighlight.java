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
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STHighlightColor;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTHighlight extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTHighlight.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cthighlight071etype");

    public static final class Factory {
        private Factory() {
        }

        public static CTHighlight newInstance() {
            return (CTHighlight) POIXMLTypeLoader.newInstance(CTHighlight.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTHighlight.type, null);
        }

        public static CTHighlight parse(File file) {
            return (CTHighlight) POIXMLTypeLoader.parse(file, CTHighlight.type, (XmlOptions) null);
        }

        public static CTHighlight newInstance(XmlOptions xmlOptions) {
            return (CTHighlight) POIXMLTypeLoader.newInstance(CTHighlight.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTHighlight.type, xmlOptions);
        }

        public static CTHighlight parse(File file, XmlOptions xmlOptions) {
            return (CTHighlight) POIXMLTypeLoader.parse(file, CTHighlight.type, xmlOptions);
        }

        public static CTHighlight parse(InputStream inputStream) {
            return (CTHighlight) POIXMLTypeLoader.parse(inputStream, CTHighlight.type, (XmlOptions) null);
        }

        public static CTHighlight parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTHighlight) POIXMLTypeLoader.parse(inputStream, CTHighlight.type, xmlOptions);
        }

        public static CTHighlight parse(Reader reader) {
            return (CTHighlight) POIXMLTypeLoader.parse(reader, CTHighlight.type, (XmlOptions) null);
        }

        public static CTHighlight parse(Reader reader, XmlOptions xmlOptions) {
            return (CTHighlight) POIXMLTypeLoader.parse(reader, CTHighlight.type, xmlOptions);
        }

        public static CTHighlight parse(String str) {
            return (CTHighlight) POIXMLTypeLoader.parse(str, CTHighlight.type, (XmlOptions) null);
        }

        public static CTHighlight parse(String str, XmlOptions xmlOptions) {
            return (CTHighlight) POIXMLTypeLoader.parse(str, CTHighlight.type, xmlOptions);
        }

        public static CTHighlight parse(URL url) {
            return (CTHighlight) POIXMLTypeLoader.parse(url, CTHighlight.type, (XmlOptions) null);
        }

        public static CTHighlight parse(URL url, XmlOptions xmlOptions) {
            return (CTHighlight) POIXMLTypeLoader.parse(url, CTHighlight.type, xmlOptions);
        }

        public static CTHighlight parse(XMLStreamReader xMLStreamReader) {
            return (CTHighlight) POIXMLTypeLoader.parse(xMLStreamReader, CTHighlight.type, (XmlOptions) null);
        }

        public static CTHighlight parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTHighlight) POIXMLTypeLoader.parse(xMLStreamReader, CTHighlight.type, xmlOptions);
        }

        public static CTHighlight parse(XMLInputStream xMLInputStream) {
            return (CTHighlight) POIXMLTypeLoader.parse(xMLInputStream, CTHighlight.type, (XmlOptions) null);
        }

        public static CTHighlight parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTHighlight) POIXMLTypeLoader.parse(xMLInputStream, CTHighlight.type, xmlOptions);
        }

        public static CTHighlight parse(Node node) {
            return (CTHighlight) POIXMLTypeLoader.parse(node, CTHighlight.type, (XmlOptions) null);
        }

        public static CTHighlight parse(Node node, XmlOptions xmlOptions) {
            return (CTHighlight) POIXMLTypeLoader.parse(node, CTHighlight.type, xmlOptions);
        }
    }

    STHighlightColor.Enum getVal();

    void setVal(STHighlightColor.Enum r12);

    STHighlightColor xgetVal();

    void xsetVal(STHighlightColor sTHighlightColor);
}
