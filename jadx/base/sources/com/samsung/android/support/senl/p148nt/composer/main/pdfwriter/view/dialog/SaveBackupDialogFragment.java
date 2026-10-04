package com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.view.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.util.SeslKoreanGeneralizer;
import androidx.fragment.app.DialogFragment;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.dialog.PwSaveBackupDialogPresenter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SaveBackupDialogFragment extends DialogFragment {
    private static final String TAG = Logger.createTag("SaveBackupDialogFragment");
    private boolean isClicked = false;

    /* JADX INFO: Access modifiers changed from: private */
    public PwSaveBackupDialogPresenter getPresenter() {
        if (getActivity() == null) {
            dismiss();
            return null;
        }
        DialogContract.IFragmentPresenterContainer iFragmentPresenterContainer = (DialogContract.IFragmentPresenterContainer) getActivity().getSupportFragmentManager().findFragmentByTag("Composer");
        PwSaveBackupDialogPresenter pwSaveBackupDialogPresenter = iFragmentPresenterContainer != null ? (PwSaveBackupDialogPresenter) iFragmentPresenterContainer.getDialogFragmentPresenter(500) : null;
        if (pwSaveBackupDialogPresenter == null) {
            Logger.m10999d(TAG, "getPresenter()# Presenter is null. dismiss call");
            dismiss();
        }
        return pwSaveBackupDialogPresenter;
    }

    private String getTitle() {
        PwSaveBackupDialogPresenter presenter = getPresenter();
        if (presenter == null) {
            return "";
        }
        String title = presenter.getTitle();
        return TextUtils.isEmpty(title) ? "" : new SeslKoreanGeneralizer().naturalizeText(getString(C9086R.string.pdf_reader_save_backup_confirm_dialog_title, title));
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = new AlertDialogBuilderForAppCompat(getContext());
        alertDialogBuilderForAppCompat.setTitle(getTitle()).setMessage(C9086R.string.pdf_reader_save_backup_confirm_dialog_desc).setPositiveButton(C9086R.string.string_save_full, new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.pdfwriter.view.dialog.SaveBackupDialogFragment.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (!SaveBackupDialogFragment.this.isClicked) {
                    SaveBackupDialogFragment.this.isClicked = true;
                }
                PwSaveBackupDialogPresenter presenter = SaveBackupDialogFragment.this.getPresenter();
                if (presenter != null) {
                    presenter.save();
                }
            }
        }).setNegativeButton(C9086R.string.string_discard, new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.pdfwriter.view.dialog.SaveBackupDialogFragment.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (!SaveBackupDialogFragment.this.isClicked) {
                    SaveBackupDialogFragment.this.isClicked = true;
                }
                PwSaveBackupDialogPresenter presenter = SaveBackupDialogFragment.this.getPresenter();
                if (presenter != null) {
                    presenter.discard();
                }
            }
        });
        AlertDialog alertDialogCreate = alertDialogBuilderForAppCompat.create();
        alertDialogCreate.setCanceledOnTouchOutside(false);
        alertDialogCreate.setCancelable(false);
        return alertDialogCreate;
    }
}
