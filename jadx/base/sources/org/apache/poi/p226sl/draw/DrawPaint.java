package org.apache.poi.p226sl.draw;

import androidx.compose.runtime.AbstractC1974b;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.java.awt.Color;
import org.apache.poi.java.awt.Dimension;
import org.apache.poi.java.awt.Graphics2D;
import org.apache.poi.java.awt.LinearGradientPaint;
import org.apache.poi.java.awt.Paint;
import org.apache.poi.java.awt.RadialGradientPaint;
import org.apache.poi.java.awt.TexturePaint;
import org.apache.poi.java.awt.geom.AffineTransform;
import org.apache.poi.java.awt.geom.Point2D;
import org.apache.poi.java.awt.geom.Rectangle2D;
import org.apache.poi.java.awt.image.BufferedImage;
import org.apache.poi.p226sl.usermodel.ColorStyle;
import org.apache.poi.p226sl.usermodel.PaintStyle;
import org.apache.poi.p226sl.usermodel.PlaceableShape;
import org.apache.poi.util.POILogFactory;
import org.apache.poi.util.POILogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DrawPaint {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final POILogger LOG = POILogFactory.getLogger((Class<?>) DrawPaint.class);
    private static final Color TRANSPARENT = new Color(1.0f, 1.0f, 1.0f, 0.0f);
    protected PlaceableShape<?, ?> shape;

    /* JADX INFO: renamed from: org.apache.poi.sl.draw.DrawPaint$2 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static /* synthetic */ class C140652 {

        /* JADX INFO: renamed from: $SwitchMap$org$apache$poi$sl$usermodel$PaintStyle$GradientPaint$GradientType */
        static final /* synthetic */ int[] f10161x425bedb0;
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$sl$usermodel$PaintStyle$PaintModifier;

        static {
            int[] iArr = new int[PaintStyle.GradientPaint.GradientType.values().length];
            f10161x425bedb0 = iArr;
            try {
                iArr[PaintStyle.GradientPaint.GradientType.linear.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10161x425bedb0[PaintStyle.GradientPaint.GradientType.circular.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10161x425bedb0[PaintStyle.GradientPaint.GradientType.shape.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[PaintStyle.PaintModifier.values().length];
            $SwitchMap$org$apache$poi$sl$usermodel$PaintStyle$PaintModifier = iArr2;
            try {
                iArr2[PaintStyle.PaintModifier.DARKEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$PaintStyle$PaintModifier[PaintStyle.PaintModifier.DARKEN_LESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$PaintStyle$PaintModifier[PaintStyle.PaintModifier.LIGHTEN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$org$apache$poi$sl$usermodel$PaintStyle$PaintModifier[PaintStyle.PaintModifier.LIGHTEN_LESS.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public DrawPaint(PlaceableShape<?, ?> placeableShape) {
        this.shape = placeableShape;
    }

    public static Color HSL2RGB(double d, double d2, double d3, double d4) {
        double dMax = Math.max(0.0d, Math.min(100.0d, d2));
        double dMax2 = Math.max(0.0d, Math.min(100.0d, d3));
        if (d4 < 0.0d || d4 > 1.0d) {
            throw new IllegalArgumentException(AbstractC1974b.m1318k("Color parameter outside of expected range - Alpha: ", d4));
        }
        double d5 = (d % 360.0d) / 360.0d;
        double d6 = dMax / 100.0d;
        double d7 = dMax2 / 100.0d;
        double d8 = d7 < 0.5d ? (d6 + 1.0d) * d7 : (d7 + d6) - (d6 * d7);
        double d9 = (d7 * 2.0d) - d8;
        double d10 = d8;
        return new Color((float) Math.min(Math.max(0.0d, HUE2RGB(d9, d10, d5 + 0.3333333333333333d)), 1.0d), (float) Math.min(Math.max(0.0d, HUE2RGB(d9, d10, d5)), 1.0d), (float) Math.min(Math.max(0.0d, HUE2RGB(d9, d10, d5 - 0.3333333333333333d)), 1.0d), (float) d4);
    }

    private static double HUE2RGB(double d, double d2, double d3) {
        double d4 = d3 < 0.0d ? d3 + 1.0d : d3;
        if (d4 > 1.0d) {
            d4 -= 1.0d;
        }
        double d5 = d4;
        return d5 * 6.0d < 1.0d ? ((d2 - d) * 6.0d * d5) + d : d5 * 2.0d < 1.0d ? d2 : 3.0d * d5 < 2.0d ? AbstractC1974b.m1306C(0.6666666666666666d, d5, (d2 - d) * 6.0d, d) : d;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static double[] RGB2HSL(Color color) {
        double d;
        float[] rGBColorComponents = color.getRGBColorComponents(null);
        double d2 = rGBColorComponents[0];
        double d3 = rGBColorComponents[1];
        double d4 = rGBColorComponents[2];
        double dMin = Math.min(d2, Math.min(d3, d4));
        double dMax = Math.max(d2, Math.max(d3, d4));
        if (dMax != dMin) {
            d = dMax == d2 ? ((((d3 - d4) * 60.0d) / (dMax - dMin)) + 360.0d) % 360.0d : dMax == d3 ? (((d4 - d2) * 60.0d) / (dMax - dMin)) + 120.0d : dMax == d4 ? 240.0d + (((d2 - d3) * 60.0d) / (dMax - dMin)) : 0.0d;
        }
        double d5 = dMax + dMin;
        double d6 = d5 / 2.0d;
        return new double[]{d, (dMax != dMin ? d6 <= 0.5d ? (dMax - dMin) / d5 : (dMax - dMin) / ((2.0d - dMax) - dMin) : 0.0d) * 100.0d, d6 * 100.0d};
    }

    public static Color applyColorTransform(ColorStyle colorStyle) {
        if (colorStyle == null || colorStyle.getColor() == null) {
            return TRANSPARENT;
        }
        Color color = colorStyle.getColor();
        double alpha = getAlpha(color, colorStyle);
        double[] dArrRGB2HSL = RGB2HSL(color);
        applyHslModOff(dArrRGB2HSL, 0, colorStyle.getHueMod(), colorStyle.getHueOff());
        applyHslModOff(dArrRGB2HSL, 1, colorStyle.getSatMod(), colorStyle.getSatOff());
        applyHslModOff(dArrRGB2HSL, 2, colorStyle.getLumMod(), colorStyle.getLumOff());
        applyShade(dArrRGB2HSL, colorStyle);
        applyTint(dArrRGB2HSL, colorStyle);
        return HSL2RGB(dArrRGB2HSL[0], dArrRGB2HSL[1], dArrRGB2HSL[2], alpha);
    }

    private static void applyHslModOff(double[] dArr, int i, int i2, int i4) {
        if (i2 == -1) {
            i2 = 100000;
        }
        if (i4 == -1) {
            i4 = 0;
        }
        if (i2 == 100000 && i4 == 0) {
            return;
        }
        dArr[i] = (dArr[i] * (((double) i2) / 100000.0d)) + (((double) i4) / 1000.0d);
    }

    private static void applyShade(double[] dArr, ColorStyle colorStyle) {
        int shade = colorStyle.getShade();
        if (shade == -1) {
            return;
        }
        dArr[2] = (1.0d - (((double) shade) / 100000.0d)) * dArr[2];
    }

    private static void applyTint(double[] dArr, ColorStyle colorStyle) {
        int tint = colorStyle.getTint();
        if (tint == -1) {
            return;
        }
        double d = 1.0d - (((double) tint) / 100000.0d);
        dArr[2] = (100.0d - (d * 100.0d)) + (dArr[2] * d);
    }

    public static PaintStyle.SolidPaint createSolidPaint(Color color) {
        if (color == null) {
            return null;
        }
        return new SimpleSolidPaint(color);
    }

    private static double getAlpha(Color color, ColorStyle colorStyle) {
        double alpha = ((double) color.getAlpha()) / 255.0d;
        int alpha2 = colorStyle.getAlpha();
        if (alpha2 != -1) {
            alpha *= ((double) alpha2) / 100000.0d;
        }
        return Math.min(1.0d, Math.max(0.0d, alpha));
    }

    public static float lin2srgb(int i) {
        double d = i;
        return (float) (d <= 0.0031308d ? (d / 100000.0d) * 12.92d : (Math.pow(d / 100000.0d, 0.4166666666666667d) * 1.055d) - 0.055d);
    }

    public static int srgb2lin(float f) {
        double d = f;
        return (int) (d <= 0.04045d ? Math.rint((d * 100000.0d) / 12.92d) : Math.rint(Math.pow((d + 0.055d) / 1.055d, 2.4d) * 100000.0d));
    }

    public Paint createLinearGradientPaint(PaintStyle.GradientPaint gradientPaint, Graphics2D graphics2D) {
        double gradientAngle = gradientPaint.getGradientAngle();
        if (!gradientPaint.isRotatedWithShape()) {
            gradientAngle -= this.shape.getRotation();
        }
        Rectangle2D anchor = DrawShape.getAnchor(graphics2D, this.shape);
        double height = anchor.getHeight();
        double width = anchor.getWidth();
        double x = anchor.getX();
        double y2 = anchor.getY();
        AffineTransform rotateInstance = AffineTransform.getRotateInstance(Math.toRadians(gradientAngle), anchor.getCenterX(), anchor.getCenterY());
        double dSqrt = ((width / 2.0d) + x) - (Math.sqrt((width * width) + (height * height)) / 2.0d);
        double d = (height / 2.0d) + y2;
        Point2D point2DTransform = rotateInstance.transform(new Point2D.Double(dSqrt, d), null);
        Point2D point2DTransform2 = rotateInstance.transform(new Point2D.Double(x + width, d), null);
        if (point2DTransform.equals(point2DTransform2)) {
            return null;
        }
        float[] gradientFractions = gradientPaint.getGradientFractions();
        Color[] colorArr = new Color[gradientFractions.length];
        ColorStyle[] gradientColors = gradientPaint.getGradientColors();
        int length = gradientColors.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            ColorStyle colorStyle = gradientColors[i];
            int i4 = i2 + 1;
            colorArr[i2] = colorStyle == null ? TRANSPARENT : applyColorTransform(colorStyle);
            i++;
            i2 = i4;
        }
        return new LinearGradientPaint(point2DTransform, point2DTransform2, gradientFractions, colorArr);
    }

    public Paint createPathGradientPaint(PaintStyle.GradientPaint gradientPaint, Graphics2D graphics2D) {
        float[] gradientFractions = gradientPaint.getGradientFractions();
        Color[] colorArr = new Color[gradientFractions.length];
        ColorStyle[] gradientColors = gradientPaint.getGradientColors();
        int length = gradientColors.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            colorArr[i2] = applyColorTransform(gradientColors[i]);
            i++;
            i2++;
        }
        return new PathGradientPaint(colorArr, gradientFractions);
    }

    public Paint createRadialGradientPaint(PaintStyle.GradientPaint gradientPaint, Graphics2D graphics2D) {
        Rectangle2D anchor = DrawShape.getAnchor(graphics2D, this.shape);
        Point2D.Double r02 = new Point2D.Double((anchor.getWidth() / 2.0d) + anchor.getX(), (anchor.getHeight() / 2.0d) + anchor.getY());
        float fMax = (float) Math.max(anchor.getWidth(), anchor.getHeight());
        float[] gradientFractions = gradientPaint.getGradientFractions();
        Color[] colorArr = new Color[gradientFractions.length];
        ColorStyle[] gradientColors = gradientPaint.getGradientColors();
        int length = gradientColors.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            colorArr[i2] = applyColorTransform(gradientColors[i]);
            i++;
            i2++;
        }
        return new RadialGradientPaint(r02, fMax, gradientFractions, colorArr);
    }

    public Paint getGradientPaint(PaintStyle.GradientPaint gradientPaint, Graphics2D graphics2D) {
        int i = C140652.f10161x425bedb0[gradientPaint.getGradientType().ordinal()];
        if (i == 1) {
            return createLinearGradientPaint(gradientPaint, graphics2D);
        }
        if (i == 2) {
            return createRadialGradientPaint(gradientPaint, graphics2D);
        }
        if (i == 3) {
            return createPathGradientPaint(gradientPaint, graphics2D);
        }
        throw new UnsupportedOperationException("gradient fill of type " + gradientPaint + " not supported.");
    }

    public Paint getPaint(Graphics2D graphics2D, PaintStyle paintStyle) {
        return getPaint(graphics2D, paintStyle, PaintStyle.PaintModifier.NORM);
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [org.apache.poi.java.awt.Color, org.apache.poi.java.awt.Paint] */
    public Paint getSolidPaint(PaintStyle.SolidPaint solidPaint, Graphics2D graphics2D, final PaintStyle.PaintModifier paintModifier) {
        final ColorStyle solidColor = solidPaint.getSolidColor();
        return applyColorTransform(new ColorStyle() { // from class: org.apache.poi.sl.draw.DrawPaint.1
            @Override // org.apache.poi.p226sl.usermodel.ColorStyle
            public int getAlpha() {
                return solidColor.getAlpha();
            }

            @Override // org.apache.poi.p226sl.usermodel.ColorStyle
            public Color getColor() {
                return solidColor.getColor();
            }

            @Override // org.apache.poi.p226sl.usermodel.ColorStyle
            public int getHueMod() {
                return solidColor.getHueMod();
            }

            @Override // org.apache.poi.p226sl.usermodel.ColorStyle
            public int getHueOff() {
                return solidColor.getHueOff();
            }

            @Override // org.apache.poi.p226sl.usermodel.ColorStyle
            public int getLumMod() {
                return solidColor.getLumMod();
            }

            @Override // org.apache.poi.p226sl.usermodel.ColorStyle
            public int getLumOff() {
                return solidColor.getLumOff();
            }

            @Override // org.apache.poi.p226sl.usermodel.ColorStyle
            public int getSatMod() {
                return solidColor.getSatMod();
            }

            @Override // org.apache.poi.p226sl.usermodel.ColorStyle
            public int getSatOff() {
                return solidColor.getSatOff();
            }

            @Override // org.apache.poi.p226sl.usermodel.ColorStyle
            public int getShade() {
                int shade = solidColor.getShade();
                int i = C140652.$SwitchMap$org$apache$poi$sl$usermodel$PaintStyle$PaintModifier[paintModifier.ordinal()];
                return i != 1 ? i != 2 ? shade : Math.min(100000, Math.max(0, shade) + 20000) : Math.min(100000, Math.max(0, shade) + 40000);
            }

            @Override // org.apache.poi.p226sl.usermodel.ColorStyle
            public int getTint() {
                int tint = solidColor.getTint();
                int i = C140652.$SwitchMap$org$apache$poi$sl$usermodel$PaintStyle$PaintModifier[paintModifier.ordinal()];
                return i != 3 ? i != 4 ? tint : Math.min(100000, Math.max(0, tint) + 20000) : Math.min(100000, Math.max(0, tint) + 40000);
            }
        });
    }

    public Paint getTexturePaint(PaintStyle.TexturePaint texturePaint, Graphics2D graphics2D) {
        InputStream imageData = texturePaint.getImageData();
        if (imageData == null) {
            return null;
        }
        ImageRenderer imageRenderer = DrawPictureShape.getImageRenderer(graphics2D, texturePaint.getContentType());
        try {
            try {
                imageRenderer.loadImage(imageData, texturePaint.getContentType());
                int alpha = texturePaint.getAlpha();
                if (alpha >= 0 && alpha < 100000) {
                    imageRenderer.setAlpha(alpha / 100000.0f);
                }
                Rectangle2D anchor = this.shape.getAnchor();
                BufferedImage image = "image/x-wmf".equals(texturePaint.getContentType()) ? imageRenderer.getImage(new Dimension((int) anchor.getWidth(), (int) anchor.getHeight())) : imageRenderer.getImage();
                if (image != null) {
                    return new TexturePaint(image, anchor);
                }
                LOG.log(7, "Can't load image data");
                return null;
            } finally {
                imageData.close();
            }
        } catch (IOException e) {
            LOG.log(7, "Can't load image data - using transparent color", e);
            return null;
        }
    }

    public void snapToAnchor(Point2D point2D, Rectangle2D rectangle2D) {
        if (point2D.getX() < rectangle2D.getX()) {
            point2D.setLocation(rectangle2D.getX(), point2D.getY());
        } else {
            if (point2D.getX() > rectangle2D.getWidth() + rectangle2D.getX()) {
                point2D.setLocation(rectangle2D.getWidth() + rectangle2D.getX(), point2D.getY());
            }
        }
        if (point2D.getY() < rectangle2D.getY()) {
            point2D.setLocation(point2D.getX(), rectangle2D.getY());
            return;
        }
        if (point2D.getY() > rectangle2D.getHeight() + rectangle2D.getY()) {
            point2D.setLocation(point2D.getX(), rectangle2D.getHeight() + rectangle2D.getY());
        }
    }

    public static PaintStyle.SolidPaint createSolidPaint(ColorStyle colorStyle) {
        if (colorStyle == null) {
            return null;
        }
        return new SimpleSolidPaint(colorStyle);
    }

    public Paint getPaint(Graphics2D graphics2D, PaintStyle paintStyle, PaintStyle.PaintModifier paintModifier) {
        if (paintModifier == PaintStyle.PaintModifier.NONE) {
            return null;
        }
        if (paintStyle instanceof PaintStyle.SolidPaint) {
            return getSolidPaint((PaintStyle.SolidPaint) paintStyle, graphics2D, paintModifier);
        }
        if (paintStyle instanceof PaintStyle.GradientPaint) {
            return getGradientPaint((PaintStyle.GradientPaint) paintStyle, graphics2D);
        }
        if (paintStyle instanceof PaintStyle.TexturePaint) {
            return getTexturePaint((PaintStyle.TexturePaint) paintStyle, graphics2D);
        }
        return null;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SimpleSolidPaint implements PaintStyle.SolidPaint {
        private final ColorStyle solidColor;

        public SimpleSolidPaint(final Color color) {
            if (color == null) {
                throw new NullPointerException("Color needs to be specified");
            }
            this.solidColor = new ColorStyle() { // from class: org.apache.poi.sl.draw.DrawPaint.SimpleSolidPaint.1
                @Override // org.apache.poi.p226sl.usermodel.ColorStyle
                public int getAlpha() {
                    return (int) Math.round((((double) color.getAlpha()) * 100000.0d) / 255.0d);
                }

                @Override // org.apache.poi.p226sl.usermodel.ColorStyle
                public Color getColor() {
                    return new Color(color.getRed(), color.getGreen(), color.getBlue());
                }

                @Override // org.apache.poi.p226sl.usermodel.ColorStyle
                public int getHueMod() {
                    return -1;
                }

                @Override // org.apache.poi.p226sl.usermodel.ColorStyle
                public int getHueOff() {
                    return -1;
                }

                @Override // org.apache.poi.p226sl.usermodel.ColorStyle
                public int getLumMod() {
                    return -1;
                }

                @Override // org.apache.poi.p226sl.usermodel.ColorStyle
                public int getLumOff() {
                    return -1;
                }

                @Override // org.apache.poi.p226sl.usermodel.ColorStyle
                public int getSatMod() {
                    return -1;
                }

                @Override // org.apache.poi.p226sl.usermodel.ColorStyle
                public int getSatOff() {
                    return -1;
                }

                @Override // org.apache.poi.p226sl.usermodel.ColorStyle
                public int getShade() {
                    return -1;
                }

                @Override // org.apache.poi.p226sl.usermodel.ColorStyle
                public int getTint() {
                    return -1;
                }
            };
        }

        @Override // org.apache.poi.sl.usermodel.PaintStyle.SolidPaint
        public ColorStyle getSolidColor() {
            return this.solidColor;
        }

        public SimpleSolidPaint(ColorStyle colorStyle) {
            if (colorStyle != null) {
                this.solidColor = colorStyle;
                return;
            }
            throw new NullPointerException("Color needs to be specified");
        }
    }
}
