package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer;

import com.samsung.android.sdk.composer.voice.VoiceManager;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.ToolShareControl;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.WritingToolManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller.ThumbnailUpdateHandler;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.QuickSaveTimerController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.TaskController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.AiDrawingUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskUndoRedo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class UndoRedoPresenter {
    private static final String TAG = Logger.createTag("UndoRedoPresenter");
    private final ComposerModel mComposerModel;
    private final ObjectManager mObjectManager;
    private final QuickSaveTimerController mQuickSaveTimerController;
    private final TaskController mTaskController;
    private ThumbnailUpdateHandler mThumbnailUpdateHandler;
    ToolShareControl mToolShareControl;
    private final TaskUndoRedo.UndoRedoStartEndListener mUndoRedoStartEndListener;
    private final WritingToolManager mWritingToolManager;

    public UndoRedoPresenter(ObjectManager objectManager, TaskController taskController, QuickSaveTimerController quickSaveTimerController, final ThumbnailUpdateHandler thumbnailUpdateHandler, WritingToolManager writingToolManager, ComposerModel composerModel) {
        this.mObjectManager = objectManager;
        this.mTaskController = taskController;
        this.mQuickSaveTimerController = quickSaveTimerController;
        this.mThumbnailUpdateHandler = thumbnailUpdateHandler;
        this.mWritingToolManager = writingToolManager;
        this.mComposerModel = composerModel;
        this.mUndoRedoStartEndListener = new TaskUndoRedo.UndoRedoStartEndListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.UndoRedoPresenter.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskUndoRedo.UndoRedoStartEndListener
            public void finished() {
                UndoRedoPresenter.this.mQuickSaveTimerController.unLock("undoredo end");
                thumbnailUpdateHandler.setBlockToUpdate(false);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskUndoRedo.UndoRedoStartEndListener
            public void started() {
                UndoRedoPresenter.this.mQuickSaveTimerController.lock("undoredo start");
                thumbnailUpdateHandler.setBlockToUpdate(true, true);
            }
        };
    }

    private boolean readyUndoRedo() {
        if (VoiceManager.isRecordingActivated() && this.mObjectManager.getNote().isObjectInUndo(VoiceManager.getObjectVoice())) {
            Logger.m10999d(TAG, "readyUndoRedo call stopRecording");
            VoiceManager.stopRecording();
            return false;
        }
        if (VoiceManager.isPlaying() && this.mObjectManager.getNote().isObjectInUndo(VoiceManager.getObjectVoice())) {
            Logger.m10999d(TAG, "readyUndoRedo call stopPlaying");
            VoiceManager.stopPlaying();
        }
        if (!this.mTaskController.isRunning()) {
            return true;
        }
        Logger.m10999d(TAG, "TaskController is running");
        return false;
    }

    public boolean isRedoable() {
        ToolShareControl toolShareControl = this.mToolShareControl;
        return (toolShareControl == null || !toolShareControl.getEnabled()) ? this.mObjectManager.getNote().isRedoable() && !AiDrawingUtil.isPopupShowingState(this.mComposerModel.getAiDrawingState()) : this.mToolShareControl.isRedoable();
    }

    public boolean isTaskRunning() {
        return this.mTaskController.isRunning();
    }

    public boolean isUndoable() {
        ToolShareControl toolShareControl = this.mToolShareControl;
        return (toolShareControl == null || !toolShareControl.getEnabled()) ? this.mObjectManager.getNote().isUndoable() : this.mToolShareControl.isUndoable();
    }

    public void redo() {
        ToolShareControl toolShareControl = this.mToolShareControl;
        if (toolShareControl != null && toolShareControl.getEnabled()) {
            this.mToolShareControl.redo();
            return;
        }
        if (readyUndoRedo() && isRedoable()) {
            String str = TAG;
            Logger.addFileLog(str, "redo", 8);
            this.mObjectManager.getSelectedObjectManager().closeObjectControlExceptTextBox();
            this.mWritingToolManager.clearControl();
            if (this.mObjectManager.getNote().isRedoHeavy()) {
                Logger.m10999d(str, "isRedoHeavy true redo");
                this.mTaskController.execute(new TaskUndoRedo(), new TaskUndoRedo.InputValues(this.mObjectManager.getNote(), 2, this.mUndoRedoStartEndListener, this.mObjectManager), null, false, 0, false);
                return;
            }
            this.mUndoRedoStartEndListener.started();
            this.mObjectManager.getNote().redo();
            if (this.mObjectManager.getNote().getRedoStatus() == 7) {
                this.mTaskController.execute(new TaskUndoRedo(), new TaskUndoRedo.InputValues(this.mObjectManager.getNote(), 2, this.mUndoRedoStartEndListener, this.mObjectManager), null, false);
                return;
            }
            TaskUndoRedo.updateRtToolbar(this.mObjectManager);
            this.mQuickSaveTimerController.reset("redo");
            this.mUndoRedoStartEndListener.finished();
        }
    }

    public void setToolShareControl(ToolShareControl toolShareControl) {
        this.mToolShareControl = toolShareControl;
    }

    public void undo() {
        ToolShareControl toolShareControl = this.mToolShareControl;
        if (toolShareControl != null && toolShareControl.getEnabled()) {
            this.mToolShareControl.undo();
            return;
        }
        if (readyUndoRedo() && isUndoable()) {
            String str = TAG;
            Logger.addFileLog(str, "undo", 8);
            this.mObjectManager.getSelectedObjectManager().closeObjectControlExceptTextBox();
            this.mWritingToolManager.clearControl();
            if (this.mObjectManager.getNote().isUndoHeavy()) {
                Logger.m10999d(str, "isUndoHeavy true undo");
                this.mTaskController.execute(new TaskUndoRedo(), new TaskUndoRedo.InputValues(this.mObjectManager.getNote(), 1, this.mUndoRedoStartEndListener, this.mObjectManager), null, false, 0, false);
                return;
            }
            this.mThumbnailUpdateHandler.setBlockToUpdate(true, true);
            this.mObjectManager.getNote().undo();
            if (this.mObjectManager.getNote().getUndoStatus() == 3) {
                this.mTaskController.execute(new TaskUndoRedo(), new TaskUndoRedo.InputValues(this.mObjectManager.getNote(), 1, this.mUndoRedoStartEndListener, this.mObjectManager), null, false);
                return;
            }
            TaskUndoRedo.updateRtToolbar(this.mObjectManager);
            this.mQuickSaveTimerController.reset("undo");
            this.mThumbnailUpdateHandler.setBlockToUpdate(false);
        }
    }
}
