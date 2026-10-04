package org.apache.poi.xslf.usermodel;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.core.text.util.LocalePreferences;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import org.apache.poi.java.awt.Color;
import org.apache.poi.p226sl.draw.DrawPaint;
import org.apache.poi.p226sl.usermodel.ColorStyle;
import org.apache.poi.sl.usermodel.PresetColor;
import org.apache.poi.util.Internal;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;
import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.drawingml.x2006.main.CTColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTFontReference;
import org.openxmlformats.schemas.drawingml.x2006.main.CTHslColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPositiveFixedPercentage;
import org.openxmlformats.schemas.drawingml.x2006.main.CTPresetColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSRgbColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTScRgbColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSchemeColor;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSolidColorFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTSystemColor;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public class XSLFColor {
    private static final POILogger LOGGER = POILogFactory.getLogger((Class<?>) XSLFColor.class);
    private Color _color;
    private CTSchemeColor _phClr;
    private XmlObject _xmlObject;

    public XSLFColor(XmlObject xmlObject, XSLFTheme xSLFTheme, CTSchemeColor cTSchemeColor) {
        this._xmlObject = xmlObject;
        this._phClr = cTSchemeColor;
        this._color = toColor(xmlObject, xSLFTheme);
    }

    private int getAngleValue(String str) {
        int rawValue = getRawValue(str);
        return rawValue == -1 ? rawValue : rawValue / 60000;
    }

    private int getPercentageValue(String str) {
        int rawValue = getRawValue(str);
        return rawValue == -1 ? rawValue : rawValue / 1000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRawValue(String str) {
        Node namedItem;
        Node namedItem2;
        String strM772n = AbstractC0541b.m772n("declare namespace a='http://schemas.openxmlformats.org/drawingml/2006/main' $this//a:", str);
        CTSchemeColor cTSchemeColor = this._phClr;
        if (cTSchemeColor != null) {
            XmlObject[] xmlObjectArrSelectPath = cTSchemeColor.selectPath(strM772n);
            if (xmlObjectArrSelectPath.length == 1 && (namedItem2 = xmlObjectArrSelectPath[0].getDomNode().getAttributes().getNamedItem(VElementFormulasCmd.FVAL)) != null) {
                return Integer.parseInt(namedItem2.getNodeValue());
            }
        }
        XmlObject[] xmlObjectArrSelectPath2 = this._xmlObject.selectPath(strM772n);
        if (xmlObjectArrSelectPath2.length != 1 || (namedItem = xmlObjectArrSelectPath2[0].getDomNode().getAttributes().getNamedItem(VElementFormulasCmd.FVAL)) == null) {
            return -1;
        }
        return Integer.parseInt(namedItem.getNodeValue());
    }

    private static boolean isInt(float f) {
        double d = f * 255.0f;
        return Math.abs(d - Math.rint(d)) < 9.999999747378752E-6d;
    }

    public int getAlpha() {
        return getPercentageValue("alpha");
    }

    public int getAlphaMod() {
        return getPercentageValue("alphaMod");
    }

    public int getAlphaOff() {
        return getPercentageValue("alphaOff");
    }

    public int getBlue() {
        return getPercentageValue("blue");
    }

    public int getBlueMod() {
        return getPercentageValue("blueMod");
    }

    public int getBlueOff() {
        return getPercentageValue("blueOff");
    }

    public Color getColor() {
        return DrawPaint.applyColorTransform(getColorStyle());
    }

    public ColorStyle getColorStyle() {
        return new ColorStyle() { // from class: org.apache.poi.xslf.usermodel.XSLFColor.1
            @Override // org.apache.poi.p226sl.usermodel.ColorStyle
            public int getAlpha() {
                return XSLFColor.this.getRawValue("alpha");
            }

            @Override // org.apache.poi.p226sl.usermodel.ColorStyle
            public Color getColor() {
                return XSLFColor.this._color;
            }

            @Override // org.apache.poi.p226sl.usermodel.ColorStyle
            public int getHueMod() {
                return XSLFColor.this.getRawValue("hueMod");
            }

            @Override // org.apache.poi.p226sl.usermodel.ColorStyle
            public int getHueOff() {
                return XSLFColor.this.getRawValue("hueOff");
            }

            @Override // org.apache.poi.p226sl.usermodel.ColorStyle
            public int getLumMod() {
                return XSLFColor.this.getRawValue("lumMod");
            }

            @Override // org.apache.poi.p226sl.usermodel.ColorStyle
            public int getLumOff() {
                return XSLFColor.this.getRawValue("lumOff");
            }

            @Override // org.apache.poi.p226sl.usermodel.ColorStyle
            public int getSatMod() {
                return XSLFColor.this.getRawValue("satMod");
            }

            @Override // org.apache.poi.p226sl.usermodel.ColorStyle
            public int getSatOff() {
                return XSLFColor.this.getRawValue("satOff");
            }

            @Override // org.apache.poi.p226sl.usermodel.ColorStyle
            public int getShade() {
                return XSLFColor.this.getRawValue("shade");
            }

            @Override // org.apache.poi.p226sl.usermodel.ColorStyle
            public int getTint() {
                return XSLFColor.this.getRawValue("tint");
            }
        };
    }

    public int getGreen() {
        return getPercentageValue("green");
    }

    public int getGreenMod() {
        return getPercentageValue("greenMod");
    }

    public int getGreenOff() {
        return getPercentageValue("greenOff");
    }

    public int getHue() {
        return getAngleValue("hue");
    }

    public int getHueMod() {
        return getPercentageValue("hueMod");
    }

    public int getHueOff() {
        return getPercentageValue("hueOff");
    }

    public int getLum() {
        return getPercentageValue("lum");
    }

    public int getLumMod() {
        return getPercentageValue("lumMod");
    }

    public int getLumOff() {
        return getPercentageValue("lumOff");
    }

    public int getRed() {
        return getPercentageValue("red");
    }

    public int getRedMod() {
        return getPercentageValue("redMod");
    }

    public int getRedOff() {
        return getPercentageValue("redOff");
    }

    public int getSat() {
        return getPercentageValue(LocalePreferences.FirstDayOfWeek.SATURDAY);
    }

    public int getSatMod() {
        return getPercentageValue("satMod");
    }

    public int getSatOff() {
        return getPercentageValue("satOff");
    }

    public int getShade() {
        return getPercentageValue("shade");
    }

    public int getTint() {
        return getPercentageValue("tint");
    }

    @Internal
    public XmlObject getXmlObject() {
        return this._xmlObject;
    }

    @Internal
    public void setColor(Color color) {
        XmlObject xmlObject = this._xmlObject;
        if (!(xmlObject instanceof CTSolidColorFillProperties)) {
            LOGGER.log(7, "XSLFColor.setColor currently only supports CTSolidColorFillProperties");
            return;
        }
        CTSolidColorFillProperties cTSolidColorFillProperties = (CTSolidColorFillProperties) xmlObject;
        if (cTSolidColorFillProperties.isSetSrgbClr()) {
            cTSolidColorFillProperties.unsetSrgbClr();
        }
        if (cTSolidColorFillProperties.isSetScrgbClr()) {
            cTSolidColorFillProperties.unsetScrgbClr();
        }
        if (cTSolidColorFillProperties.isSetHslClr()) {
            cTSolidColorFillProperties.unsetHslClr();
        }
        if (cTSolidColorFillProperties.isSetPrstClr()) {
            cTSolidColorFillProperties.unsetPrstClr();
        }
        if (cTSolidColorFillProperties.isSetSchemeClr()) {
            cTSolidColorFillProperties.unsetSchemeClr();
        }
        if (cTSolidColorFillProperties.isSetSysClr()) {
            cTSolidColorFillProperties.unsetSysClr();
        }
        CTPositiveFixedPercentage cTPositiveFixedPercentageAddNewAlpha = null;
        float[] rGBComponents = color.getRGBComponents(null);
        boolean z = rGBComponents.length == 4 && rGBComponents[3] < 1.0f;
        if (isInt(rGBComponents[0]) && isInt(rGBComponents[1]) && isInt(rGBComponents[2])) {
            CTSRgbColor cTSRgbColorAddNewSrgbClr = cTSolidColorFillProperties.addNewSrgbClr();
            cTSRgbColorAddNewSrgbClr.setVal(new byte[]{(byte) color.getRed(), (byte) color.getGreen(), (byte) color.getBlue()});
            if (z) {
                cTPositiveFixedPercentageAddNewAlpha = cTSRgbColorAddNewSrgbClr.addNewAlpha();
            }
        } else {
            CTScRgbColor cTScRgbColorAddNewScrgbClr = cTSolidColorFillProperties.addNewScrgbClr();
            cTScRgbColorAddNewScrgbClr.setR(DrawPaint.srgb2lin(rGBComponents[0]));
            cTScRgbColorAddNewScrgbClr.setG(DrawPaint.srgb2lin(rGBComponents[1]));
            cTScRgbColorAddNewScrgbClr.setB(DrawPaint.srgb2lin(rGBComponents[2]));
            if (z) {
                cTPositiveFixedPercentageAddNewAlpha = cTScRgbColorAddNewScrgbClr.addNewAlpha();
            }
        }
        if (cTPositiveFixedPercentageAddNewAlpha != null) {
            cTPositiveFixedPercentageAddNewAlpha.setVal((int) (rGBComponents[3] * 100000.0f));
        }
    }

    public Color toColor(XmlObject xmlObject, XSLFTheme xSLFTheme) {
        Color color;
        Color color2 = null;
        for (XmlObject xmlObject2 : xmlObject.selectPath("*")) {
            if (xmlObject2 instanceof CTHslColor) {
                CTHslColor cTHslColor = (CTHslColor) xmlObject2;
                color2 = DrawPaint.HSL2RGB(((double) cTHslColor.getHue2()) / 60000.0d, ((double) cTHslColor.getSat2()) / 1000.0d, ((double) cTHslColor.getLum2()) / 1000.0d, 1.0d);
            } else if (xmlObject2 instanceof CTPresetColor) {
                PresetColor presetColorValueOfOoxmlId = PresetColor.valueOfOoxmlId(((CTPresetColor) xmlObject2).getVal().toString());
                if (presetColorValueOfOoxmlId != null) {
                    color2 = presetColorValueOfOoxmlId.color;
                }
            } else {
                if (xmlObject2 instanceof CTSchemeColor) {
                    String string = ((CTSchemeColor) xmlObject2).getVal().toString();
                    CTSchemeColor cTSchemeColor = this._phClr;
                    if (cTSchemeColor != null) {
                        string = cTSchemeColor.getVal().toString();
                    }
                    CTColor cTColor = xSLFTheme.getCTColor(string);
                    if (cTColor != null) {
                        color2 = toColor(cTColor, null);
                    }
                } else if (xmlObject2 instanceof CTScRgbColor) {
                    CTScRgbColor cTScRgbColor = (CTScRgbColor) xmlObject2;
                    color2 = new Color(DrawPaint.lin2srgb(cTScRgbColor.getR()), DrawPaint.lin2srgb(cTScRgbColor.getG()), DrawPaint.lin2srgb(cTScRgbColor.getB()));
                } else {
                    if (xmlObject2 instanceof CTSRgbColor) {
                        byte[] val = ((CTSRgbColor) xmlObject2).getVal();
                        color = new Color(val[0] & 255, val[1] & 255, val[2] & 255);
                    } else if (xmlObject2 instanceof CTSystemColor) {
                        CTSystemColor cTSystemColor = (CTSystemColor) xmlObject2;
                        if (cTSystemColor.isSetLastClr()) {
                            byte[] lastClr = cTSystemColor.getLastClr();
                            color = new Color(lastClr[0] & 255, lastClr[1] & 255, lastClr[2] & 255);
                        } else {
                            PresetColor presetColorValueOfOoxmlId2 = PresetColor.valueOfOoxmlId(cTSystemColor.getVal().toString());
                            if (presetColorValueOfOoxmlId2 != null) {
                                color2 = presetColorValueOfOoxmlId2.color;
                            }
                            if (color2 == null) {
                                color2 = Color.black;
                            }
                        }
                    } else if (!(xmlObject2 instanceof CTFontReference)) {
                        throw new IllegalArgumentException("Unexpected color choice: " + xmlObject2.getClass());
                    }
                    color2 = color;
                }
            }
        }
        return color2;
    }
}
