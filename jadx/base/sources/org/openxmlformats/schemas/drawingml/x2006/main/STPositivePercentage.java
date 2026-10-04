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
public interface STPositivePercentage extends STPercentage {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STPositivePercentage.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "stpositivepercentagedb9etype");

    public static final class Factory {
        private Factory() {
        }

        public static STPositivePercentage newInstance() {
            return (STPositivePercentage) POIXMLTypeLoader.newInstance(STPositivePercentage.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STPositivePercentage.type, null);
        }

        public static STPositivePercentage newValue(Object obj) {
            return (STPositivePercentage) STPositivePercentage.type.newValue(obj);
        }

        public static STPositivePercentage parse(File file) {
            return (STPositivePercentage) POIXMLTypeLoader.parse(file, STPositivePercentage.type, (XmlOptions) null);
        }

        public static STPositivePercentage newInstance(XmlOptions xmlOptions) {
            return (STPositivePercentage) POIXMLTypeLoader.newInstance(STPositivePercentage.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STPositivePercentage.type, xmlOptions);
        }

        public static STPositivePercentage parse(File file, XmlOptions xmlOptions) {
            return (STPositivePercentage) POIXMLTypeLoader.parse(file, STPositivePercentage.type, xmlOptions);
        }

        public static STPositivePercentage parse(InputStream inputStream) {
            return (STPositivePercentage) POIXMLTypeLoader.parse(inputStream, STPositivePercentage.type, (XmlOptions) null);
        }

        public static STPositivePercentage parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STPositivePercentage) POIXMLTypeLoader.parse(inputStream, STPositivePercentage.type, xmlOptions);
        }

        public static STPositivePercentage parse(Reader reader) {
            return (STPositivePercentage) POIXMLTypeLoader.parse(reader, STPositivePercentage.type, (XmlOptions) null);
        }

        public static STPositivePercentage parse(Reader reader, XmlOptions xmlOptions) {
            return (STPositivePercentage) POIXMLTypeLoader.parse(reader, STPositivePercentage.type, xmlOptions);
        }

        public static STPositivePercentage parse(String str) {
            return (STPositivePercentage) POIXMLTypeLoader.parse(str, STPositivePercentage.type, (XmlOptions) null);
        }

        public static STPositivePercentage parse(String str, XmlOptions xmlOptions) {
            return (STPositivePercentage) POIXMLTypeLoader.parse(str, STPositivePercentage.type, xmlOptions);
        }

        public static STPositivePercentage parse(URL url) {
            return (STPositivePercentage) POIXMLTypeLoader.parse(url, STPositivePercentage.type, (XmlOptions) null);
        }

        public static STPositivePercentage parse(URL url, XmlOptions xmlOptions) {
            return (STPositivePercentage) POIXMLTypeLoader.parse(url, STPositivePercentage.type, xmlOptions);
        }

        public static STPositivePercentage parse(XMLStreamReader xMLStreamReader) {
            return (STPositivePercentage) POIXMLTypeLoader.parse(xMLStreamReader, STPositivePercentage.type, (XmlOptions) null);
        }

        public static STPositivePercentage parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STPositivePercentage) POIXMLTypeLoader.parse(xMLStreamReader, STPositivePercentage.type, xmlOptions);
        }

        public static STPositivePercentage parse(XMLInputStream xMLInputStream) {
            return (STPositivePercentage) POIXMLTypeLoader.parse(xMLInputStream, STPositivePercentage.type, (XmlOptions) null);
        }

        public static STPositivePercentage parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STPositivePercentage) POIXMLTypeLoader.parse(xMLInputStream, STPositivePercentage.type, xmlOptions);
        }

        public static STPositivePercentage parse(Node node) {
            return (STPositivePercentage) POIXMLTypeLoader.parse(node, STPositivePercentage.type, (XmlOptions) null);
        }

        public static STPositivePercentage parse(Node node, XmlOptions xmlOptions) {
            return (STPositivePercentage) POIXMLTypeLoader.parse(node, STPositivePercentage.type, xmlOptions);
        }
    }
}
