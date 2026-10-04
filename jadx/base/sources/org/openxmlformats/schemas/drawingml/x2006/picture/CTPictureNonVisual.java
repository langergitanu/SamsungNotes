package org.openxmlformats.schemas.drawingml.x2006.picture;

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
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualPictureProperties;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTPictureNonVisual extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTPictureNonVisual.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctpicturenonvisual05adtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTPictureNonVisual newInstance() {
            return (CTPictureNonVisual) POIXMLTypeLoader.newInstance(CTPictureNonVisual.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPictureNonVisual.type, null);
        }

        public static CTPictureNonVisual parse(File file) {
            return (CTPictureNonVisual) POIXMLTypeLoader.parse(file, CTPictureNonVisual.type, (XmlOptions) null);
        }

        public static CTPictureNonVisual newInstance(XmlOptions xmlOptions) {
            return (CTPictureNonVisual) POIXMLTypeLoader.newInstance(CTPictureNonVisual.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPictureNonVisual.type, xmlOptions);
        }

        public static CTPictureNonVisual parse(File file, XmlOptions xmlOptions) {
            return (CTPictureNonVisual) POIXMLTypeLoader.parse(file, CTPictureNonVisual.type, xmlOptions);
        }

        public static CTPictureNonVisual parse(InputStream inputStream) {
            return (CTPictureNonVisual) POIXMLTypeLoader.parse(inputStream, CTPictureNonVisual.type, (XmlOptions) null);
        }

        public static CTPictureNonVisual parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTPictureNonVisual) POIXMLTypeLoader.parse(inputStream, CTPictureNonVisual.type, xmlOptions);
        }

        public static CTPictureNonVisual parse(Reader reader) {
            return (CTPictureNonVisual) POIXMLTypeLoader.parse(reader, CTPictureNonVisual.type, (XmlOptions) null);
        }

        public static CTPictureNonVisual parse(Reader reader, XmlOptions xmlOptions) {
            return (CTPictureNonVisual) POIXMLTypeLoader.parse(reader, CTPictureNonVisual.type, xmlOptions);
        }

        public static CTPictureNonVisual parse(String str) {
            return (CTPictureNonVisual) POIXMLTypeLoader.parse(str, CTPictureNonVisual.type, (XmlOptions) null);
        }

        public static CTPictureNonVisual parse(String str, XmlOptions xmlOptions) {
            return (CTPictureNonVisual) POIXMLTypeLoader.parse(str, CTPictureNonVisual.type, xmlOptions);
        }

        public static CTPictureNonVisual parse(URL url) {
            return (CTPictureNonVisual) POIXMLTypeLoader.parse(url, CTPictureNonVisual.type, (XmlOptions) null);
        }

        public static CTPictureNonVisual parse(URL url, XmlOptions xmlOptions) {
            return (CTPictureNonVisual) POIXMLTypeLoader.parse(url, CTPictureNonVisual.type, xmlOptions);
        }

        public static CTPictureNonVisual parse(XMLStreamReader xMLStreamReader) {
            return (CTPictureNonVisual) POIXMLTypeLoader.parse(xMLStreamReader, CTPictureNonVisual.type, (XmlOptions) null);
        }

        public static CTPictureNonVisual parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTPictureNonVisual) POIXMLTypeLoader.parse(xMLStreamReader, CTPictureNonVisual.type, xmlOptions);
        }

        public static CTPictureNonVisual parse(XMLInputStream xMLInputStream) {
            return (CTPictureNonVisual) POIXMLTypeLoader.parse(xMLInputStream, CTPictureNonVisual.type, (XmlOptions) null);
        }

        public static CTPictureNonVisual parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTPictureNonVisual) POIXMLTypeLoader.parse(xMLInputStream, CTPictureNonVisual.type, xmlOptions);
        }

        public static CTPictureNonVisual parse(Node node) {
            return (CTPictureNonVisual) POIXMLTypeLoader.parse(node, CTPictureNonVisual.type, (XmlOptions) null);
        }

        public static CTPictureNonVisual parse(Node node, XmlOptions xmlOptions) {
            return (CTPictureNonVisual) POIXMLTypeLoader.parse(node, CTPictureNonVisual.type, xmlOptions);
        }
    }

    CTNonVisualPictureProperties addNewCNvPicPr();

    CTNonVisualDrawingProps addNewCNvPr();

    CTNonVisualPictureProperties getCNvPicPr();

    CTNonVisualDrawingProps getCNvPr();

    void setCNvPicPr(CTNonVisualPictureProperties cTNonVisualPictureProperties);

    void setCNvPr(CTNonVisualDrawingProps cTNonVisualDrawingProps);
}
