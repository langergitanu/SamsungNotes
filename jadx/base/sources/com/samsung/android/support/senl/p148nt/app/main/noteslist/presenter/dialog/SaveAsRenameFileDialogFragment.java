package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.dialog;

import android.app.Dialog;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.SaveAsRenameDialogPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.SaveAsRenameDialogFragment;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class SaveAsRenameFileDialogFragment extends SaveAsRenameDialogFragment {
    private static final String TAG = Logger.createTag("SaveAsRenameFileDialogFragment");

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.RenameDialogCommonFragment, androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        return initAlertDialog(bundle, initLayout(bundle));
    }

    public void setPresenter(SaveAsRenameDialogPresenter saveAsRenameDialogPresenter) {
        this.mPresenter = saveAsRenameDialogPresenter;
        handlePendedTasks();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.SaveAsRenameDialogFragment, com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.RenameDialogCommonFragment
    public SaveAsRenameDialogPresenter getPresenter() {
        return (SaveAsRenameDialogPresenter) this.mPresenter;
    }
}
