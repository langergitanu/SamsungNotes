package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.view.SimpleEditView;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.K */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C9690K implements SimpleEditView.ScrollBarListener, SimpleEditView.OnScrollListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ AutoFormatResultView f6928a;

    public /* synthetic */ C9690K(AutoFormatResultView autoFormatResultView) {
        this.f6928a = autoFormatResultView;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.SimpleEditView.OnScrollListener
    public void onScrolling() {
        this.f6928a.lambda$initView$1();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.view.SimpleEditView.ScrollBarListener
    public void onWorking(boolean z) {
        this.f6928a.lambda$initView$0(z);
    }
}
