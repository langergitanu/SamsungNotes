package com.samsung.android.support.senl.p148nt.model.domain.folder;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.common.exceptions.InvalidParentFolderException;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import com.samsung.android.support.senl.p148nt.data.repository.category.ParentFolderChecker;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.domain.common.DomainUtils;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class AddFolderUseCase {
    private static final String TAG = ModelLogger.createTag("AddFolderUseCase");
    private boolean mInTrash;
    private final ParentFolderChecker mParentFolderChecker = FolderManager.getInstance().getParentFolderChecker();

    private Set<String> getExcludedChildren(@NonNull String str) {
        HashSet hashSet = new HashSet();
        if ("uncategorized:///".equals(str)) {
            hashSet.addAll(PredefinedCategory.CHILDREN_FOLDERS_OF_UNCATEGORIZED);
        }
        return hashSet;
    }

    public boolean execute(@NonNull NotesCategoryTreeEntity notesCategoryTreeEntity) {
        return execute(notesCategoryTreeEntity, true);
    }

    public AddFolderUseCase setInTrash() {
        this.mInTrash = true;
        return this;
    }

    public boolean execute(@NonNull NotesCategoryTreeEntity notesCategoryTreeEntity, boolean z) {
        if (PredefinedCategory.RESTRICTED_FOLDERS.contains(notesCategoryTreeEntity.getUuid())) {
            DataLogger.m12303e(TAG, "execute, restricted folder, uuid: " + notesCategoryTreeEntity.getUuid());
            return false;
        }
        String displayName = notesCategoryTreeEntity.getDisplayName();
        int length = displayName.length();
        int iCharCount = 0;
        while (iCharCount < length) {
            int iCodePointAt = displayName.codePointAt(iCharCount);
            if (!Character.isWhitespace(iCodePointAt)) {
                String parentUuid = notesCategoryTreeEntity.getParentUuid();
                notesCategoryTreeEntity.setDisplayName(DomainUtils.applyFolderNameMaxLimit(notesCategoryTreeEntity.getDisplayName()));
                if (FolderManager.getInstance().hasDuplicateName(parentUuid, notesCategoryTreeEntity.getDisplayName())) {
                    DataLogger.m12303e(TAG, "execute, duplicate name exists");
                    return false;
                }
                try {
                    if (!this.mInTrash && !this.mParentFolderChecker.isUsed(parentUuid)) {
                        return true;
                    }
                    if (z) {
                        notesCategoryTreeEntity.setReorder(Integer.valueOf(FolderManager.getInstance().getChildrenCount(parentUuid, getExcludedChildren(parentUuid))));
                    }
                    FolderManager.getInstance().insert(notesCategoryTreeEntity);
                    return true;
                } catch (InvalidParentFolderException e) {
                    DataLogger.m12303e(TAG, "execute, e: " + e.getMessage());
                    return false;
                }
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        DataLogger.m12303e(TAG, "execute, folder name is invalid");
        return false;
    }
}
