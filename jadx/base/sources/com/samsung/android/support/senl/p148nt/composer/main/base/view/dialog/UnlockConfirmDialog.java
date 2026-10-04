package com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog;

import android.app.Activity;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class UnlockConfirmDialog extends Dialog {
    private static final String TAG = Logger.createTag("UnlockConfirmDialog");

    public UnlockConfirmDialog(final Activity activity, final DialogContract.IUnlockConfirmDialogPresenter iUnlockConfirmDialogPresenter) {
        Logger.m10999d(TAG, "UnlockConfirmDialog#");
        AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = new AlertDialogBuilderForAppCompat(activity);
        alertDialogBuilderForAppCompat.setTitle(activity.getResources().getString(C9086R.string.dialog_unlock_for_widget_title));
        alertDialogBuilderForAppCompat.setMessage(activity.getResources().getString(C9086R.string.dialog_unlock_for_widget));
        alertDialogBuilderForAppCompat.setPositiveButton(activity.getResources().getString(C9086R.string.dialog_remove_lock), new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.UnlockConfirmDialog.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                iUnlockConfirmDialogPresenter.unlock(activity);
                dialogInterface.dismiss();
            }
        });
        alertDialogBuilderForAppCompat.setNegativeButton(activity.getResources().getString(C9086R.string.dialog_unlock_cancel), new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.UnlockConfirmDialog.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialogCreate = alertDialogBuilderForAppCompat.create();
        this.mDialog = alertDialogCreate;
        alertDialogCreate.setCanceledOnTouchOutside(true);
        this.mDialog.setOnDismissListener(getDefaultDismissListener(iUnlockConfirmDialogPresenter));
    }
}
