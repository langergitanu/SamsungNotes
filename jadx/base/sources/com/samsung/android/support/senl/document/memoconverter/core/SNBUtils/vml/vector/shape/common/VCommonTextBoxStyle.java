package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.common;

import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.util.VUtilString;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VCommonTextBoxStyle {
    private String mPaddingAuto;
    private float mPaddingBottom;
    private float mPaddingLeft;
    private float mPaddingRight;
    private float mPaddingTop;
    private String mTextAnchor;
    private String mTextDirection;
    private String mTextFlow;
    private String mTextWrapping;

    public String getPaddingAuto() {
        return this.mPaddingAuto;
    }

    public float getPaddingBottom() {
        return this.mPaddingBottom;
    }

    public float getPaddingLeft() {
        return this.mPaddingLeft;
    }

    public float getPaddingRight() {
        return this.mPaddingRight;
    }

    public float getPaddingTop() {
        return this.mPaddingTop;
    }

    public String getTextAnchor() {
        return this.mTextAnchor;
    }

    public String getTextDirection() {
        return this.mTextDirection;
    }

    public String getTextFlow() {
        return this.mTextFlow;
    }

    public String getTextWrapping() {
        return this.mTextWrapping;
    }

    public void setPaddingAuto(String str) {
        this.mPaddingAuto = str;
    }

    public void setPaddingBottom(float f) {
        this.mPaddingBottom = f;
    }

    public void setPaddingLeft(float f) {
        this.mPaddingLeft = f;
    }

    public void setPaddingRight(float f) {
        this.mPaddingRight = f;
    }

    public void setPaddingTop(float f) {
        this.mPaddingTop = f;
    }

    public void setStyle(String str) {
        ArrayList<String[]> arrayList = new ArrayList();
        StringTokenizer stringTokenizer = new StringTokenizer(str, ";");
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken().split(":"));
        }
        for (String[] strArr : arrayList) {
            if ("v-padding-auto".compareToIgnoreCase(strArr[0]) == 0) {
                this.mPaddingAuto = strArr[1];
            } else if ("padding-left".compareToIgnoreCase(strArr[0]) == 0) {
                this.mPaddingLeft = VUtilString.parseFloat(strArr[1]);
            } else if ("padding-top".compareToIgnoreCase(strArr[0]) == 0) {
                this.mPaddingTop = VUtilString.parseFloat(strArr[1]);
            } else if ("padding-right".compareToIgnoreCase(strArr[0]) == 0) {
                this.mPaddingRight = VUtilString.parseFloat(strArr[1]);
            } else if ("padding-bottom".compareToIgnoreCase(strArr[0]) == 0) {
                this.mPaddingBottom = VUtilString.parseFloat(strArr[1]);
            } else if ("v-text-anchor".compareToIgnoreCase(strArr[0]) == 0) {
                this.mTextAnchor = strArr[1];
            } else if ("v-text-wrapping".compareToIgnoreCase(strArr[0]) == 0) {
                this.mTextWrapping = strArr[1];
            } else if ("v-text-flow".compareToIgnoreCase(strArr[0]) == 0) {
                this.mTextFlow = strArr[1];
            } else if ("v-text-direction".compareToIgnoreCase(strArr[0]) == 0) {
                this.mTextDirection = strArr[1];
            }
        }
    }

    public void setTextAnchor(String str) {
        this.mTextAnchor = str;
    }

    public void setTextDirection(String str) {
        this.mTextDirection = str;
    }

    public void setTextFlow(String str) {
        this.mTextFlow = str;
    }

    public void setTextWrapping(String str) {
        this.mTextWrapping = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TextBoxStyle [mPaddingAuto=");
        sb.append(this.mPaddingAuto);
        sb.append(", mPaddingLeft=");
        sb.append(this.mPaddingLeft);
        sb.append(", mPaddingTop=");
        sb.append(this.mPaddingTop);
        sb.append(", mPaddingRight=");
        sb.append(this.mPaddingRight);
        sb.append(", mPaddingBottom=");
        sb.append(this.mPaddingBottom);
        sb.append(", mTextAnchor=");
        sb.append(this.mTextAnchor);
        sb.append(", mTextWrapping=");
        sb.append(this.mTextWrapping);
        sb.append(", mTextFlow=");
        sb.append(this.mTextFlow);
        sb.append(", mTextDirection=");
        return AbstractC0622a.m1170p(this.mTextDirection, "]", sb);
    }
}
