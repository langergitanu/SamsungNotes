package org.apache.poi.javax.imageio;

import androidx.core.view.MotionEventCompat;
import com.samsung.android.mcf.continuity.interfaces.ContinuityCommand;
import com.vladsch.flexmark.parser.PegdownExtensions;
import java.util.Hashtable;
import org.apache.poi.java.awt.Point;
import org.apache.poi.java.awt.color.ColorSpace;
import org.apache.poi.java.awt.image.BandedSampleModel;
import org.apache.poi.java.awt.image.BufferedImage;
import org.apache.poi.java.awt.image.ColorModel;
import org.apache.poi.java.awt.image.ComponentColorModel;
import org.apache.poi.java.awt.image.DataBuffer;
import org.apache.poi.java.awt.image.DirectColorModel;
import org.apache.poi.java.awt.image.IndexColorModel;
import org.apache.poi.java.awt.image.MultiPixelPackedSampleModel;
import org.apache.poi.java.awt.image.PixelInterleavedSampleModel;
import org.apache.poi.java.awt.image.Raster;
import org.apache.poi.java.awt.image.RenderedImage;
import org.apache.poi.java.awt.image.SampleModel;
import org.apache.poi.java.awt.image.WritableRaster;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ImageTypeSpecifier {
    protected ColorModel colorModel;
    protected SampleModel sampleModel;
    private static ColorSpace sRGB = ColorSpace.getInstance(1000);
    private static ImageTypeSpecifier[] BISpecifier = new ImageTypeSpecifier[14];

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Banded extends ImageTypeSpecifier {
        int[] bandOffsets;
        int[] bankIndices;
        ColorSpace colorSpace;
        int dataType;
        boolean hasAlpha;
        boolean isAlphaPremultiplied;

        public Banded(ColorSpace colorSpace, int[] iArr, int[] iArr2, int i, boolean z, boolean z2) {
            super();
            if (colorSpace == null) {
                throw new IllegalArgumentException("colorSpace == null!");
            }
            if (iArr == null) {
                throw new IllegalArgumentException("bankIndices == null!");
            }
            if (iArr2 == null) {
                throw new IllegalArgumentException("bandOffsets == null!");
            }
            if (iArr.length != iArr2.length) {
                throw new IllegalArgumentException("bankIndices.length != bandOffsets.length!");
            }
            if (i != 0 && i != 2 && i != 1 && i != 3 && i != 4 && i != 5) {
                throw new IllegalArgumentException("Bad value for dataType!");
            }
            if (iArr2.length != colorSpace.getNumComponents() + (z ? 1 : 0)) {
                throw new IllegalArgumentException("bandOffsets.length is wrong!");
            }
            this.colorSpace = colorSpace;
            this.bankIndices = (int[]) iArr.clone();
            this.bandOffsets = (int[]) iArr2.clone();
            this.dataType = i;
            this.hasAlpha = z;
            this.isAlphaPremultiplied = z2;
            this.colorModel = ImageTypeSpecifier.createComponentCM(colorSpace, iArr.length, i, z, z2);
            this.sampleModel = new BandedSampleModel(i, 1, 1, 1, iArr, iArr2);
        }

        @Override // org.apache.poi.javax.imageio.ImageTypeSpecifier
        public boolean equals(Object obj) {
            if (obj != null && (obj instanceof Banded)) {
                Banded banded = (Banded) obj;
                if (this.colorSpace.equals(banded.colorSpace) && this.dataType == banded.dataType && this.hasAlpha == banded.hasAlpha && this.isAlphaPremultiplied == banded.isAlphaPremultiplied && this.bankIndices.length == banded.bankIndices.length && this.bandOffsets.length == banded.bandOffsets.length) {
                    int i = 0;
                    while (true) {
                        int[] iArr = this.bankIndices;
                        if (i >= iArr.length) {
                            int i2 = 0;
                            while (true) {
                                int[] iArr2 = this.bandOffsets;
                                if (i2 >= iArr2.length) {
                                    return true;
                                }
                                if (iArr2[i2] != banded.bandOffsets[i2]) {
                                    return false;
                                }
                                i2++;
                            }
                        } else {
                            if (iArr[i] != banded.bankIndices[i]) {
                                return false;
                            }
                            i++;
                        }
                    }
                }
            }
            return false;
        }

        @Override // org.apache.poi.javax.imageio.ImageTypeSpecifier
        public int hashCode() {
            return (this.dataType * 21) + (this.bankIndices.length * 7) + (this.bandOffsets.length * 3) + super.hashCode() + (this.hasAlpha ? 19 : 29);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Grayscale extends ImageTypeSpecifier {
        int bits;
        int dataType;
        boolean hasAlpha;
        boolean isAlphaPremultiplied;
        boolean isSigned;

        public Grayscale(int i, int i2, boolean z, boolean z2, boolean z3) {
            super();
            if (i != 1 && i != 2 && i != 4 && i != 8 && i != 16) {
                throw new IllegalArgumentException("Bad value for bits!");
            }
            if (i2 != 0 && i2 != 2 && i2 != 1) {
                throw new IllegalArgumentException("Bad value for dataType!");
            }
            if (i > 8 && i2 == 0) {
                throw new IllegalArgumentException("Too many bits for dataType!");
            }
            this.bits = i;
            this.dataType = i2;
            this.isSigned = z;
            this.hasAlpha = z2;
            this.isAlphaPremultiplied = z3;
            ColorSpace colorSpace = ColorSpace.getInstance(1003);
            if ((i != 8 || i2 != 0) && (i != 16 || (i2 != 2 && i2 != 1))) {
                int i4 = 1 << i;
                byte[] bArr = new byte[i4];
                for (int i5 = 0; i5 < i4; i5++) {
                    bArr[i5] = (byte) ((i5 * 255) / (i4 - 1));
                }
                this.colorModel = new IndexColorModel(i, i4, bArr, bArr, bArr);
                this.sampleModel = new MultiPixelPackedSampleModel(i2, 1, 1, i);
                return;
            }
            int i6 = z2 ? 2 : 1;
            int i7 = z2 ? 3 : 1;
            int[] iArr = new int[i6];
            iArr[0] = i;
            if (i6 == 2) {
                iArr[1] = i;
            }
            this.colorModel = new ComponentColorModel(colorSpace, iArr, z2, z3, i7, i2);
            int[] iArr2 = new int[i6];
            iArr2[0] = 0;
            if (i6 == 2) {
                iArr2[1] = 1;
            }
            this.sampleModel = new PixelInterleavedSampleModel(i2, 1, 1, i6, i6, iArr2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Indexed extends ImageTypeSpecifier {
        byte[] alphaLUT;
        int bits;
        byte[] blueLUT;
        int dataType;
        byte[] greenLUT;
        byte[] redLUT;

        public Indexed(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i, int i2) {
            int i4;
            super();
            this.alphaLUT = null;
            if (bArr == null || bArr2 == null || bArr3 == null) {
                throw new IllegalArgumentException("LUT is null!");
            }
            if (i != 1 && i != 2 && i != 4 && i != 8 && i != 16) {
                throw new IllegalArgumentException("Bad value for bits!");
            }
            if (i2 != 0 && i2 != 2 && i2 != 1 && i2 != 3) {
                throw new IllegalArgumentException("Bad value for dataType!");
            }
            if ((i > 8 && i2 == 0) || (i > 16 && i2 != 3)) {
                throw new IllegalArgumentException("Too many bits for dataType!");
            }
            int i5 = 1 << i;
            if (bArr.length != i5 || bArr2.length != i5 || bArr3.length != i5 || (bArr4 != null && bArr4.length != i5)) {
                throw new IllegalArgumentException("LUT has improper length!");
            }
            this.redLUT = (byte[]) bArr.clone();
            this.greenLUT = (byte[]) bArr2.clone();
            this.blueLUT = (byte[]) bArr3.clone();
            if (bArr4 != null) {
                this.alphaLUT = (byte[]) bArr4.clone();
            }
            this.bits = i;
            this.dataType = i2;
            if (bArr4 == null) {
                this.colorModel = new IndexColorModel(i, bArr.length, bArr, bArr2, bArr3);
                i4 = i;
            } else {
                i4 = i;
                this.colorModel = new IndexColorModel(i4, bArr.length, bArr, bArr2, bArr3, bArr4);
            }
            if ((i4 == 8 && i2 == 0) || (i4 == 16 && (i2 == 2 || i2 == 1))) {
                this.sampleModel = new PixelInterleavedSampleModel(i2, 1, 1, 1, 1, new int[]{0});
            } else {
                this.sampleModel = new MultiPixelPackedSampleModel(i2, 1, 1, i4);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Interleaved extends ImageTypeSpecifier {
        int[] bandOffsets;
        ColorSpace colorSpace;
        int dataType;
        boolean hasAlpha;
        boolean isAlphaPremultiplied;

        public Interleaved(ColorSpace colorSpace, int[] iArr, int i, boolean z, boolean z2) {
            super();
            if (colorSpace == null) {
                throw new IllegalArgumentException("colorSpace == null!");
            }
            if (iArr == null) {
                throw new IllegalArgumentException("bandOffsets == null!");
            }
            if (iArr.length != colorSpace.getNumComponents() + (z ? 1 : 0)) {
                throw new IllegalArgumentException("bandOffsets.length is wrong!");
            }
            if (i != 0 && i != 2 && i != 1 && i != 3 && i != 4 && i != 5) {
                throw new IllegalArgumentException("Bad value for dataType!");
            }
            this.colorSpace = colorSpace;
            this.bandOffsets = (int[]) iArr.clone();
            this.dataType = i;
            this.hasAlpha = z;
            this.isAlphaPremultiplied = z2;
            this.colorModel = ImageTypeSpecifier.createComponentCM(colorSpace, iArr.length, i, z, z2);
            int iMax = iArr[0];
            int iMin = iMax;
            for (int i2 : iArr) {
                iMin = Math.min(i2, iMin);
                iMax = Math.max(i2, iMax);
            }
            int i4 = (iMax - iMin) + 1;
            this.sampleModel = new PixelInterleavedSampleModel(i, 1, 1, i4, i4, iArr);
        }

        @Override // org.apache.poi.javax.imageio.ImageTypeSpecifier
        public boolean equals(Object obj) {
            if (obj != null && (obj instanceof Interleaved)) {
                Interleaved interleaved = (Interleaved) obj;
                if (this.colorSpace.equals(interleaved.colorSpace) && this.dataType == interleaved.dataType && this.hasAlpha == interleaved.hasAlpha && this.isAlphaPremultiplied == interleaved.isAlphaPremultiplied && this.bandOffsets.length == interleaved.bandOffsets.length) {
                    int i = 0;
                    while (true) {
                        int[] iArr = this.bandOffsets;
                        if (i >= iArr.length) {
                            return true;
                        }
                        if (iArr[i] != interleaved.bandOffsets[i]) {
                            return false;
                        }
                        i++;
                    }
                }
            }
            return false;
        }

        @Override // org.apache.poi.javax.imageio.ImageTypeSpecifier
        public int hashCode() {
            return (this.dataType * 25) + (this.bandOffsets.length * 4) + super.hashCode() + (this.hasAlpha ? 17 : 18);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Packed extends ImageTypeSpecifier {
        int alphaMask;
        int blueMask;
        ColorSpace colorSpace;
        int greenMask;
        boolean isAlphaPremultiplied;
        int redMask;
        int transferType;

        public Packed(ColorSpace colorSpace, int i, int i2, int i4, int i5, int i6, boolean z) {
            super();
            if (colorSpace == null) {
                throw new IllegalArgumentException("colorSpace == null!");
            }
            if (colorSpace.getType() != 5) {
                throw new IllegalArgumentException("colorSpace is not of type TYPE_RGB!");
            }
            if (i6 != 0 && i6 != 1 && i6 != 3) {
                throw new IllegalArgumentException("Bad value for transferType!");
            }
            if (i == 0 && i2 == 0 && i4 == 0 && i5 == 0) {
                throw new IllegalArgumentException("No mask has at least 1 bit set!");
            }
            this.colorSpace = colorSpace;
            this.redMask = i;
            this.greenMask = i2;
            this.blueMask = i4;
            this.alphaMask = i5;
            this.transferType = i6;
            this.isAlphaPremultiplied = z;
            DirectColorModel directColorModel = new DirectColorModel(colorSpace, 32, i, i2, i4, i5, z, i6);
            this.colorModel = directColorModel;
            this.sampleModel = directColorModel.createCompatibleSampleModel(1, 1);
        }
    }

    private ImageTypeSpecifier() {
    }

    public static ImageTypeSpecifier createBanded(ColorSpace colorSpace, int[] iArr, int[] iArr2, int i, boolean z, boolean z2) {
        return new Banded(colorSpace, iArr, iArr2, i, z, z2);
    }

    public static ColorModel createComponentCM(ColorSpace colorSpace, int i, int i2, boolean z, boolean z2) {
        int i4 = z ? 3 : 1;
        int[] iArr = new int[i];
        int dataTypeSize = DataBuffer.getDataTypeSize(i2);
        for (int i5 = 0; i5 < i; i5++) {
            iArr[i5] = dataTypeSize;
        }
        return new ComponentColorModel(colorSpace, iArr, z, z2, i4, i2);
    }

    public static ImageTypeSpecifier createFromBufferedImageType(int i) {
        if (i >= 1 && i <= 13) {
            return getSpecifier(i);
        }
        if (i == 0) {
            throw new IllegalArgumentException("Cannot create from TYPE_CUSTOM!");
        }
        throw new IllegalArgumentException("Invalid BufferedImage type!");
    }

    public static ImageTypeSpecifier createFromRenderedImage(RenderedImage renderedImage) {
        int type;
        if (renderedImage != null) {
            return (!(renderedImage instanceof BufferedImage) || (type = ((BufferedImage) renderedImage).getType()) == 0) ? new ImageTypeSpecifier(renderedImage) : getSpecifier(type);
        }
        throw new IllegalArgumentException("image == null!");
    }

    public static ImageTypeSpecifier createGrayscale(int i, int i2, boolean z) {
        return new Grayscale(i, i2, z, false, false);
    }

    public static ImageTypeSpecifier createIndexed(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i, int i2) {
        return new Indexed(bArr, bArr2, bArr3, bArr4, i, i2);
    }

    public static ImageTypeSpecifier createInterleaved(ColorSpace colorSpace, int[] iArr, int i, boolean z, boolean z2) {
        return new Interleaved(colorSpace, iArr, i, z, z2);
    }

    public static ImageTypeSpecifier createPacked(ColorSpace colorSpace, int i, int i2, int i4, int i5, int i6, boolean z) {
        return new Packed(colorSpace, i, i2, i4, i5, i6, z);
    }

    private static ImageTypeSpecifier createSpecifier(int i) {
        switch (i) {
            case 1:
                return createPacked(sRGB, 16711680, MotionEventCompat.ACTION_POINTER_INDEX_MASK, 255, 0, 3, false);
            case 2:
                return createPacked(sRGB, 16711680, MotionEventCompat.ACTION_POINTER_INDEX_MASK, 255, -16777216, 3, false);
            case 3:
                return createPacked(sRGB, 16711680, MotionEventCompat.ACTION_POINTER_INDEX_MASK, 255, -16777216, 3, true);
            case 4:
                return createPacked(sRGB, 255, MotionEventCompat.ACTION_POINTER_INDEX_MASK, 16711680, 0, 3, false);
            case 5:
                return createInterleaved(sRGB, new int[]{2, 1, 0}, 0, false, false);
            case 6:
                return createInterleaved(sRGB, new int[]{3, 2, 1, 0}, 0, true, false);
            case 7:
                return createInterleaved(sRGB, new int[]{3, 2, 1, 0}, 0, true, true);
            case 8:
                return createPacked(sRGB, PegdownExtensions.UNUSED_ALL, ContinuityCommand.CMD_ASYNC_DISCONNECT, 31, 0, 1, false);
            case 9:
                return createPacked(sRGB, 31744, 992, 31, 0, 1, false);
            case 10:
                return createGrayscale(8, 0, false);
            case 11:
                return createGrayscale(16, 1, false);
            case 12:
                return createGrayscale(1, 0, false);
            case 13:
                IndexColorModel indexColorModel = (IndexColorModel) new BufferedImage(1, 1, 13).getColorModel();
                int mapSize = indexColorModel.getMapSize();
                byte[] bArr = new byte[mapSize];
                byte[] bArr2 = new byte[mapSize];
                byte[] bArr3 = new byte[mapSize];
                byte[] bArr4 = new byte[mapSize];
                indexColorModel.getReds(bArr);
                indexColorModel.getGreens(bArr2);
                indexColorModel.getBlues(bArr3);
                indexColorModel.getAlphas(bArr4);
                return createIndexed(bArr, bArr2, bArr3, bArr4, 8, 0);
            default:
                throw new IllegalArgumentException("Invalid BufferedImage type!");
        }
    }

    private static ImageTypeSpecifier getSpecifier(int i) {
        ImageTypeSpecifier[] imageTypeSpecifierArr = BISpecifier;
        if (imageTypeSpecifierArr[i] == null) {
            imageTypeSpecifierArr[i] = createSpecifier(i);
        }
        return BISpecifier[i];
    }

    public BufferedImage createBufferedImage(int i, int i2) {
        try {
            WritableRaster writableRasterCreateWritableRaster = Raster.createWritableRaster(getSampleModel(i, i2), new Point(0, 0));
            ColorModel colorModel = this.colorModel;
            return new BufferedImage(colorModel, writableRasterCreateWritableRaster, colorModel.isAlphaPremultiplied(), (Hashtable<?, ?>) new Hashtable());
        } catch (NegativeArraySizeException unused) {
            throw new IllegalArgumentException("Array size > Integer.MAX_VALUE!");
        }
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ImageTypeSpecifier)) {
            ImageTypeSpecifier imageTypeSpecifier = (ImageTypeSpecifier) obj;
            if (this.colorModel.equals(imageTypeSpecifier.colorModel) && this.sampleModel.equals(imageTypeSpecifier.sampleModel)) {
                return true;
            }
        }
        return false;
    }

    public int getBitsPerBand(int i) {
        if (!(i >= getNumBands()) && !(i < 0)) {
            return this.sampleModel.getSampleSize(i);
        }
        throw new IllegalArgumentException("band out of range!");
    }

    public int getBufferedImageType() {
        return createBufferedImage(1, 1).getType();
    }

    public ColorModel getColorModel() {
        return this.colorModel;
    }

    public int getNumBands() {
        return this.sampleModel.getNumBands();
    }

    public int getNumComponents() {
        return this.colorModel.getNumComponents();
    }

    public SampleModel getSampleModel() {
        return this.sampleModel;
    }

    public int hashCode() {
        return (this.sampleModel.hashCode() * 14) + (this.colorModel.hashCode() * 9);
    }

    public static ImageTypeSpecifier createGrayscale(int i, int i2, boolean z, boolean z2) {
        return new Grayscale(i, i2, z, true, z2);
    }

    public SampleModel getSampleModel(int i, int i2) {
        if (((long) i) * ((long) i2) <= 2147483647L) {
            return this.sampleModel.createCompatibleSampleModel(i, i2);
        }
        throw new IllegalArgumentException("width*height > Integer.MAX_VALUE!");
    }

    public ImageTypeSpecifier(ColorModel colorModel, SampleModel sampleModel) {
        if (colorModel == null) {
            throw new IllegalArgumentException("colorModel == null!");
        }
        if (sampleModel != null) {
            if (colorModel.isCompatibleSampleModel(sampleModel)) {
                this.colorModel = colorModel;
                this.sampleModel = sampleModel;
                return;
            }
            throw new IllegalArgumentException("sampleModel is incompatible with colorModel!");
        }
        throw new IllegalArgumentException("sampleModel == null!");
    }

    public ImageTypeSpecifier(RenderedImage renderedImage) {
        if (renderedImage != null) {
            this.colorModel = renderedImage.getColorModel();
            this.sampleModel = renderedImage.getSampleModel();
            return;
        }
        throw new IllegalArgumentException("image == null!");
    }
}
