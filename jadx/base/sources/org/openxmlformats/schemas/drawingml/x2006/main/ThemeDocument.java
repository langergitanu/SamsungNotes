package org.openxmlformats.schemas.drawingml.x2006.main;

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
public interface ThemeDocument extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(ThemeDocument.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "themefd26doctype");

    public static final class Factory {
        private Factory() {
        }

        public static ThemeDocument newInstance() {
            return (ThemeDocument) POIXMLTypeLoader.newInstance(ThemeDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, ThemeDocument.type, null);
        }

        public static ThemeDocument parse(File file) {
            return (ThemeDocument) POIXMLTypeLoader.parse(file, ThemeDocument.type, (XmlOptions) null);
        }

        public static ThemeDocument newInstance(XmlOptions xmlOptions) {
            return (ThemeDocument) POIXMLTypeLoader.newInstance(ThemeDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, ThemeDocument.type, xmlOptions);
        }

        public static ThemeDocument parse(File file, XmlOptions xmlOptions) {
            return (ThemeDocument) POIXMLTypeLoader.parse(file, ThemeDocument.type, xmlOptions);
        }

        public static ThemeDocument parse(InputStream inputStream) {
            return (ThemeDocument) POIXMLTypeLoader.parse(inputStream, ThemeDocument.type, (XmlOptions) null);
        }

        public static ThemeDocument parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (ThemeDocument) POIXMLTypeLoader.parse(inputStream, ThemeDocument.type, xmlOptions);
        }

        public static ThemeDocument parse(Reader reader) {
            return (ThemeDocument) POIXMLTypeLoader.parse(reader, ThemeDocument.type, (XmlOptions) null);
        }

        public static ThemeDocument parse(Reader reader, XmlOptions xmlOptions) {
            return (ThemeDocument) POIXMLTypeLoader.parse(reader, ThemeDocument.type, xmlOptions);
        }

        public static ThemeDocument parse(String str) {
            return (ThemeDocument) POIXMLTypeLoader.parse(str, ThemeDocument.type, (XmlOptions) null);
        }

        public static ThemeDocument parse(String str, XmlOptions xmlOptions) {
            return (ThemeDocument) POIXMLTypeLoader.parse(str, ThemeDocument.type, xmlOptions);
        }

        public static ThemeDocument parse(URL url) {
            return (ThemeDocument) POIXMLTypeLoader.parse(url, ThemeDocument.type, (XmlOptions) null);
        }

        public static ThemeDocument parse(URL url, XmlOptions xmlOptions) {
            return (ThemeDocument) POIXMLTypeLoader.parse(url, ThemeDocument.type, xmlOptions);
        }

        public static ThemeDocument parse(XMLStreamReader xMLStreamReader) {
            return (ThemeDocument) POIXMLTypeLoader.parse(xMLStreamReader, ThemeDocument.type, (XmlOptions) null);
        }

        public static ThemeDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (ThemeDocument) POIXMLTypeLoader.parse(xMLStreamReader, ThemeDocument.type, xmlOptions);
        }

        public static ThemeDocument parse(XMLInputStream xMLInputStream) {
            return (ThemeDocument) POIXMLTypeLoader.parse(xMLInputStream, ThemeDocument.type, (XmlOptions) null);
        }

        public static ThemeDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (ThemeDocument) POIXMLTypeLoader.parse(xMLInputStream, ThemeDocument.type, xmlOptions);
        }

        public static ThemeDocument parse(Node node) {
            return (ThemeDocument) POIXMLTypeLoader.parse(node, ThemeDocument.type, (XmlOptions) null);
        }

        public static ThemeDocument parse(Node node, XmlOptions xmlOptions) {
            return (ThemeDocument) POIXMLTypeLoader.parse(node, ThemeDocument.type, xmlOptions);
        }
    }

    CTOfficeStyleSheet addNewTheme();

    CTOfficeStyleSheet getTheme();

    void setTheme(CTOfficeStyleSheet cTOfficeStyleSheet);
}
