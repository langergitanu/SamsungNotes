package com.samsung.android.sdk.pen.setting.drawing;

import android.content.Context;
import android.util.Log;
import com.samsung.android.sdk.pen.pen.SpenPenManager;
import com.samsung.android.sdk.pen.setting.pencommon.SpenSettingPenResource;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0007J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0007J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\r\u001a\u0004\u0018\u00010\u0005H\u0007J\u001a\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0015\u001a\u00020\u0011H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushPenResource;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mSupportPenNameList", "", "[Ljava/lang/String;", "getBrushPenResource", "Lcom/samsung/android/sdk/pen/setting/pencommon/SpenSettingPenResource;", "context", "Landroid/content/Context;", "penName", "getBrushPenViewInfo", "Lcom/samsung/android/sdk/pen/setting/drawing/SpenBrushPenViewInfo;", "isPenResourceDefaultSupported", "", "setMaskPosition", "", "info", "isTabletGUI", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenBrushPenResource {

    @NotNull
    private static final String TAG = "SpenBrushPenResource";

    @NotNull
    public static final SpenBrushPenResource INSTANCE = new SpenBrushPenResource();

    @NotNull
    private static final String[] mSupportPenNameList = {SpenPenManager.SPEN_WATER_BRUSH, SpenPenManager.SPEN_OIL_BRUSH3, SpenPenManager.SPEN_BRUSH_PEN, SpenPenManager.SPEN_PENCIL3, SpenPenManager.SPEN_CRAYON2, SpenPenManager.SPEN_MARKER2, SpenPenManager.SPEN_AIR_BRUSH_PEN, SpenPenManager.SPEN_SMUDGE, SpenPenManager.SPEN_COLORED_PENCIL};

    private SpenBrushPenResource() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00be  */
    @JvmStatic
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final SpenSettingPenResource getBrushPenResource(@Nullable Context context, @Nullable String penName) {
        int i;
        int i2;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        if (penName == null) {
            return null;
        }
        int i10 = 0;
        switch (penName.hashCode()) {
            case -1720765579:
                if (penName.equals(SpenPenManager.SPEN_MARKER2)) {
                    i10 = C7932R.string.pen_string_marker_pen;
                    i6 = C7932R.drawable.brush_marker_body;
                    i7 = C7932R.drawable.brush_marker_effect;
                    i8 = C7932R.drawable.brush_marker_av_unselected;
                    i9 = C7932R.drawable.brush_marker_av_selected;
                    i5 = i7;
                    i2 = i8;
                    i4 = i9;
                    i = i6;
                }
                i = 0;
                i2 = 0;
                i4 = 0;
                i5 = 0;
                break;
            case -1534445527:
                if (penName.equals(SpenPenManager.SPEN_CRAYON2)) {
                    i10 = C7932R.string.pen_string_crayon;
                    i6 = C7932R.drawable.color_pencil_body;
                    i7 = C7932R.drawable.color_pencil_effect;
                    i8 = C7932R.drawable.color_pencil_av_unselected;
                    i9 = C7932R.drawable.color_pencil_av_selected;
                    i5 = i7;
                    i2 = i8;
                    i4 = i9;
                    i = i6;
                }
                i = 0;
                i2 = 0;
                i4 = 0;
                i5 = 0;
                break;
            case -1499175198:
                if (penName.equals(SpenPenManager.SPEN_BRUSH_PEN)) {
                    i10 = C7932R.string.pen_string_chinese_brush;
                    i6 = C7932R.drawable.cali_brush_body;
                    i7 = C7932R.drawable.cali_brush_effect;
                    i8 = C7932R.drawable.cali_brush_av_unselected;
                    i9 = C7932R.drawable.cali_brush_av_selected;
                    i5 = i7;
                    i2 = i8;
                    i4 = i9;
                    i = i6;
                }
                i = 0;
                i2 = 0;
                i4 = 0;
                i5 = 0;
                break;
            case -601527130:
                if (penName.equals(SpenPenManager.SPEN_AIR_BRUSH_PEN)) {
                    i10 = C7932R.string.pen_string_air_brush;
                    i6 = C7932R.drawable.airbrush_body;
                    i7 = C7932R.drawable.airbrush_effect;
                    i8 = C7932R.drawable.airbrush_av_unselected;
                    i9 = C7932R.drawable.airbrush_av_selected;
                    i5 = i7;
                    i2 = i8;
                    i4 = i9;
                    i = i6;
                }
                i = 0;
                i2 = 0;
                i4 = 0;
                i5 = 0;
                break;
            case -547362392:
                if (penName.equals(SpenPenManager.SPEN_OIL_BRUSH3)) {
                    i10 = C7932R.string.pen_string_oil_brush;
                    i6 = C7932R.drawable.oil_brush_body;
                    i7 = C7932R.drawable.oil_brush_effect;
                    i8 = C7932R.drawable.oil_brush_av_unselected;
                    i9 = C7932R.drawable.oil_brush_av_selected;
                    i5 = i7;
                    i2 = i8;
                    i4 = i9;
                    i = i6;
                }
                i = 0;
                i2 = 0;
                i4 = 0;
                i5 = 0;
                break;
            case -454835893:
                if (penName.equals(SpenPenManager.SPEN_WATER_BRUSH)) {
                    i10 = C7932R.string.pen_string_water_color_brush;
                    i6 = C7932R.drawable.water_brush_body;
                    i7 = C7932R.drawable.water_brush_effect;
                    i8 = C7932R.drawable.water_brush_av_unselected;
                    i9 = C7932R.drawable.water_brush_av_selected;
                    i5 = i7;
                    i2 = i8;
                    i4 = i9;
                    i = i6;
                }
                i = 0;
                i2 = 0;
                i4 = 0;
                i5 = 0;
                break;
            case 669044076:
                if (penName.equals(SpenPenManager.SPEN_COLORED_PENCIL)) {
                    i10 = C7932R.string.pen_string_tilt_pencil;
                    i6 = C7932R.drawable.tilt_body;
                    i7 = C7932R.drawable.tilt_effect;
                    i8 = C7932R.drawable.tilt_av_unselected;
                    i9 = C7932R.drawable.tilt_av_selected;
                    i5 = i7;
                    i2 = i8;
                    i4 = i9;
                    i = i6;
                }
                i = 0;
                i2 = 0;
                i4 = 0;
                i5 = 0;
                break;
            case 1052333315:
                if (penName.equals(SpenPenManager.SPEN_PENCIL3)) {
                    i10 = C7932R.string.pen_string_pencil;
                    i6 = C7932R.drawable.brush_pencil_body;
                    i7 = C7932R.drawable.brush_pencil_effect;
                    i8 = C7932R.drawable.brush_pencil_av_unselected;
                    i9 = C7932R.drawable.brush_pencil_av_selected;
                    i5 = i7;
                    i2 = i8;
                    i4 = i9;
                    i = i6;
                }
                i = 0;
                i2 = 0;
                i4 = 0;
                i5 = 0;
                break;
            case 1928546602:
                if (!penName.equals(SpenPenManager.SPEN_SMUDGE)) {
                    i = 0;
                    i2 = 0;
                    i4 = 0;
                    i5 = 0;
                } else {
                    int i11 = C7932R.string.pen_string_smudge;
                    i2 = 0;
                    i4 = 0;
                    i5 = 0;
                    i = C7932R.drawable.smudge_body;
                    i10 = i11;
                }
                break;
        }
        SpenSettingPenResource spenSettingPenResource = new SpenSettingPenResource(penName, i10);
        spenSettingPenResource.setResourceId(context, i, i2, i4, i5, 0);
        return spenSettingPenResource;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @JvmStatic
    @Nullable
    public static final SpenBrushPenViewInfo getBrushPenViewInfo(@Nullable String penName) {
        int i;
        int i2;
        int i4;
        int i5;
        int i6;
        if (penName == null) {
            return null;
        }
        int i7 = 0;
        switch (penName.hashCode()) {
            case -1720765579:
                if (penName.equals(SpenPenManager.SPEN_MARKER2)) {
                    i = C7932R.drawable.maker;
                    i7 = C7932R.drawable.maker_mask;
                    i2 = C7932R.drawable.maker_mask_stroke;
                    i4 = C7932R.string.pen_string_marker_pen;
                    int i8 = i4;
                    i6 = i2;
                    i5 = i8;
                    SpenBrushPenViewInfo spenBrushPenViewInfo = new SpenBrushPenViewInfo(penName, i5);
                    spenBrushPenViewInfo.setResourceId(i, i7, i6);
                }
                Log.i(TAG, "not supported pen! ".concat(penName));
                break;
            case -1534445527:
                if (penName.equals(SpenPenManager.SPEN_CRAYON2)) {
                    i = C7932R.drawable.color_pencil;
                    i7 = C7932R.drawable.color_pencil_mask;
                    i2 = C7932R.drawable.color_pencil_mask_stroke;
                    i4 = C7932R.string.pen_string_crayon;
                    int i82 = i4;
                    i6 = i2;
                    i5 = i82;
                    SpenBrushPenViewInfo spenBrushPenViewInfo2 = new SpenBrushPenViewInfo(penName, i5);
                    spenBrushPenViewInfo2.setResourceId(i, i7, i6);
                }
                Log.i(TAG, "not supported pen! ".concat(penName));
                break;
            case -1499175198:
                if (penName.equals(SpenPenManager.SPEN_BRUSH_PEN)) {
                    i = C7932R.drawable.cali;
                    i7 = C7932R.drawable.cali_mask;
                    i2 = C7932R.drawable.cali_mask_stroke;
                    i4 = C7932R.string.pen_string_chinese_brush;
                    int i822 = i4;
                    i6 = i2;
                    i5 = i822;
                    SpenBrushPenViewInfo spenBrushPenViewInfo22 = new SpenBrushPenViewInfo(penName, i5);
                    spenBrushPenViewInfo22.setResourceId(i, i7, i6);
                }
                Log.i(TAG, "not supported pen! ".concat(penName));
                break;
            case -601527130:
                if (penName.equals(SpenPenManager.SPEN_AIR_BRUSH_PEN)) {
                    i = C7932R.drawable.airbrush;
                    i7 = C7932R.drawable.airbrush_mask;
                    i5 = C7932R.string.pen_string_air_brush;
                    i6 = 0;
                    SpenBrushPenViewInfo spenBrushPenViewInfo222 = new SpenBrushPenViewInfo(penName, i5);
                    spenBrushPenViewInfo222.setResourceId(i, i7, i6);
                }
                Log.i(TAG, "not supported pen! ".concat(penName));
                break;
            case -547362392:
                if (penName.equals(SpenPenManager.SPEN_OIL_BRUSH3)) {
                    i = C7932R.drawable.oil;
                    i7 = C7932R.drawable.oil_mask;
                    i2 = C7932R.drawable.oil_mask_stroke;
                    i4 = C7932R.string.pen_string_oil_brush;
                    int i8222 = i4;
                    i6 = i2;
                    i5 = i8222;
                    SpenBrushPenViewInfo spenBrushPenViewInfo2222 = new SpenBrushPenViewInfo(penName, i5);
                    spenBrushPenViewInfo2222.setResourceId(i, i7, i6);
                }
                Log.i(TAG, "not supported pen! ".concat(penName));
                break;
            case -454835893:
                if (penName.equals(SpenPenManager.SPEN_WATER_BRUSH)) {
                    i = C7932R.drawable.water;
                    i7 = C7932R.drawable.water_mask;
                    i2 = C7932R.drawable.water_mask_stroke;
                    i4 = C7932R.string.pen_string_water_color_brush;
                    int i82222 = i4;
                    i6 = i2;
                    i5 = i82222;
                    SpenBrushPenViewInfo spenBrushPenViewInfo22222 = new SpenBrushPenViewInfo(penName, i5);
                    spenBrushPenViewInfo22222.setResourceId(i, i7, i6);
                }
                Log.i(TAG, "not supported pen! ".concat(penName));
                break;
            case 669044076:
                if (penName.equals(SpenPenManager.SPEN_COLORED_PENCIL)) {
                    i = C7932R.drawable.tilt;
                    i7 = C7932R.drawable.tilt_mask;
                    i2 = C7932R.drawable.tilt_mask_stroke;
                    i4 = C7932R.string.pen_string_tilt_pencil;
                    int i822222 = i4;
                    i6 = i2;
                    i5 = i822222;
                    SpenBrushPenViewInfo spenBrushPenViewInfo222222 = new SpenBrushPenViewInfo(penName, i5);
                    spenBrushPenViewInfo222222.setResourceId(i, i7, i6);
                }
                Log.i(TAG, "not supported pen! ".concat(penName));
                break;
            case 1052333315:
                if (penName.equals(SpenPenManager.SPEN_PENCIL3)) {
                    i = C7932R.drawable.brush_pencil;
                    i7 = C7932R.drawable.brush_pencil_mask;
                    i2 = C7932R.drawable.brush_pencil_mask_stroke;
                    i4 = C7932R.string.pen_string_pencil;
                    int i8222222 = i4;
                    i6 = i2;
                    i5 = i8222222;
                    SpenBrushPenViewInfo spenBrushPenViewInfo2222222 = new SpenBrushPenViewInfo(penName, i5);
                    spenBrushPenViewInfo2222222.setResourceId(i, i7, i6);
                }
                Log.i(TAG, "not supported pen! ".concat(penName));
                break;
            case 1928546602:
                if (penName.equals(SpenPenManager.SPEN_SMUDGE)) {
                    i = C7932R.drawable.smudge;
                    i5 = C7932R.string.pen_string_smudge;
                    i6 = 0;
                    SpenBrushPenViewInfo spenBrushPenViewInfo22222222 = new SpenBrushPenViewInfo(penName, i5);
                    spenBrushPenViewInfo22222222.setResourceId(i, i7, i6);
                }
                Log.i(TAG, "not supported pen! ".concat(penName));
                break;
            default:
                Log.i(TAG, "not supported pen! ".concat(penName));
                break;
        }
        return null;
    }

    @JvmStatic
    public static final boolean isPenResourceDefaultSupported(@Nullable String penName) {
        if (penName == null) {
            return false;
        }
        for (String str : mSupportPenNameList) {
            if (Intrinsics.areEqual(str, penName)) {
                return true;
            }
        }
        return false;
    }

    @JvmStatic
    public static final void setMaskPosition(@Nullable SpenBrushPenViewInfo info, boolean isTabletGUI) {
        float f;
        float f4;
        if ((info != null ? info.getPenName() : null) == null) {
            return;
        }
        String penName = info.getPenName();
        float f5 = 0.0f;
        if (isTabletGUI) {
            f = 520.0f;
            if (StringsKt.m14162r(penName, "AirBrushPen")) {
                f5 = 412.0f;
                f4 = 588.0f;
            } else if (StringsKt.m14162r(penName, "BrushPen")) {
                f = 651.0f;
                f4 = 869.0f;
            } else {
                f4 = 1000.0f;
            }
        } else {
            f = 27.0f;
            if (StringsKt.m14162r(penName, "AirBrushPen")) {
                f5 = 24.0f;
                f4 = 33.0f;
            } else if (StringsKt.m14162r(penName, "BrushPen")) {
                f = 34.0f;
                f4 = 50.0f;
            } else {
                f4 = 57.0f;
            }
        }
        info.setWeight(f5, f, f4);
    }
}
