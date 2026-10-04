package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.translation;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.pdf.TranslatedPDFSaveTask;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.pdf.TranslationService;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.SingleThreadTask;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentPageUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskAddToNoteWithPDFTranslation extends SingleThreadTask<InputValues, ResultValues> {
    private static final String TAG = Logger.createTag("TaskAddToNoteWithPDFTranslation");
    private ComposerViewPresenter mComposerViewPresenter;
    private ServiceConnection mConnection;
    private final AtomicBoolean mIsCanceled = new AtomicBoolean(false);
    private TranslationService mService;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues implements Task.InputValues {
        private final ComposerModel mComposerModel;
        private final ComposerViewPresenter mComposerViewPresenter;

        @NonNull
        private final String mPdfFileName;

        public InputValues(ComposerViewPresenter composerViewPresenter, ComposerModel composerModel, @NonNull String str) {
            this.mComposerViewPresenter = composerViewPresenter;
            this.mComposerModel = composerModel;
            this.mPdfFileName = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ResultValues implements Task.ResultValues {
        private final int mErrorType;
        private final String mUuid;

        public ResultValues(String str) {
            this(str, 0);
        }

        public int getErrorType() {
            return this.mErrorType;
        }

        public String getUuid() {
            return this.mUuid;
        }

        public ResultValues(String str, int i) {
            this.mUuid = str;
            this.mErrorType = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void connectService(final InputValues inputValues, final String str, final TranslatedPDFSaveTask.Callback callback) {
        Logger.m10999d(TAG, "connect");
        Context applicationContext = BaseUtils.getApplicationContext();
        this.mConnection = new ServiceConnection() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.translation.TaskAddToNoteWithPDFTranslation.2
            @Override // android.content.ServiceConnection
            public void onNullBinding(ComponentName componentName) {
                TaskAddToNoteWithPDFTranslation.this.disconnect();
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                if (iBinder == null || TaskAddToNoteWithPDFTranslation.this.mIsCanceled.get()) {
                    return;
                }
                TaskAddToNoteWithPDFTranslation.this.setTranslationNotificationFlagToIntent(true);
                TaskAddToNoteWithPDFTranslation.this.mService = ((TranslationService.LocalBinder) iBinder).getService();
                TaskAddToNoteWithPDFTranslation.this.mService.translate(str, inputValues.mPdfFileName, DocumentPageUtils.convertToPageMode(inputValues.mComposerModel.getDoc().getPageMode()), inputValues.mComposerViewPresenter, callback);
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                Logger.m10999d(TaskAddToNoteWithPDFTranslation.TAG, "ServiceConnection, onServiceDisconnected()");
                TaskAddToNoteWithPDFTranslation.this.mConnection = null;
                TaskAddToNoteWithPDFTranslation.this.mService = null;
            }
        };
        applicationContext.bindService(new Intent(applicationContext, (Class<?>) TranslationService.class), this.mConnection, 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setProgress(int i) {
        Task.IProgressBarUpdater iProgressBarUpdater = this.mProgressBarUpdater;
        if (iProgressBarUpdater != null) {
            iProgressBarUpdater.setProgress(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTranslationNotificationFlagToIntent(boolean z) {
        ComposerViewPresenter composerViewPresenter = this.mComposerViewPresenter;
        if (composerViewPresenter != null) {
            composerViewPresenter.getActivity().getIntent().putExtra(ComposerConstants.ARG_TRANSLATION_NOTIFICATION_ON, z);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void cancel(Task.ICancelCallback iCancelCallback) {
        Logger.m11003i(TAG, "cancel#");
        this.mIsCanceled.set(true);
        TranslationService translationService = this.mService;
        if (translationService != null) {
            translationService.cancel();
        }
        if (iCancelCallback != null) {
            iCancelCallback.onCancel(true);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.SingleThreadTask, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void clear() {
        cancel(null);
        disconnect();
        super.clear();
    }

    public void disconnect() {
        if (this.mConnection == null) {
            return;
        }
        Logger.m10999d(TAG, "disconnect");
        BaseUtils.getApplicationContext().unbindService(this.mConnection);
        this.mConnection = null;
        this.mService = null;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public Pair<Boolean, Integer> getProbressBarParams() {
        return new Pair<>(Boolean.TRUE, Integer.valueOf(C9086R.string.adding_translated_pdf_to_new_note));
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean isKeepTaskDuringActivityRecreation() {
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean isProgressBarStyle() {
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(final InputValues inputValues) {
        inputValues.mComposerModel.getVoiceModel().stopRecording();
        this.mComposerViewPresenter = inputValues.mComposerViewPresenter;
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
        this.mExecutorService = executorServiceNewSingleThreadExecutor;
        executorServiceNewSingleThreadExecutor.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.translation.TaskAddToNoteWithPDFTranslation.1
            private void translate(InputValues inputValues2) {
                TranslatedPDFSaveTask.Callback callback = new TranslatedPDFSaveTask.Callback() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.translation.TaskAddToNoteWithPDFTranslation.1.1
                    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslatedPDFSaveTask.Callback
                    public void onFailed(int i, String str) {
                        Logger.m11000e(TaskAddToNoteWithPDFTranslation.TAG, "onFailed, type: " + i + ", msg: " + str);
                        TaskAddToNoteWithPDFTranslation.this.notifyCallback(false, new ResultValues("", i));
                    }

                    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslatedPDFSaveTask.Callback
                    public void onProgress(int i, int i2) {
                        TaskAddToNoteWithPDFTranslation.this.setProgress((int) ((i / i2) * 100.0f));
                    }

                    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslatedPDFSaveTask.Callback
                    public void onSuccess(String str) {
                        TaskAddToNoteWithPDFTranslation.this.setProgress(100);
                        TaskAddToNoteWithPDFTranslation.this.notifyCallback(true, new ResultValues(str));
                    }
                };
                String path = inputValues2.mComposerModel.getDocState().getPath();
                if (TextUtils.isEmpty(path) || TextUtils.isEmpty(inputValues2.mPdfFileName)) {
                    callback.onFailed(1, "path is invalid");
                } else if (TaskAddToNoteWithPDFTranslation.this.mIsCanceled.get()) {
                    callback.onFailed(2, "canceled before execution");
                } else {
                    TaskAddToNoteWithPDFTranslation.this.connectService(inputValues2, path, callback);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                TaskAddToNoteWithPDFTranslation.this.setProgress(0);
                inputValues.mComposerModel.saveCacheForced(true);
                translate(inputValues);
            }
        });
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.SingleThreadTask
    public void notifyCallback(boolean z, ResultValues resultValues) {
        super.notifyCallback(z, resultValues);
        setTranslationNotificationFlagToIntent(false);
        disconnect();
    }
}
