package org.openxmlformats.schemas.drawingml.x2006.main;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlInt;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface STCoordinate32 extends XmlInt {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STCoordinate32.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "stcoordinate322cc2type");

    public static final class Factory {
        private Factory() {
        }

        public static STCoordinate32 newInstance() {
            return (STCoordinate32) POIXMLTypeLoader.newInstance(STCoordinate32.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STCoordinate32.type, null);
        }

        public static STCoordinate32 newValue(Object obj) {
            return (STCoordinate32) STCoordinate32.type.newValue(obj);
        }

        public static STCoordinate32 parse(File file) {
            return (STCoordinate32) POIXMLTypeLoader.parse(file, STCoordinate32.type, (XmlOptions) null);
        }

        public static STCoordinate32 newInstance(XmlOptions xmlOptions) {
            return (STCoordinate32) POIXMLTypeLoader.newInstance(STCoordinate32.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STCoordinate32.type, xmlOptions);
        }

        public static STCoordinate32 parse(File file, XmlOptions xmlOptions) {
            return (STCoordinate32) POIXMLTypeLoader.parse(file, STCoordinate32.type, xmlOptions);
        }

        public static STCoordinate32 parse(InputStream inputStream) {
            return (STCoordinate32) POIXMLTypeLoader.parse(inputStream, STCoordinate32.type, (XmlOptions) null);
        }

        public static STCoordinate32 parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STCoordinate32) POIXMLTypeLoader.parse(inputStream, STCoordinate32.type, xmlOptions);
        }

        public static STCoordinate32 parse(Reader reader) {
            return (STCoordinate32) POIXMLTypeLoader.parse(reader, STCoordinate32.type, (XmlOptions) null);
        }

        public static STCoordinate32 parse(Reader reader, XmlOptions xmlOptions) {
            return (STCoordinate32) POIXMLTypeLoader.parse(reader, STCoordinate32.type, xmlOptions);
        }

        public static STCoordinate32 parse(String str) {
            return (STCoordinate32) POIXMLTypeLoader.parse(str, STCoordinate32.type, (XmlOptions) null);
        }

        public static STCoordinate32 parse(String str, XmlOptions xmlOptions) {
            return (STCoordinate32) POIXMLTypeLoader.parse(str, STCoordinate32.type, xmlOptions);
        }

        public static STCoordinate32 parse(URL url) {
            return (STCoordinate32) POIXMLTypeLoader.parse(url, STCoordinate32.type, (XmlOptions) null);
        }

        public static STCoordinate32 parse(URL url, XmlOptions xmlOptions) {
            return (STCoordinate32) POIXMLTypeLoader.parse(url, STCoordinate32.type, xmlOptions);
        }

        public static STCoordinate32 parse(XMLStreamReader xMLStreamReader) {
            return (STCoordinate32) POIXMLTypeLoader.parse(xMLStreamReader, STCoordinate32.type, (XmlOptions) null);
        }

        public static STCoordinate32 parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STCoordinate32) POIXMLTypeLoader.parse(xMLStreamReader, STCoordinate32.type, xmlOptions);
        }

        public static STCoordinate32 parse(XMLInputStream xMLInputStream) {
            return (STCoordinate32) POIXMLTypeLoader.parse(xMLInputStream, STCoordinate32.type, (XmlOptions) null);
        }

        public static STCoordinate32 parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STCoordinate32) POIXMLTypeLoader.parse(xMLInputStream, STCoordinate32.type, xmlOptions);
        }

        public static STCoordinate32 parse(Node node) {
            return (STCoordinate32) POIXMLTypeLoader.parse(node, STCoordinate32.type, (XmlOptions) null);
        }

        public static STCoordinate32 parse(Node node, XmlOptions xmlOptions) {
            return (STCoordinate32) POIXMLTypeLoader.parse(node, STCoordinate32.type, xmlOptions);
        }
    }
}
