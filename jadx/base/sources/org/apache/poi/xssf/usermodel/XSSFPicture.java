package org.apache.poi.xssf.usermodel;

import java.io.IOException;
import org.apache.poi.java.awt.Dimension;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.p227ss.usermodel.Picture;
import org.apache.poi.ss.util.ImageUtils;
import org.apache.poi.util.Internal;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetGeometry2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
import org.openxmlformats.schemas.drawingml.x2006.main.STShapeType;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPicture;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPictureNonVisual;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class XSSFPicture extends XSSFShape implements Picture {
    private static final POILogger logger = POILogFactory.getLogger((Class<?>) XSSFPicture.class);
    private static CTPicture prototype = null;
    private CTPicture ctPicture;

    public XSSFPicture(XSSFDrawing xSSFDrawing, CTPicture cTPicture) {
        this.drawing = xSSFDrawing;
        this.ctPicture = cTPicture;
    }

    public static Dimension getImageDimension(PackagePart packagePart, int i) {
        try {
            return ImageUtils.getImageDimension(packagePart.getInputStream(), i);
        } catch (IOException e) {
            logger.log(5, e);
            return new Dimension();
        }
    }

    public static CTPicture prototype() {
        if (prototype == null) {
            CTPicture cTPictureNewInstance = CTPicture.Factory.newInstance();
            CTPictureNonVisual cTPictureNonVisualAddNewNvPicPr = cTPictureNewInstance.addNewNvPicPr();
            CTNonVisualDrawingProps cTNonVisualDrawingPropsAddNewCNvPr = cTPictureNonVisualAddNewNvPicPr.addNewCNvPr();
            cTNonVisualDrawingPropsAddNewCNvPr.setId(1L);
            cTNonVisualDrawingPropsAddNewCNvPr.setName("Picture 1");
            cTNonVisualDrawingPropsAddNewCNvPr.setDescr("Picture");
            cTPictureNonVisualAddNewNvPicPr.addNewCNvPicPr().addNewPicLocks().setNoChangeAspect(true);
            CTBlipFillProperties cTBlipFillPropertiesAddNewBlipFill = cTPictureNewInstance.addNewBlipFill();
            cTBlipFillPropertiesAddNewBlipFill.addNewBlip().setEmbed("");
            cTBlipFillPropertiesAddNewBlipFill.addNewStretch().addNewFillRect();
            CTShapeProperties cTShapePropertiesAddNewSpPr = cTPictureNewInstance.addNewSpPr();
            CTTransform2D cTTransform2DAddNewXfrm = cTShapePropertiesAddNewSpPr.addNewXfrm();
            CTPositiveSize2D cTPositiveSize2DAddNewExt = cTTransform2DAddNewXfrm.addNewExt();
            cTPositiveSize2DAddNewExt.setCx(0L);
            cTPositiveSize2DAddNewExt.setCy(0L);
            CTPoint2D cTPoint2DAddNewOff = cTTransform2DAddNewXfrm.addNewOff();
            cTPoint2DAddNewOff.setX(0L);
            cTPoint2DAddNewOff.setY(0L);
            CTPresetGeometry2D cTPresetGeometry2DAddNewPrstGeom = cTShapePropertiesAddNewSpPr.addNewPrstGeom();
            cTPresetGeometry2DAddNewPrstGeom.setPrst(STShapeType.RECT);
            cTPresetGeometry2DAddNewPrstGeom.addNewAvLst();
            prototype = cTPictureNewInstance;
        }
        return prototype;
    }

    @Internal
    public CTPicture getCTPicture() {
        return this.ctPicture;
    }

    @Override // org.apache.poi.p227ss.usermodel.Shape
    public String getShapeName() {
        return this.ctPicture.getNvPicPr().getCNvPr().getName();
    }

    public CTShapeProperties getShapeProperties() {
        return this.ctPicture.getSpPr();
    }

    @Override // org.apache.poi.p227ss.usermodel.Picture
    public void resize() {
        resize(Double.MAX_VALUE);
    }

    public void setPictureReference(PackageRelationship packageRelationship) {
        this.ctPicture.getBlipFill().getBlip().setEmbed(packageRelationship.getId());
    }

    @Override // org.apache.poi.p227ss.usermodel.Picture
    public XSSFClientAnchor getClientAnchor() {
        XSSFClientAnchor anchor = getAnchor();
        if (anchor instanceof XSSFClientAnchor) {
            return anchor;
        }
        return null;
    }

    @Override // org.apache.poi.p227ss.usermodel.Picture
    public XSSFPictureData getPictureData() {
        return (XSSFPictureData) getDrawing().getRelationById(this.ctPicture.getBlipFill().getBlip().getEmbed());
    }

    @Override // org.apache.poi.p227ss.usermodel.Picture
    public XSSFSheet getSheet() {
        return (XSSFSheet) getDrawing().getParent();
    }

    @Override // org.apache.poi.p227ss.usermodel.Picture
    public void resize(double d) {
        resize(d, d);
    }

    @Override // org.apache.poi.p227ss.usermodel.Picture
    public XSSFClientAnchor getPreferredSize() {
        return getPreferredSize(1.0d);
    }

    @Override // org.apache.poi.p227ss.usermodel.Picture
    public void resize(double d, double d2) {
        XSSFClientAnchor clientAnchor = getClientAnchor();
        XSSFClientAnchor preferredSize = getPreferredSize(d, d2);
        int row2 = (preferredSize.getRow2() - preferredSize.getRow1()) + clientAnchor.getRow1();
        clientAnchor.setCol2((preferredSize.getCol2() - preferredSize.getCol1()) + clientAnchor.getCol1());
        clientAnchor.setDx2(preferredSize.getDx2());
        clientAnchor.setRow2(row2);
        clientAnchor.setDy2(preferredSize.getDy2());
    }

    @Override // org.apache.poi.p227ss.usermodel.Picture
    public Dimension getImageDimension() {
        XSSFPictureData pictureData = getPictureData();
        return getImageDimension(pictureData.getPackagePart(), pictureData.getPictureType());
    }

    public XSSFClientAnchor getPreferredSize(double d) {
        return getPreferredSize(d, d);
    }

    @Override // org.apache.poi.p227ss.usermodel.Picture
    public XSSFClientAnchor getPreferredSize(double d, double d2) {
        Dimension preferredSize = ImageUtils.setPreferredSize(this, d, d2);
        CTPositiveSize2D ext = this.ctPicture.getSpPr().getXfrm().getExt();
        ext.setCx((int) preferredSize.getWidth());
        ext.setCy((int) preferredSize.getHeight());
        return getClientAnchor();
    }
}
