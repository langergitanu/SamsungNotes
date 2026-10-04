package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog;

import android.app.Activity;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AutoRestoredNoteNotiDialogPresenter implements DialogContract.IPresenter {
    private static final String TAG = Logger.createTag("AutoRestoredNoteNotiDialogPresenter");
    private ComposerModel mComposerModel;
    private DialogContract.IDialog mDialog;

    public AutoRestoredNoteNotiDialogPresenter(ComposerModel composerModel) {
        this.mComposerModel = composerModel;
    }

    private boolean isAvailableToShow(Activity activity) {
        if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
            Logger.m10999d(TAG, "isAvailableToShow# " + activity);
            return false;
        }
        DialogContract.IDialog iDialog = this.mDialog;
        if (iDialog == null || !iDialog.isShowing()) {
            return true;
        }
        Logger.m10999d(TAG, "isAvailableToShow# dialog is showing");
        return false;
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
        this.mComposerModel.setIsRecoveredOnCorrupted(false);
        this.mComposerModel.setCanShowRecoveredOnCorrupted(false);
        DialogContract.IDialog iDialog = this.mDialog;
        if (iDialog != null) {
            iDialog.dismiss();
        }
    }

    public void show(DialogContract.IDialogCreator iDialogCreator, Activity activity) {
        if (isAvailableToShow(activity) && this.mComposerModel.canShowRecoveredOnCorrupted()) {
            DialogContract.IDialog iDialogCreateAutoRestoredNoteNotiDialog = iDialogCreator.createAutoRestoredNoteNotiDialog(activity, this);
            this.mDialog = iDialogCreateAutoRestoredNoteNotiDialog;
            iDialogCreateAutoRestoredNoteNotiDialog.show();
        }
    }
}
