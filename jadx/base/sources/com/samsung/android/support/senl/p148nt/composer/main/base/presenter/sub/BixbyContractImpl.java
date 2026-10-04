package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.sub;

import android.app.Activity;
import android.content.Intent;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.bixby.BixbyContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.MenuPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class BixbyContractImpl implements BixbyContract {
    private static final String TAG = Logger.createTag("BixbyContractImpl");
    private final BaseSubManager mSubManager;

    public BixbyContractImpl(BaseSubManager baseSubManager) {
        this.mSubManager = baseSubManager;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.bixby.BixbyContract
    public void executeActionSendTask(Intent intent) {
        Activity activity = this.mSubManager.getComposerLifeState().getActivity();
        ComposerViewPresenter compViewPresenter = this.mSubManager.getCompViewPresenter();
        ModeManager modeManager = this.mSubManager.getComposerModel().getModeManager();
        if (modeManager.isEditMode()) {
            modeManager.setMode(Mode.View, "bixby action send", true);
            modeManager.setMode(modeManager.getPrevMode(), "bixby action send", true);
        } else {
            modeManager.setMode(Mode.Text, "bixby action send", true);
        }
        new EntryAction().executeTaskActionSend(intent, activity, this.mSubManager.getComposerLifeState().getFragment(), compViewPresenter, this.mSubManager.getControllerManager(), this.mSubManager.getDialogPresenterManager(), false);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.bixby.BixbyContract
    public Activity getActivity() {
        return this.mSubManager.getComposerLifeState().getActivity();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.bixby.BixbyContract
    public MenuPresenterManager getMenuManager() {
        return this.mSubManager.getMenuPresenterManager();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.bixby.BixbyContract
    public ModeManager getModeManger() {
        return this.mSubManager.getComposerModel().getModeManager();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.bixby.BixbyContract
    public void setEditModeFromBixby() {
        Logger.m10999d(TAG, "setEditModeFromBixby# ");
        this.mSubManager.getComposerModel().getModeManager().setMode(Mode.Text, "set edit mode from bixby", true);
    }
}
