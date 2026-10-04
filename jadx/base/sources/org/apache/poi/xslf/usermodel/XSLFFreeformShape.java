package org.apache.poi.xslf.usermodel;

import org.apache.poi.java.awt.geom.AffineTransform;
import org.apache.poi.java.awt.geom.Path2D;
import org.apache.poi.java.awt.geom.PathIterator;
import org.apache.poi.java.awt.geom.Rectangle2D;
import org.apache.poi.p226sl.usermodel.FreeformShape;
import org.apache.poi.util.Units;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTAdjPoint2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTCustomGeometry2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGeomRect;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2D;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DClose;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DCubicBezierTo;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DLineTo;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DMoveTo;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPath2DQuadBezierTo;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.presentationml.x2006.main.CTShape;
import org.openxmlformats.schemas.presentationml.x2006.main.CTShapeNonVisual;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XSLFFreeformShape extends XSLFAutoShape implements FreeformShape<XSLFShape, XSLFTextParagraph> {
    public XSLFFreeformShape(CTShape cTShape, XSLFSheet xSLFSheet) {
        super(cTShape, xSLFSheet);
    }

    public static CTShape prototype(int i) {
        CTShape cTShapeNewInstance = CTShape.Factory.newInstance();
        CTShapeNonVisual cTShapeNonVisualAddNewNvSpPr = cTShapeNewInstance.addNewNvSpPr();
        CTNonVisualDrawingProps cTNonVisualDrawingPropsAddNewCNvPr = cTShapeNonVisualAddNewNvSpPr.addNewCNvPr();
        cTNonVisualDrawingPropsAddNewCNvPr.setName("Freeform " + i);
        cTNonVisualDrawingPropsAddNewCNvPr.setId((long) (i + 1));
        cTShapeNonVisualAddNewNvSpPr.addNewCNvSpPr();
        cTShapeNonVisualAddNewNvSpPr.addNewNvPr();
        CTCustomGeometry2D cTCustomGeometry2DAddNewCustGeom = cTShapeNewInstance.addNewSpPr().addNewCustGeom();
        cTCustomGeometry2DAddNewCustGeom.addNewAvLst();
        cTCustomGeometry2DAddNewCustGeom.addNewGdLst();
        cTCustomGeometry2DAddNewCustGeom.addNewAhLst();
        cTCustomGeometry2DAddNewCustGeom.addNewCxnLst();
        CTGeomRect cTGeomRectAddNewRect = cTCustomGeometry2DAddNewCustGeom.addNewRect();
        cTGeomRectAddNewRect.setR("r");
        cTGeomRectAddNewRect.setB("b");
        cTGeomRectAddNewRect.setT("t");
        cTGeomRectAddNewRect.setL("l");
        cTCustomGeometry2DAddNewCustGeom.addNewPathLst();
        return cTShapeNewInstance;
    }

    @Override // org.apache.poi.p226sl.usermodel.FreeformShape
    public Path2D.Double getPath() {
        int i;
        int i2;
        XmlObject[] xmlObjectArr;
        int i4;
        int i5;
        Path2D.Double r02 = new Path2D.Double();
        Rectangle2D anchor = getAnchor();
        XmlObject shapeProperties = getShapeProperties();
        if (!(shapeProperties instanceof CTShapeProperties)) {
            return null;
        }
        CTPath2D[] pathArray = ((CTShapeProperties) shapeProperties).getCustGeom().getPathLst().getPathArray();
        int length = pathArray.length;
        int i6 = 0;
        int i7 = 0;
        while (i7 < length) {
            CTPath2D cTPath2D = pathArray[i7];
            double width = anchor.getWidth() / Units.toPoints(cTPath2D.getW());
            double height = anchor.getHeight() / Units.toPoints(cTPath2D.getH());
            XmlObject[] xmlObjectArrSelectPath = cTPath2D.selectPath("*");
            int length2 = xmlObjectArrSelectPath.length;
            int i8 = i6;
            while (i8 < length2) {
                XmlObject xmlObject = xmlObjectArrSelectPath[i8];
                if (xmlObject instanceof CTPath2DMoveTo) {
                    CTAdjPoint2D pt = ((CTPath2DMoveTo) xmlObject).getPt();
                    r02.moveTo((float) (Units.toPoints(((Long) pt.getX()).longValue()) * width), (float) (Units.toPoints(((Long) pt.getY()).longValue()) * height));
                } else if (xmlObject instanceof CTPath2DLineTo) {
                    CTAdjPoint2D pt2 = ((CTPath2DLineTo) xmlObject).getPt();
                    r02.lineTo((float) Units.toPoints(((Long) pt2.getX()).longValue()), (float) Units.toPoints(((Long) pt2.getY()).longValue()));
                } else {
                    if (xmlObject instanceof CTPath2DQuadBezierTo) {
                        CTPath2DQuadBezierTo cTPath2DQuadBezierTo = (CTPath2DQuadBezierTo) xmlObject;
                        CTAdjPoint2D ptArray = cTPath2DQuadBezierTo.getPtArray(i6);
                        CTAdjPoint2D ptArray2 = cTPath2DQuadBezierTo.getPtArray(1);
                        i2 = i7;
                        i = i8;
                        r02.quadTo((float) (Units.toPoints(((Long) ptArray.getX()).longValue()) * width), (float) (Units.toPoints(((Long) ptArray.getY()).longValue()) * height), (float) (Units.toPoints(((Long) ptArray2.getX()).longValue()) * width), (float) (Units.toPoints(((Long) ptArray2.getY()).longValue()) * height));
                        xmlObjectArr = xmlObjectArrSelectPath;
                        i4 = length2;
                        i5 = 0;
                    } else {
                        i = i8;
                        i2 = i7;
                        if (xmlObject instanceof CTPath2DCubicBezierTo) {
                            CTPath2DCubicBezierTo cTPath2DCubicBezierTo = (CTPath2DCubicBezierTo) xmlObject;
                            CTAdjPoint2D ptArray3 = cTPath2DCubicBezierTo.getPtArray(0);
                            CTAdjPoint2D ptArray4 = cTPath2DCubicBezierTo.getPtArray(1);
                            CTAdjPoint2D ptArray5 = cTPath2DCubicBezierTo.getPtArray(2);
                            xmlObjectArr = xmlObjectArrSelectPath;
                            i4 = length2;
                            i5 = 0;
                            r02 = r02;
                            r02.curveTo((float) (Units.toPoints(((Long) ptArray3.getX()).longValue()) * width), (float) (Units.toPoints(((Long) ptArray3.getY()).longValue()) * height), (float) (Units.toPoints(((Long) ptArray4.getX()).longValue()) * width), (float) (Units.toPoints(((Long) ptArray4.getY()).longValue()) * height), (float) (Units.toPoints(((Long) ptArray5.getX()).longValue()) * width), (float) (Units.toPoints(((Long) ptArray5.getY()).longValue()) * height));
                        } else {
                            xmlObjectArr = xmlObjectArrSelectPath;
                            i4 = length2;
                            i5 = 0;
                            if (xmlObject instanceof CTPath2DClose) {
                                r02.closePath();
                            }
                        }
                    }
                    i8 = i + 1;
                    xmlObjectArrSelectPath = xmlObjectArr;
                    length2 = i4;
                    i7 = i2;
                    i6 = i5;
                }
                i = i8;
                i5 = i6;
                i2 = i7;
                xmlObjectArr = xmlObjectArrSelectPath;
                i4 = length2;
                i8 = i + 1;
                xmlObjectArrSelectPath = xmlObjectArr;
                length2 = i4;
                i7 = i2;
                i6 = i5;
            }
            i7++;
        }
        AffineTransform affineTransform = new AffineTransform();
        affineTransform.translate(anchor.getX(), anchor.getY());
        return new Path2D.Double(affineTransform.createTransformedShape(r02));
    }

    @Override // org.apache.poi.p226sl.usermodel.FreeformShape
    public int setPath(Path2D.Double r17) {
        CTPath2D cTPath2DNewInstance = CTPath2D.Factory.newInstance();
        Rectangle2D bounds2D = r17.getBounds2D();
        int emu = Units.toEMU(bounds2D.getX());
        int emu2 = Units.toEMU(bounds2D.getY());
        PathIterator pathIterator = r17.getPathIterator(new AffineTransform());
        cTPath2DNewInstance.setH(Units.toEMU(bounds2D.getHeight()));
        cTPath2DNewInstance.setW(Units.toEMU(bounds2D.getWidth()));
        int i = 0;
        while (!pathIterator.isDone()) {
            double[] dArr = new double[6];
            int iCurrentSegment = pathIterator.currentSegment(dArr);
            if (iCurrentSegment == 0) {
                CTAdjPoint2D cTAdjPoint2DAddNewPt = cTPath2DNewInstance.addNewMoveTo().addNewPt();
                cTAdjPoint2DAddNewPt.setX(Integer.valueOf(Units.toEMU(dArr[0]) - emu));
                cTAdjPoint2DAddNewPt.setY(Integer.valueOf(Units.toEMU(dArr[1]) - emu2));
            } else if (iCurrentSegment != 1) {
                if (iCurrentSegment == 2) {
                    CTPath2DQuadBezierTo cTPath2DQuadBezierToAddNewQuadBezTo = cTPath2DNewInstance.addNewQuadBezTo();
                    CTAdjPoint2D cTAdjPoint2DAddNewPt2 = cTPath2DQuadBezierToAddNewQuadBezTo.addNewPt();
                    cTAdjPoint2DAddNewPt2.setX(Integer.valueOf(Units.toEMU(dArr[0]) - emu));
                    cTAdjPoint2DAddNewPt2.setY(Integer.valueOf(Units.toEMU(dArr[1]) - emu2));
                    CTAdjPoint2D cTAdjPoint2DAddNewPt3 = cTPath2DQuadBezierToAddNewQuadBezTo.addNewPt();
                    cTAdjPoint2DAddNewPt3.setX(Integer.valueOf(Units.toEMU(dArr[2]) - emu));
                    cTAdjPoint2DAddNewPt3.setY(Integer.valueOf(Units.toEMU(dArr[3]) - emu2));
                    i += 2;
                } else if (iCurrentSegment == 3) {
                    CTPath2DCubicBezierTo cTPath2DCubicBezierToAddNewCubicBezTo = cTPath2DNewInstance.addNewCubicBezTo();
                    CTAdjPoint2D cTAdjPoint2DAddNewPt4 = cTPath2DCubicBezierToAddNewCubicBezTo.addNewPt();
                    cTAdjPoint2DAddNewPt4.setX(Integer.valueOf(Units.toEMU(dArr[0]) - emu));
                    cTAdjPoint2DAddNewPt4.setY(Integer.valueOf(Units.toEMU(dArr[1]) - emu2));
                    CTAdjPoint2D cTAdjPoint2DAddNewPt5 = cTPath2DCubicBezierToAddNewCubicBezTo.addNewPt();
                    cTAdjPoint2DAddNewPt5.setX(Integer.valueOf(Units.toEMU(dArr[2]) - emu));
                    cTAdjPoint2DAddNewPt5.setY(Integer.valueOf(Units.toEMU(dArr[3]) - emu2));
                    CTAdjPoint2D cTAdjPoint2DAddNewPt6 = cTPath2DCubicBezierToAddNewCubicBezTo.addNewPt();
                    cTAdjPoint2DAddNewPt6.setX(Integer.valueOf(Units.toEMU(dArr[4]) - emu));
                    cTAdjPoint2DAddNewPt6.setY(Integer.valueOf(Units.toEMU(dArr[5]) - emu2));
                    i += 3;
                } else {
                    if (iCurrentSegment != 4) {
                        throw new IllegalStateException(AbstractC0000a.m11h(iCurrentSegment, "Unrecognized path segment type: "));
                    }
                    i++;
                    cTPath2DNewInstance.addNewClose();
                }
                pathIterator.next();
            } else {
                CTAdjPoint2D cTAdjPoint2DAddNewPt7 = cTPath2DNewInstance.addNewLnTo().addNewPt();
                cTAdjPoint2DAddNewPt7.setX(Integer.valueOf(Units.toEMU(dArr[0]) - emu));
                cTAdjPoint2DAddNewPt7.setY(Integer.valueOf(Units.toEMU(dArr[1]) - emu2));
            }
            i++;
            pathIterator.next();
        }
        XmlObject shapeProperties = getShapeProperties();
        if (!(shapeProperties instanceof CTShapeProperties)) {
            return -1;
        }
        ((CTShapeProperties) shapeProperties).getCustGeom().getPathLst().setPathArray(new CTPath2D[]{cTPath2DNewInstance});
        setAnchor(bounds2D);
        return i;
    }
}
