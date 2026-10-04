package com.samsung.android.support.senl.p148nt.coedit.view;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.coedit.C8996R;
import com.samsung.android.support.senl.p148nt.coedit.log.CoeditLogger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CriticalErrorDialogFragment extends DialogFragment {
    public static final String TAG = "CriticalErrorDialogFragment";
    private Contract mContract;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        void onClickCloseComposer();

        void onClickSaveToDeviceBtn();
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        CoeditLogger.m8919d(TAG, "onCreateDialog#");
        boolean zIsTabletModel = DeviceUtils.isTabletModel();
        AlertDialog alertDialogCreate = new AlertDialogBuilderForAppCompat(getActivity()).setTitle(zIsTabletModel ? C8996R.string.co_edit_error_dialog_title_tablet : C8996R.string.co_edit_error_dialog_title_phone).setMessage(zIsTabletModel ? C8996R.string.co_edit_error_dialog_message_tablet : C8996R.string.co_edit_error_dialog_message_phone).setNegativeButton(C8996R.string.co_edit_error_dialog_button_cancel, new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.coedit.view.CriticalErrorDialogFragment.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (CriticalErrorDialogFragment.this.mContract != null) {
                    CriticalErrorDialogFragment.this.mContract.onClickCloseComposer();
                }
                CriticalErrorDialogFragment.this.dismissAllowingStateLoss();
            }
        }).setPositiveButton(C8996R.string.co_edit_error_dialog_button_save, new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.coedit.view.CriticalErrorDialogFragment.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (CriticalErrorDialogFragment.this.mContract != null) {
                    CriticalErrorDialogFragment.this.mContract.onClickSaveToDeviceBtn();
                }
                CriticalErrorDialogFragment.this.dismissAllowingStateLoss();
            }
        }).setCancelable(true).create();
        Window window = alertDialogCreate.getWindow();
        if (window != null) {
            window.setGravity(17);
        }
        return alertDialogCreate;
    }

    public void setContract(Contract contract) {
        this.mContract = contract;
    }

    public void showAllowingStateLoss(FragmentManager fragmentManager, String str) {
        if (fragmentManager == null || fragmentManager.isDestroyed()) {
            return;
        }
        fragmentManager.beginTransaction().add(this, str).commitAllowingStateLoss();
    }
}
