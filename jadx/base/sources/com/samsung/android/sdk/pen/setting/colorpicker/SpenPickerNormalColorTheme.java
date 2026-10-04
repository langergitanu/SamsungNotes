package com.samsung.android.sdk.pen.setting.colorpicker;

import com.samsung.android.sdk.pen.util.color.SpenNormalColorTheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenPickerNormalColorTheme;", "Lcom/samsung/android/sdk/pen/util/color/SpenNormalColorTheme;", "Lcom/samsung/android/sdk/pen/setting/colorpicker/SpenIPickerColorTheme;", "<init>", "()V", "getContentColor", "", "visibleColor", "", "outContentColor", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenPickerNormalColorTheme extends SpenNormalColorTheme implements SpenIPickerColorTheme {
    @Override // com.samsung.android.sdk.pen.setting.colorpicker.SpenIPickerColorTheme
    public boolean getContentColor(@NotNull float[] visibleColor, @NotNull float[] outContentColor) {
        Intrinsics.checkNotNullParameter(visibleColor, "visibleColor");
        Intrinsics.checkNotNullParameter(outContentColor, "outContentColor");
        System.arraycopy(visibleColor, 0, outContentColor, 0, visibleColor.length);
        return true;
    }
}
