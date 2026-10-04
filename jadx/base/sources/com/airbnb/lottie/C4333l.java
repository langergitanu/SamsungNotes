package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;

/* JADX INFO: renamed from: com.airbnb.lottie.l */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C4333l implements LottieDrawable.LazyCompositionTask {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1936a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ LottieDrawable f1937b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ String f1938c;

    public /* synthetic */ C4333l(LottieDrawable lottieDrawable, String str, int i) {
        this.f1936a = i;
        this.f1937b = lottieDrawable;
        this.f1938c = str;
    }

    @Override // com.airbnb.lottie.LottieDrawable.LazyCompositionTask
    public final void run(LottieComposition lottieComposition) {
        switch (this.f1936a) {
            case 0:
                this.f1937b.lambda$setMinAndMaxFrame$11(this.f1938c, lottieComposition);
                break;
            case 1:
                this.f1937b.lambda$setMaxFrame$10(this.f1938c, lottieComposition);
                break;
            default:
                this.f1937b.lambda$setMinFrame$9(this.f1938c, lottieComposition);
                break;
        }
    }
}
