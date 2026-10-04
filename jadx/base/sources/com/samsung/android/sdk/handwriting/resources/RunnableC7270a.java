package com.samsung.android.sdk.handwriting.resources;

import com.samsung.android.sdk.handwriting.resources.HwrLanguagePack;

/* JADX INFO: renamed from: com.samsung.android.sdk.handwriting.resources.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class RunnableC7270a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4870a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f4871b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f4872c;

    public /* synthetic */ RunnableC7270a(int i, Object obj, int i2) {
        this.f4870a = i2;
        this.f4871b = i;
        this.f4872c = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4870a) {
            case 0:
                HwrLanguagePack.lambda$returnLanguagePackDownloadListener$1(this.f4871b, (HwrLanguagePack.LanguagePackDownloadListener) this.f4872c);
                break;
            default:
                HwrLanguagePack.lambda$returnOnDownloadListener$0(this.f4871b, (HwrLanguagePack.OnDownloadListener) this.f4872c);
                break;
        }
    }
}
