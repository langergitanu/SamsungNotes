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
public interface STTextFontScalePercent extends STPercentage {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STTextFontScalePercent.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "sttextfontscalepercente6c2type");

    public static final class Factory {
        private Factory() {
        }

        public static STTextFontScalePercent newInstance() {
            return (STTextFontScalePercent) POIXMLTypeLoader.newInstance(STTextFontScalePercent.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextFontScalePercent.type, null);
        }

        public static STTextFontScalePercent newValue(Object obj) {
            return (STTextFontScalePercent) STTextFontScalePercent.type.newValue(obj);
        }

        public static STTextFontScalePercent parse(File file) {
            return (STTextFontScalePercent) POIXMLTypeLoader.parse(file, STTextFontScalePercent.type, (XmlOptions) null);
        }

        public static STTextFontScalePercent newInstance(XmlOptions xmlOptions) {
            return (STTextFontScalePercent) POIXMLTypeLoader.newInstance(STTextFontScalePercent.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextFontScalePercent.type, xmlOptions);
        }

        public static STTextFontScalePercent parse(File file, XmlOptions xmlOptions) {
            return (STTextFontScalePercent) POIXMLTypeLoader.parse(file, STTextFontScalePercent.type, xmlOptions);
        }

        public static STTextFontScalePercent parse(InputStream inputStream) {
            return (STTextFontScalePercent) POIXMLTypeLoader.parse(inputStream, STTextFontScalePercent.type, (XmlOptions) null);
        }

        public static STTextFontScalePercent parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STTextFontScalePercent) POIXMLTypeLoader.parse(inputStream, STTextFontScalePercent.type, xmlOptions);
        }

        public static STTextFontScalePercent parse(Reader reader) {
            return (STTextFontScalePercent) POIXMLTypeLoader.parse(reader, STTextFontScalePercent.type, (XmlOptions) null);
        }

        public static STTextFontScalePercent parse(Reader reader, XmlOptions xmlOptions) {
            return (STTextFontScalePercent) POIXMLTypeLoader.parse(reader, STTextFontScalePercent.type, xmlOptions);
        }

        public static STTextFontScalePercent parse(String str) {
            return (STTextFontScalePercent) POIXMLTypeLoader.parse(str, STTextFontScalePercent.type, (XmlOptions) null);
        }

        public static STTextFontScalePercent parse(String str, XmlOptions xmlOptions) {
            return (STTextFontScalePercent) POIXMLTypeLoader.parse(str, STTextFontScalePercent.type, xmlOptions);
        }

        public static STTextFontScalePercent parse(URL url) {
            return (STTextFontScalePercent) POIXMLTypeLoader.parse(url, STTextFontScalePercent.type, (XmlOptions) null);
        }

        public static STTextFontScalePercent parse(URL url, XmlOptions xmlOptions) {
            return (STTextFontScalePercent) POIXMLTypeLoader.parse(url, STTextFontScalePercent.type, xmlOptions);
        }

        public static STTextFontScalePercent parse(XMLStreamReader xMLStreamReader) {
            return (STTextFontScalePercent) POIXMLTypeLoader.parse(xMLStreamReader, STTextFontScalePercent.type, (XmlOptions) null);
        }

        public static STTextFontScalePercent parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STTextFontScalePercent) POIXMLTypeLoader.parse(xMLStreamReader, STTextFontScalePercent.type, xmlOptions);
        }

        public static STTextFontScalePercent parse(XMLInputStream xMLInputStream) {
            return (STTextFontScalePercent) POIXMLTypeLoader.parse(xMLInputStream, STTextFontScalePercent.type, (XmlOptions) null);
        }

        public static STTextFontScalePercent parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STTextFontScalePercent) POIXMLTypeLoader.parse(xMLInputStream, STTextFontScalePercent.type, xmlOptions);
        }

        public static STTextFontScalePercent parse(Node node) {
            return (STTextFontScalePercent) POIXMLTypeLoader.parse(node, STTextFontScalePercent.type, (XmlOptions) null);
        }

        public static STTextFontScalePercent parse(Node node, XmlOptions xmlOptions) {
            return (STTextFontScalePercent) POIXMLTypeLoader.parse(node, STTextFontScalePercent.type, xmlOptions);
        }
    }
}
