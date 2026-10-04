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
public interface CTTrPrBase extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTTrPrBase.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "cttrprbase5d77type");

    public static final class Factory {
        private Factory() {
        }

        public static CTTrPrBase newInstance() {
            return (CTTrPrBase) POIXMLTypeLoader.newInstance(CTTrPrBase.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTrPrBase.type, null);
        }

        public static CTTrPrBase parse(File file) {
            return (CTTrPrBase) POIXMLTypeLoader.parse(file, CTTrPrBase.type, (XmlOptions) null);
        }

        public static CTTrPrBase newInstance(XmlOptions xmlOptions) {
            return (CTTrPrBase) POIXMLTypeLoader.newInstance(CTTrPrBase.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTTrPrBase.type, xmlOptions);
        }

        public static CTTrPrBase parse(File file, XmlOptions xmlOptions) {
            return (CTTrPrBase) POIXMLTypeLoader.parse(file, CTTrPrBase.type, xmlOptions);
        }

        public static CTTrPrBase parse(InputStream inputStream) {
            return (CTTrPrBase) POIXMLTypeLoader.parse(inputStream, CTTrPrBase.type, (XmlOptions) null);
        }

        public static CTTrPrBase parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTTrPrBase) POIXMLTypeLoader.parse(inputStream, CTTrPrBase.type, xmlOptions);
        }

        public static CTTrPrBase parse(Reader reader) {
            return (CTTrPrBase) POIXMLTypeLoader.parse(reader, CTTrPrBase.type, (XmlOptions) null);
        }

        public static CTTrPrBase parse(Reader reader, XmlOptions xmlOptions) {
            return (CTTrPrBase) POIXMLTypeLoader.parse(reader, CTTrPrBase.type, xmlOptions);
        }

        public static CTTrPrBase parse(String str) {
            return (CTTrPrBase) POIXMLTypeLoader.parse(str, CTTrPrBase.type, (XmlOptions) null);
        }

        public static CTTrPrBase parse(String str, XmlOptions xmlOptions) {
            return (CTTrPrBase) POIXMLTypeLoader.parse(str, CTTrPrBase.type, xmlOptions);
        }

        public static CTTrPrBase parse(URL url) {
            return (CTTrPrBase) POIXMLTypeLoader.parse(url, CTTrPrBase.type, (XmlOptions) null);
        }

        public static CTTrPrBase parse(URL url, XmlOptions xmlOptions) {
            return (CTTrPrBase) POIXMLTypeLoader.parse(url, CTTrPrBase.type, xmlOptions);
        }

        public static CTTrPrBase parse(XMLStreamReader xMLStreamReader) {
            return (CTTrPrBase) POIXMLTypeLoader.parse(xMLStreamReader, CTTrPrBase.type, (XmlOptions) null);
        }

        public static CTTrPrBase parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTTrPrBase) POIXMLTypeLoader.parse(xMLStreamReader, CTTrPrBase.type, xmlOptions);
        }

        public static CTTrPrBase parse(XMLInputStream xMLInputStream) {
            return (CTTrPrBase) POIXMLTypeLoader.parse(xMLInputStream, CTTrPrBase.type, (XmlOptions) null);
        }

        public static CTTrPrBase parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTTrPrBase) POIXMLTypeLoader.parse(xMLInputStream, CTTrPrBase.type, xmlOptions);
        }

        public static CTTrPrBase parse(Node node) {
            return (CTTrPrBase) POIXMLTypeLoader.parse(node, CTTrPrBase.type, (XmlOptions) null);
        }

        public static CTTrPrBase parse(Node node, XmlOptions xmlOptions) {
            return (CTTrPrBase) POIXMLTypeLoader.parse(node, CTTrPrBase.type, xmlOptions);
        }
    }

    CTOnOff addNewCantSplit();

    CTCnf addNewCnfStyle();

    CTDecimalNumber addNewDivId();

    CTDecimalNumber addNewGridAfter();

    CTDecimalNumber addNewGridBefore();

    CTOnOff addNewHidden();

    CTJc addNewJc();

    CTTblWidth addNewTblCellSpacing();

    CTOnOff addNewTblHeader();

    CTHeight addNewTrHeight();

    CTTblWidth addNewWAfter();

    CTTblWidth addNewWBefore();

    CTOnOff getCantSplitArray(int i);

    CTOnOff[] getCantSplitArray();

    List<CTOnOff> getCantSplitList();

    CTCnf getCnfStyleArray(int i);

    CTCnf[] getCnfStyleArray();

    List<CTCnf> getCnfStyleList();

    CTDecimalNumber getDivIdArray(int i);

    CTDecimalNumber[] getDivIdArray();

    List<CTDecimalNumber> getDivIdList();

    CTDecimalNumber getGridAfterArray(int i);

    CTDecimalNumber[] getGridAfterArray();

    List<CTDecimalNumber> getGridAfterList();

    CTDecimalNumber getGridBeforeArray(int i);

    CTDecimalNumber[] getGridBeforeArray();

    List<CTDecimalNumber> getGridBeforeList();

    CTOnOff getHiddenArray(int i);

    CTOnOff[] getHiddenArray();

    List<CTOnOff> getHiddenList();

    CTJc getJcArray(int i);

    CTJc[] getJcArray();

    List<CTJc> getJcList();

    CTTblWidth getTblCellSpacingArray(int i);

    CTTblWidth[] getTblCellSpacingArray();

    List<CTTblWidth> getTblCellSpacingList();

    CTOnOff getTblHeaderArray(int i);

    CTOnOff[] getTblHeaderArray();

    List<CTOnOff> getTblHeaderList();

    CTHeight getTrHeightArray(int i);

    CTHeight[] getTrHeightArray();

    List<CTHeight> getTrHeightList();

    CTTblWidth getWAfterArray(int i);

    CTTblWidth[] getWAfterArray();

    List<CTTblWidth> getWAfterList();

    CTTblWidth getWBeforeArray(int i);

    CTTblWidth[] getWBeforeArray();

    List<CTTblWidth> getWBeforeList();

    CTOnOff insertNewCantSplit(int i);

    CTCnf insertNewCnfStyle(int i);

    CTDecimalNumber insertNewDivId(int i);

    CTDecimalNumber insertNewGridAfter(int i);

    CTDecimalNumber insertNewGridBefore(int i);

    CTOnOff insertNewHidden(int i);

    CTJc insertNewJc(int i);

    CTTblWidth insertNewTblCellSpacing(int i);

    CTOnOff insertNewTblHeader(int i);

    CTHeight insertNewTrHeight(int i);

    CTTblWidth insertNewWAfter(int i);

    CTTblWidth insertNewWBefore(int i);

    void removeCantSplit(int i);

    void removeCnfStyle(int i);

    void removeDivId(int i);

    void removeGridAfter(int i);

    void removeGridBefore(int i);

    void removeHidden(int i);

    void removeJc(int i);

    void removeTblCellSpacing(int i);

    void removeTblHeader(int i);

    void removeTrHeight(int i);

    void removeWAfter(int i);

    void removeWBefore(int i);

    void setCantSplitArray(int i, CTOnOff cTOnOff);

    void setCantSplitArray(CTOnOff[] cTOnOffArr);

    void setCnfStyleArray(int i, CTCnf cTCnf);

    void setCnfStyleArray(CTCnf[] cTCnfArr);

    void setDivIdArray(int i, CTDecimalNumber cTDecimalNumber);

    void setDivIdArray(CTDecimalNumber[] cTDecimalNumberArr);

    void setGridAfterArray(int i, CTDecimalNumber cTDecimalNumber);

    void setGridAfterArray(CTDecimalNumber[] cTDecimalNumberArr);

    void setGridBeforeArray(int i, CTDecimalNumber cTDecimalNumber);

    void setGridBeforeArray(CTDecimalNumber[] cTDecimalNumberArr);

    void setHiddenArray(int i, CTOnOff cTOnOff);

    void setHiddenArray(CTOnOff[] cTOnOffArr);

    void setJcArray(int i, CTJc cTJc);

    void setJcArray(CTJc[] cTJcArr);

    void setTblCellSpacingArray(int i, CTTblWidth cTTblWidth);

    void setTblCellSpacingArray(CTTblWidth[] cTTblWidthArr);

    void setTblHeaderArray(int i, CTOnOff cTOnOff);

    void setTblHeaderArray(CTOnOff[] cTOnOffArr);

    void setTrHeightArray(int i, CTHeight cTHeight);

    void setTrHeightArray(CTHeight[] cTHeightArr);

    void setWAfterArray(int i, CTTblWidth cTTblWidth);

    void setWAfterArray(CTTblWidth[] cTTblWidthArr);

    void setWBeforeArray(int i, CTTblWidth cTTblWidth);

    void setWBeforeArray(CTTblWidth[] cTTblWidthArr);

    int sizeOfCantSplitArray();

    int sizeOfCnfStyleArray();

    int sizeOfDivIdArray();

    int sizeOfGridAfterArray();

    int sizeOfGridBeforeArray();

    int sizeOfHiddenArray();

    int sizeOfJcArray();

    int sizeOfTblCellSpacingArray();

    int sizeOfTblHeaderArray();

    int sizeOfTrHeightArray();

    int sizeOfWAfterArray();

    int sizeOfWBeforeArray();
}
