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
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualConnectorProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTConnectorNonVisual extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTConnectorNonVisual.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctconnectornonvisual0f45type");

    public static final class Factory {
        private Factory() {
        }

        public static CTConnectorNonVisual newInstance() {
            return (CTConnectorNonVisual) POIXMLTypeLoader.newInstance(CTConnectorNonVisual.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTConnectorNonVisual.type, null);
        }

        public static CTConnectorNonVisual parse(File file) {
            return (CTConnectorNonVisual) POIXMLTypeLoader.parse(file, CTConnectorNonVisual.type, (XmlOptions) null);
        }

        public static CTConnectorNonVisual newInstance(XmlOptions xmlOptions) {
            return (CTConnectorNonVisual) POIXMLTypeLoader.newInstance(CTConnectorNonVisual.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTConnectorNonVisual.type, xmlOptions);
        }

        public static CTConnectorNonVisual parse(File file, XmlOptions xmlOptions) {
            return (CTConnectorNonVisual) POIXMLTypeLoader.parse(file, CTConnectorNonVisual.type, xmlOptions);
        }

        public static CTConnectorNonVisual parse(InputStream inputStream) {
            return (CTConnectorNonVisual) POIXMLTypeLoader.parse(inputStream, CTConnectorNonVisual.type, (XmlOptions) null);
        }

        public static CTConnectorNonVisual parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTConnectorNonVisual) POIXMLTypeLoader.parse(inputStream, CTConnectorNonVisual.type, xmlOptions);
        }

        public static CTConnectorNonVisual parse(Reader reader) {
            return (CTConnectorNonVisual) POIXMLTypeLoader.parse(reader, CTConnectorNonVisual.type, (XmlOptions) null);
        }

        public static CTConnectorNonVisual parse(Reader reader, XmlOptions xmlOptions) {
            return (CTConnectorNonVisual) POIXMLTypeLoader.parse(reader, CTConnectorNonVisual.type, xmlOptions);
        }

        public static CTConnectorNonVisual parse(String str) {
            return (CTConnectorNonVisual) POIXMLTypeLoader.parse(str, CTConnectorNonVisual.type, (XmlOptions) null);
        }

        public static CTConnectorNonVisual parse(String str, XmlOptions xmlOptions) {
            return (CTConnectorNonVisual) POIXMLTypeLoader.parse(str, CTConnectorNonVisual.type, xmlOptions);
        }

        public static CTConnectorNonVisual parse(URL url) {
            return (CTConnectorNonVisual) POIXMLTypeLoader.parse(url, CTConnectorNonVisual.type, (XmlOptions) null);
        }

        public static CTConnectorNonVisual parse(URL url, XmlOptions xmlOptions) {
            return (CTConnectorNonVisual) POIXMLTypeLoader.parse(url, CTConnectorNonVisual.type, xmlOptions);
        }

        public static CTConnectorNonVisual parse(XMLStreamReader xMLStreamReader) {
            return (CTConnectorNonVisual) POIXMLTypeLoader.parse(xMLStreamReader, CTConnectorNonVisual.type, (XmlOptions) null);
        }

        public static CTConnectorNonVisual parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTConnectorNonVisual) POIXMLTypeLoader.parse(xMLStreamReader, CTConnectorNonVisual.type, xmlOptions);
        }

        public static CTConnectorNonVisual parse(XMLInputStream xMLInputStream) {
            return (CTConnectorNonVisual) POIXMLTypeLoader.parse(xMLInputStream, CTConnectorNonVisual.type, (XmlOptions) null);
        }

        public static CTConnectorNonVisual parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTConnectorNonVisual) POIXMLTypeLoader.parse(xMLInputStream, CTConnectorNonVisual.type, xmlOptions);
        }

        public static CTConnectorNonVisual parse(Node node) {
            return (CTConnectorNonVisual) POIXMLTypeLoader.parse(node, CTConnectorNonVisual.type, (XmlOptions) null);
        }

        public static CTConnectorNonVisual parse(Node node, XmlOptions xmlOptions) {
            return (CTConnectorNonVisual) POIXMLTypeLoader.parse(node, CTConnectorNonVisual.type, xmlOptions);
        }
    }

    CTNonVisualConnectorProperties addNewCNvCxnSpPr();

    CTNonVisualDrawingProps addNewCNvPr();

    CTApplicationNonVisualDrawingProps addNewNvPr();

    CTNonVisualConnectorProperties getCNvCxnSpPr();

    CTNonVisualDrawingProps getCNvPr();

    CTApplicationNonVisualDrawingProps getNvPr();

    void setCNvCxnSpPr(CTNonVisualConnectorProperties cTNonVisualConnectorProperties);

    void setCNvPr(CTNonVisualDrawingProps cTNonVisualDrawingProps);

    void setNvPr(CTApplicationNonVisualDrawingProps cTApplicationNonVisualDrawingProps);
}
