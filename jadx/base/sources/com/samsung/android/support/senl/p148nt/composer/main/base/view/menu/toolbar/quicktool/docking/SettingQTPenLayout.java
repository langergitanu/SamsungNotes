package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.animation.LinearInterpolator;
import androidx.collection.AbstractC0622a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.constraintlayout.widget.ConstraintSet;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.pen.SpenPenManager;
import com.samsung.android.sdk.pen.setting.color.SpenColorThemeUtil;
import com.samsung.android.sdk.pen.setting.colorpalette.OnActionButtonListener;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenHSVColor;
import com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerDataChangedListener;
import com.samsung.android.sdk.pen.setting.handwriting.SpenPenAttrMiniView;
import com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTPenContainer;
import com.samsung.android.sdk.pen.setting.quicktool.SpenSettingQTPenInfoChangedListener;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilHover;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.RunnableC9767a;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTAttributesLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTColorDialLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTColorLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTColorPickerLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTPatternLayout;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.animation.QTAnimationKt;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.colorpalette.ChipView;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.colorpalette.PaletteDefine;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.common.QTBackground2;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.common.QTBackground3;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.common.QTVoiceAssistantAsButton;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.patternpalette.PatternDataManager;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverConstants;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\t\b\u0007\u0018\u0000 r2\u00020\u0001:\u0003rstB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010/\u001a\u000200H\u0002J\u0010\u00101\u001a\u0002002\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\b\u00102\u001a\u000200H\u0002J\u0018\u00103\u001a\u00020\f2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0002J\u000e\u00108\u001a\u0002002\u0006\u00109\u001a\u00020\u0005J\u0018\u0010:\u001a\u0002002\u0006\u00104\u001a\u00020;2\u0006\u0010<\u001a\u00020\u0013H\u0002J\b\u0010=\u001a\u000200H\u0016J\u0010\u0010>\u001a\u00020\u00052\u0006\u0010?\u001a\u00020@H\u0016J\u000e\u0010A\u001a\u0002002\u0006\u0010B\u001a\u00020\u0013J\u0018\u0010C\u001a\u0002002\b\u0010D\u001a\u0004\u0018\u00010E2\u0006\u0010F\u001a\u00020\u0013J\u001a\u0010G\u001a\u00020\u00052\u0006\u0010H\u001a\u00020I2\b\u0010J\u001a\u0004\u0018\u00010KH\u0016J \u0010C\u001a\u0002002\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u00132\u0006\u0010L\u001a\u00020\u0005H\u0002J\u0010\u0010M\u001a\u0002002\u0006\u0010N\u001a\u00020\u0013H\u0002J\u0012\u0010O\u001a\u00020\u00132\b\u0010P\u001a\u0004\u0018\u00010QH\u0002J\u0010\u0010R\u001a\u0002002\u0006\u0010S\u001a\u00020\u0005H\u0002J\u000e\u0010T\u001a\u0002002\u0006\u0010J\u001a\u00020\u001bJ\u0010\u0010U\u001a\u0002002\b\b\u0002\u0010V\u001a\u00020\u0005J(\u0010W\u001a\u0002002\u0006\u0010X\u001a\u00020\u00192\u0006\u0010Y\u001a\u00020\u00052\u0006\u0010L\u001a\u00020\u00052\b\b\u0002\u0010Z\u001a\u00020\u0005J\u0010\u0010[\u001a\u0002002\u0006\u0010Y\u001a\u00020\u0005H\u0002J\u0018\u0010\\\u001a\u0002002\u0006\u0010]\u001a\u00020\u00192\u0006\u0010Y\u001a\u00020\u0005H\u0002J\u0010\u0010^\u001a\u0002002\u0006\u0010Y\u001a\u00020\u0005H\u0002J\u0010\u0010_\u001a\u0002002\u0006\u0010Y\u001a\u00020\u0005H\u0002J\u0010\u0010`\u001a\u0002002\u0006\u0010Y\u001a\u00020\u0005H\u0002J\u0010\u0010a\u001a\u0002002\u0006\u0010Y\u001a\u00020\u0005H\u0002J \u0010b\u001a\u0002002\u0006\u0010c\u001a\u00020;2\u0006\u0010d\u001a\u00020\u00132\u0006\u0010e\u001a\u00020\u0005H\u0002J\b\u0010f\u001a\u00020\u0013H\u0002J\u000e\u0010g\u001a\u0002002\u0006\u0010J\u001a\u00020hJ\u0010\u0010i\u001a\u0002002\b\u0010J\u001a\u0004\u0018\u00010+J\u001c\u0010j\u001a\u0002002\f\u0010k\u001a\b\u0012\u0004\u0012\u00020E0l2\u0006\u0010m\u001a\u00020\u0013J\u0014\u0010n\u001a\u0002002\f\u0010k\u001a\b\u0012\u0004\u0012\u00020\u00130lJ\u0014\u0010o\u001a\u0002002\f\u0010p\u001a\b\u0012\u0004\u0012\u00020\u00150lJ\u000e\u0010q\u001a\u0002002\u0006\u0010-\u001a\u00020.R\u000e\u0010\b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006u"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTPenLayout;", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTLayout;", "context", "Landroid/content/Context;", "isSupportEyedropper", "", "<init>", "(Landroid/content/Context;Z)V", "mIsSupportEyedropper", "mAttrItem", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenAttrMiniView;", "mColorPickerItem", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/colorpalette/ChipView;", "mEyedropperItem", "mPatternItem", "mColorThemeUtil", "Lcom/samsung/android/sdk/pen/setting/color/SpenColorThemeUtil;", "mPaletteList", "", "", "mRecentColors", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenHSVColor;", "mPenInfoManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/QTPenManager;", "mViewMode", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTPenLayout$ViewMode;", "mViewModeChangedListener", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTPenLayout$OnViewModeChangedListener;", "mBackgroundView", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/common/QTBackground2;", "mBigBackgroundView", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/common/QTBackground3;", "mColorLayout", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTColorLayout;", "mAttributeLayout", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTAttributesLayout;", "mColorPickerLayout", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTColorPickerLayout;", "mPatternLayout", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTPatternLayout;", "mPatternDataManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/patternpalette/PatternDataManager;", "mPaletteActionButtonListener", "Lcom/samsung/android/sdk/pen/setting/colorpalette/OnActionButtonListener;", "mIsShowAnimation", "rotationType", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenContainer$RotationType;", "initDefaultPattern", "", "initView", "setupEyedropperItem", "initFixedItem", "item", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTColorDialLayout$FixedItem;", "angle", "", "setEyedropperEnabled", "enabled", "setItemAccessibility", "Landroid/view/View;", "stringId", "close", "getVisibleContentRect", "rect", "Landroid/graphics/Rect;", "setColorTheme", BaseWidgetConstant.WIDGET_THEME, "setInfo", "info", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "index", "startAnimation", "type", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTLayout$AnimationType;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTLayout$AnimationEndListener;", "notify", "updateView", "updateInfo", "getDrawableId", "drawable", "", "setItemAttribute", "alphaVisible", "setViewModeChangedListener", "updateColor", "moveToCurrent", "setViewMode", "mode", "animation", "forceUpdate", "setViewModeMain", "animateColorMode", "fromViewMode", "setViewModeAttributes", "setViewModeColorPicker", "setViewModeColorDetail", "setViewModePattern", "addSubView", "view", "id", "isAlignCenter", "getAttributesValue", "setPenInfoChangedListener", "Lcom/samsung/android/sdk/pen/setting/quicktool/SpenSettingQTPenInfoChangedListener;", "setPaletteActionButtonListener", "setPenInfoList", XmlErrorCodes.LIST, "", "selectedIndex", "setPaletteList", "setRecentColor", "recentList", "setRotation", "Companion", "ViewMode", "OnViewModeChangedListener", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SuppressLint({"ViewConstructor"})
@SourceDebugExtension({"SMAP\nSettingQTPenLayout.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SettingQTPenLayout.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTPenLayout\n+ 2 View.kt\nandroidx/core/view/ViewKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,731:1\n176#2,2:732\n192#2,3:735\n192#2,3:738\n1#3:734\n*S KotlinDebug\n*F\n+ 1 SettingQTPenLayout.kt\ncom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTPenLayout\n*L\n199#1:732,2\n413#1:735,3\n426#1:738,3\n*E\n"})
public final class SettingQTPenLayout extends SettingQTLayout {

    @NotNull
    private static final String TAG = "SettingQTPenLayout";
    private static final int UPDATE_ALL = 63;
    private static final int UPDATE_COLOR = 4;
    private static final int UPDATE_OPACITY = 16;
    private static final int UPDATE_PATTERN = 8;
    private static final int UPDATE_PEN = 2;
    private static final int UPDATE_SIZE = 1;
    private static final int UPDATE_WIDTH = 32;
    private static final long VI_DOCKING_ROTATION_DURATION = 400;
    private SpenPenAttrMiniView mAttrItem;

    @Nullable
    private SettingQTAttributesLayout mAttributeLayout;
    private QTBackground2 mBackgroundView;
    private QTBackground3 mBigBackgroundView;

    @Nullable
    private SettingQTColorLayout mColorLayout;
    private ChipView mColorPickerItem;

    @Nullable
    private SettingQTColorPickerLayout mColorPickerLayout;

    @NotNull
    private final SpenColorThemeUtil mColorThemeUtil;

    @Nullable
    private ChipView mEyedropperItem;
    private boolean mIsShowAnimation;
    private boolean mIsSupportEyedropper;

    @Nullable
    private OnActionButtonListener mPaletteActionButtonListener;

    @NotNull
    private final List<Integer> mPaletteList;

    @NotNull
    private final PatternDataManager mPatternDataManager;

    @Nullable
    private ChipView mPatternItem;

    @Nullable
    private SettingQTPatternLayout mPatternLayout;

    @NotNull
    private final QTPenManager mPenInfoManager;

    @NotNull
    private final List<SpenHSVColor> mRecentColors;

    @NotNull
    private ViewMode mViewMode;

    @Nullable
    private OnViewModeChangedListener mViewModeChangedListener;

    @NotNull
    private SpenSettingQTPenContainer.RotationType rotationType;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTPenLayout$OnViewModeChangedListener;", "", "onViewModeChanged", "", "mode", "Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTPenLayout$ViewMode;", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface OnViewModeChangedListener {
        void onViewModeChanged(@NotNull ViewMode mode);
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/toolbar/quicktool/docking/SettingQTPenLayout$ViewMode;", "", "<init>", "(Ljava/lang/String;I)V", "MAIN", "PEN_LIST", "COLOR", "ATTRIBUTES", "COLOR_PICKER", "COLOR_DETAIL", CoverConstants.TemplateType.PATTERN.UUID, "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class ViewMode {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ViewMode[] $VALUES;
        public static final ViewMode MAIN = new ViewMode("MAIN", 0);
        public static final ViewMode PEN_LIST = new ViewMode("PEN_LIST", 1);
        public static final ViewMode COLOR = new ViewMode("COLOR", 2);
        public static final ViewMode ATTRIBUTES = new ViewMode("ATTRIBUTES", 3);
        public static final ViewMode COLOR_PICKER = new ViewMode("COLOR_PICKER", 4);
        public static final ViewMode COLOR_DETAIL = new ViewMode("COLOR_DETAIL", 5);
        public static final ViewMode PATTERN = new ViewMode(CoverConstants.TemplateType.PATTERN.UUID, 6);

        private static final /* synthetic */ ViewMode[] $values() {
            return new ViewMode[]{MAIN, PEN_LIST, COLOR, ATTRIBUTES, COLOR_PICKER, COLOR_DETAIL, PATTERN};
        }

        static {
            ViewMode[] viewModeArr$values = $values();
            $VALUES = viewModeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(viewModeArr$values);
        }

        private ViewMode(String str, int i) {
        }

        @NotNull
        public static EnumEntries<ViewMode> getEntries() {
            return $ENTRIES;
        }

        public static ViewMode valueOf(String str) {
            return (ViewMode) Enum.valueOf(ViewMode.class, str);
        }

        public static ViewMode[] values() {
            return (ViewMode[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 1, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ViewMode.values().length];
            try {
                iArr[ViewMode.COLOR_PICKER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ViewMode.MAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ViewMode.COLOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ViewMode.ATTRIBUTES.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ViewMode.COLOR_DETAIL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ViewMode.PATTERN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingQTPenLayout(@NotNull Context context, boolean z) {
        super(context, C9086R.layout.qt_pen_base_layout);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mIsSupportEyedropper = z;
        this.mColorThemeUtil = new SpenColorThemeUtil(context);
        this.mPaletteList = new ArrayList();
        this.mRecentColors = new ArrayList();
        this.mPenInfoManager = new QTPenManager(context);
        this.mViewMode = ViewMode.MAIN;
        this.mPatternDataManager = new PatternDataManager();
        this.rotationType = SpenSettingQTPenContainer.RotationType.NONE;
        initDefaultPattern();
        initView(context);
    }

    private final void addSubView(View view, int id, boolean isAlignCenter) {
        view.setId(id);
        getMainContent$ntComposer_release().addView(view);
        if (isAlignCenter) {
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(getMainContent$ntComposer_release());
            constraintSet.connect(id, 6, 0, 6);
            constraintSet.connect(id, 7, 0, 7);
            constraintSet.connect(id, 3, 0, 3);
            constraintSet.connect(id, 4, 0, 4);
            constraintSet.applyTo(getMainContent$ntComposer_release());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void animateColorMode(ViewMode fromViewMode, boolean animation) {
        ChipView chipView;
        SpenPenAttrMiniView spenPenAttrMiniView;
        if (!animation) {
            SettingQTColorLayout settingQTColorLayout = this.mColorLayout;
            if (settingQTColorLayout != null) {
                settingQTColorLayout.setVisibility(0, false);
                return;
            }
            return;
        }
        ViewMode viewMode = ViewMode.COLOR_PICKER;
        if (fromViewMode == viewMode) {
            postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTPenLayout$animateColorMode$$inlined$postDelayed$1
                @Override // java.lang.Runnable
                public final void run() {
                    SettingQTColorLayout settingQTColorLayout2 = this.this$0.mColorLayout;
                    if (settingQTColorLayout2 != null) {
                        settingQTColorLayout2.setVisibility(0, true);
                    }
                }
            }, 100L);
        } else {
            SettingQTColorLayout settingQTColorLayout2 = this.mColorLayout;
            if (settingQTColorLayout2 != null) {
                settingQTColorLayout2.setVisibility(0, true);
            }
        }
        ChipView chipView2 = null;
        if (fromViewMode != ViewMode.ATTRIBUTES && fromViewMode != ViewMode.COLOR_DETAIL) {
            SpenPenAttrMiniView spenPenAttrMiniView2 = this.mAttrItem;
            if (spenPenAttrMiniView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAttrItem");
                spenPenAttrMiniView = null;
            } else {
                spenPenAttrMiniView = spenPenAttrMiniView2;
            }
            QTAnimationKt.scale((View) spenPenAttrMiniView, 0.0f, 1.0f, 0L, 400L);
        }
        if (fromViewMode != viewMode) {
            ChipView chipView3 = this.mColorPickerItem;
            if (chipView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mColorPickerItem");
                chipView = null;
            } else {
                chipView = chipView3;
            }
            QTAnimationKt.scale((View) chipView, 0.0f, 1.0f, 144L, 400L);
            ChipView chipView4 = this.mEyedropperItem;
            if (chipView4 != null) {
                QTAnimationKt.scale((View) chipView4, 0.0f, 1.0f, 160L, 400L);
            }
            ChipView chipView5 = this.mColorPickerItem;
            if (chipView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mColorPickerItem");
            } else {
                chipView2 = chipView5;
            }
            chipView2.setVisibility(0);
            ChipView chipView6 = this.mEyedropperItem;
            if (chipView6 != null) {
                chipView6.setVisibility(0);
            }
        }
    }

    private final int getAttributesValue() {
        int i = this.mPenInfoManager.getMIsSupportAlpha() ? 3 : 1;
        return this.mPenInfoManager.getMIsSupportFixedWidth() ? i | 4 : i;
    }

    private final int getDrawableId(String drawable) {
        if (drawable == null || drawable.length() == 0) {
            return 0;
        }
        int identifier = getContext().getResources().getIdentifier(drawable, "drawable", getContext().getPackageName());
        if (identifier == 0) {
            Logger.m11000e(TAG, "Resource is not founded");
        }
        return identifier;
    }

    private final void initDefaultPattern() {
        this.mPatternDataManager.setPatternInfo(SpenPenManager.SPEN_MOSAIC_PEN, CollectionsKt.listOf((Object[]) new String[]{"mosaic1", "mosaic2", "mosaic3"}), CollectionsKt.listOf((Object[]) new Float[]{Float.valueOf(10.0f), Float.valueOf(15.0f), Float.valueOf(20.0f)}), false);
    }

    private final ChipView initFixedItem(SettingQTColorDialLayout.FixedItem item, double angle) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(C9086R.dimen.composer_qt_dial_fixed_item_size);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(C9086R.dimen.composer_qt_dial_fixed_item_padding);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        ChipView chipView = new ChipView(context);
        chipView.setBackgroundResource(C9086R.drawable.spen_round_ripple);
        chipView.setColorRes(item.getResourceId());
        chipView.setSelectorRes(item.getSelectorResId());
        chipView.setContentDescription(item.getDescription());
        chipView.setTooltipText(item.getDescription());
        chipView.setPadding(dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2, dimensionPixelSize2);
        chipView.setAccessibilityDelegate(new QTVoiceAssistantAsButton());
        addEdgeView(chipView, dimensionPixelSize, dimensionPixelSize, angle);
        return chipView;
    }

    private final void initView(Context context) {
        this.mBackgroundView = (QTBackground2) findViewById(C9086R.id.qt_background);
        this.mBigBackgroundView = (QTBackground3) findViewById(C9086R.id.qt_big_background);
        setCenterBgVisibility(4);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(C9086R.dimen.composer_qt_circle_default_child_size);
        View viewAddEdgeView = addEdgeView(C9086R.layout.qt_attr_item, dimensionPixelSize, dimensionPixelSize, 281.0d);
        Intrinsics.checkNotNull(viewAddEdgeView, "null cannot be cast to non-null type com.samsung.android.sdk.pen.setting.handwriting.SpenPenAttrMiniView");
        SpenPenAttrMiniView spenPenAttrMiniView = (SpenPenAttrMiniView) viewAddEdgeView;
        this.mAttrItem = spenPenAttrMiniView;
        View view = null;
        if (spenPenAttrMiniView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAttrItem");
            spenPenAttrMiniView = null;
        }
        spenPenAttrMiniView.setOnClickListener(new ViewOnClickListenerC10782d(this, 0));
        View view2 = this.mAttrItem;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAttrItem");
        } else {
            view = view2;
        }
        setItemAccessibility(view, C9086R.string.pen_string_pen_thickness);
        final int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(C9086R.dimen.composer_qt_circle_color_item_size);
        ChipView chipView = new ChipView(context);
        setItemAccessibility(chipView, C9086R.string.pen_string_pattern);
        chipView.setClipToOutline(true);
        chipView.setOutlineProvider(new ViewOutlineProvider() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTPenLayout.initView.2
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view3, Outline outline) {
                Intrinsics.checkNotNullParameter(view3, "view");
                Intrinsics.checkNotNullParameter(outline, "outline");
                int i = dimensionPixelSize2;
                outline.setRoundRect(0, 0, i, i, i / 2.0f);
            }
        });
        addEdgeView(chipView, dimensionPixelSize2, dimensionPixelSize2, 0.0d);
        this.mPatternItem = chipView;
        chipView.setOnClickListener(new ViewOnClickListenerC10782d(this, 1));
        chipView.setVisibility(8);
        ChipView chipViewInitFixedItem = initFixedItem(new SettingQTColorDialLayout.FixedItem(C9086R.drawable.note_handwriting_setting_color_01, C9086R.drawable.color_picker_icon_selector, getResources().getText(C9086R.string.pen_string_color_picker)), 62.5d);
        chipViewInitFixedItem.setOnClickListener(new ViewOnClickListenerC10782d(this, 2));
        this.mColorPickerItem = chipViewInitFixedItem;
        if (this.mIsSupportEyedropper) {
            setupEyedropperItem();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$0(SettingQTPenLayout settingQTPenLayout, View view) {
        setViewMode$default(settingQTPenLayout, ViewMode.ATTRIBUTES, true, true, false, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$2$lambda$1(SettingQTPenLayout settingQTPenLayout, View view) {
        setViewMode$default(settingQTPenLayout, ViewMode.PATTERN, true, true, false, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initView$lambda$4$lambda$3(SettingQTPenLayout settingQTPenLayout, View view) {
        SettingQTPenLayout settingQTPenLayout2;
        ViewMode viewMode = settingQTPenLayout.mViewMode;
        ViewMode viewMode2 = ViewMode.COLOR_PICKER;
        if (viewMode == viewMode2) {
            setViewMode$default(settingQTPenLayout, ViewMode.COLOR, true, true, false, 8, null);
            settingQTPenLayout2 = settingQTPenLayout;
        } else {
            settingQTPenLayout2 = settingQTPenLayout;
            setViewMode$default(settingQTPenLayout2, viewMode2, true, true, false, 8, null);
        }
        OnActionButtonListener onActionButtonListener = settingQTPenLayout2.mPaletteActionButtonListener;
        if (onActionButtonListener != null) {
            onActionButtonListener.onButtonClick(1);
        }
    }

    private final void setItemAccessibility(View item, int stringId) {
        String string = getContext().getResources().getString(stringId);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        item.setContentDescription(string);
        SpenSettingUtilHover.setHoverText(item, string);
        item.setAccessibilityDelegate(new QTVoiceAssistantAsButton());
    }

    private final void setItemAttribute(boolean alphaVisible) {
        SpenPenAttrMiniView spenPenAttrMiniView = null;
        if (!alphaVisible) {
            SpenPenAttrMiniView spenPenAttrMiniView2 = this.mAttrItem;
            if (spenPenAttrMiniView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAttrItem");
            } else {
                spenPenAttrMiniView = spenPenAttrMiniView2;
            }
            spenPenAttrMiniView.setColorBackground(C9086R.drawable.setting_qt_mini_attr_bg);
            return;
        }
        SpenPenAttrMiniView spenPenAttrMiniView3 = this.mAttrItem;
        if (spenPenAttrMiniView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAttrItem");
        } else {
            spenPenAttrMiniView = spenPenAttrMiniView3;
        }
        int i = C9086R.drawable.transparency_pattern_circle;
        spenPenAttrMiniView.setDynamicColorBackground(i, i, true, SpenSettingUtil.getColor(getContext(), C9086R.color.setting_qt_attr_pattern_color));
    }

    public static /* synthetic */ void setViewMode$default(SettingQTPenLayout settingQTPenLayout, ViewMode viewMode, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 8) != 0) {
            z3 = false;
        }
        settingQTPenLayout.setViewMode(viewMode, z, z2, z3);
    }

    private final void setViewModeAttributes(boolean animation) {
        View viewFindViewById;
        SettingQTAttributesLayout settingQTAttributesLayout = this.mAttributeLayout;
        if (settingQTAttributesLayout == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            SettingQTAttributesLayout settingQTAttributesLayout2 = new SettingQTAttributesLayout(context, getAttributesValue());
            this.mAttributeLayout = settingQTAttributesLayout2;
            Intrinsics.checkNotNull(settingQTAttributesLayout2);
            addSubView(settingQTAttributesLayout2, C9086R.id.qt_sub_attributes, true);
            SettingQTAttributesLayout settingQTAttributesLayout3 = this.mAttributeLayout;
            if (settingQTAttributesLayout3 != null) {
                settingQTAttributesLayout3.setDataChangedListener(new SettingQTAttributesLayout.OnDataChangedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTPenLayout.setViewModeAttributes.1
                    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTAttributesLayout.OnDataChangedListener
                    public void onAlphaChanged(int alpha, boolean notify) {
                        if (notify) {
                            SettingQTPenLayout.this.mPenInfoManager.updateAlpha(alpha);
                        }
                        SettingQTPenLayout.this.updateView(16);
                    }

                    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTAttributesLayout.OnDataChangedListener
                    public void onColorClick() {
                        SettingQTPenLayout.setViewMode$default(SettingQTPenLayout.this, ViewMode.COLOR, true, true, false, 8, null);
                    }

                    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTAttributesLayout.OnDataChangedListener
                    public void onFixedWidthChanged(boolean isFixedWidth) {
                        SettingQTPenLayout.this.mPenInfoManager.updateFixedWidth(isFixedWidth);
                        SettingQTPenLayout.this.updateView(32);
                    }

                    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTAttributesLayout.OnDataChangedListener
                    public void onSizeChanged(int sizeLevel) {
                        SettingQTPenLayout.this.mPenInfoManager.updateSizeLevel(sizeLevel);
                        SettingQTPenLayout.this.updateView(1);
                    }
                });
            }
        } else {
            settingQTAttributesLayout.changeAttributeSet(getAttributesValue());
        }
        float f = this.rotationType == SpenSettingQTPenContainer.RotationType.LEFT_DOCKING ? 0.0f : 180.0f;
        SettingQTAttributesLayout settingQTAttributesLayout4 = this.mAttributeLayout;
        if (settingQTAttributesLayout4 != null && (viewFindViewById = settingQTAttributesLayout4.findViewById(C9086R.id.dial_handler_label_text)) != null) {
            viewFindViewById.setRotationY(f);
        }
        SpenSettingUIPenInfo penInfo = this.mPenInfoManager.getPenInfo();
        if (penInfo != null) {
            SettingQTAttributesLayout settingQTAttributesLayout5 = this.mAttributeLayout;
            if (settingQTAttributesLayout5 != null) {
                settingQTAttributesLayout5.setColor(this.mColorThemeUtil.getColor(penInfo.color));
            }
            SettingQTAttributesLayout settingQTAttributesLayout6 = this.mAttributeLayout;
            if (settingQTAttributesLayout6 != null) {
                settingQTAttributesLayout6.setSizeLevel(penInfo.sizeLevel);
            }
            SettingQTAttributesLayout settingQTAttributesLayout7 = this.mAttributeLayout;
            if (settingQTAttributesLayout7 != null) {
                settingQTAttributesLayout7.setFixedWidth(penInfo.isFixedWidth);
            }
        }
        setBaseContentVisibility(0);
        SettingQTAttributesLayout settingQTAttributesLayout8 = this.mAttributeLayout;
        if (settingQTAttributesLayout8 != null) {
            settingQTAttributesLayout8.setVisibility(0, animation);
        }
        SettingQTColorLayout settingQTColorLayout = this.mColorLayout;
        if (settingQTColorLayout != null) {
            settingQTColorLayout.setVisibility(8, animation);
        }
        SettingQTColorPickerLayout settingQTColorPickerLayout = this.mColorPickerLayout;
        if (settingQTColorPickerLayout != null) {
            settingQTColorPickerLayout.setVisibility(8);
        }
        QTBackground3 qTBackground3 = this.mBigBackgroundView;
        SpenPenAttrMiniView spenPenAttrMiniView = null;
        if (qTBackground3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBigBackgroundView");
            qTBackground3 = null;
        }
        qTBackground3.hide();
        ChipView chipView = this.mColorPickerItem;
        if (chipView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorPickerItem");
            chipView = null;
        }
        chipView.animate().alpha(0.0f).setDuration(100L).setStartDelay(0L).setInterpolator(new LinearInterpolator()).withEndAction(new RunnableC9767a(this, 12)).start();
        ChipView chipView2 = this.mEyedropperItem;
        if (chipView2 != null) {
            chipView2.animate().alpha(0.0f).setDuration(100L).setStartDelay(0L).setInterpolator(new LinearInterpolator()).withEndAction(new RunnableC9767a(chipView2, 13)).start();
        }
        SpenPenAttrMiniView spenPenAttrMiniView2 = this.mAttrItem;
        if (spenPenAttrMiniView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAttrItem");
        } else {
            spenPenAttrMiniView = spenPenAttrMiniView2;
        }
        spenPenAttrMiniView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setViewModeAttributes$lambda$12(SettingQTPenLayout settingQTPenLayout) {
        ChipView chipView = settingQTPenLayout.mColorPickerItem;
        ChipView chipView2 = null;
        if (chipView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorPickerItem");
            chipView = null;
        }
        chipView.setVisibility(8);
        ChipView chipView3 = settingQTPenLayout.mColorPickerItem;
        if (chipView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorPickerItem");
        } else {
            chipView2 = chipView3;
        }
        chipView2.setAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setViewModeAttributes$lambda$14$lambda$13(ChipView chipView) {
        chipView.setVisibility(8);
        chipView.setAlpha(1.0f);
    }

    private final void setViewModeColorDetail(boolean animation) {
        SpenSettingUIPenInfo penInfo = this.mPenInfoManager.getPenInfo();
        if (penInfo == null) {
            return;
        }
        SettingQTColorPickerLayout settingQTColorPickerLayout = this.mColorPickerLayout;
        if (settingQTColorPickerLayout == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            SettingQTColorPickerLayout settingQTColorPickerLayout2 = new SettingQTColorPickerLayout(context, penInfo.hsv);
            this.mColorPickerLayout = settingQTColorPickerLayout2;
            settingQTColorPickerLayout2.setColorTheme(this.mColorThemeUtil.getColorTheme());
            SettingQTColorPickerLayout settingQTColorPickerLayout3 = this.mColorPickerLayout;
            if (settingQTColorPickerLayout3 != null) {
                settingQTColorPickerLayout3.setOnColorChangedListener(new SpenColorPickerDataChangedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTPenLayout.setViewModeColorDetail.1
                    @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerDataChangedListener
                    public void onColorChanged(int color, float[] hsvColor) {
                        Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
                        SettingQTPenLayout.this.mPenInfoManager.updateColor(PaletteDefine.getColorUIInfo(1, 4), hsvColor);
                        SettingQTPenLayout.this.updateView(4);
                    }
                });
            }
            SettingQTColorPickerLayout settingQTColorPickerLayout4 = this.mColorPickerLayout;
            if (settingQTColorPickerLayout4 != null) {
                settingQTColorPickerLayout4.setAnimationListener(new SettingQTColorPickerLayout.AnimationListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTPenLayout.setViewModeColorDetail.2
                    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTColorPickerLayout.AnimationListener
                    public void onAnimationEnd(boolean isShowAnimation) {
                        SettingQTColorPickerLayout settingQTColorPickerLayout5;
                        if (isShowAnimation || (settingQTColorPickerLayout5 = SettingQTPenLayout.this.mColorPickerLayout) == null) {
                            return;
                        }
                        settingQTColorPickerLayout5.setVisibility(8, false);
                    }
                });
            }
            SettingQTColorPickerLayout settingQTColorPickerLayout5 = this.mColorPickerLayout;
            Intrinsics.checkNotNull(settingQTColorPickerLayout5);
            addSubView(settingQTColorPickerLayout5, C9086R.id.qt_sub_color_picker, true);
        } else if (settingQTColorPickerLayout != null) {
            settingQTColorPickerLayout.setCurrentColor(penInfo.hsv);
        }
        SettingQTColorPickerLayout settingQTColorPickerLayout6 = this.mColorPickerLayout;
        if (settingQTColorPickerLayout6 != null) {
            settingQTColorPickerLayout6.setOnActionListener(new SettingQTColorPickerLayout.ActionListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTPenLayout.setViewModeColorDetail.3
                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTColorPickerLayout.ActionListener
                public void onColorTap() {
                    SettingQTPenLayout.this.updateView(4);
                    SettingQTPenLayout.setViewMode$default(SettingQTPenLayout.this, ViewMode.MAIN, false, true, false, 8, null);
                }
            });
        }
        SettingQTColorPickerLayout settingQTColorPickerLayout7 = this.mColorPickerLayout;
        if (settingQTColorPickerLayout7 != null) {
            settingQTColorPickerLayout7.setVisibility(0, animation);
        }
        SettingQTColorPickerLayout settingQTColorPickerLayout8 = this.mColorPickerLayout;
        if (settingQTColorPickerLayout8 != null) {
            settingQTColorPickerLayout8.setShouldShowHueWheel(false);
        }
        QTBackground3 qTBackground3 = this.mBigBackgroundView;
        SpenPenAttrMiniView spenPenAttrMiniView = null;
        if (qTBackground3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBigBackgroundView");
            qTBackground3 = null;
        }
        qTBackground3.show();
        SettingQTColorLayout settingQTColorLayout = this.mColorLayout;
        if (settingQTColorLayout != null) {
            settingQTColorLayout.setVisibility(0);
        }
        SettingQTAttributesLayout settingQTAttributesLayout = this.mAttributeLayout;
        if (settingQTAttributesLayout != null) {
            settingQTAttributesLayout.setVisibility(8);
        }
        ChipView chipView = this.mColorPickerItem;
        if (chipView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorPickerItem");
            chipView = null;
        }
        chipView.setVisibility(0);
        ChipView chipView2 = this.mEyedropperItem;
        if (chipView2 != null) {
            chipView2.setVisibility(0);
        }
        SpenPenAttrMiniView spenPenAttrMiniView2 = this.mAttrItem;
        if (spenPenAttrMiniView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAttrItem");
        } else {
            spenPenAttrMiniView = spenPenAttrMiniView2;
        }
        spenPenAttrMiniView.setVisibility(0);
    }

    private final void setViewModeColorPicker(boolean animation) {
        SpenPenAttrMiniView spenPenAttrMiniView;
        SpenSettingUIPenInfo penInfo = this.mPenInfoManager.getPenInfo();
        if (penInfo == null) {
            return;
        }
        SettingQTColorPickerLayout settingQTColorPickerLayout = this.mColorPickerLayout;
        if (settingQTColorPickerLayout == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            SettingQTColorPickerLayout settingQTColorPickerLayout2 = new SettingQTColorPickerLayout(context, penInfo.hsv);
            this.mColorPickerLayout = settingQTColorPickerLayout2;
            settingQTColorPickerLayout2.setColorTheme(this.mColorThemeUtil.getColorTheme());
            SettingQTColorPickerLayout settingQTColorPickerLayout3 = this.mColorPickerLayout;
            if (settingQTColorPickerLayout3 != null) {
                settingQTColorPickerLayout3.setOnColorChangedListener(new SpenColorPickerDataChangedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTPenLayout.setViewModeColorPicker.1
                    @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenColorPickerDataChangedListener
                    public void onColorChanged(int color, float[] hsvColor) {
                        Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
                        SettingQTPenLayout.this.mPenInfoManager.updateColor(PaletteDefine.getColorUIInfo(1, 4), hsvColor);
                        SettingQTPenLayout.this.updateView(4);
                    }
                });
            }
            SettingQTColorPickerLayout settingQTColorPickerLayout4 = this.mColorPickerLayout;
            if (settingQTColorPickerLayout4 != null) {
                settingQTColorPickerLayout4.setAnimationListener(new SettingQTColorPickerLayout.AnimationListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTPenLayout.setViewModeColorPicker.2
                    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTColorPickerLayout.AnimationListener
                    public void onAnimationEnd(boolean isShowAnimation) {
                        SettingQTColorPickerLayout settingQTColorPickerLayout5;
                        if (isShowAnimation || (settingQTColorPickerLayout5 = SettingQTPenLayout.this.mColorPickerLayout) == null) {
                            return;
                        }
                        settingQTColorPickerLayout5.setVisibility(8, false);
                    }
                });
            }
            SettingQTColorPickerLayout settingQTColorPickerLayout5 = this.mColorPickerLayout;
            Intrinsics.checkNotNull(settingQTColorPickerLayout5);
            addSubView(settingQTColorPickerLayout5, C9086R.id.qt_sub_color_picker, true);
        } else if (settingQTColorPickerLayout != null) {
            settingQTColorPickerLayout.setCurrentColor(penInfo.hsv);
        }
        SettingQTColorPickerLayout settingQTColorPickerLayout6 = this.mColorPickerLayout;
        if (settingQTColorPickerLayout6 != null) {
            settingQTColorPickerLayout6.setOnActionListener(new SettingQTColorPickerLayout.ActionListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTPenLayout.setViewModeColorPicker.3
                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTColorPickerLayout.ActionListener
                public void onColorTap() {
                    SettingQTPenLayout.this.updateView(4);
                    SettingQTPenLayout.setViewMode$default(SettingQTPenLayout.this, ViewMode.COLOR, true, true, false, 8, null);
                }
            });
        }
        SettingQTColorPickerLayout settingQTColorPickerLayout7 = this.mColorPickerLayout;
        if (settingQTColorPickerLayout7 != null) {
            settingQTColorPickerLayout7.setVisibility(0, animation);
        }
        SettingQTColorPickerLayout settingQTColorPickerLayout8 = this.mColorPickerLayout;
        if (settingQTColorPickerLayout8 != null) {
            settingQTColorPickerLayout8.setShouldShowHueWheel(true);
        }
        QTBackground3 qTBackground3 = this.mBigBackgroundView;
        if (qTBackground3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBigBackgroundView");
            qTBackground3 = null;
        }
        qTBackground3.show();
        SettingQTColorLayout settingQTColorLayout = this.mColorLayout;
        if (settingQTColorLayout != null) {
            settingQTColorLayout.setVisibility(8, animation);
        }
        SettingQTAttributesLayout settingQTAttributesLayout = this.mAttributeLayout;
        if (settingQTAttributesLayout != null) {
            settingQTAttributesLayout.setVisibility(8);
        }
        ChipView chipView = this.mColorPickerItem;
        if (chipView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorPickerItem");
            chipView = null;
        }
        chipView.setVisibility(0);
        ChipView chipView2 = this.mEyedropperItem;
        if (chipView2 != null) {
            chipView2.setVisibility(0);
        }
        SpenPenAttrMiniView spenPenAttrMiniView2 = this.mAttrItem;
        if (spenPenAttrMiniView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAttrItem");
            spenPenAttrMiniView = null;
        } else {
            spenPenAttrMiniView = spenPenAttrMiniView2;
        }
        QTAnimationKt.scale((View) spenPenAttrMiniView, 1.0f, 0.0f, 0L, 350L);
    }

    private final void setViewModeMain(final boolean animation) {
        SettingQTAttributesLayout settingQTAttributesLayout = this.mAttributeLayout;
        if (settingQTAttributesLayout != null) {
            settingQTAttributesLayout.setVisibility(8, animation);
        }
        SettingQTColorPickerLayout settingQTColorPickerLayout = this.mColorPickerLayout;
        if (settingQTColorPickerLayout != null) {
            ViewMode viewMode = this.mViewMode;
            settingQTColorPickerLayout.setVisibility(8, viewMode == ViewMode.COLOR_PICKER || viewMode == ViewMode.COLOR_DETAIL);
        }
        QTBackground3 qTBackground3 = this.mBigBackgroundView;
        SpenPenAttrMiniView spenPenAttrMiniView = null;
        if (qTBackground3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBigBackgroundView");
            qTBackground3 = null;
        }
        qTBackground3.hide();
        SettingQTPatternLayout settingQTPatternLayout = this.mPatternLayout;
        if (settingQTPatternLayout != null) {
            settingQTPatternLayout.setVisibility(8, animation);
        }
        if (this.mColorLayout == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            SettingQTColorLayout settingQTColorLayout = new SettingQTColorLayout(context, this.mIsSupportEyedropper);
            this.mColorLayout = settingQTColorLayout;
            settingQTColorLayout.setColorTheme(this.mColorThemeUtil.getColorTheme());
            SettingQTColorLayout settingQTColorLayout2 = this.mColorLayout;
            if (settingQTColorLayout2 != null) {
                settingQTColorLayout2.setPaletteList(this.mPaletteList);
            }
            SettingQTColorLayout settingQTColorLayout3 = this.mColorLayout;
            if (settingQTColorLayout3 != null) {
                settingQTColorLayout3.setRecentColor(this.mRecentColors);
            }
            SettingQTColorLayout settingQTColorLayout4 = this.mColorLayout;
            if (settingQTColorLayout4 != null) {
                settingQTColorLayout4.setOnColorChangedListener(new SettingQTColorLayout.OnColorChangedListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTPenLayout.setViewModeMain.1
                    @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTColorLayout.OnColorChangedListener
                    public void onColorChanged(int info, float[] hsvColor, boolean isSame) {
                        Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
                        if (isSame) {
                            SettingQTColorPickerLayout settingQTColorPickerLayout2 = SettingQTPenLayout.this.mColorPickerLayout;
                            if (settingQTColorPickerLayout2 == null || settingQTColorPickerLayout2.getVisibility() != 0) {
                                SettingQTPenLayout.setViewMode$default(SettingQTPenLayout.this, ViewMode.COLOR_DETAIL, true, true, false, 8, null);
                                return;
                            } else {
                                SettingQTPenLayout.setViewMode$default(SettingQTPenLayout.this, ViewMode.MAIN, false, true, false, 8, null);
                                return;
                            }
                        }
                        SettingQTPenLayout.this.mPenInfoManager.updateColor(info, hsvColor);
                        SettingQTPenLayout.this.updateView(4);
                        SettingQTColorPickerLayout settingQTColorPickerLayout3 = SettingQTPenLayout.this.mColorPickerLayout;
                        if (settingQTColorPickerLayout3 == null || settingQTColorPickerLayout3.getVisibility() != 0) {
                            return;
                        }
                        SettingQTPenLayout.setViewMode$default(SettingQTPenLayout.this, ViewMode.MAIN, false, true, false, 8, null);
                    }
                });
            }
            SettingQTColorLayout settingQTColorLayout5 = this.mColorLayout;
            Intrinsics.checkNotNull(settingQTColorLayout5);
            addSubView(settingQTColorLayout5, C9086R.id.qt_sub_color, true);
        }
        updateColor(animation);
        final ViewMode viewMode2 = this.mViewMode;
        if (viewMode2 == ViewMode.ATTRIBUTES) {
            postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTPenLayout$setViewModeMain$$inlined$postDelayed$1
                @Override // java.lang.Runnable
                public final void run() {
                    this.this$0.animateColorMode(viewMode2, animation);
                }
            }, 200L);
        } else {
            animateColorMode(viewMode2, animation);
        }
        setBaseContentVisibility(0);
        SpenPenAttrMiniView spenPenAttrMiniView2 = this.mAttrItem;
        if (spenPenAttrMiniView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAttrItem");
        } else {
            spenPenAttrMiniView = spenPenAttrMiniView2;
        }
        spenPenAttrMiniView.setVisibility(0);
    }

    private final void setViewModePattern(boolean animation) {
        SettingQTPatternLayout settingQTPatternLayout;
        if (this.mPatternLayout == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            SettingQTPatternLayout settingQTPatternLayout2 = new SettingQTPatternLayout(context);
            this.mPatternLayout = settingQTPatternLayout2;
            settingQTPatternLayout2.setOnPatternChangedListener(new SettingQTPatternLayout.OnPatternChangeListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTPenLayout.setViewModePattern.1
                @Override // com.samsung.android.support.senl.nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTPatternLayout.OnPatternChangeListener
                public void onPatternChanged(String resName, int resId, float size) {
                    Intrinsics.checkNotNullParameter(resName, "resName");
                    ChipView chipView = SettingQTPenLayout.this.mPatternItem;
                    if (chipView != null) {
                        chipView.setColorRes(resId);
                    }
                    SettingQTPenLayout.this.mPenInfoManager.updateParticleSize(size);
                    SettingQTPenLayout.this.updateView(2);
                    SettingQTPenLayout.setViewMode$default(SettingQTPenLayout.this, ViewMode.COLOR, true, true, false, 8, null);
                }
            });
            SettingQTPatternLayout settingQTPatternLayout3 = this.mPatternLayout;
            Intrinsics.checkNotNull(settingQTPatternLayout3);
            addSubView(settingQTPatternLayout3, C9086R.id.qt_sub_pattern, true);
        }
        SpenSettingUIPenInfo penInfo = this.mPenInfoManager.getPenInfo();
        if (penInfo != null) {
            List<String> resourceList = this.mPatternDataManager.getResourceList(penInfo.name);
            if (resourceList != null && (settingQTPatternLayout = this.mPatternLayout) != null) {
                settingQTPatternLayout.setPatternList(resourceList, this.mPatternDataManager.getSizeList(penInfo.name));
            }
            SettingQTPatternLayout settingQTPatternLayout4 = this.mPatternLayout;
            if (settingQTPatternLayout4 != null) {
                settingQTPatternLayout4.setPatternSize(penInfo.particleSize, false);
            }
        }
        setBaseContentVisibility(0);
        SettingQTPatternLayout settingQTPatternLayout5 = this.mPatternLayout;
        if (settingQTPatternLayout5 != null) {
            settingQTPatternLayout5.setVisibility(0, animation);
        }
        SettingQTColorLayout settingQTColorLayout = this.mColorLayout;
        if (settingQTColorLayout != null) {
            settingQTColorLayout.setVisibility(8);
        }
        SettingQTAttributesLayout settingQTAttributesLayout = this.mAttributeLayout;
        if (settingQTAttributesLayout != null) {
            settingQTAttributesLayout.setVisibility(8);
        }
        SettingQTColorPickerLayout settingQTColorPickerLayout = this.mColorPickerLayout;
        if (settingQTColorPickerLayout != null) {
            settingQTColorPickerLayout.setVisibility(8);
        }
        QTBackground3 qTBackground3 = this.mBigBackgroundView;
        ChipView chipView = null;
        if (qTBackground3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mBigBackgroundView");
            qTBackground3 = null;
        }
        qTBackground3.setVisibility(8);
        ChipView chipView2 = this.mColorPickerItem;
        if (chipView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorPickerItem");
        } else {
            chipView = chipView2;
        }
        chipView.setVisibility(8);
        ChipView chipView3 = this.mEyedropperItem;
        if (chipView3 != null) {
            chipView3.setVisibility(8);
        }
    }

    private final void setupEyedropperItem() {
        ChipView chipViewInitFixedItem = initFixedItem(new SettingQTColorDialLayout.FixedItem(C9086R.drawable.qt_ic_spoid, 0, getResources().getString(C9086R.string.pen_string_color_spuit)), 80.0d);
        chipViewInitFixedItem.setOnClickListener(new ViewOnClickListenerC10782d(this, 3));
        this.mEyedropperItem = chipViewInitFixedItem;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupEyedropperItem$lambda$6$lambda$5(SettingQTPenLayout settingQTPenLayout, View view) {
        OnActionButtonListener onActionButtonListener = settingQTPenLayout.mPaletteActionButtonListener;
        if (onActionButtonListener != null) {
            onActionButtonListener.onButtonClick(2);
        }
    }

    public static /* synthetic */ void updateColor$default(SettingQTPenLayout settingQTPenLayout, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        settingQTPenLayout.updateColor(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateView(int updateInfo) {
        SettingQTAttributesLayout settingQTAttributesLayout;
        SpenSettingUIPenInfo penInfo = this.mPenInfoManager.getPenInfo();
        if (penInfo == null) {
            return;
        }
        if ((updateInfo & 2) == 2) {
            setItemAttribute(this.mPenInfoManager.getMIsSupportAlpha());
        }
        SpenPenAttrMiniView spenPenAttrMiniView = null;
        if ((updateInfo & 4) == 4) {
            int color = this.mColorThemeUtil.getColor(penInfo.color);
            SpenPenAttrMiniView spenPenAttrMiniView2 = this.mAttrItem;
            if (spenPenAttrMiniView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAttrItem");
                spenPenAttrMiniView2 = null;
            }
            spenPenAttrMiniView2.setColor(color);
            SettingQTAttributesLayout settingQTAttributesLayout2 = this.mAttributeLayout;
            if (settingQTAttributesLayout2 != null) {
                settingQTAttributesLayout2.setColor(color);
            }
            SettingQTColorLayout settingQTColorLayout = this.mColorLayout;
            if (settingQTColorLayout != null) {
                settingQTColorLayout.setColor(penInfo.colorUIInfo, penInfo.hsv, false);
            }
            SettingQTColorLayout settingQTColorLayout2 = this.mColorLayout;
            if (settingQTColorLayout2 != null) {
                ChipView chipView = this.mColorPickerItem;
                if (chipView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mColorPickerItem");
                    chipView = null;
                }
                settingQTColorLayout2.applyPickerColor(chipView);
            }
            SettingQTColorPickerLayout settingQTColorPickerLayout = this.mColorPickerLayout;
            if (settingQTColorPickerLayout != null) {
                settingQTColorPickerLayout.setCurrentColor(penInfo.hsv);
            }
        }
        if ((updateInfo & 1) == 1) {
            SpenPenAttrMiniView spenPenAttrMiniView3 = this.mAttrItem;
            if (spenPenAttrMiniView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAttrItem");
                spenPenAttrMiniView3 = null;
            }
            spenPenAttrMiniView3.setSizeLevel(penInfo.sizeLevel);
            SettingQTAttributesLayout settingQTAttributesLayout3 = this.mAttributeLayout;
            if (settingQTAttributesLayout3 != null) {
                settingQTAttributesLayout3.setSizeLevel(penInfo.sizeLevel);
            }
        }
        if ((updateInfo & 32) == 32 && (settingQTAttributesLayout = this.mAttributeLayout) != null) {
            settingQTAttributesLayout.setFixedWidth(penInfo.isFixedWidth);
        }
        if ((updateInfo & 16) == 16) {
            int color2 = this.mColorThemeUtil.getColor(penInfo.color);
            SpenPenAttrMiniView spenPenAttrMiniView4 = this.mAttrItem;
            if (spenPenAttrMiniView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAttrItem");
            } else {
                spenPenAttrMiniView = spenPenAttrMiniView4;
            }
            spenPenAttrMiniView.setColor(color2);
        }
        if ((updateInfo & 8) == 8) {
            String resource = this.mPatternDataManager.getResource(penInfo.name, penInfo.particleSize);
            ChipView chipView2 = this.mPatternItem;
            if (chipView2 != null) {
                chipView2.setColorRes(getDrawableId(resource));
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTLayout
    public void close() {
        super.close();
        this.mPatternDataManager.close();
        this.mPenInfoManager.close();
        this.mPaletteList.clear();
        this.mRecentColors.clear();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTLayout
    public boolean getVisibleContentRect(@NotNull Rect rect) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        if (WhenMappings.$EnumSwitchMapping$0[this.mViewMode.ordinal()] != 1) {
            return super.getVisibleContentRect(rect);
        }
        SettingQTColorPickerLayout settingQTColorPickerLayout = this.mColorPickerLayout;
        if (settingQTColorPickerLayout == null) {
            return false;
        }
        rect.set(settingQTColorPickerLayout.getLeft(), settingQTColorPickerLayout.getTop(), settingQTColorPickerLayout.getRight(), settingQTColorPickerLayout.getBottom());
        return true;
    }

    public final void setColorTheme(int theme) {
        this.mColorThemeUtil.setColorTheme(theme);
        SettingQTColorLayout settingQTColorLayout = this.mColorLayout;
        if (settingQTColorLayout != null) {
            settingQTColorLayout.setColorTheme(theme);
        }
        SettingQTColorPickerLayout settingQTColorPickerLayout = this.mColorPickerLayout;
        if (settingQTColorPickerLayout != null) {
            settingQTColorPickerLayout.setColorTheme(theme);
        }
    }

    public final void setEyedropperEnabled(boolean enabled) {
        if (this.mIsSupportEyedropper == enabled) {
            return;
        }
        this.mIsSupportEyedropper = enabled;
        if (enabled) {
            setupEyedropperItem();
            return;
        }
        ChipView chipView = this.mEyedropperItem;
        if (chipView != null) {
            removeEdgeView(chipView);
        }
        this.mEyedropperItem = null;
    }

    public final void setInfo(@Nullable SpenSettingUIPenInfo info, int index) {
        Logger.m11003i(TAG, "setPenInfo() index=" + index + ", name=" + (info != null ? info.name : null));
        boolean z = this.mPenInfoManager.getPenInfo() == null || info == null;
        Logger.m11003i(TAG, "setInfo() index=" + index + ", forceUpdate=" + z);
        if (info != null) {
            setInfo(info, index, false);
        } else {
            this.mPenInfoManager.clearData();
            updateView(63);
        }
        if (z) {
            setViewMode(this.mViewMode, false, false, true);
        }
    }

    public final void setPaletteActionButtonListener(@Nullable OnActionButtonListener listener) {
        this.mPaletteActionButtonListener = listener;
    }

    public final void setPaletteList(@NotNull List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        AbstractC8014b.m7217s(list.size(), "setPaletteList() size=", TAG);
        if (Intrinsics.areEqual(this.mPaletteList, list)) {
            Logger.m11003i(TAG, "Same Palette List.");
            return;
        }
        Logger.m11003i(TAG, "Update Palette.");
        this.mPaletteList.clear();
        this.mPaletteList.addAll(list);
        SettingQTColorLayout settingQTColorLayout = this.mColorLayout;
        if (settingQTColorLayout != null) {
            settingQTColorLayout.setPaletteList(list);
        }
        ViewMode viewMode = this.mViewMode;
        if (viewMode == ViewMode.COLOR || viewMode == ViewMode.MAIN) {
            updateColor$default(this, false, 1, null);
        }
    }

    public final void setPenInfoChangedListener(@NotNull SpenSettingQTPenInfoChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mPenInfoManager.setPenInfoChangedListener(listener);
    }

    public final void setPenInfoList(@NotNull List<? extends SpenSettingUIPenInfo> list, int selectedIndex) {
        Intrinsics.checkNotNullParameter(list, "list");
        int size = list.size();
        ViewMode viewMode = this.mViewMode;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(size, selectedIndex, "setPenList() size=", ", selected=", ", mode=");
        sbM1173s.append(viewMode);
        Logger.m11003i(TAG, sbM1173s.toString());
        boolean z = this.mPenInfoManager.getPenIndex() == -1 || selectedIndex == -1;
        this.mPenInfoManager.setPenInfoList(list, selectedIndex);
        updateView(63);
        if (z) {
            Logger.m11003i(TAG, "Call setViewMode() in setPenInfoList()");
            setViewMode(this.mViewMode, false, false, true);
        }
    }

    public final void setRecentColor(@NotNull List<SpenHSVColor> recentList) {
        Intrinsics.checkNotNullParameter(recentList, "recentList");
        AbstractC8014b.m7217s(recentList.size(), "setRecentColor() size=", TAG);
        if (Intrinsics.areEqual(this.mRecentColors, recentList)) {
            Logger.m11003i(TAG, "Same Recent List.");
            return;
        }
        this.mRecentColors.clear();
        this.mRecentColors.addAll(recentList);
        SettingQTColorLayout settingQTColorLayout = this.mColorLayout;
        if (settingQTColorLayout != null) {
            settingQTColorLayout.setRecentColor(recentList);
        }
        ViewMode viewMode = this.mViewMode;
        if (viewMode == ViewMode.COLOR || viewMode == ViewMode.MAIN) {
            updateColor(false);
        }
    }

    public final void setRotation(@NotNull SpenSettingQTPenContainer.RotationType rotationType) {
        View viewFindViewById;
        Intrinsics.checkNotNullParameter(rotationType, "rotationType");
        if (this.rotationType == rotationType) {
            return;
        }
        this.rotationType = rotationType;
        float f = rotationType == SpenSettingQTPenContainer.RotationType.LEFT_DOCKING ? 0.0f : 180.0f;
        SettingQTAttributesLayout settingQTAttributesLayout = this.mAttributeLayout;
        if (settingQTAttributesLayout == null || (viewFindViewById = settingQTAttributesLayout.findViewById(C9086R.id.dial_handler_label_text)) == null) {
            return;
        }
        viewFindViewById.setRotationY(f);
    }

    public final void setViewMode(@NotNull ViewMode mode, boolean animation, boolean notify, boolean forceUpdate) {
        OnViewModeChangedListener onViewModeChangedListener;
        Intrinsics.checkNotNullParameter(mode, "mode");
        if (this.mViewMode == mode && !forceUpdate) {
            Logger.m11003i(TAG, "sameViewMode. mode=" + mode);
            return;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[mode.ordinal()]) {
            case 1:
                setViewModeColorPicker(animation);
                break;
            case 2:
            case 3:
                setViewModeMain(animation);
                break;
            case 4:
                setViewModeAttributes(animation);
                break;
            case 5:
                setViewModeColorDetail(animation);
                break;
            case 6:
                setViewModePattern(animation);
                break;
        }
        this.mViewMode = mode;
        if (!notify || (onViewModeChangedListener = this.mViewModeChangedListener) == null) {
            return;
        }
        onViewModeChangedListener.onViewModeChanged(mode);
    }

    public final void setViewModeChangedListener(@NotNull OnViewModeChangedListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mViewModeChangedListener = listener;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.toolbar.quicktool.docking.SettingQTLayout
    public boolean startAnimation(@NotNull SettingQTLayout.AnimationType type, @Nullable SettingQTLayout.AnimationEndListener listener) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (type == SettingQTLayout.AnimationType.OPEN) {
            setViewMode(this.mViewMode, true, true, true);
        } else if (type == SettingQTLayout.AnimationType.TOGGLE_TO_SHOW) {
            setViewMode(this.mViewMode, false, true, true);
        }
        return super.startAnimation(type, listener);
    }

    public final void updateColor(boolean moveToCurrent) {
        SpenSettingUIPenInfo penInfo = this.mPenInfoManager.getPenInfo();
        if (penInfo != null) {
            SettingQTColorLayout settingQTColorLayout = this.mColorLayout;
            if (settingQTColorLayout != null) {
                settingQTColorLayout.setColor(penInfo.colorUIInfo, penInfo.hsv, moveToCurrent);
            }
            SettingQTColorLayout settingQTColorLayout2 = this.mColorLayout;
            if (settingQTColorLayout2 != null) {
                ChipView chipView = this.mColorPickerItem;
                if (chipView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mColorPickerItem");
                    chipView = null;
                }
                settingQTColorLayout2.applyPickerColor(chipView);
            }
        }
    }

    private final void setInfo(SpenSettingUIPenInfo info, int index, boolean notify) {
        boolean zUpdatePenInfo = this.mPenInfoManager.updatePenInfo(index, info, notify);
        String str = info.name;
        int i = info.sizeLevel;
        float[] fArr = info.hsv;
        float f = fArr[0];
        float f4 = fArr[1];
        float f5 = fArr[2];
        StringBuilder sbM1629s = AbstractC2322a.m1629s("setInfo() index=", index, ", name=", str, ", sizeLevel=");
        sbM1629s.append(i);
        sbM1629s.append(", hsv[");
        sbM1629s.append(f);
        sbM1629s.append(",");
        AbstractC11014a.m12337v(sbM1629s, f4, ",", f5, "] isChanged=");
        AbstractC8014b.m7222x(sbM1629s, zUpdatePenInfo, TAG);
        updateView(63);
    }
}
