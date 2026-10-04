package org.openxmlformats.schemas.drawingml.x2006.main;

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
import org.openxmlformats.schemas.drawingml.x2006.main.STCompoundLine;
import org.openxmlformats.schemas.drawingml.x2006.main.STLineCap;
import org.openxmlformats.schemas.drawingml.x2006.main.STPenAlignment;
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTLineProperties extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTLineProperties.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctlinepropertiesd5e2type");

    public static final class Factory {
        private Factory() {
        }

        public static CTLineProperties newInstance() {
            return (CTLineProperties) POIXMLTypeLoader.newInstance(CTLineProperties.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTLineProperties.type, null);
        }

        public static CTLineProperties parse(File file) {
            return (CTLineProperties) POIXMLTypeLoader.parse(file, CTLineProperties.type, (XmlOptions) null);
        }

        public static CTLineProperties newInstance(XmlOptions xmlOptions) {
            return (CTLineProperties) POIXMLTypeLoader.newInstance(CTLineProperties.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTLineProperties.type, xmlOptions);
        }

        public static CTLineProperties parse(File file, XmlOptions xmlOptions) {
            return (CTLineProperties) POIXMLTypeLoader.parse(file, CTLineProperties.type, xmlOptions);
        }

        public static CTLineProperties parse(InputStream inputStream) {
            return (CTLineProperties) POIXMLTypeLoader.parse(inputStream, CTLineProperties.type, (XmlOptions) null);
        }

        public static CTLineProperties parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTLineProperties) POIXMLTypeLoader.parse(inputStream, CTLineProperties.type, xmlOptions);
        }

        public static CTLineProperties parse(Reader reader) {
            return (CTLineProperties) POIXMLTypeLoader.parse(reader, CTLineProperties.type, (XmlOptions) null);
        }

        public static CTLineProperties parse(Reader reader, XmlOptions xmlOptions) {
            return (CTLineProperties) POIXMLTypeLoader.parse(reader, CTLineProperties.type, xmlOptions);
        }

        public static CTLineProperties parse(String str) {
            return (CTLineProperties) POIXMLTypeLoader.parse(str, CTLineProperties.type, (XmlOptions) null);
        }

        public static CTLineProperties parse(String str, XmlOptions xmlOptions) {
            return (CTLineProperties) POIXMLTypeLoader.parse(str, CTLineProperties.type, xmlOptions);
        }

        public static CTLineProperties parse(URL url) {
            return (CTLineProperties) POIXMLTypeLoader.parse(url, CTLineProperties.type, (XmlOptions) null);
        }

        public static CTLineProperties parse(URL url, XmlOptions xmlOptions) {
            return (CTLineProperties) POIXMLTypeLoader.parse(url, CTLineProperties.type, xmlOptions);
        }

        public static CTLineProperties parse(XMLStreamReader xMLStreamReader) {
            return (CTLineProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTLineProperties.type, (XmlOptions) null);
        }

        public static CTLineProperties parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTLineProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTLineProperties.type, xmlOptions);
        }

        public static CTLineProperties parse(XMLInputStream xMLInputStream) {
            return (CTLineProperties) POIXMLTypeLoader.parse(xMLInputStream, CTLineProperties.type, (XmlOptions) null);
        }

        public static CTLineProperties parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTLineProperties) POIXMLTypeLoader.parse(xMLInputStream, CTLineProperties.type, xmlOptions);
        }

        public static CTLineProperties parse(Node node) {
            return (CTLineProperties) POIXMLTypeLoader.parse(node, CTLineProperties.type, (XmlOptions) null);
        }

        public static CTLineProperties parse(Node node, XmlOptions xmlOptions) {
            return (CTLineProperties) POIXMLTypeLoader.parse(node, CTLineProperties.type, xmlOptions);
        }
    }

    CTLineJoinBevel addNewBevel();

    CTDashStopList addNewCustDash();

    CTOfficeArtExtensionList addNewExtLst();

    CTGradientFillProperties addNewGradFill();

    CTLineEndProperties addNewHeadEnd();

    CTLineJoinMiterProperties addNewMiter();

    CTNoFillProperties addNewNoFill();

    CTPatternFillProperties addNewPattFill();

    CTPresetLineDashProperties addNewPrstDash();

    CTLineJoinRound addNewRound();

    CTSolidColorFillProperties addNewSolidFill();

    CTLineEndProperties addNewTailEnd();

    STPenAlignment.Enum getAlgn();

    CTLineJoinBevel getBevel();

    STLineCap.Enum getCap();

    STCompoundLine.Enum getCmpd();

    CTDashStopList getCustDash();

    CTOfficeArtExtensionList getExtLst();

    CTGradientFillProperties getGradFill();

    CTLineEndProperties getHeadEnd();

    CTLineJoinMiterProperties getMiter();

    CTNoFillProperties getNoFill();

    CTPatternFillProperties getPattFill();

    CTPresetLineDashProperties getPrstDash();

    CTLineJoinRound getRound();

    CTSolidColorFillProperties getSolidFill();

    CTLineEndProperties getTailEnd();

    int getW();

    boolean isSetAlgn();

    boolean isSetBevel();

    boolean isSetCap();

    boolean isSetCmpd();

    boolean isSetCustDash();

    boolean isSetExtLst();

    boolean isSetGradFill();

    boolean isSetHeadEnd();

    boolean isSetMiter();

    boolean isSetNoFill();

    boolean isSetPattFill();

    boolean isSetPrstDash();

    boolean isSetRound();

    boolean isSetSolidFill();

    boolean isSetTailEnd();

    boolean isSetW();

    void setAlgn(STPenAlignment.Enum r12);

    void setBevel(CTLineJoinBevel cTLineJoinBevel);

    void setCap(STLineCap.Enum r12);

    void setCmpd(STCompoundLine.Enum r12);

    void setCustDash(CTDashStopList cTDashStopList);

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setGradFill(CTGradientFillProperties cTGradientFillProperties);

    void setHeadEnd(CTLineEndProperties cTLineEndProperties);

    void setMiter(CTLineJoinMiterProperties cTLineJoinMiterProperties);

    void setNoFill(CTNoFillProperties cTNoFillProperties);

    void setPattFill(CTPatternFillProperties cTPatternFillProperties);

    void setPrstDash(CTPresetLineDashProperties cTPresetLineDashProperties);

    void setRound(CTLineJoinRound cTLineJoinRound);

    void setSolidFill(CTSolidColorFillProperties cTSolidColorFillProperties);

    void setTailEnd(CTLineEndProperties cTLineEndProperties);

    void setW(int i);

    void unsetAlgn();

    void unsetBevel();

    void unsetCap();

    void unsetCmpd();

    void unsetCustDash();

    void unsetExtLst();

    void unsetGradFill();

    void unsetHeadEnd();

    void unsetMiter();

    void unsetNoFill();

    void unsetPattFill();

    void unsetPrstDash();

    void unsetRound();

    void unsetSolidFill();

    void unsetTailEnd();

    void unsetW();

    STPenAlignment xgetAlgn();

    STLineCap xgetCap();

    STCompoundLine xgetCmpd();

    STLineWidth xgetW();

    void xsetAlgn(STPenAlignment sTPenAlignment);

    void xsetCap(STLineCap sTLineCap);

    void xsetCmpd(STCompoundLine sTCompoundLine);

    void xsetW(STLineWidth sTLineWidth);
}
