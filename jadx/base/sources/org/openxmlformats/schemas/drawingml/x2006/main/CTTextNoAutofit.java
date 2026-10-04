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
public interface CTTextNoAutofit extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTextNoAutofit.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttextnoautofit1045type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextNoAutofit newInstance() {
            return (CTTextNoAutofit) POIXMLTypeLoader.newInstance(CTTextNoAutofit.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextNoAutofit.type, null);
        }

        public static CTTextNoAutofit parse(File file) {
            return (CTTextNoAutofit) POIXMLTypeLoader.parse(file, CTTextNoAutofit.type, (XmlOptions) null);
        }

        public static CTTextNoAutofit newInstance(XmlOptions xmlOptions) {
            return (CTTextNoAutofit) POIXMLTypeLoader.newInstance(CTTextNoAutofit.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextNoAutofit.type, xmlOptions);
        }

        public static CTTextNoAutofit parse(File file, XmlOptions xmlOptions) {
            return (CTTextNoAutofit) POIXMLTypeLoader.parse(file, CTTextNoAutofit.type, xmlOptions);
        }

        public static CTTextNoAutofit parse(InputStream inputStream) {
            return (CTTextNoAutofit) POIXMLTypeLoader.parse(inputStream, CTTextNoAutofit.type, (XmlOptions) null);
        }

        public static CTTextNoAutofit parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTextNoAutofit) POIXMLTypeLoader.parse(inputStream, CTTextNoAutofit.type, xmlOptions);
        }

        public static CTTextNoAutofit parse(Reader reader) {
            return (CTTextNoAutofit) POIXMLTypeLoader.parse(reader, CTTextNoAutofit.type, (XmlOptions) null);
        }

        public static CTTextNoAutofit parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTextNoAutofit) POIXMLTypeLoader.parse(reader, CTTextNoAutofit.type, xmlOptions);
        }

        public static CTTextNoAutofit parse(String str) {
            return (CTTextNoAutofit) POIXMLTypeLoader.parse(str, CTTextNoAutofit.type, (XmlOptions) null);
        }

        public static CTTextNoAutofit parse(String str, XmlOptions xmlOptions) {
            return (CTTextNoAutofit) POIXMLTypeLoader.parse(str, CTTextNoAutofit.type, xmlOptions);
        }

        public static CTTextNoAutofit parse(URL url) {
            return (CTTextNoAutofit) POIXMLTypeLoader.parse(url, CTTextNoAutofit.type, (XmlOptions) null);
        }

        public static CTTextNoAutofit parse(URL url, XmlOptions xmlOptions) {
            return (CTTextNoAutofit) POIXMLTypeLoader.parse(url, CTTextNoAutofit.type, xmlOptions);
        }

        public static CTTextNoAutofit parse(XMLStreamReader xMLStreamReader) {
            return (CTTextNoAutofit) POIXMLTypeLoader.parse(xMLStreamReader, CTTextNoAutofit.type, (XmlOptions) null);
        }

        public static CTTextNoAutofit parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTextNoAutofit) POIXMLTypeLoader.parse(xMLStreamReader, CTTextNoAutofit.type, xmlOptions);
        }

        public static CTTextNoAutofit parse(XMLInputStream xMLInputStream) {
            return (CTTextNoAutofit) POIXMLTypeLoader.parse(xMLInputStream, CTTextNoAutofit.type, (XmlOptions) null);
        }

        public static CTTextNoAutofit parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTextNoAutofit) POIXMLTypeLoader.parse(xMLInputStream, CTTextNoAutofit.type, xmlOptions);
        }

        public static CTTextNoAutofit parse(Node node) {
            return (CTTextNoAutofit) POIXMLTypeLoader.parse(node, CTTextNoAutofit.type, (XmlOptions) null);
        }

        public static CTTextNoAutofit parse(Node node, XmlOptions xmlOptions) {
            return (CTTextNoAutofit) POIXMLTypeLoader.parse(node, CTTextNoAutofit.type, xmlOptions);
        }
    }
}
