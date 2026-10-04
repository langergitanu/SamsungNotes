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
import org.apache.xmlbeans.XmlToken;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTExtension extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTExtension.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctextensionedf0type");

    public static final class Factory {
        private Factory() {
        }

        public static CTExtension newInstance() {
            return (CTExtension) POIXMLTypeLoader.newInstance(CTExtension.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTExtension.type, null);
        }

        public static CTExtension parse(File file) {
            return (CTExtension) POIXMLTypeLoader.parse(file, CTExtension.type, (XmlOptions) null);
        }

        public static CTExtension newInstance(XmlOptions xmlOptions) {
            return (CTExtension) POIXMLTypeLoader.newInstance(CTExtension.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTExtension.type, xmlOptions);
        }

        public static CTExtension parse(File file, XmlOptions xmlOptions) {
            return (CTExtension) POIXMLTypeLoader.parse(file, CTExtension.type, xmlOptions);
        }

        public static CTExtension parse(InputStream inputStream) {
            return (CTExtension) POIXMLTypeLoader.parse(inputStream, CTExtension.type, (XmlOptions) null);
        }

        public static CTExtension parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTExtension) POIXMLTypeLoader.parse(inputStream, CTExtension.type, xmlOptions);
        }

        public static CTExtension parse(Reader reader) {
            return (CTExtension) POIXMLTypeLoader.parse(reader, CTExtension.type, (XmlOptions) null);
        }

        public static CTExtension parse(Reader reader, XmlOptions xmlOptions) {
            return (CTExtension) POIXMLTypeLoader.parse(reader, CTExtension.type, xmlOptions);
        }

        public static CTExtension parse(String str) {
            return (CTExtension) POIXMLTypeLoader.parse(str, CTExtension.type, (XmlOptions) null);
        }

        public static CTExtension parse(String str, XmlOptions xmlOptions) {
            return (CTExtension) POIXMLTypeLoader.parse(str, CTExtension.type, xmlOptions);
        }

        public static CTExtension parse(URL url) {
            return (CTExtension) POIXMLTypeLoader.parse(url, CTExtension.type, (XmlOptions) null);
        }

        public static CTExtension parse(URL url, XmlOptions xmlOptions) {
            return (CTExtension) POIXMLTypeLoader.parse(url, CTExtension.type, xmlOptions);
        }

        public static CTExtension parse(XMLStreamReader xMLStreamReader) {
            return (CTExtension) POIXMLTypeLoader.parse(xMLStreamReader, CTExtension.type, (XmlOptions) null);
        }

        public static CTExtension parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTExtension) POIXMLTypeLoader.parse(xMLStreamReader, CTExtension.type, xmlOptions);
        }

        public static CTExtension parse(XMLInputStream xMLInputStream) {
            return (CTExtension) POIXMLTypeLoader.parse(xMLInputStream, CTExtension.type, (XmlOptions) null);
        }

        public static CTExtension parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTExtension) POIXMLTypeLoader.parse(xMLInputStream, CTExtension.type, xmlOptions);
        }

        public static CTExtension parse(Node node) {
            return (CTExtension) POIXMLTypeLoader.parse(node, CTExtension.type, (XmlOptions) null);
        }

        public static CTExtension parse(Node node, XmlOptions xmlOptions) {
            return (CTExtension) POIXMLTypeLoader.parse(node, CTExtension.type, xmlOptions);
        }
    }

    String getUri();

    boolean isSetUri();

    void setUri(String str);

    void unsetUri();

    XmlToken xgetUri();

    void xsetUri(XmlToken xmlToken);
}
