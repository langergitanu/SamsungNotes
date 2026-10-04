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
public interface CTTblPrExBase extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTblPrExBase.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttblprexbasee7eetype");

    public static final class Factory {
        private Factory() {
        }

        public static CTTblPrExBase newInstance() {
            return (CTTblPrExBase) POIXMLTypeLoader.newInstance(CTTblPrExBase.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTblPrExBase.type, null);
        }

        public static CTTblPrExBase parse(File file) {
            return (CTTblPrExBase) POIXMLTypeLoader.parse(file, CTTblPrExBase.type, (XmlOptions) null);
        }

        public static CTTblPrExBase newInstance(XmlOptions xmlOptions) {
            return (CTTblPrExBase) POIXMLTypeLoader.newInstance(CTTblPrExBase.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTblPrExBase.type, xmlOptions);
        }

        public static CTTblPrExBase parse(File file, XmlOptions xmlOptions) {
            return (CTTblPrExBase) POIXMLTypeLoader.parse(file, CTTblPrExBase.type, xmlOptions);
        }

        public static CTTblPrExBase parse(InputStream inputStream) {
            return (CTTblPrExBase) POIXMLTypeLoader.parse(inputStream, CTTblPrExBase.type, (XmlOptions) null);
        }

        public static CTTblPrExBase parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTblPrExBase) POIXMLTypeLoader.parse(inputStream, CTTblPrExBase.type, xmlOptions);
        }

        public static CTTblPrExBase parse(Reader reader) {
            return (CTTblPrExBase) POIXMLTypeLoader.parse(reader, CTTblPrExBase.type, (XmlOptions) null);
        }

        public static CTTblPrExBase parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTblPrExBase) POIXMLTypeLoader.parse(reader, CTTblPrExBase.type, xmlOptions);
        }

        public static CTTblPrExBase parse(String str) {
            return (CTTblPrExBase) POIXMLTypeLoader.parse(str, CTTblPrExBase.type, (XmlOptions) null);
        }

        public static CTTblPrExBase parse(String str, XmlOptions xmlOptions) {
            return (CTTblPrExBase) POIXMLTypeLoader.parse(str, CTTblPrExBase.type, xmlOptions);
        }

        public static CTTblPrExBase parse(URL url) {
            return (CTTblPrExBase) POIXMLTypeLoader.parse(url, CTTblPrExBase.type, (XmlOptions) null);
        }

        public static CTTblPrExBase parse(URL url, XmlOptions xmlOptions) {
            return (CTTblPrExBase) POIXMLTypeLoader.parse(url, CTTblPrExBase.type, xmlOptions);
        }

        public static CTTblPrExBase parse(XMLStreamReader xMLStreamReader) {
            return (CTTblPrExBase) POIXMLTypeLoader.parse(xMLStreamReader, CTTblPrExBase.type, (XmlOptions) null);
        }

        public static CTTblPrExBase parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTblPrExBase) POIXMLTypeLoader.parse(xMLStreamReader, CTTblPrExBase.type, xmlOptions);
        }

        public static CTTblPrExBase parse(XMLInputStream xMLInputStream) {
            return (CTTblPrExBase) POIXMLTypeLoader.parse(xMLInputStream, CTTblPrExBase.type, (XmlOptions) null);
        }

        public static CTTblPrExBase parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTblPrExBase) POIXMLTypeLoader.parse(xMLInputStream, CTTblPrExBase.type, xmlOptions);
        }

        public static CTTblPrExBase parse(Node node) {
            return (CTTblPrExBase) POIXMLTypeLoader.parse(node, CTTblPrExBase.type, (XmlOptions) null);
        }

        public static CTTblPrExBase parse(Node node, XmlOptions xmlOptions) {
            return (CTTblPrExBase) POIXMLTypeLoader.parse(node, CTTblPrExBase.type, xmlOptions);
        }
    }

    CTJc addNewJc();

    CTShd addNewShd();

    CTTblBorders addNewTblBorders();

    CTTblCellMar addNewTblCellMar();

    CTTblWidth addNewTblCellSpacing();

    CTTblWidth addNewTblInd();

    CTTblLayoutType addNewTblLayout();

    CTShortHexNumber addNewTblLook();

    CTTblWidth addNewTblW();

    CTJc getJc();

    CTShd getShd();

    CTTblBorders getTblBorders();

    CTTblCellMar getTblCellMar();

    CTTblWidth getTblCellSpacing();

    CTTblWidth getTblInd();

    CTTblLayoutType getTblLayout();

    CTShortHexNumber getTblLook();

    CTTblWidth getTblW();

    boolean isSetJc();

    boolean isSetShd();

    boolean isSetTblBorders();

    boolean isSetTblCellMar();

    boolean isSetTblCellSpacing();

    boolean isSetTblInd();

    boolean isSetTblLayout();

    boolean isSetTblLook();

    boolean isSetTblW();

    void setJc(CTJc cTJc);

    void setShd(CTShd cTShd);

    void setTblBorders(CTTblBorders cTTblBorders);

    void setTblCellMar(CTTblCellMar cTTblCellMar);

    void setTblCellSpacing(CTTblWidth cTTblWidth);

    void setTblInd(CTTblWidth cTTblWidth);

    void setTblLayout(CTTblLayoutType cTTblLayoutType);

    void setTblLook(CTShortHexNumber cTShortHexNumber);

    void setTblW(CTTblWidth cTTblWidth);

    void unsetJc();

    void unsetShd();

    void unsetTblBorders();

    void unsetTblCellMar();

    void unsetTblCellSpacing();

    void unsetTblInd();

    void unsetTblLayout();

    void unsetTblLook();

    void unsetTblW();
}
