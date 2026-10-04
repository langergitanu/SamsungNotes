package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.template.view.presenter;

import java.util.List;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.menu.template.view.presenter.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC10464a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7195a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f7196b;

    public /* synthetic */ RunnableC10464a(Object obj, int i) {
        this.f7195a = i;
        this.f7196b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7195a) {
            case 0:
                AddedItemPresenter.lambda$deleteTemplateRepository$1((List) this.f7196b);
                break;
            default:
                ((TaskDownloadPdfTemplate) this.f7196b).lambda$showProgressDialog$1();
                break;
        }
    }
}
