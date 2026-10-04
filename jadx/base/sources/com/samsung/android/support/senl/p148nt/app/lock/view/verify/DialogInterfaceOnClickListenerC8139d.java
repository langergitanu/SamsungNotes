package com.samsung.android.support.senl.p148nt.app.lock.view.verify;

import android.content.DialogInterface;
import android.os.Handler;
import com.samsung.android.support.senl.p148nt.app.lock.view.base.AbsBaseView;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.lock.view.verify.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class DialogInterfaceOnClickListenerC8139d implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6135a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ AbsBaseView f6136b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Handler f6137c;

    public /* synthetic */ DialogInterfaceOnClickListenerC8139d(AbsBaseView absBaseView, Handler handler, int i) {
        this.f6135a = i;
        this.f6136b = absBaseView;
        this.f6137c = handler;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (this.f6135a) {
            case 0:
                ((VerifyIrisViewUnderQ) this.f6136b).lambda$showRetryDialog$1(this.f6137c, dialogInterface, i);
                break;
            case 1:
                ((VerifyIrisViewUnderQ) this.f6136b).lambda$showRetryDialog$2(this.f6137c, dialogInterface, i);
                break;
            default:
                ((VerifyIrisView) this.f6136b).lambda$showRetryDialog$3(this.f6137c, dialogInterface, i);
                break;
        }
    }
}
