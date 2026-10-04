package com.airbnb.lottie;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.utils.Utils;
import java.io.InputStream;
import okio.Source;

/* JADX INFO: renamed from: com.airbnb.lottie.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class RunnableC4326e implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1914a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f1915b;

    public /* synthetic */ RunnableC4326e(Object obj, int i) {
        this.f1914a = i;
        this.f1915b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1914a) {
            case 0:
                Utils.closeQuietly((JsonReader) this.f1915b);
                break;
            case 1:
                Utils.closeQuietly((Source) this.f1915b);
                break;
            case 2:
                Utils.closeQuietly((InputStream) this.f1915b);
                break;
            default:
                ((LottieTask) this.f1915b).notifyListenersInternal();
                break;
        }
    }
}
