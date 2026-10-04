package com.airbnb.lottie;

/* JADX INFO: renamed from: com.airbnb.lottie.r */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class RunnableC4351r implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1956a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ LottieDrawable f1957b;

    public /* synthetic */ RunnableC4351r(LottieDrawable lottieDrawable, int i) {
        this.f1956a = i;
        this.f1957b = lottieDrawable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1956a) {
            case 0:
                this.f1957b.lambda$new$1();
                break;
            default:
                this.f1957b.lambda$new$2();
                break;
        }
    }
}
