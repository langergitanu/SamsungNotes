package com.samsung.android.app.notes.sync.coedit.sharelogic;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.coedit.sharelogic.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class RunnableC6676a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3960a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ CoeditBaseLogic$CoeditBaseLogicHandler$2 f3961b;

    public RunnableC6676a(CoeditBaseLogic$CoeditBaseLogicHandler$2 coeditBaseLogic$CoeditBaseLogicHandler$2, int i) {
        this.f3961b = coeditBaseLogic$CoeditBaseLogicHandler$2;
        this.f3960a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3961b.this$0.m4772b(this.f3960a);
    }
}
