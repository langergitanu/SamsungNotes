package com.samsung.android.support.senl.p148nt.model.executor.task;

import android.content.Context;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.document.SDocLocker;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentPageRepository;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.documents.SpenSDocDataSource;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentSubscriptionId;
import com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument;
import com.samsung.android.support.senl.p148nt.model.executor.task.DocumentTask;
import com.samsung.android.support.senl.p148nt.model.repository.cache.DocumentCacheRepository;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentCacheUtils;
import java.io.File;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class LoadDocumentTask extends DocumentTask {
    private static final String TAG = ModelLogger.createTag("LoadDocumentTask");
    private LoadTaskCallback mLoadTaskCallback;
    private SDocLocker mLocker;
    private int mMode;
    private ISpenDocument mSpenDocument;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder {
        @NonNull
        public static LoadDocumentTask build(@NonNull Context context, @NonNull DocumentDataSource documentDataSource, @Nullable Handler handler) {
            DataLogger.m12302d(LoadDocumentTask.TAG, "build, documentDataSource : " + documentDataSource);
            return new LoadDocumentTask(context, handler);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface LoadTaskCallback extends DocumentTask.TaskCallback {
        @WorkerThread
        SpenSDocDataSource getCache(@NonNull String str);

        @WorkerThread
        void onLoaded(@NonNull String str, @NonNull SpenSDocDataSource spenSDocDataSource);
    }

    public LoadDocumentTask(@NonNull Context context) {
        super(context);
    }

    private void checkDatabase(@NonNull ISpenDocument iSpenDocument) {
        if (DocumentSubscriptionId.COMPOSER_SERVICE_ID.getUser().equals(getUser().getUser())) {
            NotesDocumentPageRepository notesDocumentPageRepositoryCreateNotesDocumentPageRepository = NotesDataRepositoryFactory.newInstance(this.mContext).createNotesDocumentPageRepository();
            List<String> pageIDs = notesDocumentPageRepositoryCreateNotesDocumentPageRepository.getPageIDs(getUuid());
            if (pageIDs.isEmpty()) {
                return;
            }
            List<String> invalidPageIds = iSpenDocument.getInvalidPageIds(pageIDs);
            if (invalidPageIds.isEmpty()) {
                return;
            }
            notesDocumentPageRepositoryCreateNotesDocumentPageRepository.removeInvalidPages(getUuid(), invalidPageIds);
        }
    }

    private int getMode() {
        return this.mMode;
    }

    @NonNull
    private String getTitle(@NonNull SpenWNote spenWNote) {
        String text = spenWNote.getTitle().getText();
        return text == null ? "" : text;
    }

    @WorkerThread
    private void notifyOnLoadedCallback(@NonNull String str, @NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull String str2, @Nullable DocumentDataSource documentDataSource) {
        LoadTaskCallback loadTaskCallback;
        String str3 = TAG;
        StringBuilder sbM15l = AbstractC0000a.m15l("notifyOnLoadedCallback, uuid : ", str, ", path : ");
        sbM15l.append(DataLogger.getEncode(str2));
        sbM15l.append(", document  : ");
        sbM15l.append(documentDataSource);
        DataLogger.m12302d(str3, sbM15l.toString());
        if (documentDataSource == null || documentDataSource.getDoc() == null || (loadTaskCallback = this.mLoadTaskCallback) == null) {
            return;
        }
        loadTaskCallback.onLoaded(str, DocumentCacheRepository.subscribe(DocumentCacheRepository.create(str, str2, documentDataSource), documentSubscriptionId));
    }

    private void runCacheTask(@NonNull SpenSDocDataSource spenSDocDataSource) {
        try {
            DocumentDataSource documentDataSource = this.mTarget;
            String str = TAG;
            DataLogger.m12302d(str, "runCacheTask, cache : " + spenSDocDataSource + ", target : " + documentDataSource);
            setDocument(documentDataSource, spenSDocDataSource.getSpenSDoc());
            success(str, documentDataSource, getUuid());
        } catch (Exception e) {
            String str2 = TAG;
            AbstractC11014a.m12333r(e, new StringBuilder("runCacheTask failed, e : "), str2);
            fail(str2, e, this.mTarget.getUuid());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void runTask() {
        ISpenDocument iSpenDocument;
        DocumentDataSource documentDataSource = this.mTarget;
        try {
            boolean zExists = new File(documentDataSource.getLoadPath()).exists();
            if (!documentDataSource.isNew()) {
                documentDataSource.setNewDocument(!zExists);
                documentDataSource.getDocumentRepository().setNewDocument(!zExists);
            }
            String str = TAG;
            DataLogger.m12302d(str, "run, mode: " + getMode() + ", docExist : " + zExists);
            String pDFWriterCachePath = documentDataSource.getWritingMode() == 100 ? DocumentCacheUtils.getPDFWriterCachePath(this.mContext, getUuid()) : DocumentCacheUtils.getCachePath(this.mContext, getUuid());
            boolean zExists2 = new File(pDFWriterCachePath).exists();
            DataLogger.m12305f(str, "Try to open doc, mode : " + getMode() + ", restoreUnsavedData : " + zExists2 + ", cachePath : " + DataLogger.getEncode(pDFWriterCachePath));
            SDocLocker sDocLocker = this.mLocker;
            if (sDocLocker == null) {
                sDocLocker = new SDocLocker(this.mContext);
            }
            ISpenDocument iSpenDocument2 = this.mSpenDocument;
            if (iSpenDocument2 != null) {
                iSpenDocument = iSpenDocument2;
            } else {
                ISpenDocument iSpenDocumentCreateSpenDocument = documentDataSource.getDocumentRepository().createSpenDocument(this.mContext, sDocLocker.getUserCode(), getMode(), zExists2, UUIDUtils.isCoeditUuid(getUuid()));
                checkDatabase(iSpenDocumentCreateSpenDocument);
                iSpenDocument = iSpenDocumentCreateSpenDocument;
            }
            verifyLockAccountGuid(iSpenDocument, documentDataSource.getDocumentRepository().getLockAccountGuid());
            setDocument(documentDataSource, iSpenDocument);
            if (getMode() == 0) {
                notifyOnLoadedCallback(getUuid(), getUser(), documentDataSource.getLoadPath(), documentDataSource);
            }
            DataLogger.m12302d(str, "run, done.");
            DataLogger.m12305f(str, "try to open sdoc - success, uuid: " + getUuid() + ", title: " + DataLogger.getEncode(getTitle((SpenWNote) iSpenDocument)) + ModelLogger.getContentLog((SpenWNote) iSpenDocument));
            success(str, documentDataSource, getUuid());
        } catch (Exception e) {
            String str2 = TAG;
            DataLogger.m12305f(str2, "try to open sdoc - fail, uuid: " + getUuid() + ", e: " + e.getMessage());
            fail(str2, e, documentDataSource.getUuid());
        }
    }

    private void setDocument(DocumentDataSource documentDataSource, ISpenDocument iSpenDocument) {
        iSpenDocument.setPDFReaderMode(documentDataSource.getWritingMode() == 100);
        documentDataSource.setDoc(iSpenDocument);
    }

    @Override // com.samsung.android.support.senl.p148nt.model.executor.task.DocumentTask
    public DocumentTask.Type getType() {
        return DocumentTask.Type.LOAD;
    }

    public LoadDocumentTask locker(@Nullable SDocLocker sDocLocker) {
        this.mLocker = sDocLocker;
        return this;
    }

    public LoadDocumentTask mode(int i) {
        this.mMode = i;
        return this;
    }

    @Override // java.lang.Runnable
    public void run() {
        LoadTaskCallback loadTaskCallback;
        SpenSDocDataSource cache;
        String str = TAG;
        DataLogger.m12302d(str, "running... target : " + this.mTarget + ", cacheStrategy : " + this.mCacheStrategy);
        DataLogger.m12308p(str, "open document task - start");
        if (getCacheStrategy().equals(DocumentTask.CacheStrategy.CACHE_MEMORY) && (loadTaskCallback = this.mLoadTaskCallback) != null && (cache = loadTaskCallback.getCache(getUuid())) != null) {
            runCacheTask(DocumentCacheRepository.subscribe(cache, getUser()));
        } else {
            runTask();
            DataLogger.m12308p(str, "open document task - end");
        }
    }

    public LoadDocumentTask spenSDoc(@Nullable ISpenDocument iSpenDocument) {
        this.mSpenDocument = iSpenDocument;
        return this;
    }

    public LoadDocumentTask taskListener(LoadTaskCallback loadTaskCallback) {
        this.mLoadTaskCallback = loadTaskCallback;
        return this;
    }

    public LoadDocumentTask(@NonNull Context context, @Nullable Handler handler) {
        super(context, handler);
    }
}
