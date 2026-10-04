package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller;

import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ComposerVoiceController {
    private ComposerModel mComposerModel;
    private ComposerControllerContract mView;

    public void init(ComposerModel composerModel) {
        this.mComposerModel = composerModel;
    }

    public void restoreVoiceSyncPlayAutoScroll() {
        if (this.mComposerModel.getVoiceModel().isPlayingVoiceData()) {
            if (this.mComposerModel.getModeManager().isMode(Mode.View) || this.mComposerModel.getModeManager().isMode(Mode.ReadOnly)) {
                setVoiceSyncPlayAutoScroll(true);
            }
        }
    }

    public void setView(ComposerControllerContract composerControllerContract) {
        this.mView = composerControllerContract;
    }

    public void setVoiceSyncPlayAutoScroll(boolean z) {
        ComposerControllerContract composerControllerContract = this.mView;
        if (composerControllerContract != null) {
            composerControllerContract.setVoiceSyncPlayAutoScroll(z);
        }
    }

    public void setVoiceSyncPlayEnabled(boolean z) {
        ComposerControllerContract composerControllerContract = this.mView;
        if (composerControllerContract != null) {
            composerControllerContract.setVoiceSyncPlayEnabled(z);
        }
    }
}
