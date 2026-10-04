package com.samsung.android.support.senl.addons.brush.model.pen;

import android.graphics.Color;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.pen.pen.SpenPenManager;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0002\b\u0007\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00020\t2\u0006\u00102\u001a\u000203J\u001e\u00104\u001a\u0002032\u0006\u0010/\u001a\u00020\u00052\u0006\u00105\u001a\u00020\t2\u0006\u00106\u001a\u000203R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u0018¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001d\u0010\u001aR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010!\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010&\u001a\u00020'¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020,X\u0086T¢\u0006\u0002\n\u0000¨\u00067"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/model/pen/PenDefaultInfo;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "getTAG", "()Ljava/lang/String;", "INFO_PEN_LIST_SIZE", "", "INFO_PEN_SELECTED_INDEX", "VERSION_CRAYON", "VERSION_MARKER", "DF_WATER_BRUSH", "DF_OIL_BRUSH", "DF_BRUSH_PEN", "DF_PENCIL", "DF_COLORED_PENCIL", "DF_SMUDGE", "DF_AIR_BRUSH_PEN", "DF_MARKER", "DF_CRAYON", "DF_ERASE", "INFO_PEN_NAMES", "", "getINFO_PEN_NAMES", "()[Ljava/lang/String;", "[Ljava/lang/String;", "INFO_PREV_PEN_NAMES", "getINFO_PREV_PEN_NAMES", "INFO_MIN_SETTING_VALUES", "", "INFO_MAX_SETTING_VALUES", "INFO_PEN_SIZES", "getINFO_PEN_SIZES", "()[F", "INFO_PEN_DP_MIN_SIZE", "INFO_PEN_DP_MAX_SIZE", "INFO_PEN_COLORS", "", "getINFO_PEN_COLORS", "()[I", "INFO_PEN_ADV_SETTING", "INFO_PEN_IS_CURVABLE", "", "INFO_PEN_ENABLED_ERASER", "getPenInfoSize", "name", "widthPixel", "heightPixel", "size", "", "getPenPixelSize", "percent", "dpi", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PenDefaultInfo {
    private static final int DF_AIR_BRUSH_PEN;
    private static final int DF_BRUSH_PEN;
    private static final int DF_COLORED_PENCIL;
    private static final int DF_CRAYON;
    private static final int DF_ERASE;
    private static final int DF_MARKER;
    private static final int DF_OIL_BRUSH;
    private static final int DF_PENCIL;
    private static final int DF_SMUDGE;
    private static final int DF_WATER_BRUSH;

    @NotNull
    private static final float[] INFO_MAX_SETTING_VALUES;

    @NotNull
    private static final float[] INFO_MIN_SETTING_VALUES;

    @NotNull
    public static final String INFO_PEN_ADV_SETTING = "";

    @NotNull
    private static final int[] INFO_PEN_COLORS;

    @NotNull
    private static final float[] INFO_PEN_DP_MAX_SIZE;

    @NotNull
    private static final float[] INFO_PEN_DP_MIN_SIZE;
    public static final boolean INFO_PEN_ENABLED_ERASER = false;
    public static final boolean INFO_PEN_IS_CURVABLE = true;
    public static final int INFO_PEN_LIST_SIZE = 10;

    @NotNull
    private static final String[] INFO_PEN_NAMES;
    public static final int INFO_PEN_SELECTED_INDEX = 0;

    @NotNull
    private static final float[] INFO_PEN_SIZES;

    @NotNull
    private static final String[] INFO_PREV_PEN_NAMES;

    @NotNull
    public static final PenDefaultInfo INSTANCE = new PenDefaultInfo();

    @NotNull
    private static final String TAG = Logger.createBrushTag("PenDefaultInfo");
    private static final int VERSION_CRAYON = 2;
    private static final int VERSION_MARKER = 2;

    static {
        int color = Color.parseColor("#ff3396ff");
        DF_WATER_BRUSH = color;
        int color2 = Color.parseColor("#2b61fb");
        DF_OIL_BRUSH = color2;
        int color3 = Color.parseColor("#b3c871");
        DF_BRUSH_PEN = color3;
        int color4 = Color.parseColor("#795548");
        DF_PENCIL = color4;
        int color5 = Color.parseColor("#252525");
        DF_COLORED_PENCIL = color5;
        int color6 = Color.parseColor("#ff767676");
        DF_SMUDGE = color6;
        int color7 = Color.parseColor("#80252525");
        DF_AIR_BRUSH_PEN = color7;
        int color8 = Color.parseColor("#808b7bc9");
        DF_MARKER = color8;
        int color9 = Color.parseColor("#9ad2c9");
        DF_CRAYON = color9;
        int color10 = Color.parseColor("#ffffff");
        DF_ERASE = color10;
        INFO_PEN_NAMES = new String[]{SpenPenManager.SPEN_WATER_BRUSH, SpenPenManager.SPEN_OIL_BRUSH3, SpenPenManager.SPEN_BRUSH_PEN, SpenPenManager.SPEN_PENCIL3, SpenPenManager.SPEN_COLORED_PENCIL, SpenPenManager.SPEN_SMUDGE, SpenPenManager.SPEN_AIR_BRUSH_PEN, SpenPenManager.SPEN_MARKER2, SpenPenManager.SPEN_CRAYON2, SpenPenManager.SPEN_ERASER};
        INFO_PREV_PEN_NAMES = new String[]{SpenPenManager.SPEN_WATER_BRUSH, SpenPenManager.SPEN_OIL_BRUSH3, SpenPenManager.SPEN_BRUSH_PEN, SpenPenManager.SPEN_PENCIL3, SpenPenManager.SPEN_CRAYON2, SpenPenManager.SPEN_AIR_BRUSH_PEN, SpenPenManager.SPEN_MARKER2, SpenPenManager.SPEN_ERASER};
        INFO_MIN_SETTING_VALUES = new float[]{7.0f, 6.5f, 6.0f, 1.0f, 1.0f, 10.0f, 10.0f, 1.0f, 3.0f, 1.0f};
        INFO_MAX_SETTING_VALUES = new float[]{60.0f, 58.499996f, 20.0f, 2.5f, 2.5f, 60.0f, 50.0f, 30.0f, 15.0f, 30.0f};
        INFO_PEN_SIZES = new float[]{40.0f, 40.0f, 60.0f, 50.0f, 50.0f, 20.0f, 20.0f, 20.0f, 50.0f, 10.0f};
        INFO_PEN_DP_MIN_SIZE = new float[]{7.428f, 6.857f, 6.571f, 1.142f, 1.142f, 10.857f, 10.857f, 1.142f, 3.428f, 1.142f};
        INFO_PEN_DP_MAX_SIZE = new float[]{67.428f, 65.714f, 22.0f, 2.857f, 1.142f, 67.428f, 56.285f, 33.714f, 16.857f, 33.714f};
        INFO_PEN_COLORS = new int[]{color, color2, color3, color4, color5, color6, color7, color8, color9, color10};
    }

    private PenDefaultInfo() {
    }

    @NotNull
    public final int[] getINFO_PEN_COLORS() {
        return INFO_PEN_COLORS;
    }

    @NotNull
    public final String[] getINFO_PEN_NAMES() {
        return INFO_PEN_NAMES;
    }

    @NotNull
    public final float[] getINFO_PEN_SIZES() {
        return INFO_PEN_SIZES;
    }

    @NotNull
    public final String[] getINFO_PREV_PEN_NAMES() {
        return INFO_PREV_PEN_NAMES;
    }

    public final int getPenInfoSize(@NotNull String name, int widthPixel, int heightPixel, float size) {
        Intrinsics.checkNotNullParameter(name, "name");
        String str = TAG;
        StringBuilder sbM780v = AbstractC0541b.m780v("getPenInfoSize(name = ", widthPixel, name, ", widthPixel = ", ", heightPixel = ");
        sbM780v.append(heightPixel);
        sbM780v.append(", size = ");
        sbM780v.append(size);
        sbM780v.append(" )");
        Logger.m7100d(str, sbM780v.toString());
        if (widthPixel > heightPixel) {
            widthPixel = heightPixel;
        }
        int length = INFO_PEN_NAMES.length;
        for (int i = 0; i < length; i++) {
            if (INFO_PEN_NAMES[i].compareTo(name) == 0) {
                float f = widthPixel;
                float f4 = (INFO_MAX_SETTING_VALUES[i] * f) / 360.0f;
                float f5 = (INFO_MIN_SETTING_VALUES[i] * f) / 360.0f;
                return MathKt.roundToInt((size - f5) / ((f4 - f5) / 100.0f));
            }
        }
        return -1;
    }

    public final float getPenPixelSize(@NotNull String name, int percent, float dpi) {
        Intrinsics.checkNotNullParameter(name, "name");
        String str = TAG;
        StringBuilder sbM780v = AbstractC0541b.m780v("getPenPixelSize(name = ", percent, name, ", percent = ", ", dpi = ");
        sbM780v.append(dpi);
        sbM780v.append(")");
        Logger.m7100d(str, sbM780v.toString());
        int length = INFO_PEN_NAMES.length;
        for (int i = 0; i < length; i++) {
            if (StringsKt.m14162r(INFO_PEN_NAMES[i], name)) {
                float f = dpi / 160.0f;
                float f4 = INFO_PEN_DP_MAX_SIZE[i] * f;
                float f5 = INFO_PEN_DP_MIN_SIZE[i] * f;
                return (((f4 - f5) / 100.0f) * percent) + f5;
            }
        }
        return -1.0f;
    }

    @NotNull
    public final String getTAG() {
        return TAG;
    }
}
