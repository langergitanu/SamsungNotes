package com.samsung.android.app.sdk.deepsky.textextraction.translate;

import android.view.View;

/* JADX INFO: renamed from: com.samsung.android.app.sdk.deepsky.textextraction.translate.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class ViewOnClickListenerC7090a implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4767a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ TranslateLanguageHelperImpl f4768b;

    public /* synthetic */ ViewOnClickListenerC7090a(TranslateLanguageHelperImpl translateLanguageHelperImpl, int i) {
        this.f4767a = i;
        this.f4768b = translateLanguageHelperImpl;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f4767a) {
            case 0:
                TranslateLanguageHelperImpl.initLangChangeLayout$lambda$7$lambda$6(this.f4768b, view);
                break;
            case 1:
                TranslateLanguageHelperImpl.initLangChangeLayout$lambda$9$lambda$8(this.f4768b, view);
                break;
            default:
                TranslateLanguageHelperImpl.initLangCodeButton$lambda$3$lambda$0(this.f4768b, view);
                break;
        }
    }
}
