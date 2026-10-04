package com.samsung.android.support.senl.p148nt.base.common.p151ai.dialog;

import android.content.DialogInterface;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.base.common.ai.dialog.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class DialogInterfaceOnDismissListenerC8880a implements DialogInterface.OnDismissListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6426a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ AiDisclaimerDialog f6427b;

    public /* synthetic */ DialogInterfaceOnDismissListenerC8880a(AiDisclaimerDialog aiDisclaimerDialog, int i) {
        this.f6426a = i;
        this.f6427b = aiDisclaimerDialog;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        switch (this.f6426a) {
            case 0:
                this.f6427b.mAlertDialog = null;
                break;
            default:
                this.f6427b.mAlertDialog = null;
                break;
        }
    }
}
