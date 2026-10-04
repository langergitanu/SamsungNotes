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
public interface CTGroupFillProperties extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTGroupFillProperties.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctgroupfillpropertiesec66type");

    public static final class Factory {
        private Factory() {
        }

        public static CTGroupFillProperties newInstance() {
            return (CTGroupFillProperties) POIXMLTypeLoader.newInstance(CTGroupFillProperties.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTGroupFillProperties.type, null);
        }

        public static CTGroupFillProperties parse(File file) {
            return (CTGroupFillProperties) POIXMLTypeLoader.parse(file, CTGroupFillProperties.type, (XmlOptions) null);
        }

        public static CTGroupFillProperties newInstance(XmlOptions xmlOptions) {
            return (CTGroupFillProperties) POIXMLTypeLoader.newInstance(CTGroupFillProperties.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTGroupFillProperties.type, xmlOptions);
        }

        public static CTGroupFillProperties parse(File file, XmlOptions xmlOptions) {
            return (CTGroupFillProperties) POIXMLTypeLoader.parse(file, CTGroupFillProperties.type, xmlOptions);
        }

        public static CTGroupFillProperties parse(InputStream inputStream) {
            return (CTGroupFillProperties) POIXMLTypeLoader.parse(inputStream, CTGroupFillProperties.type, (XmlOptions) null);
        }

        public static CTGroupFillProperties parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTGroupFillProperties) POIXMLTypeLoader.parse(inputStream, CTGroupFillProperties.type, xmlOptions);
        }

        public static CTGroupFillProperties parse(Reader reader) {
            return (CTGroupFillProperties) POIXMLTypeLoader.parse(reader, CTGroupFillProperties.type, (XmlOptions) null);
        }

        public static CTGroupFillProperties parse(Reader reader, XmlOptions xmlOptions) {
            return (CTGroupFillProperties) POIXMLTypeLoader.parse(reader, CTGroupFillProperties.type, xmlOptions);
        }

        public static CTGroupFillProperties parse(String str) {
            return (CTGroupFillProperties) POIXMLTypeLoader.parse(str, CTGroupFillProperties.type, (XmlOptions) null);
        }

        public static CTGroupFillProperties parse(String str, XmlOptions xmlOptions) {
            return (CTGroupFillProperties) POIXMLTypeLoader.parse(str, CTGroupFillProperties.type, xmlOptions);
        }

        public static CTGroupFillProperties parse(URL url) {
            return (CTGroupFillProperties) POIXMLTypeLoader.parse(url, CTGroupFillProperties.type, (XmlOptions) null);
        }

        public static CTGroupFillProperties parse(URL url, XmlOptions xmlOptions) {
            return (CTGroupFillProperties) POIXMLTypeLoader.parse(url, CTGroupFillProperties.type, xmlOptions);
        }

        public static CTGroupFillProperties parse(XMLStreamReader xMLStreamReader) {
            return (CTGroupFillProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTGroupFillProperties.type, (XmlOptions) null);
        }

        public static CTGroupFillProperties parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTGroupFillProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTGroupFillProperties.type, xmlOptions);
        }

        public static CTGroupFillProperties parse(XMLInputStream xMLInputStream) {
            return (CTGroupFillProperties) POIXMLTypeLoader.parse(xMLInputStream, CTGroupFillProperties.type, (XmlOptions) null);
        }

        public static CTGroupFillProperties parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTGroupFillProperties) POIXMLTypeLoader.parse(xMLInputStream, CTGroupFillProperties.type, xmlOptions);
        }

        public static CTGroupFillProperties parse(Node node) {
            return (CTGroupFillProperties) POIXMLTypeLoader.parse(node, CTGroupFillProperties.type, (XmlOptions) null);
        }

        public static CTGroupFillProperties parse(Node node, XmlOptions xmlOptions) {
            return (CTGroupFillProperties) POIXMLTypeLoader.parse(node, CTGroupFillProperties.type, xmlOptions);
        }
    }
}
