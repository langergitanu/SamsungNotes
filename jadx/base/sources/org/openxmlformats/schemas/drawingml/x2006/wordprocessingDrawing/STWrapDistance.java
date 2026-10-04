package org.openxmlformats.schemas.drawingml.x2006.wordprocessingDrawing;

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
public interface STWrapDistance extends XmlUnsignedInt {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STWrapDistance.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "stwrapdistanceea50type");

    public static final class Factory {
        private Factory() {
        }

        public static STWrapDistance newInstance() {
            return (STWrapDistance) POIXMLTypeLoader.newInstance(STWrapDistance.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STWrapDistance.type, null);
        }

        public static STWrapDistance newValue(Object obj) {
            return (STWrapDistance) STWrapDistance.type.newValue(obj);
        }

        public static STWrapDistance parse(File file) {
            return (STWrapDistance) POIXMLTypeLoader.parse(file, STWrapDistance.type, (XmlOptions) null);
        }

        public static STWrapDistance newInstance(XmlOptions xmlOptions) {
            return (STWrapDistance) POIXMLTypeLoader.newInstance(STWrapDistance.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STWrapDistance.type, xmlOptions);
        }

        public static STWrapDistance parse(File file, XmlOptions xmlOptions) {
            return (STWrapDistance) POIXMLTypeLoader.parse(file, STWrapDistance.type, xmlOptions);
        }

        public static STWrapDistance parse(InputStream inputStream) {
            return (STWrapDistance) POIXMLTypeLoader.parse(inputStream, STWrapDistance.type, (XmlOptions) null);
        }

        public static STWrapDistance parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STWrapDistance) POIXMLTypeLoader.parse(inputStream, STWrapDistance.type, xmlOptions);
        }

        public static STWrapDistance parse(Reader reader) {
            return (STWrapDistance) POIXMLTypeLoader.parse(reader, STWrapDistance.type, (XmlOptions) null);
        }

        public static STWrapDistance parse(Reader reader, XmlOptions xmlOptions) {
            return (STWrapDistance) POIXMLTypeLoader.parse(reader, STWrapDistance.type, xmlOptions);
        }

        public static STWrapDistance parse(String str) {
            return (STWrapDistance) POIXMLTypeLoader.parse(str, STWrapDistance.type, (XmlOptions) null);
        }

        public static STWrapDistance parse(String str, XmlOptions xmlOptions) {
            return (STWrapDistance) POIXMLTypeLoader.parse(str, STWrapDistance.type, xmlOptions);
        }

        public static STWrapDistance parse(URL url) {
            return (STWrapDistance) POIXMLTypeLoader.parse(url, STWrapDistance.type, (XmlOptions) null);
        }

        public static STWrapDistance parse(URL url, XmlOptions xmlOptions) {
            return (STWrapDistance) POIXMLTypeLoader.parse(url, STWrapDistance.type, xmlOptions);
        }

        public static STWrapDistance parse(XMLStreamReader xMLStreamReader) {
            return (STWrapDistance) POIXMLTypeLoader.parse(xMLStreamReader, STWrapDistance.type, (XmlOptions) null);
        }

        public static STWrapDistance parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STWrapDistance) POIXMLTypeLoader.parse(xMLStreamReader, STWrapDistance.type, xmlOptions);
        }

        public static STWrapDistance parse(XMLInputStream xMLInputStream) {
            return (STWrapDistance) POIXMLTypeLoader.parse(xMLInputStream, STWrapDistance.type, (XmlOptions) null);
        }

        public static STWrapDistance parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STWrapDistance) POIXMLTypeLoader.parse(xMLInputStream, STWrapDistance.type, xmlOptions);
        }

        public static STWrapDistance parse(Node node) {
            return (STWrapDistance) POIXMLTypeLoader.parse(node, STWrapDistance.type, (XmlOptions) null);
        }

        public static STWrapDistance parse(Node node, XmlOptions xmlOptions) {
            return (STWrapDistance) POIXMLTypeLoader.parse(node, STWrapDistance.type, xmlOptions);
        }
    }
}
