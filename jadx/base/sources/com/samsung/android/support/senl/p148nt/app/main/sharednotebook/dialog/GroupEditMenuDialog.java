package com.samsung.android.support.senl.p148nt.app.main.sharednotebook.dialog;

import android.content.Context;
import android.content.DialogInterface;
import androidx.appcompat.app.AlertDialog;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class GroupEditMenuDialog {
    private AlertDialog mDialog;
    private IGroupEditMenuDialog mEditMenuDialogContract;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IGroupEditMenuDialog {
        void delete(boolean z);

        void rename();
    }

    public GroupEditMenuDialog(final Context context, String str, boolean z, IGroupEditMenuDialog iGroupEditMenuDialog) {
        if (context == null) {
            return;
        }
        this.mEditMenuDialogContract = iGroupEditMenuDialog;
        final String[] strArr = z ? new String[]{context.getResources().getString(C8003R.string.gcs_group_edit_menu_dialog_delete), context.getResources().getString(C8003R.string.base_string_rename_type2)} : new String[]{context.getResources().getString(C8003R.string.gcs_group_edit_menu_dialog_leave)};
        AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = new AlertDialogBuilderForAppCompat(context, C8003R.style.NoteAlertDialogListThemeForAppCompat);
        StringBuilder sbM12325j = AbstractC11014a.m12325j(str, " ");
        sbM12325j.append(context.getString(C8003R.string.shared_notebooks));
        alertDialogBuilderForAppCompat.setTitle(sbM12325j);
        alertDialogBuilderForAppCompat.setItems(strArr, new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.sharednotebook.dialog.GroupEditMenuDialog.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                String str2 = strArr[i];
                if (context.getResources().getString(C8003R.string.gcs_group_edit_menu_dialog_delete).equals(str2)) {
                    CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_GCS_GROUP_LIST, NotesSAConstants.EVENT_GCS_GROUP_DELETE_SHARED_NOTEBOOK);
                    GroupEditMenuDialog.this.mEditMenuDialogContract.delete(true);
                } else if (context.getResources().getString(C8003R.string.base_string_rename_type2).equals(str2)) {
                    CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_GCS_GROUP_LIST, NotesSAConstants.EVENT_GCS_GROUP_RENAME);
                    GroupEditMenuDialog.this.mEditMenuDialogContract.rename();
                } else if (context.getResources().getString(C8003R.string.gcs_group_edit_menu_dialog_leave).equals(str2)) {
                    CommonSamsungAnalytics.insertLog(NotesSAConstants.SCREEN_GCS_GROUP_LIST, NotesSAConstants.EVENT_GCS_GROUP_LEAVE_SHARED_NOTEBOOK);
                    GroupEditMenuDialog.this.mEditMenuDialogContract.delete(false);
                }
                dialogInterface.dismiss();
            }
        });
        this.mDialog = alertDialogBuilderForAppCompat.create();
    }

    public void show() {
        AlertDialog alertDialog = this.mDialog;
        if (alertDialog != null) {
            alertDialog.show();
        }
    }
}
