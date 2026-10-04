package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements;

import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.util.VUtilString;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataPredefinedShape;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VElementStroke extends VElementBase {
    public static final String NAME = "v:stroke";
    private String mColor;
    private String mColor2;
    private String mDashStyle;
    private boolean mEndArrow;
    private String mEndArrowLength;
    private String mEndArrowWidth;
    private String mEndCap;
    private String mFillType;
    private boolean mImageAlignShape;
    private String mImageSize;
    private String mJoinStyle;
    private String mLineStyle;
    private float mMiterLimit;
    private boolean mOn;
    private float mOpacity;
    private String mSrc;
    private boolean mStartArrow;
    private String mStartArrowLength;
    private String mStartArrowWidth;
    private float mWeight;

    public String getColor() {
        return this.mColor;
    }

    public String getColor2() {
        return this.mColor2;
    }

    public String getDashStyle() {
        return this.mDashStyle;
    }

    public boolean getEndArrow() {
        return this.mEndArrow;
    }

    public String getEndArrowLength() {
        return this.mEndArrowLength;
    }

    public String getEndArrowWidth() {
        return this.mEndArrowWidth;
    }

    public String getEndCap() {
        return this.mEndCap;
    }

    public String getFillType() {
        return this.mFillType;
    }

    public boolean getImageAlignShape() {
        return this.mImageAlignShape;
    }

    public String getImageSize() {
        return this.mImageSize;
    }

    public String getJoinStyle() {
        return this.mJoinStyle;
    }

    public String getLineStyle() {
        return this.mLineStyle;
    }

    public float getMiterLimit() {
        return this.mMiterLimit;
    }

    public boolean getOn() {
        return this.mOn;
    }

    public float getOpacity() {
        return this.mOpacity;
    }

    public String getSrc() {
        return this.mSrc;
    }

    public boolean getStartArrow() {
        return this.mStartArrow;
    }

    public String getStartArrowLength() {
        return this.mStartArrowLength;
    }

    public String getStartArrowWidth() {
        return this.mStartArrowWidth;
    }

    public float getWeight() {
        return this.mWeight;
    }

    public boolean parseBoolean(String str) {
        if (str == null) {
            return false;
        }
        return "block".compareToIgnoreCase(str) == 0 || "classic".compareToIgnoreCase(str) == 0 || "diamond".compareToIgnoreCase(str) == 0 || VMetaDataPredefinedShape.OVAL.compareToIgnoreCase(str) == 0 || AbstractCircuitBreaker.PROPERTY_NAME.compareToIgnoreCase(str) == 0;
    }

    public void setColor(String str) {
        this.mColor = str;
    }

    public void setColor2(String str) {
        this.mColor2 = str;
    }

    public void setDashStyle(String str) {
        this.mDashStyle = str;
    }

    public void setEndArrow(boolean z) {
        this.mEndArrow = z;
    }

    public void setEndArrowLength(String str) {
        this.mEndArrowLength = str;
    }

    public void setEndArrowWidth(String str) {
        this.mEndArrowWidth = str;
    }

    public void setEndCap(String str) {
        this.mEndCap = str;
    }

    public void setFillType(String str) {
        this.mFillType = str;
    }

    public void setImageAlignShape(boolean z) {
        this.mImageAlignShape = z;
    }

    public void setImageSize(String str) {
        this.mImageSize = str;
    }

    public void setJoinStyle(String str) {
        this.mJoinStyle = str;
    }

    public void setLineStyle(String str) {
        this.mLineStyle = str;
    }

    public void setMiterLimit(float f) {
        this.mMiterLimit = f;
    }

    public void setOn(boolean z) {
        this.mOn = z;
    }

    public void setOpacity(float f) {
        this.mOpacity = f;
    }

    public void setSrc(String str) {
        this.mSrc = str;
    }

    public void setStartArrow(boolean z) {
        this.mStartArrow = z;
    }

    public void setStartArrowLength(String str) {
        this.mStartArrowLength = str;
    }

    public void setStartArrowWidth(String str) {
        this.mStartArrowWidth = str;
    }

    public void setWeight(float f) {
        this.mWeight = f;
    }

    @Override // com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementBase
    public String toString() {
        StringBuilder sb = new StringBuilder("Stroke [mOn=");
        sb.append(this.mOn);
        sb.append(", mWeight=");
        sb.append(this.mWeight);
        sb.append(", mColor=");
        sb.append(this.mColor);
        sb.append(", mOpacity=");
        sb.append(this.mOpacity);
        sb.append(", mLineStyle=");
        sb.append(this.mLineStyle);
        sb.append(", mMiterLimit=");
        sb.append(this.mMiterLimit);
        sb.append(", mJoinStyle=");
        sb.append(this.mJoinStyle);
        sb.append(", mEndCap=");
        sb.append(this.mEndCap);
        sb.append(", mDashStyle=");
        sb.append(this.mDashStyle);
        sb.append(", mFillType=");
        sb.append(this.mFillType);
        sb.append(", mColor2=");
        sb.append(this.mColor2);
        sb.append(", mSrc=");
        sb.append(this.mSrc);
        sb.append(", mImageSize=");
        sb.append(this.mImageSize);
        sb.append(", mImageAlignShape=");
        sb.append(this.mImageAlignShape);
        sb.append(", mStartArrow=");
        sb.append(this.mStartArrow);
        sb.append(", mStartArrowWidth=");
        sb.append(this.mStartArrowWidth);
        sb.append(", mStartArrowLength=");
        sb.append(this.mStartArrowLength);
        sb.append(", mEndArrow=");
        sb.append(this.mEndArrow);
        sb.append(", mEndArrowWidth=");
        sb.append(this.mEndArrowWidth);
        sb.append(", mEndArrowLength=");
        sb.append(this.mEndArrowLength);
        sb.append(", toString()=");
        return AbstractC0622a.m1170p(super.toString(), "]", sb);
    }

    public void setEndArrow(String str) {
        setEndArrow(parseBoolean(str));
    }

    public void setImageAlignShape(String str) {
        setImageAlignShape(VUtilString.parseBoolean(str));
    }

    public void setMiterLimit(String str) {
        setMiterLimit(VUtilString.parseFloat(str));
    }

    public void setOn(String str) {
        setOn(VUtilString.parseBoolean(str));
    }

    public void setOpacity(String str) {
        setOpacity(VUtilString.parseFloat(str));
    }

    public void setStartArrow(String str) {
        setStartArrow(parseBoolean(str));
    }

    public void setWeight(String str) {
        setWeight(VUtilString.parseFloat(str));
    }

    @Override // com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementBase
    public void setDefaultMember() {
    }
}
