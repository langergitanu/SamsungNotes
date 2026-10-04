package com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog;

import android.content.DialogInterface;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.l */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class DialogInterfaceOnShowListenerC10242l implements DialogInterface.OnShowListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7134a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f7135b;

    public /* synthetic */ DialogInterfaceOnShowListenerC10242l(Object obj, int i) {
        this.f7134a = i;
        this.f7135b = obj;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        switch (this.f7134a) {
            case 0:
                ((PageToApplySingleModeDialog) this.f7135b).lambda$show$0(dialogInterface);
                break;
            case 1:
                ((PageToApplyTwoPageModeDialog) this.f7135b).lambda$show$0(dialogInterface);
                break;
            default:
                ((TemplateNameDialog) this.f7135b).lambda$show$0(dialogInterface);
                break;
        }
    }
}
