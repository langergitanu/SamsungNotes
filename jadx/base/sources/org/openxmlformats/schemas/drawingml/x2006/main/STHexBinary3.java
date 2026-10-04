package org.openxmlformats.schemas.drawingml.x2006.main;

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
public interface STHexBinary3 extends XmlHexBinary {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STHexBinary3.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "sthexbinary314e2type");

    public static final class Factory {
        private Factory() {
        }

        public static STHexBinary3 newInstance() {
            return (STHexBinary3) POIXMLTypeLoader.newInstance(STHexBinary3.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STHexBinary3.type, null);
        }

        public static STHexBinary3 newValue(Object obj) {
            return (STHexBinary3) STHexBinary3.type.newValue(obj);
        }

        public static STHexBinary3 parse(File file) {
            return (STHexBinary3) POIXMLTypeLoader.parse(file, STHexBinary3.type, (XmlOptions) null);
        }

        public static STHexBinary3 newInstance(XmlOptions xmlOptions) {
            return (STHexBinary3) POIXMLTypeLoader.newInstance(STHexBinary3.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STHexBinary3.type, xmlOptions);
        }

        public static STHexBinary3 parse(File file, XmlOptions xmlOptions) {
            return (STHexBinary3) POIXMLTypeLoader.parse(file, STHexBinary3.type, xmlOptions);
        }

        public static STHexBinary3 parse(InputStream inputStream) {
            return (STHexBinary3) POIXMLTypeLoader.parse(inputStream, STHexBinary3.type, (XmlOptions) null);
        }

        public static STHexBinary3 parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STHexBinary3) POIXMLTypeLoader.parse(inputStream, STHexBinary3.type, xmlOptions);
        }

        public static STHexBinary3 parse(Reader reader) {
            return (STHexBinary3) POIXMLTypeLoader.parse(reader, STHexBinary3.type, (XmlOptions) null);
        }

        public static STHexBinary3 parse(Reader reader, XmlOptions xmlOptions) {
            return (STHexBinary3) POIXMLTypeLoader.parse(reader, STHexBinary3.type, xmlOptions);
        }

        public static STHexBinary3 parse(String str) {
            return (STHexBinary3) POIXMLTypeLoader.parse(str, STHexBinary3.type, (XmlOptions) null);
        }

        public static STHexBinary3 parse(String str, XmlOptions xmlOptions) {
            return (STHexBinary3) POIXMLTypeLoader.parse(str, STHexBinary3.type, xmlOptions);
        }

        public static STHexBinary3 parse(URL url) {
            return (STHexBinary3) POIXMLTypeLoader.parse(url, STHexBinary3.type, (XmlOptions) null);
        }

        public static STHexBinary3 parse(URL url, XmlOptions xmlOptions) {
            return (STHexBinary3) POIXMLTypeLoader.parse(url, STHexBinary3.type, xmlOptions);
        }

        public static STHexBinary3 parse(XMLStreamReader xMLStreamReader) {
            return (STHexBinary3) POIXMLTypeLoader.parse(xMLStreamReader, STHexBinary3.type, (XmlOptions) null);
        }

        public static STHexBinary3 parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STHexBinary3) POIXMLTypeLoader.parse(xMLStreamReader, STHexBinary3.type, xmlOptions);
        }

        public static STHexBinary3 parse(XMLInputStream xMLInputStream) {
            return (STHexBinary3) POIXMLTypeLoader.parse(xMLInputStream, STHexBinary3.type, (XmlOptions) null);
        }

        public static STHexBinary3 parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STHexBinary3) POIXMLTypeLoader.parse(xMLInputStream, STHexBinary3.type, xmlOptions);
        }

        public static STHexBinary3 parse(Node node) {
            return (STHexBinary3) POIXMLTypeLoader.parse(node, STHexBinary3.type, (XmlOptions) null);
        }

        public static STHexBinary3 parse(Node node, XmlOptions xmlOptions) {
            return (STHexBinary3) POIXMLTypeLoader.parse(node, STHexBinary3.type, xmlOptions);
        }
    }
}
