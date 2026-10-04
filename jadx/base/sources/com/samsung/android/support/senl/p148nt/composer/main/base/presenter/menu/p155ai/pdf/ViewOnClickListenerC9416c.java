package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.pdf;

import android.view.View;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class ViewOnClickListenerC9416c implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6853a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ TranslationLanguageSelector f6854b;

    public /* synthetic */ ViewOnClickListenerC9416c(TranslationLanguageSelector translationLanguageSelector, int i) {
        this.f6853a = i;
        this.f6854b = translationLanguageSelector;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f6853a) {
            case 0:
                this.f6854b.lambda$initFromLanguageView$1(view);
                break;
            case 1:
                this.f6854b.lambda$initCloseButton$4(view);
                break;
            case 2:
                this.f6854b.lambda$initToggleButton$3(view);
                break;
            default:
                this.f6854b.lambda$initToLanguageView$2(view);
                break;
        }
    }
}
