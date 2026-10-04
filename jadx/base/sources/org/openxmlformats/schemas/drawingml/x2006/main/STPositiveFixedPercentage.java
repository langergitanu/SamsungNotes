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
public interface STPositiveFixedPercentage extends STPercentage {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STPositiveFixedPercentage.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "stpositivefixedpercentagee756type");

    public static final class Factory {
        private Factory() {
        }

        public static STPositiveFixedPercentage newInstance() {
            return (STPositiveFixedPercentage) POIXMLTypeLoader.newInstance(STPositiveFixedPercentage.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STPositiveFixedPercentage.type, null);
        }

        public static STPositiveFixedPercentage newValue(Object obj) {
            return (STPositiveFixedPercentage) STPositiveFixedPercentage.type.newValue(obj);
        }

        public static STPositiveFixedPercentage parse(File file) {
            return (STPositiveFixedPercentage) POIXMLTypeLoader.parse(file, STPositiveFixedPercentage.type, (XmlOptions) null);
        }

        public static STPositiveFixedPercentage newInstance(XmlOptions xmlOptions) {
            return (STPositiveFixedPercentage) POIXMLTypeLoader.newInstance(STPositiveFixedPercentage.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STPositiveFixedPercentage.type, xmlOptions);
        }

        public static STPositiveFixedPercentage parse(File file, XmlOptions xmlOptions) {
            return (STPositiveFixedPercentage) POIXMLTypeLoader.parse(file, STPositiveFixedPercentage.type, xmlOptions);
        }

        public static STPositiveFixedPercentage parse(InputStream inputStream) {
            return (STPositiveFixedPercentage) POIXMLTypeLoader.parse(inputStream, STPositiveFixedPercentage.type, (XmlOptions) null);
        }

        public static STPositiveFixedPercentage parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STPositiveFixedPercentage) POIXMLTypeLoader.parse(inputStream, STPositiveFixedPercentage.type, xmlOptions);
        }

        public static STPositiveFixedPercentage parse(Reader reader) {
            return (STPositiveFixedPercentage) POIXMLTypeLoader.parse(reader, STPositiveFixedPercentage.type, (XmlOptions) null);
        }

        public static STPositiveFixedPercentage parse(Reader reader, XmlOptions xmlOptions) {
            return (STPositiveFixedPercentage) POIXMLTypeLoader.parse(reader, STPositiveFixedPercentage.type, xmlOptions);
        }

        public static STPositiveFixedPercentage parse(String str) {
            return (STPositiveFixedPercentage) POIXMLTypeLoader.parse(str, STPositiveFixedPercentage.type, (XmlOptions) null);
        }

        public static STPositiveFixedPercentage parse(String str, XmlOptions xmlOptions) {
            return (STPositiveFixedPercentage) POIXMLTypeLoader.parse(str, STPositiveFixedPercentage.type, xmlOptions);
        }

        public static STPositiveFixedPercentage parse(URL url) {
            return (STPositiveFixedPercentage) POIXMLTypeLoader.parse(url, STPositiveFixedPercentage.type, (XmlOptions) null);
        }

        public static STPositiveFixedPercentage parse(URL url, XmlOptions xmlOptions) {
            return (STPositiveFixedPercentage) POIXMLTypeLoader.parse(url, STPositiveFixedPercentage.type, xmlOptions);
        }

        public static STPositiveFixedPercentage parse(XMLStreamReader xMLStreamReader) {
            return (STPositiveFixedPercentage) POIXMLTypeLoader.parse(xMLStreamReader, STPositiveFixedPercentage.type, (XmlOptions) null);
        }

        public static STPositiveFixedPercentage parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STPositiveFixedPercentage) POIXMLTypeLoader.parse(xMLStreamReader, STPositiveFixedPercentage.type, xmlOptions);
        }

        public static STPositiveFixedPercentage parse(XMLInputStream xMLInputStream) {
            return (STPositiveFixedPercentage) POIXMLTypeLoader.parse(xMLInputStream, STPositiveFixedPercentage.type, (XmlOptions) null);
        }

        public static STPositiveFixedPercentage parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STPositiveFixedPercentage) POIXMLTypeLoader.parse(xMLInputStream, STPositiveFixedPercentage.type, xmlOptions);
        }

        public static STPositiveFixedPercentage parse(Node node) {
            return (STPositiveFixedPercentage) POIXMLTypeLoader.parse(node, STPositiveFixedPercentage.type, (XmlOptions) null);
        }

        public static STPositiveFixedPercentage parse(Node node, XmlOptions xmlOptions) {
            return (STPositiveFixedPercentage) POIXMLTypeLoader.parse(node, STPositiveFixedPercentage.type, xmlOptions);
        }
    }
}
