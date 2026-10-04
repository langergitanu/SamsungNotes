package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC9270a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6797a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ AiMenuManager f6798b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ String f6799c;

    public /* synthetic */ RunnableC9270a(AiMenuManager aiMenuManager, String str, int i) {
        this.f6797a = i;
        this.f6798b = aiMenuManager;
        this.f6799c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6797a) {
            case 0:
                this.f6798b.lambda$makeCoverForBixby$3(this.f6799c);
                break;
            default:
                this.f6798b.lambda$makeCoverForBixby$4(this.f6799c);
                break;
        }
    }
}
