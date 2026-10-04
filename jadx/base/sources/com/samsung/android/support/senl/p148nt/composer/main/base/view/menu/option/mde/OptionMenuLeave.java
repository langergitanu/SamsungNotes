package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.option.mde;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.res.Resources;
import androidx.appcompat.app.AlertDialog;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.AlertDialogWrapper;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OptionMenuLeave {
    private static final String TAG = Logger.createTag("OptionMenuLeave");
    private final Activity mActivity;
    private AlertDialog mDialog;
    private final OptionMenuPresenter mPresenter;

    public OptionMenuLeave(Activity activity, OptionMenuPresenter optionMenuPresenter) {
        this.mActivity = activity;
        this.mPresenter = optionMenuPresenter;
    }

    public void showLeaveConfirmDialog() {
        String string;
        int i;
        this.mPresenter.clearSelectionForEachMode();
        if (CommonUtil.isNotAvailableActivity(this.mActivity) || CommonUtil.isTaskRootAndLockTaskMode(this.mActivity)) {
            return;
        }
        AlertDialog alertDialog = this.mDialog;
        if (alertDialog != null && alertDialog.isShowing()) {
            Logger.m10999d(TAG, "showLeaveConfirmDialog# already shown");
            return;
        }
        Resources resources = this.mActivity.getResources();
        AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = new AlertDialogBuilderForAppCompat(this.mActivity);
        if (this.mPresenter.isLeader()) {
            string = resources.getString(C9086R.string.coedit_leave_standalone_dialog_message_for_leader);
            i = C9086R.string.f6715OK;
        } else {
            string = resources.getString(C9086R.string.coedit_leave_standalone_dialog_message);
            i = C9086R.string.coedit_action_leave;
        }
        alertDialogBuilderForAppCompat.setTitle(C9086R.string.coedit_leave_standalone_dialog_title);
        alertDialogBuilderForAppCompat.setMessage(string);
        alertDialogBuilderForAppCompat.setPositiveButton(i, new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.mde.OptionMenuLeave.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                OptionMenuLeave.this.mPresenter.onClickLeave();
                dialogInterface.dismiss();
            }
        }).setNeutralButton(C9086R.string.composer_string_cancel, new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.mde.OptionMenuLeave.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialogCreate = alertDialogBuilderForAppCompat.create();
        this.mDialog = alertDialogCreate;
        AlertDialogWrapper.setAnchorView(alertDialogCreate, this.mActivity.findViewById(C9086R.id.toolbar), AlertDialogWrapper.AnchorType.getTOOLBAR());
        this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.menu.option.mde.OptionMenuLeave.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                OptionMenuLeave.this.mDialog = null;
            }
        });
        this.mDialog.show();
        ComposerSA.insertLog(this.mPresenter.isEditMode() ? "683" : "682", ComposerSAConstants.EVENT_COEDIT_MENU_LEAVE_STANDALONE);
    }
}
