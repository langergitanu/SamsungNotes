package org.openxmlformats.schemas.presentationml.x2006.main;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.XmlUnsignedInt;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface STSlideMasterId extends XmlUnsignedInt {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(STSlideMasterId.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "stslidemasteridfe71type");

    public static final class Factory {
        private Factory() {
        }

        public static STSlideMasterId newInstance() {
            return (STSlideMasterId) POIXMLTypeLoader.newInstance(STSlideMasterId.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STSlideMasterId.type, null);
        }

        public static STSlideMasterId newValue(Object obj) {
            return (STSlideMasterId) STSlideMasterId.type.newValue(obj);
        }

        public static STSlideMasterId parse(File file) {
            return (STSlideMasterId) POIXMLTypeLoader.parse(file, STSlideMasterId.type, (XmlOptions) null);
        }

        public static STSlideMasterId newInstance(XmlOptions xmlOptions) {
            return (STSlideMasterId) POIXMLTypeLoader.newInstance(STSlideMasterId.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, STSlideMasterId.type, xmlOptions);
        }

        public static STSlideMasterId parse(File file, XmlOptions xmlOptions) {
            return (STSlideMasterId) POIXMLTypeLoader.parse(file, STSlideMasterId.type, xmlOptions);
        }

        public static STSlideMasterId parse(InputStream inputStream) {
            return (STSlideMasterId) POIXMLTypeLoader.parse(inputStream, STSlideMasterId.type, (XmlOptions) null);
        }

        public static STSlideMasterId parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (STSlideMasterId) POIXMLTypeLoader.parse(inputStream, STSlideMasterId.type, xmlOptions);
        }

        public static STSlideMasterId parse(Reader reader) {
            return (STSlideMasterId) POIXMLTypeLoader.parse(reader, STSlideMasterId.type, (XmlOptions) null);
        }

        public static STSlideMasterId parse(Reader reader, XmlOptions xmlOptions) {
            return (STSlideMasterId) POIXMLTypeLoader.parse(reader, STSlideMasterId.type, xmlOptions);
        }

        public static STSlideMasterId parse(String str) {
            return (STSlideMasterId) POIXMLTypeLoader.parse(str, STSlideMasterId.type, (XmlOptions) null);
        }

        public static STSlideMasterId parse(String str, XmlOptions xmlOptions) {
            return (STSlideMasterId) POIXMLTypeLoader.parse(str, STSlideMasterId.type, xmlOptions);
        }

        public static STSlideMasterId parse(URL url) {
            return (STSlideMasterId) POIXMLTypeLoader.parse(url, STSlideMasterId.type, (XmlOptions) null);
        }

        public static STSlideMasterId parse(URL url, XmlOptions xmlOptions) {
            return (STSlideMasterId) POIXMLTypeLoader.parse(url, STSlideMasterId.type, xmlOptions);
        }

        public static STSlideMasterId parse(XMLStreamReader xMLStreamReader) {
            return (STSlideMasterId) POIXMLTypeLoader.parse(xMLStreamReader, STSlideMasterId.type, (XmlOptions) null);
        }

        public static STSlideMasterId parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (STSlideMasterId) POIXMLTypeLoader.parse(xMLStreamReader, STSlideMasterId.type, xmlOptions);
        }

        public static STSlideMasterId parse(XMLInputStream xMLInputStream) {
            return (STSlideMasterId) POIXMLTypeLoader.parse(xMLInputStream, STSlideMasterId.type, (XmlOptions) null);
        }

        public static STSlideMasterId parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (STSlideMasterId) POIXMLTypeLoader.parse(xMLInputStream, STSlideMasterId.type, xmlOptions);
        }

        public static STSlideMasterId parse(Node node) {
            return (STSlideMasterId) POIXMLTypeLoader.parse(node, STSlideMasterId.type, (XmlOptions) null);
        }

        public static STSlideMasterId parse(Node node, XmlOptions xmlOptions) {
            return (STSlideMasterId) POIXMLTypeLoader.parse(node, STSlideMasterId.type, xmlOptions);
        }
    }
}
