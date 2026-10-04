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
public interface NumberingDocument extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(NumberingDocument.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "numbering1c4ddoctype");

    public static final class Factory {
        private Factory() {
        }

        public static NumberingDocument newInstance() {
            return (NumberingDocument) POIXMLTypeLoader.newInstance(NumberingDocument.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, NumberingDocument.type, null);
        }

        public static NumberingDocument parse(File file) {
            return (NumberingDocument) POIXMLTypeLoader.parse(file, NumberingDocument.type, (XmlOptions) null);
        }

        public static NumberingDocument newInstance(XmlOptions xmlOptions) {
            return (NumberingDocument) POIXMLTypeLoader.newInstance(NumberingDocument.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, NumberingDocument.type, xmlOptions);
        }

        public static NumberingDocument parse(File file, XmlOptions xmlOptions) {
            return (NumberingDocument) POIXMLTypeLoader.parse(file, NumberingDocument.type, xmlOptions);
        }

        public static NumberingDocument parse(InputStream inputStream) {
            return (NumberingDocument) POIXMLTypeLoader.parse(inputStream, NumberingDocument.type, (XmlOptions) null);
        }

        public static NumberingDocument parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (NumberingDocument) POIXMLTypeLoader.parse(inputStream, NumberingDocument.type, xmlOptions);
        }

        public static NumberingDocument parse(Reader reader) {
            return (NumberingDocument) POIXMLTypeLoader.parse(reader, NumberingDocument.type, (XmlOptions) null);
        }

        public static NumberingDocument parse(Reader reader, XmlOptions xmlOptions) {
            return (NumberingDocument) POIXMLTypeLoader.parse(reader, NumberingDocument.type, xmlOptions);
        }

        public static NumberingDocument parse(String str) {
            return (NumberingDocument) POIXMLTypeLoader.parse(str, NumberingDocument.type, (XmlOptions) null);
        }

        public static NumberingDocument parse(String str, XmlOptions xmlOptions) {
            return (NumberingDocument) POIXMLTypeLoader.parse(str, NumberingDocument.type, xmlOptions);
        }

        public static NumberingDocument parse(URL url) {
            return (NumberingDocument) POIXMLTypeLoader.parse(url, NumberingDocument.type, (XmlOptions) null);
        }

        public static NumberingDocument parse(URL url, XmlOptions xmlOptions) {
            return (NumberingDocument) POIXMLTypeLoader.parse(url, NumberingDocument.type, xmlOptions);
        }

        public static NumberingDocument parse(XMLStreamReader xMLStreamReader) {
            return (NumberingDocument) POIXMLTypeLoader.parse(xMLStreamReader, NumberingDocument.type, (XmlOptions) null);
        }

        public static NumberingDocument parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (NumberingDocument) POIXMLTypeLoader.parse(xMLStreamReader, NumberingDocument.type, xmlOptions);
        }

        public static NumberingDocument parse(XMLInputStream xMLInputStream) {
            return (NumberingDocument) POIXMLTypeLoader.parse(xMLInputStream, NumberingDocument.type, (XmlOptions) null);
        }

        public static NumberingDocument parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (NumberingDocument) POIXMLTypeLoader.parse(xMLInputStream, NumberingDocument.type, xmlOptions);
        }

        public static NumberingDocument parse(Node node) {
            return (NumberingDocument) POIXMLTypeLoader.parse(node, NumberingDocument.type, (XmlOptions) null);
        }

        public static NumberingDocument parse(Node node, XmlOptions xmlOptions) {
            return (NumberingDocument) POIXMLTypeLoader.parse(node, NumberingDocument.type, xmlOptions);
        }
    }

    CTNumbering addNewNumbering();

    CTNumbering getNumbering();

    void setNumbering(CTNumbering cTNumbering);
}
