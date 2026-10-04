package com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.ShareSaveNoteConfirmDialogPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ShareSaveNoteConfirmDialogFragment extends DialogFragment {
    private static final String TAG = Logger.createTag("ShareSaveNoteConfirmDialogFragment");
    private ShareSaveNoteConfirmDialogPresenter mPresenter;

    private DialogInterface.OnClickListener getNegativeButtonClickListener() {
        return new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.ShareSaveNoteConfirmDialogFragment.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                ShareSaveNoteConfirmDialogFragment.this.getPresenter().dismiss();
                dialogInterface.dismiss();
            }
        };
    }

    private DialogInterface.OnClickListener getPositiveButtonClickListener() {
        return new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.ShareSaveNoteConfirmDialogFragment.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                ShareSaveNoteConfirmDialogFragment.this.getPresenter().save();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ShareSaveNoteConfirmDialogPresenter getPresenter() {
        DialogContract.IFragmentPresenterContainer iFragmentPresenterContainer;
        if (this.mPresenter == null && getActivity() != null && (iFragmentPresenterContainer = (DialogContract.IFragmentPresenterContainer) getActivity().getSupportFragmentManager().findFragmentByTag("Composer")) != null) {
            this.mPresenter = (ShareSaveNoteConfirmDialogPresenter) iFragmentPresenterContainer.getDialogFragmentPresenter(14);
        }
        if (this.mPresenter == null) {
            Logger.m10999d(TAG, "getPresenter()# Presenter is null. dismiss call");
            dismiss();
        }
        return this.mPresenter;
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = new AlertDialogBuilderForAppCompat(getContext());
        alertDialogBuilderForAppCompat.setMessage(getPresenter() == null ? C9086R.string.composer_share_save : getPresenter().getMessageId());
        alertDialogBuilderForAppCompat.setPositiveButton(C9086R.string.composer_share_save_note, getPositiveButtonClickListener());
        alertDialogBuilderForAppCompat.setNeutralButton(C9086R.string.base_string_cancel_type1, getNegativeButtonClickListener());
        return alertDialogBuilderForAppCompat.create();
    }
}
