package com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.task;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager;
import com.samsung.android.sdk.composer.pdf.SpenNotePdfImport;
import com.samsung.android.support.senl.p145cm.base.framework.sem.support.StorageManagerUtil;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.share.ShareUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.share.MakeUriHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskMakePdf;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskShareCommon;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.UriHelper;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.PwDocInfo;
import com.sec.android.diagmonagent.log.provider.utils.BundleContract;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PwTaskSavePdf extends TaskMakePdf {
    public static final int ERR_CONVERT_PDF = 2;
    public static final int ERR_IO = 1;
    public static final int ERR_NONE = 0;
    private static final boolean FEATURE_BACKUP_NOTE = false;
    private static final String TAG = Logger.createTag("PwTaskSavePdf");
    private static final String TEMP_RENAME_FILE_POSTFIX = "_origin_bak";
    private static final String TEMP_SAVED_FILE_POSTFIX = "_bak";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ResultValues extends TaskShareCommon.ResultValues {
        private int mErrorCode;

        public ResultValues(Context context) {
            super(context);
        }

        public boolean isIOError() {
            return this.mErrorCode == 1;
        }

        public boolean isNoneError() {
            return this.mErrorCode == 0;
        }

        public ResultValues(Context context, int i) {
            super(context);
            this.mErrorCode = i;
        }

        public ResultValues(Context context, String str, Uri uri) {
            super(context, str, uri);
        }

        public ResultValues(Context context, String str, int i) {
            super(context, str, null);
            this.mErrorCode = i;
        }
    }

    private void backupToDocFile(TaskMakePdf.InputValues inputValues) {
    }

    private String backupToPdfFile(String str, TaskMakePdf.InputValues inputValues) {
        File saveAsFixedDir = ShareUtils.getSaveAsFixedDir(inputValues.getContext());
        if (saveAsFixedDir == null) {
            Logger.m11000e(TAG, "backupToPdfFile# dir is null");
            return null;
        }
        String strGenerateUniqueFilePath = FileUtils.generateUniqueFilePath(saveAsFixedDir.getPath(), FileUtils.getFileNameFromFilePath(inputValues.getDestPath()));
        File file = new File(str);
        if (!file.exists()) {
            Logger.m11000e(TAG, "backupToPdfFile# srcFile doesn't exist");
            return null;
        }
        try {
            FileUtils.copyFile(file, new File(strGenerateUniqueFilePath));
            Logger.m11002f(TAG, "backupToPdfFile# copyFile ");
            return strGenerateUniqueFilePath;
        } catch (IOException e) {
            Logger.m11002f(TAG, "backupToPdfFile# copyFile error = " + e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getFileNameFromFilePath(Context context, String str) {
        try {
            for (StorageVolume storageVolume : ((StorageManager) context.getSystemService(BundleContract.STORAGE)).getStorageVolumes()) {
                String path = StorageManagerUtil.getPath(storageVolume);
                if (str.startsWith(path)) {
                    return str.replace(path, storageVolume.getDescription(context));
                }
            }
            return str;
        } catch (Exception e) {
            AbstractC8014b.m7205g(e, new StringBuilder("getFileNameFromFilePath# error ="), TAG);
            return str;
        }
    }

    private boolean isValidPdf(Context context, String str) {
        SpenNotePdfImport spenNotePdfImport = new SpenNotePdfImport(context);
        try {
            Bitmap pageBitmap = spenNotePdfImport.getPageBitmap(str, "", 0, 1000.0f);
            if (pageBitmap == null) {
                Logger.m11002f(TAG, "isValidPdf# bitmap is null");
                return false;
            }
            pageBitmap.recycle();
            spenNotePdfImport.close();
            return true;
        } catch (Exception e) {
            Logger.m11002f(TAG, "isValidPdf# " + e.getMessage());
            return false;
        } finally {
            spenNotePdfImport.close();
        }
    }

    private boolean renameTo(String str, TaskMakePdf.InputValues inputValues) {
        String destPath = inputValues.getDestPath();
        File file = new File(destPath);
        String str2 = TAG;
        Logger.m10999d(str2, "renameTo# " + Logger.getEncode(str) + "\t" + Logger.getEncode(destPath));
        if (((PwDocInfo) inputValues.getComposerModel().getDocInfo()).getPdfFileInfo().isSaveAs()) {
            if (!new File(str).renameTo(file)) {
                Logger.m11002f(str2, "renameTo# fail to rename src to dest save as");
                return false;
            }
            UriHelper.requestScanFile(inputValues.getContext(), destPath, Constants.MIME_PDF);
            Logger.m10999d(str2, "renameTo# SaveAs");
            return true;
        }
        File file2 = new File(AbstractC0541b.m756B(destPath, TEMP_RENAME_FILE_POSTFIX));
        if (!file.renameTo(file2)) {
            Logger.m11002f(str2, "renameTo# fail to rename dest file");
            return false;
        }
        if (file.exists()) {
            Logger.m11002f(str2, "renameTo# dest file is exist after dest rename");
            return false;
        }
        if (!new File(str).renameTo(file)) {
            Logger.m11002f(str2, "renameTo# fail to rename src to dest");
            return false;
        }
        if (inputValues.isWidgetMyfiles()) {
            updateUriForWidgetMyfiles(inputValues.getContext(), destPath);
        } else {
            UriHelper.requestScanFile(inputValues.getContext(), destPath, Constants.MIME_PDF);
        }
        if (!file2.delete()) {
            Logger.m11000e(str2, "renameTo# fail to delete destBackupFile");
        }
        return true;
    }

    private static void updateUriForWidgetMyfiles(final Context context, String str) {
        MediaScannerConnection.scanFile(context, new String[]{str}, new String[]{Constants.MIME_PDF}, new MediaScannerConnection.MediaScannerConnectionClient() { // from class: com.samsung.android.support.senl.nt.composer.main.pdfwriter.presenter.task.PwTaskSavePdf.1
            @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
            public void onMediaScannerConnected() {
                Logger.m10999d(PwTaskSavePdf.TAG, "updateUriForWidgetMyfiles, onMediaScannerConnected");
            }

            @Override // android.media.MediaScannerConnection.OnScanCompletedListener
            public void onScanCompleted(String str2, Uri uri) {
                String str3 = PwTaskSavePdf.TAG;
                StringBuilder sb = new StringBuilder("updateUriForWidgetMyfiles, onScanCompleted: ");
                sb.append(uri == null ? null : Logger.getEncode(uri.toString()));
                Logger.m11003i(str3, sb.toString());
                if (Build.VERSION.SDK_INT < 29 || uri == null) {
                    return;
                }
                Logger.m11003i(PwTaskSavePdf.TAG, "pdf reader, send uri to myfiles: ");
                Bundle bundle = new Bundle();
                bundle.putParcelable("UPDATED_URI", uri);
                context.getContentResolver().call("myfiles", "UPDATE_SHORTCUT", (String) null, bundle);
            }
        });
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskMakePdf, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskShareCommon, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void cancel(Task.ICancelCallback iCancelCallback) {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskShareCommon
    public Task.Callback<TaskShareCommon.ResultValues> getDefaultCallback() {
        final Task.Callback defaultCallback = super.getDefaultCallback();
        return new Task.Callback<TaskShareCommon.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.pdfwriter.presenter.task.PwTaskSavePdf.2
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(TaskShareCommon.ResultValues resultValues) {
                defaultCallback.onError(resultValues);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(TaskShareCommon.ResultValues resultValues) {
                if (resultValues == null || TextUtils.isEmpty(resultValues.getPath())) {
                    Logger.m11000e(PwTaskSavePdf.TAG, "TaskShareCommon# onSuccess result error.");
                    return;
                }
                String fileNameFromFilePath = PwTaskSavePdf.this.getFileNameFromFilePath(resultValues.getContext(), resultValues.getPath());
                if (TextUtils.isEmpty(fileNameFromFilePath)) {
                    return;
                }
                String string = resultValues.getContext().getString(C9086R.string.save_as_file_saved, fileNameFromFilePath);
                if ((resultValues instanceof ResultValues) && !((ResultValues) resultValues).isNoneError()) {
                    string = resultValues.getContext().getString(C9086R.string.composer_something_went_wrong) + "\n" + string;
                }
                ToastHandler.showEncodingLog(resultValues.getContext(), string, 0);
            }
        };
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskMakePdf
    public void saveAsPdfFile(TaskMakePdf.InputValues inputValues) {
        int pageDefaultHeight = inputValues.getComposerModel().getDoc().getPageDefaultHeight();
        int iLastIndexOf = inputValues.getDestPath().lastIndexOf(File.separator) + 1;
        MakeUriHelper.MakePdfResult makePdfResultMakePdf = this.mShareToOtherAppHandler.getMakeUriHelper().makePdf(inputValues.getContext(), this.mSpenNotePdfExport, pageDefaultHeight, inputValues.getDestPath().substring(0, iLastIndexOf) + '.' + inputValues.getDestPath().substring(iLastIndexOf) + TEMP_SAVED_FILE_POSTFIX, false);
        String resultPath = makePdfResultMakePdf.getResultPath();
        if (TextUtils.isEmpty(resultPath) || !AbstractC2322a.m1607A(resultPath)) {
            Logger.m11002f(TAG, "saveAsPdfFile# fail");
            notifyCallback(false, new ResultValues(inputValues.getContext(), makePdfResultMakePdf.getResultType() != ISpenNotePdfManager.ResultType.RESULT_TYPE_ERROR_IO ? 0 : 1));
            return;
        }
        if (!isValidPdf(inputValues.getContext(), resultPath)) {
            Logger.m11000e(TAG, "saveAsPdfFile# invalid pdf");
            backupToDocFile(inputValues);
            notifyCallback(false, new ResultValues(inputValues.getContext(), 2));
        } else {
            if (renameTo(resultPath, inputValues)) {
                notifyCallback(true, new ResultValues(inputValues.getContext(), inputValues.getDestPath(), (Uri) null));
                return;
            }
            String strBackupToPdfFile = backupToPdfFile(resultPath, inputValues);
            if (TextUtils.isEmpty(strBackupToPdfFile)) {
                notifyCallback(false, new ResultValues(inputValues.getContext(), 2));
            } else {
                notifyCallback(true, new ResultValues(inputValues.getContext(), strBackupToPdfFile, 2));
            }
        }
    }
}
