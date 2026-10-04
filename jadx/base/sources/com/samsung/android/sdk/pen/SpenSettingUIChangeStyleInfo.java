package com.samsung.android.sdk.pen;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0005J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/SpenSettingUIChangeStyleInfo;", "Lcom/samsung/android/sdk/pen/SpenSettingChangeStyleInfo;", "<init>", "()V", "info", "(Lcom/samsung/android/sdk/pen/SpenSettingUIChangeStyleInfo;)V", "strokeHSVColor", "", "fillHSVColor", "strokeColorUIInfo", "", "fillColorUIInfo", "equals", "", "o", "", "copy", "", "src", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenSettingUIChangeStyleInfo extends SpenSettingChangeStyleInfo {

    @JvmField
    public int fillColorUIInfo;

    @JvmField
    @NotNull
    public float[] fillHSVColor;

    @JvmField
    public int strokeColorUIInfo;

    @JvmField
    @NotNull
    public float[] strokeHSVColor;

    public SpenSettingUIChangeStyleInfo() {
        this.strokeHSVColor = new float[]{0.0f, 0.0f, 0.0f};
        this.fillHSVColor = new float[]{0.0f, 0.0f, 0.0f};
    }

    public final void copy(@NotNull SpenSettingUIChangeStyleInfo src) {
        Intrinsics.checkNotNullParameter(src, "src");
        this.type = src.type;
        this.sizeLevel = src.sizeLevel;
        this.color = src.color;
        this.fillColor = src.fillColor;
        this.isBlankShape = src.isBlankShape;
        this.strokeColorUIInfo = src.strokeColorUIInfo;
        this.fillColorUIInfo = src.fillColorUIInfo;
        System.arraycopy(src.strokeHSVColor, 0, this.strokeHSVColor, 0, 3);
        System.arraycopy(src.fillHSVColor, 0, this.fillHSVColor, 0, 3);
    }

    public boolean equals(@Nullable Object o) {
        if (!(o instanceof SpenSettingUIChangeStyleInfo)) {
            return false;
        }
        SpenSettingUIChangeStyleInfo spenSettingUIChangeStyleInfo = (SpenSettingUIChangeStyleInfo) o;
        return this.type == spenSettingUIChangeStyleInfo.type && this.sizeLevel == spenSettingUIChangeStyleInfo.sizeLevel && this.color == spenSettingUIChangeStyleInfo.color && this.fillColor == spenSettingUIChangeStyleInfo.fillColor && this.isBlankShape == spenSettingUIChangeStyleInfo.isBlankShape && this.strokeColorUIInfo == spenSettingUIChangeStyleInfo.strokeColorUIInfo && this.fillColorUIInfo == spenSettingUIChangeStyleInfo.fillColorUIInfo && Arrays.equals(this.strokeHSVColor, spenSettingUIChangeStyleInfo.strokeHSVColor) && Arrays.equals(this.fillHSVColor, spenSettingUIChangeStyleInfo.fillHSVColor);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenSettingUIChangeStyleInfo(@NotNull SpenSettingUIChangeStyleInfo info) {
        super(info);
        Intrinsics.checkNotNullParameter(info, "info");
        float[] fArr = {0.0f, 0.0f, 0.0f};
        this.strokeHSVColor = fArr;
        this.fillHSVColor = new float[]{0.0f, 0.0f, 0.0f};
        this.strokeColorUIInfo = info.strokeColorUIInfo;
        this.fillColorUIInfo = info.fillColorUIInfo;
        System.arraycopy(info.strokeHSVColor, 0, fArr, 0, 3);
        System.arraycopy(info.fillHSVColor, 0, this.fillHSVColor, 0, 3);
    }
}
