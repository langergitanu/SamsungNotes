package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Resources;
import androidx.appcompat.app.AlertDialog;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.AlertDialogWrapper;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.mde.OptionMenuStartCoeditPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OptionMenuDelete {
    public static final int MODE_DELETE = 1;
    public static final int MODE_PERMANENTLY_DELETE = 2;
    private static final String TAG = Logger.createTag("OptionMenuDelete");
    private final Activity mActivity;
    private AlertDialog mDialog;
    private final OptionMenuPresenter mPresenter;

    public OptionMenuDelete(Activity activity, OptionMenuPresenter optionMenuPresenter) {
        this.mActivity = activity;
        this.mPresenter = optionMenuPresenter;
    }

    public void showDeleteConfirmDialog(final int i) {
        String string;
        int i2;
        if (this.mActivity.isFinishing() || CommonUtil.isTaskRootAndLockTaskMode(this.mActivity)) {
            return;
        }
        if (!this.mPresenter.canDelete()) {
            ToastHandler.show(this.mActivity, C9086R.string.composer_no_items_to_delete, 1);
            return;
        }
        AlertDialog alertDialog = this.mDialog;
        if (alertDialog != null && alertDialog.isShowing()) {
            Logger.m10999d(TAG, "delete dialog is already shown");
            return;
        }
        Resources resources = this.mActivity.getResources();
        AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = new AlertDialogBuilderForAppCompat(this.mActivity);
        String string2 = null;
        if (i == 2) {
            if (!this.mPresenter.isCoeditNote()) {
                string = resources.getQuantityString(C9086R.plurals.plurals_permanently_delete_n_note_erased_dialog_msg, 1, 1);
            } else {
                if (!OptionMenuStartCoeditPresenter.isNetworkAvailable(this.mActivity)) {
                    ToastHandler.show(this.mActivity, C9086R.string.coedit_delete_network_fail, 0);
                    return;
                }
                string2 = resources.getString(C9086R.string.coedit_delete_standalone_dialog_title);
                string = resources.getString(C9086R.string.coedit_delete_standalone_dialog_message);
                String str = this.mPresenter.isEditMode() ? "683" : "682";
                if (this.mPresenter.isStandAlone()) {
                    ComposerSA.insertLog(str, ComposerSAConstants.EVENT_COEDIT_MENU_DELETE_STANDALONE);
                } else {
                    ComposerSA.insertLog(str, ComposerSAConstants.EVENT_COEDIT_MENU_DELETE_NOTE_IN_NOTEBOOK);
                }
            }
            i2 = C9086R.string.action_delete;
        } else {
            string = resources.getString(C9086R.string.composer_move_note_to_the_trash_dialog_msg);
            i2 = C9086R.string.composer_move_to_trash_btn;
        }
        if (string2 != null) {
            alertDialogBuilderForAppCompat.setTitle(string2);
        }
        alertDialogBuilderForAppCompat.setMessage(string);
        alertDialogBuilderForAppCompat.setPositiveButton(i2, new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.OptionMenuDelete.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i4) {
                if (OptionMenuDelete.this.mPresenter.isInAppCollaborationMode()) {
                    ComposerSA.insertLog(ComposerSAConstants.SCREEN_IN_APP_SERVER, "7032");
                } else {
                    ComposerSA.insertLog("703", "7032");
                }
                OptionMenuDelete.this.mPresenter.onClickDeleteBtn(i == 1);
                dialogInterface.dismiss();
            }
        }).setNeutralButton(C9086R.string.composer_string_cancel, new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.OptionMenuDelete.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i4) {
                if (OptionMenuDelete.this.mPresenter.isInAppCollaborationMode()) {
                    ComposerSA.insertLog(ComposerSAConstants.SCREEN_IN_APP_SERVER, "7031");
                } else {
                    ComposerSA.insertLog("703", "7031");
                }
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialogCreate = alertDialogBuilderForAppCompat.create();
        this.mDialog = alertDialogCreate;
        AlertDialogWrapper.setAnchorView(alertDialogCreate, this.mActivity.findViewById(C9086R.id.toolbar), AlertDialogWrapper.AnchorType.getTOOLBAR());
        this.mDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.OptionMenuDelete.3
            @Override // android.content.DialogInterface.OnShowListener
            public void onShow(DialogInterface dialogInterface) {
                ComposerSA.insertLog("703");
                if (i == 2) {
                    OptionMenuDelete.this.mDialog.getButton(-1).setTextColor(OptionMenuDelete.this.mActivity.getResources().getColor(C9086R.color.composer_default_button_color_red, null));
                }
            }
        });
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.OptionMenuDelete.4
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                OptionMenuDelete.this.mDialog = null;
            }
        });
        this.mDialog.show();
        if (this.mPresenter.isInAppCollaborationMode()) {
            ComposerSA.insertLog(ComposerSAConstants.SCREEN_IN_APP_SERVER, ComposerSAConstants.EVENT_IN_APP_EDIT_DELETE_NOTE);
        } else {
            ComposerSA.insertLog("301", ComposerSAConstants.EVENT_VIEW_DELETE_NOTE);
        }
    }
}
