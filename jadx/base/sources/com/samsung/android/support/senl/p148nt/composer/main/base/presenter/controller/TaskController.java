package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller;

import android.app.Activity;
import android.os.Handler;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mde.MdeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ProgressController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.CallbackWithActivity;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskSaveVoiceForRecordApp;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.coedit.CoeditPauseController;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.StorageChecker;
import java.util.ArrayList;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskController {
    private static final int PROGRESS_DELAY = 250;
    private static final String TAG = Logger.createTag("TaskController");
    private boolean isLivingActivity;
    private CoeditPauseController mCoeditPauseController;
    private final Handler mHandler = new Handler();
    private LastCallback mLastCallback;
    private Task mLastTask;
    private final OnProgressCancelListenerImpl mOnProgressCancelListenerImpl;
    private final List<PendingJob> mPendingJobList;
    private PendingTask mPendingTask;
    private final ProgressController mProgressController;
    private final StorageChecker mStorageChecker;
    private Runnable rNotification;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class LastCallback<R extends Task.ResultValues> {
        private final Task.Callback<R> mCallback;
        private final boolean mIsSuccess;
        private final R mResult;

        public LastCallback(Task.Callback<R> callback, R r, boolean z) {
            this.mCallback = callback;
            this.mResult = r;
            this.mIsSuccess = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setActivity(Activity activity) {
            Task.Callback<R> callback = this.mCallback;
            if (callback instanceof CallbackWithActivity) {
                ((CallbackWithActivity) callback).setActivity(activity);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class OnProgressCancelListenerImpl implements ProgressController.OnCancelListener {
        public /* synthetic */ OnProgressCancelListenerImpl(TaskController taskController, int i) {
            this();
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.ProgressController.OnCancelListener
        public void onCancel(Task.ICancelCallback iCancelCallback) {
            if (TaskController.this.mLastTask != null) {
                TaskController.this.mLastTask.cancel(iCancelCallback);
            }
        }

        private OnProgressCancelListenerImpl() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class PendingJob {
        public static final int TYPE_CLOSE = 0;
        public static final int TYPE_NEW = 3;
        public static final int TYPE_NOTE_CHANGE = 1;
        public static final int TYPE_UPDATE = 2;
        Runnable mJob;
        int mType;

        public PendingJob(Runnable runnable, int i) {
            this.mJob = runnable;
            this.mType = i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class PendingTask {
        Task.Callback callback;
        Task.InputValues inputValues;
        boolean isSync;
        boolean isWaitingPermission;
        Task task;

        public /* synthetic */ PendingTask(Task task, Task.InputValues inputValues, Task.Callback callback, boolean z, int i) {
            this(task, inputValues, callback, z);
        }

        public void setWaitingPermission(boolean z) {
            this.isWaitingPermission = z;
        }

        private PendingTask(Task task, Task.InputValues inputValues, Task.Callback callback, boolean z) {
            this.task = task;
            this.inputValues = inputValues;
            this.callback = callback;
            this.isSync = z;
            this.isWaitingPermission = false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class UiCallbackWrapper<R extends Task.ResultValues> implements Task.Callback<R> {
        private final Task.Callback<R> mCallback;
        private final TaskController mTaskHandler;

        public UiCallbackWrapper(Task.Callback<R> callback, TaskController taskController) {
            this.mCallback = callback;
            this.mTaskHandler = taskController;
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
        public void onError(R r) {
            this.mTaskHandler.notify(r, this.mCallback, false);
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
        public void onSuccess(R r) {
            this.mTaskHandler.notify(r, this.mCallback, true);
        }
    }

    public TaskController(ProgressController progressController, StorageChecker storageChecker) {
        this.mProgressController = progressController;
        OnProgressCancelListenerImpl onProgressCancelListenerImpl = new OnProgressCancelListenerImpl(this, 0);
        this.mOnProgressCancelListenerImpl = onProgressCancelListenerImpl;
        progressController.setOnCancelListener(onProgressCancelListenerImpl);
        this.mStorageChecker = storageChecker;
        this.mPendingJobList = new ArrayList(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <R extends Task.ResultValues> void notify(final R r, final Task.Callback<R> callback, final boolean z) {
        String str = TAG;
        AbstractC8014b.m7224z("notify# isSuccess : ", str, z);
        if (!this.isLivingActivity) {
            Logger.m10999d(str, "notify# activity is invalid.");
            this.mLastCallback = new LastCallback(callback, r, z);
        } else {
            Runnable runnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.controller.TaskController.1
                @Override // java.lang.Runnable
                public void run() {
                    Logger.m11003i(TaskController.TAG, "notify# post");
                    TaskController.this.mProgressController.hideProgress(0, true);
                    Task.Callback callback2 = callback;
                    if (callback2 != null) {
                        if (z) {
                            callback2.onSuccess(r);
                        } else {
                            callback2.onError(r);
                        }
                    }
                    TaskController.this.release();
                    if (!TaskController.this.mPendingJobList.isEmpty()) {
                        for (PendingJob pendingJob : TaskController.this.mPendingJobList) {
                            AbstractC8014b.m7195A(new StringBuilder("notify#post# call pending job "), TaskController.TAG, pendingJob.mType);
                            pendingJob.mJob.run();
                        }
                        TaskController.this.mPendingJobList.clear();
                    }
                    TaskController.this.rNotification = null;
                }
            };
            this.rNotification = runnable;
            this.mHandler.post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void release() {
        Task task = this.mLastTask;
        if (task != null) {
            task.clear();
            this.mLastTask = null;
            CoeditPauseController coeditPauseController = this.mCoeditPauseController;
            if (coeditPauseController != null) {
                coeditPauseController.resumeCoedit();
                this.mCoeditPauseController.setContract(null);
            }
        }
        this.mLastCallback = null;
    }

    public void addPendingJob(Runnable runnable, int i) {
        AbstractC8014b.m7217s(i, "addPendingJob# ", TAG);
        this.mPendingJobList.add(new PendingJob(runnable, i));
    }

    public void cancel() {
        Task task = this.mLastTask;
        if (task != null) {
            task.cancel(null);
        }
    }

    public void clearTask() {
        Task task = this.mLastTask;
        if (task == null || task.isKeepTaskDuringActivityRecreation()) {
            return;
        }
        this.mProgressController.hideProgress(0, true);
        release();
    }

    public <I extends Task.InputValues, R extends Task.ResultValues> boolean execute(Task<I, R> task, I i, Task.Callback<R> callback, boolean z) {
        return execute(task, i, callback, z, false);
    }

    public boolean executePendingTask() {
        Logger.m10999d(TAG, "executePendingTask# " + this.mPendingTask);
        PendingTask pendingTask = this.mPendingTask;
        if (pendingTask == null) {
            return false;
        }
        boolean zExecute = execute(pendingTask.task, pendingTask.inputValues, pendingTask.callback, pendingTask.isSync);
        this.mPendingTask = null;
        return zExecute;
    }

    public Task getLastTask() {
        return this.mLastTask;
    }

    public void init(MdeManager mdeManager) {
        this.mCoeditPauseController = new CoeditPauseController(mdeManager.getCoeditAdapter());
    }

    public boolean isAvailableToReload() {
        Task task = this.mLastTask;
        return task == null || task.isAvailableToReload();
    }

    public boolean isAvailableToSave() {
        Task task = this.mLastTask;
        return task == null || task.isAvailableToSave();
    }

    public boolean isAvailableToUpdate() {
        Task task = this.mLastTask;
        return task == null || task.isAvailableToUpdate();
    }

    public boolean isKeepTaskDuringActivityRecreation() {
        Task task = this.mLastTask;
        return task != null && task.isKeepTaskDuringActivityRecreation();
    }

    public boolean isRunning() {
        return isRunning(true);
    }

    public void onAttachView(Activity activity) {
        Logger.m10999d(TAG, "onAttachView# " + this.rNotification);
        this.isLivingActivity = true;
        LastCallback lastCallback = this.mLastCallback;
        if (lastCallback != null) {
            lastCallback.setActivity(activity);
            notify(this.mLastCallback.mResult, this.mLastCallback.mCallback, this.mLastCallback.mIsSuccess);
        } else {
            Runnable runnable = this.rNotification;
            if (runnable != null) {
                this.mHandler.post(runnable);
            }
        }
    }

    public void onDestroy() {
        Logger.m10999d(TAG, "onDestroy#");
        Task task = this.mLastTask;
        if (task != null) {
            task.clear();
        }
        this.mLastCallback = null;
        this.mLastTask = null;
        this.mPendingTask = null;
        CoeditPauseController coeditPauseController = this.mCoeditPauseController;
        if (coeditPauseController != null) {
            coeditPauseController.setContract(null);
        }
    }

    public void onDetachView() {
        Logger.m10999d(TAG, "onDetachView# " + this.rNotification);
        this.isLivingActivity = false;
        LastCallback lastCallback = this.mLastCallback;
        if (lastCallback != null) {
            lastCallback.setActivity(null);
            return;
        }
        if (!isKeepTaskDuringActivityRecreation()) {
            this.mHandler.removeCallbacks(this.rNotification);
            this.mProgressController.hideProgress(0, true);
            release();
        } else if (this.mLastTask != null) {
            this.mProgressController.hideProgress(0, false);
            Runnable runnable = this.rNotification;
            if (runnable != null) {
                this.mHandler.removeCallbacks(runnable);
            } else {
                this.mLastTask.cancel(null);
            }
        }
    }

    public boolean onRequestPermissionsResult(int i) {
        PendingTask pendingTask = this.mPendingTask;
        if (pendingTask == null || !pendingTask.isWaitingPermission || !pendingTask.task.onRequestPermissionsResult(i, pendingTask.inputValues)) {
            return false;
        }
        executePendingTask();
        return true;
    }

    public void resetOnCancelListener() {
        this.mProgressController.setOnCancelListener(this.mOnProgressCancelListenerImpl);
    }

    public <I extends Task.InputValues, R extends Task.ResultValues> void setPendingTask(Task<I, R> task, I i, Task.Callback<R> callback, boolean z) {
        Logger.m10999d(TAG, "setPendingTask# " + task);
        this.mPendingTask = new PendingTask(task, i, callback, z, 0);
    }

    public <I extends Task.InputValues, R extends Task.ResultValues> boolean execute(Task<I, R> task, I i, Task.Callback<R> callback, boolean z, boolean z2) {
        return execute(task, i, callback, z, 250, z2);
    }

    public boolean isRunning(boolean z) {
        if (z) {
            Logger.m10999d(TAG, "isRunning# " + this.mLastTask);
        }
        return this.mLastTask != null;
    }

    public <I extends Task.InputValues, R extends Task.ResultValues> boolean execute(Task<I, R> task, I i, Task.Callback<R> callback, boolean z, int i2, boolean z2) {
        String str = TAG;
        Logger.m10999d(str, "execute# " + task.toString());
        if (isRunning()) {
            return false;
        }
        int iCheckAvailableStateToEdit = this.mStorageChecker.checkAvailableStateToEdit(task.isNeedToCheckStorage(), task.isNeedToCheckNoteSize(), true);
        if (iCheckAvailableStateToEdit != 0) {
            AbstractC0000a.m3D(iCheckAvailableStateToEdit, "execute# err: ", str);
            return false;
        }
        if (!task.checkPermission(i)) {
            Logger.m10999d(str, "execute# no permissions");
            if (task.isNeededToWaitPermission()) {
                setPendingTask(task, i, callback, z);
                this.mPendingTask.setWaitingPermission(true);
            }
            return false;
        }
        task.setInputValue(i);
        task.setStorageChecker(this.mStorageChecker);
        if (z) {
            task.setTaskCallback(callback);
        } else {
            task.setTaskCallback(new UiCallbackWrapper(callback, this));
            this.mLastTask = task;
            if (task.isProgressBarStyle()) {
                if (this.mProgressController.showProgressBarDialog(this.mLastTask.getProbressBarParams(), this.mLastTask instanceof TaskSaveVoiceForRecordApp)) {
                    this.mLastTask.setProgressBarUpdater(this.mProgressController);
                }
            } else {
                this.mProgressController.showProgress(i2, 0, z2);
            }
            CoeditPauseController coeditPauseController = this.mCoeditPauseController;
            if (coeditPauseController != null) {
                coeditPauseController.setContract(this.mLastTask);
                this.mCoeditPauseController.pauseCoedit();
            }
        }
        task.run();
        return true;
    }

    public boolean isRunning(Class<?> cls) {
        if (cls == null) {
            return false;
        }
        return cls.isInstance(this.mLastTask);
    }
}
