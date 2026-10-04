package com.samsung.android.support.senl.p148nt.model.domain.folder;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.common.exceptions.InvalidParentFolderException;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import com.samsung.android.support.senl.p148nt.model.common.log.ModelLogger;
import com.samsung.android.support.senl.p148nt.model.domain.common.DomainUtils;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class UpdateFolderUseCase {
    private static final String TAG = ModelLogger.createTag("UpdateFolderUseCase");

    public boolean execute(@NonNull String str, @NonNull Consumer<NotesCategoryTreeEntity> consumer) {
        NotesCategoryTreeEntity categoryEntity = FolderManager.getInstance().getCategoryEntity(str);
        if (categoryEntity == null) {
            AbstractC11014a.m12314C("execute, folder doesn't exist, uuid: ", str, TAG);
            return false;
        }
        if (PredefinedCategory.RESTRICTED_FOLDERS.contains(str)) {
            AbstractC11014a.m12314C("execute, restricted folder, uuid: ", str, TAG);
            return false;
        }
        String displayName = categoryEntity.getDisplayName();
        consumer.accept(categoryEntity);
        if (displayName.equals(categoryEntity.getDisplayName())) {
            DataLogger.m12303e(TAG, "execute, nothing changed");
            return false;
        }
        String displayName2 = categoryEntity.getDisplayName();
        int length = displayName2.length();
        int iCharCount = 0;
        while (iCharCount < length) {
            int iCodePointAt = displayName2.codePointAt(iCharCount);
            if (!Character.isWhitespace(iCodePointAt)) {
                categoryEntity.setDisplayName(DomainUtils.applyFolderNameMaxLimit(categoryEntity.getDisplayName()));
                if (FolderManager.getInstance().hasDuplicateName(categoryEntity.getParentUuid(), categoryEntity.getDisplayName())) {
                    DataLogger.m12303e(TAG, "execute, duplicate name exists");
                    return false;
                }
                try {
                    FolderManager.getInstance().update(categoryEntity);
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
