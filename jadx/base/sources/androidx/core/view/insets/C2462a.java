package androidx.core.view.insets;

import android.animation.ValueAnimator;

/* JADX INFO: renamed from: androidx.core.view.insets.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class C2462a implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1341a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Protection f1342b;

    public /* synthetic */ C2462a(Protection protection, int i) {
        this.f1341a = i;
        this.f1342b = protection;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f1341a) {
            case 0:
                this.f1342b.lambda$animateInsetsAmount$1(valueAnimator);
                break;
            default:
                this.f1342b.lambda$animateAlpha$0(valueAnimator);
                break;
        }
    }
}
