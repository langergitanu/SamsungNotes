package com.samsung.android.support.senl.p148nt.app.main.invitation.View.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class InvitationJoinDialogFragment extends DialogFragment {
    private static final String KEY_ADAPTER_POSITION = "adapter_position";
    private static final String KEY_GROUP_ID = "group_id";
    public static final String TAG = "InvitationJoinDialogFragment";
    private int mAdapterPosition;
    private String mGroupId;
    private IInvitationJoinDialogResultListener mResultListener;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IInvitationJoinDialogResultListener {
        void onAccept(int i, String str);

        void onDecline(int i, String str);
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        if (bundle != null) {
            this.mGroupId = bundle.getString("group_id");
            this.mAdapterPosition = bundle.getInt(KEY_ADAPTER_POSITION);
        }
        AlertDialog alertDialogCreate = new AlertDialogBuilderForAppCompat(getActivity()).setNegativeButton(C8003R.string.gcs_invitations_join_dialog_decline, new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.invitation.View.dialog.InvitationJoinDialogFragment.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (InvitationJoinDialogFragment.this.mResultListener != null) {
                    InvitationJoinDialogFragment.this.mResultListener.onDecline(InvitationJoinDialogFragment.this.mAdapterPosition, InvitationJoinDialogFragment.this.mGroupId);
                }
            }
        }).setPositiveButton(C8003R.string.gcs_invitations_join_dialog_accept, new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.app.main.invitation.View.dialog.InvitationJoinDialogFragment.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (InvitationJoinDialogFragment.this.mResultListener != null) {
                    InvitationJoinDialogFragment.this.mResultListener.onAccept(InvitationJoinDialogFragment.this.mAdapterPosition, InvitationJoinDialogFragment.this.mGroupId);
                }
            }
        }).create();
        alertDialogCreate.setCancelable(true);
        alertDialogCreate.setCanceledOnTouchOutside(true);
        alertDialogCreate.setTitle(getString(C8003R.string.gcs_invitations_join_dialog_title, getString(C8003R.string.shared_notebooks)));
        alertDialogCreate.setMessage(getString(C8003R.string.gcs_invitations_join_dialog_message));
        return alertDialogCreate;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NonNull DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("group_id", this.mGroupId);
        bundle.putInt(KEY_ADAPTER_POSITION, this.mAdapterPosition);
    }

    public void setGroupId(int i, String str) {
        this.mAdapterPosition = i;
        this.mGroupId = str;
    }

    public void setOnResultListener(IInvitationJoinDialogResultListener iInvitationJoinDialogResultListener) {
        this.mResultListener = iInvitationJoinDialogResultListener;
    }

    public void showAllowingStateLoss(FragmentManager fragmentManager, String str) {
        if (fragmentManager == null || fragmentManager.isDestroyed()) {
            return;
        }
        FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
        fragmentTransactionBeginTransaction.add(this, str);
        fragmentTransactionBeginTransaction.commitAllowingStateLoss();
    }
}
