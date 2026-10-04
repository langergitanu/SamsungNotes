package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.dialog;

import android.content.Context;
import android.content.DialogInterface;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class ObjectLimitConvertDialog {
    private final AlertDialog mDialog;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnClickListener {
        void convertNote();

        void stopSync();
    }

    public ObjectLimitConvertDialog(@NonNull Context context, final OnClickListener onClickListener) {
        AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = new AlertDialogBuilderForAppCompat(context);
        alertDialogBuilderForAppCompat.setTitle(context.getString(C8003R.string.object_limit_convert_note_title));
        alertDialogBuilderForAppCompat.setMessage(context.getString(C8003R.string.object_limit_convert_note_message));
        alertDialogBuilderForAppCompat.setPositiveButton(context.getString(C8003R.string.object_limit_convert_note_btn), new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.dialog.ObjectLimitConvertDialog.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                onClickListener.convertNote();
            }
        });
        alertDialogBuilderForAppCompat.setNegativeButton(context.getString(C8003R.string.object_limit_convert_note_stop_syncing_btn), new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.dialog.ObjectLimitConvertDialog.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                onClickListener.stopSync();
            }
        });
        AlertDialog alertDialogCreate = alertDialogBuilderForAppCompat.create();
        this.mDialog = alertDialogCreate;
        alertDialogCreate.setCanceledOnTouchOutside(true);
    }

    public void showDialog() {
        AlertDialog alertDialog = this.mDialog;
        if (alertDialog != null) {
            alertDialog.show();
        }
    }
}
