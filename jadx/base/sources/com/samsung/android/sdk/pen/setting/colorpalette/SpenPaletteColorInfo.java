package com.samsung.android.sdk.pen.setting.colorpalette;

import androidx.annotation.IntRange;
import androidx.annotation.Size;
import androidx.collection.ScatterMapKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\u00122\b\b\u0001\u0010\u0013\u001a\u00020\fJ\u0006\u0010\u0011\u001a\u00020\fJ$\u0010\u0014\u001a\u00020\u00122\b\b\u0001\u0010\u0013\u001a\u00020\f2\b\b\u0001\u0010\u000e\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0007R\"\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteColorInfo;", "", "<init>", "()V", "info", "(Lcom/samsung/android/sdk/pen/setting/colorpalette/SpenPaletteColorInfo;)V", "value", "", "colorName", "getColorName", "()Ljava/lang/String;", "mHsvColor", "", "", "opacity", "getOpacity", "()I", "getColor", "", "color", "setColor", "name", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenPaletteColorInfo {

    @Nullable
    private String colorName;

    @NotNull
    private final float[] mHsvColor;
    private int opacity;

    public SpenPaletteColorInfo() {
        this.mHsvColor = new float[]{0.0f, 0.0f, 0.0f};
        this.opacity = 255;
    }

    public final void getColor(@Size(3) @NotNull float[] color) {
        Intrinsics.checkNotNullParameter(color, "color");
        System.arraycopy(this.mHsvColor, 0, color, 0, 3);
    }

    @Nullable
    public final String getColorName() {
        return this.colorName;
    }

    public final int getOpacity() {
        return this.opacity;
    }

    public final void setColor(@Size(3) @NotNull float[] color, @IntRange(from = 0, m706to = ScatterMapKt.Sentinel) int opacity, @Nullable String name) {
        Intrinsics.checkNotNullParameter(color, "color");
        System.arraycopy(color, 0, this.mHsvColor, 0, 3);
        this.colorName = name;
        this.opacity = opacity;
    }

    @NotNull
    public final float[] getColor() {
        float[] fArr = this.mHsvColor;
        return new float[]{fArr[0], fArr[1], fArr[2]};
    }

    public SpenPaletteColorInfo(@NotNull SpenPaletteColorInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        float[] fArr = {0.0f, 0.0f, 0.0f};
        this.mHsvColor = fArr;
        info.getColor(fArr);
        this.opacity = info.opacity;
        this.colorName = info.colorName;
    }
}
