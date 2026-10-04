package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.Translation;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.SimpleEditView;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.H */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C9687H implements SimpleEditView.ScrollBarListener, SimpleEditView.OnScrollListener, Translation.LanguageIdentifyCallback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ AiMenuResultViewTranslation f6923a;

    public /* synthetic */ C9687H(AiMenuResultViewTranslation aiMenuResultViewTranslation) {
        this.f6923a = aiMenuResultViewTranslation;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.Translation.LanguageIdentifyCallback
    public void onComplete() {
        this.f6923a.lambda$initLanguage$4();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.SimpleEditView.OnScrollListener
    public void onScrolling() {
        this.f6923a.lambda$initView$2();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.SimpleEditView.ScrollBarListener
    public void onWorking(boolean z) {
        this.f6923a.lambda$initView$1(z);
    }
}
