package com.samsung.android.support.senl.addons.base.binding.adapters;

import android.animation.Animator;
import android.util.SparseArray;
import android.view.View;
import com.samsung.android.spr.drawable.animation.interpolator.SineInOut90;
import com.samsung.android.support.senl.addons.C7944R;
import com.samsung.android.support.senl.addons.base.viewmodel.animation.HideAnimationData;
import com.samsung.android.support.senl.addons.base.viewmodel.animation.IMenuHideAnimation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0010\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tJ\u0016\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/addons/base/binding/adapters/BAViewHideAnimation;", "", "<init>", "()V", "runHideAnimation", "", "view", "Landroid/view/View;", "viewAnimation", "Landroid/util/SparseArray;", "Lcom/samsung/android/support/senl/addons/base/viewmodel/animation/HideAnimationData;", "runAnimation", "animType", "", "ntAddons_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class BAViewHideAnimation {

    @NotNull
    public static final BAViewHideAnimation INSTANCE = new BAViewHideAnimation();

    private BAViewHideAnimation() {
    }

    public final void runAnimation(@NotNull final View view, int animType) {
        Intrinsics.checkNotNullParameter(view, "view");
        IMenuHideAnimation.Companion companion = IMenuHideAnimation.INSTANCE;
        if (animType == companion.getTYPE_ANIMATION_HIDE()) {
            view.animate().alpha(0.0f).setDuration(view.getResources().getInteger(C7944R.integer.editor_sub_menu_anim_duration)).setInterpolator(new SineInOut90()).setListener(new Animator.AnimatorListener() { // from class: com.samsung.android.support.senl.addons.base.binding.adapters.BAViewHideAnimation.runAnimation.1
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                    view.setAlpha(1.0f);
                    view.invalidate();
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    Intrinsics.checkNotNullParameter(animation, "animation");
                }
            });
        } else if (animType == companion.getTYPE_ANIMATION_SHOW()) {
            view.clearAnimation();
            view.animate().cancel();
            view.setAlpha(1.0f);
            view.invalidate();
        }
    }

    public final void runHideAnimation(@NotNull View view, @Nullable SparseArray<HideAnimationData> viewAnimation) {
        Intrinsics.checkNotNullParameter(view, "view");
        int id = view.getId();
        if (viewAnimation == null || viewAnimation.get(id) == null) {
            return;
        }
        HideAnimationData hideAnimationData = viewAnimation.get(id);
        Intrinsics.checkNotNull(hideAnimationData);
        runAnimation(view, hideAnimationData.getAnimationType());
    }
}
