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
public interface CTNonVisualGraphicFrameProperties extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTNonVisualGraphicFrameProperties.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctnonvisualgraphicframeproperties43b6type");

    public static final class Factory {
        private Factory() {
        }

        public static CTNonVisualGraphicFrameProperties newInstance() {
            return (CTNonVisualGraphicFrameProperties) POIXMLTypeLoader.newInstance(CTNonVisualGraphicFrameProperties.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTNonVisualGraphicFrameProperties.type, null);
        }

        public static CTNonVisualGraphicFrameProperties parse(File file) {
            return (CTNonVisualGraphicFrameProperties) POIXMLTypeLoader.parse(file, CTNonVisualGraphicFrameProperties.type, (XmlOptions) null);
        }

        public static CTNonVisualGraphicFrameProperties newInstance(XmlOptions xmlOptions) {
            return (CTNonVisualGraphicFrameProperties) POIXMLTypeLoader.newInstance(CTNonVisualGraphicFrameProperties.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTNonVisualGraphicFrameProperties.type, xmlOptions);
        }

        public static CTNonVisualGraphicFrameProperties parse(File file, XmlOptions xmlOptions) {
            return (CTNonVisualGraphicFrameProperties) POIXMLTypeLoader.parse(file, CTNonVisualGraphicFrameProperties.type, xmlOptions);
        }

        public static CTNonVisualGraphicFrameProperties parse(InputStream inputStream) {
            return (CTNonVisualGraphicFrameProperties) POIXMLTypeLoader.parse(inputStream, CTNonVisualGraphicFrameProperties.type, (XmlOptions) null);
        }

        public static CTNonVisualGraphicFrameProperties parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTNonVisualGraphicFrameProperties) POIXMLTypeLoader.parse(inputStream, CTNonVisualGraphicFrameProperties.type, xmlOptions);
        }

        public static CTNonVisualGraphicFrameProperties parse(Reader reader) {
            return (CTNonVisualGraphicFrameProperties) POIXMLTypeLoader.parse(reader, CTNonVisualGraphicFrameProperties.type, (XmlOptions) null);
        }

        public static CTNonVisualGraphicFrameProperties parse(Reader reader, XmlOptions xmlOptions) {
            return (CTNonVisualGraphicFrameProperties) POIXMLTypeLoader.parse(reader, CTNonVisualGraphicFrameProperties.type, xmlOptions);
        }

        public static CTNonVisualGraphicFrameProperties parse(String str) {
            return (CTNonVisualGraphicFrameProperties) POIXMLTypeLoader.parse(str, CTNonVisualGraphicFrameProperties.type, (XmlOptions) null);
        }

        public static CTNonVisualGraphicFrameProperties parse(String str, XmlOptions xmlOptions) {
            return (CTNonVisualGraphicFrameProperties) POIXMLTypeLoader.parse(str, CTNonVisualGraphicFrameProperties.type, xmlOptions);
        }

        public static CTNonVisualGraphicFrameProperties parse(URL url) {
            return (CTNonVisualGraphicFrameProperties) POIXMLTypeLoader.parse(url, CTNonVisualGraphicFrameProperties.type, (XmlOptions) null);
        }

        public static CTNonVisualGraphicFrameProperties parse(URL url, XmlOptions xmlOptions) {
            return (CTNonVisualGraphicFrameProperties) POIXMLTypeLoader.parse(url, CTNonVisualGraphicFrameProperties.type, xmlOptions);
        }

        public static CTNonVisualGraphicFrameProperties parse(XMLStreamReader xMLStreamReader) {
            return (CTNonVisualGraphicFrameProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTNonVisualGraphicFrameProperties.type, (XmlOptions) null);
        }

        public static CTNonVisualGraphicFrameProperties parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTNonVisualGraphicFrameProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTNonVisualGraphicFrameProperties.type, xmlOptions);
        }

        public static CTNonVisualGraphicFrameProperties parse(XMLInputStream xMLInputStream) {
            return (CTNonVisualGraphicFrameProperties) POIXMLTypeLoader.parse(xMLInputStream, CTNonVisualGraphicFrameProperties.type, (XmlOptions) null);
        }

        public static CTNonVisualGraphicFrameProperties parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTNonVisualGraphicFrameProperties) POIXMLTypeLoader.parse(xMLInputStream, CTNonVisualGraphicFrameProperties.type, xmlOptions);
        }

        public static CTNonVisualGraphicFrameProperties parse(Node node) {
            return (CTNonVisualGraphicFrameProperties) POIXMLTypeLoader.parse(node, CTNonVisualGraphicFrameProperties.type, (XmlOptions) null);
        }

        public static CTNonVisualGraphicFrameProperties parse(Node node, XmlOptions xmlOptions) {
            return (CTNonVisualGraphicFrameProperties) POIXMLTypeLoader.parse(node, CTNonVisualGraphicFrameProperties.type, xmlOptions);
        }
    }

    CTOfficeArtExtensionList addNewExtLst();

    CTGraphicalObjectFrameLocking addNewGraphicFrameLocks();

    CTOfficeArtExtensionList getExtLst();

    CTGraphicalObjectFrameLocking getGraphicFrameLocks();

    boolean isSetExtLst();

    boolean isSetGraphicFrameLocks();

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setGraphicFrameLocks(CTGraphicalObjectFrameLocking cTGraphicalObjectFrameLocking);

    void unsetExtLst();

    void unsetGraphicFrameLocks();
}
