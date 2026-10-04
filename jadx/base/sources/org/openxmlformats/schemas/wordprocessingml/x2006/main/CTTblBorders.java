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
public interface CTTblBorders extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTblBorders.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttblborders459ftype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTblBorders newInstance() {
            return (CTTblBorders) POIXMLTypeLoader.newInstance(CTTblBorders.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTblBorders.type, null);
        }

        public static CTTblBorders parse(File file) {
            return (CTTblBorders) POIXMLTypeLoader.parse(file, CTTblBorders.type, (XmlOptions) null);
        }

        public static CTTblBorders newInstance(XmlOptions xmlOptions) {
            return (CTTblBorders) POIXMLTypeLoader.newInstance(CTTblBorders.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTblBorders.type, xmlOptions);
        }

        public static CTTblBorders parse(File file, XmlOptions xmlOptions) {
            return (CTTblBorders) POIXMLTypeLoader.parse(file, CTTblBorders.type, xmlOptions);
        }

        public static CTTblBorders parse(InputStream inputStream) {
            return (CTTblBorders) POIXMLTypeLoader.parse(inputStream, CTTblBorders.type, (XmlOptions) null);
        }

        public static CTTblBorders parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTblBorders) POIXMLTypeLoader.parse(inputStream, CTTblBorders.type, xmlOptions);
        }

        public static CTTblBorders parse(Reader reader) {
            return (CTTblBorders) POIXMLTypeLoader.parse(reader, CTTblBorders.type, (XmlOptions) null);
        }

        public static CTTblBorders parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTblBorders) POIXMLTypeLoader.parse(reader, CTTblBorders.type, xmlOptions);
        }

        public static CTTblBorders parse(String str) {
            return (CTTblBorders) POIXMLTypeLoader.parse(str, CTTblBorders.type, (XmlOptions) null);
        }

        public static CTTblBorders parse(String str, XmlOptions xmlOptions) {
            return (CTTblBorders) POIXMLTypeLoader.parse(str, CTTblBorders.type, xmlOptions);
        }

        public static CTTblBorders parse(URL url) {
            return (CTTblBorders) POIXMLTypeLoader.parse(url, CTTblBorders.type, (XmlOptions) null);
        }

        public static CTTblBorders parse(URL url, XmlOptions xmlOptions) {
            return (CTTblBorders) POIXMLTypeLoader.parse(url, CTTblBorders.type, xmlOptions);
        }

        public static CTTblBorders parse(XMLStreamReader xMLStreamReader) {
            return (CTTblBorders) POIXMLTypeLoader.parse(xMLStreamReader, CTTblBorders.type, (XmlOptions) null);
        }

        public static CTTblBorders parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTblBorders) POIXMLTypeLoader.parse(xMLStreamReader, CTTblBorders.type, xmlOptions);
        }

        public static CTTblBorders parse(XMLInputStream xMLInputStream) {
            return (CTTblBorders) POIXMLTypeLoader.parse(xMLInputStream, CTTblBorders.type, (XmlOptions) null);
        }

        public static CTTblBorders parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTblBorders) POIXMLTypeLoader.parse(xMLInputStream, CTTblBorders.type, xmlOptions);
        }

        public static CTTblBorders parse(Node node) {
            return (CTTblBorders) POIXMLTypeLoader.parse(node, CTTblBorders.type, (XmlOptions) null);
        }

        public static CTTblBorders parse(Node node, XmlOptions xmlOptions) {
            return (CTTblBorders) POIXMLTypeLoader.parse(node, CTTblBorders.type, xmlOptions);
        }
    }

    CTBorder addNewBottom();

    CTBorder addNewInsideH();

    CTBorder addNewInsideV();

    CTBorder addNewLeft();

    CTBorder addNewRight();

    CTBorder addNewTop();

    CTBorder getBottom();

    CTBorder getInsideH();

    CTBorder getInsideV();

    CTBorder getLeft();

    CTBorder getRight();

    CTBorder getTop();

    boolean isSetBottom();

    boolean isSetInsideH();

    boolean isSetInsideV();

    boolean isSetLeft();

    boolean isSetRight();

    boolean isSetTop();

    void setBottom(CTBorder cTBorder);

    void setInsideH(CTBorder cTBorder);

    void setInsideV(CTBorder cTBorder);

    void setLeft(CTBorder cTBorder);

    void setRight(CTBorder cTBorder);

    void setTop(CTBorder cTBorder);

    void unsetBottom();

    void unsetInsideH();

    void unsetInsideV();

    void unsetLeft();

    void unsetRight();

    void unsetTop();
}
