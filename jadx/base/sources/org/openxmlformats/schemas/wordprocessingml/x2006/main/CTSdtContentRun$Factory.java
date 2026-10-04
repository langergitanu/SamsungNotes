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
public final class CTSdtContentRun$Factory {
    private CTSdtContentRun$Factory() {
    }

    public static CTSdtContentRun newInstance() {
        return POIXMLTypeLoader.newInstance(CTSdtContentRun.type, null);
    }

    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
        return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSdtContentRun.type, null);
    }

    public static CTSdtContentRun parse(File file) {
        return POIXMLTypeLoader.parse(file, CTSdtContentRun.type, (XmlOptions) null);
    }

    public static CTSdtContentRun newInstance(XmlOptions xmlOptions) {
        return POIXMLTypeLoader.newInstance(CTSdtContentRun.type, xmlOptions);
    }

    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSdtContentRun.type, xmlOptions);
    }

    public static CTSdtContentRun parse(File file, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(file, CTSdtContentRun.type, xmlOptions);
    }

    public static CTSdtContentRun parse(InputStream inputStream) {
        return POIXMLTypeLoader.parse(inputStream, CTSdtContentRun.type, (XmlOptions) null);
    }

    public static CTSdtContentRun parse(InputStream inputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(inputStream, CTSdtContentRun.type, xmlOptions);
    }

    public static CTSdtContentRun parse(Reader reader) {
        return POIXMLTypeLoader.parse(reader, CTSdtContentRun.type, (XmlOptions) null);
    }

    public static CTSdtContentRun parse(Reader reader, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(reader, CTSdtContentRun.type, xmlOptions);
    }

    public static CTSdtContentRun parse(String str) {
        return POIXMLTypeLoader.parse(str, CTSdtContentRun.type, (XmlOptions) null);
    }

    public static CTSdtContentRun parse(String str, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(str, CTSdtContentRun.type, xmlOptions);
    }

    public static CTSdtContentRun parse(URL url) {
        return POIXMLTypeLoader.parse(url, CTSdtContentRun.type, (XmlOptions) null);
    }

    public static CTSdtContentRun parse(URL url, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(url, CTSdtContentRun.type, xmlOptions);
    }

    public static CTSdtContentRun parse(XMLStreamReader xMLStreamReader) {
        return POIXMLTypeLoader.parse(xMLStreamReader, CTSdtContentRun.type, (XmlOptions) null);
    }

    public static CTSdtContentRun parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(xMLStreamReader, CTSdtContentRun.type, xmlOptions);
    }

    public static CTSdtContentRun parse(XMLInputStream xMLInputStream) {
        return POIXMLTypeLoader.parse(xMLInputStream, CTSdtContentRun.type, (XmlOptions) null);
    }

    public static CTSdtContentRun parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(xMLInputStream, CTSdtContentRun.type, xmlOptions);
    }

    public static CTSdtContentRun parse(Node node) {
        return POIXMLTypeLoader.parse(node, CTSdtContentRun.type, (XmlOptions) null);
    }

    public static CTSdtContentRun parse(Node node, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(node, CTSdtContentRun.type, xmlOptions);
    }
}
