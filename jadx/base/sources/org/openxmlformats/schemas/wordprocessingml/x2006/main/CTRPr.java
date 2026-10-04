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
public interface CTRPr extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTRPr.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctrpr097etype");

    public static final class Factory {
        private Factory() {
        }

        public static CTRPr newInstance() {
            return (CTRPr) POIXMLTypeLoader.newInstance(CTRPr.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTRPr.type, null);
        }

        public static CTRPr parse(File file) {
            return (CTRPr) POIXMLTypeLoader.parse(file, CTRPr.type, (XmlOptions) null);
        }

        public static CTRPr newInstance(XmlOptions xmlOptions) {
            return (CTRPr) POIXMLTypeLoader.newInstance(CTRPr.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTRPr.type, xmlOptions);
        }

        public static CTRPr parse(File file, XmlOptions xmlOptions) {
            return (CTRPr) POIXMLTypeLoader.parse(file, CTRPr.type, xmlOptions);
        }

        public static CTRPr parse(InputStream inputStream) {
            return (CTRPr) POIXMLTypeLoader.parse(inputStream, CTRPr.type, (XmlOptions) null);
        }

        public static CTRPr parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTRPr) POIXMLTypeLoader.parse(inputStream, CTRPr.type, xmlOptions);
        }

        public static CTRPr parse(Reader reader) {
            return (CTRPr) POIXMLTypeLoader.parse(reader, CTRPr.type, (XmlOptions) null);
        }

        public static CTRPr parse(Reader reader, XmlOptions xmlOptions) {
            return (CTRPr) POIXMLTypeLoader.parse(reader, CTRPr.type, xmlOptions);
        }

        public static CTRPr parse(String str) {
            return (CTRPr) POIXMLTypeLoader.parse(str, CTRPr.type, (XmlOptions) null);
        }

        public static CTRPr parse(String str, XmlOptions xmlOptions) {
            return (CTRPr) POIXMLTypeLoader.parse(str, CTRPr.type, xmlOptions);
        }

        public static CTRPr parse(URL url) {
            return (CTRPr) POIXMLTypeLoader.parse(url, CTRPr.type, (XmlOptions) null);
        }

        public static CTRPr parse(URL url, XmlOptions xmlOptions) {
            return (CTRPr) POIXMLTypeLoader.parse(url, CTRPr.type, xmlOptions);
        }

        public static CTRPr parse(XMLStreamReader xMLStreamReader) {
            return (CTRPr) POIXMLTypeLoader.parse(xMLStreamReader, CTRPr.type, (XmlOptions) null);
        }

        public static CTRPr parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTRPr) POIXMLTypeLoader.parse(xMLStreamReader, CTRPr.type, xmlOptions);
        }

        public static CTRPr parse(XMLInputStream xMLInputStream) {
            return (CTRPr) POIXMLTypeLoader.parse(xMLInputStream, CTRPr.type, (XmlOptions) null);
        }

        public static CTRPr parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTRPr) POIXMLTypeLoader.parse(xMLInputStream, CTRPr.type, xmlOptions);
        }

        public static CTRPr parse(Node node) {
            return (CTRPr) POIXMLTypeLoader.parse(node, CTRPr.type, (XmlOptions) null);
        }

        public static CTRPr parse(Node node, XmlOptions xmlOptions) {
            return (CTRPr) POIXMLTypeLoader.parse(node, CTRPr.type, xmlOptions);
        }
    }

    CTOnOff addNewB();

    CTOnOff addNewBCs();

    CTBorder addNewBdr();

    CTOnOff addNewCaps();

    CTColor addNewColor();

    CTOnOff addNewCs();

    CTOnOff addNewDstrike();

    CTEastAsianLayout addNewEastAsianLayout();

    CTTextEffect addNewEffect();

    CTEm addNewEm();

    CTOnOff addNewEmboss();

    CTFitText addNewFitText();

    CTHighlight addNewHighlight();

    CTOnOff addNewI();

    CTOnOff addNewICs();

    CTOnOff addNewImprint();

    CTHpsMeasure addNewKern();

    CTLanguage addNewLang();

    CTOnOff addNewNoProof();

    CTOnOff addNewOMath();

    CTOnOff addNewOutline();

    CTSignedHpsMeasure addNewPosition();

    CTFonts addNewRFonts();

    CTRPrChange addNewRPrChange();

    CTString addNewRStyle();

    CTOnOff addNewRtl();

    CTOnOff addNewShadow();

    CTShd addNewShd();

    CTOnOff addNewSmallCaps();

    CTOnOff addNewSnapToGrid();

    CTSignedTwipsMeasure addNewSpacing();

    CTOnOff addNewSpecVanish();

    CTOnOff addNewStrike();

    CTHpsMeasure addNewSz();

    CTHpsMeasure addNewSzCs();

    CTUnderline addNewU();

    CTOnOff addNewVanish();

    CTVerticalAlignRun addNewVertAlign();

    CTTextScale addNewW();

    CTOnOff addNewWebHidden();

    CTOnOff getB();

    CTOnOff getBCs();

    CTBorder getBdr();

    CTOnOff getCaps();

    CTColor getColor();

    CTOnOff getCs();

    CTOnOff getDstrike();

    CTEastAsianLayout getEastAsianLayout();

    CTTextEffect getEffect();

    CTEm getEm();

    CTOnOff getEmboss();

    CTFitText getFitText();

    CTHighlight getHighlight();

    CTOnOff getI();

    CTOnOff getICs();

    CTOnOff getImprint();

    CTHpsMeasure getKern();

    CTLanguage getLang();

    CTOnOff getNoProof();

    CTOnOff getOMath();

    CTOnOff getOutline();

    CTSignedHpsMeasure getPosition();

    CTFonts getRFonts();

    CTRPrChange getRPrChange();

    CTString getRStyle();

    CTOnOff getRtl();

    CTOnOff getShadow();

    CTShd getShd();

    CTOnOff getSmallCaps();

    CTOnOff getSnapToGrid();

    CTSignedTwipsMeasure getSpacing();

    CTOnOff getSpecVanish();

    CTOnOff getStrike();

    CTHpsMeasure getSz();

    CTHpsMeasure getSzCs();

    CTUnderline getU();

    CTOnOff getVanish();

    CTVerticalAlignRun getVertAlign();

    CTTextScale getW();

    CTOnOff getWebHidden();

    boolean isSetB();

    boolean isSetBCs();

    boolean isSetBdr();

    boolean isSetCaps();

    boolean isSetColor();

    boolean isSetCs();

    boolean isSetDstrike();

    boolean isSetEastAsianLayout();

    boolean isSetEffect();

    boolean isSetEm();

    boolean isSetEmboss();

    boolean isSetFitText();

    boolean isSetHighlight();

    boolean isSetI();

    boolean isSetICs();

    boolean isSetImprint();

    boolean isSetKern();

    boolean isSetLang();

    boolean isSetNoProof();

    boolean isSetOMath();

    boolean isSetOutline();

    boolean isSetPosition();

    boolean isSetRFonts();

    boolean isSetRPrChange();

    boolean isSetRStyle();

    boolean isSetRtl();

    boolean isSetShadow();

    boolean isSetShd();

    boolean isSetSmallCaps();

    boolean isSetSnapToGrid();

    boolean isSetSpacing();

    boolean isSetSpecVanish();

    boolean isSetStrike();

    boolean isSetSz();

    boolean isSetSzCs();

    boolean isSetU();

    boolean isSetVanish();

    boolean isSetVertAlign();

    boolean isSetW();

    boolean isSetWebHidden();

    void setB(CTOnOff cTOnOff);

    void setBCs(CTOnOff cTOnOff);

    void setBdr(CTBorder cTBorder);

    void setCaps(CTOnOff cTOnOff);

    void setColor(CTColor cTColor);

    void setCs(CTOnOff cTOnOff);

    void setDstrike(CTOnOff cTOnOff);

    void setEastAsianLayout(CTEastAsianLayout cTEastAsianLayout);

    void setEffect(CTTextEffect cTTextEffect);

    void setEm(CTEm cTEm);

    void setEmboss(CTOnOff cTOnOff);

    void setFitText(CTFitText cTFitText);

    void setHighlight(CTHighlight cTHighlight);

    void setI(CTOnOff cTOnOff);

    void setICs(CTOnOff cTOnOff);

    void setImprint(CTOnOff cTOnOff);

    void setKern(CTHpsMeasure cTHpsMeasure);

    void setLang(CTLanguage cTLanguage);

    void setNoProof(CTOnOff cTOnOff);

    void setOMath(CTOnOff cTOnOff);

    void setOutline(CTOnOff cTOnOff);

    void setPosition(CTSignedHpsMeasure cTSignedHpsMeasure);

    void setRFonts(CTFonts cTFonts);

    void setRPrChange(CTRPrChange cTRPrChange);

    void setRStyle(CTString cTString);

    void setRtl(CTOnOff cTOnOff);

    void setShadow(CTOnOff cTOnOff);

    void setShd(CTShd cTShd);

    void setSmallCaps(CTOnOff cTOnOff);

    void setSnapToGrid(CTOnOff cTOnOff);

    void setSpacing(CTSignedTwipsMeasure cTSignedTwipsMeasure);

    void setSpecVanish(CTOnOff cTOnOff);

    void setStrike(CTOnOff cTOnOff);

    void setSz(CTHpsMeasure cTHpsMeasure);

    void setSzCs(CTHpsMeasure cTHpsMeasure);

    void setU(CTUnderline cTUnderline);

    void setVanish(CTOnOff cTOnOff);

    void setVertAlign(CTVerticalAlignRun cTVerticalAlignRun);

    void setW(CTTextScale cTTextScale);

    void setWebHidden(CTOnOff cTOnOff);

    void unsetB();

    void unsetBCs();

    void unsetBdr();

    void unsetCaps();

    void unsetColor();

    void unsetCs();

    void unsetDstrike();

    void unsetEastAsianLayout();

    void unsetEffect();

    void unsetEm();

    void unsetEmboss();

    void unsetFitText();

    void unsetHighlight();

    void unsetI();

    void unsetICs();

    void unsetImprint();

    void unsetKern();

    void unsetLang();

    void unsetNoProof();

    void unsetOMath();

    void unsetOutline();

    void unsetPosition();

    void unsetRFonts();

    void unsetRPrChange();

    void unsetRStyle();

    void unsetRtl();

    void unsetShadow();

    void unsetShd();

    void unsetSmallCaps();

    void unsetSnapToGrid();

    void unsetSpacing();

    void unsetSpecVanish();

    void unsetStrike();

    void unsetSz();

    void unsetSzCs();

    void unsetU();

    void unsetVanish();

    void unsetVertAlign();

    void unsetW();

    void unsetWebHidden();
}
