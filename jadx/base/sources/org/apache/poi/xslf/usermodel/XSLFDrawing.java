package org.apache.poi.xslf.usermodel;

import org.apache.poi.java.awt.Color;
import org.apache.poi.java.awt.geom.Rectangle2D;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.presentationml.x2006.main.CTConnector;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPicture;
import org.openxmlformats.schemas.presentationml.x2006.main.CTShape;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XSLFDrawing {
    private int _shapeId;
    private XSLFSheet _sheet;
    private CTGroupShape _spTree;

    public XSLFDrawing(XSLFSheet xSLFSheet, CTGroupShape cTGroupShape) {
        this._shapeId = 1;
        this._sheet = xSLFSheet;
        this._spTree = cTGroupShape;
        for (XmlObject xmlObject : xSLFSheet.getSpTree().selectPath("declare namespace p='http://schemas.openxmlformats.org/presentationml/2006/main' .//*/p:cNvPr")) {
            if (xmlObject instanceof CTNonVisualDrawingProps) {
                this._shapeId = (int) Math.max(this._shapeId, ((CTNonVisualDrawingProps) xmlObject).getId());
            }
        }
    }

    public XSLFAutoShape createAutoShape() {
        CTShape cTShapeAddNewSp = this._spTree.addNewSp();
        int i = this._shapeId;
        this._shapeId = i + 1;
        cTShapeAddNewSp.set(XSLFAutoShape.prototype(i));
        XSLFAutoShape xSLFAutoShape = new XSLFAutoShape(cTShapeAddNewSp, this._sheet);
        xSLFAutoShape.setAnchor(new Rectangle2D.Double());
        return xSLFAutoShape;
    }

    public XSLFConnectorShape createConnector() {
        CTConnector cTConnectorAddNewCxnSp = this._spTree.addNewCxnSp();
        int i = this._shapeId;
        this._shapeId = i + 1;
        cTConnectorAddNewCxnSp.set(XSLFConnectorShape.prototype(i));
        XSLFConnectorShape xSLFConnectorShape = new XSLFConnectorShape(cTConnectorAddNewCxnSp, this._sheet);
        xSLFConnectorShape.setAnchor(new Rectangle2D.Double());
        xSLFConnectorShape.setLineColor(Color.black);
        xSLFConnectorShape.setLineWidth(0.75d);
        return xSLFConnectorShape;
    }

    public XSLFFreeformShape createFreeform() {
        CTShape cTShapeAddNewSp = this._spTree.addNewSp();
        int i = this._shapeId;
        this._shapeId = i + 1;
        cTShapeAddNewSp.set(XSLFFreeformShape.prototype(i));
        XSLFFreeformShape xSLFFreeformShape = new XSLFFreeformShape(cTShapeAddNewSp, this._sheet);
        xSLFFreeformShape.setAnchor(new Rectangle2D.Double());
        return xSLFFreeformShape;
    }

    public XSLFGroupShape createGroup() {
        CTGroupShape cTGroupShapeAddNewGrpSp = this._spTree.addNewGrpSp();
        int i = this._shapeId;
        this._shapeId = i + 1;
        cTGroupShapeAddNewGrpSp.set(XSLFGroupShape.prototype(i));
        XSLFGroupShape xSLFGroupShape = new XSLFGroupShape(cTGroupShapeAddNewGrpSp, this._sheet);
        xSLFGroupShape.setAnchor(new Rectangle2D.Double());
        return xSLFGroupShape;
    }

    public XSLFPictureShape createPicture(String str) {
        CTPicture cTPictureAddNewPic = this._spTree.addNewPic();
        int i = this._shapeId;
        this._shapeId = i + 1;
        cTPictureAddNewPic.set(XSLFPictureShape.prototype(i, str));
        XSLFPictureShape xSLFPictureShape = new XSLFPictureShape(cTPictureAddNewPic, this._sheet);
        xSLFPictureShape.setAnchor(new Rectangle2D.Double());
        return xSLFPictureShape;
    }

    public XSLFTable createTable() {
        CTGraphicalObjectFrame cTGraphicalObjectFrameAddNewGraphicFrame = this._spTree.addNewGraphicFrame();
        int i = this._shapeId;
        this._shapeId = i + 1;
        cTGraphicalObjectFrameAddNewGraphicFrame.set(XSLFTable.prototype(i));
        XSLFTable xSLFTable = new XSLFTable(cTGraphicalObjectFrameAddNewGraphicFrame, this._sheet);
        xSLFTable.setAnchor(new Rectangle2D.Double());
        return xSLFTable;
    }

    public XSLFTextBox createTextBox() {
        CTShape cTShapeAddNewSp = this._spTree.addNewSp();
        int i = this._shapeId;
        this._shapeId = i + 1;
        cTShapeAddNewSp.set(XSLFTextBox.prototype(i));
        XSLFTextBox xSLFTextBox = new XSLFTextBox(cTShapeAddNewSp, this._sheet);
        xSLFTextBox.setAnchor(new Rectangle2D.Double());
        return xSLFTextBox;
    }
}
