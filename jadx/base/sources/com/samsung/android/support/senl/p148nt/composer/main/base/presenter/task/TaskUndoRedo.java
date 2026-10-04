package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import android.os.Handler;
import android.os.Message;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskUndoRedo extends Task<InputValues, ResultValues> {
    public static final int REDO = 2;
    private static final String TAG = Logger.createTag("TaskUndoRedo");
    public static final int UNDO = 1;
    private UndoRedoHandler mHandler;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues implements Task.InputValues {
        private SpenWNote mNote;
        private ObjectManager mObjectManager;
        private int mType;
        private UndoRedoStartEndListener mUndoRedoStartEndListener;

        public InputValues(SpenWNote spenWNote, int i, UndoRedoStartEndListener undoRedoStartEndListener, ObjectManager objectManager) {
            this.mNote = spenWNote;
            this.mType = i;
            this.mUndoRedoStartEndListener = undoRedoStartEndListener;
            this.mObjectManager = objectManager;
        }

        public SpenWNote getDoc() {
            return this.mNote;
        }

        public int getType() {
            return this.mType;
        }

        public UndoRedoStartEndListener getUndoRedoStartEndListener() {
            return this.mUndoRedoStartEndListener;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ResultValues implements Task.ResultValues {
        private int mError;

        public ResultValues(int i) {
            this.mError = i;
        }

        public int getError() {
            return this.mError;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class UndoRedoHandler extends Handler {
        static final int MESSAGE_UNDO_REDO_EXECUTE = 1;
        private static final String TAG = Logger.createTag("UndoRedoHandler");
        private Task.Callback<ResultValues> mCallback;
        private int mError = 0;
        private SpenWNote mNote;
        private ObjectManager mObjectManager;
        private int mType;
        private UndoRedoStartEndListener mUndoRedoStartEndListener;

        public UndoRedoHandler(Task.Callback<ResultValues> callback, SpenWNote spenWNote, int i, UndoRedoStartEndListener undoRedoStartEndListener, ObjectManager objectManager) {
            this.mCallback = callback;
            this.mNote = spenWNote;
            this.mType = i;
            this.mUndoRedoStartEndListener = undoRedoStartEndListener;
            this.mObjectManager = objectManager;
        }

        private String messageToString(int i) {
            return i != 1 ? AbstractC0000a.m11h(i, "message: ") : "MESSAGE_UNDO_REDO_EXECUTE";
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x004d  */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void handleMessage(Message message) {
            int redoStatus;
            super.handleMessage(message);
            String str = TAG;
            AbstractC8014b.m7213o(new StringBuilder("UndoRedoHandler#handleMessage, what: "), messageToString(message.what), str);
            if (message.what != 1) {
                return;
            }
            if (!isValidDoc()) {
                redoStatus = -1;
            } else if (this.mType == 1) {
                if (this.mNote.isUndoable()) {
                    this.mNote.undo();
                    redoStatus = this.mNote.getUndoStatus();
                }
            } else if (this.mNote.isRedoable()) {
                this.mNote.redo();
                redoStatus = this.mNote.getRedoStatus();
            }
            AbstractC0000a.m3D(redoStatus, "MESSAGE_UNDO_REDO_EXECUTE# result - ", str);
            if (redoStatus == 3 || redoStatus == 7) {
                sendMessage(obtainMessage(1));
                return;
            }
            if (redoStatus == 2 || redoStatus == 6) {
                TaskUndoRedo.updateRtToolbar(this.mObjectManager);
                release();
            } else {
                this.mError = redoStatus;
                release();
            }
        }

        public boolean isValidDoc() {
            SpenWNote spenWNote = this.mNote;
            return (spenWNote == null || spenWNote.isClosed()) ? false : true;
        }

        public void release() {
            Logger.m10999d(TAG, "UndoRedoHandler#release");
            removeCallbacksAndMessages(null);
            this.mUndoRedoStartEndListener.finished();
            Task.Callback<ResultValues> callback = this.mCallback;
            if (callback != null) {
                int i = this.mError;
                if (i == 0) {
                    callback.onSuccess(new ResultValues(0));
                } else {
                    callback.onError(new ResultValues(i));
                }
            }
            this.mNote = null;
            this.mCallback = null;
        }

        public void setError(int i) {
            this.mError = i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface UndoRedoStartEndListener {
        void finished();

        void started();
    }

    public static void updateRtToolbar(ObjectManager objectManager) {
        if (objectManager.isFocusedTextBox()) {
            objectManager.getTextManager().updateRichTextState();
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void clear() {
        UndoRedoHandler undoRedoHandler = this.mHandler;
        if (undoRedoHandler != null) {
            undoRedoHandler.release();
            this.mHandler = null;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean isAvailableToSave() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean isKeepTaskDuringActivityRecreation() {
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(InputValues inputValues) {
        Logger.m10999d(TAG, "executeTask#");
        inputValues.getUndoRedoStartEndListener().started();
        UndoRedoHandler undoRedoHandler = new UndoRedoHandler(getTaskCallback(), inputValues.getDoc(), inputValues.getType(), inputValues.getUndoRedoStartEndListener(), inputValues.mObjectManager);
        this.mHandler = undoRedoHandler;
        undoRedoHandler.sendMessageDelayed(undoRedoHandler.obtainMessage(1), 100L);
    }
}
