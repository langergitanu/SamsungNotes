package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public final class STPointMeasure$Factory {
    private STPointMeasure$Factory() {
    }

    public static STPointMeasure newInstance() {
        return POIXMLTypeLoader.newInstance(STPointMeasure.type, null);
    }

    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
        return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STPointMeasure.type, null);
    }

    public static STPointMeasure newValue(Object obj) {
        return STPointMeasure.type.newValue(obj);
    }

    public static STPointMeasure parse(File file) {
        return POIXMLTypeLoader.parse(file, STPointMeasure.type, (XmlOptions) null);
    }

    public static STPointMeasure newInstance(XmlOptions xmlOptions) {
        return POIXMLTypeLoader.newInstance(STPointMeasure.type, xmlOptions);
    }

    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STPointMeasure.type, xmlOptions);
    }

    public static STPointMeasure parse(File file, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(file, STPointMeasure.type, xmlOptions);
    }

    public static STPointMeasure parse(InputStream inputStream) {
        return POIXMLTypeLoader.parse(inputStream, STPointMeasure.type, (XmlOptions) null);
    }

    public static STPointMeasure parse(InputStream inputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(inputStream, STPointMeasure.type, xmlOptions);
    }

    public static STPointMeasure parse(Reader reader) {
        return POIXMLTypeLoader.parse(reader, STPointMeasure.type, (XmlOptions) null);
    }

    public static STPointMeasure parse(Reader reader, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(reader, STPointMeasure.type, xmlOptions);
    }

    public static STPointMeasure parse(String str) {
        return POIXMLTypeLoader.parse(str, STPointMeasure.type, (XmlOptions) null);
    }

    public static STPointMeasure parse(String str, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(str, STPointMeasure.type, xmlOptions);
    }

    public static STPointMeasure parse(URL url) {
        return POIXMLTypeLoader.parse(url, STPointMeasure.type, (XmlOptions) null);
    }

    public static STPointMeasure parse(URL url, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(url, STPointMeasure.type, xmlOptions);
    }

    public static STPointMeasure parse(XMLStreamReader xMLStreamReader) {
        return POIXMLTypeLoader.parse(xMLStreamReader, STPointMeasure.type, (XmlOptions) null);
    }

    public static STPointMeasure parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(xMLStreamReader, STPointMeasure.type, xmlOptions);
    }

    public static STPointMeasure parse(XMLInputStream xMLInputStream) {
        return POIXMLTypeLoader.parse(xMLInputStream, STPointMeasure.type, (XmlOptions) null);
    }

    public static STPointMeasure parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(xMLInputStream, STPointMeasure.type, xmlOptions);
    }

    public static STPointMeasure parse(Node node) {
        return POIXMLTypeLoader.parse(node, STPointMeasure.type, (XmlOptions) null);
    }

    public static STPointMeasure parse(Node node, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(node, STPointMeasure.type, xmlOptions);
    }
}
