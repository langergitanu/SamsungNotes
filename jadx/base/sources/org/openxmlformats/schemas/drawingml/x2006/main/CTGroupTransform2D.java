package org.openxmlformats.schemas.drawingml.x2006.main;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlBoolean;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTGroupTransform2D extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTGroupTransform2D.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctgrouptransform2d411atype");

    public static final class Factory {
        private Factory() {
        }

        public static CTGroupTransform2D newInstance() {
            return (CTGroupTransform2D) POIXMLTypeLoader.newInstance(CTGroupTransform2D.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTGroupTransform2D.type, null);
        }

        public static CTGroupTransform2D parse(File file) {
            return (CTGroupTransform2D) POIXMLTypeLoader.parse(file, CTGroupTransform2D.type, (XmlOptions) null);
        }

        public static CTGroupTransform2D newInstance(XmlOptions xmlOptions) {
            return (CTGroupTransform2D) POIXMLTypeLoader.newInstance(CTGroupTransform2D.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTGroupTransform2D.type, xmlOptions);
        }

        public static CTGroupTransform2D parse(File file, XmlOptions xmlOptions) {
            return (CTGroupTransform2D) POIXMLTypeLoader.parse(file, CTGroupTransform2D.type, xmlOptions);
        }

        public static CTGroupTransform2D parse(InputStream inputStream) {
            return (CTGroupTransform2D) POIXMLTypeLoader.parse(inputStream, CTGroupTransform2D.type, (XmlOptions) null);
        }

        public static CTGroupTransform2D parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTGroupTransform2D) POIXMLTypeLoader.parse(inputStream, CTGroupTransform2D.type, xmlOptions);
        }

        public static CTGroupTransform2D parse(Reader reader) {
            return (CTGroupTransform2D) POIXMLTypeLoader.parse(reader, CTGroupTransform2D.type, (XmlOptions) null);
        }

        public static CTGroupTransform2D parse(Reader reader, XmlOptions xmlOptions) {
            return (CTGroupTransform2D) POIXMLTypeLoader.parse(reader, CTGroupTransform2D.type, xmlOptions);
        }

        public static CTGroupTransform2D parse(String str) {
            return (CTGroupTransform2D) POIXMLTypeLoader.parse(str, CTGroupTransform2D.type, (XmlOptions) null);
        }

        public static CTGroupTransform2D parse(String str, XmlOptions xmlOptions) {
            return (CTGroupTransform2D) POIXMLTypeLoader.parse(str, CTGroupTransform2D.type, xmlOptions);
        }

        public static CTGroupTransform2D parse(URL url) {
            return (CTGroupTransform2D) POIXMLTypeLoader.parse(url, CTGroupTransform2D.type, (XmlOptions) null);
        }

        public static CTGroupTransform2D parse(URL url, XmlOptions xmlOptions) {
            return (CTGroupTransform2D) POIXMLTypeLoader.parse(url, CTGroupTransform2D.type, xmlOptions);
        }

        public static CTGroupTransform2D parse(XMLStreamReader xMLStreamReader) {
            return (CTGroupTransform2D) POIXMLTypeLoader.parse(xMLStreamReader, CTGroupTransform2D.type, (XmlOptions) null);
        }

        public static CTGroupTransform2D parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTGroupTransform2D) POIXMLTypeLoader.parse(xMLStreamReader, CTGroupTransform2D.type, xmlOptions);
        }

        public static CTGroupTransform2D parse(XMLInputStream xMLInputStream) {
            return (CTGroupTransform2D) POIXMLTypeLoader.parse(xMLInputStream, CTGroupTransform2D.type, (XmlOptions) null);
        }

        public static CTGroupTransform2D parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTGroupTransform2D) POIXMLTypeLoader.parse(xMLInputStream, CTGroupTransform2D.type, xmlOptions);
        }

        public static CTGroupTransform2D parse(Node node) {
            return (CTGroupTransform2D) POIXMLTypeLoader.parse(node, CTGroupTransform2D.type, (XmlOptions) null);
        }

        public static CTGroupTransform2D parse(Node node, XmlOptions xmlOptions) {
            return (CTGroupTransform2D) POIXMLTypeLoader.parse(node, CTGroupTransform2D.type, xmlOptions);
        }
    }

    CTPositiveSize2D addNewChExt();

    CTPoint2D addNewChOff();

    CTPositiveSize2D addNewExt();

    CTPoint2D addNewOff();

    CTPositiveSize2D getChExt();

    CTPoint2D getChOff();

    CTPositiveSize2D getExt();

    boolean getFlipH();

    boolean getFlipV();

    CTPoint2D getOff();

    int getRot();

    boolean isSetChExt();

    boolean isSetChOff();

    boolean isSetExt();

    boolean isSetFlipH();

    boolean isSetFlipV();

    boolean isSetOff();

    boolean isSetRot();

    void setChExt(CTPositiveSize2D cTPositiveSize2D);

    void setChOff(CTPoint2D cTPoint2D);

    void setExt(CTPositiveSize2D cTPositiveSize2D);

    void setFlipH(boolean z);

    void setFlipV(boolean z);

    void setOff(CTPoint2D cTPoint2D);

    void setRot(int i);

    void unsetChExt();

    void unsetChOff();

    void unsetExt();

    void unsetFlipH();

    void unsetFlipV();

    void unsetOff();

    void unsetRot();

    XmlBoolean xgetFlipH();

    XmlBoolean xgetFlipV();

    STAngle xgetRot();

    void xsetFlipH(XmlBoolean xmlBoolean);

    void xsetFlipV(XmlBoolean xmlBoolean);

    void xsetRot(STAngle sTAngle);
}
