package com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.dialog;

import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareData;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.SaveAsRenameDialogPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class SaveAsRenameFileDialogPresenter extends SaveAsRenameDialogPresenter {
    private static final String TAG = Logger.createTag("SaveAsRenameFileDialogPresenter");

    public SaveAsRenameFileDialogPresenter() {
        super(null);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.SaveAsRenameDialogPresenter
    public DialogFragment createDialogFragment() {
        SaveAsRenameFileDialogFragment saveAsRenameFileDialogFragment = new SaveAsRenameFileDialogFragment();
        saveAsRenameFileDialogFragment.setPresenter(this);
        return saveAsRenameFileDialogFragment;
    }

    public String getExportStorageDir() {
        return this.mExportStorageDir;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.SaveAsRenameDialogPresenter, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.RenameDialogCommonPresenter
    public String getTag() {
        return TAG;
    }

    public void onRestoreInstanceState(Bundle bundle, SaveAsRenameDialogPresenter.OnClickListener onClickListener) {
        this.mShareData = (ShareData) bundle.getParcelable("mShareData");
        this.mExportStorageDir = bundle.getString("mExportStorageDir");
        this.mExtension = bundle.getString("mExtension");
        this.mOnClickListener = onClickListener;
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putParcelable("mShareData", this.mShareData);
        bundle.putString("mExportStorageDir", this.mExportStorageDir);
        bundle.putString("mExtension", this.mExtension);
    }
}
