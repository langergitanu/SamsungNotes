package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.dialog;

import com.google.android.material.timepicker.TimeModel;
import com.samsung.android.app.notes.sync.contentsharing.sesdb.SesCoeditShareReadResolver;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.main.sharednotebook.dialog.GroupNameDialogFragment;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class CoeditNameDialogFragment extends GroupNameDialogFragment {
    public CoeditNameDialogFragment() {
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.sharednotebook.dialog.GroupNameDialogFragment, com.samsung.android.support.senl.p148nt.app.main.common.dialog.NameDialogFragment
    public String getDefaultTitle() {
        List<String> defaultNotebooksName = SesCoeditShareReadResolver.getInstance().getDefaultNotebooksName(getString(C8003R.string.gcs_group_rename_dialog_default_title).replace(TimeModel.NUMBER_FORMAT, "%").trim());
        int i = 1;
        while (true) {
            if (i > defaultNotebooksName.size() + 1) {
                i = 0;
                break;
            }
            if (!defaultNotebooksName.contains(getString(C8003R.string.gcs_group_rename_dialog_default_title, Integer.valueOf(i)))) {
                break;
            }
            i++;
        }
        return getString(C8003R.string.gcs_group_rename_dialog_default_title, Integer.valueOf(i));
    }

    public CoeditNameDialogFragment(String str, String str2) {
        super(str, str2);
    }
}
