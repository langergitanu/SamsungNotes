package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements;

import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.util.VUtilString;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.common.VCommonTextPathStyle;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VElementTextPath extends VElementBase {
    public static final String NAME = "v:textpath";
    private boolean mFitPath;
    private boolean mFitShape;
    private boolean mOn;
    private VCommonTextPathStyle mStyle;
    private String mText;
    private boolean mTrim;
    private boolean mXScale;

    public boolean getFitPath() {
        return this.mFitPath;
    }

    public boolean getFitShape() {
        return this.mFitShape;
    }

    public boolean getOn() {
        return this.mOn;
    }

    public VCommonTextPathStyle getStyle() {
        return this.mStyle;
    }

    public String getText() {
        return this.mText;
    }

    public boolean getTrim() {
        return this.mTrim;
    }

    public boolean getXScale() {
        return this.mXScale;
    }

    @Override // com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementBase
    public void setDefaultMember() {
        this.mStyle = new VCommonTextPathStyle();
    }

    public void setFitPath(boolean z) {
        this.mFitPath = z;
    }

    public void setFitShape(boolean z) {
        this.mFitShape = z;
    }

    public void setOn(boolean z) {
        this.mOn = z;
    }

    public void setStyle(VCommonTextPathStyle vCommonTextPathStyle) {
        this.mStyle = vCommonTextPathStyle;
    }

    public void setText(String str) {
        this.mText = str;
    }

    public void setTrim(boolean z) {
        this.mTrim = z;
    }

    public void setXScale(boolean z) {
        this.mXScale = z;
    }

    @Override // com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementBase
    public String toString() {
        StringBuilder sb = new StringBuilder("TextPath [mOn=");
        sb.append(this.mOn);
        sb.append(", mStyle=");
        sb.append(this.mStyle);
        sb.append(", mFitShape=");
        sb.append(this.mFitShape);
        sb.append(", mFitPath=");
        sb.append(this.mFitPath);
        sb.append(", mTrim=");
        sb.append(this.mTrim);
        sb.append(", mXScale=");
        sb.append(this.mXScale);
        sb.append(", mText=");
        sb.append(this.mText);
        sb.append(", toString()=");
        return AbstractC0622a.m1170p(super.toString(), "]", sb);
    }

    public void setFitPath(String str) {
        setFitPath(VUtilString.parseBoolean(str));
    }

    public void setFitShape(String str) {
        setFitShape(VUtilString.parseBoolean(str));
    }

    public void setOn(String str) {
        setOn(VUtilString.parseBoolean(str));
    }

    public void setStyle(String str) {
        this.mStyle.setStyle(str);
    }

    public void setTrim(String str) {
        setTrim(VUtilString.parseBoolean(str));
    }

    public void setXScale(String str) {
        setXScale(VUtilString.parseBoolean(str));
    }
}
