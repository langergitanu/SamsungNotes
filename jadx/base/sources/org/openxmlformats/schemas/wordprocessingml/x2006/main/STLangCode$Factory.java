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
public final class STLangCode$Factory {
    private STLangCode$Factory() {
    }

    public static STLangCode newInstance() {
        return POIXMLTypeLoader.newInstance(STLangCode.type, null);
    }

    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
        return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STLangCode.type, null);
    }

    public static STLangCode newValue(Object obj) {
        return STLangCode.type.newValue(obj);
    }

    public static STLangCode parse(File file) {
        return POIXMLTypeLoader.parse(file, STLangCode.type, (XmlOptions) null);
    }

    public static STLangCode newInstance(XmlOptions xmlOptions) {
        return POIXMLTypeLoader.newInstance(STLangCode.type, xmlOptions);
    }

    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STLangCode.type, xmlOptions);
    }

    public static STLangCode parse(File file, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(file, STLangCode.type, xmlOptions);
    }

    public static STLangCode parse(InputStream inputStream) {
        return POIXMLTypeLoader.parse(inputStream, STLangCode.type, (XmlOptions) null);
    }

    public static STLangCode parse(InputStream inputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(inputStream, STLangCode.type, xmlOptions);
    }

    public static STLangCode parse(Reader reader) {
        return POIXMLTypeLoader.parse(reader, STLangCode.type, (XmlOptions) null);
    }

    public static STLangCode parse(Reader reader, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(reader, STLangCode.type, xmlOptions);
    }

    public static STLangCode parse(String str) {
        return POIXMLTypeLoader.parse(str, STLangCode.type, (XmlOptions) null);
    }

    public static STLangCode parse(String str, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(str, STLangCode.type, xmlOptions);
    }

    public static STLangCode parse(URL url) {
        return POIXMLTypeLoader.parse(url, STLangCode.type, (XmlOptions) null);
    }

    public static STLangCode parse(URL url, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(url, STLangCode.type, xmlOptions);
    }

    public static STLangCode parse(XMLStreamReader xMLStreamReader) {
        return POIXMLTypeLoader.parse(xMLStreamReader, STLangCode.type, (XmlOptions) null);
    }

    public static STLangCode parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(xMLStreamReader, STLangCode.type, xmlOptions);
    }

    public static STLangCode parse(XMLInputStream xMLInputStream) {
        return POIXMLTypeLoader.parse(xMLInputStream, STLangCode.type, (XmlOptions) null);
    }

    public static STLangCode parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(xMLInputStream, STLangCode.type, xmlOptions);
    }

    public static STLangCode parse(Node node) {
        return POIXMLTypeLoader.parse(node, STLangCode.type, (XmlOptions) null);
    }

    public static STLangCode parse(Node node, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(node, STLangCode.type, xmlOptions);
    }
}
