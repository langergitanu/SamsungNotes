package com.samsung.android.support.senl.p148nt.model.executor.task;

import android.content.Context;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.samsung.android.sdk.composer.document.sdoc.SpenSDoc;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.document.SDocLocker;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.documents.SpenSDocDataSource;
import com.samsung.android.support.senl.p148nt.model.documents.constants.ModelConstants;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentDataSource;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentRepository;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentSubscriptionId;
import com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument;
import com.samsung.android.support.senl.p148nt.model.documents.spen.SpenWordDocument;
import com.samsung.android.support.senl.p148nt.model.executor.injector.NotesDocumentInjector;
import com.samsung.android.support.senl.p148nt.model.executor.task.DocumentTask;
import com.samsung.android.support.senl.p148nt.model.repository.cache.DocumentCacheRepository;
import com.samsung.android.support.senl.p148nt.model.repository.data.NotesDocument;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentCacheUtils;
import com.samsung.android.support.senl.p148nt.model.utils.VoiceDataUtil;
import java.io.File;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class LoadCacheDocumentTask extends DocumentTask {
    private static final String TAG = ModelLogger.createTag("LoadCacheDocumentTask");
    private String mCaller;
    private DocumentRepository<?, ?> mDocumentRepository;
    private LoadCacheTaskCallback mLoadCacheTaskCallback;
    private SDocLocker mLocker;
    private ISpenDocument mSpenDocument;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Builder {
        @NonNull
        public static LoadCacheDocumentTask build(@NonNull Context context, @Nullable Handler handler) {
            DataLogger.m12302d(LoadCacheDocumentTask.TAG, "build");
            return new LoadCacheDocumentTask(context, handler);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface LoadCacheTaskCallback extends DocumentTask.TaskCallback {
        @WorkerThread
        SpenSDocDataSource getCache(@NonNull String str);

        @WorkerThread
        void onLoaded(@NonNull String str, @NonNull SpenSDocDataSource spenSDocDataSource);
    }

    public LoadCacheDocumentTask(@NonNull Context context) {
        super(context);
    }

    @WorkerThread
    private void notifyOnLoadedCallback(@NonNull String str, @NonNull DocumentSubscriptionId documentSubscriptionId, @NonNull String str2, @Nullable DocumentDataSource<?, ?> documentDataSource) {
        LoadCacheTaskCallback loadCacheTaskCallback;
        String str3 = TAG;
        StringBuilder sbM15l = AbstractC0000a.m15l("notifyOnLoadedCallback, uuid : ", str, ", path : ");
        sbM15l.append(DataLogger.getEncode(str2));
        sbM15l.append(", document : ");
        sbM15l.append(documentDataSource);
        DataLogger.m12302d(str3, sbM15l.toString());
        if (documentDataSource == null || documentDataSource.getDoc() == null || (loadCacheTaskCallback = this.mLoadCacheTaskCallback) == null) {
            return;
        }
        loadCacheTaskCallback.onLoaded(str, DocumentCacheRepository.subscribe(DocumentCacheRepository.create(str, str2, documentDataSource), documentSubscriptionId));
    }

    private void runCacheTask(@NonNull DocumentDataSource documentDataSource, @NonNull SpenSDocDataSource spenSDocDataSource) {
        try {
            String str = TAG;
            DataLogger.m12302d(str, "runCacheTask, cache : " + spenSDocDataSource + ", target : " + documentDataSource);
            documentDataSource.getDocumentRepository().setNewDocument(spenSDocDataSource.getDocument().getDocumentRepository().isNewDocument());
            documentDataSource.getDocumentRepository().setSaveStrategy(spenSDocDataSource.getDocument().getDocumentRepository().getSaveStrategy());
            setDocument(documentDataSource, spenSDocDataSource.getSpenSDoc());
            DataLogger.m12305f(str, "runCacheTask, success, uuid: " + getUuid() + ModelLogger.getContentLog((SpenWordDocument) documentDataSource.getDoc()));
            success(str, documentDataSource, getUuid());
        } catch (Exception e) {
            String str2 = TAG;
            DataLogger.m12303e(str2, "runCacheTask failed, e : " + e.getMessage());
            fail(str2, e, getUuid());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void runTask(@NonNull DocumentDataSource documentDataSource) {
        boolean z;
        ISpenDocument iSpenDocument;
        try {
            String str = TAG;
            DataLogger.m12302d(str, "runTask, create doc instance.");
            boolean zExists = new File(documentDataSource.getLoadPath()).exists();
            SDocLocker sDocLocker = this.mLocker;
            if (sDocLocker == null) {
                sDocLocker = new SDocLocker(this.mContext);
            }
            ISpenDocument iSpenDocument2 = this.mSpenDocument;
            if (iSpenDocument2 != null) {
                z = false;
                iSpenDocument = iSpenDocument2;
            } else {
                boolean zIsCoeditUuid = UUIDUtils.isCoeditUuid(getUuid());
                ISpenDocument iSpenDocumentCreateSpenDocument = documentDataSource.getDocumentRepository().createSpenDocument(this.mContext, sDocLocker.getUserCode(), 0, true, zIsCoeditUuid);
                z = zIsCoeditUuid;
                iSpenDocument = iSpenDocumentCreateSpenDocument;
            }
            if (documentDataSource instanceof NotesDocument) {
                ((NotesDocument) documentDataSource).setLoadTime(System.currentTimeMillis(), "LoadCacheDocumentTask");
            }
            verifyLockAccountGuid(iSpenDocument, documentDataSource.getDocumentRepository().getLockAccountGuid());
            setDocument(documentDataSource, iSpenDocument);
            if (iSpenDocument instanceof SpenSDoc) {
                VoiceDataUtil.setCachedVoiceRecordingPath(documentDataSource, (SpenSDoc) iSpenDocument);
            } else if (iSpenDocument instanceof SpenWNote) {
                VoiceDataUtil.setCachedVoiceRecordingPath(documentDataSource, (SpenWNote) iSpenDocument, z);
            }
            notifyOnLoadedCallback(getUuid(), getUser(), documentDataSource.getLoadPath(), documentDataSource);
            DataLogger.m12305f(str, "runTask, success, uuid: " + getUuid() + ModelLogger.getContentLog((SpenWNote) documentDataSource.getDoc()) + ", loadFileExists: " + zExists);
            success(str, documentDataSource, getUuid());
        } catch (Exception e) {
            String str2 = TAG;
            DataLogger.m12303e(str2, "runTask failed, e : " + e.getMessage());
            fail(str2, e, getUuid());
        }
    }

    private void setDocument(DocumentDataSource documentDataSource, ISpenDocument iSpenDocument) {
        iSpenDocument.setPDFReaderMode(documentDataSource.getWritingMode() == 100);
        documentDataSource.setDoc(iSpenDocument);
    }

    public LoadCacheDocumentTask caller(@NonNull String str) {
        AbstractC0000a.m2C("caller : ", str, TAG);
        this.mCaller = str;
        return this;
    }

    public LoadCacheDocumentTask documentRepository(DocumentRepository<?, ?> documentRepository) {
        this.mDocumentRepository = documentRepository;
        return this;
    }

    public DocumentRepository<?, ?> getDocumentRepository() {
        return this.mDocumentRepository;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.executor.task.DocumentTask
    public DocumentTask.Type getType() {
        return DocumentTask.Type.LOAD_CACHE;
    }

    public LoadCacheDocumentTask lockConfirm(@Nullable String str) {
        AbstractC0000a.m2C("lockConfirm : ", str, TAG);
        return this;
    }

    public LoadCacheDocumentTask locker(@Nullable SDocLocker sDocLocker) {
        DataLogger.m12307i(TAG, "locker : " + sDocLocker);
        this.mLocker = sDocLocker;
        return this;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            String str = TAG;
            DataLogger.m12308p(str, "open cache document task - start");
            String pDFWriterCachePath = this.mDocumentRepository.getWritingMode() == 100 ? DocumentCacheUtils.getPDFWriterCachePath(this.mContext, getUuid()) : DocumentCacheUtils.getCachePath(this.mContext, getUuid());
            DataLogger.m12302d(str, "running... target : " + this.mTarget + ", caller : " + this.mCaller + ", uuid : " + getUuid() + ", cachePath : " + DataLogger.getEncode(pDFWriterCachePath));
            LoadCacheTaskCallback loadCacheTaskCallback = this.mLoadCacheTaskCallback;
            SpenSDocDataSource cache = loadCacheTaskCallback == null ? null : loadCacheTaskCallback.getCache(getUuid());
            DataLogger.m12307i(str, "running, SpenSDocDataSource : " + cache);
            if (cache != null) {
                runCacheTask(NotesDocumentInjector.provide(this.mContext, cache, getDocumentRepository()), DocumentCacheRepository.subscribe(cache, getUser()));
                DataLogger.m12308p(str, "open cache document task - end");
                return;
            }
            NotesDocument notesDocumentRestoreCache = NotesDocumentInjector.restoreCache(this.mContext, pDFWriterCachePath, this.mCaller, getUser());
            if (notesDocumentRestoreCache != null) {
                runTask(notesDocumentRestoreCache);
                DataLogger.m12308p(str, "open cache document task - end");
                return;
            }
            DataLogger.m12307i(str, "running, document cache not exist - uuid : " + getUuid());
            fail(str, new IllegalArgumentException(ModelConstants.ERROR_MSG_DOCUMENT_CACHE_NOT_EXIST), getUuid());
            DataLogger.m12308p(str, "open cache document task - end");
        } catch (Throwable th) {
            DataLogger.m12308p(TAG, "open cache document task - end");
            throw th;
        }
    }

    public LoadCacheDocumentTask spenSDoc(@Nullable ISpenDocument iSpenDocument) {
        this.mSpenDocument = iSpenDocument;
        return this;
    }

    public LoadCacheDocumentTask taskListener(LoadCacheTaskCallback loadCacheTaskCallback) {
        this.mLoadCacheTaskCallback = loadCacheTaskCallback;
        return this;
    }

    public LoadCacheDocumentTask(@NonNull Context context, @Nullable Handler handler) {
        super(context, handler);
    }
}
