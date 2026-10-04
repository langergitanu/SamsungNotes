package com.samsung.android.sdk.pen.setting.common;

import android.R;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.pen.setting.common.SpenSlider;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAdaptiveColor;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u0012\b\u0000\u0018\u0000 O2\u00020\u0001:\u0001OB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u001f\u001a\u00020 J\b\u0010!\u001a\u00020 H\u0002J(\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u001d2\b\u0010'\u001a\u0004\u0018\u00010\u000bJ2\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020$2\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u001d2\b\u0010'\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010*\u001a\u00020 2\u0006\u0010+\u001a\u00020\u0018J\u000e\u0010,\u001a\u00020 2\u0006\u0010-\u001a\u00020\u0016J\u000e\u0010.\u001a\u00020 2\u0006\u0010-\u001a\u00020\u0016J\u000e\u0010/\u001a\u00020 2\u0006\u00100\u001a\u00020\u0016J\u0010\u00101\u001a\u00020 2\u0006\u00100\u001a\u00020\u0016H\u0004J\u000e\u00102\u001a\u00020 2\u0006\u00100\u001a\u00020\u0016J\u000e\u00103\u001a\u00020 2\u0006\u0010-\u001a\u00020\u0016J\u0012\u0010.\u001a\u00020 2\n\u00104\u001a\u000205\"\u00020\u0016J\u0010\u0010D\u001a\u00020 2\u0006\u0010-\u001a\u00020\u0016H\u0002J\u0010\u0010E\u001a\u00020 2\u0006\u0010-\u001a\u00020\u0016H\u0002J\u001c\u0010L\u001a\u0004\u0018\u00010\b2\u0006\u0010M\u001a\u00020\u000b2\b\b\u0002\u0010N\u001a\u00020\u0016H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u00106\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b6\u00107R\u0013\u00108\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b9\u0010:R\u0013\u0010;\u001a\u0004\u0018\u00010\u00058F¢\u0006\u0006\u001a\u0004\b<\u0010:R\u001b\u0010=\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010>8F¢\u0006\u0006\u001a\u0004\b?\u0010@R\u001b\u0010A\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0018\u00010>8F¢\u0006\u0006\u001a\u0004\bB\u0010CR\u0016\u0010F\u001a\u0004\u0018\u00010\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bG\u0010HR\u0016\u0010I\u001a\u0004\u0018\u00010\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bJ\u0010K¨\u0006P"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/common/SpenSeekBarColorControl;", "", "<init>", "()V", "mScaleThumbColorDrawable", "Landroid/graphics/drawable/ScaleDrawable;", "mScaleThumbStrokeDrawable", "mGradientThumbColorDrawable", "Landroid/graphics/drawable/GradientDrawable;", "mGradientThumbStrokeDrawable", "mProgressStrokeDrawable", "Landroid/graphics/drawable/Drawable;", "mBackgroundThumbDrawable", "mProgressBgInset", "Lcom/samsung/android/sdk/pen/setting/common/SpenInsetDrawable;", "mProgressInset", "mSeekBarColor", "mProgressBg", "mGradientBg", "mContext", "Landroid/content/Context;", "mStrokeSize", "", "mSliderType", "Lcom/samsung/android/sdk/pen/setting/common/SpenSlider$SliderType;", "mStrokeSizeDrawable", "mOutlineSize", "mAdaptiveOutlineColor", "mHasScaleThumb", "", "mInitComplete", "close", "", "reset", "initSeekBar", "seekBar", "Landroid/widget/SeekBar;", "context", "hasStroke", "bgDrawable", "sliderThumbView", "Lcom/samsung/android/sdk/pen/setting/common/SpenSliderThumbView;", "setSliderType", "sliderType", "setColor", "color", "setProgressColor", "setProgressBgAlpha", "alpha", "setProgressAlpha", "setThumbAlpha", "setThumbColor", "colors", "", "isSupportProgressBg", "()Z", "thumbDrawable", "getThumbDrawable", "()Landroid/graphics/drawable/ScaleDrawable;", "thumbStrokeDrawable", "getThumbStrokeDrawable", "thumbDrawables", "", "getThumbDrawables", "()[Landroid/graphics/drawable/ScaleDrawable;", "progressDrawables", "getProgressDrawables", "()[Lcom/samsung/android/sdk/pen/setting/common/SpenInsetDrawable;", "setThumbStrokeSizeColor", "setAdaptiveStroke", "colorDrawable", "getColorDrawable", "()Landroid/graphics/drawable/Drawable;", "strokeDrawable", "getStrokeDrawable", "()Landroid/graphics/drawable/GradientDrawable;", "findProgressGradientDrawable", "drawable", "layerId", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenSeekBarColorControl {
    private static final int SCALE_DEFAULT_LEVEL = 7700;

    @NotNull
    private static final String TAG = "SpenSeekBarColorControl";
    private int mAdaptiveOutlineColor;

    @Nullable
    private Drawable mBackgroundThumbDrawable;
    private Context mContext;

    @Nullable
    private GradientDrawable mGradientBg;

    @Nullable
    private GradientDrawable mGradientThumbColorDrawable;

    @Nullable
    private GradientDrawable mGradientThumbStrokeDrawable;
    private final boolean mHasScaleThumb;
    private boolean mInitComplete;
    private int mOutlineSize;

    @Nullable
    private GradientDrawable mProgressBg;

    @Nullable
    private SpenInsetDrawable mProgressBgInset;

    @Nullable
    private SpenInsetDrawable mProgressInset;

    @Nullable
    private Drawable mProgressStrokeDrawable;

    @Nullable
    private ScaleDrawable mScaleThumbColorDrawable;

    @Nullable
    private ScaleDrawable mScaleThumbStrokeDrawable;

    @Nullable
    private final GradientDrawable mSeekBarColor;

    @NotNull
    private SpenSlider.SliderType mSliderType = SpenSlider.SliderType.DISCRETE;
    private final int mStrokeSize;

    @Nullable
    private GradientDrawable mStrokeSizeDrawable;

    public SpenSeekBarColorControl() {
        reset();
    }

    private final GradientDrawable findProgressGradientDrawable(Drawable drawable, int layerId) {
        Drawable drawableFindDrawableByLayerId;
        if (drawable instanceof GradientDrawable) {
            return (GradientDrawable) drawable;
        }
        if ((drawable instanceof LayerDrawable) && (drawableFindDrawableByLayerId = ((LayerDrawable) drawable).findDrawableByLayerId(layerId)) != null && (drawableFindDrawableByLayerId instanceof GradientDrawable)) {
            return (GradientDrawable) drawableFindDrawableByLayerId;
        }
        return null;
    }

    public static /* synthetic */ GradientDrawable findProgressGradientDrawable$default(SpenSeekBarColorControl spenSeekBarColorControl, Drawable drawable, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = C7932R.id.gradient_progress;
        }
        return spenSeekBarColorControl.findProgressGradientDrawable(drawable, i);
    }

    private final Drawable getColorDrawable() {
        return this.mHasScaleThumb ? this.mScaleThumbColorDrawable : this.mGradientThumbColorDrawable;
    }

    private final GradientDrawable getStrokeDrawable() {
        if (!this.mHasScaleThumb) {
            return this.mGradientThumbStrokeDrawable;
        }
        ScaleDrawable scaleDrawable = this.mScaleThumbStrokeDrawable;
        if (scaleDrawable != null) {
            return (GradientDrawable) (scaleDrawable != null ? scaleDrawable.getDrawable() : null);
        }
        return null;
    }

    private final void reset() {
        this.mInitComplete = false;
        this.mScaleThumbColorDrawable = null;
        this.mScaleThumbStrokeDrawable = null;
        this.mGradientThumbColorDrawable = null;
        this.mGradientThumbStrokeDrawable = null;
        this.mProgressStrokeDrawable = null;
        this.mProgressBgInset = null;
        this.mProgressInset = null;
        this.mProgressBg = null;
    }

    private final void setAdaptiveStroke(int color) {
        Context context = this.mContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        boolean zIsAdaptiveColor = SpenSettingUtilAdaptiveColor.isAdaptiveColor(context, color, SpenSettingUtilAdaptiveColor.UseType.DECISION_BG_COLOR);
        GradientDrawable gradientDrawable = this.mStrokeSizeDrawable;
        if (gradientDrawable != null) {
            int i = this.mOutlineSize;
            if (zIsAdaptiveColor) {
                color = this.mAdaptiveOutlineColor;
            }
            gradientDrawable.setStroke(i, color);
        }
        Drawable drawable = this.mProgressStrokeDrawable;
        GradientDrawable gradientDrawable2 = drawable instanceof GradientDrawable ? (GradientDrawable) drawable : null;
        if (gradientDrawable2 != null) {
            gradientDrawable2.setStroke(this.mOutlineSize, zIsAdaptiveColor ? this.mAdaptiveOutlineColor : 0);
        }
    }

    private final void setThumbStrokeSizeColor(int color) {
        GradientDrawable gradientDrawable = this.mStrokeSizeDrawable;
        if (gradientDrawable != null) {
            gradientDrawable.setColor(color);
        }
    }

    public final void close() {
        reset();
    }

    @Nullable
    public final SpenInsetDrawable[] getProgressDrawables() {
        if (this.mInitComplete) {
            return new SpenInsetDrawable[]{this.mProgressBgInset, this.mProgressInset};
        }
        return null;
    }

    @Nullable
    public final ScaleDrawable getThumbDrawable() {
        if (this.mInitComplete && this.mHasScaleThumb) {
            return this.mScaleThumbColorDrawable;
        }
        return null;
    }

    @Nullable
    public final ScaleDrawable[] getThumbDrawables() {
        if (!this.mInitComplete || !this.mHasScaleThumb) {
            return null;
        }
        ScaleDrawable scaleDrawable = this.mScaleThumbStrokeDrawable;
        ScaleDrawable[] scaleDrawableArr = new ScaleDrawable[scaleDrawable == null ? 1 : 2];
        scaleDrawableArr[0] = this.mScaleThumbColorDrawable;
        if (scaleDrawable != null) {
            scaleDrawableArr[1] = scaleDrawable;
        }
        return scaleDrawableArr;
    }

    @Nullable
    public final ScaleDrawable getThumbStrokeDrawable() {
        if (this.mInitComplete && this.mHasScaleThumb) {
            return this.mScaleThumbStrokeDrawable;
        }
        return null;
    }

    public final void initSeekBar(@NotNull SeekBar seekBar, @NotNull Context context, boolean hasStroke, @Nullable Drawable bgDrawable) {
        Intrinsics.checkNotNullParameter(seekBar, "seekBar");
        Intrinsics.checkNotNullParameter(context, "context");
        initSeekBar(seekBar, null, context, hasStroke, bgDrawable);
    }

    public final boolean isSupportProgressBg() {
        return this.mInitComplete && this.mProgressBg != null;
    }

    public final void setColor(int color) {
        setThumbColor(color);
        setThumbStrokeSizeColor(color);
        setAdaptiveStroke(color);
    }

    public final void setProgressAlpha(int alpha) {
        GradientDrawable gradientDrawable;
        if (!this.mInitComplete || (gradientDrawable = this.mSeekBarColor) == null) {
            return;
        }
        gradientDrawable.setAlpha(alpha);
    }

    public final void setProgressColor(int color) {
    }

    public final void setSliderType(@NotNull SpenSlider.SliderType sliderType) {
        Intrinsics.checkNotNullParameter(sliderType, "sliderType");
        this.mSliderType = sliderType;
    }

    public final void setThumbColor(int color) {
        Drawable drawable;
        if (this.mInitComplete && this.mSliderType == SpenSlider.SliderType.CONTINUOUS && (drawable = this.mBackgroundThumbDrawable) != null) {
            drawable.setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
        }
    }

    public final void initSeekBar(@NotNull SeekBar seekBar, @Nullable SpenSliderThumbView sliderThumbView, @NotNull Context context, boolean hasStroke, @Nullable Drawable bgDrawable) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(seekBar, "seekBar");
        Intrinsics.checkNotNullParameter(context, "context");
        this.mContext = context;
        this.mAdaptiveOutlineColor = SpenSettingUtil.getColor(context, C7932R.color.setting_preview_adaptive_bg_color);
        this.mOutlineSize = context.getResources().getDimensionPixelSize(C7932R.dimen.setting_slider_outline_size);
        Drawable background = seekBar.getBackground();
        if (background != null) {
            this.mGradientBg = findProgressGradientDrawable(background, C7932R.id.gradient_progress);
            this.mProgressStrokeDrawable = findProgressGradientDrawable(background, C7932R.id.progress_border);
        }
        if (sliderThumbView != null) {
            if (sliderThumbView.getThumbBackgroundView() != null) {
                View thumbBackgroundView = sliderThumbView.getThumbBackgroundView();
                Drawable background2 = thumbBackgroundView != null ? thumbBackgroundView.getBackground() : null;
                Intrinsics.checkNotNull(background2, "null cannot be cast to non-null type android.graphics.drawable.LayerDrawable");
                this.mBackgroundThumbDrawable = ((LayerDrawable) background2).findDrawableByLayerId(C7932R.id.background_thumb);
            }
            ImageView colorSizeView = sliderThumbView.getColorSizeView();
            if (colorSizeView != null && (drawable = colorSizeView.getDrawable()) != null && (drawable instanceof GradientDrawable)) {
                this.mStrokeSizeDrawable = (GradientDrawable) drawable;
            }
        }
        Drawable progressDrawable = seekBar.getProgressDrawable();
        Intrinsics.checkNotNull(progressDrawable, "null cannot be cast to non-null type android.graphics.drawable.LayerDrawable");
        LayerDrawable layerDrawable = (LayerDrawable) progressDrawable;
        if (bgDrawable != null) {
            this.mProgressBgInset = new SpenInsetDrawable(bgDrawable, 0, 0, 0, 0);
            this.mProgressBg = findProgressGradientDrawable$default(this, bgDrawable, 0, 2, null);
        } else {
            Drawable drawableFindDrawableByLayerId = layerDrawable.findDrawableByLayerId(R.id.background);
            Intrinsics.checkNotNull(drawableFindDrawableByLayerId);
            this.mProgressBgInset = new SpenInsetDrawable(drawableFindDrawableByLayerId, 0, 0, 0, 0);
        }
        layerDrawable.mutate();
        layerDrawable.setDrawableByLayerId(R.id.background, this.mProgressBgInset);
        this.mInitComplete = true;
    }

    public final void setProgressColor(@NotNull int... colors) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        if (!this.mInitComplete || this.mGradientBg == null) {
            return;
        }
        Context context = this.mContext;
        if (context == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContext");
            context = null;
        }
        if (AbstractC0541b.m759a(context) == 1) {
            int length = colors.length;
            int i = length / 2;
            for (int i2 = 0; i2 < i; i2++) {
                int i4 = colors[i2];
                int i5 = (length - 1) - i2;
                colors[i2] = colors[i5];
                colors[i5] = i4;
            }
        }
        GradientDrawable gradientDrawable = this.mGradientBg;
        if (gradientDrawable != null) {
            gradientDrawable.setColors(colors);
        }
    }

    public final void setProgressBgAlpha(int alpha) {
    }

    public final void setThumbAlpha(int alpha) {
    }
}
