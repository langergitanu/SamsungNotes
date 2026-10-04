package com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog;

import com.samsung.android.support.senl.p148nt.base.common.constants.BaseComposerConstants;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.SaveAsRenameDialogPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.RenameDialogCommonFragment;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SaveAsRenameDialogFragment extends RenameDialogCommonFragment {
    private static final String TAG = Logger.createTag("SaveAsRenameDialogFragment");

    public SaveAsRenameDialogFragment() {
        super(100);
        setRenameType(RenameDialogCommonFragment.RenameType.FILE_NAME);
        setPatternInvalidChars(BaseComposerConstants.PATTERN_FILE_NAME_INVALID_CHARS);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.RenameDialogCommonFragment
    public String getExistNameError() {
        return getContext().getString(C9086R.string.file_name_already_in_use);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.RenameDialogCommonFragment
    public String getHintText() {
        return getContext().getString(C9086R.string.file_name);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.RenameDialogCommonFragment
    public String getInvalidNameError() {
        return getContext().getString(C9086R.string.file_name_invalid);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.RenameDialogCommonFragment
    public String getPositiveButtonText() {
        return getContext().getString(C9086R.string.base_string_save);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.RenameDialogCommonFragment
    public void insertNegativeClickSALog() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.RenameDialogCommonFragment
    public void insertPositiveClickSALog() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.RenameDialogCommonFragment
    public void insertTextClickSALog() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.RenameDialogCommonFragment
    public void showInvalidTitleToast() {
        ToastHandler.show(getContext(), C9086R.string.file_name_invalid, 0);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog.RenameDialogCommonFragment
    public SaveAsRenameDialogPresenter getPresenter() {
        DialogContract.IFragmentPresenterContainer iFragmentPresenterContainer;
        if (this.mPresenter == null && getActivity() != null && (iFragmentPresenterContainer = (DialogContract.IFragmentPresenterContainer) getActivity().getSupportFragmentManager().findFragmentByTag("Composer")) != null) {
            this.mPresenter = (SaveAsRenameDialogPresenter) iFragmentPresenterContainer.getDialogFragmentPresenter(7);
        }
        if (this.mPresenter == null) {
            Logger.m10999d(TAG, "getPresenter()# Presenter is null. dismiss call");
            dismiss();
        }
        return (SaveAsRenameDialogPresenter) this.mPresenter;
    }
}
