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
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.SaveNoteConfirmDialogPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SaveNoteConfirmDialogFragment extends DialogFragment {
    private static final String TAG = Logger.createTag("SaveNoteConfirmDialogFragment");
    private boolean isClicked = false;
    private SaveNoteConfirmDialogPresenter mPresenter;

    /* JADX INFO: Access modifiers changed from: private */
    public SaveNoteConfirmDialogPresenter getPresenter() {
        DialogContract.IFragmentPresenterContainer iFragmentPresenterContainer;
        if (this.mPresenter == null && getActivity() != null && (iFragmentPresenterContainer = (DialogContract.IFragmentPresenterContainer) getActivity().getSupportFragmentManager().findFragmentByTag("Composer")) != null) {
            this.mPresenter = (SaveNoteConfirmDialogPresenter) iFragmentPresenterContainer.getDialogFragmentPresenter(8);
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
        alertDialogBuilderForAppCompat.setMessage(C9086R.string.base_string_popup_ask_save);
        alertDialogBuilderForAppCompat.setPositiveButton(C9086R.string.string_save_full, new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.SaveNoteConfirmDialogFragment.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                SaveNoteConfirmDialogPresenter presenter;
                if (SaveNoteConfirmDialogFragment.this.isClicked || (presenter = SaveNoteConfirmDialogFragment.this.getPresenter()) == null) {
                    return;
                }
                presenter.save();
                SaveNoteConfirmDialogFragment.this.isClicked = true;
                ComposerSA.insertLog(ComposerSAConstants.SCREEN_DIALOGS_CHECK_SAVE, ComposerSAConstants.EVENT_DIALOGS_CHECK_SAVE_SAVE);
            }
        });
        alertDialogBuilderForAppCompat.setNegativeButton(C9086R.string.string_discard, new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.SaveNoteConfirmDialogFragment.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                SaveNoteConfirmDialogPresenter presenter;
                if (SaveNoteConfirmDialogFragment.this.isClicked || (presenter = SaveNoteConfirmDialogFragment.this.getPresenter()) == null) {
                    return;
                }
                presenter.discard();
                SaveNoteConfirmDialogFragment.this.isClicked = true;
                ComposerSA.insertLog(ComposerSAConstants.SCREEN_DIALOGS_CHECK_SAVE, ComposerSAConstants.EVENT_DIALOGS_CHECK_SAVE_DISCARD);
            }
        });
        alertDialogBuilderForAppCompat.setNeutralButton(C9086R.string.base_string_cancel_type1, new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.SaveNoteConfirmDialogFragment.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                SaveNoteConfirmDialogPresenter presenter;
                if (SaveNoteConfirmDialogFragment.this.isClicked || (presenter = SaveNoteConfirmDialogFragment.this.getPresenter()) == null) {
                    return;
                }
                presenter.dismiss();
                dialogInterface.dismiss();
                SaveNoteConfirmDialogFragment.this.isClicked = true;
                ComposerSA.insertLog(ComposerSAConstants.SCREEN_DIALOGS_CHECK_SAVE, ComposerSAConstants.EVENT_DIALOGS_CHECK_SAVE_CANCEL);
            }
        });
        return alertDialogBuilderForAppCompat.create();
    }
}
