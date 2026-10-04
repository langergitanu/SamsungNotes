package p054M1;

import android.content.DialogInterface;
import com.samsung.android.app.notes.widget.common.ConvertConfirmDialogActivity;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.dialog.BarProgressDialogFragment;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.dialog.CoeditSpaceEditMenuDialog;
import com.samsung.android.support.senl.p148nt.base.common.livesharing.LiveSharingManager;
import com.samsung.android.support.senl.p148nt.base.winset.app.dialog.VerifyPasswordDialogFragment;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.voice.VoiceNotificationHelper;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.view.dialog.AbsDialog;
import com.samsung.android.support.senl.p148nt.stt.view.dialog.AbsSTTDialog;

/* JADX INFO: renamed from: M1.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class DialogInterfaceOnShowListenerC0176c implements DialogInterface.OnShowListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f558a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f559b;

    public /* synthetic */ DialogInterfaceOnShowListenerC0176c(Object obj, int i) {
        this.f558a = i;
        this.f559b = obj;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        switch (this.f558a) {
            case 0:
                ConvertConfirmDialogActivity.ConvertConfirmsDialogFragment.onCreateDialog$lambda$3((ConvertConfirmDialogActivity.ConvertConfirmsDialogFragment) this.f559b, dialogInterface);
                break;
            case 1:
                AbsDialog.setWindowAttribute$lambda$0((AbsDialog) this.f559b, dialogInterface);
                break;
            case 2:
                BarProgressDialogFragment.onCreateDialog$lambda$0((BarProgressDialogFragment) this.f559b, dialogInterface);
                break;
            case 3:
                ((CoeditSpaceEditMenuDialog) this.f559b).lambda$new$0(dialogInterface);
                break;
            case 4:
                LiveSharingManager.createConfirmDialog$lambda$4$lambda$3((LiveSharingManager) this.f559b, dialogInterface);
                break;
            case 5:
                VerifyPasswordDialogFragment.initDialog$lambda$4((VerifyPasswordDialogFragment) this.f559b, dialogInterface);
                break;
            case 6:
                VoiceNotificationHelper.showRecordCancelDialogOnCover$lambda$4((VoiceNotificationHelper) this.f559b, dialogInterface);
                break;
            default:
                AbsSTTDialog.setWindowAttribute$lambda$0((AbsSTTDialog) this.f559b, dialogInterface);
                break;
        }
    }
}
