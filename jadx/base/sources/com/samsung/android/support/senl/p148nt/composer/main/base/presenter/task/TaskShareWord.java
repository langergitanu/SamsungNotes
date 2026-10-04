package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import android.text.TextUtils;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskShareCommon;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskShareWord extends TaskShareCommon<TaskShareCommon.InputValues, TaskShareCommon.ResultValues> {
    private static final String TAG = Logger.createTag("TaskShareWord");

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskShareCommon
    public String getLogTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(final TaskShareCommon.InputValues inputValues) {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
        this.mExecutorService = executorServiceNewSingleThreadExecutor;
        executorServiceNewSingleThreadExecutor.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskShareWord.1
            @Override // java.lang.Runnable
            public void run() {
                TaskShareWord taskShareWord;
                TaskShareCommon.ResultValues resultValues = new TaskShareCommon.ResultValues(inputValues.getContext());
                boolean z = false;
                try {
                    try {
                        SpenWNote note = inputValues.getShareWNote().getNote();
                        if (TextUtils.isEmpty(inputValues.getDestPath())) {
                            TaskShareWord.this.mShareToOtherAppHandler.shareWord(inputValues.getContext(), note, inputValues.getShareData(), 0);
                        } else {
                            String strMakeMsWord = TaskShareWord.this.mShareToOtherAppHandler.getMakeUriHelper().makeMsWord(inputValues.getContext(), note, inputValues.getShareData().getPath(), inputValues.getDestPath());
                            resultValues = (TextUtils.isEmpty(strMakeMsWord) || !new File(strMakeMsWord).exists()) ? new TaskShareCommon.ResultValues(inputValues.getContext()) : new TaskShareCommon.ResultValues(inputValues.getContext(), strMakeMsWord, null);
                        }
                        inputValues.getShareWNote().close(inputValues.getShareData().getPath());
                        taskShareWord = TaskShareWord.this;
                        z = true;
                    } catch (Exception e) {
                        Logger.m11001e(TaskShareWord.TAG, "executeTask# " + e.getMessage(), e);
                        inputValues.getShareWNote().close(inputValues.getShareData().getPath());
                        taskShareWord = TaskShareWord.this;
                    }
                    taskShareWord.notifyCallback(z, resultValues);
                } catch (Throwable th) {
                    inputValues.getShareWNote().close(inputValues.getShareData().getPath());
                    TaskShareWord.this.notifyCallback(false, resultValues);
                    throw th;
                }
            }
        });
    }
}
