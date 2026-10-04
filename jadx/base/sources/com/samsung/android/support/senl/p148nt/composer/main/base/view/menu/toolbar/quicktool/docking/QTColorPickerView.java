package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.FloatValueHolder;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.util.VUtilString;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.PopOverActivityWrapper;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTColorPickerView;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.animation.QTAnimationKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u009d\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b/*\u0001J\u0018\u0000 }2\u00020\u0001:\u0005}~\u007f\u0080\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0010\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020OH\u0014J\u0010\u0010P\u001a\u00020\u00132\u0006\u0010Q\u001a\u00020RH\u0016J\u0006\u0010S\u001a\u00020MJ\u000e\u0010T\u001a\u00020M2\u0006\u0010U\u001a\u00020\u0013J\u000e\u0010V\u001a\u00020M2\u0006\u0010W\u001a\u00020DJ\u0010\u0010X\u001a\u00020M2\b\u0010W\u001a\u0004\u0018\u00010FJ\u0010\u0010Y\u001a\u00020M2\b\u0010W\u001a\u0004\u0018\u00010HJ\u000e\u0010Z\u001a\u00020M2\u0006\u0010[\u001a\u000202J\b\u0010\\\u001a\u00020MH\u0002J\u0018\u0010]\u001a\u00020\u00132\u0006\u0010^\u001a\u00020\n2\u0006\u0010_\u001a\u00020\nH\u0002J\u0010\u0010`\u001a\u00020M2\u0006\u0010N\u001a\u00020OH\u0002J\u0010\u0010a\u001a\u00020M2\u0006\u0010b\u001a\u00020\u001fH\u0002J\u0010\u0010c\u001a\u00020M2\u0006\u0010b\u001a\u00020\u001fH\u0002J \u0010d\u001a\u00020M2\u0006\u0010^\u001a\u00020\n2\u0006\u0010_\u001a\u00020\n2\u0006\u0010b\u001a\u00020\u001fH\u0002J\u0010\u0010e\u001a\u00020M2\u0006\u0010f\u001a\u00020\nH\u0002J\u0010\u0010g\u001a\u00020M2\u0006\u0010f\u001a\u00020\nH\u0002J\u0010\u0010h\u001a\u00020M2\u0006\u0010i\u001a\u00020\nH\u0002J\u0010\u0010j\u001a\u00020M2\u0006\u0010f\u001a\u00020\nH\u0002J\u0010\u0010k\u001a\u00020M2\u0006\u0010i\u001a\u00020\nH\u0002J \u0010l\u001a\u00020\u00132\u0006\u0010^\u001a\u00020\n2\u0006\u0010_\u001a\u00020\n2\u0006\u0010b\u001a\u00020\u001fH\u0002J\u0010\u0010m\u001a\u00020M2\u0006\u0010N\u001a\u00020OH\u0002J\u0010\u0010n\u001a\u00020M2\u0006\u0010N\u001a\u00020OH\u0002J8\u0010o\u001a\u00020M2\u0006\u0010N\u001a\u00020O2\u0006\u0010p\u001a\u00020\u001f2\u0006\u0010q\u001a\u00020\n2\u0006\u0010r\u001a\u00020\n2\u0006\u0010s\u001a\u00020\n2\u0006\u0010t\u001a\u00020\u0013H\u0002J\u0010\u0010u\u001a\u00020M2\u0006\u0010N\u001a\u00020OH\u0002J\u0010\u0010v\u001a\u00020\u001f2\u0006\u0010w\u001a\u00020\nH\u0002J\b\u0010x\u001a\u00020MH\u0002J\b\u0010y\u001a\u00020MH\u0002J\b\u0010z\u001a\u00020MH\u0002J\b\u0010{\u001a\u00020MH\u0002J\u0010\u0010|\u001a\u00020M2\u0006\u0010U\u001a\u00020\u0013H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020)X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020@X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020BX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u0004\u0018\u00010DX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u0004\u0018\u00010FX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u0004\u0018\u00010HX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u00020JX\u0082\u0004¢\u0006\u0004\n\u0002\u0010K¨\u0006\u0081\u0001"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTColorPickerView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "innerRadius", "", "innerCirclePath", "Landroid/graphics/Path;", "mHsvPaint", "Landroid/graphics/Paint;", "mHandlerPaint", "colors", "", "value", "", "shouldShowHueWheel", "getShouldShowHueWheel", "()Z", "setShouldShowHueWheel", "(Z)V", "mHueWheelStartAngle", "mHueWheelRadius", "mHueWheelStrokeWidth", "mHueWheelHandlerRadius", "mHueWheelHandlerAngle", "mHueWheelAlpha", "", "mHueExtendedAngle", "mColorToneSeekBarRadius", "mColorToneSeekBarStrokeWidth", "mColorToneSeekBarBorderWidth", "mColorToneSeekBarHandlerRadius", "mColorToneSeekBarAlpha", "mColorToneExtendedAngle", "mBrightnessHandlerAngle", "mBrightnessHandlerPos", "Landroid/graphics/PointF;", "mSaturationHandlerAngle", "mSaturationHandlerPos", "mBorderStrokeWidth", "mBorderColor", "mHandlerColor", "mBorderStrokeWidthColor", "mHueColor", "mHsv", "", "mCenter", "mIsAttributeTouched", "mSweepAngle", "mHueWheelTrimAnimator", "Landroid/animation/ValueAnimator;", "mHueWheelOpacityAnimator", "mHueHandlerScaleAnimator", "mHueHandlerBorderScaleAnimator", "mSeekbarOpacityAnimator", "mSeekbarHandlerScaleAnimator", "mColorToneSpringAnimation", "Landroidx/dynamicanimation/animation/SpringAnimation;", "mSpringForce", "Landroidx/dynamicanimation/animation/SpringForce;", "mAnimationSet", "Landroid/animation/AnimatorSet;", "mOnColorChangedListener", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTColorPickerView$OnColorChangedListener;", "mAnimationListener", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTColorPickerView$AnimationListener;", "mPickerActionListener", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTColorPickerView$OnActionListener;", "mSeekbarFloatProperty", "com/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTColorPickerView$mSeekbarFloatProperty$1", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTColorPickerView$mSeekbarFloatProperty$1;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "event", "Landroid/view/MotionEvent;", "close", "startAnimation", "isShow", "setOnColorChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setAnimationListener", "setOnPickerActionListener", "setPositionByColor", "hsvColor", "init", "isColorWheelTouch", "x", "y", "drawHueWheel", "notifyPickerPressed", "attribute", "notifyPickerReleased", "adjustHandlerPosition", "updateHueValue", "degrees", "updateBrightnessView", "updateBrightnessValue", "angleDegree", "updateSaturationView", "updateSaturationValue", "isSeekBarTouch", "drawColorToneSeekBar", "drawHueHandler", "drawHandler", "color", "cx", "cy", "radius", "hasBorder", "drawColorToneSeekBarHandler", "getHueColorAtAngle", "angel", "initHandlerPaint", "initHsvPaint", "updateSelectedColor", "initAnimator", "startAnimationShow", "Companion", "AnimationListener", "OnActionListener", "OnColorChangedListener", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nQTColorPickerView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 QTColorPickerView.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTColorPickerView\n+ 2 Canvas.kt\nandroidx/core/graphics/CanvasKt\n+ 3 FloatExtension.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/extension/FloatExtensionKt\n+ 4 Animator.kt\nandroidx/core/animation/AnimatorKt\n*L\n1#1,697:1\n27#2,7:698\n15#3:705\n15#3:706\n15#3:707\n10#3,2:708\n23#3,4:710\n15#3:714\n15#3:715\n15#3:716\n23#3,4:717\n23#3,4:721\n19#3:725\n19#3:726\n23#3,4:727\n19#3:731\n19#3:732\n15#3:733\n10#3,2:734\n23#3,4:736\n23#3,4:740\n19#3:744\n19#3:745\n10#3,2:746\n29#4:748\n85#4,18:749\n*S KotlinDebug\n*F\n+ 1 QTColorPickerView.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTColorPickerView\n*L\n166#1:698,7\n257#1:705\n265#1:706\n296#1:707\n296#1:708,2\n297#1:710,4\n363#1:714\n367#1:715\n372#1:716\n383#1:717,4\n399#1:721,4\n404#1:725\n405#1:726\n417#1:727,4\n422#1:731\n423#1:732\n440#1:733\n440#1:734,2\n442#1:736,4\n447#1:740,4\n497#1:744\n498#1:745\n558#1:746,2\n640#1:748\n640#1:749,18\n*E\n"})
public final class QTColorPickerView extends View {
    private static final float ANGLE_SUM = 60.0f;
    private static final int ATTRIBUTE_BRIGHTNESS = 2;
    private static final int ATTRIBUTE_HUE = 1;
    private static final int ATTRIBUTE_SATURATION = 3;
    private static final float BRIGHTNESS_ANGLE_END = 345.0f;
    private static final float BRIGHTNESS_ANGLE_START = 285.0f;
    private static final long HIDE_HUE_HANDLER_ANIMATION_DURATION = 350;
    private static final long HIDE_HUE_TRIM_ANIMATION_DURATION = 350;
    private static final long HIDE_SEEKBAR_OPACITY_ANIMATION_DURATION = 100;
    private static final float HUE_ANGLE_END = 45.0f;
    private static final float HUE_ANGLE_START = 285.0f;
    private static final long HUE_OPACITY_ANIMATION_DURATION = 350;
    private static final float HUE_RANGE = 120.0f;
    private static final int MAX_ALPHA = 255;
    private static final float SATURATION_ANGLE_END = 75.0f;
    private static final float SATURATION_ANGLE_START = 15.0f;
    private static final float SEEK_BAR_SPRING_DAMPING_RATIO = 0.75f;
    private static final float SEEK_BAR_SPRING_STIFFNESS = 300.0f;
    private static final long SHOW_HUE_HANDLER_ANIMATION_DURATION = 400;
    private static final long SHOW_HUE_TRIM_ANIMATION_DURATION = 400;
    private static final long SHOW_SEEKBAR_OPACITY_ANIMATION_DURATION = 200;

    @NotNull
    private final int[] colors;
    private Path innerCirclePath;
    private final float innerRadius;

    @Nullable
    private AnimationListener mAnimationListener;

    @NotNull
    private final AnimatorSet mAnimationSet;
    private int mBorderColor;
    private float mBorderStrokeWidth;
    private int mBorderStrokeWidthColor;
    private float mBrightnessHandlerAngle;

    @NotNull
    private PointF mBrightnessHandlerPos;

    @NotNull
    private PointF mCenter;
    private float mColorToneExtendedAngle;
    private int mColorToneSeekBarAlpha;
    private float mColorToneSeekBarBorderWidth;
    private float mColorToneSeekBarHandlerRadius;
    private float mColorToneSeekBarRadius;
    private float mColorToneSeekBarStrokeWidth;
    private SpringAnimation mColorToneSpringAnimation;
    private int mHandlerColor;
    private Paint mHandlerPaint;

    @NotNull
    private float[] mHsv;
    private Paint mHsvPaint;
    private int mHueColor;
    private float mHueExtendedAngle;

    @NotNull
    private final ValueAnimator mHueHandlerBorderScaleAnimator;

    @NotNull
    private final ValueAnimator mHueHandlerScaleAnimator;
    private int mHueWheelAlpha;
    private float mHueWheelHandlerAngle;
    private float mHueWheelHandlerRadius;

    @NotNull
    private final ValueAnimator mHueWheelOpacityAnimator;
    private float mHueWheelRadius;
    private float mHueWheelStartAngle;
    private float mHueWheelStrokeWidth;

    @NotNull
    private final ValueAnimator mHueWheelTrimAnimator;
    private int mIsAttributeTouched;

    @Nullable
    private OnColorChangedListener mOnColorChangedListener;

    @Nullable
    private OnActionListener mPickerActionListener;
    private float mSaturationHandlerAngle;

    @NotNull
    private PointF mSaturationHandlerPos;

    @NotNull
    private final QTColorPickerView$mSeekbarFloatProperty$1 mSeekbarFloatProperty;

    @NotNull
    private final ValueAnimator mSeekbarHandlerScaleAnimator;

    @NotNull
    private final ValueAnimator mSeekbarOpacityAnimator;

    @NotNull
    private final SpringForce mSpringForce;
    private float mSweepAngle;
    private boolean shouldShowHueWheel;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTColorPickerView$AnimationListener;", "", "onAnimationEnd", "", "isShowAnimation", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface AnimationListener {
        void onAnimationEnd(boolean isShowAnimation);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTColorPickerView$OnActionListener;", "", "onHuePressed", "", "onHueReleased", "onSaturationPressed", "onSaturationReleased", "onBrightnessPressed", "onBrightnessReleased", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface OnActionListener {
        void onBrightnessPressed();

        void onBrightnessReleased();

        void onHuePressed();

        void onHueReleased();

        void onSaturationPressed();

        void onSaturationReleased();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTColorPickerView$OnColorChangedListener;", "", "onColorChanged", "", "hsvColor", "", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface OnColorChangedListener {
        void onColorChanged(@NotNull float[] hsvColor);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v19, types: [com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTColorPickerView$mSeekbarFloatProperty$1] */
    public QTColorPickerView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.innerRadius = getResources().getDimension(C9086R.dimen.qt_ai_menu_radius);
        this.colors = new int[]{-65536, -256, VUtilString.GREEN, VUtilString.CYAN, -16776961, VUtilString.MAGENTA, -65536};
        this.shouldShowHueWheel = true;
        this.mBrightnessHandlerPos = new PointF();
        this.mSaturationHandlerPos = new PointF();
        this.mHsv = new float[3];
        this.mCenter = new PointF();
        this.mHueWheelTrimAnimator = new ValueAnimator();
        this.mHueWheelOpacityAnimator = new ValueAnimator();
        this.mHueHandlerScaleAnimator = new ValueAnimator();
        this.mHueHandlerBorderScaleAnimator = new ValueAnimator();
        this.mSeekbarOpacityAnimator = new ValueAnimator();
        this.mSeekbarHandlerScaleAnimator = new ValueAnimator();
        this.mSpringForce = new SpringForce();
        this.mAnimationSet = new AnimatorSet();
        this.mSeekbarFloatProperty = new FloatPropertyCompat<FloatValueHolder>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTColorPickerView$mSeekbarFloatProperty$1
            {
                super("Seekbar Radius");
            }

            @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
            public float getValue(FloatValueHolder holder) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                return holder.getValue();
            }

            @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
            public void setValue(FloatValueHolder holder, float value) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                holder.setValue(value);
                this.this$0.mColorToneSeekBarRadius = value;
                QTColorPickerView qTColorPickerView = this.this$0;
                qTColorPickerView.updateSaturationView(qTColorPickerView.mSaturationHandlerAngle);
                QTColorPickerView qTColorPickerView2 = this.this$0;
                qTColorPickerView2.updateBrightnessView(qTColorPickerView2.mBrightnessHandlerAngle);
                this.this$0.invalidate();
            }
        };
        init();
    }

    private final void adjustHandlerPosition(float x, float y2, int attribute) {
        PointF pointF = this.mCenter;
        float f = x - pointF.x;
        float f4 = y2 - pointF.y;
        if (attribute == 1) {
            updateHueValue((float) (((double) (((float) Math.atan2(f4, f)) * 180)) / 3.141592653589793d));
        } else if (attribute == 2) {
            float fAtan2 = (float) (((double) (((float) Math.atan2(f4, f)) * 180)) / 3.141592653589793d);
            this.mBrightnessHandlerAngle = fAtan2;
            updateBrightnessView(fAtan2);
        } else if (attribute == 3) {
            float fAtan22 = (float) (((double) (((float) Math.atan2(f4, f)) * 180)) / 3.141592653589793d);
            this.mSaturationHandlerAngle = fAtan22;
            updateSaturationView(fAtan22);
        }
        updateSelectedColor();
    }

    private final void drawColorToneSeekBar(Canvas canvas) {
        Paint paint;
        Paint paint2;
        Paint paint3;
        Paint paint4;
        Color.colorToHSV(this.mHueColor, new float[3]);
        PointF pointF = this.mCenter;
        float f = pointF.x;
        float f4 = this.mColorToneSeekBarRadius;
        float f5 = pointF.y;
        RectF rectF = new RectF(f - f4, f5 - f4, f + f4, f5 + f4);
        Paint paint5 = this.mHsvPaint;
        if (paint5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHsvPaint");
            paint5 = null;
        }
        paint5.setStrokeWidth(this.mColorToneSeekBarBorderWidth);
        Paint paint6 = this.mHsvPaint;
        if (paint6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHsvPaint");
            paint6 = null;
        }
        paint6.setColor(this.mBorderStrokeWidthColor);
        Paint paint7 = this.mHsvPaint;
        if (paint7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHsvPaint");
            paint7 = null;
        }
        paint7.setAlpha(this.mColorToneSeekBarAlpha);
        Paint paint8 = this.mHsvPaint;
        if (paint8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHsvPaint");
            paint = null;
        } else {
            paint = paint8;
        }
        canvas.drawArc(rectF, 285.0f, 60.0f, false, paint);
        Paint paint9 = this.mHsvPaint;
        if (paint9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHsvPaint");
            paint2 = null;
        } else {
            paint2 = paint9;
        }
        canvas.drawArc(rectF, 15.0f, 60.0f, false, paint2);
        Paint paint10 = this.mHsvPaint;
        if (paint10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHsvPaint");
            paint10 = null;
        }
        paint10.setStrokeWidth(this.mColorToneSeekBarStrokeWidth);
        int iHSVToColor = Color.HSVToColor(new float[]{this.mHsv[0], 0.0f, 1.0f});
        float[] fArr = {this.mHsv[0], 0.0f, 0.0f};
        PointF pointF2 = this.mCenter;
        SweepGradient sweepGradient = new SweepGradient(pointF2.x, pointF2.y, new int[]{iHSVToColor, Color.HSVToColor(fArr)}, new float[]{0.7916667f, 0.9583333f});
        Paint paint11 = this.mHsvPaint;
        if (paint11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHsvPaint");
            paint11 = null;
        }
        paint11.setShader(sweepGradient);
        Paint paint12 = this.mHsvPaint;
        if (paint12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHsvPaint");
            paint3 = null;
        } else {
            paint3 = paint12;
        }
        canvas.drawArc(rectF, 285.0f, 60.0f, false, paint3);
        float[] fArr2 = this.mHsv;
        int iHSVToColor2 = Color.HSVToColor(new float[]{fArr2[0], 0.0f, fArr2[2]});
        float[] fArr3 = this.mHsv;
        float[] fArr4 = {fArr3[0], 1.0f, fArr3[2]};
        PointF pointF3 = this.mCenter;
        SweepGradient sweepGradient2 = new SweepGradient(pointF3.x, pointF3.y, new int[]{iHSVToColor2, Color.HSVToColor(fArr4)}, new float[]{0.041666668f, 0.20833333f});
        Paint paint13 = this.mHsvPaint;
        if (paint13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHsvPaint");
            paint13 = null;
        }
        paint13.setShader(sweepGradient2);
        Paint paint14 = this.mHsvPaint;
        if (paint14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHsvPaint");
            paint4 = null;
        } else {
            paint4 = paint14;
        }
        canvas.drawArc(rectF, 15.0f, 60.0f, false, paint4);
        Paint paint15 = this.mHsvPaint;
        if (paint15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHsvPaint");
            paint15 = null;
        }
        paint15.setShader(null);
    }

    private final void drawColorToneSeekBarHandler(Canvas canvas) {
        int iHSVToColor = Color.HSVToColor(new float[]{0.0f, 0.0f, 1.0f});
        PointF pointF = this.mBrightnessHandlerPos;
        drawHandler(canvas, iHSVToColor, pointF.x, pointF.y, this.mColorToneSeekBarHandlerRadius, false);
        PointF pointF2 = this.mSaturationHandlerPos;
        drawHandler(canvas, iHSVToColor, pointF2.x, pointF2.y, this.mColorToneSeekBarHandlerRadius, false);
    }

    private final void drawHandler(Canvas canvas, int color, float cx, float cy, float radius, boolean hasBorder) {
        Paint paint = this.mHandlerPaint;
        Paint paint2 = null;
        if (paint == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHandlerPaint");
            paint = null;
        }
        paint.setStyle(Paint.Style.FILL);
        Paint paint3 = this.mHandlerPaint;
        if (paint3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHandlerPaint");
            paint3 = null;
        }
        paint3.setColor(color);
        if (hasBorder) {
            Paint paint4 = this.mHandlerPaint;
            if (paint4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHandlerPaint");
                paint4 = null;
            }
            paint4.setAlpha(255);
        } else {
            Paint paint5 = this.mHandlerPaint;
            if (paint5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHandlerPaint");
                paint5 = null;
            }
            paint5.setAlpha(this.mColorToneSeekBarAlpha);
        }
        int i = ((int) ((this.mColorToneSeekBarAlpha / 255.0f) * 51)) << 24;
        Paint paint6 = this.mHandlerPaint;
        if (paint6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHandlerPaint");
            paint6 = null;
        }
        paint6.setShadowLayer(getResources().getDimension(C9086R.dimen.composer_qt_color_picker_handler_elevation), 0.0f, 0.0f, i);
        Paint paint7 = this.mHandlerPaint;
        if (paint7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHandlerPaint");
            paint7 = null;
        }
        canvas.drawCircle(cx, cy, radius, paint7);
        if (hasBorder) {
            Paint paint8 = this.mHandlerPaint;
            if (paint8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHandlerPaint");
                paint8 = null;
            }
            paint8.setStyle(Paint.Style.STROKE);
            Paint paint9 = this.mHandlerPaint;
            if (paint9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHandlerPaint");
                paint9 = null;
            }
            paint9.setStrokeWidth(this.mBorderStrokeWidth);
            Paint paint10 = this.mHandlerPaint;
            if (paint10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHandlerPaint");
                paint10 = null;
            }
            paint10.setColor(this.mHandlerColor);
            float f = (this.mBorderStrokeWidth / 2) + radius;
            Paint paint11 = this.mHandlerPaint;
            if (paint11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHandlerPaint");
            } else {
                paint2 = paint11;
            }
            canvas.drawCircle(cx, cy, f, paint2);
        }
    }

    private final void drawHueHandler(Canvas canvas) {
        double d = 180;
        drawHandler(canvas, this.mHueColor, (((float) Math.cos((float) ((((double) this.mHueWheelHandlerAngle) * 3.141592653589793d) / d))) * this.mHueWheelRadius) + this.mCenter.x, (((float) Math.sin((float) ((((double) this.mHueWheelHandlerAngle) * 3.141592653589793d) / d))) * this.mHueWheelRadius) + this.mCenter.y, this.mHueWheelHandlerRadius, true);
    }

    private final void drawHueWheel(Canvas canvas) {
        Paint paint;
        float length = 0.33333334f / (r0.length - 1);
        int length2 = this.colors.length;
        float[] fArr = new float[length2];
        for (int i = 0; i < length2; i++) {
            fArr[i] = i * length;
        }
        Paint paint2 = this.mHsvPaint;
        Paint paint3 = null;
        if (paint2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHsvPaint");
            paint2 = null;
        }
        paint2.setStrokeWidth(this.mHueWheelStrokeWidth);
        PointF pointF = this.mCenter;
        SweepGradient sweepGradient = new SweepGradient(pointF.x, pointF.y, this.colors, fArr);
        Matrix matrix = new Matrix();
        PointF pointF2 = this.mCenter;
        matrix.setRotate(-75.0f, pointF2.x, pointF2.y);
        sweepGradient.setLocalMatrix(matrix);
        Paint paint4 = this.mHsvPaint;
        if (paint4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHsvPaint");
            paint4 = null;
        }
        paint4.setShader(sweepGradient);
        Paint paint5 = this.mHsvPaint;
        if (paint5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHsvPaint");
            paint5 = null;
        }
        paint5.setAlpha(this.mHueWheelAlpha);
        PointF pointF3 = this.mCenter;
        float f = pointF3.x;
        float f4 = this.mHueWheelRadius;
        float f5 = pointF3.y;
        RectF rectF = new RectF(f - f4, f5 - f4, f + f4, f5 + f4);
        float f6 = this.mSweepAngle;
        float f7 = 45.0f - f6;
        Paint paint6 = this.mHsvPaint;
        if (paint6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHsvPaint");
            paint = null;
        } else {
            paint = paint6;
        }
        canvas.drawArc(rectF, f7, f6, false, paint);
        Paint paint7 = this.mHsvPaint;
        if (paint7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHsvPaint");
            paint7 = null;
        }
        paint7.setShader(null);
        Paint paint8 = this.mHsvPaint;
        if (paint8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHsvPaint");
            paint8 = null;
        }
        paint8.setColor(this.mBorderColor);
        Paint paint9 = this.mHsvPaint;
        if (paint9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHsvPaint");
            paint9 = null;
        }
        paint9.setStrokeWidth(this.mBorderStrokeWidth);
        PointF pointF4 = this.mCenter;
        float f8 = pointF4.x;
        float f9 = pointF4.y;
        float f10 = 2;
        float f11 = (this.mBorderStrokeWidth / f10) + (this.mHueWheelStrokeWidth / f10) + this.mHueWheelRadius;
        Paint paint10 = this.mHsvPaint;
        if (paint10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHsvPaint");
            paint10 = null;
        }
        canvas.drawCircle(f8, f9, f11, paint10);
        PointF pointF5 = this.mCenter;
        float f12 = pointF5.x;
        float f13 = pointF5.y;
        float f14 = (this.mHueWheelRadius - (this.mHueWheelStrokeWidth / f10)) - (this.mBorderStrokeWidth / f10);
        Paint paint11 = this.mHsvPaint;
        if (paint11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHsvPaint");
        } else {
            paint3 = paint11;
        }
        canvas.drawCircle(f12, f13, f14, paint3);
    }

    private final int getHueColorAtAngle(float angel) {
        float f = PopOverActivityWrapper.DEFAULT_WIDTH;
        float f4 = (angel - 285.0f) % f;
        if (f4 < 0.0f) {
            f4 += f;
        }
        float[] fArr = this.mHsv;
        float f5 = (f4 / HUE_RANGE) * 360.0f;
        fArr[0] = f5;
        return Color.HSVToColor(new float[]{f5, 1.0f, 1.0f});
    }

    private final void init() {
        setBackgroundColor(0);
        this.mHueWheelRadius = getResources().getDimension(C9086R.dimen.composer_composer_qt_color_picker_hue_wheel_radius);
        float dimension = getResources().getDimension(C9086R.dimen.composer_qt_color_picker_hue_wheel_stroke_width);
        this.mHueWheelStrokeWidth = dimension;
        float f = 180;
        this.mHueExtendedAngle = (float) (((double) (((dimension * 0.5f) / this.mHueWheelRadius) * f)) / 3.141592653589793d);
        this.mColorToneSeekBarRadius = getResources().getDimension(C9086R.dimen.composer_qt_color_picker_color_tone_seekbar_max_radius);
        this.mColorToneSeekBarStrokeWidth = getResources().getDimension(C9086R.dimen.composer_qt_color_picker_color_tone_seekbar_stroke_width);
        this.mColorToneSeekBarBorderWidth = getResources().getDimension(C9086R.dimen.composer_qt_color_picker_color_tone_seekbar_stroke_width_border);
        this.mColorToneExtendedAngle = (float) (((double) (((this.mColorToneSeekBarStrokeWidth * 0.5f) / this.mColorToneSeekBarRadius) * f)) / 3.141592653589793d);
        this.mBorderColor = getResources().getColor(C9086R.color.setting_qt_circle_bg_color, null);
        this.mHandlerColor = getResources().getColor(C9086R.color.setting_qt_color_picker_handler_color, null);
        this.mBorderStrokeWidthColor = getResources().getColor(C9086R.color.setting_qt_color_picker_stroke_width_border_color, null);
        float dimension2 = getResources().getDimension(C9086R.dimen.composer_qt_color_picker_layout_width);
        float dimension3 = getResources().getDimension(C9086R.dimen.composer_qt_color_picker_layout_height);
        PointF pointF = this.mCenter;
        float f4 = 2;
        pointF.x = dimension2 / f4;
        pointF.y = dimension3 / f4;
        Path path = new Path();
        PointF pointF2 = this.mCenter;
        path.addCircle(pointF2.x, pointF2.y, this.innerRadius, Path.Direction.CW);
        this.innerCirclePath = path;
        initHsvPaint();
        initHandlerPaint();
        initAnimator();
    }

    private final void initAnimator() {
        this.mHueWheelTrimAnimator.setInterpolator(SpenSettingUtilAnimation.getInterpolator(20));
        final int i = 0;
        this.mHueWheelTrimAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.b

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ QTColorPickerView f7241b;

            {
                this.f7241b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i) {
                    case 0:
                        QTColorPickerView.initAnimator$lambda$4(this.f7241b, valueAnimator);
                        break;
                    case 1:
                        QTColorPickerView.initAnimator$lambda$5(this.f7241b, valueAnimator);
                        break;
                    case 2:
                        QTColorPickerView.initAnimator$lambda$6(this.f7241b, valueAnimator);
                        break;
                    case 3:
                        QTColorPickerView.initAnimator$lambda$7(this.f7241b, valueAnimator);
                        break;
                    case 4:
                        QTColorPickerView.initAnimator$lambda$8(this.f7241b, valueAnimator);
                        break;
                    default:
                        QTColorPickerView.initAnimator$lambda$9(this.f7241b, valueAnimator);
                        break;
                }
            }
        });
        this.mHueWheelOpacityAnimator.setInterpolator(SpenSettingUtilAnimation.getInterpolator(20));
        final int i2 = 1;
        this.mHueWheelOpacityAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.b

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ QTColorPickerView f7241b;

            {
                this.f7241b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i2) {
                    case 0:
                        QTColorPickerView.initAnimator$lambda$4(this.f7241b, valueAnimator);
                        break;
                    case 1:
                        QTColorPickerView.initAnimator$lambda$5(this.f7241b, valueAnimator);
                        break;
                    case 2:
                        QTColorPickerView.initAnimator$lambda$6(this.f7241b, valueAnimator);
                        break;
                    case 3:
                        QTColorPickerView.initAnimator$lambda$7(this.f7241b, valueAnimator);
                        break;
                    case 4:
                        QTColorPickerView.initAnimator$lambda$8(this.f7241b, valueAnimator);
                        break;
                    default:
                        QTColorPickerView.initAnimator$lambda$9(this.f7241b, valueAnimator);
                        break;
                }
            }
        });
        this.mHueHandlerScaleAnimator.setInterpolator(SpenSettingUtilAnimation.getInterpolator(20));
        final int i4 = 2;
        this.mHueHandlerScaleAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.b

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ QTColorPickerView f7241b;

            {
                this.f7241b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i4) {
                    case 0:
                        QTColorPickerView.initAnimator$lambda$4(this.f7241b, valueAnimator);
                        break;
                    case 1:
                        QTColorPickerView.initAnimator$lambda$5(this.f7241b, valueAnimator);
                        break;
                    case 2:
                        QTColorPickerView.initAnimator$lambda$6(this.f7241b, valueAnimator);
                        break;
                    case 3:
                        QTColorPickerView.initAnimator$lambda$7(this.f7241b, valueAnimator);
                        break;
                    case 4:
                        QTColorPickerView.initAnimator$lambda$8(this.f7241b, valueAnimator);
                        break;
                    default:
                        QTColorPickerView.initAnimator$lambda$9(this.f7241b, valueAnimator);
                        break;
                }
            }
        });
        this.mHueHandlerBorderScaleAnimator.setInterpolator(SpenSettingUtilAnimation.getInterpolator(20));
        final int i5 = 3;
        this.mHueHandlerBorderScaleAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.b

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ QTColorPickerView f7241b;

            {
                this.f7241b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i5) {
                    case 0:
                        QTColorPickerView.initAnimator$lambda$4(this.f7241b, valueAnimator);
                        break;
                    case 1:
                        QTColorPickerView.initAnimator$lambda$5(this.f7241b, valueAnimator);
                        break;
                    case 2:
                        QTColorPickerView.initAnimator$lambda$6(this.f7241b, valueAnimator);
                        break;
                    case 3:
                        QTColorPickerView.initAnimator$lambda$7(this.f7241b, valueAnimator);
                        break;
                    case 4:
                        QTColorPickerView.initAnimator$lambda$8(this.f7241b, valueAnimator);
                        break;
                    default:
                        QTColorPickerView.initAnimator$lambda$9(this.f7241b, valueAnimator);
                        break;
                }
            }
        });
        this.mSeekbarOpacityAnimator.setInterpolator(SpenSettingUtilAnimation.getInterpolator(15));
        final int i6 = 4;
        this.mSeekbarOpacityAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.b

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ QTColorPickerView f7241b;

            {
                this.f7241b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i6) {
                    case 0:
                        QTColorPickerView.initAnimator$lambda$4(this.f7241b, valueAnimator);
                        break;
                    case 1:
                        QTColorPickerView.initAnimator$lambda$5(this.f7241b, valueAnimator);
                        break;
                    case 2:
                        QTColorPickerView.initAnimator$lambda$6(this.f7241b, valueAnimator);
                        break;
                    case 3:
                        QTColorPickerView.initAnimator$lambda$7(this.f7241b, valueAnimator);
                        break;
                    case 4:
                        QTColorPickerView.initAnimator$lambda$8(this.f7241b, valueAnimator);
                        break;
                    default:
                        QTColorPickerView.initAnimator$lambda$9(this.f7241b, valueAnimator);
                        break;
                }
            }
        });
        this.mSeekbarHandlerScaleAnimator.setInterpolator(QTAnimationKt.getOneEasing());
        final int i7 = 5;
        this.mSeekbarHandlerScaleAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.b

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ QTColorPickerView f7241b;

            {
                this.f7241b = this;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                switch (i7) {
                    case 0:
                        QTColorPickerView.initAnimator$lambda$4(this.f7241b, valueAnimator);
                        break;
                    case 1:
                        QTColorPickerView.initAnimator$lambda$5(this.f7241b, valueAnimator);
                        break;
                    case 2:
                        QTColorPickerView.initAnimator$lambda$6(this.f7241b, valueAnimator);
                        break;
                    case 3:
                        QTColorPickerView.initAnimator$lambda$7(this.f7241b, valueAnimator);
                        break;
                    case 4:
                        QTColorPickerView.initAnimator$lambda$8(this.f7241b, valueAnimator);
                        break;
                    default:
                        QTColorPickerView.initAnimator$lambda$9(this.f7241b, valueAnimator);
                        break;
                }
            }
        });
        this.mSpringForce.setDampingRatio(0.75f);
        this.mSpringForce.setStiffness(300.0f);
        this.mAnimationSet.playTogether(this.mHueWheelTrimAnimator, this.mHueWheelOpacityAnimator, this.mHueHandlerScaleAnimator, this.mHueHandlerBorderScaleAnimator, this.mSeekbarOpacityAnimator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAnimator$lambda$4(QTColorPickerView qTColorPickerView, ValueAnimator valueAnimator) {
        qTColorPickerView.mSweepAngle = ((Float) AbstractC6670b.m4742c(valueAnimator, LangPackConfigConstants.LANGUAGE_CODE_IT, "null cannot be cast to non-null type kotlin.Float")).floatValue() * HUE_RANGE;
        qTColorPickerView.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAnimator$lambda$5(QTColorPickerView qTColorPickerView, ValueAnimator valueAnimator) {
        qTColorPickerView.mHueWheelAlpha = ((Integer) AbstractC6670b.m4742c(valueAnimator, LangPackConfigConstants.LANGUAGE_CODE_IT, "null cannot be cast to non-null type kotlin.Int")).intValue();
        qTColorPickerView.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAnimator$lambda$6(QTColorPickerView qTColorPickerView, ValueAnimator valueAnimator) {
        qTColorPickerView.mHueWheelHandlerRadius = ((Float) AbstractC6670b.m4742c(valueAnimator, LangPackConfigConstants.LANGUAGE_CODE_IT, "null cannot be cast to non-null type kotlin.Float")).floatValue();
        qTColorPickerView.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAnimator$lambda$7(QTColorPickerView qTColorPickerView, ValueAnimator valueAnimator) {
        qTColorPickerView.mBorderStrokeWidth = ((Float) AbstractC6670b.m4742c(valueAnimator, LangPackConfigConstants.LANGUAGE_CODE_IT, "null cannot be cast to non-null type kotlin.Float")).floatValue();
        qTColorPickerView.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAnimator$lambda$8(QTColorPickerView qTColorPickerView, ValueAnimator valueAnimator) {
        qTColorPickerView.mColorToneSeekBarAlpha = ((Integer) AbstractC6670b.m4742c(valueAnimator, LangPackConfigConstants.LANGUAGE_CODE_IT, "null cannot be cast to non-null type kotlin.Int")).intValue();
        qTColorPickerView.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initAnimator$lambda$9(QTColorPickerView qTColorPickerView, ValueAnimator valueAnimator) {
        qTColorPickerView.mColorToneSeekBarHandlerRadius = ((Float) AbstractC6670b.m4742c(valueAnimator, LangPackConfigConstants.LANGUAGE_CODE_IT, "null cannot be cast to non-null type kotlin.Float")).floatValue();
        qTColorPickerView.invalidate();
    }

    private final void initHandlerPaint() {
        Paint paint = new Paint();
        this.mHandlerPaint = paint;
        paint.setAntiAlias(true);
    }

    private final void initHsvPaint() {
        Paint paint = new Paint();
        this.mHsvPaint = paint;
        paint.setAntiAlias(true);
        Paint paint2 = this.mHsvPaint;
        Paint paint3 = null;
        if (paint2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHsvPaint");
            paint2 = null;
        }
        paint2.setStyle(Paint.Style.STROKE);
        Paint paint4 = this.mHsvPaint;
        if (paint4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHsvPaint");
            paint4 = null;
        }
        paint4.setStrokeCap(Paint.Cap.ROUND);
        Paint paint5 = this.mHsvPaint;
        if (paint5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHsvPaint");
        } else {
            paint3 = paint5;
        }
        paint3.setAlpha(0);
    }

    private final boolean isColorWheelTouch(float x, float y2) {
        PointF pointF = this.mCenter;
        float f = x - pointF.x;
        float f4 = y2 - pointF.y;
        float f5 = (f4 * f4) + (f * f);
        float f6 = this.mHueWheelRadius;
        float f7 = this.mHueWheelStrokeWidth;
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
            float f13 = this.mHueExtendedAngle;
            float f14 = 285.0f - f13;
            float f15 = f13 + 45.0f;
            if (f14 > f15) {
                return f12 >= f14 || f12 <= f15;
            }
            if (f14 <= f12 && f12 <= f15) {
                return true;
            }
        }
        return false;
    }

    private final boolean isSeekBarTouch(float x, float y2, int attribute) {
        PointF pointF = this.mCenter;
        float f = x - pointF.x;
        float f4 = y2 - pointF.y;
        float f5 = (f4 * f4) + (f * f);
        float f6 = this.mColorToneSeekBarRadius;
        float f7 = this.mColorToneSeekBarStrokeWidth;
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
            if (attribute == 2) {
                float f13 = this.mColorToneExtendedAngle;
                float f14 = 285.0f - f13;
                float f15 = f13 + BRIGHTNESS_ANGLE_END;
                return f14 > f15 ? f12 >= f14 || f12 <= f15 : f14 <= f12 && f12 <= f15;
            }
            float f16 = this.mColorToneExtendedAngle;
            float f17 = 15.0f - f16;
            float f18 = f16 + SATURATION_ANGLE_END;
            if (f17 > f18) {
                return f12 >= f17 || f12 <= f18;
            }
            if (f17 <= f12 && f12 <= f18) {
                return true;
            }
        }
        return false;
    }

    private final void notifyPickerPressed(int attribute) {
        OnActionListener onActionListener = this.mPickerActionListener;
        if (onActionListener != null) {
            if (attribute == 1) {
                onActionListener.onHuePressed();
            } else if (attribute == 2) {
                onActionListener.onBrightnessPressed();
            } else {
                if (attribute != 3) {
                    return;
                }
                onActionListener.onSaturationPressed();
            }
        }
    }

    private final void notifyPickerReleased(int attribute) {
        OnActionListener onActionListener = this.mPickerActionListener;
        if (onActionListener != null) {
            if (attribute == 1) {
                onActionListener.onHueReleased();
            } else if (attribute == 2) {
                onActionListener.onBrightnessReleased();
            } else {
                if (attribute != 3) {
                    return;
                }
                onActionListener.onSaturationReleased();
            }
        }
    }

    private final void startAnimationShow(final boolean isShow) {
        this.mAnimationSet.cancel();
        this.mHueWheelTrimAnimator.setFloatValues(isShow ? 0.0f : 1.0f, isShow ? 1.0f : 0.0f);
        this.mHueWheelTrimAnimator.setDuration(isShow ? 400L : 350L);
        this.mHueWheelTrimAnimator.addListener(new Animator.AnimatorListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTColorPickerView$startAnimationShow$$inlined$doOnEnd$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                QTColorPickerView.AnimationListener animationListener = this.this$0.mAnimationListener;
                if (animationListener != null) {
                    animationListener.onAnimationEnd(isShow);
                }
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        this.mHueWheelOpacityAnimator.setIntValues(isShow ? 0 : 255, isShow ? 255 : 0);
        this.mHueWheelOpacityAnimator.setDuration(350L);
        float dimension = getResources().getDimension(C9086R.dimen.composer_qt_color_picker_hue_wheel_handler_radius);
        ValueAnimator valueAnimator = this.mHueHandlerScaleAnimator;
        float f = isShow ? 0.0f : dimension;
        if (!isShow) {
            dimension = 0.0f;
        }
        valueAnimator.setFloatValues(f, dimension);
        this.mHueHandlerScaleAnimator.setDuration(isShow ? 400L : 350L);
        float dimension2 = getResources().getDimension(C9086R.dimen.composer_qt_color_picker_border_stroke_width);
        ValueAnimator valueAnimator2 = this.mHueHandlerBorderScaleAnimator;
        float f4 = isShow ? 0.0f : dimension2;
        if (!isShow) {
            dimension2 = 0.0f;
        }
        valueAnimator2.setFloatValues(f4, dimension2);
        this.mHueHandlerBorderScaleAnimator.setDuration(isShow ? 400L : 350L);
        this.mSeekbarOpacityAnimator.setIntValues(isShow ? 0 : 255, isShow ? 255 : 0);
        this.mSeekbarOpacityAnimator.setDuration(isShow ? 200L : 100L);
        this.mSeekbarHandlerScaleAnimator.setFloatValues(0.0f, getResources().getDimension(C9086R.dimen.composer_qt_color_picker_color_tone_seekbar_handler_radius));
        this.mSeekbarHandlerScaleAnimator.setDuration(400L);
        this.mColorToneSpringAnimation = new SpringAnimation(isShow ? new FloatValueHolder(getResources().getDimension(C9086R.dimen.composer_qt_color_picker_color_tone_seekbar_min_radius)) : new FloatValueHolder(getResources().getDimension(C9086R.dimen.composer_qt_color_picker_color_tone_seekbar_max_radius)), this.mSeekbarFloatProperty);
        this.mSpringForce.setFinalPosition(isShow ? getResources().getDimension(C9086R.dimen.composer_qt_color_picker_color_tone_seekbar_max_radius) : getResources().getDimension(C9086R.dimen.composer_qt_color_picker_color_tone_seekbar_min_radius));
        SpringAnimation springAnimation = this.mColorToneSpringAnimation;
        SpringAnimation springAnimation2 = null;
        if (springAnimation == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorToneSpringAnimation");
            springAnimation = null;
        }
        springAnimation.setSpring(this.mSpringForce);
        SpringAnimation springAnimation3 = this.mColorToneSpringAnimation;
        if (springAnimation3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorToneSpringAnimation");
        } else {
            springAnimation2 = springAnimation3;
        }
        springAnimation2.start();
        this.mAnimationSet.start();
        if (isShow) {
            this.mSeekbarHandlerScaleAnimator.start();
        }
    }

    private final void updateBrightnessValue(float angleDegree) {
        float f = PopOverActivityWrapper.DEFAULT_WIDTH;
        this.mHsv[2] = 1.0f - RangesKt.coerceIn((((angleDegree - 285.0f) + f) % f) / 60.0f, 0.0f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateBrightnessView(float degrees) {
        if (degrees < 0.0f) {
            degrees += PopOverActivityWrapper.DEFAULT_WIDTH;
        }
        float f = this.mColorToneExtendedAngle;
        float f4 = 285.0f - f;
        float f5 = f + BRIGHTNESS_ANGLE_END;
        if (f4 > f5) {
            if (degrees < f4 && degrees > f5) {
                return;
            }
        } else if (f4 > degrees || degrees > f5) {
            return;
        }
        float fCoerceIn = RangesKt.coerceIn(degrees, 285.0f, BRIGHTNESS_ANGLE_END);
        updateBrightnessValue(fCoerceIn);
        double d = (float) ((((double) fCoerceIn) * 3.141592653589793d) / ((double) 180));
        this.mBrightnessHandlerPos.x = (((float) Math.cos(d)) * this.mColorToneSeekBarRadius) + this.mCenter.x;
        this.mBrightnessHandlerPos.y = (((float) Math.sin(d)) * this.mColorToneSeekBarRadius) + this.mCenter.y;
    }

    private final void updateHueValue(float degrees) {
        float f = degrees < 0.0f ? PopOverActivityWrapper.DEFAULT_WIDTH + degrees : degrees;
        float f4 = this.mHueExtendedAngle;
        float f5 = 285.0f - f4;
        float f6 = f4 + 45.0f;
        if (f5 > f6) {
            if (f < f5 && f > f6) {
                return;
            }
        } else if (f5 > f || f > f6) {
            return;
        }
        if (degrees < 0.0f && f < 285.0f) {
            f = 285.0f;
        } else if (degrees >= 0.0f && f > 45.0f) {
            f = 45.0f;
        }
        this.mHueWheelHandlerAngle = f;
        this.mHueColor = getHueColorAtAngle(f);
    }

    private final void updateSaturationValue(float angleDegree) {
        float f = PopOverActivityWrapper.DEFAULT_WIDTH;
        this.mHsv[1] = RangesKt.coerceIn((((angleDegree - 15.0f) + f) % f) / 60.0f, 0.0f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSaturationView(float degrees) {
        if (degrees < 0.0f) {
            degrees += PopOverActivityWrapper.DEFAULT_WIDTH;
        }
        float f = this.mColorToneExtendedAngle;
        float f4 = 15.0f - f;
        float f5 = f + SATURATION_ANGLE_END;
        if (f4 > f5) {
            if (degrees < f4 && degrees > f5) {
                return;
            }
        } else if (f4 > degrees || degrees > f5) {
            return;
        }
        float fCoerceIn = RangesKt.coerceIn(degrees, 15.0f, SATURATION_ANGLE_END);
        updateSaturationValue(fCoerceIn);
        double d = (float) ((((double) fCoerceIn) * 3.141592653589793d) / ((double) 180));
        this.mSaturationHandlerPos.x = (((float) Math.cos(d)) * this.mColorToneSeekBarRadius) + this.mCenter.x;
        this.mSaturationHandlerPos.y = (((float) Math.sin(d)) * this.mColorToneSeekBarRadius) + this.mCenter.y;
    }

    private final void updateSelectedColor() {
        float[] fArr = this.mHsv;
        float[] fArr2 = {fArr[0], fArr[1], fArr[2]};
        OnColorChangedListener onColorChangedListener = this.mOnColorChangedListener;
        if (onColorChangedListener != null) {
            onColorChangedListener.onColorChanged(fArr2);
        }
    }

    public final void close() {
        this.mOnColorChangedListener = null;
        this.mAnimationListener = null;
    }

    public final boolean getShouldShowHueWheel() {
        return this.shouldShowHueWheel;
    }

    @Override // android.view.View
    public void onDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (this.shouldShowHueWheel) {
            drawHueWheel(canvas);
            drawHueHandler(canvas);
        }
        int iSave = canvas.save();
        try {
            Path path = this.innerCirclePath;
            if (path == null) {
                Intrinsics.throwUninitializedPropertyAccessException("innerCirclePath");
                path = null;
            }
            canvas.clipOutPath(path);
            drawColorToneSeekBar(canvas);
            drawColorToneSeekBarHandler(canvas);
            canvas.restoreToCount(iSave);
        } catch (Throwable th) {
            canvas.restoreToCount(iSave);
            throw th;
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        int i = 3;
        if (action == 0) {
            if (this.shouldShowHueWheel && isColorWheelTouch(event.getX(), event.getY())) {
                i = 1;
            } else if (isSeekBarTouch(event.getX(), event.getY(), 2)) {
                i = 2;
            } else if (!isSeekBarTouch(event.getX(), event.getY(), 3)) {
                i = 0;
            }
            this.mIsAttributeTouched = i;
            if (i == 0) {
                return false;
            }
            notifyPickerPressed(i);
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 1) {
            notifyPickerReleased(this.mIsAttributeTouched);
            this.mIsAttributeTouched = 0;
            getParent().requestDisallowInterceptTouchEvent(false);
        } else if (action == 2) {
            int i2 = this.mIsAttributeTouched;
            if (i2 == 1) {
                adjustHandlerPosition(event.getX(), event.getY(), 1);
            } else if (i2 == 2) {
                adjustHandlerPosition(event.getX(), event.getY(), 2);
            } else if (i2 == 3) {
                adjustHandlerPosition(event.getX(), event.getY(), 3);
            }
            invalidate();
        }
        return true;
    }

    public final void setAnimationListener(@Nullable AnimationListener listener) {
        this.mAnimationListener = listener;
    }

    public final void setOnColorChangedListener(@NotNull OnColorChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mOnColorChangedListener = listener;
    }

    public final void setOnPickerActionListener(@Nullable OnActionListener listener) {
        this.mPickerActionListener = listener;
    }

    public final void setPositionByColor(@NotNull float[] hsvColor) {
        Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
        if (hsvColor[0] == 0.0f && this.mHsv[0] == 360.0f) {
            hsvColor[0] = 360.0f;
        }
        this.mHsv = hsvColor;
        float f = ((hsvColor[0] / 360.0f) * HUE_RANGE) + 285.0f;
        this.mHueWheelHandlerAngle = f;
        this.mHueColor = getHueColorAtAngle(f);
        float f4 = (this.mHsv[1] * 60.0f) + 15.0f;
        float f5 = PopOverActivityWrapper.DEFAULT_WIDTH;
        float f6 = f4 % f5;
        this.mSaturationHandlerAngle = f6;
        updateSaturationView(f6);
        float f7 = (BRIGHTNESS_ANGLE_END - (this.mHsv[2] * 60.0f)) % f5;
        this.mBrightnessHandlerAngle = f7;
        updateBrightnessView(f7);
        invalidate();
    }

    public final void setShouldShowHueWheel(boolean z) {
        this.shouldShowHueWheel = z;
        invalidate();
    }

    public final void startAnimation(boolean isShow) {
        startAnimationShow(isShow);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r2v19, types: [com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTColorPickerView$mSeekbarFloatProperty$1] */
    public QTColorPickerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.innerRadius = getResources().getDimension(C9086R.dimen.qt_ai_menu_radius);
        this.colors = new int[]{-65536, -256, VUtilString.GREEN, VUtilString.CYAN, -16776961, VUtilString.MAGENTA, -65536};
        this.shouldShowHueWheel = true;
        this.mBrightnessHandlerPos = new PointF();
        this.mSaturationHandlerPos = new PointF();
        this.mHsv = new float[3];
        this.mCenter = new PointF();
        this.mHueWheelTrimAnimator = new ValueAnimator();
        this.mHueWheelOpacityAnimator = new ValueAnimator();
        this.mHueHandlerScaleAnimator = new ValueAnimator();
        this.mHueHandlerBorderScaleAnimator = new ValueAnimator();
        this.mSeekbarOpacityAnimator = new ValueAnimator();
        this.mSeekbarHandlerScaleAnimator = new ValueAnimator();
        this.mSpringForce = new SpringForce();
        this.mAnimationSet = new AnimatorSet();
        this.mSeekbarFloatProperty = new FloatPropertyCompat<FloatValueHolder>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTColorPickerView$mSeekbarFloatProperty$1
            {
                super("Seekbar Radius");
            }

            @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
            public float getValue(FloatValueHolder holder) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                return holder.getValue();
            }

            @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
            public void setValue(FloatValueHolder holder, float value) {
                Intrinsics.checkNotNullParameter(holder, "holder");
                holder.setValue(value);
                this.this$0.mColorToneSeekBarRadius = value;
                QTColorPickerView qTColorPickerView = this.this$0;
                qTColorPickerView.updateSaturationView(qTColorPickerView.mSaturationHandlerAngle);
                QTColorPickerView qTColorPickerView2 = this.this$0;
                qTColorPickerView2.updateBrightnessView(qTColorPickerView2.mBrightnessHandlerAngle);
                this.this$0.invalidate();
            }
        };
        init();
    }
}
