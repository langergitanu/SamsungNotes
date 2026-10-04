package com.samsung.android.support.senl.p148nt.model.restore.folder;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.sqlite.p113db.SimpleSQLiteQuery;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.base.common.TimeManager;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.sync.RequestToSyncManager;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class FolderArrangeManager {
    private static final String PREF_KEY_ARRANGE_FOLDER_DATABASE = "key_arrange_folder_1";
    private final Context mAppContext;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface PostJob {
        void execute(List<NotesCategoryTreeEntity> list);
    }

    public FolderArrangeManager(@NonNull Context context) {
        this.mAppContext = context;
    }

    private void addFolder(List<NotesCategoryTreeEntity> list, NotesCategoryTreeEntity notesCategoryTreeEntity, long j) {
        if (list.contains(notesCategoryTreeEntity)) {
            return;
        }
        if (PredefinedCategory.isRootFolder(notesCategoryTreeEntity.getUuid())) {
            notesCategoryTreeEntity.setParentUuid(null);
        }
        notesCategoryTreeEntity.setIsDirty(1);
        notesCategoryTreeEntity.setServerTimeStamp(Long.valueOf(j));
        list.add(notesCategoryTreeEntity);
    }

    public static void checkNeedToMigrate(@NonNull Context context) {
        SharedPreferencesCompat sharedPreferencesCompat = SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE);
        if (sharedPreferencesCompat.getBoolean(PREF_KEY_ARRANGE_FOLDER_DATABASE, false)) {
            return;
        }
        new FolderArrangeManager(context).arrangeFolders();
        sharedPreferencesCompat.putBoolean(PREF_KEY_ARRANGE_FOLDER_DATABASE, true);
    }

    private NotesCategoryTreeEntity findParent(List<NotesCategoryTreeEntity> list, String str) {
        for (NotesCategoryTreeEntity notesCategoryTreeEntity : list) {
            if (notesCategoryTreeEntity != null && notesCategoryTreeEntity.getUuid().equals(str)) {
                return notesCategoryTreeEntity;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$arrangeFolders$0(NotesCategoryTreeDao notesCategoryTreeDao, List list) {
        notesCategoryTreeDao.rawQuery(new SimpleSQLiteQuery("DELETE FROM category_tree"));
        notesCategoryTreeDao.rawQuery(new SimpleSQLiteQuery("DELETE FROM category_tree_closure"));
        if (list.isEmpty()) {
            return;
        }
        notesCategoryTreeDao.insertFolder(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$arrangeFolders$1(NotesCategoryTreeDao notesCategoryTreeDao, Set set, List list) {
        notesCategoryTreeDao.rawQuery(new SimpleSQLiteQuery("DELETE FROM category_tree_closure"));
        if (list.isEmpty()) {
            return;
        }
        notesCategoryTreeDao.restore(set, list);
    }

    public void arrangeFolders() {
        final NotesCategoryTreeDao categoryTreeDao = NotesDatabaseManager.getInstance().getCategoryTreeDao();
        arrangeFolders(categoryTreeDao.rawQuery(new SimpleSQLiteQuery("SELECT * FROM category_tree ORDER BY createdAt ASC")), TimeManager.getCurrentTime(this.mAppContext), new PostJob() { // from class: com.samsung.android.support.senl.nt.model.restore.folder.a
            @Override // com.samsung.android.support.senl.nt.model.restore.folder.FolderArrangeManager.PostJob
            public final void execute(List list) {
                FolderArrangeManager.lambda$arrangeFolders$0(categoryTreeDao, list);
            }
        });
    }

    @VisibleForTesting
    public void recursiveFolderSet(List<NotesCategoryTreeEntity> list, List<NotesCategoryTreeEntity> list2, NotesCategoryTreeEntity notesCategoryTreeEntity, long j, long j2) {
        NotesCategoryTreeEntity notesCategoryTreeEntity2;
        if (list2.contains(notesCategoryTreeEntity)) {
            return;
        }
        if (notesCategoryTreeEntity.getParentUuid() == null) {
            addFolder(list2, notesCategoryTreeEntity, j2);
            return;
        }
        if (PredefinedCategory.isRootFolder(notesCategoryTreeEntity.getUuid())) {
            addFolder(list2, notesCategoryTreeEntity, j2);
            return;
        }
        NotesCategoryTreeEntity notesCategoryTreeEntityFindParent = findParent(list, notesCategoryTreeEntity.getParentUuid());
        if (notesCategoryTreeEntityFindParent == null || list2.contains(notesCategoryTreeEntityFindParent)) {
            notesCategoryTreeEntity2 = notesCategoryTreeEntityFindParent;
        } else {
            notesCategoryTreeEntity2 = notesCategoryTreeEntityFindParent;
            recursiveFolderSet(list, list2, notesCategoryTreeEntity2, j, j2);
        }
        if (notesCategoryTreeEntity2 != null && notesCategoryTreeEntity2.getIsDeleted() == notesCategoryTreeEntity.getIsDeleted()) {
            addFolder(list2, notesCategoryTreeEntity, j2);
            return;
        }
        if (notesCategoryTreeEntity.getIsDeleted() == 1) {
            addFolder(list2, notesCategoryTreeEntity, j2);
            return;
        }
        if (notesCategoryTreeEntity2 == null) {
            if (notesCategoryTreeEntity.getIsDeleted() == 0) {
                notesCategoryTreeEntity.setParentUuid(PredefinedCategory.UNCATEGORIZED.getUuid());
            } else {
                notesCategoryTreeEntity.setParentUuid(PredefinedCategory.RECYCLE_BIN.getUuid());
                notesCategoryTreeEntity.setRecycleBinTimeMoved(j);
            }
        } else if (PredefinedCategory.RECYCLE_BIN.getUuid().equals(notesCategoryTreeEntity2.getUuid()) || notesCategoryTreeEntity2.getIsDeleted() == 2) {
            notesCategoryTreeEntity.setIsDeleted(2);
            notesCategoryTreeEntity.setRecycleBinTimeMoved(j);
        } else if (notesCategoryTreeEntity2.getIsDeleted() == 1) {
            notesCategoryTreeEntity2.setIsDeleted(2);
        } else {
            notesCategoryTreeEntity.setIsDeleted(0);
        }
        addFolder(list2, notesCategoryTreeEntity, j2);
    }

    public void arrangeFolders(final Set<NotesCategoryTreeEntity> set, List<NotesCategoryTreeEntity> list) {
        final NotesCategoryTreeDao categoryTreeDao = NotesDatabaseManager.getInstance().getCategoryTreeDao();
        long currentTime = TimeManager.getCurrentTime(this.mAppContext);
        for (NotesCategoryTreeEntity notesCategoryTreeEntity : set) {
            notesCategoryTreeEntity.setIsDirty(1);
            notesCategoryTreeEntity.setServerTimeStamp(Long.valueOf(currentTime));
        }
        arrangeFolders(list, currentTime, new PostJob() { // from class: com.samsung.android.support.senl.nt.model.restore.folder.b
            @Override // com.samsung.android.support.senl.nt.model.restore.folder.FolderArrangeManager.PostJob
            public final void execute(List list2) {
                FolderArrangeManager.lambda$arrangeFolders$1(categoryTreeDao, set, list2);
            }
        });
    }

    private void arrangeFolders(List<NotesCategoryTreeEntity> list, long j, PostJob postJob) {
        ArrayList arrayList = new ArrayList();
        long jCurrentTimeMillis = System.currentTimeMillis();
        Iterator<NotesCategoryTreeEntity> it = list.iterator();
        while (it.hasNext()) {
            recursiveFolderSet(list, arrayList, it.next(), jCurrentTimeMillis, j);
        }
        postJob.execute(arrayList);
        RequestToSyncManager.INSTANCE.requestSyncByModification();
    }
}
