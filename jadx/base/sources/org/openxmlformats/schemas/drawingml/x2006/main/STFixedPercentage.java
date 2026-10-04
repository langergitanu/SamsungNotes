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
public interface STFixedPercentage extends STPercentage {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STFixedPercentage.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "stfixedpercentagef0cftype");

    public static final class Factory {
        private Factory() {
        }

        public static STFixedPercentage newInstance() {
            return (STFixedPercentage) POIXMLTypeLoader.newInstance(STFixedPercentage.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STFixedPercentage.type, null);
        }

        public static STFixedPercentage newValue(Object obj) {
            return (STFixedPercentage) STFixedPercentage.type.newValue(obj);
        }

        public static STFixedPercentage parse(File file) {
            return (STFixedPercentage) POIXMLTypeLoader.parse(file, STFixedPercentage.type, (XmlOptions) null);
        }

        public static STFixedPercentage newInstance(XmlOptions xmlOptions) {
            return (STFixedPercentage) POIXMLTypeLoader.newInstance(STFixedPercentage.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STFixedPercentage.type, xmlOptions);
        }

        public static STFixedPercentage parse(File file, XmlOptions xmlOptions) {
            return (STFixedPercentage) POIXMLTypeLoader.parse(file, STFixedPercentage.type, xmlOptions);
        }

        public static STFixedPercentage parse(InputStream inputStream) {
            return (STFixedPercentage) POIXMLTypeLoader.parse(inputStream, STFixedPercentage.type, (XmlOptions) null);
        }

        public static STFixedPercentage parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STFixedPercentage) POIXMLTypeLoader.parse(inputStream, STFixedPercentage.type, xmlOptions);
        }

        public static STFixedPercentage parse(Reader reader) {
            return (STFixedPercentage) POIXMLTypeLoader.parse(reader, STFixedPercentage.type, (XmlOptions) null);
        }

        public static STFixedPercentage parse(Reader reader, XmlOptions xmlOptions) {
            return (STFixedPercentage) POIXMLTypeLoader.parse(reader, STFixedPercentage.type, xmlOptions);
        }

        public static STFixedPercentage parse(String str) {
            return (STFixedPercentage) POIXMLTypeLoader.parse(str, STFixedPercentage.type, (XmlOptions) null);
        }

        public static STFixedPercentage parse(String str, XmlOptions xmlOptions) {
            return (STFixedPercentage) POIXMLTypeLoader.parse(str, STFixedPercentage.type, xmlOptions);
        }

        public static STFixedPercentage parse(URL url) {
            return (STFixedPercentage) POIXMLTypeLoader.parse(url, STFixedPercentage.type, (XmlOptions) null);
        }

        public static STFixedPercentage parse(URL url, XmlOptions xmlOptions) {
            return (STFixedPercentage) POIXMLTypeLoader.parse(url, STFixedPercentage.type, xmlOptions);
        }

        public static STFixedPercentage parse(XMLStreamReader xMLStreamReader) {
            return (STFixedPercentage) POIXMLTypeLoader.parse(xMLStreamReader, STFixedPercentage.type, (XmlOptions) null);
        }

        public static STFixedPercentage parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STFixedPercentage) POIXMLTypeLoader.parse(xMLStreamReader, STFixedPercentage.type, xmlOptions);
        }

        public static STFixedPercentage parse(XMLInputStream xMLInputStream) {
            return (STFixedPercentage) POIXMLTypeLoader.parse(xMLInputStream, STFixedPercentage.type, (XmlOptions) null);
        }

        public static STFixedPercentage parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STFixedPercentage) POIXMLTypeLoader.parse(xMLInputStream, STFixedPercentage.type, xmlOptions);
        }

        public static STFixedPercentage parse(Node node) {
            return (STFixedPercentage) POIXMLTypeLoader.parse(node, STFixedPercentage.type, (XmlOptions) null);
        }

        public static STFixedPercentage parse(Node node, XmlOptions xmlOptions) {
            return (STFixedPercentage) POIXMLTypeLoader.parse(node, STFixedPercentage.type, xmlOptions);
        }
    }
}
