package com.samsung.android.support.senl.p148nt.stt.view.dialog;

import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import java.util.Map;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.stt.view.dialog.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final /* synthetic */ class DialogInterfaceOnShowListenerC11557c implements DialogInterface.OnShowListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7928a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ DialogFragment f7929b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f7930c;

    public /* synthetic */ DialogInterfaceOnShowListenerC11557c(DialogFragment dialogFragment, Object obj, int i) {
        this.f7928a = i;
        this.f7929b = dialogFragment;
        this.f7930c = obj;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        switch (this.f7928a) {
            case 0:
                RemoveTranscriptConfirmDialog.onCreateDialog$lambda$3((RemoveTranscriptConfirmDialog) this.f7929b, (AlertDialog) this.f7930c, dialogInterface);
                break;
            default:
                SpeakerRenameDialog.onCreateDialog$lambda$5((SpeakerRenameDialog) this.f7929b, (Map) this.f7930c, dialogInterface);
                break;
        }
    }
}
