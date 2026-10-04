package org.openxmlformats.schemas.presentationml.x2006.main;

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
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGraphicFrameProperties;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTGraphicalObjectFrameNonVisual extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTGraphicalObjectFrameNonVisual.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctgraphicalobjectframenonvisual257dtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTGraphicalObjectFrameNonVisual newInstance() {
            return (CTGraphicalObjectFrameNonVisual) POIXMLTypeLoader.newInstance(CTGraphicalObjectFrameNonVisual.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTGraphicalObjectFrameNonVisual.type, null);
        }

        public static CTGraphicalObjectFrameNonVisual parse(File file) {
            return (CTGraphicalObjectFrameNonVisual) POIXMLTypeLoader.parse(file, CTGraphicalObjectFrameNonVisual.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrameNonVisual newInstance(XmlOptions xmlOptions) {
            return (CTGraphicalObjectFrameNonVisual) POIXMLTypeLoader.newInstance(CTGraphicalObjectFrameNonVisual.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTGraphicalObjectFrameNonVisual.type, xmlOptions);
        }

        public static CTGraphicalObjectFrameNonVisual parse(File file, XmlOptions xmlOptions) {
            return (CTGraphicalObjectFrameNonVisual) POIXMLTypeLoader.parse(file, CTGraphicalObjectFrameNonVisual.type, xmlOptions);
        }

        public static CTGraphicalObjectFrameNonVisual parse(InputStream inputStream) {
            return (CTGraphicalObjectFrameNonVisual) POIXMLTypeLoader.parse(inputStream, CTGraphicalObjectFrameNonVisual.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrameNonVisual parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTGraphicalObjectFrameNonVisual) POIXMLTypeLoader.parse(inputStream, CTGraphicalObjectFrameNonVisual.type, xmlOptions);
        }

        public static CTGraphicalObjectFrameNonVisual parse(Reader reader) {
            return (CTGraphicalObjectFrameNonVisual) POIXMLTypeLoader.parse(reader, CTGraphicalObjectFrameNonVisual.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrameNonVisual parse(Reader reader, XmlOptions xmlOptions) {
            return (CTGraphicalObjectFrameNonVisual) POIXMLTypeLoader.parse(reader, CTGraphicalObjectFrameNonVisual.type, xmlOptions);
        }

        public static CTGraphicalObjectFrameNonVisual parse(String str) {
            return (CTGraphicalObjectFrameNonVisual) POIXMLTypeLoader.parse(str, CTGraphicalObjectFrameNonVisual.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrameNonVisual parse(String str, XmlOptions xmlOptions) {
            return (CTGraphicalObjectFrameNonVisual) POIXMLTypeLoader.parse(str, CTGraphicalObjectFrameNonVisual.type, xmlOptions);
        }

        public static CTGraphicalObjectFrameNonVisual parse(URL url) {
            return (CTGraphicalObjectFrameNonVisual) POIXMLTypeLoader.parse(url, CTGraphicalObjectFrameNonVisual.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrameNonVisual parse(URL url, XmlOptions xmlOptions) {
            return (CTGraphicalObjectFrameNonVisual) POIXMLTypeLoader.parse(url, CTGraphicalObjectFrameNonVisual.type, xmlOptions);
        }

        public static CTGraphicalObjectFrameNonVisual parse(XMLStreamReader xMLStreamReader) {
            return (CTGraphicalObjectFrameNonVisual) POIXMLTypeLoader.parse(xMLStreamReader, CTGraphicalObjectFrameNonVisual.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrameNonVisual parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTGraphicalObjectFrameNonVisual) POIXMLTypeLoader.parse(xMLStreamReader, CTGraphicalObjectFrameNonVisual.type, xmlOptions);
        }

        public static CTGraphicalObjectFrameNonVisual parse(XMLInputStream xMLInputStream) {
            return (CTGraphicalObjectFrameNonVisual) POIXMLTypeLoader.parse(xMLInputStream, CTGraphicalObjectFrameNonVisual.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrameNonVisual parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTGraphicalObjectFrameNonVisual) POIXMLTypeLoader.parse(xMLInputStream, CTGraphicalObjectFrameNonVisual.type, xmlOptions);
        }

        public static CTGraphicalObjectFrameNonVisual parse(Node node) {
            return (CTGraphicalObjectFrameNonVisual) POIXMLTypeLoader.parse(node, CTGraphicalObjectFrameNonVisual.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrameNonVisual parse(Node node, XmlOptions xmlOptions) {
            return (CTGraphicalObjectFrameNonVisual) POIXMLTypeLoader.parse(node, CTGraphicalObjectFrameNonVisual.type, xmlOptions);
        }
    }

    CTNonVisualGraphicFrameProperties addNewCNvGraphicFramePr();

    CTNonVisualDrawingProps addNewCNvPr();

    CTApplicationNonVisualDrawingProps addNewNvPr();

    CTNonVisualGraphicFrameProperties getCNvGraphicFramePr();

    CTNonVisualDrawingProps getCNvPr();

    CTApplicationNonVisualDrawingProps getNvPr();

    void setCNvGraphicFramePr(CTNonVisualGraphicFrameProperties cTNonVisualGraphicFrameProperties);

    void setCNvPr(CTNonVisualDrawingProps cTNonVisualDrawingProps);

    void setNvPr(CTApplicationNonVisualDrawingProps cTApplicationNonVisualDrawingProps);
}
