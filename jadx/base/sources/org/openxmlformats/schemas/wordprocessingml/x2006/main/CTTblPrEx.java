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
public interface CTTblPrEx extends CTTblPrExBase {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTblPrEx.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttblprex863ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTblPrEx newInstance() {
            return (CTTblPrEx) POIXMLTypeLoader.newInstance(CTTblPrEx.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTblPrEx.type, null);
        }

        public static CTTblPrEx parse(File file) {
            return (CTTblPrEx) POIXMLTypeLoader.parse(file, CTTblPrEx.type, (XmlOptions) null);
        }

        public static CTTblPrEx newInstance(XmlOptions xmlOptions) {
            return (CTTblPrEx) POIXMLTypeLoader.newInstance(CTTblPrEx.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTblPrEx.type, xmlOptions);
        }

        public static CTTblPrEx parse(File file, XmlOptions xmlOptions) {
            return (CTTblPrEx) POIXMLTypeLoader.parse(file, CTTblPrEx.type, xmlOptions);
        }

        public static CTTblPrEx parse(InputStream inputStream) {
            return (CTTblPrEx) POIXMLTypeLoader.parse(inputStream, CTTblPrEx.type, (XmlOptions) null);
        }

        public static CTTblPrEx parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTblPrEx) POIXMLTypeLoader.parse(inputStream, CTTblPrEx.type, xmlOptions);
        }

        public static CTTblPrEx parse(Reader reader) {
            return (CTTblPrEx) POIXMLTypeLoader.parse(reader, CTTblPrEx.type, (XmlOptions) null);
        }

        public static CTTblPrEx parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTblPrEx) POIXMLTypeLoader.parse(reader, CTTblPrEx.type, xmlOptions);
        }

        public static CTTblPrEx parse(String str) {
            return (CTTblPrEx) POIXMLTypeLoader.parse(str, CTTblPrEx.type, (XmlOptions) null);
        }

        public static CTTblPrEx parse(String str, XmlOptions xmlOptions) {
            return (CTTblPrEx) POIXMLTypeLoader.parse(str, CTTblPrEx.type, xmlOptions);
        }

        public static CTTblPrEx parse(URL url) {
            return (CTTblPrEx) POIXMLTypeLoader.parse(url, CTTblPrEx.type, (XmlOptions) null);
        }

        public static CTTblPrEx parse(URL url, XmlOptions xmlOptions) {
            return (CTTblPrEx) POIXMLTypeLoader.parse(url, CTTblPrEx.type, xmlOptions);
        }

        public static CTTblPrEx parse(XMLStreamReader xMLStreamReader) {
            return (CTTblPrEx) POIXMLTypeLoader.parse(xMLStreamReader, CTTblPrEx.type, (XmlOptions) null);
        }

        public static CTTblPrEx parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTblPrEx) POIXMLTypeLoader.parse(xMLStreamReader, CTTblPrEx.type, xmlOptions);
        }

        public static CTTblPrEx parse(XMLInputStream xMLInputStream) {
            return (CTTblPrEx) POIXMLTypeLoader.parse(xMLInputStream, CTTblPrEx.type, (XmlOptions) null);
        }

        public static CTTblPrEx parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTblPrEx) POIXMLTypeLoader.parse(xMLInputStream, CTTblPrEx.type, xmlOptions);
        }

        public static CTTblPrEx parse(Node node) {
            return (CTTblPrEx) POIXMLTypeLoader.parse(node, CTTblPrEx.type, (XmlOptions) null);
        }

        public static CTTblPrEx parse(Node node, XmlOptions xmlOptions) {
            return (CTTblPrEx) POIXMLTypeLoader.parse(node, CTTblPrEx.type, xmlOptions);
        }
    }

    CTTblPrExChange addNewTblPrExChange();

    CTTblPrExChange getTblPrExChange();

    boolean isSetTblPrExChange();

    void setTblPrExChange(CTTblPrExChange cTTblPrExChange);

    void unsetTblPrExChange();
}
