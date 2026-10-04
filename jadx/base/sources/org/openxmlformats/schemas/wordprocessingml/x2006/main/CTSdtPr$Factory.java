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
public final class CTSdtPr$Factory {
    private CTSdtPr$Factory() {
    }

    public static CTSdtPr newInstance() {
        return POIXMLTypeLoader.newInstance(CTSdtPr.type, null);
    }

    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
        return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSdtPr.type, null);
    }

    public static CTSdtPr parse(File file) {
        return POIXMLTypeLoader.parse(file, CTSdtPr.type, (XmlOptions) null);
    }

    public static CTSdtPr newInstance(XmlOptions xmlOptions) {
        return POIXMLTypeLoader.newInstance(CTSdtPr.type, xmlOptions);
    }

    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSdtPr.type, xmlOptions);
    }

    public static CTSdtPr parse(File file, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(file, CTSdtPr.type, xmlOptions);
    }

    public static CTSdtPr parse(InputStream inputStream) {
        return POIXMLTypeLoader.parse(inputStream, CTSdtPr.type, (XmlOptions) null);
    }

    public static CTSdtPr parse(InputStream inputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(inputStream, CTSdtPr.type, xmlOptions);
    }

    public static CTSdtPr parse(Reader reader) {
        return POIXMLTypeLoader.parse(reader, CTSdtPr.type, (XmlOptions) null);
    }

    public static CTSdtPr parse(Reader reader, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(reader, CTSdtPr.type, xmlOptions);
    }

    public static CTSdtPr parse(String str) {
        return POIXMLTypeLoader.parse(str, CTSdtPr.type, (XmlOptions) null);
    }

    public static CTSdtPr parse(String str, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(str, CTSdtPr.type, xmlOptions);
    }

    public static CTSdtPr parse(URL url) {
        return POIXMLTypeLoader.parse(url, CTSdtPr.type, (XmlOptions) null);
    }

    public static CTSdtPr parse(URL url, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(url, CTSdtPr.type, xmlOptions);
    }

    public static CTSdtPr parse(XMLStreamReader xMLStreamReader) {
        return POIXMLTypeLoader.parse(xMLStreamReader, CTSdtPr.type, (XmlOptions) null);
    }

    public static CTSdtPr parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(xMLStreamReader, CTSdtPr.type, xmlOptions);
    }

    public static CTSdtPr parse(XMLInputStream xMLInputStream) {
        return POIXMLTypeLoader.parse(xMLInputStream, CTSdtPr.type, (XmlOptions) null);
    }

    public static CTSdtPr parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(xMLInputStream, CTSdtPr.type, xmlOptions);
    }

    public static CTSdtPr parse(Node node) {
        return POIXMLTypeLoader.parse(node, CTSdtPr.type, (XmlOptions) null);
    }

    public static CTSdtPr parse(Node node, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(node, CTSdtPr.type, xmlOptions);
    }
}
