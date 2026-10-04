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
public interface CTGeomRect extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTGeomRect.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctgeomrect53dbtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTGeomRect newInstance() {
            return (CTGeomRect) POIXMLTypeLoader.newInstance(CTGeomRect.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTGeomRect.type, null);
        }

        public static CTGeomRect parse(File file) {
            return (CTGeomRect) POIXMLTypeLoader.parse(file, CTGeomRect.type, (XmlOptions) null);
        }

        public static CTGeomRect newInstance(XmlOptions xmlOptions) {
            return (CTGeomRect) POIXMLTypeLoader.newInstance(CTGeomRect.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTGeomRect.type, xmlOptions);
        }

        public static CTGeomRect parse(File file, XmlOptions xmlOptions) {
            return (CTGeomRect) POIXMLTypeLoader.parse(file, CTGeomRect.type, xmlOptions);
        }

        public static CTGeomRect parse(InputStream inputStream) {
            return (CTGeomRect) POIXMLTypeLoader.parse(inputStream, CTGeomRect.type, (XmlOptions) null);
        }

        public static CTGeomRect parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTGeomRect) POIXMLTypeLoader.parse(inputStream, CTGeomRect.type, xmlOptions);
        }

        public static CTGeomRect parse(Reader reader) {
            return (CTGeomRect) POIXMLTypeLoader.parse(reader, CTGeomRect.type, (XmlOptions) null);
        }

        public static CTGeomRect parse(Reader reader, XmlOptions xmlOptions) {
            return (CTGeomRect) POIXMLTypeLoader.parse(reader, CTGeomRect.type, xmlOptions);
        }

        public static CTGeomRect parse(String str) {
            return (CTGeomRect) POIXMLTypeLoader.parse(str, CTGeomRect.type, (XmlOptions) null);
        }

        public static CTGeomRect parse(String str, XmlOptions xmlOptions) {
            return (CTGeomRect) POIXMLTypeLoader.parse(str, CTGeomRect.type, xmlOptions);
        }

        public static CTGeomRect parse(URL url) {
            return (CTGeomRect) POIXMLTypeLoader.parse(url, CTGeomRect.type, (XmlOptions) null);
        }

        public static CTGeomRect parse(URL url, XmlOptions xmlOptions) {
            return (CTGeomRect) POIXMLTypeLoader.parse(url, CTGeomRect.type, xmlOptions);
        }

        public static CTGeomRect parse(XMLStreamReader xMLStreamReader) {
            return (CTGeomRect) POIXMLTypeLoader.parse(xMLStreamReader, CTGeomRect.type, (XmlOptions) null);
        }

        public static CTGeomRect parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTGeomRect) POIXMLTypeLoader.parse(xMLStreamReader, CTGeomRect.type, xmlOptions);
        }

        public static CTGeomRect parse(XMLInputStream xMLInputStream) {
            return (CTGeomRect) POIXMLTypeLoader.parse(xMLInputStream, CTGeomRect.type, (XmlOptions) null);
        }

        public static CTGeomRect parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTGeomRect) POIXMLTypeLoader.parse(xMLInputStream, CTGeomRect.type, xmlOptions);
        }

        public static CTGeomRect parse(Node node) {
            return (CTGeomRect) POIXMLTypeLoader.parse(node, CTGeomRect.type, (XmlOptions) null);
        }

        public static CTGeomRect parse(Node node, XmlOptions xmlOptions) {
            return (CTGeomRect) POIXMLTypeLoader.parse(node, CTGeomRect.type, xmlOptions);
        }
    }

    Object getB();

    Object getL();

    Object getR();

    Object getT();

    void setB(Object obj);

    void setL(Object obj);

    void setR(Object obj);

    void setT(Object obj);

    STAdjCoordinate xgetB();

    STAdjCoordinate xgetL();

    STAdjCoordinate xgetR();

    STAdjCoordinate xgetT();

    void xsetB(STAdjCoordinate sTAdjCoordinate);

    void xsetL(STAdjCoordinate sTAdjCoordinate);

    void xsetR(STAdjCoordinate sTAdjCoordinate);

    void xsetT(STAdjCoordinate sTAdjCoordinate);
}
