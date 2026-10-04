package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener;

import android.app.Activity;
import android.content.res.Resources;
import com.samsung.android.sdk.composer.listener.SpenDialogActionListener;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.support.senl.p145cm.base.framework.feature.CscFeature;
import com.samsung.android.support.senl.p145cm.base.framework.view.WindowManagerCompat;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerImplContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SpenDialogActionListenerImpl extends SpenDialogActionListener {
    Activity mActivity;
    ListenerImplContract.IDialogPresenter mDialogManager;
    ModeManager mModeManager;
    SoftInputManager mSoftInputManager;

    public SpenDialogActionListenerImpl(ListenerImplContract.IPresenter iPresenter, ControllerManager controllerManager) {
        this.mActivity = iPresenter.getActivity();
        this.mSoftInputManager = controllerManager.getSoftInputManager();
        this.mDialogManager = iPresenter.getDialogPresenterManager();
        this.mModeManager = iPresenter.getComposerModel().getModeManager();
    }

    private void hideSoftInput() {
        if (WindowManagerCompat.getInstance().isMultiWindowMode(this.mActivity)) {
            this.mSoftInputManager.hide(false);
        }
    }

    @Override // com.samsung.android.sdk.composer.listener.SpenDialogActionListener
    public void onRequestShowCancelVoiceDialog() {
        hideSoftInput();
        this.mDialogManager.showConfirmCancelVoiceDialog();
    }

    @Override // com.samsung.android.sdk.composer.listener.SpenDialogActionListener
    public void onRequestShowConfirmRemoveDialog(SpenObjectBase spenObjectBase) {
        hideSoftInput();
        this.mDialogManager.showConfirmRemoveItemDialog(null, spenObjectBase);
    }

    @Override // com.samsung.android.sdk.composer.listener.SpenDialogActionListener
    public void onRequestShowDeviceNotSupportedDialog() {
        Resources resources;
        int i;
        if (this.mModeManager.isMode(Mode.ReadOnly)) {
            Activity activity = this.mActivity;
            int i2 = C9086R.string.composer_a_new_version_available_update_it_to_continue;
            if (CscFeature.INSTANCE.getInstance().isSecBrandAsGalaxy()) {
                resources = this.mActivity.getResources();
                i = C9086R.string.notes_jp;
            } else {
                resources = this.mActivity.getResources();
                i = C9086R.string.notes;
            }
            ToastHandler.show(activity, activity.getString(i2, resources.getString(i)), 1);
        }
    }

    @Override // com.samsung.android.sdk.composer.listener.SpenDialogActionListener
    public void onRequestShowNotEnoughSpaceDialog() {
        hideSoftInput();
        this.mDialogManager.showNotEnoughStorageDialog();
    }

    @Override // com.samsung.android.sdk.composer.listener.SpenDialogActionListener
    public void onRequestShowRemoveRecordingVoiceDialog() {
        hideSoftInput();
        this.mDialogManager.showConfirmRemoveRecordingDialog();
    }
}
