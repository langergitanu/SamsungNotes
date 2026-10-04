package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.helper;

import android.app.Activity;
import android.content.Context;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.helper.DialogHelper;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.main.noteslist.presenter.helper.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class RunnableC8496b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6197a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f6198b;

    public /* synthetic */ RunnableC8496b(Object obj, int i) {
        this.f6197a = i;
        this.f6198b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6197a) {
            case 0:
                DialogHelper.C843311.AnonymousClass1.lambda$onEnded$0((Activity) this.f6198b);
                break;
            case 1:
                DialogHelper.C845027.lambda$onFailed$0((Context) this.f6198b);
                break;
            case 2:
                ((DetailsMenuHelper) this.f6198b).lambda$dismissDetailsDialog$0();
                break;
            case 3:
                ((DialogHelper) this.f6198b).lambda$showExportPdfDialog$1();
                break;
            default:
                ((LockHelper) this.f6198b).lambda$isPermissionGranted$0();
                break;
        }
    }
}
