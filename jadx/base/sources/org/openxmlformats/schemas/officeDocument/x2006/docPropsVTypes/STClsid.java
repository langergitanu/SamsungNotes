package org.openxmlformats.schemas.officeDocument.x2006.docPropsVTypes;

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
public interface STClsid extends XmlString {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STClsid.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "stclsida7datype");

    public static final class Factory {
        private Factory() {
        }

        public static STClsid newInstance() {
            return (STClsid) POIXMLTypeLoader.newInstance(STClsid.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STClsid.type, null);
        }

        public static STClsid newValue(Object obj) {
            return (STClsid) STClsid.type.newValue(obj);
        }

        public static STClsid parse(File file) {
            return (STClsid) POIXMLTypeLoader.parse(file, STClsid.type, (XmlOptions) null);
        }

        public static STClsid newInstance(XmlOptions xmlOptions) {
            return (STClsid) POIXMLTypeLoader.newInstance(STClsid.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STClsid.type, xmlOptions);
        }

        public static STClsid parse(File file, XmlOptions xmlOptions) {
            return (STClsid) POIXMLTypeLoader.parse(file, STClsid.type, xmlOptions);
        }

        public static STClsid parse(InputStream inputStream) {
            return (STClsid) POIXMLTypeLoader.parse(inputStream, STClsid.type, (XmlOptions) null);
        }

        public static STClsid parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STClsid) POIXMLTypeLoader.parse(inputStream, STClsid.type, xmlOptions);
        }

        public static STClsid parse(Reader reader) {
            return (STClsid) POIXMLTypeLoader.parse(reader, STClsid.type, (XmlOptions) null);
        }

        public static STClsid parse(Reader reader, XmlOptions xmlOptions) {
            return (STClsid) POIXMLTypeLoader.parse(reader, STClsid.type, xmlOptions);
        }

        public static STClsid parse(String str) {
            return (STClsid) POIXMLTypeLoader.parse(str, STClsid.type, (XmlOptions) null);
        }

        public static STClsid parse(String str, XmlOptions xmlOptions) {
            return (STClsid) POIXMLTypeLoader.parse(str, STClsid.type, xmlOptions);
        }

        public static STClsid parse(URL url) {
            return (STClsid) POIXMLTypeLoader.parse(url, STClsid.type, (XmlOptions) null);
        }

        public static STClsid parse(URL url, XmlOptions xmlOptions) {
            return (STClsid) POIXMLTypeLoader.parse(url, STClsid.type, xmlOptions);
        }

        public static STClsid parse(XMLStreamReader xMLStreamReader) {
            return (STClsid) POIXMLTypeLoader.parse(xMLStreamReader, STClsid.type, (XmlOptions) null);
        }

        public static STClsid parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STClsid) POIXMLTypeLoader.parse(xMLStreamReader, STClsid.type, xmlOptions);
        }

        public static STClsid parse(XMLInputStream xMLInputStream) {
            return (STClsid) POIXMLTypeLoader.parse(xMLInputStream, STClsid.type, (XmlOptions) null);
        }

        public static STClsid parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STClsid) POIXMLTypeLoader.parse(xMLInputStream, STClsid.type, xmlOptions);
        }

        public static STClsid parse(Node node) {
            return (STClsid) POIXMLTypeLoader.parse(node, STClsid.type, (XmlOptions) null);
        }

        public static STClsid parse(Node node, XmlOptions xmlOptions) {
            return (STClsid) POIXMLTypeLoader.parse(node, STClsid.type, xmlOptions);
        }
    }
}
