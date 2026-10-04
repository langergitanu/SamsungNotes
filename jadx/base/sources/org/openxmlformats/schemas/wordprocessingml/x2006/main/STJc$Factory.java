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
public final class STJc$Factory {
    private STJc$Factory() {
    }

    public static STJc newInstance() {
        return POIXMLTypeLoader.newInstance(STJc.type, null);
    }

    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
        return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STJc.type, null);
    }

    public static STJc newValue(Object obj) {
        return STJc.type.newValue(obj);
    }

    public static STJc parse(File file) {
        return POIXMLTypeLoader.parse(file, STJc.type, (XmlOptions) null);
    }

    public static STJc newInstance(XmlOptions xmlOptions) {
        return POIXMLTypeLoader.newInstance(STJc.type, xmlOptions);
    }

    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STJc.type, xmlOptions);
    }

    public static STJc parse(File file, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(file, STJc.type, xmlOptions);
    }

    public static STJc parse(InputStream inputStream) {
        return POIXMLTypeLoader.parse(inputStream, STJc.type, (XmlOptions) null);
    }

    public static STJc parse(InputStream inputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(inputStream, STJc.type, xmlOptions);
    }

    public static STJc parse(Reader reader) {
        return POIXMLTypeLoader.parse(reader, STJc.type, (XmlOptions) null);
    }

    public static STJc parse(Reader reader, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(reader, STJc.type, xmlOptions);
    }

    public static STJc parse(String str) {
        return POIXMLTypeLoader.parse(str, STJc.type, (XmlOptions) null);
    }

    public static STJc parse(String str, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(str, STJc.type, xmlOptions);
    }

    public static STJc parse(URL url) {
        return POIXMLTypeLoader.parse(url, STJc.type, (XmlOptions) null);
    }

    public static STJc parse(URL url, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(url, STJc.type, xmlOptions);
    }

    public static STJc parse(XMLStreamReader xMLStreamReader) {
        return POIXMLTypeLoader.parse(xMLStreamReader, STJc.type, (XmlOptions) null);
    }

    public static STJc parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(xMLStreamReader, STJc.type, xmlOptions);
    }

    public static STJc parse(XMLInputStream xMLInputStream) {
        return POIXMLTypeLoader.parse(xMLInputStream, STJc.type, (XmlOptions) null);
    }

    public static STJc parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(xMLInputStream, STJc.type, xmlOptions);
    }

    public static STJc parse(Node node) {
        return POIXMLTypeLoader.parse(node, STJc.type, (XmlOptions) null);
    }

    public static STJc parse(Node node, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(node, STJc.type, xmlOptions);
    }
}
