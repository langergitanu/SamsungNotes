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
import org.w3c.dom.Node;

/* JADX INFO: loaded from: classes11.dex */
public interface CTShapeProperties extends XmlObject {
    public static final SchemaType type = (SchemaType) AbstractC4539a.m3202l(CTShapeProperties.class, "schemaorg_apache_xmlbeans.system.sF1327CCA741569E70F9CA8C9AF9B44B2", "ctshapeproperties30e5type");

    public static final class Factory {
        private Factory() {
        }

        public static CTShapeProperties newInstance() {
            return (CTShapeProperties) POIXMLTypeLoader.newInstance(CTShapeProperties.type, null);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTShapeProperties.type, null);
        }

        public static CTShapeProperties parse(File file) {
            return (CTShapeProperties) POIXMLTypeLoader.parse(file, CTShapeProperties.type, (XmlOptions) null);
        }

        public static CTShapeProperties newInstance(XmlOptions xmlOptions) {
            return (CTShapeProperties) POIXMLTypeLoader.newInstance(CTShapeProperties.type, xmlOptions);
        }

        public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return POIXMLTypeLoader.newValidatingXMLInputStream(xMLInputStream, CTShapeProperties.type, xmlOptions);
        }

        public static CTShapeProperties parse(File file, XmlOptions xmlOptions) {
            return (CTShapeProperties) POIXMLTypeLoader.parse(file, CTShapeProperties.type, xmlOptions);
        }

        public static CTShapeProperties parse(InputStream inputStream) {
            return (CTShapeProperties) POIXMLTypeLoader.parse(inputStream, CTShapeProperties.type, (XmlOptions) null);
        }

        public static CTShapeProperties parse(InputStream inputStream, XmlOptions xmlOptions) {
            return (CTShapeProperties) POIXMLTypeLoader.parse(inputStream, CTShapeProperties.type, xmlOptions);
        }

        public static CTShapeProperties parse(Reader reader) {
            return (CTShapeProperties) POIXMLTypeLoader.parse(reader, CTShapeProperties.type, (XmlOptions) null);
        }

        public static CTShapeProperties parse(Reader reader, XmlOptions xmlOptions) {
            return (CTShapeProperties) POIXMLTypeLoader.parse(reader, CTShapeProperties.type, xmlOptions);
        }

        public static CTShapeProperties parse(String str) {
            return (CTShapeProperties) POIXMLTypeLoader.parse(str, CTShapeProperties.type, (XmlOptions) null);
        }

        public static CTShapeProperties parse(String str, XmlOptions xmlOptions) {
            return (CTShapeProperties) POIXMLTypeLoader.parse(str, CTShapeProperties.type, xmlOptions);
        }

        public static CTShapeProperties parse(URL url) {
            return (CTShapeProperties) POIXMLTypeLoader.parse(url, CTShapeProperties.type, (XmlOptions) null);
        }

        public static CTShapeProperties parse(URL url, XmlOptions xmlOptions) {
            return (CTShapeProperties) POIXMLTypeLoader.parse(url, CTShapeProperties.type, xmlOptions);
        }

        public static CTShapeProperties parse(XMLStreamReader xMLStreamReader) {
            return (CTShapeProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTShapeProperties.type, (XmlOptions) null);
        }

        public static CTShapeProperties parse(XMLStreamReader xMLStreamReader, XmlOptions xmlOptions) {
            return (CTShapeProperties) POIXMLTypeLoader.parse(xMLStreamReader, CTShapeProperties.type, xmlOptions);
        }

        public static CTShapeProperties parse(XMLInputStream xMLInputStream) {
            return (CTShapeProperties) POIXMLTypeLoader.parse(xMLInputStream, CTShapeProperties.type, (XmlOptions) null);
        }

        public static CTShapeProperties parse(XMLInputStream xMLInputStream, XmlOptions xmlOptions) {
            return (CTShapeProperties) POIXMLTypeLoader.parse(xMLInputStream, CTShapeProperties.type, xmlOptions);
        }

        public static CTShapeProperties parse(Node node) {
            return (CTShapeProperties) POIXMLTypeLoader.parse(node, CTShapeProperties.type, (XmlOptions) null);
        }

        public static CTShapeProperties parse(Node node, XmlOptions xmlOptions) {
            return (CTShapeProperties) POIXMLTypeLoader.parse(node, CTShapeProperties.type, xmlOptions);
        }
    }

    CTBlipFillProperties addNewBlipFill();

    CTCustomGeometry2D addNewCustGeom();

    CTEffectContainer addNewEffectDag();

    CTEffectList addNewEffectLst();

    CTOfficeArtExtensionList addNewExtLst();

    CTGradientFillProperties addNewGradFill();

    CTGroupFillProperties addNewGrpFill();

    CTLineProperties addNewLn();

    CTNoFillProperties addNewNoFill();

    CTPatternFillProperties addNewPattFill();

    CTPresetGeometry2D addNewPrstGeom();

    CTScene3D addNewScene3D();

    CTSolidColorFillProperties addNewSolidFill();

    CTShape3D addNewSp3D();

    CTTransform2D addNewXfrm();

    CTBlipFillProperties getBlipFill();

    STBlackWhiteMode$Enum getBwMode();

    CTCustomGeometry2D getCustGeom();

    CTEffectContainer getEffectDag();

    CTEffectList getEffectLst();

    CTOfficeArtExtensionList getExtLst();

    CTGradientFillProperties getGradFill();

    CTGroupFillProperties getGrpFill();

    CTLineProperties getLn();

    CTNoFillProperties getNoFill();

    CTPatternFillProperties getPattFill();

    CTPresetGeometry2D getPrstGeom();

    CTScene3D getScene3D();

    CTSolidColorFillProperties getSolidFill();

    CTShape3D getSp3D();

    CTTransform2D getXfrm();

    boolean isSetBlipFill();

    boolean isSetBwMode();

    boolean isSetCustGeom();

    boolean isSetEffectDag();

    boolean isSetEffectLst();

    boolean isSetExtLst();

    boolean isSetGradFill();

    boolean isSetGrpFill();

    boolean isSetLn();

    boolean isSetNoFill();

    boolean isSetPattFill();

    boolean isSetPrstGeom();

    boolean isSetScene3D();

    boolean isSetSolidFill();

    boolean isSetSp3D();

    boolean isSetXfrm();

    void setBlipFill(CTBlipFillProperties cTBlipFillProperties);

    void setBwMode(STBlackWhiteMode$Enum sTBlackWhiteMode$Enum);

    void setCustGeom(CTCustomGeometry2D cTCustomGeometry2D);

    void setEffectDag(CTEffectContainer cTEffectContainer);

    void setEffectLst(CTEffectList cTEffectList);

    void setExtLst(CTOfficeArtExtensionList cTOfficeArtExtensionList);

    void setGradFill(CTGradientFillProperties cTGradientFillProperties);

    void setGrpFill(CTGroupFillProperties cTGroupFillProperties);

    void setLn(CTLineProperties cTLineProperties);

    void setNoFill(CTNoFillProperties cTNoFillProperties);

    void setPattFill(CTPatternFillProperties cTPatternFillProperties);

    void setPrstGeom(CTPresetGeometry2D cTPresetGeometry2D);

    void setScene3D(CTScene3D cTScene3D);

    void setSolidFill(CTSolidColorFillProperties cTSolidColorFillProperties);

    void setSp3D(CTShape3D cTShape3D);

    void setXfrm(CTTransform2D cTTransform2D);

    void unsetBlipFill();

    void unsetBwMode();

    void unsetCustGeom();

    void unsetEffectDag();

    void unsetEffectLst();

    void unsetExtLst();

    void unsetGradFill();

    void unsetGrpFill();

    void unsetLn();

    void unsetNoFill();

    void unsetPattFill();

    void unsetPrstGeom();

    void unsetScene3D();

    void unsetSolidFill();

    void unsetSp3D();

    void unsetXfrm();

    STBlackWhiteMode xgetBwMode();

    void xsetBwMode(STBlackWhiteMode sTBlackWhiteMode);
}
