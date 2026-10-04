package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.action;

import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ActionInputForm extends AbsAction {
    private static final String TAG = Logger.createTag("ActionInputForm");
    private final ComposerViewPresenter mComposerViewPresenter;
    private final ModeManager mModeManager;

    public ActionInputForm(ComposerViewPresenter composerViewPresenter) {
        this.mComposerViewPresenter = composerViewPresenter;
        this.mModeManager = composerViewPresenter.getComposerModel().getModeManager();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.action.AbsAction
    public boolean doAction(String str) {
        Logger.m11003i(TAG, "doAction# ");
        boolean zIsInputFormMode = this.mModeManager.isInputFormMode();
        this.mModeManager.setInputFormMode(!zIsInputFormMode);
        if (!zIsInputFormMode) {
            return true;
        }
        this.mComposerViewPresenter.getWritingToolManager().clearSelection();
        this.mComposerViewPresenter.getHWToolbarPresenter().getSettingInstance().reloadHwToolbarState();
        return true;
    }
}
