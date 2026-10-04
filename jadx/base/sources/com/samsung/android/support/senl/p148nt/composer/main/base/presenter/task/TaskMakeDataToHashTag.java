package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import android.content.Context;
import android.os.CancellationSignal;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.data.TextInfo;
import com.samsung.android.support.senl.p148nt.model.collector.recognition.facade.RecognitionFacade;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskMakeDataToHashTag extends SingleThreadTask<InputValues, ResultValues> {
    private static final String TAG = Logger.createTag("TaskMakeDataToHashTag");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues implements Task.InputValues {
        private Context mContext;
        private ComposerModel mModel;

        public InputValues(Context context, ComposerModel composerModel) {
            this.mContext = context;
            this.mModel = composerModel;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ResultValues implements Task.ResultValues {
        private StringBuffer mStringBufferTextRecognition;

        public ResultValues(StringBuffer stringBuffer) {
            this.mStringBufferTextRecognition = stringBuffer;
        }

        public StringBuffer getStringBufferTextRecognition() {
            return this.mStringBufferTextRecognition;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void cancel(Task.ICancelCallback iCancelCallback) {
        ExecutorService executorService = this.mExecutorService;
        if (executorService != null) {
            executorService.shutdownNow();
        }
        Logger.m10999d(TAG, "cancel ");
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean isAvailableToReload() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(final InputValues inputValues) {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
        this.mExecutorService = executorServiceNewSingleThreadExecutor;
        executorServiceNewSingleThreadExecutor.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskMakeDataToHashTag.1
            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                List<TextInfo> listRecognizeLine;
                StringBuffer stringBuffer = new StringBuffer();
                try {
                    z = true;
                    inputValues.mModel.saveCache(true);
                    boolean zIsAutoSaveOptionEnabled = inputValues.mModel.getComposerSaveModel().isAutoSaveOptionEnabled();
                    Logger.m10999d(TaskMakeDataToHashTag.TAG, "executeTask# " + zIsAutoSaveOptionEnabled);
                    if (zIsAutoSaveOptionEnabled && (listRecognizeLine = new RecognitionFacade().recognizeLine(inputValues.mContext, inputValues.mModel.getDocInfo().getDocPath(), new CancellationSignal())) != null) {
                        Iterator<TextInfo> it = listRecognizeLine.iterator();
                        while (it.hasNext()) {
                            stringBuffer.append(it.next().str);
                            stringBuffer.append('\n');
                        }
                    }
                } catch (Exception e) {
                    Logger.m11001e(TaskMakeDataToHashTag.TAG, e.getMessage(), e);
                    z = false;
                }
                TaskMakeDataToHashTag.this.notifyCallback(z, new ResultValues(stringBuffer));
            }
        });
    }
}
