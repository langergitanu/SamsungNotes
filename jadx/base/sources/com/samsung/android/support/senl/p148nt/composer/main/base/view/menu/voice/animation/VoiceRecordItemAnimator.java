package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.voice.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.animation.PathInterpolator;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/view/menu/voice/animation/VoiceRecordItemAnimator;", "Landroidx/recyclerview/widget/DefaultItemAnimator;", "<init>", "()V", "mCustomInterpolator", "Landroid/view/animation/PathInterpolator;", "animateRemove", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class VoiceRecordItemAnimator extends DefaultItemAnimator {
    private static final int BASE_DURATION = 400;
    private static final float SCALE_OUT_VALUE = 0.95f;

    @NotNull
    private static final String TAG = "VoiceRecordItemAnimator";

    @NotNull
    private final PathInterpolator mCustomInterpolator = new PathInterpolator(0.4f, 0.6f, 0.0f, 1.0f);

    @Override // androidx.recyclerview.widget.DefaultItemAnimator, androidx.recyclerview.widget.SimpleItemAnimator
    public boolean animateRemove(@NotNull final RecyclerView.ViewHolder holder) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        Logger.m10999d(TAG, "animateRemove");
        holder.itemView.clearAnimation();
        holder.itemView.animate().scaleX(0.95f).scaleY(0.95f).alpha(0.0f).setDuration(400L).setInterpolator(this.mCustomInterpolator).setListener(new AnimatorListenerAdapter() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.voice.animation.VoiceRecordItemAnimator.animateRemove.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                super.onAnimationEnd(animation);
                animation.removeListener(this);
                holder.itemView.setAlpha(1.0f);
                holder.itemView.setScaleX(1.0f);
                holder.itemView.setScaleY(1.0f);
                VoiceRecordItemAnimator.this.dispatchRemoveFinished(holder);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation, boolean isReverse) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                VoiceRecordItemAnimator.this.dispatchRemoveStarting(holder);
            }
        }).start();
        return false;
    }
}
