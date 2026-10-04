package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.attribute;

import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.util.VUtilString;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VAttributeShape {
    private String mChromaKey;
    private boolean mFill;
    private String mFillColor;
    private float mOpacity;
    private String mPrint;
    private boolean mStroke;
    private String mStrokeColor;
    private float mStrokeWeight;

    public String getChromaKey() {
        return this.mChromaKey;
    }

    public boolean getFill() {
        return this.mFill;
    }

    public String getFillColor() {
        return this.mFillColor;
    }

    public float getOpacity() {
        return this.mOpacity;
    }

    public String getPrint() {
        return this.mPrint;
    }

    public boolean getStroke() {
        return this.mStroke;
    }

    public String getStrokeColor() {
        return this.mStrokeColor;
    }

    public float getStrokeWeight() {
        return this.mStrokeWeight;
    }

    public void setChromaKey(String str) {
        this.mChromaKey = str;
    }

    public void setFill(boolean z) {
        this.mFill = z;
    }

    public void setFillColor(String str) {
        this.mFillColor = str;
    }

    public void setOpacity(float f) {
        this.mOpacity = f;
    }

    public void setPrint(String str) {
        this.mPrint = str;
    }

    public void setStroke(boolean z) {
        this.mStroke = z;
    }

    public void setStrokeColor(String str) {
        this.mStrokeColor = str;
    }

    public void setStrokeWeight(float f) {
        this.mStrokeWeight = f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ShapeAttrs [mOpacity=");
        sb.append(this.mOpacity);
        sb.append(", mChromaKey=");
        sb.append(this.mChromaKey);
        sb.append(", mStroke=");
        sb.append(this.mStroke);
        sb.append(", mStrokeColor=");
        sb.append(this.mStrokeColor);
        sb.append(", mStrokeWeight=");
        sb.append(this.mStrokeWeight);
        sb.append(", mFill=");
        sb.append(this.mFill);
        sb.append(", mFillColor=");
        sb.append(this.mFillColor);
        sb.append(", mPrint=");
        return AbstractC0622a.m1170p(this.mPrint, "]", sb);
    }

    public void setFill(String str) {
        if (str == null || str.isEmpty()) {
            setFill(true);
        } else {
            setFill(VUtilString.parseBoolean(str));
        }
    }

    public void setOpacity(String str) {
        if (str == null) {
            return;
        }
        if (Pattern.compile(".*[%]*").matcher(str).matches() && str.endsWith("%")) {
            str = AbstractC2322a.m1614d(1, 0, str);
        }
        setOpacity(Float.parseFloat(str));
    }

    public void setStroke(String str) {
        if (str == null || str.isEmpty()) {
            setStroke(true);
        } else {
            setStroke(VUtilString.parseBoolean(str));
        }
    }

    public void setStrokeWeight(String str) {
        setStrokeWeight(VUtilString.parseFloat(str));
    }

    public void setDefaultMember() {
    }
}
