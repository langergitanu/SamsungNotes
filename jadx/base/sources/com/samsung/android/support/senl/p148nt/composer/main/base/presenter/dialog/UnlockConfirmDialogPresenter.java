package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog;

import android.app.Activity;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class UnlockConfirmDialogPresenter implements DialogContract.IUnlockConfirmDialogPresenter {
    private static final String TAG = "UnlockConfirmDialogPresenter";
    private Activity mActivity;
    private DialogContract.IDialog mDialog;
    private DialogContract.IDialogCreator mDialogCreator;
    private Runnable mRunnable;

    public UnlockConfirmDialogPresenter(DialogContract.IDialogCreator iDialogCreator) {
        this.mDialogCreator = iDialogCreator;
    }

    private boolean isAvailableToShow() {
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing() || this.mActivity.isDestroyed()) {
            Logger.m10999d(TAG, "isAvailableToShow# " + this.mActivity);
            return false;
        }
        DialogContract.IDialog iDialog = this.mDialog;
        if (iDialog == null || !iDialog.isShowing()) {
            return true;
        }
        Logger.m10999d(TAG, "isAvailableToShow# dialog is showing");
        return false;
    }

    public void hide() {
        DialogContract.IDialog iDialog = this.mDialog;
        if (iDialog != null) {
            iDialog.dismiss();
        }
    }

    public boolean isShowing() {
        DialogContract.IDialog iDialog = this.mDialog;
        return iDialog != null && iDialog.isShowing();
    }

    public void onAttachView(Activity activity) {
        this.mActivity = activity;
    }

    public void onDetachView() {
        onDismiss();
        this.mRunnable = null;
        this.mActivity = null;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IPresenter
    public void onDismiss() {
        DialogContract.IDialog iDialog = this.mDialog;
        if (iDialog != null && iDialog.isShowing()) {
            this.mDialog.dismiss();
        }
        this.mDialog = null;
    }

    public void show(Runnable runnable) {
        if (isAvailableToShow()) {
            DialogContract.IDialog iDialogCreateUnlockConfirmDialog = this.mDialogCreator.createUnlockConfirmDialog(this.mActivity, this);
            this.mDialog = iDialogCreateUnlockConfirmDialog;
            iDialogCreateUnlockConfirmDialog.show();
            this.mRunnable = runnable;
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IUnlockConfirmDialogPresenter
    public void unlock(Activity activity) {
        Runnable runnable = this.mRunnable;
        if (runnable != null) {
            runnable.run();
        }
    }
}
