package com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.view.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.DateTimeUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class RestoreDialogFragment extends DialogFragment {
    public static final String KEY_LAST_MODIFIED_TIME = "lastModifiedTime";
    private static final String TAG = Logger.createTag("RestoreDialogFragment");
    private Long mLastModifiedTime = null;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        void onDiscardClicked();

        void onRestoreClicked();
    }

    public RestoreDialogFragment() {
        setCancelable(false);
    }

    private void loadData(Bundle bundle) {
        if (bundle != null && bundle.containsKey(KEY_LAST_MODIFIED_TIME)) {
            this.mLastModifiedTime = Long.valueOf(bundle.getLong(KEY_LAST_MODIFIED_TIME, 0L));
        }
    }

    public Contract getContract() {
        return getParentFragment() instanceof Contract ? (Contract) getParentFragment() : new Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.pdfwriter.view.dialog.RestoreDialogFragment.3
            @Override // com.samsung.android.support.senl.nt.composer.main.pdfwriter.view.dialog.RestoreDialogFragment.Contract
            public void onDiscardClicked() {
                Logger.m11000e(RestoreDialogFragment.TAG, "onDiscardClicked# dummy");
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.pdfwriter.view.dialog.RestoreDialogFragment.Contract
            public void onRestoreClicked() {
                Logger.m11000e(RestoreDialogFragment.TAG, "onRestoreClicked# dummy");
            }
        };
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        if (bundle == null) {
            loadData(getArguments());
        } else {
            loadData(bundle);
        }
        AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = new AlertDialogBuilderForAppCompat(getContext());
        alertDialogBuilderForAppCompat.setTitle(C9086R.string.pdf_reader_restore_title);
        alertDialogBuilderForAppCompat.setMessage(getString(C9086R.string.pdf_reader_restore_desc_first) + "\n" + getString(C9086R.string.pdf_reader_restore_desc_second, this.mLastModifiedTime == null ? "" : DateTimeUtil.convertFormattedTime(getContext(), this.mLastModifiedTime.longValue()))).setPositiveButton(C9086R.string.action_restore, new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.pdfwriter.view.dialog.RestoreDialogFragment.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Logger.m10999d(RestoreDialogFragment.TAG, "onClick# ok");
                RestoreDialogFragment.this.getContract().onRestoreClicked();
                RestoreDialogFragment.this.dismiss();
            }
        }).setNegativeButton(C9086R.string.dialog_discard, new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.pdfwriter.view.dialog.RestoreDialogFragment.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Logger.m10999d(RestoreDialogFragment.TAG, "onClick# discard");
                RestoreDialogFragment.this.getContract().onDiscardClicked();
                RestoreDialogFragment.this.dismiss();
            }
        });
        AlertDialog alertDialogCreate = alertDialogBuilderForAppCompat.create();
        alertDialogCreate.setCanceledOnTouchOutside(false);
        alertDialogCreate.setCancelable(false);
        return alertDialogCreate;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }
}
