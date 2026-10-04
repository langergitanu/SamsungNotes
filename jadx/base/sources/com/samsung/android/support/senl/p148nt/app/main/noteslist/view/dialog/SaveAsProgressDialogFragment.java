package com.samsung.android.support.senl.p148nt.app.main.noteslist.view.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTaskManager;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.task.ShareTask;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class SaveAsProgressDialogFragment extends DialogFragment {
    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        View viewInflate = getLayoutInflater().inflate(C8003R.layout.notes_progress_text_view, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(C8003R.id.progress_text_view);
        if (textView != null) {
            textView.setText(C8003R.string.document_service_notification_name_saving);
        }
        AlertDialog alertDialogCreate = new AlertDialogBuilderForAppCompat(getActivity()).create();
        alertDialogCreate.setCanceledOnTouchOutside(false);
        alertDialogCreate.setView(viewInflate);
        alertDialogCreate.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.samsung.android.support.senl.nt.app.main.noteslist.view.dialog.SaveAsProgressDialogFragment.1
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
                if (SaveAsProgressDialogFragment.this.getParentFragment() != null && i == 4 && keyEvent.getAction() == 1) {
                    WorkerTaskManager.getInstance().cancelRunningTask(ShareTask.TAG, SaveAsProgressDialogFragment.this.getParentFragment().getActivity().hashCode());
                }
                return false;
            }
        });
        return alertDialogCreate;
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
