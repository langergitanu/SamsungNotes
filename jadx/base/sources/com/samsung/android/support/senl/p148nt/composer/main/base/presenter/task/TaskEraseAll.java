package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.Arrays;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskEraseAll extends Task<InputValues, ResultValues> {
    private static final String TAG = Logger.createTag("TaskEraseAll");
    private EraseAllHandler mHandler;
    private boolean mIsCanceled = false;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum DeleteType {
        ALL,
        SPECIFIC
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class EraseAllHandler extends Handler {
        static final int MESSAGE_ERASEALL_NEXT = 1;
        static final int MESSAGE_ERASEALL_START = 0;
        boolean mBeginHistory;
        private Task.Callback<ResultValues> mCallback;
        private DeleteType mDeleteType;
        private boolean mIsCanceled;
        private ObjectManager mObjectManager;
        private SpenWNote mSpenWNote;
        private Queue<Integer> mTargetPages;

        public /* synthetic */ EraseAllHandler(int i) {
            this();
        }

        private void removeAllObject(SpenWPage spenWPage) {
            spenWPage.removeObjects(1);
        }

        public void cancel() {
            this.mIsCanceled = true;
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            AbstractC8014b.m7195A(new StringBuilder("EraseAllHandler#handleMessage, what: "), TaskEraseAll.TAG, message.what);
            int i = message.what;
            if (i == 0) {
                if (this.mSpenWNote.getPageCount() <= 0) {
                    release();
                    return;
                }
                int iIntValue = 0;
                Logger.addFileLog(TaskEraseAll.TAG, "EraseAll: " + this.mDeleteType, 0);
                if (!this.mSpenWNote.isGroupingHistory()) {
                    this.mBeginHistory = true;
                    this.mSpenWNote.beginHistoryGroup();
                }
                if (this.mDeleteType == DeleteType.SPECIFIC) {
                    if (this.mTargetPages.isEmpty()) {
                        cancel();
                    } else {
                        iIntValue = this.mTargetPages.poll().intValue();
                    }
                }
                sendMessage(obtainMessage(1, Integer.valueOf(iIntValue)));
                return;
            }
            if (i != 1) {
                return;
            }
            int iIntValue2 = ((Integer) message.obj).intValue();
            AbstractC8014b.m7222x(AbstractC0541b.m778t(iIntValue2, "MESSAGE_ERASEALL_NEXT# index - ", ", mIsCanceled - "), this.mIsCanceled, TaskEraseAll.TAG);
            if (this.mIsCanceled || iIntValue2 >= this.mSpenWNote.getPageCount()) {
                if (this.mBeginHistory) {
                    this.mSpenWNote.endHistoryGroup();
                }
                release();
                return;
            }
            removeAllObject(this.mSpenWNote.getPage(iIntValue2));
            DeleteType deleteType = this.mDeleteType;
            if (deleteType == DeleteType.ALL) {
                iIntValue2++;
            } else if (deleteType == DeleteType.SPECIFIC) {
                if (this.mTargetPages.isEmpty()) {
                    cancel();
                } else {
                    iIntValue2 = this.mTargetPages.poll().intValue();
                }
            }
            sendMessage(obtainMessage(1, Integer.valueOf(iIntValue2)));
        }

        public void init(Task.Callback<ResultValues> callback, InputValues inputValues) {
            this.mCallback = callback;
            ObjectManager objectManager = inputValues.mObjectManager;
            this.mObjectManager = objectManager;
            this.mSpenWNote = objectManager.getNote();
            DeleteType deleteType = inputValues.mDeleteType;
            this.mDeleteType = deleteType;
            if (deleteType == DeleteType.SPECIFIC) {
                this.mTargetPages = inputValues.mTargetPages;
            }
        }

        public void release() {
            this.mCallback.onSuccess(new ResultValues());
        }

        private EraseAllHandler() {
            this.mBeginHistory = false;
            this.mIsCanceled = false;
            this.mDeleteType = DeleteType.ALL;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ResultValues implements Task.ResultValues {
    }

    private void notifyResultError() {
        if (getTaskCallback() != null) {
            if (this.mIsCanceled) {
                getTaskCallback().onSuccess(new ResultValues());
            } else {
                getTaskCallback().onError(new ResultValues());
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void cancel(Task.ICancelCallback iCancelCallback) {
        this.mIsCanceled = true;
        this.mHandler.cancel();
        Logger.m10999d(TAG, "cancel ");
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void clear() {
        Logger.m10999d(TAG, "clear ");
        this.mIsCanceled = true;
        this.mHandler.cancel();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean isAvailableToSave() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(InputValues inputValues) {
        Logger.m10999d(TAG, "executeTask#");
        this.mHandler = new EraseAllHandler(0);
        if (!inputValues.mObjectManager.isValidDoc()) {
            notifyResultError();
            return;
        }
        this.mHandler.init(getTaskCallback(), inputValues);
        EraseAllHandler eraseAllHandler = this.mHandler;
        eraseAllHandler.sendMessage(eraseAllHandler.obtainMessage(0));
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues implements Task.InputValues {
        private DeleteType mDeleteType;
        private ObjectManager mObjectManager;
        private Queue<Integer> mTargetPages;

        public InputValues(ObjectManager objectManager) {
            this.mDeleteType = DeleteType.ALL;
            this.mObjectManager = objectManager;
        }

        public InputValues(ObjectManager objectManager, Integer... numArr) {
            this.mDeleteType = DeleteType.SPECIFIC;
            this.mObjectManager = objectManager;
            this.mTargetPages = new ConcurrentLinkedQueue(Arrays.asList(numArr));
        }
    }
}
