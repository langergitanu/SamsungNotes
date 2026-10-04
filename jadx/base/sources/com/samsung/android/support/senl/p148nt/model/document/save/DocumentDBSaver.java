package com.samsung.android.support.senl.p148nt.model.document.save;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWNoteFile;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.SpenWNoteObjectHelper;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.DocumentExtraEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncInfoDao;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.SyncInfoEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.DocumentExtraRepository;
import com.samsung.android.support.senl.p148nt.data.repository.document.DocumentThumbnailRepository;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentRepository;
import com.samsung.android.support.senl.p148nt.data.sync.resolver.MaxObjectLimitHelper;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class DocumentDBSaver {
    private static final String TAG = DataLogger.createTag("DocumentDBSaver");

    private static SyncInfoEntity getSyncInfoEntity(@NonNull SyncInfoDao syncInfoDao, @NonNull String str) {
        DataLogger.m12307i(TAG, "getSyncInfoEntity");
        SyncInfoEntity entity = syncInfoDao.getEntity(str);
        if (entity != null) {
            return entity;
        }
        SyncInfoEntity syncInfoEntity = new SyncInfoEntity();
        syncInfoEntity.setNoteClientId(str);
        return syncInfoEntity;
    }

    private static void insertDocumentExtraInfo(@NonNull DocumentExtraRepository documentExtraRepository, @NonNull NotesDocumentEntity notesDocumentEntity, @NonNull SpenWNote spenWNote) {
        SpenWNoteObjectHelper spenWNoteObjectHelper = new SpenWNoteObjectHelper();
        DocumentExtraEntity documentExtraEntity = new DocumentExtraEntity();
        documentExtraEntity.setUuid(notesDocumentEntity.getUuid());
        documentExtraEntity.setHasSticky(spenWNote.hasCustomObject() ? 1 : 0);
        documentExtraEntity.setHasImage(spenWNoteObjectHelper.hasObject(spenWNote, 3) ? 1 : 0);
        documentExtraEntity.setHasStroke(spenWNote.hasObject(1) ? 1 : 0);
        documentExtraEntity.setHasPdf(spenWNoteObjectHelper.hasCustomPdf(spenWNote) ? 1 : 0);
        documentExtraEntity.setUnknownMinVersion(spenWNote.getMinUnknownVersion());
        documentExtraEntity.setFormatVersion(SpenWNoteFile.getFormatVersion(notesDocumentEntity.getFilePath()));
        documentExtraRepository.insert(documentExtraEntity);
    }

    public static void insertDocumentThumbnail(@NonNull DocumentThumbnailRepository documentThumbnailRepository, @NonNull String str, @NonNull SpenWNote spenWNote, int i) {
        if (i < 0) {
            return;
        }
        documentThumbnailRepository.insert(new ThumbnailDataCreator(str, spenWNote, i).createEntity());
    }

    public static void saveSDoc(@NonNull NotesDocumentRepository notesDocumentRepository, NotesDocumentEntity notesDocumentEntity) {
        notesDocumentRepository.insert(notesDocumentEntity);
    }

    public static void saveSDocX(@NonNull NotesDataRepositoryFactory notesDataRepositoryFactory, @Nullable SpenWNote spenWNote, @NonNull NotesDocumentEntity notesDocumentEntity, int i) {
        NotesDocumentRepository notesDocumentRepositoryCreateDocumentDataRepository = notesDataRepositoryFactory.createDocumentDataRepository();
        notesDocumentRepositoryCreateDocumentDataRepository.insert(notesDocumentEntity);
        if (spenWNote != null) {
            insertDocumentExtraInfo(notesDataRepositoryFactory.createDocumentExtraRepository(), notesDocumentEntity, spenWNote);
            insertDocumentThumbnail(notesDataRepositoryFactory.createDocumentThumbnailRepository(), notesDocumentEntity.getUuid(), spenWNote, i);
        }
        updateSyncInfo(notesDocumentRepositoryCreateDocumentDataRepository.getDatabase().getSyncInfoDao(), spenWNote, notesDocumentEntity);
        notesDocumentRepositoryCreateDocumentDataRepository.updateFolderTimeByKeepServerTimestampFlag(notesDocumentEntity);
    }

    private static void updateSyncInfo(@NonNull SyncInfoDao syncInfoDao, @Nullable SpenWNote spenWNote, @NonNull NotesDocumentEntity notesDocumentEntity) {
        SyncInfoEntity syncInfoEntity = getSyncInfoEntity(syncInfoDao, notesDocumentEntity.getUuid());
        updateSyncState(syncInfoEntity, spenWNote, notesDocumentEntity.getCategoryUuid());
        syncInfoDao.upsert(syncInfoEntity);
    }

    private static void updateSyncState(@NonNull SyncInfoEntity syncInfoEntity, @Nullable SpenWNote spenWNote, @NonNull String str) {
        long syncState = syncInfoEntity.getSyncState();
        boolean zEquals = "shared:///".equals(str);
        if (spenWNote != null && !zEquals) {
            int strokeGrouped = syncInfoEntity.getStrokeGrouped();
            syncState = MaxObjectLimitHelper.isMaxStrokeObjectLimit(strokeGrouped, spenWNote.getPageObjectCount(), spenWNote.getPageObjectCount(1)) ? strokeGrouped == 1 ? 65536 | ((-513) & syncState) : syncState | 512 : syncState & (-66049);
        }
        syncInfoEntity.setSyncState(syncState);
    }
}
