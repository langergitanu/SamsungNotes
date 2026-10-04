package com.airbnb.lottie;

import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.InputStream;
import java.util.concurrent.Callable;
import okio.Source;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.airbnb.lottie.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class CallableC4323b implements Callable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1909a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ String f1910b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f1911c;

    public /* synthetic */ CallableC4323b(int i, Object obj, String str) {
        this.f1909a = i;
        this.f1911c = obj;
        this.f1910b = str;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f1909a) {
            case 0:
                return ((LottieAnimationView) this.f1911c).lambda$fromAssets$2(this.f1910b);
            case 1:
                return LottieCompositionFactory.fromJsonSourceSync((Source) this.f1911c, this.f1910b);
            case 2:
                return LottieCompositionFactory.fromJsonStringSync(this.f1910b, (String) this.f1911c);
            case 3:
                return LottieCompositionFactory.fromJsonReaderSync((JsonReader) this.f1911c, this.f1910b);
            case 4:
                return LottieCompositionFactory.fromJsonInputStreamSync((InputStream) this.f1911c, this.f1910b);
            default:
                return LottieCompositionFactory.fromJsonSync((JSONObject) this.f1911c, this.f1910b);
        }
    }

    public /* synthetic */ CallableC4323b(String str, String str2) {
        this.f1909a = 2;
        this.f1910b = str;
        this.f1911c = str2;
    }
}
