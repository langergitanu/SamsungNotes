package androidx.core.util;

import android.animation.ValueAnimator;
import androidx.core.util.SeslFadingEdgeHelperImpl;
import androidx.core.util.SeslFadingEdgeLegacyHelperImpl;

/* JADX INFO: renamed from: androidx.core.util.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class C2426c implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1322a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f1323b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ int f1324c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Runnable f1325d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ Object f1326e;

    public /* synthetic */ C2426c(Object obj, int i, int i2, Runnable runnable, int i4) {
        this.f1322a = i4;
        this.f1326e = obj;
        this.f1323b = i;
        this.f1324c = i2;
        this.f1325d = runnable;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f1322a) {
            case 0:
                ((SeslFadingEdgeHelperImpl.ColorAnimationManager) this.f1326e).lambda$startAnimation$0(this.f1323b, this.f1324c, this.f1325d, valueAnimator);
                break;
            default:
                ((SeslFadingEdgeLegacyHelperImpl.ColorAnimationManager) this.f1326e).lambda$startAnimation$0(this.f1323b, this.f1324c, this.f1325d, valueAnimator);
                break;
        }
    }
}
