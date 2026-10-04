package com.samsung.android.support.senl.p148nt.app.main.noteslist.util;

import android.animation.ValueAnimator;
import android.widget.TextView;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.util.HolderAnimation;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.noteslist.util.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class C8573a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6259a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ TextView f6260b;

    public /* synthetic */ C8573a(TextView textView, int i) {
        this.f6259a = i;
        this.f6260b = textView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f6259a) {
            case 0:
                HolderAnimation.updateTextViewWidthAnimation$lambda$4$lambda$3(this.f6260b, valueAnimator);
                break;
            case 1:
                HolderAnimation.updateTextViewWidthAnimation$lambda$2$lambda$1(this.f6260b, valueAnimator);
                break;
            default:
                HolderAnimation.C85701.onAnimationEnd$lambda$1$lambda$0(this.f6260b, valueAnimator);
                break;
        }
    }
}
