package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlHexBinary;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface STHexColorRGB extends XmlHexBinary {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STHexColorRGB.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "sthexcolorrgbd59dtype");

    public static final class Factory {
        private Factory() {
        }

        public static STHexColorRGB newInstance() {
            return (STHexColorRGB) POIXMLTypeLoader.newInstance(STHexColorRGB.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STHexColorRGB.type, null);
        }

        public static STHexColorRGB newValue(Object obj) {
            return (STHexColorRGB) STHexColorRGB.type.newValue(obj);
        }

        public static STHexColorRGB parse(File file) {
            return (STHexColorRGB) POIXMLTypeLoader.parse(file, STHexColorRGB.type, (XmlOptions) null);
        }

        public static STHexColorRGB newInstance(XmlOptions xmlOptions) {
            return (STHexColorRGB) POIXMLTypeLoader.newInstance(STHexColorRGB.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STHexColorRGB.type, xmlOptions);
        }

        public static STHexColorRGB parse(File file, XmlOptions xmlOptions) {
            return (STHexColorRGB) POIXMLTypeLoader.parse(file, STHexColorRGB.type, xmlOptions);
        }

        public static STHexColorRGB parse(InputStream inputStream) {
            return (STHexColorRGB) POIXMLTypeLoader.parse(inputStream, STHexColorRGB.type, (XmlOptions) null);
        }

        public static STHexColorRGB parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STHexColorRGB) POIXMLTypeLoader.parse(inputStream, STHexColorRGB.type, xmlOptions);
        }

        public static STHexColorRGB parse(Reader reader) {
            return (STHexColorRGB) POIXMLTypeLoader.parse(reader, STHexColorRGB.type, (XmlOptions) null);
        }

        public static STHexColorRGB parse(Reader reader, XmlOptions xmlOptions) {
            return (STHexColorRGB) POIXMLTypeLoader.parse(reader, STHexColorRGB.type, xmlOptions);
        }

        public static STHexColorRGB parse(String str) {
            return (STHexColorRGB) POIXMLTypeLoader.parse(str, STHexColorRGB.type, (XmlOptions) null);
        }

        public static STHexColorRGB parse(String str, XmlOptions xmlOptions) {
            return (STHexColorRGB) POIXMLTypeLoader.parse(str, STHexColorRGB.type, xmlOptions);
        }

        public static STHexColorRGB parse(URL url) {
            return (STHexColorRGB) POIXMLTypeLoader.parse(url, STHexColorRGB.type, (XmlOptions) null);
        }

        public static STHexColorRGB parse(URL url, XmlOptions xmlOptions) {
            return (STHexColorRGB) POIXMLTypeLoader.parse(url, STHexColorRGB.type, xmlOptions);
        }

        public static STHexColorRGB parse(XMLStreamReader xMLStreamReader) {
            return (STHexColorRGB) POIXMLTypeLoader.parse(xMLStreamReader, STHexColorRGB.type, (XmlOptions) null);
        }

        public static STHexColorRGB parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STHexColorRGB) POIXMLTypeLoader.parse(xMLStreamReader, STHexColorRGB.type, xmlOptions);
        }

        public static STHexColorRGB parse(XMLInputStream xMLInputStream) {
            return (STHexColorRGB) POIXMLTypeLoader.parse(xMLInputStream, STHexColorRGB.type, (XmlOptions) null);
        }

        public static STHexColorRGB parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STHexColorRGB) POIXMLTypeLoader.parse(xMLInputStream, STHexColorRGB.type, xmlOptions);
        }

        public static STHexColorRGB parse(Node node) {
            return (STHexColorRGB) POIXMLTypeLoader.parse(node, STHexColorRGB.type, (XmlOptions) null);
        }

        public static STHexColorRGB parse(Node node, XmlOptions xmlOptions) {
            return (STHexColorRGB) POIXMLTypeLoader.parse(node, STHexColorRGB.type, xmlOptions);
        }
    }
}
