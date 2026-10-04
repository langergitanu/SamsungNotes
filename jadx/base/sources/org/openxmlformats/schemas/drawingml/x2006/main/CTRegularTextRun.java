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
import org.apache.xmlbeans.XmlString;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTRegularTextRun extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTRegularTextRun.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctregulartextrun7e3dtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTRegularTextRun newInstance() {
            return (CTRegularTextRun) POIXMLTypeLoader.newInstance(CTRegularTextRun.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTRegularTextRun.type, null);
        }

        public static CTRegularTextRun parse(File file) {
            return (CTRegularTextRun) POIXMLTypeLoader.parse(file, CTRegularTextRun.type, (XmlOptions) null);
        }

        public static CTRegularTextRun newInstance(XmlOptions xmlOptions) {
            return (CTRegularTextRun) POIXMLTypeLoader.newInstance(CTRegularTextRun.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTRegularTextRun.type, xmlOptions);
        }

        public static CTRegularTextRun parse(File file, XmlOptions xmlOptions) {
            return (CTRegularTextRun) POIXMLTypeLoader.parse(file, CTRegularTextRun.type, xmlOptions);
        }

        public static CTRegularTextRun parse(InputStream inputStream) {
            return (CTRegularTextRun) POIXMLTypeLoader.parse(inputStream, CTRegularTextRun.type, (XmlOptions) null);
        }

        public static CTRegularTextRun parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTRegularTextRun) POIXMLTypeLoader.parse(inputStream, CTRegularTextRun.type, xmlOptions);
        }

        public static CTRegularTextRun parse(Reader reader) {
            return (CTRegularTextRun) POIXMLTypeLoader.parse(reader, CTRegularTextRun.type, (XmlOptions) null);
        }

        public static CTRegularTextRun parse(Reader reader, XmlOptions xmlOptions) {
            return (CTRegularTextRun) POIXMLTypeLoader.parse(reader, CTRegularTextRun.type, xmlOptions);
        }

        public static CTRegularTextRun parse(String str) {
            return (CTRegularTextRun) POIXMLTypeLoader.parse(str, CTRegularTextRun.type, (XmlOptions) null);
        }

        public static CTRegularTextRun parse(String str, XmlOptions xmlOptions) {
            return (CTRegularTextRun) POIXMLTypeLoader.parse(str, CTRegularTextRun.type, xmlOptions);
        }

        public static CTRegularTextRun parse(URL url) {
            return (CTRegularTextRun) POIXMLTypeLoader.parse(url, CTRegularTextRun.type, (XmlOptions) null);
        }

        public static CTRegularTextRun parse(URL url, XmlOptions xmlOptions) {
            return (CTRegularTextRun) POIXMLTypeLoader.parse(url, CTRegularTextRun.type, xmlOptions);
        }

        public static CTRegularTextRun parse(XMLStreamReader xMLStreamReader) {
            return (CTRegularTextRun) POIXMLTypeLoader.parse(xMLStreamReader, CTRegularTextRun.type, (XmlOptions) null);
        }

        public static CTRegularTextRun parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTRegularTextRun) POIXMLTypeLoader.parse(xMLStreamReader, CTRegularTextRun.type, xmlOptions);
        }

        public static CTRegularTextRun parse(XMLInputStream xMLInputStream) {
            return (CTRegularTextRun) POIXMLTypeLoader.parse(xMLInputStream, CTRegularTextRun.type, (XmlOptions) null);
        }

        public static CTRegularTextRun parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTRegularTextRun) POIXMLTypeLoader.parse(xMLInputStream, CTRegularTextRun.type, xmlOptions);
        }

        public static CTRegularTextRun parse(Node node) {
            return (CTRegularTextRun) POIXMLTypeLoader.parse(node, CTRegularTextRun.type, (XmlOptions) null);
        }

        public static CTRegularTextRun parse(Node node, XmlOptions xmlOptions) {
            return (CTRegularTextRun) POIXMLTypeLoader.parse(node, CTRegularTextRun.type, xmlOptions);
        }
    }

    CTTextCharacterProperties addNewRPr();

    CTTextCharacterProperties getRPr();

    String getT();

    boolean isSetRPr();

    void setRPr(CTTextCharacterProperties cTTextCharacterProperties);

    void setT(String str);

    void unsetRPr();

    XmlString xgetT();

    void xsetT(XmlString xmlString);
}
