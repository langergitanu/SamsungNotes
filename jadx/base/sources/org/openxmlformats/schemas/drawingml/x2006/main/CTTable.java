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
public interface CTTable extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTable.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttable5f3ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTable newInstance() {
            return (CTTable) POIXMLTypeLoader.newInstance(CTTable.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTable.type, null);
        }

        public static CTTable parse(File file) {
            return (CTTable) POIXMLTypeLoader.parse(file, CTTable.type, (XmlOptions) null);
        }

        public static CTTable newInstance(XmlOptions xmlOptions) {
            return (CTTable) POIXMLTypeLoader.newInstance(CTTable.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTable.type, xmlOptions);
        }

        public static CTTable parse(File file, XmlOptions xmlOptions) {
            return (CTTable) POIXMLTypeLoader.parse(file, CTTable.type, xmlOptions);
        }

        public static CTTable parse(InputStream inputStream) {
            return (CTTable) POIXMLTypeLoader.parse(inputStream, CTTable.type, (XmlOptions) null);
        }

        public static CTTable parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTable) POIXMLTypeLoader.parse(inputStream, CTTable.type, xmlOptions);
        }

        public static CTTable parse(Reader reader) {
            return (CTTable) POIXMLTypeLoader.parse(reader, CTTable.type, (XmlOptions) null);
        }

        public static CTTable parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTable) POIXMLTypeLoader.parse(reader, CTTable.type, xmlOptions);
        }

        public static CTTable parse(String str) {
            return (CTTable) POIXMLTypeLoader.parse(str, CTTable.type, (XmlOptions) null);
        }

        public static CTTable parse(String str, XmlOptions xmlOptions) {
            return (CTTable) POIXMLTypeLoader.parse(str, CTTable.type, xmlOptions);
        }

        public static CTTable parse(URL url) {
            return (CTTable) POIXMLTypeLoader.parse(url, CTTable.type, (XmlOptions) null);
        }

        public static CTTable parse(URL url, XmlOptions xmlOptions) {
            return (CTTable) POIXMLTypeLoader.parse(url, CTTable.type, xmlOptions);
        }

        public static CTTable parse(XMLStreamReader xMLStreamReader) {
            return (CTTable) POIXMLTypeLoader.parse(xMLStreamReader, CTTable.type, (XmlOptions) null);
        }

        public static CTTable parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTable) POIXMLTypeLoader.parse(xMLStreamReader, CTTable.type, xmlOptions);
        }

        public static CTTable parse(XMLInputStream xMLInputStream) {
            return (CTTable) POIXMLTypeLoader.parse(xMLInputStream, CTTable.type, (XmlOptions) null);
        }

        public static CTTable parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTable) POIXMLTypeLoader.parse(xMLInputStream, CTTable.type, xmlOptions);
        }

        public static CTTable parse(Node node) {
            return (CTTable) POIXMLTypeLoader.parse(node, CTTable.type, (XmlOptions) null);
        }

        public static CTTable parse(Node node, XmlOptions xmlOptions) {
            return (CTTable) POIXMLTypeLoader.parse(node, CTTable.type, xmlOptions);
        }
    }

    CTTableGrid addNewTblGrid();

    CTTableProperties addNewTblPr();

    CTTableRow addNewTr();

    CTTableGrid getTblGrid();

    CTTableProperties getTblPr();

    CTTableRow getTrArray(int i);

    CTTableRow[] getTrArray();

    List<CTTableRow> getTrList();

    CTTableRow insertNewTr(int i);

    boolean isSetTblPr();

    void removeTr(int i);

    void setTblGrid(CTTableGrid cTTableGrid);

    void setTblPr(CTTableProperties cTTableProperties);

    void setTrArray(int i, CTTableRow cTTableRow);

    void setTrArray(CTTableRow[] cTTableRowArr);

    int sizeOfTrArray();

    void unsetTblPr();
}
