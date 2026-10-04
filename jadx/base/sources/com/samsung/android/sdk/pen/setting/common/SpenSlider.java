package com.samsung.android.sdk.pen.setting.common;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ScaleDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.SeekBar;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.core.widget.NestedScrollView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.carousel.RunnableC4617a;
import com.google.android.material.timepicker.TimeModel;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.common.SpenSeekBarButtonControl;
import com.samsung.android.sdk.pen.setting.common.SpenSlider;
import com.samsung.android.sdk.pen.setting.common.SpenSliderThumbView;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000Ã\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001@\b\u0016\u0018\u0000 \u009c\u00012\u00020\u0001:\n\u009c\u0001\u009d\u0001\u009e\u0001\u009f\u0001 \u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u0010B)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u0011B1\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u0014BA\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u0015J\b\u0010B\u001a\u00020CH\u0014J\b\u0010D\u001a\u00020CH\u0014J\u0018\u0010E\u001a\u00020C2\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020\u0007H\u0014J\b\u0010I\u001a\u00020CH\u0016J\u0016\u0010J\u001a\u00020C2\u0006\u0010K\u001a\u00020\u00072\u0006\u0010L\u001a\u00020\u0005J\u000e\u0010M\u001a\u00020C2\u0006\u0010N\u001a\u00020\u0005J\u000e\u0010O\u001a\u00020C2\u0006\u0010P\u001a\u00020\u0005J\u000e\u0010W\u001a\u00020C2\u0006\u0010X\u001a\u00020\u0007J\u0012\u0010Y\u001a\u00020C2\n\u0010Z\u001a\u00020[\"\u00020\u0007J\u0010\u0010\\\u001a\u00020C2\b\u0010]\u001a\u0004\u0018\u00010^J\u0010\u0010_\u001a\u00020C2\u0006\u0010`\u001a\u00020!H\u0016J\u0010\u0010a\u001a\u00020C2\b\u0010b\u001a\u0004\u0018\u00010!J\u0012\u0010c\u001a\u00020C2\b\u0010d\u001a\u0004\u0018\u000107H\u0016J\u0012\u0010e\u001a\u00020C2\b\u0010d\u001a\u0004\u0018\u000109H\u0016J\u0012\u0010f\u001a\u00020C2\b\u0010d\u001a\u0004\u0018\u000109H\u0016J\u0012\u0010g\u001a\u00020C2\b\u0010d\u001a\u0004\u0018\u00010<H\u0016J\u0016\u0010j\u001a\u00020C2\u0006\u0010k\u001a\u00020\u00072\u0006\u0010l\u001a\u00020\u0007J\u0016\u0010m\u001a\u00020C2\u0006\u0010n\u001a\u00020\u00072\u0006\u0010o\u001a\u00020\u0007J\u0010\u0010p\u001a\u00020C2\b\u0010d\u001a\u0004\u0018\u00010qJ\u0006\u0010r\u001a\u00020CJ\u000e\u0010s\u001a\u00020C2\u0006\u0010t\u001a\u00020uJ(\u0010v\u001a\u00020C2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010w\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0018\u0010x\u001a\u00020C2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010y\u001a\u00020\u0005H\u0002J\u0010\u0010z\u001a\u00020C2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0018\u0010{\u001a\u00020C2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J\u0010\u0010|\u001a\u00020C2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0012\u0010}\u001a\u00020C2\b\u0010d\u001a\u0004\u0018\u000109H\u0002J\u001a\u0010~\u001a\u00020C2\b\u0010d\u001a\u0004\u0018\u0001092\u0006\u0010\u007f\u001a\u00020\u0005H\u0002J\u001b\u0010\u0080\u0001\u001a\u00020C2\u0007\u0010\u0081\u0001\u001a\u00020\u00072\u0007\u0010\u0082\u0001\u001a\u00020\u0007H\u0002J\t\u0010\u0083\u0001\u001a\u00020CH\u0002J\u001a\u0010\u0084\u0001\u001a\u00020C2\u0006\u0010K\u001a\u00020\u00072\u0007\u0010\u0085\u0001\u001a\u00020\u0005H\u0002J\u001a\u0010\u0086\u0001\u001a\u00020C2\u0006\u0010K\u001a\u00020\u00072\u0007\u0010\u0087\u0001\u001a\u00020\u0005H\u0002J\t\u0010\u0088\u0001\u001a\u00020CH\u0002J\u0011\u0010\u0089\u0001\u001a\u00020\u00072\u0006\u0010K\u001a\u00020\u0007H\u0002J\u0012\u0010\u008a\u0001\u001a\u00020\u00072\u0007\u0010\u008b\u0001\u001a\u00020\u0007H\u0002J\t\u0010\u008c\u0001\u001a\u00020CH\u0002J\t\u0010\u008d\u0001\u001a\u00020CH\u0002J\t\u0010\u008e\u0001\u001a\u00020CH\u0002J\t\u0010\u008f\u0001\u001a\u00020CH\u0002J\t\u0010\u0090\u0001\u001a\u00020CH\u0002J\t\u0010\u0092\u0001\u001a\u00020CH\u0002J\t\u0010\u0093\u0001\u001a\u00020CH\u0002J\t\u0010\u0094\u0001\u001a\u00020CH\u0002J\u0013\u0010\u0095\u0001\u001a\u00020C2\b\u0010\u0096\u0001\u001a\u00030\u0097\u0001H\u0002J\u0017\u0010\u0098\u0001\u001a\u0005\u0018\u00010\u0099\u00012\t\u0010\u009a\u0001\u001a\u0004\u0018\u00010GH\u0002J\u0017\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u0099\u00012\t\u0010\u009a\u0001\u001a\u0004\u0018\u00010GH\u0002R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u0004\u0018\u000109X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010<X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u00020@X\u0082\u0004¢\u0006\u0004\n\u0002\u0010AR\u0014\u0010K\u001a\u00020\u00078DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010RR$\u0010S\u001a\u00020\u00072\u0006\u0010S\u001a\u00020\u00078F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bT\u0010R\"\u0004\bU\u0010VR\u0011\u0010h\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\bh\u0010iR\u0016\u0010\u0091\u0001\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u0091\u0001\u0010i¨\u0006¡\u0001"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/common/SpenSlider;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "hasOutline", "", "layoutId", "", "mMin", "mMax", "minStringID", "maxStringID", "sliderType", "Lcom/samsung/android/sdk/pen/setting/common/SpenSlider$SliderType;", "<init>", "(Landroid/content/Context;ZIIIIILcom/samsung/android/sdk/pen/setting/common/SpenSlider$SliderType;)V", "(Landroid/content/Context;ZLcom/samsung/android/sdk/pen/setting/common/SpenSlider$SliderType;)V", "(Landroid/content/Context;ZILcom/samsung/android/sdk/pen/setting/common/SpenSlider$SliderType;)V", VElementFormulasCmd.FMIN, VElementFormulasCmd.FMAX, "(Landroid/content/Context;ZIILcom/samsung/android/sdk/pen/setting/common/SpenSlider$SliderType;)V", "(Landroid/content/Context;ZIIIILcom/samsung/android/sdk/pen/setting/common/SpenSlider$SliderType;)V", "mTrackMinHeight", "mTrackMaxHeight", "mTrackDefaultHeight", "mFactor", "mIsTracking", "mIsTrackingThumb", "mEnableSliderAnimation", "mCurrentValue", "mColor", "mHasOutline", "mLabelFormat", "", "mPostfixString", "mPostfixButtonClickString", "mSeekBar", "Landroid/widget/SeekBar;", "mSeekBarColorControl", "Lcom/samsung/android/sdk/pen/setting/common/SpenSeekBarColorControl;", "mSeekBarButtonControl", "Lcom/samsung/android/sdk/pen/setting/common/SpenSeekBarButtonControl;", "mSliderThumbView", "Lcom/samsung/android/sdk/pen/setting/common/SpenSliderThumbView;", "mSeekBarAnimation", "Lcom/samsung/android/sdk/pen/setting/common/SpenSeekBarAnimation;", "mSliderAnimation", "Lcom/samsung/android/sdk/pen/setting/common/SpenSliderAnimation;", "mProgressAnimation", "Lcom/samsung/android/sdk/pen/setting/common/SpenSeekBarProgressAnimation;", "mSliderTransition", "Lcom/samsung/android/sdk/pen/setting/common/SpenSliderTransitionAnimator;", "mThumbScaleAnimation", "Lcom/samsung/android/sdk/pen/setting/common/SpenSliderThumbScaleAnimation;", "mChangedListener", "Lcom/samsung/android/sdk/pen/setting/common/SpenSlider$OnChangedListener;", "mMinusButtonListener", "Lcom/samsung/android/sdk/pen/setting/common/SpenSlider$OnSliderButtonListener;", "mPlusButtonListener", "mTrackListener", "Lcom/samsung/android/sdk/pen/setting/common/SpenSlider$OnSliderTrackListener;", "mSliderThumbChangeListener", "Lcom/samsung/android/sdk/pen/setting/common/SpenSliderThumbView$OnSliderThumbChangeListener;", "mOnTouchListener", "com/samsung/android/sdk/pen/setting/common/SpenSlider$mOnTouchListener$1", "Lcom/samsung/android/sdk/pen/setting/common/SpenSlider$mOnTouchListener$1;", "onAttachedToWindow", "", "onDetachedFromWindow", "onVisibilityChanged", "changedView", "Landroid/view/View;", "visibility", "close", "setValue", "value", "needAnimation", "setThumbAnimationEnable", "enable", "setThumbScaleAnimation", "isScaleDown", "getValue", "()I", "color", "getColor", "setColor", "(I)V", "setTrackMinHeight", "minHeight", "setProgressBackgroundColors", "colors", "", "setProgressBackgroundDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "setLabelFormat", "format", "setAccessibilityPostfix", "postfix", "setOnChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnPlusButtonActionListener", "setOnMinusButtonActionListener", "setOnTrackListener", "isRunningShowHideAnimation", "()Z", "setAnimationValue", "startHeight", "endHeight", "startShowAnimation", "startThumbColor", "endThumbColor", "setHideAnimationListener", "Landroid/animation/Animator$AnimatorListener;", "startHideAnimation", "setRotateDegree", "degree", "", "initView", "inflateResource", "initBackgroundSeekBar", "isBrushSlider", "initSeekBar", "initControlButton", "initSliderThumbView", "notifyButtonClicked", "notifyButtonLongClick", "start", "notifyHapticFeedback", "oldValue", "newValue", "updateColor", "notifyValueChangedListener", "fromUser", "updateContentDescription", "isButtonEvent", "updateThumbViewPosition", "calculateProgress", "calculateValue", "progress", "setSliderAnimation", "closeSliderAnimation", "setSeekBarAnimation", "closeSeekBarAnimation", "setProgressAnimation", "isRunningProgressAnimation", "closeProgressAnimation", "setTransitionAnimator", "closeTransitionAnimator", "requestInterceptTouchEvent", "event", "Landroid/view/MotionEvent;", "findHorizontalScrollParent", "Landroid/view/ViewParent;", "view", "findScrollParent", "Companion", "OnChangedListener", "OnSliderButtonListener", "OnSliderTrackListener", "SliderType", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public class SpenSlider extends FrameLayout {
    public static final int DEFAULT_MAX_VALUE = 100;
    public static final int DEFAULT_MIN_VALUE = 1;
    public static final int HAPTIC_INDEX_EFFECT_TICK = 41;

    @NotNull
    private static final String TAG = "SpenSlider";
    public static final int VALUE_FACTOR_DEFAULT_PROGRESS = 1;
    public static final int VALUE_FACTOR_EXPAND_PROGRESS = 10;
    public static final int VALUE_SUPPORT_EXPAND_PROGRESS = 20;

    @Nullable
    private OnChangedListener mChangedListener;
    private int mColor;
    private int mCurrentValue;
    private boolean mEnableSliderAnimation;
    private int mFactor;
    private final boolean mHasOutline;
    private boolean mIsTracking;
    private boolean mIsTrackingThumb;
    private String mLabelFormat;
    private final int mMax;
    private final int mMin;

    @Nullable
    private OnSliderButtonListener mMinusButtonListener;

    @NotNull
    private final SpenSlider$mOnTouchListener$1 mOnTouchListener;

    @Nullable
    private OnSliderButtonListener mPlusButtonListener;
    private String mPostfixButtonClickString;
    private String mPostfixString;

    @Nullable
    private SpenSeekBarProgressAnimation mProgressAnimation;
    private SeekBar mSeekBar;

    @Nullable
    private SpenSeekBarAnimation mSeekBarAnimation;
    private SpenSeekBarButtonControl mSeekBarButtonControl;
    private SpenSeekBarColorControl mSeekBarColorControl;

    @Nullable
    private SpenSliderAnimation mSliderAnimation;

    @NotNull
    private final SpenSliderThumbView.OnSliderThumbChangeListener mSliderThumbChangeListener;
    private SpenSliderThumbView mSliderThumbView;

    @Nullable
    private SpenSliderTransitionAnimator mSliderTransition;

    @Nullable
    private SpenSliderThumbScaleAnimation mThumbScaleAnimation;
    private int mTrackDefaultHeight;

    @Nullable
    private OnSliderTrackListener mTrackListener;
    private int mTrackMaxHeight;
    private int mTrackMinHeight;

    @NotNull
    private final SliderType sliderType;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/common/SpenSlider$OnChangedListener;", "", "onChanged", "", "value", "", "fromUser", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnChangedListener {
        void onChanged(int value, boolean fromUser);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/common/SpenSlider$OnSliderButtonListener;", "", "onButtonClick", "", "onStartButtonLongClick", "onStopButtonLongClick", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnSliderButtonListener {
        void onButtonClick();

        void onStartButtonLongClick();

        void onStopButtonLongClick();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/common/SpenSlider$OnSliderTrackListener;", "", "onStartTrackingTouch", "", "onStopTrackingTouch", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnSliderTrackListener {
        void onStartTrackingTouch();

        void onStopTrackingTouch();
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/common/SpenSlider$SliderType;", "", "<init>", "(Ljava/lang/String;I)V", "DISCRETE", "CONTINUOUS", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class SliderType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ SliderType[] $VALUES;
        public static final SliderType DISCRETE = new SliderType("DISCRETE", 0);
        public static final SliderType CONTINUOUS = new SliderType("CONTINUOUS", 1);

        private static final /* synthetic */ SliderType[] $values() {
            return new SliderType[]{DISCRETE, CONTINUOUS};
        }

        static {
            SliderType[] sliderTypeArr$values = $values();
            $VALUES = sliderTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(sliderTypeArr$values);
        }

        private SliderType(String str, int i) {
        }

        @NotNull
        public static EnumEntries<SliderType> getEntries() {
            return $ENTRIES;
        }

        public static SliderType valueOf(String str) {
            return (SliderType) Enum.valueOf(SliderType.class, str);
        }

        public static SliderType[] values() {
            return (SliderType[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SliderType.values().length];
            try {
                iArr[SliderType.DISCRETE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SliderType.CONTINUOUS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r5v3, types: [com.samsung.android.sdk.pen.setting.common.SpenSlider$mOnTouchListener$1] */
    public SpenSlider(@NotNull Context context, boolean z, int i, int i2, int i4, int i5, int i6, @NotNull SliderType sliderType) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sliderType, "sliderType");
        this.mMin = i2;
        this.mMax = i4;
        this.mFactor = 1;
        this.mSliderThumbChangeListener = new SpenSliderThumbView.OnSliderThumbChangeListener() { // from class: com.samsung.android.sdk.pen.setting.common.SpenSlider$mSliderThumbChangeListener$1
            @Override // com.samsung.android.sdk.pen.setting.common.SpenSliderThumbView.OnSliderThumbChangeListener
            public void OnProgressChange(int progress) {
                SeekBar seekBar = this.this$0.mSeekBar;
                SeekBar seekBar2 = null;
                if (seekBar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
                    seekBar = null;
                }
                AbstractC6670b.m4744e(progress, seekBar.getProgress(), "OnProgressChange progress =", " mSeekBarProgress= ", "SpenSlider");
                SeekBar seekBar3 = this.this$0.mSeekBar;
                if (seekBar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
                    seekBar3 = null;
                }
                if (progress == seekBar3.getProgress()) {
                    return;
                }
                int iRoundToInt = this.this$0.mFactor * MathKt.roundToInt(progress / (this.this$0.mFactor * 1.0f));
                SeekBar seekBar4 = this.this$0.mSeekBar;
                if (seekBar4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
                } else {
                    seekBar2 = seekBar4;
                }
                seekBar2.setProgress(iRoundToInt);
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenSliderThumbView.OnSliderThumbChangeListener
            public void onStartTrackingTouch() {
                this.this$0.mIsTrackingThumb = true;
                SpenSlider.OnSliderTrackListener onSliderTrackListener = this.this$0.mTrackListener;
                if (onSliderTrackListener != null) {
                    onSliderTrackListener.onStartTrackingTouch();
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenSliderThumbView.OnSliderThumbChangeListener
            public void onStopTrackingTouch() {
                this.this$0.mIsTrackingThumb = false;
                SpenSlider.OnSliderTrackListener onSliderTrackListener = this.this$0.mTrackListener;
                if (onSliderTrackListener != null) {
                    onSliderTrackListener.onStopTrackingTouch();
                }
                SpenSlider spenSlider = this.this$0;
                spenSlider.updateContentDescription(spenSlider.mCurrentValue, false);
            }
        };
        this.mOnTouchListener = new View.OnTouchListener() { // from class: com.samsung.android.sdk.pen.setting.common.SpenSlider$mOnTouchListener$1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View v, MotionEvent event) {
                if (v != null && event != null) {
                    if (this.this$0.mEnableSliderAnimation) {
                        SpenSliderAnimation spenSliderAnimation = this.this$0.mSliderAnimation;
                        if (spenSliderAnimation != null) {
                            spenSliderAnimation.setOnTouchEvent(event);
                        }
                    } else {
                        SpenSeekBarAnimation spenSeekBarAnimation = this.this$0.mSeekBarAnimation;
                        if (spenSeekBarAnimation != null) {
                            spenSeekBarAnimation.setOnTouchEvent(event);
                        }
                    }
                    SpenSeekBarProgressAnimation spenSeekBarProgressAnimation = this.this$0.mProgressAnimation;
                    if (spenSeekBarProgressAnimation != null) {
                        spenSeekBarProgressAnimation.setOnTouchEvent(event);
                    }
                    this.this$0.requestInterceptTouchEvent(event);
                    if (event.getAction() == 0) {
                        return true;
                    }
                }
                return false;
            }
        };
        if (i4 <= 20) {
            this.mFactor = 10;
        }
        this.mHasOutline = z;
        this.sliderType = sliderType;
        this.mColor = 0;
        initView(context, i, i5, i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int calculateProgress(int value) {
        return (value - this.mMin) * this.mFactor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int calculateValue(int progress) {
        return (progress / this.mFactor) + this.mMin;
    }

    private final void closeProgressAnimation() {
        SpenSeekBarProgressAnimation spenSeekBarProgressAnimation = this.mProgressAnimation;
        if (spenSeekBarProgressAnimation != null) {
            spenSeekBarProgressAnimation.close();
        }
        this.mProgressAnimation = null;
    }

    private final void closeSeekBarAnimation() {
        SpenSeekBarAnimation spenSeekBarAnimation = this.mSeekBarAnimation;
        if (spenSeekBarAnimation != null) {
            spenSeekBarAnimation.close();
        }
        this.mSeekBarAnimation = null;
    }

    private final void closeSliderAnimation() {
        SpenSliderAnimation spenSliderAnimation = this.mSliderAnimation;
        if (spenSliderAnimation != null) {
            spenSliderAnimation.close();
        }
        this.mSliderAnimation = null;
    }

    private final void closeTransitionAnimator() {
        SpenSliderTransitionAnimator spenSliderTransitionAnimator = this.mSliderTransition;
        if (spenSliderTransitionAnimator != null) {
            spenSliderTransitionAnimator.close();
        }
        this.mSliderTransition = null;
    }

    private final ViewParent findHorizontalScrollParent(View view) {
        if (view == null) {
            return null;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof HorizontalScrollView) {
                return parent;
            }
        }
        return null;
    }

    private final ViewParent findScrollParent(View view) {
        if (view == null) {
            return null;
        }
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof NestedScrollView) {
                return parent;
            }
        }
        return null;
    }

    private final void initBackgroundSeekBar(Context context, boolean isBrushSlider) {
        Drawable drawable;
        SeekBar seekBar;
        SpenSliderThumbView spenSliderThumbView;
        SpenSeekBarColorControl spenSeekBarColorControl = null;
        if (this.sliderType == SliderType.DISCRETE) {
            SeekBar seekBar2 = this.mSeekBar;
            if (seekBar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
                seekBar2 = null;
            }
            drawable = new SpenSliderThumbDrawable(context, 0, seekBar2.getMax());
        } else {
            drawable = isBrushSlider ? getResources().getDrawable(C7932R.drawable.brush_slider_opacity_bg_drawable, context.getTheme()) : getResources().getDrawable(C7932R.drawable.sliider_opacity_bg_drawable, context.getTheme());
            Intrinsics.checkNotNull(drawable);
        }
        SeekBar seekBar3 = this.mSeekBar;
        if (seekBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
            seekBar3 = null;
        }
        seekBar3.setBackground(drawable);
        SpenSeekBarColorControl spenSeekBarColorControl2 = new SpenSeekBarColorControl();
        this.mSeekBarColorControl = spenSeekBarColorControl2;
        SeekBar seekBar4 = this.mSeekBar;
        if (seekBar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
            seekBar = null;
        } else {
            seekBar = seekBar4;
        }
        SpenSliderThumbView spenSliderThumbView2 = this.mSliderThumbView;
        if (spenSliderThumbView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSliderThumbView");
            spenSliderThumbView = null;
        } else {
            spenSliderThumbView = spenSliderThumbView2;
        }
        spenSeekBarColorControl2.initSeekBar(seekBar, spenSliderThumbView, context, this.mHasOutline, null);
        SpenSeekBarColorControl spenSeekBarColorControl3 = this.mSeekBarColorControl;
        if (spenSeekBarColorControl3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBarColorControl");
        } else {
            spenSeekBarColorControl = spenSeekBarColorControl3;
        }
        spenSeekBarColorControl.setSliderType(this.sliderType);
    }

    private final void initControlButton(int minStringID, int maxStringID) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        SpenSeekBarButtonControl spenSeekBarButtonControl = new SpenSeekBarButtonControl(context);
        this.mSeekBarButtonControl = spenSeekBarButtonControl;
        SeekBar seekBar = this.mSeekBar;
        SpenSeekBarButtonControl spenSeekBarButtonControl2 = null;
        if (seekBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
            seekBar = null;
        }
        View viewFindViewById = findViewById(C7932R.id.seek_bar_minus_button);
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.ImageButton");
        View viewFindViewById2 = findViewById(C7932R.id.seek_bar_plus_button);
        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.ImageButton");
        spenSeekBarButtonControl.initControlButton(seekBar, (ImageButton) viewFindViewById, minStringID, (ImageButton) viewFindViewById2, maxStringID);
        SpenSeekBarButtonControl spenSeekBarButtonControl3 = this.mSeekBarButtonControl;
        if (spenSeekBarButtonControl3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBarButtonControl");
            spenSeekBarButtonControl3 = null;
        }
        spenSeekBarButtonControl3.setFactorValue(this.mFactor);
        SpenSeekBarButtonControl spenSeekBarButtonControl4 = this.mSeekBarButtonControl;
        if (spenSeekBarButtonControl4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBarButtonControl");
        } else {
            spenSeekBarButtonControl2 = spenSeekBarButtonControl4;
        }
        spenSeekBarButtonControl2.setActionListener(new SpenSeekBarButtonControl.OnActionListener() { // from class: com.samsung.android.sdk.pen.setting.common.SpenSlider.initControlButton.1
            @Override // com.samsung.android.sdk.pen.setting.common.SpenSeekBarButtonControl.OnActionListener
            public void onSizeButtonClicked(SpenSeekBarButtonControl.ButtonType type) {
                Intrinsics.checkNotNullParameter(type, "type");
                Log.i(SpenSlider.TAG, "onSizeButtonPressed() type=" + type);
                SpenSlider spenSlider = SpenSlider.this;
                spenSlider.notifyButtonClicked(type == SpenSeekBarButtonControl.ButtonType.MINUS ? spenSlider.mMinusButtonListener : spenSlider.mPlusButtonListener);
                SpenSlider spenSlider2 = SpenSlider.this;
                spenSlider2.updateContentDescription(spenSlider2.mCurrentValue, true);
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenSeekBarButtonControl.OnActionListener
            public void onStartSizeButtonLongClick(SpenSeekBarButtonControl.ButtonType type) {
                Intrinsics.checkNotNullParameter(type, "type");
                Log.i(SpenSlider.TAG, "onStartSizeButtonLongClick() type=" + type);
                SpenSlider spenSlider = SpenSlider.this;
                spenSlider.notifyButtonLongClick(type == SpenSeekBarButtonControl.ButtonType.MINUS ? spenSlider.mMinusButtonListener : spenSlider.mPlusButtonListener, true);
            }

            @Override // com.samsung.android.sdk.pen.setting.common.SpenSeekBarButtonControl.OnActionListener
            public void onStopSizeButtonLongClick(SpenSeekBarButtonControl.ButtonType type) {
                Intrinsics.checkNotNullParameter(type, "type");
                Log.i(SpenSlider.TAG, "onStopSizeButtonLongClick() type=" + type);
                SpenSlider spenSlider = SpenSlider.this;
                spenSlider.notifyButtonLongClick(type == SpenSeekBarButtonControl.ButtonType.MINUS ? spenSlider.mMinusButtonListener : spenSlider.mPlusButtonListener, false);
                SpenSlider spenSlider2 = SpenSlider.this;
                spenSlider2.updateContentDescription(spenSlider2.mCurrentValue, true);
            }
        });
    }

    private final void initSeekBar(Context context) {
        this.mSeekBar = (SeekBar) findViewById(C7932R.id.seek_bar);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(C7932R.dimen.floating_thumb_height);
        SeekBar seekBar = this.mSeekBar;
        SeekBar seekBar2 = null;
        if (seekBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
            seekBar = null;
        }
        int i = dimensionPixelSize / 2;
        seekBar.setPadding(i, 0, i, 0);
        SeekBar seekBar3 = this.mSeekBar;
        if (seekBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
            seekBar3 = null;
        }
        seekBar3.setImportantForAccessibility(2);
        SeekBar seekBar4 = this.mSeekBar;
        if (seekBar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
            seekBar4 = null;
        }
        seekBar4.setMax(calculateProgress(this.mMax));
        SeekBar seekBar5 = this.mSeekBar;
        if (seekBar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
            seekBar5 = null;
        }
        seekBar5.setOnTouchListener(this.mOnTouchListener);
        SeekBar seekBar6 = this.mSeekBar;
        if (seekBar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
        } else {
            seekBar2 = seekBar6;
        }
        seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.samsung.android.sdk.pen.setting.common.SpenSlider.initSeekBar.1
            /* JADX WARN: Removed duplicated region for block: B:20:0x007b  */
            /* JADX WARN: Removed duplicated region for block: B:23:0x008a  */
            /* JADX WARN: Removed duplicated region for block: B:38:0x00d8  */
            /* JADX WARN: Removed duplicated region for block: B:41:0x00e3  */
            /* JADX WARN: Removed duplicated region for block: B:44:0x00f0  */
            /* JADX WARN: Removed duplicated region for block: B:45:0x00f6  */
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void onProgressChanged(SeekBar seekBar7, int progress, boolean fromUser) {
                SpenSeekBarButtonControl spenSeekBarButtonControl;
                SpenSeekBarProgressAnimation spenSeekBarProgressAnimation;
                SpenSliderThumbView spenSliderThumbView;
                SeekBar seekBar8;
                Intrinsics.checkNotNullParameter(seekBar7, "seekBar");
                StringBuilder sb = new StringBuilder("OnProgressChanged() progress=");
                sb.append(progress);
                sb.append(" fromUser=");
                AbstractC11014a.m12339x(sb, " ", SpenSlider.TAG, fromUser);
                int iRoundToInt = SpenSlider.this.mFactor * MathKt.roundToInt(progress / (SpenSlider.this.mFactor * 1.0f));
                int iCalculateValue = SpenSlider.this.calculateValue(iRoundToInt);
                SpenSeekBarButtonControl spenSeekBarButtonControl2 = SpenSlider.this.mSeekBarButtonControl;
                SpenSliderThumbView spenSliderThumbView2 = null;
                if (spenSeekBarButtonControl2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSeekBarButtonControl");
                    spenSeekBarButtonControl2 = null;
                }
                boolean zIsUserEvent = spenSeekBarButtonControl2.isUserEvent();
                boolean target = false;
                if (!zIsUserEvent) {
                    SpenSeekBarButtonControl spenSeekBarButtonControl3 = SpenSlider.this.mSeekBarButtonControl;
                    if (spenSeekBarButtonControl3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSeekBarButtonControl");
                        spenSeekBarButtonControl3 = null;
                    }
                    if (spenSeekBarButtonControl3.isAutoChanged()) {
                    }
                    spenSeekBarButtonControl = SpenSlider.this.mSeekBarButtonControl;
                    if (spenSeekBarButtonControl == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSeekBarButtonControl");
                        spenSeekBarButtonControl = null;
                    }
                    spenSeekBarButtonControl.updateButtonState();
                    spenSeekBarProgressAnimation = SpenSlider.this.mProgressAnimation;
                    if (spenSeekBarProgressAnimation != null) {
                        SpenSlider spenSlider = SpenSlider.this;
                        if (zIsUserEvent) {
                            spenSeekBarProgressAnimation.setStartProgress(spenSlider.calculateProgress(spenSlider.mCurrentValue));
                        }
                        target = spenSeekBarProgressAnimation.setTarget(fromUser, spenSlider.mIsTracking, zIsUserEvent, iRoundToInt);
                    }
                    if ((fromUser || SpenSlider.this.mIsTrackingThumb) && SpenSlider.this.mCurrentValue != iCalculateValue) {
                        SpenSlider.this.notifyValueChangedListener(iCalculateValue, true);
                        SpenSlider spenSlider2 = SpenSlider.this;
                        spenSlider2.notifyHapticFeedback(spenSlider2.mCurrentValue, iCalculateValue);
                        SpenSlider.this.mCurrentValue = iCalculateValue;
                    }
                    if (progress != iRoundToInt && !SpenSlider.this.isRunningProgressAnimation()) {
                        seekBar8 = SpenSlider.this.mSeekBar;
                        if (seekBar8 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
                            seekBar8 = null;
                        }
                        seekBar8.setProgress(iRoundToInt);
                    }
                    if (!target) {
                        SpenSlider.this.updateThumbViewPosition();
                    }
                    spenSliderThumbView = SpenSlider.this.mSliderThumbView;
                    if (spenSliderThumbView != null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mSliderThumbView");
                    } else {
                        spenSliderThumbView2 = spenSliderThumbView;
                    }
                    spenSliderThumbView2.updateProgressValue(SpenSlider.this.mCurrentValue);
                }
                SpenSeekBarButtonControl spenSeekBarButtonControl4 = SpenSlider.this.mSeekBarButtonControl;
                if (spenSeekBarButtonControl4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSeekBarButtonControl");
                    spenSeekBarButtonControl4 = null;
                }
                spenSeekBarButtonControl4.setUserEvent(false);
                fromUser = true;
                spenSeekBarButtonControl = SpenSlider.this.mSeekBarButtonControl;
                if (spenSeekBarButtonControl == null) {
                }
                spenSeekBarButtonControl.updateButtonState();
                spenSeekBarProgressAnimation = SpenSlider.this.mProgressAnimation;
                if (spenSeekBarProgressAnimation != null) {
                }
                if (fromUser) {
                    SpenSlider.this.notifyValueChangedListener(iCalculateValue, true);
                    SpenSlider spenSlider22 = SpenSlider.this;
                    spenSlider22.notifyHapticFeedback(spenSlider22.mCurrentValue, iCalculateValue);
                    SpenSlider.this.mCurrentValue = iCalculateValue;
                } else {
                    SpenSlider.this.notifyValueChangedListener(iCalculateValue, true);
                    SpenSlider spenSlider222 = SpenSlider.this;
                    spenSlider222.notifyHapticFeedback(spenSlider222.mCurrentValue, iCalculateValue);
                    SpenSlider.this.mCurrentValue = iCalculateValue;
                }
                if (progress != iRoundToInt) {
                    seekBar8 = SpenSlider.this.mSeekBar;
                    if (seekBar8 == null) {
                    }
                    seekBar8.setProgress(iRoundToInt);
                }
                if (!target) {
                }
                spenSliderThumbView = SpenSlider.this.mSliderThumbView;
                if (spenSliderThumbView != null) {
                }
                spenSliderThumbView2.updateProgressValue(SpenSlider.this.mCurrentValue);
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar7) {
                Intrinsics.checkNotNullParameter(seekBar7, "seekBar");
                Log.i(SpenSlider.TAG, "onStartTrackTouch()");
                OnSliderTrackListener onSliderTrackListener = SpenSlider.this.mTrackListener;
                if (onSliderTrackListener != null) {
                    onSliderTrackListener.onStartTrackingTouch();
                }
                SpenSlider.this.mIsTracking = true;
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar7) {
                Intrinsics.checkNotNullParameter(seekBar7, "seekBar");
                Log.i(SpenSlider.TAG, "onStopTrackingTouch()");
                OnSliderTrackListener onSliderTrackListener = SpenSlider.this.mTrackListener;
                if (onSliderTrackListener != null) {
                    onSliderTrackListener.onStopTrackingTouch();
                }
                SpenSlider.this.mIsTracking = false;
                SpenSlider spenSlider = SpenSlider.this;
                spenSlider.updateContentDescription(spenSlider.mCurrentValue, false);
            }
        });
    }

    private final void initSliderThumbView(Context context) {
        SpenSliderThumbView spenSliderThumbView = (SpenSliderThumbView) findViewById(C7932R.id.slider_thumb);
        this.mSliderThumbView = spenSliderThumbView;
        SpenSliderThumbView spenSliderThumbView2 = null;
        if (spenSliderThumbView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSliderThumbView");
            spenSliderThumbView = null;
        }
        SeekBar seekBar = this.mSeekBar;
        if (seekBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
            seekBar = null;
        }
        spenSliderThumbView.init(context, seekBar, this.sliderType);
        SpenSliderThumbView spenSliderThumbView3 = this.mSliderThumbView;
        if (spenSliderThumbView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSliderThumbView");
        } else {
            spenSliderThumbView2 = spenSliderThumbView3;
        }
        spenSliderThumbView2.setSliderThumbChangeListener(this.mSliderThumbChangeListener);
    }

    private final void initView(Context context, int inflateResource, int minStringID, int maxStringID) {
        Object systemService = context.getSystemService("layout_inflater");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        ((LayoutInflater) systemService).inflate(inflateResource, (ViewGroup) this, true);
        this.mEnableSliderAnimation = false;
        this.mLabelFormat = TimeModel.NUMBER_FORMAT;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        this.mPostfixString = AbstractC2322a.m1624n(", %s", new Object[]{context.getResources().getString(C7932R.string.pen_string_slider)}, 1, "format(format, *args)");
        this.mPostfixButtonClickString = "";
        Resources resources = getContext().getResources();
        this.mTrackDefaultHeight = resources.getDimensionPixelSize(C7932R.dimen.setting_slider_track_default_height);
        this.mTrackMinHeight = resources.getDimensionPixelSize(C7932R.dimen.setting_slider_track_min_height);
        this.mTrackMaxHeight = resources.getDimensionPixelSize(C7932R.dimen.setting_slider_track_max_height);
        initSeekBar(context);
        initControlButton(minStringID, maxStringID);
        initSliderThumbView(context);
        initBackgroundSeekBar(context, inflateResource == C7932R.layout.setting_brush_slider_layout);
        SeekBar seekBar = this.mSeekBar;
        if (seekBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
            seekBar = null;
        }
        this.mCurrentValue = calculateValue(seekBar.getProgress());
        setSliderAnimation();
        if (!this.mEnableSliderAnimation) {
            setSeekBarAnimation();
        }
        setProgressAnimation();
        setTransitionAnimator();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isRunningProgressAnimation() {
        SpenSeekBarProgressAnimation spenSeekBarProgressAnimation = this.mProgressAnimation;
        return spenSeekBarProgressAnimation != null && spenSeekBarProgressAnimation.isAnimationRunning();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyButtonClicked(OnSliderButtonListener listener) {
        if (listener != null) {
            listener.onButtonClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyButtonLongClick(OnSliderButtonListener listener, boolean start) {
        if (listener == null) {
            return;
        }
        if (start) {
            listener.onStartButtonLongClick();
        } else {
            listener.onStopButtonLongClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyHapticFeedback(int oldValue, int newValue) {
        int i = WhenMappings.$EnumSwitchMapping$0[this.sliderType.ordinal()];
        if (i == 1) {
            int i2 = this.mFactor;
            if (i2 == 1) {
                int i4 = newValue < oldValue ? -1 : 0;
                int i5 = (newValue + i4) / 10;
                int i6 = (oldValue + i4) / 10;
                if (newValue != this.mMin && i5 == i6) {
                    return;
                }
            } else if (i2 != 10) {
                return;
            }
        } else {
            if (i != 2) {
                throw new NoWhenBranchMatchedException();
            }
            if (getValue() != this.mMin && getValue() != this.mMax) {
                return;
            }
        }
        View rootView = getRootView();
        Intrinsics.checkNotNullExpressionValue(rootView, "getRootView(...)");
        SpenSettingUtil.performHapticFeedback(rootView, 41);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void notifyValueChangedListener(int value, boolean fromUser) {
        OnChangedListener onChangedListener = this.mChangedListener;
        if (onChangedListener != null) {
            onChangedListener.onChanged(value, fromUser);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestInterceptTouchEvent(MotionEvent event) {
        SeekBar seekBar = this.mSeekBar;
        if (seekBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
            seekBar = null;
        }
        ViewParent viewParentFindHorizontalScrollParent = findHorizontalScrollParent(seekBar);
        if (viewParentFindHorizontalScrollParent == null) {
            return;
        }
        int action = event.getAction();
        if (action == 0) {
            viewParentFindHorizontalScrollParent.requestDisallowInterceptTouchEvent(true);
        } else if (action == 1 || action == 3) {
            viewParentFindHorizontalScrollParent.requestDisallowInterceptTouchEvent(false);
        }
    }

    private final void setProgressAnimation() {
        if (this.mProgressAnimation == null) {
            SeekBar seekBar = this.mSeekBar;
            SpenSliderThumbView spenSliderThumbView = null;
            if (seekBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
                seekBar = null;
            }
            SpenSliderThumbView spenSliderThumbView2 = this.mSliderThumbView;
            if (spenSliderThumbView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSliderThumbView");
            } else {
                spenSliderThumbView = spenSliderThumbView2;
            }
            this.mProgressAnimation = new SpenSeekBarProgressAnimation(seekBar, spenSliderThumbView.getLabelTextView());
        }
    }

    private final void setSeekBarAnimation() {
        if (this.mSeekBarAnimation == null) {
            this.mSeekBarAnimation = new SpenSeekBarAnimation();
        }
        SpenSeekBarAnimation spenSeekBarAnimation = this.mSeekBarAnimation;
        if (spenSeekBarAnimation != null) {
            SeekBar seekBar = this.mSeekBar;
            SpenSeekBarColorControl spenSeekBarColorControl = null;
            if (seekBar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
                seekBar = null;
            }
            SpenSeekBarColorControl spenSeekBarColorControl2 = this.mSeekBarColorControl;
            if (spenSeekBarColorControl2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSeekBarColorControl");
                spenSeekBarColorControl2 = null;
            }
            ScaleDrawable thumbDrawable = spenSeekBarColorControl2.getThumbDrawable();
            SpenSeekBarColorControl spenSeekBarColorControl3 = this.mSeekBarColorControl;
            if (spenSeekBarColorControl3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSeekBarColorControl");
            } else {
                spenSeekBarColorControl = spenSeekBarColorControl3;
            }
            spenSeekBarAnimation.setTarget(seekBar, thumbDrawable, spenSeekBarColorControl.getThumbStrokeDrawable());
        }
    }

    private final void setSliderAnimation() {
        if (this.mSliderAnimation == null) {
            this.mSliderAnimation = new SpenSliderAnimation();
        }
        SpenSliderAnimation spenSliderAnimation = this.mSliderAnimation;
        if (spenSliderAnimation != null) {
            int i = this.mTrackDefaultHeight;
            int i2 = this.mTrackMinHeight;
            int i4 = this.mTrackMaxHeight;
            SpenSeekBarColorControl spenSeekBarColorControl = this.mSeekBarColorControl;
            SeekBar seekBar = null;
            if (spenSeekBarColorControl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSeekBarColorControl");
                spenSeekBarColorControl = null;
            }
            spenSliderAnimation.setProgressInformation(i, i2, i4, spenSeekBarColorControl.getProgressDrawables());
            SpenSeekBarColorControl spenSeekBarColorControl2 = this.mSeekBarColorControl;
            if (spenSeekBarColorControl2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSeekBarColorControl");
                spenSeekBarColorControl2 = null;
            }
            spenSliderAnimation.setThumbInformation(0, 7700, spenSeekBarColorControl2.getThumbDrawables());
            spenSliderAnimation.setThumbLevel(7700);
            spenSliderAnimation.setProgress(this.mTrackMinHeight);
            if (this.mEnableSliderAnimation) {
                SeekBar seekBar2 = this.mSeekBar;
                if (seekBar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
                } else {
                    seekBar = seekBar2;
                }
                spenSliderAnimation.setAutoAnimation(seekBar);
            }
        }
    }

    private final void setTransitionAnimator() {
        if (this.mSliderAnimation == null) {
            return;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        SpenSeekBarColorControl spenSeekBarColorControl = this.mSeekBarColorControl;
        if (spenSeekBarColorControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBarColorControl");
            spenSeekBarColorControl = null;
        }
        this.mSliderTransition = new SpenSliderTransitionAnimator(context, spenSeekBarColorControl, this.mSliderAnimation);
    }

    private final void updateColor() {
        SpenSeekBarColorControl spenSeekBarColorControl = this.mSeekBarColorControl;
        SpenSliderThumbView spenSliderThumbView = null;
        if (spenSeekBarColorControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBarColorControl");
            spenSeekBarColorControl = null;
        }
        spenSeekBarColorControl.setColor(this.mColor);
        SpenSliderThumbView spenSliderThumbView2 = this.mSliderThumbView;
        if (spenSliderThumbView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSliderThumbView");
        } else {
            spenSliderThumbView = spenSliderThumbView2;
        }
        spenSliderThumbView.setColor(this.mColor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateContentDescription(int value, boolean isButtonEvent) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = this.mLabelFormat;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLabelFormat");
            str = null;
        }
        String strM1624n = AbstractC2322a.m1624n(str, new Object[]{Integer.valueOf(value)}, 1, "format(format, *args)");
        String str3 = this.mPostfixString;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPostfixString");
            str3 = null;
        }
        setContentDescription(strM1624n + str3);
        if (isButtonEvent) {
            String str4 = this.mPostfixButtonClickString;
            if (str4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPostfixButtonClickString");
            } else {
                str2 = str4;
            }
            announceForAccessibility(strM1624n + str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateThumbViewPosition() {
        SeekBar seekBar = this.mSeekBar;
        SpenSliderThumbView spenSliderThumbView = null;
        if (seekBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
            seekBar = null;
        }
        float fExactCenterX = seekBar.getThumb().getBounds().exactCenterX();
        SeekBar seekBar2 = this.mSeekBar;
        if (seekBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
            seekBar2 = null;
        }
        float fExactCenterX2 = fExactCenterX - seekBar2.getProgressDrawable().getBounds().exactCenterX();
        SeekBar seekBar3 = this.mSeekBar;
        if (seekBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
            seekBar3 = null;
        }
        int thumbOffset = (int) (fExactCenterX2 - seekBar3.getThumbOffset());
        SeekBar seekBar4 = this.mSeekBar;
        if (seekBar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
            seekBar4 = null;
        }
        float rotation = seekBar4.getRotation();
        if (rotation == 270.0f) {
            SpenSliderThumbView spenSliderThumbView2 = this.mSliderThumbView;
            if (spenSliderThumbView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSliderThumbView");
            } else {
                spenSliderThumbView = spenSliderThumbView2;
            }
            spenSliderThumbView.setTranslationY(-thumbOffset);
            return;
        }
        if (rotation == 90.0f) {
            SpenSliderThumbView spenSliderThumbView3 = this.mSliderThumbView;
            if (spenSliderThumbView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSliderThumbView");
            } else {
                spenSliderThumbView = spenSliderThumbView3;
            }
            spenSliderThumbView.setTranslationY(thumbOffset);
            return;
        }
        SpenSliderThumbView spenSliderThumbView4 = this.mSliderThumbView;
        if (spenSliderThumbView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSliderThumbView");
        } else {
            spenSliderThumbView = spenSliderThumbView4;
        }
        spenSliderThumbView.setTranslationX(thumbOffset);
    }

    public void close() {
        this.mTrackListener = null;
        this.mMinusButtonListener = null;
        this.mPlusButtonListener = null;
        closeSliderAnimation();
        closeSeekBarAnimation();
        closeProgressAnimation();
        closeTransitionAnimator();
        SpenSeekBarButtonControl spenSeekBarButtonControl = this.mSeekBarButtonControl;
        if (spenSeekBarButtonControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBarButtonControl");
            spenSeekBarButtonControl = null;
        }
        spenSeekBarButtonControl.close();
        SpenSeekBarColorControl spenSeekBarColorControl = this.mSeekBarColorControl;
        if (spenSeekBarColorControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBarColorControl");
            spenSeekBarColorControl = null;
        }
        spenSeekBarColorControl.close();
        SpenSliderThumbView spenSliderThumbView = this.mSliderThumbView;
        if (spenSliderThumbView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSliderThumbView");
            spenSliderThumbView = null;
        }
        spenSliderThumbView.close();
        SpenSliderThumbScaleAnimation spenSliderThumbScaleAnimation = this.mThumbScaleAnimation;
        if (spenSliderThumbScaleAnimation != null) {
            spenSliderThumbScaleAnimation.close();
        }
        SeekBar seekBar = this.mSeekBar;
        if (seekBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
            seekBar = null;
        }
        seekBar.setOnTouchListener(null);
        this.mThumbScaleAnimation = null;
    }

    /* JADX INFO: renamed from: getColor, reason: from getter */
    public final int getMColor() {
        return this.mColor;
    }

    public final int getValue() {
        SeekBar seekBar = this.mSeekBar;
        if (seekBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
            seekBar = null;
        }
        return calculateValue(seekBar.getProgress());
    }

    public final boolean isRunningShowHideAnimation() {
        SpenSliderTransitionAnimator spenSliderTransitionAnimator = this.mSliderTransition;
        return spenSliderTransitionAnimator != null && spenSliderTransitionAnimator.isRunningAnimation();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        SpenSeekBarButtonControl spenSeekBarButtonControl = this.mSeekBarButtonControl;
        SpenSeekBarButtonControl spenSeekBarButtonControl2 = null;
        if (spenSeekBarButtonControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBarButtonControl");
            spenSeekBarButtonControl = null;
        }
        spenSeekBarButtonControl.addDisallowTouchInterceptGroup((ViewGroup) findHorizontalScrollParent(this));
        SpenSeekBarButtonControl spenSeekBarButtonControl3 = this.mSeekBarButtonControl;
        if (spenSeekBarButtonControl3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBarButtonControl");
        } else {
            spenSeekBarButtonControl2 = spenSeekBarButtonControl3;
        }
        spenSeekBarButtonControl2.addDisallowTouchInterceptGroup((ViewGroup) findScrollParent(this));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        SpenSeekBarButtonControl spenSeekBarButtonControl = this.mSeekBarButtonControl;
        if (spenSeekBarButtonControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBarButtonControl");
            spenSeekBarButtonControl = null;
        }
        spenSeekBarButtonControl.clearDisallowTouchInterceptGroup();
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NotNull View changedView, int visibility) {
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        if (visibility == 0) {
            post(new RunnableC4617a(this, 26));
        }
        super.onVisibilityChanged(changedView, visibility);
    }

    public final void setAccessibilityPostfix(@Nullable String postfix) {
        if (postfix == null || postfix.length() == 0) {
            return;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        this.mPostfixString = AbstractC2322a.m1624n(", %s, %s", new Object[]{postfix, getContext().getResources().getString(C7932R.string.pen_string_slider)}, 2, "format(format, *args)");
        this.mPostfixButtonClickString = AbstractC2322a.m1624n(", %s", new Object[]{postfix}, 1, "format(format, *args)");
        updateContentDescription(getValue(), false);
    }

    public final void setAnimationValue(int startHeight, int endHeight) {
        SpenSliderTransitionAnimator spenSliderTransitionAnimator = this.mSliderTransition;
        if (spenSliderTransitionAnimator != null) {
            spenSliderTransitionAnimator.setHeight(startHeight, endHeight);
        }
    }

    public final void setColor(int i) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Log.i(TAG, AbstractC1974b.m1319l("setColor() color=", i, AbstractC2322a.m1624n("#%08X", new Object[]{Integer.valueOf(i)}, 1, "format(format, *args)"), "(", ")"));
        this.mColor = i;
        updateColor();
    }

    public final void setHideAnimationListener(@Nullable Animator.AnimatorListener listener) {
        SpenSliderTransitionAnimator spenSliderTransitionAnimator = this.mSliderTransition;
        if (spenSliderTransitionAnimator != null) {
            spenSliderTransitionAnimator.setHideAnimatorListener(listener);
        }
    }

    public void setLabelFormat(@NotNull String format) {
        Intrinsics.checkNotNullParameter(format, "format");
        this.mLabelFormat = format;
        updateContentDescription(getValue(), false);
    }

    public void setOnChangedListener(@Nullable OnChangedListener listener) {
        this.mChangedListener = listener;
    }

    public void setOnMinusButtonActionListener(@Nullable OnSliderButtonListener listener) {
        this.mMinusButtonListener = listener;
    }

    public void setOnPlusButtonActionListener(@Nullable OnSliderButtonListener listener) {
        this.mPlusButtonListener = listener;
    }

    public void setOnTrackListener(@Nullable OnSliderTrackListener listener) {
        this.mTrackListener = listener;
    }

    public final void setProgressBackgroundColors(@NotNull int... colors) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        AbstractC2322a.m1631u(colors.length, "setProgressBackgroundColors() length=", TAG);
        SpenSeekBarColorControl spenSeekBarColorControl = this.mSeekBarColorControl;
        if (spenSeekBarColorControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBarColorControl");
            spenSeekBarColorControl = null;
        }
        spenSeekBarColorControl.setProgressColor(Arrays.copyOf(colors, colors.length));
    }

    public final void setProgressBackgroundDrawable(@Nullable Drawable drawable) {
        SpenSeekBarColorControl spenSeekBarColorControl;
        SeekBar seekBar;
        SpenSliderThumbView spenSliderThumbView;
        Log.i(TAG, "setProgressBackgroundDrawable()");
        SpenSeekBarColorControl spenSeekBarColorControl2 = this.mSeekBarColorControl;
        if (spenSeekBarColorControl2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBarColorControl");
            spenSeekBarColorControl2 = null;
        }
        spenSeekBarColorControl2.close();
        SpenSeekBarColorControl spenSeekBarColorControl3 = this.mSeekBarColorControl;
        if (spenSeekBarColorControl3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBarColorControl");
            spenSeekBarColorControl = null;
        } else {
            spenSeekBarColorControl = spenSeekBarColorControl3;
        }
        SeekBar seekBar2 = this.mSeekBar;
        if (seekBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
            seekBar = null;
        } else {
            seekBar = seekBar2;
        }
        SpenSliderThumbView spenSliderThumbView2 = this.mSliderThumbView;
        if (spenSliderThumbView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSliderThumbView");
            spenSliderThumbView = null;
        } else {
            spenSliderThumbView = spenSliderThumbView2;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        spenSeekBarColorControl.initSeekBar(seekBar, spenSliderThumbView, context, this.mHasOutline, drawable);
        if (this.mEnableSliderAnimation) {
            setSliderAnimation();
        } else {
            setSeekBarAnimation();
        }
    }

    public final void setRotateDegree(float degree) {
        SpenSliderThumbView spenSliderThumbView = this.mSliderThumbView;
        if (spenSliderThumbView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSliderThumbView");
            spenSliderThumbView = null;
        }
        spenSliderThumbView.setRotateDegree(degree);
    }

    public final void setThumbAnimationEnable(boolean enable) {
        SpenSliderThumbView spenSliderThumbView = this.mSliderThumbView;
        if (spenSliderThumbView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSliderThumbView");
            spenSliderThumbView = null;
        }
        spenSliderThumbView.setThumbAnimationEnable(enable);
    }

    public final void setThumbScaleAnimation(boolean isScaleDown) {
        if (this.mThumbScaleAnimation == null) {
            SpenSliderThumbView spenSliderThumbView = this.mSliderThumbView;
            if (spenSliderThumbView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSliderThumbView");
                spenSliderThumbView = null;
            }
            this.mThumbScaleAnimation = new SpenSliderThumbScaleAnimation(spenSliderThumbView);
        }
        SpenSliderThumbScaleAnimation spenSliderThumbScaleAnimation = this.mThumbScaleAnimation;
        if (spenSliderThumbScaleAnimation != null) {
            spenSliderThumbScaleAnimation.startAnimation(isScaleDown);
        }
    }

    public final void setTrackMinHeight(int minHeight) {
        this.mTrackMinHeight = minHeight;
        setSliderAnimation();
    }

    public final void setValue(int value, boolean needAnimation) {
        int iCalculateProgress = calculateProgress(value);
        SeekBar seekBar = this.mSeekBar;
        SeekBar seekBar2 = null;
        if (seekBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
            seekBar = null;
        }
        int progress = seekBar.getProgress();
        AbstractC0000a.m27x(AbstractC0622a.m1173s(progress, iCalculateProgress, "setValue: curr= ", " target= ", " needAnimation= "), needAnimation, TAG);
        if (progress == iCalculateProgress) {
            return;
        }
        this.mCurrentValue = value;
        if (needAnimation) {
            SpenSeekBarProgressAnimation spenSeekBarProgressAnimation = this.mProgressAnimation;
            if (spenSeekBarProgressAnimation != null) {
                spenSeekBarProgressAnimation.startAnimation(progress, iCalculateProgress);
            }
        } else {
            SeekBar seekBar3 = this.mSeekBar;
            if (seekBar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSeekBar");
            } else {
                seekBar2 = seekBar3;
            }
            seekBar2.setProgress(iCalculateProgress);
        }
        updateContentDescription(this.mCurrentValue, false);
    }

    public final void startHideAnimation() {
        SpenSliderTransitionAnimator spenSliderTransitionAnimator = this.mSliderTransition;
        if (spenSliderTransitionAnimator != null) {
            spenSliderTransitionAnimator.startHide();
        }
    }

    public final void startShowAnimation(int startThumbColor, int endThumbColor) {
        SpenSliderTransitionAnimator spenSliderTransitionAnimator = this.mSliderTransition;
        if (spenSliderTransitionAnimator != null) {
            spenSliderTransitionAnimator.startShow(startThumbColor, endThumbColor, this.mColor);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SpenSlider(@NotNull Context context, boolean z, @NotNull SliderType sliderType) {
        this(context, z, C7932R.layout.setting_slider_layout, 1, 100, C7932R.string.pen_string_decrease, C7932R.string.pen_string_increase, sliderType);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sliderType, "sliderType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SpenSlider(@NotNull Context context, boolean z, int i, @NotNull SliderType sliderType) {
        this(context, z, i, 1, 100, C7932R.string.pen_string_decrease, C7932R.string.pen_string_increase, sliderType);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sliderType, "sliderType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SpenSlider(@NotNull Context context, boolean z, int i, int i2, @NotNull SliderType sliderType) {
        this(context, z, C7932R.layout.setting_slider_layout, i, i2, C7932R.string.pen_string_decrease, C7932R.string.pen_string_increase, sliderType);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sliderType, "sliderType");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SpenSlider(@NotNull Context context, boolean z, int i, int i2, int i4, int i5, @NotNull SliderType sliderType) {
        this(context, z, C7932R.layout.setting_slider_layout, i, i2, i4, i5, sliderType);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sliderType, "sliderType");
    }
}
