package com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog;

import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Dialog implements DialogContract.IDialog {
    protected AlertDialog mDialog;

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IDialog
    public void dismiss() {
        AlertDialog alertDialog = this.mDialog;
        if (alertDialog == null || !alertDialog.isShowing()) {
            return;
        }
        this.mDialog.dismiss();
    }

    public DialogInterface.OnDismissListener getDefaultDismissListener(final DialogContract.IPresenter iPresenter) {
        return new DialogInterface.OnDismissListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.Dialog.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                iPresenter.onDismiss();
                Dialog.this.mDialog = null;
            }
        };
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IDialog
    public boolean isShowing() {
        AlertDialog alertDialog = this.mDialog;
        return alertDialog != null && alertDialog.isShowing();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IDialog
    public void show() {
        if (this.mDialog.getWindow() != null) {
            this.mDialog.getWindow().setGravity(80);
        }
        this.mDialog.show();
    }
}
