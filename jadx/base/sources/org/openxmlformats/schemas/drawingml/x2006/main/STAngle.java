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
public interface STAngle extends XmlInt {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STAngle.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "stangle8074type");

    public static final class Factory {
        private Factory() {
        }

        public static STAngle newInstance() {
            return (STAngle) POIXMLTypeLoader.newInstance(STAngle.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STAngle.type, null);
        }

        public static STAngle newValue(Object obj) {
            return (STAngle) STAngle.type.newValue(obj);
        }

        public static STAngle parse(File file) {
            return (STAngle) POIXMLTypeLoader.parse(file, STAngle.type, (XmlOptions) null);
        }

        public static STAngle newInstance(XmlOptions xmlOptions) {
            return (STAngle) POIXMLTypeLoader.newInstance(STAngle.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STAngle.type, xmlOptions);
        }

        public static STAngle parse(File file, XmlOptions xmlOptions) {
            return (STAngle) POIXMLTypeLoader.parse(file, STAngle.type, xmlOptions);
        }

        public static STAngle parse(InputStream inputStream) {
            return (STAngle) POIXMLTypeLoader.parse(inputStream, STAngle.type, (XmlOptions) null);
        }

        public static STAngle parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STAngle) POIXMLTypeLoader.parse(inputStream, STAngle.type, xmlOptions);
        }

        public static STAngle parse(Reader reader) {
            return (STAngle) POIXMLTypeLoader.parse(reader, STAngle.type, (XmlOptions) null);
        }

        public static STAngle parse(Reader reader, XmlOptions xmlOptions) {
            return (STAngle) POIXMLTypeLoader.parse(reader, STAngle.type, xmlOptions);
        }

        public static STAngle parse(String str) {
            return (STAngle) POIXMLTypeLoader.parse(str, STAngle.type, (XmlOptions) null);
        }

        public static STAngle parse(String str, XmlOptions xmlOptions) {
            return (STAngle) POIXMLTypeLoader.parse(str, STAngle.type, xmlOptions);
        }

        public static STAngle parse(URL url) {
            return (STAngle) POIXMLTypeLoader.parse(url, STAngle.type, (XmlOptions) null);
        }

        public static STAngle parse(URL url, XmlOptions xmlOptions) {
            return (STAngle) POIXMLTypeLoader.parse(url, STAngle.type, xmlOptions);
        }

        public static STAngle parse(XMLStreamReader xMLStreamReader) {
            return (STAngle) POIXMLTypeLoader.parse(xMLStreamReader, STAngle.type, (XmlOptions) null);
        }

        public static STAngle parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STAngle) POIXMLTypeLoader.parse(xMLStreamReader, STAngle.type, xmlOptions);
        }

        public static STAngle parse(XMLInputStream xMLInputStream) {
            return (STAngle) POIXMLTypeLoader.parse(xMLInputStream, STAngle.type, (XmlOptions) null);
        }

        public static STAngle parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STAngle) POIXMLTypeLoader.parse(xMLInputStream, STAngle.type, xmlOptions);
        }

        public static STAngle parse(Node node) {
            return (STAngle) POIXMLTypeLoader.parse(node, STAngle.type, (XmlOptions) null);
        }

        public static STAngle parse(Node node, XmlOptions xmlOptions) {
            return (STAngle) POIXMLTypeLoader.parse(node, STAngle.type, xmlOptions);
        }
    }
}
