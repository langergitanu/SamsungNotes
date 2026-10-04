package com.samsung.android.support.senl.p148nt.model.document.save;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p145cm.base.common.constants.SaveStrategy;
import com.samsung.android.support.senl.p145cm.base.common.util.DataStrategy;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.executor.NotesDataTaskExecutor;
import com.samsung.android.support.senl.p148nt.data.repository.common.scheduler.DataRepositoryScheduler;
import com.samsung.android.support.senl.p148nt.data.resolver.lock.encryption.SDocEncryptionHelper;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class SaveOperation<Entity extends NotesDocumentEntity, SpenDocument> extends DocumentOperation<Entity> {
    private static final String TAG = DataLogger.createTag("SaveOperation");
    private boolean mIsNew;
    private String mLockAccountGuid;
    private final DataStrategy mSaveStrategy;
    private SpenDocument mSpenDocument;
    private boolean mUpdateDocSize;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public @interface Strategy {
        public static final int COLLECT = 8;
        public static final int GROUP_SHARE = 32;
        public static final int NONE = 1;
        public static final int SYNC = 16;
        public static final int TAG_BOARD = 4;
        public static final int WIDGET_BROADCAST = 2;
    }

    public SaveOperation(@NonNull Context context) {
        super(context);
        this.mUpdateDocSize = true;
        this.mSaveStrategy = new DataStrategy(67592);
    }

    private void printDatabaseStrategy(@NonNull DataStrategy dataStrategy) {
        StringBuilder sb = new StringBuilder("strategy : ");
        if (dataStrategy.check(2)) {
            sb.append("BROADCAST_RELOAD_AFTER_SAVE,");
        }
        if (dataStrategy.check(4)) {
            sb.append("CLOSE_AFTER_SAVE,");
        }
        if (dataStrategy.check(8)) {
            sb.append("CREATE_AUTO_TITLE,");
        }
        if (dataStrategy.check(16)) {
            sb.append("SHOW_SAVE_SUCCESS_MESSAGE,");
        }
        if (dataStrategy.check(32)) {
            sb.append("SHOW_DELETE_EMPTY_DOCUMENT_MESSAGE,");
        }
        if (dataStrategy.check(64)) {
            sb.append("DO_NOT_DELETE_SERVICE_CACHE,");
        }
        if (dataStrategy.check(128)) {
            sb.append("FORCE_SAVE,");
        }
        if (dataStrategy.check(1024)) {
            sb.append("DO_NOT_UPDATE_DATABASE,");
        }
        if (dataStrategy.check(2048)) {
            sb.append("CREATE_THUMBNAIL_CACHE,");
        }
        if (dataStrategy.check(4096)) {
            sb.append("DO_NOT_UPDATE_MAPPING_TABLE,");
        }
        if (dataStrategy.check(8192)) {
            sb.append("BROADCAST_FORCE_UPDATE,");
        }
        if (dataStrategy.check(65536)) {
            sb.append("SEND_ANALYTICS,");
        }
        if (dataStrategy.check(131072)) {
            sb.append("REMOVE_HANDWRITING_SEARCH_DATA,");
        }
        if (dataStrategy.check(262144)) {
            sb.append("DO_NOT_COLLECT_SEARCH_DATA,");
        }
        if (dataStrategy.check(524288)) {
            sb.append("UPDATE_DATABASE_AFTER_FILE_SAVE,");
        }
        DataLogger.m12302d(TAG, "printDatabaseStrategy - " + ((Object) sb));
    }

    @Override // com.samsung.android.support.senl.p148nt.model.document.save.DocumentOperation
    public boolean apply(Entity entity) {
        try {
            try {
                SpenDocument spenDocument = getSpenDocument();
                if (entity != null && spenDocument != null) {
                    String str = TAG;
                    DataLogger.m12307i(str, "apply, document : " + spenDocument);
                    DataLogger.m12305f(str, "apply, entity : " + entity);
                    DataLogger.m12308p(str, "save database operation - start");
                    printDatabaseStrategy(new DataStrategy(getSaveStrategy()));
                    setDocumentTitleEntity(spenDocument, entity);
                    setDocumentPageEntity(spenDocument, entity);
                    setDocumentBackgroundEntity(spenDocument, entity);
                    setDocumentContentEntity(spenDocument, entity);
                    setDocumentSize(spenDocument, entity);
                    setDocumentTimeEntity(spenDocument, entity);
                    setLockAccountGuidEntity(spenDocument, entity);
                    saveToDatabase(spenDocument, entity);
                    try {
                        new SDocEncryptionHelper(getContext(), entity).encryptContents();
                    } catch (Exception e) {
                        DataLogger.m12305f(TAG, "apply, end -> failed to encryptContents - e : " + e.getMessage());
                    }
                    entity.getTimeSaveParam().setTime(null, null);
                    DataRepositoryScheduler.runnable(new DocumentPostSaveOperation(getContext(), isNew(), entity, null).setStrategy(4)).executeOn(NotesDataTaskExecutor.getIOThreadExecutor()).execute();
                    String str2 = TAG;
                    DataLogger.m12305f(str2, "apply, end - insert to database. entity : " + entity);
                    DataLogger.m12308p(str2, "save database operation - end");
                    return true;
                }
                return false;
            } catch (Exception e2) {
                String str3 = TAG;
                DataLogger.m12305f(str3, "apply, e : " + e2.getMessage());
                DataLogger.m12308p(str3, "save database operation - end");
                return false;
            }
        } finally {
            DataLogger.m12308p(TAG, "save database operation - end");
        }
    }

    public boolean checkSaveStrategy(@SaveStrategy int i) {
        return this.mSaveStrategy.check(i);
    }

    @Nullable
    public String getLockAccountGuid() {
        String str = this.mLockAccountGuid;
        return str == null ? "" : str;
    }

    public int getSaveStrategy() {
        return this.mSaveStrategy.getMStrategy();
    }

    public SpenDocument getSpenDocument() {
        return this.mSpenDocument;
    }

    public boolean isNew() {
        return this.mIsNew;
    }

    public abstract void saveToDatabase(@NonNull SpenDocument spendocument, @NonNull Entity entity);

    public abstract void setDocumentBackgroundEntity(@NonNull SpenDocument spendocument, @NonNull Entity entity);

    public abstract void setDocumentContentEntity(@NonNull SpenDocument spendocument, @NonNull Entity entity);

    public abstract void setDocumentPageEntity(@NonNull SpenDocument spendocument, @NonNull Entity entity);

    public abstract void setDocumentSize(@NonNull SpenDocument spendocument, @NonNull Entity entity);

    public abstract void setDocumentTimeEntity(@NonNull SpenDocument spendocument, @NonNull Entity entity);

    public abstract void setDocumentTitleEntity(@NonNull SpenDocument spendocument, @NonNull Entity entity);

    public SaveOperation<Entity, SpenDocument> setLockAccountGuid(@Nullable String str) {
        this.mLockAccountGuid = str;
        return this;
    }

    public abstract void setLockAccountGuidEntity(@NonNull SpenDocument spendocument, @NonNull Entity entity);

    public SaveOperation<Entity, SpenDocument> setNew(boolean z) {
        this.mIsNew = z;
        return this;
    }

    public SaveOperation<Entity, SpenDocument> setSaveStrategy(@SaveStrategy int i) {
        this.mSaveStrategy.set(i);
        return this;
    }

    public SaveOperation<Entity, SpenDocument> setSpenDocument(SpenDocument spendocument) {
        this.mSpenDocument = spendocument;
        return this;
    }

    public SaveOperation<Entity, SpenDocument> setUpdateDocSize(boolean z) {
        this.mUpdateDocSize = z;
        return this;
    }

    public boolean updateDocSize() {
        return this.mUpdateDocSize;
    }
}
