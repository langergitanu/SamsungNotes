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
public interface STPercentage extends XmlInt {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STPercentage.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "stpercentage0a85type");

    public static final class Factory {
        private Factory() {
        }

        public static STPercentage newInstance() {
            return (STPercentage) POIXMLTypeLoader.newInstance(STPercentage.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STPercentage.type, null);
        }

        public static STPercentage newValue(Object obj) {
            return (STPercentage) STPercentage.type.newValue(obj);
        }

        public static STPercentage parse(File file) {
            return (STPercentage) POIXMLTypeLoader.parse(file, STPercentage.type, (XmlOptions) null);
        }

        public static STPercentage newInstance(XmlOptions xmlOptions) {
            return (STPercentage) POIXMLTypeLoader.newInstance(STPercentage.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STPercentage.type, xmlOptions);
        }

        public static STPercentage parse(File file, XmlOptions xmlOptions) {
            return (STPercentage) POIXMLTypeLoader.parse(file, STPercentage.type, xmlOptions);
        }

        public static STPercentage parse(InputStream inputStream) {
            return (STPercentage) POIXMLTypeLoader.parse(inputStream, STPercentage.type, (XmlOptions) null);
        }

        public static STPercentage parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STPercentage) POIXMLTypeLoader.parse(inputStream, STPercentage.type, xmlOptions);
        }

        public static STPercentage parse(Reader reader) {
            return (STPercentage) POIXMLTypeLoader.parse(reader, STPercentage.type, (XmlOptions) null);
        }

        public static STPercentage parse(Reader reader, XmlOptions xmlOptions) {
            return (STPercentage) POIXMLTypeLoader.parse(reader, STPercentage.type, xmlOptions);
        }

        public static STPercentage parse(String str) {
            return (STPercentage) POIXMLTypeLoader.parse(str, STPercentage.type, (XmlOptions) null);
        }

        public static STPercentage parse(String str, XmlOptions xmlOptions) {
            return (STPercentage) POIXMLTypeLoader.parse(str, STPercentage.type, xmlOptions);
        }

        public static STPercentage parse(URL url) {
            return (STPercentage) POIXMLTypeLoader.parse(url, STPercentage.type, (XmlOptions) null);
        }

        public static STPercentage parse(URL url, XmlOptions xmlOptions) {
            return (STPercentage) POIXMLTypeLoader.parse(url, STPercentage.type, xmlOptions);
        }

        public static STPercentage parse(XMLStreamReader xMLStreamReader) {
            return (STPercentage) POIXMLTypeLoader.parse(xMLStreamReader, STPercentage.type, (XmlOptions) null);
        }

        public static STPercentage parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STPercentage) POIXMLTypeLoader.parse(xMLStreamReader, STPercentage.type, xmlOptions);
        }

        public static STPercentage parse(XMLInputStream xMLInputStream) {
            return (STPercentage) POIXMLTypeLoader.parse(xMLInputStream, STPercentage.type, (XmlOptions) null);
        }

        public static STPercentage parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STPercentage) POIXMLTypeLoader.parse(xMLInputStream, STPercentage.type, xmlOptions);
        }

        public static STPercentage parse(Node node) {
            return (STPercentage) POIXMLTypeLoader.parse(node, STPercentage.type, (XmlOptions) null);
        }

        public static STPercentage parse(Node node, XmlOptions xmlOptions) {
            return (STPercentage) POIXMLTypeLoader.parse(node, STPercentage.type, xmlOptions);
        }
    }
}
