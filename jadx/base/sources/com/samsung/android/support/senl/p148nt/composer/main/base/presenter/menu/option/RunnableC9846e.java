package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC9846e implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7017a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f7018b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f7019c;

    public /* synthetic */ RunnableC9846e(Object obj, int i, int i2) {
        this.f7017a = i2;
        this.f7019c = obj;
        this.f7018b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7017a) {
            case 0:
                ((OptionMenuPresenter.C98231) this.f7019c).lambda$onSuccess$0(this.f7018b);
                break;
            default:
                ((OptionMenuPageSettingPresenter) this.f7019c).lambda$setBackgroundColor$0(this.f7018b);
                break;
        }
    }
}
