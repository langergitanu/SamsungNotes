package org.openxmlformats.schemas.officeDocument.x2006.customProperties;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTProperties extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTProperties.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctproperties2c18type");

    public static final class Factory {
        private Factory() {
        }

        public static CTProperties newInstance() {
            return (CTProperties) POIXMLTypeLoader.newInstance(CTProperties.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTProperties.type, null);
        }

        public static CTProperties parse(File file) {
            return (CTProperties) POIXMLTypeLoader.parse(file, CTProperties.type, (XmlOptions) null);
        }

        public static CTProperties newInstance(XmlOptions xmlOptions) {
            return (CTProperties) POIXMLTypeLoader.newInstance(CTProperties.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTProperties.type, xmlOptions);
        }

        public static CTProperties parse(File file, XmlOptions xmlOptions) {
            return (CTProperties) POIXMLTypeLoader.parse(file, CTProperties.type, xmlOptions);
        }

        public static CTProperties parse(InputStream inputStream) {
            return (CTProperties) POIXMLTypeLoader.parse(inputStream, CTProperties.type, (XmlOptions) null);
        }

        public static CTProperties parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTProperties) POIXMLTypeLoader.parse(inputStream, CTProperties.type, xmlOptions);
        }

        public static CTProperties parse(Reader reader) {
            return (CTProperties) POIXMLTypeLoader.parse(reader, CTProperties.type, (XmlOptions) null);
        }

        public static CTProperties parse(Reader reader, XmlOptions xmlOptions) {
            return (CTProperties) POIXMLTypeLoader.parse(reader, CTProperties.type, xmlOptions);
        }

        public static CTProperties parse(String str) {
            return (CTProperties) POIXMLTypeLoader.parse(str, CTProperties.type, (XmlOptions) null);
        }

        public static CTProperties parse(String str, XmlOptions xmlOptions) {
            return (CTProperties) POIXMLTypeLoader.parse(str, CTProperties.type, xmlOptions);
        }

        public static CTProperties parse(URL url) {
            return (CTProperties) POIXMLTypeLoader.parse(url, CTProperties.type, (XmlOptions) null);
        }

        public static CTProperties parse(URL url, XmlOptions xmlOptions) {
            return (CTProperties) POIXMLTypeLoader.parse(url, CTProperties.type, xmlOptions);
        }

        public static CTProperties parse(XMLStreamReader xMLStreamReader) {
            return (CTProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTProperties.type, (XmlOptions) null);
        }

        public static CTProperties parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTProperties.type, xmlOptions);
        }

        public static CTProperties parse(XMLInputStream xMLInputStream) {
            return (CTProperties) POIXMLTypeLoader.parse(xMLInputStream, CTProperties.type, (XmlOptions) null);
        }

        public static CTProperties parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTProperties) POIXMLTypeLoader.parse(xMLInputStream, CTProperties.type, xmlOptions);
        }

        public static CTProperties parse(Node node) {
            return (CTProperties) POIXMLTypeLoader.parse(node, CTProperties.type, (XmlOptions) null);
        }

        public static CTProperties parse(Node node, XmlOptions xmlOptions) {
            return (CTProperties) POIXMLTypeLoader.parse(node, CTProperties.type, xmlOptions);
        }
    }

    CTProperty addNewProperty();

    CTProperty getPropertyArray(int i);

    CTProperty[] getPropertyArray();

    List<CTProperty> getPropertyList();

    CTProperty insertNewProperty(int i);

    void removeProperty(int i);

    void setPropertyArray(int i, CTProperty cTProperty);

    void setPropertyArray(CTProperty[] cTPropertyArr);

    int sizeOfPropertyArray();
}
