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
public interface STTextBulletStartAtNum extends XmlInt {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STTextBulletStartAtNum.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "sttextbulletstartatnum562btype");

    public static final class Factory {
        private Factory() {
        }

        public static STTextBulletStartAtNum newInstance() {
            return (STTextBulletStartAtNum) POIXMLTypeLoader.newInstance(STTextBulletStartAtNum.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextBulletStartAtNum.type, null);
        }

        public static STTextBulletStartAtNum newValue(Object obj) {
            return (STTextBulletStartAtNum) STTextBulletStartAtNum.type.newValue(obj);
        }

        public static STTextBulletStartAtNum parse(File file) {
            return (STTextBulletStartAtNum) POIXMLTypeLoader.parse(file, STTextBulletStartAtNum.type, (XmlOptions) null);
        }

        public static STTextBulletStartAtNum newInstance(XmlOptions xmlOptions) {
            return (STTextBulletStartAtNum) POIXMLTypeLoader.newInstance(STTextBulletStartAtNum.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextBulletStartAtNum.type, xmlOptions);
        }

        public static STTextBulletStartAtNum parse(File file, XmlOptions xmlOptions) {
            return (STTextBulletStartAtNum) POIXMLTypeLoader.parse(file, STTextBulletStartAtNum.type, xmlOptions);
        }

        public static STTextBulletStartAtNum parse(InputStream inputStream) {
            return (STTextBulletStartAtNum) POIXMLTypeLoader.parse(inputStream, STTextBulletStartAtNum.type, (XmlOptions) null);
        }

        public static STTextBulletStartAtNum parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STTextBulletStartAtNum) POIXMLTypeLoader.parse(inputStream, STTextBulletStartAtNum.type, xmlOptions);
        }

        public static STTextBulletStartAtNum parse(Reader reader) {
            return (STTextBulletStartAtNum) POIXMLTypeLoader.parse(reader, STTextBulletStartAtNum.type, (XmlOptions) null);
        }

        public static STTextBulletStartAtNum parse(Reader reader, XmlOptions xmlOptions) {
            return (STTextBulletStartAtNum) POIXMLTypeLoader.parse(reader, STTextBulletStartAtNum.type, xmlOptions);
        }

        public static STTextBulletStartAtNum parse(String str) {
            return (STTextBulletStartAtNum) POIXMLTypeLoader.parse(str, STTextBulletStartAtNum.type, (XmlOptions) null);
        }

        public static STTextBulletStartAtNum parse(String str, XmlOptions xmlOptions) {
            return (STTextBulletStartAtNum) POIXMLTypeLoader.parse(str, STTextBulletStartAtNum.type, xmlOptions);
        }

        public static STTextBulletStartAtNum parse(URL url) {
            return (STTextBulletStartAtNum) POIXMLTypeLoader.parse(url, STTextBulletStartAtNum.type, (XmlOptions) null);
        }

        public static STTextBulletStartAtNum parse(URL url, XmlOptions xmlOptions) {
            return (STTextBulletStartAtNum) POIXMLTypeLoader.parse(url, STTextBulletStartAtNum.type, xmlOptions);
        }

        public static STTextBulletStartAtNum parse(XMLStreamReader xMLStreamReader) {
            return (STTextBulletStartAtNum) POIXMLTypeLoader.parse(xMLStreamReader, STTextBulletStartAtNum.type, (XmlOptions) null);
        }

        public static STTextBulletStartAtNum parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STTextBulletStartAtNum) POIXMLTypeLoader.parse(xMLStreamReader, STTextBulletStartAtNum.type, xmlOptions);
        }

        public static STTextBulletStartAtNum parse(XMLInputStream xMLInputStream) {
            return (STTextBulletStartAtNum) POIXMLTypeLoader.parse(xMLInputStream, STTextBulletStartAtNum.type, (XmlOptions) null);
        }

        public static STTextBulletStartAtNum parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STTextBulletStartAtNum) POIXMLTypeLoader.parse(xMLInputStream, STTextBulletStartAtNum.type, xmlOptions);
        }

        public static STTextBulletStartAtNum parse(Node node) {
            return (STTextBulletStartAtNum) POIXMLTypeLoader.parse(node, STTextBulletStartAtNum.type, (XmlOptions) null);
        }

        public static STTextBulletStartAtNum parse(Node node, XmlOptions xmlOptions) {
            return (STTextBulletStartAtNum) POIXMLTypeLoader.parse(node, STTextBulletStartAtNum.type, xmlOptions);
        }
    }
}
