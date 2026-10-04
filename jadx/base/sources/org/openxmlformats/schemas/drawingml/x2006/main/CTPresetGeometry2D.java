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
import org.openxmlformats.schemas.drawingml.x2006.main.STShapeType;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTPresetGeometry2D extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTPresetGeometry2D.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctpresetgeometry2db1detype");

    public static final class Factory {
        private Factory() {
        }

        public static CTPresetGeometry2D newInstance() {
            return (CTPresetGeometry2D) POIXMLTypeLoader.newInstance(CTPresetGeometry2D.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPresetGeometry2D.type, null);
        }

        public static CTPresetGeometry2D parse(File file) {
            return (CTPresetGeometry2D) POIXMLTypeLoader.parse(file, CTPresetGeometry2D.type, (XmlOptions) null);
        }

        public static CTPresetGeometry2D newInstance(XmlOptions xmlOptions) {
            return (CTPresetGeometry2D) POIXMLTypeLoader.newInstance(CTPresetGeometry2D.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPresetGeometry2D.type, xmlOptions);
        }

        public static CTPresetGeometry2D parse(File file, XmlOptions xmlOptions) {
            return (CTPresetGeometry2D) POIXMLTypeLoader.parse(file, CTPresetGeometry2D.type, xmlOptions);
        }

        public static CTPresetGeometry2D parse(InputStream inputStream) {
            return (CTPresetGeometry2D) POIXMLTypeLoader.parse(inputStream, CTPresetGeometry2D.type, (XmlOptions) null);
        }

        public static CTPresetGeometry2D parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTPresetGeometry2D) POIXMLTypeLoader.parse(inputStream, CTPresetGeometry2D.type, xmlOptions);
        }

        public static CTPresetGeometry2D parse(Reader reader) {
            return (CTPresetGeometry2D) POIXMLTypeLoader.parse(reader, CTPresetGeometry2D.type, (XmlOptions) null);
        }

        public static CTPresetGeometry2D parse(Reader reader, XmlOptions xmlOptions) {
            return (CTPresetGeometry2D) POIXMLTypeLoader.parse(reader, CTPresetGeometry2D.type, xmlOptions);
        }

        public static CTPresetGeometry2D parse(String str) {
            return (CTPresetGeometry2D) POIXMLTypeLoader.parse(str, CTPresetGeometry2D.type, (XmlOptions) null);
        }

        public static CTPresetGeometry2D parse(String str, XmlOptions xmlOptions) {
            return (CTPresetGeometry2D) POIXMLTypeLoader.parse(str, CTPresetGeometry2D.type, xmlOptions);
        }

        public static CTPresetGeometry2D parse(URL url) {
            return (CTPresetGeometry2D) POIXMLTypeLoader.parse(url, CTPresetGeometry2D.type, (XmlOptions) null);
        }

        public static CTPresetGeometry2D parse(URL url, XmlOptions xmlOptions) {
            return (CTPresetGeometry2D) POIXMLTypeLoader.parse(url, CTPresetGeometry2D.type, xmlOptions);
        }

        public static CTPresetGeometry2D parse(XMLStreamReader xMLStreamReader) {
            return (CTPresetGeometry2D) POIXMLTypeLoader.parse(xMLStreamReader, CTPresetGeometry2D.type, (XmlOptions) null);
        }

        public static CTPresetGeometry2D parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTPresetGeometry2D) POIXMLTypeLoader.parse(xMLStreamReader, CTPresetGeometry2D.type, xmlOptions);
        }

        public static CTPresetGeometry2D parse(XMLInputStream xMLInputStream) {
            return (CTPresetGeometry2D) POIXMLTypeLoader.parse(xMLInputStream, CTPresetGeometry2D.type, (XmlOptions) null);
        }

        public static CTPresetGeometry2D parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTPresetGeometry2D) POIXMLTypeLoader.parse(xMLInputStream, CTPresetGeometry2D.type, xmlOptions);
        }

        public static CTPresetGeometry2D parse(Node node) {
            return (CTPresetGeometry2D) POIXMLTypeLoader.parse(node, CTPresetGeometry2D.type, (XmlOptions) null);
        }

        public static CTPresetGeometry2D parse(Node node, XmlOptions xmlOptions) {
            return (CTPresetGeometry2D) POIXMLTypeLoader.parse(node, CTPresetGeometry2D.type, xmlOptions);
        }
    }

    CTGeomGuideList addNewAvLst();

    CTGeomGuideList getAvLst();

    STShapeType.Enum getPrst();

    boolean isSetAvLst();

    void setAvLst(CTGeomGuideList cTGeomGuideList);

    void setPrst(STShapeType.Enum r12);

    void unsetAvLst();

    STShapeType xgetPrst();

    void xsetPrst(STShapeType sTShapeType);
}
