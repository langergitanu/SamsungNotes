package com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.composer.listener;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerImplContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenConvertToTextListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ProgressController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.TaskController;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PwSpenConvertToTextListenerImpl extends SpenConvertToTextListenerImpl {
    public PwSpenConvertToTextListenerImpl(ListenerImplContract.IPresenter iPresenter, TaskController taskController, ProgressController progressController, SoftInputManager softInputManager) {
        super(iPresenter, taskController, progressController, softInputManager);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.SpenConvertToTextListenerImpl
    public int getInsertType() {
        return 0;
    }
}
