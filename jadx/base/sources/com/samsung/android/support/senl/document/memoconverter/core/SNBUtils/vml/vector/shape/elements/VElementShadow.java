package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements;

import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.util.VUtilString;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.common.VCommonPoint;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VElementShadow extends VElementBase {
    public static final String NAME = "v:shadow";
    private String mColor;
    private String mColor2;
    private String mMatrix;
    private boolean mObscured;
    private VCommonPoint mOffset;
    private VCommonPoint mOffset2;
    private boolean mOn;
    private float mOpacity;
    private float mOpacity2;
    private VCommonPoint mOrigin;
    private String mType;

    public String getColor() {
        return this.mColor;
    }

    public String getColor2() {
        return this.mColor2;
    }

    public String getMatrix() {
        return this.mMatrix;
    }

    public VCommonPoint getOffset() {
        return this.mOffset;
    }

    public VCommonPoint getOffset2() {
        return this.mOffset2;
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

    public VCommonPoint getOrigin() {
        return this.mOrigin;
    }

    public String getType() {
        return this.mType;
    }

    public boolean ismObscured() {
        return this.mObscured;
    }

    public void setColor(String str) {
        this.mColor = str;
    }

    public void setColor2(String str) {
        this.mColor2 = str;
    }

    @Override // com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementBase
    public void setDefaultMember() {
        this.mOffset = new VCommonPoint();
        this.mOffset2 = new VCommonPoint();
        this.mOrigin = new VCommonPoint();
    }

    public void setMatrix(String str) {
        this.mMatrix = str;
    }

    public void setObscured(boolean z) {
        this.mObscured = z;
    }

    public void setOffset(VCommonPoint vCommonPoint) {
        this.mOffset = vCommonPoint;
    }

    public void setOffset2(VCommonPoint vCommonPoint) {
        this.mOffset2 = vCommonPoint;
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

    public void setOrigin(VCommonPoint vCommonPoint) {
        this.mOrigin = vCommonPoint;
    }

    public void setType(String str) {
        this.mType = str;
    }

    @Override // com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementBase
    public String toString() {
        StringBuilder sb = new StringBuilder("Shadow [mOn=");
        sb.append(this.mOn);
        sb.append(", mType=");
        sb.append(this.mType);
        sb.append(", mObscured=");
        sb.append(this.mObscured);
        sb.append(", mColor=");
        sb.append(this.mColor);
        sb.append(", mOpacity=");
        sb.append(this.mOpacity);
        sb.append(", mOffset=");
        sb.append(this.mOffset);
        sb.append(", mColor2=");
        sb.append(this.mColor2);
        sb.append(", mOpacity2=");
        sb.append(this.mOpacity2);
        sb.append(", mOffset2=");
        sb.append(this.mOffset2);
        sb.append(", mOrigin=");
        sb.append(this.mOrigin);
        sb.append(", mMatrix=");
        sb.append(this.mMatrix);
        sb.append(", toString()=");
        return AbstractC0622a.m1170p(super.toString(), "]", sb);
    }

    public void setObscured(String str) {
        setObscured(VUtilString.parseBoolean(str));
    }

    public void setOffset(String str) {
        this.mOffset.setPoint(str);
    }

    public void setOffset2(String str) {
        this.mOffset2.setPoint(str);
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

    public void setOrigin(String str) {
        this.mOrigin.setPoint(str);
    }
}
