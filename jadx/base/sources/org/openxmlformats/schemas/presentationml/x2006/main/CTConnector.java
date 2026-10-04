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
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeStyle;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTConnector extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTConnector.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctconnector3522type");

    public static final class Factory {
        private Factory() {
        }

        public static CTConnector newInstance() {
            return (CTConnector) POIXMLTypeLoader.newInstance(CTConnector.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTConnector.type, null);
        }

        public static CTConnector parse(File file) {
            return (CTConnector) POIXMLTypeLoader.parse(file, CTConnector.type, (XmlOptions) null);
        }

        public static CTConnector newInstance(XmlOptions xmlOptions) {
            return (CTConnector) POIXMLTypeLoader.newInstance(CTConnector.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTConnector.type, xmlOptions);
        }

        public static CTConnector parse(File file, XmlOptions xmlOptions) {
            return (CTConnector) POIXMLTypeLoader.parse(file, CTConnector.type, xmlOptions);
        }

        public static CTConnector parse(InputStream inputStream) {
            return (CTConnector) POIXMLTypeLoader.parse(inputStream, CTConnector.type, (XmlOptions) null);
        }

        public static CTConnector parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTConnector) POIXMLTypeLoader.parse(inputStream, CTConnector.type, xmlOptions);
        }

        public static CTConnector parse(Reader reader) {
            return (CTConnector) POIXMLTypeLoader.parse(reader, CTConnector.type, (XmlOptions) null);
        }

        public static CTConnector parse(Reader reader, XmlOptions xmlOptions) {
            return (CTConnector) POIXMLTypeLoader.parse(reader, CTConnector.type, xmlOptions);
        }

        public static CTConnector parse(String str) {
            return (CTConnector) POIXMLTypeLoader.parse(str, CTConnector.type, (XmlOptions) null);
        }

        public static CTConnector parse(String str, XmlOptions xmlOptions) {
            return (CTConnector) POIXMLTypeLoader.parse(str, CTConnector.type, xmlOptions);
        }

        public static CTConnector parse(URL url) {
            return (CTConnector) POIXMLTypeLoader.parse(url, CTConnector.type, (XmlOptions) null);
        }

        public static CTConnector parse(URL url, XmlOptions xmlOptions) {
            return (CTConnector) POIXMLTypeLoader.parse(url, CTConnector.type, xmlOptions);
        }

        public static CTConnector parse(XMLStreamReader xMLStreamReader) {
            return (CTConnector) POIXMLTypeLoader.parse(xMLStreamReader, CTConnector.type, (XmlOptions) null);
        }

        public static CTConnector parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTConnector) POIXMLTypeLoader.parse(xMLStreamReader, CTConnector.type, xmlOptions);
        }

        public static CTConnector parse(XMLInputStream xMLInputStream) {
            return (CTConnector) POIXMLTypeLoader.parse(xMLInputStream, CTConnector.type, (XmlOptions) null);
        }

        public static CTConnector parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTConnector) POIXMLTypeLoader.parse(xMLInputStream, CTConnector.type, xmlOptions);
        }

        public static CTConnector parse(Node node) {
            return (CTConnector) POIXMLTypeLoader.parse(node, CTConnector.type, (XmlOptions) null);
        }

        public static CTConnector parse(Node node, XmlOptions xmlOptions) {
            return (CTConnector) POIXMLTypeLoader.parse(node, CTConnector.type, xmlOptions);
        }
    }

    CTExtensionListModify addNewExtLst();

    CTConnectorNonVisual addNewNvCxnSpPr();

    CTShapeProperties addNewSpPr();

    CTShapeStyle addNewStyle();

    CTExtensionListModify getExtLst();

    CTConnectorNonVisual getNvCxnSpPr();

    CTShapeProperties getSpPr();

    CTShapeStyle getStyle();

    boolean isSetExtLst();

    boolean isSetStyle();

    void setExtLst(CTExtensionListModify cTExtensionListModify);

    void setNvCxnSpPr(CTConnectorNonVisual cTConnectorNonVisual);

    void setSpPr(CTShapeProperties cTShapeProperties);

    void setStyle(CTShapeStyle cTShapeStyle);

    void unsetExtLst();

    void unsetStyle();
}
