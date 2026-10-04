package com.samsung.android.support.senl.p148nt.composer.main.cover.presenter;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UriFileUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.SingleThreadTask;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.cover.util.CoverStickerDownloadUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskDownloadCoverSticker extends SingleThreadTask<InputValues, ResultValues> {
    private static final String TAG = Logger.createCoverTag("TaskDownloadCoverSticker");
    private Runnable mRunnable;
    private final Handler mHandler = new Handler();
    private int mErrorCode = 0;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ResultValues implements Task.ResultValues {
        private final Context mContext;
        private final int mErrorCode;
        private final List<String> mPathList;

        public ResultValues(Context context, List<String> list, int i) {
            this.mContext = context;
            this.mPathList = list;
            this.mErrorCode = i;
        }

        public Context getContext() {
            return this.mContext;
        }

        public int getErrorCode() {
            return this.mErrorCode;
        }

        public List<String> getPathList() {
            return this.mPathList;
        }
    }

    private String downloadStickerFile(Context context, String str, Uri uri) {
        CoverStickerDownloadUtils.DownloadFileResult downloadFileResultDownloadFile = CoverStickerDownloadUtils.downloadFile(context, str, uri);
        if (downloadFileResultDownloadFile == null) {
            setErrorCode(6);
            return "";
        }
        int i = downloadFileResultDownloadFile.resultCode;
        if (i != 0) {
            if (i == 1) {
                setErrorCode(5);
                return "";
            }
            if (i == 2) {
                setErrorCode(2);
                return "";
            }
            if (i != 3) {
                setErrorCode(6);
                return "";
            }
            setErrorCode(1);
            return "";
        }
        if (TextUtils.isEmpty(downloadFileResultDownloadFile.filePath)) {
            setErrorCode(6);
            return "";
        }
        String str2 = downloadFileResultDownloadFile.filePath;
        if (!AbstractC2322a.m1607A(str2)) {
            setErrorCode(3);
            return "";
        }
        Logger.m11003i(TAG, "downloadCoverSticker#, path : " + Logger.getEncode(str2));
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<String> downloadStickers(Context context, String str, List<Uri> list) {
        Logger.m10999d(TAG, "downloadStickers");
        showProgressDialog();
        ArrayList arrayList = new ArrayList();
        Iterator<Uri> it = list.iterator();
        while (it.hasNext()) {
            String strDownloadStickers = downloadStickers(context, str, it.next());
            if (!TextUtils.isEmpty(strDownloadStickers)) {
                arrayList.add(strDownloadStickers);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runNotifyCallback(final boolean z, final ResultValues resultValues) {
        Runnable runnable = this.mRunnable;
        if (runnable != null) {
            this.mHandler.removeCallbacks(runnable);
        }
        Runnable runnable2 = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.cover.presenter.TaskDownloadCoverSticker.1
            @Override // java.lang.Runnable
            public void run() {
                TaskDownloadCoverSticker.this.notifyCallback(z, resultValues);
                TaskDownloadCoverSticker.this.mRunnable = null;
                TaskDownloadCoverSticker.this.clear();
            }
        };
        this.mRunnable = runnable2;
        this.mHandler.post(runnable2);
    }

    private void setErrorCode(int i) {
        AbstractC0000a.m3D(i, "setErrorCode : ", TAG);
        this.mErrorCode = i;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.SingleThreadTask, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void clear() {
        Logger.m11003i(TAG, "clear ");
        Runnable runnable = this.mRunnable;
        if (runnable != null) {
            this.mHandler.removeCallbacks(runnable);
            this.mRunnable = null;
        }
        dismissProgressDialog();
        this.mErrorCode = 0;
        super.clear();
    }

    public boolean clearCachePath(String str, String str2) {
        File[] fileArrListFiles;
        Logger.m11003i(TAG, "clearCachePath# cachePath : " + str + ", stickerFilePath : " + str2);
        File file = new File(str);
        if (!file.exists() || !file.isDirectory() || (fileArrListFiles = file.listFiles()) == null) {
            return false;
        }
        for (File file2 : fileArrListFiles) {
            if (file2.getAbsolutePath().contains(str2) || file2.length() <= 0) {
                FileUtils.deleteFile(file2);
            }
        }
        return true;
    }

    public void dismissProgressDialog() {
    }

    public void showProgressDialog() {
        if (this.mRunnable != null) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.cover.presenter.TaskDownloadCoverSticker.2
            @Override // java.lang.Runnable
            public void run() {
                TaskDownloadCoverSticker.this.mRunnable = null;
            }
        };
        this.mRunnable = runnable;
        this.mHandler.post(runnable);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues implements Task.InputValues {
        private final String mCachePath;
        private final Context mContext;
        private List<Uri> mUriList;

        public InputValues(Context context, List<Uri> list, String str) {
            this(context, str);
            this.mUriList = list;
        }

        public InputValues(Context context, String str) {
            this.mContext = context;
            this.mCachePath = str;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(final InputValues inputValues) {
        final Context context = inputValues.mContext;
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(TAG));
        this.mExecutorService = executorServiceNewSingleThreadExecutor;
        executorServiceNewSingleThreadExecutor.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.cover.presenter.TaskDownloadCoverSticker.3
            @Override // java.lang.Runnable
            public void run() {
                Logger.startTime(String.valueOf(hashCode()), TaskDownloadCoverSticker.TAG, "download cover sticker start. ");
                List arrayList = new ArrayList();
                boolean z = true;
                if (inputValues.mUriList != null && !inputValues.mUriList.isEmpty()) {
                    arrayList = TaskDownloadCoverSticker.this.downloadStickers(context, inputValues.mCachePath, (List<Uri>) inputValues.mUriList);
                    if (inputValues.mUriList.size() != arrayList.size()) {
                        z = false;
                    }
                }
                Logger.endTime(String.valueOf(hashCode()), TaskDownloadCoverSticker.TAG, "download cover sticker end. ");
                TaskDownloadCoverSticker taskDownloadCoverSticker = TaskDownloadCoverSticker.this;
                taskDownloadCoverSticker.runNotifyCallback(z, new ResultValues(context, arrayList, taskDownloadCoverSticker.mErrorCode));
            }
        });
    }

    private String downloadStickers(Context context, String str, Uri uri) {
        String str2 = TAG;
        Logger.m10999d(str2, "downloadStickers# uri : " + uri);
        String mimeType = UriFileUtils.getMimeType(context, uri);
        if (mimeType != null && mimeType.contains("zip")) {
            String fileNameFromUri = CoverStickerDownloadUtils.getFileNameFromUri(uri);
            String absolutePath = "";
            if (!TextUtils.isEmpty(fileNameFromUri)) {
                try {
                    absolutePath = new File(str, fileNameFromUri).getAbsolutePath();
                    clearCachePath(str, absolutePath);
                } catch (Exception e) {
                    AbstractC8014b.m7207i("downloadStickers# clearCachePath Exception : ", e, TAG);
                }
            }
            String strDownloadStickerFile = downloadStickerFile(context, str, uri);
            if (TextUtils.isEmpty(strDownloadStickerFile)) {
                Logger.m11000e(TAG, "downloadStickers# stickerFilePath has some problem. uri:" + Logger.getEncode(uri.toString()));
                return null;
            }
            String str3 = TAG;
            Logger.m10999d(str3, "downloadStickers# stickerFilePath : " + strDownloadStickerFile + ", newStickerFilePath : " + absolutePath);
            if (TextUtils.isEmpty(absolutePath)) {
                Logger.m11003i(str3, "downloadStickers# stickerFileName is empty. uri:" + Logger.getEncode(uri.toString()));
                return strDownloadStickerFile;
            }
            FileUtils.moveFile(strDownloadStickerFile, absolutePath);
            return absolutePath;
        }
        AbstractC8014b.m7198D("downloadStickers# mimeType is wrong. ", mimeType, str2);
        setErrorCode(4);
        return null;
    }
}
