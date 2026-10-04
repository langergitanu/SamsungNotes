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
public interface CTTextNoBullet extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTextNoBullet.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttextnobulleta08btype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTextNoBullet newInstance() {
            return (CTTextNoBullet) POIXMLTypeLoader.newInstance(CTTextNoBullet.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextNoBullet.type, null);
        }

        public static CTTextNoBullet parse(File file) {
            return (CTTextNoBullet) POIXMLTypeLoader.parse(file, CTTextNoBullet.type, (XmlOptions) null);
        }

        public static CTTextNoBullet newInstance(XmlOptions xmlOptions) {
            return (CTTextNoBullet) POIXMLTypeLoader.newInstance(CTTextNoBullet.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTextNoBullet.type, xmlOptions);
        }

        public static CTTextNoBullet parse(File file, XmlOptions xmlOptions) {
            return (CTTextNoBullet) POIXMLTypeLoader.parse(file, CTTextNoBullet.type, xmlOptions);
        }

        public static CTTextNoBullet parse(InputStream inputStream) {
            return (CTTextNoBullet) POIXMLTypeLoader.parse(inputStream, CTTextNoBullet.type, (XmlOptions) null);
        }

        public static CTTextNoBullet parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTextNoBullet) POIXMLTypeLoader.parse(inputStream, CTTextNoBullet.type, xmlOptions);
        }

        public static CTTextNoBullet parse(Reader reader) {
            return (CTTextNoBullet) POIXMLTypeLoader.parse(reader, CTTextNoBullet.type, (XmlOptions) null);
        }

        public static CTTextNoBullet parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTextNoBullet) POIXMLTypeLoader.parse(reader, CTTextNoBullet.type, xmlOptions);
        }

        public static CTTextNoBullet parse(String str) {
            return (CTTextNoBullet) POIXMLTypeLoader.parse(str, CTTextNoBullet.type, (XmlOptions) null);
        }

        public static CTTextNoBullet parse(String str, XmlOptions xmlOptions) {
            return (CTTextNoBullet) POIXMLTypeLoader.parse(str, CTTextNoBullet.type, xmlOptions);
        }

        public static CTTextNoBullet parse(URL url) {
            return (CTTextNoBullet) POIXMLTypeLoader.parse(url, CTTextNoBullet.type, (XmlOptions) null);
        }

        public static CTTextNoBullet parse(URL url, XmlOptions xmlOptions) {
            return (CTTextNoBullet) POIXMLTypeLoader.parse(url, CTTextNoBullet.type, xmlOptions);
        }

        public static CTTextNoBullet parse(XMLStreamReader xMLStreamReader) {
            return (CTTextNoBullet) POIXMLTypeLoader.parse(xMLStreamReader, CTTextNoBullet.type, (XmlOptions) null);
        }

        public static CTTextNoBullet parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTextNoBullet) POIXMLTypeLoader.parse(xMLStreamReader, CTTextNoBullet.type, xmlOptions);
        }

        public static CTTextNoBullet parse(XMLInputStream xMLInputStream) {
            return (CTTextNoBullet) POIXMLTypeLoader.parse(xMLInputStream, CTTextNoBullet.type, (XmlOptions) null);
        }

        public static CTTextNoBullet parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTextNoBullet) POIXMLTypeLoader.parse(xMLInputStream, CTTextNoBullet.type, xmlOptions);
        }

        public static CTTextNoBullet parse(Node node) {
            return (CTTextNoBullet) POIXMLTypeLoader.parse(node, CTTextNoBullet.type, (XmlOptions) null);
        }

        public static CTTextNoBullet parse(Node node, XmlOptions xmlOptions) {
            return (CTTextNoBullet) POIXMLTypeLoader.parse(node, CTTextNoBullet.type, xmlOptions);
        }
    }
}
