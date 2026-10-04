package com.google.android.material.chip;

import android.animation.ValueAnimator;
import android.view.View;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.util.HolderAnimation;

/* JADX INFO: renamed from: com.google.android.material.chip.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C4635c implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2245a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f2246b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ int f2247c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ View f2248d;

    public /* synthetic */ C4635c(View view, int i, int i2, int i4) {
        this.f2245a = i4;
        this.f2248d = view;
        this.f2246b = i;
        this.f2247c = i2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f2245a) {
            case 0:
                ((SeslChipGroup) this.f2248d).lambda$startSeslLayoutHeightAnim$1(this.f2246b, this.f2247c, valueAnimator);
                break;
            default:
                HolderAnimation.getSubFolderCollapseAnimator$lambda$0(this.f2248d, this.f2246b, this.f2247c, valueAnimator);
                break;
        }
    }
}
