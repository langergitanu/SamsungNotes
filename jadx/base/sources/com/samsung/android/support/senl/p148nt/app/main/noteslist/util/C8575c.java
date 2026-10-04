package com.samsung.android.support.senl.p148nt.app.main.noteslist.util;

import android.animation.ValueAnimator;
import android.view.View;
import com.samsung.android.support.senl.p148nt.base.winset.view.toolbar.CustomToolbar;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.noteslist.util.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C8575c implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6263a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ View f6264b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ int f6265c;

    public /* synthetic */ C8575c(View view, int i, int i2) {
        this.f6263a = i2;
        this.f6264b = view;
        this.f6265c = i;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f6263a) {
            case 0:
                HolderAnimation.decorateRoundFavoriteShape$lambda$10(this.f6264b, this.f6265c, valueAnimator);
                break;
            default:
                CustomToolbar.setHeightUpdateListener$lambda$10(this.f6264b, this.f6265c, valueAnimator);
                break;
        }
    }
}
