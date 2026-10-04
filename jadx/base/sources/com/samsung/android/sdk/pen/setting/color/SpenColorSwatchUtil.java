package com.samsung.android.sdk.pen.setting.color;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import androidx.glance.AbstractC2821a;
import com.samsung.android.spen.C7932R;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u0017J\u0016\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014J\u001e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\fJ\u0018\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0002R\u0018\u0010\u0006\u001a\n \b*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/color/SpenColorSwatchUtil;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mResources", "Landroid/content/res/Resources;", "kotlin.jvm.PlatformType", "Landroid/content/res/Resources;", "mHSV", "", "", "[[F", "mColorID", "", "[[I", "getColorName", "", "row", "", "column", "details", "", "getColor", "hsv", "isValidIndex", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenColorSwatchUtil {
    private static final int DARK_COLOR_NAME_IDX = 2;
    private static final int LIGHT_COLOR_NAME_IDX = 1;
    private static final int STANDARD_DARK_ROW = 7;
    private static final int STANDARD_LIGHT_ROW = 5;
    public static final int SWATCH_COL_SIZE = 13;
    public static final int SWATCH_ROW_SIZE = 13;

    @NotNull
    private static final String TAG = "SpenColorSwatchUtil";

    @NotNull
    private final int[][] mColorID;

    @NotNull
    private final float[][] mHSV;
    private final Resources mResources;

    public SpenColorSwatchUtil(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.mResources = context.getResources();
        this.mHSV = new float[][]{new float[]{0.0f, 0.0f, 0.99f}, new float[]{0.0f, 0.11f, 1.0f}, new float[]{25.0f, 0.13f, 1.0f}, new float[]{43.0f, 0.14f, 1.0f}, new float[]{57.0f, 0.14f, 1.0f}, new float[]{98.0f, 0.09f, 1.0f}, new float[]{143.0f, 0.1f, 0.99f}, new float[]{172.0f, 0.11f, 1.0f}, new float[]{212.0f, 0.14f, 1.0f}, new float[]{228.0f, 0.14f, 1.0f}, new float[]{272.0f, 0.14f, 1.0f}, new float[]{302.0f, 0.11f, 1.0f}, new float[]{337.0f, 0.11f, 1.0f}, new float[]{0.0f, 0.0f, 0.9f}, new float[]{0.0f, 0.21f, 1.0f}, new float[]{26.0f, 0.23f, 1.0f}, new float[]{44.0f, 0.25f, 1.0f}, new float[]{57.0f, 0.25f, 1.0f}, new float[]{98.0f, 0.15f, 1.0f}, new float[]{144.0f, 0.18f, 0.98f}, new float[]{172.0f, 0.2f, 1.0f}, new float[]{211.0f, 0.25f, 1.0f}, new float[]{228.0f, 0.25f, 1.0f}, new float[]{272.0f, 0.21f, 1.0f}, new float[]{302.0f, 0.19f, 1.0f}, new float[]{337.0f, 0.2f, 1.0f}, new float[]{0.0f, 0.0f, 0.8f}, new float[]{1.0f, 0.37f, 1.0f}, new float[]{26.0f, 0.36f, 1.0f}, new float[]{45.0f, 0.4f, 1.0f}, new float[]{57.0f, 0.4f, 1.0f}, new float[]{98.0f, 0.24f, 1.0f}, new float[]{144.0f, 0.29f, 0.98f}, new float[]{172.0f, 0.32f, 1.0f}, new float[]{211.0f, 0.4f, 1.0f}, new float[]{227.0f, 0.4f, 1.0f}, new float[]{272.0f, 0.35f, 1.0f}, new float[]{302.0f, 0.3f, 1.0f}, new float[]{337.0f, 0.32f, 1.0f}, new float[]{0.0f, 0.0f, 0.7f}, new float[]{2.0f, 0.51f, 1.0f}, new float[]{26.0f, 0.49f, 1.0f}, new float[]{45.0f, 0.55f, 1.0f}, new float[]{57.0f, 0.55f, 1.0f}, new float[]{98.0f, 0.33f, 1.0f}, new float[]{144.0f, 0.4f, 0.97f}, new float[]{172.0f, 0.44f, 1.0f}, new float[]{211.0f, 0.55f, 1.0f}, new float[]{227.0f, 0.55f, 1.0f}, new float[]{272.0f, 0.48f, 1.0f}, new float[]{302.0f, 0.41f, 1.0f}, new float[]{337.0f, 0.44f, 1.0f}, new float[]{0.0f, 0.0f, 0.6f}, new float[]{0.0f, 0.65f, 1.0f}, new float[]{26.0f, 0.63f, 1.0f}, new float[]{45.0f, 0.66f, 1.0f}, new float[]{57.0f, 0.7f, 1.0f}, new float[]{98.0f, 0.4f, 1.0f}, new float[]{144.0f, 0.49f, 0.96f}, new float[]{172.0f, 0.53f, 1.0f}, new float[]{211.0f, 0.7f, 1.0f}, new float[]{227.0f, 0.7f, 1.0f}, new float[]{270.0f, 0.58f, 1.0f}, new float[]{302.0f, 0.53f, 1.0f}, new float[]{337.0f, 0.56f, 1.0f}, new float[]{0.0f, 0.0f, 0.5f}, new float[]{0.0f, 0.79f, 1.0f}, new float[]{26.0f, 0.76f, 1.0f}, new float[]{45.0f, 0.81f, 1.0f}, new float[]{58.0f, 0.9f, 0.99f}, new float[]{98.0f, 0.6f, 1.0f}, new float[]{144.0f, 0.68f, 0.96f}, new float[]{172.0f, 0.8f, 1.0f}, new float[]{211.0f, 0.8f, 1.0f}, new float[]{227.0f, 0.8f, 1.0f}, new float[]{270.0f, 0.69f, 1.0f}, new float[]{302.0f, 0.6f, 1.0f}, new float[]{337.0f, 0.64f, 1.0f}, new float[]{0.0f, 0.0f, 0.4f}, new float[]{0.0f, 0.93f, 1.0f}, new float[]{26.0f, 0.9f, 1.0f}, new float[]{45.0f, 1.0f, 0.97f}, new float[]{57.0f, 1.0f, 0.97f}, new float[]{97.0f, 0.6f, 0.97f}, new float[]{143.0f, 0.7f, 0.93f}, new float[]{172.0f, 0.8f, 0.97f}, new float[]{210.0f, 0.94f, 1.0f}, new float[]{227.0f, 0.92f, 1.0f}, new float[]{270.0f, 0.8f, 1.0f}, new float[]{302.0f, 0.75f, 1.0f}, new float[]{337.0f, 0.73f, 1.0f}, new float[]{0.0f, 0.0f, 0.3f}, new float[]{0.0f, 0.93f, 0.91f}, new float[]{26.0f, 0.9f, 0.92f}, new float[]{45.0f, 1.0f, 0.92f}, new float[]{57.0f, 1.0f, 0.92f}, new float[]{98.0f, 0.6f, 0.92f}, new float[]{144.0f, 0.75f, 0.87f}, new float[]{172.0f, 0.8f, 0.92f}, new float[]{211.0f, 1.0f, 0.92f}, new float[]{227.0f, 0.97f, 0.92f}, new float[]{270.0f, 0.91f, 1.0f}, new float[]{302.0f, 0.75f, 0.92f}, new float[]{337.0f, 0.75f, 0.93f}, new float[]{0.0f, 0.0f, 0.25f}, new float[]{0.0f, 0.92f, 0.83f}, new float[]{26.0f, 0.9f, 0.85f}, new float[]{45.0f, 1.0f, 0.85f}, new float[]{57.0f, 1.0f, 0.85f}, new float[]{98.0f, 0.6f, 0.85f}, new float[]{144.0f, 0.75f, 0.81f}, new float[]{172.0f, 0.8f, 0.85f}, new float[]{211.0f, 1.0f, 0.85f}, new float[]{227.0f, 1.0f, 0.85f}, new float[]{270.0f, 1.0f, 0.92f}, new float[]{302.0f, 0.75f, 0.85f}, new float[]{337.0f, 0.8f, 0.85f}, new float[]{0.0f, 0.0f, 0.2f}, new float[]{0.0f, 0.93f, 0.72f}, new float[]{26.0f, 0.9f, 0.72f}, new float[]{45.0f, 1.0f, 0.72f}, new float[]{57.0f, 1.0f, 0.72f}, new float[]{98.0f, 0.6f, 0.72f}, new float[]{143.0f, 0.75f, 0.69f}, new float[]{172.0f, 0.81f, 0.72f}, new float[]{211.0f, 1.0f, 0.72f}, new float[]{227.0f, 1.0f, 0.72f}, new float[]{270.0f, 1.0f, 0.8f}, new float[]{302.0f, 0.75f, 0.72f}, new float[]{337.0f, 0.8f, 0.72f}, new float[]{0.0f, 0.0f, 0.145f}, new float[]{0.0f, 0.93f, 0.6f}, new float[]{26.0f, 1.0f, 0.6f}, new float[]{45.0f, 1.0f, 0.6f}, new float[]{57.0f, 1.0f, 0.6f}, new float[]{98.0f, 0.6f, 0.6f}, new float[]{144.0f, 0.75f, 0.57f}, new float[]{171.0f, 0.8f, 0.58f}, new float[]{211.0f, 1.0f, 0.6f}, new float[]{227.0f, 1.0f, 0.6f}, new float[]{270.0f, 1.0f, 0.64f}, new float[]{302.0f, 0.75f, 0.65f}, new float[]{337.0f, 0.8f, 0.62f}, new float[]{0.0f, 0.0f, 0.1f}, new float[]{0.0f, 0.93f, 0.43f}, new float[]{26.0f, 1.0f, 0.43f}, new float[]{39.0f, 1.0f, 0.43f}, new float[]{57.0f, 1.0f, 0.43f}, new float[]{98.0f, 0.6f, 0.42f}, new float[]{144.0f, 0.75f, 0.41f}, new float[]{172.0f, 0.8f, 0.39f}, new float[]{211.0f, 1.0f, 0.43f}, new float[]{227.0f, 1.0f, 0.43f}, new float[]{270.0f, 1.0f, 0.5f}, new float[]{302.0f, 0.75f, 0.43f}, new float[]{338.0f, 0.8f, 0.49f}, new float[]{0.0f, 0.0f, 0.0f}, new float[]{0.0f, 0.94f, 0.25f}, new float[]{26.0f, 1.0f, 0.32f}, new float[]{40.0f, 1.0f, 0.32f}, new float[]{57.0f, 1.0f, 0.32f}, new float[]{99.0f, 0.61f, 0.29f}, new float[]{144.0f, 0.75f, 0.28f}, new float[]{172.0f, 0.81f, 0.29f}, new float[]{211.0f, 1.0f, 0.32f}, new float[]{228.0f, 1.0f, 0.32f}, new float[]{270.0f, 1.0f, 0.38f}, new float[]{302.0f, 0.76f, 0.29f}, new float[]{337.0f, 0.81f, 0.37f}};
        this.mColorID = new int[][]{new int[]{C7932R.string.pen_swatch_color_gray, C7932R.string.pen_palette_color_light_gray, C7932R.string.pen_palette_color_dark_gray}, new int[]{C7932R.string.pen_palette_color_red, C7932R.string.pen_swatch_color_light_red, C7932R.string.pen_swatch_color_dark_red}, new int[]{C7932R.string.pen_palette_color_orange, C7932R.string.pen_swatch_color_light_orange, C7932R.string.pen_swatch_color_dark_orange}, new int[]{C7932R.string.pen_swatch_color_gold, C7932R.string.pen_swatch_color_light_gold, C7932R.string.pen_swatch_color_dark_gold}, new int[]{C7932R.string.pen_palette_color_yellow, C7932R.string.pen_palette_color_light_yellow, C7932R.string.pen_swatch_color_dark_yellow}, new int[]{C7932R.string.pen_palette_color_green, C7932R.string.pen_palette_color_light_green, C7932R.string.pen_palette_color_dark_green}, new int[]{C7932R.string.pen_palette_color_spring_green, C7932R.string.pen_swatch_color_light_spring_green, C7932R.string.pen_swatch_color_dark_spring_green}, new int[]{C7932R.string.pen_swatch_color_cyan, C7932R.string.pen_swatch_color_light_cyan, C7932R.string.pen_swatch_color_dark_cyan}, new int[]{C7932R.string.pen_swatch_color_azure, C7932R.string.pen_swatch_color_light_azure, C7932R.string.pen_swatch_color_dark_azure}, new int[]{C7932R.string.pen_palette_color_blue, C7932R.string.pen_swatch_color_light_blue, C7932R.string.pen_swatch_color_dark_blue}, new int[]{C7932R.string.pen_palette_color_violet, C7932R.string.pen_swatch_color_light_violet, C7932R.string.pen_swatch_color_dark_violet}, new int[]{C7932R.string.pen_swatch_color_magenta, C7932R.string.pen_swatch_color_light_magenta, C7932R.string.pen_swatch_color_dark_magenta}, new int[]{C7932R.string.pen_swatch_color_pink, C7932R.string.pen_swatch_color_light_pink, C7932R.string.pen_palette_color_dark_pink}};
    }

    public static /* synthetic */ String getColorName$default(SpenColorSwatchUtil spenColorSwatchUtil, int i, int i2, boolean z, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            z = false;
        }
        return spenColorSwatchUtil.getColorName(i, i2, z);
    }

    private final boolean isValidIndex(int row, int column) {
        return row >= 0 && row < 13 && column >= 0 && column < 13;
    }

    public final int getColor(int row, int column) {
        if (!isValidIndex(row, column)) {
            return -1;
        }
        return Color.HSVToColor(this.mHSV[(row * 13) + column]);
    }

    @NotNull
    public final String getColorName(int row, int column, boolean details) {
        String string = (row == 12 && column == 0) ? this.mResources.getString(C7932R.string.pen_palette_color_black) : this.mResources.getString(this.mColorID[column][row < 5 ? (char) 1 : row > 7 ? (char) 2 : (char) 0]);
        Intrinsics.checkNotNull(string);
        if (details) {
            float[] fArr = new float[3];
            if (getColor(row, column, fArr)) {
                return AbstractC2821a.m2218i((int) (fArr[2] * 100), string, SQLKeyword.COMMA);
            }
        }
        return string;
    }

    public final boolean getColor(int row, int column, @NotNull float[] hsv) {
        Intrinsics.checkNotNullParameter(hsv, "hsv");
        if (!isValidIndex(row, column)) {
            return false;
        }
        float[] fArr = this.mHSV[(row * 13) + column];
        System.arraycopy(fArr, 0, hsv, 0, fArr.length);
        return true;
    }
}
