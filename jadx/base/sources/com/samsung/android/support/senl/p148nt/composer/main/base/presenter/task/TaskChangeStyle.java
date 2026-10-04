package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.SpenSettingUIChangeStyleInfo;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.pen.SpenPenUtil;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.WritingToolManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskChangeStyle extends SingleThreadTask<InputValues, ResultValues> {
    private static final String TAG = Logger.createTag("TaskChangeStyle");
    private ChangeStyleHandler mHandler;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ChangeStyleHandler extends Handler {
        private static final int CHANGE_STYLE_FIRST_OBJECT_SIZE = 10;
        private static final int CHANGE_STYLE_SECOND_OBJECT_SIZE = 200;
        static final int MESSAGE_CHANGE_STYLE_NEXT = 1;
        static final int MESSAGE_CHANGE_STYLE_START = 0;
        private Task.Callback<ResultValues> mCallback;
        private InputValues mInputValues;
        private int mListCount;
        private int mListIndex;
        private int mNoteHeight;
        private int mNoteWidth;

        public /* synthetic */ ChangeStyleHandler(int i) {
            this();
        }

        private void changeStyle(int i) {
            while (this.mListIndex < this.mListCount) {
                Context context = this.mInputValues.mContext;
                List list = this.mInputValues.mSpenObjectBaseList;
                int i2 = this.mListIndex;
                this.mListIndex = i2 + 1;
                SpenPenUtil.changeStyle(context, (SpenObjectBase) list.get(i2), this.mInputValues.mChangeStyleInfo, this.mNoteWidth, this.mNoteHeight);
                if (this.mListIndex % i == 0) {
                    return;
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            AbstractC8014b.m7195A(new StringBuilder("ChangeStyleHandler#handleMessage, what: "), TaskChangeStyle.TAG, message.what);
            int i = message.what;
            if (i == 0) {
                changeStyle(10);
                sendMessage(obtainMessage(1));
            } else {
                if (i != 1) {
                    return;
                }
                if (this.mListIndex >= this.mListCount) {
                    release();
                } else {
                    changeStyle(200);
                    sendMessage(obtainMessage(1));
                }
            }
        }

        public void init(Task.Callback<ResultValues> callback, InputValues inputValues) {
            this.mInputValues = inputValues;
            this.mCallback = callback;
            this.mNoteWidth = inputValues.mWritingToolManager.getWNoteWidth();
            this.mNoteHeight = this.mInputValues.mWritingToolManager.getWNoteHeight();
            this.mListCount = this.mInputValues.mSpenObjectBaseList.size();
            this.mListIndex = 0;
            AbstractC8014b.m7195A(new StringBuilder("ChangeStyleHandler# List size : "), TaskChangeStyle.TAG, this.mListCount);
        }

        public void release() {
            removeCallbacksAndMessages(null);
            Task.Callback<ResultValues> callback = this.mCallback;
            if (callback != null) {
                callback.onSuccess(new ResultValues());
                this.mCallback = null;
            }
            InputValues inputValues = this.mInputValues;
            if (inputValues != null) {
                inputValues.mWritingToolManager.commitHistory();
                this.mInputValues.mWritingToolManager.clearSelection();
                this.mInputValues = null;
            }
        }

        private ChangeStyleHandler() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues implements Task.InputValues {
        private final SpenSettingUIChangeStyleInfo mChangeStyleInfo;
        private final Context mContext;
        private final ObjectManager mObjectManager;
        private final List<SpenObjectBase> mSpenObjectBaseList;
        private final WritingToolManager mWritingToolManager;

        public InputValues(Context context, WritingToolManager writingToolManager, ObjectManager objectManager, SpenSettingUIChangeStyleInfo spenSettingUIChangeStyleInfo) {
            this.mContext = context;
            this.mObjectManager = objectManager;
            this.mWritingToolManager = writingToolManager;
            this.mSpenObjectBaseList = writingToolManager.getSelectedStrokeList();
            this.mChangeStyleInfo = spenSettingUIChangeStyleInfo;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ResultValues implements Task.ResultValues {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.SingleThreadTask, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void clear() {
        ChangeStyleHandler changeStyleHandler = this.mHandler;
        if (changeStyleHandler != null) {
            changeStyleHandler.release();
            this.mHandler = null;
        }
        super.clear();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean isAvailableToSave() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(InputValues inputValues) {
        Logger.m11003i(TAG, "executeTask#");
        ChangeStyleHandler changeStyleHandler = new ChangeStyleHandler(0);
        this.mHandler = changeStyleHandler;
        changeStyleHandler.init(getTaskCallback(), inputValues);
        ChangeStyleHandler changeStyleHandler2 = this.mHandler;
        changeStyleHandler2.sendMessage(changeStyleHandler2.obtainMessage(0));
    }
}
