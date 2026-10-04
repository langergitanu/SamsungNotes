package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog;

import android.app.Activity;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.base.common.util.ModelFeature;
import com.samsung.android.support.senl.p148nt.base.composer.common.ComposerSpenUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.WritingToolManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CanNotUseSpenDialogPresenter implements DialogContract.ICanNotUseSpenDialogPresenter {
    private static final int CAN_NOT_USE_SPEN_DIALOG_OK_CLICKED = 1;
    private static final String CAN_NOT_USE_SPEN_PREF = "CanNotUseSpenPref";
    private static final String TAG = Logger.createTag("CanNotUseSpenDialogPresenter");
    private Activity mActivity;
    private final ComposerModel mComposerModel;
    private final DialogContract.IDialogCreator mCreator;
    private DialogContract.IDialog mDialog;
    private boolean mIsSpenSupportDisplay;
    private final WritingToolManager mWritingToolManager;

    public CanNotUseSpenDialogPresenter(DialogContract.IDialogCreator iDialogCreator, WritingToolManager writingToolManager, ComposerModel composerModel) {
        this.mCreator = iDialogCreator;
        this.mWritingToolManager = writingToolManager;
        this.mComposerModel = composerModel;
        this.mIsSpenSupportDisplay = writingToolManager.isSupportedSpenDisplay();
    }

    private boolean canCreateDialog() {
        return (ModelFeature.getFeature().getIsQ2Device() || ModelFeature.getFeature().getIsQ4Device() || ModelFeature.getFeature().getIsQ5Device() || ModelFeature.getFeature().getIsQ6Device()) && ComposerSpenUtils.isSpenActivated() && this.mComposerModel.getModeManager().isMode(Mode.Writing) && this.mIsSpenSupportDisplay != this.mWritingToolManager.isSupportedSpenDisplay() && SharedPreferencesCompat.getInstance("Composer").getInt(CAN_NOT_USE_SPEN_PREF, 0) != 1;
    }

    public void onAttachView(Activity activity) {
        this.mActivity = activity;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.ICanNotUseSpenDialogPresenter
    public void onClicked() {
        SharedPreferencesCompat.getInstance("Composer").putInt(CAN_NOT_USE_SPEN_PREF, 1);
    }

    public void onDetachView() {
        DialogContract.IDialog iDialog = this.mDialog;
        if (iDialog != null && iDialog.isShowing()) {
            this.mDialog.dismiss();
        }
        this.mActivity = null;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IPresenter
    public void onDismiss() {
    }

    public void showDialog() {
        if (CommonUtil.isNotAvailableActivity(this.mActivity)) {
            Logger.m11004w(TAG, "showDialog# " + this.mActivity);
            return;
        }
        if (!canCreateDialog()) {
            Logger.m11004w(TAG, "showDialog# fail create dialog ");
            return;
        }
        this.mIsSpenSupportDisplay = this.mWritingToolManager.isSupportedSpenDisplay();
        DialogContract.IDialog iDialog = this.mDialog;
        if (iDialog != null && iDialog.isShowing()) {
            Logger.m11004w(TAG, "showDialog# dialog is already shown");
            if (this.mIsSpenSupportDisplay) {
                this.mDialog.dismiss();
                return;
            }
            return;
        }
        if (this.mIsSpenSupportDisplay) {
            return;
        }
        DialogContract.IDialog iDialogCreateCanNotUsePenDialog = this.mCreator.createCanNotUsePenDialog(this.mActivity, this);
        this.mDialog = iDialogCreateCanNotUsePenDialog;
        iDialogCreateCanNotUsePenDialog.show();
    }
}
