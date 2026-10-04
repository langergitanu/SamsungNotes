package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog;

import android.app.Activity;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.hashtag.HashTagController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class HashTagRenameDialogPresenter extends AbsDialogFragmentPresenter {
    private DialogContract.IDialogCreator mCreator;
    private HashTagController mHashTagController;

    public HashTagRenameDialogPresenter(DialogContract.IDialogCreator iDialogCreator, HashTagController hashTagController) {
        this.mCreator = iDialogCreator;
        this.mHashTagController = hashTagController;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.AbsDialogFragmentPresenter
    public DialogFragment findFragmentByTag(Activity activity) {
        return findFragmentByTag(activity, ComposerConstants.TAG_HASHTAG_RENAME_DIALOG_FRAGMENT);
    }

    public void rename(String str, String str2) {
        this.mHashTagController.onHashTagRenameed(str, str2);
    }

    public void showHashTagRenameDialog(String str) {
        if (findFragmentByTag(this.mActivity) == null) {
            DialogFragment dialogFragmentCreateHashTagRenameDialogFragment = this.mCreator.createHashTagRenameDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString(ComposerConstants.HASHTAG_NAME, str);
            dialogFragmentCreateHashTagRenameDialogFragment.setArguments(bundle);
            dialogFragmentCreateHashTagRenameDialogFragment.show(((AppCompatActivity) this.mActivity).getSupportFragmentManager(), ComposerConstants.TAG_HASHTAG_RENAME_DIALOG_FRAGMENT);
        }
    }
}
