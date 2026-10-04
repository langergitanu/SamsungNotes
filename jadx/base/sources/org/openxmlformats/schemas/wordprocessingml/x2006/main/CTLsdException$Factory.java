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
public final class CTLsdException$Factory {
    private CTLsdException$Factory() {
    }

    public static CTLsdException newInstance() {
        return POIXMLTypeLoader.newInstance(CTLsdException.type, null);
    }

    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
        return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTLsdException.type, null);
    }

    public static CTLsdException parse(File file) {
        return POIXMLTypeLoader.parse(file, CTLsdException.type, (XmlOptions) null);
    }

    public static CTLsdException newInstance(XmlOptions xmlOptions) {
        return POIXMLTypeLoader.newInstance(CTLsdException.type, xmlOptions);
    }

    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTLsdException.type, xmlOptions);
    }

    public static CTLsdException parse(File file, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(file, CTLsdException.type, xmlOptions);
    }

    public static CTLsdException parse(InputStream inputStream) {
        return POIXMLTypeLoader.parse(inputStream, CTLsdException.type, (XmlOptions) null);
    }

    public static CTLsdException parse(InputStream inputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(inputStream, CTLsdException.type, xmlOptions);
    }

    public static CTLsdException parse(Reader reader) {
        return POIXMLTypeLoader.parse(reader, CTLsdException.type, (XmlOptions) null);
    }

    public static CTLsdException parse(Reader reader, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(reader, CTLsdException.type, xmlOptions);
    }

    public static CTLsdException parse(String str) {
        return POIXMLTypeLoader.parse(str, CTLsdException.type, (XmlOptions) null);
    }

    public static CTLsdException parse(String str, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(str, CTLsdException.type, xmlOptions);
    }

    public static CTLsdException parse(URL url) {
        return POIXMLTypeLoader.parse(url, CTLsdException.type, (XmlOptions) null);
    }

    public static CTLsdException parse(URL url, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(url, CTLsdException.type, xmlOptions);
    }

    public static CTLsdException parse(XMLStreamReader xMLStreamReader) {
        return POIXMLTypeLoader.parse(xMLStreamReader, CTLsdException.type, (XmlOptions) null);
    }

    public static CTLsdException parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(xMLStreamReader, CTLsdException.type, xmlOptions);
    }

    public static CTLsdException parse(XMLInputStream xMLInputStream) {
        return POIXMLTypeLoader.parse(xMLInputStream, CTLsdException.type, (XmlOptions) null);
    }

    public static CTLsdException parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(xMLInputStream, CTLsdException.type, xmlOptions);
    }

    public static CTLsdException parse(Node node) {
        return POIXMLTypeLoader.parse(node, CTLsdException.type, (XmlOptions) null);
    }

    public static CTLsdException parse(Node node, XmlOptions xmlOptions) {
        return POIXMLTypeLoader.parse(node, CTLsdException.type, xmlOptions);
    }
}
