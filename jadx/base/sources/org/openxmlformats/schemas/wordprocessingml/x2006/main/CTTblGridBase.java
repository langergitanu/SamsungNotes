package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.util.List;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTTblGridBase extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTblGridBase.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttblgridbasea11dtype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTblGridBase newInstance() {
            return (CTTblGridBase) POIXMLTypeLoader.newInstance(CTTblGridBase.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTblGridBase.type, null);
        }

        public static CTTblGridBase parse(File file) {
            return (CTTblGridBase) POIXMLTypeLoader.parse(file, CTTblGridBase.type, (XmlOptions) null);
        }

        public static CTTblGridBase newInstance(XmlOptions xmlOptions) {
            return (CTTblGridBase) POIXMLTypeLoader.newInstance(CTTblGridBase.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTblGridBase.type, xmlOptions);
        }

        public static CTTblGridBase parse(File file, XmlOptions xmlOptions) {
            return (CTTblGridBase) POIXMLTypeLoader.parse(file, CTTblGridBase.type, xmlOptions);
        }

        public static CTTblGridBase parse(InputStream inputStream) {
            return (CTTblGridBase) POIXMLTypeLoader.parse(inputStream, CTTblGridBase.type, (XmlOptions) null);
        }

        public static CTTblGridBase parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTblGridBase) POIXMLTypeLoader.parse(inputStream, CTTblGridBase.type, xmlOptions);
        }

        public static CTTblGridBase parse(Reader reader) {
            return (CTTblGridBase) POIXMLTypeLoader.parse(reader, CTTblGridBase.type, (XmlOptions) null);
        }

        public static CTTblGridBase parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTblGridBase) POIXMLTypeLoader.parse(reader, CTTblGridBase.type, xmlOptions);
        }

        public static CTTblGridBase parse(String str) {
            return (CTTblGridBase) POIXMLTypeLoader.parse(str, CTTblGridBase.type, (XmlOptions) null);
        }

        public static CTTblGridBase parse(String str, XmlOptions xmlOptions) {
            return (CTTblGridBase) POIXMLTypeLoader.parse(str, CTTblGridBase.type, xmlOptions);
        }

        public static CTTblGridBase parse(URL url) {
            return (CTTblGridBase) POIXMLTypeLoader.parse(url, CTTblGridBase.type, (XmlOptions) null);
        }

        public static CTTblGridBase parse(URL url, XmlOptions xmlOptions) {
            return (CTTblGridBase) POIXMLTypeLoader.parse(url, CTTblGridBase.type, xmlOptions);
        }

        public static CTTblGridBase parse(XMLStreamReader xMLStreamReader) {
            return (CTTblGridBase) POIXMLTypeLoader.parse(xMLStreamReader, CTTblGridBase.type, (XmlOptions) null);
        }

        public static CTTblGridBase parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTblGridBase) POIXMLTypeLoader.parse(xMLStreamReader, CTTblGridBase.type, xmlOptions);
        }

        public static CTTblGridBase parse(XMLInputStream xMLInputStream) {
            return (CTTblGridBase) POIXMLTypeLoader.parse(xMLInputStream, CTTblGridBase.type, (XmlOptions) null);
        }

        public static CTTblGridBase parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTblGridBase) POIXMLTypeLoader.parse(xMLInputStream, CTTblGridBase.type, xmlOptions);
        }

        public static CTTblGridBase parse(Node node) {
            return (CTTblGridBase) POIXMLTypeLoader.parse(node, CTTblGridBase.type, (XmlOptions) null);
        }

        public static CTTblGridBase parse(Node node, XmlOptions xmlOptions) {
            return (CTTblGridBase) POIXMLTypeLoader.parse(node, CTTblGridBase.type, xmlOptions);
        }
    }

    CTTblGridCol addNewGridCol();

    CTTblGridCol getGridColArray(int i);

    CTTblGridCol[] getGridColArray();

    List<CTTblGridCol> getGridColList();

    CTTblGridCol insertNewGridCol(int i);

    void removeGridCol(int i);

    void setGridColArray(int i, CTTblGridCol cTTblGridCol);

    void setGridColArray(CTTblGridCol[] cTTblGridColArr);

    int sizeOfGridColArray();
}
