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
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface STHpsMeasure extends STUnsignedDecimalNumber {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STHpsMeasure.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "sthpsmeasurec985type");

    public static final class Factory {
        private Factory() {
        }

        public static STHpsMeasure newInstance() {
            return (STHpsMeasure) POIXMLTypeLoader.newInstance(STHpsMeasure.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STHpsMeasure.type, null);
        }

        public static STHpsMeasure newValue(Object obj) {
            return (STHpsMeasure) STHpsMeasure.type.newValue(obj);
        }

        public static STHpsMeasure parse(File file) {
            return (STHpsMeasure) POIXMLTypeLoader.parse(file, STHpsMeasure.type, (XmlOptions) null);
        }

        public static STHpsMeasure newInstance(XmlOptions xmlOptions) {
            return (STHpsMeasure) POIXMLTypeLoader.newInstance(STHpsMeasure.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STHpsMeasure.type, xmlOptions);
        }

        public static STHpsMeasure parse(File file, XmlOptions xmlOptions) {
            return (STHpsMeasure) POIXMLTypeLoader.parse(file, STHpsMeasure.type, xmlOptions);
        }

        public static STHpsMeasure parse(InputStream inputStream) {
            return (STHpsMeasure) POIXMLTypeLoader.parse(inputStream, STHpsMeasure.type, (XmlOptions) null);
        }

        public static STHpsMeasure parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STHpsMeasure) POIXMLTypeLoader.parse(inputStream, STHpsMeasure.type, xmlOptions);
        }

        public static STHpsMeasure parse(Reader reader) {
            return (STHpsMeasure) POIXMLTypeLoader.parse(reader, STHpsMeasure.type, (XmlOptions) null);
        }

        public static STHpsMeasure parse(Reader reader, XmlOptions xmlOptions) {
            return (STHpsMeasure) POIXMLTypeLoader.parse(reader, STHpsMeasure.type, xmlOptions);
        }

        public static STHpsMeasure parse(String str) {
            return (STHpsMeasure) POIXMLTypeLoader.parse(str, STHpsMeasure.type, (XmlOptions) null);
        }

        public static STHpsMeasure parse(String str, XmlOptions xmlOptions) {
            return (STHpsMeasure) POIXMLTypeLoader.parse(str, STHpsMeasure.type, xmlOptions);
        }

        public static STHpsMeasure parse(URL url) {
            return (STHpsMeasure) POIXMLTypeLoader.parse(url, STHpsMeasure.type, (XmlOptions) null);
        }

        public static STHpsMeasure parse(URL url, XmlOptions xmlOptions) {
            return (STHpsMeasure) POIXMLTypeLoader.parse(url, STHpsMeasure.type, xmlOptions);
        }

        public static STHpsMeasure parse(XMLStreamReader xMLStreamReader) {
            return (STHpsMeasure) POIXMLTypeLoader.parse(xMLStreamReader, STHpsMeasure.type, (XmlOptions) null);
        }

        public static STHpsMeasure parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STHpsMeasure) POIXMLTypeLoader.parse(xMLStreamReader, STHpsMeasure.type, xmlOptions);
        }

        public static STHpsMeasure parse(XMLInputStream xMLInputStream) {
            return (STHpsMeasure) POIXMLTypeLoader.parse(xMLInputStream, STHpsMeasure.type, (XmlOptions) null);
        }

        public static STHpsMeasure parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STHpsMeasure) POIXMLTypeLoader.parse(xMLInputStream, STHpsMeasure.type, xmlOptions);
        }

        public static STHpsMeasure parse(Node node) {
            return (STHpsMeasure) POIXMLTypeLoader.parse(node, STHpsMeasure.type, (XmlOptions) null);
        }

        public static STHpsMeasure parse(Node node, XmlOptions xmlOptions) {
            return (STHpsMeasure) POIXMLTypeLoader.parse(node, STHpsMeasure.type, xmlOptions);
        }
    }
}
