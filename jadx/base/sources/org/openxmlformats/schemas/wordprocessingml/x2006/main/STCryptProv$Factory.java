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
public final class STCryptProv$Factory {
    private STCryptProv$Factory() {
    }

    public static STCryptProv newInstance() {
        return POIXMLTypeLoader.newInstance(STCryptProv.type, null);
    }

    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
        return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STCryptProv.type, null);
    }

    public static STCryptProv newValue(Object obj) {
        return STCryptProv.type.newValue(obj);
    }

    public static STCryptProv parse(File file) {
        return POIXMLTypeLoader.parse(file, STCryptProv.type, (XmlOptions) null);
    }

    public static STCryptProv newInstance(XmlOptions xmlOptions) {
        return POIXMLTypeLoader.newInstance(STCryptProv.type, xmlOptions);
    }

    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STCryptProv.type, xmlOptions);
    }

    public static STCryptProv parse(File file, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(file, STCryptProv.type, xmlOptions);
    }

    public static STCryptProv parse(InputStream inputStream) {
        return POIXMLTypeLoader.parse(inputStream, STCryptProv.type, (XmlOptions) null);
    }

    public static STCryptProv parse(InputStream inputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(inputStream, STCryptProv.type, xmlOptions);
    }

    public static STCryptProv parse(Reader reader) {
        return POIXMLTypeLoader.parse(reader, STCryptProv.type, (XmlOptions) null);
    }

    public static STCryptProv parse(Reader reader, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(reader, STCryptProv.type, xmlOptions);
    }

    public static STCryptProv parse(String str) {
        return POIXMLTypeLoader.parse(str, STCryptProv.type, (XmlOptions) null);
    }

    public static STCryptProv parse(String str, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(str, STCryptProv.type, xmlOptions);
    }

    public static STCryptProv parse(URL url) {
        return POIXMLTypeLoader.parse(url, STCryptProv.type, (XmlOptions) null);
    }

    public static STCryptProv parse(URL url, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(url, STCryptProv.type, xmlOptions);
    }

    public static STCryptProv parse(XMLStreamReader xMLStreamReader) {
        return POIXMLTypeLoader.parse(xMLStreamReader, STCryptProv.type, (XmlOptions) null);
    }

    public static STCryptProv parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(xMLStreamReader, STCryptProv.type, xmlOptions);
    }

    public static STCryptProv parse(XMLInputStream xMLInputStream) {
        return POIXMLTypeLoader.parse(xMLInputStream, STCryptProv.type, (XmlOptions) null);
    }

    public static STCryptProv parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(xMLInputStream, STCryptProv.type, xmlOptions);
    }

    public static STCryptProv parse(Node node) {
        return POIXMLTypeLoader.parse(node, STCryptProv.type, (XmlOptions) null);
    }

    public static STCryptProv parse(Node node, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(node, STCryptProv.type, xmlOptions);
    }
}
