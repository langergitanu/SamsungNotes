package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.option.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC9845d implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7015a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f7016b;

    public /* synthetic */ RunnableC9845d(Object obj, int i) {
        this.f7015a = i;
        this.f7016b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7015a) {
            case 0:
                ((OptionMenuPresenter.C98231) this.f7016b).lambda$onFail$1();
                break;
            case 1:
                ((OptionMenuPresenter.C98264) this.f7016b).lambda$openNoteAfterAddToNoteWithTranslation$0();
                break;
            case 2:
                ((OptionMenuNotesAssistPresenter) this.f7016b).lambda$translate$0();
                break;
            default:
                ((OptionMenuPresenter) this.f7016b).lambda$onClickDone$0();
                break;
        }
    }
}
