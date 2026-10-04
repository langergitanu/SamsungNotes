package org.openxmlformats.schemas.wordprocessingml.x2006.main;

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
public interface SettingsDocument extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(SettingsDocument.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "settings9dd1doctype");

    public static final class Factory {
        private Factory() {
        }

        public static SettingsDocument newInstance() {
            return (SettingsDocument) POIXMLTypeLoader.newInstance(SettingsDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, SettingsDocument.type, null);
        }

        public static SettingsDocument parse(File file) {
            return (SettingsDocument) POIXMLTypeLoader.parse(file, SettingsDocument.type, (XmlOptions) null);
        }

        public static SettingsDocument newInstance(XmlOptions xmlOptions) {
            return (SettingsDocument) POIXMLTypeLoader.newInstance(SettingsDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, SettingsDocument.type, xmlOptions);
        }

        public static SettingsDocument parse(File file, XmlOptions xmlOptions) {
            return (SettingsDocument) POIXMLTypeLoader.parse(file, SettingsDocument.type, xmlOptions);
        }

        public static SettingsDocument parse(InputStream inputStream) {
            return (SettingsDocument) POIXMLTypeLoader.parse(inputStream, SettingsDocument.type, (XmlOptions) null);
        }

        public static SettingsDocument parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (SettingsDocument) POIXMLTypeLoader.parse(inputStream, SettingsDocument.type, xmlOptions);
        }

        public static SettingsDocument parse(Reader reader) {
            return (SettingsDocument) POIXMLTypeLoader.parse(reader, SettingsDocument.type, (XmlOptions) null);
        }

        public static SettingsDocument parse(Reader reader, XmlOptions xmlOptions) {
            return (SettingsDocument) POIXMLTypeLoader.parse(reader, SettingsDocument.type, xmlOptions);
        }

        public static SettingsDocument parse(String str) {
            return (SettingsDocument) POIXMLTypeLoader.parse(str, SettingsDocument.type, (XmlOptions) null);
        }

        public static SettingsDocument parse(String str, XmlOptions xmlOptions) {
            return (SettingsDocument) POIXMLTypeLoader.parse(str, SettingsDocument.type, xmlOptions);
        }

        public static SettingsDocument parse(URL url) {
            return (SettingsDocument) POIXMLTypeLoader.parse(url, SettingsDocument.type, (XmlOptions) null);
        }

        public static SettingsDocument parse(URL url, XmlOptions xmlOptions) {
            return (SettingsDocument) POIXMLTypeLoader.parse(url, SettingsDocument.type, xmlOptions);
        }

        public static SettingsDocument parse(XMLStreamReader xMLStreamReader) {
            return (SettingsDocument) POIXMLTypeLoader.parse(xMLStreamReader, SettingsDocument.type, (XmlOptions) null);
        }

        public static SettingsDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (SettingsDocument) POIXMLTypeLoader.parse(xMLStreamReader, SettingsDocument.type, xmlOptions);
        }

        public static SettingsDocument parse(XMLInputStream xMLInputStream) {
            return (SettingsDocument) POIXMLTypeLoader.parse(xMLInputStream, SettingsDocument.type, (XmlOptions) null);
        }

        public static SettingsDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (SettingsDocument) POIXMLTypeLoader.parse(xMLInputStream, SettingsDocument.type, xmlOptions);
        }

        public static SettingsDocument parse(Node node) {
            return (SettingsDocument) POIXMLTypeLoader.parse(node, SettingsDocument.type, (XmlOptions) null);
        }

        public static SettingsDocument parse(Node node, XmlOptions xmlOptions) {
            return (SettingsDocument) POIXMLTypeLoader.parse(node, SettingsDocument.type, xmlOptions);
        }
    }

    CTSettings addNewSettings();

    CTSettings getSettings();

    void setSettings(CTSettings cTSettings);
}
