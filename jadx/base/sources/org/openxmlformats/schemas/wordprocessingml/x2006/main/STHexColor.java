package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlAnySimpleType;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface STHexColor extends XmlAnySimpleType {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STHexColor.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "sthexcolor55d0type");

    public static final class Factory {
        private Factory() {
        }

        public static STHexColor newInstance() {
            return (STHexColor) POIXMLTypeLoader.newInstance(STHexColor.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STHexColor.type, null);
        }

        public static STHexColor newValue(Object obj) {
            return (STHexColor) STHexColor.type.newValue(obj);
        }

        public static STHexColor parse(File file) {
            return (STHexColor) POIXMLTypeLoader.parse(file, STHexColor.type, (XmlOptions) null);
        }

        public static STHexColor newInstance(XmlOptions xmlOptions) {
            return (STHexColor) POIXMLTypeLoader.newInstance(STHexColor.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STHexColor.type, xmlOptions);
        }

        public static STHexColor parse(File file, XmlOptions xmlOptions) {
            return (STHexColor) POIXMLTypeLoader.parse(file, STHexColor.type, xmlOptions);
        }

        public static STHexColor parse(InputStream inputStream) {
            return (STHexColor) POIXMLTypeLoader.parse(inputStream, STHexColor.type, (XmlOptions) null);
        }

        public static STHexColor parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STHexColor) POIXMLTypeLoader.parse(inputStream, STHexColor.type, xmlOptions);
        }

        public static STHexColor parse(Reader reader) {
            return (STHexColor) POIXMLTypeLoader.parse(reader, STHexColor.type, (XmlOptions) null);
        }

        public static STHexColor parse(Reader reader, XmlOptions xmlOptions) {
            return (STHexColor) POIXMLTypeLoader.parse(reader, STHexColor.type, xmlOptions);
        }

        public static STHexColor parse(String str) {
            return (STHexColor) POIXMLTypeLoader.parse(str, STHexColor.type, (XmlOptions) null);
        }

        public static STHexColor parse(String str, XmlOptions xmlOptions) {
            return (STHexColor) POIXMLTypeLoader.parse(str, STHexColor.type, xmlOptions);
        }

        public static STHexColor parse(URL url) {
            return (STHexColor) POIXMLTypeLoader.parse(url, STHexColor.type, (XmlOptions) null);
        }

        public static STHexColor parse(URL url, XmlOptions xmlOptions) {
            return (STHexColor) POIXMLTypeLoader.parse(url, STHexColor.type, xmlOptions);
        }

        public static STHexColor parse(XMLStreamReader xMLStreamReader) {
            return (STHexColor) POIXMLTypeLoader.parse(xMLStreamReader, STHexColor.type, (XmlOptions) null);
        }

        public static STHexColor parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STHexColor) POIXMLTypeLoader.parse(xMLStreamReader, STHexColor.type, xmlOptions);
        }

        public static STHexColor parse(XMLInputStream xMLInputStream) {
            return (STHexColor) POIXMLTypeLoader.parse(xMLInputStream, STHexColor.type, (XmlOptions) null);
        }

        public static STHexColor parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STHexColor) POIXMLTypeLoader.parse(xMLInputStream, STHexColor.type, xmlOptions);
        }

        public static STHexColor parse(Node node) {
            return (STHexColor) POIXMLTypeLoader.parse(node, STHexColor.type, (XmlOptions) null);
        }

        public static STHexColor parse(Node node, XmlOptions xmlOptions) {
            return (STHexColor) POIXMLTypeLoader.parse(node, STHexColor.type, xmlOptions);
        }
    }

    Object getObjectValue();

    SchemaType instanceType();

    void objectSet(Object obj);

    Object objectValue();

    void setObjectValue(Object obj);
}
