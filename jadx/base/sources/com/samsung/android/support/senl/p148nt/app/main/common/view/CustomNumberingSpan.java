package com.samsung.android.support.senl.p148nt.app.main.common.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;
import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class CustomNumberingSpan implements LeadingMarginSpan {
    private final int mColor;
    private final int mGapWidth;
    private final int mIndentLevel;
    private int mIndentWidth;
    private final String mIndex;
    private final int mLeadWidth;
    private final int mTextSize;

    public CustomNumberingSpan(int i, int i2, String str, int i4, int i5, int i6) {
        this.mGapWidth = i;
        this.mLeadWidth = i2;
        this.mIndex = str;
        this.mColor = i4;
        this.mIndentLevel = i5;
        this.mTextSize = i6;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i4, int i5, int i6, CharSequence charSequence, int i7, int i8, boolean z, Layout layout) {
        if (z) {
            Paint.Style style = paint.getStyle();
            float textSize = paint.getTextSize();
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(this.mColor);
            paint.setTextSize(this.mTextSize);
            canvas.drawText(AbstractC0622a.m1170p(this.mIndex, Extension.DOT, new StringBuilder()), (((float) i) - (paint.measureText(this.mIndex + " ") / 2.0f)) + ((float) ((this.mIndentWidth + this.mLeadWidth) * i2)), (float) i5, paint);
            paint.setStyle(style);
            paint.setTextSize(textSize);
        }
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z) {
        int i = this.mIndentLevel * 16;
        this.mIndentWidth = i;
        return i + this.mLeadWidth + this.mGapWidth;
    }
}
