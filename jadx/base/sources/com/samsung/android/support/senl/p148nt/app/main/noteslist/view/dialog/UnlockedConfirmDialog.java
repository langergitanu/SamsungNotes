package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.dialog.DialogViewContract;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.dialog.UnlockConfirmDialogHelper;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class UnlockedConfirmDialog extends Dialog {
    private final AlertDialog mDialog;
    private final UnlockConfirmDialogHelper mHelper;

    public UnlockedConfirmDialog(Context context, UnlockConfirmDialogHelper unlockConfirmDialogHelper, final DialogViewContract.IUnlockConfirmDialog iUnlockConfirmDialog) {
        super(context);
        this.mHelper = unlockConfirmDialogHelper;
        this.mDialog = ((AlertDialogBuilderForAppCompat) new AlertDialogBuilderForAppCompat(context).setTitle(unlockConfirmDialogHelper.getTitle()).setMessage(unlockConfirmDialogHelper.getMessage()).setCancelable(true).setPositiveButton(unlockConfirmDialogHelper.getPositiveButton(), new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.dialog.UnlockedConfirmDialog.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (UnlockedConfirmDialog.this.mHelper.getCaller() == UnlockConfirmDialogHelper.Caller.PICKER) {
                    CommonSamsungAnalytics.insertLog("722", "7222");
                } else {
                    CommonSamsungAnalytics.insertLog("744", "7442");
                }
                UserInputSkipper.setHoldingEventTime(1000L, UserInputSkipper.Tag.MemoList);
                iUnlockConfirmDialog.unLock();
            }
        }).setNegativeButton(unlockConfirmDialogHelper.getNegativeButton(), new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.dialog.UnlockedConfirmDialog.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (UnlockedConfirmDialog.this.mHelper.getCaller() == UnlockConfirmDialogHelper.Caller.PICKER) {
                    CommonSamsungAnalytics.insertLog("722", "7221");
                } else {
                    CommonSamsungAnalytics.insertLog("744", "7441");
                }
            }
        })).create();
    }

    @Override // android.app.Dialog
    public void show() {
        AlertDialog alertDialog = this.mDialog;
        if (alertDialog != null) {
            alertDialog.show();
        }
    }
}
