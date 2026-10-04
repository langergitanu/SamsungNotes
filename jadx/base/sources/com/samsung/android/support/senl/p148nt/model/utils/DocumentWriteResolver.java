package com.samsung.android.support.senl.p148nt.model.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.composer.document.sdoc.SpenSDoc;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.common.constants.SaveStrategy;
import com.samsung.android.support.senl.p145cm.base.framework.feature.FloatingFeature;
import com.samsung.android.support.senl.p148nt.base.common.access.widgetaccess.WidgetAccessContract;
import com.samsung.android.support.senl.p148nt.base.common.access.widgetaccess.WidgetAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.constants.DataBaseConstants;
import com.samsung.android.support.senl.p148nt.base.common.data.DataUpdateManager;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.LockUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.base.widget.constant.BaseWidgetConstant;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.RunnableC10960a;
import com.samsung.android.support.senl.p148nt.data.common.constants.DeleteType;
import com.samsung.android.support.senl.p148nt.data.common.constants.DocumentData;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeClosureEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.category.NotesCategoryTreeClosureRepository;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentRepository;
import com.samsung.android.support.senl.p148nt.data.repository.tag.NotesTagRepository;
import com.samsung.android.support.senl.p148nt.data.resolver.operation.constants.DocumentType;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.document.save.NotesDocumentOperationProcessor;
import com.samsung.android.support.senl.p148nt.model.document.save.autotitle.DocumentAutoTitleCreator;
import com.samsung.android.support.senl.p148nt.model.documents.data.DocumentSubscriptionId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DocumentWriteResolver {
    private static final String TAG = ModelLogger.createTag("DocumentWriteResolver");

    public static boolean delete(Context context, String str, @DeleteType int i, @NonNull String str2) {
        return delete(context, new ArrayList(Collections.singleton(str)), i, str2);
    }

    public static void deleteAllNoteData(Context context, @NonNull String str, @DataBaseConstants.DeletedBy int i) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        deleteNoteFilesAndRelatedNoteDb(context, arrayList, i);
        deleteEntityFromDocumentTable(context, str);
        WidgetAccessContract widgetAccessContract = WidgetAccessHandler.getWidgetAccessContract();
        if (widgetAccessContract == null || UUIDUtils.isCoeditUuid(str)) {
            return;
        }
        widgetAccessContract.sendDocumentDeletedBroadcast(context, new ArrayList(arrayList), BaseWidgetConstant.ACTION_WIDGET_LIST_SETTING_DELETE);
    }

    private static void deleteDocumentContent(@NonNull NotesDataRepositoryFactory notesDataRepositoryFactory, List<String> list) {
        notesDataRepositoryFactory.createDocumentContentRepository().deleteBySDocUuid(list);
    }

    private static void deleteDocumentCover(@NonNull NotesDataRepositoryFactory notesDataRepositoryFactory, List<String> list) {
        notesDataRepositoryFactory.createDocumentCoverRepository().deleteByUuids(list);
    }

    private static void deleteDocumentExtra(@NonNull NotesDataRepositoryFactory notesDataRepositoryFactory, List<String> list) {
        notesDataRepositoryFactory.createDocumentExtraRepository().deleteByUuids(list);
    }

    private static void deleteDocumentPage(@NonNull NotesDataRepositoryFactory notesDataRepositoryFactory, List<String> list) {
        notesDataRepositoryFactory.createNotesDocumentPageRepository().deleteByDocumentUuid(list);
    }

    private static void deleteDocumentTempData(@NonNull NotesDataRepositoryFactory notesDataRepositoryFactory, List<String> list) {
        notesDataRepositoryFactory.createDocumentTempDataRepository().deleteByUuids(list);
    }

    private static void deleteDocumentThumbnail(@NonNull NotesDataRepositoryFactory notesDataRepositoryFactory, List<String> list) {
        notesDataRepositoryFactory.createDocumentThumbnailRepository().delete(list);
    }

    public static void deleteEntityFromDocumentTable(Context context, @NonNull String str) {
        NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository().deleteByUuidDb(str);
    }

    public static boolean deleteExpiredNotes(Context context, @NonNull List<String> list, @DeleteType int i, @NonNull String str) {
        return delete(context, list, new DeleteParam(i, str, true, true));
    }

    private static void deleteExternalSharedDocuments(@NonNull NotesDataRepositoryFactory notesDataRepositoryFactory, List<String> list) {
        notesDataRepositoryFactory.createExternalSharedDocumentsRepository().delete(list);
    }

    private static void deleteHashTagContent(Context context, List<String> list) {
        if (NotesDatabaseManager.getInstance().getHashtagContentDao().deleteByUuids(list) > 0) {
            new NotesTagRepository(context).notifyTagBoard();
        }
    }

    private static void deleteMappedDocument(@NonNull NotesDataRepositoryFactory notesDataRepositoryFactory, List<DocumentData> list) {
        notesDataRepositoryFactory.createMappedDocumentRepository().delete(list);
    }

    private static void deleteNoteFilesAndRelatedNoteDb(Context context, List<String> list, @DataBaseConstants.DeletedBy int i) {
        List<DocumentData> documentDataList = NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository().getDocumentDataList(list);
        deleteNotesFiles(context, documentDataList, i);
        deleteRelatedNoteDbEntries(context, list, documentDataList);
    }

    private static void deleteNotesFiles(Context context, List<DocumentData> list, @DataBaseConstants.DeletedBy int i) {
        NotesDocumentDeleteUtils.deleteDocumentFile(context, list, i);
    }

    private static void deleteOrganizedDocument(@NonNull NotesDataRepositoryFactory notesDataRepositoryFactory, List<String> list) {
        notesDataRepositoryFactory.createOrganizedDocumentRepository().deleteByUuids(list);
    }

    private static void deletePageSearchInfo(@NonNull NotesDataRepositoryFactory notesDataRepositoryFactory, List<String> list) {
        notesDataRepositoryFactory.createPageSearchInfoRepository().deleteByUuid(list);
    }

    private static void deleteRelatedNoteDbEntries(Context context, List<String> list, List<DocumentData> list2) {
        NotesDataRepositoryFactory notesDataRepositoryFactoryNewInstance = NotesDataRepositoryFactory.newInstance(context);
        deleteMappedDocument(notesDataRepositoryFactoryNewInstance, list2);
        deleteDocumentPage(notesDataRepositoryFactoryNewInstance, list);
        deleteDocumentContent(notesDataRepositoryFactoryNewInstance, list);
        NotesDocumentDeleteUtils.execute(new RunnableC10960a(notesDataRepositoryFactoryNewInstance, list, 5));
        deleteTagList(notesDataRepositoryFactoryNewInstance, list);
        deleteHashTagContent(context, list);
        deleteDocumentCover(notesDataRepositoryFactoryNewInstance, list);
        deleteSuggestedCover(notesDataRepositoryFactoryNewInstance, list);
        deleteOrganizedDocument(notesDataRepositoryFactoryNewInstance, list);
        deleteSttContent(notesDataRepositoryFactoryNewInstance, list);
        deleteDocumentTempData(notesDataRepositoryFactoryNewInstance, list);
        deleteDocumentExtra(notesDataRepositoryFactoryNewInstance, list);
        deleteDocumentThumbnail(notesDataRepositoryFactoryNewInstance, list);
        deleteExternalSharedDocuments(notesDataRepositoryFactoryNewInstance, list);
    }

    private static void deleteRetryData(@NonNull NotesDataRepositoryFactory notesDataRepositoryFactory, List<String> list) {
        notesDataRepositoryFactory.createDocumentRetryRepository().deleteByUuid(list);
    }

    private static void deleteStickyNoteData(@NonNull NotesDataRepositoryFactory notesDataRepositoryFactory, List<String> list) {
        notesDataRepositoryFactory.createStickyNoteRepository().deleteByDocUuids(list);
    }

    private static void deleteStrokeData(@NonNull NotesDataRepositoryFactory notesDataRepositoryFactory, List<String> list) {
        notesDataRepositoryFactory.createDocumentStrokeRepository().deleteByUuid(list);
    }

    private static void deleteSttContent(@NonNull NotesDataRepositoryFactory notesDataRepositoryFactory, List<String> list) {
        notesDataRepositoryFactory.createSttContentRepository().deleteByUuids(list);
    }

    private static void deleteSuggestedCover(@NonNull NotesDataRepositoryFactory notesDataRepositoryFactory, List<String> list) {
        notesDataRepositoryFactory.createSuggestedCoverRepository().deleteByUuids(list);
    }

    private static void deleteTagList(@NonNull NotesDataRepositoryFactory notesDataRepositoryFactory, List<String> list) {
        notesDataRepositoryFactory.createDocumentTagRepository().deleteByUuid(list);
    }

    private static void deleteTextSearchData(@NonNull NotesDataRepositoryFactory notesDataRepositoryFactory, List<String> list) {
        notesDataRepositoryFactory.createSearchRepository().deleteByUuid(list);
    }

    private static boolean isValidFolder(Context context, DocumentType documentType, NotesDocumentEntity notesDocumentEntity) {
        String uuid = (documentType == DocumentType.SDOCX ? PredefinedCategory.OLD_NOTES : PredefinedCategory.UNCATEGORIZED).getUuid();
        NotesCategoryTreeClosureRepository notesCategoryTreeClosureRepositoryCreateCategoryTreeClosureRepository = NotesDataRepositoryFactory.newInstance(context).createCategoryTreeClosureRepository();
        boolean zHasRelationShip = notesCategoryTreeClosureRepositoryCreateCategoryTreeClosureRepository.hasRelationShip(uuid, notesDocumentEntity.getCategoryUuid());
        if (zHasRelationShip) {
            DataLogger.m12305f(TAG, "invalid folder, uuid: " + notesDocumentEntity.getUuid() + ", folderUuid: " + notesDocumentEntity.getCategoryUuid());
            printClosureTable(notesCategoryTreeClosureRepositoryCreateCategoryTreeClosureRepository, notesDocumentEntity.getCategoryUuid());
        }
        return !zHasRelationShip;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$deleteRelatedNoteDbEntries$0(NotesDataRepositoryFactory notesDataRepositoryFactory, List list) {
        deletePageSearchInfo(notesDataRepositoryFactory, list);
        deleteStrokeData(notesDataRepositoryFactory, list);
        deleteRetryData(notesDataRepositoryFactory, list);
        deleteTextSearchData(notesDataRepositoryFactory, list);
        deleteStickyNoteData(notesDataRepositoryFactory, list);
    }

    private static void printClosureTable(NotesCategoryTreeClosureRepository notesCategoryTreeClosureRepository, String str) {
        List<NotesCategoryTreeClosureEntity> entities = notesCategoryTreeClosureRepository.getEntities(str);
        DataLogger.m12307i(TAG, "printClosureTable, entities: " + entities.size());
        for (NotesCategoryTreeClosureEntity notesCategoryTreeClosureEntity : entities) {
            DataLogger.m12307i(TAG, "ans= " + notesCategoryTreeClosureEntity.getAncestor() + ", des= " + notesCategoryTreeClosureEntity.getDescendant() + ", depth= " + notesCategoryTreeClosureEntity.getDepth());
        }
    }

    public static void removeDeletedPages(Context context, String str) {
        NotesDataRepositoryFactory.newInstance(context).createNotesDocumentPageRepository().removeDeletedPages(str);
    }

    public static void removeFromDB(Context context, @NonNull String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        deleteRelatedNoteDbEntries(context, arrayList, NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository().getDocumentDataList(arrayList));
        deleteEntityFromDocumentTable(context, str);
    }

    public static boolean save(Context context, boolean z, String str, @NonNull NotesDocumentEntity notesDocumentEntity, @NonNull SpenSDoc spenSDoc, @Nullable String str2, boolean z2, @NonNull String str3) {
        return save(context, z, str, DocumentType.SDOC, notesDocumentEntity, spenSDoc, str2, z2, 2056, str3);
    }

    public static boolean updateRecommendedTitle(Context context, @NonNull String str, @NonNull SpenWNote spenWNote) {
        try {
            String text = spenWNote.getTitle().getText();
            if (!TextUtils.isEmpty(text)) {
                return false;
            }
            String hintText = spenWNote.getTitle().getHintText();
            String str2 = TAG;
            DataLogger.m12302d(str2, "updateRecommendedTitle, title : " + DataLogger.getEncode(text) + ", hintText : " + DataLogger.getEncode(hintText));
            String strCreate = new DocumentAutoTitleCreator().create(context.getResources(), spenWNote);
            StringBuilder sb = new StringBuilder("updateRecommendedTitle, recommendedTitle : ");
            sb.append(DataLogger.getEncode(strCreate));
            DataLogger.m12302d(str2, sb.toString());
            if (Objects.equals(strCreate, spenWNote.getTitle().getText())) {
                return false;
            }
            NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository().updateRecommendedTitle(str, strCreate);
            return true;
        } catch (Exception e) {
            AbstractC11014a.m12333r(e, new StringBuilder("updateRecommendedTitle, e : "), TAG);
            return false;
        }
    }

    public static boolean delete(Context context, @NonNull List<String> list, @DeleteType int i, @NonNull String str) {
        return delete(context, list, new DeleteParam(i, str, false, true));
    }

    public static boolean save(Context context, boolean z, String str, @NonNull NotesDocumentEntity notesDocumentEntity, @NonNull SpenWNote spenWNote, @Nullable String str2, boolean z2, @NonNull String str3) {
        return save(context, z, str, DocumentType.SDOCX, notesDocumentEntity, spenWNote, str2, z2, 67592, str3);
    }

    public static boolean delete(Context context, @NonNull List<String> list, DeleteParam deleteParam) {
        if (list.isEmpty()) {
            return false;
        }
        DataLogger.m12305f(TAG, "#delete, isDeleted: " + deleteParam.getDeleteType() + ", doc count: " + list.size() + ", caller : " + deleteParam.getCaller() + ", backtrace: " + CommonUtils.getCallee(Thread.currentThread().getStackTrace()));
        NotesDocumentRepository notesDocumentRepositoryCreateDocumentDataRepository = NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository();
        if (FloatingFeature.INSTANCE.getInstance().isDisableRecycleBinModel() && deleteParam.getDeleteType() == 2) {
            deleteParam.setDeleteType(1);
        }
        if (deleteParam.getDeleteType() == 2) {
            notesDocumentRepositoryCreateDocumentDataRepository.moveToRecycleBinByUuid(list);
            DataUpdateManager.getInstance().onDocumentMovedToTrash(list);
        } else if (deleteParam.getDeleteType() == 1) {
            List<DocumentData> documentDataList = notesDocumentRepositoryCreateDocumentDataRepository.getDocumentDataList(list);
            int i = deleteParam.isDeleteExpiredNotes() ? 2 : 1;
            if (deleteParam.isDeleteFile()) {
                deleteNotesFiles(context, documentDataList, i);
            }
            deleteRelatedNoteDbEntries(context, list, documentDataList);
            if (i == 2) {
                notesDocumentRepositoryCreateDocumentDataRepository.deleteByUuidWithTimestampIncrease(list);
            } else {
                notesDocumentRepositoryCreateDocumentDataRepository.deleteByUuid(list);
            }
            DataUpdateManager.getInstance().onDocumentDeleted(list, i);
        }
        DataUpdateManager.getInstance().onDataUpdated(1);
        return true;
    }

    public static boolean save(Context context, boolean z, String str, @NonNull NotesDocumentEntity notesDocumentEntity, @NonNull SpenSDoc spenSDoc, @Nullable String str2, boolean z2, int i, @NonNull String str3) {
        return save(context, z, str, DocumentType.SDOC, notesDocumentEntity, spenSDoc, str2, z2, i, str3);
    }

    public static boolean save(Context context, boolean z, String str, @NonNull NotesDocumentEntity notesDocumentEntity, @NonNull SpenWNote spenWNote, @Nullable String str2, boolean z2, @SaveStrategy int i, @NonNull String str3) {
        return save(context, z, str, DocumentType.SDOCX, notesDocumentEntity, spenWNote, str2, z2, i, str3);
    }

    private static boolean save(Context context, boolean z, String str, DocumentType documentType, NotesDocumentEntity notesDocumentEntity, Object obj, String str2, boolean z2, @SaveStrategy int i, @NonNull String str3) {
        String hashedAccountGuid = LockUtils.getHashedAccountGuid(str2);
        String str4 = TAG;
        StringBuilder sbM3200j = AbstractC4539a.m3200j("save, isNew : ", ", savePath : ", z);
        sbM3200j.append(DataLogger.getEncode(str));
        sbM3200j.append(", accountGuid : ");
        sbM3200j.append(DataLogger.pii(hashedAccountGuid));
        sbM3200j.append(", updateModifiedTime : ");
        sbM3200j.append(z2);
        sbM3200j.append(", docType : ");
        sbM3200j.append(documentType);
        sbM3200j.append(", saveStrategy : ");
        sbM3200j.append(i);
        sbM3200j.append(", caller : ");
        sbM3200j.append(str3);
        sbM3200j.append(", backtrace : ");
        sbM3200j.append(CommonUtils.getCallee(Thread.currentThread().getStackTrace()));
        DataLogger.m12305f(str4, sbM3200j.toString());
        if (!z2) {
            notesDocumentEntity.getTimeSaveParam().setTime(Long.valueOf(notesDocumentEntity.getCreatedAt()), Long.valueOf(notesDocumentEntity.getLastModifiedAt()));
        }
        notesDocumentEntity.setFilePath(str);
        return isValidFolder(context, documentType, notesDocumentEntity) && NotesDocumentOperationProcessor.createSaveOperation(context, documentType).setNew(z).setLockAccountGuid(hashedAccountGuid).setSaveStrategy(i).setSpenDocument(obj).setUpdateDocSize(documentType == DocumentType.SDOC || !str3.contains(DocumentSubscriptionId.COMPOSER_SERVICE_ID.getUser())).apply(notesDocumentEntity);
    }
}
