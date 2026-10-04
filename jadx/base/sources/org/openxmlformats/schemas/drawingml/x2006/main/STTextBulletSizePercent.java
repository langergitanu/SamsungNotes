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
public interface STTextBulletSizePercent extends STPercentage {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STTextBulletSizePercent.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "sttextbulletsizepercentb516type");

    public static final class Factory {
        private Factory() {
        }

        public static STTextBulletSizePercent newInstance() {
            return (STTextBulletSizePercent) POIXMLTypeLoader.newInstance(STTextBulletSizePercent.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextBulletSizePercent.type, null);
        }

        public static STTextBulletSizePercent newValue(Object obj) {
            return (STTextBulletSizePercent) STTextBulletSizePercent.type.newValue(obj);
        }

        public static STTextBulletSizePercent parse(File file) {
            return (STTextBulletSizePercent) POIXMLTypeLoader.parse(file, STTextBulletSizePercent.type, (XmlOptions) null);
        }

        public static STTextBulletSizePercent newInstance(XmlOptions xmlOptions) {
            return (STTextBulletSizePercent) POIXMLTypeLoader.newInstance(STTextBulletSizePercent.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextBulletSizePercent.type, xmlOptions);
        }

        public static STTextBulletSizePercent parse(File file, XmlOptions xmlOptions) {
            return (STTextBulletSizePercent) POIXMLTypeLoader.parse(file, STTextBulletSizePercent.type, xmlOptions);
        }

        public static STTextBulletSizePercent parse(InputStream inputStream) {
            return (STTextBulletSizePercent) POIXMLTypeLoader.parse(inputStream, STTextBulletSizePercent.type, (XmlOptions) null);
        }

        public static STTextBulletSizePercent parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STTextBulletSizePercent) POIXMLTypeLoader.parse(inputStream, STTextBulletSizePercent.type, xmlOptions);
        }

        public static STTextBulletSizePercent parse(Reader reader) {
            return (STTextBulletSizePercent) POIXMLTypeLoader.parse(reader, STTextBulletSizePercent.type, (XmlOptions) null);
        }

        public static STTextBulletSizePercent parse(Reader reader, XmlOptions xmlOptions) {
            return (STTextBulletSizePercent) POIXMLTypeLoader.parse(reader, STTextBulletSizePercent.type, xmlOptions);
        }

        public static STTextBulletSizePercent parse(String str) {
            return (STTextBulletSizePercent) POIXMLTypeLoader.parse(str, STTextBulletSizePercent.type, (XmlOptions) null);
        }

        public static STTextBulletSizePercent parse(String str, XmlOptions xmlOptions) {
            return (STTextBulletSizePercent) POIXMLTypeLoader.parse(str, STTextBulletSizePercent.type, xmlOptions);
        }

        public static STTextBulletSizePercent parse(URL url) {
            return (STTextBulletSizePercent) POIXMLTypeLoader.parse(url, STTextBulletSizePercent.type, (XmlOptions) null);
        }

        public static STTextBulletSizePercent parse(URL url, XmlOptions xmlOptions) {
            return (STTextBulletSizePercent) POIXMLTypeLoader.parse(url, STTextBulletSizePercent.type, xmlOptions);
        }

        public static STTextBulletSizePercent parse(XMLStreamReader xMLStreamReader) {
            return (STTextBulletSizePercent) POIXMLTypeLoader.parse(xMLStreamReader, STTextBulletSizePercent.type, (XmlOptions) null);
        }

        public static STTextBulletSizePercent parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STTextBulletSizePercent) POIXMLTypeLoader.parse(xMLStreamReader, STTextBulletSizePercent.type, xmlOptions);
        }

        public static STTextBulletSizePercent parse(XMLInputStream xMLInputStream) {
            return (STTextBulletSizePercent) POIXMLTypeLoader.parse(xMLInputStream, STTextBulletSizePercent.type, (XmlOptions) null);
        }

        public static STTextBulletSizePercent parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STTextBulletSizePercent) POIXMLTypeLoader.parse(xMLInputStream, STTextBulletSizePercent.type, xmlOptions);
        }

        public static STTextBulletSizePercent parse(Node node) {
            return (STTextBulletSizePercent) POIXMLTypeLoader.parse(node, STTextBulletSizePercent.type, (XmlOptions) null);
        }

        public static STTextBulletSizePercent parse(Node node, XmlOptions xmlOptions) {
            return (STTextBulletSizePercent) POIXMLTypeLoader.parse(node, STTextBulletSizePercent.type, xmlOptions);
        }
    }
}
