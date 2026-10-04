package com.samsung.android.support.senl.p148nt.app.main.common.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentManager;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.base.common.samsunganalytices.CommonSamsungAnalytics;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class MoveConfirmDialogFragment extends ConfirmDialogFragment {
    private static final String TAG = "MoveConfirmDialogFragment";
    private String mMessage;

    public MoveConfirmDialogFragment() {
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.dialog.ConfirmDialogFragment, android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        super.onClick(dialogInterface, i);
        if (i == -1) {
            CommonSamsungAnalytics.insertLog("753", "7803");
        } else {
            CommonSamsungAnalytics.insertLog("753", "7802");
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.dialog.ConfirmDialogFragment, androidx.fragment.app.DialogFragment
    @NotNull
    public Dialog onCreateDialog(Bundle bundle) {
        if (bundle != null) {
            this.mPositiveResId = bundle.getInt("positiveResId");
            this.mNegativeResId = bundle.getInt("negativeResId");
            this.mMessage = bundle.getString("message");
            this.mFolderUuid = bundle.getString(NotesConstants.KEY_FOLDER_UUID);
        }
        AlertDialog alertDialogCreate = new AlertDialogBuilderForAppCompat(getActivity()).setMessage(this.mMessage).setCancelable(true).setPositiveButton(this.mPositiveResId, this).setNegativeButton(this.mNegativeResId, this).create();
        this.mAlertDialog = alertDialogCreate;
        return alertDialogCreate;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.dialog.ConfirmDialogFragment, com.samsung.android.support.senl.p148nt.base.winset.view.AbsDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        bundle.putInt("positiveResId", this.mPositiveResId);
        bundle.putInt("negativeResId", this.mNegativeResId);
        bundle.putString("message", this.mMessage);
        bundle.putString(NotesConstants.KEY_FOLDER_UUID, this.mFolderUuid);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.winset.view.AbsDialogFragment, androidx.fragment.app.DialogFragment
    public void show(@NonNull FragmentManager fragmentManager, @Nullable String str) {
        try {
            super.show(fragmentManager, str);
        } catch (IllegalStateException e) {
            MainLogger.m7255e(TAG, "show# can not show dialog because of " + e.getMessage());
        }
    }

    public MoveConfirmDialogFragment(String str, int i) {
        this.mMessage = str;
        this.mPositiveResId = i;
    }
}
