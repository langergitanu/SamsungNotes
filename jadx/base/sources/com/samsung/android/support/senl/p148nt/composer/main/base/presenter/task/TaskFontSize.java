package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskFontSize extends SingleThreadTask<InputValues, Task.ResultValues> {
    private static final String TAG = Logger.createTag("TaskFontSize");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues implements Task.InputValues {
        int mFontSize;
        RtToolbarPresenter mPresenter;

        public InputValues(RtToolbarPresenter rtToolbarPresenter, int i) {
            this.mPresenter = rtToolbarPresenter;
            this.mFontSize = i;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(final InputValues inputValues) {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
        this.mExecutorService = executorServiceNewSingleThreadExecutor;
        executorServiceNewSingleThreadExecutor.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskFontSize.1
            @Override // java.lang.Runnable
            public void run() {
                InputValues inputValues2 = inputValues;
                inputValues2.mPresenter.setFontSize(inputValues2.mFontSize);
                TaskFontSize.this.notifyCallback(true, null);
            }
        });
    }
}
