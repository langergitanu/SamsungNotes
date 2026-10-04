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
public interface SldDocument extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(SldDocument.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "sld1b98doctype");

    public static final class Factory {
        private Factory() {
        }

        public static SldDocument newInstance() {
            return (SldDocument) POIXMLTypeLoader.newInstance(SldDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, SldDocument.type, null);
        }

        public static SldDocument parse(File file) {
            return (SldDocument) POIXMLTypeLoader.parse(file, SldDocument.type, (XmlOptions) null);
        }

        public static SldDocument newInstance(XmlOptions xmlOptions) {
            return (SldDocument) POIXMLTypeLoader.newInstance(SldDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, SldDocument.type, xmlOptions);
        }

        public static SldDocument parse(File file, XmlOptions xmlOptions) {
            return (SldDocument) POIXMLTypeLoader.parse(file, SldDocument.type, xmlOptions);
        }

        public static SldDocument parse(InputStream inputStream) {
            return (SldDocument) POIXMLTypeLoader.parse(inputStream, SldDocument.type, (XmlOptions) null);
        }

        public static SldDocument parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (SldDocument) POIXMLTypeLoader.parse(inputStream, SldDocument.type, xmlOptions);
        }

        public static SldDocument parse(Reader reader) {
            return (SldDocument) POIXMLTypeLoader.parse(reader, SldDocument.type, (XmlOptions) null);
        }

        public static SldDocument parse(Reader reader, XmlOptions xmlOptions) {
            return (SldDocument) POIXMLTypeLoader.parse(reader, SldDocument.type, xmlOptions);
        }

        public static SldDocument parse(String str) {
            return (SldDocument) POIXMLTypeLoader.parse(str, SldDocument.type, (XmlOptions) null);
        }

        public static SldDocument parse(String str, XmlOptions xmlOptions) {
            return (SldDocument) POIXMLTypeLoader.parse(str, SldDocument.type, xmlOptions);
        }

        public static SldDocument parse(URL url) {
            return (SldDocument) POIXMLTypeLoader.parse(url, SldDocument.type, (XmlOptions) null);
        }

        public static SldDocument parse(URL url, XmlOptions xmlOptions) {
            return (SldDocument) POIXMLTypeLoader.parse(url, SldDocument.type, xmlOptions);
        }

        public static SldDocument parse(XMLStreamReader xMLStreamReader) {
            return (SldDocument) POIXMLTypeLoader.parse(xMLStreamReader, SldDocument.type, (XmlOptions) null);
        }

        public static SldDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (SldDocument) POIXMLTypeLoader.parse(xMLStreamReader, SldDocument.type, xmlOptions);
        }

        public static SldDocument parse(XMLInputStream xMLInputStream) {
            return (SldDocument) POIXMLTypeLoader.parse(xMLInputStream, SldDocument.type, (XmlOptions) null);
        }

        public static SldDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (SldDocument) POIXMLTypeLoader.parse(xMLInputStream, SldDocument.type, xmlOptions);
        }

        public static SldDocument parse(Node node) {
            return (SldDocument) POIXMLTypeLoader.parse(node, SldDocument.type, (XmlOptions) null);
        }

        public static SldDocument parse(Node node, XmlOptions xmlOptions) {
            return (SldDocument) POIXMLTypeLoader.parse(node, SldDocument.type, xmlOptions);
        }
    }

    CTSlide addNewSld();

    CTSlide getSld();

    void setSld(CTSlide cTSlide);
}
