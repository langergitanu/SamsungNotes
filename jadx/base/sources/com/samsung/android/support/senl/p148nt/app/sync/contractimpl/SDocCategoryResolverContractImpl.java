package com.samsung.android.support.senl.p148nt.app.sync.contractimpl;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.C8003R;
import com.samsung.android.support.senl.p148nt.base.common.TimeManager;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSyncManager;
import com.samsung.android.support.senl.p148nt.data.common.constants.CategoryConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.DocumentCategoryTree;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncCategoryTreeDao;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncDocumentDao;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.category.SoftParentFolderChecker;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import com.samsung.android.support.senl.p148nt.model.restore.folder.RestoreFolderCreator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import p001A.AbstractC0000a;
import p093X.InterfaceC0333a;
import p206n0.C13533a;
import p244u1.C14477a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class SDocCategoryResolverContractImpl implements InterfaceC0333a {
    public static final Object synchronizeCategory = new Object();

    public String addCategory(Context context, String str, String str2, boolean z) {
        return addCategory(context, str, str2, -1, z);
    }

    @Override // p093X.InterfaceC0333a
    @Nullable
    public NotesCategoryTreeEntity createRestoredFolder() {
        return new RestoreFolderCreator(BaseUtils.getApplicationContext()).createFolderByVersion();
    }

    @Override // p093X.InterfaceC0333a
    public void deleteCategory(Context context, String str, long j, int i, boolean z) {
        synchronized (synchronizeCategory) {
            Context applicationContext = context.getApplicationContext();
            NotesDatabase notesDatabaseManager = NotesDatabaseManager.getInstance();
            SyncCategoryTreeDao syncCategoryTreeDao = notesDatabaseManager.getSyncCategoryTreeDao();
            SyncDocumentDao syncDocumentDao = notesDatabaseManager.getSyncDocumentDao();
            new SyncNoteDataRepository();
            new SoftParentFolderChecker(notesDatabaseManager.getCategoryTreeClosureDao());
            if (z) {
                syncDocumentDao.updateCategoryByCategoryUuid(str, "1");
            } else {
                syncDocumentDao.updateCategoryByCategoryUuidWithCategoryServerTimestamp(str, "1", TimeManager.getCurrentTime(applicationContext));
            }
            syncCategoryTreeDao.deleteOldCategory(str, j, i);
        }
    }

    @Override // p093X.InterfaceC0333a
    public void deleteCategorySync(Context context, String str) {
        synchronized (synchronizeCategory) {
            context.getApplicationContext();
            NotesDatabase notesDatabaseManager = NotesDatabaseManager.getInstance();
            SyncCategoryTreeDao syncCategoryTreeDao = notesDatabaseManager.getSyncCategoryTreeDao();
            notesDatabaseManager.getSyncDocumentDao();
            new SyncNoteDataRepository();
            new SoftParentFolderChecker(notesDatabaseManager.getCategoryTreeClosureDao());
            Debugger.m8615i("SyncCategoryTreeRepository", "deleteFolderBySync ");
            syncCategoryTreeDao.deleteCategory(str);
            syncCategoryTreeDao.deleteCategoryClosure(str);
        }
    }

    @Override // p093X.InterfaceC0333a
    public int getCategoryDeleted(String str) {
        NotesCategoryTreeEntity entity = NotesDataRepositoryFactory.newInstance(BaseUtils.getApplicationContext()).createDocumentCategoryTreeRepository().getEntity(str);
        if (entity != null) {
            return entity.getIsDeleted();
        }
        return 0;
    }

    @Override // p093X.InterfaceC0333a
    public String getCategoryName(Context context, String str) {
        String string;
        if (str == null || str.equals("1")) {
            string = context.getResources().getString(C8003R.string.uncategorised);
        } else if (str.equals("2")) {
            string = context.getResources().getString(C8003R.string.string_screen_off_memo);
        } else {
            NotesCategoryTreeEntity entity = NotesDataRepositoryFactory.newInstance(BaseUtils.getApplicationContext()).createDocumentCategoryTreeRepository().getEntity(str);
            string = entity != null ? entity.getDisplayName() : "";
        }
        return TextUtils.isEmpty(string) ? context.getResources().getString(C8003R.string.uncategorised) : string;
    }

    @Override // p093X.InterfaceC0333a
    public int getCategoryOrder(Context context, String str) {
        NotesCategoryTreeEntity entity = NotesDataRepositoryFactory.newInstance(BaseUtils.getApplicationContext()).createDocumentCategoryTreeRepository().getEntity(str);
        if (entity != null) {
            return entity.getReorder().intValue();
        }
        return 0;
    }

    @Override // p093X.InterfaceC0333a
    public long getCategoryServerTimestamp(Context context, String str) {
        NotesCategoryTreeEntity entity = NotesDataRepositoryFactory.newInstance(context).createDocumentCategoryTreeRepository().getEntity(str);
        if (entity != null) {
            return entity.getServerTimeStamp().longValue();
        }
        return 0L;
    }

    @Override // p093X.InterfaceC0333a
    public List<String> getCategoryUUIDList(Context context) {
        context.getApplicationContext();
        NotesDatabase notesDatabaseManager = NotesDatabaseManager.getInstance();
        SyncCategoryTreeDao syncCategoryTreeDao = notesDatabaseManager.getSyncCategoryTreeDao();
        notesDatabaseManager.getSyncDocumentDao();
        new SyncNoteDataRepository();
        new SoftParentFolderChecker(notesDatabaseManager.getCategoryTreeClosureDao());
        return syncCategoryTreeDao.getOldCategoryUuidList();
    }

    @Override // p093X.InterfaceC0333a
    public List<String> getCategoryUUIDListByDeleted(Context context, boolean z) {
        context.getApplicationContext();
        NotesDatabase notesDatabaseManager = NotesDatabaseManager.getInstance();
        SyncCategoryTreeDao syncCategoryTreeDao = notesDatabaseManager.getSyncCategoryTreeDao();
        notesDatabaseManager.getSyncDocumentDao();
        new SyncNoteDataRepository();
        new SoftParentFolderChecker(notesDatabaseManager.getCategoryTreeClosureDao());
        return z ? syncCategoryTreeDao.getOldCategoryUuidListIncludeDeletedOrderByAsc() : syncCategoryTreeDao.getOldCategoryUuidListOrderByAsc();
    }

    @Override // p093X.InterfaceC0333a
    public List<String> getCategoryUUIDListByDirty(Context context, int i) {
        context.getApplicationContext();
        NotesDatabase notesDatabaseManager = NotesDatabaseManager.getInstance();
        SyncCategoryTreeDao syncCategoryTreeDao = notesDatabaseManager.getSyncCategoryTreeDao();
        notesDatabaseManager.getSyncDocumentDao();
        new SyncNoteDataRepository();
        new SoftParentFolderChecker(notesDatabaseManager.getCategoryTreeClosureDao());
        return syncCategoryTreeDao.getOldCategoryUuidListByDirty(i);
    }

    @Override // p093X.InterfaceC0333a
    public int getDirtyCountOfNoteCategory(Context context) {
        return new SyncNoteDataRepository().getOldDirtyCountOfNoteCategory();
    }

    @Override // p093X.InterfaceC0333a
    public long getNoteCategoryDirty(Context context, String str) {
        if (AbstractC0000a.m9f(context, str) != null) {
            return r1.getCategoryIsDirty();
        }
        return 0L;
    }

    @Override // p093X.InterfaceC0333a
    public long getNoteCategoryServerTimestamp(Context context, String str) {
        Long noteCategoryServerTimestamp = NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository().getNoteCategoryServerTimestamp(str);
        if (noteCategoryServerTimestamp == null) {
            return 0L;
        }
        return noteCategoryServerTimestamp.longValue();
    }

    @Override // p093X.InterfaceC0333a
    public String getNoteCategoryUUID(Context context, String str) {
        NotesDocumentEntity notesDocumentEntityM9f = AbstractC0000a.m9f(context, str);
        if (notesDocumentEntityM9f == null) {
            return "1";
        }
        if (!PredefinedCategory.RECYCLE_BIN.getUuid().equals(notesDocumentEntityM9f.getCategoryUuid())) {
            return notesDocumentEntityM9f.getCategoryUuid();
        }
        NotesFolder notesFolderFind = NotesDataRepositoryFactory.newInstance(context).createDocumentCategoryTreeRepository().getAllDocumentCategoryTree(false).find(notesDocumentEntityM9f.getAbsolutePath());
        if (notesFolderFind != null) {
            if (PredefinedCategory.OLD_NOTES.getUuid().equals(notesFolderFind.getParentUuid())) {
                return notesFolderFind.getUuid();
            }
        }
        return "1";
    }

    @Override // p093X.InterfaceC0333a
    public List<String> getUUIDListByCategory(Context context, String str, boolean z) {
        context.getApplicationContext();
        NotesDatabase notesDatabaseManager = NotesDatabaseManager.getInstance();
        notesDatabaseManager.getSyncCategoryTreeDao();
        notesDatabaseManager.getSyncDocumentDao();
        SyncNoteDataRepository syncNoteDataRepository = new SyncNoteDataRepository();
        new SoftParentFolderChecker(notesDatabaseManager.getCategoryTreeClosureDao());
        return syncNoteDataRepository.getUuidListByCategory(str, z);
    }

    @Override // p093X.InterfaceC0333a
    public HashMap<String, Long> getUuidAndNoteCategoryTimeList(Context context) {
        context.getApplicationContext();
        NotesDatabase notesDatabaseManager = NotesDatabaseManager.getInstance();
        notesDatabaseManager.getSyncCategoryTreeDao();
        notesDatabaseManager.getSyncDocumentDao();
        SyncNoteDataRepository syncNoteDataRepository = new SyncNoteDataRepository();
        new SoftParentFolderChecker(notesDatabaseManager.getCategoryTreeClosureDao());
        return syncNoteDataRepository.getOldUuidAndNoteCategoryTimeList();
    }

    @Override // p093X.InterfaceC0333a
    public boolean isExistCategory(Context context, String str) {
        if ("1".equals(str)) {
            return true;
        }
        NotesCategoryTreeEntity categoryEntity = FolderManager.getInstance().getCategoryEntity(str);
        if (categoryEntity == null || !PredefinedCategory.OLD_NOTES.getUuid().equals(categoryEntity.getParentUuid())) {
            return false;
        }
        categoryEntity.getIsDeleted();
        return true;
    }

    @Override // p093X.InterfaceC0333a
    public void recoveryCategory(Context context, String str, long j, int i) {
        synchronized (synchronizeCategory) {
            context.getApplicationContext();
            NotesDatabase notesDatabaseManager = NotesDatabaseManager.getInstance();
            SyncCategoryTreeDao syncCategoryTreeDao = notesDatabaseManager.getSyncCategoryTreeDao();
            notesDatabaseManager.getSyncDocumentDao();
            new SyncNoteDataRepository();
            new SoftParentFolderChecker(notesDatabaseManager.getCategoryTreeClosureDao());
            syncCategoryTreeDao.recoveryCategoryForOldCategory(str, i, j, syncCategoryTreeDao.getOldLastOrder(), 0);
        }
        C14477a.m15065b().m15073i();
    }

    @Override // p093X.InterfaceC0333a
    public void setCategoryDirty(Context context, String str, int i) {
        context.getApplicationContext();
        NotesDatabase notesDatabaseManager = NotesDatabaseManager.getInstance();
        SyncCategoryTreeDao syncCategoryTreeDao = notesDatabaseManager.getSyncCategoryTreeDao();
        notesDatabaseManager.getSyncDocumentDao();
        new SyncNoteDataRepository();
        new SoftParentFolderChecker(notesDatabaseManager.getCategoryTreeClosureDao());
        syncCategoryTreeDao.updateIsDirty(str, i);
    }

    @Override // p093X.InterfaceC0333a
    public void setCategoryOrder(Context context, HashMap<String, Integer> map, long j) {
        context.getApplicationContext();
        NotesDatabase notesDatabaseManager = NotesDatabaseManager.getInstance();
        SyncCategoryTreeDao syncCategoryTreeDao = notesDatabaseManager.getSyncCategoryTreeDao();
        notesDatabaseManager.getSyncDocumentDao();
        new SyncNoteDataRepository();
        new SoftParentFolderChecker(notesDatabaseManager.getCategoryTreeClosureDao());
        HashMap map2 = new HashMap();
        List<String> uuidListWithOrder = syncCategoryTreeDao.getUuidListWithOrder();
        int size = uuidListWithOrder.size();
        int i = 599999;
        for (int i2 = 0; i2 < size; i2++) {
            i--;
            map2.put(uuidListWithOrder.get(i2), Integer.valueOf(i));
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            value.intValue();
            if (!"1".equals(key) && !"2".equals(key)) {
                map2.put(key, value);
            }
        }
        LinkedList<Map.Entry> linkedList = new LinkedList(map2.entrySet());
        linkedList.sort(Map.Entry.comparingByValue());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry2 : linkedList) {
            linkedHashMap.put((String) entry2.getKey(), (Integer) entry2.getValue());
        }
        Iterator it = linkedHashMap.entrySet().iterator();
        int i4 = 1;
        while (it.hasNext()) {
            syncCategoryTreeDao.setOldCategoryOrder((String) ((Map.Entry) it.next()).getKey(), i4);
            i4++;
        }
        RequestToSyncManager.INSTANCE.setCategoryOrderModifiedTime(j);
    }

    @Override // p093X.InterfaceC0333a
    public int setNoteCategory(Context context, String str, String str2, int i, long j) {
        SyncNoteDataRepository syncNoteDataRepositoryCreateSyncNoteDataRepository = NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository();
        if (TextUtils.isEmpty(str2) || str2.equals(PredefinedCategory.UNCATEGORIZED.getUuid())) {
            str2 = "1";
        }
        if (syncNoteDataRepositoryCreateSyncNoteDataRepository.getNoteDeleted(str) == 0) {
            syncNoteDataRepositoryCreateSyncNoteDataRepository.updateNoteCategory(str, str2, i, j);
            return 1;
        }
        boolean zEquals = PredefinedCategory.RECYCLE_BIN.getUuid().equals(str2);
        String absolutePath = CategoryConstants.OldUncategorized.PATH;
        if (!zEquals) {
            NotesFolder folder = NotesDataRepositoryFactory.newInstance(context).createDocumentCategoryTreeRepository().getAllDocumentCategoryTree(false).getFolder(str2);
            if (folder != null) {
                absolutePath = folder.getAbsolutePath();
            }
            str2 = "trash:///";
        }
        syncNoteDataRepositoryCreateSyncNoteDataRepository.updateNoteCategoryAndAbsolutePath(str, str2, i, j, absolutePath);
        return 1;
    }

    @Override // p093X.InterfaceC0333a
    public void setNoteCategoryDirty(Context context, String str, int i) {
        NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository().updateDirtyCategory(str, i);
    }

    @Override // p093X.InterfaceC0333a
    public void setTimestampAndDirty(Context context, String str, long j, int i) {
        context.getApplicationContext();
        NotesDatabase notesDatabaseManager = NotesDatabaseManager.getInstance();
        SyncCategoryTreeDao syncCategoryTreeDao = notesDatabaseManager.getSyncCategoryTreeDao();
        notesDatabaseManager.getSyncDocumentDao();
        new SyncNoteDataRepository();
        new SoftParentFolderChecker(notesDatabaseManager.getCategoryTreeClosureDao());
        syncCategoryTreeDao.setTimestampAndDirtyForOldCategory(str, j, i);
    }

    @Override // p093X.InterfaceC0333a
    public Object synchronizeCategory() {
        return synchronizeCategory;
    }

    @Override // p093X.InterfaceC0333a
    public void updateCategoryNameAndColor(Context context, String str, String str2, int i) {
        context.getApplicationContext();
        NotesDatabase notesDatabaseManager = NotesDatabaseManager.getInstance();
        SyncCategoryTreeDao syncCategoryTreeDao = notesDatabaseManager.getSyncCategoryTreeDao();
        notesDatabaseManager.getSyncDocumentDao();
        new SyncNoteDataRepository();
        new SoftParentFolderChecker(notesDatabaseManager.getCategoryTreeClosureDao());
        syncCategoryTreeDao.setDisplayNameAndColorForOldCategory(str, str2, i);
    }

    @Override // p093X.InterfaceC0333a
    public String addCategory(Context context, String str, String str2, int i, boolean z) {
        NotesCategoryTreeEntity notesCategoryTreeEntity = new NotesCategoryTreeEntity(str, PredefinedCategory.OLD_NOTES.getUuid(), str2, null);
        notesCategoryTreeEntity.setServerTimeStamp(Long.valueOf(TimeManager.getCurrentTime(context)));
        notesCategoryTreeEntity.setCreatedAt(System.currentTimeMillis());
        notesCategoryTreeEntity.setLastModifiedAt(System.currentTimeMillis());
        notesCategoryTreeEntity.setDisplayNameColor(i);
        notesCategoryTreeEntity.setIsDirty(0);
        C13533a c13533a = new C13533a(context);
        Debugger.m8615i("SyncCategoryTreeRepository", "insertOrMerge ");
        String uuid = notesCategoryTreeEntity.getUuid();
        String parentUuid = notesCategoryTreeEntity.getParentUuid();
        String uuid2 = notesCategoryTreeEntity.getUuid();
        String displayName = notesCategoryTreeEntity.getDisplayName();
        SyncCategoryTreeDao syncCategoryTreeDao = c13533a.f9553b;
        NotesCategoryTreeEntity entityByParentUuidAndName = syncCategoryTreeDao.getEntityByParentUuidAndName(parentUuid, uuid2, displayName);
        Debugger.m8615i("SyncCategoryTreeRepository", "insertBySync, entity : " + notesCategoryTreeEntity);
        c13533a.f9555d.checkInvalidRelationShip(notesCategoryTreeEntity.getUuid(), notesCategoryTreeEntity.getParentUuid());
        syncCategoryTreeDao.insertFolder(notesCategoryTreeEntity);
        if (entityByParentUuidAndName == null || entityByParentUuidAndName.getUuid().equals(notesCategoryTreeEntity.getUuid())) {
            return uuid;
        }
        DocumentCategoryTree allDocumentCategoryTree = syncCategoryTreeDao.getAllDocumentCategoryTree(false);
        long jLongValue = notesCategoryTreeEntity.getServerTimeStamp().longValue();
        long jLongValue2 = entityByParentUuidAndName.getServerTimeStamp().longValue();
        SyncDocumentDao syncDocumentDao = c13533a.f9554c;
        if (jLongValue > jLongValue2) {
            NotesFolder folder = allDocumentCategoryTree.getFolder(notesCategoryTreeEntity.getUuid());
            NotesFolder folder2 = allDocumentCategoryTree.getFolder(entityByParentUuidAndName.getUuid());
            c13533a.m14281c(allDocumentCategoryTree, folder2, folder);
            c13533a.m14280b(syncDocumentDao, allDocumentCategoryTree, folder, folder2, null);
            return uuid;
        }
        NotesFolder folder3 = allDocumentCategoryTree.getFolder(entityByParentUuidAndName.getUuid());
        NotesFolder folder4 = allDocumentCategoryTree.getFolder(notesCategoryTreeEntity.getUuid());
        c13533a.m14281c(allDocumentCategoryTree, folder4, folder3);
        c13533a.m14280b(syncDocumentDao, allDocumentCategoryTree, folder3, folder4, null);
        return entityByParentUuidAndName.getUuid();
    }

    @Override // p093X.InterfaceC0333a
    public int setNoteCategory(Context context, String str, String str2) {
        return setNoteCategory(context, str, str2, 1, TimeManager.getCurrentTime(context));
    }
}
