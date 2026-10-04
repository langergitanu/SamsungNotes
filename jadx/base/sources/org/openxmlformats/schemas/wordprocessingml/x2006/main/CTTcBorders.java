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
public interface CTTcBorders extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTcBorders.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttcbordersa5fatype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTcBorders newInstance() {
            return (CTTcBorders) POIXMLTypeLoader.newInstance(CTTcBorders.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTcBorders.type, null);
        }

        public static CTTcBorders parse(File file) {
            return (CTTcBorders) POIXMLTypeLoader.parse(file, CTTcBorders.type, (XmlOptions) null);
        }

        public static CTTcBorders newInstance(XmlOptions xmlOptions) {
            return (CTTcBorders) POIXMLTypeLoader.newInstance(CTTcBorders.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTcBorders.type, xmlOptions);
        }

        public static CTTcBorders parse(File file, XmlOptions xmlOptions) {
            return (CTTcBorders) POIXMLTypeLoader.parse(file, CTTcBorders.type, xmlOptions);
        }

        public static CTTcBorders parse(InputStream inputStream) {
            return (CTTcBorders) POIXMLTypeLoader.parse(inputStream, CTTcBorders.type, (XmlOptions) null);
        }

        public static CTTcBorders parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTcBorders) POIXMLTypeLoader.parse(inputStream, CTTcBorders.type, xmlOptions);
        }

        public static CTTcBorders parse(Reader reader) {
            return (CTTcBorders) POIXMLTypeLoader.parse(reader, CTTcBorders.type, (XmlOptions) null);
        }

        public static CTTcBorders parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTcBorders) POIXMLTypeLoader.parse(reader, CTTcBorders.type, xmlOptions);
        }

        public static CTTcBorders parse(String str) {
            return (CTTcBorders) POIXMLTypeLoader.parse(str, CTTcBorders.type, (XmlOptions) null);
        }

        public static CTTcBorders parse(String str, XmlOptions xmlOptions) {
            return (CTTcBorders) POIXMLTypeLoader.parse(str, CTTcBorders.type, xmlOptions);
        }

        public static CTTcBorders parse(URL url) {
            return (CTTcBorders) POIXMLTypeLoader.parse(url, CTTcBorders.type, (XmlOptions) null);
        }

        public static CTTcBorders parse(URL url, XmlOptions xmlOptions) {
            return (CTTcBorders) POIXMLTypeLoader.parse(url, CTTcBorders.type, xmlOptions);
        }

        public static CTTcBorders parse(XMLStreamReader xMLStreamReader) {
            return (CTTcBorders) POIXMLTypeLoader.parse(xMLStreamReader, CTTcBorders.type, (XmlOptions) null);
        }

        public static CTTcBorders parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTcBorders) POIXMLTypeLoader.parse(xMLStreamReader, CTTcBorders.type, xmlOptions);
        }

        public static CTTcBorders parse(XMLInputStream xMLInputStream) {
            return (CTTcBorders) POIXMLTypeLoader.parse(xMLInputStream, CTTcBorders.type, (XmlOptions) null);
        }

        public static CTTcBorders parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTcBorders) POIXMLTypeLoader.parse(xMLInputStream, CTTcBorders.type, xmlOptions);
        }

        public static CTTcBorders parse(Node node) {
            return (CTTcBorders) POIXMLTypeLoader.parse(node, CTTcBorders.type, (XmlOptions) null);
        }

        public static CTTcBorders parse(Node node, XmlOptions xmlOptions) {
            return (CTTcBorders) POIXMLTypeLoader.parse(node, CTTcBorders.type, xmlOptions);
        }
    }

    CTBorder addNewBottom();

    CTBorder addNewInsideH();

    CTBorder addNewInsideV();

    CTBorder addNewLeft();

    CTBorder addNewRight();

    CTBorder addNewTl2Br();

    CTBorder addNewTop();

    CTBorder addNewTr2Bl();

    CTBorder getBottom();

    CTBorder getInsideH();

    CTBorder getInsideV();

    CTBorder getLeft();

    CTBorder getRight();

    CTBorder getTl2Br();

    CTBorder getTop();

    CTBorder getTr2Bl();

    boolean isSetBottom();

    boolean isSetInsideH();

    boolean isSetInsideV();

    boolean isSetLeft();

    boolean isSetRight();

    boolean isSetTl2Br();

    boolean isSetTop();

    boolean isSetTr2Bl();

    void setBottom(CTBorder cTBorder);

    void setInsideH(CTBorder cTBorder);

    void setInsideV(CTBorder cTBorder);

    void setLeft(CTBorder cTBorder);

    void setRight(CTBorder cTBorder);

    void setTl2Br(CTBorder cTBorder);

    void setTop(CTBorder cTBorder);

    void setTr2Bl(CTBorder cTBorder);

    void unsetBottom();

    void unsetInsideH();

    void unsetInsideV();

    void unsetLeft();

    void unsetRight();

    void unsetTl2Br();

    void unsetTop();

    void unsetTr2Bl();
}
