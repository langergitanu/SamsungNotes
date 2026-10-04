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
public interface STPositiveFixedAngle extends STAngle {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STPositiveFixedAngle.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "stpositivefixedangle2503type");

    public static final class Factory {
        private Factory() {
        }

        public static STPositiveFixedAngle newInstance() {
            return (STPositiveFixedAngle) POIXMLTypeLoader.newInstance(STPositiveFixedAngle.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STPositiveFixedAngle.type, null);
        }

        public static STPositiveFixedAngle newValue(Object obj) {
            return (STPositiveFixedAngle) STPositiveFixedAngle.type.newValue(obj);
        }

        public static STPositiveFixedAngle parse(File file) {
            return (STPositiveFixedAngle) POIXMLTypeLoader.parse(file, STPositiveFixedAngle.type, (XmlOptions) null);
        }

        public static STPositiveFixedAngle newInstance(XmlOptions xmlOptions) {
            return (STPositiveFixedAngle) POIXMLTypeLoader.newInstance(STPositiveFixedAngle.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STPositiveFixedAngle.type, xmlOptions);
        }

        public static STPositiveFixedAngle parse(File file, XmlOptions xmlOptions) {
            return (STPositiveFixedAngle) POIXMLTypeLoader.parse(file, STPositiveFixedAngle.type, xmlOptions);
        }

        public static STPositiveFixedAngle parse(InputStream inputStream) {
            return (STPositiveFixedAngle) POIXMLTypeLoader.parse(inputStream, STPositiveFixedAngle.type, (XmlOptions) null);
        }

        public static STPositiveFixedAngle parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STPositiveFixedAngle) POIXMLTypeLoader.parse(inputStream, STPositiveFixedAngle.type, xmlOptions);
        }

        public static STPositiveFixedAngle parse(Reader reader) {
            return (STPositiveFixedAngle) POIXMLTypeLoader.parse(reader, STPositiveFixedAngle.type, (XmlOptions) null);
        }

        public static STPositiveFixedAngle parse(Reader reader, XmlOptions xmlOptions) {
            return (STPositiveFixedAngle) POIXMLTypeLoader.parse(reader, STPositiveFixedAngle.type, xmlOptions);
        }

        public static STPositiveFixedAngle parse(String str) {
            return (STPositiveFixedAngle) POIXMLTypeLoader.parse(str, STPositiveFixedAngle.type, (XmlOptions) null);
        }

        public static STPositiveFixedAngle parse(String str, XmlOptions xmlOptions) {
            return (STPositiveFixedAngle) POIXMLTypeLoader.parse(str, STPositiveFixedAngle.type, xmlOptions);
        }

        public static STPositiveFixedAngle parse(URL url) {
            return (STPositiveFixedAngle) POIXMLTypeLoader.parse(url, STPositiveFixedAngle.type, (XmlOptions) null);
        }

        public static STPositiveFixedAngle parse(URL url, XmlOptions xmlOptions) {
            return (STPositiveFixedAngle) POIXMLTypeLoader.parse(url, STPositiveFixedAngle.type, xmlOptions);
        }

        public static STPositiveFixedAngle parse(XMLStreamReader xMLStreamReader) {
            return (STPositiveFixedAngle) POIXMLTypeLoader.parse(xMLStreamReader, STPositiveFixedAngle.type, (XmlOptions) null);
        }

        public static STPositiveFixedAngle parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STPositiveFixedAngle) POIXMLTypeLoader.parse(xMLStreamReader, STPositiveFixedAngle.type, xmlOptions);
        }

        public static STPositiveFixedAngle parse(XMLInputStream xMLInputStream) {
            return (STPositiveFixedAngle) POIXMLTypeLoader.parse(xMLInputStream, STPositiveFixedAngle.type, (XmlOptions) null);
        }

        public static STPositiveFixedAngle parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STPositiveFixedAngle) POIXMLTypeLoader.parse(xMLInputStream, STPositiveFixedAngle.type, xmlOptions);
        }

        public static STPositiveFixedAngle parse(Node node) {
            return (STPositiveFixedAngle) POIXMLTypeLoader.parse(node, STPositiveFixedAngle.type, (XmlOptions) null);
        }

        public static STPositiveFixedAngle parse(Node node, XmlOptions xmlOptions) {
            return (STPositiveFixedAngle) POIXMLTypeLoader.parse(node, STPositiveFixedAngle.type, xmlOptions);
        }
    }
}
