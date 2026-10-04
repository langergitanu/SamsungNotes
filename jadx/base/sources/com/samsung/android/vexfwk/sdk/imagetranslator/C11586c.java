package com.samsung.android.vexfwk.sdk.imagetranslator;

import java.util.function.Supplier;

/* JADX INFO: renamed from: com.samsung.android.vexfwk.sdk.imagetranslator.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11586c implements Supplier {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8112a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ VexFwkImageTranslator f8113b;

    public /* synthetic */ C11586c(VexFwkImageTranslator vexFwkImageTranslator, int i) {
        this.f8112a = i;
        this.f8113b = vexFwkImageTranslator;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f8112a) {
            case 0:
                return VexFwkImageTranslator.getAvailableLanguages$lambda$38(this.f8113b);
            default:
                return VexFwkImageTranslator.showInstallPopupAsync$lambda$14(this.f8113b);
        }
    }
}
