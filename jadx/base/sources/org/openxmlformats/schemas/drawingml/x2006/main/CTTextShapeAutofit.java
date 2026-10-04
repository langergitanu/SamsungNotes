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
public interface CTTextShapeAutofit extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTextShapeAutofit.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttextshapeautofita009type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextShapeAutofit newInstance() {
            return (CTTextShapeAutofit) POIXMLTypeLoader.newInstance(CTTextShapeAutofit.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextShapeAutofit.type, null);
        }

        public static CTTextShapeAutofit parse(File file) {
            return (CTTextShapeAutofit) POIXMLTypeLoader.parse(file, CTTextShapeAutofit.type, (XmlOptions) null);
        }

        public static CTTextShapeAutofit newInstance(XmlOptions xmlOptions) {
            return (CTTextShapeAutofit) POIXMLTypeLoader.newInstance(CTTextShapeAutofit.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextShapeAutofit.type, xmlOptions);
        }

        public static CTTextShapeAutofit parse(File file, XmlOptions xmlOptions) {
            return (CTTextShapeAutofit) POIXMLTypeLoader.parse(file, CTTextShapeAutofit.type, xmlOptions);
        }

        public static CTTextShapeAutofit parse(InputStream inputStream) {
            return (CTTextShapeAutofit) POIXMLTypeLoader.parse(inputStream, CTTextShapeAutofit.type, (XmlOptions) null);
        }

        public static CTTextShapeAutofit parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTextShapeAutofit) POIXMLTypeLoader.parse(inputStream, CTTextShapeAutofit.type, xmlOptions);
        }

        public static CTTextShapeAutofit parse(Reader reader) {
            return (CTTextShapeAutofit) POIXMLTypeLoader.parse(reader, CTTextShapeAutofit.type, (XmlOptions) null);
        }

        public static CTTextShapeAutofit parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTextShapeAutofit) POIXMLTypeLoader.parse(reader, CTTextShapeAutofit.type, xmlOptions);
        }

        public static CTTextShapeAutofit parse(String str) {
            return (CTTextShapeAutofit) POIXMLTypeLoader.parse(str, CTTextShapeAutofit.type, (XmlOptions) null);
        }

        public static CTTextShapeAutofit parse(String str, XmlOptions xmlOptions) {
            return (CTTextShapeAutofit) POIXMLTypeLoader.parse(str, CTTextShapeAutofit.type, xmlOptions);
        }

        public static CTTextShapeAutofit parse(URL url) {
            return (CTTextShapeAutofit) POIXMLTypeLoader.parse(url, CTTextShapeAutofit.type, (XmlOptions) null);
        }

        public static CTTextShapeAutofit parse(URL url, XmlOptions xmlOptions) {
            return (CTTextShapeAutofit) POIXMLTypeLoader.parse(url, CTTextShapeAutofit.type, xmlOptions);
        }

        public static CTTextShapeAutofit parse(XMLStreamReader xMLStreamReader) {
            return (CTTextShapeAutofit) POIXMLTypeLoader.parse(xMLStreamReader, CTTextShapeAutofit.type, (XmlOptions) null);
        }

        public static CTTextShapeAutofit parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTextShapeAutofit) POIXMLTypeLoader.parse(xMLStreamReader, CTTextShapeAutofit.type, xmlOptions);
        }

        public static CTTextShapeAutofit parse(XMLInputStream xMLInputStream) {
            return (CTTextShapeAutofit) POIXMLTypeLoader.parse(xMLInputStream, CTTextShapeAutofit.type, (XmlOptions) null);
        }

        public static CTTextShapeAutofit parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTextShapeAutofit) POIXMLTypeLoader.parse(xMLInputStream, CTTextShapeAutofit.type, xmlOptions);
        }

        public static CTTextShapeAutofit parse(Node node) {
            return (CTTextShapeAutofit) POIXMLTypeLoader.parse(node, CTTextShapeAutofit.type, (XmlOptions) null);
        }

        public static CTTextShapeAutofit parse(Node node, XmlOptions xmlOptions) {
            return (CTTextShapeAutofit) POIXMLTypeLoader.parse(node, CTTextShapeAutofit.type, xmlOptions);
        }
    }
}
