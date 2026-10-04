package com.samsung.android.sdk.pen.engine.drawLoop;

import com.samsung.android.support.senl.p148nt.app.lock.presenter.verify.VerifyPasswordPresenter;

/* JADX INFO: renamed from: com.samsung.android.sdk.pen.engine.drawLoop.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class RunnableC7449c implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4960a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ long f4961b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f4962c;

    public /* synthetic */ RunnableC7449c(int i, long j, Object obj) {
        this.f4960a = i;
        this.f4961b = j;
        this.f4962c = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4960a) {
            case 0:
                SpenDrawLoopHwBuffer.doFrame$lambda$0(this.f4961b, (SpenDrawLoopHwBuffer) this.f4962c);
                break;
            case 1:
                SpenDrawLoopTexture.doFrame$lambda$8(this.f4961b, (SpenDrawLoopTexture) this.f4962c);
                break;
            default:
                VerifyPasswordPresenter.C81091.onStart$lambda$0((VerifyPasswordPresenter) this.f4962c, this.f4961b);
                break;
        }
    }

    public /* synthetic */ RunnableC7449c(VerifyPasswordPresenter verifyPasswordPresenter, long j) {
        this.f4960a = 2;
        this.f4962c = verifyPasswordPresenter;
        this.f4961b = j;
    }
}
