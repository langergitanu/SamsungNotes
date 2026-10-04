package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.action;

import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.MenuPresenterContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ActionPageList extends AbsAction {
    private static final String TAG = Logger.createTag("ActionPageList");
    private final ComposerViewPresenter mComposerViewPresenter;
    private final ControllerManager mControllerManager;
    private final MenuPresenterContract.IMenuManager mMenuManager;
    private final ModeManager mModeManager;

    public ActionPageList(ComposerViewPresenter composerViewPresenter, ControllerManager controllerManager, MenuPresenterContract.IMenuManager iMenuManager) {
        this.mComposerViewPresenter = composerViewPresenter;
        this.mModeManager = composerViewPresenter.getComposerModel().getModeManager();
        this.mControllerManager = controllerManager;
        this.mMenuManager = iMenuManager;
    }

    private void clearSelection() {
        this.mComposerViewPresenter.setContextMenu(false);
        this.mComposerViewPresenter.getObjectManager().clearSelection();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.action.AbsAction
    public boolean doAction(String str) {
        AbstractC8014b.m7197C("doAction# ", str, TAG);
        if (this.mComposerViewPresenter.getComposerModel().isSingleMode()) {
            return false;
        }
        if (!this.mModeManager.isEditModeWithReadOnly() && !this.mModeManager.isMode(Mode.View)) {
            return false;
        }
        clearSelection();
        this.mControllerManager.getClipboardController().closeClipboard();
        this.mMenuManager.onEvent(this.mComposerViewPresenter.getComposerModel().isTabletLayout() ? 3 : 4);
        return true;
    }
}
