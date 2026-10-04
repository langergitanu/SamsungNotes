package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import android.os.Handler;
import android.os.Message;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.NoteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskDeletePages extends SingleThreadTask<InputValues, ResultValues> {
    private static final int DELETE_PAGE_SIZE = 10;
    private static final String TAG = Logger.createTag("TaskDeletePages");
    private DeletePagesHandler mHandler;
    private boolean mIsUseThread = false;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DeletePagesHandler extends Handler {
        static final int MESSAGE_DELETE_PAGE_EXECUTE = 2;
        static final int MESSAGE_POST_EXECUTE = 3;
        static final int MESSAGE_PRE_EXECUTE = 1;
        private static final String TAG = Logger.createTag("DeletePagesHandler");
        private Task.Callback<ResultValues> mCallback;
        private InputValues mInputValues;
        private int mPageStartIndex = 0;
        private int mPageCount = 0;
        private List<Integer> mSrcDeletedPageIdList = new ArrayList();
        private List<String> mReultDeletedPageIdList = new ArrayList();

        public DeletePagesHandler(InputValues inputValues, Task.Callback<ResultValues> callback) {
            this.mInputValues = inputValues;
            this.mCallback = callback;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            AbstractC8014b.m7221w(new StringBuilder("DeletePagesHandler#handleMessage, what: "), TAG, message.what);
            int i = message.what;
            boolean z = true;
            if (i == 1) {
                this.mPageStartIndex = 0;
                ArrayList arrayList = new ArrayList(this.mInputValues.mDeletePageList);
                this.mSrcDeletedPageIdList = arrayList;
                Collections.sort(arrayList, new Comparator<Integer>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskDeletePages.DeletePagesHandler.1
                    @Override // java.util.Comparator
                    public int compare(Integer num, Integer num2) {
                        return num2.intValue() - num.intValue();
                    }
                });
                this.mPageCount = this.mSrcDeletedPageIdList.size();
                sendMessage(obtainMessage(2));
                return;
            }
            if (i != 2) {
                if (i != 3) {
                    return;
                }
                if (this.mInputValues.mNoteManager.getNote().getPageCount() > 1) {
                    this.mInputValues.mNoteManager.updateDummyPage();
                }
                release();
                return;
            }
            int i2 = this.mPageCount;
            if (i2 > 10) {
                sendMessage(obtainMessage(2));
                z = false;
                i2 = 10;
            } else {
                sendMessage(obtainMessage(3));
            }
            ArrayList arrayList2 = new ArrayList();
            for (int i4 = this.mPageStartIndex; i4 < this.mPageStartIndex + i2; i4++) {
                arrayList2.add(this.mSrcDeletedPageIdList.get(i4));
            }
            this.mReultDeletedPageIdList.addAll(this.mInputValues.mNoteManager.deletePageList(arrayList2, z, false));
            this.mPageStartIndex += i2;
            this.mPageCount -= i2;
        }

        public void release() {
            Logger.m10999d(TAG, "DeletePagesHandler#release");
            removeCallbacksAndMessages(null);
            Task.Callback<ResultValues> callback = this.mCallback;
            if (callback != null) {
                callback.onSuccess(new ResultValues(this.mInputValues.mPageManager, this.mInputValues.mNoteManager, this.mInputValues.mDeletePageList, this.mReultDeletedPageIdList, this.mInputValues.mNeedToCallEndHistory));
            }
            this.mInputValues = null;
            this.mCallback = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues implements Task.InputValues {
        private List<Integer> mDeletePageList;
        private boolean mNeedToCallEndHistory;
        private NoteManager mNoteManager;
        private PageManager mPageManager;

        public InputValues(PageManager pageManager, NoteManager noteManager, List<Integer> list, boolean z) {
            this.mPageManager = pageManager;
            this.mNoteManager = noteManager;
            this.mDeletePageList = list;
            this.mNeedToCallEndHistory = z;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ResultValues implements Task.ResultValues {
        private List<String> mDeletedPageIdList;
        private List<Integer> mDeletedPageList;
        private boolean mNeedToCallEndHistory;
        private NoteManager mNoteManager;
        private PageManager mPageManager;

        public ResultValues(PageManager pageManager, NoteManager noteManager, List<Integer> list, List<String> list2, boolean z) {
            this.mPageManager = pageManager;
            this.mNoteManager = noteManager;
            this.mDeletedPageList = list;
            this.mDeletedPageIdList = list2;
            this.mNeedToCallEndHistory = z;
        }

        public List<String> getDeletedPageIdList() {
            return this.mDeletedPageIdList;
        }

        public List<Integer> getDeletedPageIndexList() {
            return this.mDeletedPageList;
        }

        public NoteManager getNoteManager() {
            return this.mNoteManager;
        }

        public PageManager getPageManager() {
            return this.mPageManager;
        }

        public boolean isNeededToCallEndHistory() {
            return this.mNeedToCallEndHistory;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.SingleThreadTask, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void clear() {
        DeletePagesHandler deletePagesHandler = this.mHandler;
        if (deletePagesHandler != null) {
            deletePagesHandler.release();
        }
        super.clear();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean isAvailableToSave() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean isAvailableToUpdate() {
        return (this.mHandler.hasMessages(1) || this.mHandler.hasMessages(2) || this.mHandler.hasMessages(3)) ? false : true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(final InputValues inputValues) {
        if (this.mIsUseThread) {
            ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
            this.mExecutorService = executorServiceNewSingleThreadExecutor;
            executorServiceNewSingleThreadExecutor.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskDeletePages.1
                @Override // java.lang.Runnable
                public void run() {
                    Logger.m10999d(TaskDeletePages.TAG, "executeTask#");
                    TaskDeletePages.this.getTaskCallback().onSuccess(new ResultValues(inputValues.mPageManager, inputValues.mNoteManager, inputValues.mDeletePageList, inputValues.mNoteManager.deletePageList(inputValues.mDeletePageList, true), inputValues.mNeedToCallEndHistory));
                }
            });
        } else {
            DeletePagesHandler deletePagesHandler = new DeletePagesHandler(inputValues, getTaskCallback());
            this.mHandler = deletePagesHandler;
            deletePagesHandler.sendMessage(deletePagesHandler.obtainMessage(1));
        }
    }
}
