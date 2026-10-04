package com.samsung.android.sdk.pen.setting.common;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0005H\u0016J\u0012\u0010\u0018\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/common/SpenSliderThumbDrawable;", "Landroid/graphics/drawable/Drawable;", "mContext", "Landroid/content/Context;", "seekBarMin", "", "seekBarMax", "<init>", "(Landroid/content/Context;II)V", "mPaint", "Landroid/graphics/Paint;", "mMinDotRadius", "mMaxDotRadius", "mRadius", "mThumbSize", "mTotalPoints", "mBackgroundColor", "mDotColor", "draw", "", "canvas", "Landroid/graphics/Canvas;", "setAlpha", "alpha", BaseWidgetConstant.SET_COLOR_FILTER, "colorFilter", "Landroid/graphics/ColorFilter;", "getOpacity", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenSliderThumbDrawable extends Drawable {
    private final int mBackgroundColor;

    @NotNull
    private final Context mContext;
    private final int mDotColor;
    private final int mMaxDotRadius;
    private final int mMinDotRadius;

    @NotNull
    private final Paint mPaint;
    private final int mRadius;
    private final int mThumbSize;
    private final int mTotalPoints;

    public SpenSliderThumbDrawable(@NotNull Context mContext, int i, int i2) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        this.mContext = mContext;
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.mMinDotRadius = mContext.getResources().getDimensionPixelSize(C7932R.dimen.setting_slider_progress_bg_min_dot_radius);
        this.mMaxDotRadius = mContext.getResources().getDimensionPixelSize(C7932R.dimen.setting_slider_progress_bg_max_dot_radius);
        this.mRadius = mContext.getResources().getDimensionPixelSize(C7932R.dimen.setting_slider_floating_thumb_drawable_radius);
        this.mThumbSize = mContext.getResources().getDimensionPixelSize(C7932R.dimen.floating_thumb_height);
        this.mTotalPoints = MathKt.roundToInt((i2 - i) / 10) + 1;
        this.mBackgroundColor = SpenSettingUtil.getColor(mContext, C7932R.color.setting_discrete_slider_bg);
        this.mDotColor = SpenSettingUtil.getColor(mContext, C7932R.color.setting_discrete_slider_dot);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.mPaint.setColor(this.mBackgroundColor);
        RectF rectF = new RectF(getBounds());
        int i = this.mRadius;
        canvas.drawRoundRect(rectF, i, i, this.mPaint);
        float fWidth = getBounds().width() - this.mThumbSize;
        int i2 = this.mTotalPoints;
        float f = fWidth / (i2 - 1);
        float f4 = (this.mMaxDotRadius - this.mMinDotRadius) / (i2 - 1);
        this.mPaint.setColor(this.mDotColor);
        int i4 = this.mTotalPoints;
        for (int i5 = 0; i5 < i4; i5++) {
            canvas.drawCircle((i5 * f) + (this.mThumbSize / 2.0f), getBounds().exactCenterY(), AbstractC0541b.m759a(this.mContext) == 1 ? this.mMaxDotRadius - (i5 * f4) : this.mMinDotRadius + (i5 * f4), this.mPaint);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.mPaint.setAlpha(alpha);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }
}
