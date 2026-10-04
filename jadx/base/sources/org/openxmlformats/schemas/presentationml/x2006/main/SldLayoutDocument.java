package org.openxmlformats.schemas.presentationml.x2006.main;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface SldLayoutDocument extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(SldLayoutDocument.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "sldlayout638edoctype");

    public static final class Factory {
        private Factory() {
        }

        public static SldLayoutDocument newInstance() {
            return (SldLayoutDocument) POIXMLTypeLoader.newInstance(SldLayoutDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, SldLayoutDocument.type, null);
        }

        public static SldLayoutDocument parse(File file) {
            return (SldLayoutDocument) POIXMLTypeLoader.parse(file, SldLayoutDocument.type, (XmlOptions) null);
        }

        public static SldLayoutDocument newInstance(XmlOptions xmlOptions) {
            return (SldLayoutDocument) POIXMLTypeLoader.newInstance(SldLayoutDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, SldLayoutDocument.type, xmlOptions);
        }

        public static SldLayoutDocument parse(File file, XmlOptions xmlOptions) {
            return (SldLayoutDocument) POIXMLTypeLoader.parse(file, SldLayoutDocument.type, xmlOptions);
        }

        public static SldLayoutDocument parse(InputStream inputStream) {
            return (SldLayoutDocument) POIXMLTypeLoader.parse(inputStream, SldLayoutDocument.type, (XmlOptions) null);
        }

        public static SldLayoutDocument parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (SldLayoutDocument) POIXMLTypeLoader.parse(inputStream, SldLayoutDocument.type, xmlOptions);
        }

        public static SldLayoutDocument parse(Reader reader) {
            return (SldLayoutDocument) POIXMLTypeLoader.parse(reader, SldLayoutDocument.type, (XmlOptions) null);
        }

        public static SldLayoutDocument parse(Reader reader, XmlOptions xmlOptions) {
            return (SldLayoutDocument) POIXMLTypeLoader.parse(reader, SldLayoutDocument.type, xmlOptions);
        }

        public static SldLayoutDocument parse(String str) {
            return (SldLayoutDocument) POIXMLTypeLoader.parse(str, SldLayoutDocument.type, (XmlOptions) null);
        }

        public static SldLayoutDocument parse(String str, XmlOptions xmlOptions) {
            return (SldLayoutDocument) POIXMLTypeLoader.parse(str, SldLayoutDocument.type, xmlOptions);
        }

        public static SldLayoutDocument parse(URL url) {
            return (SldLayoutDocument) POIXMLTypeLoader.parse(url, SldLayoutDocument.type, (XmlOptions) null);
        }

        public static SldLayoutDocument parse(URL url, XmlOptions xmlOptions) {
            return (SldLayoutDocument) POIXMLTypeLoader.parse(url, SldLayoutDocument.type, xmlOptions);
        }

        public static SldLayoutDocument parse(XMLStreamReader xMLStreamReader) {
            return (SldLayoutDocument) POIXMLTypeLoader.parse(xMLStreamReader, SldLayoutDocument.type, (XmlOptions) null);
        }

        public static SldLayoutDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (SldLayoutDocument) POIXMLTypeLoader.parse(xMLStreamReader, SldLayoutDocument.type, xmlOptions);
        }

        public static SldLayoutDocument parse(XMLInputStream xMLInputStream) {
            return (SldLayoutDocument) POIXMLTypeLoader.parse(xMLInputStream, SldLayoutDocument.type, (XmlOptions) null);
        }

        public static SldLayoutDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (SldLayoutDocument) POIXMLTypeLoader.parse(xMLInputStream, SldLayoutDocument.type, xmlOptions);
        }

        public static SldLayoutDocument parse(Node node) {
            return (SldLayoutDocument) POIXMLTypeLoader.parse(node, SldLayoutDocument.type, (XmlOptions) null);
        }

        public static SldLayoutDocument parse(Node node, XmlOptions xmlOptions) {
            return (SldLayoutDocument) POIXMLTypeLoader.parse(node, SldLayoutDocument.type, xmlOptions);
        }
    }

    CTSlideLayout addNewSldLayout();

    CTSlideLayout getSldLayout();

    void setSldLayout(CTSlideLayout cTSlideLayout);
}
