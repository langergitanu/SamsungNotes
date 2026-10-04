package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AlertDialog;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import p054M1.DialogInterfaceOnShowListenerC0176c;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class CoeditSpaceEditMenuDialog {
    private AlertDialog mDialog;
    private IGroupEditMenuDialog mEditMenuDialogContract;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IGroupEditMenuDialog {
        void delete();

        void leave();

        void rename();
    }

    public CoeditSpaceEditMenuDialog(final Context context, String str, boolean z, IGroupEditMenuDialog iGroupEditMenuDialog) {
        if (context == null) {
            return;
        }
        this.mEditMenuDialogContract = iGroupEditMenuDialog;
        final String[] strArr = z ? new String[]{context.getResources().getString(C8003R.string.co_edit_space_rename), context.getResources().getString(C8003R.string.co_edit_space_leave), context.getResources().getString(C8003R.string.co_edit_space_delete)} : new String[]{context.getResources().getString(C8003R.string.co_edit_space_leave)};
        AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = new AlertDialogBuilderForAppCompat(context, C8003R.style.NoteAlertDialogListThemeForAppCompat);
        StringBuilder sbM12325j = AbstractC11014a.m12325j(str, " ");
        sbM12325j.append(context.getString(C8003R.string.shared_notebooks));
        alertDialogBuilderForAppCompat.setTitle(sbM12325j);
        alertDialogBuilderForAppCompat.setItems(strArr, new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.dialog.CoeditSpaceEditMenuDialog.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                String str2 = strArr[i];
                if (context.getResources().getString(C8003R.string.co_edit_space_rename).equals(str2)) {
                    CoeditSpaceEditMenuDialog.this.mEditMenuDialogContract.rename();
                } else if (context.getResources().getString(C8003R.string.co_edit_space_leave).equals(str2)) {
                    CoeditSpaceEditMenuDialog.this.mEditMenuDialogContract.leave();
                } else if (context.getResources().getString(C8003R.string.co_edit_space_delete).equals(str2)) {
                    CoeditSpaceEditMenuDialog.this.mEditMenuDialogContract.delete();
                }
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialogCreate = alertDialogBuilderForAppCompat.create();
        this.mDialog = alertDialogCreate;
        alertDialogCreate.setOnShowListener(new DialogInterfaceOnShowListenerC0176c(this, 3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0(DialogInterface dialogInterface) {
        Window window = this.mDialog.getWindow();
        if (window == null) {
            return;
        }
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.layoutInDisplayCutoutMode = 2;
        window.setAttributes(attributes);
    }

    public void show() {
        AlertDialog alertDialog = this.mDialog;
        if (alertDialog != null) {
            alertDialog.show();
        }
    }
}
