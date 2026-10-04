package org.openxmlformats.schemas.drawingml.x2006.main;

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
public interface CTTableGrid extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTableGrid.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttablegrid69a5type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTableGrid newInstance() {
            return (CTTableGrid) POIXMLTypeLoader.newInstance(CTTableGrid.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTableGrid.type, null);
        }

        public static CTTableGrid parse(File file) {
            return (CTTableGrid) POIXMLTypeLoader.parse(file, CTTableGrid.type, (XmlOptions) null);
        }

        public static CTTableGrid newInstance(XmlOptions xmlOptions) {
            return (CTTableGrid) POIXMLTypeLoader.newInstance(CTTableGrid.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTableGrid.type, xmlOptions);
        }

        public static CTTableGrid parse(File file, XmlOptions xmlOptions) {
            return (CTTableGrid) POIXMLTypeLoader.parse(file, CTTableGrid.type, xmlOptions);
        }

        public static CTTableGrid parse(InputStream inputStream) {
            return (CTTableGrid) POIXMLTypeLoader.parse(inputStream, CTTableGrid.type, (XmlOptions) null);
        }

        public static CTTableGrid parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTableGrid) POIXMLTypeLoader.parse(inputStream, CTTableGrid.type, xmlOptions);
        }

        public static CTTableGrid parse(Reader reader) {
            return (CTTableGrid) POIXMLTypeLoader.parse(reader, CTTableGrid.type, (XmlOptions) null);
        }

        public static CTTableGrid parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTableGrid) POIXMLTypeLoader.parse(reader, CTTableGrid.type, xmlOptions);
        }

        public static CTTableGrid parse(String str) {
            return (CTTableGrid) POIXMLTypeLoader.parse(str, CTTableGrid.type, (XmlOptions) null);
        }

        public static CTTableGrid parse(String str, XmlOptions xmlOptions) {
            return (CTTableGrid) POIXMLTypeLoader.parse(str, CTTableGrid.type, xmlOptions);
        }

        public static CTTableGrid parse(URL url) {
            return (CTTableGrid) POIXMLTypeLoader.parse(url, CTTableGrid.type, (XmlOptions) null);
        }

        public static CTTableGrid parse(URL url, XmlOptions xmlOptions) {
            return (CTTableGrid) POIXMLTypeLoader.parse(url, CTTableGrid.type, xmlOptions);
        }

        public static CTTableGrid parse(XMLStreamReader xMLStreamReader) {
            return (CTTableGrid) POIXMLTypeLoader.parse(xMLStreamReader, CTTableGrid.type, (XmlOptions) null);
        }

        public static CTTableGrid parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTableGrid) POIXMLTypeLoader.parse(xMLStreamReader, CTTableGrid.type, xmlOptions);
        }

        public static CTTableGrid parse(XMLInputStream xMLInputStream) {
            return (CTTableGrid) POIXMLTypeLoader.parse(xMLInputStream, CTTableGrid.type, (XmlOptions) null);
        }

        public static CTTableGrid parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTableGrid) POIXMLTypeLoader.parse(xMLInputStream, CTTableGrid.type, xmlOptions);
        }

        public static CTTableGrid parse(Node node) {
            return (CTTableGrid) POIXMLTypeLoader.parse(node, CTTableGrid.type, (XmlOptions) null);
        }

        public static CTTableGrid parse(Node node, XmlOptions xmlOptions) {
            return (CTTableGrid) POIXMLTypeLoader.parse(node, CTTableGrid.type, xmlOptions);
        }
    }

    CTTableCol addNewGridCol();

    CTTableCol getGridColArray(int i);

    CTTableCol[] getGridColArray();

    List<CTTableCol> getGridColList();

    CTTableCol insertNewGridCol(int i);

    void removeGridCol(int i);

    void setGridColArray(int i, CTTableCol cTTableCol);

    void setGridColArray(CTTableCol[] cTTableColArr);

    int sizeOfGridColArray();
}
