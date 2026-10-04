package org.apache.poi.java.awt;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import java.beans.ConstructorProperties;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class Color {
    public static final Color BLACK;
    public static final Color BLUE;
    public static final Color CYAN;
    public static final Color DARK_GRAY;
    private static final double FACTOR = 0.7d;
    public static final Color GRAY;
    public static final Color GREEN;
    public static final Color LIGHT_GRAY;
    public static final Color MAGENTA;
    public static final Color ORANGE;
    public static final Color PINK;
    public static final Color RED;
    public static final Color WHITE;
    public static final Color YELLOW;
    public static final Color black;
    public static final Color blue;
    public static final Color cyan;
    public static final Color darkGray;
    public static final Color gray;
    public static final Color green;
    public static final Color lightGray;
    public static final Color magenta;
    public static final Color orange;
    public static final Color pink;
    public static final Color red;
    public static final Color white;
    public static final Color yellow;
    private float falpha;
    private float[] frgbvalue;
    private float[] fvalue;
    int value;

    static {
        Color color = new Color(255, 255, 255);
        white = color;
        WHITE = color;
        Color color2 = new Color(192, 192, 192);
        lightGray = color2;
        LIGHT_GRAY = color2;
        Color color3 = new Color(128, 128, 128);
        gray = color3;
        GRAY = color3;
        Color color4 = new Color(64, 64, 64);
        darkGray = color4;
        DARK_GRAY = color4;
        Color color5 = new Color(0, 0, 0);
        black = color5;
        BLACK = color5;
        Color color6 = new Color(255, 0, 0);
        red = color6;
        RED = color6;
        Color color7 = new Color(255, 175, 175);
        pink = color7;
        PINK = color7;
        Color color8 = new Color(255, 200, 0);
        orange = color8;
        ORANGE = color8;
        Color color9 = new Color(255, 255, 0);
        yellow = color9;
        YELLOW = color9;
        Color color10 = new Color(0, 255, 0);
        green = color10;
        GREEN = color10;
        Color color11 = new Color(255, 0, 255);
        magenta = color11;
        MAGENTA = color11;
        Color color12 = new Color(0, 255, 255);
        cyan = color12;
        CYAN = color12;
        Color color13 = new Color(0, 0, 255);
        blue = color13;
        BLUE = color13;
    }

    public Color(int i, int i2, int i4) {
        this(i, i2, i4, 255);
    }

    public static int HSBtoRGB(float f, float f4, float f5) {
        int i;
        int i2;
        int i4;
        if (f4 != 0.0f) {
            float fFloor = (f - ((float) Math.floor(f))) * 6.0f;
            float fFloor2 = fFloor - ((float) Math.floor(fFloor));
            float f6 = (1.0f - f4) * f5;
            float fM1309b = AbstractC1974b.m1309b(f4, fFloor2, 1.0f, f5);
            float f7 = (1.0f - ((1.0f - fFloor2) * f4)) * f5;
            int i5 = (int) fFloor;
            if (i5 == 0) {
                i = (int) ((f5 * 255.0f) + 0.5f);
                i2 = (int) ((f7 * 255.0f) + 0.5f);
            } else {
                if (i5 != 1) {
                    if (i5 != 2) {
                        if (i5 == 3) {
                            i = (int) ((f6 * 255.0f) + 0.5f);
                            i2 = (int) ((fM1309b * 255.0f) + 0.5f);
                        } else if (i5 == 4) {
                            i = (int) ((f7 * 255.0f) + 0.5f);
                            i2 = (int) ((f6 * 255.0f) + 0.5f);
                        } else if (i5 != 5) {
                            i = 0;
                        } else {
                            i = (int) ((f5 * 255.0f) + 0.5f);
                            i2 = (int) ((f6 * 255.0f) + 0.5f);
                            i4 = (int) ((fM1309b * 255.0f) + 0.5f);
                        }
                        i4 = (int) ((f5 * 255.0f) + 0.5f);
                    } else {
                        i = (int) ((f6 * 255.0f) + 0.5f);
                        i2 = (int) ((f5 * 255.0f) + 0.5f);
                        i4 = (int) ((f7 * 255.0f) + 0.5f);
                    }
                    return (i << 16) | (-16777216) | (i2 << 8) | i4;
                }
                i = (int) ((fM1309b * 255.0f) + 0.5f);
                i2 = (int) ((f5 * 255.0f) + 0.5f);
            }
            i4 = (int) ((f6 * 255.0f) + 0.5f);
            return (i << 16) | (-16777216) | (i2 << 8) | i4;
        }
        i = (int) ((f5 * 255.0f) + 0.5f);
        i2 = i;
        i4 = i2;
        return (i << 16) | (-16777216) | (i2 << 8) | i4;
    }

    public static float[] RGBtoHSB(int i, int i2, int i4, float[] fArr) {
        if (fArr == null) {
            fArr = new float[3];
        }
        int i5 = i > i2 ? i : i2;
        if (i4 > i5) {
            i5 = i4;
        }
        int i6 = i < i2 ? i : i2;
        if (i4 < i6) {
            i6 = i4;
        }
        float f = i5;
        float f4 = f / 255.0f;
        float f5 = 0.0f;
        float f6 = i5 != 0 ? (i5 - i6) / f : 0.0f;
        if (f6 != 0.0f) {
            float f7 = i5 - i6;
            float f8 = (i5 - i) / f7;
            float f9 = (i5 - i2) / f7;
            float f10 = (i5 - i4) / f7;
            float f11 = (i == i5 ? f10 - f9 : i2 == i5 ? (f8 + 2.0f) - f10 : (f9 + 4.0f) - f8) / 6.0f;
            f5 = f11 < 0.0f ? f11 + 1.0f : f11;
        }
        fArr[0] = f5;
        fArr[1] = f6;
        fArr[2] = f4;
        return fArr;
    }

    public static Color decode(String str) {
        int iIntValue = Integer.decode(str).intValue();
        return new Color((iIntValue >> 16) & 255, (iIntValue >> 8) & 255, iIntValue & 255);
    }

    public static Color getColor(String str) {
        return getColor(str, (Color) null);
    }

    public static Color getHSBColor(float f, float f4, float f5) {
        return new Color(HSBtoRGB(f, f4, f5));
    }

    private static void testColorValueRange(int i, int i2, int i4, int i5) {
        String strM756B;
        boolean z;
        if (i5 < 0 || i5 > 255) {
            strM756B = " Alpha";
            z = true;
        } else {
            z = false;
            strM756B = "";
        }
        if (i < 0 || i > 255) {
            strM756B = AbstractC0541b.m756B(strM756B, " Red");
            z = true;
        }
        if (i2 < 0 || i2 > 255) {
            strM756B = AbstractC0541b.m756B(strM756B, " Green");
            z = true;
        }
        if (i4 < 0 || i4 > 255) {
            strM756B = AbstractC0541b.m756B(strM756B, " Blue");
            z = true;
        }
        if (z) {
            throw new IllegalArgumentException(AbstractC0541b.m772n("Color parameter outside of expected range:", strM756B));
        }
    }

    public Color brighter() {
        int red2 = getRed();
        int green2 = getGreen();
        int blue2 = getBlue();
        int alpha = getAlpha();
        if (red2 == 0 && green2 == 0 && blue2 == 0) {
            return new Color(3, 3, 3, alpha);
        }
        if (red2 > 0 && red2 < 3) {
            red2 = 3;
        }
        if (green2 > 0 && green2 < 3) {
            green2 = 3;
        }
        if (blue2 > 0 && blue2 < 3) {
            blue2 = 3;
        }
        return new Color(Math.min((int) (((double) red2) / FACTOR), 255), Math.min((int) (((double) green2) / FACTOR), 255), Math.min((int) (((double) blue2) / FACTOR), 255), alpha);
    }

    public Color darker() {
        return new Color(Math.max((int) (((double) getRed()) * FACTOR), 0), Math.max((int) (((double) getGreen()) * FACTOR), 0), Math.max((int) (((double) getBlue()) * FACTOR), 0), getAlpha());
    }

    public boolean equals(Object obj) {
        return (obj instanceof Color) && ((Color) obj).getRGB() == getRGB();
    }

    public int getAlpha() {
        return (getRGB() >> 24) & 255;
    }

    public int getBlue() {
        return getRGB() & 255;
    }

    public float[] getColorComponents(float[] fArr) {
        float[] fArr2 = this.fvalue;
        if (fArr2 == null) {
            return getRGBColorComponents(fArr);
        }
        int length = fArr2.length;
        if (fArr == null) {
            fArr = new float[length];
        }
        for (int i = 0; i < length; i++) {
            fArr[i] = this.fvalue[i];
        }
        return fArr;
    }

    public float[] getComponents(float[] fArr) {
        float[] fArr2 = this.fvalue;
        if (fArr2 == null) {
            return getRGBComponents(fArr);
        }
        int length = fArr2.length;
        if (fArr == null) {
            fArr = new float[length + 1];
        }
        for (int i = 0; i < length; i++) {
            fArr[i] = this.fvalue[i];
        }
        fArr[length] = this.falpha;
        return fArr;
    }

    public int getGreen() {
        return (getRGB() >> 8) & 255;
    }

    public int getRGB() {
        return this.value;
    }

    public float[] getRGBColorComponents(float[] fArr) {
        if (fArr == null) {
            fArr = new float[3];
        }
        float[] fArr2 = this.frgbvalue;
        if (fArr2 == null) {
            fArr[0] = getRed() / 255.0f;
            fArr[1] = getGreen() / 255.0f;
            fArr[2] = getBlue() / 255.0f;
            return fArr;
        }
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        fArr[2] = fArr2[2];
        return fArr;
    }

    public float[] getRGBComponents(float[] fArr) {
        if (fArr == null) {
            fArr = new float[4];
        }
        float[] fArr2 = this.frgbvalue;
        if (fArr2 == null) {
            fArr[0] = getRed() / 255.0f;
            fArr[1] = getGreen() / 255.0f;
            fArr[2] = getBlue() / 255.0f;
            fArr[3] = getAlpha() / 255.0f;
            return fArr;
        }
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        fArr[2] = fArr2[2];
        fArr[3] = this.falpha;
        return fArr;
    }

    public int getRed() {
        return (getRGB() >> 16) & 255;
    }

    public int hashCode() {
        return this.value;
    }

    public String toString() {
        return getClass().getName() + "[r=" + getRed() + ",g=" + getGreen() + ",b=" + getBlue() + "]";
    }

    @ConstructorProperties({"red", "green", "blue", "alpha"})
    public Color(int i, int i2, int i4, int i5) {
        this.frgbvalue = null;
        this.fvalue = null;
        this.falpha = 0.0f;
        this.value = ((i5 & 255) << 24) | ((i & 255) << 16) | ((i2 & 255) << 8) | (i4 & 255);
        testColorValueRange(i, i2, i4, i5);
    }

    public static Color getColor(String str, Color color) {
        Integer integer = Integer.getInteger(str);
        if (integer == null) {
            return color;
        }
        int iIntValue = integer.intValue();
        return new Color((iIntValue >> 16) & 255, (iIntValue >> 8) & 255, iIntValue & 255);
    }

    public static Color getColor(String str, int i) {
        Integer integer = Integer.getInteger(str);
        if (integer != null) {
            i = integer.intValue();
        }
        return new Color((i >> 16) & 255, (i >> 8) & 255, i & 255);
    }

    public Color(int i) {
        this.frgbvalue = null;
        this.fvalue = null;
        this.falpha = 0.0f;
        this.value = i | (-16777216);
    }

    public Color(int i, boolean z) {
        this.frgbvalue = null;
        this.fvalue = null;
        this.falpha = 0.0f;
        if (z) {
            this.value = i;
        } else {
            this.value = i | (-16777216);
        }
    }

    public Color(float f, float f4, float f5) {
        this((int) (((double) (f * 255.0f)) + 0.5d), (int) (((double) (f4 * 255.0f)) + 0.5d), (int) (((double) (255.0f * f5)) + 0.5d));
        testColorValueRange(f, f4, f5, 1.0f);
        float[] fArr = {f, f4, f5};
        this.frgbvalue = fArr;
        this.falpha = 1.0f;
        this.fvalue = fArr;
    }

    public Color(float f, float f4, float f5, float f6) {
        this((int) (((double) (f * 255.0f)) + 0.5d), (int) (((double) (f4 * 255.0f)) + 0.5d), (int) (((double) (f5 * 255.0f)) + 0.5d), (int) (((double) (255.0f * f6)) + 0.5d));
        float[] fArr = {f, f4, f5};
        this.frgbvalue = fArr;
        this.falpha = f6;
        this.fvalue = fArr;
    }

    private static void testColorValueRange(float f, float f4, float f5, float f6) {
        String strM756B;
        boolean z;
        double d = f6;
        if (d >= 0.0d && d <= 1.0d) {
            z = false;
            strM756B = "";
        } else {
            strM756B = " Alpha";
            z = true;
        }
        double d2 = f;
        if (d2 < 0.0d || d2 > 1.0d) {
            strM756B = AbstractC0541b.m756B(strM756B, " Red");
            z = true;
        }
        double d3 = f4;
        if (d3 < 0.0d || d3 > 1.0d) {
            strM756B = AbstractC0541b.m756B(strM756B, " Green");
            z = true;
        }
        double d4 = f5;
        if (d4 < 0.0d || d4 > 1.0d) {
            strM756B = AbstractC0541b.m756B(strM756B, " Blue");
            z = true;
        }
        if (z) {
            throw new IllegalArgumentException(AbstractC0541b.m772n("Color parameter outside of expected range:", strM756B));
        }
    }
}
