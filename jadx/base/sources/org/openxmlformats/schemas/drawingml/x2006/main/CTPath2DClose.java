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
public interface CTPath2DClose extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTPath2DClose.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctpath2dclose09f2type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPath2DClose newInstance() {
            return (CTPath2DClose) POIXMLTypeLoader.newInstance(CTPath2DClose.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPath2DClose.type, null);
        }

        public static CTPath2DClose parse(File file) {
            return (CTPath2DClose) POIXMLTypeLoader.parse(file, CTPath2DClose.type, (XmlOptions) null);
        }

        public static CTPath2DClose newInstance(XmlOptions xmlOptions) {
            return (CTPath2DClose) POIXMLTypeLoader.newInstance(CTPath2DClose.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPath2DClose.type, xmlOptions);
        }

        public static CTPath2DClose parse(File file, XmlOptions xmlOptions) {
            return (CTPath2DClose) POIXMLTypeLoader.parse(file, CTPath2DClose.type, xmlOptions);
        }

        public static CTPath2DClose parse(InputStream inputStream) {
            return (CTPath2DClose) POIXMLTypeLoader.parse(inputStream, CTPath2DClose.type, (XmlOptions) null);
        }

        public static CTPath2DClose parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTPath2DClose) POIXMLTypeLoader.parse(inputStream, CTPath2DClose.type, xmlOptions);
        }

        public static CTPath2DClose parse(Reader reader) {
            return (CTPath2DClose) POIXMLTypeLoader.parse(reader, CTPath2DClose.type, (XmlOptions) null);
        }

        public static CTPath2DClose parse(Reader reader, XmlOptions xmlOptions) {
            return (CTPath2DClose) POIXMLTypeLoader.parse(reader, CTPath2DClose.type, xmlOptions);
        }

        public static CTPath2DClose parse(String str) {
            return (CTPath2DClose) POIXMLTypeLoader.parse(str, CTPath2DClose.type, (XmlOptions) null);
        }

        public static CTPath2DClose parse(String str, XmlOptions xmlOptions) {
            return (CTPath2DClose) POIXMLTypeLoader.parse(str, CTPath2DClose.type, xmlOptions);
        }

        public static CTPath2DClose parse(URL url) {
            return (CTPath2DClose) POIXMLTypeLoader.parse(url, CTPath2DClose.type, (XmlOptions) null);
        }

        public static CTPath2DClose parse(URL url, XmlOptions xmlOptions) {
            return (CTPath2DClose) POIXMLTypeLoader.parse(url, CTPath2DClose.type, xmlOptions);
        }

        public static CTPath2DClose parse(XMLStreamReader xMLStreamReader) {
            return (CTPath2DClose) POIXMLTypeLoader.parse(xMLStreamReader, CTPath2DClose.type, (XmlOptions) null);
        }

        public static CTPath2DClose parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTPath2DClose) POIXMLTypeLoader.parse(xMLStreamReader, CTPath2DClose.type, xmlOptions);
        }

        public static CTPath2DClose parse(XMLInputStream xMLInputStream) {
            return (CTPath2DClose) POIXMLTypeLoader.parse(xMLInputStream, CTPath2DClose.type, (XmlOptions) null);
        }

        public static CTPath2DClose parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTPath2DClose) POIXMLTypeLoader.parse(xMLInputStream, CTPath2DClose.type, xmlOptions);
        }

        public static CTPath2DClose parse(Node node) {
            return (CTPath2DClose) POIXMLTypeLoader.parse(node, CTPath2DClose.type, (XmlOptions) null);
        }

        public static CTPath2DClose parse(Node node, XmlOptions xmlOptions) {
            return (CTPath2DClose) POIXMLTypeLoader.parse(node, CTPath2DClose.type, xmlOptions);
        }
    }
}
