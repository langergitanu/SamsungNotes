package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.InputValues;
import com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskShareCommon.ResultValues;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareData;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareWNote;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share.ShareToOtherAppHandler;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class TaskShareCommon<Input extends Task.InputValues, Result extends ResultValues> extends SingleThreadTask<Input, Result> {
    private static final String TAG = Logger.createTag("TaskShareCommon");
    protected boolean mIsCanceled;
    protected ShareToOtherAppHandler mShareToOtherAppHandler = new ShareToOtherAppHandler();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues implements Task.InputValues {
        private final Context mContext;
        private final String mDestPath;
        private final ShareData mShareData;
        private ShareWNote mShareWNote;

        public InputValues(Context context, String str, ShareData shareData, ShareWNote shareWNote) {
            this.mContext = context;
            this.mDestPath = str;
            this.mShareData = shareData;
            this.mShareWNote = shareWNote;
        }

        public Context getContext() {
            return this.mContext;
        }

        public String getDestPath() {
            return this.mDestPath;
        }

        public ShareData getShareData() {
            return this.mShareData;
        }

        public ShareWNote getShareWNote() {
            return this.mShareWNote;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void cancel(Task.ICancelCallback iCancelCallback) {
        Logger.m11003i(getLogTag(), "cancel ");
        this.mIsCanceled = true;
        this.mShareToOtherAppHandler.cancel();
        if (iCancelCallback != null) {
            iCancelCallback.onCancel(true);
        }
        ExecutorService executorService = this.mExecutorService;
        if (executorService != null) {
            executorService.shutdownNow();
            this.mExecutorService = null;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.SingleThreadTask, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void clear() {
        Logger.m11003i(getLogTag(), "clear ");
        cancel(null);
        super.clear();
    }

    public Task.Callback<Result> getDefaultCallback() {
        return (Task.Callback<Result>) new Task.Callback<Result>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskShareCommon.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(Result result) {
                if (result == null) {
                    Logger.m11000e(TaskShareCommon.TAG, "TaskShareCommon# onError result is null.");
                } else {
                    ToastHandler.show(result.getContext(), C9086R.string.save_as_file_failed, 0);
                }
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(Result result) {
                if (result == null) {
                    Logger.m11000e(TaskShareCommon.TAG, "TaskShareCommon# onSuccess result is null.");
                    return;
                }
                String fileNameFromFilePath = !TextUtils.isEmpty(result.getPath()) ? FileUtils.getFileNameFromFilePath(result.getPath()) : result.getUri() != null ? FileUtils.getFileNameFromUri(result.getContext(), result.getUri()) : "";
                if (TextUtils.isEmpty(fileNameFromFilePath)) {
                    return;
                }
                ToastHandler.showEncodingLog(result.getContext(), result.getContext().getString(C9086R.string.save_as_file_saved, fileNameFromFilePath), 0);
            }
        };
    }

    public String getLogTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean isAvailableToReload() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task, com.samsung.android.support.senl.nt.composer.main.base.presenter.task.coedit.CoeditPauseController.Contract
    public boolean isCoeditNoTimeoutPause() {
        return true;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ResultValues implements Task.ResultValues {
        private final Context mContext;
        private String mPath;
        private Uri mUri;

        public ResultValues(Context context) {
            this.mContext = context;
        }

        public Context getContext() {
            return this.mContext;
        }

        public String getPath() {
            return this.mPath;
        }

        public Uri getUri() {
            return this.mUri;
        }

        public ResultValues(Context context, String str, Uri uri) {
            this.mContext = context;
            this.mPath = str;
            this.mUri = uri;
        }
    }
}
