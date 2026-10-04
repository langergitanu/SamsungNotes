package com.samsung.android.support.senl.p148nt.app.main.common.task;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.bixby2.state.StateHandler;
import com.samsung.android.sdk.composer.pdf.ISpenNotePdfManager;
import com.samsung.android.sdk.vexkit.scanner.VexDocumentScanConstants;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.common.FolderConstants;
import com.samsung.android.support.senl.p148nt.app.common.NotesConstants;
import com.samsung.android.support.senl.p148nt.app.common.log.MainLogger;
import com.samsung.android.support.senl.p148nt.app.common.util.FeatureUtils;
import com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask;
import com.samsung.android.support.senl.p148nt.app.settings.importnotes.common.request.ImportHandler;
import com.samsung.android.support.senl.p148nt.base.common.util.ContentPickerUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.AddPdfUtil;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.model.importer.task.ImportPDFTask;
import com.samsung.android.support.senl.p148nt.model.importer.task.ImportTask;
import com.samsung.android.support.senl.p148nt.model.importer.task.param.ImportPdfParam;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.TestOnly;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 @2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004=>?@B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u0012J\u0006\u0010\u001e\u001a\u00020\u0011J\b\u0010\u001f\u001a\u00020\u001bH\u0016J\u0012\u0010 \u001a\u00020\u001b2\b\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0016J \u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\u00112\u0006\u0010$\u001a\u00020\u0011H\u0002J\b\u0010%\u001a\u00020\u001bH\u0016J\u0018\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\u0007H\u0002J\u001a\u0010*\u001a\u0004\u0018\u00010\u000e2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0007H\u0002J\u0010\u0010.\u001a\u00020\u001b2\u0006\u0010/\u001a\u00020\u0011H\u0005J\u0012\u00100\u001a\u00020\u001b2\b\u00101\u001a\u0004\u0018\u00010\u000eH\u0005J\u0010\u00102\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020\u0007H\u0005J\u0012\u00103\u001a\u00020\u001b2\b\u00101\u001a\u0004\u0018\u00010\u000eH\u0005J\u0010\u00104\u001a\u00020'2\u0006\u00105\u001a\u000206H\u0002J\u0010\u00107\u001a\u00020\u001b2\u0006\u0010\u0013\u001a\u00020\u0011H\u0002J\b\u00108\u001a\u00020\u001bH\u0002J\b\u00109\u001a\u00020\u001bH\u0005J\b\u0010:\u001a\u00020\u000eH\u0016J\b\u0010;\u001a\u00020<H\u0016R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u00020\u00118\u0004@\u0004X\u0085\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/common/task/PdfImportTask;", "Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTask;", "Lcom/samsung/android/support/senl/nt/app/main/common/task/PdfImportTask$TaskParams;", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "pdfUris", "", "Landroid/net/Uri;", "<init>", "(Landroid/app/Activity;Ljava/util/List;)V", "getPdfUris", "()Ljava/util/List;", "taskParams", "cacheDir", "", "contracts", "", "", "Lcom/samsung/android/support/senl/nt/app/main/common/task/PdfImportTask$Contract;", "errorCode", "getErrorCode", "()I", "setErrorCode", "(I)V", "result", "Lcom/samsung/android/support/senl/nt/app/main/common/task/PdfImportTask$Result;", "registerContract", "", "hashCode", "contract", "getPdfUriCount", "onPreExecute", "execute", "onTaskProgressed", ImportHandler.KEY_TOTAL, "progress", "fail", "onPostExecute", "importPdfWithoutOpenComposer", "", NotesConstants.KEY_FOLDER_UUID, "uri", "downloadPdfFileToCacheDir", StateHandler.KEY_APP_STATE, "Landroid/content/Context;", VexDocumentScanConstants.KEY_PDF_URI, "validateDownloadPdfResult", "saveResult", "validateFilePath", "filePath", "validateFileSizeFromUri", "validateFileSizeFromPath", "isValidFileSize", "fileSize", "", "addErrorCode", "initCacheDir", "clearCacheDir", "getTag", "getResult", "Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTask$Result;", "Contract", "TaskParams", "Result", "Companion", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class PdfImportTask extends WorkerTask<TaskParams> {

    @NotNull
    public static final String TAG = "PdfImportTask";

    @NotNull
    private String cacheDir;

    @NotNull
    private final Map<Integer, Contract> contracts;

    @TestOnly
    private int errorCode;

    @NotNull
    private final List<Uri> pdfUris;

    @NotNull
    private Result result;

    @Nullable
    private TaskParams taskParams;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J \u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H&¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/common/task/PdfImportTask$Contract;", "", "onPostExecute", "", "onTaskProgressed", ImportHandler.KEY_TOTAL, "", "progress", "fail", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Contract {
        void onPostExecute();

        void onTaskProgressed(int total, int progress, int fail);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u0003J\u0006\u0010\u0012\u001a\u00020\u0003J\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u0003J\u0006\u0010\u0014\u001a\u00020\u0003J\u000e\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u000e\u001a\u00020\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/common/task/PdfImportTask$Result;", "Lcom/samsung/android/support/senl/nt/app/main/common/task/WorkerTask$Result;", "hashCode", "", "<init>", "(I)V", "getHashCode", "()I", "tag", "", "getTag", "()Ljava/lang/String;", "successCount", "errorCode", "isCancelled", "", "setSuccessCount", "", "getSuccessCount", "setErrorCode", "getErrorCode", "setCancelled", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Result implements WorkerTask.Result {
        private int errorCode;
        private final int hashCode;
        private boolean isCancelled;
        private int successCount;

        public Result(int i) {
            this.hashCode = i;
        }

        public final int getErrorCode() {
            return this.errorCode;
        }

        @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Result
        public int getHashCode() {
            return this.hashCode;
        }

        public final int getSuccessCount() {
            return this.successCount;
        }

        @Override // com.samsung.android.support.senl.nt.app.main.common.task.WorkerTask.Result
        @NotNull
        public String getTag() {
            return PdfImportTask.TAG;
        }

        /* JADX INFO: renamed from: isCancelled, reason: from getter */
        public final boolean getIsCancelled() {
            return this.isCancelled;
        }

        public final void setCancelled(boolean isCancelled) {
            this.isCancelled = isCancelled;
        }

        public final void setErrorCode(int errorCode) {
            this.errorCode = errorCode;
        }

        public final void setSuccessCount(int successCount) {
            this.successCount = successCount;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/app/main/common/task/PdfImportTask$TaskParams;", "", NotesConstants.KEY_FOLDER_UUID, "", "<init>", "(Ljava/lang/String;)V", "getFolderUuid", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "ntApp_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final /* data */ class TaskParams {

        @NotNull
        private final String folderUuid;

        public TaskParams(@NotNull String folderUuid) {
            Intrinsics.checkNotNullParameter(folderUuid, "folderUuid");
            this.folderUuid = folderUuid;
        }

        public static /* synthetic */ TaskParams copy$default(TaskParams taskParams, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = taskParams.folderUuid;
            }
            return taskParams.copy(str);
        }

        @NotNull
        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getFolderUuid() {
            return this.folderUuid;
        }

        @NotNull
        public final TaskParams copy(@NotNull String folderUuid) {
            Intrinsics.checkNotNullParameter(folderUuid, "folderUuid");
            return new TaskParams(folderUuid);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof TaskParams) && Intrinsics.areEqual(this.folderUuid, ((TaskParams) other).folderUuid);
        }

        @NotNull
        public final String getFolderUuid() {
            return this.folderUuid;
        }

        public int hashCode() {
            return this.folderUuid.hashCode();
        }

        @NotNull
        public String toString() {
            return AbstractC0541b.m773o("TaskParams(folderUuid=", this.folderUuid, ")");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public PdfImportTask(@NotNull Activity activity, @NotNull List<? extends Uri> pdfUris) {
        super(activity.hashCode(), null, 2, null);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(pdfUris, "pdfUris");
        this.pdfUris = pdfUris;
        this.contracts = new HashMap();
        this.result = new Result(getHashCode());
        Context applicationContext = BaseUtils.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext);
        File cacheDir = applicationContext.getCacheDir();
        String str = File.separator;
        this.cacheDir = cacheDir + str + getTag() + "_" + hashCode() + str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addErrorCode(int errorCode) {
        this.errorCode = AddPdfUtil.getConvertErrorCode(errorCode) | this.errorCode;
    }

    private final String downloadPdfFileToCacheDir(Context appContext, Uri pdfUri) throws Exception {
        validateFileSizeFromUri(pdfUri);
        String str = this.cacheDir;
        Intrinsics.checkNotNull(str);
        ContentPickerUtils.DownloadFileResult downloadFileResultDownloadPdf$default = ContentPickerUtils.downloadPdf$default(appContext, str, pdfUri, 0L, 8, null);
        validateDownloadPdfResult(downloadFileResultDownloadPdf$default.mSaveResult);
        validateFilePath(downloadFileResultDownloadPdf$default.mFilePath);
        validateFileSizeFromPath(downloadFileResultDownloadPdf$default.mFilePath);
        return downloadFileResultDownloadPdf$default.mFilePath;
    }

    private final boolean importPdfWithoutOpenComposer(String folderUuid, Uri uri) {
        String strDownloadPdfFileToCacheDir;
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext == null) {
            MainLogger.m7259w(TAG, " importPdfWithoutOpenComposer, context is null");
            return false;
        }
        try {
            strDownloadPdfFileToCacheDir = downloadPdfFileToCacheDir(applicationContext, uri);
        } catch (Exception e) {
            e = e;
            strDownloadPdfFileToCacheDir = null;
        }
        try {
            Boolean boolCall = new ImportPDFTask(new ImportPdfParam().setIsNew(true).setContext(applicationContext).setUuid(UUIDUtils.newUUID(applicationContext)).setFolderUuid(folderUuid).setExternalPath(strDownloadPdfFileToCacheDir).setTitle(FileUtils.getFileNameFromUriWithoutExt(applicationContext, uri)).setCaller(TAG)).setImported(true).setImportTaskListener(new ImportTask.ListerImpl() { // from class: com.samsung.android.support.senl.nt.app.main.common.task.PdfImportTask.importPdfWithoutOpenComposer.1
                @Override // com.samsung.android.support.senl.nt.model.importer.task.ImportTask.ListerImpl, com.samsung.android.support.senl.p148nt.model.importer.task.ImportTaskListener
                public void onFail(String uuid, String path, int errorCode, String message) {
                    Intrinsics.checkNotNullParameter(uuid, "uuid");
                    Intrinsics.checkNotNullParameter(path, "path");
                    PdfImportTask.this.addErrorCode(errorCode);
                }
            }).call();
            Intrinsics.checkNotNullExpressionValue(boolCall, "call(...)");
            return boolCall.booleanValue();
        } catch (Exception e2) {
            e = e2;
            MainLogger.m7255e(TAG, e.getMessage() + " pdfFilePath: " + MainLogger.getEncode(strDownloadPdfFileToCacheDir));
            return false;
        }
    }

    private final void initCacheDir() {
        FileUtils.makeDirectory(this.cacheDir);
    }

    private final boolean isValidFileSize(long fileSize) {
        return 0 < fileSize && fileSize < 1073741824;
    }

    private final void onTaskProgressed(int total, int progress, int fail) {
        synchronized (this.contracts) {
            try {
                Iterator<Contract> it = this.contracts.values().iterator();
                while (it.hasNext()) {
                    it.next().onTaskProgressed(total, progress, fail);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @TestOnly
    public final void clearCacheDir() {
        MainLogger.m7254d(TAG, "clearCacheDir");
        FileUtils.deleteFile(new File(this.cacheDir));
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final int getPdfUriCount() {
        return this.pdfUris.size();
    }

    @NotNull
    public final List<Uri> getPdfUris() {
        return this.pdfUris;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask
    @NotNull
    /* JADX INFO: renamed from: getResult */
    public WorkerTask.Result getTaskResult() {
        return this.result;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask
    @NotNull
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask
    public void onPostExecute() {
        try {
            clearCacheDir();
        } catch (IOException e) {
            MainLogger.m7255e(TAG, e.getMessage());
        } catch (NullPointerException e2) {
            MainLogger.m7255e(TAG, e2.getMessage());
        }
        synchronized (this.contracts) {
            try {
                Iterator<Contract> it = this.contracts.values().iterator();
                while (it.hasNext()) {
                    it.next().onPostExecute();
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        super.onPostExecute();
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask
    public void onPreExecute() {
        super.onPreExecute();
        initCacheDir();
    }

    public final void registerContract(int hashCode, @Nullable Contract contract) {
        synchronized (this.contracts) {
            if (contract != null) {
                this.contracts.remove(Integer.valueOf(hashCode));
                this.contracts.put(Integer.valueOf(hashCode), contract);
            }
        }
    }

    public final void setErrorCode(int i) {
        this.errorCode = i;
    }

    @TestOnly
    public final void validateDownloadPdfResult(int saveResult) throws Exception {
        if (1 == saveResult) {
            addErrorCode(ISpenNotePdfManager.ResultType.RESULT_TYPE_CANCEL.ordinal());
            throw new Exception("validateDownloadPdfResult# download cancelled");
        }
        if (2 == saveResult) {
            addErrorCode(131072);
            throw new Exception("validateDownloadPdfResult# download failed(note over size)");
        }
        if (3 != saveResult) {
            return;
        }
        addErrorCode(65536);
        throw new Exception("validateDownloadPdfResult# download failed(low Storage)");
    }

    @TestOnly
    public final void validateFilePath(@Nullable String filePath) throws Exception {
        if (TextUtils.isEmpty(filePath)) {
            addErrorCode(16777216);
            throw new Exception("validateFilePath# filePath is empty");
        }
    }

    @TestOnly
    public final void validateFileSizeFromPath(@Nullable String filePath) throws Exception {
        if (isValidFileSize(FileUtils.getFileSize(filePath))) {
            return;
        }
        addErrorCode(131072);
        throw new Exception("isValidFileSizeFromFilePath# invalid file size ");
    }

    @TestOnly
    public final void validateFileSizeFromUri(@NotNull Uri uri) throws Exception {
        Intrinsics.checkNotNullParameter(uri, "uri");
        if (BaseUtils.getApplicationContext() == null) {
            addErrorCode(32768);
            throw new Exception("validateFileSizeFromUri# context is null");
        }
        Context applicationContext = BaseUtils.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext);
        if (isValidFileSize(FileUtils.getFileSize(applicationContext, uri))) {
            return;
        }
        addErrorCode(131072);
        throw new Exception("validateFileSizeFromUri# invalid file size");
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.task.WorkerTask
    public void execute(@Nullable TaskParams taskParams) {
        if (taskParams == null) {
            return;
        }
        this.taskParams = taskParams;
        this.errorCode = 0;
        int pdfUriCount = getPdfUriCount();
        String folderUuid = FeatureUtils.isPreDefinedFolderUuid(taskParams.getFolderUuid()) ? FolderConstants.MyFolders.UUID : taskParams.getFolderUuid();
        int i = 0;
        int i2 = 0;
        for (int i4 = 0; i4 < pdfUriCount && !isCancelled(); i4++) {
            Intrinsics.checkNotNull(folderUuid);
            i++;
            if (!importPdfWithoutOpenComposer(folderUuid, this.pdfUris.get(i4))) {
                i2++;
            }
            onTaskProgressed(pdfUriCount, i, i2);
        }
        this.result.setSuccessCount(i - i2);
        this.result.setErrorCode(this.errorCode);
        this.result.setCancelled(isCancelled());
    }
}
