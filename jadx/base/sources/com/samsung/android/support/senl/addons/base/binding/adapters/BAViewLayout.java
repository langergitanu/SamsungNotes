package com.samsung.android.support.senl.addons.base.binding.adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.samsung.android.support.senl.addons.base.utils.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\u000f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000bJ\u0016\u0010\u0011\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\u0014\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\u0015\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017J\u0016\u0010\u0018\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\u0019\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/adapters/BAViewLayout;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "setViewWidth", "", "view", "Landroid/view/View;", "size", "", "setViewHeight", "setViewMarginTop", "setViewMarginBottom", "setViewMarginBottomResId", "resId", "setViewMarginRight", "setViewMarginLeft", "setViewMarginStart", "setViewMarginEnd", "setViewWeight", "weight", "", "setViewPaddingEnd", "setViewGravityByDirection", "gravity", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BAViewLayout {

    @NotNull
    public static final BAViewLayout INSTANCE = new BAViewLayout();

    @NotNull
    private static final String TAG = Logger.createTag("BAViewLayout");

    private BAViewLayout() {
    }

    public final void setViewGravityByDirection(@NotNull View view, int gravity) {
        Intrinsics.checkNotNullParameter(view, "view");
        Logger.m7100d(TAG, "setViewGravityByDirection(), gravity : " + gravity);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        switch (gravity) {
            case 8388659:
                layoutParams2.addRule(20);
                layoutParams2.addRule(10);
                break;
            case 8388661:
                layoutParams2.addRule(21);
                layoutParams2.addRule(10);
                break;
            case 8388691:
                layoutParams2.addRule(20);
                layoutParams2.addRule(12);
                break;
            case 8388693:
                layoutParams2.addRule(21);
                layoutParams2.addRule(12);
                break;
        }
        view.setLayoutParams(layoutParams2);
    }

    public final void setViewHeight(@NotNull View view, int size) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.getLayoutParams().height = size;
    }

    public final void setViewMarginBottom(@NotNull View view, int size) {
        Intrinsics.checkNotNullParameter(view, "view");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = size;
        view.requestLayout();
    }

    public final void setViewMarginBottomResId(@NotNull View view, int resId) {
        Intrinsics.checkNotNullParameter(view, "view");
        setViewMarginBottom(view, view.getResources().getDimensionPixelSize(resId));
    }

    public final void setViewMarginEnd(@NotNull View view, int size) {
        Intrinsics.checkNotNullParameter(view, "view");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams).setMarginEnd(size);
    }

    public final void setViewMarginLeft(@NotNull View view, int size) {
        Intrinsics.checkNotNullParameter(view, "view");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = size;
    }

    public final void setViewMarginRight(@NotNull View view, int size) {
        Intrinsics.checkNotNullParameter(view, "view");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = size;
    }

    public final void setViewMarginStart(@NotNull View view, int size) {
        Intrinsics.checkNotNullParameter(view, "view");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams).setMarginStart(size);
    }

    public final void setViewMarginTop(@NotNull View view, int size) {
        Intrinsics.checkNotNullParameter(view, "view");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = size;
    }

    public final void setViewPaddingEnd(@NotNull View view, int size) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setPaddingRelative(view.getPaddingStart(), view.getPaddingTop(), size, view.getPaddingBottom());
    }

    public final void setViewWeight(@NotNull View view, float weight) {
        Intrinsics.checkNotNullParameter(view, "view");
        try {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            ((LinearLayout.LayoutParams) layoutParams).weight = weight;
            setViewWidth(view, 0);
        } catch (Exception unused) {
            Logger.m7101e(TAG, "setViewWeight(), parent is not LinearLayout!!!");
        }
    }

    public final void setViewWidth(@NotNull View view, int size) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.getLayoutParams().width = size;
    }
}
