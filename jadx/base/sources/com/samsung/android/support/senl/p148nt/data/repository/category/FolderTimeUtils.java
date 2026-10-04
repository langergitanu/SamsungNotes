package com.samsung.android.support.senl.p148nt.data.repository.category;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.base.common.TimeManager;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesCategoryTreeDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entry.CategoryTimeTuple;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.DocumentCategoryTree;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class FolderTimeUtils {
    private static final String TAG = DataLogger.createTag("FolderTimeUtils");

    @Nullable
    private static CategoryTimeTuple createModifiedTimeUpdateCommand(@Nullable NotesFolder notesFolder, long j) {
        if (notesFolder == null) {
            return null;
        }
        return createModifiedTimeUpdateCommand(notesFolder.getUuid(), j);
    }

    private static HashMap<String, CategoryTimeTuple> getParentsFolderCandidateMap(long j, List<CategoryTimeTuple> list, long j2) {
        HashMap<String, CategoryTimeTuple> map = new HashMap<>();
        for (CategoryTimeTuple categoryTimeTuple : list) {
            if (isTargetForServerTimestampUpdate(categoryTimeTuple.categoryUuid) && (categoryTimeTuple.time.longValue() < j || j2 < categoryTimeTuple.time.longValue())) {
                CategoryTimeTuple categoryTimeTuple2 = map.get(categoryTimeTuple.categoryUuid);
                if (categoryTimeTuple2 == null) {
                    map.put(categoryTimeTuple.categoryUuid, new CategoryTimeTuple(Long.valueOf(j), categoryTimeTuple.categoryUuid));
                } else if (categoryTimeTuple2.time.longValue() < j) {
                    map.put(categoryTimeTuple.categoryUuid, new CategoryTimeTuple(Long.valueOf(j), categoryTimeTuple.categoryUuid));
                }
            }
        }
        return map;
    }

    private static boolean isTargetForServerTimestampUpdate(@NonNull String str) {
        return (str.equals("uncategorized:///") || str.equals("trash:///") || str.equals("old:///")) ? false : true;
    }

    private static void performCandidateFolderMapBuilding(@NonNull DocumentCategoryTree documentCategoryTree, @Nullable NotesFolder notesFolder, long j, Map<String, CategoryTimeTuple> map, long j2) {
        NotesFolder folder;
        if (notesFolder == null) {
            DataLogger.m12303e(TAG, "performCandidateFolderMapBuilding() : folder is null!");
            return;
        }
        if (isTargetForServerTimestampUpdate(notesFolder.getUuid())) {
            long jLongValue = notesFolder.getServerTimeStamp().longValue();
            if (jLongValue < j || jLongValue > j2) {
                CategoryTimeTuple categoryTimeTuple = new CategoryTimeTuple(Long.valueOf(j), notesFolder.getUuid());
                CategoryTimeTuple categoryTimeTuple2 = map.get(categoryTimeTuple.categoryUuid);
                if (categoryTimeTuple2 == null || categoryTimeTuple2.time.longValue() < j) {
                    map.put(notesFolder.getUuid(), categoryTimeTuple);
                }
            }
            String parentUuid = notesFolder.getParentUuid();
            if (TextUtils.isEmpty(parentUuid) || (folder = documentCategoryTree.getFolder(parentUuid)) == null) {
                return;
            }
            performCandidateFolderMapBuilding(documentCategoryTree, folder, j, map, j2);
        }
    }

    public static void updateModifiedTime(DocumentCategoryTree documentCategoryTree, NotesCategoryTreeDao notesCategoryTreeDao, @NonNull Set<String> set, long j) {
        HashMap map = new HashMap();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            CategoryTimeTuple categoryTimeTupleCreateModifiedTimeUpdateCommand = createModifiedTimeUpdateCommand(documentCategoryTree.getFolder(it.next()), j);
            if (categoryTimeTupleCreateModifiedTimeUpdateCommand != null) {
                map.put(categoryTimeTupleCreateModifiedTimeUpdateCommand.categoryUuid, categoryTimeTupleCreateModifiedTimeUpdateCommand);
            }
        }
        notesCategoryTreeDao.updateModifiedTimeWithUuidList(map.values());
    }

    private static void updateServerTimeOfTargetUuidList(NotesCategoryTreeDao notesCategoryTreeDao, Collection<CategoryTimeTuple> collection) {
        if (collection == null) {
            return;
        }
        HashMap map = new HashMap();
        for (CategoryTimeTuple categoryTimeTuple : collection) {
            CategoryTimeTuple categoryTimeTuple2 = (CategoryTimeTuple) map.get(categoryTimeTuple.categoryUuid);
            if (categoryTimeTuple2 == null) {
                map.put(categoryTimeTuple.categoryUuid, categoryTimeTuple);
            } else if (categoryTimeTuple2.time.longValue() < categoryTimeTuple.time.longValue()) {
                map.put(categoryTimeTuple.categoryUuid, categoryTimeTuple);
            }
        }
        Collection<CategoryTimeTuple> collectionValues = map.values();
        if (collectionValues == null || collectionValues.size() <= 0) {
            DataLogger.m12303e(TAG, "updateServerTimeOfTargetUuidList() : No folder!");
            return;
        }
        DataLogger.m12307i(TAG, "updateServerTimeOfTargetUuidList() : " + collectionValues.size());
        notesCategoryTreeDao.updateServerTimestampWithUuidList(collectionValues);
    }

    public static void updateServerTimeUpward(DocumentCategoryTree documentCategoryTree, NotesCategoryTreeDao notesCategoryTreeDao, @NonNull Set<String> set, long j) {
        long currentTime = TimeManager.getCurrentTime();
        HashMap map = new HashMap();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            performCandidateFolderMapBuilding(documentCategoryTree, documentCategoryTree.getFolder(it.next()), j, map, currentTime);
        }
        notesCategoryTreeDao.updateServerTimestampWithUuidList(map.values());
    }

    @Nullable
    private static CategoryTimeTuple createModifiedTimeUpdateCommand(@Nullable String str, long j) {
        if (str == null || str.equals("uncategorized:///") || str.equals("trash:///") || str.equals("old:///")) {
            return null;
        }
        return new CategoryTimeTuple(Long.valueOf(j), str);
    }

    public static void updateModifiedTime(NotesCategoryTreeDao notesCategoryTreeDao, Collection<CategoryTimeTuple> collection) {
        if (collection == null) {
            return;
        }
        HashMap map = new HashMap();
        for (CategoryTimeTuple categoryTimeTuple : collection) {
            CategoryTimeTuple categoryTimeTupleCreateModifiedTimeUpdateCommand = createModifiedTimeUpdateCommand(categoryTimeTuple.categoryUuid, categoryTimeTuple.time.longValue());
            if (categoryTimeTupleCreateModifiedTimeUpdateCommand != null) {
                map.put(categoryTimeTupleCreateModifiedTimeUpdateCommand.categoryUuid, categoryTimeTupleCreateModifiedTimeUpdateCommand);
            }
        }
        notesCategoryTreeDao.updateModifiedTimeWithUuidList(map.values());
    }

    public static void updateServerTimeUpward(NotesCategoryTreeDao notesCategoryTreeDao, Collection<CategoryTimeTuple> collection) {
        if (collection == null) {
            return;
        }
        long currentTime = TimeManager.getCurrentTime();
        HashMap map = new HashMap();
        for (CategoryTimeTuple categoryTimeTuple : collection) {
            List<CategoryTimeTuple> parentsCategoryUuidList = notesCategoryTreeDao.getParentsCategoryUuidList(categoryTimeTuple.categoryUuid);
            if (parentsCategoryUuidList != null) {
                map.putAll(getParentsFolderCandidateMap(categoryTimeTuple.time.longValue(), parentsCategoryUuidList, currentTime));
            }
        }
        updateServerTimeOfTargetUuidList(notesCategoryTreeDao, map.values());
    }

    public static void updateModifiedTime(NotesCategoryTreeDao notesCategoryTreeDao, Collection<String> collection, long j) {
        if (collection == null) {
            return;
        }
        HashMap map = new HashMap();
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            CategoryTimeTuple categoryTimeTupleCreateModifiedTimeUpdateCommand = createModifiedTimeUpdateCommand(it.next(), j);
            if (categoryTimeTupleCreateModifiedTimeUpdateCommand != null) {
                map.put(categoryTimeTupleCreateModifiedTimeUpdateCommand.categoryUuid, categoryTimeTupleCreateModifiedTimeUpdateCommand);
            }
        }
        notesCategoryTreeDao.updateModifiedTimeWithUuidList(map.values());
    }

    public static void updateServerTimeUpward(NotesCategoryTreeDao notesCategoryTreeDao, Collection<String> collection, long j) {
        if (collection == null) {
            return;
        }
        long currentTime = TimeManager.getCurrentTime();
        HashMap map = new HashMap();
        Iterator<String> it = collection.iterator();
        while (it.hasNext()) {
            List<CategoryTimeTuple> parentsCategoryUuidList = notesCategoryTreeDao.getParentsCategoryUuidList(it.next());
            if (parentsCategoryUuidList != null) {
                map.putAll(getParentsFolderCandidateMap(j, parentsCategoryUuidList, currentTime));
            }
        }
        updateServerTimeOfTargetUuidList(notesCategoryTreeDao, map.values());
    }

    public static void updateServerTimeUpward(NotesCategoryTreeDao notesCategoryTreeDao, NotesCategoryTreeEntity notesCategoryTreeEntity, long j) {
        if (notesCategoryTreeEntity == null) {
            DataLogger.m12303e(TAG, "updateServerTimeUpward() : entity is null!");
        } else {
            if (PredefinedCategory.isRootFolder(notesCategoryTreeEntity.getUuid())) {
                return;
            }
            updateServerTimeUpward(notesCategoryTreeDao, Collections.singletonList(new CategoryTimeTuple(Long.valueOf(j), notesCategoryTreeEntity.getUuid())));
        }
    }
}
