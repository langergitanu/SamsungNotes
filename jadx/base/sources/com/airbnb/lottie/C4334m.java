package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;

/* JADX INFO: renamed from: com.airbnb.lottie.m */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C4334m implements LottieDrawable.LazyCompositionTask {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1939a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ LottieDrawable f1940b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ int f1941c;

    public /* synthetic */ C4334m(LottieDrawable lottieDrawable, int i, int i2) {
        this.f1939a = i2;
        this.f1940b = lottieDrawable;
        this.f1941c = i;
    }

    @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
    public final void run(LottieComposition lottieComposition) {
        switch (this.f1939a) {
            case 0:
                this.f1940b.lambda$setFrame$15(this.f1941c, lottieComposition);
                break;
            case 1:
                this.f1940b.lambda$setMaxFrame$7(this.f1941c, lottieComposition);
                break;
            default:
                this.f1940b.lambda$setMinFrame$5(this.f1941c, lottieComposition);
                break;
        }
    }
}
