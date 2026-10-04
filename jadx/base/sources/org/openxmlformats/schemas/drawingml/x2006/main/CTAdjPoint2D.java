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
public interface CTAdjPoint2D extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTAdjPoint2D.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctadjpoint2d1656type");

    public static final class Factory {
        private Factory() {
        }

        public static CTAdjPoint2D newInstance() {
            return (CTAdjPoint2D) POIXMLTypeLoader.newInstance(CTAdjPoint2D.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTAdjPoint2D.type, null);
        }

        public static CTAdjPoint2D parse(File file) {
            return (CTAdjPoint2D) POIXMLTypeLoader.parse(file, CTAdjPoint2D.type, (XmlOptions) null);
        }

        public static CTAdjPoint2D newInstance(XmlOptions xmlOptions) {
            return (CTAdjPoint2D) POIXMLTypeLoader.newInstance(CTAdjPoint2D.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTAdjPoint2D.type, xmlOptions);
        }

        public static CTAdjPoint2D parse(File file, XmlOptions xmlOptions) {
            return (CTAdjPoint2D) POIXMLTypeLoader.parse(file, CTAdjPoint2D.type, xmlOptions);
        }

        public static CTAdjPoint2D parse(InputStream inputStream) {
            return (CTAdjPoint2D) POIXMLTypeLoader.parse(inputStream, CTAdjPoint2D.type, (XmlOptions) null);
        }

        public static CTAdjPoint2D parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTAdjPoint2D) POIXMLTypeLoader.parse(inputStream, CTAdjPoint2D.type, xmlOptions);
        }

        public static CTAdjPoint2D parse(Reader reader) {
            return (CTAdjPoint2D) POIXMLTypeLoader.parse(reader, CTAdjPoint2D.type, (XmlOptions) null);
        }

        public static CTAdjPoint2D parse(Reader reader, XmlOptions xmlOptions) {
            return (CTAdjPoint2D) POIXMLTypeLoader.parse(reader, CTAdjPoint2D.type, xmlOptions);
        }

        public static CTAdjPoint2D parse(String str) {
            return (CTAdjPoint2D) POIXMLTypeLoader.parse(str, CTAdjPoint2D.type, (XmlOptions) null);
        }

        public static CTAdjPoint2D parse(String str, XmlOptions xmlOptions) {
            return (CTAdjPoint2D) POIXMLTypeLoader.parse(str, CTAdjPoint2D.type, xmlOptions);
        }

        public static CTAdjPoint2D parse(URL url) {
            return (CTAdjPoint2D) POIXMLTypeLoader.parse(url, CTAdjPoint2D.type, (XmlOptions) null);
        }

        public static CTAdjPoint2D parse(URL url, XmlOptions xmlOptions) {
            return (CTAdjPoint2D) POIXMLTypeLoader.parse(url, CTAdjPoint2D.type, xmlOptions);
        }

        public static CTAdjPoint2D parse(XMLStreamReader xMLStreamReader) {
            return (CTAdjPoint2D) POIXMLTypeLoader.parse(xMLStreamReader, CTAdjPoint2D.type, (XmlOptions) null);
        }

        public static CTAdjPoint2D parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTAdjPoint2D) POIXMLTypeLoader.parse(xMLStreamReader, CTAdjPoint2D.type, xmlOptions);
        }

        public static CTAdjPoint2D parse(XMLInputStream xMLInputStream) {
            return (CTAdjPoint2D) POIXMLTypeLoader.parse(xMLInputStream, CTAdjPoint2D.type, (XmlOptions) null);
        }

        public static CTAdjPoint2D parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTAdjPoint2D) POIXMLTypeLoader.parse(xMLInputStream, CTAdjPoint2D.type, xmlOptions);
        }

        public static CTAdjPoint2D parse(Node node) {
            return (CTAdjPoint2D) POIXMLTypeLoader.parse(node, CTAdjPoint2D.type, (XmlOptions) null);
        }

        public static CTAdjPoint2D parse(Node node, XmlOptions xmlOptions) {
            return (CTAdjPoint2D) POIXMLTypeLoader.parse(node, CTAdjPoint2D.type, xmlOptions);
        }
    }

    Object getX();

    Object getY();

    void setX(Object obj);

    void setY(Object obj);

    STAdjCoordinate xgetX();

    STAdjCoordinate xgetY();

    void xsetX(STAdjCoordinate sTAdjCoordinate);

    void xsetY(STAdjCoordinate sTAdjCoordinate);
}
