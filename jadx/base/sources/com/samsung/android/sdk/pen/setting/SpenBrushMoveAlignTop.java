package com.samsung.android.sdk.pen.setting;

import android.util.Size;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J \u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000bH\u0016¨\u0006\u0014"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenBrushMoveAlignTop;", "Lcom/samsung/android/sdk/pen/setting/SpenBrushMoveAlign;", "<init>", "()V", "moveView", "", "target", "Landroid/view/View;", "size", "Landroid/util/Size;", "layoutDirection", "", "getMoveOrientation", "getPenAngle", "getSelectorAngle", "getColorFlip", "getNextViewAngle", "isPen", "", "nextAlign", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenBrushMoveAlignTop extends SpenBrushMoveAlign {
    @Override // com.samsung.android.sdk.pen.setting.SpenBrushMoveAlign
    public int getColorFlip(int layoutDirection) {
        return getDeviceAngle() == this.ANGLE_180 ? 1 : 0;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenBrushMoveAlign
    public int getMoveOrientation() {
        return 1;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenBrushMoveAlign
    public int getNextViewAngle(boolean isPen, int layoutDirection, int nextAlign) {
        return nextAlign != 1 ? nextAlign != 2 ? nextAlign != 3 ? this.ANGLE_INVALID : this.ANGLE_0 : layoutDirection == 0 ? getViewAngleTopToLeft(isPen) : getViewAngleTopToRight(isPen) : layoutDirection == 0 ? getViewAngleTopToRight(isPen) : getViewAngleTopToLeft(isPen);
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenBrushMoveAlign
    public int getPenAngle(int layoutDirection) {
        int deviceAngle = getDeviceAngle();
        int i = this.ANGLE_0;
        return deviceAngle != i ? this.ANGLE_180 : i;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenBrushMoveAlign
    public int getSelectorAngle(int layoutDirection) {
        return this.ANGLE_0;
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenBrushMoveAlign
    public void moveView(@NotNull View target, @NotNull Size size, int layoutDirection) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(size, "size");
        float f = 2;
        target.setPivotX(size.getWidth() / f);
        target.setPivotY(size.getHeight() / f);
        target.setRotation(this.ANGLE_0);
        target.setTranslationX(0.0f);
        target.setTranslationY(0.0f);
    }
}
