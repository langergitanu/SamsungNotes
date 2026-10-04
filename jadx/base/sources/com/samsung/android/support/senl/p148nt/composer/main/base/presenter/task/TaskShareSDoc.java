package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import android.content.Intent;
import android.text.TextUtils;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.base.composer.share.ShareCallbackReceiver;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskShareCommon;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskShareSDoc extends TaskShareCommon<TaskShareCommon.InputValues, TaskShareCommon.ResultValues> {
    private static final String TAG = Logger.createTag("TaskShareSDoc");

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskShareCommon, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void cancel(Task.ICancelCallback iCancelCallback) {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskShareCommon, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.SingleThreadTask, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void clear() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskShareCommon
    public String getLogTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(final TaskShareCommon.InputValues inputValues) {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
        this.mExecutorService = executorServiceNewSingleThreadExecutor;
        executorServiceNewSingleThreadExecutor.submit(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskShareSDoc.1
            @Override // java.lang.Runnable
            public void run() {
                TaskShareCommon.ResultValues resultValues = new TaskShareCommon.ResultValues(inputValues.getContext());
                boolean z = false;
                try {
                    try {
                        if (TextUtils.isEmpty(inputValues.getDestPath())) {
                            Intent intentShareSDoc = TaskShareSDoc.this.mShareToOtherAppHandler.shareSDoc(inputValues.getContext(), inputValues.getShareData(), ShareCallbackReceiver.ShareCaller.ComposerToolbar);
                            if (intentShareSDoc == null) {
                                Logger.m11000e(TaskShareSDoc.TAG, "shareNote, intent is null");
                            } else {
                                inputValues.getShareData().setShareTo(intentShareSDoc);
                                TaskShareSDoc.this.mShareToOtherAppHandler.startChooserActivity(inputValues.getContext(), intentShareSDoc, 0);
                                z = true;
                            }
                        } else {
                            String strMakeSDoc = TaskShareSDoc.this.mShareToOtherAppHandler.getMakeUriHelper().makeSDoc(inputValues.getContext(), inputValues.getShareData(), inputValues.getDestPath());
                            if (!TextUtils.isEmpty(strMakeSDoc) && new File(strMakeSDoc).exists()) {
                                z = true;
                                resultValues = new TaskShareCommon.ResultValues(inputValues.getContext(), strMakeSDoc, null);
                            }
                        }
                    } catch (Exception e) {
                        Logger.m11001e(TaskShareSDoc.TAG, e.getMessage(), e);
                    }
                } finally {
                    inputValues.getShareWNote().close(inputValues.getShareData().getPath());
                    TaskShareSDoc.this.notifyCallback(z, resultValues);
                }
            }
        });
    }
}
