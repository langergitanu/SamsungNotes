package com.samsung.android.support.senl.p148nt.app.main.common.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class CustomImageSpan extends ImageSpan {
    private final int mSize;

    public CustomImageSpan(Drawable drawable, int i) {
        super(drawable);
        this.mSize = i;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i, int i2, float f, int i4, int i5, int i6, Paint paint) {
        Drawable drawable = getDrawable();
        int i7 = ((i5 + paint.getFontMetricsInt().descent) + (paint.getFontMetricsInt().ascent + i5)) / 2;
        int i8 = (int) f;
        int i9 = this.mSize;
        drawable.setBounds(i8, i7 - (i9 / 2), i8 + i9, (i9 / 2) + i7);
        drawable.draw(canvas);
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i, int i2, Paint.FontMetricsInt fontMetricsInt) {
        return this.mSize;
    }
}
