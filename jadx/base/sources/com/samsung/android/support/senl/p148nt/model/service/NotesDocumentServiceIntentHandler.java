package com.samsung.android.support.senl.p148nt.model.service;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.constants.WritingMode;
import com.samsung.android.support.senl.p148nt.base.common.sdk.util.SpenSdkInitializer;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.control.action.RunnableC8928b;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.model.base.document.DocumentStyleRepository;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.document.DocumentInitializer;
import com.samsung.android.support.senl.p148nt.model.document.DocumentObjectInserter;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentSubscriptionId;
import com.samsung.android.support.senl.p148nt.model.documents.data.ISpenDocument;
import com.samsung.android.support.senl.p148nt.model.executor.DocumentUseCaseExecutor;
import com.samsung.android.support.senl.p148nt.model.executor.injector.NotesDocumentInjector;
import com.samsung.android.support.senl.p148nt.model.executor.task.DocumentCompletionListener;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import com.samsung.android.support.senl.p148nt.model.markdown.converter.MarkdownConverter;
import com.samsung.android.support.senl.p148nt.model.repository.data.NotesDocument;
import com.samsung.android.support.senl.p148nt.model.repository.data.sdoc.SpenDocumentRepositoryFactory;
import com.samsung.android.support.senl.p148nt.model.repository.data.sdoc.SpenWordDocRepository;
import com.samsung.android.support.senl.p148nt.model.service.DocumentServiceConstants;
import com.samsung.android.support.senl.p148nt.model.service.callback.NotesDocumentCompletionListener;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentCacheUtils;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentPageUtils;
import com.samsung.android.support.senl.p148nt.model.utils.NotesDocumentIntentUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import p001A.AbstractC0000a;
import p009B3.C0035a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class NotesDocumentServiceIntentHandler extends Handler {
    private static final String TAG = ModelLogger.createTag("NotesDocumentServiceIntentHandler");
    private final Context mContext;
    private final DocumentUseCaseExecutor mNotesDocumentUsecaseExecutor;

    /* JADX INFO: renamed from: com.samsung.android.support.senl.nt.model.service.NotesDocumentServiceIntentHandler$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C114851 extends NotesDocumentCompletionListener<ISpenDocument> {
        final /* synthetic */ Runnable val$callback;

        public C114851(Runnable runnable) {
            this.val$callback = runnable;
        }

        @Override // com.samsung.android.support.senl.p148nt.model.service.callback.NotesDocumentCompletionListener
        public void completed(@NonNull final NotesDocument<ISpenDocument> notesDocument, @NonNull String str) {
            DataLogger.m12305f(NotesDocumentServiceIntentHandler.TAG, "resave, open$completed, uuid : " + str);
            notesDocument.setDirty(true);
            notesDocument.getDocumentRepository().addSaveStrategy(8192);
            NotesDocumentServiceIntentHandler.this.mNotesDocumentUsecaseExecutor.save(notesDocument, false, true, new NotesDocumentCompletionListener<ISpenDocument>() { // from class: com.samsung.android.support.senl.nt.model.service.NotesDocumentServiceIntentHandler.1.1
                private final NotesDocumentCompletionListener<ISpenDocument> mCloseListener = new NotesDocumentCompletionListener<ISpenDocument>() { // from class: com.samsung.android.support.senl.nt.model.service.NotesDocumentServiceIntentHandler.1.1.1
                    @Override // com.samsung.android.support.senl.p148nt.model.service.callback.NotesDocumentCompletionListener
                    public void completed(@NonNull NotesDocument<ISpenDocument> notesDocument2, @NonNull String str2) {
                        DataLogger.m12307i(NotesDocumentServiceIntentHandler.TAG, "resave, close$completed, uuid : " + str2);
                        RestoreCacheManager.remove(str2);
                        C114851.this.val$callback.run();
                    }

                    @Override // com.samsung.android.support.senl.p148nt.model.executor.task.DocumentCompletionListener
                    public void failed(Throwable th, String str2) {
                        DataLogger.m12303e(NotesDocumentServiceIntentHandler.TAG, "resave, close$failed, uuid : " + str2 + ", exc : " + th);
                        C114851 c114851 = C114851.this;
                        NotesDocumentServiceIntentHandler.this.removeCache(str2, c114851.val$callback);
                    }
                };

                @Override // com.samsung.android.support.senl.p148nt.model.service.callback.NotesDocumentCompletionListener
                public void completed(@NonNull NotesDocument<ISpenDocument> notesDocument2, @NonNull String str2) {
                    AbstractC0000a.m2C("resave, save$completed, uuid : ", str2, NotesDocumentServiceIntentHandler.TAG);
                    NotesDocumentServiceIntentHandler.this.mNotesDocumentUsecaseExecutor.close(notesDocument2, this.mCloseListener);
                }

                @Override // com.samsung.android.support.senl.p148nt.model.executor.task.DocumentCompletionListener
                public void failed(Throwable th, String str2) {
                    DataLogger.m12303e(NotesDocumentServiceIntentHandler.TAG, "resave, save$failed, uuid : " + str2 + ", exc : " + th);
                    NotesDocumentServiceIntentHandler.this.mNotesDocumentUsecaseExecutor.close(notesDocument, this.mCloseListener);
                }
            });
        }

        @Override // com.samsung.android.support.senl.p148nt.model.executor.task.DocumentCompletionListener
        public void failed(Throwable th, String str) {
            DataLogger.m12303e(NotesDocumentServiceIntentHandler.TAG, "resave, open$failed, uuid : " + str + ", exc : " + th);
            NotesDocumentServiceIntentHandler.this.removeCache(str, this.val$callback);
        }
    }

    public NotesDocumentServiceIntentHandler(@NonNull Context context, DocumentUseCaseExecutor documentUseCaseExecutor) {
        super(Looper.getMainLooper());
        this.mContext = context;
        this.mNotesDocumentUsecaseExecutor = documentUseCaseExecutor;
    }

    private SpenWNote.PageMode getPageMode(boolean z, NotesDocumentEntity notesDocumentEntity) {
        return z ? DocumentPageUtils.convertSettingsPageTypeToWNotePageMode(new DocumentStyleRepository().getPageStyle()) : DocumentPageUtils.convertToWNotePageMode(notesDocumentEntity.getPageMode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$removeCacheAndResave$2(File file, String str) {
        return str.endsWith(".dat");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$removeCacheAndResave$3(Set set, String str) {
        set.remove(str);
        if (set.isEmpty()) {
            updateResaveTaskPreference(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$restoreDocumentCaches$0(File file, String str) {
        return str.endsWith(".dat");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$restorePDFWriterCaches$1(File file, String str) {
        return str.endsWith(".dat");
    }

    @NonNull
    public static NotesDocumentServiceIntentHandler provideNotesDocumentIntentHandler(@NonNull Context context, @NonNull DocumentUseCaseExecutor documentUseCaseExecutor) {
        return new NotesDocumentServiceIntentHandler(context, documentUseCaseExecutor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeCache(String str, Runnable runnable) {
        RestoreCacheManager.remove(str);
        DocumentCacheUtils.deleteDocumentDat(this.mContext, str);
        runnable.run();
    }

    private void resave(@NonNull String str, @NonNull String str2, Runnable runnable) {
        DataLogger.m12307i(TAG, "resave, uuid : " + str + ", caller : " + str2);
        C114851 c114851 = new C114851(runnable);
        String path = NotesDataRepositoryFactory.newInstance(this.mContext).createDocumentDataRepository().getPath(str);
        if (TextUtils.isEmpty(path)) {
            restoreByUuid(str, c114851, null);
        } else {
            this.mNotesDocumentUsecaseExecutor.open(NotesDocumentInjector.provide(this.mContext, SpenDocumentRepositoryFactory.newInstance(str, "", path, null, str2, DocumentSubscriptionId.DOCUMENT_SERVICE_ID).createWordDocRepository()), c114851);
        }
    }

    private void restore(@NonNull File file, @Nullable DocumentCompletionListener<?> documentCompletionListener, @Nullable DocumentSubscriptionId documentSubscriptionId, @WritingMode int i) {
        String str = TAG;
        DataLogger.m12302d(str, "restore, cache file :" + DataLogger.getEncode(file.getPath()));
        String fileName = DocumentCacheUtils.getFileName(file.getPath(), false);
        if (fileName.endsWith("_screenoff")) {
            DataLogger.m12303e(str, "restore, do not restore screen off caches - uuid : ".concat(fileName));
            return;
        }
        RestoreCacheManager.add(fileName);
        if (documentSubscriptionId == null) {
            documentSubscriptionId = DocumentSubscriptionId.DOCUMENT_SERVICE_ID;
        }
        this.mNotesDocumentUsecaseExecutor.openCache(SpenDocumentRepositoryFactory.newInstance(fileName, "", "", null, str, documentSubscriptionId).createWordDocRepository().setWritingMode(i), documentCompletionListener);
    }

    private void restoreByUuid(@NonNull String str, @Nullable DocumentCompletionListener<?> documentCompletionListener, @Nullable DocumentSubscriptionId documentSubscriptionId) {
        String str2 = TAG;
        AbstractC11014a.m12334s("restoreByUuid, cache uuid :", str, str2);
        DocumentUseCaseExecutor documentUseCaseExecutor = this.mNotesDocumentUsecaseExecutor;
        if (documentSubscriptionId == null) {
            documentSubscriptionId = DocumentSubscriptionId.DOCUMENT_SERVICE_ID;
        }
        documentUseCaseExecutor.openCache(SpenDocumentRepositoryFactory.newInstance(str, "", "", null, str2, documentSubscriptionId).createWordDocRepository(), documentCompletionListener);
    }

    private void restoreDocumentCaches(Intent intent, DocumentCompletionListener<?> documentCompletionListener, DocumentSubscriptionId documentSubscriptionId) {
        if (!DocumentCacheUtils.existAnyCacheFiles(this.mContext)) {
            DataLogger.m12302d(TAG, "restoreCache, cache dir is not exist.");
            return;
        }
        String string = intent.getExtras() == null ? "" : intent.getExtras().getString(DocumentServiceConstants.Extra.ARG_RESTORE_UUID);
        if (!TextUtils.isEmpty(string)) {
            restoreByUuid(string, documentCompletionListener, documentSubscriptionId);
            return;
        }
        File[] fileArrListFiles = DocumentCacheUtils.getCacheFolderFile(this.mContext).listFiles(new C0035a(14));
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            restore(file, documentCompletionListener, documentSubscriptionId, 0);
        }
    }

    private void restorePDFWriterCaches(@Nullable DocumentCompletionListener<?> documentCompletionListener, @Nullable DocumentSubscriptionId documentSubscriptionId) {
        File[] fileArrListFiles = DocumentCacheUtils.getPDFWriterCacheFolderFile(this.mContext).listFiles(new C0035a(12));
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            restore(file, documentCompletionListener, documentSubscriptionId, 100);
        }
    }

    private void updateResaveTaskPreference(boolean z) {
        DataLogger.m12307i(TAG, "updateResaveTaskPreference, inProgress : " + z);
        SharedPreferencesCompat.getInstance("APP_UPDATE_PREFERENCE").putBoolean(DocumentServiceConstants.Task.CACHE_RESAVE_TASK_IN_PROGRESS, z);
    }

    public void removeCacheAndResave(@NonNull Intent intent) {
        if (!DocumentCacheUtils.existAnyCacheFiles(this.mContext)) {
            DataLogger.m12307i(TAG, "removeCacheAndResave, cache dir is not exist.");
            return;
        }
        File[] fileArrListFiles = DocumentCacheUtils.getCacheFolderFile(this.mContext).listFiles(new C0035a(13));
        if (fileArrListFiles == null) {
            DataLogger.m12307i(TAG, "removeCacheAndResave, listFiles is empty");
            return;
        }
        SpenSdkInitializer.initialize(this.mContext);
        String intentCaller = NotesDocumentIntentUtils.getIntentCaller(intent);
        HashSet<String> hashSet = new HashSet();
        StringBuilder sb = new StringBuilder();
        for (File file : fileArrListFiles) {
            sb.append("removeCacheAndResave, cache file : ");
            sb.append(DataLogger.getEncode(file.toString()));
            sb.append('\n');
            String fileName = DocumentCacheUtils.getFileName(file.getPath(), false);
            if (fileName.endsWith("_screenoff")) {
                sb.append("removeCacheAndResave, do not restore screen off caches - uuid : ");
                sb.append(fileName);
                sb.append('\n');
            } else {
                hashSet.add(fileName);
            }
        }
        DataLogger.m12307i(TAG, sb.toString());
        if (hashSet.isEmpty()) {
            updateResaveTaskPreference(false);
            return;
        }
        updateResaveTaskPreference(true);
        HashSet hashSet2 = new HashSet(hashSet);
        for (String str : hashSet) {
            RestoreCacheManager.add(str);
            resave(str, intentCaller, new RunnableC8928b(this, 20, hashSet2, str));
        }
    }

    public void restoreCaches(@NonNull Intent intent, @Nullable DocumentCompletionListener<?> documentCompletionListener, @Nullable DocumentSubscriptionId documentSubscriptionId) {
        DataLogger.m12307i(TAG, "restoreCache, intent : " + intent + ", callback : " + documentCompletionListener);
        restoreDocumentCaches(intent, documentCompletionListener, documentSubscriptionId);
        restorePDFWriterCaches(documentCompletionListener, documentSubscriptionId);
    }

    public void save(@NonNull String str, @Nullable final String str2, @Nullable final String str3, @Nullable final List<String> list, @Nullable final List<Uri> list2, @Nullable final String str4, @Nullable NotesDocumentEntity notesDocumentEntity, @NonNull String str5, @NonNull final MarkdownConverter markdownConverter) {
        final boolean z = notesDocumentEntity == null;
        String filePath = z ? "" : notesDocumentEntity.getFilePath();
        SpenWNote.PageMode pageMode = getPageMode(z, notesDocumentEntity);
        String str6 = TAG;
        StringBuilder sbM15l = AbstractC0000a.m15l("save, uuid : ", str, ", path: ");
        sbM15l.append(DataLogger.getEncode(filePath));
        sbM15l.append(", title : ");
        sbM15l.append(DataLogger.getEncode(str2));
        sbM15l.append(", bodyText : ");
        sbM15l.append(DataLogger.getEncode(str3));
        sbM15l.append(", folderUuid : ");
        sbM15l.append(str4);
        sbM15l.append(", caller : ");
        sbM15l.append(str5);
        DataLogger.m12307i(str6, sbM15l.toString());
        SpenWordDocRepository spenWordDocRepositoryCreateWordDocRepository = SpenDocumentRepositoryFactory.newInstance(str, "", filePath, null, str5, DocumentSubscriptionId.BACKGROUND_DOCUMENT_SERVICE_ID).createWordDocRepository();
        spenWordDocRepositoryCreateWordDocRepository.setPageMode(pageMode);
        spenWordDocRepositoryCreateWordDocRepository.setNewDocument(true);
        NotesDocument notesDocumentProvide = NotesDocumentInjector.provide(this.mContext, spenWordDocRepositoryCreateWordDocRepository);
        notesDocumentProvide.setNewDocument(z);
        this.mNotesDocumentUsecaseExecutor.open(notesDocumentProvide, new NotesDocumentCompletionListener<ISpenDocument>() { // from class: com.samsung.android.support.senl.nt.model.service.NotesDocumentServiceIntentHandler.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.samsung.android.support.senl.p148nt.model.service.callback.NotesDocumentCompletionListener
            public void completed(@NonNull final NotesDocument<ISpenDocument> notesDocument, @NonNull String str7) {
                DataLogger.m12307i(NotesDocumentServiceIntentHandler.TAG, "open$completed, uuid : " + str7);
                ISpenDocument doc = notesDocument.getDoc();
                if (doc == 0) {
                    return;
                }
                NotesDocumentCompletionListener<ISpenDocument> notesDocumentCompletionListener = new NotesDocumentCompletionListener<ISpenDocument>() { // from class: com.samsung.android.support.senl.nt.model.service.NotesDocumentServiceIntentHandler.2.1
                    @Override // com.samsung.android.support.senl.p148nt.model.service.callback.NotesDocumentCompletionListener
                    public void completed(@NonNull NotesDocument<ISpenDocument> notesDocument2, @NonNull String str8) {
                        AbstractC0000a.m2C("save$completed, uuid : ", str8, NotesDocumentServiceIntentHandler.TAG);
                        NotesDocumentServiceIntentHandler.this.mNotesDocumentUsecaseExecutor.close(notesDocument2, null);
                    }

                    @Override // com.samsung.android.support.senl.p148nt.model.executor.task.DocumentCompletionListener
                    public void failed(Throwable th, String str8) {
                        DataLogger.m12307i(NotesDocumentServiceIntentHandler.TAG, "save$failed, uuid : " + str8 + ", exc : " + th);
                        NotesDocumentServiceIntentHandler.this.mNotesDocumentUsecaseExecutor.close(notesDocument, null);
                    }
                };
                if (z) {
                    new DocumentInitializer(NotesDocumentServiceIntentHandler.this.mContext).initNewNote((SpenWNote) doc);
                }
                String str8 = str2;
                if (str8 != null) {
                    doc.insertTitle(str8);
                }
                if (!TextUtils.isEmpty(str3)) {
                    markdownConverter.insertMarkdown((SpenWNote) doc, str3);
                }
                NotesDocumentIntentUtils.setFolderUuid(notesDocument.getDocumentEntityContainer().getEntity(), str4);
                try {
                    new DocumentObjectInserter().insert(NotesDocumentServiceIntentHandler.this.mContext, list, list2, (SpenWNote) doc);
                } catch (Exception e) {
                    AbstractC11014a.m12333r(e, new StringBuilder("insert, e : "), NotesDocumentServiceIntentHandler.TAG);
                }
                NotesDocumentServiceIntentHandler.this.mNotesDocumentUsecaseExecutor.save(notesDocument, false, true, notesDocumentCompletionListener);
            }

            @Override // com.samsung.android.support.senl.p148nt.model.executor.task.DocumentCompletionListener
            public void failed(Throwable th, String str7) {
                DataLogger.m12307i(NotesDocumentServiceIntentHandler.TAG, "open$failed, uuid : " + str7 + ", exc : " + th);
            }
        });
    }

    public void save(@NonNull Intent intent, @NonNull MarkdownConverter markdownConverter) {
        if (!SpenSdkInitializer.initialize(this.mContext)) {
            DataLogger.m12303e(TAG, "SPenSdk initialize failed");
            return;
        }
        String stringExtra = intent.getStringExtra("sdoc_uuid");
        String stringExtra2 = intent.getStringExtra("folder_uuid");
        String stringExtra3 = intent.getStringExtra("title");
        String stringExtra4 = intent.getStringExtra("body");
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra(DocumentServiceConstants.Extra.ARG_MIME_TYPES);
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(DocumentServiceConstants.Extra.ARG_URIS);
        String stringExtra5 = intent.getStringExtra(DocumentServiceConstants.Extra.ARG_FOLDER_PATH);
        String intentCaller = NotesDocumentIntentUtils.getIntentCaller(intent);
        String str = TAG;
        StringBuilder sbM16m = AbstractC0000a.m16m("save, intent caller : ", intentCaller, ", uuid : ", stringExtra, ", folderUuid : ");
        sbM16m.append(stringExtra2);
        sbM16m.append(", title : ");
        sbM16m.append(DataLogger.getEncode(stringExtra3));
        sbM16m.append(", body : ");
        sbM16m.append(DataLogger.getEncode(stringExtra4));
        sbM16m.append(", folderPath : ");
        sbM16m.append(stringExtra5);
        DataLogger.m12307i(str, sbM16m.toString());
        if (!TextUtils.isEmpty(stringExtra) && (!TextUtils.isEmpty(stringExtra3) || !TextUtils.isEmpty(stringExtra4) || !TextUtils.isEmpty(stringExtra5) || (parcelableArrayListExtra != null && !parcelableArrayListExtra.isEmpty()))) {
            NotesDocumentEntity notesDocumentEntityM9f = AbstractC0000a.m9f(this.mContext, stringExtra);
            if (!TextUtils.isEmpty(stringExtra2) && FolderManager.getInstance().getCategoryEntity(stringExtra2) == null) {
                stringExtra2 = "";
            }
            if (notesDocumentEntityM9f == null && TextUtils.isEmpty(stringExtra2)) {
                stringExtra2 = NotesDocumentIntentUtils.getFolderUuid(stringExtra5);
            }
            save(stringExtra, stringExtra3, stringExtra4, stringArrayListExtra, parcelableArrayListExtra, stringExtra2, notesDocumentEntityM9f, intentCaller, markdownConverter);
            return;
        }
        DataLogger.m12303e(str, "save failed");
    }
}
