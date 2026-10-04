package com.samsung.android.sdk.pen.util.color;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/util/color/SpenNormalColorTheme;", "Lcom/samsung/android/sdk/pen/util/color/SpenIColorTheme;", "<init>", "()V", "getColor", "", "color", "", "input", "", "output", "close", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public class SpenNormalColorTheme implements SpenIColorTheme {
    @Override // com.samsung.android.sdk.pen.util.color.SpenIColorTheme
    public int getColor(int color) {
        return color;
    }

    @Override // com.samsung.android.sdk.pen.util.color.SpenIColorTheme
    public boolean getColor(@NotNull float[] input, @NotNull float[] output) {
        Intrinsics.checkNotNullParameter(input, "input");
        Intrinsics.checkNotNullParameter(output, "output");
        System.arraycopy(input, 0, output, 0, input.length);
        return true;
    }

    @Override // com.samsung.android.sdk.pen.util.color.SpenIColorTheme
    public void close() {
    }
}
