package com.samsung.android.support.senl.p148nt.base.winset.view.dynamical;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.base.winset.view.dynamical.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C8973a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6503a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ViewGroup.LayoutParams f6504b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ View f6505c;

    public /* synthetic */ C8973a(int i, View view, ViewGroup.LayoutParams layoutParams) {
        this.f6503a = i;
        this.f6504b = layoutParams;
        this.f6505c = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f6503a) {
            case 0:
                HorizontalChangeableView.update$lambda$0(this.f6504b, this.f6505c, valueAnimator);
                break;
            default:
                VerticalChangeableView.update$lambda$0(this.f6504b, this.f6505c, valueAnimator);
                break;
        }
    }
}
