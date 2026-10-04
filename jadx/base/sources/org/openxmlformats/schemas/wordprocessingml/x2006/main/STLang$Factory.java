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
public final class STLang$Factory {
    private STLang$Factory() {
    }

    public static STLang newInstance() {
        return POIXMLTypeLoader.newInstance(STLang.type, null);
    }

    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
        return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STLang.type, null);
    }

    public static STLang newValue(Object obj) {
        return STLang.type.newValue(obj);
    }

    public static STLang parse(File file) {
        return POIXMLTypeLoader.parse(file, STLang.type, (XmlOptions) null);
    }

    public static STLang newInstance(XmlOptions xmlOptions) {
        return POIXMLTypeLoader.newInstance(STLang.type, xmlOptions);
    }

    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STLang.type, xmlOptions);
    }

    public static STLang parse(File file, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(file, STLang.type, xmlOptions);
    }

    public static STLang parse(InputStream inputStream) {
        return POIXMLTypeLoader.parse(inputStream, STLang.type, (XmlOptions) null);
    }

    public static STLang parse(InputStream inputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(inputStream, STLang.type, xmlOptions);
    }

    public static STLang parse(Reader reader) {
        return POIXMLTypeLoader.parse(reader, STLang.type, (XmlOptions) null);
    }

    public static STLang parse(Reader reader, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(reader, STLang.type, xmlOptions);
    }

    public static STLang parse(String str) {
        return POIXMLTypeLoader.parse(str, STLang.type, (XmlOptions) null);
    }

    public static STLang parse(String str, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(str, STLang.type, xmlOptions);
    }

    public static STLang parse(URL url) {
        return POIXMLTypeLoader.parse(url, STLang.type, (XmlOptions) null);
    }

    public static STLang parse(URL url, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(url, STLang.type, xmlOptions);
    }

    public static STLang parse(XMLStreamReader xMLStreamReader) {
        return POIXMLTypeLoader.parse(xMLStreamReader, STLang.type, (XmlOptions) null);
    }

    public static STLang parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(xMLStreamReader, STLang.type, xmlOptions);
    }

    public static STLang parse(XMLInputStream xMLInputStream) {
        return POIXMLTypeLoader.parse(xMLInputStream, STLang.type, (XmlOptions) null);
    }

    public static STLang parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(xMLInputStream, STLang.type, xmlOptions);
    }

    public static STLang parse(Node node) {
        return POIXMLTypeLoader.parse(node, STLang.type, (XmlOptions) null);
    }

    public static STLang parse(Node node, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(node, STLang.type, xmlOptions);
    }
}
