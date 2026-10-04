package com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.composer.listener;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerImplContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.OnDragListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PwOnDragListenerImpl extends OnDragListenerImpl {
    public PwOnDragListenerImpl(ListenerImplContract.IPresenter iPresenter, ControllerManager controllerManager) {
        super(iPresenter, controllerManager);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.OnDragListenerImpl
    public boolean isEditableState() {
        return super.isEditableState() && this.mModeManager.isEditMode();
    }
}
