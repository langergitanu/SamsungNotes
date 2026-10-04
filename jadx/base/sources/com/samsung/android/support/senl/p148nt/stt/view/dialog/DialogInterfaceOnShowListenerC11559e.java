package com.samsung.android.support.senl.p148nt.stt.view.dialog;

import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.stt.view.dialog.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final /* synthetic */ class DialogInterfaceOnShowListenerC11559e implements DialogInterface.OnShowListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7933a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ AlertDialog f7934b;

    public /* synthetic */ DialogInterfaceOnShowListenerC11559e(AlertDialog alertDialog, int i) {
        this.f7933a = i;
        this.f7934b = alertDialog;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        switch (this.f7933a) {
            case 0:
                STTSelectTranscribeDialogFragment.createAlertDialog$lambda$2(this.f7934b, dialogInterface);
                break;
            default:
                STTSettingLanguageDialogFragment.createAlertDialog$lambda$3(this.f7934b, dialogInterface);
                break;
        }
    }
}
