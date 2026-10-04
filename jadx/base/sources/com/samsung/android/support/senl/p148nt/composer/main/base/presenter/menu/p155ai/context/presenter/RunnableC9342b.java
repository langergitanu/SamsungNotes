package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.presenter;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC9342b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6807a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ AiContextMenuPresenter f6808b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ int f6809c;

    public /* synthetic */ RunnableC9342b(AiContextMenuPresenter aiContextMenuPresenter, int i, int i2) {
        this.f6807a = i2;
        this.f6808b = aiContextMenuPresenter;
        this.f6809c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6807a) {
            case 0:
                this.f6808b.lambda$doDirectAction$5(this.f6809c);
                break;
            default:
                this.f6808b.lambda$startAiAssist$2(this.f6809c);
                break;
        }
    }
}
