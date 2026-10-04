package com.airbnb.lottie;

import com.airbnb.lottie.utils.Utils;
import java.util.zip.ZipInputStream;

/* JADX INFO: renamed from: com.airbnb.lottie.h */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class RunnableC4329h implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1924a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ZipInputStream f1925b;

    public /* synthetic */ RunnableC4329h(ZipInputStream zipInputStream, int i) {
        this.f1924a = i;
        this.f1925b = zipInputStream;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1924a) {
            case 0:
                Utils.closeQuietly(this.f1925b);
                break;
            default:
                Utils.closeQuietly(this.f1925b);
                break;
        }
    }
}
