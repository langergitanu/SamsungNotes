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
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTOfficeArtExtension extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTOfficeArtExtension.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctofficeartextension8e53type");

    public static final class Factory {
        private Factory() {
        }

        public static CTOfficeArtExtension newInstance() {
            return (CTOfficeArtExtension) POIXMLTypeLoader.newInstance(CTOfficeArtExtension.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTOfficeArtExtension.type, null);
        }

        public static CTOfficeArtExtension parse(File file) {
            return (CTOfficeArtExtension) POIXMLTypeLoader.parse(file, CTOfficeArtExtension.type, (XmlOptions) null);
        }

        public static CTOfficeArtExtension newInstance(XmlOptions xmlOptions) {
            return (CTOfficeArtExtension) POIXMLTypeLoader.newInstance(CTOfficeArtExtension.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTOfficeArtExtension.type, xmlOptions);
        }

        public static CTOfficeArtExtension parse(File file, XmlOptions xmlOptions) {
            return (CTOfficeArtExtension) POIXMLTypeLoader.parse(file, CTOfficeArtExtension.type, xmlOptions);
        }

        public static CTOfficeArtExtension parse(InputStream inputStream) {
            return (CTOfficeArtExtension) POIXMLTypeLoader.parse(inputStream, CTOfficeArtExtension.type, (XmlOptions) null);
        }

        public static CTOfficeArtExtension parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTOfficeArtExtension) POIXMLTypeLoader.parse(inputStream, CTOfficeArtExtension.type, xmlOptions);
        }

        public static CTOfficeArtExtension parse(Reader reader) {
            return (CTOfficeArtExtension) POIXMLTypeLoader.parse(reader, CTOfficeArtExtension.type, (XmlOptions) null);
        }

        public static CTOfficeArtExtension parse(Reader reader, XmlOptions xmlOptions) {
            return (CTOfficeArtExtension) POIXMLTypeLoader.parse(reader, CTOfficeArtExtension.type, xmlOptions);
        }

        public static CTOfficeArtExtension parse(String str) {
            return (CTOfficeArtExtension) POIXMLTypeLoader.parse(str, CTOfficeArtExtension.type, (XmlOptions) null);
        }

        public static CTOfficeArtExtension parse(String str, XmlOptions xmlOptions) {
            return (CTOfficeArtExtension) POIXMLTypeLoader.parse(str, CTOfficeArtExtension.type, xmlOptions);
        }

        public static CTOfficeArtExtension parse(URL url) {
            return (CTOfficeArtExtension) POIXMLTypeLoader.parse(url, CTOfficeArtExtension.type, (XmlOptions) null);
        }

        public static CTOfficeArtExtension parse(URL url, XmlOptions xmlOptions) {
            return (CTOfficeArtExtension) POIXMLTypeLoader.parse(url, CTOfficeArtExtension.type, xmlOptions);
        }

        public static CTOfficeArtExtension parse(XMLStreamReader xMLStreamReader) {
            return (CTOfficeArtExtension) POIXMLTypeLoader.parse(xMLStreamReader, CTOfficeArtExtension.type, (XmlOptions) null);
        }

        public static CTOfficeArtExtension parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTOfficeArtExtension) POIXMLTypeLoader.parse(xMLStreamReader, CTOfficeArtExtension.type, xmlOptions);
        }

        public static CTOfficeArtExtension parse(XMLInputStream xMLInputStream) {
            return (CTOfficeArtExtension) POIXMLTypeLoader.parse(xMLInputStream, CTOfficeArtExtension.type, (XmlOptions) null);
        }

        public static CTOfficeArtExtension parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTOfficeArtExtension) POIXMLTypeLoader.parse(xMLInputStream, CTOfficeArtExtension.type, xmlOptions);
        }

        public static CTOfficeArtExtension parse(Node node) {
            return (CTOfficeArtExtension) POIXMLTypeLoader.parse(node, CTOfficeArtExtension.type, (XmlOptions) null);
        }

        public static CTOfficeArtExtension parse(Node node, XmlOptions xmlOptions) {
            return (CTOfficeArtExtension) POIXMLTypeLoader.parse(node, CTOfficeArtExtension.type, xmlOptions);
        }
    }

    String getUri();

    boolean isSetUri();

    void setUri(String str);

    void unsetUri();

    XmlToken xgetUri();

    void xsetUri(XmlToken xmlToken);
}
