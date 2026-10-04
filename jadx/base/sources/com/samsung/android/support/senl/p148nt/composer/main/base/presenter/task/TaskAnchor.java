package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.textspan.SpenObjectSpan;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.composer.text.common.TextUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectSpanHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.common.TaskContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskAnchor extends SingleThreadTask<InputValues, ResultValues> {
    private static final int ANCHOR_OBJECT_SIZE = 50;
    private static final String TAG = Logger.createTag("TaskAnchor");
    private AnchorHandler mHandler;
    private boolean mIsCursorBlinkEnabled;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class AnchorHandler extends Handler {
        static final int MESSAGE_ANCHOR_EXECUTE = 2;
        static final int MESSAGE_POST_EXECUTE = 4;
        static final int MESSAGE_PRE_EXECUTE = 1;
        static final int MESSAGE_REMOVE_ANCHOR_EXECUTE = 3;
        private static final String TAG = Logger.createTag("AnchorHandler");
        private List<SpenObjectBase> mAnchorObjectList;
        private List<SpenObjectSpan> mAnchorObjectSpanList;
        private List<SpenWPage> mAnchorPageList;
        private Task.Callback<ResultValues> mCallback;
        private boolean mIsAnchorToText;
        private ObjectManager mObjectManager;
        private SpenWNote mSpenWNote;
        private SpenObjectShape mTextBox;
        private TextManager mTextManager;
        private PointF mCursorPosition = new PointF();
        private boolean mBeginHistory = false;
        private int mStartObjectIndex = 0;
        private int mObjectCount = 0;

        public AnchorHandler(InputValues inputValues, Task.Callback<ResultValues> callback) {
            this.mObjectManager = inputValues.mObjectManager;
            this.mTextManager = inputValues.mTextManager;
            this.mAnchorObjectList = inputValues.mAnchorObjectList;
            this.mAnchorPageList = inputValues.mAnchorPageList;
            this.mIsAnchorToText = inputValues.mIsAnchorToText;
            this.mCallback = callback;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            String str = TAG;
            AbstractC8014b.m7221w(new StringBuilder("AnchorHandler#handleMessage, what: "), str, message.what);
            int i = message.what;
            if (i == 1) {
                SpenWNote note = this.mObjectManager.getNote();
                this.mSpenWNote = note;
                this.mTextBox = note.getBodyText();
                if (!this.mSpenWNote.isGroupingHistory()) {
                    this.mBeginHistory = true;
                    this.mSpenWNote.beginHistoryGroup();
                }
                this.mStartObjectIndex = 0;
                if (this.mIsAnchorToText) {
                    this.mObjectCount = this.mAnchorObjectList.size();
                    sendMessage(obtainMessage(2));
                    return;
                } else {
                    this.mObjectCount = this.mAnchorObjectSpanList.size();
                    sendMessage(obtainMessage(3));
                    return;
                }
            }
            int i2 = 50;
            if (i == 2) {
                StringBuilder sb = new StringBuilder("AnchorHandler#handleMessage, MESSAGE_ANCHOR_EXECUTE# index:");
                sb.append(this.mStartObjectIndex);
                sb.append(", count:");
                AbstractC8014b.m7195A(sb, str, this.mObjectCount);
                int i4 = this.mObjectCount;
                if (i4 > 50) {
                    sendMessage(obtainMessage(2));
                } else {
                    sendMessage(obtainMessage(4));
                    i2 = i4;
                }
                int i5 = this.mStartObjectIndex;
                while (true) {
                    int i6 = this.mStartObjectIndex;
                    if (i5 >= i6 + i2) {
                        this.mStartObjectIndex = i6 + i2;
                        this.mObjectCount -= i2;
                        return;
                    }
                    SpenObjectBase spenObjectBase = this.mAnchorObjectList.get(i5);
                    SpenWPage spenWPage = this.mAnchorPageList.get(i5);
                    RectF rect = spenObjectBase.getRect();
                    this.mCursorPosition.set(spenWPage.getOffset().x + rect.left, spenWPage.getOffset().y + rect.top);
                    TextUtil.insertLineFeed(this.mTextBox, this.mTextManager.getLineCountFromBodyTextBottom(this.mCursorPosition));
                    int cursorIndexToInsertIntoBodyText = this.mTextManager.getCursorIndexToInsertIntoBodyText(this.mCursorPosition);
                    this.mTextBox.setCursorPosition(cursorIndexToInsertIntoBodyText);
                    this.mSpenWNote.transferObject(spenObjectBase, cursorIndexToInsertIntoBodyText);
                    i5++;
                }
            } else {
                if (i != 3) {
                    if (i != 4) {
                        return;
                    }
                    release();
                    return;
                }
                AbstractC8014b.m7195A(new StringBuilder("AnchorHandler#handleMessage, MESSAGE_REMOVE_ANCHOR_EXECUTE# count:"), str, this.mObjectCount);
                int i7 = this.mObjectCount;
                if (i7 > 50) {
                    sendMessage(obtainMessage(3));
                } else {
                    sendMessage(obtainMessage(4));
                    i2 = i7;
                }
                int i8 = this.mObjectCount - 1;
                while (true) {
                    int i9 = this.mObjectCount;
                    if (i8 < i9 - i2) {
                        this.mObjectCount = i9 - i2;
                        return;
                    }
                    SpenObjectSpan spenObjectSpan = this.mAnchorObjectSpanList.get(i8);
                    SpenWPage page = this.mSpenWNote.getPage(spenObjectSpan.getObject().getPageIndex());
                    if (page != null) {
                        this.mSpenWNote.transferObject(spenObjectSpan.getTextIndex(), page);
                    }
                    i8--;
                }
            }
        }

        public void release() {
            Logger.m10999d(TAG, "AnchorHandler#release");
            removeCallbacksAndMessages(null);
            Task.Callback<ResultValues> callback = this.mCallback;
            if (callback != null) {
                callback.onSuccess(new ResultValues());
                this.mCallback = null;
            }
            if (this.mBeginHistory) {
                this.mSpenWNote.endHistoryGroup();
                this.mBeginHistory = false;
            }
        }

        public void setAnchorObjectSpanList(List<SpenObjectSpan> list) {
            this.mAnchorObjectSpanList = list;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ResultValues implements Task.ResultValues {
    }

    private List<SpenObjectSpan> findSelectedObjectSpanFromObjectSelection(ObjectManager objectManager) {
        return new ObjectSpanHelper(objectManager.getNote()).findObjectSpan(objectManager.getSelectedObjectList());
    }

    private List<SpenObjectSpan> findSelectedObjectSpanFromTextSelection(TextManager textManager, int[] iArr) {
        ArrayList<SpenObjectSpan> arrayListFindObjectSpan = textManager.getTextBox().findObjectSpan(iArr[0], iArr[1]);
        Collections.sort(arrayListFindObjectSpan, new Comparator<SpenObjectSpan>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskAnchor.2
            @Override // java.util.Comparator
            public int compare(SpenObjectSpan spenObjectSpan, SpenObjectSpan spenObjectSpan2) {
                return spenObjectSpan.getTextIndex() - spenObjectSpan2.getTextIndex();
            }
        });
        return arrayListFindObjectSpan;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<SpenObjectSpan> getAnchorObjectSpanList(InputValues inputValues) {
        if (inputValues.mCursor == null) {
            return findSelectedObjectSpanFromObjectSelection(inputValues.mObjectManager);
        }
        inputValues.mTextManager.updateBodyObjectSpanPosition(inputValues.mCursor[0], inputValues.mCursor[1] - inputValues.mCursor[0]);
        inputValues.mTextManager.getTextBox().setCursorPosition(inputValues.mCursor[0]);
        return findSelectedObjectSpanFromTextSelection(inputValues.mTextManager, inputValues.mCursor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.SingleThreadTask, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void clear() {
        AnchorHandler anchorHandler = this.mHandler;
        if (anchorHandler != null) {
            anchorHandler.release();
            this.mHandler = null;
        }
        ((InputValues) getInputValue()).mAutoScrollContract.setAutoScrollEnabled(true);
        ((InputValues) getInputValue()).mTextManager.setCursorBlink(this.mIsCursorBlinkEnabled);
        super.clear();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean isAvailableToSave() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean isAvailableToUpdate() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(final InputValues inputValues) {
        inputValues.mAutoScrollContract.setAutoScrollEnabled(false);
        this.mIsCursorBlinkEnabled = inputValues.mTextManager.isCursorBlinking();
        inputValues.mTextManager.setCursorBlink(false);
        this.mHandler = new AnchorHandler(inputValues, getTaskCallback());
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
        this.mExecutorService = executorServiceNewSingleThreadExecutor;
        executorServiceNewSingleThreadExecutor.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskAnchor.1
            @Override // java.lang.Runnable
            public void run() {
                Logger.m10999d(TaskAnchor.TAG, "executeTask#");
                if (!inputValues.mIsAnchorToText) {
                    TaskAnchor.this.mHandler.setAnchorObjectSpanList(TaskAnchor.this.getAnchorObjectSpanList(inputValues));
                }
                TaskAnchor.this.mHandler.sendMessage(TaskAnchor.this.mHandler.obtainMessage(1));
            }
        });
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues implements Task.InputValues {
        private List<SpenObjectBase> mAnchorObjectList;
        private List<SpenWPage> mAnchorPageList;
        private TaskContract.AutoScrollContract mAutoScrollContract;
        private int[] mCursor;
        private boolean mIsAnchorToText = true;
        private ObjectManager mObjectManager;
        private TextManager mTextManager;

        public InputValues(ObjectManager objectManager, TextManager textManager, TaskContract.AutoScrollContract autoScrollContract, List<SpenObjectBase> list, List<SpenWPage> list2) {
            this.mObjectManager = objectManager;
            this.mTextManager = textManager;
            this.mAutoScrollContract = autoScrollContract;
            this.mAnchorObjectList = list;
            this.mAnchorPageList = list2;
        }

        public InputValues(ObjectManager objectManager, TextManager textManager, TaskContract.AutoScrollContract autoScrollContract, int[] iArr) {
            this.mObjectManager = objectManager;
            this.mTextManager = textManager;
            this.mAutoScrollContract = autoScrollContract;
            this.mCursor = iArr;
        }
    }
}
