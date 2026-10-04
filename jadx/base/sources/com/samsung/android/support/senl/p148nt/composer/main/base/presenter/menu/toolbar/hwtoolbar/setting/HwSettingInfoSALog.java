package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.setting;

import android.content.Context;
import com.samsung.android.sdk.pen.SpenSettingUIPenInfo;
import com.samsung.android.support.senl.p145cm.base.framework.support.ColorCompat;
import com.samsung.android.support.senl.p148nt.base.common.util.ResourceUtils;
import com.samsung.android.support.senl.p148nt.base.composer.common.BaseComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.common.ColorSettingUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.HWToolbarSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HwSettingInfoSALog extends ComposerSA {
    public static String NONE_TYPE = "0";
    private ContextReference mContextReference;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ContextReference {
        Context getContext();
    }

    public HwSettingInfoSALog(ContextReference contextReference) {
        this.mContextReference = contextReference;
    }

    public static int getAlphaPercent(int i) {
        return (((i >> 24) & 255) * 100) / 255;
    }

    public static String getSADetailHighlighterThicknessType(float f) {
        return isSameFloat(f, 1.0f) ? "3" : isSameFloat(f, 0.7f) ? "2" : isSameFloat(f, 0.5f) ? "1" : NONE_TYPE;
    }

    public static String getSADetailMakerType(String str) {
        str.getClass();
        switch (str) {
            case "com.samsung.android.sdk.pen.pen.preload.Marker3":
                return "2";
            case "com.samsung.android.sdk.pen.pen.preload.Marker4":
                return "1";
            case "com.samsung.android.sdk.pen.pen.preload.StraightHighlighter":
                return "3";
            case "com.samsung.android.sdk.pen.pen.preload.StraightMarker":
                return "4";
            default:
                return NONE_TYPE;
        }
    }

    public static String getSADetailMakerTypeInitialName(String str) {
        return !getSADetailMakerType(str).equals(NONE_TYPE) ? HWToolbarSAConstants.DETAIL_MARKER_PEN : NONE_TYPE;
    }

    public static String getSADetailPenType(String str) {
        str.getClass();
        switch (str) {
            case "com.samsung.android.sdk.pen.pen.preload.BrushPen":
                return "5";
            case "com.samsung.android.sdk.pen.pen.preload.InkPen2":
                return "3";
            case "com.samsung.android.sdk.pen.pen.preload.ObliquePen":
                return "2";
            case "com.samsung.android.sdk.pen.pen.preload.Pencil2":
                return "4";
            case "com.samsung.android.sdk.pen.pen.preload.FountainPen":
                return "1";
            default:
                return NONE_TYPE;
        }
    }

    public static String getSADetailPenTypeInitialName(String str) {
        str.getClass();
        switch (str) {
            case "com.samsung.android.sdk.pen.pen.preload.BrushPen":
                return "Cb";
            case "com.samsung.android.sdk.pen.pen.preload.InkPen2":
                return HWToolbarSAConstants.DETAIL_PEN;
            case "com.samsung.android.sdk.pen.pen.preload.ObliquePen":
                return HWToolbarSAConstants.DETAIL_CALI_PEN;
            case "com.samsung.android.sdk.pen.pen.preload.Pencil2":
                return HWToolbarSAConstants.DETAIL_PENCIL;
            case "com.samsung.android.sdk.pen.pen.preload.FountainPen":
                return HWToolbarSAConstants.DETAIL_FOUNTAIN_PEN;
            default:
                return NONE_TYPE;
        }
    }

    public static String getSAEventThicknessAdjustmentHighlighterType(String str) {
        str.getClass();
        switch (str) {
            case "com.samsung.android.sdk.pen.pen.preload.Marker3":
                return HWToolbarSAConstants.EVENT_THICKNESS_ADJUSTMENT_HIGHLIGHTER_TYPE_MARKER;
            case "com.samsung.android.sdk.pen.pen.preload.Marker4":
                return HWToolbarSAConstants.EVENT_THICKNESS_ADJUSTMENT_HIGHLIGHTER_TYPE_HIGHLIGHTER;
            case "com.samsung.android.sdk.pen.pen.preload.StraightHighlighter":
                return HWToolbarSAConstants.EVENT_THICKNESS_ADJUSTMENT_HIGHLIGHTER_TYPE_HIGHLIGHTER_RULER;
            case "com.samsung.android.sdk.pen.pen.preload.StraightMarker":
                return HWToolbarSAConstants.EVENT_THICKNESS_ADJUSTMENT_HIGHLIGHTER_TYPE_MARKER_RULER;
            default:
                return NONE_TYPE;
        }
    }

    public static String getSAEventThicknessOnOffHighlighterType(String str) {
        str.getClass();
        switch (str) {
            case "com.samsung.android.sdk.pen.pen.preload.Marker3":
                return HWToolbarSAConstants.EVENT_THICKNESS_ONOFF_HIGHLIGHTER_TYPE_MARKER;
            case "com.samsung.android.sdk.pen.pen.preload.Marker4":
                return HWToolbarSAConstants.EVENT_THICKNESS_ONOFF_HIGHLIGHTER_TYPE_HIGHLIGHTER;
            case "com.samsung.android.sdk.pen.pen.preload.StraightHighlighter":
                return HWToolbarSAConstants.EVENT_THICKNESS_ONOFF_HIGHLIGHTER_TYPE_HIGHLIGHTER_RULER;
            case "com.samsung.android.sdk.pen.pen.preload.StraightMarker":
                return HWToolbarSAConstants.EVENT_THICKNESS_ONOFF_HIGHLIGHTER_TYPE_MARKER_RULER;
            default:
                return NONE_TYPE;
        }
    }

    private void insertHighlighterInfoForFitRatioChanged(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        ComposerSA.insertLog(HWToolbarSAConstants.SCREEN_HW_HIGHLIGHTER_SETTING, getSAEventThicknessAdjustmentHighlighterType(spenSettingUIPenInfo.name), getSADetailHighlighterThicknessType(spenSettingUIPenInfo.fitRatio));
    }

    private static boolean isSameFloat(float f, float f4) {
        return Math.abs(f - f4) < 0.05f;
    }

    public void insertHighlighterInfo(SpenSettingUIPenInfo spenSettingUIPenInfo, SpenSettingUIPenInfo spenSettingUIPenInfo2) {
        int alphaPercent = getAlphaPercent(spenSettingUIPenInfo2.color);
        if (!spenSettingUIPenInfo.name.equals(spenSettingUIPenInfo2.name)) {
            ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_HIGHLIGHTER_PEN_TYPE, getSADetailMakerType(spenSettingUIPenInfo2.name));
            return;
        }
        int i = spenSettingUIPenInfo2.sizeLevel;
        if (i != spenSettingUIPenInfo.sizeLevel) {
            ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_HIGHLIGHTER_PEN_SIZE, i);
            return;
        }
        if (alphaPercent != getAlphaPercent(spenSettingUIPenInfo.color)) {
            ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_HIGHLIGHTER_OPACITY, alphaPercent);
            return;
        }
        boolean z = spenSettingUIPenInfo2.isAutoSizeEnabled;
        if (z != spenSettingUIPenInfo.isAutoSizeEnabled) {
            ComposerSA.insertLog(HWToolbarSAConstants.SCREEN_HW_HIGHLIGHTER_SETTING, getSAEventThicknessOnOffHighlighterType(spenSettingUIPenInfo2.name), spenSettingUIPenInfo2.isAutoSizeEnabled ? "1" : "2");
            if (spenSettingUIPenInfo2.isAutoSizeEnabled) {
                insertHighlighterInfoForFitRatioChanged(spenSettingUIPenInfo2);
                return;
            }
            return;
        }
        if (!z || isSameFloat(spenSettingUIPenInfo2.fitRatio, spenSettingUIPenInfo.fitRatio)) {
            return;
        }
        insertHighlighterInfoForFitRatioChanged(spenSettingUIPenInfo2);
    }

    public void insertPenInfo(SpenSettingUIPenInfo spenSettingUIPenInfo, SpenSettingUIPenInfo spenSettingUIPenInfo2) {
        if (!spenSettingUIPenInfo.name.equals(spenSettingUIPenInfo2.name)) {
            if (ResourceUtils.isTabletLayout(this.mContextReference.getContext())) {
                ComposerSA.insertLog("403", HWToolbarSAConstants.EVENT_TABLET_TOOLBAR_SETTING_PEN_TYPE, getSADetailPenType(spenSettingUIPenInfo2.name));
                return;
            } else {
                ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_PEN_TYPE, getSADetailPenType(spenSettingUIPenInfo2.name));
                return;
            }
        }
        if (spenSettingUIPenInfo2.sizeLevel != spenSettingUIPenInfo.sizeLevel) {
            if (ResourceUtils.isTabletLayout(this.mContextReference.getContext())) {
                ComposerSA.insertLog("403", HWToolbarSAConstants.EVENT_TABLET_TOOLBAR_SETTING_PEN_SIZE, spenSettingUIPenInfo2.sizeLevel);
                return;
            } else {
                ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_PEN_SIZE, spenSettingUIPenInfo2.sizeLevel);
                return;
            }
        }
        if (getAlphaPercent(spenSettingUIPenInfo2.color) != getAlphaPercent(spenSettingUIPenInfo.color)) {
            ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_PEN_DARKNESS, getAlphaPercent(spenSettingUIPenInfo2.color));
            return;
        }
        boolean z = spenSettingUIPenInfo2.isFixedWidth;
        if (z != spenSettingUIPenInfo.isFixedWidth) {
            ComposerSA.insertLog("411", HWToolbarSAConstants.EVENT_WRITING_INK_PEN_THICKNESS, z ? "a" : "b");
            return;
        }
        boolean z2 = spenSettingUIPenInfo2.isFixedOpacity;
        if (z2 != spenSettingUIPenInfo.isFixedOpacity) {
            ComposerSA.insertLog(HWToolbarSAConstants.SCREEN_HW_PEN_SETTING, HWToolbarSAConstants.EVENT_HW_PEN_SETTING_PENCIL_PRESSURE, z2 ? "1" : "2");
        }
    }

    public void insertPenSettingFirstWritingInfo(SpenSettingUIPenInfo spenSettingUIPenInfo) {
        StringBuilder sb = new StringBuilder();
        String sADetailPenTypeInitialName = getSADetailPenTypeInitialName(spenSettingUIPenInfo.name);
        if (sADetailPenTypeInitialName.equals(NONE_TYPE)) {
            sADetailPenTypeInitialName = getSADetailMakerTypeInitialName(spenSettingUIPenInfo.name);
        }
        sb.append(sADetailPenTypeInitialName);
        sb.append("_");
        sb.append((int) Math.ceil(((double) spenSettingUIPenInfo.sizeLevel) / 20.0d));
        sb.append("_");
        sb.append(ColorSettingUtil.hasColorName(this.mContextReference.getContext(), ColorCompat.HSVToColor(spenSettingUIPenInfo.hsv)) ? HWToolbarSAConstants.DETAIL_COLOR_DEFINED : HWToolbarSAConstants.DETAIL_COLOR_CUSTOMIZED);
        ComposerSA.insertLog(BaseComposerSAConstants.SCREEN_NONE, HWToolbarSAConstants.EVENT_EDIT_PEN_PEN_SETTINGS_FIRST_WRITING, sb.toString());
    }
}
