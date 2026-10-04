package com.google.android.material.timepicker;

/* JADX INFO: renamed from: com.google.android.material.timepicker.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class RunnableC4939b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2409a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f2410b;

    public /* synthetic */ RunnableC4939b(Object obj, int i) {
        this.f2409a = i;
        this.f2410b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2409a) {
            case 0:
                ((RadialViewGroup) this.f2410b).updateLayoutParams();
                break;
            default:
                ((MaterialTimePicker) this.f2410b).lambda$onViewCreated$0();
                break;
        }
    }
}
