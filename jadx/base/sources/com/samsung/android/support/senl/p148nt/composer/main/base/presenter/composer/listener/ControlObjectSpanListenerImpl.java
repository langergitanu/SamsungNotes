package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.DragAndDropController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerImplContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ControlObjectSpanListenerImpl extends ControlObjectListenerImpl {
    private static final String TAG = Logger.createTag("ControlObjectSpanListenerImpl");

    public ControlObjectSpanListenerImpl(ListenerImplContract.IPresenter iPresenter, ControllerManager controllerManager, DragAndDropController dragAndDropController) {
        super(iPresenter, controllerManager, dragAndDropController);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ControlObjectListenerImpl
    public String getTAG() {
        return TAG;
    }
}
