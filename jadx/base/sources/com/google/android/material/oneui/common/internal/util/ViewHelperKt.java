package com.google.android.material.oneui.common.internal.util;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@Metadata(m13885d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0007\u001a\u0014\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0007\u001a\u0014\u0010\b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0007¨\u0006\n"}, m13886d2 = {"getCurrentLayoutBounds", "", "Landroid/view/View;", "outBounds", "Landroid/graphics/Rect;", "getViewRect", "rect", "setViewRect", "updateViewBounds", "targetBounds", "material_release"}, m13887k = 2, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class ViewHelperKt {
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final void getCurrentLayoutBounds(@NotNull View view, @NotNull Rect outBounds) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(outBounds, "outBounds");
        outBounds.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        outBounds.offset((int) view.getTranslationX(), (int) view.getTranslationY());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final void getViewRect(@NotNull View view, @NotNull Rect rect) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(rect, "rect");
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final void setViewRect(@NotNull View view, @NotNull Rect rect) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(rect, "rect");
        view.setLeft(rect.left);
        view.setTop(rect.top);
        view.setRight(rect.right);
        view.setBottom(rect.bottom);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final void updateViewBounds(@NotNull View view, @NotNull Rect targetBounds) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        Intrinsics.checkNotNullParameter(targetBounds, "targetBounds");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            marginLayoutParams.width = targetBounds.width();
            marginLayoutParams.height = targetBounds.height();
            marginLayoutParams.leftMargin = targetBounds.left;
            marginLayoutParams.topMargin = targetBounds.top;
            view.setLayoutParams(marginLayoutParams);
            view.invalidate();
        }
    }
}
