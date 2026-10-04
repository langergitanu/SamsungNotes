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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTTextCharBullet extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTextCharBullet.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttextcharbullet3c20type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextCharBullet newInstance() {
            return (CTTextCharBullet) POIXMLTypeLoader.newInstance(CTTextCharBullet.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextCharBullet.type, null);
        }

        public static CTTextCharBullet parse(File file) {
            return (CTTextCharBullet) POIXMLTypeLoader.parse(file, CTTextCharBullet.type, (XmlOptions) null);
        }

        public static CTTextCharBullet newInstance(XmlOptions xmlOptions) {
            return (CTTextCharBullet) POIXMLTypeLoader.newInstance(CTTextCharBullet.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextCharBullet.type, xmlOptions);
        }

        public static CTTextCharBullet parse(File file, XmlOptions xmlOptions) {
            return (CTTextCharBullet) POIXMLTypeLoader.parse(file, CTTextCharBullet.type, xmlOptions);
        }

        public static CTTextCharBullet parse(InputStream inputStream) {
            return (CTTextCharBullet) POIXMLTypeLoader.parse(inputStream, CTTextCharBullet.type, (XmlOptions) null);
        }

        public static CTTextCharBullet parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTextCharBullet) POIXMLTypeLoader.parse(inputStream, CTTextCharBullet.type, xmlOptions);
        }

        public static CTTextCharBullet parse(Reader reader) {
            return (CTTextCharBullet) POIXMLTypeLoader.parse(reader, CTTextCharBullet.type, (XmlOptions) null);
        }

        public static CTTextCharBullet parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTextCharBullet) POIXMLTypeLoader.parse(reader, CTTextCharBullet.type, xmlOptions);
        }

        public static CTTextCharBullet parse(String str) {
            return (CTTextCharBullet) POIXMLTypeLoader.parse(str, CTTextCharBullet.type, (XmlOptions) null);
        }

        public static CTTextCharBullet parse(String str, XmlOptions xmlOptions) {
            return (CTTextCharBullet) POIXMLTypeLoader.parse(str, CTTextCharBullet.type, xmlOptions);
        }

        public static CTTextCharBullet parse(URL url) {
            return (CTTextCharBullet) POIXMLTypeLoader.parse(url, CTTextCharBullet.type, (XmlOptions) null);
        }

        public static CTTextCharBullet parse(URL url, XmlOptions xmlOptions) {
            return (CTTextCharBullet) POIXMLTypeLoader.parse(url, CTTextCharBullet.type, xmlOptions);
        }

        public static CTTextCharBullet parse(XMLStreamReader xMLStreamReader) {
            return (CTTextCharBullet) POIXMLTypeLoader.parse(xMLStreamReader, CTTextCharBullet.type, (XmlOptions) null);
        }

        public static CTTextCharBullet parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTextCharBullet) POIXMLTypeLoader.parse(xMLStreamReader, CTTextCharBullet.type, xmlOptions);
        }

        public static CTTextCharBullet parse(XMLInputStream xMLInputStream) {
            return (CTTextCharBullet) POIXMLTypeLoader.parse(xMLInputStream, CTTextCharBullet.type, (XmlOptions) null);
        }

        public static CTTextCharBullet parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTextCharBullet) POIXMLTypeLoader.parse(xMLInputStream, CTTextCharBullet.type, xmlOptions);
        }

        public static CTTextCharBullet parse(Node node) {
            return (CTTextCharBullet) POIXMLTypeLoader.parse(node, CTTextCharBullet.type, (XmlOptions) null);
        }

        public static CTTextCharBullet parse(Node node, XmlOptions xmlOptions) {
            return (CTTextCharBullet) POIXMLTypeLoader.parse(node, CTTextCharBullet.type, xmlOptions);
        }
    }

    String getChar();

    void setChar(String str);

    XmlString xgetChar();

    void xsetChar(XmlString xmlString);
}
