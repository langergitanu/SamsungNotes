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
public interface CTPath2DMoveTo extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTPath2DMoveTo.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctpath2dmovetoa01etype");

    public static final class Factory {
        private Factory() {
        }

        public static CTPath2DMoveTo newInstance() {
            return (CTPath2DMoveTo) POIXMLTypeLoader.newInstance(CTPath2DMoveTo.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPath2DMoveTo.type, null);
        }

        public static CTPath2DMoveTo parse(File file) {
            return (CTPath2DMoveTo) POIXMLTypeLoader.parse(file, CTPath2DMoveTo.type, (XmlOptions) null);
        }

        public static CTPath2DMoveTo newInstance(XmlOptions xmlOptions) {
            return (CTPath2DMoveTo) POIXMLTypeLoader.newInstance(CTPath2DMoveTo.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPath2DMoveTo.type, xmlOptions);
        }

        public static CTPath2DMoveTo parse(File file, XmlOptions xmlOptions) {
            return (CTPath2DMoveTo) POIXMLTypeLoader.parse(file, CTPath2DMoveTo.type, xmlOptions);
        }

        public static CTPath2DMoveTo parse(InputStream inputStream) {
            return (CTPath2DMoveTo) POIXMLTypeLoader.parse(inputStream, CTPath2DMoveTo.type, (XmlOptions) null);
        }

        public static CTPath2DMoveTo parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTPath2DMoveTo) POIXMLTypeLoader.parse(inputStream, CTPath2DMoveTo.type, xmlOptions);
        }

        public static CTPath2DMoveTo parse(Reader reader) {
            return (CTPath2DMoveTo) POIXMLTypeLoader.parse(reader, CTPath2DMoveTo.type, (XmlOptions) null);
        }

        public static CTPath2DMoveTo parse(Reader reader, XmlOptions xmlOptions) {
            return (CTPath2DMoveTo) POIXMLTypeLoader.parse(reader, CTPath2DMoveTo.type, xmlOptions);
        }

        public static CTPath2DMoveTo parse(String str) {
            return (CTPath2DMoveTo) POIXMLTypeLoader.parse(str, CTPath2DMoveTo.type, (XmlOptions) null);
        }

        public static CTPath2DMoveTo parse(String str, XmlOptions xmlOptions) {
            return (CTPath2DMoveTo) POIXMLTypeLoader.parse(str, CTPath2DMoveTo.type, xmlOptions);
        }

        public static CTPath2DMoveTo parse(URL url) {
            return (CTPath2DMoveTo) POIXMLTypeLoader.parse(url, CTPath2DMoveTo.type, (XmlOptions) null);
        }

        public static CTPath2DMoveTo parse(URL url, XmlOptions xmlOptions) {
            return (CTPath2DMoveTo) POIXMLTypeLoader.parse(url, CTPath2DMoveTo.type, xmlOptions);
        }

        public static CTPath2DMoveTo parse(XMLStreamReader xMLStreamReader) {
            return (CTPath2DMoveTo) POIXMLTypeLoader.parse(xMLStreamReader, CTPath2DMoveTo.type, (XmlOptions) null);
        }

        public static CTPath2DMoveTo parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTPath2DMoveTo) POIXMLTypeLoader.parse(xMLStreamReader, CTPath2DMoveTo.type, xmlOptions);
        }

        public static CTPath2DMoveTo parse(XMLInputStream xMLInputStream) {
            return (CTPath2DMoveTo) POIXMLTypeLoader.parse(xMLInputStream, CTPath2DMoveTo.type, (XmlOptions) null);
        }

        public static CTPath2DMoveTo parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTPath2DMoveTo) POIXMLTypeLoader.parse(xMLInputStream, CTPath2DMoveTo.type, xmlOptions);
        }

        public static CTPath2DMoveTo parse(Node node) {
            return (CTPath2DMoveTo) POIXMLTypeLoader.parse(node, CTPath2DMoveTo.type, (XmlOptions) null);
        }

        public static CTPath2DMoveTo parse(Node node, XmlOptions xmlOptions) {
            return (CTPath2DMoveTo) POIXMLTypeLoader.parse(node, CTPath2DMoveTo.type, xmlOptions);
        }
    }

    CTAdjPoint2D addNewPt();

    CTAdjPoint2D getPt();

    void setPt(CTAdjPoint2D cTAdjPoint2D);
}
