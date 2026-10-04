package com.google.android.material.oneui.common.internal.util;

import android.graphics.Rect;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0004"}, m13886d2 = {"moveInsideAndIntersect", "", "Landroid/graphics/Rect;", "moveableArea", "material_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class RectHelperKt {
    public static final boolean moveInsideAndIntersect(@NotNull Rect rect, @NotNull Rect moveableArea) {
        Intrinsics.checkNotNullParameter(rect, "<this>");
        Intrinsics.checkNotNullParameter(moveableArea, "moveableArea");
        int i = rect.left;
        int i2 = moveableArea.left;
        int i4 = (i >= i2 && (i = rect.right) <= (i2 = moveableArea.right)) ? 0 : i2 - i;
        int i5 = rect.top;
        int i6 = moveableArea.top;
        int i7 = (i5 >= i6 && (i5 = rect.bottom) <= (i6 = moveableArea.bottom)) ? 0 : i6 - i5;
        if (i4 == 0 && i7 == 0) {
            return false;
        }
        rect.offset(i4, i7);
        rect.setIntersect(rect, moveableArea);
        return true;
    }
}
