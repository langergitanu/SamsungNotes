package org.apache.poi.xslf.usermodel;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Comparator;
import org.apache.poi.java.awt.Graphics2D;
import org.apache.poi.java.awt.geom.Rectangle2D;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.p226sl.draw.DrawPaint;
import org.apache.poi.p226sl.usermodel.ColorStyle;
import org.apache.poi.p226sl.usermodel.PaintStyle;
import org.apache.poi.p226sl.usermodel.PlaceableShape;
import org.apache.poi.p226sl.usermodel.Placeholder;
import org.apache.poi.p226sl.usermodel.Shape;
import org.apache.poi.p226sl.usermodel.Sheet;
import org.apache.poi.sl.draw.DrawFactory;
import org.apache.poi.util.Internal;
import org.apache.poi.xslf.model.PropertyFetcher;
import org.apache.poi.xslf.usermodel.XSLFPropertiesDelegate;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlTokenSource;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlip;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGradientStop;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGroupShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTNonVisualDrawingProps;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSchemeColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTShapeStyle;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrix;
import org.openxmlformats.schemas.drawingml.x2006.main.CTStyleMatrixReference;
import org.openxmlformats.schemas.drawingml.x2006.main.STPathShadeType;
import org.openxmlformats.schemas.presentationml.x2006.main.CTApplicationNonVisualDrawingProps;
import org.openxmlformats.schemas.presentationml.x2006.main.CTBackgroundProperties;
import org.openxmlformats.schemas.presentationml.x2006.main.CTPlaceholder;
import org.openxmlformats.schemas.presentationml.x2006.main.STPlaceholderType;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class XSLFShape implements Shape<XSLFShape, XSLFTextParagraph> {
    protected static final String PML_NS = "http://schemas.openxmlformats.org/presentationml/2006/main";
    private CTNonVisualDrawingProps _nvPr;
    private XSLFShapeContainer _parent;
    private CTPlaceholder _ph;
    private final XmlObject _shape;
    private final XSLFSheet _sheet;
    private CTShapeStyle _spStyle;

    public XSLFShape(XmlObject xmlObject, XSLFSheet xSLFSheet) {
        this._shape = xmlObject;
        this._sheet = xSLFSheet;
    }

    private static int getPlaceholderType(CTPlaceholder cTPlaceholder) {
        if (!cTPlaceholder.isSetType()) {
            return 2;
        }
        int iIntValue = cTPlaceholder.getType().intValue();
        if (iIntValue == 1 || iIntValue == 3) {
            return 1;
        }
        if (iIntValue == 5 || iIntValue == 6 || iIntValue == 7) {
            return cTPlaceholder.getType().intValue();
        }
        return 2;
    }

    public static PaintStyle selectPaint(XSLFPropertiesDelegate.XSLFFillProperties xSLFFillProperties, CTSchemeColor cTSchemeColor, PackagePart packagePart, XSLFTheme xSLFTheme, boolean z) {
        if (xSLFFillProperties != null && !xSLFFillProperties.isSetNoFill()) {
            if (xSLFFillProperties.isSetSolidFill()) {
                return selectPaint(xSLFFillProperties.getSolidFill(), cTSchemeColor, xSLFTheme);
            }
            if (xSLFFillProperties.isSetBlipFill()) {
                return selectPaint(xSLFFillProperties.getBlipFill(), packagePart);
            }
            if (xSLFFillProperties.isSetGradFill()) {
                return selectPaint(xSLFFillProperties.getGradFill(), cTSchemeColor, xSLFTheme);
            }
            if (xSLFFillProperties.isSetMatrixStyle()) {
                return selectPaint(xSLFFillProperties.getMatrixStyle(), xSLFTheme, xSLFFillProperties.isLineStyle(), z);
            }
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Internal
    public void copy(XSLFShape xSLFShape) {
        if (getClass().isInstance(xSLFShape)) {
            if (this instanceof PlaceableShape) {
                ((PlaceableShape) this).setAnchor(xSLFShape.getAnchor());
            }
        } else {
            throw new IllegalArgumentException("Can't copy " + xSLFShape.getClass().getSimpleName() + " into " + getClass().getSimpleName());
        }
    }

    @Override // org.apache.poi.p226sl.usermodel.Shape
    public void draw(Graphics2D graphics2D, Rectangle2D rectangle2D) {
        DrawFactory.getInstance(graphics2D).drawShape(graphics2D, this, rectangle2D);
    }

    public boolean fetchShapeProperty(PropertyFetcher<?> propertyFetcher) {
        XSLFSimpleShape placeholderByType;
        if (propertyFetcher.fetch(this)) {
            return true;
        }
        CTPlaceholder cTPlaceholder = getCTPlaceholder();
        if (cTPlaceholder == null) {
            return false;
        }
        Sheet masterSheet = getSheet().getMasterSheet();
        if (masterSheet instanceof XSLFSlideLayout) {
            XSLFSlideLayout xSLFSlideLayout = (XSLFSlideLayout) masterSheet;
            XSLFSimpleShape placeholder = xSLFSlideLayout.getPlaceholder(cTPlaceholder);
            if (placeholder != null && propertyFetcher.fetch(placeholder)) {
                return true;
            }
            masterSheet = xSLFSlideLayout.getMasterSheet();
        }
        return (masterSheet instanceof XSLFSlideMaster) && (placeholderByType = ((XSLFSlideMaster) masterSheet).getPlaceholderByType(getPlaceholderType(cTPlaceholder))) != null && propertyFetcher.fetch(placeholderByType);
    }

    public CTBackgroundProperties getBgPr() {
        return getChild(CTBackgroundProperties.class, PML_NS, "bgPr");
    }

    public CTStyleMatrixReference getBgRef() {
        return (CTStyleMatrixReference) getChild(CTStyleMatrixReference.class, PML_NS, "bgRef");
    }

    public CTNonVisualDrawingProps getCNvPr() {
        if (this._nvPr == null) {
            this._nvPr = (CTNonVisualDrawingProps) selectProperty(CTNonVisualDrawingProps.class, "declare namespace p='http://schemas.openxmlformats.org/presentationml/2006/main' .//*/p:cNvPr");
        }
        return this._nvPr;
    }

    public CTPlaceholder getCTPlaceholder() {
        if (this._ph == null) {
            this._ph = (CTPlaceholder) selectProperty(CTPlaceholder.class, "declare namespace p='http://schemas.openxmlformats.org/presentationml/2006/main' .//*/p:nvPr/p:ph");
        }
        return this._ph;
    }

    public <T extends XmlObject> T getChild(Class<T> cls, String str, String str2) {
        XmlCursor xmlCursorNewCursor = getXmlObject().newCursor();
        T t = xmlCursorNewCursor.toChild(str, str2) ? (T) xmlCursorNewCursor.getObject() : null;
        if (xmlCursorNewCursor.toChild(XSSFRelation.NS_DRAWINGML, str2)) {
            t = (T) xmlCursorNewCursor.getObject();
        }
        xmlCursorNewCursor.dispose();
        return t;
    }

    public PaintStyle getFillPaint() {
        final XSLFTheme theme = getSheet().getTheme();
        final boolean z = getPlaceholder() != null;
        PropertyFetcher<PaintStyle> propertyFetcher = new PropertyFetcher<PaintStyle>() { // from class: org.apache.poi.xslf.usermodel.XSLFShape.1
            @Override // org.apache.poi.xslf.model.PropertyFetcher
            public boolean fetch(XSLFShape xSLFShape) {
                XSLFPropertiesDelegate.XSLFFillProperties fillDelegate = XSLFPropertiesDelegate.getFillDelegate(xSLFShape.getShapeProperties());
                if (fillDelegate == null) {
                    return false;
                }
                if (fillDelegate.isSetNoFill()) {
                    setValue(null);
                    return true;
                }
                PackagePart packagePart = xSLFShape.getSheet().getPackagePart();
                PaintStyle paintStyleSelectPaint = XSLFShape.selectPaint(fillDelegate, null, packagePart, theme, z);
                if (paintStyleSelectPaint != null) {
                    setValue(paintStyleSelectPaint);
                    return true;
                }
                CTShapeStyle spStyle = xSLFShape.getSpStyle();
                if (spStyle != null) {
                    paintStyleSelectPaint = XSLFShape.selectPaint(XSLFPropertiesDelegate.getFillDelegate(spStyle.getFillRef()), null, packagePart, theme, z);
                }
                if (paintStyleSelectPaint == null) {
                    return false;
                }
                setValue(paintStyleSelectPaint);
                return true;
            }
        };
        fetchShapeProperty(propertyFetcher);
        return propertyFetcher.getValue();
    }

    public CTGroupShapeProperties getGrpSpPr() {
        return (CTGroupShapeProperties) getChild(CTGroupShapeProperties.class, PML_NS, "grpSpPr");
    }

    public Placeholder getPlaceholder() {
        CTPlaceholder cTPlaceholder = getCTPlaceholder();
        if (cTPlaceholder == null) {
            return null;
        }
        if (cTPlaceholder.isSetType() || cTPlaceholder.isSetIdx()) {
            return Placeholder.lookupOoxml(cTPlaceholder.getType().intValue());
        }
        return null;
    }

    public int getShapeId() {
        return (int) getCNvPr().getId();
    }

    public String getShapeName() {
        return getCNvPr().getName();
    }

    public XmlObject getShapeProperties() {
        return getChild(CTShapeProperties.class, PML_NS, "spPr");
    }

    public CTShapeStyle getSpStyle() {
        if (this._spStyle == null) {
            this._spStyle = (CTShapeStyle) getChild(CTShapeStyle.class, PML_NS, "style");
        }
        return this._spStyle;
    }

    public final XmlObject getXmlObject() {
        return this._shape;
    }

    public <T extends XmlObject> T selectProperty(Class<T> cls, String str) {
        XmlObject[] xmlObjectArrSelectPath = getXmlObject().selectPath(str);
        if (xmlObjectArrSelectPath.length != 0 && cls.isInstance(xmlObjectArrSelectPath[0])) {
            return (T) xmlObjectArrSelectPath[0];
        }
        return null;
    }

    public void setParent(XSLFShapeContainer xSLFShapeContainer) {
        this._parent = xSLFShapeContainer;
    }

    public void setPlaceholder(Placeholder placeholder) {
        CTApplicationNonVisualDrawingProps cTApplicationNonVisualDrawingProps = (CTApplicationNonVisualDrawingProps) selectProperty(CTApplicationNonVisualDrawingProps.class, "declare namespace p='http://schemas.openxmlformats.org/presentationml/2006/main' .//*/p:nvPr");
        if (cTApplicationNonVisualDrawingProps == null) {
            return;
        }
        if (placeholder != null) {
            cTApplicationNonVisualDrawingProps.addNewPh().setType(STPlaceholderType.Enum.forInt(placeholder.ooxmlId));
            return;
        }
        if (cTApplicationNonVisualDrawingProps.isSetPh()) {
            cTApplicationNonVisualDrawingProps.unsetPh();
        }
        this._ph = null;
    }

    @Override // org.apache.poi.p226sl.usermodel.Shape
    public XSLFShapeContainer getParent() {
        return this._parent;
    }

    @Override // org.apache.poi.p226sl.usermodel.Shape
    public XSLFSheet getSheet() {
        return this._sheet;
    }

    public static PaintStyle selectPaint(CTSolidColorFillProperties cTSolidColorFillProperties, CTSchemeColor cTSchemeColor, XSLFTheme xSLFTheme) {
        if (cTSolidColorFillProperties.isSetSchemeClr() && cTSchemeColor == null) {
            cTSchemeColor = cTSolidColorFillProperties.getSchemeClr();
        }
        return DrawPaint.createSolidPaint(new XSLFColor(cTSolidColorFillProperties, xSLFTheme, cTSchemeColor).getColorStyle());
    }

    public static PaintStyle selectPaint(CTBlipFillProperties cTBlipFillProperties, final PackagePart packagePart) {
        final CTBlip blip = cTBlipFillProperties.getBlip();
        return new PaintStyle.TexturePaint() { // from class: org.apache.poi.xslf.usermodel.XSLFShape.2
            private PackagePart getPart() {
                try {
                    return packagePart.getRelatedPart(packagePart.getRelationship(blip.getEmbed()));
                } catch (InvalidFormatException e) {
                    throw new RuntimeException(e);
                }
            }

            @Override // org.apache.poi.sl.usermodel.PaintStyle.TexturePaint
            public int getAlpha() {
                if (blip.sizeOfAlphaModFixArray() > 0) {
                    return blip.getAlphaModFixArray(0).getAmt();
                }
                return 100000;
            }

            @Override // org.apache.poi.sl.usermodel.PaintStyle.TexturePaint
            public String getContentType() {
                return getPart().getContentType();
            }

            @Override // org.apache.poi.sl.usermodel.PaintStyle.TexturePaint
            public InputStream getImageData() {
                try {
                    return getPart().getInputStream();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }

    public static PaintStyle selectPaint(final CTGradientFillProperties cTGradientFillProperties, CTSchemeColor cTSchemeColor, XSLFTheme xSLFTheme) {
        CTGradientStop[] gsArray = cTGradientFillProperties.getGsLst().getGsArray();
        Arrays.sort(gsArray, new Comparator<CTGradientStop>() { // from class: org.apache.poi.xslf.usermodel.XSLFShape.3
            @Override // java.util.Comparator
            public int compare(CTGradientStop cTGradientStop, CTGradientStop cTGradientStop2) {
                return Integer.valueOf(cTGradientStop.getPos()).compareTo(Integer.valueOf(cTGradientStop2.getPos()));
            }
        });
        final ColorStyle[] colorStyleArr = new ColorStyle[gsArray.length];
        final float[] fArr = new float[gsArray.length];
        int i = 0;
        for (CTGradientStop cTGradientStop : gsArray) {
            colorStyleArr[i] = new XSLFColor(cTGradientStop, xSLFTheme, (cTSchemeColor == null && cTGradientStop.isSetSchemeClr()) ? cTGradientStop.getSchemeClr() : cTSchemeColor).getColorStyle();
            fArr[i] = cTGradientStop.getPos() / 100000.0f;
            i++;
        }
        return new PaintStyle.GradientPaint() { // from class: org.apache.poi.xslf.usermodel.XSLFShape.4
            @Override // org.apache.poi.sl.usermodel.PaintStyle.GradientPaint
            public double getGradientAngle() {
                if (cTGradientFillProperties.isSetLin()) {
                    return ((double) cTGradientFillProperties.getLin().getAng()) / 60000.0d;
                }
                return 0.0d;
            }

            @Override // org.apache.poi.sl.usermodel.PaintStyle.GradientPaint
            public ColorStyle[] getGradientColors() {
                return colorStyleArr;
            }

            @Override // org.apache.poi.sl.usermodel.PaintStyle.GradientPaint
            public float[] getGradientFractions() {
                return fArr;
            }

            @Override // org.apache.poi.sl.usermodel.PaintStyle.GradientPaint
            public PaintStyle.GradientPaint.GradientType getGradientType() {
                if (cTGradientFillProperties.isSetLin()) {
                    return PaintStyle.GradientPaint.GradientType.linear;
                }
                if (cTGradientFillProperties.isSetPath()) {
                    STPathShadeType.Enum path = cTGradientFillProperties.getPath().getPath();
                    if (path == STPathShadeType.CIRCLE) {
                        return PaintStyle.GradientPaint.GradientType.circular;
                    }
                    if (path == STPathShadeType.SHAPE) {
                        return PaintStyle.GradientPaint.GradientType.shape;
                    }
                }
                return PaintStyle.GradientPaint.GradientType.linear;
            }

            @Override // org.apache.poi.sl.usermodel.PaintStyle.GradientPaint
            public boolean isRotatedWithShape() {
                return cTGradientFillProperties.getRotWithShape();
            }
        };
    }

    public static PaintStyle selectPaint(CTStyleMatrixReference cTStyleMatrixReference, XSLFTheme xSLFTheme, boolean z, boolean z2) {
        int i;
        XmlTokenSource bgFillStyleLst;
        PaintStyle paintStyleSelectPaint = null;
        if (cTStyleMatrixReference == null) {
            return null;
        }
        int idx = (int) cTStyleMatrixReference.getIdx();
        CTStyleMatrix fmtScheme = xSLFTheme.getXmlObject().getThemeElements().getFmtScheme();
        if (idx < 1 || idx > 999) {
            if (idx >= 1001) {
                i = idx - 1001;
                bgFillStyleLst = fmtScheme.getBgFillStyleLst();
            }
            return paintStyleSelectPaint;
        }
        i = idx - 1;
        bgFillStyleLst = z ? fmtScheme.getLnStyleLst() : fmtScheme.getFillStyleLst();
        XmlCursor xmlCursorNewCursor = bgFillStyleLst.newCursor();
        XSLFPropertiesDelegate.XSLFFillProperties fillDelegate = xmlCursorNewCursor.toChild(i) ? XSLFPropertiesDelegate.getFillDelegate(xmlCursorNewCursor.getObject()) : null;
        xmlCursorNewCursor.dispose();
        CTSchemeColor schemeClr = cTStyleMatrixReference.getSchemeClr();
        paintStyleSelectPaint = selectPaint(fillDelegate, schemeClr, xSLFTheme.getPackagePart(), xSLFTheme, z2);
        if (paintStyleSelectPaint == null && !z2) {
            return DrawPaint.createSolidPaint(new XSLFColor(cTStyleMatrixReference, xSLFTheme, schemeClr).getColorStyle());
        }
        return paintStyleSelectPaint;
    }
}
