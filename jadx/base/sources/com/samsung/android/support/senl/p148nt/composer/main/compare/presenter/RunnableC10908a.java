package com.samsung.android.support.senl.p148nt.composer.main.compare.presenter;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.compare.presenter.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC10908a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7330a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ CompareMainPresenter f7331b;

    public /* synthetic */ RunnableC10908a(CompareMainPresenter compareMainPresenter, int i) {
        this.f7330a = i;
        this.f7331b = compareMainPresenter;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7330a) {
            case 0:
                CompareMainPresenter.onMergeDone$lambda$2(this.f7331b);
                break;
            default:
                CompareMainPresenter.onConflictCheckDone$lambda$1(this.f7331b);
                break;
        }
    }
}
