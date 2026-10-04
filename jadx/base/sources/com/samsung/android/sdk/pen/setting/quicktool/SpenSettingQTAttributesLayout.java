package com.samsung.android.sdk.pen.setting.quicktool;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.setting.handwriting.SpenPenOpacityLayoutInterface;
import com.samsung.android.sdk.pen.setting.handwriting.SpenPenWidthLayoutInterface;
import com.samsung.android.sdk.pen.setting.handwriting.SpenPenWidthMiniLayout;
import com.samsung.android.sdk.pen.setting.quicktool.SpenCurvedDialer;
import com.samsung.android.sdk.pen.setting.quicktool.SpenQTOpacitySlider;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.spen.C7932R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\f\u0018\u0000 ?2\u00020\u0001:\u0003?@AB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0004\u001a\u00020\u0005J \u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\fH\u0002J\u0018\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u0005H\u0002J\b\u0010$\u001a\u00020\u001bH\u0002J\u000e\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\u0005J\u0006\u0010'\u001a\u00020\u0005J\u000e\u0010(\u001a\u00020\f2\u0006\u0010)\u001a\u00020\u0005J\u0006\u0010*\u001a\u00020\u0005J\u000e\u0010+\u001a\u00020\f2\u0006\u0010,\u001a\u00020\u0005J\u0006\u0010-\u001a\u00020\fJ\u000e\u0010.\u001a\u00020\f2\u0006\u0010-\u001a\u00020\fJ\u0010\u0010/\u001a\u00020\u001b2\b\u00100\u001a\u0004\u0018\u00010\u000eJ\u0010\u00101\u001a\u00020\u001b2\b\u00100\u001a\u0004\u0018\u00010\u0010J\u0010\u00102\u001a\u00020\u001b2\b\u00100\u001a\u0004\u0018\u000103J\u0016\u00104\u001a\u00020\f2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u000206J\u0016\u00108\u001a\u00020\u001b2\u0006\u00109\u001a\u00020\u00052\u0006\u0010:\u001a\u00020\fJ\u0010\u0010;\u001a\u00020\f2\u0006\u0010<\u001a\u00020\u0005H\u0002J\u0018\u0010;\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u0005H\u0002J\u0010\u0010=\u001a\u00020\u001b2\u0006\u0010>\u001a\u00020\fH\u0002R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006B"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTAttributesLayout;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attributeSet", "", "<init>", "(Landroid/content/Context;I)V", "mAttributeSet", "mSizeLevel", "mOpacity", "mIsFixedWidth", "", "mDataChangedListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTAttributesLayout$OnDataChangedListener;", "mActionListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTAttributesLayout$OnActionListener;", "mFixedWidthView", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenWidthMiniLayout;", "mOpacityView", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenQTOpacitySlider;", "mSizeView", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenCurvedDialer;", "mDefaultSizeAngle", "Landroid/graphics/PointF;", "mHalfSizeAngle", "close", "", "changeAttributeSet", "updateLayout", "changeSizeAngle", "opacityVisible", "fixedWidthVisible", "needToChangeSizeAngle", "fromSet", "toSet", "initValue", "setColor", "color", "getSizeLevel", "setSizeLevel", "sizeLevel", "getOpacity", "setOpacity", "opacity", "isFixedWidth", "setFixedWidth", "setDataChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setActionListener", "setCurvedDialerTrackListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/OnCurvedDialerTrackListener;", "isScrollAt", "rawX", "", "rawY", "setVisibility", "pVisibility", "isAnimate", "isSupportedAttribute", "attribute", "startFixedWidthVisibilityAnimation", "isShow", "Companion", "OnDataChangedListener", "OnActionListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSpenSettingQTAttributesLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SpenSettingQTAttributesLayout.kt\ncom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTAttributesLayout\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,262:1\n254#2:263\n254#2:264\n*S KotlinDebug\n*F\n+ 1 SpenSettingQTAttributesLayout.kt\ncom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTAttributesLayout\n*L\n221#1:263\n232#1:264\n*E\n"})
public final class SpenSettingQTAttributesLayout extends ConstraintLayout {
    public static final int ATTRIBUTE_FIXED_WIDTH = 4;
    public static final int ATTRIBUTE_OPACITY = 2;
    public static final int ATTRIBUTE_SIZE = 1;
    private static final long FIXED_WIDTH_HIDE_ANIMATION_DURATION = 350;
    private static final long FIXED_WIDTH_SHOW_ANIMATION_DURATION = 400;

    @NotNull
    private static final String TAG = "SpenSettingQTAttributesLayout";

    @Nullable
    private OnActionListener mActionListener;
    private int mAttributeSet;

    @Nullable
    private OnDataChangedListener mDataChangedListener;

    @NotNull
    private final PointF mDefaultSizeAngle;

    @Nullable
    private SpenPenWidthMiniLayout mFixedWidthView;

    @NotNull
    private final PointF mHalfSizeAngle;
    private boolean mIsFixedWidth;
    private int mOpacity;

    @Nullable
    private SpenQTOpacitySlider mOpacityView;
    private int mSizeLevel;

    @Nullable
    private SpenCurvedDialer mSizeView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTAttributesLayout$OnActionListener;", "", "onDialerHandlerClicked", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnActionListener {
        void onDialerHandlerClicked();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\tH&¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTAttributesLayout$OnDataChangedListener;", "", "onSizeChanged", "", "sizeLevel", "", "onAlphaChanged", "alpha", "notify", "", "onFixedWidthChanged", "isFixedWidth", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnDataChangedListener {
        void onAlphaChanged(int alpha, boolean notify);

        void onFixedWidthChanged(boolean isFixedWidth);

        void onSizeChanged(int sizeLevel);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenSettingQTAttributesLayout(@NotNull Context context, int i) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mOpacity = 255;
        this.mDefaultSizeAngle = new PointF(context.getResources().getInteger(C7932R.integer.setting_qt_size_default_angle_start), context.getResources().getInteger(C7932R.integer.setting_qt_size_default_angle_end));
        this.mHalfSizeAngle = new PointF(context.getResources().getInteger(C7932R.integer.setting_qt_size_half_angle_start), context.getResources().getInteger(C7932R.integer.setting_qt_size_half_angle_end));
        initValue();
        LayoutInflater.from(context).inflate(C7932R.layout.setting_qt_attr_layout, (ViewGroup) this, true);
        this.mFixedWidthView = (SpenPenWidthMiniLayout) findViewById(C7932R.id.attr_fixed_width_view);
        this.mOpacityView = (SpenQTOpacitySlider) findViewById(C7932R.id.attr_opacity_slider);
        this.mSizeView = (SpenCurvedDialer) findViewById(C7932R.id.attr_size_dialer);
        this.mAttributeSet = i;
        if (i != 1) {
            updateLayout(true, isSupportedAttribute(2), isSupportedAttribute(4));
        }
        SpenCurvedDialer spenCurvedDialer = this.mSizeView;
        if (spenCurvedDialer != null) {
            spenCurvedDialer.setOnChangedListener(new SpenCurvedDialer.OnChangedListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTAttributesLayout.1
                @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenCurvedDialer.OnChangedListener
                public void onChanged(int value, boolean fromUser) {
                    SpenSettingQTAttributesLayout.this.mSizeLevel = value;
                    OnDataChangedListener onDataChangedListener = SpenSettingQTAttributesLayout.this.mDataChangedListener;
                    if (onDataChangedListener != null) {
                        onDataChangedListener.onSizeChanged(SpenSettingQTAttributesLayout.this.mSizeLevel);
                    }
                }
            });
        }
        SpenCurvedDialer spenCurvedDialer2 = this.mSizeView;
        if (spenCurvedDialer2 != null) {
            spenCurvedDialer2.setOnAnimationListener(new SpenCurvedDialer.OnAnimationListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTAttributesLayout.2
                @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenCurvedDialer.OnAnimationListener
                public void onVisibilityAnimationEnd(boolean isShowAnimation) {
                    if (isShowAnimation) {
                        return;
                    }
                    SpenSettingQTAttributesLayout.this.setVisibility(8);
                }
            });
        }
        SpenCurvedDialer spenCurvedDialer3 = this.mSizeView;
        if (spenCurvedDialer3 != null) {
            spenCurvedDialer3.setOnActionListener(new SpenCurvedDialer.OnActionListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTAttributesLayout.3
                @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenCurvedDialer.OnActionListener
                public void onDialerHandlerClicked() {
                    OnActionListener onActionListener = SpenSettingQTAttributesLayout.this.mActionListener;
                    if (onActionListener != null) {
                        onActionListener.onDialerHandlerClicked();
                    }
                }
            });
        }
        SpenQTOpacitySlider spenQTOpacitySlider = this.mOpacityView;
        if (spenQTOpacitySlider != null) {
            spenQTOpacitySlider.setDataChangedListener(new SpenPenOpacityLayoutInterface.OnDataChangedListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTAttributesLayout.4
                @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenOpacityLayoutInterface.OnDataChangedListener
                public void onAlphaChanged(int alpha, boolean notify) {
                    SpenSettingQTAttributesLayout.this.mOpacity = alpha;
                    OnDataChangedListener onDataChangedListener = SpenSettingQTAttributesLayout.this.mDataChangedListener;
                    if (onDataChangedListener != null) {
                        onDataChangedListener.onAlphaChanged(SpenSettingQTAttributesLayout.this.mOpacity, notify);
                    }
                }
            });
        }
        SpenQTOpacitySlider spenQTOpacitySlider2 = this.mOpacityView;
        if (spenQTOpacitySlider2 != null) {
            spenQTOpacitySlider2.setAnimationListener(new SpenQTOpacitySlider.OnAnimationListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTAttributesLayout.5
                @Override // com.samsung.android.sdk.pen.setting.quicktool.SpenQTOpacitySlider.OnAnimationListener
                public void onAnimationEnd(boolean isShowAnimation) {
                    if (isShowAnimation) {
                        return;
                    }
                    SpenSettingQTAttributesLayout.this.setVisibility(8);
                }
            });
        }
        SpenPenWidthMiniLayout spenPenWidthMiniLayout = this.mFixedWidthView;
        if (spenPenWidthMiniLayout != null) {
            spenPenWidthMiniLayout.setDataChangedListener(new SpenPenWidthLayoutInterface.OnDataChangedListener() { // from class: com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTAttributesLayout.6
                @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenWidthLayoutInterface.OnDataChangedListener
                public void onPenWidthChanged(boolean isFixed) {
                    SpenSettingQTAttributesLayout.this.mIsFixedWidth = isFixed;
                    OnDataChangedListener onDataChangedListener = SpenSettingQTAttributesLayout.this.mDataChangedListener;
                    if (onDataChangedListener != null) {
                        onDataChangedListener.onFixedWidthChanged(SpenSettingQTAttributesLayout.this.mIsFixedWidth);
                    }
                }
            });
        }
    }

    private final void initValue() {
        this.mSizeLevel = 1;
        this.mOpacity = 255;
        this.mIsFixedWidth = false;
    }

    private final boolean isSupportedAttribute(int attributeSet, int attribute) {
        return (attributeSet & attribute) == attribute;
    }

    private final boolean needToChangeSizeAngle(int fromSet, int toSet) {
        return isSupportedAttribute(fromSet, 2) != isSupportedAttribute(toSet, 2);
    }

    private final void startFixedWidthVisibilityAnimation(boolean isShow) {
        float f = isShow ? 0.0f : 1.0f;
        float f4 = isShow ? 1.0f : 0.0f;
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.mFixedWidthView, "scaleX", f, f4);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.mFixedWidthView, "scaleY", f, f4);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        animatorSet.setDuration(isShow ? 400L : 350L);
        animatorSet.setInterpolator(SpenSettingUtilAnimation.getInterpolator(20));
        animatorSet.start();
    }

    private final void updateLayout(boolean changeSizeAngle, boolean opacityVisible, boolean fixedWidthVisible) {
        SpenPenWidthMiniLayout spenPenWidthMiniLayout;
        SpenQTOpacitySlider spenQTOpacitySlider;
        SpenCurvedDialer spenCurvedDialer;
        if (changeSizeAngle && (spenCurvedDialer = this.mSizeView) != null) {
            spenCurvedDialer.setAngleRange((opacityVisible ? this.mHalfSizeAngle : this.mDefaultSizeAngle).x, (opacityVisible ? this.mHalfSizeAngle : this.mDefaultSizeAngle).y);
        }
        SpenQTOpacitySlider spenQTOpacitySlider2 = this.mOpacityView;
        if ((spenQTOpacitySlider2 != null && spenQTOpacitySlider2.getVisibility() == 0) != opacityVisible && (spenQTOpacitySlider = this.mOpacityView) != null) {
            spenQTOpacitySlider.setVisibility(opacityVisible ? 0 : 8, false);
        }
        SpenPenWidthMiniLayout spenPenWidthMiniLayout2 = this.mFixedWidthView;
        if ((spenPenWidthMiniLayout2 != null && spenPenWidthMiniLayout2.getVisibility() == 0) == fixedWidthVisible || (spenPenWidthMiniLayout = this.mFixedWidthView) == null) {
            return;
        }
        spenPenWidthMiniLayout.setVisibility(fixedWidthVisible ? 0 : 8);
    }

    public final void changeAttributeSet(int attributeSet) {
        AbstractC6670b.m4744e(this.mAttributeSet, attributeSet, "changeAttributeSet() ", " -> ", TAG);
        int i = this.mAttributeSet;
        if (attributeSet == i) {
            return;
        }
        updateLayout(needToChangeSizeAngle(i, attributeSet), isSupportedAttribute(attributeSet, 2), isSupportedAttribute(attributeSet, 4));
        this.mAttributeSet = attributeSet;
    }

    public final void close() {
        SpenQTOpacitySlider spenQTOpacitySlider = this.mOpacityView;
        if (spenQTOpacitySlider != null) {
            spenQTOpacitySlider.close();
        }
        this.mOpacityView = null;
        SpenCurvedDialer spenCurvedDialer = this.mSizeView;
        if (spenCurvedDialer != null) {
            spenCurvedDialer.close();
        }
        this.mSizeView = null;
        SpenPenWidthMiniLayout spenPenWidthMiniLayout = this.mFixedWidthView;
        if (spenPenWidthMiniLayout != null) {
            spenPenWidthMiniLayout.close();
        }
        this.mFixedWidthView = null;
        this.mDataChangedListener = null;
        this.mActionListener = null;
    }

    public final int getOpacity() {
        if (isSupportedAttribute(2)) {
            return this.mOpacity;
        }
        return 255;
    }

    public final int getSizeLevel() {
        if (isSupportedAttribute(1)) {
            return this.mSizeLevel;
        }
        return 0;
    }

    public final boolean isFixedWidth() {
        if (isSupportedAttribute(4)) {
            return false;
        }
        return this.mIsFixedWidth;
    }

    public final boolean isScrollAt(float rawX, float rawY) {
        SpenCurvedDialer spenCurvedDialer = this.mSizeView;
        if (spenCurvedDialer != null && spenCurvedDialer.isRawPointInView(rawX, rawY)) {
            return true;
        }
        SpenQTOpacitySlider spenQTOpacitySlider = this.mOpacityView;
        return spenQTOpacitySlider != null && spenQTOpacitySlider.getVisibility() == 0 && spenQTOpacitySlider.isRawPointInView(rawX, rawY);
    }

    public final void setActionListener(@Nullable OnActionListener listener) {
        this.mActionListener = listener;
    }

    public final void setColor(int color) {
        if (isSupportedAttribute(2)) {
            this.mOpacity = Color.alpha(color);
            SpenQTOpacitySlider spenQTOpacitySlider = this.mOpacityView;
            if (spenQTOpacitySlider != null) {
                spenQTOpacitySlider.setColor(color);
            }
        }
        SpenCurvedDialer spenCurvedDialer = this.mSizeView;
        if (spenCurvedDialer != null) {
            spenCurvedDialer.setColor(color);
        }
    }

    public final void setCurvedDialerTrackListener(@Nullable OnCurvedDialerTrackListener listener) {
        SpenCurvedDialer spenCurvedDialer = this.mSizeView;
        if (spenCurvedDialer != null) {
            spenCurvedDialer.setCurvedDialerTrackListener(listener);
        }
    }

    public final void setDataChangedListener(@Nullable OnDataChangedListener listener) {
        this.mDataChangedListener = listener;
    }

    public final boolean setFixedWidth(boolean isFixedWidth) {
        if (!isSupportedAttribute(4)) {
            return false;
        }
        AbstractC4539a.m3208r("setPenWidth() isFixedWidth=", TAG, isFixedWidth);
        this.mIsFixedWidth = isFixedWidth;
        SpenPenWidthMiniLayout spenPenWidthMiniLayout = this.mFixedWidthView;
        if (spenPenWidthMiniLayout == null) {
            return true;
        }
        spenPenWidthMiniLayout.setPenWidth(isFixedWidth, false);
        return true;
    }

    public final boolean setOpacity(int opacity) {
        if (!isSupportedAttribute(2)) {
            return false;
        }
        this.mOpacity = opacity;
        return true;
    }

    public final boolean setSizeLevel(int sizeLevel) {
        if (!isSupportedAttribute(1)) {
            return false;
        }
        if (sizeLevel < 1) {
            sizeLevel = 1;
        }
        this.mSizeLevel = sizeLevel;
        SpenCurvedDialer spenCurvedDialer = this.mSizeView;
        if (spenCurvedDialer != null) {
            SpenCurvedDialer.setValue$default(spenCurvedDialer, sizeLevel, false, 2, null);
        }
        return true;
    }

    public final void setVisibility(int pVisibility, boolean isAnimate) {
        SpenCurvedDialer spenCurvedDialer;
        SpenQTOpacitySlider spenQTOpacitySlider;
        boolean zIsSupportedAttribute = isSupportedAttribute(2);
        boolean zIsSupportedAttribute2 = isSupportedAttribute(1);
        boolean zIsSupportedAttribute3 = isSupportedAttribute(4);
        if ((getVisibility() != 0 && pVisibility != 0) || !isAnimate) {
            setVisibility(pVisibility);
            return;
        }
        setVisibility(0);
        if (zIsSupportedAttribute && (spenQTOpacitySlider = this.mOpacityView) != null) {
            spenQTOpacitySlider.setVisibility(pVisibility, true);
        }
        if (zIsSupportedAttribute2 && (spenCurvedDialer = this.mSizeView) != null) {
            spenCurvedDialer.startVisibilityAnimation(pVisibility == 0);
        }
        if (zIsSupportedAttribute3) {
            startFixedWidthVisibilityAnimation(pVisibility == 0);
        }
    }

    private final boolean isSupportedAttribute(int attribute) {
        return isSupportedAttribute(this.mAttributeSet, attribute);
    }
}
