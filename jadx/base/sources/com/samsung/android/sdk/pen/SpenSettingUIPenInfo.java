package com.samsung.android.sdk.pen;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0005J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;", "Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;", "<init>", "()V", "uiInfo", "(Lcom/samsung/android/sdk/pen/SpenSettingUIPenInfo;)V", "hsv", "", "colorUIInfo", "", "equals", "", "o", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public class SpenSettingUIPenInfo extends SpenSettingPenInfo {

    @JvmField
    public int colorUIInfo;

    @JvmField
    @NotNull
    public float[] hsv;

    public SpenSettingUIPenInfo() {
        this.hsv = new float[]{0.0f, 0.0f, 0.0f};
    }

    @Override // com.samsung.android.sdk.pen.SpenSettingPenInfo
    public boolean equals(@Nullable Object o) {
        if (!(o instanceof SpenSettingUIPenInfo)) {
            return false;
        }
        SpenSettingUIPenInfo spenSettingUIPenInfo = (SpenSettingUIPenInfo) o;
        return Intrinsics.areEqual(this.name, spenSettingUIPenInfo.name) && this.sizeLevel == spenSettingUIPenInfo.sizeLevel && this.color == spenSettingUIPenInfo.color && this.particleDensity == spenSettingUIPenInfo.particleDensity && Float.compare(this.particleSize, spenSettingUIPenInfo.particleSize) == 0 && this.isFixedWidth == spenSettingUIPenInfo.isFixedWidth && this.isFixedOpacity == spenSettingUIPenInfo.isFixedOpacity && this.isAutoSizeEnabled == spenSettingUIPenInfo.isAutoSizeEnabled && this.fitRatio == spenSettingUIPenInfo.fitRatio && Arrays.equals(this.hsv, spenSettingUIPenInfo.hsv);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenSettingUIPenInfo(@NotNull SpenSettingUIPenInfo uiInfo) {
        super(uiInfo);
        Intrinsics.checkNotNullParameter(uiInfo, "uiInfo");
        float[] fArr = {0.0f, 0.0f, 0.0f};
        this.hsv = fArr;
        System.arraycopy(uiInfo.hsv, 0, fArr, 0, 3);
        this.colorUIInfo = uiInfo.colorUIInfo;
    }
}
