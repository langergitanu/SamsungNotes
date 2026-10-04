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
public class TaskSharePowerPoint extends TaskShareCommon<TaskShareCommon.InputValues, TaskShareCommon.ResultValues> {
    private static final String TAG = Logger.createTag("TaskSharePowerPoint");

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskShareCommon
    public String getLogTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(final TaskShareCommon.InputValues inputValues) {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
        this.mExecutorService = executorServiceNewSingleThreadExecutor;
        executorServiceNewSingleThreadExecutor.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskSharePowerPoint.1
            @Override // java.lang.Runnable
            public void run() {
                TaskSharePowerPoint taskSharePowerPoint;
                TaskShareCommon.ResultValues resultValues = new TaskShareCommon.ResultValues(inputValues.getContext());
                boolean z = false;
                try {
                    try {
                        SpenWNote note = inputValues.getShareWNote().getNote();
                        if (TextUtils.isEmpty(inputValues.getDestPath())) {
                            TaskSharePowerPoint.this.mShareToOtherAppHandler.sharePowerPoint(inputValues.getContext(), note, inputValues.getShareData(), 0);
                        } else {
                            String strMakeMsPPT = TaskSharePowerPoint.this.mShareToOtherAppHandler.getMakeUriHelper().makeMsPPT(inputValues.getContext(), note, inputValues.getShareData().getPath(), inputValues.getDestPath());
                            resultValues = (TextUtils.isEmpty(strMakeMsPPT) || !new File(strMakeMsPPT).exists()) ? new TaskShareCommon.ResultValues(inputValues.getContext()) : new TaskShareCommon.ResultValues(inputValues.getContext(), strMakeMsPPT, null);
                        }
                        inputValues.getShareWNote().close(inputValues.getShareData().getPath());
                        taskSharePowerPoint = TaskSharePowerPoint.this;
                        z = true;
                    } catch (Exception e) {
                        Logger.m11001e(TaskSharePowerPoint.TAG, "executeTask# " + e.getMessage(), e);
                        inputValues.getShareWNote().close(inputValues.getShareData().getPath());
                        taskSharePowerPoint = TaskSharePowerPoint.this;
                    }
                    taskSharePowerPoint.notifyCallback(z, resultValues);
                } catch (Throwable th) {
                    inputValues.getShareWNote().close(inputValues.getShareData().getPath());
                    TaskSharePowerPoint.this.notifyCallback(false, resultValues);
                    throw th;
                }
            }
        });
    }
}
