package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.dialog;

import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.dialog.DialogViewContract;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class CoeditNoteDeleteDialogFragment extends DeleteDialogFragment implements DialogViewContract.IDialogFragment {
    public CoeditNoteDeleteDialogFragment() {
    }

    public CoeditNoteDeleteDialogFragment(int i, int i2) {
        super(0, C8003R.plurals.plurals_move_to_trash_n_note_dialog_msg, C8003R.string.move_to_trash_btn, i, 0, 0, true, i2, false);
    }
}
