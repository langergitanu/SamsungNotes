package com.samsung.android.support.senl.p148nt.app.main.common.view;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.style.DrawableMarginSpan;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class CustomImageMarginSpan extends DrawableMarginSpan {
    private final Drawable mDrawable;
    private final boolean mHasLeftMargin;
    private final int mIndentLevel;
    private int mIndentWidth;
    private final int mPaddingRight;
    private final int mSize;
    private final int mStart;

    public CustomImageMarginSpan(int i, Drawable drawable, int i2, int i4, boolean z, int i5) {
        super(drawable, i2);
        this.mDrawable = drawable;
        this.mPaddingRight = i2;
        this.mSize = i4;
        this.mStart = i;
        this.mHasLeftMargin = z;
        this.mIndentLevel = i5;
    }

    @Override // android.text.style.DrawableMarginSpan, android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i2, int i4, int i5, int i6, CharSequence charSequence, int i7, int i8, boolean z, Layout layout) {
        int i9;
        int i10;
        int i11;
        if (i7 != this.mStart) {
            return;
        }
        int i12 = ((i5 + paint.getFontMetricsInt().descent) + (paint.getFontMetricsInt().ascent + i5)) / 2;
        if (i2 < 0) {
            i10 = i - this.mIndentWidth;
            i11 = this.mSize;
        } else {
            if (!this.mHasLeftMargin) {
                i9 = i + this.mIndentWidth;
                canvas.save();
                Drawable drawable = this.mDrawable;
                int i13 = this.mSize;
                drawable.setBounds(i9, i12 - (i13 / 2), i9 + i13, (i13 / 2) + i12);
                this.mDrawable.draw(canvas);
            }
            i10 = i + this.mIndentWidth;
            i11 = (int) (this.mSize * 0.1f);
        }
        i9 = i10 - i11;
        canvas.save();
        Drawable drawable2 = this.mDrawable;
        int i132 = this.mSize;
        drawable2.setBounds(i9, i12 - (i132 / 2), i9 + i132, (i132 / 2) + i12);
        this.mDrawable.draw(canvas);
    }

    @Override // android.text.style.DrawableMarginSpan, android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z) {
        int i = this.mIndentLevel * 16;
        this.mIndentWidth = i;
        return i + this.mSize + this.mPaddingRight;
    }
}
