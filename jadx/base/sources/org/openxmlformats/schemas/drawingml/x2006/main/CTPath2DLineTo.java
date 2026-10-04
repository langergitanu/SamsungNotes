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
public interface CTPath2DLineTo extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTPath2DLineTo.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctpath2dlineto4f41type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPath2DLineTo newInstance() {
            return (CTPath2DLineTo) POIXMLTypeLoader.newInstance(CTPath2DLineTo.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPath2DLineTo.type, null);
        }

        public static CTPath2DLineTo parse(File file) {
            return (CTPath2DLineTo) POIXMLTypeLoader.parse(file, CTPath2DLineTo.type, (XmlOptions) null);
        }

        public static CTPath2DLineTo newInstance(XmlOptions xmlOptions) {
            return (CTPath2DLineTo) POIXMLTypeLoader.newInstance(CTPath2DLineTo.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPath2DLineTo.type, xmlOptions);
        }

        public static CTPath2DLineTo parse(File file, XmlOptions xmlOptions) {
            return (CTPath2DLineTo) POIXMLTypeLoader.parse(file, CTPath2DLineTo.type, xmlOptions);
        }

        public static CTPath2DLineTo parse(InputStream inputStream) {
            return (CTPath2DLineTo) POIXMLTypeLoader.parse(inputStream, CTPath2DLineTo.type, (XmlOptions) null);
        }

        public static CTPath2DLineTo parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTPath2DLineTo) POIXMLTypeLoader.parse(inputStream, CTPath2DLineTo.type, xmlOptions);
        }

        public static CTPath2DLineTo parse(Reader reader) {
            return (CTPath2DLineTo) POIXMLTypeLoader.parse(reader, CTPath2DLineTo.type, (XmlOptions) null);
        }

        public static CTPath2DLineTo parse(Reader reader, XmlOptions xmlOptions) {
            return (CTPath2DLineTo) POIXMLTypeLoader.parse(reader, CTPath2DLineTo.type, xmlOptions);
        }

        public static CTPath2DLineTo parse(String str) {
            return (CTPath2DLineTo) POIXMLTypeLoader.parse(str, CTPath2DLineTo.type, (XmlOptions) null);
        }

        public static CTPath2DLineTo parse(String str, XmlOptions xmlOptions) {
            return (CTPath2DLineTo) POIXMLTypeLoader.parse(str, CTPath2DLineTo.type, xmlOptions);
        }

        public static CTPath2DLineTo parse(URL url) {
            return (CTPath2DLineTo) POIXMLTypeLoader.parse(url, CTPath2DLineTo.type, (XmlOptions) null);
        }

        public static CTPath2DLineTo parse(URL url, XmlOptions xmlOptions) {
            return (CTPath2DLineTo) POIXMLTypeLoader.parse(url, CTPath2DLineTo.type, xmlOptions);
        }

        public static CTPath2DLineTo parse(XMLStreamReader xMLStreamReader) {
            return (CTPath2DLineTo) POIXMLTypeLoader.parse(xMLStreamReader, CTPath2DLineTo.type, (XmlOptions) null);
        }

        public static CTPath2DLineTo parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTPath2DLineTo) POIXMLTypeLoader.parse(xMLStreamReader, CTPath2DLineTo.type, xmlOptions);
        }

        public static CTPath2DLineTo parse(XMLInputStream xMLInputStream) {
            return (CTPath2DLineTo) POIXMLTypeLoader.parse(xMLInputStream, CTPath2DLineTo.type, (XmlOptions) null);
        }

        public static CTPath2DLineTo parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTPath2DLineTo) POIXMLTypeLoader.parse(xMLInputStream, CTPath2DLineTo.type, xmlOptions);
        }

        public static CTPath2DLineTo parse(Node node) {
            return (CTPath2DLineTo) POIXMLTypeLoader.parse(node, CTPath2DLineTo.type, (XmlOptions) null);
        }

        public static CTPath2DLineTo parse(Node node, XmlOptions xmlOptions) {
            return (CTPath2DLineTo) POIXMLTypeLoader.parse(node, CTPath2DLineTo.type, xmlOptions);
        }
    }

    CTAdjPoint2D addNewPt();

    CTAdjPoint2D getPt();

    void setPt(CTAdjPoint2D cTAdjPoint2D);
}
