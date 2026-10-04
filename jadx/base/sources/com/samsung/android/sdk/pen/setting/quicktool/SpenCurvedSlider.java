package com.samsung.android.sdk.pen.setting.quicktool;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.appcompat.animation.C0421a;
import androidx.collection.AbstractC0622a;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.quicktool.SpenCurvedSlider;
import com.samsung.android.sdk.pen.setting.quicktool.SpenSliderBackgroundDrawable;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.PopOverActivityWrapper;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u0083\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0006\n\u0002\b\u0016*\u0001.\b\u0010\u0018\u0000 ^2\u00020\u0001:\u0004^_`aB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u00020$H\u0004J\b\u00103\u001a\u000201H\u0016J\b\u00104\u001a\u000201H\u0014J(\u00105\u001a\u0002012\u0006\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0014J\u0010\u0010:\u001a\u00020$2\u0006\u0010;\u001a\u00020<H\u0016J\u0016\u0010=\u001a\u00020$2\u0006\u0010>\u001a\u00020\u000f2\u0006\u0010?\u001a\u00020\u000fJ\u0018\u0010@\u001a\u0002012\u0006\u0010A\u001a\u00020\u000b2\u0006\u0010B\u001a\u00020$H\u0016J\u0018\u0010C\u001a\u00020$2\u0006\u0010D\u001a\u00020\u000f2\u0006\u0010E\u001a\u00020\u000fH\u0002J\b\u0010F\u001a\u000201H\u0002J\u000e\u0010G\u001a\u0002012\u0006\u0010H\u001a\u00020\tJ\u000e\u0010I\u001a\u0002012\u0006\u0010J\u001a\u00020\u000bJ\u0010\u0010K\u001a\u00020L2\u0006\u0010J\u001a\u00020\u000bH\u0002J\u0010\u0010M\u001a\u0002012\b\u0010N\u001a\u0004\u0018\u00010!J\u0010\u0010O\u001a\u0002012\b\u0010N\u001a\u0004\u0018\u00010&J\u0010\u0010P\u001a\u0002012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010Q\u001a\u000201H\u0002J\b\u0010R\u001a\u000201H\u0002J\b\u0010S\u001a\u000201H\u0002J\b\u0010T\u001a\u000201H\u0002J\u0010\u0010U\u001a\u0002012\u0006\u0010V\u001a\u00020$H\u0004J\b\u0010W\u001a\u00020$H\u0002J\u0010\u0010X\u001a\u0002012\u0006\u0010Y\u001a\u00020LH\u0002J\u0010\u0010Z\u001a\u0002012\u0006\u0010Y\u001a\u00020LH\u0002J\u0010\u0010[\u001a\u00020\u000b2\u0006\u0010Y\u001a\u00020LH\u0002J\u0010\u0010\\\u001a\u0002012\u0006\u0010Y\u001a\u00020LH\u0002J\u001a\u0010]\u001a\u0002012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0004\n\u0002\u0010/¨\u0006b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSlider;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mProgressBackgroundColor", "", "mCurrentValue", "", "mCenter", "Landroid/graphics/PointF;", "mRadius", "", "mAngleStart", "mAngleEnd", "mAngleSum", "mAngleDiff", "mThickness", "mExtendedAngle", "mArcDrawable", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSliderBackgroundDrawable;", "mThumbView", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSliderThumbView;", "getMThumbView", "()Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSliderThumbView;", "setMThumbView", "(Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSliderThumbView;)V", "mBackgroundView", "Landroid/view/View;", "mChangedListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSlider$OnChangedListener;", "mThumbSize", "mIsSupportCheckBg", "", "mAnimationListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSlider$OnAnimationListener;", "mIsAnimationCancelled", "mRatioAnimator", "Landroid/animation/ValueAnimator;", "mCurrentBgAniRatio", "mCurrentBgStrokeWidthAniValue", "mIsAnimation", "mBgStrokeWidthFloatProperty", "com/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSlider$mBgStrokeWidthFloatProperty$1", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSlider$mBgStrokeWidthFloatProperty$1;", "setSupportCheckBg", "", "support", "close", "onFinishInflate", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "isRawPointInView", "absX", "absY", "setVisibility", "visibility", "animation", "isSliderTouched", "x", "y", "updateAngleSum", "setProgressColor", "colors", "setValue", "value", "calculateAngleDegree", "", "setOnChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnAnimationListener", "initView", "updateDrawCurvedInfo", "initAnimator", "startShowAnimation", "startHideAnimation", "startCurvedAnimation", "isShow", "isReversed", "updateThumbView", "angleDegree", "updateThumbPosition", "calculateValue", "updateSliderValue", "setAttributes", "Companion", "OnChangedListener", "OnAnimationListener", "FloatValueHolder", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenCurvedSlider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenCurvedSlider.kt\ncom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSlider\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,391:1\n254#2:392\n*S KotlinDebug\n*F\n+ 1 SpenCurvedSlider.kt\ncom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSlider\n*L\n152#1:392\n*E\n"})
public class SpenCurvedSlider extends RelativeLayout {
    public static final int DEFAULT_MAX_VALUE = 100;
    public static final int DEFAULT_MIN_VALUE = 1;
    public static final long HIDE_ANIMATION_DURATION = 350;
    private static final float HIDE_DAMPING_RATIO = 1.0f;
    private static final float HIDE_STIFFNESS = 400.0f;
    private static final float HIDE_TARGET_RATIO = 0.0f;
    public static final long SHOW_ANIMATION_DURATION = 400;
    private static final float SHOW_DAMPING_RATIO = 0.3f;
    private static final float SHOW_STIFFNESS = 200.0f;
    private static final float SHOW_TARGET_RATIO = 1.0f;

    @NotNull
    private static final String TAG = "SpenCurvedSlider";
    private float mAngleDiff;
    private int mAngleEnd;
    private int mAngleStart;
    private int mAngleSum;

    @Nullable
    private OnAnimationListener mAnimationListener;

    @Nullable
    private SpenSliderBackgroundDrawable mArcDrawable;

    @Nullable
    private View mBackgroundView;

    @NotNull
    private final SpenCurvedSlider$mBgStrokeWidthFloatProperty$1 mBgStrokeWidthFloatProperty;

    @NotNull
    private PointF mCenter;

    @Nullable
    private OnChangedListener mChangedListener;
    private float mCurrentBgAniRatio;
    private float mCurrentBgStrokeWidthAniValue;
    private int mCurrentValue;
    private float mExtendedAngle;
    private boolean mIsAnimation;
    private boolean mIsAnimationCancelled;
    private boolean mIsSupportCheckBg;

    @NotNull
    private int[] mProgressBackgroundColor;
    private float mRadius;

    @NotNull
    private final ValueAnimator mRatioAnimator;
    private float mThickness;
    private int mThumbSize;

    @Nullable
    private SpenCurvedSliderThumbView mThumbView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSlider$FloatValueHolder;", "", "value", "", "<init>", "(F)V", "getValue", "()F", "setValue", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class FloatValueHolder {
        private float value;

        public FloatValueHolder(float f) {
            this.value = f;
        }

        public final float getValue() {
            return this.value;
        }

        public final void setValue(float f) {
            this.value = f;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSlider$OnAnimationListener;", "", "onAnimationEnd", "", "isShowAnimation", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnAnimationListener {
        void onAnimationEnd(boolean isShowAnimation);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedSlider$OnChangedListener;", "", "onChanged", "", "value", "", "fromUser", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnChangedListener {
        void onChanged(int value, boolean fromUser);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r1v4, types: [com.samsung.android.sdk.pen.setting.quicktool.SpenCurvedSlider$mBgStrokeWidthFloatProperty$1] */
    public SpenCurvedSlider(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mProgressBackgroundColor = new int[]{0, 0};
        this.mCurrentValue = 1;
        this.mCenter = new PointF();
        this.mRatioAnimator = new ValueAnimator();
        this.mBgStrokeWidthFloatProperty = new FloatPropertyCompat<FloatValueHolder>() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenCurvedSlider$mBgStrokeWidthFloatProperty$1
            {
                super("customFloat");
            }

            @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
            public float getValue(SpenCurvedSlider.FloatValueHolder holder) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                return holder.getValue();
            }

            @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
            public void setValue(SpenCurvedSlider.FloatValueHolder holder, float value) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                holder.setValue(value);
                this.this$0.mCurrentBgStrokeWidthAniValue = value;
            }
        };
        setLayoutDirection(0);
        setAttributes(context, attributeSet);
    }

    private final double calculateAngleDegree(int value) {
        float f = (this.mAngleDiff * (value - 1)) + this.mAngleStart;
        if (isReversed()) {
            f -= PopOverActivityWrapper.DEFAULT_WIDTH;
        }
        return f;
    }

    private final int calculateValue(double angleDegree) {
        int i = this.mAngleStart;
        if (angleDegree < i) {
            angleDegree += (double) PopOverActivityWrapper.DEFAULT_WIDTH;
        }
        int i2 = ((int) (((angleDegree - ((double) i)) * ((double) 100)) / ((double) this.mAngleSum))) + 1;
        if (i2 > 100) {
            return 100;
        }
        return i2;
    }

    private final void initAnimator() {
        this.mRatioAnimator.setInterpolator(SpenSettingUtilAnimation.getInterpolator(20));
        this.mRatioAnimator.addUpdateListener(new C0421a(this, 9));
        this.mRatioAnimator.addListener(new Animator.AnimatorListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenCurvedSlider.initAnimator.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                SpenCurvedSlider.this.mIsAnimationCancelled = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                OnAnimationListener onAnimationListener;
                Intrinsics.checkNotNullParameter(animation, "animation");
                if (SpenCurvedSlider.this.mIsAnimationCancelled || (onAnimationListener = SpenCurvedSlider.this.mAnimationListener) == null) {
                    return;
                }
                onAnimationListener.onAnimationEnd(SpenCurvedSlider.this.mCurrentBgAniRatio == 1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                SpenCurvedSlider.this.mIsAnimationCancelled = false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAnimator$lambda$0(SpenCurvedSlider spenCurvedSlider, ValueAnimator valueAnimator) {
        spenCurvedSlider.mCurrentBgAniRatio = ((Float) AbstractC6670b.m4742c(valueAnimator, "value", "null cannot be cast to non-null type kotlin.Float")).floatValue();
        spenCurvedSlider.updateDrawCurvedInfo();
    }

    private final void initView(Context context) {
        this.mThumbView = (SpenCurvedSliderThumbView) findViewById(C7932R.id.curved_seekbar_thumb);
        this.mThumbSize = context.getResources().getDimensionPixelSize(C7932R.dimen.qt_curved_seekbar_thumb_size);
        SpenSliderBackgroundDrawable spenSliderBackgroundDrawable = new SpenSliderBackgroundDrawable(context, getWidth(), getHeight(), this.mRadius, this.mThickness, this.mAngleStart, this.mAngleSum, this.mProgressBackgroundColor);
        this.mArcDrawable = spenSliderBackgroundDrawable;
        spenSliderBackgroundDrawable.setOutlineEnable(true);
        View viewFindViewById = findViewById(C7932R.id.curved_seekbar_background);
        this.mBackgroundView = viewFindViewById;
        if (viewFindViewById != null) {
            viewFindViewById.setBackground(this.mArcDrawable);
        }
        initAnimator();
    }

    private final boolean isReversed() {
        return this.mAngleStart > this.mAngleEnd;
    }

    private final boolean isSliderTouched(float x, float y2) {
        double dSqrt = Math.sqrt(Math.pow(y2 - this.mCenter.y, 2.0d) + Math.pow(x - this.mCenter.x, 2.0d));
        float f = (this.mThickness / 2) + this.mRadius;
        if (dSqrt >= r2 - (r3 / r4) && dSqrt <= f) {
            PointF pointF = this.mCenter;
            float degrees = (float) Math.toDegrees(Math.atan2(y2 - pointF.y, x - pointF.x));
            if (degrees < 0.0f) {
                degrees += 360.0f;
            }
            float f4 = this.mAngleStart;
            float f5 = this.mExtendedAngle;
            float f6 = f4 - f5;
            float f7 = this.mAngleEnd + f5;
            if (isReversed()) {
                return (degrees >= f6 && degrees <= f6 + f7) || degrees <= f7;
            }
            if (f6 <= degrees && degrees <= f7) {
                return true;
            }
        }
        return false;
    }

    private final void setAttributes(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attrs, C7932R.styleable.SpenCurvedSlider, 0, 0);
            Intrinsics.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
            this.mAngleStart = typedArrayObtainStyledAttributes.getInteger(C7932R.styleable.SpenCurvedSlider_angleStart, 0);
            this.mAngleEnd = typedArrayObtainStyledAttributes.getInteger(C7932R.styleable.SpenCurvedSlider_angleEnd, 0);
            this.mRadius = typedArrayObtainStyledAttributes.getDimension(C7932R.styleable.SpenCurvedSlider_radius, 0.0f);
            this.mThickness = typedArrayObtainStyledAttributes.getDimension(C7932R.styleable.SpenCurvedSlider_thickness, 0.0f);
        }
        if (this.mThickness == 0.0f) {
            this.mThickness = getResources().getDimension(C7932R.dimen.qt_dial_bg_thickness);
        }
        if (this.mAngleStart == 0) {
            this.mAngleStart = getResources().getInteger(C7932R.integer.setting_qt_opacity_angle_start);
        }
        if (this.mAngleEnd == 0) {
            this.mAngleEnd = getResources().getInteger(C7932R.integer.setting_qt_opacity_angle_end);
        }
        if (this.mRadius == 0.0f) {
            this.mRadius = getResources().getDimension(C7932R.dimen.qt_circle_radius);
        }
        updateAngleSum();
        this.mExtendedAngle = (float) Math.toDegrees((this.mThickness / 2.0f) / this.mRadius);
    }

    private final void startHideAnimation() {
        this.mRatioAnimator.setDuration(350L);
        this.mRatioAnimator.setFloatValues(this.mCurrentBgAniRatio, 0.0f);
        this.mRatioAnimator.start();
        SpringAnimation springAnimation = new SpringAnimation(new FloatValueHolder(getResources().getDimensionPixelSize(C7932R.dimen.qt_thickness_bg_max_stroke_width)), this.mBgStrokeWidthFloatProperty);
        SpringForce springForce = new SpringForce();
        springForce.setDampingRatio(1.0f);
        springForce.setStiffness(400.0f);
        springForce.setFinalPosition(getResources().getDimensionPixelSize(C7932R.dimen.qt_thickness_bg_min_stroke_width));
        springAnimation.setSpring(springForce);
        springAnimation.start();
    }

    private final void startShowAnimation() {
        this.mRatioAnimator.setDuration(400L);
        this.mRatioAnimator.setFloatValues(this.mCurrentBgAniRatio, 1.0f);
        this.mRatioAnimator.start();
        SpringAnimation springAnimation = new SpringAnimation(new FloatValueHolder(getResources().getDimensionPixelSize(C7932R.dimen.qt_thickness_bg_min_stroke_width)), this.mBgStrokeWidthFloatProperty);
        SpringForce springForce = new SpringForce();
        springForce.setDampingRatio(0.3f);
        springForce.setStiffness(200.0f);
        springForce.setFinalPosition(getResources().getDimensionPixelSize(C7932R.dimen.qt_thickness_bg_max_stroke_width));
        springAnimation.setSpring(springForce);
        springAnimation.start();
    }

    private final void updateAngleSum() {
        int i = this.mAngleStart;
        int i2 = this.mAngleEnd;
        if (i > i2) {
            this.mAngleSum = 360 - (i - i2);
        } else {
            this.mAngleSum = i2 - i;
        }
        int i4 = this.mAngleSum;
        float f = i4 / 99.0f;
        this.mAngleDiff = f;
        Log.i(TAG, "updateAngleSum() angleSum=" + i4 + " angleDiff=" + f);
    }

    private final void updateDrawCurvedInfo() {
        float f = this.mAngleSum * (this.mIsAnimation ? this.mCurrentBgAniRatio : 1.0f);
        SpenSliderBackgroundDrawable.DrawArcInfo drawArcInfo = new SpenSliderBackgroundDrawable.DrawArcInfo(getWidth(), getHeight(), this.mRadius, this.mIsAnimation ? this.mCurrentBgStrokeWidthAniValue : this.mThickness, AbstractC0622a.m1155a(this.mAngleSum, f, 2.0f, this.mAngleStart), f, this.mExtendedAngle);
        SpenSliderBackgroundDrawable spenSliderBackgroundDrawable = this.mArcDrawable;
        if (spenSliderBackgroundDrawable != null) {
            spenSliderBackgroundDrawable.setDrawInfo(drawArcInfo);
        }
    }

    private final void updateSliderValue(double angleDegree) {
        int iCalculateValue = calculateValue(angleDegree);
        this.mCurrentValue = iCalculateValue;
        Log.i(TAG, " updateSliderValue angleDegree=" + angleDegree + ", value=" + iCalculateValue);
        OnChangedListener onChangedListener = this.mChangedListener;
        if (onChangedListener != null) {
            onChangedListener.onChanged(iCalculateValue, false);
        }
    }

    private final void updateThumbPosition(double angleDegree) {
        if (this.mThumbView == null) {
            return;
        }
        double d = (angleDegree * 3.141592653589793d) / ((double) 180);
        float fM2210a = (float) (AbstractC2821a.m2210a(d, this.mRadius, this.mCenter.x) - ((double) (this.mThumbSize / 2)));
        float fM5b = (float) (AbstractC0000a.m5b(d, this.mRadius, this.mCenter.y) - ((double) (this.mThumbSize / 2)));
        SpenCurvedSliderThumbView spenCurvedSliderThumbView = this.mThumbView;
        Intrinsics.checkNotNull(spenCurvedSliderThumbView);
        spenCurvedSliderThumbView.setX(fM2210a);
        SpenCurvedSliderThumbView spenCurvedSliderThumbView2 = this.mThumbView;
        Intrinsics.checkNotNull(spenCurvedSliderThumbView2);
        spenCurvedSliderThumbView2.setY(fM5b);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0068 A[PHI: r1
      0x0068: PHI (r1v8 int) = (r1v2 int), (r1v11 int) binds: [B:39:0x009a, B:22:0x0066] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0073 A[PHI: r0
      0x0073: PHI (r0v4 int) = (r0v3 int), (r0v7 int) binds: [B:43:0x00a4, B:26:0x0071] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void updateThumbView(double angleDegree) {
        int i;
        int i2;
        if (this.mThumbView == null) {
            return;
        }
        double d = angleDegree < 0.0d ? 360.0d + angleDegree : angleDegree;
        Log.i(TAG, "updateThumbView()-1 angleDegree=" + angleDegree + ", angle=" + d + ", isReversed()=" + isReversed());
        if (isReversed()) {
            if (angleDegree < 0.0d && d < this.mAngleStart - this.mExtendedAngle) {
                return;
            }
            if (angleDegree >= 0.0d && d > this.mAngleEnd + this.mExtendedAngle) {
                return;
            }
            if (angleDegree < 0.0d) {
                i2 = this.mAngleStart;
                if (d < i2) {
                    d = i2;
                }
            }
            if (angleDegree >= 0.0d) {
                i = this.mAngleEnd;
                if (d > i) {
                    d = i;
                }
            }
        } else {
            if (angleDegree < 0.0d && d > this.mAngleEnd + this.mExtendedAngle) {
                return;
            }
            if (angleDegree >= 0.0d && d < this.mAngleStart - this.mExtendedAngle) {
                return;
            }
            if (angleDegree < 0.0d) {
                i2 = this.mAngleEnd;
                if (d > i2) {
                }
            }
            if (angleDegree >= 0.0d) {
                i = this.mAngleStart;
                if (d < i) {
                }
            }
        }
        Log.i(TAG, "updateThumbView()-2 angleDegree= " + angleDegree + " angle= " + d);
        updateSliderValue(d);
        updateThumbPosition(d);
    }

    public void close() {
        this.mThumbView = null;
        SpenSliderBackgroundDrawable spenSliderBackgroundDrawable = this.mArcDrawable;
        if (spenSliderBackgroundDrawable != null) {
            spenSliderBackgroundDrawable.close();
        }
        this.mArcDrawable = null;
        View view = this.mBackgroundView;
        if (view != null) {
            view.setBackground(null);
        }
        this.mBackgroundView = null;
        this.mAnimationListener = null;
    }

    @Nullable
    public final SpenCurvedSliderThumbView getMThumbView() {
        return this.mThumbView;
    }

    public final boolean isRawPointInView(float absX, float absY) {
        getLocationOnScreen(new int[2]);
        return isSliderTouched(absX - r0[0], absY - r0[1]);
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        initView(context);
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (w <= 0 || h <= 0) {
            return;
        }
        PointF pointF = this.mCenter;
        pointF.x = w / 2.0f;
        pointF.y = h / 2.0f;
        updateDrawCurvedInfo();
        SpenSliderBackgroundDrawable spenSliderBackgroundDrawable = this.mArcDrawable;
        if (spenSliderBackgroundDrawable != null) {
            spenSliderBackgroundDrawable.setCheckerboardDrawableEnable(this.mIsSupportCheckBg);
        }
        updateThumbView(calculateAngleDegree(this.mCurrentValue));
        for (int i = 1; i < 101; i++) {
            Log.i(TAG, "value=" + i + ", angle=" + calculateAngleDegree(i));
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        if (action != 0) {
            if (action == 1) {
                OnChangedListener onChangedListener = this.mChangedListener;
                if (onChangedListener != null) {
                    onChangedListener.onChanged(this.mCurrentValue, true);
                }
            } else if (action == 2) {
                updateThumbView(Math.toDegrees(Math.atan2(event.getY() - this.mCenter.y, event.getX() - this.mCenter.x)));
            }
        } else if (!isSliderTouched(event.getX(), event.getY())) {
            return false;
        }
        return true;
    }

    public final void setMThumbView(@Nullable SpenCurvedSliderThumbView spenCurvedSliderThumbView) {
        this.mThumbView = spenCurvedSliderThumbView;
    }

    public final void setOnAnimationListener(@Nullable OnAnimationListener listener) {
        this.mAnimationListener = listener;
    }

    public final void setOnChangedListener(@Nullable OnChangedListener listener) {
        this.mChangedListener = listener;
    }

    public final void setProgressColor(@NotNull int[] colors) {
        SpenSliderBackgroundDrawable spenSliderBackgroundDrawable;
        Intrinsics.checkNotNullParameter(colors, "colors");
        int[] iArrCopyOf = Arrays.copyOf(colors, colors.length);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(this, size)");
        this.mProgressBackgroundColor = iArrCopyOf;
        if (getWidth() == 0 || getHeight() == 0 || (spenSliderBackgroundDrawable = this.mArcDrawable) == null) {
            return;
        }
        spenSliderBackgroundDrawable.setGradientColor(this.mProgressBackgroundColor);
    }

    public final void setSupportCheckBg(boolean support) {
        this.mIsSupportCheckBg = support;
        SpenSliderBackgroundDrawable spenSliderBackgroundDrawable = this.mArcDrawable;
        if (spenSliderBackgroundDrawable != null) {
            spenSliderBackgroundDrawable.setCheckerboardDrawableEnable(support);
        }
    }

    public final void setValue(int value) {
        AbstractC6670b.m4744e(value, this.mCurrentValue, "setValue() value=", " current=", TAG);
        this.mCurrentValue = value;
        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }
        updateThumbView(calculateAngleDegree(value));
    }

    public void setVisibility(int visibility, boolean animation) {
        this.mIsAnimation = animation;
        if ((getVisibility() != 0 && visibility != 0) || !animation) {
            setVisibility(visibility);
        } else {
            setVisibility(0);
            startCurvedAnimation(visibility == 0);
        }
    }

    public final void startCurvedAnimation(boolean isShow) {
        if (this.mRatioAnimator.isRunning()) {
            this.mRatioAnimator.cancel();
        }
        if (isShow) {
            startShowAnimation();
        } else {
            startHideAnimation();
        }
    }
}
