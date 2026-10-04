package com.samsung.android.sdk.pen.setting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.LinearLayout;
import androidx.compose.foundation.layout.AbstractC1038a;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.sdk.pen.setting.SpenPatternControl;
import com.samsung.android.sdk.pen.setting.color.SpenColorThemeUtil;
import com.samsung.android.sdk.pen.setting.colorpalette.OnActionButtonListener;
import com.samsung.android.sdk.pen.setting.colorpalette.OnColorChangeListener;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenExtendedColorLayout;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenHSVColor;
import com.samsung.android.sdk.pen.setting.handwriting.SpenPenLayout;
import com.samsung.android.sdk.pen.setting.handwriting.SpenPenLayoutInterface;
import com.samsung.android.sdk.pen.setting.handwriting.SpenPenOpacityLayout;
import com.samsung.android.sdk.pen.setting.handwriting.SpenPenOpacityLayoutInterface;
import com.samsung.android.sdk.pen.setting.handwriting.SpenPenSizeLayout;
import com.samsung.android.sdk.pen.setting.handwriting.SpenPenSizeLayoutInterface;
import com.samsung.android.sdk.pen.setting.handwriting.SpenPenWidthLayout;
import com.samsung.android.sdk.pen.setting.handwriting.SpenPenWidthLayoutInterface;
import com.samsung.android.sdk.pen.setting.handwriting.SpenSettingPenManager;
import com.samsung.android.sdk.pen.setting.patternpalette.SpenRectPatternLayout;
import com.samsung.android.sdk.pen.setting.pencommon.PenInfoChangedListener;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtil;
import com.samsung.android.sdk.pen.setting.util.SpenSettingUtilOpacity;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0012\n\u0002\u0010\u0007\n\u0002\b\n\b\u0007\u0018\u0000 Z2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001ZB5\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eBE\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0007\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0007¢\u0006\u0004\b\r\u0010\u0011J\u0006\u0010)\u001a\u00020*J\u0018\u0010+\u001a\u00020*2\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010-H\u0016J\u0010\u0010/\u001a\u00020*2\u0006\u00100\u001a\u00020.H\u0016J\n\u00101\u001a\u0004\u0018\u00010.H\u0016J\u0012\u00102\u001a\u00020*2\b\u00103\u001a\u0004\u0018\u000104H\u0016J\u0018\u00105\u001a\u00020*2\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010-H\u0016J\u0010\u00106\u001a\u00020*2\u0006\u00107\u001a\u00020\bH\u0016J\u0012\u00108\u001a\u00020*2\b\u00103\u001a\u0004\u0018\u000109H\u0016J\u0012\u0010:\u001a\u00020*2\b\u00103\u001a\u0004\u0018\u00010;H\u0016J\u0010\u0010<\u001a\u00020*2\u0006\u0010=\u001a\u00020>H\u0016J\u0018\u0010?\u001a\u00020*2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010-H\u0016J\u0012\u0010@\u001a\u00020*2\b\u00103\u001a\u0004\u0018\u00010'H\u0016J\u0018\u0010A\u001a\u00020\f2\u0006\u0010B\u001a\u00020\b2\b\u0010=\u001a\u0004\u0018\u00010>J\u001d\u0010C\u001a\u00020*2\u0006\u0010D\u001a\u00020\b2\u0006\u0010E\u001a\u00020\fH\u0000¢\u0006\u0002\bFJ<\u0010G\u001a\u00020*2\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0007H\u0002J4\u0010H\u001a\u00020*2\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00072\u0006\u0010I\u001a\u00020\fH\u0002J\u0010\u0010J\u001a\u00020*2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010K\u001a\u00020*H\u0002J\u0012\u0010L\u001a\u00020\f2\b\u0010M\u001a\u0004\u0018\u00010\u0010H\u0002J\u0018\u0010N\u001a\u00020\f2\u0006\u0010O\u001a\u00020\b2\u0006\u0010P\u001a\u00020QH\u0002J\u001a\u0010R\u001a\u00020\f2\u0006\u0010S\u001a\u00020\b2\b\u0010=\u001a\u0004\u0018\u00010>H\u0002J\u0010\u0010T\u001a\u00020\f2\u0006\u0010U\u001a\u00020\bH\u0002J\u0010\u0010V\u001a\u00020\f2\u0006\u0010W\u001a\u00020QH\u0002J\u0010\u0010X\u001a\u00020\f2\u0006\u0010Y\u001a\u00020\fH\u0002R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006["}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenSettingPenPanel;", "Landroid/widget/LinearLayout;", "Lcom/samsung/android/sdk/pen/setting/SpenPenSetting;", "Lcom/samsung/android/sdk/pen/setting/SpenPenSettingUI;", "context", "Landroid/content/Context;", "paletteList", "", "", "recentList", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenHSVColor;", "isSupportEyedropper", "", "<init>", "(Landroid/content/Context;Ljava/util/List;Ljava/util/List;Z)V", "customizedPenList", "", "(Landroid/content/Context;Ljava/util/List;Ljava/util/List;ZLjava/util/List;)V", "mColorThemeUtil", "Lcom/samsung/android/sdk/pen/setting/color/SpenColorThemeUtil;", "mPenManager", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenSettingPenManager;", "mPenLayout", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenLayout;", "mSizeLayout", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenSizeLayout;", "mColorLayout", "Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenExtendedColorLayout;", "mOpacityLayout", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenOpacityLayout;", "mWidthLayout", "Lcom/samsung/android/sdk/pen/setting/handwriting/SpenPenWidthLayout;", "mPortraitLayout", "Lcom/samsung/android/sdk/pen/setting/SpenPenSettingPortraitLayout;", "mPatternLayout", "Lcom/samsung/android/sdk/pen/setting/patternpalette/SpenRectPatternLayout;", "mPatternControl", "Lcom/samsung/android/sdk/pen/setting/SpenPatternControl;", "mRecentColorChangedListener", "Lcom/samsung/android/sdk/pen/setting/SpenRecentColorChangedListener;", "mIsSupportEyedropper", "close", "", "setPenInfoList", "uiPenInfoList", "", "Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "setInfo", "uiPenInfo", "getInfo", "setPenInfoChangedListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/pen/setting/pencommon/PenInfoChangedListener;", "setPalette", "setCurrentPalette", "paletteID", "setPaletteActionButtonListener", "Lcom/samsung/android/sdk/pen/setting/colorpalette/OnActionButtonListener;", "setPaletteActionListener", "Lcom/samsung/android/sdk/pen/setting/SpenPaletteActionListener;", "addRecentColor", "hsvColor", "", "setRecentColor", "setRecentColorChangedListener", "setCurrentColor", "colorFrom", "updateView", "updateInfo", "needOpacityAnimation", "updateView$SDK_fullRelease", "construct", "initView", "makePatternView", "initLayout", "initPatternControl", "changePen", "penName", "changeCurrentSize", "sizeLevel", "dpSize", "", "changeCurrentColor", "info", "changeAlpha", "alpha", "changeCurrentParticleSize", "size", "changePenWidth", "isFixed", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"ViewConstructor"})
public final class SpenSettingPenPanel extends LinearLayout implements SpenPenSetting, SpenPenSettingUI {
    public static final int COLOR_FROM_EYEDROPPER = 2;
    public static final int COLOR_FROM_NONE = 0;
    public static final int COLOR_FROM_PICKER = 1;

    @NotNull
    private static final String TAG = "SpenSettingPenPanel";
    private static final int UPDATE_ALL = 63;
    private static final int UPDATE_COLOR = 4;
    private static final int UPDATE_OPACITY = 16;
    private static final int UPDATE_PATTERN = 8;
    private static final int UPDATE_PEN = 2;
    private static final int UPDATE_SIZE = 1;
    private static final int UPDATE_WIDTH = 32;
    private SpenExtendedColorLayout mColorLayout;

    @NotNull
    private SpenColorThemeUtil mColorThemeUtil;
    private boolean mIsSupportEyedropper;
    private SpenPenOpacityLayout mOpacityLayout;

    @Nullable
    private SpenPatternControl mPatternControl;

    @Nullable
    private SpenRectPatternLayout mPatternLayout;
    private SpenPenLayout mPenLayout;
    private SpenSettingPenManager mPenManager;
    private SpenPenSettingPortraitLayout mPortraitLayout;

    @Nullable
    private SpenRecentColorChangedListener mRecentColorChangedListener;
    private SpenPenSizeLayout mSizeLayout;
    private SpenPenWidthLayout mWidthLayout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenSettingPenPanel(@NotNull Context context, @NotNull List<Integer> paletteList, @NotNull List<SpenHSVColor> recentList, boolean z) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(paletteList, "paletteList");
        Intrinsics.checkNotNullParameter(recentList, "recentList");
        this.mIsSupportEyedropper = z;
        this.mColorThemeUtil = new SpenColorThemeUtil(context);
        construct(context, paletteList, recentList, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean changeAlpha(int alpha) {
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
        currentUIPenInfo.color = ((alpha << 24) & (-16777216)) | (currentUIPenInfo.color & 16777215);
        SpenSettingPenManager spenSettingPenManager3 = this.mPenManager;
        if (spenSettingPenManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenManager");
        } else {
            spenSettingPenManager2 = spenSettingPenManager3;
        }
        return spenSettingPenManager2.setCurrentUIPenInfo(currentUIPenInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean changeCurrentColor(int info, float[] hsvColor) {
        if (hsvColor == null) {
            return false;
        }
        Log.i(TAG, AbstractC1038a.m1216q(AbstractC2322a.m1628r("updateColor info=", info, " color[", hsvColor[0], SQLKeyword.COMMA), hsvColor[1], SQLKeyword.COMMA, hsvColor[2], "]"));
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

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean changeCurrentParticleSize(float size) {
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
        currentUIPenInfo.particleSize = size;
        SpenSettingPenManager spenSettingPenManager3 = this.mPenManager;
        if (spenSettingPenManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenManager");
        } else {
            spenSettingPenManager2 = spenSettingPenManager3;
        }
        return spenSettingPenManager2.setCurrentUIPenInfo(currentUIPenInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean changeCurrentSize(int sizeLevel, float dpSize) {
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
        currentUIPenInfo.size = dpSize;
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

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean changePenWidth(boolean isFixed) {
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
        currentUIPenInfo.isFixedWidth = isFixed;
        SpenSettingPenManager spenSettingPenManager3 = this.mPenManager;
        if (spenSettingPenManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenManager");
        } else {
            spenSettingPenManager2 = spenSettingPenManager3;
        }
        return spenSettingPenManager2.setCurrentUIPenInfo(currentUIPenInfo);
    }

    private final void construct(Context context, List<Integer> paletteList, List<SpenHSVColor> recentList, List<String> customizedPenList) {
        SpenSettingPenManager spenSettingPenManager = new SpenSettingPenManager(context, customizedPenList);
        this.mPenManager = spenSettingPenManager;
        boolean zContainsParticleSizePen = spenSettingPenManager.containsParticleSizePen();
        SpenSettingPenManager spenSettingPenManager2 = this.mPenManager;
        SpenSettingPenManager spenSettingPenManager3 = null;
        if (spenSettingPenManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenManager");
            spenSettingPenManager2 = null;
        }
        boolean zContainsAlphaChangeablePen = spenSettingPenManager2.containsAlphaChangeablePen();
        SpenSettingPenManager spenSettingPenManager4 = this.mPenManager;
        if (spenSettingPenManager4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenManager");
        } else {
            spenSettingPenManager3 = spenSettingPenManager4;
        }
        spenSettingPenManager3.setEnableAlphaChange(zContainsAlphaChangeablePen);
        initView(context, paletteList, recentList, zContainsParticleSizePen);
        initLayout(context);
        if (zContainsParticleSizePen) {
            initPatternControl();
        }
    }

    private final void initLayout(Context context) {
        SpenPenWidthLayout spenPenWidthLayout = null;
        SpenPenSettingPortraitLayout spenPenSettingPortraitLayout = new SpenPenSettingPortraitLayout(context, false, 2, null);
        this.mPortraitLayout = spenPenSettingPortraitLayout;
        spenPenSettingPortraitLayout.setContentView(this);
        SpenPenSizeLayout spenPenSizeLayout = this.mSizeLayout;
        if (spenPenSizeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSizeLayout");
            spenPenSizeLayout = null;
        }
        SpenPenLayout spenPenLayout = this.mPenLayout;
        if (spenPenLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
            spenPenLayout = null;
        }
        SpenExtendedColorLayout spenExtendedColorLayout = this.mColorLayout;
        if (spenExtendedColorLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorLayout");
            spenExtendedColorLayout = null;
        }
        SpenRectPatternLayout spenRectPatternLayout = this.mPatternLayout;
        SpenPenOpacityLayout spenPenOpacityLayout = this.mOpacityLayout;
        if (spenPenOpacityLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOpacityLayout");
            spenPenOpacityLayout = null;
        }
        SpenPenWidthLayout spenPenWidthLayout2 = this.mWidthLayout;
        if (spenPenWidthLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWidthLayout");
        } else {
            spenPenWidthLayout = spenPenWidthLayout2;
        }
        spenPenSettingPortraitLayout.attachChild(spenPenSizeLayout, spenPenLayout, spenExtendedColorLayout, spenRectPatternLayout, spenPenOpacityLayout, spenPenWidthLayout, null, null);
        spenPenSettingPortraitLayout.setViewMode(7);
        spenPenSettingPortraitLayout.setAttributeVisibility(false, false, false, false, false);
        spenPenSettingPortraitLayout.setPatternViewVisibility(false);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        AbstractC4539a.m3205o("initView density = ", TAG, displayMetrics.density);
        AbstractC2322a.m1631u(displayMetrics.densityDpi, "initView densityDpi = ", TAG);
        AbstractC2322a.m1631u(displayMetrics.widthPixels, "initView widthPixels = ", TAG);
        AbstractC2322a.m1631u(displayMetrics.heightPixels, "initView heightPixels = ", TAG);
    }

    private final void initPatternControl() {
        SpenPatternControl spenPatternControl = new SpenPatternControl();
        this.mPatternControl = spenPatternControl;
        spenPatternControl.setPatternLayout(this.mPatternLayout);
        SpenPatternControl spenPatternControl2 = this.mPatternControl;
        if (spenPatternControl2 != null) {
            spenPatternControl2.setOnPatternChangedListener(new SpenPatternControl.OnPatternChangeListener() { // from class: com.samsung.android.sdk.pen.setting.SpenSettingPenPanel.initPatternControl.1
                @Override // com.samsung.android.sdk.pen.setting.SpenPatternControl.OnPatternChangeListener
                public void onPatternChanged(String resName, float size) {
                    if (SpenSettingPenPanel.this.changeCurrentParticleSize(size)) {
                        SpenSettingPenPanel.this.updateView$SDK_fullRelease(2, false);
                    }
                }
            });
        }
    }

    private final void initView(Context context, List<Integer> paletteList, List<SpenHSVColor> recentList, boolean makePatternView) {
        SpenPenSizeLayout spenPenSizeLayout = new SpenPenSizeLayout(context);
        this.mSizeLayout = spenPenSizeLayout;
        spenPenSizeLayout.setActionListener(new SpenPenSizeLayoutInterface.ActionListener() { // from class: com.samsung.android.sdk.pen.setting.SpenSettingPenPanel.initView.1
            @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenSizeLayoutInterface.ActionListener
            public void onSizeChanged(int sizeLevel, float dpSize) {
                Log.i(SpenSettingPenPanel.TAG, "SpenPenSizeLayout.onSizeChanged() level=" + sizeLevel + " dpSize=" + dpSize);
                if (SpenSettingPenPanel.this.changeCurrentSize(sizeLevel, dpSize)) {
                    SpenSettingPenPanel.this.updateView$SDK_fullRelease(2, false);
                }
            }
        });
        SpenPenLayout spenPenLayout = new SpenPenLayout(context, true);
        this.mPenLayout = spenPenLayout;
        SpenSettingPenManager spenSettingPenManager = this.mPenManager;
        SpenPenOpacityLayout spenPenOpacityLayout = null;
        if (spenSettingPenManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenManager");
            spenSettingPenManager = null;
        }
        spenPenLayout.setPenList(spenSettingPenManager.getPenNameList());
        SpenPenLayout spenPenLayout2 = this.mPenLayout;
        if (spenPenLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
            spenPenLayout2 = null;
        }
        spenPenLayout2.setActionListener(new SpenPenLayoutInterface.OnActionListener() { // from class: com.samsung.android.sdk.pen.setting.SpenSettingPenPanel.initView.2
            @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenLayoutInterface.OnActionListener
            public void onPenClicked(String name, boolean isSelected) {
                if (isSelected) {
                    return;
                }
                AbstractC6670b.m4756q("SpenPenLayout.onPenChanged() name=", name, SpenSettingPenPanel.TAG);
                if (SpenSettingPenPanel.this.changePen(name)) {
                    SpenSettingPenPanel.this.updateView$SDK_fullRelease(63, true);
                }
            }
        });
        SpenExtendedColorLayout spenExtendedColorLayout = new SpenExtendedColorLayout(context, null, this.mIsSupportEyedropper);
        this.mColorLayout = spenExtendedColorLayout;
        spenExtendedColorLayout.setPaletteList(paletteList);
        SpenExtendedColorLayout spenExtendedColorLayout2 = this.mColorLayout;
        if (spenExtendedColorLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorLayout");
            spenExtendedColorLayout2 = null;
        }
        spenExtendedColorLayout2.setRecentColor(recentList);
        SpenExtendedColorLayout spenExtendedColorLayout3 = this.mColorLayout;
        if (spenExtendedColorLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorLayout");
            spenExtendedColorLayout3 = null;
        }
        spenExtendedColorLayout3.setOnColorChangeListener(new OnColorChangeListener() { // from class: com.samsung.android.sdk.pen.setting.SpenSettingPenPanel.initView.3
            @Override // com.samsung.android.sdk.pen.setting.colorpalette.OnColorChangeListener
            public void onColorChanged(int info, float[] hsvColor) {
                Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
                if (SpenSettingPenPanel.this.changeCurrentColor(info, hsvColor)) {
                    SpenSettingPenPanel.this.updateView$SDK_fullRelease(19, false);
                }
            }
        });
        if (makePatternView) {
            this.mPatternLayout = new SpenRectPatternLayout(context);
        }
        SpenPenOpacityLayout spenPenOpacityLayout2 = new SpenPenOpacityLayout(context);
        this.mOpacityLayout = spenPenOpacityLayout2;
        spenPenOpacityLayout2.setDataChangedListener(new SpenPenOpacityLayoutInterface.OnDataChangedListener() { // from class: com.samsung.android.sdk.pen.setting.SpenSettingPenPanel.initView.4
            @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenOpacityLayoutInterface.OnDataChangedListener
            public void onAlphaChanged(int alpha, boolean notify) {
                AbstractC2322a.m1631u(alpha, "onAlphaChanged() alpha=", SpenSettingPenPanel.TAG);
                if (SpenSettingPenPanel.this.changeAlpha(alpha)) {
                    SpenSettingPenPanel.this.updateView$SDK_fullRelease(3, false);
                }
            }
        });
        SpenPenOpacityLayout spenPenOpacityLayout3 = this.mOpacityLayout;
        if (spenPenOpacityLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOpacityLayout");
        } else {
            spenPenOpacityLayout = spenPenOpacityLayout3;
        }
        spenPenOpacityLayout.setSliderTrackListener(new SpenPenOpacityLayout.OnSliderTrackListener() { // from class: com.samsung.android.sdk.pen.setting.SpenSettingPenPanel.initView.5
            @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenOpacityLayout.OnSliderTrackListener
            public void onStartTrackingTouch() {
                SpenPenSizeLayout spenPenSizeLayout2 = SpenSettingPenPanel.this.mSizeLayout;
                if (spenPenSizeLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSizeLayout");
                    spenPenSizeLayout2 = null;
                }
                spenPenSizeLayout2.setThumbScaleAnimation(true);
            }

            @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenOpacityLayout.OnSliderTrackListener
            public void onStopTrackingTouch() {
                SpenPenSizeLayout spenPenSizeLayout2 = SpenSettingPenPanel.this.mSizeLayout;
                if (spenPenSizeLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mSizeLayout");
                    spenPenSizeLayout2 = null;
                }
                spenPenSizeLayout2.setThumbScaleAnimation(false);
            }
        });
        SpenPenWidthLayout spenPenWidthLayout = new SpenPenWidthLayout(context);
        this.mWidthLayout = spenPenWidthLayout;
        spenPenWidthLayout.setDataChangedListener(new SpenPenWidthLayoutInterface.OnDataChangedListener() { // from class: com.samsung.android.sdk.pen.setting.SpenSettingPenPanel.initView.6
            @Override // com.samsung.android.sdk.pen.setting.handwriting.SpenPenWidthLayoutInterface.OnDataChangedListener
            public void onPenWidthChanged(boolean isFixed) {
                AbstractC4539a.m3208r("onPenWidthChanged() isFixed=", SpenSettingPenPanel.TAG, isFixed);
                if (SpenSettingPenPanel.this.changePenWidth(isFixed)) {
                    SpenSettingPenPanel.this.updateView$SDK_fullRelease(2, false);
                }
            }
        });
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenSettingUI
    public void addRecentColor(@NotNull float[] hsvColor) {
        SpenRecentColorChangedListener spenRecentColorChangedListener;
        Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
        SpenExtendedColorLayout spenExtendedColorLayout = this.mColorLayout;
        SpenExtendedColorLayout spenExtendedColorLayout2 = null;
        if (spenExtendedColorLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorLayout");
            spenExtendedColorLayout = null;
        }
        if (spenExtendedColorLayout.addRecentColor(hsvColor) && (spenRecentColorChangedListener = this.mRecentColorChangedListener) != null) {
            SpenExtendedColorLayout spenExtendedColorLayout3 = this.mColorLayout;
            if (spenExtendedColorLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mColorLayout");
            } else {
                spenExtendedColorLayout2 = spenExtendedColorLayout3;
            }
            spenRecentColorChangedListener.onRecentColorChanged(spenExtendedColorLayout2.getRecentColor());
        }
    }

    public final void close() {
        Log.i(TAG, "close()");
        SpenPenLayout spenPenLayout = this.mPenLayout;
        if (spenPenLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
            spenPenLayout = null;
        }
        spenPenLayout.close();
        SpenPenSizeLayout spenPenSizeLayout = this.mSizeLayout;
        if (spenPenSizeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mSizeLayout");
            spenPenSizeLayout = null;
        }
        spenPenSizeLayout.close();
        SpenExtendedColorLayout spenExtendedColorLayout = this.mColorLayout;
        if (spenExtendedColorLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorLayout");
            spenExtendedColorLayout = null;
        }
        spenExtendedColorLayout.close();
        SpenPenOpacityLayout spenPenOpacityLayout = this.mOpacityLayout;
        if (spenPenOpacityLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOpacityLayout");
            spenPenOpacityLayout = null;
        }
        spenPenOpacityLayout.close();
        SpenPenWidthLayout spenPenWidthLayout = this.mWidthLayout;
        if (spenPenWidthLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWidthLayout");
            spenPenWidthLayout = null;
        }
        spenPenWidthLayout.close();
        SpenSettingPenManager spenSettingPenManager = this.mPenManager;
        if (spenSettingPenManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenManager");
            spenSettingPenManager = null;
        }
        spenSettingPenManager.close();
        this.mColorThemeUtil.close();
        SpenPenSettingPortraitLayout spenPenSettingPortraitLayout = this.mPortraitLayout;
        if (spenPenSettingPortraitLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPortraitLayout");
            spenPenSettingPortraitLayout = null;
        }
        spenPenSettingPortraitLayout.close();
        SpenRectPatternLayout spenRectPatternLayout = this.mPatternLayout;
        if (spenRectPatternLayout != null) {
            spenRectPatternLayout.close();
        }
        this.mPatternLayout = null;
        SpenPatternControl spenPatternControl = this.mPatternControl;
        if (spenPatternControl != null) {
            spenPatternControl.close();
        }
        this.mPatternControl = null;
        this.mRecentColorChangedListener = null;
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

    public final boolean setCurrentColor(int colorFrom, @Nullable float[] hsvColor) {
        if (hsvColor == null) {
            return false;
        }
        float f = hsvColor[0];
        Log.i(TAG, AbstractC1038a.m1216q(AbstractC2322a.m1628r("setCurrentColor() from=", colorFrom, "[", f, SQLKeyword.COMMA), hsvColor[1], SQLKeyword.COMMA, hsvColor[2], "]"));
        SpenExtendedColorLayout spenExtendedColorLayout = null;
        if (colorFrom == 1) {
            SpenExtendedColorLayout spenExtendedColorLayout2 = this.mColorLayout;
            if (spenExtendedColorLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mColorLayout");
            } else {
                spenExtendedColorLayout = spenExtendedColorLayout2;
            }
            spenExtendedColorLayout.setPickerColor(hsvColor);
            return true;
        }
        if (colorFrom != 2 || !this.mIsSupportEyedropper) {
            return false;
        }
        int iHSVToColor = SpenSettingUtil.HSVToColor(hsvColor);
        SpenExtendedColorLayout spenExtendedColorLayout3 = this.mColorLayout;
        if (spenExtendedColorLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorLayout");
        } else {
            spenExtendedColorLayout = spenExtendedColorLayout3;
        }
        spenExtendedColorLayout.setEyedropperColor(iHSVToColor);
        return true;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenSettingUI
    public void setCurrentPalette(int paletteID) {
        AbstractC2322a.m1631u(paletteID, "setCurrentPalette() paletteID=", TAG);
        SpenExtendedColorLayout spenExtendedColorLayout = this.mColorLayout;
        if (spenExtendedColorLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorLayout");
            spenExtendedColorLayout = null;
        }
        spenExtendedColorLayout.setPalette(paletteID);
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
        spenSettingPenManager.printInfo("SpenSettingPenLayout::setInfo()", uiPenInfo, false);
        SpenSettingPenManager spenSettingPenManager3 = this.mPenManager;
        if (spenSettingPenManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenManager");
        } else {
            spenSettingPenManager2 = spenSettingPenManager3;
        }
        if (spenSettingPenManager2.setCurrentUIPenInfo(uiPenInfo)) {
            updateView$SDK_fullRelease(63, false);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenSettingUI
    public void setPalette(@Nullable List<Integer> paletteList) {
        if (paletteList == null || paletteList.size() == 0) {
            Log.i(TAG, "Invalid paletteList information");
            return;
        }
        SpenExtendedColorLayout spenExtendedColorLayout = this.mColorLayout;
        if (spenExtendedColorLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorLayout");
            spenExtendedColorLayout = null;
        }
        if (spenExtendedColorLayout.setPaletteList(paletteList)) {
            updateView$SDK_fullRelease(4, false);
        }
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenSettingUI
    public void setPaletteActionButtonListener(@Nullable OnActionButtonListener listener) {
        SpenExtendedColorLayout spenExtendedColorLayout = this.mColorLayout;
        if (spenExtendedColorLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorLayout");
            spenExtendedColorLayout = null;
        }
        spenExtendedColorLayout.setOnActionButtonListener(listener);
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
        Log.i(TAG, "setPenInfoList() in SpenSettingPenPanel()");
        SpenSettingPenManager spenSettingPenManager = this.mPenManager;
        SpenSettingPenManager spenSettingPenManager2 = null;
        if (spenSettingPenManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenManager");
            spenSettingPenManager = null;
        }
        spenSettingPenManager.setUIPenInfoList(uiPenInfoList);
        SpenPenLayout spenPenLayout = this.mPenLayout;
        if (spenPenLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
            spenPenLayout = null;
        }
        SpenSettingPenManager spenSettingPenManager3 = this.mPenManager;
        if (spenSettingPenManager3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenManager");
        } else {
            spenSettingPenManager2 = spenSettingPenManager3;
        }
        spenPenLayout.setPenInfoList(spenSettingPenManager2.getPenInfoList());
        updateView$SDK_fullRelease(63, false);
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenSettingUI
    public void setRecentColor(@Nullable List<SpenHSVColor> recentList) {
        SpenExtendedColorLayout spenExtendedColorLayout = this.mColorLayout;
        if (spenExtendedColorLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mColorLayout");
            spenExtendedColorLayout = null;
        }
        spenExtendedColorLayout.setRecentColor(recentList);
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenSettingUI
    public void setRecentColorChangedListener(@Nullable SpenRecentColorChangedListener listener) {
        this.mRecentColorChangedListener = listener;
    }

    public final void updateView$SDK_fullRelease(int updateInfo, boolean needOpacityAnimation) {
        SpenPenSettingPortraitLayout spenPenSettingPortraitLayout;
        AbstractC6670b.m4754o("updateView() info=", updateInfo, " animation=", needOpacityAnimation, TAG);
        SpenSettingPenManager spenSettingPenManager = this.mPenManager;
        SpenPenSettingPortraitLayout spenPenSettingPortraitLayout2 = null;
        if (spenSettingPenManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPenManager");
            spenSettingPenManager = null;
        }
        SpenSettingUIPenInfo currentUIPenInfo = spenSettingPenManager.getCurrentUIPenInfo();
        if (currentUIPenInfo == null) {
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
        if ((updateInfo & 2) == 2) {
            SpenPenLayout spenPenLayout = this.mPenLayout;
            if (spenPenLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenLayout");
                spenPenLayout = null;
            }
            spenPenLayout.setPenInfo(currentUIPenInfo);
        }
        if ((updateInfo & 1) == 1) {
            int i = currentUIPenInfo.color;
            if (zIsSupportAlphaChange) {
                i = (i & 16777215) | (-16777216);
            }
            SpenPenSizeLayout spenPenSizeLayout = this.mSizeLayout;
            if (spenPenSizeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSizeLayout");
                spenPenSizeLayout = null;
            }
            spenPenSizeLayout.setPenInfo(null, currentUIPenInfo.sizeLevel, i);
        }
        if ((updateInfo & 16) == 16 && zIsSupportAlphaChange) {
            SpenPenOpacityLayout spenPenOpacityLayout = this.mOpacityLayout;
            if (spenPenOpacityLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOpacityLayout");
                spenPenOpacityLayout = null;
            }
            spenPenOpacityLayout.setColor(currentUIPenInfo.color);
        }
        if ((updateInfo & 32) == 32 && zIsSupportFixedWidthChange) {
            SpenPenWidthLayout spenPenWidthLayout = this.mWidthLayout;
            if (spenPenWidthLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWidthLayout");
                spenPenWidthLayout = null;
            }
            spenPenWidthLayout.setPenInfo(currentUIPenInfo.name, currentUIPenInfo.sizeLevel, currentUIPenInfo.color);
            SpenPenWidthLayout spenPenWidthLayout2 = this.mWidthLayout;
            if (spenPenWidthLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWidthLayout");
                spenPenWidthLayout2 = null;
            }
            spenPenWidthLayout2.setPenWidth(currentUIPenInfo.isFixedWidth, false);
        }
        SpenPenSettingPortraitLayout spenPenSettingPortraitLayout3 = this.mPortraitLayout;
        if (spenPenSettingPortraitLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPortraitLayout");
            spenPenSettingPortraitLayout = null;
        } else {
            spenPenSettingPortraitLayout = spenPenSettingPortraitLayout3;
        }
        spenPenSettingPortraitLayout.setAttributeVisibility(zIsSupportAlphaChange, zIsSupportFixedWidthChange, false, false, needOpacityAnimation);
        if ((updateInfo & 4) == 4) {
            SpenExtendedColorLayout spenExtendedColorLayout = this.mColorLayout;
            if (spenExtendedColorLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mColorLayout");
                spenExtendedColorLayout = null;
            }
            spenExtendedColorLayout.setColor(currentUIPenInfo.colorUIInfo, currentUIPenInfo.hsv);
        }
        if ((updateInfo & 8) == 8) {
            SpenSettingPenManager spenSettingPenManager4 = this.mPenManager;
            if (spenSettingPenManager4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPenManager");
                spenSettingPenManager4 = null;
            }
            boolean zIsSupportParticleSize = spenSettingPenManager4.isSupportParticleSize(currentUIPenInfo.name);
            if (zIsSupportParticleSize) {
                SpenPatternControl spenPatternControl = this.mPatternControl;
                if (spenPatternControl != null) {
                    spenPatternControl.setPattern(currentUIPenInfo.name);
                }
                SpenPatternControl spenPatternControl2 = this.mPatternControl;
                if (spenPatternControl2 != null) {
                    spenPatternControl2.setSize(currentUIPenInfo.particleSize, false);
                }
            }
            SpenPenSettingPortraitLayout spenPenSettingPortraitLayout4 = this.mPortraitLayout;
            if (spenPenSettingPortraitLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPortraitLayout");
            } else {
                spenPenSettingPortraitLayout2 = spenPenSettingPortraitLayout4;
            }
            spenPenSettingPortraitLayout2.setPatternViewVisibility(zIsSupportParticleSize);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenSettingPenPanel(@NotNull Context context, @NotNull List<Integer> paletteList, @NotNull List<SpenHSVColor> recentList, boolean z, @Nullable List<String> list) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(paletteList, "paletteList");
        Intrinsics.checkNotNullParameter(recentList, "recentList");
        setOrientation(1);
        this.mColorThemeUtil = new SpenColorThemeUtil(context);
        this.mIsSupportEyedropper = z;
        construct(context, paletteList, recentList, list);
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenPenSettingUI
    public void setPaletteActionListener(@Nullable SpenPaletteActionListener listener) {
    }
}
