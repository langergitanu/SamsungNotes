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
public interface CTTblGrid extends CTTblGridBase {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTblGrid.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttblgrid2eeetype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTblGrid newInstance() {
            return (CTTblGrid) POIXMLTypeLoader.newInstance(CTTblGrid.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTblGrid.type, null);
        }

        public static CTTblGrid parse(File file) {
            return (CTTblGrid) POIXMLTypeLoader.parse(file, CTTblGrid.type, (XmlOptions) null);
        }

        public static CTTblGrid newInstance(XmlOptions xmlOptions) {
            return (CTTblGrid) POIXMLTypeLoader.newInstance(CTTblGrid.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTblGrid.type, xmlOptions);
        }

        public static CTTblGrid parse(File file, XmlOptions xmlOptions) {
            return (CTTblGrid) POIXMLTypeLoader.parse(file, CTTblGrid.type, xmlOptions);
        }

        public static CTTblGrid parse(InputStream inputStream) {
            return (CTTblGrid) POIXMLTypeLoader.parse(inputStream, CTTblGrid.type, (XmlOptions) null);
        }

        public static CTTblGrid parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTblGrid) POIXMLTypeLoader.parse(inputStream, CTTblGrid.type, xmlOptions);
        }

        public static CTTblGrid parse(Reader reader) {
            return (CTTblGrid) POIXMLTypeLoader.parse(reader, CTTblGrid.type, (XmlOptions) null);
        }

        public static CTTblGrid parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTblGrid) POIXMLTypeLoader.parse(reader, CTTblGrid.type, xmlOptions);
        }

        public static CTTblGrid parse(String str) {
            return (CTTblGrid) POIXMLTypeLoader.parse(str, CTTblGrid.type, (XmlOptions) null);
        }

        public static CTTblGrid parse(String str, XmlOptions xmlOptions) {
            return (CTTblGrid) POIXMLTypeLoader.parse(str, CTTblGrid.type, xmlOptions);
        }

        public static CTTblGrid parse(URL url) {
            return (CTTblGrid) POIXMLTypeLoader.parse(url, CTTblGrid.type, (XmlOptions) null);
        }

        public static CTTblGrid parse(URL url, XmlOptions xmlOptions) {
            return (CTTblGrid) POIXMLTypeLoader.parse(url, CTTblGrid.type, xmlOptions);
        }

        public static CTTblGrid parse(XMLStreamReader xMLStreamReader) {
            return (CTTblGrid) POIXMLTypeLoader.parse(xMLStreamReader, CTTblGrid.type, (XmlOptions) null);
        }

        public static CTTblGrid parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTblGrid) POIXMLTypeLoader.parse(xMLStreamReader, CTTblGrid.type, xmlOptions);
        }

        public static CTTblGrid parse(XMLInputStream xMLInputStream) {
            return (CTTblGrid) POIXMLTypeLoader.parse(xMLInputStream, CTTblGrid.type, (XmlOptions) null);
        }

        public static CTTblGrid parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTblGrid) POIXMLTypeLoader.parse(xMLInputStream, CTTblGrid.type, xmlOptions);
        }

        public static CTTblGrid parse(Node node) {
            return (CTTblGrid) POIXMLTypeLoader.parse(node, CTTblGrid.type, (XmlOptions) null);
        }

        public static CTTblGrid parse(Node node, XmlOptions xmlOptions) {
            return (CTTblGrid) POIXMLTypeLoader.parse(node, CTTblGrid.type, xmlOptions);
        }
    }

    CTTblGridChange addNewTblGridChange();

    CTTblGridChange getTblGridChange();

    boolean isSetTblGridChange();

    void setTblGridChange(CTTblGridChange cTTblGridChange);

    void unsetTblGridChange();
}
