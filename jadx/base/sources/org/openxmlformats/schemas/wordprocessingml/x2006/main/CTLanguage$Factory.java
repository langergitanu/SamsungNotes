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
public final class CTLanguage$Factory {
    private CTLanguage$Factory() {
    }

    public static CTLanguage newInstance() {
        return POIXMLTypeLoader.newInstance(CTLanguage.type, null);
    }

    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
        return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTLanguage.type, null);
    }

    public static CTLanguage parse(File file) {
        return POIXMLTypeLoader.parse(file, CTLanguage.type, (XmlOptions) null);
    }

    public static CTLanguage newInstance(XmlOptions xmlOptions) {
        return POIXMLTypeLoader.newInstance(CTLanguage.type, xmlOptions);
    }

    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTLanguage.type, xmlOptions);
    }

    public static CTLanguage parse(File file, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(file, CTLanguage.type, xmlOptions);
    }

    public static CTLanguage parse(InputStream inputStream) {
        return POIXMLTypeLoader.parse(inputStream, CTLanguage.type, (XmlOptions) null);
    }

    public static CTLanguage parse(InputStream inputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(inputStream, CTLanguage.type, xmlOptions);
    }

    public static CTLanguage parse(Reader reader) {
        return POIXMLTypeLoader.parse(reader, CTLanguage.type, (XmlOptions) null);
    }

    public static CTLanguage parse(Reader reader, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(reader, CTLanguage.type, xmlOptions);
    }

    public static CTLanguage parse(String str) {
        return POIXMLTypeLoader.parse(str, CTLanguage.type, (XmlOptions) null);
    }

    public static CTLanguage parse(String str, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(str, CTLanguage.type, xmlOptions);
    }

    public static CTLanguage parse(URL url) {
        return POIXMLTypeLoader.parse(url, CTLanguage.type, (XmlOptions) null);
    }

    public static CTLanguage parse(URL url, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(url, CTLanguage.type, xmlOptions);
    }

    public static CTLanguage parse(XMLStreamReader xMLStreamReader) {
        return POIXMLTypeLoader.parse(xMLStreamReader, CTLanguage.type, (XmlOptions) null);
    }

    public static CTLanguage parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(xMLStreamReader, CTLanguage.type, xmlOptions);
    }

    public static CTLanguage parse(XMLInputStream xMLInputStream) {
        return POIXMLTypeLoader.parse(xMLInputStream, CTLanguage.type, (XmlOptions) null);
    }

    public static CTLanguage parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(xMLInputStream, CTLanguage.type, xmlOptions);
    }

    public static CTLanguage parse(Node node) {
        return POIXMLTypeLoader.parse(node, CTLanguage.type, (XmlOptions) null);
    }

    public static CTLanguage parse(Node node, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(node, CTLanguage.type, xmlOptions);
    }
}
