package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTTcPr extends CTTcPrInner {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTcPr.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttcpree37type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTcPr newInstance() {
            return (CTTcPr) POIXMLTypeLoader.newInstance(CTTcPr.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTcPr.type, null);
        }

        public static CTTcPr parse(File file) {
            return (CTTcPr) POIXMLTypeLoader.parse(file, CTTcPr.type, (XmlOptions) null);
        }

        public static CTTcPr newInstance(XmlOptions xmlOptions) {
            return (CTTcPr) POIXMLTypeLoader.newInstance(CTTcPr.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTcPr.type, xmlOptions);
        }

        public static CTTcPr parse(File file, XmlOptions xmlOptions) {
            return (CTTcPr) POIXMLTypeLoader.parse(file, CTTcPr.type, xmlOptions);
        }

        public static CTTcPr parse(InputStream inputStream) {
            return (CTTcPr) POIXMLTypeLoader.parse(inputStream, CTTcPr.type, (XmlOptions) null);
        }

        public static CTTcPr parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTcPr) POIXMLTypeLoader.parse(inputStream, CTTcPr.type, xmlOptions);
        }

        public static CTTcPr parse(Reader reader) {
            return (CTTcPr) POIXMLTypeLoader.parse(reader, CTTcPr.type, (XmlOptions) null);
        }

        public static CTTcPr parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTcPr) POIXMLTypeLoader.parse(reader, CTTcPr.type, xmlOptions);
        }

        public static CTTcPr parse(String str) {
            return (CTTcPr) POIXMLTypeLoader.parse(str, CTTcPr.type, (XmlOptions) null);
        }

        public static CTTcPr parse(String str, XmlOptions xmlOptions) {
            return (CTTcPr) POIXMLTypeLoader.parse(str, CTTcPr.type, xmlOptions);
        }

        public static CTTcPr parse(URL url) {
            return (CTTcPr) POIXMLTypeLoader.parse(url, CTTcPr.type, (XmlOptions) null);
        }

        public static CTTcPr parse(URL url, XmlOptions xmlOptions) {
            return (CTTcPr) POIXMLTypeLoader.parse(url, CTTcPr.type, xmlOptions);
        }

        public static CTTcPr parse(XMLStreamReader xMLStreamReader) {
            return (CTTcPr) POIXMLTypeLoader.parse(xMLStreamReader, CTTcPr.type, (XmlOptions) null);
        }

        public static CTTcPr parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTcPr) POIXMLTypeLoader.parse(xMLStreamReader, CTTcPr.type, xmlOptions);
        }

        public static CTTcPr parse(XMLInputStream xMLInputStream) {
            return (CTTcPr) POIXMLTypeLoader.parse(xMLInputStream, CTTcPr.type, (XmlOptions) null);
        }

        public static CTTcPr parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTcPr) POIXMLTypeLoader.parse(xMLInputStream, CTTcPr.type, xmlOptions);
        }

        public static CTTcPr parse(Node node) {
            return (CTTcPr) POIXMLTypeLoader.parse(node, CTTcPr.type, (XmlOptions) null);
        }

        public static CTTcPr parse(Node node, XmlOptions xmlOptions) {
            return (CTTcPr) POIXMLTypeLoader.parse(node, CTTcPr.type, xmlOptions);
        }
    }

    CTTcPrChange addNewTcPrChange();

    CTTcPrChange getTcPrChange();

    boolean isSetTcPrChange();

    void setTcPrChange(CTTcPrChange cTTcPrChange);

    void unsetTcPrChange();
}
