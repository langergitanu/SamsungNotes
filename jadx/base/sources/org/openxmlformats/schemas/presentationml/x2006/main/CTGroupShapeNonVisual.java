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
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualGroupDrawingShapeProps;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTGroupShapeNonVisual extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTGroupShapeNonVisual.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctgroupshapenonvisual3e44type");

    public static final class Factory {
        private Factory() {
        }

        public static CTGroupShapeNonVisual newInstance() {
            return (CTGroupShapeNonVisual) POIXMLTypeLoader.newInstance(CTGroupShapeNonVisual.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTGroupShapeNonVisual.type, null);
        }

        public static CTGroupShapeNonVisual parse(File file) {
            return (CTGroupShapeNonVisual) POIXMLTypeLoader.parse(file, CTGroupShapeNonVisual.type, (XmlOptions) null);
        }

        public static CTGroupShapeNonVisual newInstance(XmlOptions xmlOptions) {
            return (CTGroupShapeNonVisual) POIXMLTypeLoader.newInstance(CTGroupShapeNonVisual.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTGroupShapeNonVisual.type, xmlOptions);
        }

        public static CTGroupShapeNonVisual parse(File file, XmlOptions xmlOptions) {
            return (CTGroupShapeNonVisual) POIXMLTypeLoader.parse(file, CTGroupShapeNonVisual.type, xmlOptions);
        }

        public static CTGroupShapeNonVisual parse(InputStream inputStream) {
            return (CTGroupShapeNonVisual) POIXMLTypeLoader.parse(inputStream, CTGroupShapeNonVisual.type, (XmlOptions) null);
        }

        public static CTGroupShapeNonVisual parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTGroupShapeNonVisual) POIXMLTypeLoader.parse(inputStream, CTGroupShapeNonVisual.type, xmlOptions);
        }

        public static CTGroupShapeNonVisual parse(Reader reader) {
            return (CTGroupShapeNonVisual) POIXMLTypeLoader.parse(reader, CTGroupShapeNonVisual.type, (XmlOptions) null);
        }

        public static CTGroupShapeNonVisual parse(Reader reader, XmlOptions xmlOptions) {
            return (CTGroupShapeNonVisual) POIXMLTypeLoader.parse(reader, CTGroupShapeNonVisual.type, xmlOptions);
        }

        public static CTGroupShapeNonVisual parse(String str) {
            return (CTGroupShapeNonVisual) POIXMLTypeLoader.parse(str, CTGroupShapeNonVisual.type, (XmlOptions) null);
        }

        public static CTGroupShapeNonVisual parse(String str, XmlOptions xmlOptions) {
            return (CTGroupShapeNonVisual) POIXMLTypeLoader.parse(str, CTGroupShapeNonVisual.type, xmlOptions);
        }

        public static CTGroupShapeNonVisual parse(URL url) {
            return (CTGroupShapeNonVisual) POIXMLTypeLoader.parse(url, CTGroupShapeNonVisual.type, (XmlOptions) null);
        }

        public static CTGroupShapeNonVisual parse(URL url, XmlOptions xmlOptions) {
            return (CTGroupShapeNonVisual) POIXMLTypeLoader.parse(url, CTGroupShapeNonVisual.type, xmlOptions);
        }

        public static CTGroupShapeNonVisual parse(XMLStreamReader xMLStreamReader) {
            return (CTGroupShapeNonVisual) POIXMLTypeLoader.parse(xMLStreamReader, CTGroupShapeNonVisual.type, (XmlOptions) null);
        }

        public static CTGroupShapeNonVisual parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTGroupShapeNonVisual) POIXMLTypeLoader.parse(xMLStreamReader, CTGroupShapeNonVisual.type, xmlOptions);
        }

        public static CTGroupShapeNonVisual parse(XMLInputStream xMLInputStream) {
            return (CTGroupShapeNonVisual) POIXMLTypeLoader.parse(xMLInputStream, CTGroupShapeNonVisual.type, (XmlOptions) null);
        }

        public static CTGroupShapeNonVisual parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTGroupShapeNonVisual) POIXMLTypeLoader.parse(xMLInputStream, CTGroupShapeNonVisual.type, xmlOptions);
        }

        public static CTGroupShapeNonVisual parse(Node node) {
            return (CTGroupShapeNonVisual) POIXMLTypeLoader.parse(node, CTGroupShapeNonVisual.type, (XmlOptions) null);
        }

        public static CTGroupShapeNonVisual parse(Node node, XmlOptions xmlOptions) {
            return (CTGroupShapeNonVisual) POIXMLTypeLoader.parse(node, CTGroupShapeNonVisual.type, xmlOptions);
        }
    }

    CTNonVisualGroupDrawingShapeProps addNewCNvGrpSpPr();

    CTNonVisualDrawingProps addNewCNvPr();

    CTApplicationNonVisualDrawingProps addNewNvPr();

    CTNonVisualGroupDrawingShapeProps getCNvGrpSpPr();

    CTNonVisualDrawingProps getCNvPr();

    CTApplicationNonVisualDrawingProps getNvPr();

    void setCNvGrpSpPr(CTNonVisualGroupDrawingShapeProps cTNonVisualGroupDrawingShapeProps);

    void setCNvPr(CTNonVisualDrawingProps cTNonVisualDrawingProps);

    void setNvPr(CTApplicationNonVisualDrawingProps cTApplicationNonVisualDrawingProps);
}
