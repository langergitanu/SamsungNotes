package com.samsung.android.support.senl.p148nt.app.lock.view.verify;

import android.app.Activity;
import android.content.Context;
import com.samsung.android.support.senl.p148nt.app.lock.view.verify.VerifyFingerprintView;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.lock.view.verify.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC8136a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6126a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f6127b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Context f6128c;

    public /* synthetic */ RunnableC8136a(Context context, int i, Object obj) {
        this.f6126a = i;
        this.f6127b = obj;
        this.f6128c = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6126a) {
            case 0:
                ((VerifyFingerprintView.C81281) this.f6127b).lambda$onActivityPostResumed$0((Activity) this.f6128c);
                break;
            default:
                ((VerifyIrisView) this.f6127b).lambda$showRetryDialog$1(this.f6128c);
                break;
        }
    }
}
