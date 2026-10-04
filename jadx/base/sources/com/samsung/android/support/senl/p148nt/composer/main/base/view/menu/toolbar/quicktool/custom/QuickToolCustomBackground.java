package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.custom;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.view.View;
import androidx.annotation.RequiresApi;
import androidx.appcompat.animation.C0421a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.quicktool.OnAnimationListener;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.commons.lang3.concurrent.AbstractCircuitBreaker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 (2\u00020\u0001:\u0001(B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\u0006\u0010\u001d\u001a\u00020\u001bJ\"\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"J\u0010\u0010#\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u0007H\u0002J\u001c\u0010$\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020\u00072\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\u0010\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020'H\u0017R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/custom/QuickToolCustomBackground;", "Landroid/view/View;", "context", "Landroid/content/Context;", "size", "", "hasCenter", "", "<init>", "(Landroid/content/Context;FZ)V", "mCenterPaint", "Landroid/graphics/Paint;", "mFadePaint", "mBackgroundPaint", "mLeftFadePaint", "mRightFadePaint", "mStrokeWidth", "mElevationValue", "mShadowColor", "", "mCircleBackgroundColor", "mCircleBgRadius", "mCurrentBgRadius", "mArchBgRadius", "mBgRadiusAnimator", "Landroid/animation/ValueAnimator;", "initFadePaint", "", "initBgAnimator", "close", "setBGMode", AbstractCircuitBreaker.PROPERTY_NAME, "animation", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/setting/quicktool/OnAnimationListener;", "setOpenModeLayout", "setCloseModeLayout", "draw", "canvas", "Landroid/graphics/Canvas;", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SuppressLint({"ViewConstructor"})
@SourceDebugExtension({"SMAP\nQuickToolCustomBackground.kt\nKotlin\n*S Kotlin\n*F\n+ 1 QuickToolCustomBackground.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/custom/QuickToolCustomBackground\n+ 2 Animator.kt\nandroidx/core/animation/AnimatorKt\n*L\n1#1,177:1\n29#2:178\n85#2,18:179\n*S KotlinDebug\n*F\n+ 1 QuickToolCustomBackground.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/custom/QuickToolCustomBackground\n*L\n133#1:178\n133#1:179,18\n*E\n"})
public final class QuickToolCustomBackground extends View {
    public static final long BG_CLOSE_ANIMATOR_DURATION = 250;
    public static final long BG_OPEN_ANIMATOR_DURATION = 250;

    @NotNull
    private static final String TAG = "QuickToolCustomBackground";
    private final boolean hasCenter;
    private float mArchBgRadius;

    @NotNull
    private Paint mBackgroundPaint;

    @NotNull
    private ValueAnimator mBgRadiusAnimator;

    @NotNull
    private final Paint mCenterPaint;
    private int mCircleBackgroundColor;
    private float mCircleBgRadius;
    private float mCurrentBgRadius;
    private float mElevationValue;

    @NotNull
    private Paint mFadePaint;

    @NotNull
    private Paint mLeftFadePaint;

    @NotNull
    private Paint mRightFadePaint;
    private int mShadowColor;
    private float mStrokeWidth;

    public /* synthetic */ QuickToolCustomBackground(Context context, float f, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? context.getResources().getDimension(C9086R.dimen.qt_circle_layout_height) : f, (i & 4) != 0 ? false : z);
    }

    private final void initBgAnimator() {
        this.mBgRadiusAnimator.setInterpolator(SpenSettingUtilAnimation.getInterpolator(11));
        this.mBgRadiusAnimator.addUpdateListener(new C0421a(this, 23));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initBgAnimator$lambda$0(QuickToolCustomBackground quickToolCustomBackground, ValueAnimator valueAnimator) {
        quickToolCustomBackground.mCurrentBgRadius = ((Float) AbstractC6670b.m4742c(valueAnimator, "valueAnimator", "null cannot be cast to non-null type kotlin.Float")).floatValue();
        quickToolCustomBackground.invalidate();
    }

    private final void initFadePaint() {
        float f = this.mElevationValue * 2;
        Paint paint = this.mLeftFadePaint;
        int[] iArr = {0, this.mFadePaint.getColor()};
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new LinearGradient(0.0f, 0.0f, f, 0.0f, iArr, (float[]) null, tileMode));
        Paint paint2 = this.mLeftFadePaint;
        Paint.Style style = Paint.Style.FILL;
        paint2.setStyle(style);
        Paint paint3 = this.mLeftFadePaint;
        PorterDuff.Mode mode = PorterDuff.Mode.DST_IN;
        paint3.setXfermode(new PorterDuffXfermode(mode));
        float dimensionPixelSize = getContext().getResources().getDimensionPixelSize(C9086R.dimen.qt_circle_pen_list_width);
        this.mRightFadePaint.setShader(new LinearGradient(dimensionPixelSize - f, 0.0f, dimensionPixelSize, 0.0f, new int[]{this.mFadePaint.getColor(), 0}, (float[]) null, tileMode));
        this.mRightFadePaint.setStyle(style);
        this.mRightFadePaint.setXfermode(new PorterDuffXfermode(mode));
    }

    public static /* synthetic */ void setBGMode$default(QuickToolCustomBackground quickToolCustomBackground, boolean z, boolean z2, OnAnimationListener onAnimationListener, int i, Object obj) {
        if ((i & 4) != 0) {
            onAnimationListener = null;
        }
        quickToolCustomBackground.setBGMode(z, z2, onAnimationListener);
    }

    private final void setCloseModeLayout(boolean animation, final OnAnimationListener listener) {
        float f = this.mArchBgRadius;
        if (this.mBgRadiusAnimator.isRunning()) {
            this.mBgRadiusAnimator.cancel();
            f = this.mCurrentBgRadius;
        }
        if (!animation) {
            this.mCurrentBgRadius = this.mCircleBgRadius;
            invalidate();
        } else {
            this.mBgRadiusAnimator.setFloatValues(f, this.mCircleBgRadius);
            this.mBgRadiusAnimator.setDuration(250L);
            this.mBgRadiusAnimator.start();
            this.mBgRadiusAnimator.addListener(new Animator.AnimatorListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.custom.QuickToolCustomBackground$setCloseModeLayout$$inlined$doOnEnd$1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    OnAnimationListener onAnimationListener = listener;
                    if (onAnimationListener != null) {
                        onAnimationListener.onAnimationEnd();
                    }
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                }
            });
        }
    }

    public static /* synthetic */ void setCloseModeLayout$default(QuickToolCustomBackground quickToolCustomBackground, boolean z, OnAnimationListener onAnimationListener, int i, Object obj) {
        if ((i & 2) != 0) {
            onAnimationListener = null;
        }
        quickToolCustomBackground.setCloseModeLayout(z, onAnimationListener);
    }

    private final void setOpenModeLayout(boolean animation) {
        float f = this.mCircleBgRadius;
        if (this.mBgRadiusAnimator.isRunning()) {
            this.mBgRadiusAnimator.cancel();
            f = this.mCurrentBgRadius;
        }
        if (!animation) {
            this.mCurrentBgRadius = this.mArchBgRadius;
            invalidate();
        } else {
            this.mBgRadiusAnimator.setFloatValues(f, this.mArchBgRadius);
            this.mBgRadiusAnimator.setDuration(250L);
            this.mBgRadiusAnimator.start();
        }
    }

    public final void close() {
        this.mBgRadiusAnimator.cancel();
    }

    @Override // android.view.View
    @RequiresApi(33)
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        PointF pointF = new PointF(getWidth() / 2.0f, ((getHeight() / 2.0f) + this.mCurrentBgRadius) - this.mCircleBgRadius);
        if (this.hasCenter) {
            canvas.drawCircle(pointF.x, pointF.y, this.mCurrentBgRadius - (this.mStrokeWidth * 0.5f), this.mCenterPaint);
        }
        Paint paint = this.mFadePaint;
        Paint.Style style = Paint.Style.STROKE;
        paint.setStyle(style);
        this.mFadePaint.setStrokeWidth(this.mStrokeWidth);
        this.mFadePaint.setColor(this.mShadowColor);
        this.mFadePaint.setMaskFilter(new BlurMaskFilter(this.mElevationValue, BlurMaskFilter.Blur.NORMAL));
        canvas.drawCircle(pointF.x, pointF.y, this.mCurrentBgRadius, this.mFadePaint);
        this.mBackgroundPaint.setStyle(style);
        this.mBackgroundPaint.setStrokeWidth(this.mStrokeWidth);
        this.mBackgroundPaint.setMaskFilter(null);
        this.mBackgroundPaint.setColor(this.mCircleBackgroundColor);
        canvas.drawCircle(pointF.x, pointF.y, this.mCurrentBgRadius, this.mBackgroundPaint);
        super.draw(canvas);
        if (this.mCurrentBgRadius > getHeight()) {
            float f = 2;
            canvas.drawRect(0.0f, 0.0f, this.mElevationValue * f, getHeight(), this.mLeftFadePaint);
            canvas.drawRect(getWidth() - (this.mElevationValue * f), 0.0f, getWidth(), getHeight(), this.mRightFadePaint);
        }
    }

    public final void setBGMode(boolean open, boolean animation, @Nullable OnAnimationListener listener) {
        this.mBgRadiusAnimator.removeAllListeners();
        if (open) {
            setOpenModeLayout(animation);
        } else {
            setCloseModeLayout(animation, listener);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QuickToolCustomBackground(@NotNull Context context, float f, boolean z) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.hasCenter = z;
        Paint paint = new Paint();
        this.mCenterPaint = paint;
        this.mFadePaint = new Paint();
        this.mBackgroundPaint = new Paint();
        this.mLeftFadePaint = new Paint();
        this.mRightFadePaint = new Paint();
        this.mBgRadiusAnimator = new ValueAnimator();
        this.mStrokeWidth = context.getResources().getDimensionPixelSize(C9086R.dimen.qt_circle_stroke_size);
        this.mElevationValue = getResources().getDimensionPixelSize(C9086R.dimen.composer_qt_circle_layout_elevation);
        this.mShadowColor = context.getColor(C9086R.color.setting_qt_bg_shadow_color);
        this.mCircleBackgroundColor = context.getColor(C9086R.color.setting_qt_circle_bg_color);
        float f4 = (f - this.mStrokeWidth) / 2.0f;
        this.mCircleBgRadius = f4;
        this.mCurrentBgRadius = f4;
        this.mArchBgRadius = context.getResources().getDimensionPixelSize(C9086R.dimen.qt_circle_arch_background_radius_docking);
        paint.setColor(context.getColor(C9086R.color.setting_qt_center_bg_color));
        initFadePaint();
        initBgAnimator();
        setLayerType(2, null);
    }
}
