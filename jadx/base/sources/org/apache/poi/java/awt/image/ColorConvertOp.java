package org.apache.poi.java.awt.image;

import java.util.Hashtable;
import kotlin.UShort;
import org.apache.poi.java.awt.Graphics2D;
import org.apache.poi.java.awt.Point;
import org.apache.poi.java.awt.RenderingHints;
import org.apache.poi.java.awt.color.ColorSpace;
import org.apache.poi.java.awt.color.ICC_ColorSpace;
import org.apache.poi.java.awt.color.ICC_Profile;
import org.apache.poi.java.awt.geom.Point2D;
import org.apache.poi.java.awt.geom.Rectangle2D;
import org.apache.poi.sun.java2d.cmm.CMSManager;
import org.apache.poi.sun.java2d.cmm.ColorTransform;
import org.apache.poi.sun.java2d.cmm.PCMM;
import org.apache.poi.sun.java2d.cmm.ProfileDeferralMgr;

/* JADX INFO: loaded from: classes10.dex */
public class ColorConvertOp implements BufferedImageOp, RasterOp {
    ColorSpace[] CSList;
    float[] dstMaxVals;
    float[] dstMinVals;
    boolean gotProfiles;
    RenderingHints hints;
    ICC_Profile[] profileList;
    float[] srcMaxVals;
    float[] srcMinVals;
    ICC_Profile thisDestProfile;
    ColorTransform thisRasterTransform;
    ICC_Profile thisSrcProfile;
    ColorTransform thisTransform;

    static {
        if (ProfileDeferralMgr.deferring) {
            ProfileDeferralMgr.activateProfiles();
        }
    }

    public ColorConvertOp(RenderingHints renderingHints) {
        this.profileList = new ICC_Profile[0];
        this.hints = renderingHints;
    }

    private final BufferedImage ICCBIFilter(BufferedImage bufferedImage, ColorSpace colorSpace, BufferedImage bufferedImage2, ColorSpace colorSpace2) {
        BufferedImage bufferedImageCreateCompatibleDestImage;
        ICC_Profile iCC_Profile;
        int length = this.profileList.length;
        ICC_Profile profile = ((ICC_ColorSpace) colorSpace).getProfile();
        if (bufferedImage2 == null) {
            if (length == 0) {
                throw new IllegalArgumentException("Destination ColorSpace is undefined");
            }
            iCC_Profile = this.profileList[length - 1];
            bufferedImageCreateCompatibleDestImage = createCompatibleDestImage(bufferedImage, null);
        } else {
            if (bufferedImage.getHeight() != bufferedImage2.getHeight() || bufferedImage.getWidth() != bufferedImage2.getWidth()) {
                throw new IllegalArgumentException("Width or height of BufferedImages do not match");
            }
            ICC_Profile profile2 = ((ICC_ColorSpace) colorSpace2).getProfile();
            bufferedImageCreateCompatibleDestImage = bufferedImage2;
            iCC_Profile = profile2;
        }
        if (profile == iCC_Profile) {
            for (int i = 0; i < length; i++) {
                if (profile == this.profileList[i]) {
                }
            }
            Graphics2D graphics2DCreateGraphics = bufferedImageCreateCompatibleDestImage.createGraphics();
            try {
                graphics2DCreateGraphics.drawImage(bufferedImage, 0, 0, (ImageObserver) null);
                return bufferedImageCreateCompatibleDestImage;
            } finally {
                graphics2DCreateGraphics.dispose();
            }
        }
        if (this.thisTransform == null || this.thisSrcProfile != profile || this.thisDestProfile != iCC_Profile) {
            updateBITransform(profile, iCC_Profile);
        }
        this.thisTransform.colorConvert(bufferedImage, bufferedImageCreateCompatibleDestImage);
        return bufferedImageCreateCompatibleDestImage;
    }

    private void getMinMaxValsFromColorSpaces(ColorSpace colorSpace, ColorSpace colorSpace2) {
        int numComponents = colorSpace.getNumComponents();
        this.srcMinVals = new float[numComponents];
        this.srcMaxVals = new float[numComponents];
        for (int i = 0; i < numComponents; i++) {
            this.srcMinVals[i] = colorSpace.getMinValue(i);
            this.srcMaxVals[i] = colorSpace.getMaxValue(i);
        }
        int numComponents2 = colorSpace2.getNumComponents();
        this.dstMinVals = new float[numComponents2];
        this.dstMaxVals = new float[numComponents2];
        for (int i2 = 0; i2 < numComponents2; i2++) {
            this.dstMinVals[i2] = colorSpace2.getMinValue(i2);
            this.dstMaxVals[i2] = colorSpace2.getMaxValue(i2);
        }
    }

    private void getMinMaxValsFromProfiles(ICC_Profile iCC_Profile, ICC_Profile iCC_Profile2) {
        int colorSpaceType = iCC_Profile.getColorSpaceType();
        int numComponents = iCC_Profile.getNumComponents();
        float[] fArr = new float[numComponents];
        this.srcMinVals = fArr;
        float[] fArr2 = new float[numComponents];
        this.srcMaxVals = fArr2;
        setMinMax(colorSpaceType, numComponents, fArr, fArr2);
        int colorSpaceType2 = iCC_Profile2.getColorSpaceType();
        int numComponents2 = iCC_Profile2.getNumComponents();
        float[] fArr3 = new float[numComponents2];
        this.dstMinVals = fArr3;
        float[] fArr4 = new float[numComponents2];
        this.dstMaxVals = fArr4;
        setMinMax(colorSpaceType2, numComponents2, fArr3, fArr4);
    }

    private int getRenderingIntent(ICC_Profile iCC_Profile) {
        byte[] data = iCC_Profile.getData(ICC_Profile.icSigHead);
        return (data[67] & 255) | ((data[64] & 255) << 24) | ((data[65] & 255) << 16) | ((data[66] & 255) << 8);
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0102 A[PHI: r8
      0x0102: PHI (r8v9 int) = (r8v6 int), (r8v10 int) binds: [B:56:0x0107, B:51:0x00ff] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0122  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final BufferedImage nonICCBIFilter(BufferedImage bufferedImage, ColorSpace colorSpace, BufferedImage bufferedImage2, ColorSpace colorSpace2) {
        BufferedImage bufferedImageCreateCompatibleDestImage;
        ColorSpace colorSpace3;
        BufferedImage bufferedImage3;
        ICC_Profile profile;
        boolean z;
        ICC_Profile profile2;
        ColorSpace colorSpace4;
        int i;
        ColorSpace colorSpace5;
        int i2;
        int i4;
        int i5;
        int i6;
        ColorSpace colorSpace6 = colorSpace;
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        ICC_ColorSpace iCC_ColorSpace = (ICC_ColorSpace) ColorSpace.getInstance(1001);
        if (bufferedImage2 == null) {
            bufferedImageCreateCompatibleDestImage = createCompatibleDestImage(bufferedImage, null);
            colorSpace3 = bufferedImageCreateCompatibleDestImage.getColorModel().getColorSpace();
        } else {
            if (height != bufferedImage2.getHeight() || width != bufferedImage2.getWidth()) {
                throw new IllegalArgumentException("Width or height of BufferedImages do not match");
            }
            bufferedImageCreateCompatibleDestImage = bufferedImage2;
            colorSpace3 = colorSpace2;
        }
        WritableRaster raster = bufferedImage.getRaster();
        WritableRaster raster2 = bufferedImageCreateCompatibleDestImage.getRaster();
        ColorModel colorModel = bufferedImage.getColorModel();
        ColorModel colorModel2 = bufferedImageCreateCompatibleDestImage.getColorModel();
        int numColorComponents = colorModel.getNumColorComponents();
        int numColorComponents2 = colorModel2.getNumColorComponents();
        boolean zHasAlpha = colorModel2.hasAlpha();
        boolean z2 = true;
        boolean z3 = colorModel.hasAlpha() && zHasAlpha;
        ColorSpace[] colorSpaceArr = this.CSList;
        if (colorSpaceArr != null || this.profileList.length == 0) {
            int i7 = height;
            bufferedImage3 = bufferedImageCreateCompatibleDestImage;
            boolean z4 = z3;
            int length = colorSpaceArr == null ? 0 : colorSpaceArr.length;
            float[] fArr = zHasAlpha ? new float[numColorComponents2 + 1] : new float[numColorComponents2];
            Object dataElements = null;
            Object dataElements2 = null;
            int i8 = 0;
            float[] fArr2 = null;
            while (true) {
                int i9 = i7;
                if (i8 >= i9) {
                    break;
                }
                i7 = i9;
                float[] normalizedComponents = fArr2;
                int i10 = 0;
                while (i10 < width) {
                    dataElements2 = raster.getDataElements(i10, i8, dataElements2);
                    int i11 = width;
                    normalizedComponents = colorModel.getNormalizedComponents(dataElements2, normalizedComponents, 0);
                    float[] ciexyz = colorSpace6.toCIEXYZ(normalizedComponents);
                    int i12 = 0;
                    while (i12 < length) {
                        int i13 = i12;
                        ciexyz = this.CSList[i13].toCIEXYZ(this.CSList[i13].fromCIEXYZ(ciexyz));
                        i12 = i13 + 1;
                    }
                    float[] fArrFromCIEXYZ = colorSpace3.fromCIEXYZ(ciexyz);
                    for (int i14 = 0; i14 < numColorComponents2; i14++) {
                        fArr[i14] = fArrFromCIEXYZ[i14];
                    }
                    if (z4) {
                        fArr[numColorComponents2] = normalizedComponents[numColorComponents];
                    } else if (zHasAlpha) {
                        fArr[numColorComponents2] = 1.0f;
                    }
                    dataElements = colorModel2.getDataElements(fArr, 0, dataElements);
                    raster2.setDataElements(i10, i8, dataElements);
                    i10++;
                    colorSpace6 = colorSpace;
                    width = i11;
                }
                i8++;
                colorSpace6 = colorSpace;
                fArr2 = normalizedComponents;
                width = width;
            }
        } else {
            if (colorSpace6 instanceof ICC_ColorSpace) {
                profile = ((ICC_ColorSpace) colorSpace6).getProfile();
                z = false;
            } else {
                profile = iCC_ColorSpace.getProfile();
                z = true;
            }
            ICC_Profile iCC_Profile = profile;
            if (colorSpace3 instanceof ICC_ColorSpace) {
                profile2 = ((ICC_ColorSpace) colorSpace3).getProfile();
                z2 = false;
            } else {
                profile2 = iCC_ColorSpace.getProfile();
            }
            bufferedImage3 = bufferedImageCreateCompatibleDestImage;
            if (this.thisTransform == null || this.thisSrcProfile != iCC_Profile || this.thisDestProfile != profile2) {
                updateBITransform(iCC_Profile, profile2);
            }
            if (z) {
                colorSpace4 = iCC_ColorSpace;
                i = 3;
            } else {
                colorSpace4 = colorSpace6;
                i = numColorComponents;
            }
            float[] fArr3 = new float[i];
            float[] fArr4 = new float[i];
            for (int i15 = 0; i15 < numColorComponents; i15++) {
                fArr3[i15] = colorSpace4.getMinValue(i15);
                fArr4[i15] = 65535.0f / (colorSpace4.getMaxValue(i15) - fArr3[i15]);
            }
            if (z2) {
                colorSpace5 = iCC_ColorSpace;
                i2 = 3;
            } else {
                colorSpace5 = colorSpace3;
                i2 = numColorComponents2;
            }
            float[] fArr5 = new float[i2];
            float[] fArr6 = new float[i2];
            for (int i16 = 0; i16 < numColorComponents2; i16++) {
                fArr5[i16] = colorSpace5.getMinValue(i16);
                fArr6[i16] = (colorSpace5.getMaxValue(i16) - fArr5[i16]) / 65535.0f;
            }
            if (zHasAlpha) {
                i5 = numColorComponents2 + 1;
                i4 = 3;
                if (i5 <= 3) {
                    i5 = i4;
                }
                float[] fArr7 = new float[i5];
                short[] sArr = new short[width * i];
                short[] sArr2 = new short[width * i2];
                float[] fArr8 = !z3 ? new float[width] : null;
                i6 = 0;
                while (i6 < height) {
                    int i17 = height;
                    WritableRaster writableRaster = raster2;
                    boolean z5 = z3;
                    Object dataElements3 = null;
                    float[] normalizedComponents2 = null;
                    int i18 = 0;
                    int i19 = 0;
                    while (i18 < width) {
                        dataElements3 = raster.getDataElements(i18, i6, dataElements3);
                        int i20 = i18;
                        normalizedComponents2 = colorModel.getNormalizedComponents(dataElements3, normalizedComponents2, 0);
                        if (z5) {
                            fArr8[i20] = normalizedComponents2[numColorComponents];
                        }
                        if (z) {
                            normalizedComponents2 = colorSpace6.toCIEXYZ(normalizedComponents2);
                        }
                        int i21 = 0;
                        while (i21 < i) {
                            sArr[i19] = (short) (((normalizedComponents2[i21] - fArr3[i21]) * fArr4[i21]) + 0.5f);
                            i21++;
                            i19++;
                            dataElements3 = dataElements3;
                        }
                        i18 = i20 + 1;
                    }
                    this.thisTransform.colorConvert(sArr, sArr2);
                    int i22 = 0;
                    int i23 = 0;
                    Object dataElements4 = null;
                    while (i22 < width) {
                        int i24 = i23;
                        int i25 = 0;
                        while (i25 < i2) {
                            fArr7[i25] = ((sArr2[i24] & UShort.MAX_VALUE) * fArr6[i25]) + fArr5[i25];
                            i25++;
                            i24++;
                            i = i;
                        }
                        int i26 = i;
                        if (z2) {
                            float[] fArrFromCIEXYZ2 = colorSpace6.fromCIEXYZ(fArr7);
                            for (int i27 = 0; i27 < numColorComponents2; i27++) {
                                fArr7[i27] = fArrFromCIEXYZ2[i27];
                            }
                        }
                        if (z5) {
                            fArr7[numColorComponents2] = fArr8[i22];
                        } else if (zHasAlpha) {
                            fArr7[numColorComponents2] = 1.0f;
                        }
                        dataElements4 = colorModel2.getDataElements(fArr7, 0, dataElements4);
                        writableRaster.setDataElements(i22, i6, dataElements4);
                        i22++;
                        i23 = i24;
                        i = i26;
                    }
                    raster2 = writableRaster;
                    i6++;
                    z3 = z5;
                    height = i17;
                }
            } else {
                i4 = 3;
                if (numColorComponents2 > 3) {
                    i5 = numColorComponents2;
                }
                float[] fArr72 = new float[i5];
                short[] sArr3 = new short[width * i];
                short[] sArr22 = new short[width * i2];
                float[] fArr82 = !z3 ? new float[width] : null;
                i6 = 0;
                while (i6 < height) {
                }
            }
        }
        return bufferedImage3;
    }

    private final WritableRaster nonICCRasterFilter(Raster raster, WritableRaster writableRaster) {
        WritableRaster writableRasterCreateCompatibleDestRaster;
        int i;
        float[] fArr;
        int i2;
        int i4 = 2;
        if (this.CSList.length != 2) {
            throw new IllegalArgumentException("Destination ColorSpace is undefined");
        }
        int i5 = 0;
        if (raster.getNumBands() != this.CSList[0].getNumComponents()) {
            throw new IllegalArgumentException("Numbers of source Raster bands and source color space components do not match");
        }
        if (writableRaster == null) {
            writableRasterCreateCompatibleDestRaster = createCompatibleDestRaster(raster);
        } else {
            if (raster.getHeight() != writableRaster.getHeight() || raster.getWidth() != writableRaster.getWidth()) {
                throw new IllegalArgumentException("Width or height of Rasters do not match");
            }
            if (writableRaster.getNumBands() != this.CSList[1].getNumComponents()) {
                throw new IllegalArgumentException("Numbers of destination Raster bands and destination color space components do not match");
            }
            writableRasterCreateCompatibleDestRaster = writableRaster;
        }
        if (this.srcMinVals == null) {
            ColorSpace[] colorSpaceArr = this.CSList;
            getMinMaxValsFromColorSpaces(colorSpaceArr[0], colorSpaceArr[1]);
        }
        SampleModel sampleModel = raster.getSampleModel();
        SampleModel sampleModel2 = writableRasterCreateCompatibleDestRaster.getSampleModel();
        int transferType = raster.getTransferType();
        int transferType2 = writableRasterCreateCompatibleDestRaster.getTransferType();
        boolean z = transferType == 4 || transferType == 5;
        boolean z2 = transferType2 == 4 || transferType2 == 5;
        int width = raster.getWidth();
        int height = raster.getHeight();
        int numBands = raster.getNumBands();
        int numBands2 = writableRasterCreateCompatibleDestRaster.getNumBands();
        float[] fArr2 = null;
        if (z) {
            i = 0;
            fArr = null;
        } else {
            fArr = new float[numBands];
            i = 0;
            while (i5 < numBands) {
                if (transferType == i4) {
                    fArr[i5] = (this.srcMaxVals[i5] - this.srcMinVals[i5]) / 32767.0f;
                } else {
                    fArr[i5] = (this.srcMaxVals[i5] - this.srcMinVals[i5]) / ((1 << sampleModel.getSampleSize(i5)) - 1);
                }
                i5++;
                i4 = 2;
            }
        }
        if (!z2) {
            float[] fArr3 = new float[numBands2];
            for (int i6 = i; i6 < numBands2; i6++) {
                if (transferType2 == 2) {
                    fArr3[i6] = 32767.0f / (this.dstMaxVals[i6] - this.dstMinVals[i6]);
                } else {
                    fArr3[i6] = ((1 << sampleModel2.getSampleSize(i6)) - 1) / (this.dstMaxVals[i6] - this.dstMinVals[i6]);
                }
            }
            fArr2 = fArr3;
        }
        int minY = raster.getMinY();
        int minY2 = writableRasterCreateCompatibleDestRaster.getMinY();
        float[] fArr4 = new float[numBands];
        ColorSpace[] colorSpaceArr2 = this.CSList;
        ColorSpace colorSpace = colorSpaceArr2[i];
        ColorSpace colorSpace2 = colorSpaceArr2[1];
        int i7 = i;
        while (i7 < height) {
            int minX = raster.getMinX();
            float[] fArr5 = fArr;
            int minX2 = writableRasterCreateCompatibleDestRaster.getMinX();
            int i8 = i7;
            int i9 = i;
            while (i9 < width) {
                int i10 = i9;
                int i11 = i;
                while (i11 < numBands) {
                    boolean z3 = z2;
                    float sampleFloat = raster.getSampleFloat(minX, minY, i11);
                    if (z) {
                        i2 = minY;
                    } else {
                        i2 = minY;
                        sampleFloat = (sampleFloat * fArr5[i11]) + this.srcMinVals[i11];
                    }
                    fArr4[i11] = sampleFloat;
                    i11++;
                    z2 = z3;
                    minY = i2;
                }
                int i12 = minY;
                boolean z4 = z2;
                float[] fArrFromCIEXYZ = colorSpace2.fromCIEXYZ(colorSpace.toCIEXYZ(fArr4));
                int i13 = i;
                while (i13 < numBands2) {
                    float f = fArrFromCIEXYZ[i13];
                    float[] fArr6 = fArrFromCIEXYZ;
                    if (!z4) {
                        f = (f - this.dstMinVals[i13]) * fArr2[i13];
                    }
                    writableRasterCreateCompatibleDestRaster.setSample(minX2, minY2, i13, f);
                    i13++;
                    fArrFromCIEXYZ = fArr6;
                }
                i9 = i10 + 1;
                minX++;
                minX2++;
                z2 = z4;
                minY = i12;
            }
            i7 = i8 + 1;
            minY++;
            minY2++;
            fArr = fArr5;
            z2 = z2;
        }
        return writableRasterCreateCompatibleDestRaster;
    }

    private void setMinMax(int i, int i2, float[] fArr, float[] fArr2) {
        if (i == 1) {
            fArr[0] = 0.0f;
            fArr2[0] = 100.0f;
            fArr[1] = -128.0f;
            fArr2[1] = 127.0f;
            fArr[2] = -128.0f;
            fArr2[2] = 127.0f;
            return;
        }
        if (i != 0) {
            for (int i4 = 0; i4 < i2; i4++) {
                fArr[i4] = 0.0f;
                fArr2[i4] = 1.0f;
            }
            return;
        }
        fArr[2] = 0.0f;
        fArr[1] = 0.0f;
        fArr[0] = 0.0f;
        fArr2[2] = 1.9999695f;
        fArr2[1] = 1.9999695f;
        fArr2[0] = 1.9999695f;
    }

    private void updateBITransform(ICC_Profile iCC_Profile, ICC_Profile iCC_Profile2) {
        int i;
        boolean z;
        boolean z2;
        int i2;
        ICC_Profile[] iCC_ProfileArr = this.profileList;
        int length = iCC_ProfileArr.length;
        if (length == 0 || iCC_Profile != iCC_ProfileArr[0]) {
            i = length + 1;
            z = true;
        } else {
            i = length;
            z = false;
        }
        if (length == 0 || iCC_Profile2 != iCC_ProfileArr[length - 1] || i < 2) {
            i++;
            z2 = true;
        } else {
            z2 = false;
        }
        ICC_Profile[] iCC_ProfileArr2 = new ICC_Profile[i];
        if (z) {
            iCC_ProfileArr2[0] = iCC_Profile;
            i2 = 1;
        } else {
            i2 = 0;
        }
        int i4 = 0;
        while (i4 < length) {
            iCC_ProfileArr2[i2] = this.profileList[i4];
            i4++;
            i2++;
        }
        if (z2) {
            iCC_ProfileArr2[i2] = iCC_Profile2;
        }
        ColorTransform[] colorTransformArr = new ColorTransform[i];
        int renderingIntent = iCC_ProfileArr2[0].getProfileClass() == 2 ? 1 : 0;
        PCMM module = CMSManager.getModule();
        int i5 = 1;
        int i6 = 0;
        while (i6 < i) {
            if (i6 == i - 1) {
                i5 = 2;
            } else if (i5 == 4 && iCC_ProfileArr2[i6].getProfileClass() == 5) {
                i5 = 1;
                renderingIntent = 0;
            }
            colorTransformArr[i6] = module.createTransform(iCC_ProfileArr2[i6], renderingIntent, i5);
            renderingIntent = getRenderingIntent(iCC_ProfileArr2[i6]);
            i6++;
            i5 = 4;
        }
        this.thisTransform = module.createTransform(colorTransformArr);
        this.thisSrcProfile = iCC_Profile;
        this.thisDestProfile = iCC_Profile2;
    }

    @Override // org.apache.poi.java.awt.image.BufferedImageOp
    public BufferedImage createCompatibleDestImage(BufferedImage bufferedImage, ColorModel colorModel) {
        ColorSpace iCC_ColorSpace;
        if (colorModel == null) {
            ColorSpace[] colorSpaceArr = this.CSList;
            if (colorSpaceArr == null) {
                ICC_Profile[] iCC_ProfileArr = this.profileList;
                int length = iCC_ProfileArr.length;
                if (length == 0) {
                    throw new IllegalArgumentException("Destination ColorSpace is undefined");
                }
                iCC_ColorSpace = new ICC_ColorSpace(iCC_ProfileArr[length - 1]);
            } else {
                iCC_ColorSpace = colorSpaceArr[colorSpaceArr.length - 1];
            }
        } else {
            iCC_ColorSpace = null;
        }
        return createCompatibleDestImage(bufferedImage, colorModel, iCC_ColorSpace);
    }

    @Override // org.apache.poi.java.awt.image.RasterOp
    public WritableRaster createCompatibleDestRaster(Raster raster) {
        int numComponents;
        ColorSpace[] colorSpaceArr = this.CSList;
        if (colorSpaceArr == null) {
            ICC_Profile[] iCC_ProfileArr = this.profileList;
            int length = iCC_ProfileArr.length;
            if (length < 2) {
                throw new IllegalArgumentException("Destination ColorSpace is undefined");
            }
            numComponents = iCC_ProfileArr[length - 1].getNumComponents();
        } else {
            if (colorSpaceArr.length != 2) {
                throw new IllegalArgumentException("Destination ColorSpace is undefined");
            }
            numComponents = colorSpaceArr[1].getNumComponents();
        }
        return Raster.createInterleavedRaster(0, raster.getWidth(), raster.getHeight(), numComponents, new Point(raster.getMinX(), raster.getMinY()));
    }

    @Override // org.apache.poi.java.awt.image.BufferedImageOp
    public final BufferedImage filter(BufferedImage bufferedImage, BufferedImage bufferedImage2) {
        BufferedImage bufferedImage3;
        ColorSpace colorSpace;
        if (bufferedImage.getColorModel() instanceof IndexColorModel) {
            bufferedImage = ((IndexColorModel) bufferedImage.getColorModel()).convertToIntDiscrete(bufferedImage.getRaster(), true);
        }
        ColorSpace colorSpace2 = bufferedImage.getColorModel().getColorSpace();
        if (bufferedImage2 == null) {
            bufferedImage3 = null;
            colorSpace = null;
        } else if (bufferedImage2.getColorModel() instanceof IndexColorModel) {
            bufferedImage3 = bufferedImage2;
            bufferedImage2 = null;
            colorSpace = null;
        } else {
            colorSpace = bufferedImage2.getColorModel().getColorSpace();
            bufferedImage3 = null;
        }
        BufferedImage bufferedImageICCBIFilter = (this.CSList == null && (colorSpace2 instanceof ICC_ColorSpace) && (bufferedImage2 == null || (colorSpace instanceof ICC_ColorSpace))) ? ICCBIFilter(bufferedImage, colorSpace2, bufferedImage2, colorSpace) : nonICCBIFilter(bufferedImage, colorSpace2, bufferedImage2, colorSpace);
        if (bufferedImage3 == null) {
            return bufferedImageICCBIFilter;
        }
        Graphics2D graphics2DCreateGraphics = bufferedImage3.createGraphics();
        try {
            graphics2DCreateGraphics.drawImage(bufferedImageICCBIFilter, 0, 0, (ImageObserver) null);
            return bufferedImage3;
        } finally {
            graphics2DCreateGraphics.dispose();
        }
    }

    @Override // org.apache.poi.java.awt.image.BufferedImageOp
    public final Rectangle2D getBounds2D(BufferedImage bufferedImage) {
        return getBounds2D(bufferedImage.getRaster());
    }

    public final ICC_Profile[] getICC_Profiles() {
        if (!this.gotProfiles) {
            return null;
        }
        ICC_Profile[] iCC_ProfileArr = new ICC_Profile[this.profileList.length];
        int i = 0;
        while (true) {
            ICC_Profile[] iCC_ProfileArr2 = this.profileList;
            if (i >= iCC_ProfileArr2.length) {
                return iCC_ProfileArr;
            }
            iCC_ProfileArr[i] = iCC_ProfileArr2[i];
            i++;
        }
    }

    @Override // org.apache.poi.java.awt.image.BufferedImageOp, org.apache.poi.java.awt.image.RasterOp
    public final Point2D getPoint2D(Point2D point2D, Point2D point2D2) {
        if (point2D2 == null) {
            point2D2 = new Point2D.Float();
        }
        point2D2.setLocation(point2D.getX(), point2D.getY());
        return point2D2;
    }

    @Override // org.apache.poi.java.awt.image.BufferedImageOp, org.apache.poi.java.awt.image.RasterOp
    public final RenderingHints getRenderingHints() {
        return this.hints;
    }

    public ColorConvertOp(ColorSpace colorSpace, RenderingHints renderingHints) {
        if (colorSpace == null) {
            throw new NullPointerException("ColorSpace cannot be null");
        }
        if (colorSpace instanceof ICC_ColorSpace) {
            this.profileList = new ICC_Profile[]{((ICC_ColorSpace) colorSpace).getProfile()};
        } else {
            this.CSList = new ColorSpace[]{colorSpace};
        }
        this.hints = renderingHints;
    }

    private BufferedImage createCompatibleDestImage(BufferedImage bufferedImage, ColorModel colorModel, ColorSpace colorSpace) {
        if (colorModel == null) {
            ColorModel colorModel2 = bufferedImage.getColorModel();
            int numComponents = colorSpace.getNumComponents();
            boolean zHasAlpha = colorModel2.hasAlpha();
            if (zHasAlpha) {
                numComponents++;
            }
            int[] iArr = new int[numComponents];
            for (int i = 0; i < numComponents; i++) {
                iArr[i] = 8;
            }
            colorModel = new ComponentColorModel(colorSpace, iArr, zHasAlpha, colorModel2.isAlphaPremultiplied(), colorModel2.getTransparency(), 0);
        }
        return new BufferedImage(colorModel, colorModel.createCompatibleWritableRaster(bufferedImage.getWidth(), bufferedImage.getHeight()), colorModel.isAlphaPremultiplied(), (Hashtable<?, ?>) null);
    }

    @Override // org.apache.poi.java.awt.image.RasterOp
    public final WritableRaster filter(Raster raster, WritableRaster writableRaster) {
        if (this.CSList != null) {
            return nonICCRasterFilter(raster, writableRaster);
        }
        int length = this.profileList.length;
        if (length < 2) {
            throw new IllegalArgumentException("Source or Destination ColorSpace is undefined");
        }
        if (raster.getNumBands() != this.profileList[0].getNumComponents()) {
            throw new IllegalArgumentException("Numbers of source Raster bands and source color space components do not match");
        }
        if (writableRaster == null) {
            writableRaster = createCompatibleDestRaster(raster);
        } else {
            if (raster.getHeight() != writableRaster.getHeight() || raster.getWidth() != writableRaster.getWidth()) {
                throw new IllegalArgumentException("Width or height of Rasters do not match");
            }
            if (writableRaster.getNumBands() != this.profileList[length - 1].getNumComponents()) {
                throw new IllegalArgumentException("Numbers of destination Raster bands and destination color space components do not match");
            }
        }
        WritableRaster writableRaster2 = writableRaster;
        if (this.thisRasterTransform == null) {
            ColorTransform[] colorTransformArr = new ColorTransform[length];
            int renderingIntent = this.profileList[0].getProfileClass() == 2 ? 1 : 0;
            PCMM module = CMSManager.getModule();
            int i = 0;
            int i2 = 1;
            while (i < length) {
                if (i == length - 1) {
                    i2 = 2;
                } else if (i2 == 4 && this.profileList[i].getProfileClass() == 5) {
                    renderingIntent = 0;
                    i2 = 1;
                }
                colorTransformArr[i] = module.createTransform(this.profileList[i], renderingIntent, i2);
                renderingIntent = getRenderingIntent(this.profileList[i]);
                i++;
                i2 = 4;
            }
            this.thisRasterTransform = module.createTransform(colorTransformArr);
        }
        int transferType = raster.getTransferType();
        int transferType2 = writableRaster2.getTransferType();
        if (transferType != 4 && transferType != 5 && transferType2 != 4 && transferType2 != 5) {
            this.thisRasterTransform.colorConvert(raster, writableRaster2);
            return writableRaster2;
        }
        if (this.srcMinVals == null) {
            ICC_Profile[] iCC_ProfileArr = this.profileList;
            getMinMaxValsFromProfiles(iCC_ProfileArr[0], iCC_ProfileArr[length - 1]);
        }
        this.thisRasterTransform.colorConvert(raster, writableRaster2, this.srcMinVals, this.srcMaxVals, this.dstMinVals, this.dstMaxVals);
        return writableRaster2;
    }

    @Override // org.apache.poi.java.awt.image.RasterOp
    public final Rectangle2D getBounds2D(Raster raster) {
        return raster.getBounds();
    }

    public ColorConvertOp(ColorSpace colorSpace, ColorSpace colorSpace2, RenderingHints renderingHints) {
        if (colorSpace == null || colorSpace2 == null) {
            throw new NullPointerException("ColorSpaces cannot be null");
        }
        if ((colorSpace instanceof ICC_ColorSpace) && (colorSpace2 instanceof ICC_ColorSpace)) {
            ICC_Profile[] iCC_ProfileArr = new ICC_Profile[2];
            this.profileList = iCC_ProfileArr;
            iCC_ProfileArr[0] = ((ICC_ColorSpace) colorSpace).getProfile();
            this.profileList[1] = ((ICC_ColorSpace) colorSpace2).getProfile();
            getMinMaxValsFromColorSpaces(colorSpace, colorSpace2);
        } else {
            this.CSList = new ColorSpace[]{colorSpace, colorSpace2};
        }
        this.hints = renderingHints;
    }

    public ColorConvertOp(ICC_Profile[] iCC_ProfileArr, RenderingHints renderingHints) {
        if (iCC_ProfileArr == null) {
            throw new NullPointerException("Profiles cannot be null");
        }
        this.gotProfiles = true;
        this.profileList = new ICC_Profile[iCC_ProfileArr.length];
        for (int i = 0; i < iCC_ProfileArr.length; i++) {
            this.profileList[i] = iCC_ProfileArr[i];
        }
        this.hints = renderingHints;
    }
}
