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
public final class CTSdtEndPr$Factory {
    private CTSdtEndPr$Factory() {
    }

    public static CTSdtEndPr newInstance() {
        return POIXMLTypeLoader.newInstance(CTSdtEndPr.type, null);
    }

    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
        return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSdtEndPr.type, null);
    }

    public static CTSdtEndPr parse(File file) {
        return POIXMLTypeLoader.parse(file, CTSdtEndPr.type, (XmlOptions) null);
    }

    public static CTSdtEndPr newInstance(XmlOptions xmlOptions) {
        return POIXMLTypeLoader.newInstance(CTSdtEndPr.type, xmlOptions);
    }

    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTSdtEndPr.type, xmlOptions);
    }

    public static CTSdtEndPr parse(File file, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(file, CTSdtEndPr.type, xmlOptions);
    }

    public static CTSdtEndPr parse(InputStream inputStream) {
        return POIXMLTypeLoader.parse(inputStream, CTSdtEndPr.type, (XmlOptions) null);
    }

    public static CTSdtEndPr parse(InputStream inputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(inputStream, CTSdtEndPr.type, xmlOptions);
    }

    public static CTSdtEndPr parse(Reader reader) {
        return POIXMLTypeLoader.parse(reader, CTSdtEndPr.type, (XmlOptions) null);
    }

    public static CTSdtEndPr parse(Reader reader, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(reader, CTSdtEndPr.type, xmlOptions);
    }

    public static CTSdtEndPr parse(String str) {
        return POIXMLTypeLoader.parse(str, CTSdtEndPr.type, (XmlOptions) null);
    }

    public static CTSdtEndPr parse(String str, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(str, CTSdtEndPr.type, xmlOptions);
    }

    public static CTSdtEndPr parse(URL url) {
        return POIXMLTypeLoader.parse(url, CTSdtEndPr.type, (XmlOptions) null);
    }

    public static CTSdtEndPr parse(URL url, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(url, CTSdtEndPr.type, xmlOptions);
    }

    public static CTSdtEndPr parse(XMLStreamReader xMLStreamReader) {
        return POIXMLTypeLoader.parse(xMLStreamReader, CTSdtEndPr.type, (XmlOptions) null);
    }

    public static CTSdtEndPr parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(xMLStreamReader, CTSdtEndPr.type, xmlOptions);
    }

    public static CTSdtEndPr parse(XMLInputStream xMLInputStream) {
        return POIXMLTypeLoader.parse(xMLInputStream, CTSdtEndPr.type, (XmlOptions) null);
    }

    public static CTSdtEndPr parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(xMLInputStream, CTSdtEndPr.type, xmlOptions);
    }

    public static CTSdtEndPr parse(Node node) {
        return POIXMLTypeLoader.parse(node, CTSdtEndPr.type, (XmlOptions) null);
    }

    public static CTSdtEndPr parse(Node node, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(node, CTSdtEndPr.type, xmlOptions);
    }
}
