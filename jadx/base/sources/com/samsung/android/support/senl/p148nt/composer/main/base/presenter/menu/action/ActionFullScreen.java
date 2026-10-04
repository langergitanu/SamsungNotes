package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.action;

import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.MenuPresenterContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ActionFullScreen extends AbsAction {
    private static final String TAG = Logger.createTag("ActionFullScreen");
    private final ComposerViewPresenter mComposerViewPresenter;
    private final MenuPresenterContract.IMenuManager mMenuManager;
    private final ModeManager mModeManager;

    public ActionFullScreen(ComposerViewPresenter composerViewPresenter, MenuPresenterContract.IMenuManager iMenuManager) {
        this.mComposerViewPresenter = composerViewPresenter;
        this.mModeManager = composerViewPresenter.getComposerModel().getModeManager();
        this.mMenuManager = iMenuManager;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.action.AbsAction
    public boolean doAction(String str) {
        AbstractC8014b.m7197C("doAction# ", str, TAG);
        if (!this.mModeManager.isEditModeWithReadOnly() && !this.mModeManager.isMode(Mode.View)) {
            return true;
        }
        this.mMenuManager.onEvent(5);
        this.mComposerViewPresenter.setFullScreenModeOn();
        return true;
    }
}
