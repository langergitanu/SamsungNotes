package com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.composer.listener;

import androidx.collection.AbstractC0622a;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.DragAndDropController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ControlObjectListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerImplContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PwControlObjectListenerImpl extends ControlObjectListenerImpl {
    private static final String TAG = Logger.createTag("PwControlObjectListenerImpl");

    public PwControlObjectListenerImpl(ListenerImplContract.IPresenter iPresenter, ControllerManager controllerManager, DragAndDropController dragAndDropController) {
        super(iPresenter, controllerManager, dragAndDropController);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ControlObjectListenerImpl, com.samsung.android.sdk.pen.control.SpenControlObjectListener
    public boolean onSelectedItemClicked(SpenObjectBase spenObjectBase) {
        if (spenObjectBase.getType() == 7 && this.mPresenter.getComposerModel().getModeManager().isMode(Mode.Writing)) {
            this.mPresenter.getComposerModel().getModeManager().setMode(Mode.Text, AbstractC0622a.m1170p(TAG, " onSelectedItemClicked#", new StringBuilder()), true);
        }
        return super.onSelectedItemClicked(spenObjectBase);
    }
}
