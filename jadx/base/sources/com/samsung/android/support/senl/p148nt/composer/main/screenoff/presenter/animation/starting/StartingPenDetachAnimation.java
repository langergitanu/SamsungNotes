package com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.animation.starting;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.model.statical.PenInfoModel;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.SOLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0014J\b\u0010\u0006\u001a\u00020\u0005H\u0014R\u0014\u0010\u0007\u001a\u00020\bX\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/animation/starting/StartingPenDetachAnimation;", "Lcom/samsung/android/support/senl/nt/composer/main/screenoff/presenter/animation/starting/AbsStartingAnimation;", "<init>", "()V", "initSystemValues", "", "initPosition", "startOffset", "", "getStartOffset", "()I", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class StartingPenDetachAnimation extends AbsStartingAnimation {

    @NotNull
    private static final String TAG = SOLogger.createTag("StartingPenDetachAnimation");
    private final int startOffset;

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.animation.starting.AbsStartingAnimation
    public int getStartOffset() {
        return this.startOffset;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.animation.starting.AbsStartingAnimation
    public void initPosition() {
        Resources resources;
        Resources resources2;
        LottieAnimationView mAnimationView = getMAnimationView();
        if ((mAnimationView != null ? mAnimationView.getParent() : null) != null) {
            try {
                LottieAnimationView mAnimationView2 = getMAnimationView();
                ViewParent parent = mAnimationView2 != null ? mAnimationView2.getParent() : null;
                Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) parent).removeView(getMAnimationView());
            } catch (Exception e) {
                AbstractC0000a.m24u("initPosition# animationView is already removed, ", e.getMessage(), SOLogger.INSTANCE, TAG);
            }
        }
        View mContainer = getMContainer();
        View viewFindViewById = mContainer != null ? mContainer.findViewById(C9086R.id.main_layout) : null;
        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) viewFindViewById).addView(getMAnimationView());
        Context mContext = getMContext();
        Integer numValueOf = (mContext == null || (resources2 = mContext.getResources()) == null) ? null : Integer.valueOf((int) resources2.getDimension(C9086R.dimen.screenoff_pen_detach_animation_width));
        Context mContext2 = getMContext();
        Integer numValueOf2 = (mContext2 == null || (resources = mContext2.getResources()) == null) ? null : Integer.valueOf((int) resources.getDimension(C9086R.dimen.screenoff_pen_detach_animation_height));
        LottieAnimationView mAnimationView3 = getMAnimationView();
        ViewGroup.LayoutParams layoutParams = mAnimationView3 != null ? mAnimationView3.getLayoutParams() : null;
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.width = numValueOf != null ? numValueOf.intValue() : 0;
        layoutParams2.height = numValueOf2 != null ? numValueOf2.intValue() : 0;
        if (PenInfoModel.INSTANCE.getPenPositionType() == PenInfoModel.PEN_POSITION_TYPE.LEFT) {
            layoutParams2.addRule(20);
        } else {
            layoutParams2.addRule(21);
        }
        layoutParams2.addRule(12);
        LottieAnimationView mAnimationView4 = getMAnimationView();
        if (mAnimationView4 != null) {
            mAnimationView4.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.screenoff.presenter.animation.starting.AbsStartingAnimation
    public void initSystemValues() {
    }
}
