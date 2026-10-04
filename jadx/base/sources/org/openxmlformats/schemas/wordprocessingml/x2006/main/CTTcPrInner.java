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
public interface CTTcPrInner extends CTTcPrBase {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTcPrInner.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttcprinnerc56dtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTcPrInner newInstance() {
            return (CTTcPrInner) POIXMLTypeLoader.newInstance(CTTcPrInner.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTcPrInner.type, null);
        }

        public static CTTcPrInner parse(File file) {
            return (CTTcPrInner) POIXMLTypeLoader.parse(file, CTTcPrInner.type, (XmlOptions) null);
        }

        public static CTTcPrInner newInstance(XmlOptions xmlOptions) {
            return (CTTcPrInner) POIXMLTypeLoader.newInstance(CTTcPrInner.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTcPrInner.type, xmlOptions);
        }

        public static CTTcPrInner parse(File file, XmlOptions xmlOptions) {
            return (CTTcPrInner) POIXMLTypeLoader.parse(file, CTTcPrInner.type, xmlOptions);
        }

        public static CTTcPrInner parse(InputStream inputStream) {
            return (CTTcPrInner) POIXMLTypeLoader.parse(inputStream, CTTcPrInner.type, (XmlOptions) null);
        }

        public static CTTcPrInner parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTcPrInner) POIXMLTypeLoader.parse(inputStream, CTTcPrInner.type, xmlOptions);
        }

        public static CTTcPrInner parse(Reader reader) {
            return (CTTcPrInner) POIXMLTypeLoader.parse(reader, CTTcPrInner.type, (XmlOptions) null);
        }

        public static CTTcPrInner parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTcPrInner) POIXMLTypeLoader.parse(reader, CTTcPrInner.type, xmlOptions);
        }

        public static CTTcPrInner parse(String str) {
            return (CTTcPrInner) POIXMLTypeLoader.parse(str, CTTcPrInner.type, (XmlOptions) null);
        }

        public static CTTcPrInner parse(String str, XmlOptions xmlOptions) {
            return (CTTcPrInner) POIXMLTypeLoader.parse(str, CTTcPrInner.type, xmlOptions);
        }

        public static CTTcPrInner parse(URL url) {
            return (CTTcPrInner) POIXMLTypeLoader.parse(url, CTTcPrInner.type, (XmlOptions) null);
        }

        public static CTTcPrInner parse(URL url, XmlOptions xmlOptions) {
            return (CTTcPrInner) POIXMLTypeLoader.parse(url, CTTcPrInner.type, xmlOptions);
        }

        public static CTTcPrInner parse(XMLStreamReader xMLStreamReader) {
            return (CTTcPrInner) POIXMLTypeLoader.parse(xMLStreamReader, CTTcPrInner.type, (XmlOptions) null);
        }

        public static CTTcPrInner parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTcPrInner) POIXMLTypeLoader.parse(xMLStreamReader, CTTcPrInner.type, xmlOptions);
        }

        public static CTTcPrInner parse(XMLInputStream xMLInputStream) {
            return (CTTcPrInner) POIXMLTypeLoader.parse(xMLInputStream, CTTcPrInner.type, (XmlOptions) null);
        }

        public static CTTcPrInner parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTcPrInner) POIXMLTypeLoader.parse(xMLInputStream, CTTcPrInner.type, xmlOptions);
        }

        public static CTTcPrInner parse(Node node) {
            return (CTTcPrInner) POIXMLTypeLoader.parse(node, CTTcPrInner.type, (XmlOptions) null);
        }

        public static CTTcPrInner parse(Node node, XmlOptions xmlOptions) {
            return (CTTcPrInner) POIXMLTypeLoader.parse(node, CTTcPrInner.type, xmlOptions);
        }
    }

    CTTrackChange addNewCellDel();

    CTTrackChange addNewCellIns();

    CTCellMergeTrackChange addNewCellMerge();

    CTTrackChange getCellDel();

    CTTrackChange getCellIns();

    CTCellMergeTrackChange getCellMerge();

    boolean isSetCellDel();

    boolean isSetCellIns();

    boolean isSetCellMerge();

    void setCellDel(CTTrackChange cTTrackChange);

    void setCellIns(CTTrackChange cTTrackChange);

    void setCellMerge(CTCellMergeTrackChange cTCellMergeTrackChange);

    void unsetCellDel();

    void unsetCellIns();

    void unsetCellMerge();
}
