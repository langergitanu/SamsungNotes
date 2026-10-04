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
public final class STAlgType$Factory {
    private STAlgType$Factory() {
    }

    public static STAlgType newInstance() {
        return POIXMLTypeLoader.newInstance(STAlgType.type, null);
    }

    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
        return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STAlgType.type, null);
    }

    public static STAlgType newValue(Object obj) {
        return STAlgType.type.newValue(obj);
    }

    public static STAlgType parse(File file) {
        return POIXMLTypeLoader.parse(file, STAlgType.type, (XmlOptions) null);
    }

    public static STAlgType newInstance(XmlOptions xmlOptions) {
        return POIXMLTypeLoader.newInstance(STAlgType.type, xmlOptions);
    }

    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STAlgType.type, xmlOptions);
    }

    public static STAlgType parse(File file, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(file, STAlgType.type, xmlOptions);
    }

    public static STAlgType parse(InputStream inputStream) {
        return POIXMLTypeLoader.parse(inputStream, STAlgType.type, (XmlOptions) null);
    }

    public static STAlgType parse(InputStream inputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(inputStream, STAlgType.type, xmlOptions);
    }

    public static STAlgType parse(Reader reader) {
        return POIXMLTypeLoader.parse(reader, STAlgType.type, (XmlOptions) null);
    }

    public static STAlgType parse(Reader reader, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(reader, STAlgType.type, xmlOptions);
    }

    public static STAlgType parse(String str) {
        return POIXMLTypeLoader.parse(str, STAlgType.type, (XmlOptions) null);
    }

    public static STAlgType parse(String str, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(str, STAlgType.type, xmlOptions);
    }

    public static STAlgType parse(URL url) {
        return POIXMLTypeLoader.parse(url, STAlgType.type, (XmlOptions) null);
    }

    public static STAlgType parse(URL url, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(url, STAlgType.type, xmlOptions);
    }

    public static STAlgType parse(XMLStreamReader xMLStreamReader) {
        return POIXMLTypeLoader.parse(xMLStreamReader, STAlgType.type, (XmlOptions) null);
    }

    public static STAlgType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(xMLStreamReader, STAlgType.type, xmlOptions);
    }

    public static STAlgType parse(XMLInputStream xMLInputStream) {
        return POIXMLTypeLoader.parse(xMLInputStream, STAlgType.type, (XmlOptions) null);
    }

    public static STAlgType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(xMLInputStream, STAlgType.type, xmlOptions);
    }

    public static STAlgType parse(Node node) {
        return POIXMLTypeLoader.parse(node, STAlgType.type, (XmlOptions) null);
    }

    public static STAlgType parse(Node node, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(node, STAlgType.type, xmlOptions);
    }
}
