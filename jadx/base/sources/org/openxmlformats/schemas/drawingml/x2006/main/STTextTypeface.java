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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface STTextTypeface extends XmlString {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STTextTypeface.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "sttexttypefacea80ftype");

    public static final class Factory {
        private Factory() {
        }

        public static STTextTypeface newInstance() {
            return (STTextTypeface) POIXMLTypeLoader.newInstance(STTextTypeface.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextTypeface.type, null);
        }

        public static STTextTypeface newValue(Object obj) {
            return (STTextTypeface) STTextTypeface.type.newValue(obj);
        }

        public static STTextTypeface parse(File file) {
            return (STTextTypeface) POIXMLTypeLoader.parse(file, STTextTypeface.type, (XmlOptions) null);
        }

        public static STTextTypeface newInstance(XmlOptions xmlOptions) {
            return (STTextTypeface) POIXMLTypeLoader.newInstance(STTextTypeface.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextTypeface.type, xmlOptions);
        }

        public static STTextTypeface parse(File file, XmlOptions xmlOptions) {
            return (STTextTypeface) POIXMLTypeLoader.parse(file, STTextTypeface.type, xmlOptions);
        }

        public static STTextTypeface parse(InputStream inputStream) {
            return (STTextTypeface) POIXMLTypeLoader.parse(inputStream, STTextTypeface.type, (XmlOptions) null);
        }

        public static STTextTypeface parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STTextTypeface) POIXMLTypeLoader.parse(inputStream, STTextTypeface.type, xmlOptions);
        }

        public static STTextTypeface parse(Reader reader) {
            return (STTextTypeface) POIXMLTypeLoader.parse(reader, STTextTypeface.type, (XmlOptions) null);
        }

        public static STTextTypeface parse(Reader reader, XmlOptions xmlOptions) {
            return (STTextTypeface) POIXMLTypeLoader.parse(reader, STTextTypeface.type, xmlOptions);
        }

        public static STTextTypeface parse(String str) {
            return (STTextTypeface) POIXMLTypeLoader.parse(str, STTextTypeface.type, (XmlOptions) null);
        }

        public static STTextTypeface parse(String str, XmlOptions xmlOptions) {
            return (STTextTypeface) POIXMLTypeLoader.parse(str, STTextTypeface.type, xmlOptions);
        }

        public static STTextTypeface parse(URL url) {
            return (STTextTypeface) POIXMLTypeLoader.parse(url, STTextTypeface.type, (XmlOptions) null);
        }

        public static STTextTypeface parse(URL url, XmlOptions xmlOptions) {
            return (STTextTypeface) POIXMLTypeLoader.parse(url, STTextTypeface.type, xmlOptions);
        }

        public static STTextTypeface parse(XMLStreamReader xMLStreamReader) {
            return (STTextTypeface) POIXMLTypeLoader.parse(xMLStreamReader, STTextTypeface.type, (XmlOptions) null);
        }

        public static STTextTypeface parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STTextTypeface) POIXMLTypeLoader.parse(xMLStreamReader, STTextTypeface.type, xmlOptions);
        }

        public static STTextTypeface parse(XMLInputStream xMLInputStream) {
            return (STTextTypeface) POIXMLTypeLoader.parse(xMLInputStream, STTextTypeface.type, (XmlOptions) null);
        }

        public static STTextTypeface parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STTextTypeface) POIXMLTypeLoader.parse(xMLInputStream, STTextTypeface.type, xmlOptions);
        }

        public static STTextTypeface parse(Node node) {
            return (STTextTypeface) POIXMLTypeLoader.parse(node, STTextTypeface.type, (XmlOptions) null);
        }

        public static STTextTypeface parse(Node node, XmlOptions xmlOptions) {
            return (STTextTypeface) POIXMLTypeLoader.parse(node, STTextTypeface.type, xmlOptions);
        }
    }
}
