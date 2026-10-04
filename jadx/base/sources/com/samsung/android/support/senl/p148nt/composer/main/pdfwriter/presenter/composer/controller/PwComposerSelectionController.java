package com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.composer.controller;

import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerSelectionController;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PwComposerSelectionController extends ComposerSelectionController {
    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ComposerSelectionController
    public void clearSelectionInTextMode(boolean z) {
        super.clearSelectionInTextMode(z);
        if (z) {
            return;
        }
        this.mModeManager.setMode(Mode.Writing, "clearSelectionInTextMode", true);
    }
}
