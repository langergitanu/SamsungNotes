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
public interface CTTableRow extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTableRow.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttablerow4ac7type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTableRow newInstance() {
            return (CTTableRow) POIXMLTypeLoader.newInstance(CTTableRow.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTableRow.type, null);
        }

        public static CTTableRow parse(File file) {
            return (CTTableRow) POIXMLTypeLoader.parse(file, CTTableRow.type, (XmlOptions) null);
        }

        public static CTTableRow newInstance(XmlOptions xmlOptions) {
            return (CTTableRow) POIXMLTypeLoader.newInstance(CTTableRow.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTableRow.type, xmlOptions);
        }

        public static CTTableRow parse(File file, XmlOptions xmlOptions) {
            return (CTTableRow) POIXMLTypeLoader.parse(file, CTTableRow.type, xmlOptions);
        }

        public static CTTableRow parse(InputStream inputStream) {
            return (CTTableRow) POIXMLTypeLoader.parse(inputStream, CTTableRow.type, (XmlOptions) null);
        }

        public static CTTableRow parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTableRow) POIXMLTypeLoader.parse(inputStream, CTTableRow.type, xmlOptions);
        }

        public static CTTableRow parse(Reader reader) {
            return (CTTableRow) POIXMLTypeLoader.parse(reader, CTTableRow.type, (XmlOptions) null);
        }

        public static CTTableRow parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTableRow) POIXMLTypeLoader.parse(reader, CTTableRow.type, xmlOptions);
        }

        public static CTTableRow parse(String str) {
            return (CTTableRow) POIXMLTypeLoader.parse(str, CTTableRow.type, (XmlOptions) null);
        }

        public static CTTableRow parse(String str, XmlOptions xmlOptions) {
            return (CTTableRow) POIXMLTypeLoader.parse(str, CTTableRow.type, xmlOptions);
        }

        public static CTTableRow parse(URL url) {
            return (CTTableRow) POIXMLTypeLoader.parse(url, CTTableRow.type, (XmlOptions) null);
        }

        public static CTTableRow parse(URL url, XmlOptions xmlOptions) {
            return (CTTableRow) POIXMLTypeLoader.parse(url, CTTableRow.type, xmlOptions);
        }

        public static CTTableRow parse(XMLStreamReader xMLStreamReader) {
            return (CTTableRow) POIXMLTypeLoader.parse(xMLStreamReader, CTTableRow.type, (XmlOptions) null);
        }

        public static CTTableRow parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTableRow) POIXMLTypeLoader.parse(xMLStreamReader, CTTableRow.type, xmlOptions);
        }

        public static CTTableRow parse(XMLInputStream xMLInputStream) {
            return (CTTableRow) POIXMLTypeLoader.parse(xMLInputStream, CTTableRow.type, (XmlOptions) null);
        }

        public static CTTableRow parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTableRow) POIXMLTypeLoader.parse(xMLInputStream, CTTableRow.type, xmlOptions);
        }

        public static CTTableRow parse(Node node) {
            return (CTTableRow) POIXMLTypeLoader.parse(node, CTTableRow.type, (XmlOptions) null);
        }

        public static CTTableRow parse(Node node, XmlOptions xmlOptions) {
            return (CTTableRow) POIXMLTypeLoader.parse(node, CTTableRow.type, xmlOptions);
        }
    }

    CTOfficeArtExtensionList addNewExtLst();

    CTTableCell addNewTc();

    CTOfficeArtExtensionList getExtLst();

    long getH();

    CTTableCell getTcArray(int i);

    CTTableCell[] getTcArray();

    List<CTTableCell> getTcList();

    CTTableCell insertNewTc(int i);

    boolean isSetExtLst();

    void removeTc(int i);

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setH(long j);

    void setTcArray(int i, CTTableCell cTTableCell);

    void setTcArray(CTTableCell[] cTTableCellArr);

    int sizeOfTcArray();

    void unsetExtLst();

    STCoordinate xgetH();

    void xsetH(STCoordinate sTCoordinate);
}
