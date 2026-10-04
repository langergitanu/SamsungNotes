package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;

/* JADX INFO: renamed from: com.airbnb.lottie.s */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C4352s implements LottieDrawable.LazyCompositionTask {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1958a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ LottieDrawable f1959b;

    public /* synthetic */ C4352s(LottieDrawable lottieDrawable, int i) {
        this.f1958a = i;
        this.f1959b = lottieDrawable;
    }

    @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
    public final void run(LottieComposition lottieComposition) {
        switch (this.f1958a) {
            case 0:
                this.f1959b.lambda$resumeAnimation$4(lottieComposition);
                break;
            default:
                this.f1959b.lambda$playAnimation$3(lottieComposition);
                break;
        }
    }
}
