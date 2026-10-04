package com.samsung.android.sdk.pen.setting;

import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\b`\u0018\u00002\u00020\u0001J<\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\rH&J\b\u0010\u000e\u001a\u00020\rH&J\b\u0010\u000f\u001a\u00020\rH&J\b\u0010\u0010\u001a\u00020\rH&J\b\u0010\u0011\u001a\u00020\rH&¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenBrushMoveAniStrategy;", "", "setAniInfo", "", "aniView", "Landroid/view/View;", "isPen", "target", "oldAlign", "", "newAlign", "direction", "getAniRotation", "", "getAniTransX", "getAniTransY", "getAniPivotX", "getAniPivotY", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public interface SpenBrushMoveAniStrategy {
    float getAniPivotX();

    float getAniPivotY();

    float getAniRotation();

    float getAniTransX();

    float getAniTransY();

    boolean setAniInfo(@Nullable View aniView, boolean isPen, @Nullable View target, int oldAlign, int newAlign, int direction);
}
