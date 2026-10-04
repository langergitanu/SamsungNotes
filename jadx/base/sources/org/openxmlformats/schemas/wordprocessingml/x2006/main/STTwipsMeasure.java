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
public interface STTwipsMeasure extends STUnsignedDecimalNumber {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STTwipsMeasure.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "sttwipsmeasure1e23type");

    public static final class Factory {
        private Factory() {
        }

        public static STTwipsMeasure newInstance() {
            return (STTwipsMeasure) POIXMLTypeLoader.newInstance(STTwipsMeasure.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTwipsMeasure.type, null);
        }

        public static STTwipsMeasure newValue(Object obj) {
            return (STTwipsMeasure) STTwipsMeasure.type.newValue(obj);
        }

        public static STTwipsMeasure parse(File file) {
            return (STTwipsMeasure) POIXMLTypeLoader.parse(file, STTwipsMeasure.type, (XmlOptions) null);
        }

        public static STTwipsMeasure newInstance(XmlOptions xmlOptions) {
            return (STTwipsMeasure) POIXMLTypeLoader.newInstance(STTwipsMeasure.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTwipsMeasure.type, xmlOptions);
        }

        public static STTwipsMeasure parse(File file, XmlOptions xmlOptions) {
            return (STTwipsMeasure) POIXMLTypeLoader.parse(file, STTwipsMeasure.type, xmlOptions);
        }

        public static STTwipsMeasure parse(InputStream inputStream) {
            return (STTwipsMeasure) POIXMLTypeLoader.parse(inputStream, STTwipsMeasure.type, (XmlOptions) null);
        }

        public static STTwipsMeasure parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STTwipsMeasure) POIXMLTypeLoader.parse(inputStream, STTwipsMeasure.type, xmlOptions);
        }

        public static STTwipsMeasure parse(Reader reader) {
            return (STTwipsMeasure) POIXMLTypeLoader.parse(reader, STTwipsMeasure.type, (XmlOptions) null);
        }

        public static STTwipsMeasure parse(Reader reader, XmlOptions xmlOptions) {
            return (STTwipsMeasure) POIXMLTypeLoader.parse(reader, STTwipsMeasure.type, xmlOptions);
        }

        public static STTwipsMeasure parse(String str) {
            return (STTwipsMeasure) POIXMLTypeLoader.parse(str, STTwipsMeasure.type, (XmlOptions) null);
        }

        public static STTwipsMeasure parse(String str, XmlOptions xmlOptions) {
            return (STTwipsMeasure) POIXMLTypeLoader.parse(str, STTwipsMeasure.type, xmlOptions);
        }

        public static STTwipsMeasure parse(URL url) {
            return (STTwipsMeasure) POIXMLTypeLoader.parse(url, STTwipsMeasure.type, (XmlOptions) null);
        }

        public static STTwipsMeasure parse(URL url, XmlOptions xmlOptions) {
            return (STTwipsMeasure) POIXMLTypeLoader.parse(url, STTwipsMeasure.type, xmlOptions);
        }

        public static STTwipsMeasure parse(XMLStreamReader xMLStreamReader) {
            return (STTwipsMeasure) POIXMLTypeLoader.parse(xMLStreamReader, STTwipsMeasure.type, (XmlOptions) null);
        }

        public static STTwipsMeasure parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STTwipsMeasure) POIXMLTypeLoader.parse(xMLStreamReader, STTwipsMeasure.type, xmlOptions);
        }

        public static STTwipsMeasure parse(XMLInputStream xMLInputStream) {
            return (STTwipsMeasure) POIXMLTypeLoader.parse(xMLInputStream, STTwipsMeasure.type, (XmlOptions) null);
        }

        public static STTwipsMeasure parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STTwipsMeasure) POIXMLTypeLoader.parse(xMLInputStream, STTwipsMeasure.type, xmlOptions);
        }

        public static STTwipsMeasure parse(Node node) {
            return (STTwipsMeasure) POIXMLTypeLoader.parse(node, STTwipsMeasure.type, (XmlOptions) null);
        }

        public static STTwipsMeasure parse(Node node, XmlOptions xmlOptions) {
            return (STTwipsMeasure) POIXMLTypeLoader.parse(node, STTwipsMeasure.type, xmlOptions);
        }
    }
}
