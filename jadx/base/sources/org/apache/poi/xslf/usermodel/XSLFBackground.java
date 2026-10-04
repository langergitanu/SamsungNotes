package org.apache.poi.xslf.usermodel;

import org.apache.poi.POIXMLException;
import org.apache.poi.java.awt.Color;
import org.apache.poi.java.awt.Dimension;
import org.apache.poi.java.awt.geom.Rectangle2D;
import org.apache.poi.p226sl.usermodel.Background;
import org.apache.poi.p226sl.usermodel.Placeholder;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTTransform2D;
import org.openxmlformats.schemas.presentationml.x2006.main.CTBackground;
import org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XSLFBackground extends XSLFSimpleShape implements Background<XSLFShape, XSLFTextParagraph> {
    public XSLFBackground(CTBackground cTBackground, XSLFSheet xSLFSheet) {
        super(cTBackground, xSLFSheet);
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSimpleShape, org.apache.poi.p226sl.usermodel.Shape, org.apache.poi.p226sl.usermodel.PlaceableShape
    public Rectangle2D getAnchor() {
        Dimension pageSize = getSheet().getSlideShow().getPageSize();
        return new Rectangle2D.Double(0.0d, 0.0d, pageSize.getWidth(), pageSize.getHeight());
    }

    public CTBackgroundProperties getBgPr(boolean z) {
        CTBackground xmlObject = getXmlObject();
        if (xmlObject.isSetBgPr() || !z) {
            return xmlObject.getBgPr();
        }
        if (xmlObject.isSetBgRef()) {
            xmlObject.unsetBgRef();
        }
        return xmlObject.addNewBgPr();
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFShape
    public XmlObject getShapeProperties() {
        CTBackground xmlObject = getXmlObject();
        if (xmlObject.isSetBgPr()) {
            return xmlObject.getBgPr();
        }
        if (xmlObject.isSetBgRef()) {
            return xmlObject.getBgRef();
        }
        return null;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSimpleShape
    public CTTransform2D getXfrm(boolean z) {
        return null;
    }

    @Override // org.apache.poi.xslf.usermodel.XSLFSimpleShape, org.apache.poi.p226sl.usermodel.SimpleShape
    public void setFillColor(Color color) {
        CTBackgroundProperties bgPr = getBgPr(true);
        if (color != null) {
            if (bgPr.isSetNoFill()) {
                bgPr.unsetNoFill();
            }
            CTSolidColorFillProperties solidFill = bgPr.isSetSolidFill() ? bgPr.getSolidFill() : bgPr.addNewSolidFill();
            new XSLFColor(solidFill, getSheet().getTheme(), solidFill.getSchemeClr()).setColor(color);
            return;
        }
        if (bgPr.isSetSolidFill()) {
            bgPr.unsetSolidFill();
        }
        if (bgPr.isSetNoFill()) {
            return;
        }
        bgPr.addNewNoFill();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.poi.POIXMLException */
    @Override // org.apache.poi.xslf.usermodel.XSLFSimpleShape, org.apache.poi.xslf.usermodel.XSLFShape, org.apache.poi.p226sl.usermodel.SimpleShape
    public void setPlaceholder(Placeholder placeholder) throws POIXMLException {
        throw new POIXMLException("Can't set a placeholder for a background");
    }
}
