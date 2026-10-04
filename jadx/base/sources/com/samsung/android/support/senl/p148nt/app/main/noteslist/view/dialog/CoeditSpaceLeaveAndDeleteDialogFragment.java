package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.dialog;

import android.app.Dialog;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class CoeditSpaceLeaveAndDeleteDialogFragment extends DeleteDialogFragment {
    private String mSpaceTitle;

    public CoeditSpaceLeaveAndDeleteDialogFragment() {
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.dialog.DeleteDialogFragment, androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog alertDialog = (AlertDialog) super.onCreateDialog(bundle);
        if (bundle != null) {
            this.mSpaceTitle = bundle.getString("spaceId");
        }
        alertDialog.setTitle(getResources().getString(this.mTitleId, this.mSpaceTitle));
        alertDialog.setMessage(getResources().getString(this.mMessageId, this.mSpaceTitle));
        return alertDialog;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.dialog.DeleteDialogFragment, com.samsung.android.support.senl.p148nt.base.winset.view.AbsDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("spaceId", this.mSpaceTitle);
    }

    public CoeditSpaceLeaveAndDeleteDialogFragment(String str, int i) {
        super(C8003R.string.coedit_leave_n_delete_dialog_title, C8003R.string.coedit_leave_n_delete_dialog_message, C8003R.string.coedit_leave_n_delete_dialog_button, 1, 0, 0, false, i, false);
        this.mSpaceTitle = str;
    }
}
