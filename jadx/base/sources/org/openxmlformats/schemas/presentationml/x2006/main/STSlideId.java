package org.openxmlformats.schemas.presentationml.x2006.main;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface STSlideId extends XmlUnsignedInt {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STSlideId.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "stslideida0b3type");

    public static final class Factory {
        private Factory() {
        }

        public static STSlideId newInstance() {
            return (STSlideId) POIXMLTypeLoader.newInstance(STSlideId.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STSlideId.type, null);
        }

        public static STSlideId newValue(Object obj) {
            return (STSlideId) STSlideId.type.newValue(obj);
        }

        public static STSlideId parse(File file) {
            return (STSlideId) POIXMLTypeLoader.parse(file, STSlideId.type, (XmlOptions) null);
        }

        public static STSlideId newInstance(XmlOptions xmlOptions) {
            return (STSlideId) POIXMLTypeLoader.newInstance(STSlideId.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STSlideId.type, xmlOptions);
        }

        public static STSlideId parse(File file, XmlOptions xmlOptions) {
            return (STSlideId) POIXMLTypeLoader.parse(file, STSlideId.type, xmlOptions);
        }

        public static STSlideId parse(InputStream inputStream) {
            return (STSlideId) POIXMLTypeLoader.parse(inputStream, STSlideId.type, (XmlOptions) null);
        }

        public static STSlideId parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STSlideId) POIXMLTypeLoader.parse(inputStream, STSlideId.type, xmlOptions);
        }

        public static STSlideId parse(Reader reader) {
            return (STSlideId) POIXMLTypeLoader.parse(reader, STSlideId.type, (XmlOptions) null);
        }

        public static STSlideId parse(Reader reader, XmlOptions xmlOptions) {
            return (STSlideId) POIXMLTypeLoader.parse(reader, STSlideId.type, xmlOptions);
        }

        public static STSlideId parse(String str) {
            return (STSlideId) POIXMLTypeLoader.parse(str, STSlideId.type, (XmlOptions) null);
        }

        public static STSlideId parse(String str, XmlOptions xmlOptions) {
            return (STSlideId) POIXMLTypeLoader.parse(str, STSlideId.type, xmlOptions);
        }

        public static STSlideId parse(URL url) {
            return (STSlideId) POIXMLTypeLoader.parse(url, STSlideId.type, (XmlOptions) null);
        }

        public static STSlideId parse(URL url, XmlOptions xmlOptions) {
            return (STSlideId) POIXMLTypeLoader.parse(url, STSlideId.type, xmlOptions);
        }

        public static STSlideId parse(XMLStreamReader xMLStreamReader) {
            return (STSlideId) POIXMLTypeLoader.parse(xMLStreamReader, STSlideId.type, (XmlOptions) null);
        }

        public static STSlideId parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STSlideId) POIXMLTypeLoader.parse(xMLStreamReader, STSlideId.type, xmlOptions);
        }

        public static STSlideId parse(XMLInputStream xMLInputStream) {
            return (STSlideId) POIXMLTypeLoader.parse(xMLInputStream, STSlideId.type, (XmlOptions) null);
        }

        public static STSlideId parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STSlideId) POIXMLTypeLoader.parse(xMLInputStream, STSlideId.type, xmlOptions);
        }

        public static STSlideId parse(Node node) {
            return (STSlideId) POIXMLTypeLoader.parse(node, STSlideId.type, (XmlOptions) null);
        }

        public static STSlideId parse(Node node, XmlOptions xmlOptions) {
            return (STSlideId) POIXMLTypeLoader.parse(node, STSlideId.type, xmlOptions);
        }
    }
}
