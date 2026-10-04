package org.apache.poi.xslf.usermodel;

import org.apache.poi.POIXMLException;
import org.apache.poi.p226sl.usermodel.ConnectorShape;
import org.apache.poi.p226sl.usermodel.Placeholder;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetGeometry2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.STShapeType;
import org.openxmlformats.schemas.presentationml.x2006.main.CTConnector;
import org.openxmlformats.schemas.presentationml.x2006.main.CTConnectorNonVisual;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XSLFConnectorShape extends XSLFSimpleShape implements ConnectorShape<XSLFShape, XSLFTextParagraph> {
    public XSLFConnectorShape(CTConnector cTConnector, XSLFSheet xSLFSheet) {
        super(cTConnector, xSLFSheet);
    }

    public static CTConnector prototype(int i) {
        CTConnector cTConnectorNewInstance = CTConnector.Factory.newInstance();
        CTConnectorNonVisual cTConnectorNonVisualAddNewNvCxnSpPr = cTConnectorNewInstance.addNewNvCxnSpPr();
        CTNonVisualDrawingProps cTNonVisualDrawingPropsAddNewCNvPr = cTConnectorNonVisualAddNewNvCxnSpPr.addNewCNvPr();
        cTNonVisualDrawingPropsAddNewCNvPr.setName("Connector " + i);
        cTNonVisualDrawingPropsAddNewCNvPr.setId((long) (i + 1));
        cTConnectorNonVisualAddNewNvCxnSpPr.addNewCNvCxnSpPr();
        cTConnectorNonVisualAddNewNvCxnSpPr.addNewNvPr();
        CTShapeProperties cTShapePropertiesAddNewSpPr = cTConnectorNewInstance.addNewSpPr();
        CTPresetGeometry2D cTPresetGeometry2DAddNewPrstGeom = cTShapePropertiesAddNewSpPr.addNewPrstGeom();
        cTPresetGeometry2DAddNewPrstGeom.setPrst(STShapeType.LINE);
        cTPresetGeometry2DAddNewPrstGeom.addNewAvLst();
        cTShapePropertiesAddNewSpPr.addNewLn();
        return cTConnectorNewInstance;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSimpleShape, org.apache.poi.p226sl.usermodel.SimpleShape
    public XSLFShadow getShadow() {
        return null;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.poi.POIXMLException */
    @Override // org.apache.poi.xslf.usermodel.XSLFSimpleShape, org.apache.poi.xslf.usermodel.XSLFShape, org.apache.poi.p226sl.usermodel.SimpleShape
    public void setPlaceholder(Placeholder placeholder) throws POIXMLException {
        throw new POIXMLException("A connector shape can't be a placeholder.");
    }
}
