package com.samsung.android.sdk.pen;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0005J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0096\u0002R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000b¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/SpenSettingFillColorInfo;", "", "<init>", "()V", "info", "(Lcom/samsung/android/sdk/pen/SpenSettingFillColorInfo;)V", "fillType", "", "getFillType", "()I", "setFillType", "(I)V", "fillColor", "getFillColor", "setFillColor", "floodFillTolerance", "getFloodFillTolerance", "setFloodFillTolerance", "equals", "", "o", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenSettingFillColorInfo {
    public static final int FILL_TYPE_SOLID = 0;
    private int fillColor;
    private int fillType;
    private int floodFillTolerance;

    public SpenSettingFillColorInfo() {
        this.fillColor = -16777216;
        this.floodFillTolerance = 51;
    }

    public boolean equals(@Nullable Object o) {
        if (!(o instanceof SpenSettingFillColorInfo)) {
            return false;
        }
        SpenSettingFillColorInfo spenSettingFillColorInfo = (SpenSettingFillColorInfo) o;
        return this.fillColor == spenSettingFillColorInfo.fillColor && this.fillType == spenSettingFillColorInfo.fillType && this.floodFillTolerance == spenSettingFillColorInfo.floodFillTolerance;
    }

    public final int getFillColor() {
        return this.fillColor;
    }

    public final int getFillType() {
        return this.fillType;
    }

    public final int getFloodFillTolerance() {
        return this.floodFillTolerance;
    }

    public final void setFillColor(int i) {
        this.fillColor = i;
    }

    public final void setFillType(int i) {
        this.fillType = i;
    }

    public final void setFloodFillTolerance(int i) {
        this.floodFillTolerance = i;
    }

    public SpenSettingFillColorInfo(@NotNull SpenSettingFillColorInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        this.fillColor = -16777216;
        this.floodFillTolerance = 51;
        this.fillType = info.fillType;
        this.fillColor = info.fillColor;
        this.floodFillTolerance = info.floodFillTolerance;
    }
}
