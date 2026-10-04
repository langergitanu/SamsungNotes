package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import androidx.core.util.Pair;
import com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.InputValues;
import com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.ResultValues;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.coedit.CoeditPauseController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.coedit.SynchronizedCancelAction;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.StorageChecker;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Task<I extends InputValues, R extends ResultValues> implements CoeditPauseController.Contract {
    private static final String TAG = Logger.createTag("Task");
    private I mInputValues;
    protected IProgressBarUpdater mProgressBarUpdater;
    protected StorageChecker mStorageChecker;
    private Callback<R> mTaskCallback;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Callback<R> {
        void onError(R r);

        void onSuccess(R r);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ICancelCallback {
        void onCancel(boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface IProgressBarUpdater {
        void setProgress(int i);

        void updateDialogTitle(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface InputValues {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ResultValues {
    }

    public void cancel(ICancelCallback iCancelCallback) {
    }

    public boolean checkPermission(I i) {
        return true;
    }

    public void clear() {
    }

    public abstract void executeTask(I i);

    public I getInputValue() {
        return this.mInputValues;
    }

    public Pair<Boolean, Integer> getProbressBarParams() {
        return new Pair<>(Boolean.FALSE, Integer.valueOf(C9086R.string.composer_add_pdf));
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.coedit.CoeditPauseController.Contract
    public SynchronizedCancelAction getSynchronizedCancelAction() {
        return null;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.coedit.CoeditPauseController.Contract
    public String getTag() {
        return TAG;
    }

    public Callback<R> getTaskCallback() {
        return this.mTaskCallback;
    }

    public boolean isAvailableToReload() {
        return true;
    }

    public boolean isAvailableToSave() {
        return true;
    }

    public boolean isAvailableToUpdate() {
        return true;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.coedit.CoeditPauseController.Contract
    public boolean isCoeditNoTimeoutPause() {
        return false;
    }

    public boolean isKeepTaskDuringActivityRecreation() {
        return false;
    }

    public boolean isNeedToCheckNoteSize() {
        return false;
    }

    public boolean isNeedToCheckStorage() {
        return true;
    }

    public boolean isNeededToWaitPermission() {
        return false;
    }

    public boolean isProgressBarStyle() {
        return false;
    }

    public boolean onRequestPermissionsResult(int i, I i2) {
        return false;
    }

    public void run() {
        executeTask(this.mInputValues);
    }

    public void setInputValue(I i) {
        this.mInputValues = i;
    }

    public void setProgressBarUpdater(IProgressBarUpdater iProgressBarUpdater) {
        this.mProgressBarUpdater = iProgressBarUpdater;
    }

    public void setStorageChecker(StorageChecker storageChecker) {
        this.mStorageChecker = storageChecker;
    }

    public void setTaskCallback(Callback<R> callback) {
        this.mTaskCallback = callback;
    }
}
