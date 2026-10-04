package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.textspan.SpenIndentLevelParagraph;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p148nt.base.composer.text.span.Indent;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskIndentThread extends SingleThreadTask<InputValues, Task.ResultValues> {
    private static final String TAG = Logger.createTag("TaskIndentThread");

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

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(final InputValues inputValues) {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
        this.mExecutorService = executorServiceNewSingleThreadExecutor;
        executorServiceNewSingleThreadExecutor.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskIndentThread.1
            @Override // java.lang.Runnable
            public void run() {
                InputValues inputValues2 = inputValues;
                inputValues2.mIndent.appendIndentParagraph(inputValues2.mParagraphIndex, inputValues2.mSpenObjectShape, inputValues2.mIsPlus, inputValues2.mDirection, inputValues2.mIndentParagraphArray);
                TaskIndentThread.this.notifyCallback(true, null);
            }
        });
    }
}
