package com.samsung.android.support.senl.addons.brush.binding.adapter;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.samsung.android.sdk.pen.setting.SpenSettingBrushLayout;
import com.samsung.android.sdk.pen.setting.colorpalette.SpenColorLayout;
import com.samsung.android.support.senl.addons.base.binding.adapters.BAViewHideAnimation;
import com.samsung.android.support.senl.addons.base.viewmodel.animation.HideAnimationData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/brush/binding/adapter/BABrushMenuHide;", "", "<init>", "()V", "runMenuHideAnimation", "", "view", "Landroid/view/View;", "viewAnimation", "Landroid/util/SparseArray;", "Lcom/samsung/android/support/senl/addons/base/viewmodel/animation/HideAnimationData;", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BABrushMenuHide {

    @NotNull
    public static final BABrushMenuHide INSTANCE = new BABrushMenuHide();

    private BABrushMenuHide() {
    }

    public final void runMenuHideAnimation(@Nullable View view, @Nullable SparseArray<HideAnimationData> viewAnimation) {
        View childAt;
        if (!(view instanceof ViewGroup) || viewAnimation == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        int i = 0;
        while (true) {
            if (i >= childCount) {
                childAt = null;
                break;
            }
            childAt = viewGroup.getChildAt(i);
            if (childAt instanceof SpenSettingBrushLayout) {
                break;
            } else {
                i++;
            }
        }
        if (childAt == null) {
            return;
        }
        SpenSettingBrushLayout spenSettingBrushLayout = (SpenSettingBrushLayout) childAt;
        SpenColorLayout colorView = spenSettingBrushLayout.getColorView();
        Object penView = spenSettingBrushLayout.getPenView();
        Intrinsics.checkNotNull(penView, "null cannot be cast to non-null type android.view.View");
        View view2 = (View) penView;
        int id = colorView.getId();
        int id2 = view2.getId();
        if (viewAnimation.get(id) != null) {
            BAViewHideAnimation bAViewHideAnimation = BAViewHideAnimation.INSTANCE;
            HideAnimationData hideAnimationData = viewAnimation.get(id);
            Intrinsics.checkNotNull(hideAnimationData);
            bAViewHideAnimation.runAnimation(colorView, hideAnimationData.getAnimationType());
        }
        if (viewAnimation.get(id2) != null) {
            BAViewHideAnimation bAViewHideAnimation2 = BAViewHideAnimation.INSTANCE;
            HideAnimationData hideAnimationData2 = viewAnimation.get(id2);
            Intrinsics.checkNotNull(hideAnimationData2);
            bAViewHideAnimation2.runAnimation(view2, hideAnimationData2.getAnimationType());
        }
    }
}
