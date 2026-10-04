package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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
public interface CTPictureBase extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTPictureBase.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctpicturebase5f83type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPictureBase newInstance() {
            return (CTPictureBase) POIXMLTypeLoader.newInstance(CTPictureBase.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPictureBase.type, null);
        }

        public static CTPictureBase parse(File file) {
            return (CTPictureBase) POIXMLTypeLoader.parse(file, CTPictureBase.type, (XmlOptions) null);
        }

        public static CTPictureBase newInstance(XmlOptions xmlOptions) {
            return (CTPictureBase) POIXMLTypeLoader.newInstance(CTPictureBase.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPictureBase.type, xmlOptions);
        }

        public static CTPictureBase parse(File file, XmlOptions xmlOptions) {
            return (CTPictureBase) POIXMLTypeLoader.parse(file, CTPictureBase.type, xmlOptions);
        }

        public static CTPictureBase parse(InputStream inputStream) {
            return (CTPictureBase) POIXMLTypeLoader.parse(inputStream, CTPictureBase.type, (XmlOptions) null);
        }

        public static CTPictureBase parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTPictureBase) POIXMLTypeLoader.parse(inputStream, CTPictureBase.type, xmlOptions);
        }

        public static CTPictureBase parse(Reader reader) {
            return (CTPictureBase) POIXMLTypeLoader.parse(reader, CTPictureBase.type, (XmlOptions) null);
        }

        public static CTPictureBase parse(Reader reader, XmlOptions xmlOptions) {
            return (CTPictureBase) POIXMLTypeLoader.parse(reader, CTPictureBase.type, xmlOptions);
        }

        public static CTPictureBase parse(String str) {
            return (CTPictureBase) POIXMLTypeLoader.parse(str, CTPictureBase.type, (XmlOptions) null);
        }

        public static CTPictureBase parse(String str, XmlOptions xmlOptions) {
            return (CTPictureBase) POIXMLTypeLoader.parse(str, CTPictureBase.type, xmlOptions);
        }

        public static CTPictureBase parse(URL url) {
            return (CTPictureBase) POIXMLTypeLoader.parse(url, CTPictureBase.type, (XmlOptions) null);
        }

        public static CTPictureBase parse(URL url, XmlOptions xmlOptions) {
            return (CTPictureBase) POIXMLTypeLoader.parse(url, CTPictureBase.type, xmlOptions);
        }

        public static CTPictureBase parse(XMLStreamReader xMLStreamReader) {
            return (CTPictureBase) POIXMLTypeLoader.parse(xMLStreamReader, CTPictureBase.type, (XmlOptions) null);
        }

        public static CTPictureBase parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTPictureBase) POIXMLTypeLoader.parse(xMLStreamReader, CTPictureBase.type, xmlOptions);
        }

        public static CTPictureBase parse(XMLInputStream xMLInputStream) {
            return (CTPictureBase) POIXMLTypeLoader.parse(xMLInputStream, CTPictureBase.type, (XmlOptions) null);
        }

        public static CTPictureBase parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTPictureBase) POIXMLTypeLoader.parse(xMLInputStream, CTPictureBase.type, xmlOptions);
        }

        public static CTPictureBase parse(Node node) {
            return (CTPictureBase) POIXMLTypeLoader.parse(node, CTPictureBase.type, (XmlOptions) null);
        }

        public static CTPictureBase parse(Node node, XmlOptions xmlOptions) {
            return (CTPictureBase) POIXMLTypeLoader.parse(node, CTPictureBase.type, xmlOptions);
        }
    }
}
