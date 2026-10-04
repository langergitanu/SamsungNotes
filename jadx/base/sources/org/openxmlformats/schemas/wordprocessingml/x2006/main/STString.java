package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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
public interface STString extends XmlString {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STString.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ststringa627type");

    public static final class Factory {
        private Factory() {
        }

        public static STString newInstance() {
            return (STString) POIXMLTypeLoader.newInstance(STString.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STString.type, null);
        }

        public static STString newValue(Object obj) {
            return (STString) STString.type.newValue(obj);
        }

        public static STString parse(File file) {
            return (STString) POIXMLTypeLoader.parse(file, STString.type, (XmlOptions) null);
        }

        public static STString newInstance(XmlOptions xmlOptions) {
            return (STString) POIXMLTypeLoader.newInstance(STString.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STString.type, xmlOptions);
        }

        public static STString parse(File file, XmlOptions xmlOptions) {
            return (STString) POIXMLTypeLoader.parse(file, STString.type, xmlOptions);
        }

        public static STString parse(InputStream inputStream) {
            return (STString) POIXMLTypeLoader.parse(inputStream, STString.type, (XmlOptions) null);
        }

        public static STString parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STString) POIXMLTypeLoader.parse(inputStream, STString.type, xmlOptions);
        }

        public static STString parse(Reader reader) {
            return (STString) POIXMLTypeLoader.parse(reader, STString.type, (XmlOptions) null);
        }

        public static STString parse(Reader reader, XmlOptions xmlOptions) {
            return (STString) POIXMLTypeLoader.parse(reader, STString.type, xmlOptions);
        }

        public static STString parse(String str) {
            return (STString) POIXMLTypeLoader.parse(str, STString.type, (XmlOptions) null);
        }

        public static STString parse(String str, XmlOptions xmlOptions) {
            return (STString) POIXMLTypeLoader.parse(str, STString.type, xmlOptions);
        }

        public static STString parse(URL url) {
            return (STString) POIXMLTypeLoader.parse(url, STString.type, (XmlOptions) null);
        }

        public static STString parse(URL url, XmlOptions xmlOptions) {
            return (STString) POIXMLTypeLoader.parse(url, STString.type, xmlOptions);
        }

        public static STString parse(XMLStreamReader xMLStreamReader) {
            return (STString) POIXMLTypeLoader.parse(xMLStreamReader, STString.type, (XmlOptions) null);
        }

        public static STString parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STString) POIXMLTypeLoader.parse(xMLStreamReader, STString.type, xmlOptions);
        }

        public static STString parse(XMLInputStream xMLInputStream) {
            return (STString) POIXMLTypeLoader.parse(xMLInputStream, STString.type, (XmlOptions) null);
        }

        public static STString parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STString) POIXMLTypeLoader.parse(xMLInputStream, STString.type, xmlOptions);
        }

        public static STString parse(Node node) {
            return (STString) POIXMLTypeLoader.parse(node, STString.type, (XmlOptions) null);
        }

        public static STString parse(Node node, XmlOptions xmlOptions) {
            return (STString) POIXMLTypeLoader.parse(node, STString.type, xmlOptions);
        }
    }
}
