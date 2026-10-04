package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements;

import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.util.VUtilString;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.common.VCommonPoint;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.common.VCommonSize;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VElementFill extends VElementBase {
    public static final String NAME = "v:fill";
    private String mAlignShape;
    private float mAngle;
    private String mAspect;
    private String mColor;
    private String mColor2;
    private String mColors;
    private float mFocus;
    private VCommonPoint mFocusPosition;
    private VCommonSize mFocusSize;
    private String mMethod;
    private boolean mOn;
    private float mOpacity;
    private float mOpacity2;
    private String mOrigin;
    private String mPosition;
    private String mSize;
    private String mSrc;
    private String mType;

    public String getAlignShape() {
        return this.mAlignShape;
    }

    public float getAngle() {
        return this.mAngle;
    }

    public String getAspect() {
        return this.mAspect;
    }

    public String getColor() {
        return this.mColor;
    }

    public String getColor2() {
        return this.mColor2;
    }

    public String getColors() {
        return this.mColors;
    }

    public float getFocus() {
        return this.mFocus;
    }

    public VCommonPoint getFocusPosition() {
        return this.mFocusPosition;
    }

    public VCommonSize getFocusSize() {
        return this.mFocusSize;
    }

    public String getMethod() {
        return this.mMethod;
    }

    public boolean getOn() {
        return this.mOn;
    }

    public float getOpacity() {
        return this.mOpacity;
    }

    public float getOpacity2() {
        return this.mOpacity2;
    }

    public String getOrigin() {
        return this.mOrigin;
    }

    public String getPosition() {
        return this.mPosition;
    }

    public String getSize() {
        return this.mSize;
    }

    public String getSrc() {
        return this.mSrc;
    }

    public String getType() {
        return this.mType;
    }

    public void setAlignShape(String str) {
        this.mAlignShape = str;
    }

    public void setAngle(float f) {
        this.mAngle = f;
    }

    public void setAspect(String str) {
        this.mAspect = str;
    }

    public void setColor(String str) {
        this.mColor = str;
    }

    public void setColor2(String str) {
        this.mColor2 = str;
    }

    public void setColors(String str) {
        this.mColors = str;
    }

    @Override // com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementBase
    public void setDefaultMember() {
        this.mFocusSize = new VCommonSize();
        this.mFocusPosition = new VCommonPoint();
    }

    public void setFocus(float f) {
        this.mFocus = f;
    }

    public void setFocusPosition(VCommonPoint vCommonPoint) {
        this.mFocusPosition = vCommonPoint;
    }

    public void setFocusSize(VCommonSize vCommonSize) {
        this.mFocusSize = vCommonSize;
    }

    public void setMethod(String str) {
        this.mMethod = str;
    }

    public void setOn(boolean z) {
        this.mOn = z;
    }

    public void setOpacity(float f) {
        this.mOpacity = f;
    }

    public void setOpacity2(float f) {
        this.mOpacity2 = f;
    }

    public void setOrigin(String str) {
        this.mOrigin = str;
    }

    public void setPosition(String str) {
        this.mPosition = str;
    }

    public void setSize(String str) {
        this.mSize = str;
    }

    public void setSrc(String str) {
        this.mSrc = str;
    }

    public void setType(String str) {
        this.mType = str;
    }

    @Override // com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementBase
    public String toString() {
        StringBuilder sb = new StringBuilder("Fill [mType=");
        sb.append(this.mType);
        sb.append(", mOn=");
        sb.append(this.mOn);
        sb.append(", mColor=");
        sb.append(this.mColor);
        sb.append(", mOpacity=");
        sb.append(this.mOpacity);
        sb.append(", mColor2=");
        sb.append(this.mColor2);
        sb.append(", mOpacity2=");
        sb.append(this.mOpacity2);
        sb.append(", mSrc=");
        sb.append(this.mSrc);
        sb.append(", mSize=");
        sb.append(this.mSize);
        sb.append(", mOrigin=");
        sb.append(this.mOrigin);
        sb.append(", mPosition=");
        sb.append(this.mPosition);
        sb.append(", mAspect=");
        sb.append(this.mAspect);
        sb.append(", mAlignShape=");
        sb.append(this.mAlignShape);
        sb.append(", mColors=");
        sb.append(this.mColors);
        sb.append(", mAngle=");
        sb.append(this.mAngle);
        sb.append(", mFocus=");
        sb.append(this.mFocus);
        sb.append(", mFocusSize=");
        sb.append(this.mFocusSize);
        sb.append(", mFocusPosition=");
        sb.append(this.mFocusPosition);
        sb.append(", mMethod=");
        sb.append(this.mMethod);
        sb.append(", toString()=");
        return AbstractC0622a.m1170p(super.toString(), "]", sb);
    }

    public void setAngle(String str) {
        setAngle(VUtilString.parseFloat(str));
    }

    public void setFocus(String str) {
        setFocus(VUtilString.parseFloat(str));
    }

    public void setFocusPosition(String str) {
        this.mFocusPosition.setPoint(str);
    }

    public void setFocusSize(String str) {
        this.mFocusSize.setSize(str);
    }

    public void setOn(String str) {
        setOn(VUtilString.parseBoolean(str));
    }

    public void setOpacity(String str) {
        setOpacity(VUtilString.parseFloat(str));
    }

    public void setOpacity2(String str) {
        setOpacity2(VUtilString.parseFloat(str));
    }
}
