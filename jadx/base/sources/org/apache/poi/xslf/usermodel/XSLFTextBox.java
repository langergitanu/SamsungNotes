package org.apache.poi.xslf.usermodel;

import org.apache.poi.p226sl.usermodel.TextBox;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetGeometry2D;
import org.openxmlformats.schemas.drawingml.x2006.main.STShapeType;
import org.openxmlformats.schemas.presentationml.x2006.main.CTShape;
import org.openxmlformats.schemas.presentationml.x2006.main.CTShapeNonVisual;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XSLFTextBox extends XSLFAutoShape implements TextBox<XSLFShape, XSLFTextParagraph> {
    public XSLFTextBox(CTShape cTShape, XSLFSheet xSLFSheet) {
        super(cTShape, xSLFSheet);
    }

    public static CTShape prototype(int i) {
        CTShape cTShapeNewInstance = CTShape.Factory.newInstance();
        CTShapeNonVisual cTShapeNonVisualAddNewNvSpPr = cTShapeNewInstance.addNewNvSpPr();
        CTNonVisualDrawingProps cTNonVisualDrawingPropsAddNewCNvPr = cTShapeNonVisualAddNewNvSpPr.addNewCNvPr();
        cTNonVisualDrawingPropsAddNewCNvPr.setName("TextBox " + i);
        cTNonVisualDrawingPropsAddNewCNvPr.setId((long) (i + 1));
        cTShapeNonVisualAddNewNvSpPr.addNewCNvSpPr().setTxBox(true);
        cTShapeNonVisualAddNewNvSpPr.addNewNvPr();
        CTPresetGeometry2D cTPresetGeometry2DAddNewPrstGeom = cTShapeNewInstance.addNewSpPr().addNewPrstGeom();
        cTPresetGeometry2DAddNewPrstGeom.setPrst(STShapeType.RECT);
        cTPresetGeometry2DAddNewPrstGeom.addNewAvLst();
        XSLFAutoShape.initTextBody(cTShapeNewInstance.addNewTxBody());
        return cTShapeNewInstance;
    }
}
