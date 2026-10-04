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
public final class CTHMerge$Factory {
    private CTHMerge$Factory() {
    }

    public static CTHMerge newInstance() {
        return POIXMLTypeLoader.newInstance(CTHMerge.type, null);
    }

    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
        return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTHMerge.type, null);
    }

    public static CTHMerge parse(File file) {
        return POIXMLTypeLoader.parse(file, CTHMerge.type, (XmlOptions) null);
    }

    public static CTHMerge newInstance(XmlOptions xmlOptions) {
        return POIXMLTypeLoader.newInstance(CTHMerge.type, xmlOptions);
    }

    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTHMerge.type, xmlOptions);
    }

    public static CTHMerge parse(File file, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(file, CTHMerge.type, xmlOptions);
    }

    public static CTHMerge parse(InputStream inputStream) {
        return POIXMLTypeLoader.parse(inputStream, CTHMerge.type, (XmlOptions) null);
    }

    public static CTHMerge parse(InputStream inputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(inputStream, CTHMerge.type, xmlOptions);
    }

    public static CTHMerge parse(Reader reader) {
        return POIXMLTypeLoader.parse(reader, CTHMerge.type, (XmlOptions) null);
    }

    public static CTHMerge parse(Reader reader, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(reader, CTHMerge.type, xmlOptions);
    }

    public static CTHMerge parse(String str) {
        return POIXMLTypeLoader.parse(str, CTHMerge.type, (XmlOptions) null);
    }

    public static CTHMerge parse(String str, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(str, CTHMerge.type, xmlOptions);
    }

    public static CTHMerge parse(URL url) {
        return POIXMLTypeLoader.parse(url, CTHMerge.type, (XmlOptions) null);
    }

    public static CTHMerge parse(URL url, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(url, CTHMerge.type, xmlOptions);
    }

    public static CTHMerge parse(XMLStreamReader xMLStreamReader) {
        return POIXMLTypeLoader.parse(xMLStreamReader, CTHMerge.type, (XmlOptions) null);
    }

    public static CTHMerge parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(xMLStreamReader, CTHMerge.type, xmlOptions);
    }

    public static CTHMerge parse(XMLInputStream xMLInputStream) {
        return POIXMLTypeLoader.parse(xMLInputStream, CTHMerge.type, (XmlOptions) null);
    }

    public static CTHMerge parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(xMLInputStream, CTHMerge.type, xmlOptions);
    }

    public static CTHMerge parse(Node node) {
        return POIXMLTypeLoader.parse(node, CTHMerge.type, (XmlOptions) null);
    }

    public static CTHMerge parse(Node node, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(node, CTHMerge.type, xmlOptions);
    }
}
