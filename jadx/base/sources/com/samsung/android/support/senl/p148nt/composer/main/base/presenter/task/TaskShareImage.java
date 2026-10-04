package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import android.content.Context;
import android.text.TextUtils;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.base.common.util.DeviceUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareData;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareWNote;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share.ShareToOtherAppHandler;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskShareImage extends SingleThreadTask<InputValues, ResultValues> {
    private static final String TAG = Logger.createTag("MakeImage");
    ShareToOtherAppHandler mShareToOtherAppHandler = new ShareToOtherAppHandler();

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void cancel(Task.ICancelCallback iCancelCallback) {
        Logger.m11003i(TAG, "cancel ");
        this.mShareToOtherAppHandler.cancel();
        if (iCancelCallback != null) {
            iCancelCallback.onCancel(true);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.SingleThreadTask, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void clear() {
        Logger.m11003i(TAG, "clear ");
        cancel(null);
        super.clear();
    }

    public void close(InputValues inputValues) {
        inputValues.mShareWNote.close(inputValues.mShareData.getPath());
    }

    public Task.Callback<ResultValues> getDefaultCallback() {
        return new Task.Callback<ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskShareImage.2
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(ResultValues resultValues) {
                ToastHandler.show(resultValues.mContext, C9086R.string.save_as_file_failed, 0);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(ResultValues resultValues) {
                if (resultValues.getPathList() == null || resultValues.getPathList().isEmpty()) {
                    Logger.m11000e(TaskShareImage.TAG, "onSuccess# getPathList is empty");
                    return;
                }
                int size = resultValues.getPathList().size();
                if (size != 1) {
                    ToastHandler.show(resultValues.mContext, resultValues.mContext.getResources().getQuantityString(DeviceUtils.isTabletModel() ? C9086R.plurals.plurals_save_as_tablet : C9086R.plurals.plurals_save_as_phone, size, Integer.valueOf(size)), 0);
                    return;
                }
                String str = resultValues.getPathList().get(0);
                String fileNameFromFilePath = !TextUtils.isEmpty(str) ? FileUtils.getFileNameFromFilePath(str) : "";
                if (TextUtils.isEmpty(fileNameFromFilePath)) {
                    return;
                }
                ToastHandler.showEncodingLog(resultValues.mContext, resultValues.mContext.getString(C9086R.string.save_as_file_saved, fileNameFromFilePath), 0);
            }
        };
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean isAvailableToReload() {
        return false;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ResultValues implements Task.ResultValues {
        private final Context mContext;
        private ArrayList<String> mPathList;

        public ResultValues(Context context) {
            this.mContext = context;
        }

        public ArrayList<String> getPathList() {
            return this.mPathList;
        }

        public ResultValues(Context context, ArrayList<String> arrayList) {
            this.mContext = context;
            this.mPathList = arrayList;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(final InputValues inputValues) {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
        this.mExecutorService = executorServiceNewSingleThreadExecutor;
        executorServiceNewSingleThreadExecutor.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskShareImage.1
            @Override // java.lang.Runnable
            public void run() {
                SpenWNote note;
                ResultValues resultValues = new ResultValues(inputValues.mContext);
                boolean z = false;
                try {
                    try {
                        note = inputValues.mShareWNote.getNote();
                    } catch (Exception e) {
                        Logger.m11001e(TaskShareImage.TAG, e.getMessage(), e);
                    }
                    if (!TextUtils.isEmpty(inputValues.mDestPath)) {
                        ArrayList<String> arrayListMakeImage = TaskShareImage.this.mShareToOtherAppHandler.getMakeUriHelper().makeImage(inputValues.mContext, note, inputValues.mDestPath);
                        if (arrayListMakeImage != null && !arrayListMakeImage.isEmpty()) {
                            resultValues = new ResultValues(inputValues.mContext, arrayListMakeImage);
                        }
                    }
                    if (inputValues.mIndexList == null || inputValues.mIndexList.isEmpty()) {
                        TaskShareImage.this.mShareToOtherAppHandler.shareImage(inputValues.mContext, note, inputValues.mShareData, 0);
                    } else {
                        TaskShareImage.this.mShareToOtherAppHandler.sharePageImage(inputValues.mContext, note, inputValues.mIndexList, inputValues.mShareData, 0);
                    }
                    z = true;
                } finally {
                    TaskShareImage.this.close(inputValues);
                    TaskShareImage.this.notifyCallback(false, resultValues);
                }
            }
        });
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues implements Task.InputValues {
        private final ComposerModel mComposerModel;
        private final Context mContext;
        private final String mDestPath;
        private List<Integer> mIndexList;
        private final ShareData mShareData;
        private final ShareWNote mShareWNote;

        public InputValues(Context context, ComposerModel composerModel, String str, ShareData shareData, ShareWNote shareWNote) {
            this.mContext = context;
            this.mComposerModel = composerModel;
            this.mDestPath = str;
            this.mShareData = shareData;
            this.mShareWNote = shareWNote;
        }

        public ComposerModel getComposerModel() {
            return this.mComposerModel;
        }

        public InputValues(Context context, ComposerModel composerModel, List<Integer> list, ShareData shareData, ShareWNote shareWNote) {
            this(context, composerModel, "", shareData, shareWNote);
            this.mIndexList = new ArrayList(list);
        }
    }
}
