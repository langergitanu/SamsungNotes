package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.base.composer.drag.DragViewMaker;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.PdfManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.controller.ViewState;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.info.DragAndDropInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.TaskController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskCreationDropContent;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.StorageChecker;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class DragAndDropController {
    private static final String TAG = Logger.createTag("DragAndDropController");
    private Activity mActivity;
    private View mCompView;
    private final DragViewMaker mDragViewMaker;
    private final DragViewMakerContract mDragViewMakerContract;
    private final int mHashCode;
    private final ModeManager mModeManager;
    private final ObjectManager mObjectManager;
    private final PageManager mPageManager;
    private final PdfManager mPdfManager;
    private final ScrollController mScrollController;
    private final StorageChecker mStorageChecker;
    private final TaskController mTaskController;
    private final ViewState mViewState;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class DragViewMakerContract implements DragViewMaker.Contract {
        DragAndDropInfo mDragAndDropInfo;

        public DragViewMakerContract() {
        }

        @Override // com.samsung.android.support.senl.nt.base.composer.drag.DragViewMaker.Contract
        public float getScale() {
            return DragAndDropController.this.mScrollController.getScale();
        }

        @Override // com.samsung.android.support.senl.nt.base.composer.drag.DragViewMaker.Contract
        @NonNull
        public Bitmap getSelectedObjectBitmap() {
            return DragAndDropController.this.mObjectManager.getSelectedObjectBitmap();
        }

        public void setDragAndDropInfo(DragAndDropInfo dragAndDropInfo) {
            this.mDragAndDropInfo = dragAndDropInfo;
        }

        @Override // com.samsung.android.support.senl.nt.base.composer.drag.DragViewMaker.Contract
        public void setShadowSize(int i, int i2) {
            DragAndDropInfo dragAndDropInfo = this.mDragAndDropInfo;
            if (dragAndDropInfo != null) {
                dragAndDropInfo.setShadowViewWidth(i);
                this.mDragAndDropInfo.setShadowViewHeight(i2);
            }
        }
    }

    public DragAndDropController(Activity activity, View view, ObjectManager objectManager, PageManager pageManager, ModeManager modeManager, ScrollController scrollController, ControllerManager controllerManager, PdfManager pdfManager, int i) {
        this.mActivity = activity;
        this.mCompView = view;
        this.mObjectManager = objectManager;
        this.mPageManager = pageManager;
        this.mHashCode = i;
        this.mModeManager = modeManager;
        this.mScrollController = scrollController;
        this.mPdfManager = pdfManager;
        this.mTaskController = controllerManager.getTaskController();
        this.mStorageChecker = controllerManager.getStorageChecker();
        this.mViewState = controllerManager.getViewState();
        DragViewMakerContract dragViewMakerContract = new DragViewMakerContract();
        this.mDragViewMakerContract = dragViewMakerContract;
        this.mDragViewMaker = new DragViewMaker(TAG, view, dragViewMakerContract);
    }

    public boolean executeDragAndDrop(DragAndDropInfo dragAndDropInfo) {
        String str = TAG;
        Logger.m10999d(str, "onSelectedItemLongClicked#");
        if (this.mStorageChecker.checkAvailableStateToEdit(true, true) != 0 || !DeviceInfo.isSemDevice()) {
            return false;
        }
        if (isObjectLock()) {
            Logger.m10999d(str, "onSelectionAreaLongPressed# isObjectLock");
            return false;
        }
        if (this.mModeManager.isEditMode()) {
            ComposerSA.insertLog("401", ComposerSAConstants.EVENT_EDIT_SELECTION);
        } else {
            ComposerSA.insertLog("301", ComposerSAConstants.EVENT_VIEW_SELECTION);
        }
        this.mDragViewMakerContract.setDragAndDropInfo(dragAndDropInfo);
        this.mTaskController.execute(new TaskCreationDropContent(), new TaskCreationDropContent.InputValues(this.mActivity, this.mObjectManager, this.mPdfManager), new Task.Callback<TaskCreationDropContent.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.controller.DragAndDropController.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(TaskCreationDropContent.ResultValues resultValues) {
                resultValues.showErrorToast();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(TaskCreationDropContent.ResultValues resultValues) {
                if (DragAndDropController.this.mActivity == null || DragAndDropController.this.mActivity.isFinishing() || DragAndDropController.this.mActivity.isDestroyed()) {
                    Logger.m11000e(DragAndDropController.TAG, "onSelectionAreaLongPressed#onSuccess# activity is " + DragAndDropController.this.mActivity);
                    return;
                }
                if (!DragAndDropController.this.mViewState.isResumed()) {
                    Logger.m11000e(DragAndDropController.TAG, "onSelectionAreaLongPressed#onSuccess# activity is stopped");
                    return;
                }
                if (resultValues.getDropContent().contentList == null || resultValues.getDropContent().contentList.isEmpty()) {
                    Logger.m11000e(DragAndDropController.TAG, "onSelectionAreaLongPressed#DropContent is empty");
                    return;
                }
                if (DragAndDropController.this.mObjectManager.getPastePosition() == null) {
                    Logger.m11000e(DragAndDropController.TAG, "PastePosition is error");
                    return;
                }
                try {
                    DragAndDropController.this.mDragViewMaker.startDragAndDrop(DragAndDropController.this.mCompView, DragAndDropController.this.mDragViewMaker.createClipData(resultValues.getDropContent(), DragAndDropController.this.mHashCode, DragAndDropController.this.mPageManager.getDocPageInfo().getCurrentPageIndex(), DragAndDropController.this.mObjectManager.getPastePosition()), resultValues.getDropContent());
                } catch (Exception e) {
                    Logger.m11001e(DragAndDropController.TAG, e.getMessage(), e);
                }
            }
        }, false);
        return true;
    }

    public boolean isObjectLock() {
        List<SpenObjectBase> selectedObjectList = this.mObjectManager.getSelectedObjectList();
        if (selectedObjectList != null && !selectedObjectList.isEmpty()) {
            Iterator<SpenObjectBase> it = selectedObjectList.iterator();
            while (it.hasNext()) {
                if (it.next().getLockState()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void release() {
        this.mCompView = null;
        this.mActivity = null;
        this.mDragViewMaker.release();
    }
}
