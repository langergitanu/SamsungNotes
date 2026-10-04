package com.samsung.android.support.senl.p148nt.model.restore.folder;

import android.content.Context;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.data.common.constants.CategoryConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class CircularFolderDetector {
    private static final String TAG = ModelLogger.createTag("CircularFolderDetector");
    private final FolderArrangeManager mFolderArrangeManager;
    private final RestoreFolderCreator mFolderCreator;
    private final String mRestoredFolderUuid;
    private final Map<String, NotesCategoryTreeEntity> mEntityMap = new HashMap();
    private final Map<String, Set<NotesCategoryTreeEntity>> mChildrenMap = new HashMap();
    private final Set<String> mNormalCategories = new HashSet();
    private final Set<NotesCategoryTreeEntity> mRepairedCategories = new HashSet();

    public CircularFolderDetector(@NonNull Context context) {
        RestoreFolderCreator restoreFolderCreator = new RestoreFolderCreator(context);
        this.mFolderCreator = restoreFolderCreator;
        this.mFolderArrangeManager = new FolderArrangeManager(context);
        this.mRestoredFolderUuid = restoreFolderCreator.getRestoredFolderUuidByVersion();
        initializeMaps();
    }

    private void addChildren(NotesCategoryTreeEntity notesCategoryTreeEntity) {
        this.mChildrenMap.get(notesCategoryTreeEntity.getParentUuid()).add(notesCategoryTreeEntity);
    }

    private void checkCircularCategory(@NonNull NotesCategoryTreeEntity notesCategoryTreeEntity) {
        HashSet hashSet = new HashSet();
        while (true) {
            if (notesCategoryTreeEntity != null) {
                if (!hashSet.contains(notesCategoryTreeEntity.getUuid())) {
                    hashSet.add(notesCategoryTreeEntity.getUuid());
                    String parentUuid = notesCategoryTreeEntity.getParentUuid();
                    boolean zContains = this.mNormalCategories.contains(parentUuid);
                    boolean z = false;
                    boolean z2 = parentUuid == null && !PredefinedCategory.isRootFolder(notesCategoryTreeEntity.getUuid());
                    if (parentUuid != null && this.mEntityMap.get(parentUuid) == null) {
                        z = true;
                    }
                    if (zContains) {
                        break;
                    }
                    if (z2 || z) {
                        break;
                    } else {
                        notesCategoryTreeEntity = this.mEntityMap.get(parentUuid);
                    }
                } else {
                    moveToRestoreFolder(notesCategoryTreeEntity);
                    break;
                }
            } else {
                break;
            }
        }
        moveToRestoreFolder(notesCategoryTreeEntity);
        this.mNormalCategories.addAll(hashSet);
    }

    private boolean createRestoredCategory() {
        NotesCategoryTreeEntity notesCategoryTreeEntityCreateFolderByVersion = this.mFolderCreator.createFolderByVersion();
        if (notesCategoryTreeEntityCreateFolderByVersion == null) {
            DataLogger.m12305f(TAG, "createRestoredCategory, fail to create Restored category");
            return false;
        }
        if (this.mEntityMap.get(this.mRestoredFolderUuid) != null) {
            return true;
        }
        this.mEntityMap.put(this.mRestoredFolderUuid, notesCategoryTreeEntityCreateFolderByVersion);
        this.mChildrenMap.get("uncategorized:///").add(notesCategoryTreeEntityCreateFolderByVersion);
        return true;
    }

    public static String generateUniqueFolderName(Set<String> set, String str) {
        String str2 = str;
        int i = 1;
        while (set.contains(str2)) {
            str2 = str + " (" + i + ")";
            i++;
        }
        return str2;
    }

    private Set<NotesCategoryTreeEntity> getInitialModifiedFolders() {
        HashSet hashSet = new HashSet();
        NotesCategoryTreeEntity notesCategoryTreeEntity = this.mEntityMap.get(CategoryConstants.Restored.UUID);
        if (notesCategoryTreeEntity != null) {
            hashSet.add(notesCategoryTreeEntity);
        }
        return hashSet;
    }

    private Set<NotesCategoryTreeEntity> getModifiedFolders() {
        Set<NotesCategoryTreeEntity> initialModifiedFolders = getInitialModifiedFolders();
        initialModifiedFolders.add(this.mEntityMap.get(this.mRestoredFolderUuid));
        initialModifiedFolders.addAll(this.mRepairedCategories);
        initialModifiedFolders.addAll(getDuplicatedFolderNameEntities());
        return initialModifiedFolders;
    }

    private void initializeMaps() {
        this.mChildrenMap.put(null, new HashSet());
        this.mChildrenMap.put(this.mRestoredFolderUuid, new HashSet());
        for (NotesCategoryTreeEntity notesCategoryTreeEntity : FolderManager.getInstance().getEntities()) {
            this.mEntityMap.put(notesCategoryTreeEntity.getUuid(), notesCategoryTreeEntity);
            this.mChildrenMap.put(notesCategoryTreeEntity.getUuid(), new HashSet());
        }
    }

    private void moveToRestoreFolder(@NonNull NotesCategoryTreeEntity notesCategoryTreeEntity) {
        notesCategoryTreeEntity.setParentUuid(this.mRestoredFolderUuid);
        this.mRepairedCategories.add(notesCategoryTreeEntity);
    }

    private void restoreCategories() {
        DataLogger.m12305f(TAG, "restoreCategories, circular tree count : " + this.mRepairedCategories.size());
        if (this.mRepairedCategories.isEmpty()) {
            this.mFolderArrangeManager.arrangeFolders(getInitialModifiedFolders(), getSortedCategories());
        } else if (createRestoredCategory()) {
            this.mFolderArrangeManager.arrangeFolders(getModifiedFolders(), getSortedCategories());
        }
    }

    public void execute() {
        for (NotesCategoryTreeEntity notesCategoryTreeEntity : this.mEntityMap.values()) {
            if (!this.mNormalCategories.contains(notesCategoryTreeEntity.getUuid())) {
                checkCircularCategory(notesCategoryTreeEntity);
            }
            addChildren(notesCategoryTreeEntity);
        }
        restoreCategories();
    }

    public Set<NotesCategoryTreeEntity> getDuplicatedFolderNameEntities() {
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        String uuid = this.mRestoredFolderUuid;
        while (true) {
            Set<NotesCategoryTreeEntity> set = this.mChildrenMap.get(uuid);
            HashSet hashSet2 = new HashSet();
            arrayList.addAll(set);
            if (arrayList.isEmpty()) {
                DataLogger.m12307i(TAG, " checkDuplicatedFolderName, result - " + hashSet.size());
                return hashSet;
            }
            for (NotesCategoryTreeEntity notesCategoryTreeEntity : set) {
                if (hashSet2.contains(notesCategoryTreeEntity.getDisplayName())) {
                    notesCategoryTreeEntity.setDisplayName(generateUniqueFolderName(hashSet2, notesCategoryTreeEntity.getDisplayName()));
                    hashSet.add(notesCategoryTreeEntity);
                }
                hashSet2.add(notesCategoryTreeEntity.getDisplayName());
            }
            uuid = ((NotesCategoryTreeEntity) arrayList.remove(0)).getUuid();
        }
    }

    public List<NotesCategoryTreeEntity> getSortedCategories() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        String uuid = null;
        while (true) {
            Set<NotesCategoryTreeEntity> set = this.mChildrenMap.get(uuid);
            arrayList.addAll(set);
            linkedHashSet.addAll(set);
            if (arrayList.isEmpty()) {
                DataLogger.m12307i(TAG, " getSortedCategories, entities/result - " + this.mEntityMap.size() + " / " + linkedHashSet.size());
                return new ArrayList(linkedHashSet);
            }
            uuid = ((NotesCategoryTreeEntity) arrayList.remove(0)).getUuid();
        }
    }
}
