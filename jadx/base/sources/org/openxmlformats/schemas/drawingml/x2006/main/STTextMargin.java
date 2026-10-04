package org.openxmlformats.schemas.drawingml.x2006.main;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface STTextMargin extends STCoordinate32 {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STTextMargin.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "sttextmargin9666type");

    public static final class Factory {
        private Factory() {
        }

        public static STTextMargin newInstance() {
            return (STTextMargin) POIXMLTypeLoader.newInstance(STTextMargin.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextMargin.type, null);
        }

        public static STTextMargin newValue(Object obj) {
            return (STTextMargin) STTextMargin.type.newValue(obj);
        }

        public static STTextMargin parse(File file) {
            return (STTextMargin) POIXMLTypeLoader.parse(file, STTextMargin.type, (XmlOptions) null);
        }

        public static STTextMargin newInstance(XmlOptions xmlOptions) {
            return (STTextMargin) POIXMLTypeLoader.newInstance(STTextMargin.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextMargin.type, xmlOptions);
        }

        public static STTextMargin parse(File file, XmlOptions xmlOptions) {
            return (STTextMargin) POIXMLTypeLoader.parse(file, STTextMargin.type, xmlOptions);
        }

        public static STTextMargin parse(InputStream inputStream) {
            return (STTextMargin) POIXMLTypeLoader.parse(inputStream, STTextMargin.type, (XmlOptions) null);
        }

        public static STTextMargin parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STTextMargin) POIXMLTypeLoader.parse(inputStream, STTextMargin.type, xmlOptions);
        }

        public static STTextMargin parse(Reader reader) {
            return (STTextMargin) POIXMLTypeLoader.parse(reader, STTextMargin.type, (XmlOptions) null);
        }

        public static STTextMargin parse(Reader reader, XmlOptions xmlOptions) {
            return (STTextMargin) POIXMLTypeLoader.parse(reader, STTextMargin.type, xmlOptions);
        }

        public static STTextMargin parse(String str) {
            return (STTextMargin) POIXMLTypeLoader.parse(str, STTextMargin.type, (XmlOptions) null);
        }

        public static STTextMargin parse(String str, XmlOptions xmlOptions) {
            return (STTextMargin) POIXMLTypeLoader.parse(str, STTextMargin.type, xmlOptions);
        }

        public static STTextMargin parse(URL url) {
            return (STTextMargin) POIXMLTypeLoader.parse(url, STTextMargin.type, (XmlOptions) null);
        }

        public static STTextMargin parse(URL url, XmlOptions xmlOptions) {
            return (STTextMargin) POIXMLTypeLoader.parse(url, STTextMargin.type, xmlOptions);
        }

        public static STTextMargin parse(XMLStreamReader xMLStreamReader) {
            return (STTextMargin) POIXMLTypeLoader.parse(xMLStreamReader, STTextMargin.type, (XmlOptions) null);
        }

        public static STTextMargin parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STTextMargin) POIXMLTypeLoader.parse(xMLStreamReader, STTextMargin.type, xmlOptions);
        }

        public static STTextMargin parse(XMLInputStream xMLInputStream) {
            return (STTextMargin) POIXMLTypeLoader.parse(xMLInputStream, STTextMargin.type, (XmlOptions) null);
        }

        public static STTextMargin parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STTextMargin) POIXMLTypeLoader.parse(xMLInputStream, STTextMargin.type, xmlOptions);
        }

        public static STTextMargin parse(Node node) {
            return (STTextMargin) POIXMLTypeLoader.parse(node, STTextMargin.type, (XmlOptions) null);
        }

        public static STTextMargin parse(Node node, XmlOptions xmlOptions) {
            return (STTextMargin) POIXMLTypeLoader.parse(node, STTextMargin.type, xmlOptions);
        }
    }
}
