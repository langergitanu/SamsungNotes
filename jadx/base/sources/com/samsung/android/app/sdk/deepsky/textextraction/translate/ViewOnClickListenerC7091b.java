package com.samsung.android.app.sdk.deepsky.textextraction.translate;

import android.view.View;
import android.widget.LinearLayout;

/* JADX INFO: renamed from: com.samsung.android.app.sdk.deepsky.textextraction.translate.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class ViewOnClickListenerC7091b implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4769a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ TranslateLanguageHelperImpl f4770b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ LinearLayout f4771c;

    public /* synthetic */ ViewOnClickListenerC7091b(TranslateLanguageHelperImpl translateLanguageHelperImpl, LinearLayout linearLayout, int i) {
        this.f4769a = i;
        this.f4770b = translateLanguageHelperImpl;
        this.f4771c = linearLayout;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f4769a) {
            case 0:
                TranslateLanguageHelperImpl.initTargetLangChangeLayout$lambda$15$lambda$14(this.f4770b, this.f4771c, view);
                break;
            default:
                TranslateLanguageHelperImpl.initSourceLangChangeLayout$lambda$12$lambda$11(this.f4770b, this.f4771c, view);
                break;
        }
    }
}
