package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import android.content.Context;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.coedit.caller.CoeditNoteUpDownloader;
import com.samsung.android.support.senl.p148nt.coedit.caller.updownloader.ImportResult;
import com.samsung.android.support.senl.p148nt.coedit.control.CoeditHandlerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.documents.spen.SpenWordDocument;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskMakeCoeditNote extends SingleThreadTask<InputValues, ResultValues> {
    private static final String TAG = Logger.createTag("TaskMakeCoeditNote");
    private String mNewUuid = null;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues implements Task.InputValues {
        private final ComposerModel mComposerModel;
        private final Context mContext;
        private final String mSpaceId;

        public InputValues(Context context, ComposerModel composerModel, String str) {
            this.mContext = context;
            this.mComposerModel = composerModel;
            this.mSpaceId = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ResultValues implements Task.ResultValues {
        public static final int ERROR_COEDIT_WITH_COMPOSER_RUNNING = 204;
        public static final int ERROR_FILE_COPY = 202;
        public static final int ERROR_LARGE_SIZE = 205;
        public static final int ERROR_NETWORK_FAIL = 203;
        public static final int IGNORE = 201;
        public static final int SUCCESS = 200;
        private final boolean mIsChangedToLightMode;
        private final String mPath;
        private final int mResult;
        private final String mUuid;

        public ResultValues(String str, String str2, boolean z, int i) {
            this.mUuid = str;
            this.mPath = str2;
            this.mIsChangedToLightMode = z;
            this.mResult = i;
        }

        public String getPath() {
            return this.mPath;
        }

        public int getResult() {
            return this.mResult;
        }

        public String getUuid() {
            return this.mUuid;
        }

        public boolean isChangedToLightMode() {
            return this.mIsChangedToLightMode;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean waitToCloseCoedit(String str) {
        String str2 = TAG;
        Logger.m11003i(str2, "waitToCloseCoedit# start");
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        CoeditHandlerManager.getInstance().registerRunningStateListener(str, new CoeditHandlerManager.RunningStateListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskMakeCoeditNote.2
            @Override // com.samsung.android.support.senl.nt.coedit.control.CoeditHandlerManager.RunningStateListener
            public void onComposerRunningStateChanged(boolean z) {
                AbstractC8014b.m7224z("waitToCloseCoedit#onComposerRunningStateChanged# ", TaskMakeCoeditNote.TAG, z);
                countDownLatch.countDown();
            }
        });
        try {
            try {
                countDownLatch.await();
                CoeditHandlerManager.getInstance().unregisterRunningStateListener(str);
                Logger.m11003i(str2, "waitToCloseCoedit# end");
                return true;
            } catch (InterruptedException e) {
                Logger.m11000e(TAG, "waitToCloseCoedit# " + e.getMessage());
                CoeditHandlerManager.getInstance().unregisterRunningStateListener(str);
                return false;
            }
        } catch (Throwable th) {
            CoeditHandlerManager.getInstance().unregisterRunningStateListener(str);
            throw th;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void cancel(Task.ICancelCallback iCancelCallback) {
        super.cancel(iCancelCallback);
        if (this.mNewUuid != null) {
            CoeditHandlerManager.getInstance().forceCancel(this.mNewUuid, TAG);
            this.mNewUuid = null;
        }
        ExecutorService executorService = this.mExecutorService;
        if (executorService != null) {
            executorService.shutdownNow();
            this.mExecutorService = null;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean isAvailableToReload() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean isAvailableToSave() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean isKeepTaskDuringActivityRecreation() {
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(final InputValues inputValues) {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
        this.mExecutorService = executorServiceNewSingleThreadExecutor;
        executorServiceNewSingleThreadExecutor.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskMakeCoeditNote.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                ComposerModel composerModel = inputValues.mComposerModel;
                String uuid = composerModel.getDocState().getUuid();
                boolean z = ((SpenWordDocument) composerModel.getDocState().getDoc()).isBackgroundColorInverted() && ContextUtils.isNightMode(inputValues.mContext);
                composerModel.save(true, true, false, 0, false);
                if (CoeditHandlerManager.getInstance().isCoeditWithComposerRunning() && !TaskMakeCoeditNote.this.waitToCloseCoedit(uuid)) {
                    TaskMakeCoeditNote.this.notifyCallback(false, new ResultValues("", "", z, 203));
                    return;
                }
                ImportResult importResultImportNoteToCoedit = CoeditNoteUpDownloader.getInstance().importNoteToCoedit(((InputValues) TaskMakeCoeditNote.this.getInputValue()).mContext, uuid, inputValues.mSpaceId);
                TaskMakeCoeditNote.this.mNewUuid = importResultImportNoteToCoedit.newUuid;
                AbstractC8014b.m7221w(new StringBuilder("executeTask# ret:"), TaskMakeCoeditNote.TAG, importResultImportNoteToCoedit.ret);
                TaskMakeCoeditNote taskMakeCoeditNote = TaskMakeCoeditNote.this;
                int i = importResultImportNoteToCoedit.ret;
                taskMakeCoeditNote.notifyCallback(i == 200, new ResultValues(importResultImportNoteToCoedit.newUuid, importResultImportNoteToCoedit.newPath, z, i));
            }
        });
    }
}
