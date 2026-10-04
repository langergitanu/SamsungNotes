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
public final class CTSdtCell$Factory {
    private CTSdtCell$Factory() {
    }

    public static CTSdtCell newInstance() {
        return POIXMLTypeLoader.newInstance(CTSdtCell.type, null);
    }

    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
        return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSdtCell.type, null);
    }

    public static CTSdtCell parse(File file) {
        return POIXMLTypeLoader.parse(file, CTSdtCell.type, (XmlOptions) null);
    }

    public static CTSdtCell newInstance(XmlOptions xmlOptions) {
        return POIXMLTypeLoader.newInstance(CTSdtCell.type, xmlOptions);
    }

    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSdtCell.type, xmlOptions);
    }

    public static CTSdtCell parse(File file, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(file, CTSdtCell.type, xmlOptions);
    }

    public static CTSdtCell parse(InputStream inputStream) {
        return POIXMLTypeLoader.parse(inputStream, CTSdtCell.type, (XmlOptions) null);
    }

    public static CTSdtCell parse(InputStream inputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(inputStream, CTSdtCell.type, xmlOptions);
    }

    public static CTSdtCell parse(Reader reader) {
        return POIXMLTypeLoader.parse(reader, CTSdtCell.type, (XmlOptions) null);
    }

    public static CTSdtCell parse(Reader reader, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(reader, CTSdtCell.type, xmlOptions);
    }

    public static CTSdtCell parse(String str) {
        return POIXMLTypeLoader.parse(str, CTSdtCell.type, (XmlOptions) null);
    }

    public static CTSdtCell parse(String str, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(str, CTSdtCell.type, xmlOptions);
    }

    public static CTSdtCell parse(URL url) {
        return POIXMLTypeLoader.parse(url, CTSdtCell.type, (XmlOptions) null);
    }

    public static CTSdtCell parse(URL url, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(url, CTSdtCell.type, xmlOptions);
    }

    public static CTSdtCell parse(XMLStreamReader xMLStreamReader) {
        return POIXMLTypeLoader.parse(xMLStreamReader, CTSdtCell.type, (XmlOptions) null);
    }

    public static CTSdtCell parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(xMLStreamReader, CTSdtCell.type, xmlOptions);
    }

    public static CTSdtCell parse(XMLInputStream xMLInputStream) {
        return POIXMLTypeLoader.parse(xMLInputStream, CTSdtCell.type, (XmlOptions) null);
    }

    public static CTSdtCell parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(xMLInputStream, CTSdtCell.type, xmlOptions);
    }

    public static CTSdtCell parse(Node node) {
        return POIXMLTypeLoader.parse(node, CTSdtCell.type, (XmlOptions) null);
    }

    public static CTSdtCell parse(Node node, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(node, CTSdtCell.type, xmlOptions);
    }
}
