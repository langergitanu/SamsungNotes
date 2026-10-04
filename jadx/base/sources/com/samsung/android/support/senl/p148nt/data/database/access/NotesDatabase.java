package com.samsung.android.support.senl.p148nt.data.database.access;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import com.samsung.android.support.senl.p148nt.data.database.core.converter.NotesDataConverter;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.CoverStickerDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.CoverTemplateDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.DocumentExtraDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.DocumentTempDataDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.DocumentThumbnailDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.ExternalSharedDocumentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.MainListDocumentDataDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeClosureDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesContentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesConvertedDocumentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDebugDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentCoverDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentPageDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesHashtagContentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesHashtagDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesLockDocumentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesMappedDocumentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesOldDocumentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesOrganizedDocumentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesPageSearchInfoDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesRecycleBinDocumentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesRestoreDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesRetryDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesSearchDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesStrokeDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesTagDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesTemplateDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.RestoreFolderDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.StickyNoteDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.StickyStrokeDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.StickyTextDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.SttContentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.SuggestedCoverDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.CoverStickerEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.CoverTemplateEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.DocumentExtraEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.DocumentTempDataEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.DocumentThumbnailEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.ExternalSharedDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeClosureEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesContentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentCoverEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentPageEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentTextSearchEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesHashtagContentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesHashtagEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesMappedDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesOrganizedDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesPageSearchInfoEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesRetryEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesStrokeSearchEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesTagEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesTemplateEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.StickyNoteEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.StickyStrokeSearchEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.StickyTextEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.SttContentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.SuggestedCoverEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.external.ExternalDataDao;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncCategoryTreeDao;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncDelayInfoDao;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncDocumentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncFolderInfoDao;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncInfoDao;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncMdeDao;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.SyncDelayInfoEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.SyncFolderInfoEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.SyncInfoEntity;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@TypeConverters({NotesDataConverter.class})
@Database(entities = {NotesDocumentEntity.class, NotesContentEntity.class, NotesCategoryTreeEntity.class, NotesCategoryTreeClosureEntity.class, SyncInfoEntity.class, NotesTagEntity.class, NotesRetryEntity.class, NotesStrokeSearchEntity.class, NotesTemplateEntity.class, NotesMappedDocumentEntity.class, NotesDocumentPageEntity.class, NotesHashtagEntity.class, NotesHashtagContentEntity.class, NotesDocumentTextSearchEntity.class, DocumentThumbnailEntity.class, NotesPageSearchInfoEntity.class, CoverTemplateEntity.class, CoverStickerEntity.class, SuggestedCoverEntity.class, NotesDocumentCoverEntity.class, NotesOrganizedDocumentEntity.class, SttContentEntity.class, DocumentTempDataEntity.class, SyncDelayInfoEntity.class, DocumentExtraEntity.class, StickyNoteEntity.class, StickyTextEntity.class, StickyStrokeSearchEntity.class, ExternalSharedDocumentEntity.class, SyncFolderInfoEntity.class}, version = 67)
public abstract class NotesDatabase extends RoomDatabase {
    static final String DATABASE_NAME = "sdoc.db";

    public abstract NotesCategoryTreeClosureDao getCategoryTreeClosureDao();

    public abstract NotesCategoryTreeDao getCategoryTreeDao();

    public abstract NotesContentDao getContentDao();

    public abstract NotesConvertedDocumentDao getConvertedDocumentDao();

    public abstract CoverStickerDao getCoverStickerDao();

    public abstract CoverTemplateDao getCoverTemplateDao();

    public abstract NotesDebugDao getDebugDao();

    public abstract NotesDocumentCoverDao getDocumentCoverDao();

    public abstract NotesDocumentDao getDocumentDao();

    public abstract DocumentExtraDao getDocumentExtraDao();

    public abstract NotesDocumentPageDao getDocumentPageDao();

    public abstract DocumentTempDataDao getDocumentTempDataDao();

    public abstract DocumentThumbnailDao getDocumentThumbnailDao();

    public abstract ExternalDataDao getExternalDataDao();

    public abstract ExternalSharedDocumentDao getExternalSharedDocumentDao();

    public abstract NotesHashtagContentDao getHashtagContentDao();

    public abstract NotesHashtagDao getHashtagDao();

    public abstract NotesLockDocumentDao getLockDocumentDao();

    public abstract MainListDocumentDataDao getMainListDocumentDataDao();

    public abstract NotesMappedDocumentDao getMappedDocumentDao();

    public abstract NotesSearchDao getNotesSearchDao();

    public abstract NotesTemplateDao getNotesTemplateDao();

    public abstract NotesOldDocumentDao getOldDocumentDao();

    public abstract NotesOrganizedDocumentDao getOrganizedDocumentDao();

    public abstract NotesPageSearchInfoDao getPageSearchInfoDao();

    public abstract NotesRecycleBinDocumentDao getRecycleBinDocumentDao();

    public abstract NotesRestoreDao getRestoreDao();

    public abstract RestoreFolderDao getRestoreFolderDao();

    public abstract NotesRetryDao getRetryDao();

    public abstract StickyNoteDao getStickyNoteDao();

    public abstract StickyStrokeDao getStickyStrokeDao();

    public abstract StickyTextDao getStickyTextDao();

    public abstract NotesStrokeDao getStrokeDao();

    public abstract SttContentDao getSttContentDao();

    public abstract SuggestedCoverDao getSuggestedCoverDao();

    public abstract SyncCategoryTreeDao getSyncCategoryTreeDao();

    public abstract SyncDelayInfoDao getSyncDelayInfoDao();

    public abstract SyncDocumentDao getSyncDocumentDao();

    public abstract SyncFolderInfoDao getSyncFolderInfoDao();

    public abstract SyncInfoDao getSyncInfoDao();

    public abstract SyncMdeDao getSyncMdeDao();

    public abstract NotesTagDao getTagDao();
}
