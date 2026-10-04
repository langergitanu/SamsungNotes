package com.samsung.android.vexfwk.sdk.imagetranslator;

import java.util.function.Supplier;

/* JADX INFO: renamed from: com.samsung.android.vexfwk.sdk.imagetranslator.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class C11585b implements Supplier {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f8109a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ String f8110b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ VexFwkImageTranslator f8111c;

    public /* synthetic */ C11585b(String str, VexFwkImageTranslator vexFwkImageTranslator, int i) {
        this.f8109a = i;
        this.f8110b = str;
        this.f8111c = vexFwkImageTranslator;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f8109a) {
            case 0:
                return VexFwkImageTranslator.getAvailableTargetLanguageFrom$lambda$23(this.f8110b, this.f8111c);
            default:
                return VexFwkImageTranslator.getAvailableSourceLanguageTo$lambda$31(this.f8110b, this.f8111c);
        }
    }
}
