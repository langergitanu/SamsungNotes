package com.airbnb.lottie.model;

import android.graphics.PointF;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.compose.foundation.layout.AbstractC1038a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class DocumentData {
    public float baselineShift;

    @Nullable
    public PointF boxPosition;

    @Nullable
    public PointF boxSize;

    @ColorInt
    public int color;
    public String fontName;
    public Justification justification;
    public float lineHeight;
    public float size;

    @ColorInt
    public int strokeColor;
    public boolean strokeOverFill;
    public float strokeWidth;
    public String text;
    public int tracking;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Justification {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public DocumentData(String str, String str2, float f, Justification justification, int i, float f4, float f5, @ColorInt int i2, @ColorInt int i4, float f6, boolean z, PointF pointF, PointF pointF2) {
        set(str, str2, f, justification, i, f4, f5, i2, i4, f6, z, pointF, pointF2);
    }

    public int hashCode() {
        int iOrdinal = ((this.justification.ordinal() + (((int) (AbstractC1038a.m1202c(this.text.hashCode() * 31, 31, this.fontName) + this.size)) * 31)) * 31) + this.tracking;
        long jFloatToRawIntBits = Float.floatToRawIntBits(this.lineHeight);
        return (((iOrdinal * 31) + ((int) (jFloatToRawIntBits ^ (jFloatToRawIntBits >>> 32)))) * 31) + this.color;
    }

    public void set(String str, String str2, float f, Justification justification, int i, float f4, float f5, @ColorInt int i2, @ColorInt int i4, float f6, boolean z, PointF pointF, PointF pointF2) {
        this.text = str;
        this.fontName = str2;
        this.size = f;
        this.justification = justification;
        this.tracking = i;
        this.lineHeight = f4;
        this.baselineShift = f5;
        this.color = i2;
        this.strokeColor = i4;
        this.strokeWidth = f6;
        this.strokeOverFill = z;
        this.boxPosition = pointF;
        this.boxSize = pointF2;
    }

    public DocumentData() {
    }
}
