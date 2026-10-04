package com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog;

import android.app.Activity;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
class RemoveItemConfirmDialog extends Dialog {
    private static final String TAG = Logger.createTag("RemoveItemConfirmDialog");

    public RemoveItemConfirmDialog(Activity activity, final DialogContract.IVoiceDialogPresenter iVoiceDialogPresenter, final SpenWPage spenWPage, final SpenObjectBase spenObjectBase) {
        Logger.m10999d(TAG, "RemoveItemConfirmDialog#");
        AlertDialog.Builder builder = new AlertDialog.Builder(activity, C9086R.style.NoteAlertDialogThemeForAppCompat);
        builder.setMessage(activity.getResources().getString(C9086R.string.dialog_selected_item));
        builder.setPositiveButton(activity.getResources().getString(C9086R.string.dialog_delete), new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.RemoveItemConfirmDialog.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                iVoiceDialogPresenter.removeItem(spenWPage, spenObjectBase);
                dialogInterface.dismiss();
            }
        });
        builder.setNeutralButton(activity.getResources().getString(C9086R.string.dialog_cancel), new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.RemoveItemConfirmDialog.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialogCreate = builder.create();
        this.mDialog = alertDialogCreate;
        alertDialogCreate.setCanceledOnTouchOutside(true);
        this.mDialog.setOnDismissListener(getDefaultDismissListener(iVoiceDialogPresenter));
    }
}
