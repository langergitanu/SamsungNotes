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
public interface CTTextSpacingPercent extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTextSpacingPercent.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttextspacingpercent322atype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextSpacingPercent newInstance() {
            return (CTTextSpacingPercent) POIXMLTypeLoader.newInstance(CTTextSpacingPercent.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextSpacingPercent.type, null);
        }

        public static CTTextSpacingPercent parse(File file) {
            return (CTTextSpacingPercent) POIXMLTypeLoader.parse(file, CTTextSpacingPercent.type, (XmlOptions) null);
        }

        public static CTTextSpacingPercent newInstance(XmlOptions xmlOptions) {
            return (CTTextSpacingPercent) POIXMLTypeLoader.newInstance(CTTextSpacingPercent.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextSpacingPercent.type, xmlOptions);
        }

        public static CTTextSpacingPercent parse(File file, XmlOptions xmlOptions) {
            return (CTTextSpacingPercent) POIXMLTypeLoader.parse(file, CTTextSpacingPercent.type, xmlOptions);
        }

        public static CTTextSpacingPercent parse(InputStream inputStream) {
            return (CTTextSpacingPercent) POIXMLTypeLoader.parse(inputStream, CTTextSpacingPercent.type, (XmlOptions) null);
        }

        public static CTTextSpacingPercent parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTextSpacingPercent) POIXMLTypeLoader.parse(inputStream, CTTextSpacingPercent.type, xmlOptions);
        }

        public static CTTextSpacingPercent parse(Reader reader) {
            return (CTTextSpacingPercent) POIXMLTypeLoader.parse(reader, CTTextSpacingPercent.type, (XmlOptions) null);
        }

        public static CTTextSpacingPercent parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTextSpacingPercent) POIXMLTypeLoader.parse(reader, CTTextSpacingPercent.type, xmlOptions);
        }

        public static CTTextSpacingPercent parse(String str) {
            return (CTTextSpacingPercent) POIXMLTypeLoader.parse(str, CTTextSpacingPercent.type, (XmlOptions) null);
        }

        public static CTTextSpacingPercent parse(String str, XmlOptions xmlOptions) {
            return (CTTextSpacingPercent) POIXMLTypeLoader.parse(str, CTTextSpacingPercent.type, xmlOptions);
        }

        public static CTTextSpacingPercent parse(URL url) {
            return (CTTextSpacingPercent) POIXMLTypeLoader.parse(url, CTTextSpacingPercent.type, (XmlOptions) null);
        }

        public static CTTextSpacingPercent parse(URL url, XmlOptions xmlOptions) {
            return (CTTextSpacingPercent) POIXMLTypeLoader.parse(url, CTTextSpacingPercent.type, xmlOptions);
        }

        public static CTTextSpacingPercent parse(XMLStreamReader xMLStreamReader) {
            return (CTTextSpacingPercent) POIXMLTypeLoader.parse(xMLStreamReader, CTTextSpacingPercent.type, (XmlOptions) null);
        }

        public static CTTextSpacingPercent parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTextSpacingPercent) POIXMLTypeLoader.parse(xMLStreamReader, CTTextSpacingPercent.type, xmlOptions);
        }

        public static CTTextSpacingPercent parse(XMLInputStream xMLInputStream) {
            return (CTTextSpacingPercent) POIXMLTypeLoader.parse(xMLInputStream, CTTextSpacingPercent.type, (XmlOptions) null);
        }

        public static CTTextSpacingPercent parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTextSpacingPercent) POIXMLTypeLoader.parse(xMLInputStream, CTTextSpacingPercent.type, xmlOptions);
        }

        public static CTTextSpacingPercent parse(Node node) {
            return (CTTextSpacingPercent) POIXMLTypeLoader.parse(node, CTTextSpacingPercent.type, (XmlOptions) null);
        }

        public static CTTextSpacingPercent parse(Node node, XmlOptions xmlOptions) {
            return (CTTextSpacingPercent) POIXMLTypeLoader.parse(node, CTTextSpacingPercent.type, xmlOptions);
        }
    }

    int getVal();

    void setVal(int i);

    STTextSpacingPercent xgetVal();

    void xsetVal(STTextSpacingPercent sTTextSpacingPercent);
}
