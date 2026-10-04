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
public final class CTLang$Factory {
    private CTLang$Factory() {
    }

    public static CTLang newInstance() {
        return POIXMLTypeLoader.newInstance(CTLang.type, null);
    }

    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
        return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTLang.type, null);
    }

    public static CTLang parse(File file) {
        return POIXMLTypeLoader.parse(file, CTLang.type, (XmlOptions) null);
    }

    public static CTLang newInstance(XmlOptions xmlOptions) {
        return POIXMLTypeLoader.newInstance(CTLang.type, xmlOptions);
    }

    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTLang.type, xmlOptions);
    }

    public static CTLang parse(File file, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(file, CTLang.type, xmlOptions);
    }

    public static CTLang parse(InputStream inputStream) {
        return POIXMLTypeLoader.parse(inputStream, CTLang.type, (XmlOptions) null);
    }

    public static CTLang parse(InputStream inputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(inputStream, CTLang.type, xmlOptions);
    }

    public static CTLang parse(Reader reader) {
        return POIXMLTypeLoader.parse(reader, CTLang.type, (XmlOptions) null);
    }

    public static CTLang parse(Reader reader, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(reader, CTLang.type, xmlOptions);
    }

    public static CTLang parse(String str) {
        return POIXMLTypeLoader.parse(str, CTLang.type, (XmlOptions) null);
    }

    public static CTLang parse(String str, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(str, CTLang.type, xmlOptions);
    }

    public static CTLang parse(URL url) {
        return POIXMLTypeLoader.parse(url, CTLang.type, (XmlOptions) null);
    }

    public static CTLang parse(URL url, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(url, CTLang.type, xmlOptions);
    }

    public static CTLang parse(XMLStreamReader xMLStreamReader) {
        return POIXMLTypeLoader.parse(xMLStreamReader, CTLang.type, (XmlOptions) null);
    }

    public static CTLang parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(xMLStreamReader, CTLang.type, xmlOptions);
    }

    public static CTLang parse(XMLInputStream xMLInputStream) {
        return POIXMLTypeLoader.parse(xMLInputStream, CTLang.type, (XmlOptions) null);
    }

    public static CTLang parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(xMLInputStream, CTLang.type, xmlOptions);
    }

    public static CTLang parse(Node node) {
        return POIXMLTypeLoader.parse(node, CTLang.type, (XmlOptions) null);
    }

    public static CTLang parse(Node node, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(node, CTLang.type, xmlOptions);
    }
}
