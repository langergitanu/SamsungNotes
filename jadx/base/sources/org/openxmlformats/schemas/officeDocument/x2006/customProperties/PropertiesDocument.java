package org.openxmlformats.schemas.officeDocument.x2006.customProperties;

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
public interface PropertiesDocument extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(PropertiesDocument.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "properties288cdoctype");

    public static final class Factory {
        private Factory() {
        }

        public static PropertiesDocument newInstance() {
            return (PropertiesDocument) POIXMLTypeLoader.newInstance(PropertiesDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, PropertiesDocument.type, null);
        }

        public static PropertiesDocument parse(File file) {
            return (PropertiesDocument) POIXMLTypeLoader.parse(file, PropertiesDocument.type, (XmlOptions) null);
        }

        public static PropertiesDocument newInstance(XmlOptions xmlOptions) {
            return (PropertiesDocument) POIXMLTypeLoader.newInstance(PropertiesDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, PropertiesDocument.type, xmlOptions);
        }

        public static PropertiesDocument parse(File file, XmlOptions xmlOptions) {
            return (PropertiesDocument) POIXMLTypeLoader.parse(file, PropertiesDocument.type, xmlOptions);
        }

        public static PropertiesDocument parse(InputStream inputStream) {
            return (PropertiesDocument) POIXMLTypeLoader.parse(inputStream, PropertiesDocument.type, (XmlOptions) null);
        }

        public static PropertiesDocument parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (PropertiesDocument) POIXMLTypeLoader.parse(inputStream, PropertiesDocument.type, xmlOptions);
        }

        public static PropertiesDocument parse(Reader reader) {
            return (PropertiesDocument) POIXMLTypeLoader.parse(reader, PropertiesDocument.type, (XmlOptions) null);
        }

        public static PropertiesDocument parse(Reader reader, XmlOptions xmlOptions) {
            return (PropertiesDocument) POIXMLTypeLoader.parse(reader, PropertiesDocument.type, xmlOptions);
        }

        public static PropertiesDocument parse(String str) {
            return (PropertiesDocument) POIXMLTypeLoader.parse(str, PropertiesDocument.type, (XmlOptions) null);
        }

        public static PropertiesDocument parse(String str, XmlOptions xmlOptions) {
            return (PropertiesDocument) POIXMLTypeLoader.parse(str, PropertiesDocument.type, xmlOptions);
        }

        public static PropertiesDocument parse(URL url) {
            return (PropertiesDocument) POIXMLTypeLoader.parse(url, PropertiesDocument.type, (XmlOptions) null);
        }

        public static PropertiesDocument parse(URL url, XmlOptions xmlOptions) {
            return (PropertiesDocument) POIXMLTypeLoader.parse(url, PropertiesDocument.type, xmlOptions);
        }

        public static PropertiesDocument parse(XMLStreamReader xMLStreamReader) {
            return (PropertiesDocument) POIXMLTypeLoader.parse(xMLStreamReader, PropertiesDocument.type, (XmlOptions) null);
        }

        public static PropertiesDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (PropertiesDocument) POIXMLTypeLoader.parse(xMLStreamReader, PropertiesDocument.type, xmlOptions);
        }

        public static PropertiesDocument parse(XMLInputStream xMLInputStream) {
            return (PropertiesDocument) POIXMLTypeLoader.parse(xMLInputStream, PropertiesDocument.type, (XmlOptions) null);
        }

        public static PropertiesDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (PropertiesDocument) POIXMLTypeLoader.parse(xMLInputStream, PropertiesDocument.type, xmlOptions);
        }

        public static PropertiesDocument parse(Node node) {
            return (PropertiesDocument) POIXMLTypeLoader.parse(node, PropertiesDocument.type, (XmlOptions) null);
        }

        public static PropertiesDocument parse(Node node, XmlOptions xmlOptions) {
            return (PropertiesDocument) POIXMLTypeLoader.parse(node, PropertiesDocument.type, xmlOptions);
        }
    }

    CTProperties addNewProperties();

    CTProperties getProperties();

    void setProperties(CTProperties cTProperties);
}
