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
public final class CTSdtDocPart$Factory {
    private CTSdtDocPart$Factory() {
    }

    public static CTSdtDocPart newInstance() {
        return POIXMLTypeLoader.newInstance(CTSdtDocPart.type, null);
    }

    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
        return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSdtDocPart.type, null);
    }

    public static CTSdtDocPart parse(File file) {
        return POIXMLTypeLoader.parse(file, CTSdtDocPart.type, (XmlOptions) null);
    }

    public static CTSdtDocPart newInstance(XmlOptions xmlOptions) {
        return POIXMLTypeLoader.newInstance(CTSdtDocPart.type, xmlOptions);
    }

    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSdtDocPart.type, xmlOptions);
    }

    public static CTSdtDocPart parse(File file, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(file, CTSdtDocPart.type, xmlOptions);
    }

    public static CTSdtDocPart parse(InputStream inputStream) {
        return POIXMLTypeLoader.parse(inputStream, CTSdtDocPart.type, (XmlOptions) null);
    }

    public static CTSdtDocPart parse(InputStream inputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(inputStream, CTSdtDocPart.type, xmlOptions);
    }

    public static CTSdtDocPart parse(Reader reader) {
        return POIXMLTypeLoader.parse(reader, CTSdtDocPart.type, (XmlOptions) null);
    }

    public static CTSdtDocPart parse(Reader reader, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(reader, CTSdtDocPart.type, xmlOptions);
    }

    public static CTSdtDocPart parse(String str) {
        return POIXMLTypeLoader.parse(str, CTSdtDocPart.type, (XmlOptions) null);
    }

    public static CTSdtDocPart parse(String str, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(str, CTSdtDocPart.type, xmlOptions);
    }

    public static CTSdtDocPart parse(URL url) {
        return POIXMLTypeLoader.parse(url, CTSdtDocPart.type, (XmlOptions) null);
    }

    public static CTSdtDocPart parse(URL url, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(url, CTSdtDocPart.type, xmlOptions);
    }

    public static CTSdtDocPart parse(XMLStreamReader xMLStreamReader) {
        return POIXMLTypeLoader.parse(xMLStreamReader, CTSdtDocPart.type, (XmlOptions) null);
    }

    public static CTSdtDocPart parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(xMLStreamReader, CTSdtDocPart.type, xmlOptions);
    }

    public static CTSdtDocPart parse(XMLInputStream xMLInputStream) {
        return POIXMLTypeLoader.parse(xMLInputStream, CTSdtDocPart.type, (XmlOptions) null);
    }

    public static CTSdtDocPart parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(xMLInputStream, CTSdtDocPart.type, xmlOptions);
    }

    public static CTSdtDocPart parse(Node node) {
        return POIXMLTypeLoader.parse(node, CTSdtDocPart.type, (XmlOptions) null);
    }

    public static CTSdtDocPart parse(Node node, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(node, CTSdtDocPart.type, xmlOptions);
    }
}
