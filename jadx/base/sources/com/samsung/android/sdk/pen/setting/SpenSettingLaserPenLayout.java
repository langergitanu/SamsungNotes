package com.samsung.android.sdk.pen.setting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.transition.ChangeBounds;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.util.Log;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.collection.AbstractC0622a;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.carousel.RunnableC4617a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.SpenSettingUILaserPenInfo;
import com.samsung.android.sdk.pen.setting.SpenColorControl;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenColorPaletteLayout;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenHSVColor;
import com.samsung.android.sdk.pen.setting.common.SpenShowButtonShapeText;
import com.samsung.android.sdk.pen.setting.laserpen.SpenLaserColorOptionLayout;
import com.samsung.android.sdk.pen.setting.laserpen.SpenLaserTypeLayout;
import com.samsung.android.sdk.pen.setting.laserpen.SpenSettingLaserPenManager;
import com.samsung.android.sdk.pen.setting.pencommon.SpenColorSettingInfo;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilAnimation;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilText;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;
import p043J2.ViewOnClickListenerC0157a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 Q2\u00020\u0001:\u0003QRSBI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\b\u0010%\u001a\u00020&H\u0016J\u000e\u0010+\u001a\u00020&2\u0006\u0010'\u001a\u00020(J\u0010\u0010,\u001a\u00020&2\b\u0010-\u001a\u0004\u0018\u00010.J\u0010\u0010/\u001a\u00020&2\b\u0010-\u001a\u0004\u0018\u00010\"J\u0018\u00100\u001a\u00020&2\u0006\u00101\u001a\u0002022\b\u0010-\u001a\u0004\u0018\u00010$J\u000e\u00103\u001a\u00020&2\u0006\u00101\u001a\u000202J\u0010\u00104\u001a\u00020&2\u0006\u00105\u001a\u00020\u000eH\u0016JB\u00106\u001a\u00020&2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u00107\u001a\u00020&2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0018\u00108\u001a\u00020&2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00109\u001a\u00020\u0005H\u0002J\u0018\u0010:\u001a\u00020&2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00109\u001a\u00020\u0005H\u0002J\u0018\u0010;\u001a\u00020&2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00109\u001a\u00020\u0005H\u0002J\u0010\u0010<\u001a\u00020&2\u0006\u0010=\u001a\u00020\u000eH\u0002J\u0018\u0010>\u001a\u00020&2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00109\u001a\u00020\u0005H\u0002J\u0010\u0010?\u001a\u00020&2\u0006\u0010@\u001a\u00020AH\u0002J\u0010\u0010B\u001a\u00020&2\u0006\u0010C\u001a\u00020\bH\u0002J\u0018\u0010D\u001a\u00020&2\u0006\u0010E\u001a\u00020\b2\u0006\u0010F\u001a\u00020\u000eH\u0002J\u0014\u0010G\u001a\u00020\b2\n\u0010H\u001a\u00020I\"\u00020\bH\u0002J,\u0010J\u001a\u00020&2\u0006\u0010K\u001a\u00020\u001c2\u0006\u0010L\u001a\u00020\b2\b\b\u0002\u0010F\u001a\u00020\u000e2\b\b\u0002\u0010M\u001a\u00020\u000eH\u0002J\u0010\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020\u000eH\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010'\u001a\u00020(8F¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006T"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenSettingLaserPenLayout;", "Lcom/samsung/android/sdk/pen/setting/SpenColorControlPopupLayout;", "context", "Landroid/content/Context;", "canvasLayout", "Landroid/view/ViewGroup;", "paletteList", "", "", "recentList", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenHSVColor;", "colorSettingInfo", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenColorSettingInfo;", "mIsSupportEyedropper", "", "<init>", "(Landroid/content/Context;Landroid/view/ViewGroup;Ljava/util/List;Ljava/util/List;Lcom/samsung/android/sdk/pen/setting/pencommon/SpenColorSettingInfo;Z)V", "mLaserPenManager", "Lcom/samsung/android/sdk/pen/setting/laserpen/SpenSettingLaserPenManager;", "mColorView", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenColorPaletteLayout;", "mTypeView", "Lcom/samsung/android/sdk/pen/setting/laserpen/SpenLaserTypeLayout;", "mColorOptionView", "Lcom/samsung/android/sdk/pen/setting/laserpen/SpenLaserColorOptionLayout;", "mContentBody", "Landroid/widget/LinearLayout;", "mBottomDivider", "Landroid/view/View;", "mBottomLayout", "mBottomText", "Landroid/widget/TextView;", "mColorMagin", "mGSIMLoggingListener", "Lcom/samsung/android/sdk/pen/setting/SpenSettingLaserPenLayout$LoggingListener;", "mBottomButtonClickListener", "Landroid/view/View$OnClickListener;", "close", "", "info", "Lcom/samsung/android/sdk/pen/SpenSettingUILaserPenInfo;", "getInfo", "()Lcom/samsung/android/sdk/pen/SpenSettingUILaserPenInfo;", "setInfo", "setLaserPenInfoChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/setting/SpenSettingLaserPenLayout$LaserPenInfoChangedListener;", "setLoggingListener", "setActionButton", "text", "", "setActionButtonText", "setEyedropperEnabled", "enabled", "construct", "initView", "initTypeView", "parent", "initColorOptionView", "initColorView", "adjustColorTopMargin", "hasMargin", "initBottomView", "initShowButtonTextShape", "buttonShapeText", "Lcom/samsung/android/sdk/pen/setting/common/SpenShowButtonShapeText;", "setContentBottomPadding", "bottomPadding", "updateView", "updateInfo", "needAnimation", "getVisibleCount", "visibilities", "", "setViewVisibility", "targetView", "visibility", "needChangeBounds", "getTransition", "Landroid/transition/TransitionSet;", "isShow", "Companion", "LaserPenInfoChangedListener", "LoggingListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"LongLogTag", "ViewConstructor"})
public final class SpenSettingLaserPenLayout extends SpenColorControlPopupLayout {
    private static final long LAYOUT_CHANGE_DELAY = 150;
    private static final long LAYOUT_CHANGE_DURATION = 333;

    @NotNull
    private static final String TAG = "SpenSettingLaserPenLayout";
    private static final int UPDATE_ALL = 7;
    private static final int UPDATE_COLOR = 2;
    private static final int UPDATE_COLOR_OPTION = 4;
    private static final int UPDATE_NONE = 0;
    private static final int UPDATE_TYPE = 1;

    @Nullable
    private View.OnClickListener mBottomButtonClickListener;

    @Nullable
    private View mBottomDivider;

    @Nullable
    private View mBottomLayout;

    @Nullable
    private TextView mBottomText;
    private int mColorMagin;
    private SpenLaserColorOptionLayout mColorOptionView;
    private SpenColorPaletteLayout mColorView;
    private LinearLayout mContentBody;

    @Nullable
    private LoggingListener mGSIMLoggingListener;
    private boolean mIsSupportEyedropper;
    private SpenSettingLaserPenManager mLaserPenManager;
    private SpenLaserTypeLayout mTypeView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenSettingLaserPenLayout$LaserPenInfoChangedListener;", "Lcom/samsung/android/sdk/pen/setting/laserpen/SpenSettingLaserPenManager$LaserPenInfoChangedListener;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface LaserPenInfoChangedListener extends SpenSettingLaserPenManager.LaserPenInfoChangedListener {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenSettingLaserPenLayout$LoggingListener;", "Lcom/samsung/android/sdk/pen/setting/SpenColorSAListener;", "onClosed", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface LoggingListener extends SpenColorSAListener {
        void onClosed();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenSettingLaserPenLayout(@NotNull Context context, @Nullable ViewGroup viewGroup, @Nullable List<Integer> list, @Nullable List<SpenHSVColor> list2, @NotNull SpenColorSettingInfo colorSettingInfo, boolean z) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(colorSettingInfo, "colorSettingInfo");
        this.mIsSupportEyedropper = z;
        construct(context, viewGroup, list, list2, colorSettingInfo);
    }

    private final void adjustColorTopMargin(boolean hasMargin) {
        SpenColorPaletteLayout spenColorPaletteLayout = this.mColorView;
        SpenColorPaletteLayout spenColorPaletteLayout2 = null;
        if (spenColorPaletteLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorView");
            spenColorPaletteLayout = null;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) spenColorPaletteLayout.getLayoutParams();
        if (layoutParams != null) {
            int i = hasMargin ? this.mColorMagin : 0;
            if (layoutParams.topMargin != i) {
                layoutParams.topMargin = i;
                layoutParams.bottomMargin = i;
                SpenColorPaletteLayout spenColorPaletteLayout3 = this.mColorView;
                if (spenColorPaletteLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mColorView");
                } else {
                    spenColorPaletteLayout2 = spenColorPaletteLayout3;
                }
                spenColorPaletteLayout2.setLayoutParams(layoutParams);
            }
        }
    }

    private final void construct(Context context, ViewGroup canvasLayout, List<Integer> paletteList, List<SpenHSVColor> recentList, SpenColorSettingInfo colorSettingInfo) {
        Log.i(TAG, "construct() ");
        this.mLaserPenManager = new SpenSettingLaserPenManager();
        initView(context);
        SpenColorPaletteLayout spenColorPaletteLayout = this.mColorView;
        if (spenColorPaletteLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorView");
            spenColorPaletteLayout = null;
        }
        initColorControl(context, canvasLayout, spenColorPaletteLayout, this.mIsSupportEyedropper, paletteList, recentList, colorSettingInfo);
        setOnColorChangedListener$SDK_fullRelease(new SpenColorControl.OnColorChangeListener() { // from class: com.samsung.android.sdk.pen.setting.SpenSettingLaserPenLayout.construct.1
            @Override // com.samsung.android.sdk.pen.setting.SpenPaletteColorControl.OnColorChangeListener
            public void onColorChanged(int info, float[] hsvColor, boolean maintainAlpha) {
                Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
                float f = hsvColor[0];
                Log.i(SpenSettingLaserPenLayout.TAG, AbstractC1038a.m1216q(AbstractC2322a.m1628r("SpenColorControl.onColorChanged() info=", info, " color[", f, SQLKeyword.COMMA), hsvColor[1], SQLKeyword.COMMA, hsvColor[2], "]"));
                SpenSettingLaserPenManager spenSettingLaserPenManager = SpenSettingLaserPenLayout.this.mLaserPenManager;
                if (spenSettingLaserPenManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLaserPenManager");
                    spenSettingLaserPenManager = null;
                }
                spenSettingLaserPenManager.changeColor(info, hsvColor, maintainAlpha, true);
            }
        });
    }

    private final TransitionSet getTransition(boolean isShow) {
        ChangeBounds changeBounds = new ChangeBounds();
        changeBounds.setDuration(LAYOUT_CHANGE_DURATION);
        changeBounds.setInterpolator(SpenSettingUtilAnimation.getInterpolator(3));
        if (!isShow) {
            changeBounds.setStartDelay(150L);
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.setOrdering(0);
        transitionSet.addTransition(changeBounds);
        return transitionSet;
    }

    private final int getVisibleCount(int... visibilities) {
        int i = 0;
        for (int i2 : visibilities) {
            i += i2 == 0 ? 1 : 0;
        }
        return i;
    }

    private final void initBottomView(Context context, ViewGroup parent) {
        if (this.mBottomLayout != null) {
            Log.i(TAG, "already initialized");
            return;
        }
        View.inflate(context, C7932R.layout.setting_laser_bottom_layout, parent);
        this.mBottomDivider = parent.findViewById(C7932R.id.setting_laser_bottom_divider);
        View viewFindViewById = parent.findViewById(C7932R.id.setting_laser_bottom_layout);
        this.mBottomLayout = viewFindViewById;
        if (viewFindViewById != null) {
            viewFindViewById.post(new RunnableC4617a(this, 18));
        }
        TextView textView = (TextView) parent.findViewById(C7932R.id.setting_laser_bottom_text);
        this.mBottomText = textView;
        if (textView != null) {
            textView.setOnClickListener(this.mBottomButtonClickListener);
            initShowButtonTextShape((SpenShowButtonShapeText) textView);
        }
        setContentBottomPadding(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initBottomView$lambda$3(SpenSettingLaserPenLayout spenSettingLaserPenLayout) {
        View view = spenSettingLaserPenLayout.mBottomLayout;
        if (view != null) {
            view.setTouchDelegate(new TouchDelegate(new Rect(0, 0, view.getWidth(), view.getHeight()), spenSettingLaserPenLayout.mBottomText));
        }
    }

    private final void initColorOptionView(Context context, ViewGroup parent) {
        SpenLaserColorOptionLayout spenLaserColorOptionLayout = new SpenLaserColorOptionLayout(context);
        this.mColorOptionView = spenLaserColorOptionLayout;
        parent.addView(spenLaserColorOptionLayout);
        SpenLaserColorOptionLayout spenLaserColorOptionLayout2 = this.mColorOptionView;
        if (spenLaserColorOptionLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorOptionView");
            spenLaserColorOptionLayout2 = null;
        }
        spenLaserColorOptionLayout2.setColorOptionChangedListener(new SpenLaserColorOptionLayout.OnColorOptionChangedListener() { // from class: com.samsung.android.sdk.pen.setting.SpenSettingLaserPenLayout.initColorOptionView.1
            @Override // com.samsung.android.sdk.pen.setting.laserpen.SpenLaserColorOptionLayout.OnColorOptionChangedListener
            public void onColorOptionChanged(int type) {
                SpenSettingLaserPenManager spenSettingLaserPenManager = SpenSettingLaserPenLayout.this.mLaserPenManager;
                if (spenSettingLaserPenManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLaserPenManager");
                    spenSettingLaserPenManager = null;
                }
                spenSettingLaserPenManager.changeColorOption(type);
                SpenSettingLaserPenLayout.this.updateView(0, true);
            }
        });
    }

    private final void initColorView(Context context, ViewGroup parent) {
        SpenColorPaletteLayout spenColorPaletteLayout = null;
        this.mColorView = new SpenColorPaletteLayout(context, null, this.mIsSupportEyedropper);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        SpenColorPaletteLayout spenColorPaletteLayout2 = this.mColorView;
        if (spenColorPaletteLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorView");
        } else {
            spenColorPaletteLayout = spenColorPaletteLayout2;
        }
        parent.addView(spenColorPaletteLayout, layoutParams);
    }

    private final void initShowButtonTextShape(SpenShowButtonShapeText buttonShapeText) {
        Context context = buttonShapeText.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        SpenSettingUtilText.setDefaultButtonTextStyle(context, buttonShapeText);
        SpenSettingUtilText.applyUpToLargeLevel(buttonShapeText.getContext(), 18.0f, buttonShapeText);
        buttonShapeText.setButtonShapeEnabled(true);
    }

    private final void initTypeView(Context context, ViewGroup parent) {
        SpenLaserTypeLayout spenLaserTypeLayout = new SpenLaserTypeLayout(context);
        this.mTypeView = spenLaserTypeLayout;
        parent.addView(spenLaserTypeLayout);
        SpenLaserTypeLayout spenLaserTypeLayout2 = this.mTypeView;
        if (spenLaserTypeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTypeView");
            spenLaserTypeLayout2 = null;
        }
        spenLaserTypeLayout2.setLaserTypeChangedListener(new SpenLaserTypeLayout.OnLaserTypeChangedListener() { // from class: com.samsung.android.sdk.pen.setting.SpenSettingLaserPenLayout.initTypeView.1
            @Override // com.samsung.android.sdk.pen.setting.laserpen.SpenLaserTypeLayout.OnLaserTypeChangedListener
            public void onLaserTypeChanged(SpenLaserTypeLayout.LaserPointerUIType uiType, int type, boolean fillInside) {
                Intrinsics.checkNotNullParameter(uiType, "uiType");
                Log.i(SpenSettingLaserPenLayout.TAG, "onLaserTypeChanged() uiType=" + uiType);
                SpenSettingLaserPenManager spenSettingLaserPenManager = SpenSettingLaserPenLayout.this.mLaserPenManager;
                if (spenSettingLaserPenManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLaserPenManager");
                    spenSettingLaserPenManager = null;
                }
                spenSettingLaserPenManager.changeTypeAndFillInside(type, fillInside);
                SpenSettingLaserPenLayout.this.updateView(0, true);
            }
        });
    }

    private final void initView(Context context) {
        Resources resources = context.getResources();
        this.mColorMagin = resources.getDimensionPixelSize(C7932R.dimen.setting_laser_pen_layout_palette_top_margin);
        setTitleText(C7932R.string.pen_string_laser_pointer);
        String string = resources.getString(C7932R.string.pen_string_close_any, resources.getString(C7932R.string.pen_string_laser_pointer_settings));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        setCloseButtonDescription(string);
        setCloseButtonInfo(new ViewOnClickListenerC0157a(this, 22));
        LinearLayout linearLayout = new LinearLayout(context);
        this.mContentBody = linearLayout;
        linearLayout.setOrientation(1);
        LinearLayout linearLayout2 = this.mContentBody;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentBody");
            linearLayout2 = null;
        }
        setContentView(linearLayout2);
        LinearLayout linearLayout3 = this.mContentBody;
        if (linearLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentBody");
            linearLayout3 = null;
        }
        initTypeView(context, linearLayout3);
        LinearLayout linearLayout4 = this.mContentBody;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentBody");
            linearLayout4 = null;
        }
        initColorOptionView(context, linearLayout4);
        LinearLayout linearLayout5 = this.mContentBody;
        if (linearLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentBody");
            linearLayout5 = null;
        }
        initColorView(context, linearLayout5);
        setContentBottomPadding(resources.getDimensionPixelSize(C7932R.dimen.setting_laser_pen_layout_bottom_padding));
        this.mBottomText = null;
        this.mBottomDivider = null;
        this.mBottomLayout = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(SpenSettingLaserPenLayout spenSettingLaserPenLayout, View view) {
        spenSettingLaserPenLayout.hideAnimation(null);
        LoggingListener loggingListener = spenSettingLaserPenLayout.mGSIMLoggingListener;
        if (loggingListener != null) {
            loggingListener.onClosed();
        }
    }

    private final void setContentBottomPadding(int bottomPadding) {
        LinearLayout linearLayout = this.mContentBody;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentBody");
            linearLayout = null;
        }
        linearLayout.setPadding(linearLayout.getPaddingLeft(), linearLayout.getPaddingTop(), linearLayout.getPaddingRight(), bottomPadding);
    }

    private final void setViewVisibility(View targetView, int visibility, boolean needAnimation, boolean needChangeBounds) {
        Animation animationLoadAnimation;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(targetView.getVisibility(), visibility, "setViewVisibility() (", " -> ", "] animation=");
        sbM1173s.append(needAnimation);
        Log.i(TAG, sbM1173s.toString());
        if (targetView.getVisibility() == visibility) {
            return;
        }
        targetView.setVisibility(visibility);
        if (needAnimation) {
            if (needChangeBounds) {
                TransitionManager.beginDelayedTransition(this, getTransition(visibility == 0));
            }
            if (visibility == 8) {
                animationLoadAnimation = AnimationUtils.loadAnimation(getContext(), C7932R.anim.spen_seekbar_scale_down);
            } else {
                animationLoadAnimation = AnimationUtils.loadAnimation(getContext(), C7932R.anim.spen_seekbar_scale_up);
                animationLoadAnimation.setStartOffset(150L);
            }
            targetView.startAnimation(animationLoadAnimation);
        }
    }

    public static /* synthetic */ void setViewVisibility$default(SpenSettingLaserPenLayout spenSettingLaserPenLayout, View view, int i, boolean z, boolean z2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        if ((i2 & 8) != 0) {
            z2 = false;
        }
        spenSettingLaserPenLayout.setViewVisibility(view, i, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateView(int updateInfo, boolean needAnimation) {
        int i;
        int i2;
        SpenSettingLaserPenManager spenSettingLaserPenManager = this.mLaserPenManager;
        SpenColorPaletteLayout spenColorPaletteLayout = null;
        if (spenSettingLaserPenManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLaserPenManager");
            spenSettingLaserPenManager = null;
        }
        SpenSettingUILaserPenInfo info = spenSettingLaserPenManager.getInfo();
        if ((updateInfo & 1) == 1) {
            SpenLaserTypeLayout spenLaserTypeLayout = this.mTypeView;
            if (spenLaserTypeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTypeView");
                spenLaserTypeLayout = null;
            }
            spenLaserTypeLayout.setType(info.type, info.fillInside);
        }
        if ((updateInfo & 2) == 2) {
            SpenColorPaletteLayout spenColorPaletteLayout2 = this.mColorView;
            if (spenColorPaletteLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mColorView");
                spenColorPaletteLayout2 = null;
            }
            spenColorPaletteLayout2.setColor(info.colorUIInfo, info.hsvColor, false);
        }
        if ((updateInfo & 4) == 4) {
            SpenLaserColorOptionLayout spenLaserColorOptionLayout = this.mColorOptionView;
            if (spenLaserColorOptionLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mColorOptionView");
                spenLaserColorOptionLayout = null;
            }
            spenLaserColorOptionLayout.setColorOption(info.colorOption);
        }
        if (info.type == 0) {
            i2 = 8;
            i = 0;
        } else if (info.colorOption == 1) {
            i = 8;
            i2 = 0;
        } else {
            i = 0;
            i2 = 0;
        }
        if (i == 0) {
            adjustColorTopMargin(i2 == 8);
        }
        SpenLaserColorOptionLayout spenLaserColorOptionLayout2 = this.mColorOptionView;
        if (spenLaserColorOptionLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorOptionView");
            spenLaserColorOptionLayout2 = null;
        }
        int visibility = spenLaserColorOptionLayout2.getVisibility();
        SpenColorPaletteLayout spenColorPaletteLayout3 = this.mColorView;
        if (spenColorPaletteLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorView");
            spenColorPaletteLayout3 = null;
        }
        int visibleCount = getVisibleCount(visibility, spenColorPaletteLayout3.getVisibility());
        int visibleCount2 = getVisibleCount(i2, i);
        SpenLaserColorOptionLayout spenLaserColorOptionLayout3 = this.mColorOptionView;
        if (spenLaserColorOptionLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorOptionView");
            spenLaserColorOptionLayout3 = null;
        }
        setViewVisibility(spenLaserColorOptionLayout3, i2, needAnimation, visibleCount != visibleCount2);
        SpenColorPaletteLayout spenColorPaletteLayout4 = this.mColorView;
        if (spenColorPaletteLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorView");
        } else {
            spenColorPaletteLayout = spenColorPaletteLayout4;
        }
        setViewVisibility(spenColorPaletteLayout, i, needAnimation, visibleCount != visibleCount2);
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenColorControlPopupLayout, com.samsung.android.sdk.pen.setting.SpenPopupLayout
    public void close() {
        Log.i(TAG, "close()");
        super.close();
        SpenLaserTypeLayout spenLaserTypeLayout = this.mTypeView;
        SpenColorPaletteLayout spenColorPaletteLayout = null;
        if (spenLaserTypeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTypeView");
            spenLaserTypeLayout = null;
        }
        spenLaserTypeLayout.close();
        SpenColorPaletteLayout spenColorPaletteLayout2 = this.mColorView;
        if (spenColorPaletteLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorView");
        } else {
            spenColorPaletteLayout = spenColorPaletteLayout2;
        }
        spenColorPaletteLayout.close();
    }

    @NotNull
    public final SpenSettingUILaserPenInfo getInfo() {
        Log.i(TAG, "getInfo()");
        SpenSettingLaserPenManager spenSettingLaserPenManager = this.mLaserPenManager;
        if (spenSettingLaserPenManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLaserPenManager");
            spenSettingLaserPenManager = null;
        }
        return spenSettingLaserPenManager.getInfo();
    }

    public final void setActionButton(@NotNull CharSequence text, @Nullable View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(text, "text");
        this.mBottomButtonClickListener = listener;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        LinearLayout linearLayout = this.mContentBody;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentBody");
            linearLayout = null;
        }
        initBottomView(context, linearLayout);
        setActionButtonText(text);
    }

    public final void setActionButtonText(@NotNull CharSequence text) {
        Intrinsics.checkNotNullParameter(text, "text");
        TextView textView = this.mBottomText;
        if (textView != null) {
            textView.setText(text);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenColorControlPopupLayout
    public void setEyedropperEnabled(boolean enabled) {
        AbstractC6670b.m4758s("setEyedropperEnabled() ", " -> ", TAG, this.mIsSupportEyedropper, enabled);
        if (this.mIsSupportEyedropper == enabled) {
            return;
        }
        this.mIsSupportEyedropper = enabled;
        super.setEyedropperEnabled(enabled);
        SpenColorPaletteLayout spenColorPaletteLayout = this.mColorView;
        if (spenColorPaletteLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorView");
            spenColorPaletteLayout = null;
        }
        spenColorPaletteLayout.setEyedropperEnabled(enabled);
    }

    public final void setInfo(@NotNull SpenSettingUILaserPenInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        int i = info.type;
        int i2 = info.colorOption;
        boolean z = info.fillInside;
        int i4 = info.colorUIInfo;
        int i5 = info.color;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "setInfo() type=", " colorOption=", ", fillInside=");
        sbM1173s.append(z);
        sbM1173s.append(", colorUIInfo=");
        sbM1173s.append(i4);
        sbM1173s.append(", color=");
        AbstractC11014a.m12329n(i5, "))", TAG, sbM1173s);
        float f = info.blurSize;
        float f4 = info.strokeSize;
        float f5 = info.insideRatio;
        int i6 = info.waitingTime;
        int i7 = info.fadeOutTime;
        StringBuilder sbM1176v = AbstractC0622a.m1176v("setInfo() blurSize=", f, ", strokeSize=", f4, ", insideRatio=");
        sbM1176v.append(f5);
        sbM1176v.append(", waitingTime=");
        sbM1176v.append(i6);
        sbM1176v.append(", fadeoutTime=");
        AbstractC0000a.m26w(sbM1176v, TAG, i7);
        int i8 = info.rainbowDistance;
        int i9 = info.rainbowTime;
        AbstractC0000a.m26w(AbstractC0622a.m1173s(i8, i9, "setInfo() rainbowDistance=", ", rainbowTime=", ", rainbowEffectType="), TAG, info.rainbowEffectType);
        SpenSettingLaserPenManager spenSettingLaserPenManager = this.mLaserPenManager;
        if (spenSettingLaserPenManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLaserPenManager");
            spenSettingLaserPenManager = null;
        }
        if (spenSettingLaserPenManager.setInfo(info)) {
            updateView(7, false);
        }
    }

    public final void setLaserPenInfoChangedListener(@Nullable LaserPenInfoChangedListener listener) {
        Log.i(TAG, "setLaserPenInfoChangedListener()");
        SpenSettingLaserPenManager spenSettingLaserPenManager = this.mLaserPenManager;
        if (spenSettingLaserPenManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLaserPenManager");
            spenSettingLaserPenManager = null;
        }
        spenSettingLaserPenManager.setLaserPenInfoChangedListener(listener);
    }

    public final void setLoggingListener(@Nullable LoggingListener listener) {
        this.mGSIMLoggingListener = listener;
        setColorLogListener(listener);
    }
}
