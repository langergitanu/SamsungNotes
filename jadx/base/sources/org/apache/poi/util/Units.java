package org.apache.poi.util;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class Units {
    public static final float DEFAULT_CHARACTER_WIDTH = 7.0017f;
    public static final int EMU_PER_CENTIMETER = 360000;
    public static final int EMU_PER_CHARACTER = 66691;
    public static final int EMU_PER_PIXEL = 9525;
    public static final int EMU_PER_POINT = 12700;
    public static final int MASTER_DPI = 576;
    public static final int PIXEL_DPI = 96;
    public static final int POINT_DPI = 72;

    public static int TwipsToEMU(short s) {
        return (int) ((((double) s) / 20.0d) * 12700.0d);
    }

    public static int charactersToEMU(double d) {
        return ((int) d) * EMU_PER_CHARACTER;
    }

    public static int columnWidthToEMU(int i) {
        return charactersToEMU(((double) i) / 256.0d);
    }

    public static int doubleToFixedPoint(double d) {
        double d2 = d % 1.0d;
        return (((int) Math.floor(d - d2)) << 16) | (((int) Math.rint(d2 * 65536.0d)) & 65535);
    }

    public static double fixedPointToDouble(int i) {
        return (((double) (i & 65535)) / 65536.0d) + ((double) (i >> 16));
    }

    public static double masterToPoints(int i) {
        return (((double) i) * 72.0d) / 576.0d;
    }

    public static int pixelToEMU(int i) {
        return i * EMU_PER_PIXEL;
    }

    public static double pixelToPoints(int i) {
        return (((double) i) * 72.0d) / 96.0d;
    }

    public static int pointsToMaster(double d) {
        return (int) Math.rint((d * 576.0d) / 72.0d);
    }

    public static int pointsToPixel(double d) {
        return (int) Math.rint((d * 96.0d) / 72.0d);
    }

    public static int toEMU(double d) {
        return (int) Math.rint(d * 12700.0d);
    }

    public static double toPoints(long j) {
        return j / 12700.0d;
    }
}
