package com.samsung.android.sdk.pen.setting;

import android.util.Size;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u00020\u0012\"\u00020\u0005J\u000e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0010J\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0010J\u000e\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0010J\u000e\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0010J \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0005H&J\b\u0010\u001f\u001a\u00020\u0005H&J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005H&J\u0010\u0010!\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005H&J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0005H&J \u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u0005H&R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006&"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenBrushMoveAlign;", "", "<init>", "()V", "ANGLE_INVALID", "", "ANGLE_0", "ANGLE_90", "ANGLE_180", "ANGLE_270", "deviceAngle", "getDeviceAngle", "()I", "setDeviceAngle", "(I)V", "hasSameDeviceAngle", "", "angles", "", "getViewAngleLeftToTop", "isPenView", "getViewAngleRightToTop", "getViewAngleTopToLeft", "getViewAngleTopToRight", "moveView", "", "target", "Landroid/view/View;", "size", "Landroid/util/Size;", "layoutDirection", "getMoveOrientation", "getPenAngle", "getSelectorAngle", "getColorFlip", "getNextViewAngle", "isPen", "nextAlign", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public abstract class SpenBrushMoveAlign {

    @JvmField
    public int ANGLE_INVALID = -1;

    @JvmField
    public int ANGLE_90 = 90;

    @JvmField
    public int ANGLE_180 = 180;

    @JvmField
    public int ANGLE_270 = 270;

    @JvmField
    public int ANGLE_0;
    private int deviceAngle = this.ANGLE_0;

    public abstract int getColorFlip(int layoutDirection);

    public final int getDeviceAngle() {
        return this.deviceAngle;
    }

    public abstract int getMoveOrientation();

    public abstract int getNextViewAngle(boolean isPen, int layoutDirection, int nextAlign);

    public abstract int getPenAngle(int layoutDirection);

    public abstract int getSelectorAngle(int layoutDirection);

    public final int getViewAngleLeftToTop(boolean isPenView) {
        return (!(isPenView && hasSameDeviceAngle(this.ANGLE_90, this.ANGLE_180)) && (isPenView || !hasSameDeviceAngle(this.ANGLE_180, this.ANGLE_270))) ? -this.ANGLE_90 : this.ANGLE_90;
    }

    public final int getViewAngleRightToTop(boolean isPenView) {
        return (!(isPenView && hasSameDeviceAngle(this.ANGLE_180, this.ANGLE_270)) && (isPenView || !hasSameDeviceAngle(this.ANGLE_90, this.ANGLE_180))) ? this.ANGLE_90 : -this.ANGLE_90;
    }

    public final int getViewAngleTopToLeft(boolean isPenView) {
        return (!(isPenView && hasSameDeviceAngle(this.ANGLE_90, this.ANGLE_180)) && (isPenView || !hasSameDeviceAngle(this.ANGLE_180, this.ANGLE_270))) ? this.ANGLE_90 : -this.ANGLE_90;
    }

    public final int getViewAngleTopToRight(boolean isPenView) {
        return (!(isPenView && hasSameDeviceAngle(this.ANGLE_180, this.ANGLE_270)) && (isPenView || !hasSameDeviceAngle(this.ANGLE_90, this.ANGLE_180))) ? -this.ANGLE_90 : this.ANGLE_90;
    }

    public final boolean hasSameDeviceAngle(@NotNull int... angles) {
        Intrinsics.checkNotNullParameter(angles, "angles");
        for (int i : angles) {
            if (this.deviceAngle == i) {
                return true;
            }
        }
        return false;
    }

    public abstract void moveView(@NotNull View target, @NotNull Size size, int layoutDirection);

    public final void setDeviceAngle(int i) {
        this.deviceAngle = i;
    }
}
