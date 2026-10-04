package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog;

import android.app.Activity;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ManualSaveConfirmDialogPresenter implements DialogContract.IManualSaveConfirmDialogPresenter {
    private static final String TAG = Logger.createTag("ManualSaveConfirmDialogPresenter");
    private Runnable mAction;
    private DialogContract.IDialog mDialog;
    private boolean mIsCollaborator;

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IManualSaveConfirmDialogPresenter
    public int getMessageId() {
        return this.mIsCollaborator ? C9086R.string.coedit_manual_save_confirm : C9086R.string.shared_notebook_manual_save_confirm;
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

    public void onDetachView() {
        if (this.mDialog != null) {
            Logger.m11004w(TAG, "onDetachView# dialog is attached");
            this.mDialog.dismiss();
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IPresenter
    public void onDismiss() {
        Logger.m10999d(TAG, "onDismiss#");
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IManualSaveConfirmDialogPresenter
    public void onPositiveButtonClick() {
        Runnable runnable = this.mAction;
        if (runnable != null) {
            runnable.run();
        }
    }

    public void show(DialogContract.IDialogCreator iDialogCreator, Activity activity, Runnable runnable, boolean z) {
        if (CommonUtil.isNotAvailableActivity(activity)) {
            return;
        }
        if (isShowing()) {
            Logger.m10999d(TAG, "show# dialog is showing");
            return;
        }
        this.mAction = runnable;
        this.mIsCollaborator = z;
        DialogContract.IDialog iDialogCreateManualSaveConfirmDialog = iDialogCreator.createManualSaveConfirmDialog(activity, this);
        this.mDialog = iDialogCreateManualSaveConfirmDialog;
        iDialogCreateManualSaveConfirmDialog.show();
    }
}
