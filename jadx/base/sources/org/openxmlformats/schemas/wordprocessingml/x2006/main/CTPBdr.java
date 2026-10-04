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
public interface CTPBdr extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTPBdr.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctpbdre388type");

    public static final class Factory {
        private Factory() {
        }

        public static CTPBdr newInstance() {
            return (CTPBdr) POIXMLTypeLoader.newInstance(CTPBdr.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPBdr.type, null);
        }

        public static CTPBdr parse(File file) {
            return (CTPBdr) POIXMLTypeLoader.parse(file, CTPBdr.type, (XmlOptions) null);
        }

        public static CTPBdr newInstance(XmlOptions xmlOptions) {
            return (CTPBdr) POIXMLTypeLoader.newInstance(CTPBdr.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTPBdr.type, xmlOptions);
        }

        public static CTPBdr parse(File file, XmlOptions xmlOptions) {
            return (CTPBdr) POIXMLTypeLoader.parse(file, CTPBdr.type, xmlOptions);
        }

        public static CTPBdr parse(InputStream inputStream) {
            return (CTPBdr) POIXMLTypeLoader.parse(inputStream, CTPBdr.type, (XmlOptions) null);
        }

        public static CTPBdr parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTPBdr) POIXMLTypeLoader.parse(inputStream, CTPBdr.type, xmlOptions);
        }

        public static CTPBdr parse(Reader reader) {
            return (CTPBdr) POIXMLTypeLoader.parse(reader, CTPBdr.type, (XmlOptions) null);
        }

        public static CTPBdr parse(Reader reader, XmlOptions xmlOptions) {
            return (CTPBdr) POIXMLTypeLoader.parse(reader, CTPBdr.type, xmlOptions);
        }

        public static CTPBdr parse(String str) {
            return (CTPBdr) POIXMLTypeLoader.parse(str, CTPBdr.type, (XmlOptions) null);
        }

        public static CTPBdr parse(String str, XmlOptions xmlOptions) {
            return (CTPBdr) POIXMLTypeLoader.parse(str, CTPBdr.type, xmlOptions);
        }

        public static CTPBdr parse(URL url) {
            return (CTPBdr) POIXMLTypeLoader.parse(url, CTPBdr.type, (XmlOptions) null);
        }

        public static CTPBdr parse(URL url, XmlOptions xmlOptions) {
            return (CTPBdr) POIXMLTypeLoader.parse(url, CTPBdr.type, xmlOptions);
        }

        public static CTPBdr parse(XMLStreamReader xMLStreamReader) {
            return (CTPBdr) POIXMLTypeLoader.parse(xMLStreamReader, CTPBdr.type, (XmlOptions) null);
        }

        public static CTPBdr parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTPBdr) POIXMLTypeLoader.parse(xMLStreamReader, CTPBdr.type, xmlOptions);
        }

        public static CTPBdr parse(XMLInputStream xMLInputStream) {
            return (CTPBdr) POIXMLTypeLoader.parse(xMLInputStream, CTPBdr.type, (XmlOptions) null);
        }

        public static CTPBdr parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTPBdr) POIXMLTypeLoader.parse(xMLInputStream, CTPBdr.type, xmlOptions);
        }

        public static CTPBdr parse(Node node) {
            return (CTPBdr) POIXMLTypeLoader.parse(node, CTPBdr.type, (XmlOptions) null);
        }

        public static CTPBdr parse(Node node, XmlOptions xmlOptions) {
            return (CTPBdr) POIXMLTypeLoader.parse(node, CTPBdr.type, xmlOptions);
        }
    }

    CTBorder addNewBar();

    CTBorder addNewBetween();

    CTBorder addNewBottom();

    CTBorder addNewLeft();

    CTBorder addNewRight();

    CTBorder addNewTop();

    CTBorder getBar();

    CTBorder getBetween();

    CTBorder getBottom();

    CTBorder getLeft();

    CTBorder getRight();

    CTBorder getTop();

    boolean isSetBar();

    boolean isSetBetween();

    boolean isSetBottom();

    boolean isSetLeft();

    boolean isSetRight();

    boolean isSetTop();

    void setBar(CTBorder cTBorder);

    void setBetween(CTBorder cTBorder);

    void setBottom(CTBorder cTBorder);

    void setLeft(CTBorder cTBorder);

    void setRight(CTBorder cTBorder);

    void setTop(CTBorder cTBorder);

    void unsetBar();

    void unsetBetween();

    void unsetBottom();

    void unsetLeft();

    void unsetRight();

    void unsetTop();
}
