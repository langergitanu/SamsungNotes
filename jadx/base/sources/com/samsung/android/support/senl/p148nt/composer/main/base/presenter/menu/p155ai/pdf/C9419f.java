package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.pdf;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.pdf.TranslationLanguageModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.pdf.TranslationNotificationHelper;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C9419f implements TranslationLanguageModel.LanguageTagListener, TranslationNotificationHelper.CancelListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Object f6857a;

    public /* synthetic */ C9419f(Object obj) {
        this.f6857a = obj;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslationNotificationHelper.CancelListener
    public void onCancel() {
        ((TranslationService) this.f6857a).cancel();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslationLanguageModel.LanguageTagListener
    public void onToLanguageChanged() {
        ((TranslationLanguageSelector) this.f6857a).updateLanguage();
    }
}
