package org.openxmlformats.schemas.wordprocessingml.x2006.main;

import com.google.android.gms.common.data.AbstractC4539a;
import java.io.File;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigInteger;
import java.net.URL;
import org.apache.poi.POIXMLTypeLoader;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STOnOff;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTLvl extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTLvl.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctlvlf630type");

    public static final class Factory {
        private Factory() {
        }

        public static CTLvl newInstance() {
            return (CTLvl) POIXMLTypeLoader.newInstance(CTLvl.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTLvl.type, null);
        }

        public static CTLvl parse(File file) {
            return (CTLvl) POIXMLTypeLoader.parse(file, CTLvl.type, (XmlOptions) null);
        }

        public static CTLvl newInstance(XmlOptions xmlOptions) {
            return (CTLvl) POIXMLTypeLoader.newInstance(CTLvl.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTLvl.type, xmlOptions);
        }

        public static CTLvl parse(File file, XmlOptions xmlOptions) {
            return (CTLvl) POIXMLTypeLoader.parse(file, CTLvl.type, xmlOptions);
        }

        public static CTLvl parse(InputStream inputStream) {
            return (CTLvl) POIXMLTypeLoader.parse(inputStream, CTLvl.type, (XmlOptions) null);
        }

        public static CTLvl parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTLvl) POIXMLTypeLoader.parse(inputStream, CTLvl.type, xmlOptions);
        }

        public static CTLvl parse(Reader reader) {
            return (CTLvl) POIXMLTypeLoader.parse(reader, CTLvl.type, (XmlOptions) null);
        }

        public static CTLvl parse(Reader reader, XmlOptions xmlOptions) {
            return (CTLvl) POIXMLTypeLoader.parse(reader, CTLvl.type, xmlOptions);
        }

        public static CTLvl parse(String str) {
            return (CTLvl) POIXMLTypeLoader.parse(str, CTLvl.type, (XmlOptions) null);
        }

        public static CTLvl parse(String str, XmlOptions xmlOptions) {
            return (CTLvl) POIXMLTypeLoader.parse(str, CTLvl.type, xmlOptions);
        }

        public static CTLvl parse(URL url) {
            return (CTLvl) POIXMLTypeLoader.parse(url, CTLvl.type, (XmlOptions) null);
        }

        public static CTLvl parse(URL url, XmlOptions xmlOptions) {
            return (CTLvl) POIXMLTypeLoader.parse(url, CTLvl.type, xmlOptions);
        }

        public static CTLvl parse(XMLStreamReader xMLStreamReader) {
            return (CTLvl) POIXMLTypeLoader.parse(xMLStreamReader, CTLvl.type, (XmlOptions) null);
        }

        public static CTLvl parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTLvl) POIXMLTypeLoader.parse(xMLStreamReader, CTLvl.type, xmlOptions);
        }

        public static CTLvl parse(XMLInputStream xMLInputStream) {
            return (CTLvl) POIXMLTypeLoader.parse(xMLInputStream, CTLvl.type, (XmlOptions) null);
        }

        public static CTLvl parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTLvl) POIXMLTypeLoader.parse(xMLInputStream, CTLvl.type, xmlOptions);
        }

        public static CTLvl parse(Node node) {
            return (CTLvl) POIXMLTypeLoader.parse(node, CTLvl.type, (XmlOptions) null);
        }

        public static CTLvl parse(Node node, XmlOptions xmlOptions) {
            return (CTLvl) POIXMLTypeLoader.parse(node, CTLvl.type, xmlOptions);
        }
    }

    CTOnOff addNewIsLgl();

    CTLvlLegacy addNewLegacy();

    CTJc addNewLvlJc();

    CTDecimalNumber addNewLvlPicBulletId();

    CTDecimalNumber addNewLvlRestart();

    CTLevelText addNewLvlText();

    CTNumFmt addNewNumFmt();

    CTPPr addNewPPr();

    CTString addNewPStyle();

    CTRPr addNewRPr();

    CTDecimalNumber addNewStart();

    CTLevelSuffix addNewSuff();

    BigInteger getIlvl();

    CTOnOff getIsLgl();

    CTLvlLegacy getLegacy();

    CTJc getLvlJc();

    CTDecimalNumber getLvlPicBulletId();

    CTDecimalNumber getLvlRestart();

    CTLevelText getLvlText();

    CTNumFmt getNumFmt();

    CTPPr getPPr();

    CTString getPStyle();

    CTRPr getRPr();

    CTDecimalNumber getStart();

    CTLevelSuffix getSuff();

    STOnOff.Enum getTentative();

    byte[] getTplc();

    boolean isSetIsLgl();

    boolean isSetLegacy();

    boolean isSetLvlJc();

    boolean isSetLvlPicBulletId();

    boolean isSetLvlRestart();

    boolean isSetLvlText();

    boolean isSetNumFmt();

    boolean isSetPPr();

    boolean isSetPStyle();

    boolean isSetRPr();

    boolean isSetStart();

    boolean isSetSuff();

    boolean isSetTentative();

    boolean isSetTplc();

    void setIlvl(BigInteger bigInteger);

    void setIsLgl(CTOnOff cTOnOff);

    void setLegacy(CTLvlLegacy cTLvlLegacy);

    void setLvlJc(CTJc cTJc);

    void setLvlPicBulletId(CTDecimalNumber cTDecimalNumber);

    void setLvlRestart(CTDecimalNumber cTDecimalNumber);

    void setLvlText(CTLevelText cTLevelText);

    void setNumFmt(CTNumFmt cTNumFmt);

    void setPPr(CTPPr cTPPr);

    void setPStyle(CTString cTString);

    void setRPr(CTRPr cTRPr);

    void setStart(CTDecimalNumber cTDecimalNumber);

    void setSuff(CTLevelSuffix cTLevelSuffix);

    void setTentative(STOnOff.Enum r12);

    void setTplc(byte[] bArr);

    void unsetIsLgl();

    void unsetLegacy();

    void unsetLvlJc();

    void unsetLvlPicBulletId();

    void unsetLvlRestart();

    void unsetLvlText();

    void unsetNumFmt();

    void unsetPPr();

    void unsetPStyle();

    void unsetRPr();

    void unsetStart();

    void unsetSuff();

    void unsetTentative();

    void unsetTplc();

    STDecimalNumber xgetIlvl();

    STOnOff xgetTentative();

    STLongHexNumber xgetTplc();

    void xsetIlvl(STDecimalNumber sTDecimalNumber);

    void xsetTentative(STOnOff sTOnOff);

    void xsetTplc(STLongHexNumber sTLongHexNumber);
}
