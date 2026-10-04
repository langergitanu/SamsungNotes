package com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog;

import android.content.DialogInterface;
import androidx.fragment.app.DialogFragment;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class DialogInterfaceOnClickListenerC10231a implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7112a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ DialogFragment f7113b;

    public /* synthetic */ DialogInterfaceOnClickListenerC10231a(DialogFragment dialogFragment, int i) {
        this.f7112a = i;
        this.f7113b = dialogFragment;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (this.f7112a) {
            case 0:
                ((CanNotAddToNoteDialogFragment) this.f7113b).lambda$onCreateDialog$0(dialogInterface, i);
                break;
            case 1:
                ((DirectWriteSettingDialogFragment) this.f7113b).lambda$createAlertDialog$2(dialogInterface, i);
                break;
            case 2:
                ((HwBeautifierLanguageDialogFragment) this.f7113b).lambda$createAlertDialog$0(dialogInterface, i);
                break;
            case 3:
                NoteStyleConfirmDialogFragment.onCreateDialog$lambda$0((NoteStyleConfirmDialogFragment) this.f7113b, dialogInterface, i);
                break;
            case 4:
                ((TableDialogFragment) this.f7113b).lambda$onCreateDialog$1(dialogInterface, i);
                break;
            case 5:
                ((TranslatedPDFBlockingDialogFragment) this.f7113b).lambda$onCreateDialog$0(dialogInterface, i);
                break;
            case 6:
                ((TranslatedPDFGuideDialogFragment) this.f7113b).lambda$onCreateDialog$0(dialogInterface, i);
                break;
            case 7:
                ((UnavailableContentDialogFragment) this.f7113b).lambda$onCreateDialog$0(dialogInterface, i);
                break;
            default:
                VoiceDataDeleteConfirmDialogFragment.onCreateDialog$lambda$0((VoiceDataDeleteConfirmDialogFragment) this.f7113b, dialogInterface, i);
                break;
        }
    }
}
