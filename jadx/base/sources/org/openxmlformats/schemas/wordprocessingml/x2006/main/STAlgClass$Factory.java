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
public final class STAlgClass$Factory {
    private STAlgClass$Factory() {
    }

    public static STAlgClass newInstance() {
        return POIXMLTypeLoader.newInstance(STAlgClass.type, null);
    }

    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
        return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STAlgClass.type, null);
    }

    public static STAlgClass newValue(Object obj) {
        return STAlgClass.type.newValue(obj);
    }

    public static STAlgClass parse(File file) {
        return POIXMLTypeLoader.parse(file, STAlgClass.type, (XmlOptions) null);
    }

    public static STAlgClass newInstance(XmlOptions xmlOptions) {
        return POIXMLTypeLoader.newInstance(STAlgClass.type, xmlOptions);
    }

    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STAlgClass.type, xmlOptions);
    }

    public static STAlgClass parse(File file, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(file, STAlgClass.type, xmlOptions);
    }

    public static STAlgClass parse(InputStream inputStream) {
        return POIXMLTypeLoader.parse(inputStream, STAlgClass.type, (XmlOptions) null);
    }

    public static STAlgClass parse(InputStream inputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(inputStream, STAlgClass.type, xmlOptions);
    }

    public static STAlgClass parse(Reader reader) {
        return POIXMLTypeLoader.parse(reader, STAlgClass.type, (XmlOptions) null);
    }

    public static STAlgClass parse(Reader reader, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(reader, STAlgClass.type, xmlOptions);
    }

    public static STAlgClass parse(String str) {
        return POIXMLTypeLoader.parse(str, STAlgClass.type, (XmlOptions) null);
    }

    public static STAlgClass parse(String str, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(str, STAlgClass.type, xmlOptions);
    }

    public static STAlgClass parse(URL url) {
        return POIXMLTypeLoader.parse(url, STAlgClass.type, (XmlOptions) null);
    }

    public static STAlgClass parse(URL url, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(url, STAlgClass.type, xmlOptions);
    }

    public static STAlgClass parse(XMLStreamReader xMLStreamReader) {
        return POIXMLTypeLoader.parse(xMLStreamReader, STAlgClass.type, (XmlOptions) null);
    }

    public static STAlgClass parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(xMLStreamReader, STAlgClass.type, xmlOptions);
    }

    public static STAlgClass parse(XMLInputStream xMLInputStream) {
        return POIXMLTypeLoader.parse(xMLInputStream, STAlgClass.type, (XmlOptions) null);
    }

    public static STAlgClass parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(xMLInputStream, STAlgClass.type, xmlOptions);
    }

    public static STAlgClass parse(Node node) {
        return POIXMLTypeLoader.parse(node, STAlgClass.type, (XmlOptions) null);
    }

    public static STAlgClass parse(Node node, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(node, STAlgClass.type, xmlOptions);
    }
}
