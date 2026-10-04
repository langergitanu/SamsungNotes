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
public final class STBrType$Factory {
    private STBrType$Factory() {
    }

    public static STBrType newInstance() {
        return POIXMLTypeLoader.newInstance(STBrType.type, null);
    }

    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
        return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STBrType.type, null);
    }

    public static STBrType newValue(Object obj) {
        return STBrType.type.newValue(obj);
    }

    public static STBrType parse(File file) {
        return POIXMLTypeLoader.parse(file, STBrType.type, (XmlOptions) null);
    }

    public static STBrType newInstance(XmlOptions xmlOptions) {
        return POIXMLTypeLoader.newInstance(STBrType.type, xmlOptions);
    }

    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STBrType.type, xmlOptions);
    }

    public static STBrType parse(File file, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(file, STBrType.type, xmlOptions);
    }

    public static STBrType parse(InputStream inputStream) {
        return POIXMLTypeLoader.parse(inputStream, STBrType.type, (XmlOptions) null);
    }

    public static STBrType parse(InputStream inputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(inputStream, STBrType.type, xmlOptions);
    }

    public static STBrType parse(Reader reader) {
        return POIXMLTypeLoader.parse(reader, STBrType.type, (XmlOptions) null);
    }

    public static STBrType parse(Reader reader, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(reader, STBrType.type, xmlOptions);
    }

    public static STBrType parse(String str) {
        return POIXMLTypeLoader.parse(str, STBrType.type, (XmlOptions) null);
    }

    public static STBrType parse(String str, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(str, STBrType.type, xmlOptions);
    }

    public static STBrType parse(URL url) {
        return POIXMLTypeLoader.parse(url, STBrType.type, (XmlOptions) null);
    }

    public static STBrType parse(URL url, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(url, STBrType.type, xmlOptions);
    }

    public static STBrType parse(XMLStreamReader xMLStreamReader) {
        return POIXMLTypeLoader.parse(xMLStreamReader, STBrType.type, (XmlOptions) null);
    }

    public static STBrType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(xMLStreamReader, STBrType.type, xmlOptions);
    }

    public static STBrType parse(XMLInputStream xMLInputStream) {
        return POIXMLTypeLoader.parse(xMLInputStream, STBrType.type, (XmlOptions) null);
    }

    public static STBrType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(xMLInputStream, STBrType.type, xmlOptions);
    }

    public static STBrType parse(Node node) {
        return POIXMLTypeLoader.parse(node, STBrType.type, (XmlOptions) null);
    }

    public static STBrType parse(Node node, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(node, STBrType.type, xmlOptions);
    }
}
