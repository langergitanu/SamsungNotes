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
public interface CTPositiveSize2D extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTPositiveSize2D.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctpositivesize2d0147type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPositiveSize2D newInstance() {
            return (CTPositiveSize2D) POIXMLTypeLoader.newInstance(CTPositiveSize2D.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPositiveSize2D.type, null);
        }

        public static CTPositiveSize2D parse(File file) {
            return (CTPositiveSize2D) POIXMLTypeLoader.parse(file, CTPositiveSize2D.type, (XmlOptions) null);
        }

        public static CTPositiveSize2D newInstance(XmlOptions xmlOptions) {
            return (CTPositiveSize2D) POIXMLTypeLoader.newInstance(CTPositiveSize2D.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPositiveSize2D.type, xmlOptions);
        }

        public static CTPositiveSize2D parse(File file, XmlOptions xmlOptions) {
            return (CTPositiveSize2D) POIXMLTypeLoader.parse(file, CTPositiveSize2D.type, xmlOptions);
        }

        public static CTPositiveSize2D parse(InputStream inputStream) {
            return (CTPositiveSize2D) POIXMLTypeLoader.parse(inputStream, CTPositiveSize2D.type, (XmlOptions) null);
        }

        public static CTPositiveSize2D parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTPositiveSize2D) POIXMLTypeLoader.parse(inputStream, CTPositiveSize2D.type, xmlOptions);
        }

        public static CTPositiveSize2D parse(Reader reader) {
            return (CTPositiveSize2D) POIXMLTypeLoader.parse(reader, CTPositiveSize2D.type, (XmlOptions) null);
        }

        public static CTPositiveSize2D parse(Reader reader, XmlOptions xmlOptions) {
            return (CTPositiveSize2D) POIXMLTypeLoader.parse(reader, CTPositiveSize2D.type, xmlOptions);
        }

        public static CTPositiveSize2D parse(String str) {
            return (CTPositiveSize2D) POIXMLTypeLoader.parse(str, CTPositiveSize2D.type, (XmlOptions) null);
        }

        public static CTPositiveSize2D parse(String str, XmlOptions xmlOptions) {
            return (CTPositiveSize2D) POIXMLTypeLoader.parse(str, CTPositiveSize2D.type, xmlOptions);
        }

        public static CTPositiveSize2D parse(URL url) {
            return (CTPositiveSize2D) POIXMLTypeLoader.parse(url, CTPositiveSize2D.type, (XmlOptions) null);
        }

        public static CTPositiveSize2D parse(URL url, XmlOptions xmlOptions) {
            return (CTPositiveSize2D) POIXMLTypeLoader.parse(url, CTPositiveSize2D.type, xmlOptions);
        }

        public static CTPositiveSize2D parse(XMLStreamReader xMLStreamReader) {
            return (CTPositiveSize2D) POIXMLTypeLoader.parse(xMLStreamReader, CTPositiveSize2D.type, (XmlOptions) null);
        }

        public static CTPositiveSize2D parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTPositiveSize2D) POIXMLTypeLoader.parse(xMLStreamReader, CTPositiveSize2D.type, xmlOptions);
        }

        public static CTPositiveSize2D parse(XMLInputStream xMLInputStream) {
            return (CTPositiveSize2D) POIXMLTypeLoader.parse(xMLInputStream, CTPositiveSize2D.type, (XmlOptions) null);
        }

        public static CTPositiveSize2D parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTPositiveSize2D) POIXMLTypeLoader.parse(xMLInputStream, CTPositiveSize2D.type, xmlOptions);
        }

        public static CTPositiveSize2D parse(Node node) {
            return (CTPositiveSize2D) POIXMLTypeLoader.parse(node, CTPositiveSize2D.type, (XmlOptions) null);
        }

        public static CTPositiveSize2D parse(Node node, XmlOptions xmlOptions) {
            return (CTPositiveSize2D) POIXMLTypeLoader.parse(node, CTPositiveSize2D.type, xmlOptions);
        }
    }

    long getCx();

    long getCy();

    void setCx(long j);

    void setCy(long j);

    STPositiveCoordinate xgetCx();

    STPositiveCoordinate xgetCy();

    void xsetCx(STPositiveCoordinate sTPositiveCoordinate);

    void xsetCy(STPositiveCoordinate sTPositiveCoordinate);
}
