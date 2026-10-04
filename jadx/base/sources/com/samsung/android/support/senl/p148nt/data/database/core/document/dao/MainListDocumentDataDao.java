package com.samsung.android.support.senl.p148nt.data.database.core.document.dao;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import androidx.room.Dao;
import androidx.room.Query;
import androidx.room.RawQuery;
import androidx.room.Transaction;
import androidx.sqlite.p113db.SimpleSQLiteQuery;
import androidx.sqlite.p113db.SupportSQLiteQuery;
import com.google.android.material.color.utilities.C4662f;
import com.opencsv.bean.C6631n;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.scs.requester.C8886c;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.CategoryConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.DeleteType;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.DocumentExtraEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.DocumentThumbnailEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentCoverEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.SuggestedCoverEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entry.NotesDocumentCountEntry;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesCategoryTreeSortUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.document.sort.FolderSortData;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.QueryConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.QueryUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.query.common.SplitTaskExecutor;
import com.samsung.android.support.senl.p148nt.data.database.core.query.document.DocumentSortQuery;
import com.samsung.android.support.senl.p148nt.data.database.core.query.param.SortParam;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.NotesSQLBuilder;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.DBSchema;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.SyncInfoEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import p079T.C0287e;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Dao
public abstract class MainListDocumentDataDao {
    private static final String TAG = DataLogger.createTag("MainListDocumentDataDao");
    private static final String sQueryGetDocumentWithTag = "SELECT `sdoc`.`_id` AS `_id`, `sdoc`.`UUID` AS `UUID`, `sdoc`.`isDeleted` AS `isDeleted`, `sdoc`.`isDirty` AS `isDirty`, substr(`sdoc`.`title`, 1, 300) AS `title`, `sdoc`.`recommendedTitle` AS `recommendedTitle`, substr(`sdoc`.`content`, 1, 300) AS `content`, `sdoc`.`displayContent` AS `displayContent`, `sdoc`.`createdAt` AS `createdAt`, `sdoc`.`lastModifiedAt` AS `lastModifiedAt`, `sdoc`.`vrUUID` AS `vrUUID`, `sdoc`.`contentUUID` AS `contentUUID`, `sdoc`.`firstContentType` AS `firstContentType`, `sdoc`.`secondContentType` AS `secondContentType`, `sdoc`.`strokeUUID` AS `strokeUUID`, `sdoc`.`categoryUUID` AS `categoryUUID`, `sdoc`.`filePath` AS `filePath`, `sdoc`.`isFavorite` AS `isFavorite`, `sdoc`.`isLock` AS `isLock`, `sdoc`.`isSaving` AS `isSaving`, `sdoc`.`recycle_bin_time_moved` AS `recycle_bin_time_moved`, `sdoc`.`firstOpendAt` AS `firstOpendAt`, `sdoc`.`mdeSpaceId` AS `mdeSpaceId`, `sdoc`.`mdeItemId` AS `mdeItemId`, `sdoc`.`mdeGroupId` AS `mdeGroupId`, `sdoc`.`mdeOwnerId` AS `mdeOwnerId`, `sdoc`.`absolutePath` AS `absolutePath`, `sdoc`.`backgroundColor` AS `backgroundColor`, `sdoc`.`backgroundColorInverted` AS `backgroundColorInverted`, `sdoc`.`corrupted` AS `corrupted`, `sdoc`.`pageMode` AS `pageMode`, `sdoc`.`size` AS `size`,`document_cover`.`templateUUID` AS `coverTemplateUuid`, `document_cover`.`summary` AS `coverSummary`, `document_cover`.`summary_alignment` AS `coverSummaryAlignment`, `document_cover`.`categoryUUID` AS `coverStickerUuid`, `document_cover`.`backgroundColor` AS `coverBackgroundColor`, `document_cover`.`isEnabled` AS `isCoverEnabled`, `suggested_cover`.`state` AS `coverSuggestedState`, `sync_info`.`syncState` AS `syncState`, `document_extra`.`hasSticky` AS `hasSticky`, `document_extra`.`unknownMinVersion` AS `unknownMinVersion`, `document_extra`.`formatVersion` AS `formatVersion`,`document_thumbnail`.`backgroundType` AS `backgroundType`, `document_thumbnail`.`layout` AS `layout`,`document_thumbnail`.`imagePath` AS `imagePath`, `document_thumbnail`.`playTime` AS `playTime` FROM sdoc JOIN tag_list ON sdoc.uuid = tag_list.docUUID LEFT JOIN document_extra ON sdoc.UUID = document_extra.UUID LEFT JOIN document_thumbnail ON sdoc.UUID = document_thumbnail.UUID LEFT JOIN sync_info ON sdoc.UUID = sync_info.clientId LEFT JOIN document_cover ON sdoc.UUID = document_cover.documentUUID LEFT JOIN suggested_cover ON sdoc.UUID = suggested_cover.documentUUID WHERE sdoc.isDeleted = 0 AND sdoc.isLock = 0";
    private static final String sQueryGetOldDocumentWithTag = "SELECT `sdoc`.`_id` AS `_id`, `sdoc`.`UUID` AS `UUID`, `sdoc`.`isDeleted` AS `isDeleted`, `sdoc`.`isDirty` AS `isDirty`, substr(`sdoc`.`title`, 1, 300) AS `title`, `sdoc`.`recommendedTitle` AS `recommendedTitle`, substr(`sdoc`.`content`, 1, 300) AS `content`, `sdoc`.`displayContent` AS `displayContent`, `sdoc`.`createdAt` AS `createdAt`, `sdoc`.`lastModifiedAt` AS `lastModifiedAt`, `sdoc`.`vrUUID` AS `vrUUID`, `sdoc`.`contentUUID` AS `contentUUID`, `sdoc`.`firstContentType` AS `firstContentType`, `sdoc`.`secondContentType` AS `secondContentType`, `sdoc`.`strokeUUID` AS `strokeUUID`, `sdoc`.`categoryUUID` AS `categoryUUID`, `sdoc`.`filePath` AS `filePath`, `sdoc`.`isFavorite` AS `isFavorite`, `sdoc`.`isLock` AS `isLock`, `sdoc`.`isSaving` AS `isSaving`, `sdoc`.`recycle_bin_time_moved` AS `recycle_bin_time_moved`, `sdoc`.`firstOpendAt` AS `firstOpendAt`, `sdoc`.`mdeSpaceId` AS `mdeSpaceId`, `sdoc`.`mdeItemId` AS `mdeItemId`, `sdoc`.`mdeGroupId` AS `mdeGroupId`, `sdoc`.`mdeOwnerId` AS `mdeOwnerId`, `sdoc`.`absolutePath` AS `absolutePath`, `sdoc`.`backgroundColor` AS `backgroundColor`, `sdoc`.`backgroundColorInverted` AS `backgroundColorInverted`, `sdoc`.`corrupted` AS `corrupted`, `sdoc`.`pageMode` AS `pageMode`, `sdoc`.`size` AS `size`,`document_cover`.`templateUUID` AS `coverTemplateUuid`, `document_cover`.`summary` AS `coverSummary`, `document_cover`.`summary_alignment` AS `coverSummaryAlignment`, `document_cover`.`categoryUUID` AS `coverStickerUuid`, `document_cover`.`backgroundColor` AS `coverBackgroundColor`, `document_cover`.`isEnabled` AS `isCoverEnabled`, `suggested_cover`.`state` AS `coverSuggestedState`, `sync_info`.`syncState` AS `syncState`, `document_extra`.`hasSticky` AS `hasSticky`, `document_extra`.`unknownMinVersion` AS `unknownMinVersion`, `document_extra`.`formatVersion` AS `formatVersion`,`document_thumbnail`.`backgroundType` AS `backgroundType`, `document_thumbnail`.`layout` AS `layout`,`document_thumbnail`.`imagePath` AS `imagePath`, `document_thumbnail`.`playTime` AS `playTime` FROM sdoc  JOIN hashtagContent ON sdoc.UUID = hashtagContent.sdocUUID JOIN hashtag ON hashtag.UUID = hashtagContent.hashtagUUID LEFT JOIN mapped_document AS map ON sdoc.UUID = map.UUID LEFT JOIN document_extra ON sdoc.UUID = document_extra.UUID LEFT JOIN document_thumbnail ON sdoc.UUID = document_thumbnail.UUID LEFT JOIN sync_info ON sdoc.UUID = sync_info.clientId LEFT JOIN document_cover ON sdoc.UUID = document_cover.documentUUID LEFT JOIN suggested_cover ON sdoc.UUID = suggested_cover.documentUUID WHERE sdoc.isDeleted = 0 AND map.UUID IS NULL AND sdoc.isLock = 0";

    private SupportSQLiteQuery getAllByTagNormalizedNamesQuery(SortParam sortParam, Collection<String> collection) {
        int size = collection.size();
        String strCreateQuery = new DocumentSortQuery().createQuery(sortParam);
        List<String> documentsWithTag = getDocumentsWithTag(collection, size);
        List<String> oldDocumentsWithTag = getOldDocumentsWithTag(collection, size);
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(getDocumentsWithTag(collection, size));
        arrayList.addAll(getOldDocumentsWithTag(collection, size));
        return new SimpleSQLiteQuery(new NotesSQLBuilder().select("sdoc.*").from("(SELECT `sdoc`.`_id` AS `_id`, `sdoc`.`UUID` AS `UUID`, `sdoc`.`isDeleted` AS `isDeleted`, `sdoc`.`isDirty` AS `isDirty`, substr(`sdoc`.`title`, 1, 300) AS `title`, `sdoc`.`recommendedTitle` AS `recommendedTitle`, substr(`sdoc`.`content`, 1, 300) AS `content`, `sdoc`.`displayContent` AS `displayContent`, `sdoc`.`createdAt` AS `createdAt`, `sdoc`.`lastModifiedAt` AS `lastModifiedAt`, `sdoc`.`vrUUID` AS `vrUUID`, `sdoc`.`contentUUID` AS `contentUUID`, `sdoc`.`firstContentType` AS `firstContentType`, `sdoc`.`secondContentType` AS `secondContentType`, `sdoc`.`strokeUUID` AS `strokeUUID`, `sdoc`.`categoryUUID` AS `categoryUUID`, `sdoc`.`filePath` AS `filePath`, `sdoc`.`isFavorite` AS `isFavorite`, `sdoc`.`isLock` AS `isLock`, `sdoc`.`isSaving` AS `isSaving`, `sdoc`.`recycle_bin_time_moved` AS `recycle_bin_time_moved`, `sdoc`.`firstOpendAt` AS `firstOpendAt`, `sdoc`.`mdeSpaceId` AS `mdeSpaceId`, `sdoc`.`mdeItemId` AS `mdeItemId`, `sdoc`.`mdeGroupId` AS `mdeGroupId`, `sdoc`.`mdeOwnerId` AS `mdeOwnerId`, `sdoc`.`absolutePath` AS `absolutePath`, `sdoc`.`backgroundColor` AS `backgroundColor`, `sdoc`.`backgroundColorInverted` AS `backgroundColorInverted`, `sdoc`.`corrupted` AS `corrupted`, `sdoc`.`pageMode` AS `pageMode`, `sdoc`.`size` AS `size`,`document_cover`.`templateUUID` AS `coverTemplateUuid`, `document_cover`.`summary` AS `coverSummary`, `document_cover`.`summary_alignment` AS `coverSummaryAlignment`, `document_cover`.`categoryUUID` AS `coverStickerUuid`, `document_cover`.`backgroundColor` AS `coverBackgroundColor`, `document_cover`.`isEnabled` AS `isCoverEnabled`, `suggested_cover`.`state` AS `coverSuggestedState`, `sync_info`.`syncState` AS `syncState`, `document_extra`.`hasSticky` AS `hasSticky`, `document_extra`.`unknownMinVersion` AS `unknownMinVersion`, `document_extra`.`formatVersion` AS `formatVersion`,`document_thumbnail`.`backgroundType` AS `backgroundType`, `document_thumbnail`.`layout` AS `layout`,`document_thumbnail`.`imagePath` AS `imagePath`, `document_thumbnail`.`playTime` AS `playTime` FROM sdoc JOIN tag_list ON sdoc.uuid = tag_list.docUUID LEFT JOIN document_extra ON sdoc.UUID = document_extra.UUID LEFT JOIN document_thumbnail ON sdoc.UUID = document_thumbnail.UUID LEFT JOIN sync_info ON sdoc.UUID = sync_info.clientId LEFT JOIN document_cover ON sdoc.UUID = document_cover.documentUUID LEFT JOIN suggested_cover ON sdoc.UUID = suggested_cover.documentUUID WHERE sdoc.isDeleted = 0 AND sdoc.isLock = 0 AND tag_list.docUUID IN (" + QueryUtils.getPlaceHolders(documentsWithTag.size()) + ") UNION SELECT `sdoc`.`_id` AS `_id`, `sdoc`.`UUID` AS `UUID`, `sdoc`.`isDeleted` AS `isDeleted`, `sdoc`.`isDirty` AS `isDirty`, substr(`sdoc`.`title`, 1, 300) AS `title`, `sdoc`.`recommendedTitle` AS `recommendedTitle`, substr(`sdoc`.`content`, 1, 300) AS `content`, `sdoc`.`displayContent` AS `displayContent`, `sdoc`.`createdAt` AS `createdAt`, `sdoc`.`lastModifiedAt` AS `lastModifiedAt`, `sdoc`.`vrUUID` AS `vrUUID`, `sdoc`.`contentUUID` AS `contentUUID`, `sdoc`.`firstContentType` AS `firstContentType`, `sdoc`.`secondContentType` AS `secondContentType`, `sdoc`.`strokeUUID` AS `strokeUUID`, `sdoc`.`categoryUUID` AS `categoryUUID`, `sdoc`.`filePath` AS `filePath`, `sdoc`.`isFavorite` AS `isFavorite`, `sdoc`.`isLock` AS `isLock`, `sdoc`.`isSaving` AS `isSaving`, `sdoc`.`recycle_bin_time_moved` AS `recycle_bin_time_moved`, `sdoc`.`firstOpendAt` AS `firstOpendAt`, `sdoc`.`mdeSpaceId` AS `mdeSpaceId`, `sdoc`.`mdeItemId` AS `mdeItemId`, `sdoc`.`mdeGroupId` AS `mdeGroupId`, `sdoc`.`mdeOwnerId` AS `mdeOwnerId`, `sdoc`.`absolutePath` AS `absolutePath`, `sdoc`.`backgroundColor` AS `backgroundColor`, `sdoc`.`backgroundColorInverted` AS `backgroundColorInverted`, `sdoc`.`corrupted` AS `corrupted`, `sdoc`.`pageMode` AS `pageMode`, `sdoc`.`size` AS `size`,`document_cover`.`templateUUID` AS `coverTemplateUuid`, `document_cover`.`summary` AS `coverSummary`, `document_cover`.`summary_alignment` AS `coverSummaryAlignment`, `document_cover`.`categoryUUID` AS `coverStickerUuid`, `document_cover`.`backgroundColor` AS `coverBackgroundColor`, `document_cover`.`isEnabled` AS `isCoverEnabled`, `suggested_cover`.`state` AS `coverSuggestedState`, `sync_info`.`syncState` AS `syncState`, `document_extra`.`hasSticky` AS `hasSticky`, `document_extra`.`unknownMinVersion` AS `unknownMinVersion`, `document_extra`.`formatVersion` AS `formatVersion`,`document_thumbnail`.`backgroundType` AS `backgroundType`, `document_thumbnail`.`layout` AS `layout`,`document_thumbnail`.`imagePath` AS `imagePath`, `document_thumbnail`.`playTime` AS `playTime` FROM sdoc  JOIN hashtagContent ON sdoc.UUID = hashtagContent.sdocUUID JOIN hashtag ON hashtag.UUID = hashtagContent.hashtagUUID LEFT JOIN mapped_document AS map ON sdoc.UUID = map.UUID LEFT JOIN document_extra ON sdoc.UUID = document_extra.UUID LEFT JOIN document_thumbnail ON sdoc.UUID = document_thumbnail.UUID LEFT JOIN sync_info ON sdoc.UUID = sync_info.clientId LEFT JOIN document_cover ON sdoc.UUID = document_cover.documentUUID LEFT JOIN suggested_cover ON sdoc.UUID = suggested_cover.documentUUID WHERE sdoc.isDeleted = 0 AND map.UUID IS NULL AND sdoc.isLock = 0 AND hashtagContent.sdocUUID IN (" + QueryUtils.getPlaceHolders(oldDocumentsWithTag.size()) + ")) AS sdoc").orderBy(strCreateQuery).build(), arrayList.toArray());
    }

    private SupportSQLiteQuery getAllWithTagQuery(String str) {
        return new SimpleSQLiteQuery(new NotesSQLBuilder().select("sdoc.*").from("(SELECT `sdoc`.`_id` AS `_id`, `sdoc`.`UUID` AS `UUID`, `sdoc`.`isDeleted` AS `isDeleted`, `sdoc`.`isDirty` AS `isDirty`, substr(`sdoc`.`title`, 1, 300) AS `title`, `sdoc`.`recommendedTitle` AS `recommendedTitle`, substr(`sdoc`.`content`, 1, 300) AS `content`, `sdoc`.`displayContent` AS `displayContent`, `sdoc`.`createdAt` AS `createdAt`, `sdoc`.`lastModifiedAt` AS `lastModifiedAt`, `sdoc`.`vrUUID` AS `vrUUID`, `sdoc`.`contentUUID` AS `contentUUID`, `sdoc`.`firstContentType` AS `firstContentType`, `sdoc`.`secondContentType` AS `secondContentType`, `sdoc`.`strokeUUID` AS `strokeUUID`, `sdoc`.`categoryUUID` AS `categoryUUID`, `sdoc`.`filePath` AS `filePath`, `sdoc`.`isFavorite` AS `isFavorite`, `sdoc`.`isLock` AS `isLock`, `sdoc`.`isSaving` AS `isSaving`, `sdoc`.`recycle_bin_time_moved` AS `recycle_bin_time_moved`, `sdoc`.`firstOpendAt` AS `firstOpendAt`, `sdoc`.`mdeSpaceId` AS `mdeSpaceId`, `sdoc`.`mdeItemId` AS `mdeItemId`, `sdoc`.`mdeGroupId` AS `mdeGroupId`, `sdoc`.`mdeOwnerId` AS `mdeOwnerId`, `sdoc`.`absolutePath` AS `absolutePath`, `sdoc`.`backgroundColor` AS `backgroundColor`, `sdoc`.`backgroundColorInverted` AS `backgroundColorInverted`, `sdoc`.`corrupted` AS `corrupted`, `sdoc`.`pageMode` AS `pageMode`, `sdoc`.`size` AS `size`,`document_cover`.`templateUUID` AS `coverTemplateUuid`, `document_cover`.`summary` AS `coverSummary`, `document_cover`.`summary_alignment` AS `coverSummaryAlignment`, `document_cover`.`categoryUUID` AS `coverStickerUuid`, `document_cover`.`backgroundColor` AS `coverBackgroundColor`, `document_cover`.`isEnabled` AS `isCoverEnabled`, `suggested_cover`.`state` AS `coverSuggestedState`, `sync_info`.`syncState` AS `syncState`, `document_extra`.`hasSticky` AS `hasSticky`, `document_extra`.`unknownMinVersion` AS `unknownMinVersion`, `document_extra`.`formatVersion` AS `formatVersion`,`document_thumbnail`.`backgroundType` AS `backgroundType`, `document_thumbnail`.`layout` AS `layout`,`document_thumbnail`.`imagePath` AS `imagePath`, `document_thumbnail`.`playTime` AS `playTime` FROM sdoc JOIN tag_list ON sdoc.uuid = tag_list.docUUID LEFT JOIN document_extra ON sdoc.UUID = document_extra.UUID LEFT JOIN document_thumbnail ON sdoc.UUID = document_thumbnail.UUID LEFT JOIN sync_info ON sdoc.UUID = sync_info.clientId LEFT JOIN document_cover ON sdoc.UUID = document_cover.documentUUID LEFT JOIN suggested_cover ON sdoc.UUID = suggested_cover.documentUUID WHERE sdoc.isDeleted = 0 AND sdoc.isLock = 0 UNION SELECT `sdoc`.`_id` AS `_id`, `sdoc`.`UUID` AS `UUID`, `sdoc`.`isDeleted` AS `isDeleted`, `sdoc`.`isDirty` AS `isDirty`, substr(`sdoc`.`title`, 1, 300) AS `title`, `sdoc`.`recommendedTitle` AS `recommendedTitle`, substr(`sdoc`.`content`, 1, 300) AS `content`, `sdoc`.`displayContent` AS `displayContent`, `sdoc`.`createdAt` AS `createdAt`, `sdoc`.`lastModifiedAt` AS `lastModifiedAt`, `sdoc`.`vrUUID` AS `vrUUID`, `sdoc`.`contentUUID` AS `contentUUID`, `sdoc`.`firstContentType` AS `firstContentType`, `sdoc`.`secondContentType` AS `secondContentType`, `sdoc`.`strokeUUID` AS `strokeUUID`, `sdoc`.`categoryUUID` AS `categoryUUID`, `sdoc`.`filePath` AS `filePath`, `sdoc`.`isFavorite` AS `isFavorite`, `sdoc`.`isLock` AS `isLock`, `sdoc`.`isSaving` AS `isSaving`, `sdoc`.`recycle_bin_time_moved` AS `recycle_bin_time_moved`, `sdoc`.`firstOpendAt` AS `firstOpendAt`, `sdoc`.`mdeSpaceId` AS `mdeSpaceId`, `sdoc`.`mdeItemId` AS `mdeItemId`, `sdoc`.`mdeGroupId` AS `mdeGroupId`, `sdoc`.`mdeOwnerId` AS `mdeOwnerId`, `sdoc`.`absolutePath` AS `absolutePath`, `sdoc`.`backgroundColor` AS `backgroundColor`, `sdoc`.`backgroundColorInverted` AS `backgroundColorInverted`, `sdoc`.`corrupted` AS `corrupted`, `sdoc`.`pageMode` AS `pageMode`, `sdoc`.`size` AS `size`,`document_cover`.`templateUUID` AS `coverTemplateUuid`, `document_cover`.`summary` AS `coverSummary`, `document_cover`.`summary_alignment` AS `coverSummaryAlignment`, `document_cover`.`categoryUUID` AS `coverStickerUuid`, `document_cover`.`backgroundColor` AS `coverBackgroundColor`, `document_cover`.`isEnabled` AS `isCoverEnabled`, `suggested_cover`.`state` AS `coverSuggestedState`, `sync_info`.`syncState` AS `syncState`, `document_extra`.`hasSticky` AS `hasSticky`, `document_extra`.`unknownMinVersion` AS `unknownMinVersion`, `document_extra`.`formatVersion` AS `formatVersion`,`document_thumbnail`.`backgroundType` AS `backgroundType`, `document_thumbnail`.`layout` AS `layout`,`document_thumbnail`.`imagePath` AS `imagePath`, `document_thumbnail`.`playTime` AS `playTime` FROM sdoc  JOIN hashtagContent ON sdoc.UUID = hashtagContent.sdocUUID JOIN hashtag ON hashtag.UUID = hashtagContent.hashtagUUID LEFT JOIN mapped_document AS map ON sdoc.UUID = map.UUID LEFT JOIN document_extra ON sdoc.UUID = document_extra.UUID LEFT JOIN document_thumbnail ON sdoc.UUID = document_thumbnail.UUID LEFT JOIN sync_info ON sdoc.UUID = sync_info.clientId LEFT JOIN document_cover ON sdoc.UUID = document_cover.documentUUID LEFT JOIN suggested_cover ON sdoc.UUID = suggested_cover.documentUUID WHERE sdoc.isDeleted = 0 AND map.UUID IS NULL AND sdoc.isLock = 0) AS sdoc").orderBy(str).build());
    }

    private String getAll_QueryStr(int i, SortParam sortParam) {
        return new NotesSQLBuilder().select(DBSchema.DocumentProjection.MAIN_LIST_DOCUMENT_PROJECTION).from(DBSchema.MAIN_LIST_DOCUMENT_MAPPED_JOINED_TABLE).where("sdoc.mdeSpaceId=''").and("sdoc.isDeleted=" + i).and("map.UUID IS NULL").orderBy(new DocumentSortQuery().createQuery(sortParam)).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Map lambda$getAllDocumentCountEntryMap_LiveData$4(NotesOldDocumentDao notesOldDocumentDao, NotesConvertedDocumentDao notesConvertedDocumentDao, boolean z, List list) {
        return makeAllDocumentCountEntryMap(lambda$getAllDocumentCountEntry_LiveData$1(list, notesOldDocumentDao, notesConvertedDocumentDao, z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ NotesDocumentCountEntry lambda$makeDocumentCountEntries$2(NotesDocumentCountEntry notesDocumentCountEntry) {
        return notesDocumentCountEntry;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$makeDocumentCountEntries$3(NotesDocumentCountEntry notesDocumentCountEntry, List list, Map map, NotesDocumentCountEntry notesDocumentCountEntry2) {
        if (notesDocumentCountEntry2.getParentUuid() == null || (notesDocumentCountEntry == null && "old:///".equals(notesDocumentCountEntry2.getParentUuid()))) {
            list.add(notesDocumentCountEntry2);
            return;
        }
        NotesDocumentCountEntry notesDocumentCountEntry3 = (NotesDocumentCountEntry) map.get(notesDocumentCountEntry2.getParentUuid());
        if (notesDocumentCountEntry3 != null) {
            notesDocumentCountEntry3.getChildren().add(notesDocumentCountEntry2);
        }
    }

    private Map<String, NotesDocumentCountEntry> makeAllDocumentCountEntryMap(List<NotesDocumentCountEntry> list) {
        DataLogger.m12307i(TAG, "makeAllDocumentCountEntryMap");
        NotesDocumentCountEntry notesDocumentCountEntry = new NotesDocumentCountEntry();
        notesDocumentCountEntry.setCategoryUuid(PredefinedCategory.ALL.getUuid());
        HashMap map = new HashMap();
        for (NotesDocumentCountEntry notesDocumentCountEntry2 : list) {
            map.put(notesDocumentCountEntry2.getCategoryUuid(), notesDocumentCountEntry2);
            if (!PredefinedCategory.RECYCLE_BIN.getUuid().equals(notesDocumentCountEntry2.getCategoryUuid()) && !PredefinedCategory.SHARED_NOTE_BOOK.getUuid().equals(notesDocumentCountEntry2.getCategoryUuid()) && !PredefinedCategory.OLD_NOTES.getUuid().equals(notesDocumentCountEntry2.getCategoryUuid()) && !"old_converted_notes".equals(notesDocumentCountEntry2.getCategoryUuid()) && notesDocumentCountEntry2.getIsDeleted() == 0) {
                notesDocumentCountEntry.setDocumentCount(notesDocumentCountEntry2.getDocumentCount() + notesDocumentCountEntry.getDocumentCount());
            }
        }
        PredefinedCategory predefinedCategory = PredefinedCategory.RECYCLE_BIN;
        map.put(predefinedCategory.getUuid(), getDocumentCountEntry_NotConsideringMappingTable(predefinedCategory.getUuid()));
        NotesDocumentCountEntry notesDocumentCountEntry3 = (NotesDocumentCountEntry) map.get("old_converted_notes");
        if (notesDocumentCountEntry3 != null) {
            notesDocumentCountEntry.setDocumentCount(notesDocumentCountEntry.getDocumentCount() - notesDocumentCountEntry3.getDocumentCount());
        }
        map.put(PredefinedCategory.ALL.getUuid(), notesDocumentCountEntry);
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: makeDocumentCountEntries, reason: merged with bridge method [inline-methods] */
    public List<NotesDocumentCountEntry> lambda$getAllDocumentCountEntry_LiveData$1(List<NotesDocumentCountEntry> list, @NonNull NotesOldDocumentDao notesOldDocumentDao, @NonNull NotesConvertedDocumentDao notesConvertedDocumentDao, boolean z) {
        Map map = (Map) list.stream().collect(Collectors.toMap(new C4662f(27), new C4662f(28)));
        NotesDocumentCountEntry notesDocumentCountEntry = (NotesDocumentCountEntry) map.get("old:///");
        if (notesDocumentCountEntry != null && notesDocumentCountEntry.getIsDeleted() == 0) {
            notesDocumentCountEntry.setDocumentCount(notesOldDocumentDao.getAll_OldNotes_Count(0));
        }
        if (z) {
            NotesDocumentCountEntry notesDocumentCountEntry2 = new NotesDocumentCountEntry();
            notesDocumentCountEntry2.setCategoryUuid("old_converted_notes");
            notesDocumentCountEntry2.setDisplayName(CategoryConstants.OldConvertedNotes.DISPLAY_NAME);
            notesDocumentCountEntry2.setDocumentCount(notesConvertedDocumentDao.getAll_ConvertedCount(0));
            map.put(notesDocumentCountEntry2.getUuid(), notesDocumentCountEntry2);
        }
        ArrayList arrayList = new ArrayList();
        map.values().forEach(new C6631n(notesDocumentCountEntry, 5, arrayList, map));
        NotesCategoryTreeSortUtils.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList(arrayList);
        while (!arrayList3.isEmpty()) {
            FolderSortData folderSortData = (FolderSortData) arrayList3.remove(0);
            arrayList2.add((NotesDocumentCountEntry) folderSortData);
            arrayList3.addAll(folderSortData.getChildren());
        }
        return arrayList2;
    }

    public List<MainListDocumentData> getAll(@DeleteType int i, SortParam sortParam) {
        return rawQuery(new SimpleSQLiteQuery(getAll_QueryStr(i, sortParam)));
    }

    @Transaction
    public List<MainListDocumentData> getAllByTagNormalizedNames(SortParam sortParam, Collection<String> collection) {
        return rawQuery(getAllByTagNormalizedNamesQuery(sortParam, collection));
    }

    public List<MainListDocumentData> getAllContentShare(@DeleteType int i, SortParam sortParam, String str) {
        return rawQuery(new SimpleSQLiteQuery(AbstractC0541b.m757C(new NotesSQLBuilder().select(DBSchema.DocumentProjection.MAIN_LIST_DOCUMENT_PROJECTION).from(DBSchema.MAIN_LIST_DOCUMENT_MAPPED_JOINED_TABLE).where("sdoc.mdeSpaceId=?").and("sdoc.isDeleted=" + i).and("(map.UUID IS NULL OR mdeSpaceId!='')").build(), SQLKeyword.ORDER_BY, new DocumentSortQuery().createQuery(sortParam)), new Object[]{str}));
    }

    @Nullable
    public LiveData<List<MainListDocumentData>> getAllContentShare_LiveData(@DeleteType int i, @NonNull SortParam sortParam, String str) {
        return rawQuery_LiveData(new SimpleSQLiteQuery(AbstractC0541b.m757C(new NotesSQLBuilder().select(DBSchema.DocumentProjection.MAIN_LIST_DOCUMENT_PROJECTION).from(DBSchema.MAIN_LIST_DOCUMENT_MAPPED_JOINED_TABLE).where("sdoc.mdeSpaceId=?").and("sdoc.isDeleted=" + i).and("(map.UUID IS NULL OR mdeSpaceId!='')").build(), SQLKeyword.ORDER_BY, new DocumentSortQuery().createQuery(sortParam)), new Object[]{str}));
    }

    public LiveData<Map<String, NotesDocumentCountEntry>> getAllDocumentCountEntryMap_LiveData(@NonNull NotesOldDocumentDao notesOldDocumentDao, @NonNull NotesConvertedDocumentDao notesConvertedDocumentDao, boolean z) {
        DataLogger.m12307i(TAG, "getAllDocumentCountEntryMap_LiveData");
        return Transformations.map(getAllDocumentCountEntry_LiveData(), new C11244a(this, notesOldDocumentDao, notesConvertedDocumentDao, z, 1));
    }

    @Query("SELECT category_tree.UUID, category_tree.parentUUID, category_tree.displayName, category_tree.displayNameColor, category_tree.isDeleted, category_tree.createdAt, category_tree.lastModifiedAt, category_tree.recycle_bin_time_moved, category_tree.orderBy, (SELECT COUNT(*) FROM sdoc AS doc WHERE doc.categoryUUID=category_tree.UUID AND doc.isDeleted IS NOT 1) AS documentCount FROM category_tree ORDER BY category_tree.orderBy ASC")
    public abstract LiveData<List<NotesDocumentCountEntry>> getAllDocumentCountEntry_LiveData();

    public LiveData<List<NotesDocumentCountEntry>> getAllDocumentCountEntry_LiveData(@NonNull NotesOldDocumentDao notesOldDocumentDao, @NonNull NotesConvertedDocumentDao notesConvertedDocumentDao, String str, boolean z) {
        return Transformations.map(getAllDocumentCountEntry_LiveData(str), new C11244a(this, notesOldDocumentDao, notesConvertedDocumentDao, z, 0));
    }

    @Query("SELECT category_tree.UUID, category_tree.parentUUID, category_tree.displayName, category_tree.displayNameColor, category_tree.isDeleted,  category_tree.createdAt, category_tree.lastModifiedAt, category_tree.recycle_bin_time_moved, category_tree.orderBy, (SELECT COUNT(*) FROM sdoc AS doc LEFT OUTER JOIN mapped_document AS map ON doc.UUID = map.UUID WHERE doc.categoryUUID=category_tree.UUID AND doc.isDeleted IS NOT 1 AND map.UUID IS NULL) AS documentCount FROM category_tree WHERE category_tree.parentUUID=:parentUuid ORDER BY category_tree.orderBy ASC")
    public abstract LiveData<List<NotesDocumentCountEntry>> getAllDocumentCountEntry_LiveData(String str);

    @Nullable
    public LiveData<List<MainListDocumentData>> getAllForImportContentShare_LiveData(@DeleteType int i, @NonNull SortParam sortParam) {
        return rawQuery_LiveData(new SimpleSQLiteQuery(AbstractC0541b.m757C(new NotesSQLBuilder().select(DBSchema.DocumentProjection.MAIN_LIST_DOCUMENT_PROJECTION).from(DBSchema.MAIN_LIST_DOCUMENT_MAPPED_JOINED_TABLE).where("sdoc.mdeSpaceId=''").and("sdoc.isDeleted=" + i).and("pageMode=2").build(), SQLKeyword.ORDER_BY, new DocumentSortQuery().createQuery(sortParam))));
    }

    @Query("SELECT COUNT(*) FROM sdoc LEFT OUTER JOIN mapped_document AS map ON sdoc.UUID = map.UUID WHERE sdoc.isDeleted=:deleteType AND sdoc.mdeSpaceId='' AND map.UUID IS NULL ")
    public abstract int getAllNoteCount(@DeleteType int i);

    public int getAllNoteCount(@DeleteType int i, boolean z) {
        return z ? getAllNoteCountIncludingOldNote(i) : getAllNoteCount(i);
    }

    @Query("SELECT COUNT(*) FROM sdoc WHERE isDeleted=:deleteType AND mdeSpaceId=''")
    public abstract int getAllNoteCountIncludingOldNote(@DeleteType int i);

    public List<MainListDocumentData> getAllRecycleBinDataList(@DeleteType int i, SortParam sortParam) {
        return rawQuery(new SimpleSQLiteQuery(new NotesSQLBuilder().select(DBSchema.DocumentProjection.MAIN_LIST_DOCUMENT_PROJECTION).from(DBSchema.MAIN_LIST_DOCUMENT_JOINED_TABLE).where("sdoc.mdeSpaceId=''").and("sdoc.isDeleted=" + i).orderBy(new DocumentSortQuery().createQuery(sortParam)).build()));
    }

    @Nullable
    public LiveData<List<MainListDocumentData>> getAllRecycleBinData_LiveData(@DeleteType int i, @NonNull SortParam sortParam) {
        return rawQuery_LiveData(new SimpleSQLiteQuery(new NotesSQLBuilder().select(DBSchema.DocumentProjection.MAIN_LIST_DOCUMENT_PROJECTION).from(DBSchema.MAIN_LIST_DOCUMENT_JOINED_TABLE).where("sdoc.mdeSpaceId=''").and("sdoc.isDeleted=" + i).orderBy(new DocumentSortQuery().createQuery(sortParam)).build()));
    }

    public List<MainListDocumentData> getAllWithCover(SortParam sortParam, String str, int i) {
        return rawQuery(new SimpleSQLiteQuery(AbstractC0541b.m757C(new NotesSQLBuilder().select(DBSchema.DocumentProjection.MAIN_LIST_DOCUMENT_PROJECTION).from(DBSchema.MAIN_LIST_DOCUMENT_JOINED_TABLE).where("document_cover.categoryUUID='" + str + "'").and("document_cover.isEnabled=1").and("sdoc.isDeleted=" + i).and(QueryConstants.UNLOCKED_CONDITION).build(), SQLKeyword.ORDER_BY, new DocumentSortQuery().createQuery(sortParam))));
    }

    @Transaction
    public List<MainListDocumentData> getAllWithTag(String str) {
        return rawQuery(getAllWithTagQuery(str));
    }

    @Nullable
    public LiveData<List<MainListDocumentData>> getAllWithTag_LiveData(String str) {
        return rawQuery_LiveData(getAllWithTagQuery(str));
    }

    @Nullable
    public LiveData<List<MainListDocumentData>> getAll_LiveData(@DeleteType int i, @NonNull SortParam sortParam) {
        return rawQuery_LiveData(new SimpleSQLiteQuery(getAll_QueryStr(i, sortParam)));
    }

    public List<MainListDocumentData> getAll_OldNotes(@DeleteType int i, SortParam sortParam) {
        return rawQuery(new SimpleSQLiteQuery(new NotesSQLBuilder().select(DBSchema.DocumentProjection.MAIN_LIST_DOCUMENT_PROJECTION).from(DBSchema.MAIN_LIST_DOCUMENT_MAPPED_JOINED_TABLE).where("sdoc.mdeSpaceId=''").and("sdoc.isDeleted=" + i).and("sdoc.filePath LIKE '%.sdoc'").and("map.mappedUUID IS NULL").orderBy(new DocumentSortQuery().createQuery(sortParam)).build()));
    }

    @Nullable
    public LiveData<List<MainListDocumentData>> getAll_OldNotes_LiveData(@NonNull SortParam sortParam) {
        return rawQuery_LiveData(new SimpleSQLiteQuery(new NotesSQLBuilder().select(DBSchema.DocumentProjection.MAIN_LIST_DOCUMENT_PROJECTION).from(DBSchema.MAIN_LIST_DOCUMENT_MAPPED_JOINED_TABLE).where("sdoc.mdeSpaceId=''").and("sdoc.isDeleted IS NOT 1").and("sdoc.filePath LIKE '%.sdoc'").and("map.mappedUUID IS NULL").orderBy(new DocumentSortQuery().createQuery(sortParam)).build()));
    }

    public List<MainListDocumentData> getCoEditEntryBySpaceId(List<String> list, SortParam sortParam) {
        return rawQuery(new SimpleSQLiteQuery(new NotesSQLBuilder().select(DBSchema.DocumentProjection.MAIN_LIST_DOCUMENT_PROJECTION).from(DBSchema.MAIN_LIST_DOCUMENT_JOINED_TABLE).where(QueryConstants.USED_DOCUMENT_CONDITION).and("mdeSpaceId").mo12420in(QueryUtils.getCommaSeparatedString(list)).and("sdoc.categoryUUID='coedit:///'").orderBy(new DocumentSortQuery().createQuery(sortParam)).build()));
    }

    @Query("SELECT category_tree.UUID, category_tree.parentUUID, category_tree.displayName, category_tree.displayNameColor, category_tree.isDeleted,  category_tree.createdAt, category_tree.lastModifiedAt, category_tree.recycle_bin_time_moved, category_tree.orderBy, (SELECT COUNT(*) FROM sdoc WHERE sdoc.categoryUUID=category_tree.UUID AND sdoc.isDeleted IS NOT 1) AS documentCount FROM category_tree WHERE category_tree.UUID=:categoryUuid")
    public abstract NotesDocumentCountEntry getDocumentCountEntry_NotConsideringMappingTable(String str);

    @Query("SELECT tag_list.docUUID FROM tag_list WHERE tag_list.normalizeName IN (:tagNormalizedNames) GROUP BY tag_list.docUUID HAVING COUNT(*)=:tagCount")
    public abstract List<String> getDocumentsWithTag(Collection<String> collection, int i);

    @Transaction
    public List<MainListDocumentData> getEntities(Collection<String> collection, String str) {
        return str.isEmpty() ? new SplitTaskExecutor(new C8886c(this, 20)).execute(collection) : new SplitTaskExecutor(new C0287e(this, str, 19)).execute(collection);
    }

    @Query("SELECT `sdoc`.`_id` AS `_id`, `sdoc`.`UUID` AS `UUID`, `sdoc`.`isDeleted` AS `isDeleted`, `sdoc`.`isDirty` AS `isDirty`, substr(`sdoc`.`title`, 1, 300) AS `title`, `sdoc`.`recommendedTitle` AS `recommendedTitle`, substr(`sdoc`.`content`, 1, 300) AS `content`, `sdoc`.`displayContent` AS `displayContent`, `sdoc`.`createdAt` AS `createdAt`, `sdoc`.`lastModifiedAt` AS `lastModifiedAt`, `sdoc`.`vrUUID` AS `vrUUID`, `sdoc`.`contentUUID` AS `contentUUID`, `sdoc`.`firstContentType` AS `firstContentType`, `sdoc`.`secondContentType` AS `secondContentType`, `sdoc`.`strokeUUID` AS `strokeUUID`, `sdoc`.`categoryUUID` AS `categoryUUID`, `sdoc`.`filePath` AS `filePath`, `sdoc`.`isFavorite` AS `isFavorite`, `sdoc`.`isLock` AS `isLock`, `sdoc`.`isSaving` AS `isSaving`, `sdoc`.`recycle_bin_time_moved` AS `recycle_bin_time_moved`, `sdoc`.`firstOpendAt` AS `firstOpendAt`, `sdoc`.`mdeSpaceId` AS `mdeSpaceId`, `sdoc`.`mdeItemId` AS `mdeItemId`, `sdoc`.`mdeGroupId` AS `mdeGroupId`, `sdoc`.`mdeOwnerId` AS `mdeOwnerId`, `sdoc`.`absolutePath` AS `absolutePath`, `sdoc`.`backgroundColor` AS `backgroundColor`, `sdoc`.`backgroundColorInverted` AS `backgroundColorInverted`, `sdoc`.`corrupted` AS `corrupted`, `sdoc`.`pageMode` AS `pageMode`, `sdoc`.`size` AS `size`,`document_cover`.`templateUUID` AS `coverTemplateUuid`, `document_cover`.`summary` AS `coverSummary`, `document_cover`.`summary_alignment` AS `coverSummaryAlignment`, `document_cover`.`categoryUUID` AS `coverStickerUuid`, `document_cover`.`backgroundColor` AS `coverBackgroundColor`, `document_cover`.`isEnabled` AS `isCoverEnabled`, `suggested_cover`.`state` AS `coverSuggestedState`, `sync_info`.`syncState` AS `syncState`, `document_extra`.`hasSticky` AS `hasSticky`, `document_extra`.`unknownMinVersion` AS `unknownMinVersion`, `document_extra`.`formatVersion` AS `formatVersion`,`document_thumbnail`.`backgroundType` AS `backgroundType`, `document_thumbnail`.`layout` AS `layout`,`document_thumbnail`.`imagePath` AS `imagePath`, `document_thumbnail`.`playTime` AS `playTime` FROM sdoc LEFT JOIN document_extra ON sdoc.UUID = document_extra.UUID LEFT JOIN document_thumbnail ON sdoc.UUID = document_thumbnail.UUID LEFT JOIN sync_info ON sdoc.UUID = sync_info.clientId LEFT JOIN document_cover ON sdoc.UUID = document_cover.documentUUID LEFT JOIN suggested_cover ON sdoc.UUID = suggested_cover.documentUUID WHERE sdoc.UUID IN (:uuids) AND sdoc.isDeleted = 0 AND sdoc.isLock = 0")
    public abstract List<MainListDocumentData> getEntitiesInChunk(Collection<String> collection);

    @Query("SELECT `sdoc`.`_id` AS `_id`, `sdoc`.`UUID` AS `UUID`, `sdoc`.`isDeleted` AS `isDeleted`, `sdoc`.`isDirty` AS `isDirty`, substr(`sdoc`.`title`, 1, 300) AS `title`, `sdoc`.`recommendedTitle` AS `recommendedTitle`, substr(`sdoc`.`content`, 1, 300) AS `content`, `sdoc`.`displayContent` AS `displayContent`, `sdoc`.`createdAt` AS `createdAt`, `sdoc`.`lastModifiedAt` AS `lastModifiedAt`, `sdoc`.`vrUUID` AS `vrUUID`, `sdoc`.`contentUUID` AS `contentUUID`, `sdoc`.`firstContentType` AS `firstContentType`, `sdoc`.`secondContentType` AS `secondContentType`, `sdoc`.`strokeUUID` AS `strokeUUID`, `sdoc`.`categoryUUID` AS `categoryUUID`, `sdoc`.`filePath` AS `filePath`, `sdoc`.`isFavorite` AS `isFavorite`, `sdoc`.`isLock` AS `isLock`, `sdoc`.`isSaving` AS `isSaving`, `sdoc`.`recycle_bin_time_moved` AS `recycle_bin_time_moved`, `sdoc`.`firstOpendAt` AS `firstOpendAt`, `sdoc`.`mdeSpaceId` AS `mdeSpaceId`, `sdoc`.`mdeItemId` AS `mdeItemId`, `sdoc`.`mdeGroupId` AS `mdeGroupId`, `sdoc`.`mdeOwnerId` AS `mdeOwnerId`, `sdoc`.`absolutePath` AS `absolutePath`, `sdoc`.`backgroundColor` AS `backgroundColor`, `sdoc`.`backgroundColorInverted` AS `backgroundColorInverted`, `sdoc`.`corrupted` AS `corrupted`, `sdoc`.`pageMode` AS `pageMode`, `sdoc`.`size` AS `size`,`document_cover`.`templateUUID` AS `coverTemplateUuid`, `document_cover`.`summary` AS `coverSummary`, `document_cover`.`summary_alignment` AS `coverSummaryAlignment`, `document_cover`.`categoryUUID` AS `coverStickerUuid`, `document_cover`.`backgroundColor` AS `coverBackgroundColor`, `document_cover`.`isEnabled` AS `isCoverEnabled`, `suggested_cover`.`state` AS `coverSuggestedState`, `sync_info`.`syncState` AS `syncState`, `document_extra`.`hasSticky` AS `hasSticky`, `document_extra`.`unknownMinVersion` AS `unknownMinVersion`, `document_extra`.`formatVersion` AS `formatVersion`,`document_thumbnail`.`backgroundType` AS `backgroundType`, `document_thumbnail`.`layout` AS `layout`,`document_thumbnail`.`imagePath` AS `imagePath`, `document_thumbnail`.`playTime` AS `playTime` FROM sdoc LEFT JOIN document_extra ON sdoc.UUID = document_extra.UUID LEFT JOIN document_thumbnail ON sdoc.UUID = document_thumbnail.UUID LEFT JOIN sync_info ON sdoc.UUID = sync_info.clientId LEFT JOIN document_cover ON sdoc.UUID = document_cover.documentUUID LEFT JOIN suggested_cover ON sdoc.UUID = suggested_cover.documentUUID WHERE sdoc.categoryUUID = :folderUuid AND sdoc.UUID IN (:uuids) AND sdoc.isDeleted = 0 AND sdoc.isLock = 0")
    /* JADX INFO: renamed from: getEntitiesInChunk, reason: merged with bridge method [inline-methods] */
    public abstract List<MainListDocumentData> lambda$getEntities$0(Collection<String> collection, String str);

    @Query("SELECT `sdoc`.`_id` AS `_id`, `sdoc`.`UUID` AS `UUID`, `sdoc`.`isDeleted` AS `isDeleted`, `sdoc`.`isDirty` AS `isDirty`, substr(`sdoc`.`title`, 1, 300) AS `title`, `sdoc`.`recommendedTitle` AS `recommendedTitle`, substr(`sdoc`.`content`, 1, 300) AS `content`, `sdoc`.`displayContent` AS `displayContent`, `sdoc`.`createdAt` AS `createdAt`, `sdoc`.`lastModifiedAt` AS `lastModifiedAt`, `sdoc`.`vrUUID` AS `vrUUID`, `sdoc`.`contentUUID` AS `contentUUID`, `sdoc`.`firstContentType` AS `firstContentType`, `sdoc`.`secondContentType` AS `secondContentType`, `sdoc`.`strokeUUID` AS `strokeUUID`, `sdoc`.`categoryUUID` AS `categoryUUID`, `sdoc`.`filePath` AS `filePath`, `sdoc`.`isFavorite` AS `isFavorite`, `sdoc`.`isLock` AS `isLock`, `sdoc`.`isSaving` AS `isSaving`, `sdoc`.`recycle_bin_time_moved` AS `recycle_bin_time_moved`, `sdoc`.`firstOpendAt` AS `firstOpendAt`, `sdoc`.`mdeSpaceId` AS `mdeSpaceId`, `sdoc`.`mdeItemId` AS `mdeItemId`, `sdoc`.`mdeGroupId` AS `mdeGroupId`, `sdoc`.`mdeOwnerId` AS `mdeOwnerId`, `sdoc`.`absolutePath` AS `absolutePath`, `sdoc`.`backgroundColor` AS `backgroundColor`, `sdoc`.`backgroundColorInverted` AS `backgroundColorInverted`, `sdoc`.`corrupted` AS `corrupted`, `sdoc`.`pageMode` AS `pageMode`, `sdoc`.`size` AS `size`,`document_cover`.`templateUUID` AS `coverTemplateUuid`, `document_cover`.`summary` AS `coverSummary`, `document_cover`.`summary_alignment` AS `coverSummaryAlignment`, `document_cover`.`categoryUUID` AS `coverStickerUuid`, `document_cover`.`backgroundColor` AS `coverBackgroundColor`, `document_cover`.`isEnabled` AS `isCoverEnabled`, `suggested_cover`.`state` AS `coverSuggestedState`, `sync_info`.`syncState` AS `syncState`, `document_extra`.`hasSticky` AS `hasSticky`, `document_extra`.`unknownMinVersion` AS `unknownMinVersion`, `document_extra`.`formatVersion` AS `formatVersion`,`document_thumbnail`.`backgroundType` AS `backgroundType`, `document_thumbnail`.`layout` AS `layout`,`document_thumbnail`.`imagePath` AS `imagePath`, `document_thumbnail`.`playTime` AS `playTime` FROM sdoc LEFT JOIN document_extra ON sdoc.UUID = document_extra.UUID LEFT JOIN document_thumbnail ON sdoc.UUID = document_thumbnail.UUID LEFT JOIN sync_info ON sdoc.UUID = sync_info.clientId LEFT JOIN document_cover ON sdoc.UUID = document_cover.documentUUID LEFT JOIN suggested_cover ON sdoc.UUID = suggested_cover.documentUUID WHERE sdoc.UUID=:uuid")
    public abstract MainListDocumentData getEntity(String str);

    @Query("SELECT UUID FROM sdoc WHERE recycle_bin_time_moved<:expiredTime AND recycle_bin_time_moved IS NOT 0 AND isDeleted=2 AND categoryUUID='trash:///'")
    public abstract List<String> getExpiredRecycleBinDataNotInFolder(long j);

    @Query("SELECT COUNT(*) FROM sdoc LEFT OUTER JOIN mapped_document AS map ON sdoc.UUID = map.UUID WHERE sdoc.isFavorite=1 AND sdoc.mdeSpaceId='' AND sdoc.isDeleted=:deleteType AND map.UUID IS NULL")
    public abstract int getFavoriteItemCount(@DeleteType int i);

    @Query("SELECT COUNT(*) FROM sdoc WHERE title != '' AND sdoc.isDeleted = 0")
    public abstract int getNoteCountWithTitle();

    @Query("SELECT COUNT(*) FROM sdoc WHERE vrUUID != '' AND sdoc.isDeleted = 0")
    public abstract int getNoteCountWithVoiceData();

    @Query("SELECT hashtagContent.sdocUUID FROM hashtagContent JOIN hashtag ON hashtagContent.hashtagUUID = hashtag.UUID WHERE LOWER(hashtag.name) IN (:tagNormalizedNames) GROUP BY hashtagContent.sdocUUID HAVING COUNT(*)=:tagCount")
    public abstract List<String> getOldDocumentsWithTag(Collection<String> collection, int i);

    @Query("SELECT filePath FROM sdoc WHERE UUID=:uuid")
    public abstract String getPath(String str);

    @Query("SELECT COUNT(*) FROM sdoc LEFT OUTER JOIN mapped_document AS map ON sdoc.UUID = map.UUID WHERE sdoc.importedAt >= :timeRecentlyImported AND sdoc.isDeleted = 0 AND sdoc.mdeSpaceId='' AND map.UUID IS NULL ")
    public abstract int getRecentlyImportedNoteCount(long j);

    @Query("SELECT `sdoc`.`_id` AS `_id`, `sdoc`.`UUID` AS `UUID`, `sdoc`.`isDeleted` AS `isDeleted`, `sdoc`.`isDirty` AS `isDirty`, substr(`sdoc`.`title`, 1, 300) AS `title`, `sdoc`.`recommendedTitle` AS `recommendedTitle`, substr(`sdoc`.`content`, 1, 300) AS `content`, `sdoc`.`displayContent` AS `displayContent`, `sdoc`.`createdAt` AS `createdAt`, `sdoc`.`lastModifiedAt` AS `lastModifiedAt`, `sdoc`.`vrUUID` AS `vrUUID`, `sdoc`.`contentUUID` AS `contentUUID`, `sdoc`.`firstContentType` AS `firstContentType`, `sdoc`.`secondContentType` AS `secondContentType`, `sdoc`.`strokeUUID` AS `strokeUUID`, `sdoc`.`categoryUUID` AS `categoryUUID`, `sdoc`.`filePath` AS `filePath`, `sdoc`.`isFavorite` AS `isFavorite`, `sdoc`.`isLock` AS `isLock`, `sdoc`.`isSaving` AS `isSaving`, `sdoc`.`recycle_bin_time_moved` AS `recycle_bin_time_moved`, `sdoc`.`firstOpendAt` AS `firstOpendAt`, `sdoc`.`mdeSpaceId` AS `mdeSpaceId`, `sdoc`.`mdeItemId` AS `mdeItemId`, `sdoc`.`mdeGroupId` AS `mdeGroupId`, `sdoc`.`mdeOwnerId` AS `mdeOwnerId`, `sdoc`.`absolutePath` AS `absolutePath`, `sdoc`.`backgroundColor` AS `backgroundColor`, `sdoc`.`backgroundColorInverted` AS `backgroundColorInverted`, `sdoc`.`corrupted` AS `corrupted`, `sdoc`.`pageMode` AS `pageMode`, `sdoc`.`size` AS `size`,`document_cover`.`templateUUID` AS `coverTemplateUuid`, `document_cover`.`summary` AS `coverSummary`, `document_cover`.`summary_alignment` AS `coverSummaryAlignment`, `document_cover`.`categoryUUID` AS `coverStickerUuid`, `document_cover`.`backgroundColor` AS `coverBackgroundColor`, `document_cover`.`isEnabled` AS `isCoverEnabled`, `suggested_cover`.`state` AS `coverSuggestedState`, `sync_info`.`syncState` AS `syncState`, `document_extra`.`hasSticky` AS `hasSticky`, `document_extra`.`unknownMinVersion` AS `unknownMinVersion`, `document_extra`.`formatVersion` AS `formatVersion`,`document_thumbnail`.`backgroundType` AS `backgroundType`, `document_thumbnail`.`layout` AS `layout`,`document_thumbnail`.`imagePath` AS `imagePath`, `document_thumbnail`.`playTime` AS `playTime` FROM sdoc LEFT JOIN document_extra ON sdoc.UUID = document_extra.UUID LEFT JOIN document_thumbnail ON sdoc.UUID = document_thumbnail.UUID LEFT JOIN sync_info ON sdoc.UUID = sync_info.clientId LEFT JOIN document_cover ON sdoc.UUID = document_cover.documentUUID LEFT JOIN suggested_cover ON sdoc.UUID = suggested_cover.documentUUID WHERE sdoc.UUID=:uuid")
    public abstract LiveData<MainListDocumentData> get_LiveData(String str);

    @RawQuery(observedEntities = {NotesDocumentEntity.class, NotesDocumentCoverEntity.class, SuggestedCoverEntity.class, SyncInfoEntity.class, DocumentExtraEntity.class, DocumentThumbnailEntity.class})
    public abstract List<MainListDocumentData> internalRawQuery(SupportSQLiteQuery supportSQLiteQuery);

    @RawQuery(observedEntities = {NotesDocumentEntity.class, NotesDocumentCoverEntity.class, SuggestedCoverEntity.class, SyncInfoEntity.class, DocumentExtraEntity.class, DocumentThumbnailEntity.class})
    public abstract LiveData<List<MainListDocumentData>> internalRawQuery_LiveData(SupportSQLiteQuery supportSQLiteQuery);

    @NonNull
    public List<MainListDocumentData> rawQuery(@NonNull SupportSQLiteQuery supportSQLiteQuery) {
        try {
            return internalRawQuery(supportSQLiteQuery);
        } catch (Exception e) {
            DataLogger.m12305f(TAG, "rawQuery, e : " + e.getMessage() + ", backtrace : " + CommonUtils.getCallee(Thread.currentThread().getStackTrace()));
            return new ArrayList();
        }
    }

    @Nullable
    public LiveData<List<MainListDocumentData>> rawQuery_LiveData(@NonNull SupportSQLiteQuery supportSQLiteQuery) {
        try {
            return internalRawQuery_LiveData(supportSQLiteQuery);
        } catch (Exception e) {
            DataLogger.m12305f(TAG, "rawQuery_LiveData, e : " + e.getMessage() + ", backtrace : " + CommonUtils.getCallee(Thread.currentThread().getStackTrace()));
            return null;
        }
    }

    public List<MainListDocumentData> search(String str, String[] strArr) {
        return rawQuery(new SimpleSQLiteQuery(str, strArr));
    }

    public List<MainListDocumentData> searchLatestNotes(int i) {
        return rawQuery(new SimpleSQLiteQuery(new NotesSQLBuilder().select(DBSchema.DocumentProjection.MAIN_LIST_DOCUMENT_PROJECTION).from(DBSchema.MAIN_LIST_DOCUMENT_JOINED_TABLE).where(QueryConstants.USED_DOCUMENT_CONDITION).and(QueryConstants.UNLOCKED_CONDITION).and("mdeSpaceId = ''").orderBy("lastModifiedAt", SQLKeyword.SortingOrder.DESC).limit(i).build()));
    }
}
