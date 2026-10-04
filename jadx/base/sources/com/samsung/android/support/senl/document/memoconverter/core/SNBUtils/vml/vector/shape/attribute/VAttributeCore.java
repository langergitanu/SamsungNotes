package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.attribute;

import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.common.VCommonCoordOrigin;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.common.VCommonCoordSize;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.common.VCommonStyle;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VAttributeCore {
    private String mAlt;
    private String mClsName;
    private VCommonCoordOrigin mCoordOrigin;
    private VCommonCoordSize mCoordSize;
    private String mHref;
    private String mId;
    private VCommonStyle mStyle;
    private String mTitle;
    private String mWrapCoords;

    public String geWrapCoords() {
        return this.mWrapCoords;
    }

    public String getAlt() {
        return this.mAlt;
    }

    public String getClsName() {
        return this.mClsName;
    }

    public VCommonCoordOrigin getCoordOrigin() {
        return this.mCoordOrigin;
    }

    public VCommonCoordSize getCoordSize() {
        return this.mCoordSize;
    }

    public String getHref() {
        return this.mHref;
    }

    public String getId() {
        return this.mId;
    }

    public VCommonStyle getStyle() {
        return this.mStyle;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public void setAlt(String str) {
        this.mAlt = str;
    }

    public void setClsName(String str) {
        this.mClsName = str;
    }

    public void setCoordOrigin(VCommonCoordOrigin vCommonCoordOrigin) {
        this.mCoordOrigin = vCommonCoordOrigin;
    }

    public void setCoordSize(VCommonCoordSize vCommonCoordSize) {
        this.mCoordSize = vCommonCoordSize;
    }

    public void setDefaultMember() {
        this.mStyle = new VCommonStyle();
        this.mCoordSize = new VCommonCoordSize();
        this.mCoordOrigin = new VCommonCoordOrigin();
    }

    public void setHref(String str) {
        this.mHref = str;
    }

    public void setId(String str) {
        this.mId = str;
    }

    public void setStyle(String str) {
        this.mStyle.setStyle(str);
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void setWrapCoords(String str) {
        this.mWrapCoords = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CoreAttrs [mId=");
        sb.append(this.mId);
        sb.append(", mClsName=");
        sb.append(this.mClsName);
        sb.append(", mTitle=");
        sb.append(this.mTitle);
        sb.append(", mStyle=");
        sb.append(this.mStyle);
        sb.append(", mHref=");
        sb.append(this.mHref);
        sb.append(", mAlt=");
        sb.append(this.mAlt);
        sb.append(", mCoordSize=");
        sb.append(this.mCoordSize);
        sb.append(", mCoordOrigin=");
        sb.append(this.mCoordOrigin);
        sb.append(", mWrapCoords=");
        return AbstractC0622a.m1170p(this.mWrapCoords, "]", sb);
    }

    public void setCoordOrigin(String str) {
        this.mCoordOrigin.setCoordOrigin(str);
    }

    public void setCoordSize(String str) {
        this.mCoordSize.setCoordSize(str);
    }
}
