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
public interface CTTblPrBase extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTblPrBase.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttblprbaseeba1type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTblPrBase newInstance() {
            return (CTTblPrBase) POIXMLTypeLoader.newInstance(CTTblPrBase.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTblPrBase.type, null);
        }

        public static CTTblPrBase parse(File file) {
            return (CTTblPrBase) POIXMLTypeLoader.parse(file, CTTblPrBase.type, (XmlOptions) null);
        }

        public static CTTblPrBase newInstance(XmlOptions xmlOptions) {
            return (CTTblPrBase) POIXMLTypeLoader.newInstance(CTTblPrBase.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTblPrBase.type, xmlOptions);
        }

        public static CTTblPrBase parse(File file, XmlOptions xmlOptions) {
            return (CTTblPrBase) POIXMLTypeLoader.parse(file, CTTblPrBase.type, xmlOptions);
        }

        public static CTTblPrBase parse(InputStream inputStream) {
            return (CTTblPrBase) POIXMLTypeLoader.parse(inputStream, CTTblPrBase.type, (XmlOptions) null);
        }

        public static CTTblPrBase parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTblPrBase) POIXMLTypeLoader.parse(inputStream, CTTblPrBase.type, xmlOptions);
        }

        public static CTTblPrBase parse(Reader reader) {
            return (CTTblPrBase) POIXMLTypeLoader.parse(reader, CTTblPrBase.type, (XmlOptions) null);
        }

        public static CTTblPrBase parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTblPrBase) POIXMLTypeLoader.parse(reader, CTTblPrBase.type, xmlOptions);
        }

        public static CTTblPrBase parse(String str) {
            return (CTTblPrBase) POIXMLTypeLoader.parse(str, CTTblPrBase.type, (XmlOptions) null);
        }

        public static CTTblPrBase parse(String str, XmlOptions xmlOptions) {
            return (CTTblPrBase) POIXMLTypeLoader.parse(str, CTTblPrBase.type, xmlOptions);
        }

        public static CTTblPrBase parse(URL url) {
            return (CTTblPrBase) POIXMLTypeLoader.parse(url, CTTblPrBase.type, (XmlOptions) null);
        }

        public static CTTblPrBase parse(URL url, XmlOptions xmlOptions) {
            return (CTTblPrBase) POIXMLTypeLoader.parse(url, CTTblPrBase.type, xmlOptions);
        }

        public static CTTblPrBase parse(XMLStreamReader xMLStreamReader) {
            return (CTTblPrBase) POIXMLTypeLoader.parse(xMLStreamReader, CTTblPrBase.type, (XmlOptions) null);
        }

        public static CTTblPrBase parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTblPrBase) POIXMLTypeLoader.parse(xMLStreamReader, CTTblPrBase.type, xmlOptions);
        }

        public static CTTblPrBase parse(XMLInputStream xMLInputStream) {
            return (CTTblPrBase) POIXMLTypeLoader.parse(xMLInputStream, CTTblPrBase.type, (XmlOptions) null);
        }

        public static CTTblPrBase parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTblPrBase) POIXMLTypeLoader.parse(xMLInputStream, CTTblPrBase.type, xmlOptions);
        }

        public static CTTblPrBase parse(Node node) {
            return (CTTblPrBase) POIXMLTypeLoader.parse(node, CTTblPrBase.type, (XmlOptions) null);
        }

        public static CTTblPrBase parse(Node node, XmlOptions xmlOptions) {
            return (CTTblPrBase) POIXMLTypeLoader.parse(node, CTTblPrBase.type, xmlOptions);
        }
    }

    CTOnOff addNewBidiVisual();

    CTJc addNewJc();

    CTShd addNewShd();

    CTTblBorders addNewTblBorders();

    CTTblCellMar addNewTblCellMar();

    CTTblWidth addNewTblCellSpacing();

    CTTblWidth addNewTblInd();

    CTTblLayoutType addNewTblLayout();

    CTShortHexNumber addNewTblLook();

    CTTblOverlap addNewTblOverlap();

    CTString addNewTblStyle();

    CTDecimalNumber addNewTblStyleColBandSize();

    CTDecimalNumber addNewTblStyleRowBandSize();

    CTTblWidth addNewTblW();

    CTTblPPr addNewTblpPr();

    CTOnOff getBidiVisual();

    CTJc getJc();

    CTShd getShd();

    CTTblBorders getTblBorders();

    CTTblCellMar getTblCellMar();

    CTTblWidth getTblCellSpacing();

    CTTblWidth getTblInd();

    CTTblLayoutType getTblLayout();

    CTShortHexNumber getTblLook();

    CTTblOverlap getTblOverlap();

    CTString getTblStyle();

    CTDecimalNumber getTblStyleColBandSize();

    CTDecimalNumber getTblStyleRowBandSize();

    CTTblWidth getTblW();

    CTTblPPr getTblpPr();

    boolean isSetBidiVisual();

    boolean isSetJc();

    boolean isSetShd();

    boolean isSetTblBorders();

    boolean isSetTblCellMar();

    boolean isSetTblCellSpacing();

    boolean isSetTblInd();

    boolean isSetTblLayout();

    boolean isSetTblLook();

    boolean isSetTblOverlap();

    boolean isSetTblStyle();

    boolean isSetTblStyleColBandSize();

    boolean isSetTblStyleRowBandSize();

    boolean isSetTblW();

    boolean isSetTblpPr();

    void setBidiVisual(CTOnOff cTOnOff);

    void setJc(CTJc cTJc);

    void setShd(CTShd cTShd);

    void setTblBorders(CTTblBorders cTTblBorders);

    void setTblCellMar(CTTblCellMar cTTblCellMar);

    void setTblCellSpacing(CTTblWidth cTTblWidth);

    void setTblInd(CTTblWidth cTTblWidth);

    void setTblLayout(CTTblLayoutType cTTblLayoutType);

    void setTblLook(CTShortHexNumber cTShortHexNumber);

    void setTblOverlap(CTTblOverlap cTTblOverlap);

    void setTblStyle(CTString cTString);

    void setTblStyleColBandSize(CTDecimalNumber cTDecimalNumber);

    void setTblStyleRowBandSize(CTDecimalNumber cTDecimalNumber);

    void setTblW(CTTblWidth cTTblWidth);

    void setTblpPr(CTTblPPr cTTblPPr);

    void unsetBidiVisual();

    void unsetJc();

    void unsetShd();

    void unsetTblBorders();

    void unsetTblCellMar();

    void unsetTblCellSpacing();

    void unsetTblInd();

    void unsetTblLayout();

    void unsetTblLook();

    void unsetTblOverlap();

    void unsetTblStyle();

    void unsetTblStyleColBandSize();

    void unsetTblStyleRowBandSize();

    void unsetTblW();

    void unsetTblpPr();
}
