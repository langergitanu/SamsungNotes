package com.samsung.android.sdk.pen.setting;

import android.annotation.SuppressLint;
import android.view.View;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenColorLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u0003H\u0014J \u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0014J\b\u0010\u000e\u001a\u00020\u000fH\u0016¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenBrushColorNextMovement;", "Lcom/samsung/android/sdk/pen/setting/SpenBrushNextMovement;", "target", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "decideCurrentDegree", "", "decideNextDegree", "strategy", "Lcom/samsung/android/sdk/pen/setting/SpenBrushMoveStrategy;", "toAlignment", "", "layoutDirection", "needTopDownFlip", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"LongLogTag"})
public final class SpenBrushColorNextMovement extends SpenBrushNextMovement {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SpenBrushColorNextMovement(@NotNull View target) {
        super(target);
        Intrinsics.checkNotNullParameter(target, "target");
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenBrushNextMovement
    public float decideCurrentDegree(@NotNull View target) {
        Intrinsics.checkNotNullParameter(target, "target");
        return ((SpenColorLayout) target).getFlip(1);
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenBrushNextMovement
    public float decideNextDegree(@NotNull SpenBrushMoveStrategy strategy, int toAlignment, int layoutDirection) {
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        strategy.setColorInfo(0, toAlignment, layoutDirection);
        return strategy.getColorFlipDegree();
    }

    @Override // com.samsung.android.sdk.pen.setting.SpenBrushNextMovement
    public boolean needTopDownFlip() {
        if (hasSameDegree()) {
            return false;
        }
        float aniRotation = getAniRotation();
        boolean z = aniRotation == getViewRotation();
        return aniRotation == 0.0f || (getCurrentDegree() == 0.0f && Math.abs(aniRotation) == 90.0f && z) || (getNextDegree() == 0.0f && z);
    }
}
