package org.openxmlformats.schemas.presentationml.x2006.main;

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
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTShape extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTShape.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctshapecfcetype");

    public static final class Factory {
        private Factory() {
        }

        public static CTShape newInstance() {
            return (CTShape) POIXMLTypeLoader.newInstance(CTShape.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTShape.type, null);
        }

        public static CTShape parse(File file) {
            return (CTShape) POIXMLTypeLoader.parse(file, CTShape.type, (XmlOptions) null);
        }

        public static CTShape newInstance(XmlOptions xmlOptions) {
            return (CTShape) POIXMLTypeLoader.newInstance(CTShape.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTShape.type, xmlOptions);
        }

        public static CTShape parse(File file, XmlOptions xmlOptions) {
            return (CTShape) POIXMLTypeLoader.parse(file, CTShape.type, xmlOptions);
        }

        public static CTShape parse(InputStream inputStream) {
            return (CTShape) POIXMLTypeLoader.parse(inputStream, CTShape.type, (XmlOptions) null);
        }

        public static CTShape parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTShape) POIXMLTypeLoader.parse(inputStream, CTShape.type, xmlOptions);
        }

        public static CTShape parse(Reader reader) {
            return (CTShape) POIXMLTypeLoader.parse(reader, CTShape.type, (XmlOptions) null);
        }

        public static CTShape parse(Reader reader, XmlOptions xmlOptions) {
            return (CTShape) POIXMLTypeLoader.parse(reader, CTShape.type, xmlOptions);
        }

        public static CTShape parse(String str) {
            return (CTShape) POIXMLTypeLoader.parse(str, CTShape.type, (XmlOptions) null);
        }

        public static CTShape parse(String str, XmlOptions xmlOptions) {
            return (CTShape) POIXMLTypeLoader.parse(str, CTShape.type, xmlOptions);
        }

        public static CTShape parse(URL url) {
            return (CTShape) POIXMLTypeLoader.parse(url, CTShape.type, (XmlOptions) null);
        }

        public static CTShape parse(URL url, XmlOptions xmlOptions) {
            return (CTShape) POIXMLTypeLoader.parse(url, CTShape.type, xmlOptions);
        }

        public static CTShape parse(XMLStreamReader xMLStreamReader) {
            return (CTShape) POIXMLTypeLoader.parse(xMLStreamReader, CTShape.type, (XmlOptions) null);
        }

        public static CTShape parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTShape) POIXMLTypeLoader.parse(xMLStreamReader, CTShape.type, xmlOptions);
        }

        public static CTShape parse(XMLInputStream xMLInputStream) {
            return (CTShape) POIXMLTypeLoader.parse(xMLInputStream, CTShape.type, (XmlOptions) null);
        }

        public static CTShape parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTShape) POIXMLTypeLoader.parse(xMLInputStream, CTShape.type, xmlOptions);
        }

        public static CTShape parse(Node node) {
            return (CTShape) POIXMLTypeLoader.parse(node, CTShape.type, (XmlOptions) null);
        }

        public static CTShape parse(Node node, XmlOptions xmlOptions) {
            return (CTShape) POIXMLTypeLoader.parse(node, CTShape.type, xmlOptions);
        }
    }

    CTExtensionListModify addNewExtLst();

    CTShapeNonVisual addNewNvSpPr();

    CTShapeProperties addNewSpPr();

    CTShapeStyle addNewStyle();

    CTTextBody addNewTxBody();

    CTExtensionListModify getExtLst();

    CTShapeNonVisual getNvSpPr();

    CTShapeProperties getSpPr();

    CTShapeStyle getStyle();

    CTTextBody getTxBody();

    boolean getUseBgFill();

    boolean isSetExtLst();

    boolean isSetStyle();

    boolean isSetTxBody();

    boolean isSetUseBgFill();

    void setExtLst(CTExtensionListModify cTExtensionListModify);

    void setNvSpPr(CTShapeNonVisual cTShapeNonVisual);

    void setSpPr(CTShapeProperties cTShapeProperties);

    void setStyle(CTShapeStyle cTShapeStyle);

    void setTxBody(CTTextBody cTTextBody);

    void setUseBgFill(boolean z);

    void unsetExtLst();

    void unsetStyle();

    void unsetTxBody();

    void unsetUseBgFill();

    XmlBoolean xgetUseBgFill();

    void xsetUseBgFill(XmlBoolean xmlBoolean);
}
