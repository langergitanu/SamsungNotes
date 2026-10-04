package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PointF;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.setting.quicktool.SpenSimpleChipView;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilHover;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilOpacity;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.search.view.ViewOnClickListenerC8556a;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.CurvedDialer;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTOpacitySlider;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.animation.QTAnimationKt;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.common.QTCircle;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.common.QTVoiceAssistantAsButton;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.handwriting.PenOpacityLayoutInterface;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.handwriting.PenWidthLayoutInterface;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.handwriting.PenWidthMiniLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p258y.AbstractC14516b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0007\n\u0002\b\u000b\b\u0007\u0018\u0000 D2\u00020\u0001:\u0002DEB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\u0018\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0005H\u0002J\u0006\u0010\"\u001a\u00020\u001dJ\u000e\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020\u0005J \u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00020\f2\u0006\u0010(\u001a\u00020\fH\u0002J\u0018\u0010)\u001a\u00020\f2\u0006\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u0005H\u0002J\b\u0010,\u001a\u00020\u001dH\u0002J\u000e\u0010-\u001a\u00020\u001d2\u0006\u0010.\u001a\u00020\u0005J\u0006\u0010/\u001a\u00020\u0005J\u000e\u00100\u001a\u00020\f2\u0006\u00101\u001a\u00020\u0005J\u0006\u00102\u001a\u00020\u0005J\u000e\u00103\u001a\u00020\f2\u0006\u00104\u001a\u00020\u0005J\u0006\u00105\u001a\u00020\fJ\u000e\u00106\u001a\u00020\f2\u0006\u00105\u001a\u00020\fJ\u0010\u00107\u001a\u00020\u001d2\b\u00108\u001a\u0004\u0018\u00010\u000eJ\u0016\u00109\u001a\u00020\f2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020;J\u0016\u0010=\u001a\u00020\u001d2\u0006\u0010>\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\fJ\u0010\u0010@\u001a\u00020\f2\u0006\u0010A\u001a\u00020\u0005H\u0002J\u0018\u0010@\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010A\u001a\u00020\u0005H\u0002J\u0010\u0010B\u001a\u00020\u001d2\u0006\u0010C\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006F"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTAttributesLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "mAttributeSet", "", "<init>", "(Landroid/content/Context;I)V", "mSizeLevel", "mColor", "mOpacity", "mIsFixedWidth", "", "mDataChangedListener", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTAttributesLayout$OnDataChangedListener;", "circle", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/common/QTCircle;", "mColorItem", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSimpleChipView;", "mFixedWidthView", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/handwriting/PenWidthMiniLayout;", "mOpacityView", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTOpacitySlider;", "mSizeView", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/CurvedDialer;", "mDefaultSizeAngle", "Landroid/graphics/PointF;", "mHalfSizeAngle", "setupViewPosition", "", "setItemAccessibility", "item", "Landroid/view/View;", "stringId", "close", "changeAttributeSet", "attributeSet", "updateLayout", "changeSizeAngle", "opacityVisible", "fixedWidthVisible", "needToChangeSizeAngle", "fromSet", "toSet", "initValue", "setColor", "color", "getSizeLevel", "setSizeLevel", "sizeLevel", "getOpacity", "setOpacity", "opacity", "isFixedWidth", "setFixedWidth", "setDataChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "isScrollAt", "rawX", "", "rawY", "setVisibility", "pVisibility", "isAnimate", "isSupportedAttribute", "attribute", "startFixedWidthVisibilityAnimation", "isShow", "Companion", "OnDataChangedListener", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SuppressLint({"ViewConstructor"})
@SourceDebugExtension({"SMAP\nSettingQTAttributesLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SettingQTAttributesLayout.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTAttributesLayout\n+ 2 View.kt\nandroidx/core/view/ViewKt\n*L\n1#1,291:1\n176#2,2:292\n257#2,2:294\n255#2:296\n255#2:297\n255#2:298\n*S KotlinDebug\n*F\n+ 1 SettingQTAttributesLayout.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTAttributesLayout\n*L\n75#1:292,2\n171#1:294,2\n255#1:296\n265#1:297\n287#1:298\n*E\n"})
public final class SettingQTAttributesLayout extends FrameLayout {
    public static final int ATTRIBUTE_FIXED_WIDTH = 4;
    public static final int ATTRIBUTE_OPACITY = 2;
    public static final int ATTRIBUTE_SIZE = 1;
    private static final long FIXED_WIDTH_HIDE_ANIMATION_DURATION = 350;
    private static final long FIXED_WIDTH_SHOW_ANIMATION_DURATION = 400;

    @NotNull
    private static final String TAG = "QTAttributesLayout";

    @NotNull
    private final QTCircle circle;
    private int mAttributeSet;
    private int mColor;

    @NotNull
    private SpenSimpleChipView mColorItem;

    @Nullable
    private OnDataChangedListener mDataChangedListener;

    @NotNull
    private final PointF mDefaultSizeAngle;

    @NotNull
    private PenWidthMiniLayout mFixedWidthView;

    @NotNull
    private final PointF mHalfSizeAngle;
    private boolean mIsFixedWidth;
    private int mOpacity;

    @Nullable
    private QTOpacitySlider mOpacityView;
    private int mSizeLevel;

    @Nullable
    private CurvedDialer mSizeView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0018\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\nH&¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTAttributesLayout$OnDataChangedListener;", "", "onColorClick", "", "onSizeChanged", "sizeLevel", "", "onAlphaChanged", "alpha", "notify", "", "onFixedWidthChanged", "isFixedWidth", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface OnDataChangedListener {
        void onAlphaChanged(int alpha, boolean notify);

        void onColorClick();

        void onFixedWidthChanged(boolean isFixedWidth);

        void onSizeChanged(int sizeLevel);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingQTAttributesLayout(@NotNull Context context, int i) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mAttributeSet = i;
        this.mOpacity = 255;
        this.mDefaultSizeAngle = new PointF(context.getResources().getInteger(C9086R.integer.composer_qt_size_default_angle_start), context.getResources().getInteger(C9086R.integer.composer_qt_size_default_angle_end));
        this.mHalfSizeAngle = new PointF(context.getResources().getInteger(C9086R.integer.composer_qt_size_half_angle_start), context.getResources().getInteger(C9086R.integer.composer_qt_size_half_angle_end));
        initValue();
        LayoutInflater.from(context).inflate(C9086R.layout.qt_attr_layout, (ViewGroup) this, true);
        float dimension = getResources().getDimension(C9086R.dimen.composer_qt_circle_default_size) * 0.5f;
        this.circle = new QTCircle(dimension, dimension, getResources().getDimension(C9086R.dimen.qt_inner_radius));
        View viewFindViewById = findViewById(C9086R.id.attr_fixed_width_view);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.mFixedWidthView = (PenWidthMiniLayout) viewFindViewById;
        SpenSimpleChipView spenSimpleChipView = new SpenSimpleChipView(context);
        this.mColorItem = spenSimpleChipView;
        spenSimpleChipView.setBackgroundResource(C9086R.drawable.spen_round_ripple);
        SpenSimpleChipView spenSimpleChipView2 = this.mColorItem;
        int dimensionPixelSize = getResources().getDimensionPixelSize(C9086R.dimen.composer_qt_attr_color_item_padding);
        spenSimpleChipView2.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        setItemAccessibility(this.mColorItem, C9086R.string.pen_string_pen_color);
        this.mColorItem.setOnClickListener(new ViewOnClickListenerC8556a(this, 21));
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(C9086R.dimen.composer_qt_circle_color_item_size);
        this.mColorItem.setLayoutParams(new ViewGroup.LayoutParams(dimensionPixelSize2, dimensionPixelSize2));
        addView(this.mColorItem);
        this.mOpacityView = (QTOpacitySlider) findViewById(C9086R.id.attr_opacity_slider);
        this.mSizeView = (CurvedDialer) findViewById(C9086R.id.attr_size_dialer);
        updateLayout(true, isSupportedAttribute(2), isSupportedAttribute(4));
        CurvedDialer curvedDialer = this.mSizeView;
        if (curvedDialer != null) {
            curvedDialer.setOnChangedListener(new CurvedDialer.OnChangedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTAttributesLayout.2
                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.CurvedDialer.OnChangedListener
                public void onChanged(int value, boolean fromUser) {
                    SettingQTAttributesLayout.this.mSizeLevel = value;
                    OnDataChangedListener onDataChangedListener = SettingQTAttributesLayout.this.mDataChangedListener;
                    if (onDataChangedListener != null) {
                        onDataChangedListener.onSizeChanged(SettingQTAttributesLayout.this.mSizeLevel);
                    }
                }
            });
        }
        CurvedDialer curvedDialer2 = this.mSizeView;
        if (curvedDialer2 != null) {
            curvedDialer2.setOnAnimationListener(new CurvedDialer.OnAnimationListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTAttributesLayout.3
                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.CurvedDialer.OnAnimationListener
                public void onVisibilityAnimationEnd(boolean isShowAnimation) {
                    if (isShowAnimation) {
                        return;
                    }
                    SettingQTAttributesLayout.this.setVisibility(8);
                }
            });
        }
        QTOpacitySlider qTOpacitySlider = this.mOpacityView;
        if (qTOpacitySlider != null) {
            qTOpacitySlider.setDataChangedListener(new PenOpacityLayoutInterface.OnDataChangedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTAttributesLayout.4
                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.handwriting.PenOpacityLayoutInterface.OnDataChangedListener
                public void onAlphaChanged(int alpha, boolean notify) {
                    SettingQTAttributesLayout.this.mOpacity = alpha;
                    SettingQTAttributesLayout.this.mColorItem.setColor(SpenSettingUtilOpacity.setCurrentAlpha(SettingQTAttributesLayout.this.mColor, alpha));
                    SettingQTAttributesLayout settingQTAttributesLayout = SettingQTAttributesLayout.this;
                    settingQTAttributesLayout.setItemAccessibility(settingQTAttributesLayout.mColorItem, C9086R.string.pen_string_pen_color);
                    OnDataChangedListener onDataChangedListener = SettingQTAttributesLayout.this.mDataChangedListener;
                    if (onDataChangedListener != null) {
                        onDataChangedListener.onAlphaChanged(SettingQTAttributesLayout.this.mOpacity, notify);
                    }
                }
            });
        }
        QTOpacitySlider qTOpacitySlider2 = this.mOpacityView;
        if (qTOpacitySlider2 != null) {
            qTOpacitySlider2.setAnimationListener(new QTOpacitySlider.OnAnimationListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTAttributesLayout.5
                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.QTOpacitySlider.OnAnimationListener
                public void onAnimationEnd(boolean isShowAnimation) {
                    if (isShowAnimation) {
                        return;
                    }
                    SettingQTAttributesLayout.this.setVisibility(8);
                }
            });
        }
        this.mFixedWidthView.setDataChangedListener(new PenWidthLayoutInterface.OnDataChangedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTAttributesLayout.6
            @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.handwriting.PenWidthLayoutInterface.OnDataChangedListener
            public void onPenWidthChanged(boolean isFixed) {
                SettingQTAttributesLayout.this.mIsFixedWidth = isFixed;
                OnDataChangedListener onDataChangedListener = SettingQTAttributesLayout.this.mDataChangedListener;
                if (onDataChangedListener != null) {
                    onDataChangedListener.onFixedWidthChanged(SettingQTAttributesLayout.this.mIsFixedWidth);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(SettingQTAttributesLayout settingQTAttributesLayout, View view) {
        OnDataChangedListener onDataChangedListener = settingQTAttributesLayout.mDataChangedListener;
        if (onDataChangedListener != null) {
            onDataChangedListener.onColorClick();
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void setItemAccessibility(View item, int stringId) {
        String string = getContext().getResources().getString(stringId);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        item.setContentDescription(string);
        SpenSettingUtilHover.setHoverText(item, string);
        item.setAccessibilityDelegate(new QTVoiceAssistantAsButton());
    }

    private final void setupViewPosition() {
        int dimensionPixelSize = getResources().getDimensionPixelSize(C9086R.dimen.qt_child_size);
        this.circle.place(this.mFixedWidthView, dimensionPixelSize, dimensionPixelSize, 78.75f);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(C9086R.dimen.composer_qt_circle_color_item_size);
        this.circle.place(this.mColorItem, dimensionPixelSize2, dimensionPixelSize2, 78.75f);
    }

    private final void startFixedWidthVisibilityAnimation(boolean isShow) {
        QTAnimationKt.scale(this.mFixedWidthView.getVisibility() == 0 ? this.mFixedWidthView : this.mColorItem, isShow ? 0.0f : 1.0f, isShow ? 1.0f : 0.0f, 0L, isShow ? 400L : 350L);
    }

    private final void updateLayout(boolean changeSizeAngle, boolean opacityVisible, boolean fixedWidthVisible) {
        QTOpacitySlider qTOpacitySlider;
        CurvedDialer curvedDialer;
        setupViewPosition();
        if (changeSizeAngle && (curvedDialer = this.mSizeView) != null) {
            curvedDialer.setAngleRange((opacityVisible ? this.mHalfSizeAngle : this.mDefaultSizeAngle).x, (opacityVisible ? this.mHalfSizeAngle : this.mDefaultSizeAngle).y);
        }
        QTOpacitySlider qTOpacitySlider2 = this.mOpacityView;
        if ((qTOpacitySlider2 != null && qTOpacitySlider2.getVisibility() == 0) != opacityVisible && (qTOpacitySlider = this.mOpacityView) != null) {
            qTOpacitySlider.setVisibility(opacityVisible ? 0 : 8);
        }
        this.mColorItem.setVisibility(0);
    }

    public final void changeAttributeSet(int attributeSet) {
        AbstractC14516b.m15114b(this.mAttributeSet, attributeSet, "changeAttributeSet() ", " -> ", TAG);
        int i = this.mAttributeSet;
        if (attributeSet == i) {
            return;
        }
        updateLayout(needToChangeSizeAngle(i, attributeSet), isSupportedAttribute(attributeSet, 2), isSupportedAttribute(attributeSet, 4));
        this.mAttributeSet = attributeSet;
    }

    public final void close() {
        QTOpacitySlider qTOpacitySlider = this.mOpacityView;
        if (qTOpacitySlider != null) {
            qTOpacitySlider.close();
        }
        this.mOpacityView = null;
        CurvedDialer curvedDialer = this.mSizeView;
        if (curvedDialer != null) {
            curvedDialer.close();
        }
        this.mSizeView = null;
        this.mFixedWidthView.close();
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
        CurvedDialer curvedDialer = this.mSizeView;
        if (curvedDialer != null && curvedDialer.isRawPointInView(rawX, rawY)) {
            return true;
        }
        QTOpacitySlider qTOpacitySlider = this.mOpacityView;
        return qTOpacitySlider != null && qTOpacitySlider.getVisibility() == 0 && qTOpacitySlider.isRawPointInView(rawX, rawY);
    }

    public final void setColor(int color) {
        this.mColor = color;
        this.mColorItem.setColor(color);
        setItemAccessibility(this.mColorItem, C9086R.string.pen_string_pen_color);
        if (!isSupportedAttribute(2)) {
            CurvedDialer curvedDialer = this.mSizeView;
            if (curvedDialer != null) {
                curvedDialer.setColor(color);
                return;
            }
            return;
        }
        this.mOpacity = Color.alpha(color);
        QTOpacitySlider qTOpacitySlider = this.mOpacityView;
        if (qTOpacitySlider != null) {
            qTOpacitySlider.setColor(color);
        }
        CurvedDialer curvedDialer2 = this.mSizeView;
        if (curvedDialer2 != null) {
            curvedDialer2.setColor(color | (-16777216));
        }
    }

    public final void setDataChangedListener(@Nullable OnDataChangedListener listener) {
        this.mDataChangedListener = listener;
    }

    public final boolean setFixedWidth(boolean isFixedWidth) {
        if (!isSupportedAttribute(4)) {
            return false;
        }
        AbstractC8014b.m7224z("setPenWidth() isFixedWidth=", TAG, isFixedWidth);
        this.mIsFixedWidth = isFixedWidth;
        this.mFixedWidthView.setPenWidth(isFixedWidth, false);
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
        CurvedDialer curvedDialer = this.mSizeView;
        if (curvedDialer != null) {
            CurvedDialer.setValue$default(curvedDialer, sizeLevel, 0.0f, 2, null);
        }
        return true;
    }

    public final void setVisibility(int pVisibility, boolean isAnimate) {
        CurvedDialer curvedDialer;
        QTOpacitySlider qTOpacitySlider;
        boolean zIsSupportedAttribute = isSupportedAttribute(2);
        boolean zIsSupportedAttribute2 = isSupportedAttribute(1);
        if ((getVisibility() != 0 && pVisibility != 0) || !isAnimate) {
            setVisibility(pVisibility);
            return;
        }
        setVisibility(0);
        if (zIsSupportedAttribute && (qTOpacitySlider = this.mOpacityView) != null) {
            qTOpacitySlider.startAnimation(pVisibility == 0);
        }
        if (zIsSupportedAttribute2 && (curvedDialer = this.mSizeView) != null) {
            curvedDialer.startVisibilityAnimation(pVisibility == 0);
        }
        startFixedWidthVisibilityAnimation(pVisibility == 0);
    }

    private final boolean isSupportedAttribute(int attribute) {
        return isSupportedAttribute(this.mAttributeSet, attribute);
    }
}
