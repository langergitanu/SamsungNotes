package com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CanNotAddToNoteDialogFragment extends DialogFragment {
    private boolean mIsClicked = false;

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onCreateDialog$0(DialogInterface dialogInterface, int i) {
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
        alertDialogBuilderForAppCompat.setMessage(getResources().getString(C9086R.string.can_not_add_to_note_while_translation_is_being_prepared));
        alertDialogBuilderForAppCompat.setPositiveButton(C9086R.string.f6715OK, new DialogInterfaceOnClickListenerC10231a(this, 0));
        return alertDialogBuilderForAppCompat.create();
    }
}
