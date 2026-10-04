package org.openxmlformats.schemas.drawingml.x2006.main;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface STTextLanguageID extends XmlString {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STTextLanguageID.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "sttextlanguageid806btype");

    public static final class Factory {
        private Factory() {
        }

        public static STTextLanguageID newInstance() {
            return (STTextLanguageID) POIXMLTypeLoader.newInstance(STTextLanguageID.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextLanguageID.type, null);
        }

        public static STTextLanguageID newValue(Object obj) {
            return (STTextLanguageID) STTextLanguageID.type.newValue(obj);
        }

        public static STTextLanguageID parse(File file) {
            return (STTextLanguageID) POIXMLTypeLoader.parse(file, STTextLanguageID.type, (XmlOptions) null);
        }

        public static STTextLanguageID newInstance(XmlOptions xmlOptions) {
            return (STTextLanguageID) POIXMLTypeLoader.newInstance(STTextLanguageID.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STTextLanguageID.type, xmlOptions);
        }

        public static STTextLanguageID parse(File file, XmlOptions xmlOptions) {
            return (STTextLanguageID) POIXMLTypeLoader.parse(file, STTextLanguageID.type, xmlOptions);
        }

        public static STTextLanguageID parse(InputStream inputStream) {
            return (STTextLanguageID) POIXMLTypeLoader.parse(inputStream, STTextLanguageID.type, (XmlOptions) null);
        }

        public static STTextLanguageID parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STTextLanguageID) POIXMLTypeLoader.parse(inputStream, STTextLanguageID.type, xmlOptions);
        }

        public static STTextLanguageID parse(Reader reader) {
            return (STTextLanguageID) POIXMLTypeLoader.parse(reader, STTextLanguageID.type, (XmlOptions) null);
        }

        public static STTextLanguageID parse(Reader reader, XmlOptions xmlOptions) {
            return (STTextLanguageID) POIXMLTypeLoader.parse(reader, STTextLanguageID.type, xmlOptions);
        }

        public static STTextLanguageID parse(String str) {
            return (STTextLanguageID) POIXMLTypeLoader.parse(str, STTextLanguageID.type, (XmlOptions) null);
        }

        public static STTextLanguageID parse(String str, XmlOptions xmlOptions) {
            return (STTextLanguageID) POIXMLTypeLoader.parse(str, STTextLanguageID.type, xmlOptions);
        }

        public static STTextLanguageID parse(URL url) {
            return (STTextLanguageID) POIXMLTypeLoader.parse(url, STTextLanguageID.type, (XmlOptions) null);
        }

        public static STTextLanguageID parse(URL url, XmlOptions xmlOptions) {
            return (STTextLanguageID) POIXMLTypeLoader.parse(url, STTextLanguageID.type, xmlOptions);
        }

        public static STTextLanguageID parse(XMLStreamReader xMLStreamReader) {
            return (STTextLanguageID) POIXMLTypeLoader.parse(xMLStreamReader, STTextLanguageID.type, (XmlOptions) null);
        }

        public static STTextLanguageID parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STTextLanguageID) POIXMLTypeLoader.parse(xMLStreamReader, STTextLanguageID.type, xmlOptions);
        }

        public static STTextLanguageID parse(XMLInputStream xMLInputStream) {
            return (STTextLanguageID) POIXMLTypeLoader.parse(xMLInputStream, STTextLanguageID.type, (XmlOptions) null);
        }

        public static STTextLanguageID parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STTextLanguageID) POIXMLTypeLoader.parse(xMLInputStream, STTextLanguageID.type, xmlOptions);
        }

        public static STTextLanguageID parse(Node node) {
            return (STTextLanguageID) POIXMLTypeLoader.parse(node, STTextLanguageID.type, (XmlOptions) null);
        }

        public static STTextLanguageID parse(Node node, XmlOptions xmlOptions) {
            return (STTextLanguageID) POIXMLTypeLoader.parse(node, STTextLanguageID.type, xmlOptions);
        }
    }
}
