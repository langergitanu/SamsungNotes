package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener;

import com.samsung.android.support.senl.p148nt.composer.main.base.model.info.DragAndDropInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.DragAndDropController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerImplContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SpenNotePdfActionListenerImpl {
    private static final String TAG = Logger.createTag("SpenNotePdfActionListenerImpl");
    private final DragAndDropController mDragAndDropController;
    private DragAndDropInfo mDragAndDropInfo;

    public SpenNotePdfActionListenerImpl(ListenerImplContract.IPresenter iPresenter, ControllerManager controllerManager, DragAndDropController dragAndDropController) {
        this.mDragAndDropController = dragAndDropController;
    }

    public void onSelectionAreaLongPressed() {
        if (this.mDragAndDropController == null || this.mDragAndDropInfo == null) {
            Logger.m10999d(TAG, "onSelectionAreaLongPressed# Ignored by invalid status.");
        } else {
            Logger.m10999d(TAG, "onSelectionAreaLongPressed# ");
            this.mDragAndDropController.executeDragAndDrop(this.mDragAndDropInfo);
        }
    }

    public void setDragAndDropInfo(DragAndDropInfo dragAndDropInfo) {
        this.mDragAndDropInfo = dragAndDropInfo;
    }
}
