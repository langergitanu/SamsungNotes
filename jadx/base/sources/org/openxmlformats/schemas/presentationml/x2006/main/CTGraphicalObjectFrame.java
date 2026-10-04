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
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTGraphicalObjectFrame extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTGraphicalObjectFrame.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctgraphicalobjectframebfeatype");

    public static final class Factory {
        private Factory() {
        }

        public static CTGraphicalObjectFrame newInstance() {
            return (CTGraphicalObjectFrame) POIXMLTypeLoader.newInstance(CTGraphicalObjectFrame.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTGraphicalObjectFrame.type, null);
        }

        public static CTGraphicalObjectFrame parse(File file) {
            return (CTGraphicalObjectFrame) POIXMLTypeLoader.parse(file, CTGraphicalObjectFrame.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrame newInstance(XmlOptions xmlOptions) {
            return (CTGraphicalObjectFrame) POIXMLTypeLoader.newInstance(CTGraphicalObjectFrame.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTGraphicalObjectFrame.type, xmlOptions);
        }

        public static CTGraphicalObjectFrame parse(File file, XmlOptions xmlOptions) {
            return (CTGraphicalObjectFrame) POIXMLTypeLoader.parse(file, CTGraphicalObjectFrame.type, xmlOptions);
        }

        public static CTGraphicalObjectFrame parse(InputStream inputStream) {
            return (CTGraphicalObjectFrame) POIXMLTypeLoader.parse(inputStream, CTGraphicalObjectFrame.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrame parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTGraphicalObjectFrame) POIXMLTypeLoader.parse(inputStream, CTGraphicalObjectFrame.type, xmlOptions);
        }

        public static CTGraphicalObjectFrame parse(Reader reader) {
            return (CTGraphicalObjectFrame) POIXMLTypeLoader.parse(reader, CTGraphicalObjectFrame.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrame parse(Reader reader, XmlOptions xmlOptions) {
            return (CTGraphicalObjectFrame) POIXMLTypeLoader.parse(reader, CTGraphicalObjectFrame.type, xmlOptions);
        }

        public static CTGraphicalObjectFrame parse(String str) {
            return (CTGraphicalObjectFrame) POIXMLTypeLoader.parse(str, CTGraphicalObjectFrame.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrame parse(String str, XmlOptions xmlOptions) {
            return (CTGraphicalObjectFrame) POIXMLTypeLoader.parse(str, CTGraphicalObjectFrame.type, xmlOptions);
        }

        public static CTGraphicalObjectFrame parse(URL url) {
            return (CTGraphicalObjectFrame) POIXMLTypeLoader.parse(url, CTGraphicalObjectFrame.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrame parse(URL url, XmlOptions xmlOptions) {
            return (CTGraphicalObjectFrame) POIXMLTypeLoader.parse(url, CTGraphicalObjectFrame.type, xmlOptions);
        }

        public static CTGraphicalObjectFrame parse(XMLStreamReader xMLStreamReader) {
            return (CTGraphicalObjectFrame) POIXMLTypeLoader.parse(xMLStreamReader, CTGraphicalObjectFrame.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrame parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTGraphicalObjectFrame) POIXMLTypeLoader.parse(xMLStreamReader, CTGraphicalObjectFrame.type, xmlOptions);
        }

        public static CTGraphicalObjectFrame parse(XMLInputStream xMLInputStream) {
            return (CTGraphicalObjectFrame) POIXMLTypeLoader.parse(xMLInputStream, CTGraphicalObjectFrame.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrame parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTGraphicalObjectFrame) POIXMLTypeLoader.parse(xMLInputStream, CTGraphicalObjectFrame.type, xmlOptions);
        }

        public static CTGraphicalObjectFrame parse(Node node) {
            return (CTGraphicalObjectFrame) POIXMLTypeLoader.parse(node, CTGraphicalObjectFrame.type, (XmlOptions) null);
        }

        public static CTGraphicalObjectFrame parse(Node node, XmlOptions xmlOptions) {
            return (CTGraphicalObjectFrame) POIXMLTypeLoader.parse(node, CTGraphicalObjectFrame.type, xmlOptions);
        }
    }

    CTExtensionListModify addNewExtLst();

    CTGraphicalObject addNewGraphic();

    CTGraphicalObjectFrameNonVisual addNewNvGraphicFramePr();

    CTTransform2D addNewXfrm();

    CTExtensionListModify getExtLst();

    CTGraphicalObject getGraphic();

    CTGraphicalObjectFrameNonVisual getNvGraphicFramePr();

    CTTransform2D getXfrm();

    boolean isSetExtLst();

    void setExtLst(CTExtensionListModify cTExtensionListModify);

    void setGraphic(CTGraphicalObject cTGraphicalObject);

    void setNvGraphicFramePr(CTGraphicalObjectFrameNonVisual cTGraphicalObjectFrameNonVisual);

    void setXfrm(CTTransform2D cTTransform2D);

    void unsetExtLst();
}
