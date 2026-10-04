package org.apache.poi.xslf.usermodel;

import org.apache.poi.p226sl.usermodel.AutoShape;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetGeometry2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBody;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextBodyProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextCharacterProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTextParagraph;
import org.openxmlformats.schemas.drawingml.x2006.main.STShapeType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextAlignType;
import org.openxmlformats.schemas.drawingml.x2006.main.STTextAnchoringType;
import org.openxmlformats.schemas.presentationml.x2006.main.CTShape;
import org.openxmlformats.schemas.presentationml.x2006.main.CTShapeNonVisual;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XSLFAutoShape extends XSLFTextShape implements AutoShape<XSLFShape, XSLFTextParagraph> {
    public XSLFAutoShape(CTShape cTShape, XSLFSheet xSLFSheet) {
        super(cTShape, xSLFSheet);
    }

    public static XSLFAutoShape create(CTShape cTShape, XSLFSheet xSLFSheet) {
        return cTShape.getSpPr().isSetCustGeom() ? new XSLFFreeformShape(cTShape, xSLFSheet) : cTShape.getNvSpPr().getCNvSpPr().isSetTxBox() ? new XSLFTextBox(cTShape, xSLFSheet) : new XSLFAutoShape(cTShape, xSLFSheet);
    }

    public static void initTextBody(CTTextBody cTTextBody) {
        CTTextBodyProperties cTTextBodyPropertiesAddNewBodyPr = cTTextBody.addNewBodyPr();
        cTTextBodyPropertiesAddNewBodyPr.setAnchor(STTextAnchoringType.f10213T);
        cTTextBodyPropertiesAddNewBodyPr.setRtlCol(false);
        CTTextParagraph cTTextParagraphAddNewP = cTTextBody.addNewP();
        cTTextParagraphAddNewP.addNewPPr().setAlgn(STTextAlignType.f10210L);
        CTTextCharacterProperties cTTextCharacterPropertiesAddNewEndParaRPr = cTTextParagraphAddNewP.addNewEndParaRPr();
        cTTextCharacterPropertiesAddNewEndParaRPr.setLang("en-US");
        cTTextCharacterPropertiesAddNewEndParaRPr.setSz(1100);
        cTTextParagraphAddNewP.addNewR().setT("");
        cTTextBody.addNewLstStyle();
    }

    public static CTShape prototype(int i) {
        CTShape cTShapeNewInstance = CTShape.Factory.newInstance();
        CTShapeNonVisual cTShapeNonVisualAddNewNvSpPr = cTShapeNewInstance.addNewNvSpPr();
        CTNonVisualDrawingProps cTNonVisualDrawingPropsAddNewCNvPr = cTShapeNonVisualAddNewNvSpPr.addNewCNvPr();
        cTNonVisualDrawingPropsAddNewCNvPr.setName("AutoShape " + i);
        cTNonVisualDrawingPropsAddNewCNvPr.setId((long) (i + 1));
        cTShapeNonVisualAddNewNvSpPr.addNewCNvSpPr();
        cTShapeNonVisualAddNewNvSpPr.addNewNvPr();
        CTPresetGeometry2D cTPresetGeometry2DAddNewPrstGeom = cTShapeNewInstance.addNewSpPr().addNewPrstGeom();
        cTPresetGeometry2DAddNewPrstGeom.setPrst(STShapeType.RECT);
        cTPresetGeometry2DAddNewPrstGeom.addNewAvLst();
        return cTShapeNewInstance;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFTextShape
    public CTTextBody getTextBody(boolean z) {
        CTShape cTShape = (CTShape) getXmlObject();
        CTTextBody txBody = cTShape.getTxBody();
        if (txBody != null || !z) {
            return txBody;
        }
        CTTextBody cTTextBodyAddNewTxBody = cTShape.addNewTxBody();
        initTextBody(cTTextBodyAddNewTxBody);
        return cTTextBodyAddNewTxBody;
    }

    public String toString() {
        return "[" + getClass().getSimpleName() + "] " + getShapeName();
    }
}
