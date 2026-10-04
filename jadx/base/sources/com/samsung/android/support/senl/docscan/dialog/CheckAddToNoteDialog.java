package com.samsung.android.support.senl.docscan.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import com.samsung.android.support.senl.docscan.C7976R;
import com.samsung.android.support.senl.docscan.common.Logger;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u00012\u00020\u0002:\u0002\u0016\u0017B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\u0018\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u0016R\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/dialog/CheckAddToNoteDialog;", "Landroidx/fragment/app/DialogFragment;", "Landroid/content/DialogInterface$OnClickListener;", "scanDataCount", "", "contract", "Lcom/samsung/android/support/senl/docscan/dialog/CheckAddToNoteDialog$Contract;", "<init>", "(ILcom/samsung/android/support/senl/docscan/dialog/CheckAddToNoteDialog$Contract;)V", "mScanDataCount", "mContract", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", NotesConstants.DialogTag.ON_SAVE_INSTANCE_STATE, "", "outState", "onClick", "dialog", "Landroid/content/DialogInterface;", "which", "Contract", "Companion", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class CheckAddToNoteDialog extends DialogFragment implements DialogInterface.OnClickListener {

    @NotNull
    private static final String KEY_SCAN_DATA_COUNT = "key_scan_data_count";

    @NotNull
    public static final String TAG = "CheckAddToNoteDialog";

    @Nullable
    private Contract mContract;
    private int mScanDataCount;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/support/senl/docscan/dialog/CheckAddToNoteDialog$Contract;", "", "onPositiveButtonClicked", "", "onNeutralButtonClicked", "docscan_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {
        void onNeutralButtonClicked();

        void onPositiveButtonClicked();
    }

    public CheckAddToNoteDialog(int i, @Nullable Contract contract) {
        this.mScanDataCount = i;
        this.mContract = contract;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(@NotNull DialogInterface dialog, int which) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        Contract contract = this.mContract;
        if (contract == null) {
            return;
        }
        if (which == -2) {
            Intrinsics.checkNotNull(contract);
            contract.onNeutralButtonClicked();
        } else if (which == -1) {
            Intrinsics.checkNotNull(contract);
            contract.onPositiveButtonClicked();
        } else {
            Logger.m7146e(TAG, "unexpected button type: " + which);
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            this.mScanDataCount = savedInstanceState.getInt(KEY_SCAN_DATA_COUNT);
        }
        AlertDialog alertDialogCreate = new AlertDialogBuilderForAppCompat(getContext(), 0, 2, null).setMessage(this.mScanDataCount > 1 ? C7976R.string.add_these_scans_to_your_note_or_discard_them_q : C7976R.string.add_this_scan_to_your_note_or_discard_it_q).setNeutralButton(C7976R.string.action_cancel, (DialogInterface.OnClickListener) null).setNegativeButton(C7976R.string.action_discard, this).setPositiveButton(C7976R.string.action_add, this).create();
        Intrinsics.checkNotNullExpressionValue(alertDialogCreate, "create(...)");
        return alertDialogCreate;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_SCAN_DATA_COUNT, this.mScanDataCount);
    }
}
