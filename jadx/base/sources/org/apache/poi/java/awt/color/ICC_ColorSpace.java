package org.apache.poi.java.awt.color;

import kotlin.UShort;
import org.apache.poi.sun.java2d.cmm.CMSManager;
import org.apache.poi.sun.java2d.cmm.ColorTransform;
import org.apache.poi.sun.java2d.cmm.PCMM;

/* JADX INFO: loaded from: classes10.dex */
public class ICC_ColorSpace extends ColorSpace {
    static final long serialVersionUID = 3455889114070431483L;
    private float[] diffMinMax;
    private float[] invDiffMinMax;
    private float[] maxVal;
    private float[] minVal;
    private boolean needScaleInit;
    private transient ColorTransform srgb2this;
    private transient ColorTransform this2srgb;
    private transient ColorTransform this2xyz;
    private ICC_Profile thisProfile;
    private transient ColorTransform xyz2this;

    public ICC_ColorSpace(ICC_Profile iCC_Profile) {
        super(iCC_Profile.getColorSpaceType(), iCC_Profile.getNumComponents());
        this.needScaleInit = true;
        int profileClass = iCC_Profile.getProfileClass();
        if (profileClass != 0 && profileClass != 1 && profileClass != 2 && profileClass != 4 && profileClass != 6 && profileClass != 5) {
            throw new IllegalArgumentException("Invalid profile type");
        }
        this.thisProfile = iCC_Profile;
        setMinMax();
    }

    private void setComponentScaling() {
        int numComponents = getNumComponents();
        this.diffMinMax = new float[numComponents];
        this.invDiffMinMax = new float[numComponents];
        for (int i = 0; i < numComponents; i++) {
            this.minVal[i] = getMinValue(i);
            this.maxVal[i] = getMaxValue(i);
            float[] fArr = this.diffMinMax;
            float f = this.maxVal[i] - this.minVal[i];
            fArr[i] = f;
            this.invDiffMinMax[i] = 65535.0f / f;
        }
        this.needScaleInit = false;
    }

    private void setMinMax() {
        int numComponents = getNumComponents();
        int type = getType();
        float[] fArr = new float[numComponents];
        this.minVal = fArr;
        float[] fArr2 = new float[numComponents];
        this.maxVal = fArr2;
        if (type == 1) {
            fArr[0] = 0.0f;
            fArr2[0] = 100.0f;
            fArr[1] = -128.0f;
            fArr2[1] = 127.0f;
            fArr[2] = -128.0f;
            fArr2[2] = 127.0f;
            return;
        }
        if (type != 0) {
            for (int i = 0; i < numComponents; i++) {
                this.minVal[i] = 0.0f;
                this.maxVal[i] = 1.0f;
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

    @Override // org.apache.poi.java.awt.color.ColorSpace
    public float[] fromCIEXYZ(float[] fArr) {
        if (this.xyz2this == null) {
            ColorTransform[] colorTransformArr = new ColorTransform[2];
            ICC_ColorSpace iCC_ColorSpace = (ICC_ColorSpace) ColorSpace.getInstance(1001);
            PCMM module = CMSManager.getModule();
            colorTransformArr[0] = module.createTransform(iCC_ColorSpace.getProfile(), -1, 1);
            try {
                colorTransformArr[1] = module.createTransform(this.thisProfile, 1, 2);
            } catch (CMMException unused) {
                colorTransformArr[1] = CMSManager.getModule().createTransform(this.thisProfile, -1, 2);
            }
            this.xyz2this = module.createTransform(colorTransformArr);
            if (this.needScaleInit) {
                setComponentScaling();
            }
        }
        short[] sArr = new short[3];
        for (int i = 0; i < 3; i++) {
            sArr[i] = (short) ((fArr[i] * 32768.0f) + 0.5f);
        }
        short[] sArrColorConvert = this.xyz2this.colorConvert(sArr, (short[]) null);
        int numComponents = getNumComponents();
        float[] fArr2 = new float[numComponents];
        for (int i2 = 0; i2 < numComponents; i2++) {
            fArr2[i2] = (((sArrColorConvert[i2] & UShort.MAX_VALUE) / 65535.0f) * this.diffMinMax[i2]) + this.minVal[i2];
        }
        return fArr2;
    }

    @Override // org.apache.poi.java.awt.color.ColorSpace
    public float[] fromRGB(float[] fArr) {
        if (this.srgb2this == null) {
            ICC_ColorSpace iCC_ColorSpace = (ICC_ColorSpace) ColorSpace.getInstance(1000);
            PCMM module = CMSManager.getModule();
            this.srgb2this = module.createTransform(new ColorTransform[]{module.createTransform(iCC_ColorSpace.getProfile(), -1, 1), module.createTransform(this.thisProfile, -1, 2)});
            if (this.needScaleInit) {
                setComponentScaling();
            }
        }
        short[] sArr = new short[3];
        for (int i = 0; i < 3; i++) {
            sArr[i] = (short) ((fArr[i] * 65535.0f) + 0.5f);
        }
        short[] sArrColorConvert = this.srgb2this.colorConvert(sArr, (short[]) null);
        int numComponents = getNumComponents();
        float[] fArr2 = new float[numComponents];
        for (int i2 = 0; i2 < numComponents; i2++) {
            fArr2[i2] = (((sArrColorConvert[i2] & UShort.MAX_VALUE) / 65535.0f) * this.diffMinMax[i2]) + this.minVal[i2];
        }
        return fArr2;
    }

    @Override // org.apache.poi.java.awt.color.ColorSpace
    public float getMaxValue(int i) {
        if (i < 0 || i > getNumComponents() - 1) {
            throw new IllegalArgumentException("Component index out of range: + component");
        }
        return this.maxVal[i];
    }

    @Override // org.apache.poi.java.awt.color.ColorSpace
    public float getMinValue(int i) {
        if (i < 0 || i > getNumComponents() - 1) {
            throw new IllegalArgumentException("Component index out of range: + component");
        }
        return this.minVal[i];
    }

    public ICC_Profile getProfile() {
        return this.thisProfile;
    }

    @Override // org.apache.poi.java.awt.color.ColorSpace
    public float[] toCIEXYZ(float[] fArr) {
        if (this.this2xyz == null) {
            ColorTransform[] colorTransformArr = new ColorTransform[2];
            ICC_ColorSpace iCC_ColorSpace = (ICC_ColorSpace) ColorSpace.getInstance(1001);
            PCMM module = CMSManager.getModule();
            try {
                colorTransformArr[0] = module.createTransform(this.thisProfile, 1, 1);
            } catch (CMMException unused) {
                colorTransformArr[0] = module.createTransform(this.thisProfile, -1, 1);
            }
            colorTransformArr[1] = module.createTransform(iCC_ColorSpace.getProfile(), -1, 2);
            this.this2xyz = module.createTransform(colorTransformArr);
            if (this.needScaleInit) {
                setComponentScaling();
            }
        }
        int numComponents = getNumComponents();
        short[] sArr = new short[numComponents];
        for (int i = 0; i < numComponents; i++) {
            sArr[i] = (short) (((fArr[i] - this.minVal[i]) * this.invDiffMinMax[i]) + 0.5f);
        }
        short[] sArrColorConvert = this.this2xyz.colorConvert(sArr, (short[]) null);
        float[] fArr2 = new float[3];
        for (int i2 = 0; i2 < 3; i2++) {
            fArr2[i2] = ((sArrColorConvert[i2] & UShort.MAX_VALUE) / 65535.0f) * 1.9999695f;
        }
        return fArr2;
    }

    @Override // org.apache.poi.java.awt.color.ColorSpace
    public float[] toRGB(float[] fArr) {
        if (this.this2srgb == null) {
            ICC_ColorSpace iCC_ColorSpace = (ICC_ColorSpace) ColorSpace.getInstance(1000);
            PCMM module = CMSManager.getModule();
            this.this2srgb = module.createTransform(new ColorTransform[]{module.createTransform(this.thisProfile, -1, 1), module.createTransform(iCC_ColorSpace.getProfile(), -1, 2)});
            if (this.needScaleInit) {
                setComponentScaling();
            }
        }
        int numComponents = getNumComponents();
        short[] sArr = new short[numComponents];
        for (int i = 0; i < numComponents; i++) {
            sArr[i] = (short) (((fArr[i] - this.minVal[i]) * this.invDiffMinMax[i]) + 0.5f);
        }
        short[] sArrColorConvert = this.this2srgb.colorConvert(sArr, (short[]) null);
        float[] fArr2 = new float[3];
        for (int i2 = 0; i2 < 3; i2++) {
            fArr2[i2] = (sArrColorConvert[i2] & UShort.MAX_VALUE) / 65535.0f;
        }
        return fArr2;
    }
}
