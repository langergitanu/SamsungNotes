package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.action;

import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.ToolShareControl;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.MenuPresenterContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ActionReadonlyMode extends AbsAction {
    private static final String TAG = Logger.createTag("ActionReadonlyMode");
    private final ComposerViewPresenter mComposerViewPresenter;
    private final MenuPresenterContract.IMenuManager mMenuManager;
    private final ModeManager mModeManager;
    private ToolShareControl mToolShareControl;

    public ActionReadonlyMode(ComposerViewPresenter composerViewPresenter, MenuPresenterContract.IMenuManager iMenuManager) {
        this.mComposerViewPresenter = composerViewPresenter;
        this.mModeManager = composerViewPresenter.getComposerModel().getModeManager();
        this.mMenuManager = iMenuManager;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.action.AbsAction
    public boolean doAction(String str) {
        String str2 = TAG;
        Logger.m11003i(str2, "doAction# ");
        if (!this.mModeManager.isEditModeWithReadOnly()) {
            return false;
        }
        boolean z = this.mComposerViewPresenter.canUseLaserPenMode() && this.mComposerViewPresenter.getWritingToolManager().getToolTypeAction(2) == 18;
        ModeManager modeManager = this.mModeManager;
        Mode mode = Mode.ReadOnly;
        if (modeManager.isMode(mode)) {
            Mode prevMode = this.mModeManager.getPrevMode();
            if (prevMode == Mode.Search) {
                prevMode = this.mModeManager.getLastEditMode();
            }
            if (z && prevMode == Mode.Text) {
                prevMode = Mode.Writing;
            }
            Mode mode2 = Mode.Text;
            if (prevMode == mode2) {
                this.mComposerViewPresenter.getNoteManager().setCursorOnScreen(this.mComposerViewPresenter.getPageManager().getDocPageInfo().getCurrentPageIndex());
            }
            this.mModeManager.setMode(prevMode, str2 + str, true);
            if (z && this.mComposerViewPresenter.getComposerModel().getModeManager().isMode(Mode.Writing)) {
                this.mComposerViewPresenter.getComposerModel().getComposerState().setLaserPenMode(z);
                this.mMenuManager.onEvent(13);
                return true;
            }
            this.mComposerViewPresenter.getComposerModel().getComposerState().setLaserPenMode(false);
            ToolShareControl toolShareControl = this.mToolShareControl;
            if (toolShareControl != null) {
                if (prevMode == mode2) {
                    toolShareControl.changeTextMode();
                } else {
                    toolShareControl.changeHwMode();
                }
            }
        } else {
            this.mComposerViewPresenter.getComposerModel().getComposerState().setLaserPenMode(z);
            this.mComposerViewPresenter.getTextManager().clearSelection();
            this.mComposerViewPresenter.getWritingToolManager().cancel();
            this.mModeManager.setMode(mode, str2 + str, true);
            this.mComposerViewPresenter.getComposerModel().saveCacheAndRequestCollect();
            ToolShareControl toolShareControl2 = this.mToolShareControl;
            if (toolShareControl2 != null) {
                toolShareControl2.changeReadMode();
            }
        }
        this.mMenuManager.invalidateOptionsMenu();
        return true;
    }

    public void setToolShareControl(ToolShareControl toolShareControl) {
        this.mToolShareControl = toolShareControl;
    }
}
