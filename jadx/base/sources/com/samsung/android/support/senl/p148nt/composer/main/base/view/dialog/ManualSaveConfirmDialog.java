package com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog;

import android.content.Context;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ManualSaveConfirmDialog extends Dialog {
    private static final String TAG = Logger.createTag("ManualSaveConfirmDialog");

    public ManualSaveConfirmDialog(Context context, final DialogContract.IManualSaveConfirmDialogPresenter iManualSaveConfirmDialogPresenter) {
        AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = new AlertDialogBuilderForAppCompat(context);
        alertDialogBuilderForAppCompat.setPositiveButton(C9086R.string.composer_share_save_note, new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.ManualSaveConfirmDialog.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Logger.m10999d(ManualSaveConfirmDialog.TAG, "onPositiveButtonClick");
                iManualSaveConfirmDialogPresenter.onPositiveButtonClick();
                dialogInterface.dismiss();
            }
        });
        alertDialogBuilderForAppCompat.setNegativeButton(C9086R.string.base_string_cancel_type1, new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.ManualSaveConfirmDialog.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Logger.m10999d(ManualSaveConfirmDialog.TAG, "onNegativeButtonClick");
                dialogInterface.dismiss();
            }
        });
        alertDialogBuilderForAppCompat.setMessage(iManualSaveConfirmDialogPresenter.getMessageId());
        AlertDialog alertDialogCreate = alertDialogBuilderForAppCompat.create();
        this.mDialog = alertDialogCreate;
        alertDialogCreate.setOnDismissListener(getDefaultDismissListener(iManualSaveConfirmDialogPresenter));
    }
}
