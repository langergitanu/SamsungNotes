package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.dialog;

import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.main.common.GcsConstants;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class CoeditSpaceLeaveDialogFragment extends DeleteDialogFragment {
    private boolean mIsLeader;

    public CoeditSpaceLeaveDialogFragment() {
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.dialog.DeleteDialogFragment, androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog alertDialog = (AlertDialog) super.onCreateDialog(bundle);
        if (bundle != null) {
            this.mIsLeader = bundle.getBoolean(GcsConstants.KEY_IS_LEADER);
        }
        return alertDialog;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.noteslist.view.dialog.DeleteDialogFragment, com.samsung.android.support.senl.p148nt.base.winset.view.AbsDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(GcsConstants.KEY_IS_LEADER, this.mIsLeader);
    }

    public CoeditSpaceLeaveDialogFragment(boolean z, int i) {
        super(C8003R.string.co_edit_leave_space_dialog_title, z ? C8003R.string.co_edit_leave_space_dialog_message_for_leader : C8003R.string.co_edit_leave_space_dialog_message, C8003R.string.dialog_ok, 1, 0, 0, false, i, false);
        this.mIsLeader = z;
    }
}
