package com.samsung.android.support.senl.p148nt.base.winset.view.floater;

import android.view.MotionEvent;
import androidx.constraintlayout.widget.ConstraintLayout;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.base.winset.view.floater.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC8979b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6508a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ConstraintLayout f6509b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f6510c;

    public /* synthetic */ RunnableC8979b(ConstraintLayout constraintLayout, Object obj, int i) {
        this.f6508a = i;
        this.f6509b = constraintLayout;
        this.f6510c = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6508a) {
            case 0:
                FloaterContainer.access$checkOutBounds((FloaterContainer) this.f6509b, (IFloater) this.f6510c);
                break;
            default:
                FloatLayout.detectLongPressGesture$lambda$2((FloatLayout) this.f6509b, (MotionEvent) this.f6510c);
                break;
        }
    }
}
