package com.samsung.android.sdk.pen.recoguifeature.math;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatSeekBar;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014J(\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J \u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J \u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/math/SpenMathDialerSeekBar;", "Landroidx/appcompat/widget/AppCompatSeekBar;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mContext", "close", "", "initView", "onDraw", "canvas", "Landroid/graphics/Canvas;", "drawProgressLine", "paint", "Landroid/graphics/Paint;", "lineHeight", "", "radius", "drawSelectedProgressLine", "drawMilestone", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenMathDialerSeekBar extends AppCompatSeekBar {

    @NotNull
    private static final String TAG = "SpenMathDialerSeekBar";

    @Nullable
    private Context mContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenMathDialerSeekBar(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        initView(context);
    }

    private final void drawMilestone(Canvas canvas, Paint paint, float radius) {
        Resources resources;
        RectF rectF = new RectF();
        float f = 2;
        rectF.set((getWidth() / f) - 2.0f, (getHeight() / f) - 10.0f, (getWidth() / f) + 2.0f, (getHeight() / f) + 10.0f);
        Context context = this.mContext;
        paint.setColor((context == null || (resources = context.getResources()) == null) ? 0 : resources.getColor(C7932R.color.math_dialer_seek_bar_milestone_color));
        canvas.drawRoundRect(rectF, radius, radius, paint);
    }

    private final void drawProgressLine(Canvas canvas, Paint paint, float lineHeight, float radius) {
        Resources resources;
        RectF rectF = new RectF();
        float f = 2;
        float f4 = lineHeight / f;
        rectF.set(getThumbOffset(), (getHeight() / f) - f4, getWidth() - getThumbOffset(), (getHeight() / f) + f4);
        Context context = this.mContext;
        paint.setColor((context == null || (resources = context.getResources()) == null) ? 0 : resources.getColor(C7932R.color.setting_handwriting_slider_progress_bg_color));
        canvas.drawRoundRect(rectF, radius, radius, paint);
    }

    private final void drawSelectedProgressLine(Canvas canvas, Paint paint, float lineHeight) {
        Resources resources;
        Configuration configuration;
        Resources resources2;
        Context context = this.mContext;
        boolean z = false;
        paint.setColor((context == null || (resources2 = context.getResources()) == null) ? 0 : resources2.getColor(C7932R.color.math_dialer_seek_bar_progress_color));
        int max = getMax() / 2;
        int width = getWidth() - (getThumbOffset() * 2);
        Context context2 = this.mContext;
        if (context2 != null && (resources = context2.getResources()) != null && (configuration = resources.getConfiguration()) != null && configuration.getLayoutDirection() == 1) {
            z = true;
        }
        RectF rectF = new RectF();
        float f = 2;
        float f4 = lineHeight / f;
        rectF.set(0.0f, (getHeight() / f) - f4, 0.0f, (getHeight() / f) + f4);
        if (getProgress() > max) {
            if (z) {
                float f5 = width;
                float f6 = f5 / f;
                rectF.left = (getThumbOffset() + f6) - ((getProgress() - max) * (f5 / getMax()));
                rectF.right = getThumbOffset() + f6;
            } else {
                float f7 = width;
                float thumbOffset = (f7 / f) + getThumbOffset();
                rectF.left = thumbOffset;
                rectF.right = AbstractC0000a.m29z(getProgress(), max, f7 / getMax(), thumbOffset);
            }
            canvas.drawRect(rectF, paint);
            return;
        }
        if (getProgress() < max) {
            if (z) {
                float f8 = width;
                float thumbOffset2 = (f8 / f) + getThumbOffset();
                rectF.left = thumbOffset2;
                rectF.right = AbstractC0000a.m29z(max, getProgress(), f8 / getMax(), thumbOffset2);
            } else {
                float f9 = width;
                float f10 = f9 / f;
                rectF.left = (getThumbOffset() + f10) - ((max - getProgress()) * (f9 / getMax()));
                rectF.right = getThumbOffset() + f10;
            }
            canvas.drawRect(rectF, paint);
        }
    }

    private final void initView(Context context) {
        this.mContext = context;
    }

    public final void close() {
        this.mContext = null;
    }

    @Override // androidx.appcompat.widget.AppCompatSeekBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    public synchronized void onDraw(@NotNull Canvas canvas) {
        Resources resources;
        Resources resources2;
        try {
            Intrinsics.checkNotNullParameter(canvas, "canvas");
            Paint paint = new Paint();
            Context context = this.mContext;
            float dimensionPixelSize = 0.0f;
            float dimensionPixelSize2 = (context == null || (resources2 = context.getResources()) == null) ? 0.0f : resources2.getDimensionPixelSize(C7932R.dimen.math_dialer_seek_bar_height);
            Context context2 = this.mContext;
            if (context2 != null && (resources = context2.getResources()) != null) {
                dimensionPixelSize = resources.getDimensionPixelSize(C7932R.dimen.setting_slider_progress_bg_radius);
            }
            drawProgressLine(canvas, paint, dimensionPixelSize2, dimensionPixelSize);
            drawSelectedProgressLine(canvas, paint, dimensionPixelSize2);
            drawMilestone(canvas, paint, dimensionPixelSize);
            super.onDraw(canvas);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenMathDialerSeekBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        initView(context);
    }
}
