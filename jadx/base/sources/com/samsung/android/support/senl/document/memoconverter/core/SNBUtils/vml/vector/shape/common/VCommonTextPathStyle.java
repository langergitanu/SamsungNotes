package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.common;

import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.util.VUtilString;
import java.util.ArrayList;
import java.util.StringTokenizer;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VCommonTextPathStyle {
    private String mFont;
    private String mFontFamily;
    private String mFontSize;
    private String mFontStyle;
    private String mFontVariant;
    private String mFontWeight;
    private float mLetterTightening;
    private float mLetterTracking;
    private boolean mRotateLetters;
    private boolean mSameLetterHeights;
    private String mTextAlign;
    private String mTextAlignAlt;
    private String mTextDecoration;
    private boolean mTextKern;
    private boolean mTextShadow;

    public String getFont() {
        return this.mFont;
    }

    public String getFontFamily() {
        return this.mFontFamily;
    }

    public String getFontSize() {
        return this.mFontSize;
    }

    public String getFontStyle() {
        return this.mFontStyle;
    }

    public String getFontVariant() {
        return this.mFontVariant;
    }

    public String getFontWeight() {
        return this.mFontWeight;
    }

    public float getLetterTightening() {
        return this.mLetterTightening;
    }

    public float getLetterTracking() {
        return this.mLetterTracking;
    }

    public boolean getRotateLetters() {
        return this.mRotateLetters;
    }

    public boolean getSameLetterHeights() {
        return this.mSameLetterHeights;
    }

    public String getTextAlign() {
        return this.mTextAlign;
    }

    public String getTextAlignAlt() {
        return this.mTextAlignAlt;
    }

    public String getTextDecoration() {
        return this.mTextDecoration;
    }

    public boolean getTextKern() {
        return this.mTextKern;
    }

    public boolean getTextShadow() {
        return this.mTextShadow;
    }

    public void setFont(String str) {
        this.mFont = str;
    }

    public void setFontFamily(String str) {
        this.mFontFamily = str;
    }

    public void setFontSize(String str) {
        this.mFontSize = str;
    }

    public void setFontStyle(String str) {
        this.mFontStyle = str;
    }

    public void setFontVariant(String str) {
        this.mFontVariant = str;
    }

    public void setFontWeight(String str) {
        this.mFontWeight = str;
    }

    public void setLetterTightening(float f) {
        this.mLetterTightening = f;
    }

    public void setLetterTracking(float f) {
        this.mLetterTracking = f;
    }

    public void setRotateLetters(boolean z) {
        this.mRotateLetters = z;
    }

    public void setSameLetterHeights(boolean z) {
        this.mSameLetterHeights = z;
    }

    public void setStyle(String str) {
        ArrayList<String[]> arrayList = new ArrayList();
        StringTokenizer stringTokenizer = new StringTokenizer(str, ";");
        while (stringTokenizer.hasMoreTokens()) {
            arrayList.add(stringTokenizer.nextToken().split(":"));
        }
        for (String[] strArr : arrayList) {
            if ("font".compareToIgnoreCase(strArr[0]) == 0) {
                this.mFont = strArr[1];
            } else if ("font-family".compareToIgnoreCase(strArr[0]) == 0) {
                this.mFontFamily = strArr[1];
            } else if ("font-style".compareToIgnoreCase(strArr[0]) == 0) {
                this.mFontStyle = strArr[1];
            } else if ("font-weight".compareToIgnoreCase(strArr[0]) == 0) {
                this.mFontWeight = strArr[1];
            } else if ("font-size".compareToIgnoreCase(strArr[0]) == 0) {
                this.mFontSize = strArr[1];
            } else if ("font-variant".compareToIgnoreCase(strArr[0]) == 0) {
                this.mFontVariant = strArr[1];
            } else if ("text-decoration".compareToIgnoreCase(strArr[0]) == 0) {
                this.mTextDecoration = strArr[1];
            } else if ("v-text-shadow".compareToIgnoreCase(strArr[0]) == 0) {
                this.mTextShadow = VUtilString.parseBoolean(strArr[1]);
            } else if ("text-align".compareToIgnoreCase(strArr[0]) == 0) {
                this.mTextAlign = strArr[1];
            } else if ("v-text-align-alt".compareToIgnoreCase(strArr[0]) == 0) {
                this.mTextAlignAlt = strArr[1];
            } else if ("v-letter-tightening".compareToIgnoreCase(strArr[0]) == 0) {
                this.mLetterTightening = VUtilString.parseFloat(strArr[1]);
            } else if ("v-letter-tracking".compareToIgnoreCase(strArr[0]) == 0) {
                this.mLetterTracking = VUtilString.parseFloat(strArr[1]);
            } else if ("v-text-kern".compareToIgnoreCase(strArr[0]) == 0) {
                this.mTextKern = VUtilString.parseBoolean(strArr[1]);
            } else if ("v-rotate-letters".compareToIgnoreCase(strArr[0]) == 0) {
                this.mRotateLetters = VUtilString.parseBoolean(strArr[1]);
            } else if ("v-same-letter-heights".compareToIgnoreCase(strArr[0]) == 0) {
                this.mSameLetterHeights = VUtilString.parseBoolean(strArr[1]);
            }
        }
    }

    public void setTextAlign(String str) {
        this.mTextAlign = str;
    }

    public void setTextAlignAlt(String str) {
        this.mTextAlignAlt = str;
    }

    public void setTextDecoration(String str) {
        this.mTextDecoration = str;
    }

    public void setTextKern(boolean z) {
        this.mTextKern = z;
    }

    public void setTextShadow(boolean z) {
        this.mTextShadow = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("TextPathStyle [mFont=");
        sb.append(this.mFont);
        sb.append(", mFontFamily=");
        sb.append(this.mFontFamily);
        sb.append(", mFontStyle=");
        sb.append(this.mFontStyle);
        sb.append(", mFontWeight=");
        sb.append(this.mFontWeight);
        sb.append(", mFontSize=");
        sb.append(this.mFontSize);
        sb.append(", mFontVariant=");
        sb.append(this.mFontVariant);
        sb.append(", mTextDecoration=");
        sb.append(this.mTextDecoration);
        sb.append(", mTextShadow=");
        sb.append(this.mTextShadow);
        sb.append(", mTextAlign=");
        sb.append(this.mTextAlign);
        sb.append(", mTextAlignAlt=");
        sb.append(this.mTextAlignAlt);
        sb.append(", mLetterTightening=");
        sb.append(this.mLetterTightening);
        sb.append(", mLetterTracking=");
        sb.append(this.mLetterTracking);
        sb.append(", mTextKern=");
        sb.append(this.mTextKern);
        sb.append(", mRotateLetters=");
        sb.append(this.mRotateLetters);
        sb.append(", mSameLetterHeights=");
        return AbstractC0000a.m14k(sb, this.mSameLetterHeights, "]");
    }
}
