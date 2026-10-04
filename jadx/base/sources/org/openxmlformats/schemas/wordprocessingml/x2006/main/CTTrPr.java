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
public interface CTTrPr extends CTTrPrBase {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTrPr.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttrpr2848type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTrPr newInstance() {
            return (CTTrPr) POIXMLTypeLoader.newInstance(CTTrPr.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTrPr.type, null);
        }

        public static CTTrPr parse(File file) {
            return (CTTrPr) POIXMLTypeLoader.parse(file, CTTrPr.type, (XmlOptions) null);
        }

        public static CTTrPr newInstance(XmlOptions xmlOptions) {
            return (CTTrPr) POIXMLTypeLoader.newInstance(CTTrPr.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTrPr.type, xmlOptions);
        }

        public static CTTrPr parse(File file, XmlOptions xmlOptions) {
            return (CTTrPr) POIXMLTypeLoader.parse(file, CTTrPr.type, xmlOptions);
        }

        public static CTTrPr parse(InputStream inputStream) {
            return (CTTrPr) POIXMLTypeLoader.parse(inputStream, CTTrPr.type, (XmlOptions) null);
        }

        public static CTTrPr parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTrPr) POIXMLTypeLoader.parse(inputStream, CTTrPr.type, xmlOptions);
        }

        public static CTTrPr parse(Reader reader) {
            return (CTTrPr) POIXMLTypeLoader.parse(reader, CTTrPr.type, (XmlOptions) null);
        }

        public static CTTrPr parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTrPr) POIXMLTypeLoader.parse(reader, CTTrPr.type, xmlOptions);
        }

        public static CTTrPr parse(String str) {
            return (CTTrPr) POIXMLTypeLoader.parse(str, CTTrPr.type, (XmlOptions) null);
        }

        public static CTTrPr parse(String str, XmlOptions xmlOptions) {
            return (CTTrPr) POIXMLTypeLoader.parse(str, CTTrPr.type, xmlOptions);
        }

        public static CTTrPr parse(URL url) {
            return (CTTrPr) POIXMLTypeLoader.parse(url, CTTrPr.type, (XmlOptions) null);
        }

        public static CTTrPr parse(URL url, XmlOptions xmlOptions) {
            return (CTTrPr) POIXMLTypeLoader.parse(url, CTTrPr.type, xmlOptions);
        }

        public static CTTrPr parse(XMLStreamReader xMLStreamReader) {
            return (CTTrPr) POIXMLTypeLoader.parse(xMLStreamReader, CTTrPr.type, (XmlOptions) null);
        }

        public static CTTrPr parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTrPr) POIXMLTypeLoader.parse(xMLStreamReader, CTTrPr.type, xmlOptions);
        }

        public static CTTrPr parse(XMLInputStream xMLInputStream) {
            return (CTTrPr) POIXMLTypeLoader.parse(xMLInputStream, CTTrPr.type, (XmlOptions) null);
        }

        public static CTTrPr parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTrPr) POIXMLTypeLoader.parse(xMLInputStream, CTTrPr.type, xmlOptions);
        }

        public static CTTrPr parse(Node node) {
            return (CTTrPr) POIXMLTypeLoader.parse(node, CTTrPr.type, (XmlOptions) null);
        }

        public static CTTrPr parse(Node node, XmlOptions xmlOptions) {
            return (CTTrPr) POIXMLTypeLoader.parse(node, CTTrPr.type, xmlOptions);
        }
    }

    CTTrackChange addNewDel();

    CTTrackChange addNewIns();

    CTTrPrChange addNewTrPrChange();

    CTTrackChange getDel();

    CTTrackChange getIns();

    CTTrPrChange getTrPrChange();

    boolean isSetDel();

    boolean isSetIns();

    boolean isSetTrPrChange();

    void setDel(CTTrackChange cTTrackChange);

    void setIns(CTTrackChange cTTrackChange);

    void setTrPrChange(CTTrPrChange cTTrPrChange);

    void unsetDel();

    void unsetIns();

    void unsetTrPrChange();
}
