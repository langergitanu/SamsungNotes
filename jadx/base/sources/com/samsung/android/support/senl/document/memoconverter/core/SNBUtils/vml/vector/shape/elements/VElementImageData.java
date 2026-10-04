package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements;

import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.util.VUtilString;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VElementImageData extends VElementBase {
    public static final String NAME = "v:imagedata";
    private boolean mBiLevel;
    private float mBlackLevel;
    private String mChromaKey;
    private float mCropBottom;
    private float mCropLeft;
    private float mCropTop;
    private String mEmbossColor;
    private float mGain;
    private float mGamma;
    private boolean mGrayScale;
    private String mHref;
    private String mLinkType;
    private String mSrc;

    public boolean getBiLevel() {
        return this.mBiLevel;
    }

    public float getBlackLevel() {
        return this.mBlackLevel;
    }

    public String getChromaKey() {
        return this.mChromaKey;
    }

    public float getCropBottom() {
        return this.mCropBottom;
    }

    public float getCropLeft() {
        return this.mCropLeft;
    }

    public float getCropTop() {
        return this.mCropTop;
    }

    public String getEmbossColor() {
        return this.mEmbossColor;
    }

    public float getGain() {
        return this.mGain;
    }

    public float getGamma() {
        return this.mGamma;
    }

    public boolean getGrayScale() {
        return this.mGrayScale;
    }

    public String getHref() {
        return this.mHref;
    }

    public String getLinkType() {
        return this.mLinkType;
    }

    public String getSrc() {
        return this.mSrc;
    }

    public void setBiLevel(boolean z) {
        this.mBiLevel = z;
    }

    public void setBlackLevel(float f) {
        this.mBlackLevel = f;
    }

    public void setChromaKey(String str) {
        this.mChromaKey = str;
    }

    public void setCropBottom(float f) {
        this.mCropBottom = f;
    }

    public void setCropLeft(float f) {
        this.mCropLeft = f;
    }

    public void setCropTop(float f) {
        this.mCropTop = f;
    }

    public void setEmbossColor(String str) {
        this.mEmbossColor = str;
    }

    public void setGain(float f) {
        this.mGain = f;
    }

    public void setGamma(float f) {
        this.mGamma = f;
    }

    public void setGrayScale(boolean z) {
        this.mGrayScale = z;
    }

    public void setHref(String str) {
        this.mHref = str;
    }

    public void setLinkType(String str) {
        this.mLinkType = str;
    }

    public void setSrc(String str) {
        this.mSrc = str;
    }

    @Override // com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementBase
    public String toString() {
        StringBuilder sb = new StringBuilder("ImageData [mSrc=");
        sb.append(this.mSrc);
        sb.append(", mHref=");
        sb.append(this.mHref);
        sb.append(", mLinkType=");
        sb.append(this.mLinkType);
        sb.append(", mCropLeft=");
        sb.append(this.mCropLeft);
        sb.append(", mCropTop=");
        sb.append(this.mCropTop);
        sb.append(", mCropBottom=");
        sb.append(this.mCropBottom);
        sb.append(", mEmbossColor=");
        sb.append(this.mEmbossColor);
        sb.append(", mGain=");
        sb.append(this.mGain);
        sb.append(", mBlackLevel=");
        sb.append(this.mBlackLevel);
        sb.append(", mGamma=");
        sb.append(this.mGamma);
        sb.append(", mChromaKey=");
        sb.append(this.mChromaKey);
        sb.append(", mGrayScale=");
        sb.append(this.mGrayScale);
        sb.append(", mBiLevel=");
        sb.append(this.mBiLevel);
        sb.append(", toString()=");
        return AbstractC0622a.m1170p(super.toString(), "]", sb);
    }

    public void setBiLevel(String str) {
        setBiLevel(VUtilString.parseBoolean(str));
    }

    public void setBlackLevel(String str) {
        setBlackLevel(VUtilString.parseFloat(str));
    }

    public void setCropBottom(String str) {
        setCropBottom(VUtilString.parseFloat(str));
    }

    public void setCropLeft(String str) {
        setCropLeft(VUtilString.parseFloat(str));
    }

    public void setCropTop(String str) {
        setCropTop(VUtilString.parseFloat(str));
    }

    public void setGain(String str) {
        setGain(VUtilString.parseFloat(str));
    }

    public void setGamma(String str) {
        setGamma(VUtilString.parseFloat(str));
    }

    public void setGrayScale(String str) {
        setGrayScale(VUtilString.parseBoolean(str));
    }

    @Override // com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementBase
    public void setDefaultMember() {
    }
}
