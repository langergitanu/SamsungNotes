package com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.composer.controller;

import android.app.Activity;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerControllerContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerModeController;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.NavigationBarUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PwComposerModeController extends ComposerModeController {
    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerModeController
    public void setViewMode(ModeManager modeManager) {
        if (this.mView != null) {
            if (this.mComposerModel.getComposerState().isSecured()) {
                this.mView.setModeOfSpenComposerView(false, 4);
            } else {
                this.mView.setModeOfSpenComposerView(modeManager.isMode(Mode.View), 5);
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerModeController
    public void updateWritingModeState(ModeManager modeManager, Activity activity, ComposerModeController.HwToolbarContract hwToolbarContract) {
        ComposerControllerContract composerControllerContract = this.mView;
        if (composerControllerContract != null) {
            composerControllerContract.setEditModeType(2);
        }
        if (modeManager.getPrevMode() == Mode.Text) {
            this.mObjectManager.commitHistory();
        }
        this.mObjectManager.getSelectedObjectManager().clearSelectObject(true, false);
        if (hwToolbarContract != null) {
            hwToolbarContract.updateToolTypeAction();
        }
        this.mWritingToolManager.setToolTypeAction(6, 8);
        if (NavigationBarUtil.hideNavigationBar(activity)) {
            updateDisallowTouchDownArea(true, activity);
        }
    }
}
