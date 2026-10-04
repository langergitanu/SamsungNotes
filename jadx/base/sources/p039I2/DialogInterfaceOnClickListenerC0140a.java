package p039I2;

import android.content.DialogInterface;
import com.samsung.android.support.senl.docscan.common.Logger;
import com.samsung.android.support.senl.docscan.dialog.CameraInUseDialog;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.view.dialog.SortByDialogFragment;
import com.samsung.android.support.senl.p148nt.app.settings.common.dialog.GDPRDialogFragment;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.dialog.AiDisclaimerDialog;
import com.samsung.android.support.senl.p148nt.base.winset.app.dialog.GoToSettingsDialog;
import com.samsung.android.support.senl.p148nt.base.winset.app.dialog.VerifyPasswordDialogFragment;
import com.samsung.android.support.senl.p148nt.base.winset.util.DialogUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.voice.VoiceNotificationHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.RemoveRecordingConfirmDialog;

/* JADX INFO: renamed from: I2.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class DialogInterfaceOnClickListenerC0140a implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f393a;

    public /* synthetic */ DialogInterfaceOnClickListenerC0140a(int i) {
        this.f393a = i;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        switch (this.f393a) {
            case 0:
                Logger.m7145d(CameraInUseDialog.TAG, "onPositiveButtonClicked# ");
                break;
            case 1:
                dialogInterface.dismiss();
                break;
            case 2:
                GDPRDialogFragment.onCreateDialog$lambda$0(dialogInterface, i);
                break;
            case 3:
                dialogInterface.dismiss();
                break;
            case 4:
                SortByDialogFragment.onCreateDialog$lambda$0(dialogInterface, i);
                break;
            case 5:
                dialogInterface.dismiss();
                break;
            case 6:
                dialogInterface.dismiss();
                break;
            case 7:
                dialogInterface.dismiss();
                break;
            case 8:
                AiDisclaimerDialog.getDialog$lambda$0(dialogInterface, i);
                break;
            case 9:
                dialogInterface.dismiss();
                break;
            case 10:
                dialogInterface.dismiss();
                break;
            case 11:
                GoToSettingsDialog.onCreateDialog$lambda$0(dialogInterface, i);
                break;
            case 12:
                GoToSettingsDialog.onCreateDialog$lambda$1(dialogInterface, i);
                break;
            case 13:
                VerifyPasswordDialogFragment.initDialog$lambda$2(dialogInterface, i);
                break;
            case 14:
                dialogInterface.cancel();
                break;
            case 15:
                dialogInterface.dismiss();
                break;
            case 16:
                VoiceNotificationHelper.showCancelDialog$lambda$1(dialogInterface, i);
                break;
            case 17:
                VoiceNotificationHelper.showCancelDialog$lambda$2(dialogInterface, i);
                break;
            case 18:
                ComposerSA.insertLog(ComposerSAConstants.SCREEN_DIALOGS_TEXT_RECOGNITION, ComposerSAConstants.EVENT_DIALOGS_TEXT_RECOGNITION_CANCEL);
                break;
            case 19:
                dialogInterface.dismiss();
                break;
            case 20:
                RemoveRecordingConfirmDialog._init_$lambda$2(dialogInterface, i);
                break;
            case 21:
                dialogInterface.dismiss();
                break;
            case 22:
                dialogInterface.dismiss();
                break;
            case 23:
                dialogInterface.dismiss();
                break;
            case 24:
                dialogInterface.dismiss();
                break;
            case 25:
                dialogInterface.dismiss();
                break;
            case 26:
                DialogUtils.showWidgetNoteWarning$lambda$2(dialogInterface, i);
                break;
            default:
                DialogUtils.showOverSizeItemsDialog$lambda$0(dialogInterface, i);
                break;
        }
    }
}
