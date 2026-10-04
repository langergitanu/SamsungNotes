package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog;

import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SyncWaitingProgressDialogPresenter extends AbsDialogFragmentPresenter implements DialogContract.ISyncWaitingProgressDialogPresenter {
    private static final String TAG = Logger.createTag("handoff$SyncWaitingProgressDialogPresenter");
    private final ComposerViewPresenter mComposerViewPresenter;
    private final DialogContract.IDialogCreator mCreator;

    public SyncWaitingProgressDialogPresenter(DialogContract.IDialogCreator iDialogCreator, ComposerViewPresenter composerViewPresenter) {
        this.mCreator = iDialogCreator;
        this.mComposerViewPresenter = composerViewPresenter;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.ISyncWaitingProgressDialogPresenter
    public boolean canStopToSendRequestSyncMsg() {
        return this.mComposerViewPresenter.getComposerModel().isReloading();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.ISyncWaitingProgressDialogPresenter
    public void cancel() {
        this.mComposerViewPresenter.getHandoffManager().cancelWaitingSync();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.AbsDialogFragmentPresenter
    public DialogFragment findFragmentByTag(Activity activity) {
        return findFragmentByTag(activity, TAG);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.ISyncWaitingProgressDialogPresenter
    /* JADX INFO: renamed from: getUuid */
    public String get$uuid() {
        return this.mComposerViewPresenter.getComposerModel().getDocState().getUuid();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.AbsDialogFragmentPresenter
    public void hide() {
        Logger.m11003i(TAG, "handoff#hide#");
        super.hide();
    }

    public boolean isShowing() {
        return findFragmentByTag(this.mActivity) != null;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.ISyncWaitingProgressDialogPresenter, com.samsung.android.support.senl.nt.composer.main.base.presenter.dialog.DialogContract.IPresenter
    public void onDismiss() {
        this.mComposerViewPresenter.getHandoffManager().updateStateFromHandoff();
    }

    public void show() {
        Activity activity = this.mActivity;
        if (activity == null || activity.isFinishing() || this.mActivity.isDestroyed()) {
            Logger.m11004w(TAG, "handoff#show# " + this.mActivity);
            return;
        }
        if (isShowing()) {
            Logger.m11004w(TAG, "handoff#show# dialog is already showing");
            return;
        }
        String str = TAG;
        Logger.m11003i(str, "handoff#show#");
        DialogFragment dialogFragmentCreateSyncWaitingProgressDialogFragment = this.mCreator.createSyncWaitingProgressDialogFragment();
        FragmentManager childFragmentManager = ((AppCompatActivity) this.mActivity).getSupportFragmentManager().getFragments().get(0).getChildFragmentManager();
        childFragmentManager.beginTransaction().add(dialogFragmentCreateSyncWaitingProgressDialogFragment, str).commitAllowingStateLoss();
        childFragmentManager.executePendingTransactions();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.AbsDialogFragmentPresenter
    public DialogFragment findFragmentByTag(Activity activity, String str) {
        Activity activity2 = this.mActivity;
        if (activity2 == null) {
            return null;
        }
        return (DialogFragment) ((AppCompatActivity) activity2).getSupportFragmentManager().getFragments().get(0).getChildFragmentManager().findFragmentByTag(str);
    }
}
