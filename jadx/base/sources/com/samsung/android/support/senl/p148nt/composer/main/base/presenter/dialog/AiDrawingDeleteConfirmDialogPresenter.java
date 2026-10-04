package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog;

import android.app.Activity;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.constants.SharedPreferencesConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class AiDrawingDeleteConfirmDialogPresenter implements DialogContract.IAIDrawingDeleteConfirmDialogPresenter {
    private static final String TAG = Logger.createTag("SummaryOptionDialogPresenter");
    private Contract mContract;
    private final DialogContract.IDialogCreator mCreator;
    private DialogContract.IDialog mDialog;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        void delete();
    }

    public AiDrawingDeleteConfirmDialogPresenter(DialogContract.IDialogCreator iDialogCreator) {
        this.mCreator = iDialogCreator;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IAIDrawingDeleteConfirmDialogPresenter
    public void delete() {
        Contract contract = this.mContract;
        if (contract != null) {
            contract.delete();
        }
    }

    public void hide() {
        if (isShowing()) {
            this.mDialog.dismiss();
        }
    }

    public boolean isShowing() {
        DialogContract.IDialog iDialog = this.mDialog;
        return iDialog != null && iDialog.isShowing();
    }

    public void onDetachView() {
        DialogContract.IDialog iDialog = this.mDialog;
        if (iDialog == null || !iDialog.isShowing()) {
            return;
        }
        this.mDialog.dismiss();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IPresenter
    public void onDismiss() {
        this.mContract = null;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IAIDrawingDeleteConfirmDialogPresenter
    public void setOffOption() {
        SharedPreferencesCompat.getInstance("Composer").edit().putBoolean(SharedPreferencesConstants.AI_DRAWING_DELETE_CONFIRM_DIALOG_OFF, true).apply();
    }

    public void showDialog(Activity activity, Contract contract) {
        if (CommonUtil.isNotAvailableActivity(activity)) {
            Logger.m11004w(TAG, "showDialog# " + activity);
            return;
        }
        this.mContract = contract;
        DialogContract.IDialog iDialog = this.mDialog;
        if (iDialog != null && iDialog.isShowing()) {
            Logger.m11004w(TAG, "showDialog# dialog is already shown");
            return;
        }
        DialogContract.IDialog iDialogCreateAiDrawingDeleteConfirmDialog = this.mCreator.createAiDrawingDeleteConfirmDialog(activity, this);
        this.mDialog = iDialogCreateAiDrawingDeleteConfirmDialog;
        iDialogCreateAiDrawingDeleteConfirmDialog.show();
    }
}
