package com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog;

import android.content.DialogInterface;
import android.view.Window;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.p */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class DialogInterfaceOnShowListenerC10246p implements DialogInterface.OnShowListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7143a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ DialogFragment f7144b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f7145c;

    public /* synthetic */ DialogInterfaceOnShowListenerC10246p(DialogFragment dialogFragment, Object obj, int i) {
        this.f7143a = i;
        this.f7144b = dialogFragment;
        this.f7145c = obj;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        switch (this.f7143a) {
            case 0:
                ((SelectTranslateLanguageDialog) this.f7144b).lambda$onCreateDialog$3((Window) this.f7145c, dialogInterface);
                break;
            default:
                VoiceDataDeleteConfirmDialogFragment.onCreateDialog$lambda$3((VoiceDataDeleteConfirmDialogFragment) this.f7144b, (AlertDialog) this.f7145c, dialogInterface);
                break;
        }
    }
}
