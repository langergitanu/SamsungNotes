package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller;

import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ComposerViewModeOnlyController extends ComposerModeController {
    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerModeController
    public void setViewMode(ModeManager modeManager) {
        ComposerControllerContract composerControllerContract = this.mView;
        if (composerControllerContract != null) {
            composerControllerContract.setModeOfSpenComposerView(modeManager.isMode(Mode.View), 4);
        }
    }
}
