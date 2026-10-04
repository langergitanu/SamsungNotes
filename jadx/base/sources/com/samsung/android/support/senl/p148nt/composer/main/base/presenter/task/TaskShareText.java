package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.composer.share.ShareCallbackReceiver;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareData;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareWNote;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share.ShareToOtherAppHandler;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskShareText extends SingleThreadTask<InputValues, ResultValues> {
    private static final String TAG = Logger.createTag("TaskShareText");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues implements Task.InputValues {
        private Context mContext;
        private String mDestPath;
        private ShareData mShareData;
        private ShareWNote mShareWNote;

        public InputValues(Context context, String str, ShareData shareData, ShareWNote shareWNote) {
            this.mContext = context;
            this.mDestPath = str;
            this.mShareData = shareData;
            this.mShareWNote = shareWNote;
        }
    }

    public Task.Callback<ResultValues> getDefaultCallback() {
        return new Task.Callback<ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskShareText.2
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(ResultValues resultValues) {
                ToastHandler.show(resultValues.mContext, C9086R.string.save_as_file_failed, 0);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(ResultValues resultValues) {
                if (TextUtils.isEmpty(resultValues.mPath)) {
                    return;
                }
                ToastHandler.showEncodingLog(resultValues.mContext, resultValues.mContext.getString(C9086R.string.save_as_file_saved, FileUtils.getFileNameFromFilePath(resultValues.mPath)), 0);
            }
        };
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean isAvailableToReload() {
        return false;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ResultValues implements Task.ResultValues {
        private Context mContext;
        private String mPath;

        public ResultValues(Context context) {
            this.mContext = context;
        }

        public ResultValues(Context context, String str) {
            this.mContext = context;
            this.mPath = str;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(final InputValues inputValues) {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
        this.mExecutorService = executorServiceNewSingleThreadExecutor;
        executorServiceNewSingleThreadExecutor.submit(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskShareText.1
            @Override // java.lang.Runnable
            public void run() {
                ResultValues resultValues = new ResultValues(inputValues.mContext);
                boolean z = false;
                try {
                    SpenWNote note = inputValues.mShareWNote.getNote();
                    ShareToOtherAppHandler shareToOtherAppHandler = new ShareToOtherAppHandler();
                    if (!TextUtils.isEmpty(inputValues.mDestPath)) {
                        String strMakeText = shareToOtherAppHandler.getMakeUriHelper().makeText(inputValues.mContext, note, inputValues.mDestPath);
                        if (!TextUtils.isEmpty(strMakeText) && new File(strMakeText).exists()) {
                            resultValues = new ResultValues(inputValues.mContext, strMakeText);
                        }
                    }
                    Intent intentCreateIntentToShareText = shareToOtherAppHandler.createIntentToShareText(inputValues.mContext, note, inputValues.mShareData.getTitle(), ShareCallbackReceiver.ShareCaller.ComposerToolbar);
                    if (intentCreateIntentToShareText == null) {
                        Logger.m11000e(TaskShareText.TAG, "shareNote, intent is null");
                        resultValues = new ResultValues(inputValues.mContext);
                        return;
                    } else {
                        inputValues.mShareData.setShareTo(intentCreateIntentToShareText);
                        shareToOtherAppHandler.startChooserActivity(inputValues.mContext, intentCreateIntentToShareText, 0);
                    }
                    z = true;
                } catch (Exception e) {
                    Logger.m11001e(TaskShareText.TAG, e.getMessage(), e);
                } finally {
                    inputValues.mShareWNote.close(inputValues.mShareData.getPath());
                    TaskShareText.this.notifyCallback(false, resultValues);
                }
            }
        });
    }
}
