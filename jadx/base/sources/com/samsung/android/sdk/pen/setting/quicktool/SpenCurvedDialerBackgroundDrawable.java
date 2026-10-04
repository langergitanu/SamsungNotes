package com.samsung.android.sdk.pen.setting.quicktool;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.appbar.C4565b;
import com.samsung.android.sdk.pen.setting.quicktool.SpenCurvedDialerBackgroundDrawable;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.sesl.visualeffect.lighteffects.radialgrad.WiggleAnimationConfig;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 /2\u00020\u0001:\u0002/0B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0019\u001a\u00020\u001aJ\u0016\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\fJ\u000e\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u000fJ\u000e\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\fJ\u001a\u0010!\u001a\u00020\u001a2\u0006\u0010\"\u001a\u00020\f2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$J\u0010\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u000fH\u0016J\u0012\u0010*\u001a\u00020\u001a2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010-\u001a\u00020\u000fH\u0016J\b\u0010.\u001a\u00020\u001aH\u0002R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedDialerBackgroundDrawable;", "Landroid/graphics/drawable/Drawable;", "context", "Landroid/content/Context;", "center", "Landroid/graphics/PointF;", "<init>", "(Landroid/content/Context;Landroid/graphics/PointF;)V", "mContext", "mPaint", "Landroid/graphics/Paint;", "mRadius", "", "mCenter", "mStartIndex", "", "mEndIndex", "mOffsetAngle", "mMaxDot", "mItemSizes", "", "mItemAngles", "mValueAnimator", "Landroid/animation/ValueAnimator;", "mItemSizeScale", "close", "", "updatePosition", "value", "angle", "setMaxDotsVisible", "setItemSizeScale", WiggleAnimationConfig.KEY_SCALE, "startAnimation", "targetAngle", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedDialerBackgroundDrawable$AnimationListener;", "draw", "canvas", "Landroid/graphics/Canvas;", "setAlpha", "alpha", BaseWidgetConstant.SET_COLOR_FILTER, "colorFilter", "Landroid/graphics/ColorFilter;", "getOpacity", "generateCircleDotInfo", "Companion", "AnimationListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenCurvedDialerBackgroundDrawable extends Drawable {
    private static final float END_ANGLE = 45.0f;
    private static final int END_INDEX = 10;
    private static final int MAX_POINT = 11;
    private static final long ROTATE_ANIMATION_DURATION = 450;
    private static final float START_ANGLE = 315.0f;
    private static final int START_INDEX = 0;

    @NotNull
    private static final String TAG = "SpenCurvedDialerBackgroundDrawable";

    @NotNull
    private final PointF mCenter;

    @NotNull
    private final Context mContext;
    private int mEndIndex;
    private float[] mItemAngles;
    private float mItemSizeScale;
    private float[] mItemSizes;
    private int mMaxDot;
    private float mOffsetAngle;

    @NotNull
    private final Paint mPaint;
    private final float mRadius;
    private int mStartIndex;

    @Nullable
    private ValueAnimator mValueAnimator;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedDialerBackgroundDrawable$AnimationListener;", "", "onAnimationStart", "", "onAnimationUpdate", "value", "", "onAnimationEnd", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface AnimationListener {
        void onAnimationEnd();

        void onAnimationStart();

        void onAnimationUpdate(float value);
    }

    public SpenCurvedDialerBackgroundDrawable(@NotNull Context context, @NotNull PointF center) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(center, "center");
        this.mContext = context;
        Paint paint = new Paint(1);
        this.mPaint = paint;
        this.mItemSizeScale = 1.0f;
        paint.setColor(context.getResources().getColor(C7932R.color.setting_qt_dialer_dot_color, null));
        this.mRadius = (context.getResources().getDimensionPixelSize(C7932R.dimen.qt_dial_width) - context.getResources().getDimensionPixelSize(C7932R.dimen.qt_dial_stroke_size)) / 2.0f;
        this.mCenter = center;
        this.mStartIndex = 0;
        this.mEndIndex = 10;
        this.mOffsetAngle = 0.0f;
        this.mMaxDot = 11;
        generateCircleDotInfo();
    }

    private final void generateCircleDotInfo() {
        float radians = (float) Math.toRadians(315.0d);
        float radians2 = (float) Math.toRadians(45.0d);
        float dimensionPixelSize = this.mContext.getResources().getDimensionPixelSize(C7932R.dimen.qt_dial_item_min_size) / 2.0f;
        float dimensionPixelSize2 = this.mContext.getResources().getDimensionPixelSize(C7932R.dimen.qt_dial_item_max_size) / 2.0f;
        float[] fArr = new float[11];
        this.mItemSizes = fArr;
        int length = fArr.length;
        int i = 0;
        while (true) {
            float[] fArr2 = null;
            if (i >= length) {
                break;
            }
            float[] fArr3 = this.mItemSizes;
            if (fArr3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mItemSizes");
            } else {
                fArr2 = fArr3;
            }
            fArr2[i] = (((dimensionPixelSize2 - dimensionPixelSize) * i) / 10) + dimensionPixelSize;
            i++;
        }
        float[] fArr4 = new float[11];
        this.mItemAngles = fArr4;
        int length2 = fArr4.length;
        for (int i2 = 0; i2 < length2; i2++) {
            float[] fArr5 = this.mItemAngles;
            if (fArr5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mItemAngles");
                fArr5 = null;
            }
            fArr5[i2] = (((radians2 - radians) * i2) / 10) + radians;
        }
    }

    public static /* synthetic */ void startAnimation$default(SpenCurvedDialerBackgroundDrawable spenCurvedDialerBackgroundDrawable, float f, AnimationListener animationListener, int i, Object obj) {
        if ((i & 2) != 0) {
            animationListener = null;
        }
        spenCurvedDialerBackgroundDrawable.startAnimation(f, animationListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startAnimation$lambda$1$lambda$0(AnimationListener animationListener, ValueAnimator valueAnimator, ValueAnimator it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (animationListener != null) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            animationListener.onAnimationUpdate(((Float) animatedValue).floatValue());
        }
    }

    public final void close() {
        ValueAnimator valueAnimator = this.mValueAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.mValueAnimator = null;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        float radians = (float) Math.toRadians(this.mOffsetAngle);
        int i = this.mStartIndex;
        int i2 = this.mEndIndex;
        if (i > i2) {
            return;
        }
        while (true) {
            double d = this.mCenter.x;
            double d2 = this.mRadius;
            float[] fArr = this.mItemAngles;
            float[] fArr2 = null;
            if (fArr == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mItemAngles");
                fArr = null;
            }
            float fM2210a = (float) AbstractC2821a.m2210a(fArr[i] + radians, d2, d);
            double d3 = this.mCenter.y;
            double d4 = this.mRadius;
            float[] fArr3 = this.mItemAngles;
            if (fArr3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mItemAngles");
                fArr3 = null;
            }
            float fM5b = (float) AbstractC0000a.m5b(fArr3[i] + radians, d4, d3);
            float[] fArr4 = this.mItemSizes;
            if (fArr4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mItemSizes");
            } else {
                fArr2 = fArr4;
            }
            canvas.drawCircle(fM2210a, fM5b, fArr2[i] * this.mItemSizeScale, this.mPaint);
            if (i == i2) {
                return;
            } else {
                i++;
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public final void setItemSizeScale(float scale) {
        this.mItemSizeScale = scale;
    }

    public final void setMaxDotsVisible(int value) {
        this.mMaxDot = value;
        generateCircleDotInfo();
        invalidateSelf();
    }

    public final void startAnimation(float targetAngle, @Nullable final AnimationListener listener) {
        ValueAnimator valueAnimator = this.mValueAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.mOffsetAngle, targetAngle);
        valueAnimatorOfFloat.setDuration(450L);
        valueAnimatorOfFloat.setInterpolator(SpenSettingUtilAnimation.getInterpolator(20));
        valueAnimatorOfFloat.addListener(new Animator.AnimatorListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenCurvedDialerBackgroundDrawable$startAnimation$1$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                SpenCurvedDialerBackgroundDrawable.AnimationListener animationListener = listener;
                if (animationListener != null) {
                    animationListener.onAnimationEnd();
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                SpenCurvedDialerBackgroundDrawable.AnimationListener animationListener = listener;
                if (animationListener != null) {
                    animationListener.onAnimationStart();
                }
            }
        });
        valueAnimatorOfFloat.addUpdateListener(new C4565b(listener, valueAnimatorOfFloat, 4));
        valueAnimatorOfFloat.start();
        this.mValueAnimator = valueAnimatorOfFloat;
    }

    public final void updatePosition(int value, float angle) {
        if (angle == this.mOffsetAngle) {
            return;
        }
        this.mOffsetAngle = angle;
        int i = value / 10;
        this.mStartIndex = Math.max(i - 6, 0);
        this.mEndIndex = Math.min(i + 6, 10);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
    }
}
