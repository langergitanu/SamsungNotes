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
public final class STEighthPointMeasure$Factory {
    private STEighthPointMeasure$Factory() {
    }

    public static STEighthPointMeasure newInstance() {
        return POIXMLTypeLoader.newInstance(STEighthPointMeasure.type, null);
    }

    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
        return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STEighthPointMeasure.type, null);
    }

    public static STEighthPointMeasure newValue(Object obj) {
        return STEighthPointMeasure.type.newValue(obj);
    }

    public static STEighthPointMeasure parse(File file) {
        return POIXMLTypeLoader.parse(file, STEighthPointMeasure.type, (XmlOptions) null);
    }

    public static STEighthPointMeasure newInstance(XmlOptions xmlOptions) {
        return POIXMLTypeLoader.newInstance(STEighthPointMeasure.type, xmlOptions);
    }

    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STEighthPointMeasure.type, xmlOptions);
    }

    public static STEighthPointMeasure parse(File file, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(file, STEighthPointMeasure.type, xmlOptions);
    }

    public static STEighthPointMeasure parse(InputStream inputStream) {
        return POIXMLTypeLoader.parse(inputStream, STEighthPointMeasure.type, (XmlOptions) null);
    }

    public static STEighthPointMeasure parse(InputStream inputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(inputStream, STEighthPointMeasure.type, xmlOptions);
    }

    public static STEighthPointMeasure parse(Reader reader) {
        return POIXMLTypeLoader.parse(reader, STEighthPointMeasure.type, (XmlOptions) null);
    }

    public static STEighthPointMeasure parse(Reader reader, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(reader, STEighthPointMeasure.type, xmlOptions);
    }

    public static STEighthPointMeasure parse(String str) {
        return POIXMLTypeLoader.parse(str, STEighthPointMeasure.type, (XmlOptions) null);
    }

    public static STEighthPointMeasure parse(String str, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(str, STEighthPointMeasure.type, xmlOptions);
    }

    public static STEighthPointMeasure parse(URL url) {
        return POIXMLTypeLoader.parse(url, STEighthPointMeasure.type, (XmlOptions) null);
    }

    public static STEighthPointMeasure parse(URL url, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(url, STEighthPointMeasure.type, xmlOptions);
    }

    public static STEighthPointMeasure parse(XMLStreamReader xMLStreamReader) {
        return POIXMLTypeLoader.parse(xMLStreamReader, STEighthPointMeasure.type, (XmlOptions) null);
    }

    public static STEighthPointMeasure parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(xMLStreamReader, STEighthPointMeasure.type, xmlOptions);
    }

    public static STEighthPointMeasure parse(XMLInputStream xMLInputStream) {
        return POIXMLTypeLoader.parse(xMLInputStream, STEighthPointMeasure.type, (XmlOptions) null);
    }

    public static STEighthPointMeasure parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(xMLInputStream, STEighthPointMeasure.type, xmlOptions);
    }

    public static STEighthPointMeasure parse(Node node) {
        return POIXMLTypeLoader.parse(node, STEighthPointMeasure.type, (XmlOptions) null);
    }

    public static STEighthPointMeasure parse(Node node, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(node, STEighthPointMeasure.type, xmlOptions);
    }
}
