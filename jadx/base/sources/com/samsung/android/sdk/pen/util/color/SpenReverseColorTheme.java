package com.samsung.android.sdk.pen.util.color;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.Log;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0011\b\u0016\u0018\u0000 !2\u00020\u0001:\u0001!B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u0018\u0010\r\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\bJ\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\bH\u0004J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\bH\u0002J\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\bH\u0002J.\u0010\u001d\u001a\u00020\b2\u0014\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\bH\u0002J\u0012\u0010\u001f\u001a\u00020\f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010 \u001a\u00020\f2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00078DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/sdk/pen/util/color/SpenReverseColorTheme;", "Lcom/samsung/android/sdk/pen/util/color/SpenIColorTheme;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mPickerColorHash", "Ljava/util/HashMap;", "", "mPaletteColorHash", "mSearchScope", "close", "", "getColor", "color", "", "input", "", "output", "setSearchScope", "scope", "isContainsPickerColor", "paletteHash", "getPaletteHash", "()Ljava/util/HashMap;", "getColorByLightControl", "alpha", "opacityColor", "containsScope", "findColor", "hash", "initPickerHash", "initPaletteHash", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public class SpenReverseColorTheme implements SpenIColorTheme {
    public static final int SCOPE_ALL = 8;
    public static final int SCOPE_PALETTE = 2;
    public static final int SCOPE_PICKER = 1;
    public static final int SCOPE_REVERSER_LIGHT = 8;
    private static final float STANDARD_AREA_MAX = 0.6f;
    private static final float STANDARD_AREA_MIN = 0.4f;
    private static final int TABLE_LIST_SIZE = 23;

    @NotNull
    private static final String TAG = "SpenReverseUIColorTheme";
    private int mSearchScope = 8;

    @NotNull
    private HashMap<Integer, Integer> mPickerColorHash = new HashMap<>();

    @NotNull
    private HashMap<Integer, Integer> mPaletteColorHash = new HashMap<>();

    public SpenReverseColorTheme(@Nullable Context context) {
        initPickerHash(context);
        initPaletteHash(context);
    }

    private final boolean containsScope(int scope) {
        return (this.mSearchScope & scope) == scope;
    }

    private final int findColor(HashMap<Integer, Integer> hash, int alpha, int opacityColor) {
        Integer num;
        if (hash == null || (num = hash.get(Integer.valueOf(opacityColor))) == null) {
            return -1;
        }
        return (num.intValue() & 16777215) | ((alpha << 24) & (-16777216));
    }

    private final int getColorByLightControl(int alpha, int opacityColor) {
        float[] fArr = {0.0f, 0.0f, 0.0f};
        SpenColorUtil spenColorUtil = SpenColorUtil.INSTANCE;
        spenColorUtil.RGBToHSL(opacityColor, fArr);
        float f = fArr[2];
        if (0.4f > f || f > 0.6f) {
            fArr[2] = 1 - f;
            opacityColor = spenColorUtil.HSLToRGB(fArr);
        }
        return ((alpha << 24) & (-16777216)) | (opacityColor & 16777215);
    }

    private final void initPaletteHash(Context context) {
        if (context == null) {
            return;
        }
        Resources resources = context.getResources();
        String packageName = context.getPackageName();
        for (int i = 1; i < 24; i++) {
            int identifier = resources.getIdentifier("spen_setting_swatch_" + i, "array", packageName);
            int identifier2 = resources.getIdentifier("spen_setting_swatch_adaptive_" + i, "array", packageName);
            if (identifier > 0 && identifier2 > 0) {
                int[] intArray = resources.getIntArray(identifier);
                Intrinsics.checkNotNullExpressionValue(intArray, "getIntArray(...)");
                int[] intArray2 = resources.getIntArray(identifier2);
                Intrinsics.checkNotNullExpressionValue(intArray2, "getIntArray(...)");
                int length = intArray.length;
                for (int i2 = 0; i2 < length; i2++) {
                    this.mPaletteColorHash.put(Integer.valueOf(intArray[i2]), Integer.valueOf(intArray2[i2]));
                }
            }
        }
    }

    private final void initPickerHash(Context context) {
        if (context == null) {
            return;
        }
        Resources resources = context.getResources();
        String packageName = context.getPackageName();
        int identifier = resources.getIdentifier("spen_adaptive_light_color", "array", packageName);
        int identifier2 = resources.getIdentifier("spen_adaptive_dark_color", "array", packageName);
        int identifier3 = resources.getIdentifier("spen_adaptive_standard_color", "array", packageName);
        if (identifier > 0 && identifier2 > 0) {
            int[] intArray = resources.getIntArray(identifier);
            Intrinsics.checkNotNullExpressionValue(intArray, "getIntArray(...)");
            int[] intArray2 = resources.getIntArray(identifier2);
            Intrinsics.checkNotNullExpressionValue(intArray2, "getIntArray(...)");
            int length = intArray.length;
            for (int i = 0; i < length; i++) {
                int i2 = intArray[i];
                int i4 = intArray2[i];
                this.mPickerColorHash.put(Integer.valueOf(i2), Integer.valueOf(i4));
                this.mPickerColorHash.put(Integer.valueOf(i4), Integer.valueOf(i2));
            }
        }
        if (identifier3 > 0) {
            int[] intArray3 = resources.getIntArray(identifier3);
            Intrinsics.checkNotNullExpressionValue(intArray3, "getIntArray(...)");
            int length2 = intArray3.length;
            for (int i5 = 0; i5 < length2; i5++) {
                this.mPickerColorHash.put(Integer.valueOf(intArray3[i5]), Integer.valueOf(intArray3[i5]));
            }
        }
    }

    @Override // com.samsung.android.sdk.pen.util.color.SpenIColorTheme
    public void close() {
        this.mPickerColorHash.clear();
        this.mPaletteColorHash.clear();
    }

    @Override // com.samsung.android.sdk.pen.util.color.SpenIColorTheme
    public int getColor(int color) {
        boolean z;
        int colorByLightControl;
        int iFindColor;
        int iFindColor2;
        int i = (16777215 & color) | (-16777216);
        int i2 = (color >> 24) & 255;
        if (!containsScope(2) || (iFindColor2 = findColor(this.mPaletteColorHash, i2, i)) == -1) {
            z = false;
            colorByLightControl = color;
        } else {
            Log.i(TAG, "getColor() :: Find in Palette!");
            colorByLightControl = iFindColor2;
            z = true;
        }
        if (!z && containsScope(1) && (iFindColor = findColor(this.mPickerColorHash, i2, i)) != -1) {
            Log.i(TAG, "getColor() :: Find in Picker!");
            z = true;
            colorByLightControl = iFindColor;
        }
        if (!z && containsScope(8)) {
            colorByLightControl = getColorByLightControl(i2, i);
            Log.i(TAG, "getColor() :: Find by LightControl!");
            z = true;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String strM1624n = AbstractC2322a.m1624n(" #%08X", new Object[]{Integer.valueOf(color)}, 1, "format(format, *args)");
        String strM1624n2 = AbstractC2322a.m1624n(" #%08X", new Object[]{Integer.valueOf(colorByLightControl)}, 1, "format(format, *args)");
        StringBuilder sb = new StringBuilder(" isFind=");
        sb.append(z);
        sb.append("[");
        sb.append(strM1624n);
        sb.append(SQLKeyword.COMMA);
        AbstractC4539a.m3209s(sb, strM1624n2, "] ", TAG);
        return colorByLightControl;
    }

    @NotNull
    public final HashMap<Integer, Integer> getPaletteHash() {
        return this.mPaletteColorHash;
    }

    public final boolean isContainsPickerColor(int color) {
        return findColor(this.mPickerColorHash, (color >> 24) & 255, (16777215 & color) | (-16777216)) != -1;
    }

    public final void setSearchScope(int scope) {
        this.mSearchScope = scope;
    }

    @Override // com.samsung.android.sdk.pen.util.color.SpenIColorTheme
    public boolean getColor(@NotNull float[] input, @NotNull float[] output) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(output, "output");
        Color.colorToHSV(getColor(SpenColorUtil.INSTANCE.HSVToColor(input)), output);
        return true;
    }
}
