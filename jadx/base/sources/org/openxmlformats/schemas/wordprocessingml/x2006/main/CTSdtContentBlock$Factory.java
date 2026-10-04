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
public final class CTSdtContentBlock$Factory {
    private CTSdtContentBlock$Factory() {
    }

    public static CTSdtContentBlock newInstance() {
        return POIXMLTypeLoader.newInstance(CTSdtContentBlock.type, null);
    }

    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
        return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSdtContentBlock.type, null);
    }

    public static CTSdtContentBlock parse(File file) {
        return POIXMLTypeLoader.parse(file, CTSdtContentBlock.type, (XmlOptions) null);
    }

    public static CTSdtContentBlock newInstance(XmlOptions xmlOptions) {
        return POIXMLTypeLoader.newInstance(CTSdtContentBlock.type, xmlOptions);
    }

    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSdtContentBlock.type, xmlOptions);
    }

    public static CTSdtContentBlock parse(File file, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(file, CTSdtContentBlock.type, xmlOptions);
    }

    public static CTSdtContentBlock parse(InputStream inputStream) {
        return POIXMLTypeLoader.parse(inputStream, CTSdtContentBlock.type, (XmlOptions) null);
    }

    public static CTSdtContentBlock parse(InputStream inputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(inputStream, CTSdtContentBlock.type, xmlOptions);
    }

    public static CTSdtContentBlock parse(Reader reader) {
        return POIXMLTypeLoader.parse(reader, CTSdtContentBlock.type, (XmlOptions) null);
    }

    public static CTSdtContentBlock parse(Reader reader, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(reader, CTSdtContentBlock.type, xmlOptions);
    }

    public static CTSdtContentBlock parse(String str) {
        return POIXMLTypeLoader.parse(str, CTSdtContentBlock.type, (XmlOptions) null);
    }

    public static CTSdtContentBlock parse(String str, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(str, CTSdtContentBlock.type, xmlOptions);
    }

    public static CTSdtContentBlock parse(URL url) {
        return POIXMLTypeLoader.parse(url, CTSdtContentBlock.type, (XmlOptions) null);
    }

    public static CTSdtContentBlock parse(URL url, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(url, CTSdtContentBlock.type, xmlOptions);
    }

    public static CTSdtContentBlock parse(XMLStreamReader xMLStreamReader) {
        return POIXMLTypeLoader.parse(xMLStreamReader, CTSdtContentBlock.type, (XmlOptions) null);
    }

    public static CTSdtContentBlock parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(xMLStreamReader, CTSdtContentBlock.type, xmlOptions);
    }

    public static CTSdtContentBlock parse(XMLInputStream xMLInputStream) {
        return POIXMLTypeLoader.parse(xMLInputStream, CTSdtContentBlock.type, (XmlOptions) null);
    }

    public static CTSdtContentBlock parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(xMLInputStream, CTSdtContentBlock.type, xmlOptions);
    }

    public static CTSdtContentBlock parse(Node node) {
        return POIXMLTypeLoader.parse(node, CTSdtContentBlock.type, (XmlOptions) null);
    }

    public static CTSdtContentBlock parse(Node node, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(node, CTSdtContentBlock.type, xmlOptions);
    }
}
