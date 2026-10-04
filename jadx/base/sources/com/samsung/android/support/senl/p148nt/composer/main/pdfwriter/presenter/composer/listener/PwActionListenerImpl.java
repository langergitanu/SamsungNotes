package com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.composer.listener;

import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ActionListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ContextMenuListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerImplContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PwActionListenerImpl extends ActionListenerImpl {
    private static final String TAG = Logger.createTag("PwActionListenerImpl");

    public PwActionListenerImpl(ListenerImplContract.IView iView, ListenerImplContract.IPresenter iPresenter, ControllerManager controllerManager, ContextMenuListenerImpl contextMenuListenerImpl) {
        super(iView, iPresenter, controllerManager, contextMenuListenerImpl);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ActionListenerImpl, com.samsung.android.sdk.composer.listener.SpenComposerActionListener
    public void onEditModeChanged(int i) {
        if (i == 1 || i == 2) {
            Mode mode = Mode.Writing;
            if (i == 1 && this.mPresenter.getObjectManager().isSelectedTextBox()) {
                mode = Mode.Text;
            }
            this.mModeManager.setMode(mode, AbstractC0622a.m1170p(TAG, " onEditModeChanged#", new StringBuilder()), true);
        }
    }
}
