package com.samsung.android.support.senl.p148nt.app.lock.view.verify;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.lock.utils.LockLogger;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class VerifyMultiAccountDialogFragment extends DialogFragment {
    private ResultListener mResultListener;
    public static final String TAG = "VerifyMultiAccountDialogFragment";
    private static final String LOG_TAG = LockLogger.createTag(TAG);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ResultListener {
        void onResult(boolean z);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        Context context = getContext();
        AlertDialog alertDialogCreate = new AlertDialogBuilderForAppCompat(context).create();
        alertDialogCreate.setMessage(context.getString(C8003R.string.lock_multiple_accounts_verify_dialog_message));
        alertDialogCreate.setButton(-1, context.getString(C8003R.string.button_sign_in), new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.lock.view.verify.VerifyMultiAccountDialogFragment.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (VerifyMultiAccountDialogFragment.this.mResultListener != null) {
                    VerifyMultiAccountDialogFragment.this.mResultListener.onResult(true);
                }
            }
        });
        alertDialogCreate.setButton(-2, context.getString(C8003R.string.dialog_cancel), new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.lock.view.verify.VerifyMultiAccountDialogFragment.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                VerifyMultiAccountDialogFragment.this.dismiss();
            }
        });
        alertDialogCreate.setCancelable(false);
        alertDialogCreate.setCanceledOnTouchOutside(false);
        return alertDialogCreate;
    }

    public void setOnResultListener(ResultListener resultListener) {
        this.mResultListener = resultListener;
    }
}
