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
public interface STTextIndent extends STCoordinate32 {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STTextIndent.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "sttextindent16e4type");

    public static final class Factory {
        private Factory() {
        }

        public static STTextIndent newInstance() {
            return (STTextIndent) POIXMLTypeLoader.newInstance(STTextIndent.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextIndent.type, null);
        }

        public static STTextIndent newValue(Object obj) {
            return (STTextIndent) STTextIndent.type.newValue(obj);
        }

        public static STTextIndent parse(File file) {
            return (STTextIndent) POIXMLTypeLoader.parse(file, STTextIndent.type, (XmlOptions) null);
        }

        public static STTextIndent newInstance(XmlOptions xmlOptions) {
            return (STTextIndent) POIXMLTypeLoader.newInstance(STTextIndent.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextIndent.type, xmlOptions);
        }

        public static STTextIndent parse(File file, XmlOptions xmlOptions) {
            return (STTextIndent) POIXMLTypeLoader.parse(file, STTextIndent.type, xmlOptions);
        }

        public static STTextIndent parse(InputStream inputStream) {
            return (STTextIndent) POIXMLTypeLoader.parse(inputStream, STTextIndent.type, (XmlOptions) null);
        }

        public static STTextIndent parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STTextIndent) POIXMLTypeLoader.parse(inputStream, STTextIndent.type, xmlOptions);
        }

        public static STTextIndent parse(Reader reader) {
            return (STTextIndent) POIXMLTypeLoader.parse(reader, STTextIndent.type, (XmlOptions) null);
        }

        public static STTextIndent parse(Reader reader, XmlOptions xmlOptions) {
            return (STTextIndent) POIXMLTypeLoader.parse(reader, STTextIndent.type, xmlOptions);
        }

        public static STTextIndent parse(String str) {
            return (STTextIndent) POIXMLTypeLoader.parse(str, STTextIndent.type, (XmlOptions) null);
        }

        public static STTextIndent parse(String str, XmlOptions xmlOptions) {
            return (STTextIndent) POIXMLTypeLoader.parse(str, STTextIndent.type, xmlOptions);
        }

        public static STTextIndent parse(URL url) {
            return (STTextIndent) POIXMLTypeLoader.parse(url, STTextIndent.type, (XmlOptions) null);
        }

        public static STTextIndent parse(URL url, XmlOptions xmlOptions) {
            return (STTextIndent) POIXMLTypeLoader.parse(url, STTextIndent.type, xmlOptions);
        }

        public static STTextIndent parse(XMLStreamReader xMLStreamReader) {
            return (STTextIndent) POIXMLTypeLoader.parse(xMLStreamReader, STTextIndent.type, (XmlOptions) null);
        }

        public static STTextIndent parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STTextIndent) POIXMLTypeLoader.parse(xMLStreamReader, STTextIndent.type, xmlOptions);
        }

        public static STTextIndent parse(XMLInputStream xMLInputStream) {
            return (STTextIndent) POIXMLTypeLoader.parse(xMLInputStream, STTextIndent.type, (XmlOptions) null);
        }

        public static STTextIndent parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STTextIndent) POIXMLTypeLoader.parse(xMLInputStream, STTextIndent.type, xmlOptions);
        }

        public static STTextIndent parse(Node node) {
            return (STTextIndent) POIXMLTypeLoader.parse(node, STTextIndent.type, (XmlOptions) null);
        }

        public static STTextIndent parse(Node node, XmlOptions xmlOptions) {
            return (STTextIndent) POIXMLTypeLoader.parse(node, STTextIndent.type, xmlOptions);
        }
    }
}
