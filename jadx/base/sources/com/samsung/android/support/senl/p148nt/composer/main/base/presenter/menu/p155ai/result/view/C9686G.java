package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

import android.app.Activity;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.SimpleEditView;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.SubTranslationViewManager;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.G */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C9686G implements SimpleEditView.ScrollBarListener, SimpleEditView.OnScrollListener, SubTranslationViewManager.Contract {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ AiMenuResultViewSummarization f6922a;

    public /* synthetic */ C9686G(AiMenuResultViewSummarization aiMenuResultViewSummarization) {
        this.f6922a = aiMenuResultViewSummarization;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.SubTranslationViewManager.Contract
    public Activity getActivity() {
        return this.f6922a.lambda$toggleTranslate$5();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.SimpleEditView.OnScrollListener
    public void onScrolling() {
        this.f6922a.lambda$initView$1();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.SimpleEditView.ScrollBarListener
    public void onWorking(boolean z) {
        this.f6922a.lambda$initView$0(z);
    }
}
