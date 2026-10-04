package org.apache.poi.xslf.usermodel;

import org.apache.poi.POIXMLException;
import org.apache.poi.java.awt.geom.Rectangle2D;
import org.apache.poi.javax.xml.namespace.QName;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.p226sl.usermodel.GraphicalFrame;
import org.apache.poi.p226sl.usermodel.ShapeType;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.poi.util.RecordFormatException;
import org.apache.poi.util.Units;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGraphicalObjectData;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveSize2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGraphicalObjectFrame;
import org.openxmlformats.schemas.presentationml.x2006.main.CTGroupShape;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XSLFGraphicFrame extends XSLFShape implements GraphicalFrame<XSLFShape, XSLFTextParagraph> {
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) XSLFGraphicFrame.class);

    public XSLFGraphicFrame(CTGraphicalObjectFrame cTGraphicalObjectFrame, XSLFSheet xSLFSheet) {
        super(cTGraphicalObjectFrame, xSLFSheet);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.poi.POIXMLException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.poi.util.RecordFormatException */
    private void copyDiagram(CTGraphicalObjectData cTGraphicalObjectData, XSLFGraphicFrame xSLFGraphicFrame) throws POIXMLException, RecordFormatException {
        XmlObject[] xmlObjectArrSelectPath = cTGraphicalObjectData.selectPath("declare namespace dgm='http://schemas.openxmlformats.org/drawingml/2006/diagram' $this//dgm:relIds");
        if (xmlObjectArrSelectPath == null || xmlObjectArrSelectPath.length != 1) {
            return;
        }
        XmlCursor xmlCursorNewCursor = xmlObjectArrSelectPath[0].newCursor();
        XSLFSheet sheet = xSLFGraphicFrame.getSheet();
        try {
            PackageRelationship relationship = sheet.getPackagePart().getRelationship(xmlCursorNewCursor.getAttributeText(new QName("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "dm")));
            getSheet().importPart(relationship, sheet.getPackagePart().getRelatedPart(relationship));
            PackageRelationship relationship2 = sheet.getPackagePart().getRelationship(xmlCursorNewCursor.getAttributeText(new QName("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "lo")));
            getSheet().importPart(relationship2, sheet.getPackagePart().getRelatedPart(relationship2));
            PackageRelationship relationship3 = sheet.getPackagePart().getRelationship(xmlCursorNewCursor.getAttributeText(new QName("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "qs")));
            getSheet().importPart(relationship3, sheet.getPackagePart().getRelatedPart(relationship3));
            PackageRelationship relationship4 = sheet.getPackagePart().getRelationship(xmlCursorNewCursor.getAttributeText(new QName("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "cs")));
            getSheet().importPart(relationship4, sheet.getPackagePart().getRelatedPart(relationship4));
            xmlCursorNewCursor.dispose();
        } catch (InvalidFormatException e) {
            throw new POIXMLException(e);
        }
    }

    public static XSLFGraphicFrame create(CTGraphicalObjectFrame cTGraphicalObjectFrame, XSLFSheet xSLFSheet) {
        return "http://schemas.openxmlformats.org/drawingml/2006/table".equals(cTGraphicalObjectFrame.getGraphic().getGraphicData().getUri()) ? new XSLFTable(cTGraphicalObjectFrame, xSLFSheet) : new XSLFGraphicFrame(cTGraphicalObjectFrame, xSLFSheet);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.poi.POIXMLException */
    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.poi.util.RecordFormatException */
    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    public void copy(XSLFShape xSLFShape) throws POIXMLException, RecordFormatException {
        super.copy(xSLFShape);
        CTGraphicalObjectData graphicData = ((CTGraphicalObjectFrame) getXmlObject()).getGraphic().getGraphicData();
        if (graphicData.getUri().equals("http://schemas.openxmlformats.org/drawingml/2006/diagram")) {
            copyDiagram(graphicData, (XSLFGraphicFrame) xSLFShape);
        }
    }

    @Override // org.apache.poi.p226sl.usermodel.Shape, org.apache.poi.p226sl.usermodel.PlaceableShape
    public Rectangle2D getAnchor() {
        CTTransform2D xfrm = ((CTGraphicalObjectFrame) getXmlObject()).getXfrm();
        CTPoint2D off = xfrm.getOff();
        double points = Units.toPoints(off.getX());
        double points2 = Units.toPoints(off.getY());
        CTPositiveSize2D ext = xfrm.getExt();
        return new Rectangle2D.Double(points, points2, Units.toPoints(ext.getCx()), Units.toPoints(ext.getCy()));
    }

    @Override // org.apache.poi.p226sl.usermodel.PlaceableShape
    public boolean getFlipHorizontal() {
        return false;
    }

    @Override // org.apache.poi.p226sl.usermodel.PlaceableShape
    public boolean getFlipVertical() {
        return false;
    }

    @Override // org.apache.poi.p226sl.usermodel.PlaceableShape
    public double getRotation() {
        return 0.0d;
    }

    public ShapeType getShapeType() {
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.poi.p226sl.usermodel.PlaceableShape
    public void setAnchor(Rectangle2D rectangle2D) {
        CTTransform2D xfrm = ((CTGraphicalObjectFrame) getXmlObject()).getXfrm();
        CTPoint2D off = xfrm.isSetOff() ? xfrm.getOff() : xfrm.addNewOff();
        long emu = Units.toEMU(rectangle2D.getX());
        long emu2 = Units.toEMU(rectangle2D.getY());
        off.setX(emu);
        off.setY(emu2);
        CTPositiveSize2D ext = xfrm.isSetExt() ? xfrm.getExt() : xfrm.addNewExt();
        long emu3 = Units.toEMU(rectangle2D.getWidth());
        long emu4 = Units.toEMU(rectangle2D.getHeight());
        ext.setCx(emu3);
        ext.setCy(emu4);
    }

    @Override // org.apache.poi.p226sl.usermodel.PlaceableShape
    public void setFlipHorizontal(boolean z) {
        throw new IllegalArgumentException("Operation not supported");
    }

    @Override // org.apache.poi.p226sl.usermodel.PlaceableShape
    public void setFlipVertical(boolean z) {
        throw new IllegalArgumentException("Operation not supported");
    }

    @Override // org.apache.poi.p226sl.usermodel.PlaceableShape
    public void setRotation(double d) {
        throw new IllegalArgumentException("Operation not supported");
    }

    @Override // org.apache.poi.p226sl.usermodel.GraphicalFrame
    public XSLFPictureShape getFallbackPicture() {
        XmlObject xmlObjectSelectProperty = selectProperty(XmlObject.class, "declare namespace p='http://schemas.openxmlformats.org/presentationml/2006/main'; declare namespace mc='http://schemas.openxmlformats.org/markup-compatibility/2006' .//mc:Fallback/*/p:pic");
        if (xmlObjectSelectProperty == null) {
            return null;
        }
        try {
            CTGroupShape cTGroupShape = CTGroupShape.Factory.parse(xmlObjectSelectProperty.newDomNode());
            if (cTGroupShape.sizeOfPicArray() == 0) {
                return null;
            }
            return new XSLFPictureShape(cTGroupShape.getPicArray(0), getSheet());
        } catch (XmlException e) {
            LOG.log(5, "Can't parse fallback picture stream of graphical frame", e);
            return null;
        }
    }
}
