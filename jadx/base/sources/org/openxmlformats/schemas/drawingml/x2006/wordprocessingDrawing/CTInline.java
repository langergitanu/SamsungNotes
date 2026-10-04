package org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing;

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
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGraphicFrameProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTInline extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTInline.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctinline5726type");

    public static final class Factory {
        private Factory() {
        }

        public static CTInline newInstance() {
            return (CTInline) POIXMLTypeLoader.newInstance(CTInline.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTInline.type, null);
        }

        public static CTInline parse(File file) {
            return (CTInline) POIXMLTypeLoader.parse(file, CTInline.type, (XmlOptions) null);
        }

        public static CTInline newInstance(XmlOptions xmlOptions) {
            return (CTInline) POIXMLTypeLoader.newInstance(CTInline.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTInline.type, xmlOptions);
        }

        public static CTInline parse(File file, XmlOptions xmlOptions) {
            return (CTInline) POIXMLTypeLoader.parse(file, CTInline.type, xmlOptions);
        }

        public static CTInline parse(InputStream inputStream) {
            return (CTInline) POIXMLTypeLoader.parse(inputStream, CTInline.type, (XmlOptions) null);
        }

        public static CTInline parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTInline) POIXMLTypeLoader.parse(inputStream, CTInline.type, xmlOptions);
        }

        public static CTInline parse(Reader reader) {
            return (CTInline) POIXMLTypeLoader.parse(reader, CTInline.type, (XmlOptions) null);
        }

        public static CTInline parse(Reader reader, XmlOptions xmlOptions) {
            return (CTInline) POIXMLTypeLoader.parse(reader, CTInline.type, xmlOptions);
        }

        public static CTInline parse(String str) {
            return (CTInline) POIXMLTypeLoader.parse(str, CTInline.type, (XmlOptions) null);
        }

        public static CTInline parse(String str, XmlOptions xmlOptions) {
            return (CTInline) POIXMLTypeLoader.parse(str, CTInline.type, xmlOptions);
        }

        public static CTInline parse(URL url) {
            return (CTInline) POIXMLTypeLoader.parse(url, CTInline.type, (XmlOptions) null);
        }

        public static CTInline parse(URL url, XmlOptions xmlOptions) {
            return (CTInline) POIXMLTypeLoader.parse(url, CTInline.type, xmlOptions);
        }

        public static CTInline parse(XMLStreamReader xMLStreamReader) {
            return (CTInline) POIXMLTypeLoader.parse(xMLStreamReader, CTInline.type, (XmlOptions) null);
        }

        public static CTInline parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTInline) POIXMLTypeLoader.parse(xMLStreamReader, CTInline.type, xmlOptions);
        }

        public static CTInline parse(XMLInputStream xMLInputStream) {
            return (CTInline) POIXMLTypeLoader.parse(xMLInputStream, CTInline.type, (XmlOptions) null);
        }

        public static CTInline parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTInline) POIXMLTypeLoader.parse(xMLInputStream, CTInline.type, xmlOptions);
        }

        public static CTInline parse(Node node) {
            return (CTInline) POIXMLTypeLoader.parse(node, CTInline.type, (XmlOptions) null);
        }

        public static CTInline parse(Node node, XmlOptions xmlOptions) {
            return (CTInline) POIXMLTypeLoader.parse(node, CTInline.type, xmlOptions);
        }
    }

    CTNonVisualGraphicFrameProperties addNewCNvGraphicFramePr();

    CTNonVisualDrawingProps addNewDocPr();

    CTEffectExtent addNewEffectExtent();

    CTPositiveSize2D addNewExtent();

    CTGraphicalObject addNewGraphic();

    CTNonVisualGraphicFrameProperties getCNvGraphicFramePr();

    long getDistB();

    long getDistL();

    long getDistR();

    long getDistT();

    CTNonVisualDrawingProps getDocPr();

    CTEffectExtent getEffectExtent();

    CTPositiveSize2D getExtent();

    CTGraphicalObject getGraphic();

    boolean isSetCNvGraphicFramePr();

    boolean isSetDistB();

    boolean isSetDistL();

    boolean isSetDistR();

    boolean isSetDistT();

    boolean isSetEffectExtent();

    void setCNvGraphicFramePr(CTNonVisualGraphicFrameProperties cTNonVisualGraphicFrameProperties);

    void setDistB(long j);

    void setDistL(long j);

    void setDistR(long j);

    void setDistT(long j);

    void setDocPr(CTNonVisualDrawingProps cTNonVisualDrawingProps);

    void setEffectExtent(CTEffectExtent cTEffectExtent);

    void setExtent(CTPositiveSize2D cTPositiveSize2D);

    void setGraphic(CTGraphicalObject cTGraphicalObject);

    void unsetCNvGraphicFramePr();

    void unsetDistB();

    void unsetDistL();

    void unsetDistR();

    void unsetDistT();

    void unsetEffectExtent();

    STWrapDistance xgetDistB();

    STWrapDistance xgetDistL();

    STWrapDistance xgetDistR();

    STWrapDistance xgetDistT();

    void xsetDistB(STWrapDistance sTWrapDistance);

    void xsetDistL(STWrapDistance sTWrapDistance);

    void xsetDistR(STWrapDistance sTWrapDistance);

    void xsetDistT(STWrapDistance sTWrapDistance);
}
