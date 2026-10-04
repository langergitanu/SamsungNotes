package com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog;

import android.app.Activity;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
class CancelVoiceConfirmDialog extends Dialog {
    private static final String TAG = Logger.createTag("CancelVoiceConfirmDialog");

    public CancelVoiceConfirmDialog(Activity activity, final DialogContract.IVoiceDialogPresenter iVoiceDialogPresenter) {
        Logger.m10999d(TAG, "CancelVoiceConfirmDialog#");
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, C9086R.style.NoteAlertDialogThemeForAppCompat);
        builder.setMessage(activity.getResources().getString(C9086R.string.voice_alertdialog_message));
        builder.setPositiveButton(activity.getResources().getString(C9086R.string.string_save_full), new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.CancelVoiceConfirmDialog.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                iVoiceDialogPresenter.stopRecording();
                dialogInterface.dismiss();
                ComposerSA.insertLog(ComposerSAConstants.SCREEN_DIALOGS_DISCARD_VOICE_REC, ComposerSAConstants.EVENT_DIALOGS_DISCARD_VOICE_REC_SAVE);
            }
        });
        builder.setNegativeButton(activity.getResources().getString(C9086R.string.string_discard), new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.CancelVoiceConfirmDialog.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                iVoiceDialogPresenter.cancelRecording();
                dialogInterface.dismiss();
                ComposerSA.insertLog(ComposerSAConstants.SCREEN_DIALOGS_DISCARD_VOICE_REC, ComposerSAConstants.EVENT_DIALOGS_DISCARD_VOICE_REC_DISCARD);
            }
        });
        builder.setNeutralButton(activity.getResources().getString(C9086R.string.base_string_cancel_type1), new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.CancelVoiceConfirmDialog.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                ComposerSA.insertLog(ComposerSAConstants.SCREEN_DIALOGS_DISCARD_VOICE_REC, ComposerSAConstants.EVENT_DIALOGS_DISCARD_VOICE_REC_CANCEL);
            }
        });
        AlertDialog alertDialogCreate = builder.create();
        this.mDialog = alertDialogCreate;
        alertDialogCreate.setCanceledOnTouchOutside(true);
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.CancelVoiceConfirmDialog.4
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                iVoiceDialogPresenter.onDismiss();
                CancelVoiceConfirmDialog.this.mDialog = null;
            }
        });
    }
}
