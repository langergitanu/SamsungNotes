package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.base.common.util.UriFileUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.AudioUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.StorageChecker;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskDownloadAudio extends SingleThreadTask<InputValues, ResultValues> {
    private static final String TAG = Logger.createTag("TaskDownloadAudio");

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public boolean isNeedToCheckNoteSize() {
        return true;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ResultValues implements Task.ResultValues {
        private Context mContext;
        private String mFileName;
        private String mFilePath;
        private boolean mIsNotSupportAudioType;
        private boolean mOverSize;
        private String mTitle;

        public ResultValues(Context context) {
            this.mContext = context;
        }

        public String getContentPath() {
            return this.mFilePath;
        }

        public String getFileName() {
            return this.mFileName;
        }

        public String getTitle() {
            return this.mTitle;
        }

        public void showErrorDialog() {
            Context context = this.mContext;
            if (context != null) {
                if (this.mOverSize) {
                    StorageChecker.showErrorDialog(context, 2);
                } else if (this.mIsNotSupportAudioType) {
                    ToastHandler.show(context, C9086R.string.composer_failed_to_load_image, 0);
                } else {
                    ToastHandler.show(context, C9086R.string.composer_failed_to_download_content, 0);
                }
            }
        }

        public ResultValues(String str, String str2, String str3) {
            this.mFilePath = str;
            this.mFileName = str2;
            this.mTitle = str3;
        }

        public ResultValues(Context context, boolean z, boolean z2) {
            this.mContext = context;
            this.mOverSize = z;
            this.mIsNotSupportAudioType = z2;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(final InputValues inputValues) {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
        this.mExecutorService = executorServiceNewSingleThreadExecutor;
        executorServiceNewSingleThreadExecutor.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskDownloadAudio.1
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                InputValues inputValues2 = inputValues;
                Uri uri = inputValues2.mUri;
                if (uri == null) {
                    Logger.m11000e(TaskDownloadAudio.TAG, "mUri is null.");
                    TaskDownloadAudio.this.notifyCallback(false, new ResultValues(inputValues.mContext));
                    return;
                }
                String audioFileName = AudioUtil.getAudioFileName(inputValues2.mContext, uri);
                if (TextUtils.isEmpty(audioFileName)) {
                    Logger.m11000e(TaskDownloadAudio.TAG, "fileName is empty.");
                    TaskDownloadAudio.this.notifyCallback(false, new ResultValues(inputValues.mContext));
                    return;
                }
                String audioFilePath = AudioUtil.getAudioFilePath(inputValues.mDestFilePath, audioFileName);
                InputValues inputValues3 = inputValues;
                if (!UriFileUtils.saveUriToFile(inputValues3.mContext, inputValues3.mUri, audioFilePath)) {
                    Logger.m11000e(TaskDownloadAudio.TAG, "saveUriToFile is false.");
                    TaskDownloadAudio.this.notifyCallback(false, new ResultValues(inputValues.mContext));
                    return;
                }
                if (!AbstractC2322a.m1607A(audioFilePath)) {
                    Logger.m11000e(TaskDownloadAudio.TAG, "file is not exist.");
                    TaskDownloadAudio.this.notifyCallback(false, new ResultValues(inputValues.mContext));
                } else if (!AudioUtil.isSupportedAudio(audioFilePath)) {
                    Logger.m11000e(TaskDownloadAudio.TAG, "not supported audio file.");
                    TaskDownloadAudio.this.notifyCallback(false, new ResultValues(inputValues.mContext, false, true));
                } else if (TaskDownloadAudio.this.mStorageChecker.checkAvailableStateToAdd(audioFilePath)) {
                    TaskDownloadAudio.this.notifyCallback(true, new ResultValues(audioFilePath, audioFileName, inputValues.mTitle));
                } else {
                    TaskDownloadAudio.this.notifyCallback(false, new ResultValues(inputValues.mContext, true, false));
                }
            }
        });
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues implements Task.InputValues {
        Context mContext;
        String mDestFilePath;
        String mTitle;
        Uri mUri;

        public InputValues(Context context, String str, Uri uri) {
            this.mDestFilePath = str;
            this.mContext = context;
            this.mUri = uri;
        }

        public InputValues(Context context, String str, Uri uri, String str2) {
            this.mDestFilePath = str;
            this.mContext = context;
            this.mUri = uri;
            this.mTitle = str2;
        }
    }
}
