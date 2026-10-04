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
public interface CTTblPr extends CTTblPrBase {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTblPr.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttblpr5b72type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTblPr newInstance() {
            return (CTTblPr) POIXMLTypeLoader.newInstance(CTTblPr.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTblPr.type, null);
        }

        public static CTTblPr parse(File file) {
            return (CTTblPr) POIXMLTypeLoader.parse(file, CTTblPr.type, (XmlOptions) null);
        }

        public static CTTblPr newInstance(XmlOptions xmlOptions) {
            return (CTTblPr) POIXMLTypeLoader.newInstance(CTTblPr.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTblPr.type, xmlOptions);
        }

        public static CTTblPr parse(File file, XmlOptions xmlOptions) {
            return (CTTblPr) POIXMLTypeLoader.parse(file, CTTblPr.type, xmlOptions);
        }

        public static CTTblPr parse(InputStream inputStream) {
            return (CTTblPr) POIXMLTypeLoader.parse(inputStream, CTTblPr.type, (XmlOptions) null);
        }

        public static CTTblPr parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTblPr) POIXMLTypeLoader.parse(inputStream, CTTblPr.type, xmlOptions);
        }

        public static CTTblPr parse(Reader reader) {
            return (CTTblPr) POIXMLTypeLoader.parse(reader, CTTblPr.type, (XmlOptions) null);
        }

        public static CTTblPr parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTblPr) POIXMLTypeLoader.parse(reader, CTTblPr.type, xmlOptions);
        }

        public static CTTblPr parse(String str) {
            return (CTTblPr) POIXMLTypeLoader.parse(str, CTTblPr.type, (XmlOptions) null);
        }

        public static CTTblPr parse(String str, XmlOptions xmlOptions) {
            return (CTTblPr) POIXMLTypeLoader.parse(str, CTTblPr.type, xmlOptions);
        }

        public static CTTblPr parse(URL url) {
            return (CTTblPr) POIXMLTypeLoader.parse(url, CTTblPr.type, (XmlOptions) null);
        }

        public static CTTblPr parse(URL url, XmlOptions xmlOptions) {
            return (CTTblPr) POIXMLTypeLoader.parse(url, CTTblPr.type, xmlOptions);
        }

        public static CTTblPr parse(XMLStreamReader xMLStreamReader) {
            return (CTTblPr) POIXMLTypeLoader.parse(xMLStreamReader, CTTblPr.type, (XmlOptions) null);
        }

        public static CTTblPr parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTblPr) POIXMLTypeLoader.parse(xMLStreamReader, CTTblPr.type, xmlOptions);
        }

        public static CTTblPr parse(XMLInputStream xMLInputStream) {
            return (CTTblPr) POIXMLTypeLoader.parse(xMLInputStream, CTTblPr.type, (XmlOptions) null);
        }

        public static CTTblPr parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTblPr) POIXMLTypeLoader.parse(xMLInputStream, CTTblPr.type, xmlOptions);
        }

        public static CTTblPr parse(Node node) {
            return (CTTblPr) POIXMLTypeLoader.parse(node, CTTblPr.type, (XmlOptions) null);
        }

        public static CTTblPr parse(Node node, XmlOptions xmlOptions) {
            return (CTTblPr) POIXMLTypeLoader.parse(node, CTTblPr.type, xmlOptions);
        }
    }

    CTTblPrChange addNewTblPrChange();

    CTTblPrChange getTblPrChange();

    boolean isSetTblPrChange();

    void setTblPrChange(CTTblPrChange cTTblPrChange);

    void unsetTblPrChange();
}
