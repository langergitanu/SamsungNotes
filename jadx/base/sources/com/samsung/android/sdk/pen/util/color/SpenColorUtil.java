package com.samsung.android.sdk.pen.util.color;

import android.graphics.Color;
import androidx.core.graphics.ColorUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007J\u000e\u0010\r\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/util/color/SpenColorUtil;", "", "<init>", "()V", "HSVToColor", "", "hsvColor", "", "alpha", "RGBToHSL", "", "color", "hslColor", "HSLToRGB", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenColorUtil {

    @NotNull
    public static final SpenColorUtil INSTANCE = new SpenColorUtil();

    private SpenColorUtil() {
    }

    public final int HSLToRGB(@NotNull float[] hslColor) {
        Intrinsics.checkNotNullParameter(hslColor, "hslColor");
        return ColorUtils.HSLToColor(hslColor);
    }

    public final int HSVToColor(@NotNull float[] hsvColor) {
        Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
        return HSVToColor(255, hsvColor);
    }

    public final void RGBToHSL(int color, @NotNull float[] hslColor) {
        Intrinsics.checkNotNullParameter(hslColor, "hslColor");
        ColorUtils.RGBToHSL(Color.red(color), Color.green(color), Color.blue(color), hslColor);
    }

    public final int HSVToColor(int alpha, @NotNull float[] hsvColor) {
        Intrinsics.checkNotNullParameter(hsvColor, "hsvColor");
        return Color.HSVToColor(alpha, hsvColor);
    }
}
