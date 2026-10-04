package com.samsung.android.support.senl.p148nt.composer.main.base.view.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.C8875R;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSyncManager;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.stt.view.AiSTTListView;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SyncWaitingProgressDialog extends DialogFragment {
    public static final String TAG = Logger.createTag("handoff$SyncWaitingProgressDialog");
    private RequestSyncHandler mHandler;
    private DialogContract.ISyncWaitingProgressDialogPresenter mPresenter;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class RequestSyncHandler extends Handler {
        private static final int MSG_REQUEST_SYNC_PERIODIC = 3;
        private static final int MSG_REQUEST_SYNC_START = 2;
        private static final int REQUEST_SYNC_INTERVAL = 3000;
        private static final int REQUEST_SYNC_START = 5000;

        public /* synthetic */ RequestSyncHandler(SyncWaitingProgressDialog syncWaitingProgressDialog, int i) {
            this();
        }

        private void requestSyncForServerPolling(boolean z) {
            if (SyncWaitingProgressDialog.this.getPresenter() == null) {
                return;
            }
            if (SyncWaitingProgressDialog.this.getPresenter().canStopToSendRequestSyncMsg()) {
                Logger.m11003i(SyncWaitingProgressDialog.TAG, "requestSyncForServerPolling# stop");
                return;
            }
            if (z) {
                RequestToSyncManager.INSTANCE.requestSyncDownImmediately(SyncWaitingProgressDialog.this.mPresenter.getUuid());
            } else {
                RequestToSyncManager.INSTANCE.requestSyncForServerPolling();
            }
            sendEmptyMessageDelayed(3, AiSTTListView.USER_SCROLL_INTERVAL);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            AbstractC8014b.m7221w(new StringBuilder("handleMessage# "), SyncWaitingProgressDialog.TAG, message.what);
            int i = message.what;
            if (i == 2) {
                requestSyncForServerPolling(true);
            } else {
                if (i != 3) {
                    return;
                }
                requestSyncForServerPolling(false);
            }
        }

        public void sendRequestSyncMsg() {
            DialogContract.ISyncWaitingProgressDialogPresenter presenter = SyncWaitingProgressDialog.this.getPresenter();
            if (presenter == null) {
                return;
            }
            if (presenter.canStopToSendRequestSyncMsg()) {
                Logger.m11003i(SyncWaitingProgressDialog.TAG, "sendRequestSyncMsg# stop");
            } else {
                removeCallbacksAndMessages(null);
                sendEmptyMessageDelayed(2, 5000L);
            }
        }

        private RequestSyncHandler() {
        }
    }

    private void releaseHandler() {
        RequestSyncHandler requestSyncHandler = this.mHandler;
        if (requestSyncHandler != null) {
            requestSyncHandler.removeCallbacksAndMessages(null);
            this.mHandler = null;
        }
    }

    public DialogContract.ISyncWaitingProgressDialogPresenter getPresenter() {
        DialogContract.IFragmentPresenterContainer iFragmentPresenterContainer;
        if (this.mPresenter == null && getActivity() != null && (iFragmentPresenterContainer = (DialogContract.IFragmentPresenterContainer) getActivity().getSupportFragmentManager().findFragmentByTag("Composer")) != null) {
            this.mPresenter = (DialogContract.ISyncWaitingProgressDialogPresenter) iFragmentPresenterContainer.getDialogFragmentPresenter(10);
        }
        if (this.mPresenter == null) {
            Logger.m11000e(TAG, "getPresenter# Presenter is null. dismiss call");
            dismiss();
        }
        return this.mPresenter;
    }

    @Override // androidx.fragment.app.DialogFragment
    @NonNull
    public Dialog onCreateDialog(@Nullable Bundle bundle) {
        Logger.m10999d(TAG, "onCreateDialog# create");
        PostLaunchManager.getInstance().executeBaseLogic(301);
        View viewInflate = getActivity().getLayoutInflater().inflate(C8875R.layout.notes_progress_text_view, (ViewGroup) null);
        ((TextView) viewInflate.findViewById(C9086R.id.progress_text_view)).setText(C9086R.string.composer_synchronizing);
        AlertDialogBuilderForAppCompat alertDialogBuilderForAppCompat = new AlertDialogBuilderForAppCompat(getActivity());
        alertDialogBuilderForAppCompat.setNegativeButton(C9086R.string.composer_cancel, new DialogInterface.OnClickListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.SyncWaitingProgressDialog.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Logger.m11003i(SyncWaitingProgressDialog.TAG, "cancel#");
                DialogContract.ISyncWaitingProgressDialogPresenter presenter = SyncWaitingProgressDialog.this.getPresenter();
                if (presenter != null) {
                    presenter.cancel();
                }
            }
        });
        alertDialogBuilderForAppCompat.setView(viewInflate);
        AlertDialog alertDialogCreate = alertDialogBuilderForAppCompat.create();
        int i = 0;
        alertDialogCreate.setCanceledOnTouchOutside(false);
        alertDialogCreate.setCancelable(false);
        if (alertDialogCreate.getWindow() != null) {
            alertDialogCreate.getWindow().setGravity(17);
        }
        alertDialogCreate.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.view.dialog.SyncWaitingProgressDialog.2
            @Override // android.content.DialogInterface.OnKeyListener
            public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                if (keyEvent.getAction() != 1) {
                    return false;
                }
                if (keyEvent.getKeyCode() != 4 && keyEvent.getKeyCode() != 111) {
                    return false;
                }
                Logger.m11003i(SyncWaitingProgressDialog.TAG, "onKey# back key");
                DialogContract.ISyncWaitingProgressDialogPresenter presenter = SyncWaitingProgressDialog.this.getPresenter();
                if (presenter == null) {
                    return false;
                }
                presenter.cancel();
                return false;
            }
        });
        RequestSyncHandler requestSyncHandler = new RequestSyncHandler(this, i);
        this.mHandler = requestSyncHandler;
        requestSyncHandler.sendRequestSyncMsg();
        return alertDialogCreate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        releaseHandler();
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NonNull DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        DialogContract.ISyncWaitingProgressDialogPresenter presenter = getPresenter();
        if (presenter != null) {
            presenter.onDismiss();
        }
        releaseHandler();
    }

    public void setPresenter(DialogContract.ISyncWaitingProgressDialogPresenter iSyncWaitingProgressDialogPresenter) {
        this.mPresenter = iSyncWaitingProgressDialogPresenter;
    }
}
