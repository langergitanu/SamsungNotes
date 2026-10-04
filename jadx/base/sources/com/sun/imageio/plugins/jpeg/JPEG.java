package com.sun.imageio.plugins.jpeg;

import org.apache.poi.java.awt.color.ColorSpace;
import org.apache.poi.java.awt.color.ICC_ColorSpace;
import org.apache.poi.java.awt.image.ColorModel;
import org.apache.poi.javax.imageio.ImageTypeSpecifier;
import org.apache.poi.javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import org.apache.poi.javax.imageio.plugins.jpeg.JPEGQTable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class JPEG {
    public static final int ADOBE_IMPOSSIBLE = -1;
    public static final int ADOBE_UNKNOWN = 0;
    public static final int ADOBE_YCC = 1;
    public static final int ADOBE_YCCK = 2;
    public static final int APP0 = 224;
    public static final int APP1 = 225;
    public static final int APP10 = 234;
    public static final int APP11 = 235;
    public static final int APP12 = 236;
    public static final int APP13 = 237;
    public static final int APP14 = 238;
    public static final int APP15 = 239;
    public static final int APP2 = 226;
    public static final int APP3 = 227;
    public static final int APP4 = 228;
    public static final int APP5 = 229;
    public static final int APP6 = 230;
    public static final int APP7 = 231;
    public static final int APP8 = 232;
    public static final int APP9 = 233;
    public static final int COM = 254;
    public static final int DAC = 204;
    public static final float DEFAULT_QUALITY = 0.75f;
    public static final int DENSITY_UNIT_ASPECT_RATIO = 0;
    public static final int DENSITY_UNIT_DOTS_CM = 2;
    public static final int DENSITY_UNIT_DOTS_INCH = 1;
    public static final int DHP = 222;
    public static final int DHT = 196;
    public static final int DNL = 220;
    public static final int DQT = 219;
    public static final int DRI = 221;
    public static final int EOI = 217;
    public static final int EXP = 223;
    public static final int JCS_CMYK = 4;
    public static final int JCS_GRAYSCALE = 1;
    public static final int JCS_RGB = 2;
    public static final int JCS_RGBA = 6;
    public static final int JCS_UNKNOWN = 0;
    public static final int JCS_YCC = 5;
    public static final int JCS_YCCA = 10;
    public static final int JCS_YCCK = 11;
    public static final int JCS_YCbCr = 3;
    public static final int JCS_YCbCrA = 7;
    public static final int JPG = 200;
    public static final int NUM_DENSITY_UNIT = 3;
    public static final int NUM_JCS_CODES = 12;
    public static final int RESTART_RANGE = 8;
    public static final int RST0 = 208;
    public static final int RST1 = 209;
    public static final int RST2 = 210;
    public static final int RST3 = 211;
    public static final int RST4 = 212;
    public static final int RST5 = 213;
    public static final int RST6 = 214;
    public static final int RST7 = 215;
    public static final int SOF0 = 192;
    public static final int SOF1 = 193;
    public static final int SOF10 = 202;
    public static final int SOF11 = 203;
    public static final int SOF13 = 205;
    public static final int SOF14 = 206;
    public static final int SOF15 = 207;
    public static final int SOF2 = 194;
    public static final int SOF3 = 195;
    public static final int SOF5 = 197;
    public static final int SOF6 = 198;
    public static final int SOF7 = 199;
    public static final int SOF9 = 201;
    public static final int SOI = 216;
    public static final int SOS = 218;
    public static final int TEM = 1;
    public static final String nativeImageMetadataFormatClassName = "com.sun.imageio.plugins.jpeg.JPEGImageMetadataFormat";
    public static final String nativeImageMetadataFormatName = "javax_imageio_jpeg_image_1.0";
    public static final String nativeStreamMetadataFormatClassName = "com.sun.imageio.plugins.jpeg.JPEGStreamMetadataFormat";
    public static final String nativeStreamMetadataFormatName = "javax_imageio_jpeg_stream_1.0";
    public static final String vendor = "Oracle Corporation";
    public static final String version = "0.5";
    static final String[] names = {"JPEG", "jpeg", "JPG", "jpg"};
    static final String[] suffixes = {"jpg", "jpeg"};
    static final String[] MIMETypes = {"image/jpeg"};
    static final int[][] bandOffsets = {new int[]{0}, new int[]{0, 1}, new int[]{0, 1, 2}, new int[]{0, 1, 2, 3}};
    static final int[] bOffsRGB = {2, 1, 0};

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class JCS {
        public static final ColorSpace sRGB = ColorSpace.getInstance(1000);
        private static ColorSpace YCC = null;
        private static boolean yccInited = false;

        public static ColorSpace getYCC() {
            if (!yccInited) {
                try {
                    YCC = ColorSpace.getInstance(1002);
                } catch (IllegalArgumentException unused) {
                } catch (Throwable th) {
                    yccInited = true;
                    throw th;
                }
                yccInited = true;
            }
            return YCC;
        }
    }

    public static float convertToLinearQuality(float f) {
        if (f <= 0.0f) {
            f = 0.01f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        return f < 0.5f ? 0.5f / f : 2.0f - (f * 2.0f);
    }

    public static JPEGHuffmanTable[] getDefaultHuffmanTables(boolean z) {
        JPEGHuffmanTable[] jPEGHuffmanTableArr = new JPEGHuffmanTable[2];
        if (z) {
            jPEGHuffmanTableArr[0] = JPEGHuffmanTable.StdDCLuminance;
            jPEGHuffmanTableArr[1] = JPEGHuffmanTable.StdDCChrominance;
            return jPEGHuffmanTableArr;
        }
        jPEGHuffmanTableArr[0] = JPEGHuffmanTable.StdACLuminance;
        jPEGHuffmanTableArr[1] = JPEGHuffmanTable.StdACChrominance;
        return jPEGHuffmanTableArr;
    }

    public static JPEGQTable[] getDefaultQTables() {
        return new JPEGQTable[]{JPEGQTable.K1Div2Luminance, JPEGQTable.K2Div2Chrominance};
    }

    public static boolean isJFIFcompliant(ImageTypeSpecifier imageTypeSpecifier, boolean z) {
        ColorModel colorModel = imageTypeSpecifier.getColorModel();
        if (colorModel.hasAlpha()) {
            return false;
        }
        int numComponents = imageTypeSpecifier.getNumComponents();
        if (numComponents == 1) {
            return true;
        }
        if (numComponents != 3) {
            return false;
        }
        if (z) {
            if (colorModel.getColorSpace().getType() == 5) {
                return true;
            }
        } else if (colorModel.getColorSpace().getType() == 3) {
            return true;
        }
        return false;
    }

    public static boolean isNonStandardICC(ColorSpace colorSpace) {
        return (!(colorSpace instanceof ICC_ColorSpace) || colorSpace.isCS_sRGB() || colorSpace.equals(ColorSpace.getInstance(1001)) || colorSpace.equals(ColorSpace.getInstance(1003)) || colorSpace.equals(ColorSpace.getInstance(1004)) || colorSpace.equals(ColorSpace.getInstance(1002))) ? false : true;
    }

    public static int transformForType(ImageTypeSpecifier imageTypeSpecifier, boolean z) {
        int type = imageTypeSpecifier.getColorModel().getColorSpace().getType();
        if (type != 3) {
            return type != 9 ? type != 5 ? type != 6 ? -1 : 0 : z ? 1 : 0 : z ? 2 : -1;
        }
        return 1;
    }
}
