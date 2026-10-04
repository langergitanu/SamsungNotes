package com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.task;

import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.composer.main.base.common.ExecuteCallback;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.RunnableC9121a;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.SingleThreadTask;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.RunnableC10960a;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PwTaskConvertToNote extends SingleThreadTask<InputValues, ResultValues> {
    private static final String TAG = Logger.createTag("PwTaskConvertToNote");
    private Runnable mCancelRequest;
    private final AtomicBoolean mIsCanceled = new AtomicBoolean(false);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues implements Task.InputValues {
        private final ComposerModel composerModel;
        private final String newUuid;

        public InputValues(String str, ComposerModel composerModel) {
            this.newUuid = str;
            this.composerModel = composerModel;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ResultValues implements Task.ResultValues {
        private final boolean mIsCanceled;

        public ResultValues(boolean z) {
            this.mIsCanceled = z;
        }

        public boolean isCanceled() {
            return this.mIsCanceled;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$executeTask$0(ComposerModel composerModel) {
        composerModel.getComposerSaveModel().cancelSaveToDevice();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$executeTask$1(InputValues inputValues) {
        ComposerModel composerModel = inputValues.composerModel;
        composerModel.saveCacheForced(true);
        if (this.mIsCanceled.get()) {
            Logger.m10999d(TAG, TelemetryEventStrings.Value.CANCELLED);
            notifyCallback(false, new ResultValues(this.mIsCanceled.get()));
        } else {
            this.mCancelRequest = new RunnableC9121a(composerModel, 1);
            composerModel.getComposerSaveModel().saveToDevice(new ExecuteCallback() { // from class: com.samsung.android.support.senl.nt.composer.main.pdfwriter.presenter.task.PwTaskConvertToNote.1
                @Override // com.samsung.android.support.senl.p148nt.composer.main.base.common.ExecuteCallback
                public void onFail() {
                    Logger.m11000e(PwTaskConvertToNote.TAG, "onFail");
                    PwTaskConvertToNote pwTaskConvertToNote = PwTaskConvertToNote.this;
                    pwTaskConvertToNote.notifyCallback(false, new ResultValues(pwTaskConvertToNote.mIsCanceled.get()));
                }

                @Override // com.samsung.android.support.senl.p148nt.composer.main.base.common.ExecuteCallback
                public void onSuccess() {
                    Logger.m11003i(PwTaskConvertToNote.TAG, "onSuccess ");
                    PwTaskConvertToNote pwTaskConvertToNote = PwTaskConvertToNote.this;
                    pwTaskConvertToNote.notifyCallback(true, new ResultValues(pwTaskConvertToNote.mIsCanceled.get()));
                }
            }, inputValues.newUuid);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void cancel(Task.ICancelCallback iCancelCallback) {
        Logger.m11003i(TAG, "cancel#");
        this.mIsCanceled.set(true);
        Runnable runnable = this.mCancelRequest;
        if (runnable != null) {
            runnable.run();
        }
        if (iCancelCallback != null) {
            iCancelCallback.onCancel(true);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(InputValues inputValues) {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
        this.mExecutorService = executorServiceNewSingleThreadExecutor;
        executorServiceNewSingleThreadExecutor.execute(new RunnableC10960a(this, inputValues, 1));
    }
}
