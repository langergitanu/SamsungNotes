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
public interface STTextSpacingPercent extends STPercentage {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STTextSpacingPercent.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "sttextspacingpercentde3atype");

    public static final class Factory {
        private Factory() {
        }

        public static STTextSpacingPercent newInstance() {
            return (STTextSpacingPercent) POIXMLTypeLoader.newInstance(STTextSpacingPercent.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextSpacingPercent.type, null);
        }

        public static STTextSpacingPercent newValue(Object obj) {
            return (STTextSpacingPercent) STTextSpacingPercent.type.newValue(obj);
        }

        public static STTextSpacingPercent parse(File file) {
            return (STTextSpacingPercent) POIXMLTypeLoader.parse(file, STTextSpacingPercent.type, (XmlOptions) null);
        }

        public static STTextSpacingPercent newInstance(XmlOptions xmlOptions) {
            return (STTextSpacingPercent) POIXMLTypeLoader.newInstance(STTextSpacingPercent.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextSpacingPercent.type, xmlOptions);
        }

        public static STTextSpacingPercent parse(File file, XmlOptions xmlOptions) {
            return (STTextSpacingPercent) POIXMLTypeLoader.parse(file, STTextSpacingPercent.type, xmlOptions);
        }

        public static STTextSpacingPercent parse(InputStream inputStream) {
            return (STTextSpacingPercent) POIXMLTypeLoader.parse(inputStream, STTextSpacingPercent.type, (XmlOptions) null);
        }

        public static STTextSpacingPercent parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STTextSpacingPercent) POIXMLTypeLoader.parse(inputStream, STTextSpacingPercent.type, xmlOptions);
        }

        public static STTextSpacingPercent parse(Reader reader) {
            return (STTextSpacingPercent) POIXMLTypeLoader.parse(reader, STTextSpacingPercent.type, (XmlOptions) null);
        }

        public static STTextSpacingPercent parse(Reader reader, XmlOptions xmlOptions) {
            return (STTextSpacingPercent) POIXMLTypeLoader.parse(reader, STTextSpacingPercent.type, xmlOptions);
        }

        public static STTextSpacingPercent parse(String str) {
            return (STTextSpacingPercent) POIXMLTypeLoader.parse(str, STTextSpacingPercent.type, (XmlOptions) null);
        }

        public static STTextSpacingPercent parse(String str, XmlOptions xmlOptions) {
            return (STTextSpacingPercent) POIXMLTypeLoader.parse(str, STTextSpacingPercent.type, xmlOptions);
        }

        public static STTextSpacingPercent parse(URL url) {
            return (STTextSpacingPercent) POIXMLTypeLoader.parse(url, STTextSpacingPercent.type, (XmlOptions) null);
        }

        public static STTextSpacingPercent parse(URL url, XmlOptions xmlOptions) {
            return (STTextSpacingPercent) POIXMLTypeLoader.parse(url, STTextSpacingPercent.type, xmlOptions);
        }

        public static STTextSpacingPercent parse(XMLStreamReader xMLStreamReader) {
            return (STTextSpacingPercent) POIXMLTypeLoader.parse(xMLStreamReader, STTextSpacingPercent.type, (XmlOptions) null);
        }

        public static STTextSpacingPercent parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STTextSpacingPercent) POIXMLTypeLoader.parse(xMLStreamReader, STTextSpacingPercent.type, xmlOptions);
        }

        public static STTextSpacingPercent parse(XMLInputStream xMLInputStream) {
            return (STTextSpacingPercent) POIXMLTypeLoader.parse(xMLInputStream, STTextSpacingPercent.type, (XmlOptions) null);
        }

        public static STTextSpacingPercent parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STTextSpacingPercent) POIXMLTypeLoader.parse(xMLInputStream, STTextSpacingPercent.type, xmlOptions);
        }

        public static STTextSpacingPercent parse(Node node) {
            return (STTextSpacingPercent) POIXMLTypeLoader.parse(node, STTextSpacingPercent.type, (XmlOptions) null);
        }

        public static STTextSpacingPercent parse(Node node, XmlOptions xmlOptions) {
            return (STTextSpacingPercent) POIXMLTypeLoader.parse(node, STTextSpacingPercent.type, xmlOptions);
        }
    }
}
