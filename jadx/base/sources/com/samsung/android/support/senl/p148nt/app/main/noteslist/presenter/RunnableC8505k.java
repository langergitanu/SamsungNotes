package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter;

import android.app.Activity;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.NotesPresenter;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.k */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC8505k implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6223a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Activity f6224b;

    public /* synthetic */ RunnableC8505k(Activity activity, int i) {
        this.f6223a = i;
        this.f6224b = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6223a) {
            case 0:
                NotesPresenter.C83876.lambda$onEnd$0(this.f6224b);
                break;
            default:
                NotesPresenter.lambda$playConvertFinishedToast$6(this.f6224b);
                break;
        }
    }
}
