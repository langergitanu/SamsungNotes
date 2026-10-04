package com.samsung.android.sdk.pen.setting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.SpenSettingPenInfo;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.setting.SpenMiniPatternControl;
import com.samsung.android.sdk.pen.setting.SpenMiniPenAttributeControl;
import com.samsung.android.sdk.pen.setting.SpenMiniPenControl;
import com.samsung.android.sdk.pen.setting.SpenPenMiniLayoutControl;
import com.samsung.android.sdk.pen.setting.SpenSettingPenMiniLayout;
import com.samsung.android.sdk.pen.setting.color.SpenColorThemeUtil;
import com.samsung.android.sdk.pen.setting.colorpalette.OnActionButtonListener;
import com.samsung.android.sdk.pen.setting.colorpalette.OnColorChangeListener;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenHSVColor;
import com.samsung.android.sdk.pen.setting.common.SpenLayoutConfig;
import com.samsung.android.sdk.pen.setting.handwriting.SpenPenAttrMiniLayout;
import com.samsung.android.sdk.pen.setting.handwriting.SpenSettingPenManager;
import com.samsung.android.sdk.pen.setting.pencommon.PenInfoChangedListener;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilOpacity;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\b\u0017\u0018\u0000 s2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0004stuvBC\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0012\u0010\u0013BK\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0010\u0014\u001a\u00020\n¢\u0006\u0004\b\u0012\u0010\u0015J\b\u00109\u001a\u00020:H\u0016J\u0018\u0010;\u001a\u00020:2\u000e\u0010<\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010\tH\u0016J\u0010\u0010>\u001a\n\u0012\u0004\u0012\u00020?\u0018\u00010\u0010H\u0002J\u0010\u0010@\u001a\u00020:2\u0006\u0010A\u001a\u00020=H\u0016J\n\u0010B\u001a\u0004\u0018\u00010=H\u0016J\u0012\u0010C\u001a\u00020:2\b\u0010D\u001a\u0004\u0018\u00010EH\u0016J\u0018\u0010F\u001a\u00020:2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0016J\u0010\u0010G\u001a\u00020:2\u0006\u0010H\u001a\u00020\nH\u0016J\u0012\u0010I\u001a\u00020:2\b\u0010D\u001a\u0004\u0018\u00010JH\u0016J\u0012\u0010K\u001a\u00020:2\b\u0010D\u001a\u0004\u0018\u00010LH\u0016J\u0010\u0010M\u001a\u00020:2\u0006\u0010N\u001a\u00020OH\u0016J\u0018\u0010P\u001a\u00020:2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\tH\u0016J\u0012\u0010Q\u001a\u00020:2\b\u0010D\u001a\u0004\u0018\u00010RH\u0016J\u0012\u0010S\u001a\u00020:2\b\u0010D\u001a\u0004\u0018\u00010TH\u0016J\u000e\u0010U\u001a\u00020:2\u0006\u0010V\u001a\u00020\nJ\u0010\u0010W\u001a\u00020:2\b\u0010D\u001a\u0004\u0018\u00010*J\u0018\u0010X\u001a\u00020\u000e2\u0006\u0010Y\u001a\u00020\n2\b\u0010N\u001a\u0004\u0018\u00010OJ\u000e\u0010Z\u001a\u00020\u000e2\u0006\u0010[\u001a\u00020\nJ\u0010\u0010\\\u001a\u00020:2\b\u0010D\u001a\u0004\u0018\u00010(J\u0010\u0010]\u001a\u00020:2\b\u0010D\u001a\u0004\u0018\u00010,J\u000e\u0010^\u001a\u00020:2\u0006\u0010_\u001a\u00020\u000eJ\u000e\u0010`\u001a\u00020:2\u0006\u0010a\u001a\u00020\nJ\u0010\u0010b\u001a\u00020:2\u0006\u0010\u0014\u001a\u00020\nH\u0016J\b\u0010c\u001a\u00020\nH\u0016J\u000e\u0010d\u001a\u00020:2\u0006\u0010e\u001a\u00020\u000eJB\u0010f\u001a\u00020:2\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0014\u001a\u00020\nH\u0002J<\u0010g\u001a\u00020:2\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\t2\u0006\u0010h\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\nH\u0002J\u0018\u0010Z\u001a\u00020\u000e2\u0006\u0010[\u001a\u00020\n2\u0006\u0010i\u001a\u00020\u000eH\u0002J\u0018\u0010j\u001a\u00020:2\u0006\u0010k\u001a\u00020\n2\u0006\u0010l\u001a\u00020\u000eH\u0002J\u001a\u0010m\u001a\u00020\u000e2\u0006\u0010n\u001a\u00020\n2\b\u0010N\u001a\u0004\u0018\u00010OH\u0002J\u0012\u0010o\u001a\u00020\u000e2\b\u0010p\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010q\u001a\u00020\u000e2\u0006\u0010r\u001a\u00020\nH\u0002R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u000202X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000206X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006w"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenSettingPenMiniLayout;", "Lcom/samsung/android/sdk/pen/setting/SpenPopupMiniLayout;", "Lcom/samsung/android/sdk/pen/setting/SpenPenSetting;", "Lcom/samsung/android/sdk/pen/setting/SpenPenSettingUI;", "Lcom/samsung/android/sdk/pen/setting/SpenPenFavoriteSettingUI;", "Lcom/samsung/android/sdk/pen/setting/common/SpenLayoutConfig;", "context", "Landroid/content/Context;", "paletteList", "", "", "recentList", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenHSVColor;", "isSupportEyedropper", "", "customizedPenList", "", "", "<init>", "(Landroid/content/Context;Ljava/util/List;Ljava/util/List;ZLjava/util/List;)V", "orientation", "(Landroid/content/Context;Ljava/util/List;Ljava/util/List;ZLjava/util/List;I)V", "mPenManager", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenSettingPenManager;", "mColorThemeUtil", "Lcom/samsung/android/sdk/pen/setting/color/SpenColorThemeUtil;", "mLayoutControl", "Lcom/samsung/android/sdk/pen/setting/SpenPenMiniLayoutControl;", "mIsSupportEyedropper", "mPenControl", "Lcom/samsung/android/sdk/pen/setting/SpenMiniPenControl;", "mAttributeControl", "Lcom/samsung/android/sdk/pen/setting/SpenMiniPenAttributeControl;", "mColorControl", "Lcom/samsung/android/sdk/pen/setting/SpenMiniColorControl;", "mPatternControl", "Lcom/samsung/android/sdk/pen/setting/SpenMiniPatternControl;", "mSliderLabelControl", "Lcom/samsung/android/sdk/pen/setting/SpenMiniSliderLabelControl;", "mChildViewModeChangedListener", "Lcom/samsung/android/sdk/pen/setting/SpenSettingPenMiniLayout$OnViewModeChangedListener;", "mButtonClickListener", "Lcom/samsung/android/sdk/pen/setting/SpenSettingPenMiniLayout$OnButtonClickListener;", "mSliderLabelListener", "Lcom/samsung/android/sdk/pen/setting/SpenSettingPenMiniLayout$OnSliderLabelListener;", "mPenDataChangedListener", "Lcom/samsung/android/sdk/pen/setting/SpenMiniPenControl$OnDataChangedListener;", "mPenAttrDataChangedListener", "Lcom/samsung/android/sdk/pen/setting/SpenMiniPenAttributeControl$OnDataChangedListener;", "mColorChangedListener", "Lcom/samsung/android/sdk/pen/setting/colorpalette/OnColorChangeListener;", "mPatternChangedListener", "Lcom/samsung/android/sdk/pen/setting/SpenMiniPatternControl$OnPatternChangedListener;", "mViewModeChangedListener", "Lcom/samsung/android/sdk/pen/setting/SpenPenMiniLayoutControl$OnViewModeChangedListener;", "mSliderListener", "Lcom/samsung/android/sdk/pen/setting/SpenMiniPenAttributeControl$OnSliderListener;", "close", "", "setPenInfoList", "uiPenInfoList", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "getThemePenInfoList", "Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;", "setInfo", "uiPenInfo", "getInfo", "setPenInfoChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/setting/pencommon/PenInfoChangedListener;", "setPalette", "setCurrentPalette", "paletteID", "setPaletteActionButtonListener", "Lcom/samsung/android/sdk/pen/setting/colorpalette/OnActionButtonListener;", "setPaletteActionListener", "Lcom/samsung/android/sdk/pen/setting/SpenPaletteActionListener;", "addRecentColor", "hsvColor", "", "setRecentColor", "setRecentColorChangedListener", "Lcom/samsung/android/sdk/pen/setting/SpenRecentColorChangedListener;", "setChangeViewModeButtonListener", "Landroid/view/View$OnClickListener;", "setColorTheme", "colorTheme", "setOnButtonClickListener", "setCurrentColor", "colorFrom", "setViewMode", "viewMode", "setViewModeChangedListener", "setSliderLabelListener", "setDisallowSliderLabel", "disallowSliderLabel", "setSliderLabelGravity", "gravity", "setLayoutOrientation", "getLayoutOrientation", "setEyedropperEnabled", "enabled", "construct", "initView", "makePatternView", "needAnimation", "updateView", "updateInfo", "needOpacityAnimation", "changeCurrentColor", "info", "changePen", "penName", "changeCurrentSize", "sizeLevel", "Companion", "OnViewModeChangedListener", "OnButtonClickListener", "OnSliderLabelListener", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"LongLogTag", "ViewConstructor"})
public class SpenSettingPenMiniLayout extends SpenPopupMiniLayout implements SpenPenSetting, SpenPenSettingUI, SpenPenFavoriteSettingUI, SpenLayoutConfig {
    public static final int COLOR_FROM_EYEDROPPER = 2;
    public static final int COLOR_FROM_NONE = 0;
    public static final int COLOR_FROM_PICKER = 1;

    @NotNull
    private static final String TAG = "SpenSettingPenMiniLayout";
    private static final int UPDATE_ALL = 63;
    private static final int UPDATE_COLOR = 4;
    private static final int UPDATE_OPACITY = 16;
    private static final int UPDATE_PATTERN = 8;
    private static final int UPDATE_PEN = 2;
    private static final int UPDATE_SIZE = 1;
    private static final int UPDATE_WIDTH = 32;
    public static final int VIEW_MODE_MINI_HOME = 1;
    public static final int VIEW_MODE_MINI_PEN_COLOR = 8;
    public static final int VIEW_MODE_MINI_PEN_SIZE = 4;
    public static final int VIEW_MODE_MINI_PEN_TYPE = 2;
    private SpenMiniPenAttributeControl mAttributeControl;

    @Nullable
    private OnButtonClickListener mButtonClickListener;

    @Nullable
    private OnViewModeChangedListener mChildViewModeChangedListener;

    @NotNull
    private final OnColorChangeListener mColorChangedListener;
    private SpenMiniColorControl mColorControl;

    @NotNull
    private SpenColorThemeUtil mColorThemeUtil;
    private boolean mIsSupportEyedropper;
    private SpenPenMiniLayoutControl mLayoutControl;

    @NotNull
    private final SpenMiniPatternControl.OnPatternChangedListener mPatternChangedListener;

    @Nullable
    private SpenMiniPatternControl mPatternControl;

    @NotNull
    private final SpenMiniPenAttributeControl.OnDataChangedListener mPenAttrDataChangedListener;
    private SpenMiniPenControl mPenControl;

    @NotNull
    private final SpenMiniPenControl.OnDataChangedListener mPenDataChangedListener;
    private SpenSettingPenManager mPenManager;
    private SpenMiniSliderLabelControl mSliderLabelControl;

    @Nullable
    private OnSliderLabelListener mSliderLabelListener;

    @NotNull
    private final SpenMiniPenAttributeControl.OnSliderListener mSliderListener;

    @NotNull
    private final SpenPenMiniLayoutControl.OnViewModeChangedListener mViewModeChangedListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenSettingPenMiniLayout$OnButtonClickListener;", "", "onCloseButtonClick", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnButtonClickListener {
        void onCloseButtonClick();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenSettingPenMiniLayout$OnSliderLabelListener;", "Lcom/samsung/android/sdk/pen/setting/SpenMiniPenAttributeControl$OnSliderListener;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnSliderLabelListener extends SpenMiniPenAttributeControl.OnSliderListener {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenSettingPenMiniLayout$OnViewModeChangedListener;", "Lcom/samsung/android/sdk/pen/setting/SpenPenMiniLayoutControl$OnViewModeChangedListener;", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnViewModeChangedListener extends SpenPenMiniLayoutControl.OnViewModeChangedListener {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenSettingPenMiniLayout(@NotNull Context context, @NotNull List<Integer> paletteList, @NotNull List<SpenHSVColor> recentList, boolean z, @NotNull List<String> customizedPenList) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(paletteList, "paletteList");
        Intrinsics.checkNotNullParameter(recentList, "recentList");
        Intrinsics.checkNotNullParameter(customizedPenList, "customizedPenList");
        this.mPenDataChangedListener = new SpenMiniPenControl.OnDataChangedListener() { // from class: com.samsung.android.sdk.pen.setting.SpenSettingPenMiniLayout$mPenDataChangedListener$1
            @Override // com.samsung.android.sdk.pen.setting.SpenMiniPenControl.OnDataChangedListener
            public void onPenChanged(String penName) {
                AbstractC6670b.m4756q("onPenChanged() penName=", penName, "SpenSettingPenMiniLayout");
                this.this$0.changePen(penName);
                this.this$0.updateView(63, true);
            }
        };
        this.mPenAttrDataChangedListener = new SpenMiniPenAttributeControl.OnDataChangedListener() { // from class: com.samsung.android.sdk.pen.setting.SpenSettingPenMiniLayout$mPenAttrDataChangedListener$1
            @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenAttrMiniLayout.OnDataChangedListener
            public void onAlphaChanged(int alpha) {
                SpenSettingPenManager spenSettingPenManager = this.this$0.mPenManager;
                SpenSettingPenManager spenSettingPenManager2 = null;
                if (spenSettingPenManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPenManager");
                    spenSettingPenManager = null;
                }
                SpenSettingUIPenInfo currentUIPenInfo = spenSettingPenManager.getCurrentUIPenInfo();
                if (currentUIPenInfo == null) {
                    return;
                }
                currentUIPenInfo.color = SpenSettingUtilOpacity.setCurrentAlpha(currentUIPenInfo.color, alpha);
                SpenSettingPenManager spenSettingPenManager3 = this.this$0.mPenManager;
                if (spenSettingPenManager3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPenManager");
                } else {
                    spenSettingPenManager2 = spenSettingPenManager3;
                }
                if (spenSettingPenManager2.setCurrentUIPenInfo(currentUIPenInfo)) {
                    this.this$0.updateView(3, false);
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenAttrMiniLayout.OnDataChangedListener
            public void onFixedWidthChanged(boolean isFixedWidth) {
                SpenSettingPenManager spenSettingPenManager = this.this$0.mPenManager;
                SpenSettingPenManager spenSettingPenManager2 = null;
                if (spenSettingPenManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPenManager");
                    spenSettingPenManager = null;
                }
                SpenSettingUIPenInfo currentUIPenInfo = spenSettingPenManager.getCurrentUIPenInfo();
                if (currentUIPenInfo == null) {
                    return;
                }
                currentUIPenInfo.isFixedWidth = isFixedWidth;
                SpenSettingPenManager spenSettingPenManager3 = this.this$0.mPenManager;
                if (spenSettingPenManager3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPenManager");
                } else {
                    spenSettingPenManager2 = spenSettingPenManager3;
                }
                if (spenSettingPenManager2.setCurrentUIPenInfo(currentUIPenInfo)) {
                    this.this$0.updateView(2, false);
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenAttrMiniLayout.OnDataChangedListener
            public void onSizeChanged(int sizeLevel) {
                if (this.this$0.changeCurrentSize(sizeLevel)) {
                    this.this$0.updateView(2, false);
                }
            }
        };
        this.mColorChangedListener = new OnColorChangeListener() { // from class: com.samsung.android.sdk.pen.setting.SpenSettingPenMiniLayout$mColorChangedListener$1
            @Override // com.samsung.android.sdk.pen.setting.colorpalette.OnColorChangeListener
            public void onColorChanged(int info, float[] hsvColor) {
                Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
                if (this.this$0.changeCurrentColor(info, hsvColor)) {
                    this.this$0.updateView(19, false);
                }
            }
        };
        this.mPatternChangedListener = new SpenMiniPatternControl.OnPatternChangedListener() { // from class: com.samsung.android.sdk.pen.setting.SpenSettingPenMiniLayout$mPatternChangedListener$1
            @Override // com.samsung.android.sdk.pen.setting.SpenPatternControl.OnPatternChangeListener
            public void onPatternChanged(String resName, float size) {
                Log.i("SpenSettingPenMiniLayout", "onPatternChanged() resourceName=[" + resName + "] size=" + size);
                SpenSettingPenManager spenSettingPenManager = this.this$0.mPenManager;
                SpenSettingPenManager spenSettingPenManager2 = null;
                if (spenSettingPenManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPenManager");
                    spenSettingPenManager = null;
                }
                SpenSettingUIPenInfo currentUIPenInfo = spenSettingPenManager.getCurrentUIPenInfo();
                if (currentUIPenInfo == null) {
                    return;
                }
                currentUIPenInfo.particleSize = size;
                SpenSettingPenManager spenSettingPenManager3 = this.this$0.mPenManager;
                if (spenSettingPenManager3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPenManager");
                } else {
                    spenSettingPenManager2 = spenSettingPenManager3;
                }
                if (spenSettingPenManager2.setCurrentUIPenInfo(currentUIPenInfo)) {
                    this.this$0.updateView(2, false);
                }
            }
        };
        this.mViewModeChangedListener = new SpenPenMiniLayoutControl.OnViewModeChangedListener() { // from class: com.samsung.android.sdk.pen.setting.SpenSettingPenMiniLayout$mViewModeChangedListener$1
            @Override // com.samsung.android.sdk.pen.setting.SpenPenMiniLayoutControl.OnViewModeChangedListener
            public void onViewModeChanged(int mode) {
                AbstractC2322a.m1631u(mode, "onViewModeChanged() mode=", "SpenSettingPenMiniLayout");
                SpenSettingPenMiniLayout.OnViewModeChangedListener onViewModeChangedListener = this.this$0.mChildViewModeChangedListener;
                if (onViewModeChangedListener != null) {
                    onViewModeChangedListener.onViewModeChanged(mode);
                }
            }
        };
        this.mSliderListener = new SpenMiniPenAttributeControl.OnSliderListener() { // from class: com.samsung.android.sdk.pen.setting.SpenSettingPenMiniLayout$mSliderListener$1
            @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenAttrMiniLayout.OnSliderListener
            public void onLabelChanged(String text) {
                Intrinsics.checkNotNullParameter(text, "text");
                SpenMiniSliderLabelControl spenMiniSliderLabelControl = this.this$0.mSliderLabelControl;
                if (spenMiniSliderLabelControl == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSliderLabelControl");
                    spenMiniSliderLabelControl = null;
                }
                spenMiniSliderLabelControl.onLabelChanged(text);
                SpenSettingPenMiniLayout.OnSliderLabelListener onSliderLabelListener = this.this$0.mSliderLabelListener;
                if (onSliderLabelListener != null) {
                    onSliderLabelListener.onLabelChanged(text);
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenAttrMiniLayout.OnSliderListener
            public void onLabelStateChanged(View slider, SpenPenAttrMiniLayout.OnSliderListener.LabelState state, String text) {
                Intrinsics.checkNotNullParameter(text, "text");
                SpenMiniSliderLabelControl spenMiniSliderLabelControl = this.this$0.mSliderLabelControl;
                if (spenMiniSliderLabelControl == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSliderLabelControl");
                    spenMiniSliderLabelControl = null;
                }
                spenMiniSliderLabelControl.onLabelStateChanged(slider, state, text);
                SpenSettingPenMiniLayout.OnSliderLabelListener onSliderLabelListener = this.this$0.mSliderLabelListener;
                if (onSliderLabelListener != null) {
                    onSliderLabelListener.onLabelStateChanged(slider, state, text);
                }
            }
        };
        this.mColorThemeUtil = new SpenColorThemeUtil(context);
        this.mIsSupportEyedropper = z;
        construct(context, paletteList, recentList, customizedPenList, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean changeCurrentColor(int info, float[] hsvColor) {
        if (hsvColor != null) {
            Log.i(TAG, AbstractC1038a.m1216q(AbstractC2322a.m1628r("updateColor info=", info, " color[", hsvColor[0], SQLKeyword.COMMA), hsvColor[1], SQLKeyword.COMMA, hsvColor[2], "]"));
            SpenSettingPenManager spenSettingPenManager = this.mPenManager;
            SpenSettingPenManager spenSettingPenManager2 = null;
            if (spenSettingPenManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenManager");
                spenSettingPenManager = null;
            }
            SpenSettingUIPenInfo currentUIPenInfo = spenSettingPenManager.getCurrentUIPenInfo();
            if (currentUIPenInfo != null) {
                currentUIPenInfo.colorUIInfo = info;
                float[] fArr = currentUIPenInfo.hsv;
                fArr[0] = hsvColor[0];
                fArr[1] = hsvColor[1];
                fArr[2] = hsvColor[2];
                currentUIPenInfo.color = SpenSettingUtilOpacity.setCurrentAlpha(SpenSettingUtil.HSVToColor(fArr), Color.alpha(currentUIPenInfo.color));
                SpenSettingPenManager spenSettingPenManager3 = this.mPenManager;
                if (spenSettingPenManager3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPenManager");
                } else {
                    spenSettingPenManager2 = spenSettingPenManager3;
                }
                return spenSettingPenManager2.setCurrentUIPenInfo(currentUIPenInfo);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean changeCurrentSize(int sizeLevel) {
        SpenSettingPenManager spenSettingPenManager = this.mPenManager;
        SpenSettingPenManager spenSettingPenManager2 = null;
        if (spenSettingPenManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenManager");
            spenSettingPenManager = null;
        }
        SpenSettingUIPenInfo currentUIPenInfo = spenSettingPenManager.getCurrentUIPenInfo();
        if (currentUIPenInfo == null) {
            return false;
        }
        currentUIPenInfo.sizeLevel = sizeLevel;
        SpenSettingPenManager spenSettingPenManager3 = this.mPenManager;
        if (spenSettingPenManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenManager");
        } else {
            spenSettingPenManager2 = spenSettingPenManager3;
        }
        return spenSettingPenManager2.setCurrentUIPenInfo(currentUIPenInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean changePen(String penName) {
        SpenSettingPenManager spenSettingPenManager = this.mPenManager;
        if (spenSettingPenManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenManager");
            spenSettingPenManager = null;
        }
        return spenSettingPenManager.setCurrentPen(penName);
    }

    private final void construct(Context context, List<Integer> paletteList, List<SpenHSVColor> recentList, List<String> customizedPenList, int orientation) {
        SpenSettingPenManager spenSettingPenManager = new SpenSettingPenManager(context, customizedPenList);
        this.mPenManager = spenSettingPenManager;
        boolean zContainsParticleSizePen = spenSettingPenManager.containsParticleSizePen();
        SpenSettingPenManager spenSettingPenManager2 = this.mPenManager;
        SpenMiniPenAttributeControl spenMiniPenAttributeControl = null;
        if (spenSettingPenManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenManager");
            spenSettingPenManager2 = null;
        }
        boolean zContainsAlphaChangeablePen = spenSettingPenManager2.containsAlphaChangeablePen();
        SpenSettingPenManager spenSettingPenManager3 = this.mPenManager;
        if (spenSettingPenManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenManager");
            spenSettingPenManager3 = null;
        }
        spenSettingPenManager3.setEnableAlphaChange(zContainsAlphaChangeablePen);
        initView(context, paletteList, recentList, zContainsParticleSizePen, orientation);
        SpenMiniSliderLabelControl spenMiniSliderLabelControl = new SpenMiniSliderLabelControl(context, this, orientation);
        this.mSliderLabelControl = spenMiniSliderLabelControl;
        spenMiniSliderLabelControl.setDisallowLabel(true);
        SpenMiniPenAttributeControl spenMiniPenAttributeControl2 = this.mAttributeControl;
        if (spenMiniPenAttributeControl2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAttributeControl");
        } else {
            spenMiniPenAttributeControl = spenMiniPenAttributeControl2;
        }
        spenMiniPenAttributeControl.setSliderListener(this.mSliderListener);
    }

    private final List<SpenSettingPenInfo> getThemePenInfoList() {
        SpenSettingPenManager spenSettingPenManager = this.mPenManager;
        if (spenSettingPenManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenManager");
            spenSettingPenManager = null;
        }
        List<SpenSettingPenInfo> penInfoList = spenSettingPenManager.getPenInfoList();
        if (this.mColorThemeUtil.getColorTheme() != 1) {
            return penInfoList;
        }
        ArrayList arrayList = new ArrayList();
        for (SpenSettingPenInfo spenSettingPenInfo : penInfoList) {
            SpenSettingPenInfo spenSettingPenInfo2 = new SpenSettingPenInfo(spenSettingPenInfo);
            spenSettingPenInfo2.color = this.mColorThemeUtil.getColor(spenSettingPenInfo.color);
            arrayList.add(spenSettingPenInfo2);
        }
        return arrayList;
    }

    private final void initView(Context context, List<Integer> paletteList, List<SpenHSVColor> recentList, boolean makePatternView, int orientation) {
        this.mLayoutControl = new SpenPenMiniLayoutControl(context, this, orientation);
        SpenMiniColorControl spenMiniColorControl = new SpenMiniColorControl(context);
        this.mColorControl = spenMiniColorControl;
        spenMiniColorControl.initView(this.mIsSupportEyedropper, paletteList);
        SpenMiniColorControl spenMiniColorControl2 = this.mColorControl;
        SpenPenMiniLayoutControl spenPenMiniLayoutControl = null;
        if (spenMiniColorControl2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorControl");
            spenMiniColorControl2 = null;
        }
        spenMiniColorControl2.setPalette(paletteList);
        SpenMiniColorControl spenMiniColorControl3 = this.mColorControl;
        if (spenMiniColorControl3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorControl");
            spenMiniColorControl3 = null;
        }
        spenMiniColorControl3.setRecentColor(recentList);
        SpenMiniColorControl spenMiniColorControl4 = this.mColorControl;
        if (spenMiniColorControl4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorControl");
            spenMiniColorControl4 = null;
        }
        spenMiniColorControl4.setOnColorChangeListener(this.mColorChangedListener);
        SpenMiniPenControl spenMiniPenControl = new SpenMiniPenControl();
        this.mPenControl = spenMiniPenControl;
        SpenSettingPenManager spenSettingPenManager = this.mPenManager;
        if (spenSettingPenManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenManager");
            spenSettingPenManager = null;
        }
        spenMiniPenControl.initView(context, spenSettingPenManager.getPenNameList());
        SpenMiniPenControl spenMiniPenControl2 = this.mPenControl;
        if (spenMiniPenControl2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenControl");
            spenMiniPenControl2 = null;
        }
        spenMiniPenControl2.setDataChangedListener(this.mPenDataChangedListener);
        SpenMiniPenAttributeControl spenMiniPenAttributeControl = new SpenMiniPenAttributeControl();
        this.mAttributeControl = spenMiniPenAttributeControl;
        spenMiniPenAttributeControl.initView(context);
        SpenMiniPenAttributeControl spenMiniPenAttributeControl2 = this.mAttributeControl;
        if (spenMiniPenAttributeControl2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAttributeControl");
            spenMiniPenAttributeControl2 = null;
        }
        spenMiniPenAttributeControl2.setDataChangedListener(this.mPenAttrDataChangedListener);
        if (makePatternView) {
            SpenMiniPatternControl spenMiniPatternControl = new SpenMiniPatternControl(context);
            this.mPatternControl = spenMiniPatternControl;
            spenMiniPatternControl.setOnPatternChangedListener(this.mPatternChangedListener);
        }
        SpenPenMiniLayoutControl spenPenMiniLayoutControl2 = this.mLayoutControl;
        if (spenPenMiniLayoutControl2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutControl");
            spenPenMiniLayoutControl2 = null;
        }
        SpenMiniPenControl spenMiniPenControl3 = this.mPenControl;
        if (spenMiniPenControl3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenControl");
            spenMiniPenControl3 = null;
        }
        SpenMiniPenAttributeControl spenMiniPenAttributeControl3 = this.mAttributeControl;
        if (spenMiniPenAttributeControl3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAttributeControl");
            spenMiniPenAttributeControl3 = null;
        }
        SpenMiniColorControl spenMiniColorControl5 = this.mColorControl;
        if (spenMiniColorControl5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorControl");
            spenMiniColorControl5 = null;
        }
        spenPenMiniLayoutControl2.setContent(spenMiniPenControl3, spenMiniPenAttributeControl3, spenMiniColorControl5, this.mPatternControl);
        SpenPenMiniLayoutControl spenPenMiniLayoutControl3 = this.mLayoutControl;
        if (spenPenMiniLayoutControl3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutControl");
            spenPenMiniLayoutControl3 = null;
        }
        spenPenMiniLayoutControl3.setOnViewModeChangedListener(this.mViewModeChangedListener);
        SpenPenMiniLayoutControl spenPenMiniLayoutControl4 = this.mLayoutControl;
        if (spenPenMiniLayoutControl4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutControl");
        } else {
            spenPenMiniLayoutControl = spenPenMiniLayoutControl4;
        }
        spenPenMiniLayoutControl.setOnButtonClickListener(new SpenPenMiniLayoutControl.OnButtonClickListener() { // from class: com.samsung.android.sdk.pen.setting.SpenSettingPenMiniLayout.initView.1
            @Override // com.samsung.android.sdk.pen.setting.SpenPenMiniLayoutControl.OnButtonClickListener
            public void onCloseButtonClicked() {
                OnButtonClickListener onButtonClickListener = SpenSettingPenMiniLayout.this.mButtonClickListener;
                if (onButtonClickListener != null) {
                    onButtonClickListener.onCloseButtonClick();
                }
            }
        });
        setViewMode(1, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateView(int updateInfo, boolean needOpacityAnimation) {
        boolean z;
        SpenMiniPenControl spenMiniPenControl;
        SpenMiniPatternControl spenMiniPatternControl;
        AbstractC2322a.m1631u(updateInfo, "updateView() targetChild=", TAG);
        SpenSettingPenManager spenSettingPenManager = this.mPenManager;
        SpenMiniPenAttributeControl spenMiniPenAttributeControl = null;
        if (spenSettingPenManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenManager");
            spenSettingPenManager = null;
        }
        SpenSettingUIPenInfo currentUIPenInfo = spenSettingPenManager.getCurrentUIPenInfo();
        if (currentUIPenInfo == null) {
            Log.i(TAG, "current info is invalid");
            return;
        }
        SpenSettingPenManager spenSettingPenManager2 = this.mPenManager;
        if (spenSettingPenManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenManager");
            spenSettingPenManager2 = null;
        }
        boolean zIsSupportAlphaChange = spenSettingPenManager2.isSupportAlphaChange(currentUIPenInfo.name);
        SpenSettingPenManager spenSettingPenManager3 = this.mPenManager;
        if (spenSettingPenManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenManager");
            spenSettingPenManager3 = null;
        }
        boolean zIsSupportFixedWidthChange = spenSettingPenManager3.isSupportFixedWidthChange(currentUIPenInfo.name);
        currentUIPenInfo.color = this.mColorThemeUtil.getColor(currentUIPenInfo.color);
        if ((updateInfo & 4) == 4) {
            Log.i(TAG, "updateView() -- COLOR");
            SpenMiniColorControl spenMiniColorControl = this.mColorControl;
            if (spenMiniColorControl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mColorControl");
                spenMiniColorControl = null;
            }
            spenMiniColorControl.setColor(currentUIPenInfo.colorUIInfo, currentUIPenInfo.hsv);
        }
        if (this.mPatternControl != null && (updateInfo & 8) == 8) {
            Log.i(TAG, "updateView() -- PATTERN");
            SpenSettingPenManager spenSettingPenManager4 = this.mPenManager;
            if (spenSettingPenManager4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenManager");
                spenSettingPenManager4 = null;
            }
            boolean zIsSupportParticleSize = spenSettingPenManager4.isSupportParticleSize(currentUIPenInfo.name);
            if (zIsSupportParticleSize && (spenMiniPatternControl = this.mPatternControl) != null) {
                spenMiniPatternControl.setPatternInfo(currentUIPenInfo.name, currentUIPenInfo.particleSize);
            }
            SpenPenMiniLayoutControl spenPenMiniLayoutControl = this.mLayoutControl;
            if (spenPenMiniLayoutControl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLayoutControl");
                spenPenMiniLayoutControl = null;
            }
            spenPenMiniLayoutControl.setPatternVisibility(zIsSupportParticleSize);
        }
        if ((updateInfo & 2) == 2) {
            Log.i(TAG, "updateView() -- PEN");
            SpenMiniPenControl spenMiniPenControl2 = this.mPenControl;
            if (spenMiniPenControl2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenControl");
                spenMiniPenControl = null;
            } else {
                spenMiniPenControl = spenMiniPenControl2;
            }
            spenMiniPenControl.setPenInfo(currentUIPenInfo.name, currentUIPenInfo.color, currentUIPenInfo.sizeLevel, currentUIPenInfo.particleSize, currentUIPenInfo.isFixedWidth);
        }
        boolean z2 = true;
        if ((updateInfo & 1) == 1) {
            Log.i(TAG, "updateView() -- SIZE");
            SpenMiniPenAttributeControl spenMiniPenAttributeControl2 = this.mAttributeControl;
            if (spenMiniPenAttributeControl2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAttributeControl");
                spenMiniPenAttributeControl2 = null;
            }
            spenMiniPenAttributeControl2.setSizeLevel(currentUIPenInfo.sizeLevel, currentUIPenInfo.color);
        }
        if ((updateInfo & 16) == 16) {
            Log.i(TAG, "updateView() -- OPACITY");
            int i = currentUIPenInfo.color;
            if (zIsSupportAlphaChange) {
                SpenMiniPenAttributeControl spenMiniPenAttributeControl3 = this.mAttributeControl;
                if (spenMiniPenAttributeControl3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAttributeControl");
                    spenMiniPenAttributeControl3 = null;
                }
                spenMiniPenAttributeControl3.setOpacity(i);
            }
            z = true;
        } else {
            z = false;
        }
        if ((updateInfo & 32) == 32) {
            Log.i(TAG, "updateView() -- WIDTH");
            if (zIsSupportFixedWidthChange) {
                SpenMiniPenAttributeControl spenMiniPenAttributeControl4 = this.mAttributeControl;
                if (spenMiniPenAttributeControl4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAttributeControl");
                    spenMiniPenAttributeControl4 = null;
                }
                spenMiniPenAttributeControl4.setPenWidth(currentUIPenInfo.name, currentUIPenInfo.isFixedWidth);
            }
        } else {
            z2 = z;
        }
        if (z2) {
            SpenMiniPenAttributeControl spenMiniPenAttributeControl5 = this.mAttributeControl;
            if (spenMiniPenAttributeControl5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAttributeControl");
            } else {
                spenMiniPenAttributeControl = spenMiniPenAttributeControl5;
            }
            spenMiniPenAttributeControl.setAttributeVisibility(zIsSupportAlphaChange, zIsSupportFixedWidthChange, needOpacityAnimation);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenSettingUI
    public void addRecentColor(@NotNull float[] hsvColor) {
        Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
        SpenMiniColorControl spenMiniColorControl = this.mColorControl;
        if (spenMiniColorControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorControl");
            spenMiniColorControl = null;
        }
        spenMiniColorControl.addRecentColor(hsvColor);
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPopupMiniLayout
    public void close() {
        SpenMiniSliderLabelControl spenMiniSliderLabelControl = this.mSliderLabelControl;
        SpenSettingPenManager spenSettingPenManager = null;
        if (spenMiniSliderLabelControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSliderLabelControl");
            spenMiniSliderLabelControl = null;
        }
        spenMiniSliderLabelControl.close();
        SpenMiniPenAttributeControl spenMiniPenAttributeControl = this.mAttributeControl;
        if (spenMiniPenAttributeControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAttributeControl");
            spenMiniPenAttributeControl = null;
        }
        spenMiniPenAttributeControl.close();
        SpenMiniPenControl spenMiniPenControl = this.mPenControl;
        if (spenMiniPenControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenControl");
            spenMiniPenControl = null;
        }
        spenMiniPenControl.close();
        SpenMiniColorControl spenMiniColorControl = this.mColorControl;
        if (spenMiniColorControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorControl");
            spenMiniColorControl = null;
        }
        spenMiniColorControl.close();
        SpenMiniPatternControl spenMiniPatternControl = this.mPatternControl;
        if (spenMiniPatternControl != null) {
            spenMiniPatternControl.close();
        }
        this.mPatternControl = null;
        SpenPenMiniLayoutControl spenPenMiniLayoutControl = this.mLayoutControl;
        if (spenPenMiniLayoutControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutControl");
            spenPenMiniLayoutControl = null;
        }
        spenPenMiniLayoutControl.close();
        this.mColorThemeUtil.close();
        SpenSettingPenManager spenSettingPenManager2 = this.mPenManager;
        if (spenSettingPenManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenManager");
        } else {
            spenSettingPenManager = spenSettingPenManager2;
        }
        spenSettingPenManager.close();
        super.close();
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenSetting
    @Nullable
    public SpenSettingUIPenInfo getInfo() {
        SpenSettingPenManager spenSettingPenManager = this.mPenManager;
        if (spenSettingPenManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenManager");
            spenSettingPenManager = null;
        }
        return spenSettingPenManager.getCurrentUIPenInfo();
    }

    @Override // com.samsung.android.sdk.pen.setting.common.SpenLayoutConfig
    public int getLayoutOrientation() {
        SpenPenMiniLayoutControl spenPenMiniLayoutControl = this.mLayoutControl;
        if (spenPenMiniLayoutControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutControl");
            spenPenMiniLayoutControl = null;
        }
        return spenPenMiniLayoutControl.getMOrientation();
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenFavoriteSettingUI
    public void setChangeViewModeButtonListener(@Nullable View.OnClickListener listener) {
        SpenPenMiniLayoutControl spenPenMiniLayoutControl = this.mLayoutControl;
        if (spenPenMiniLayoutControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutControl");
            spenPenMiniLayoutControl = null;
        }
        spenPenMiniLayoutControl.setChangeFavoriteButton(listener);
    }

    public final void setColorTheme(int colorTheme) {
        AbstractC11014a.m12328m(colorTheme, "setColorTheme()=", " ThemeUtil is NOT NULL", TAG);
        this.mColorThemeUtil.setColorTheme(colorTheme);
        SpenMiniColorControl spenMiniColorControl = this.mColorControl;
        if (spenMiniColorControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorControl");
            spenMiniColorControl = null;
        }
        spenMiniColorControl.setColorTheme(colorTheme);
        updateView(19, false);
    }

    public final boolean setCurrentColor(int colorFrom, @Nullable float[] hsvColor) {
        if (hsvColor != null) {
            float f = hsvColor[0];
            Log.i(TAG, AbstractC1038a.m1216q(AbstractC2322a.m1628r("setCurrentColor() from=", colorFrom, "[", f, SQLKeyword.COMMA), hsvColor[1], SQLKeyword.COMMA, hsvColor[2], "]"));
            SpenMiniColorControl spenMiniColorControl = null;
            if (colorFrom == 1) {
                SpenMiniColorControl spenMiniColorControl2 = this.mColorControl;
                if (spenMiniColorControl2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mColorControl");
                } else {
                    spenMiniColorControl = spenMiniColorControl2;
                }
                spenMiniColorControl.setPickerColor(hsvColor);
                return true;
            }
            if (colorFrom == 2 && this.mIsSupportEyedropper) {
                int iHSVToColor = SpenSettingUtil.HSVToColor(hsvColor);
                SpenMiniColorControl spenMiniColorControl3 = this.mColorControl;
                if (spenMiniColorControl3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mColorControl");
                } else {
                    spenMiniColorControl = spenMiniColorControl3;
                }
                spenMiniColorControl.setEyedropperColor(iHSVToColor);
                return true;
            }
        }
        return false;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenSettingUI
    public void setCurrentPalette(int paletteID) {
        AbstractC2322a.m1631u(paletteID, "setCurrentPalette() paletteID=", TAG);
        SpenMiniColorControl spenMiniColorControl = this.mColorControl;
        if (spenMiniColorControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorControl");
            spenMiniColorControl = null;
        }
        spenMiniColorControl.setCurrentPalette(paletteID);
    }

    public final void setDisallowSliderLabel(boolean disallowSliderLabel) {
        SpenMiniSliderLabelControl spenMiniSliderLabelControl = this.mSliderLabelControl;
        if (spenMiniSliderLabelControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSliderLabelControl");
            spenMiniSliderLabelControl = null;
        }
        spenMiniSliderLabelControl.setDisallowLabel(disallowSliderLabel);
    }

    public final void setEyedropperEnabled(boolean enabled) {
        AbstractC6670b.m4758s("setEyedropperEnabled() ", " -> ", TAG, this.mIsSupportEyedropper, enabled);
        if (this.mIsSupportEyedropper == enabled) {
            return;
        }
        this.mIsSupportEyedropper = enabled;
        SpenMiniColorControl spenMiniColorControl = this.mColorControl;
        if (spenMiniColorControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorControl");
            spenMiniColorControl = null;
        }
        spenMiniColorControl.setEyedropperEnabled(enabled);
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenSetting
    public void setInfo(@NotNull SpenSettingUIPenInfo uiPenInfo) {
        Intrinsics.checkNotNullParameter(uiPenInfo, "uiPenInfo");
        Log.i(TAG, "setInfo()");
        SpenSettingPenManager spenSettingPenManager = this.mPenManager;
        SpenSettingPenManager spenSettingPenManager2 = null;
        if (spenSettingPenManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenManager");
            spenSettingPenManager = null;
        }
        spenSettingPenManager.printInfo("SpenSettingPenMiniLayout::setInfo()", uiPenInfo, false);
        SpenSettingPenManager spenSettingPenManager3 = this.mPenManager;
        if (spenSettingPenManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenManager");
        } else {
            spenSettingPenManager2 = spenSettingPenManager3;
        }
        if (spenSettingPenManager2.setCurrentUIPenInfo(uiPenInfo)) {
            updateView(63, false);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.common.SpenLayoutConfig
    public void setLayoutOrientation(int orientation) {
        SpenPenMiniLayoutControl spenPenMiniLayoutControl = this.mLayoutControl;
        SpenMiniSliderLabelControl spenMiniSliderLabelControl = null;
        if (spenPenMiniLayoutControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutControl");
            spenPenMiniLayoutControl = null;
        }
        if (spenPenMiniLayoutControl.getMOrientation() == orientation) {
            return;
        }
        SpenPenMiniLayoutControl spenPenMiniLayoutControl2 = this.mLayoutControl;
        if (spenPenMiniLayoutControl2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutControl");
            spenPenMiniLayoutControl2 = null;
        }
        spenPenMiniLayoutControl2.saveViewState();
        SpenPenMiniLayoutControl spenPenMiniLayoutControl3 = this.mLayoutControl;
        if (spenPenMiniLayoutControl3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutControl");
            spenPenMiniLayoutControl3 = null;
        }
        spenPenMiniLayoutControl3.setOrientation(orientation);
        updateView(63, false);
        SpenPenMiniLayoutControl spenPenMiniLayoutControl4 = this.mLayoutControl;
        if (spenPenMiniLayoutControl4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutControl");
            spenPenMiniLayoutControl4 = null;
        }
        spenPenMiniLayoutControl4.restoreViewState();
        SpenMiniSliderLabelControl spenMiniSliderLabelControl2 = this.mSliderLabelControl;
        if (spenMiniSliderLabelControl2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSliderLabelControl");
        } else {
            spenMiniSliderLabelControl = spenMiniSliderLabelControl2;
        }
        spenMiniSliderLabelControl.setParentOrientation(orientation);
    }

    public final void setOnButtonClickListener(@Nullable OnButtonClickListener listener) {
        this.mButtonClickListener = listener;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenSettingUI
    public void setPalette(@Nullable List<Integer> paletteList) {
        if (paletteList == null || paletteList.size() == 0) {
            Log.i(TAG, "Invalid paletteList information");
            return;
        }
        SpenMiniColorControl spenMiniColorControl = this.mColorControl;
        if (spenMiniColorControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorControl");
            spenMiniColorControl = null;
        }
        spenMiniColorControl.setPalette(paletteList);
        updateView(4, false);
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenSettingUI
    public void setPaletteActionButtonListener(@Nullable OnActionButtonListener listener) {
        SpenMiniColorControl spenMiniColorControl = this.mColorControl;
        if (spenMiniColorControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorControl");
            spenMiniColorControl = null;
        }
        spenMiniColorControl.setPaletteActionButtonListener(listener);
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenSettingUI
    public void setPaletteActionListener(@Nullable SpenPaletteActionListener listener) {
        SpenMiniColorControl spenMiniColorControl = this.mColorControl;
        if (spenMiniColorControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorControl");
            spenMiniColorControl = null;
        }
        spenMiniColorControl.setPaletteActionListener(listener);
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenSetting
    public void setPenInfoChangedListener(@Nullable PenInfoChangedListener listener) {
        SpenSettingPenManager spenSettingPenManager = this.mPenManager;
        if (spenSettingPenManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenManager");
            spenSettingPenManager = null;
        }
        spenSettingPenManager.setPenInfoChangedListener(listener);
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenSetting
    public void setPenInfoList(@Nullable List<SpenSettingUIPenInfo> uiPenInfoList) {
        Log.i(TAG, "setPenInfoList()");
        if (uiPenInfoList != null) {
            SpenSettingPenManager spenSettingPenManager = this.mPenManager;
            SpenSettingPenManager spenSettingPenManager2 = null;
            if (spenSettingPenManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenManager");
                spenSettingPenManager = null;
            }
            spenSettingPenManager.setUIPenInfoList(uiPenInfoList);
            SpenMiniPenControl spenMiniPenControl = this.mPenControl;
            if (spenMiniPenControl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenControl");
                spenMiniPenControl = null;
            }
            spenMiniPenControl.setListPenInfo(getThemePenInfoList());
            SpenSettingPenManager spenSettingPenManager3 = this.mPenManager;
            if (spenSettingPenManager3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenManager");
            } else {
                spenSettingPenManager2 = spenSettingPenManager3;
            }
            if (spenSettingPenManager2.getCurrentUIPenInfo() != null) {
                updateView(63, false);
            }
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenSettingUI
    public void setRecentColor(@Nullable List<SpenHSVColor> recentList) {
        SpenMiniColorControl spenMiniColorControl = this.mColorControl;
        if (spenMiniColorControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorControl");
            spenMiniColorControl = null;
        }
        spenMiniColorControl.setRecentColor(recentList);
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenSettingUI
    public void setRecentColorChangedListener(@Nullable SpenRecentColorChangedListener listener) {
        SpenMiniColorControl spenMiniColorControl = this.mColorControl;
        if (spenMiniColorControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorControl");
            spenMiniColorControl = null;
        }
        spenMiniColorControl.setRecentColorChangedListener(listener);
    }

    public final void setSliderLabelGravity(int gravity) {
        SpenMiniSliderLabelControl spenMiniSliderLabelControl = this.mSliderLabelControl;
        if (spenMiniSliderLabelControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSliderLabelControl");
            spenMiniSliderLabelControl = null;
        }
        spenMiniSliderLabelControl.setLabelGravity(gravity);
    }

    public final void setSliderLabelListener(@Nullable OnSliderLabelListener listener) {
        this.mSliderLabelListener = listener;
    }

    public final boolean setViewMode(int viewMode) {
        return setViewMode(viewMode, false);
    }

    public final void setViewModeChangedListener(@Nullable OnViewModeChangedListener listener) {
        this.mChildViewModeChangedListener = listener;
    }

    private final boolean setViewMode(int viewMode, boolean needAnimation) {
        AbstractC6670b.m4754o("setViewMode() mode=", viewMode, " animation=", needAnimation, TAG);
        SpenPenMiniLayoutControl spenPenMiniLayoutControl = this.mLayoutControl;
        if (spenPenMiniLayoutControl == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLayoutControl");
            spenPenMiniLayoutControl = null;
        }
        return spenPenMiniLayoutControl.setViewMode(viewMode, needAnimation);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenSettingPenMiniLayout(@NotNull Context context, @NotNull List<Integer> paletteList, @NotNull List<SpenHSVColor> recentList, boolean z, @NotNull List<String> customizedPenList, int i) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(paletteList, "paletteList");
        Intrinsics.checkNotNullParameter(recentList, "recentList");
        Intrinsics.checkNotNullParameter(customizedPenList, "customizedPenList");
        this.mPenDataChangedListener = new SpenMiniPenControl.OnDataChangedListener() { // from class: com.samsung.android.sdk.pen.setting.SpenSettingPenMiniLayout$mPenDataChangedListener$1
            @Override // com.samsung.android.sdk.pen.setting.SpenMiniPenControl.OnDataChangedListener
            public void onPenChanged(String penName) {
                AbstractC6670b.m4756q("onPenChanged() penName=", penName, "SpenSettingPenMiniLayout");
                this.this$0.changePen(penName);
                this.this$0.updateView(63, true);
            }
        };
        this.mPenAttrDataChangedListener = new SpenMiniPenAttributeControl.OnDataChangedListener() { // from class: com.samsung.android.sdk.pen.setting.SpenSettingPenMiniLayout$mPenAttrDataChangedListener$1
            @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenAttrMiniLayout.OnDataChangedListener
            public void onAlphaChanged(int alpha) {
                SpenSettingPenManager spenSettingPenManager = this.this$0.mPenManager;
                SpenSettingPenManager spenSettingPenManager2 = null;
                if (spenSettingPenManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPenManager");
                    spenSettingPenManager = null;
                }
                SpenSettingUIPenInfo currentUIPenInfo = spenSettingPenManager.getCurrentUIPenInfo();
                if (currentUIPenInfo == null) {
                    return;
                }
                currentUIPenInfo.color = SpenSettingUtilOpacity.setCurrentAlpha(currentUIPenInfo.color, alpha);
                SpenSettingPenManager spenSettingPenManager3 = this.this$0.mPenManager;
                if (spenSettingPenManager3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPenManager");
                } else {
                    spenSettingPenManager2 = spenSettingPenManager3;
                }
                if (spenSettingPenManager2.setCurrentUIPenInfo(currentUIPenInfo)) {
                    this.this$0.updateView(3, false);
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenAttrMiniLayout.OnDataChangedListener
            public void onFixedWidthChanged(boolean isFixedWidth) {
                SpenSettingPenManager spenSettingPenManager = this.this$0.mPenManager;
                SpenSettingPenManager spenSettingPenManager2 = null;
                if (spenSettingPenManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPenManager");
                    spenSettingPenManager = null;
                }
                SpenSettingUIPenInfo currentUIPenInfo = spenSettingPenManager.getCurrentUIPenInfo();
                if (currentUIPenInfo == null) {
                    return;
                }
                currentUIPenInfo.isFixedWidth = isFixedWidth;
                SpenSettingPenManager spenSettingPenManager3 = this.this$0.mPenManager;
                if (spenSettingPenManager3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPenManager");
                } else {
                    spenSettingPenManager2 = spenSettingPenManager3;
                }
                if (spenSettingPenManager2.setCurrentUIPenInfo(currentUIPenInfo)) {
                    this.this$0.updateView(2, false);
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenAttrMiniLayout.OnDataChangedListener
            public void onSizeChanged(int sizeLevel) {
                if (this.this$0.changeCurrentSize(sizeLevel)) {
                    this.this$0.updateView(2, false);
                }
            }
        };
        this.mColorChangedListener = new OnColorChangeListener() { // from class: com.samsung.android.sdk.pen.setting.SpenSettingPenMiniLayout$mColorChangedListener$1
            @Override // com.samsung.android.sdk.pen.setting.colorpalette.OnColorChangeListener
            public void onColorChanged(int info, float[] hsvColor) {
                Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
                if (this.this$0.changeCurrentColor(info, hsvColor)) {
                    this.this$0.updateView(19, false);
                }
            }
        };
        this.mPatternChangedListener = new SpenMiniPatternControl.OnPatternChangedListener() { // from class: com.samsung.android.sdk.pen.setting.SpenSettingPenMiniLayout$mPatternChangedListener$1
            @Override // com.samsung.android.sdk.pen.setting.SpenPatternControl.OnPatternChangeListener
            public void onPatternChanged(String resName, float size) {
                Log.i("SpenSettingPenMiniLayout", "onPatternChanged() resourceName=[" + resName + "] size=" + size);
                SpenSettingPenManager spenSettingPenManager = this.this$0.mPenManager;
                SpenSettingPenManager spenSettingPenManager2 = null;
                if (spenSettingPenManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPenManager");
                    spenSettingPenManager = null;
                }
                SpenSettingUIPenInfo currentUIPenInfo = spenSettingPenManager.getCurrentUIPenInfo();
                if (currentUIPenInfo == null) {
                    return;
                }
                currentUIPenInfo.particleSize = size;
                SpenSettingPenManager spenSettingPenManager3 = this.this$0.mPenManager;
                if (spenSettingPenManager3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPenManager");
                } else {
                    spenSettingPenManager2 = spenSettingPenManager3;
                }
                if (spenSettingPenManager2.setCurrentUIPenInfo(currentUIPenInfo)) {
                    this.this$0.updateView(2, false);
                }
            }
        };
        this.mViewModeChangedListener = new SpenPenMiniLayoutControl.OnViewModeChangedListener() { // from class: com.samsung.android.sdk.pen.setting.SpenSettingPenMiniLayout$mViewModeChangedListener$1
            @Override // com.samsung.android.sdk.pen.setting.SpenPenMiniLayoutControl.OnViewModeChangedListener
            public void onViewModeChanged(int mode) {
                AbstractC2322a.m1631u(mode, "onViewModeChanged() mode=", "SpenSettingPenMiniLayout");
                SpenSettingPenMiniLayout.OnViewModeChangedListener onViewModeChangedListener = this.this$0.mChildViewModeChangedListener;
                if (onViewModeChangedListener != null) {
                    onViewModeChangedListener.onViewModeChanged(mode);
                }
            }
        };
        this.mSliderListener = new SpenMiniPenAttributeControl.OnSliderListener() { // from class: com.samsung.android.sdk.pen.setting.SpenSettingPenMiniLayout$mSliderListener$1
            @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenAttrMiniLayout.OnSliderListener
            public void onLabelChanged(String text) {
                Intrinsics.checkNotNullParameter(text, "text");
                SpenMiniSliderLabelControl spenMiniSliderLabelControl = this.this$0.mSliderLabelControl;
                if (spenMiniSliderLabelControl == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSliderLabelControl");
                    spenMiniSliderLabelControl = null;
                }
                spenMiniSliderLabelControl.onLabelChanged(text);
                SpenSettingPenMiniLayout.OnSliderLabelListener onSliderLabelListener = this.this$0.mSliderLabelListener;
                if (onSliderLabelListener != null) {
                    onSliderLabelListener.onLabelChanged(text);
                }
            }

            @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenAttrMiniLayout.OnSliderListener
            public void onLabelStateChanged(View slider, SpenPenAttrMiniLayout.OnSliderListener.LabelState state, String text) {
                Intrinsics.checkNotNullParameter(text, "text");
                SpenMiniSliderLabelControl spenMiniSliderLabelControl = this.this$0.mSliderLabelControl;
                if (spenMiniSliderLabelControl == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSliderLabelControl");
                    spenMiniSliderLabelControl = null;
                }
                spenMiniSliderLabelControl.onLabelStateChanged(slider, state, text);
                SpenSettingPenMiniLayout.OnSliderLabelListener onSliderLabelListener = this.this$0.mSliderLabelListener;
                if (onSliderLabelListener != null) {
                    onSliderLabelListener.onLabelStateChanged(slider, state, text);
                }
            }
        };
        this.mColorThemeUtil = new SpenColorThemeUtil(context);
        this.mIsSupportEyedropper = z;
        construct(context, paletteList, recentList, customizedPenList, i);
    }
}
