package com.samsung.android.support.senl.p148nt.app.common.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.base.winset.view.AbsDialogFragment;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class MeridianDialogFragment extends AbsDialogFragment {
    public static final String TAG = "MeridianDialogFragment";
    private DialogListener mDialogListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface DialogListener {
        void onCancel();

        void onConfirm();
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        View viewInflate = LayoutInflater.from(getContext()).inflate(C8003R.layout.meridian_dialog_fragment, (ViewGroup) null);
        AlertDialog alertDialogCreate = new AlertDialogBuilderForAppCompat(getContext()).create();
        alertDialogCreate.setView(viewInflate);
        alertDialogCreate.setTitle(C8003R.string.settings_sync_to_ms_sync_login_title);
        alertDialogCreate.setCancelable(true);
        alertDialogCreate.setCanceledOnTouchOutside(false);
        alertDialogCreate.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.samsung.android.support.senl.nt.app.common.dialog.MeridianDialogFragment.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() != 1) {
                    return false;
                }
                if ((keyEvent.getKeyCode() != 4 && keyEvent.getKeyCode() != 111) || MeridianDialogFragment.this.mDialogListener == null) {
                    return false;
                }
                MeridianDialogFragment.this.mDialogListener.onCancel();
                return false;
            }
        });
        viewInflate.findViewById(C8003R.id.negative_button).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.common.dialog.MeridianDialogFragment.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MeridianDialogFragment.this.dismiss();
                if (MeridianDialogFragment.this.mDialogListener != null) {
                    MeridianDialogFragment.this.mDialogListener.onCancel();
                }
            }
        });
        viewInflate.findViewById(C8003R.id.positive_button).setOnClickListener(new View.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.common.dialog.MeridianDialogFragment.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MeridianDialogFragment.this.dismiss();
                if (MeridianDialogFragment.this.mDialogListener != null) {
                    MeridianDialogFragment.this.mDialogListener.onConfirm();
                }
            }
        });
        return alertDialogCreate;
    }

    public void setDialogListener(DialogListener dialogListener) {
        this.mDialogListener = dialogListener;
    }
}
