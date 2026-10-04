package com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import androidx.appcompat.app.AlertDialog;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
class AutoRestoredNoteNotiDialog extends Dialog {
    public AutoRestoredNoteNotiDialog(Context context, DialogContract.IPresenter iPresenter) {
        Logger.m10999d("TextBoxMoreDialog", "TextBoxMoreDialog");
        if (LayoutInflater.from(context) == null) {
            return;
        }
        AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = new AlertDialogBuilderForAppCompat(context);
        alertDialogBuilderForAppCompat.setPositiveButton(context.getResources().getString(C9086R.string.f6715OK), new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.AutoRestoredNoteNotiDialog.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        alertDialogBuilderForAppCompat.setTitle(C9086R.string.composer_corrupt_restored_dialog_title);
        alertDialogBuilderForAppCompat.setMessage(context.getResources().getString(C9086R.string.composer_corrupt_restored_dialog_body));
        AlertDialog alertDialogCreate = alertDialogBuilderForAppCompat.create();
        this.mDialog = alertDialogCreate;
        alertDialogCreate.setOnDismissListener(getDefaultDismissListener(iPresenter));
    }
}
