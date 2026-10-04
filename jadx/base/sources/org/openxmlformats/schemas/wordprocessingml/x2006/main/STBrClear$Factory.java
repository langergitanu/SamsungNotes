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
public final class STBrClear$Factory {
    private STBrClear$Factory() {
    }

    public static STBrClear newInstance() {
        return POIXMLTypeLoader.newInstance(STBrClear.type, null);
    }

    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
        return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STBrClear.type, null);
    }

    public static STBrClear newValue(Object obj) {
        return STBrClear.type.newValue(obj);
    }

    public static STBrClear parse(File file) {
        return POIXMLTypeLoader.parse(file, STBrClear.type, (XmlOptions) null);
    }

    public static STBrClear newInstance(XmlOptions xmlOptions) {
        return POIXMLTypeLoader.newInstance(STBrClear.type, xmlOptions);
    }

    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STBrClear.type, xmlOptions);
    }

    public static STBrClear parse(File file, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(file, STBrClear.type, xmlOptions);
    }

    public static STBrClear parse(InputStream inputStream) {
        return POIXMLTypeLoader.parse(inputStream, STBrClear.type, (XmlOptions) null);
    }

    public static STBrClear parse(InputStream inputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(inputStream, STBrClear.type, xmlOptions);
    }

    public static STBrClear parse(Reader reader) {
        return POIXMLTypeLoader.parse(reader, STBrClear.type, (XmlOptions) null);
    }

    public static STBrClear parse(Reader reader, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(reader, STBrClear.type, xmlOptions);
    }

    public static STBrClear parse(String str) {
        return POIXMLTypeLoader.parse(str, STBrClear.type, (XmlOptions) null);
    }

    public static STBrClear parse(String str, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(str, STBrClear.type, xmlOptions);
    }

    public static STBrClear parse(URL url) {
        return POIXMLTypeLoader.parse(url, STBrClear.type, (XmlOptions) null);
    }

    public static STBrClear parse(URL url, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(url, STBrClear.type, xmlOptions);
    }

    public static STBrClear parse(XMLStreamReader xMLStreamReader) {
        return POIXMLTypeLoader.parse(xMLStreamReader, STBrClear.type, (XmlOptions) null);
    }

    public static STBrClear parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(xMLStreamReader, STBrClear.type, xmlOptions);
    }

    public static STBrClear parse(XMLInputStream xMLInputStream) {
        return POIXMLTypeLoader.parse(xMLInputStream, STBrClear.type, (XmlOptions) null);
    }

    public static STBrClear parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(xMLInputStream, STBrClear.type, xmlOptions);
    }

    public static STBrClear parse(Node node) {
        return POIXMLTypeLoader.parse(node, STBrClear.type, (XmlOptions) null);
    }

    public static STBrClear parse(Node node, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(node, STBrClear.type, xmlOptions);
    }
}
