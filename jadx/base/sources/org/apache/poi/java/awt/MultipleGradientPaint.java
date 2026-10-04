package org.apache.poi.java.awt;

import androidx.collection.AbstractC0622a;
import java.lang.ref.SoftReference;
import java.util.Arrays;
import org.apache.poi.java.awt.geom.AffineTransform;
import org.apache.poi.java.awt.image.ColorModel;

/* JADX INFO: loaded from: classes10.dex */
public abstract class MultipleGradientPaint implements Paint {
    final ColorSpaceType colorSpace;
    final Color[] colors;
    final CycleMethod cycleMethod;
    int fastGradientArraySize;
    final float[] fractions;
    SoftReference<int[]> gradient;
    final AffineTransform gradientTransform;
    SoftReference<int[][]> gradients;
    boolean isSimpleLookup;
    ColorModel model;
    float[] normalizedIntervals;
    final int transparency;

    public enum ColorSpaceType {
        SRGB,
        LINEAR_RGB
    }

    public enum CycleMethod {
        NO_CYCLE,
        REFLECT,
        REPEAT
    }

    public MultipleGradientPaint(float[] fArr, Color[] colorArr, CycleMethod cycleMethod, ColorSpaceType colorSpaceType, AffineTransform affineTransform) {
        int i;
        boolean z;
        if (fArr == null) {
            throw new NullPointerException("Fractions array cannot be null");
        }
        if (colorArr == null) {
            throw new NullPointerException("Colors array cannot be null");
        }
        if (cycleMethod == null) {
            throw new NullPointerException("Cycle method cannot be null");
        }
        if (colorSpaceType == null) {
            throw new NullPointerException("Color space cannot be null");
        }
        if (affineTransform == null) {
            throw new NullPointerException("Gradient transform cannot be null");
        }
        if (fArr.length != colorArr.length) {
            throw new IllegalArgumentException("Colors and fractions must have equal size");
        }
        if (colorArr.length < 2) {
            throw new IllegalArgumentException("User must specify at least 2 colors");
        }
        int length = fArr.length;
        float f = -1.0f;
        int i2 = 0;
        while (i2 < length) {
            float f4 = fArr[i2];
            if (f4 < 0.0f || f4 > 1.0f) {
                throw new IllegalArgumentException(AbstractC0622a.m1166l("Fraction values must be in the range 0 to 1: ", f4));
            }
            if (f4 <= f) {
                throw new IllegalArgumentException(AbstractC0622a.m1166l("Keyframe fractions must be increasing: ", f4));
            }
            i2++;
            f = f4;
        }
        int length2 = fArr.length;
        if (fArr[0] != 0.0f) {
            length2++;
            i = 1;
        } else {
            i = 0;
        }
        int i4 = i;
        if (fArr[fArr.length - 1] != 1.0f) {
            length2++;
            z = true;
        } else {
            z = false;
        }
        float[] fArr2 = new float[length2];
        this.fractions = fArr2;
        System.arraycopy(fArr, 0, fArr2, i4, fArr.length);
        Color[] colorArr2 = new Color[length2];
        this.colors = colorArr2;
        System.arraycopy(colorArr, 0, colorArr2, i4, colorArr.length);
        if (i != 0) {
            fArr2[0] = 0.0f;
            colorArr2[0] = colorArr[0];
        }
        if (z) {
            int i5 = length2 - 1;
            fArr2[i5] = 1.0f;
            colorArr2[i5] = colorArr[colorArr.length - 1];
        }
        this.colorSpace = colorSpaceType;
        this.cycleMethod = cycleMethod;
        this.gradientTransform = new AffineTransform(affineTransform);
        boolean z2 = true;
        for (Color color : colorArr) {
            z2 = z2 && color.getAlpha() == 255;
        }
        this.transparency = z2 ? 1 : 3;
    }

    public final ColorSpaceType getColorSpace() {
        return this.colorSpace;
    }

    public final Color[] getColors() {
        Color[] colorArr = this.colors;
        return (Color[]) Arrays.copyOf(colorArr, colorArr.length);
    }

    public final CycleMethod getCycleMethod() {
        return this.cycleMethod;
    }

    public final float[] getFractions() {
        float[] fArr = this.fractions;
        return Arrays.copyOf(fArr, fArr.length);
    }

    public final AffineTransform getTransform() {
        return new AffineTransform(this.gradientTransform);
    }

    @Override // org.apache.poi.java.awt.Transparency
    public final int getTransparency() {
        return this.transparency;
    }
}
