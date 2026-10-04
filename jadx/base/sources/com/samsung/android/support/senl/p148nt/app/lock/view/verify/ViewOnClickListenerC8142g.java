package com.samsung.android.support.senl.p148nt.app.lock.view.verify;

import android.view.View;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.app.lock.view.verify.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ViewOnClickListenerC8142g implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6143a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ VerifyMultiBioView f6144b;

    public /* synthetic */ ViewOnClickListenerC8142g(VerifyMultiBioView verifyMultiBioView, int i) {
        this.f6143a = i;
        this.f6144b = verifyMultiBioView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f6143a) {
            case 0:
                this.f6144b.lambda$createDexView$0(view);
                break;
            default:
                this.f6144b.lambda$createDefaultView$1(view);
                break;
        }
    }
}
