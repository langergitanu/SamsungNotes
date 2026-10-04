package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.appcompat.animation.C0421a;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.PopOverActivityWrapper;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.CurvedSlider;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.SliderBackgroundDrawable;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p258y.AbstractC14516b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000w\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b(*\u0001.\b\u0016\u0018\u0000 `2\u00020\u0001:\u0004`abcB\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0017H\u0004J\b\u00103\u001a\u000201H\u0016J\b\u00104\u001a\u000201H\u0014J(\u00105\u001a\u0002012\u0006\u00106\u001a\u00020\u000b2\u0006\u00107\u001a\u00020\u000b2\u0006\u00108\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0014J\u0010\u0010:\u001a\u00020\u00172\u0006\u0010;\u001a\u00020<H\u0017J\u0016\u0010=\u001a\u00020\u00172\u0006\u0010>\u001a\u00020\u000f2\u0006\u0010?\u001a\u00020\u000fJ\u0018\u0010@\u001a\u00020\u00172\u0006\u0010A\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020\u000fH\u0002J\b\u0010C\u001a\u000201H\u0002J\b\u0010D\u001a\u000201H\u0002J\u000e\u0010E\u001a\u0002012\u0006\u0010F\u001a\u00020\tJ\u0010\u0010G\u001a\u0002012\u0006\u0010F\u001a\u00020\tH\u0002J\u000e\u0010H\u001a\u0002012\u0006\u0010I\u001a\u00020\u000bJ\u0010\u0010J\u001a\u00020\u000f2\u0006\u0010I\u001a\u00020\u000bH\u0002J\u0010\u0010K\u001a\u0002012\b\u0010L\u001a\u0004\u0018\u00010#J\u0010\u0010M\u001a\u0002012\b\u0010L\u001a\u0004\u0018\u00010'J\u0010\u0010N\u001a\u0002012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u0010O\u001a\u000201H\u0002J\b\u0010P\u001a\u000201H\u0002J\b\u0010Q\u001a\u000201H\u0002J\b\u0010R\u001a\u000201H\u0002J\u0010\u0010S\u001a\u0002012\u0006\u0010T\u001a\u00020\u0017H\u0004J\u0010\u0010U\u001a\u0002012\u0006\u0010V\u001a\u00020\u000bH\u0002J\b\u0010W\u001a\u00020\u0017H\u0002J\u0018\u0010X\u001a\u0002012\u0006\u0010Y\u001a\u00020\u000f2\u0006\u0010Z\u001a\u00020\u0017H\u0002J\u0010\u0010[\u001a\u0002012\u0006\u0010\\\u001a\u00020\u000fH\u0002J\u0010\u0010]\u001a\u00020\u000b2\u0006\u0010Y\u001a\u00020\u000fH\u0002J\u0018\u0010^\u001a\u0002012\u0006\u0010Y\u001a\u00020\u000f2\u0006\u0010Z\u001a\u00020\u0017H\u0002J\u001a\u0010_\u001a\u0002012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0004\n\u0002\u0010/¨\u0006d"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/CurvedSlider;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mProgressBackgroundColor", "", "mCurrentValue", "", "mCenter", "Landroid/graphics/PointF;", "mRadius", "", "mAngleStart", "mAngleEnd", "mAngleSum", "mAngleDiff", "mThickness", "mOpacityExtendedAngle", "mIsTouched", "", "mArcDrawable", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SliderBackgroundDrawable;", "mCheckerBoardDrawable", "mThumbView", "Landroid/view/View;", "getMThumbView", "()Landroid/view/View;", "setMThumbView", "(Landroid/view/View;)V", "mBackgroundView", "mChangedListener", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/CurvedSlider$OnChangedListener;", "mThumbSize", "mIsSupportCheckBg", "mAnimationListener", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/CurvedSlider$OnAnimationListener;", "mIsAnimationCancelled", "mRatioAnimator", "Landroid/animation/ValueAnimator;", "mCurrentBgAniRatio", "mCurrentBgStrokeWidthAniValue", "mBgStrokeWidthFloatProperty", "com/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/CurvedSlider$mBgStrokeWidthFloatProperty$1", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/CurvedSlider$mBgStrokeWidthFloatProperty$1;", "setSupportCheckBg", "", "support", "close", "onFinishInflate", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "isRawPointInView", "absX", "absY", "isSliderTouched", "x", "y", "updateAngleSum", "setProgressBackground", "setProgressColor", "colors", "updateProgressColors", "setValue", "value", "calculateAngleDegree", "setOnChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnAnimationListener", "initView", "updatedDrawCurvedInfo", "initAnimator", "startShowAnimation", "startHideAnimation", "startCurvedAnimation", "isShow", "setSliderBackground", "color", "isReversed", "updateThumbView", "degrees", "notify", "updateThumbPosition", "angleDegree", "calculateValue", "updateSliderValue", "setAttributes", "Companion", "OnChangedListener", "OnAnimationListener", "FloatValueHolder", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nCurvedSlider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CurvedSlider.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/CurvedSlider\n+ 2 FloatExtension.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/extension/FloatExtensionKt\n+ 3 Context.kt\nandroidx/core/content/ContextKt\n*L\n1#1,410:1\n15#2:411\n15#2:412\n15#2:413\n10#2,2:414\n10#2,2:416\n23#2,4:418\n19#2:422\n15#2:425\n58#3,2:423\n*S KotlinDebug\n*F\n+ 1 CurvedSlider.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/CurvedSlider\n*L\n149#1:411\n157#1:412\n181#1:413\n181#1:414,2\n183#1:416,2\n182#1:418,4\n367#1:422\n404#1:425\n385#1:423,2\n*E\n"})
public class CurvedSlider extends RelativeLayout {
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
    private static final String TAG = "CurvedSlider";
    private float mAngleDiff;
    private int mAngleEnd;
    private int mAngleStart;
    private int mAngleSum;

    @Nullable
    private OnAnimationListener mAnimationListener;

    @Nullable
    private SliderBackgroundDrawable mArcDrawable;

    @Nullable
    private View mBackgroundView;

    @NotNull
    private final CurvedSlider$mBgStrokeWidthFloatProperty$1 mBgStrokeWidthFloatProperty;

    @NotNull
    private PointF mCenter;

    @Nullable
    private OnChangedListener mChangedListener;

    @Nullable
    private SliderBackgroundDrawable mCheckerBoardDrawable;
    private float mCurrentBgAniRatio;
    private float mCurrentBgStrokeWidthAniValue;
    private int mCurrentValue;
    private boolean mIsAnimationCancelled;
    private boolean mIsSupportCheckBg;
    private boolean mIsTouched;
    private float mOpacityExtendedAngle;

    @Nullable
    private int[] mProgressBackgroundColor;
    private float mRadius;

    @NotNull
    private final ValueAnimator mRatioAnimator;
    private float mThickness;
    private int mThumbSize;

    @Nullable
    private View mThumbView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/CurvedSlider$FloatValueHolder;", "", "value", "", "<init>", "(F)V", "getValue", "()F", "setValue", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
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
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/CurvedSlider$OnAnimationListener;", "", "onAnimationEnd", "", "isShowAnimation", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface OnAnimationListener {
        void onAnimationEnd(boolean isShowAnimation);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/CurvedSlider$OnChangedListener;", "", "onChanged", "", "value", "", "fromUser", "", "notify", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface OnChangedListener {
        void onChanged(int value, boolean fromUser, boolean notify);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.CurvedSlider$mBgStrokeWidthFloatProperty$1] */
    public CurvedSlider(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mCurrentValue = 1;
        this.mCenter = new PointF();
        this.mRatioAnimator = new ValueAnimator();
        this.mBgStrokeWidthFloatProperty = new FloatPropertyCompat<FloatValueHolder>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.CurvedSlider$mBgStrokeWidthFloatProperty$1
            {
                super("customFloat");
            }

            @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
            public float getValue(CurvedSlider.FloatValueHolder holder) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                return holder.getValue();
            }

            @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
            public void setValue(CurvedSlider.FloatValueHolder holder, float value) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                holder.setValue(value);
                this.this$0.mCurrentBgStrokeWidthAniValue = value;
            }
        };
        setAttributes(context, attributeSet);
    }

    private final float calculateAngleDegree(int value) {
        float f = (this.mAngleDiff * (value - 1)) + this.mAngleStart;
        return isReversed() ? f - PopOverActivityWrapper.DEFAULT_WIDTH : f;
    }

    private final int calculateValue(float degrees) {
        return RangesKt.coerceAtMost(((int) (((degrees - this.mAngleStart) / this.mAngleSum) * 100)) + 1, 100);
    }

    private final void initAnimator() {
        this.mRatioAnimator.setInterpolator(SpenSettingUtilAnimation.getInterpolator(20));
        this.mRatioAnimator.addUpdateListener(new C0421a(this, 25));
        this.mRatioAnimator.addListener(new Animator.AnimatorListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.CurvedSlider.initAnimator.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                CurvedSlider.this.mIsAnimationCancelled = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                OnAnimationListener onAnimationListener;
                Intrinsics.checkNotNullParameter(animation, "animation");
                if (CurvedSlider.this.mIsAnimationCancelled || (onAnimationListener = CurvedSlider.this.mAnimationListener) == null) {
                    return;
                }
                onAnimationListener.onAnimationEnd(CurvedSlider.this.mCurrentBgAniRatio == 1.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                CurvedSlider.this.mIsAnimationCancelled = false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAnimator$lambda$0(CurvedSlider curvedSlider, ValueAnimator valueAnimator) {
        curvedSlider.mCurrentBgAniRatio = ((Float) AbstractC6670b.m4742c(valueAnimator, "value", "null cannot be cast to non-null type kotlin.Float")).floatValue();
        curvedSlider.updatedDrawCurvedInfo();
    }

    private final void initView(Context context) {
        this.mThumbView = findViewById(C9086R.id.curved_seekbar_thumb);
        this.mThumbSize = context.getResources().getDimensionPixelSize(C9086R.dimen.composer_qt_curved_seekbar_thumb_size);
        this.mBackgroundView = findViewById(C9086R.id.curved_seekbar_background);
        initAnimator();
    }

    private final boolean isReversed() {
        return this.mAngleStart > this.mAngleEnd;
    }

    private final boolean isSliderTouched(float x, float y2) {
        PointF pointF = this.mCenter;
        float f = x - pointF.x;
        float f4 = y2 - pointF.y;
        float f5 = (f4 * f4) + (f * f);
        float f6 = this.mRadius;
        float f7 = this.mThickness;
        float f8 = 2;
        float f9 = (f7 / f8) + f6;
        float f10 = f6 - (f7 / f8);
        if (f5 >= f10 * f10 && f5 <= f9 * f9) {
            float fAtan2 = (float) (((double) (((float) Math.atan2(f4, f)) * 180)) / 3.141592653589793d);
            float f11 = PopOverActivityWrapper.DEFAULT_WIDTH;
            float f12 = fAtan2 % f11;
            if (f12 < 0.0f) {
                f12 += f11;
            }
            float f13 = this.mAngleStart;
            float f14 = this.mOpacityExtendedAngle;
            float f15 = (f13 - f14) % f11;
            if (f15 < 0.0f) {
                f15 += f11;
            }
            float f16 = this.mAngleEnd + f14;
            if (f15 > f16) {
                return f12 >= f15 || f12 <= f16;
            }
            if (f15 <= f12 && f12 <= f16) {
                return true;
            }
        }
        return false;
    }

    private final void setAttributes(Context context, AttributeSet attrs) {
        if (attrs != null) {
            int[] SpenCurvedSlider = C9086R.styleable.SpenCurvedSlider;
            Intrinsics.checkNotNullExpressionValue(SpenCurvedSlider, "SpenCurvedSlider");
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, SpenCurvedSlider, 0, 0);
            this.mAngleStart = typedArrayObtainStyledAttributes.getInteger(C9086R.styleable.SpenCurvedSlider_angleStart, 0);
            this.mAngleEnd = typedArrayObtainStyledAttributes.getInteger(C9086R.styleable.SpenCurvedSlider_angleEnd, 0);
            this.mRadius = typedArrayObtainStyledAttributes.getDimension(C9086R.styleable.SpenCurvedSlider_radius, 0.0f);
            this.mThickness = typedArrayObtainStyledAttributes.getDimension(C9086R.styleable.SpenCurvedSlider_thickness, 0.0f);
            typedArrayObtainStyledAttributes.recycle();
        }
        if (this.mThickness == 0.0f) {
            this.mThickness = getResources().getDimension(C9086R.dimen.composer_qt_dial_bg_thickness);
        }
        if (this.mAngleStart == 0) {
            this.mAngleStart = getResources().getInteger(C9086R.integer.composer_qt_opacity_angle_start);
        }
        if (this.mAngleEnd == 0) {
            this.mAngleEnd = getResources().getInteger(C9086R.integer.composer_qt_opacity_angle_end);
        }
        if (this.mRadius == 0.0f) {
            this.mRadius = getResources().getDimension(C9086R.dimen.composer_qt_circle_radius);
        }
        this.mOpacityExtendedAngle = (float) (((double) (((this.mThickness * 0.5f) / this.mRadius) * 180)) / 3.141592653589793d);
        updateAngleSum();
    }

    private final void setProgressBackground() {
        if (this.mCheckerBoardDrawable == null) {
            SliderBackgroundDrawable sliderBackgroundDrawable = new SliderBackgroundDrawable(getWidth(), getHeight(), this.mRadius, this.mThickness, this.mAngleStart, this.mAngleSum, null);
            this.mCheckerBoardDrawable = sliderBackgroundDrawable;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            sliderBackgroundDrawable.enableCheckerboardDrawable(context);
            View view = this.mBackgroundView;
            if (view != null) {
                SliderBackgroundDrawable sliderBackgroundDrawable2 = this.mCheckerBoardDrawable;
                Intrinsics.checkNotNull(sliderBackgroundDrawable2);
                view.setBackground(sliderBackgroundDrawable2);
            }
        }
    }

    private final void setSliderBackground(int color) {
        int width = getWidth();
        int height = getHeight();
        float f = this.mRadius;
        float f4 = this.mThickness;
        int i = this.mAngleStart;
        int i2 = this.mAngleEnd;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(width, height, "sliderBackground() width=", ", height=", " radius=");
        AbstractC11014a.m12337v(sbM1173s, f, ", thickness=", f4, ", angele[");
        Logger.m11003i(TAG, AbstractC2322a.m1625o(sbM1173s, i, i2, SQLKeyword.COMMA, "]"));
        if (getWidth() <= 0 || getHeight() <= 0) {
            Logger.m11003i(TAG, "Not decided size.");
            return;
        }
        int iRed = Color.red(color);
        int iGreen = Color.green(color);
        int iBlue = Color.blue(color);
        int[] iArr = {Color.argb(0, iRed, iGreen, iBlue), Color.argb(255, iRed, iGreen, iBlue)};
        SliderBackgroundDrawable sliderBackgroundDrawable = this.mArcDrawable;
        if (sliderBackgroundDrawable != null) {
            if (sliderBackgroundDrawable != null) {
                sliderBackgroundDrawable.updatePaint(iArr);
                return;
            }
            return;
        }
        SliderBackgroundDrawable sliderBackgroundDrawable2 = new SliderBackgroundDrawable(getWidth(), getHeight(), this.mRadius, this.mThickness, this.mAngleStart, this.mAngleSum, iArr);
        this.mArcDrawable = sliderBackgroundDrawable2;
        View view = this.mBackgroundView;
        if (view != null) {
            view.setForeground(sliderBackgroundDrawable2);
        }
        SliderBackgroundDrawable sliderBackgroundDrawable3 = new SliderBackgroundDrawable(getWidth(), getHeight(), this.mRadius, this.mThickness, this.mAngleStart, this.mAngleSum, iArr);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        sliderBackgroundDrawable3.enableCheckerboardDrawable(context);
        View view2 = this.mBackgroundView;
        if (view2 != null) {
            view2.setBackground(sliderBackgroundDrawable3);
        }
    }

    private final void startHideAnimation() {
        this.mRatioAnimator.setDuration(350L);
        this.mRatioAnimator.setFloatValues(1.0f, 0.0f);
        this.mRatioAnimator.start();
        SpringAnimation springAnimation = new SpringAnimation(new FloatValueHolder(getResources().getDimensionPixelSize(C9086R.dimen.composer_qt_thickness_bg_max_stroke_width)), this.mBgStrokeWidthFloatProperty);
        SpringForce springForce = new SpringForce();
        springForce.setDampingRatio(1.0f);
        springForce.setStiffness(400.0f);
        springForce.setFinalPosition(getResources().getDimensionPixelSize(C9086R.dimen.composer_qt_thickness_bg_min_stroke_width));
        springAnimation.setSpring(springForce);
        springAnimation.start();
    }

    private final void startShowAnimation() {
        this.mRatioAnimator.setDuration(400L);
        this.mRatioAnimator.setFloatValues(0.0f, 1.0f);
        this.mRatioAnimator.start();
        SpringAnimation springAnimation = new SpringAnimation(new FloatValueHolder(getResources().getDimensionPixelSize(C9086R.dimen.composer_qt_thickness_bg_min_stroke_width)), this.mBgStrokeWidthFloatProperty);
        SpringForce springForce = new SpringForce();
        springForce.setDampingRatio(0.3f);
        springForce.setStiffness(200.0f);
        springForce.setFinalPosition(getResources().getDimensionPixelSize(C9086R.dimen.composer_qt_thickness_bg_max_stroke_width));
        springAnimation.setSpring(springForce);
        springAnimation.start();
    }

    private final void updateAngleSum() {
        int i = this.mAngleStart;
        int i2 = this.mAngleEnd;
        int i4 = i > i2 ? 360 - (i - i2) : i2 - i;
        this.mAngleSum = i4;
        float f = i4 / 99.0f;
        this.mAngleDiff = f;
        Logger.m11003i(TAG, "updateAngleSum() angleSum=" + i4 + " angleDiff=" + f);
    }

    private final void updateProgressColors(int[] colors) {
        SliderBackgroundDrawable sliderBackgroundDrawable = this.mArcDrawable;
        if (sliderBackgroundDrawable != null) {
            if (sliderBackgroundDrawable != null) {
                sliderBackgroundDrawable.updatePaint(colors);
            }
        } else {
            SliderBackgroundDrawable sliderBackgroundDrawable2 = new SliderBackgroundDrawable(getWidth(), getHeight(), this.mRadius, this.mThickness, this.mAngleStart, this.mAngleSum, colors);
            this.mArcDrawable = sliderBackgroundDrawable2;
            View view = this.mBackgroundView;
            if (view != null) {
                view.setForeground(sliderBackgroundDrawable2);
            }
        }
    }

    private final void updateSliderValue(float degrees, boolean notify) {
        int iCalculateValue = calculateValue(degrees);
        Logger.m11003i(TAG, " updateSliderValue degrees=" + degrees + ", value=" + iCalculateValue);
        OnChangedListener onChangedListener = this.mChangedListener;
        if (onChangedListener != null) {
            onChangedListener.onChanged(iCalculateValue, true, notify);
        }
    }

    private final void updateThumbPosition(float angleDegree) {
        View view = this.mThumbView;
        if (view == null) {
            return;
        }
        double d = (float) ((((double) angleDegree) * 3.141592653589793d) / ((double) 180));
        view.setX(((this.mRadius * ((float) Math.cos(d))) + this.mCenter.x) - (this.mThumbSize * 0.5f));
        view.setY(((this.mRadius * ((float) Math.sin(d))) + this.mCenter.y) - (this.mThumbSize * 0.5f));
    }

    private final void updateThumbView(float degrees, boolean notify) {
        if (this.mThumbView == null) {
            return;
        }
        float fCoerceIn = RangesKt.coerceIn(degrees, this.mAngleStart, this.mAngleEnd);
        updateSliderValue(fCoerceIn, notify);
        updateThumbPosition(fCoerceIn);
    }

    private final void updatedDrawCurvedInfo() {
        float f = this.mAngleSum * this.mCurrentBgAniRatio;
        SliderBackgroundDrawable.DrawArcInfo drawArcInfo = new SliderBackgroundDrawable.DrawArcInfo(getWidth(), getHeight(), this.mRadius, this.mCurrentBgStrokeWidthAniValue, this.mAngleEnd - f, f);
        SliderBackgroundDrawable sliderBackgroundDrawable = this.mArcDrawable;
        if (sliderBackgroundDrawable != null) {
            sliderBackgroundDrawable.setDrawInfo(drawArcInfo);
        }
        SliderBackgroundDrawable sliderBackgroundDrawable2 = this.mCheckerBoardDrawable;
        if (sliderBackgroundDrawable2 != null) {
            sliderBackgroundDrawable2.setDrawInfo(drawArcInfo);
        }
    }

    public void close() {
        this.mThumbView = null;
        SliderBackgroundDrawable sliderBackgroundDrawable = this.mArcDrawable;
        if (sliderBackgroundDrawable != null) {
            sliderBackgroundDrawable.close();
        }
        this.mArcDrawable = null;
        SliderBackgroundDrawable sliderBackgroundDrawable2 = this.mCheckerBoardDrawable;
        if (sliderBackgroundDrawable2 != null) {
            sliderBackgroundDrawable2.close();
        }
        this.mCheckerBoardDrawable = null;
        View view = this.mBackgroundView;
        if (view != null) {
            view.setBackground(null);
        }
        View view2 = this.mBackgroundView;
        if (view2 != null) {
            view2.setForeground(null);
        }
        this.mBackgroundView = null;
        this.mAnimationListener = null;
    }

    @Nullable
    public final View getMThumbView() {
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
        int[] iArr = this.mProgressBackgroundColor;
        if (iArr != null) {
            Intrinsics.checkNotNull(iArr);
            updateProgressColors(iArr);
        }
        if (this.mIsSupportCheckBg) {
            setProgressBackground();
        }
        updateThumbView(calculateAngleDegree(this.mCurrentValue), false);
        for (int i = 1; i < 101; i++) {
            Logger.m11003i(TAG, "value=" + i + ", angle=" + calculateAngleDegree(i));
        }
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        if (action == 0) {
            boolean zIsSliderTouched = isSliderTouched(event.getX(), event.getY());
            this.mIsTouched = zIsSliderTouched;
            if (!zIsSliderTouched) {
                return false;
            }
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action != 1) {
            if (action == 2 && this.mIsTouched) {
                updateThumbView((float) (((double) (((float) Math.atan2(event.getY() - this.mCenter.y, event.getX() - this.mCenter.x)) * 180)) / 3.141592653589793d), false);
            }
        } else if (this.mIsTouched) {
            updateThumbView((float) (((double) (((float) Math.atan2(event.getY() - this.mCenter.y, event.getX() - this.mCenter.x)) * 180)) / 3.141592653589793d), true);
            getParent().requestDisallowInterceptTouchEvent(false);
        }
        return true;
    }

    public final void setMThumbView(@Nullable View view) {
        this.mThumbView = view;
    }

    public final void setOnAnimationListener(@Nullable OnAnimationListener listener) {
        this.mAnimationListener = listener;
    }

    public final void setOnChangedListener(@Nullable OnChangedListener listener) {
        this.mChangedListener = listener;
    }

    public final void setProgressColor(@NotNull int[] colors) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        int[] iArrCopyOf = Arrays.copyOf(colors, colors.length);
        Intrinsics.checkNotNullExpressionValue(iArrCopyOf, "copyOf(...)");
        this.mProgressBackgroundColor = iArrCopyOf;
        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }
        int[] iArr = this.mProgressBackgroundColor;
        Intrinsics.checkNotNull(iArr);
        updateProgressColors(iArr);
    }

    public final void setSupportCheckBg(boolean support) {
        this.mIsSupportCheckBg = support;
    }

    public final void setValue(int value) {
        AbstractC14516b.m15114b(value, this.mCurrentValue, "setValue() value=", " current=", TAG);
        this.mCurrentValue = value;
        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }
        updateThumbView(calculateAngleDegree(value), false);
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
