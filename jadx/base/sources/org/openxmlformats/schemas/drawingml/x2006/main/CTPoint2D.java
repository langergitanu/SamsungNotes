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
public interface CTPoint2D extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTPoint2D.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctpoint2d8193type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPoint2D newInstance() {
            return (CTPoint2D) POIXMLTypeLoader.newInstance(CTPoint2D.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPoint2D.type, null);
        }

        public static CTPoint2D parse(File file) {
            return (CTPoint2D) POIXMLTypeLoader.parse(file, CTPoint2D.type, (XmlOptions) null);
        }

        public static CTPoint2D newInstance(XmlOptions xmlOptions) {
            return (CTPoint2D) POIXMLTypeLoader.newInstance(CTPoint2D.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPoint2D.type, xmlOptions);
        }

        public static CTPoint2D parse(File file, XmlOptions xmlOptions) {
            return (CTPoint2D) POIXMLTypeLoader.parse(file, CTPoint2D.type, xmlOptions);
        }

        public static CTPoint2D parse(InputStream inputStream) {
            return (CTPoint2D) POIXMLTypeLoader.parse(inputStream, CTPoint2D.type, (XmlOptions) null);
        }

        public static CTPoint2D parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTPoint2D) POIXMLTypeLoader.parse(inputStream, CTPoint2D.type, xmlOptions);
        }

        public static CTPoint2D parse(Reader reader) {
            return (CTPoint2D) POIXMLTypeLoader.parse(reader, CTPoint2D.type, (XmlOptions) null);
        }

        public static CTPoint2D parse(Reader reader, XmlOptions xmlOptions) {
            return (CTPoint2D) POIXMLTypeLoader.parse(reader, CTPoint2D.type, xmlOptions);
        }

        public static CTPoint2D parse(String str) {
            return (CTPoint2D) POIXMLTypeLoader.parse(str, CTPoint2D.type, (XmlOptions) null);
        }

        public static CTPoint2D parse(String str, XmlOptions xmlOptions) {
            return (CTPoint2D) POIXMLTypeLoader.parse(str, CTPoint2D.type, xmlOptions);
        }

        public static CTPoint2D parse(URL url) {
            return (CTPoint2D) POIXMLTypeLoader.parse(url, CTPoint2D.type, (XmlOptions) null);
        }

        public static CTPoint2D parse(URL url, XmlOptions xmlOptions) {
            return (CTPoint2D) POIXMLTypeLoader.parse(url, CTPoint2D.type, xmlOptions);
        }

        public static CTPoint2D parse(XMLStreamReader xMLStreamReader) {
            return (CTPoint2D) POIXMLTypeLoader.parse(xMLStreamReader, CTPoint2D.type, (XmlOptions) null);
        }

        public static CTPoint2D parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTPoint2D) POIXMLTypeLoader.parse(xMLStreamReader, CTPoint2D.type, xmlOptions);
        }

        public static CTPoint2D parse(XMLInputStream xMLInputStream) {
            return (CTPoint2D) POIXMLTypeLoader.parse(xMLInputStream, CTPoint2D.type, (XmlOptions) null);
        }

        public static CTPoint2D parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTPoint2D) POIXMLTypeLoader.parse(xMLInputStream, CTPoint2D.type, xmlOptions);
        }

        public static CTPoint2D parse(Node node) {
            return (CTPoint2D) POIXMLTypeLoader.parse(node, CTPoint2D.type, (XmlOptions) null);
        }

        public static CTPoint2D parse(Node node, XmlOptions xmlOptions) {
            return (CTPoint2D) POIXMLTypeLoader.parse(node, CTPoint2D.type, xmlOptions);
        }
    }

    long getX();

    long getY();

    void setX(long j);

    void setY(long j);

    STCoordinate xgetX();

    STCoordinate xgetY();

    void xsetX(STCoordinate sTCoordinate);

    void xsetY(STCoordinate sTCoordinate);
}
