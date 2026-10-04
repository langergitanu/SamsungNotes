package com.samsung.android.sdk.pen;

import com.samsung.android.sdk.pen.document.SpenObjectStroke;
import com.samsung.android.sdk.pen.pen.SpenPenManager;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0016\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0005J\u0013\u0010\u001e\u001a\u00020\r2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, m13886d2 = {"Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;", "", "<init>", "()V", "info", "(Lcom/samsung/android/sdk/pen/SpenSettingPenInfo;)V", "name", "", "size", "", "color", "", "isCurvable", "", "advancedSetting", "isEraserEnabled", "sizeLevel", "particleDensity", "particleSize", "isFixedWidth", "isFixedOpacity", "isAutoSizeEnabled", "fitRatio", "isDpSize", "fromLightColor", "toLightColor", "fromDarkColor", "toDarkColor", "dashType", "dashOffset", "equals", "o", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public class SpenSettingPenInfo {

    @JvmField
    @NotNull
    public String advancedSetting;

    @JvmField
    public int color;

    @JvmField
    public float dashOffset;

    @JvmField
    public int dashType;

    @JvmField
    public float fitRatio;

    @JvmField
    public int fromDarkColor;

    @JvmField
    public int fromLightColor;

    @JvmField
    public boolean isAutoSizeEnabled;

    @JvmField
    public boolean isCurvable;

    @JvmField
    public boolean isDpSize;

    @JvmField
    public boolean isEraserEnabled;

    @JvmField
    public boolean isFixedOpacity;

    @JvmField
    public boolean isFixedWidth;

    @JvmField
    @NotNull
    public String name;

    @JvmField
    public int particleDensity;

    @JvmField
    public float particleSize;

    @JvmField
    public float size;

    @JvmField
    public int sizeLevel;

    @JvmField
    public int toDarkColor;

    @JvmField
    public int toLightColor;

    public SpenSettingPenInfo() {
        this.name = SpenPenManager.SPEN_FOUNTAIN_PEN;
        this.size = 10.0f;
        this.color = -16777216;
        this.isCurvable = true;
        this.advancedSetting = "";
        this.particleDensity = 1;
        this.fitRatio = 1.0f;
        this.fromLightColor = -16777216;
        this.toLightColor = -16777216;
        this.fromDarkColor = -16777216;
        this.toDarkColor = -16777216;
        this.dashType = SpenObjectStroke.PenDashType.CONTINUOUS_LINE.ordinal();
    }

    public boolean equals(@Nullable Object o) {
        if (!(o instanceof SpenSettingPenInfo)) {
            return false;
        }
        SpenSettingPenInfo spenSettingPenInfo = (SpenSettingPenInfo) o;
        return Float.compare(this.size, spenSettingPenInfo.size) == 0 && this.color == spenSettingPenInfo.color && this.isCurvable == spenSettingPenInfo.isCurvable && this.isEraserEnabled == spenSettingPenInfo.isEraserEnabled && this.sizeLevel == spenSettingPenInfo.sizeLevel && this.particleDensity == spenSettingPenInfo.particleDensity && Float.compare(this.particleSize, spenSettingPenInfo.particleSize) == 0 && this.isFixedWidth == spenSettingPenInfo.isFixedWidth && this.isFixedOpacity == spenSettingPenInfo.isFixedOpacity && this.isAutoSizeEnabled == spenSettingPenInfo.isAutoSizeEnabled && this.fitRatio == spenSettingPenInfo.fitRatio && Intrinsics.areEqual(this.name, spenSettingPenInfo.name) && Intrinsics.areEqual(this.advancedSetting, spenSettingPenInfo.advancedSetting) && this.fromLightColor == spenSettingPenInfo.fromLightColor && this.toLightColor == spenSettingPenInfo.toLightColor && this.fromDarkColor == spenSettingPenInfo.fromDarkColor && this.toDarkColor == spenSettingPenInfo.toDarkColor && this.dashType == spenSettingPenInfo.dashType && Float.compare(this.dashOffset, spenSettingPenInfo.dashOffset) == 0;
    }

    public SpenSettingPenInfo(@NotNull SpenSettingPenInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        this.name = SpenPenManager.SPEN_FOUNTAIN_PEN;
        this.size = 10.0f;
        this.color = -16777216;
        this.isCurvable = true;
        this.advancedSetting = "";
        this.particleDensity = 1;
        this.fitRatio = 1.0f;
        this.fromLightColor = -16777216;
        this.toLightColor = -16777216;
        this.fromDarkColor = -16777216;
        this.toDarkColor = -16777216;
        this.dashType = SpenObjectStroke.PenDashType.CONTINUOUS_LINE.ordinal();
        this.name = info.name;
        this.size = info.size;
        this.sizeLevel = info.sizeLevel;
        this.color = info.color;
        this.isCurvable = info.isCurvable;
        this.isEraserEnabled = info.isEraserEnabled;
        this.advancedSetting = info.advancedSetting;
        this.particleDensity = info.particleDensity;
        this.particleSize = info.particleSize;
        this.isFixedWidth = info.isFixedWidth;
        this.isFixedOpacity = info.isFixedOpacity;
        this.isAutoSizeEnabled = info.isAutoSizeEnabled;
        this.fitRatio = info.fitRatio;
        this.fromLightColor = info.fromLightColor;
        this.toLightColor = info.toLightColor;
        this.fromDarkColor = info.fromDarkColor;
        this.toDarkColor = info.toDarkColor;
        this.dashType = info.dashType;
        this.dashOffset = info.dashOffset;
    }
}
