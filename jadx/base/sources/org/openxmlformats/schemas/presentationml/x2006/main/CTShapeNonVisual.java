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
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingShapeProps;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTShapeNonVisual extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTShapeNonVisual.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctshapenonvisualb619type");

    public static final class Factory {
        private Factory() {
        }

        public static CTShapeNonVisual newInstance() {
            return (CTShapeNonVisual) POIXMLTypeLoader.newInstance(CTShapeNonVisual.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTShapeNonVisual.type, null);
        }

        public static CTShapeNonVisual parse(File file) {
            return (CTShapeNonVisual) POIXMLTypeLoader.parse(file, CTShapeNonVisual.type, (XmlOptions) null);
        }

        public static CTShapeNonVisual newInstance(XmlOptions xmlOptions) {
            return (CTShapeNonVisual) POIXMLTypeLoader.newInstance(CTShapeNonVisual.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTShapeNonVisual.type, xmlOptions);
        }

        public static CTShapeNonVisual parse(File file, XmlOptions xmlOptions) {
            return (CTShapeNonVisual) POIXMLTypeLoader.parse(file, CTShapeNonVisual.type, xmlOptions);
        }

        public static CTShapeNonVisual parse(InputStream inputStream) {
            return (CTShapeNonVisual) POIXMLTypeLoader.parse(inputStream, CTShapeNonVisual.type, (XmlOptions) null);
        }

        public static CTShapeNonVisual parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTShapeNonVisual) POIXMLTypeLoader.parse(inputStream, CTShapeNonVisual.type, xmlOptions);
        }

        public static CTShapeNonVisual parse(Reader reader) {
            return (CTShapeNonVisual) POIXMLTypeLoader.parse(reader, CTShapeNonVisual.type, (XmlOptions) null);
        }

        public static CTShapeNonVisual parse(Reader reader, XmlOptions xmlOptions) {
            return (CTShapeNonVisual) POIXMLTypeLoader.parse(reader, CTShapeNonVisual.type, xmlOptions);
        }

        public static CTShapeNonVisual parse(String str) {
            return (CTShapeNonVisual) POIXMLTypeLoader.parse(str, CTShapeNonVisual.type, (XmlOptions) null);
        }

        public static CTShapeNonVisual parse(String str, XmlOptions xmlOptions) {
            return (CTShapeNonVisual) POIXMLTypeLoader.parse(str, CTShapeNonVisual.type, xmlOptions);
        }

        public static CTShapeNonVisual parse(URL url) {
            return (CTShapeNonVisual) POIXMLTypeLoader.parse(url, CTShapeNonVisual.type, (XmlOptions) null);
        }

        public static CTShapeNonVisual parse(URL url, XmlOptions xmlOptions) {
            return (CTShapeNonVisual) POIXMLTypeLoader.parse(url, CTShapeNonVisual.type, xmlOptions);
        }

        public static CTShapeNonVisual parse(XMLStreamReader xMLStreamReader) {
            return (CTShapeNonVisual) POIXMLTypeLoader.parse(xMLStreamReader, CTShapeNonVisual.type, (XmlOptions) null);
        }

        public static CTShapeNonVisual parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTShapeNonVisual) POIXMLTypeLoader.parse(xMLStreamReader, CTShapeNonVisual.type, xmlOptions);
        }

        public static CTShapeNonVisual parse(XMLInputStream xMLInputStream) {
            return (CTShapeNonVisual) POIXMLTypeLoader.parse(xMLInputStream, CTShapeNonVisual.type, (XmlOptions) null);
        }

        public static CTShapeNonVisual parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTShapeNonVisual) POIXMLTypeLoader.parse(xMLInputStream, CTShapeNonVisual.type, xmlOptions);
        }

        public static CTShapeNonVisual parse(Node node) {
            return (CTShapeNonVisual) POIXMLTypeLoader.parse(node, CTShapeNonVisual.type, (XmlOptions) null);
        }

        public static CTShapeNonVisual parse(Node node, XmlOptions xmlOptions) {
            return (CTShapeNonVisual) POIXMLTypeLoader.parse(node, CTShapeNonVisual.type, xmlOptions);
        }
    }

    CTNonVisualDrawingProps addNewCNvPr();

    CTNonVisualDrawingShapeProps addNewCNvSpPr();

    CTApplicationNonVisualDrawingProps addNewNvPr();

    CTNonVisualDrawingProps getCNvPr();

    CTNonVisualDrawingShapeProps getCNvSpPr();

    CTApplicationNonVisualDrawingProps getNvPr();

    void setCNvPr(CTNonVisualDrawingProps cTNonVisualDrawingProps);

    void setCNvSpPr(CTNonVisualDrawingShapeProps cTNonVisualDrawingShapeProps);

    void setNvPr(CTApplicationNonVisualDrawingProps cTApplicationNonVisualDrawingProps);
}
