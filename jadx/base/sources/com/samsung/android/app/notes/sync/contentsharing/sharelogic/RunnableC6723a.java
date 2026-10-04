package com.samsung.android.app.notes.sync.contentsharing.sharelogic;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.contentsharing.sharelogic.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class RunnableC6723a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4065a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ BaseLogic$BaseLogicHandler$2 f4066b;

    public RunnableC6723a(BaseLogic$BaseLogicHandler$2 baseLogic$BaseLogicHandler$2, int i) {
        this.f4066b = baseLogic$BaseLogicHandler$2;
        this.f4065a = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f4066b.this$0.m4816b(this.f4065a);
    }
}
