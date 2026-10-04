package com.samsung.android.sdk.pen;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0005J\u0013\u0010\u0018\u001a\u00020\u00102\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/SpenSettingUILaserPenInfo;", "", "<init>", "()V", "info", "(Lcom/samsung/android/sdk/pen/SpenSettingUILaserPenInfo;)V", "type", "", "colorOption", "color", "colorUIInfo", "hsvColor", "", "blurSize", "", "fillInside", "", "strokeSize", "insideRatio", "waitingTime", "fadeOutTime", "rainbowDistance", "rainbowTime", "rainbowEffectType", "equals", "o", "copy", "", "src", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenSettingUILaserPenInfo {
    private static final int DEFAULT_FADE_OUT_DURATION = 400;
    private static final int DEFAULT_RAINBOW_DISTANCE = 1586;
    private static final int DEFAULT_RAINBOW_TIME = 2000;
    private static final int DEFAULT_WAITING_DURATION = 700;
    public static final int LASER_COLOR_RAINBOW = 1;
    public static final int LASER_COLOR_SINGLE = 0;
    public static final int LASER_TYPE_LINE = 1;
    public static final int LASER_TYPE_POINT = 0;
    public static final int RAINBOW_TYPE_DISTANCE = 0;
    public static final int RAINBOW_TYPE_TIME = 1;

    @JvmField
    public float blurSize;

    @JvmField
    public int color;

    @JvmField
    public int colorOption;

    @JvmField
    public int colorUIInfo;

    @JvmField
    public int fadeOutTime;

    @JvmField
    public boolean fillInside;

    @JvmField
    @NotNull
    public float[] hsvColor;

    @JvmField
    public float insideRatio;

    @JvmField
    public int rainbowDistance;

    @JvmField
    public int rainbowEffectType;

    @JvmField
    public int rainbowTime;

    @JvmField
    public float strokeSize;

    @JvmField
    public int type;

    @JvmField
    public int waitingTime;

    public SpenSettingUILaserPenInfo() {
        this.color = -16777216;
        this.hsvColor = new float[]{0.0f, 0.0f, 0.0f};
        this.blurSize = 18.0f;
        this.strokeSize = 80.0f;
        this.insideRatio = 60.0f;
        this.waitingTime = 700;
        this.fadeOutTime = 400;
        this.rainbowDistance = DEFAULT_RAINBOW_DISTANCE;
        this.rainbowTime = 2000;
    }

    public final void copy(@NotNull SpenSettingUILaserPenInfo src) {
        Intrinsics.checkNotNullParameter(src, "src");
        this.type = src.type;
        this.colorOption = src.colorOption;
        this.blurSize = src.blurSize;
        this.fillInside = src.fillInside;
        this.strokeSize = src.strokeSize;
        this.insideRatio = src.insideRatio;
        this.color = src.color;
        this.colorUIInfo = src.colorUIInfo;
        this.waitingTime = src.waitingTime;
        this.fadeOutTime = src.fadeOutTime;
        this.rainbowEffectType = src.rainbowEffectType;
        this.rainbowDistance = src.rainbowDistance;
        this.rainbowTime = src.rainbowTime;
        System.arraycopy(src.hsvColor, 0, this.hsvColor, 0, 3);
    }

    public boolean equals(@Nullable Object o) {
        if (!(o instanceof SpenSettingUILaserPenInfo)) {
            return false;
        }
        SpenSettingUILaserPenInfo spenSettingUILaserPenInfo = (SpenSettingUILaserPenInfo) o;
        return this.type == spenSettingUILaserPenInfo.type && this.colorOption == spenSettingUILaserPenInfo.colorOption && Float.compare(this.blurSize, spenSettingUILaserPenInfo.blurSize) == 0 && this.fillInside == spenSettingUILaserPenInfo.fillInside && Float.compare(this.strokeSize, spenSettingUILaserPenInfo.strokeSize) == 0 && Float.compare(this.insideRatio, spenSettingUILaserPenInfo.insideRatio) == 0 && this.color == spenSettingUILaserPenInfo.color && this.colorUIInfo == spenSettingUILaserPenInfo.colorUIInfo && this.waitingTime == spenSettingUILaserPenInfo.waitingTime && this.fadeOutTime == spenSettingUILaserPenInfo.fadeOutTime && this.rainbowEffectType == spenSettingUILaserPenInfo.rainbowEffectType && this.rainbowDistance == spenSettingUILaserPenInfo.rainbowDistance && this.rainbowTime == spenSettingUILaserPenInfo.rainbowTime && Arrays.equals(this.hsvColor, spenSettingUILaserPenInfo.hsvColor);
    }

    public SpenSettingUILaserPenInfo(@NotNull SpenSettingUILaserPenInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        this.color = -16777216;
        float[] fArr = {0.0f, 0.0f, 0.0f};
        this.hsvColor = fArr;
        this.blurSize = 18.0f;
        this.strokeSize = 80.0f;
        this.insideRatio = 60.0f;
        this.waitingTime = 700;
        this.fadeOutTime = 400;
        this.rainbowDistance = DEFAULT_RAINBOW_DISTANCE;
        this.rainbowTime = 2000;
        this.type = info.type;
        this.colorOption = info.colorOption;
        this.blurSize = info.blurSize;
        this.fillInside = info.fillInside;
        this.strokeSize = info.strokeSize;
        this.insideRatio = info.insideRatio;
        this.color = info.color;
        this.colorUIInfo = info.colorUIInfo;
        this.waitingTime = info.waitingTime;
        this.fadeOutTime = info.fadeOutTime;
        this.rainbowEffectType = info.rainbowEffectType;
        this.rainbowDistance = info.rainbowDistance;
        this.rainbowTime = info.rainbowTime;
        System.arraycopy(info.hsvColor, 0, fArr, 0, 3);
    }
}
