package com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog;

import android.content.Context;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
class CanNotUseSpenDialog extends Dialog {
    public CanNotUseSpenDialog(Context context, final DialogContract.ICanNotUseSpenDialogPresenter iCanNotUseSpenDialogPresenter) {
        AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = new AlertDialogBuilderForAppCompat(context);
        alertDialogBuilderForAppCompat.setMessage(context.getResources().getString(C9086R.string.can_not_use_spen_cover_screen_dialog_text));
        alertDialogBuilderForAppCompat.setPositiveButton(context.getResources().getString(C9086R.string.f6715OK), new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.CanNotUseSpenDialog.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                iCanNotUseSpenDialogPresenter.onClicked();
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialogCreate = alertDialogBuilderForAppCompat.create();
        this.mDialog = alertDialogCreate;
        alertDialogCreate.setCanceledOnTouchOutside(true);
        this.mDialog.setOnDismissListener(getDefaultDismissListener(iCanNotUseSpenDialogPresenter));
    }
}
