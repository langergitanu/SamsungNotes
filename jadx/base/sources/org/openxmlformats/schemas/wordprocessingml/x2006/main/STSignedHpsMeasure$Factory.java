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
public final class STSignedHpsMeasure$Factory {
    private STSignedHpsMeasure$Factory() {
    }

    public static STSignedHpsMeasure newInstance() {
        return POIXMLTypeLoader.newInstance(STSignedHpsMeasure.type, null);
    }

    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
        return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STSignedHpsMeasure.type, null);
    }

    public static STSignedHpsMeasure newValue(Object obj) {
        return STSignedHpsMeasure.type.newValue(obj);
    }

    public static STSignedHpsMeasure parse(File file) {
        return POIXMLTypeLoader.parse(file, STSignedHpsMeasure.type, (XmlOptions) null);
    }

    public static STSignedHpsMeasure newInstance(XmlOptions xmlOptions) {
        return POIXMLTypeLoader.newInstance(STSignedHpsMeasure.type, xmlOptions);
    }

    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STSignedHpsMeasure.type, xmlOptions);
    }

    public static STSignedHpsMeasure parse(File file, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(file, STSignedHpsMeasure.type, xmlOptions);
    }

    public static STSignedHpsMeasure parse(InputStream inputStream) {
        return POIXMLTypeLoader.parse(inputStream, STSignedHpsMeasure.type, (XmlOptions) null);
    }

    public static STSignedHpsMeasure parse(InputStream inputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(inputStream, STSignedHpsMeasure.type, xmlOptions);
    }

    public static STSignedHpsMeasure parse(Reader reader) {
        return POIXMLTypeLoader.parse(reader, STSignedHpsMeasure.type, (XmlOptions) null);
    }

    public static STSignedHpsMeasure parse(Reader reader, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(reader, STSignedHpsMeasure.type, xmlOptions);
    }

    public static STSignedHpsMeasure parse(String str) {
        return POIXMLTypeLoader.parse(str, STSignedHpsMeasure.type, (XmlOptions) null);
    }

    public static STSignedHpsMeasure parse(String str, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(str, STSignedHpsMeasure.type, xmlOptions);
    }

    public static STSignedHpsMeasure parse(URL url) {
        return POIXMLTypeLoader.parse(url, STSignedHpsMeasure.type, (XmlOptions) null);
    }

    public static STSignedHpsMeasure parse(URL url, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(url, STSignedHpsMeasure.type, xmlOptions);
    }

    public static STSignedHpsMeasure parse(XMLStreamReader xMLStreamReader) {
        return POIXMLTypeLoader.parse(xMLStreamReader, STSignedHpsMeasure.type, (XmlOptions) null);
    }

    public static STSignedHpsMeasure parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(xMLStreamReader, STSignedHpsMeasure.type, xmlOptions);
    }

    public static STSignedHpsMeasure parse(XMLInputStream xMLInputStream) {
        return POIXMLTypeLoader.parse(xMLInputStream, STSignedHpsMeasure.type, (XmlOptions) null);
    }

    public static STSignedHpsMeasure parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(xMLInputStream, STSignedHpsMeasure.type, xmlOptions);
    }

    public static STSignedHpsMeasure parse(Node node) {
        return POIXMLTypeLoader.parse(node, STSignedHpsMeasure.type, (XmlOptions) null);
    }

    public static STSignedHpsMeasure parse(Node node, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(node, STSignedHpsMeasure.type, xmlOptions);
    }
}
