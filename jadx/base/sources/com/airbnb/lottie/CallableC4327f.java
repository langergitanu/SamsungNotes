package com.airbnb.lottie;

import android.content.Context;
import java.util.concurrent.Callable;

/* JADX INFO: renamed from: com.airbnb.lottie.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class CallableC4327f implements Callable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1916a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Context f1917b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ String f1918c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ String f1919d;

    public /* synthetic */ CallableC4327f(Context context, String str, String str2, int i) {
        this.f1916a = i;
        this.f1917b = context;
        this.f1918c = str;
        this.f1919d = str2;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f1916a) {
            case 0:
                return LottieCompositionFactory.fromAssetSync(this.f1917b, this.f1918c, this.f1919d);
            default:
                return LottieCompositionFactory.lambda$fromUrl$0(this.f1917b, this.f1918c, this.f1919d);
        }
    }
}
