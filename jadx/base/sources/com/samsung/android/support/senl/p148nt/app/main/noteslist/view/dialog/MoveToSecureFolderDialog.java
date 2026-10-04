package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.dialog.DialogViewContract;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.base.winset.app.popover.AlertDialogWrapper;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.model.securefolder.common.SecureFolderUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class MoveToSecureFolderDialog extends Dialog {
    private final AlertDialog mDialog;

    public MoveToSecureFolderDialog(Context context, int i, View view, final DialogViewContract.IMoveToSecureFolderDialog iMoveToSecureFolderDialog) {
        super(context);
        String menuName = SecureFolderUtils.getMenuName(context);
        AlertDialog alertDialogCreate = ((AlertDialogBuilderForAppCompat) new AlertDialogBuilderForAppCompat(context).setTitle(menuName.isEmpty() ? "" : menuName).setMessage(i > 1 ? context.getString(C8003R.string.noteslist_unlock_notes_for_move_to_secure_folder) : context.getString(C8003R.string.noteslist_unlock_note_for_move_to_secure_folder)).setCancelable(true).setPositiveButton(C8003R.string.dialog_continue, new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.dialog.MoveToSecureFolderDialog.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                UserInputSkipper.setHoldingEventTime(1000L, UserInputSkipper.Tag.MemoList);
                iMoveToSecureFolderDialog.onConfirm();
            }
        }).setNegativeButton(C8003R.string.dialog_cancel, new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.dialog.MoveToSecureFolderDialog.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                MoveToSecureFolderDialog.this.dismiss();
            }
        })).create();
        this.mDialog = alertDialogCreate;
        AlertDialogWrapper.setAnchorView(alertDialogCreate, view);
    }

    @Override // android.app.Dialog
    public void show() {
        AlertDialog alertDialog = this.mDialog;
        if (alertDialog != null) {
            alertDialog.show();
        }
    }
}
