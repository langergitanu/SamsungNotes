package com.samsung.android.support.senl.p148nt.app.lock.presenter.verify;

import com.samsung.android.support.senl.p148nt.app.lock.presenter.verify.VerifyPasswordPresenter;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.lock.presenter.verify.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC8110a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6118a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ VerifyPasswordPresenter f6119b;

    public /* synthetic */ RunnableC8110a(VerifyPasswordPresenter verifyPasswordPresenter, int i) {
        this.f6118a = i;
        this.f6119b = verifyPasswordPresenter;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6118a) {
            case 0:
                VerifyPasswordPresenter.onVerifySucceeded$lambda$0(this.f6119b);
                break;
            case 1:
                VerifyPasswordPresenter.onVerifyFailed$lambda$1(this.f6119b);
                break;
            default:
                VerifyPasswordPresenter.C81091.onEnd$lambda$2(this.f6119b);
                break;
        }
    }
}
