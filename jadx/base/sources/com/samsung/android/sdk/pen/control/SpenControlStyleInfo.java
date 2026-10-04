package com.samsung.android.sdk.pen.control;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0005J\u0013\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0096\u0002R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/control/SpenControlStyleInfo;", "", "<init>", "()V", "info", "(Lcom/samsung/android/sdk/pen/control/SpenControlStyleInfo;)V", "baseColor", "", "movedColor", "pointColor", "pointBorderColor", "dashedLineBackgroundColor", "dashedLineColor", "isDashedLineEnabled", "", "dashedLineSegment", "", "rotationHandleSize", "", "rotationHandleDistance", "equals", "other", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenControlStyleInfo {

    @JvmField
    public int baseColor;

    @JvmField
    public int dashedLineBackgroundColor;

    @JvmField
    public int dashedLineColor;

    @JvmField
    @NotNull
    public float[] dashedLineSegment;

    @JvmField
    public boolean isDashedLineEnabled;

    @JvmField
    public int movedColor;

    @JvmField
    public int pointBorderColor;

    @JvmField
    public int pointColor;

    @JvmField
    public float rotationHandleDistance;

    @JvmField
    public float rotationHandleSize;

    public SpenControlStyleInfo() {
        this.dashedLineSegment = new float[]{0.0f, 0.0f};
    }

    public boolean equals(@Nullable Object other) {
        if (!(other instanceof SpenControlStyleInfo)) {
            return false;
        }
        SpenControlStyleInfo spenControlStyleInfo = (SpenControlStyleInfo) other;
        if (this.baseColor == spenControlStyleInfo.baseColor && this.movedColor == spenControlStyleInfo.movedColor && this.pointColor == spenControlStyleInfo.pointColor && this.pointBorderColor == spenControlStyleInfo.pointBorderColor && this.dashedLineBackgroundColor == spenControlStyleInfo.dashedLineBackgroundColor && this.dashedLineColor == spenControlStyleInfo.dashedLineColor && this.isDashedLineEnabled == spenControlStyleInfo.isDashedLineEnabled) {
            float[] fArr = this.dashedLineSegment;
            float f = fArr[0];
            float[] fArr2 = spenControlStyleInfo.dashedLineSegment;
            if (f == fArr2[0] && fArr[1] == fArr2[1] && this.rotationHandleSize == spenControlStyleInfo.rotationHandleSize && this.rotationHandleDistance == spenControlStyleInfo.rotationHandleDistance) {
                return true;
            }
        }
        return false;
    }

    public SpenControlStyleInfo(@NotNull SpenControlStyleInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        float[] fArr = {0.0f, 0.0f};
        this.dashedLineSegment = fArr;
        this.baseColor = info.baseColor;
        this.movedColor = info.movedColor;
        this.pointColor = info.pointColor;
        this.pointBorderColor = info.pointBorderColor;
        this.dashedLineBackgroundColor = info.dashedLineBackgroundColor;
        this.dashedLineColor = info.dashedLineColor;
        this.isDashedLineEnabled = info.isDashedLineEnabled;
        float[] fArr2 = info.dashedLineSegment;
        fArr[0] = fArr2[0];
        fArr[1] = fArr2[1];
        this.rotationHandleSize = info.rotationHandleSize;
        this.rotationHandleDistance = info.rotationHandleDistance;
    }
}
