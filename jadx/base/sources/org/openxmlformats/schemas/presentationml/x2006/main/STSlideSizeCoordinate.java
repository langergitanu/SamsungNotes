package org.openxmlformats.schemas.presentationml.x2006.main;

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
import org.openxmlformats.schemas.drawingml.x2006.main.STPositiveCoordinate32;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface STSlideSizeCoordinate extends STPositiveCoordinate32 {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STSlideSizeCoordinate.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "stslidesizecoordinate24b5type");

    public static final class Factory {
        private Factory() {
        }

        public static STSlideSizeCoordinate newInstance() {
            return (STSlideSizeCoordinate) POIXMLTypeLoader.newInstance(STSlideSizeCoordinate.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STSlideSizeCoordinate.type, null);
        }

        public static STSlideSizeCoordinate newValue(Object obj) {
            return (STSlideSizeCoordinate) STSlideSizeCoordinate.type.newValue(obj);
        }

        public static STSlideSizeCoordinate parse(File file) {
            return (STSlideSizeCoordinate) POIXMLTypeLoader.parse(file, STSlideSizeCoordinate.type, (XmlOptions) null);
        }

        public static STSlideSizeCoordinate newInstance(XmlOptions xmlOptions) {
            return (STSlideSizeCoordinate) POIXMLTypeLoader.newInstance(STSlideSizeCoordinate.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STSlideSizeCoordinate.type, xmlOptions);
        }

        public static STSlideSizeCoordinate parse(File file, XmlOptions xmlOptions) {
            return (STSlideSizeCoordinate) POIXMLTypeLoader.parse(file, STSlideSizeCoordinate.type, xmlOptions);
        }

        public static STSlideSizeCoordinate parse(InputStream inputStream) {
            return (STSlideSizeCoordinate) POIXMLTypeLoader.parse(inputStream, STSlideSizeCoordinate.type, (XmlOptions) null);
        }

        public static STSlideSizeCoordinate parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STSlideSizeCoordinate) POIXMLTypeLoader.parse(inputStream, STSlideSizeCoordinate.type, xmlOptions);
        }

        public static STSlideSizeCoordinate parse(Reader reader) {
            return (STSlideSizeCoordinate) POIXMLTypeLoader.parse(reader, STSlideSizeCoordinate.type, (XmlOptions) null);
        }

        public static STSlideSizeCoordinate parse(Reader reader, XmlOptions xmlOptions) {
            return (STSlideSizeCoordinate) POIXMLTypeLoader.parse(reader, STSlideSizeCoordinate.type, xmlOptions);
        }

        public static STSlideSizeCoordinate parse(String str) {
            return (STSlideSizeCoordinate) POIXMLTypeLoader.parse(str, STSlideSizeCoordinate.type, (XmlOptions) null);
        }

        public static STSlideSizeCoordinate parse(String str, XmlOptions xmlOptions) {
            return (STSlideSizeCoordinate) POIXMLTypeLoader.parse(str, STSlideSizeCoordinate.type, xmlOptions);
        }

        public static STSlideSizeCoordinate parse(URL url) {
            return (STSlideSizeCoordinate) POIXMLTypeLoader.parse(url, STSlideSizeCoordinate.type, (XmlOptions) null);
        }

        public static STSlideSizeCoordinate parse(URL url, XmlOptions xmlOptions) {
            return (STSlideSizeCoordinate) POIXMLTypeLoader.parse(url, STSlideSizeCoordinate.type, xmlOptions);
        }

        public static STSlideSizeCoordinate parse(XMLStreamReader xMLStreamReader) {
            return (STSlideSizeCoordinate) POIXMLTypeLoader.parse(xMLStreamReader, STSlideSizeCoordinate.type, (XmlOptions) null);
        }

        public static STSlideSizeCoordinate parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STSlideSizeCoordinate) POIXMLTypeLoader.parse(xMLStreamReader, STSlideSizeCoordinate.type, xmlOptions);
        }

        public static STSlideSizeCoordinate parse(XMLInputStream xMLInputStream) {
            return (STSlideSizeCoordinate) POIXMLTypeLoader.parse(xMLInputStream, STSlideSizeCoordinate.type, (XmlOptions) null);
        }

        public static STSlideSizeCoordinate parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STSlideSizeCoordinate) POIXMLTypeLoader.parse(xMLInputStream, STSlideSizeCoordinate.type, xmlOptions);
        }

        public static STSlideSizeCoordinate parse(Node node) {
            return (STSlideSizeCoordinate) POIXMLTypeLoader.parse(node, STSlideSizeCoordinate.type, (XmlOptions) null);
        }

        public static STSlideSizeCoordinate parse(Node node, XmlOptions xmlOptions) {
            return (STSlideSizeCoordinate) POIXMLTypeLoader.parse(node, STSlideSizeCoordinate.type, xmlOptions);
        }
    }
}
