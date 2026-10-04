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
public final class CTSdtContentCell$Factory {
    private CTSdtContentCell$Factory() {
    }

    public static CTSdtContentCell newInstance() {
        return POIXMLTypeLoader.newInstance(CTSdtContentCell.type, null);
    }

    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
        return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSdtContentCell.type, null);
    }

    public static CTSdtContentCell parse(File file) {
        return POIXMLTypeLoader.parse(file, CTSdtContentCell.type, (XmlOptions) null);
    }

    public static CTSdtContentCell newInstance(XmlOptions xmlOptions) {
        return POIXMLTypeLoader.newInstance(CTSdtContentCell.type, xmlOptions);
    }

    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSdtContentCell.type, xmlOptions);
    }

    public static CTSdtContentCell parse(File file, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(file, CTSdtContentCell.type, xmlOptions);
    }

    public static CTSdtContentCell parse(InputStream inputStream) {
        return POIXMLTypeLoader.parse(inputStream, CTSdtContentCell.type, (XmlOptions) null);
    }

    public static CTSdtContentCell parse(InputStream inputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(inputStream, CTSdtContentCell.type, xmlOptions);
    }

    public static CTSdtContentCell parse(Reader reader) {
        return POIXMLTypeLoader.parse(reader, CTSdtContentCell.type, (XmlOptions) null);
    }

    public static CTSdtContentCell parse(Reader reader, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(reader, CTSdtContentCell.type, xmlOptions);
    }

    public static CTSdtContentCell parse(String str) {
        return POIXMLTypeLoader.parse(str, CTSdtContentCell.type, (XmlOptions) null);
    }

    public static CTSdtContentCell parse(String str, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(str, CTSdtContentCell.type, xmlOptions);
    }

    public static CTSdtContentCell parse(URL url) {
        return POIXMLTypeLoader.parse(url, CTSdtContentCell.type, (XmlOptions) null);
    }

    public static CTSdtContentCell parse(URL url, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(url, CTSdtContentCell.type, xmlOptions);
    }

    public static CTSdtContentCell parse(XMLStreamReader xMLStreamReader) {
        return POIXMLTypeLoader.parse(xMLStreamReader, CTSdtContentCell.type, (XmlOptions) null);
    }

    public static CTSdtContentCell parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(xMLStreamReader, CTSdtContentCell.type, xmlOptions);
    }

    public static CTSdtContentCell parse(XMLInputStream xMLInputStream) {
        return POIXMLTypeLoader.parse(xMLInputStream, CTSdtContentCell.type, (XmlOptions) null);
    }

    public static CTSdtContentCell parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(xMLInputStream, CTSdtContentCell.type, xmlOptions);
    }

    public static CTSdtContentCell parse(Node node) {
        return POIXMLTypeLoader.parse(node, CTSdtContentCell.type, (XmlOptions) null);
    }

    public static CTSdtContentCell parse(Node node, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(node, CTSdtContentCell.type, xmlOptions);
    }
}
