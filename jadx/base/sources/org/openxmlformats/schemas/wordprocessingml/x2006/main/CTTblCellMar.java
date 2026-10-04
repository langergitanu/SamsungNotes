package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTTblCellMar extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTblCellMar.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttblcellmar66eatype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTblCellMar newInstance() {
            return (CTTblCellMar) POIXMLTypeLoader.newInstance(CTTblCellMar.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTblCellMar.type, null);
        }

        public static CTTblCellMar parse(File file) {
            return (CTTblCellMar) POIXMLTypeLoader.parse(file, CTTblCellMar.type, (XmlOptions) null);
        }

        public static CTTblCellMar newInstance(XmlOptions xmlOptions) {
            return (CTTblCellMar) POIXMLTypeLoader.newInstance(CTTblCellMar.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTblCellMar.type, xmlOptions);
        }

        public static CTTblCellMar parse(File file, XmlOptions xmlOptions) {
            return (CTTblCellMar) POIXMLTypeLoader.parse(file, CTTblCellMar.type, xmlOptions);
        }

        public static CTTblCellMar parse(InputStream inputStream) {
            return (CTTblCellMar) POIXMLTypeLoader.parse(inputStream, CTTblCellMar.type, (XmlOptions) null);
        }

        public static CTTblCellMar parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTblCellMar) POIXMLTypeLoader.parse(inputStream, CTTblCellMar.type, xmlOptions);
        }

        public static CTTblCellMar parse(Reader reader) {
            return (CTTblCellMar) POIXMLTypeLoader.parse(reader, CTTblCellMar.type, (XmlOptions) null);
        }

        public static CTTblCellMar parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTblCellMar) POIXMLTypeLoader.parse(reader, CTTblCellMar.type, xmlOptions);
        }

        public static CTTblCellMar parse(String str) {
            return (CTTblCellMar) POIXMLTypeLoader.parse(str, CTTblCellMar.type, (XmlOptions) null);
        }

        public static CTTblCellMar parse(String str, XmlOptions xmlOptions) {
            return (CTTblCellMar) POIXMLTypeLoader.parse(str, CTTblCellMar.type, xmlOptions);
        }

        public static CTTblCellMar parse(URL url) {
            return (CTTblCellMar) POIXMLTypeLoader.parse(url, CTTblCellMar.type, (XmlOptions) null);
        }

        public static CTTblCellMar parse(URL url, XmlOptions xmlOptions) {
            return (CTTblCellMar) POIXMLTypeLoader.parse(url, CTTblCellMar.type, xmlOptions);
        }

        public static CTTblCellMar parse(XMLStreamReader xMLStreamReader) {
            return (CTTblCellMar) POIXMLTypeLoader.parse(xMLStreamReader, CTTblCellMar.type, (XmlOptions) null);
        }

        public static CTTblCellMar parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTblCellMar) POIXMLTypeLoader.parse(xMLStreamReader, CTTblCellMar.type, xmlOptions);
        }

        public static CTTblCellMar parse(XMLInputStream xMLInputStream) {
            return (CTTblCellMar) POIXMLTypeLoader.parse(xMLInputStream, CTTblCellMar.type, (XmlOptions) null);
        }

        public static CTTblCellMar parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTblCellMar) POIXMLTypeLoader.parse(xMLInputStream, CTTblCellMar.type, xmlOptions);
        }

        public static CTTblCellMar parse(Node node) {
            return (CTTblCellMar) POIXMLTypeLoader.parse(node, CTTblCellMar.type, (XmlOptions) null);
        }

        public static CTTblCellMar parse(Node node, XmlOptions xmlOptions) {
            return (CTTblCellMar) POIXMLTypeLoader.parse(node, CTTblCellMar.type, xmlOptions);
        }
    }

    CTTblWidth addNewBottom();

    CTTblWidth addNewLeft();

    CTTblWidth addNewRight();

    CTTblWidth addNewTop();

    CTTblWidth getBottom();

    CTTblWidth getLeft();

    CTTblWidth getRight();

    CTTblWidth getTop();

    boolean isSetBottom();

    boolean isSetLeft();

    boolean isSetRight();

    boolean isSetTop();

    void setBottom(CTTblWidth cTTblWidth);

    void setLeft(CTTblWidth cTTblWidth);

    void setRight(CTTblWidth cTTblWidth);

    void setTop(CTTblWidth cTTblWidth);

    void unsetBottom();

    void unsetLeft();

    void unsetRight();

    void unsetTop();
}
