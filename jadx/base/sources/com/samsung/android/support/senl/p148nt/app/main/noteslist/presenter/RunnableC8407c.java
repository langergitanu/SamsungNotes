package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter;

import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.DataMapper;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC8407c implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6186a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ DataMapper.C83761 f6187b;

    public /* synthetic */ RunnableC8407c(DataMapper.C83761 c83761, int i) {
        this.f6186a = i;
        this.f6187b = c83761;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6186a) {
            case 0:
                this.f6187b.lambda$onProgress$1();
                break;
            case 1:
                this.f6187b.lambda$onStart$0();
                break;
            default:
                this.f6187b.lambda$onEnd$2();
                break;
        }
    }
}
