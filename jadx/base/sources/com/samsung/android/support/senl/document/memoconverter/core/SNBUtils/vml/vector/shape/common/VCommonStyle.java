package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.common;

import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.Key;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.util.VUtilString;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VCommonStyle {
    private float mFlip;
    private float mHeight;
    private float mLeft;
    private float mMarginLeft;
    private float mMarginTop;
    private String mPositon;
    private float mRotation;
    private float mTop;
    private String mVisibility;
    private float mWidth;
    private float mZIndex;

    public float getFlip() {
        return this.mFlip;
    }

    public float getHeight() {
        return this.mHeight;
    }

    public float getLeft() {
        return this.mLeft;
    }

    public float getMarginLeft() {
        return this.mMarginLeft;
    }

    public float getMarginTop() {
        return this.mMarginTop;
    }

    public String getPosition() {
        return this.mPositon;
    }

    public float getRotation() {
        return this.mRotation;
    }

    public float getTop() {
        return this.mTop;
    }

    public String getVisibility() {
        return this.mVisibility;
    }

    public float getWidth() {
        return this.mWidth;
    }

    public float getZIndex() {
        return this.mZIndex;
    }

    public void setFlip(float f) {
        this.mFlip = f;
    }

    public void setHeight(float f) {
        this.mHeight = f;
    }

    public void setLeft(float f) {
        this.mLeft = f;
    }

    public void setMarginLeft(float f) {
        this.mMarginLeft = f;
    }

    public void setMarginTop(float f) {
        this.mMarginTop = f;
    }

    public void setPositon(String str) {
        this.mPositon = str;
    }

    public void setRotation(float f) {
        this.mRotation = f;
    }

    public void setStyle(float f, float f4, String str, float f5, float f6, float f7, float f8, float f9, float f10, float f11) {
        this.mWidth = f;
        this.mHeight = f4;
        this.mPositon = str;
        this.mLeft = f5;
        this.mTop = f6;
        this.mMarginLeft = f7;
        this.mMarginTop = f8;
        this.mZIndex = f9;
        this.mFlip = f11;
    }

    public void setTop(float f) {
        this.mTop = f;
    }

    public void setVisibility(String str) {
        this.mVisibility = str;
    }

    public void setWidth(float f) {
        this.mWidth = f;
    }

    public void setZIndex(float f) {
        this.mZIndex = f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Style [mWidth=");
        sb.append(this.mWidth);
        sb.append(", mHeight=");
        sb.append(this.mHeight);
        sb.append(", mPositon=");
        sb.append(this.mPositon);
        sb.append(", mLeft=");
        sb.append(this.mLeft);
        sb.append(", mTop=");
        sb.append(this.mTop);
        sb.append(", mMarginLeft=");
        sb.append(this.mMarginLeft);
        sb.append(", mMarginTop=");
        sb.append(this.mMarginTop);
        sb.append(", mZIndex=");
        sb.append(this.mZIndex);
        sb.append(", mRotation=");
        sb.append(this.mRotation);
        sb.append(", mFlip=");
        sb.append(this.mFlip);
        sb.append(", mVisibility=");
        return AbstractC0622a.m1170p(this.mVisibility, "]", sb);
    }

    public void setStyle(String str) {
        if (str == null || str.length() == 0) {
            return;
        }
        ArrayList<String[]> arrayList = new ArrayList();
        StringTokenizer stringTokenizer = new StringTokenizer(str, ";");
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken().replaceAll("\\p{Space}", "").split(":"));
        }
        for (String[] strArr : arrayList) {
            if ("width".compareToIgnoreCase(strArr[0]) == 0) {
                this.mWidth = VUtilString.parseFloat(strArr[1]);
            } else if ("height".compareToIgnoreCase(strArr[0]) == 0) {
                this.mHeight = VUtilString.parseFloat(strArr[1]);
            } else if ("position".compareToIgnoreCase(strArr[0]) == 0) {
                this.mPositon = strArr[1];
            } else if ("left".compareToIgnoreCase(strArr[0]) == 0) {
                this.mLeft = VUtilString.parseFloat(strArr[1]);
            } else if ("top".compareToIgnoreCase(strArr[0]) == 0) {
                this.mTop = VUtilString.parseFloat(strArr[1]);
            } else if ("margin-left".compareToIgnoreCase(strArr[0]) == 0) {
                this.mMarginLeft = VUtilString.parseFloat(strArr[1]);
            } else if ("margin-top".compareToIgnoreCase(strArr[0]) == 0) {
                this.mMarginTop = VUtilString.parseFloat(strArr[1]);
            } else if ("z-index".compareToIgnoreCase(strArr[0]) == 0) {
                this.mZIndex = VUtilString.parseFloat(strArr[1]);
            } else if (Key.ROTATION.compareToIgnoreCase(strArr[0]) == 0) {
                this.mRotation = VUtilString.parseFloat(strArr[1]);
            } else if ("flip".compareToIgnoreCase(strArr[0]) == 0) {
                this.mFlip = VUtilString.parseFloat(strArr[1]);
            } else if ("visibility".compareToIgnoreCase(strArr[0]) == 0) {
                this.mVisibility = strArr[1];
            }
        }
    }
}
