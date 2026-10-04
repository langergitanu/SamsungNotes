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
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STMultiLevelType;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTMultiLevelType extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTMultiLevelType.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctmultileveltypea223type");

    public static final class Factory {
        private Factory() {
        }

        public static CTMultiLevelType newInstance() {
            return (CTMultiLevelType) POIXMLTypeLoader.newInstance(CTMultiLevelType.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTMultiLevelType.type, null);
        }

        public static CTMultiLevelType parse(File file) {
            return (CTMultiLevelType) POIXMLTypeLoader.parse(file, CTMultiLevelType.type, (XmlOptions) null);
        }

        public static CTMultiLevelType newInstance(XmlOptions xmlOptions) {
            return (CTMultiLevelType) POIXMLTypeLoader.newInstance(CTMultiLevelType.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTMultiLevelType.type, xmlOptions);
        }

        public static CTMultiLevelType parse(File file, XmlOptions xmlOptions) {
            return (CTMultiLevelType) POIXMLTypeLoader.parse(file, CTMultiLevelType.type, xmlOptions);
        }

        public static CTMultiLevelType parse(InputStream inputStream) {
            return (CTMultiLevelType) POIXMLTypeLoader.parse(inputStream, CTMultiLevelType.type, (XmlOptions) null);
        }

        public static CTMultiLevelType parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTMultiLevelType) POIXMLTypeLoader.parse(inputStream, CTMultiLevelType.type, xmlOptions);
        }

        public static CTMultiLevelType parse(Reader reader) {
            return (CTMultiLevelType) POIXMLTypeLoader.parse(reader, CTMultiLevelType.type, (XmlOptions) null);
        }

        public static CTMultiLevelType parse(Reader reader, XmlOptions xmlOptions) {
            return (CTMultiLevelType) POIXMLTypeLoader.parse(reader, CTMultiLevelType.type, xmlOptions);
        }

        public static CTMultiLevelType parse(String str) {
            return (CTMultiLevelType) POIXMLTypeLoader.parse(str, CTMultiLevelType.type, (XmlOptions) null);
        }

        public static CTMultiLevelType parse(String str, XmlOptions xmlOptions) {
            return (CTMultiLevelType) POIXMLTypeLoader.parse(str, CTMultiLevelType.type, xmlOptions);
        }

        public static CTMultiLevelType parse(URL url) {
            return (CTMultiLevelType) POIXMLTypeLoader.parse(url, CTMultiLevelType.type, (XmlOptions) null);
        }

        public static CTMultiLevelType parse(URL url, XmlOptions xmlOptions) {
            return (CTMultiLevelType) POIXMLTypeLoader.parse(url, CTMultiLevelType.type, xmlOptions);
        }

        public static CTMultiLevelType parse(XMLStreamReader xMLStreamReader) {
            return (CTMultiLevelType) POIXMLTypeLoader.parse(xMLStreamReader, CTMultiLevelType.type, (XmlOptions) null);
        }

        public static CTMultiLevelType parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTMultiLevelType) POIXMLTypeLoader.parse(xMLStreamReader, CTMultiLevelType.type, xmlOptions);
        }

        public static CTMultiLevelType parse(XMLInputStream xMLInputStream) {
            return (CTMultiLevelType) POIXMLTypeLoader.parse(xMLInputStream, CTMultiLevelType.type, (XmlOptions) null);
        }

        public static CTMultiLevelType parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTMultiLevelType) POIXMLTypeLoader.parse(xMLInputStream, CTMultiLevelType.type, xmlOptions);
        }

        public static CTMultiLevelType parse(Node node) {
            return (CTMultiLevelType) POIXMLTypeLoader.parse(node, CTMultiLevelType.type, (XmlOptions) null);
        }

        public static CTMultiLevelType parse(Node node, XmlOptions xmlOptions) {
            return (CTMultiLevelType) POIXMLTypeLoader.parse(node, CTMultiLevelType.type, xmlOptions);
        }
    }

    STMultiLevelType.Enum getVal();

    void setVal(STMultiLevelType.Enum r12);

    STMultiLevelType xgetVal();

    void xsetVal(STMultiLevelType sTMultiLevelType);
}
