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
public final class STSignedTwipsMeasure$Factory {
    private STSignedTwipsMeasure$Factory() {
    }

    public static STSignedTwipsMeasure newInstance() {
        return POIXMLTypeLoader.newInstance(STSignedTwipsMeasure.type, null);
    }

    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
        return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STSignedTwipsMeasure.type, null);
    }

    public static STSignedTwipsMeasure newValue(Object obj) {
        return STSignedTwipsMeasure.type.newValue(obj);
    }

    public static STSignedTwipsMeasure parse(File file) {
        return POIXMLTypeLoader.parse(file, STSignedTwipsMeasure.type, (XmlOptions) null);
    }

    public static STSignedTwipsMeasure newInstance(XmlOptions xmlOptions) {
        return POIXMLTypeLoader.newInstance(STSignedTwipsMeasure.type, xmlOptions);
    }

    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STSignedTwipsMeasure.type, xmlOptions);
    }

    public static STSignedTwipsMeasure parse(File file, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(file, STSignedTwipsMeasure.type, xmlOptions);
    }

    public static STSignedTwipsMeasure parse(InputStream inputStream) {
        return POIXMLTypeLoader.parse(inputStream, STSignedTwipsMeasure.type, (XmlOptions) null);
    }

    public static STSignedTwipsMeasure parse(InputStream inputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(inputStream, STSignedTwipsMeasure.type, xmlOptions);
    }

    public static STSignedTwipsMeasure parse(Reader reader) {
        return POIXMLTypeLoader.parse(reader, STSignedTwipsMeasure.type, (XmlOptions) null);
    }

    public static STSignedTwipsMeasure parse(Reader reader, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(reader, STSignedTwipsMeasure.type, xmlOptions);
    }

    public static STSignedTwipsMeasure parse(String str) {
        return POIXMLTypeLoader.parse(str, STSignedTwipsMeasure.type, (XmlOptions) null);
    }

    public static STSignedTwipsMeasure parse(String str, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(str, STSignedTwipsMeasure.type, xmlOptions);
    }

    public static STSignedTwipsMeasure parse(URL url) {
        return POIXMLTypeLoader.parse(url, STSignedTwipsMeasure.type, (XmlOptions) null);
    }

    public static STSignedTwipsMeasure parse(URL url, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(url, STSignedTwipsMeasure.type, xmlOptions);
    }

    public static STSignedTwipsMeasure parse(XMLStreamReader xMLStreamReader) {
        return POIXMLTypeLoader.parse(xMLStreamReader, STSignedTwipsMeasure.type, (XmlOptions) null);
    }

    public static STSignedTwipsMeasure parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(xMLStreamReader, STSignedTwipsMeasure.type, xmlOptions);
    }

    public static STSignedTwipsMeasure parse(XMLInputStream xMLInputStream) {
        return POIXMLTypeLoader.parse(xMLInputStream, STSignedTwipsMeasure.type, (XmlOptions) null);
    }

    public static STSignedTwipsMeasure parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(xMLInputStream, STSignedTwipsMeasure.type, xmlOptions);
    }

    public static STSignedTwipsMeasure parse(Node node) {
        return POIXMLTypeLoader.parse(node, STSignedTwipsMeasure.type, (XmlOptions) null);
    }

    public static STSignedTwipsMeasure parse(Node node, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(node, STSignedTwipsMeasure.type, xmlOptions);
    }
}
