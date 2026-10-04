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
public interface CTStretchInfoProperties extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTStretchInfoProperties.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctstretchinfopropertiesde57type");

    public static final class Factory {
        private Factory() {
        }

        public static CTStretchInfoProperties newInstance() {
            return (CTStretchInfoProperties) POIXMLTypeLoader.newInstance(CTStretchInfoProperties.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTStretchInfoProperties.type, null);
        }

        public static CTStretchInfoProperties parse(File file) {
            return (CTStretchInfoProperties) POIXMLTypeLoader.parse(file, CTStretchInfoProperties.type, (XmlOptions) null);
        }

        public static CTStretchInfoProperties newInstance(XmlOptions xmlOptions) {
            return (CTStretchInfoProperties) POIXMLTypeLoader.newInstance(CTStretchInfoProperties.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTStretchInfoProperties.type, xmlOptions);
        }

        public static CTStretchInfoProperties parse(File file, XmlOptions xmlOptions) {
            return (CTStretchInfoProperties) POIXMLTypeLoader.parse(file, CTStretchInfoProperties.type, xmlOptions);
        }

        public static CTStretchInfoProperties parse(InputStream inputStream) {
            return (CTStretchInfoProperties) POIXMLTypeLoader.parse(inputStream, CTStretchInfoProperties.type, (XmlOptions) null);
        }

        public static CTStretchInfoProperties parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTStretchInfoProperties) POIXMLTypeLoader.parse(inputStream, CTStretchInfoProperties.type, xmlOptions);
        }

        public static CTStretchInfoProperties parse(Reader reader) {
            return (CTStretchInfoProperties) POIXMLTypeLoader.parse(reader, CTStretchInfoProperties.type, (XmlOptions) null);
        }

        public static CTStretchInfoProperties parse(Reader reader, XmlOptions xmlOptions) {
            return (CTStretchInfoProperties) POIXMLTypeLoader.parse(reader, CTStretchInfoProperties.type, xmlOptions);
        }

        public static CTStretchInfoProperties parse(String str) {
            return (CTStretchInfoProperties) POIXMLTypeLoader.parse(str, CTStretchInfoProperties.type, (XmlOptions) null);
        }

        public static CTStretchInfoProperties parse(String str, XmlOptions xmlOptions) {
            return (CTStretchInfoProperties) POIXMLTypeLoader.parse(str, CTStretchInfoProperties.type, xmlOptions);
        }

        public static CTStretchInfoProperties parse(URL url) {
            return (CTStretchInfoProperties) POIXMLTypeLoader.parse(url, CTStretchInfoProperties.type, (XmlOptions) null);
        }

        public static CTStretchInfoProperties parse(URL url, XmlOptions xmlOptions) {
            return (CTStretchInfoProperties) POIXMLTypeLoader.parse(url, CTStretchInfoProperties.type, xmlOptions);
        }

        public static CTStretchInfoProperties parse(XMLStreamReader xMLStreamReader) {
            return (CTStretchInfoProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTStretchInfoProperties.type, (XmlOptions) null);
        }

        public static CTStretchInfoProperties parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTStretchInfoProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTStretchInfoProperties.type, xmlOptions);
        }

        public static CTStretchInfoProperties parse(XMLInputStream xMLInputStream) {
            return (CTStretchInfoProperties) POIXMLTypeLoader.parse(xMLInputStream, CTStretchInfoProperties.type, (XmlOptions) null);
        }

        public static CTStretchInfoProperties parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTStretchInfoProperties) POIXMLTypeLoader.parse(xMLInputStream, CTStretchInfoProperties.type, xmlOptions);
        }

        public static CTStretchInfoProperties parse(Node node) {
            return (CTStretchInfoProperties) POIXMLTypeLoader.parse(node, CTStretchInfoProperties.type, (XmlOptions) null);
        }

        public static CTStretchInfoProperties parse(Node node, XmlOptions xmlOptions) {
            return (CTStretchInfoProperties) POIXMLTypeLoader.parse(node, CTStretchInfoProperties.type, xmlOptions);
        }
    }

    CTRelativeRect addNewFillRect();

    CTRelativeRect getFillRect();

    boolean isSetFillRect();

    void setFillRect(CTRelativeRect cTRelativeRect);

    void unsetFillRect();
}
