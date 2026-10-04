package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.textspan.SpenIndentLevelParagraph;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.Indent;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import p258y.AbstractC14516b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskIndent extends Task<InputValues, ResultValues> {
    private static final String TAG = Logger.createTag("TaskIndent");
    private IndentHandler mHandler;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class IndentHandler extends Handler {
        private static final int INDENT_PROCESS_SIZE = 50;
        static final int MESSAGE_INDENT_NEXT = 1;
        static final int MESSAGE_INDENT_START = 0;
        private Task.Callback<ResultValues> mCallback;
        private InputValues mInputValues;
        private final int mListEnd;
        private int mListIndex;

        public IndentHandler(Task.Callback<ResultValues> callback, InputValues inputValues) {
            this.mInputValues = inputValues;
            this.mCallback = callback;
            int[] iArr = inputValues.mParagraphIndex;
            int i = iArr[1];
            this.mListEnd = i;
            this.mListIndex = iArr[0];
            Logger.m11003i(TaskIndent.TAG, "IndentHandler# start : " + this.mListIndex + " end : " + i);
        }

        private void applyIndent() {
            int i = this.mListIndex;
            int iMin = Math.min(i + 50, this.mListEnd);
            this.mListIndex = iMin;
            AbstractC14516b.m15114b(i, iMin, "applyIndent from ", " to ", TaskIndent.TAG);
            InputValues inputValues = this.mInputValues;
            inputValues.mIndent.appendIndentParagraph(new int[]{i, iMin}, inputValues.mSpenObjectShape, inputValues.mIsPlus, inputValues.mDirection, inputValues.mIndentParagraphArray);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            AbstractC8014b.m7195A(new StringBuilder("IndentHandler#handleMessage, what: "), TaskIndent.TAG, message.what);
            int i = message.what;
            if (i == 0) {
                applyIndent();
                sendMessage(obtainMessage(1));
            } else {
                if (i != 1) {
                    return;
                }
                if (this.mListIndex == this.mListEnd) {
                    release();
                } else {
                    applyIndent();
                    sendMessage(obtainMessage(1));
                }
            }
        }

        public void release() {
            removeCallbacksAndMessages(null);
            Task.Callback<ResultValues> callback = this.mCallback;
            if (callback != null) {
                callback.onSuccess(new ResultValues());
                this.mCallback = null;
            }
            if (this.mInputValues != null) {
                this.mInputValues = null;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues implements Task.InputValues {
        int mDirection;
        Indent mIndent;
        SpenIndentLevelParagraph[] mIndentParagraphArray;
        boolean mIsPlus;
        int[] mParagraphIndex;
        SpenObjectShape mSpenObjectShape;

        public InputValues(Indent indent, int[] iArr, SpenObjectShape spenObjectShape, boolean z) {
            this.mIndent = indent;
            this.mParagraphIndex = iArr;
            this.mSpenObjectShape = spenObjectShape;
            this.mIsPlus = z;
            this.mDirection = LocaleUtils.isRTLMode() ? 2 : 1;
            this.mIndentParagraphArray = this.mIndent.getSpenIndentLevelParagraphs(iArr, spenObjectShape);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ResultValues implements Task.ResultValues {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void clear() {
        IndentHandler indentHandler = this.mHandler;
        if (indentHandler != null) {
            indentHandler.release();
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
        IndentHandler indentHandler = new IndentHandler(getTaskCallback(), inputValues);
        this.mHandler = indentHandler;
        indentHandler.sendMessage(indentHandler.obtainMessage(0));
    }
}
