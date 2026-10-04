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
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.TurnOffTranslationDialogPresenter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TurnOffTranslationModeDialogFragment extends DialogFragment {
    private boolean mIsClicked = false;

    @Nullable
    private TurnOffTranslationDialogPresenter getPresenter() {
        if (getActivity() == null) {
            dismiss();
            return null;
        }
        DialogContract.IFragmentPresenterContainer iFragmentPresenterContainer = (DialogContract.IFragmentPresenterContainer) getActivity().getSupportFragmentManager().findFragmentByTag("Composer");
        if (iFragmentPresenterContainer == null) {
            return null;
        }
        return (TurnOffTranslationDialogPresenter) iFragmentPresenterContainer.getDialogFragmentPresenter(16);
    }

    private int getStringResId(int i) {
        switch (i) {
            case 1:
                return C9086R.string.turn_off_translation_to_share_pdf;
            case 2:
                return C9086R.string.turn_off_translation_to_print_pdf;
            case 3:
                return C9086R.string.turn_off_translation_to_add_pdf_to_note;
            case 4:
                return C9086R.string.turn_off_translation_to_cut_pdf;
            case 5:
                return C9086R.string.turn_off_translation_to_copy_pdf;
            case 6:
                return C9086R.string.this_feature_cant_be_used_with_translated_pdfs;
            default:
                return C9086R.string.turn_off_translation_to_save_pdf;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateDialog$0(DialogInterface dialogInterface, int i) {
        if (this.mIsClicked) {
            return;
        }
        this.mIsClicked = true;
        TurnOffTranslationDialogPresenter presenter = getPresenter();
        if (presenter == null) {
            return;
        }
        presenter.turnOff();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateDialog$1(DialogInterface dialogInterface, int i) {
        if (this.mIsClicked) {
            return;
        }
        this.mIsClicked = true;
        dismiss();
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = new AlertDialogBuilderForAppCompat(getContext());
        alertDialogBuilderForAppCompat.setMessage(getResources().getString(getStringResId(getArguments() == null ? 0 : getArguments().getInt(TurnOffTranslationDialogPresenter.KEY_TURN_OFF_TRANSLATION_TYPE))));
        final int i = 0;
        final int i2 = 1;
        alertDialogBuilderForAppCompat.setPositiveButton(C9086R.string.hw_toolbar_turn_off, new DialogInterface.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.r

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ TurnOffTranslationModeDialogFragment f7148b;

            {
                this.f7148b = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                switch (i) {
                    case 0:
                        this.f7148b.lambda$onCreateDialog$0(dialogInterface, i4);
                        break;
                    default:
                        this.f7148b.lambda$onCreateDialog$1(dialogInterface, i4);
                        break;
                }
            }
        }).setNegativeButton(C9086R.string.dialog_cancel, new DialogInterface.OnClickListener(this) { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.r

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ TurnOffTranslationModeDialogFragment f7148b;

            {
                this.f7148b = this;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                switch (i2) {
                    case 0:
                        this.f7148b.lambda$onCreateDialog$0(dialogInterface, i4);
                        break;
                    default:
                        this.f7148b.lambda$onCreateDialog$1(dialogInterface, i4);
                        break;
                }
            }
        });
        return alertDialogBuilderForAppCompat.create();
    }
}
