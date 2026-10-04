package com.samsung.android.support.senl.p148nt.app.trigger.task;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.converter.ConverterDialogManager;
import com.samsung.android.support.senl.p148nt.base.common.util.FileExtensions;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UriFileUtils;
import com.samsung.android.support.senl.p148nt.model.importer.task.ImportSdocTask;
import com.samsung.android.support.senl.p148nt.model.importer.task.ImportSdocXTask;
import com.samsung.android.support.senl.p148nt.model.importer.task.ImportTask;
import com.samsung.android.support.senl.p148nt.model.importer.task.param.ImportSdocParam;
import com.samsung.android.support.senl.p148nt.model.importer.task.param.ImportSdocXParam;
import com.samsung.android.support.senl.p148nt.model.importer.utils.ImportUtils;
import java.io.File;
import p259y0.AbstractC14517a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class TriggerImportTask extends AbsTriggerTask<Uri, Void, Result> {
    private static final String IMPORT_FAIL_WITH_MSG = "IMPORT_FAIL_WITH_MSG";
    private static final String INTERNAL_DIR_PATH;
    private static final String INTERNAL_FILE_PATH = "INTERNAL_FILE_PATH";
    public static final String MSG_STORAGE_IS_FULL = "storage is full";
    private static final String SDOCX_IMPORT_SUCCESS = "SDOCX_IMPORT_SUCCESS";
    private static final String SDOC_IMPORT_SUCCESS = "SDOC_IMPORT_SUCCESS";
    private static final String TAG = "TriggerImportTask";
    private static final String TRIGGER_IMPORT_PREFIX = "TrImport";
    private static final String UNSUPPORTED_DOC_TYPE = "UNSUPPORTED_DOC_TYPE";
    private final ICallback mCallback;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ICallback {
        void onFailed(String str);

        void onFailedUnsupportedDocType(String str);

        void onFailedWithError(boolean z, String str);

        void onSdocImported(String str);

        void onSdocxImported(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Result {
        private boolean mIsUnsupportedVersion;
        private String mResult = "";
        private String mPath = "";
        private String mUuid = "";
        private String mMsg = "";

        public String getMsg() {
            return this.mMsg;
        }

        public String getPath() {
            return this.mPath;
        }

        public String getResult() {
            return this.mResult;
        }

        public String getUuid() {
            return this.mUuid;
        }

        public boolean isUnsupportedVersion() {
            return this.mIsUnsupportedVersion;
        }

        public void setMsg(String str) {
            this.mMsg = str;
        }

        public Result setPath(String str) {
            this.mPath = str;
            return this;
        }

        public Result setResult(String str) {
            this.mResult = str;
            return this;
        }

        public void setUnsupportedVersion() {
            this.mIsUnsupportedVersion = true;
        }

        public void setUuid(String str) {
            this.mUuid = str;
        }
    }

    static {
        StringBuilder sb = new StringBuilder();
        String str = File.separator;
        INTERNAL_DIR_PATH = AbstractC2322a.m1626p(sb, str, "com.samsung.android.app.notes", str);
    }

    public TriggerImportTask(Context context, ConverterDialogManager converterDialogManager, ICallback iCallback) {
        super(context, converterDialogManager);
        this.mCallback = iCallback;
    }

    private String getPath(Context context, Uri uri) {
        if (!"content".equals(uri.getScheme())) {
            return "file".equals(uri.getScheme()) ? uri.getPath() : "";
        }
        String path = UriFileUtils.getPath(context, uri);
        return TextUtils.isEmpty(path) ? UriFileUtils.getContentName(context.getContentResolver(), uri) : path;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.String] */
    private void importSdoc(Result result) {
        String strNewUUID = UUIDUtils.newUUID(this.mContextRef.get());
        try {
            try {
                if (new ImportSdocTask(new ImportSdocParam().setContext(this.mContextRef.get()).setUuid(strNewUUID).setExternalPath(result.getPath()).setExecutePostOperation(false).setCaller(TAG)).setImported(true).call().booleanValue()) {
                    result.setResult(SDOC_IMPORT_SUCCESS).setUuid(strNewUUID);
                } else {
                    result.setResult(IMPORT_FAIL_WITH_MSG).setMsg("convertFromUri, failed to import import sdoc: " + strNewUUID);
                }
            } catch (Exception e) {
                result.setResult(IMPORT_FAIL_WITH_MSG).setMsg("convertFromUri, exception during import sdoc: " + strNewUUID + " / e : " + e.getMessage());
            }
            result = result.getPath();
            AbstractC14517a.m15140Y(result);
        } catch (Throwable th) {
            AbstractC14517a.m15140Y(result.getPath());
            throw th;
        }
    }

    private void importSdocx(final Result result) {
        String strCreateNewUuid = ImportUtils.createNewUuid(this.mContextRef.get(), result.getPath());
        try {
            try {
                if (new ImportSdocXTask(new ImportSdocXParam().setContext(this.mContextRef.get()).setUuid(strCreateNewUuid).setExternalPath(result.getPath()).setCaller(TAG)).setImported(true).setImportTaskListener(new ImportTask.ListerImpl() { // from class: com.samsung.android.support.senl.nt.app.trigger.task.TriggerImportTask.1
                    @Override // com.samsung.android.support.senl.nt.model.importer.task.ImportTask.ListerImpl, com.samsung.android.support.senl.p148nt.model.importer.task.ImportTaskListener
                    public void onUnsupportedVersionError(@NonNull String str, @NonNull String str2) {
                        result.setUnsupportedVersion();
                    }
                }).call().booleanValue()) {
                    result.setResult(SDOCX_IMPORT_SUCCESS).setUuid(strCreateNewUuid);
                } else {
                    result.setResult(IMPORT_FAIL_WITH_MSG).setMsg("convertFromUri, failed to import sdocx: " + strCreateNewUuid);
                }
            } catch (Exception e) {
                result.setResult(IMPORT_FAIL_WITH_MSG).setMsg("convertFromUri, exception during import sdocx: " + strCreateNewUuid + " / e : " + e.getMessage());
            }
            AbstractC14517a.m15140Y(result.getPath());
        } catch (Throwable th) {
            AbstractC14517a.m15140Y(result.getPath());
            throw th;
        }
    }

    private void notifyCallback(Result result) {
        MainLogger.m7258i(TAG, "notifyCallback, result : " + result.getResult());
        String result2 = result.getResult();
        result2.getClass();
        switch (result2) {
            case "UNSUPPORTED_DOC_TYPE":
                break;
            case "SDOC_IMPORT_SUCCESS":
                this.mCallback.onSdocImported(result.getUuid());
                break;
            case "IMPORT_FAIL_WITH_MSG":
            case "INTERNAL_FILE_PATH":
                this.mCallback.onFailedWithError(result.isUnsupportedVersion(), result.getMsg());
                break;
            case "SDOCX_IMPORT_SUCCESS":
                this.mCallback.onSdocxImported(result.getUuid());
                break;
            default:
                this.mCallback.onFailed("unexpected case");
                break;
        }
    }

    public Result downloadFile(Context context, Uri uri) {
        Result result = new Result();
        String path = uri.getPath();
        if (path != null && path.contains(INTERNAL_DIR_PATH)) {
            MainLogger.m7259w(TAG, "downloadFile, invalid file path: " + MainLogger.getEncode(path));
            result.setResult(INTERNAL_FILE_PATH);
            return result;
        }
        String strExtractFile = FileUtils.extractFile(getPath(context, uri));
        if (TextUtils.isEmpty(strExtractFile)) {
            String extensionFromUri = FileUtils.getExtensionFromUri(context, uri);
            if (TextUtils.isEmpty(extensionFromUri)) {
                MainLogger.m7259w(TAG, "downloadFile, failed to extract fileName");
                return result;
            }
            strExtractFile = FileExtensions.getFileNameByTime(TRIGGER_IMPORT_PREFIX, extensionFromUri);
        }
        String strM15149i = AbstractC14517a.m15149i(context);
        if (TextUtils.isEmpty(strM15149i)) {
            MainLogger.m7259w(TAG, "downloadFile, failed to get cache directory");
            return result;
        }
        StringBuilder sbM1324q = AbstractC1974b.m1324q(strM15149i);
        sbM1324q.append(File.separator);
        sbM1324q.append(strExtractFile);
        String string = sbM1324q.toString();
        FileUtils.deleteFile(string);
        int resultSaveUriToFile = UriFileUtils.getResultSaveUriToFile(context, uri, string, false);
        if (resultSaveUriToFile == 0) {
            String pathWithDocumentExtension = UriFileUtils.getPathWithDocumentExtension(context, string);
            MainLogger.m7254d(TAG, "downloadFile, path: " + MainLogger.getEncode(pathWithDocumentExtension));
            return result.setPath(pathWithDocumentExtension);
        }
        if (!TextUtils.isEmpty(string)) {
            FileUtils.deleteFile(string);
        }
        MainLogger.m7259w(TAG, "downloadFile, failed to download a file from Uri");
        if (resultSaveUriToFile == 3) {
            result.setResult(IMPORT_FAIL_WITH_MSG).setMsg(MSG_STORAGE_IS_FULL);
        }
        return result;
    }

    @Override // android.os.AsyncTask
    public void onPreExecute() {
        super.onPreExecute();
        if (this.mDialogManager.showImportProgressDialog()) {
            return;
        }
        this.mCallback.onFailed("onPreExecute, cannot create a dialog");
        cancel(true);
    }

    @Override // android.os.AsyncTask
    public Result doInBackground(Uri... uriArr) {
        Thread.currentThread().setName("TriggerImportTask-thread");
        Result resultDownloadFile = downloadFile(this.mContextRef.get(), uriArr[0]);
        if (!resultDownloadFile.getResult().isEmpty()) {
            return resultDownloadFile;
        }
        String path = resultDownloadFile.getPath();
        if (path.endsWith(".sdoc")) {
            importSdoc(resultDownloadFile);
            return resultDownloadFile;
        }
        if (path.endsWith(".sdocx")) {
            importSdocx(resultDownloadFile);
            return resultDownloadFile;
        }
        this.mCallback.onFailedUnsupportedDocType(resultDownloadFile.getPath());
        resultDownloadFile.setResult(UNSUPPORTED_DOC_TYPE);
        return resultDownloadFile;
    }

    @Override // android.os.AsyncTask
    public void onPostExecute(Result result) {
        super.onPostExecute(result);
        dismissDialog();
        notifyCallback(result);
        release();
    }
}
