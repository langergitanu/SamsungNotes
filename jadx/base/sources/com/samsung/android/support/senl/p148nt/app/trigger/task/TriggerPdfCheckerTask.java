package com.samsung.android.support.senl.p148nt.app.trigger.task;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager;
import com.samsung.android.sdk.composer.pdf.SpenNotePdfImport;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constructor.ToolConstructor;
import com.samsung.android.support.senl.p148nt.app.converter.ConverterDialogManager;
import com.samsung.android.support.senl.p148nt.base.common.util.ContentPickerUtils;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.AddPdfUtil;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class TriggerPdfCheckerTask extends AbsTriggerTask<Uri, Void, Result> {
    private static final String TAG = "TriggerPdfCheckerTask";
    private final Callback mCallback;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Callback {
        @MainThread
        void onDone(Result result);

        void onFailed(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Result {
        final String mDownloadedPdfPath;
        int mErrorCode = 0;
        boolean mIsOpenReader;
        final Uri mUri;

        public Result(Uri uri, String str) {
            this.mUri = uri;
            this.mDownloadedPdfPath = str;
        }

        public String getDownloadedPdfPath() {
            return this.mDownloadedPdfPath;
        }

        public int getErrorCode() {
            return this.mErrorCode;
        }

        public Uri getUri() {
            return this.mUri;
        }

        public boolean isOpenReader() {
            return this.mIsOpenReader;
        }

        public void setErrorCode(int i) {
            this.mErrorCode = AddPdfUtil.getConvertErrorCode(i);
        }

        public void setOpenReader(boolean z) {
            this.mIsOpenReader = z;
        }

        public void showErrorToast(Context context) {
            AddPdfUtil.showErrorToast(context, this.mErrorCode, true);
        }
    }

    public TriggerPdfCheckerTask(Context context, ConverterDialogManager converterDialogManager, Callback callback) {
        super(context, converterDialogManager);
        this.mCallback = callback;
    }

    private void deleteFile(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(str);
        if (!file.exists() || file.delete()) {
            return;
        }
        Logger.m8697d(TAG, "doInBackground# fail to delete file");
    }

    @Override // com.samsung.android.support.senl.p148nt.app.trigger.task.AbsTriggerTask, android.os.AsyncTask
    public void onCancelled() {
        Logger.m8697d(TAG, "onCancelled");
        super.onCancelled();
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        if (this.mDialogManager.showPdfCheckerProgressDialog()) {
            return;
        }
        this.mCallback.onFailed("onPreExecute#, cannot create a dialog");
        cancel(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0087  */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Result doInBackground(Uri... uriArr) {
        boolean zEquals;
        Context applicationContext = this.mContextRef.get().getApplicationContext();
        File cacheDir = applicationContext.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        ContentPickerUtils.DownloadFileResult downloadFileResultDownloadPdf = ContentPickerUtils.downloadPdf(applicationContext, cacheDir.getAbsolutePath(), uriArr[0]);
        if (isCancelled()) {
            return null;
        }
        Result result = new Result(uriArr[0], downloadFileResultDownloadPdf.mFilePath);
        int i = downloadFileResultDownloadPdf.mSaveResult;
        if (i != 0) {
            if (i == 1) {
                result.setErrorCode(16777216);
            } else if (i == 2) {
                result.setErrorCode(131072);
            } else if (i == 3) {
                result.setErrorCode(65536);
            }
            deleteFile(downloadFileResultDownloadPdf.mFilePath);
            return result;
        }
        SpenNotePdfImport spenNotePdfImportMakeSpenNotePdfImport = ToolConstructor.makeSpenNotePdfImport(applicationContext);
        String str = downloadFileResultDownloadPdf.mFilePath;
        boolean zHasPassword = str != null ? spenNotePdfImportMakeSpenNotePdfImport.hasPassword(str) : false;
        if (zHasPassword) {
            result.setErrorCode(4194304);
        } else {
            String str2 = downloadFileResultDownloadPdf.mFilePath;
            if (str2 != null) {
                zEquals = ISpenNotePdfManager.ResultType.RESULT_TYPE_ERROR_PROTECTED.equals(spenNotePdfImportMakeSpenNotePdfImport.hasOwnerPermission(str2, ""));
                if (zEquals) {
                    result.setErrorCode(8388608);
                }
                Logger.m8702i(TAG, "hasPassword: " + zHasPassword + " isProtected: " + zEquals);
                result.setOpenReader(!zHasPassword || zEquals);
                return result;
            }
            Logger.m8698e(TAG, "doInBackground# File path is null");
        }
        zEquals = false;
        Logger.m8702i(TAG, "hasPassword: " + zHasPassword + " isProtected: " + zEquals);
        result.setOpenReader(!zHasPassword || zEquals);
        return result;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Result result) {
        Logger.m8697d(TAG, "onPostExecute");
        dismissDialog();
        this.mCallback.onDone(result);
        release();
    }
}
