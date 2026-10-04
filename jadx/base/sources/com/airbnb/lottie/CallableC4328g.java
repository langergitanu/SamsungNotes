package com.airbnb.lottie;

import android.content.Context;
import java.util.concurrent.Callable;
import java.util.zip.ZipInputStream;

/* JADX INFO: renamed from: com.airbnb.lottie.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class CallableC4328g implements Callable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1920a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Context f1921b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ ZipInputStream f1922c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ String f1923d;

    public /* synthetic */ CallableC4328g(Context context, ZipInputStream zipInputStream, String str, int i) {
        this.f1920a = i;
        this.f1921b = context;
        this.f1922c = zipInputStream;
        this.f1923d = str;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f1920a) {
            case 0:
                return LottieCompositionFactory.fromZipStreamSync(this.f1921b, this.f1922c, this.f1923d);
            default:
                return LottieCompositionFactory.fromZipStreamSync(this.f1921b, this.f1922c, this.f1923d);
        }
    }
}
