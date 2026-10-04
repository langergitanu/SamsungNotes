package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.handoff;

import android.app.Activity;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.C8416h;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.common.ModelManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.CvPageSettingController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ScrollController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.handoff.HandoffManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class EmptyHandoffManager extends HandoffManager {
    public EmptyHandoffManager(ScrollController scrollController) {
        super(scrollController, new C8416h(5));
        setDisabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$new$0() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.handoff.HandoffManager
    public void cancelWaitingSync() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.handoff.HandoffManager
    public void disableHandoffTemporary() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.handoff.HandoffManager
    public HandoffHandler getHandler() {
        return super.getHandler();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.handoff.HandoffManager
    public void init(Activity activity, SpenWNote spenWNote) {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.handoff.HandoffManager
    public boolean isDisabled() {
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.handoff.HandoffManager
    public void release() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.handoff.HandoffManager
    public void sendHandoffData() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.handoff.HandoffManager
    public void updatePendingStateFromHandoff() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.handoff.HandoffManager
    public void updateStateFromHandoff() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.handoff.HandoffManager
    public void init(Activity activity, ControllerManager controllerManager, ComposerModel composerModel, ModelManager modelManager, HandoffManager.IDialogManager iDialogManager, CvPageSettingController cvPageSettingController) {
    }
}
