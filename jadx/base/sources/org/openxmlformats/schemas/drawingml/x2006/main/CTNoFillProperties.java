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
public interface CTNoFillProperties extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTNoFillProperties.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctnofillpropertiesbf92type");

    public static final class Factory {
        private Factory() {
        }

        public static CTNoFillProperties newInstance() {
            return (CTNoFillProperties) POIXMLTypeLoader.newInstance(CTNoFillProperties.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTNoFillProperties.type, null);
        }

        public static CTNoFillProperties parse(File file) {
            return (CTNoFillProperties) POIXMLTypeLoader.parse(file, CTNoFillProperties.type, (XmlOptions) null);
        }

        public static CTNoFillProperties newInstance(XmlOptions xmlOptions) {
            return (CTNoFillProperties) POIXMLTypeLoader.newInstance(CTNoFillProperties.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTNoFillProperties.type, xmlOptions);
        }

        public static CTNoFillProperties parse(File file, XmlOptions xmlOptions) {
            return (CTNoFillProperties) POIXMLTypeLoader.parse(file, CTNoFillProperties.type, xmlOptions);
        }

        public static CTNoFillProperties parse(InputStream inputStream) {
            return (CTNoFillProperties) POIXMLTypeLoader.parse(inputStream, CTNoFillProperties.type, (XmlOptions) null);
        }

        public static CTNoFillProperties parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTNoFillProperties) POIXMLTypeLoader.parse(inputStream, CTNoFillProperties.type, xmlOptions);
        }

        public static CTNoFillProperties parse(Reader reader) {
            return (CTNoFillProperties) POIXMLTypeLoader.parse(reader, CTNoFillProperties.type, (XmlOptions) null);
        }

        public static CTNoFillProperties parse(Reader reader, XmlOptions xmlOptions) {
            return (CTNoFillProperties) POIXMLTypeLoader.parse(reader, CTNoFillProperties.type, xmlOptions);
        }

        public static CTNoFillProperties parse(String str) {
            return (CTNoFillProperties) POIXMLTypeLoader.parse(str, CTNoFillProperties.type, (XmlOptions) null);
        }

        public static CTNoFillProperties parse(String str, XmlOptions xmlOptions) {
            return (CTNoFillProperties) POIXMLTypeLoader.parse(str, CTNoFillProperties.type, xmlOptions);
        }

        public static CTNoFillProperties parse(URL url) {
            return (CTNoFillProperties) POIXMLTypeLoader.parse(url, CTNoFillProperties.type, (XmlOptions) null);
        }

        public static CTNoFillProperties parse(URL url, XmlOptions xmlOptions) {
            return (CTNoFillProperties) POIXMLTypeLoader.parse(url, CTNoFillProperties.type, xmlOptions);
        }

        public static CTNoFillProperties parse(XMLStreamReader xMLStreamReader) {
            return (CTNoFillProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTNoFillProperties.type, (XmlOptions) null);
        }

        public static CTNoFillProperties parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTNoFillProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTNoFillProperties.type, xmlOptions);
        }

        public static CTNoFillProperties parse(XMLInputStream xMLInputStream) {
            return (CTNoFillProperties) POIXMLTypeLoader.parse(xMLInputStream, CTNoFillProperties.type, (XmlOptions) null);
        }

        public static CTNoFillProperties parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTNoFillProperties) POIXMLTypeLoader.parse(xMLInputStream, CTNoFillProperties.type, xmlOptions);
        }

        public static CTNoFillProperties parse(Node node) {
            return (CTNoFillProperties) POIXMLTypeLoader.parse(node, CTNoFillProperties.type, (XmlOptions) null);
        }

        public static CTNoFillProperties parse(Node node, XmlOptions xmlOptions) {
            return (CTNoFillProperties) POIXMLTypeLoader.parse(node, CTNoFillProperties.type, xmlOptions);
        }
    }
}
