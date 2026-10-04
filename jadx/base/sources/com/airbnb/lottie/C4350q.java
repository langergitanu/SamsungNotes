package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;

/* JADX INFO: renamed from: com.airbnb.lottie.q */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C4350q implements LottieDrawable.LazyCompositionTask {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1953a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ LottieDrawable f1954b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ float f1955c;

    public /* synthetic */ C4350q(LottieDrawable lottieDrawable, float f, int i) {
        this.f1953a = i;
        this.f1954b = lottieDrawable;
        this.f1955c = f;
    }

    @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
    public final void run(LottieComposition lottieComposition) {
        switch (this.f1953a) {
            case 0:
                this.f1954b.lambda$setMaxProgress$8(this.f1955c, lottieComposition);
                break;
            case 1:
                this.f1954b.lambda$setMinProgress$6(this.f1955c, lottieComposition);
                break;
            default:
                this.f1954b.lambda$setProgress$16(this.f1955c, lottieComposition);
                break;
        }
    }
}
