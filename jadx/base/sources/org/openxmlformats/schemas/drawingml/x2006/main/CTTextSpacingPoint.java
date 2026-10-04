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
public interface CTTextSpacingPoint extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTextSpacingPoint.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttextspacingpoint6cf5type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextSpacingPoint newInstance() {
            return (CTTextSpacingPoint) POIXMLTypeLoader.newInstance(CTTextSpacingPoint.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextSpacingPoint.type, null);
        }

        public static CTTextSpacingPoint parse(File file) {
            return (CTTextSpacingPoint) POIXMLTypeLoader.parse(file, CTTextSpacingPoint.type, (XmlOptions) null);
        }

        public static CTTextSpacingPoint newInstance(XmlOptions xmlOptions) {
            return (CTTextSpacingPoint) POIXMLTypeLoader.newInstance(CTTextSpacingPoint.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextSpacingPoint.type, xmlOptions);
        }

        public static CTTextSpacingPoint parse(File file, XmlOptions xmlOptions) {
            return (CTTextSpacingPoint) POIXMLTypeLoader.parse(file, CTTextSpacingPoint.type, xmlOptions);
        }

        public static CTTextSpacingPoint parse(InputStream inputStream) {
            return (CTTextSpacingPoint) POIXMLTypeLoader.parse(inputStream, CTTextSpacingPoint.type, (XmlOptions) null);
        }

        public static CTTextSpacingPoint parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTextSpacingPoint) POIXMLTypeLoader.parse(inputStream, CTTextSpacingPoint.type, xmlOptions);
        }

        public static CTTextSpacingPoint parse(Reader reader) {
            return (CTTextSpacingPoint) POIXMLTypeLoader.parse(reader, CTTextSpacingPoint.type, (XmlOptions) null);
        }

        public static CTTextSpacingPoint parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTextSpacingPoint) POIXMLTypeLoader.parse(reader, CTTextSpacingPoint.type, xmlOptions);
        }

        public static CTTextSpacingPoint parse(String str) {
            return (CTTextSpacingPoint) POIXMLTypeLoader.parse(str, CTTextSpacingPoint.type, (XmlOptions) null);
        }

        public static CTTextSpacingPoint parse(String str, XmlOptions xmlOptions) {
            return (CTTextSpacingPoint) POIXMLTypeLoader.parse(str, CTTextSpacingPoint.type, xmlOptions);
        }

        public static CTTextSpacingPoint parse(URL url) {
            return (CTTextSpacingPoint) POIXMLTypeLoader.parse(url, CTTextSpacingPoint.type, (XmlOptions) null);
        }

        public static CTTextSpacingPoint parse(URL url, XmlOptions xmlOptions) {
            return (CTTextSpacingPoint) POIXMLTypeLoader.parse(url, CTTextSpacingPoint.type, xmlOptions);
        }

        public static CTTextSpacingPoint parse(XMLStreamReader xMLStreamReader) {
            return (CTTextSpacingPoint) POIXMLTypeLoader.parse(xMLStreamReader, CTTextSpacingPoint.type, (XmlOptions) null);
        }

        public static CTTextSpacingPoint parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTextSpacingPoint) POIXMLTypeLoader.parse(xMLStreamReader, CTTextSpacingPoint.type, xmlOptions);
        }

        public static CTTextSpacingPoint parse(XMLInputStream xMLInputStream) {
            return (CTTextSpacingPoint) POIXMLTypeLoader.parse(xMLInputStream, CTTextSpacingPoint.type, (XmlOptions) null);
        }

        public static CTTextSpacingPoint parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTextSpacingPoint) POIXMLTypeLoader.parse(xMLInputStream, CTTextSpacingPoint.type, xmlOptions);
        }

        public static CTTextSpacingPoint parse(Node node) {
            return (CTTextSpacingPoint) POIXMLTypeLoader.parse(node, CTTextSpacingPoint.type, (XmlOptions) null);
        }

        public static CTTextSpacingPoint parse(Node node, XmlOptions xmlOptions) {
            return (CTTextSpacingPoint) POIXMLTypeLoader.parse(node, CTTextSpacingPoint.type, xmlOptions);
        }
    }

    int getVal();

    void setVal(int i);

    STTextSpacingPoint xgetVal();

    void xsetVal(STTextSpacingPoint sTTextSpacingPoint);
}
