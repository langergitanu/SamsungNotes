package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.view;

import android.view.View;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.view.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class ViewOnClickListenerC9368a implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6828a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ AiMenuPopup f6829b;

    public /* synthetic */ ViewOnClickListenerC9368a(AiMenuPopup aiMenuPopup, int i) {
        this.f6828a = i;
        this.f6829b = aiMenuPopup;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f6828a) {
            case 0:
                this.f6829b.onTranslateClick(view);
                break;
            case 1:
                this.f6829b.onSummarizeClick(view);
                break;
            case 2:
                this.f6829b.onSpellingCorrectionClick(view);
                break;
            case 3:
                this.f6829b.lambda$setupAutoFormat$0(view);
                break;
            case 4:
                this.f6829b.onTranscribeClick(view);
                break;
            default:
                this.f6829b.onCreateImageClick(view);
                break;
        }
    }
}
