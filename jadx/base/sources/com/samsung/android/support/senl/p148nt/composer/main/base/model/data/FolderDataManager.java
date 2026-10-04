package com.samsung.android.support.senl.p148nt.composer.main.base.model.data;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class FolderDataManager {
    private static final String TAG = Logger.createTag("FolderDataManager");

    public static String getFolderAbsolutePath(String str) {
        NotesFolder folder = FolderManager.getInstance().getAllDocumentCategoryTree(false).getFolder(str);
        if (folder == null) {
            return null;
        }
        return folder.getAbsolutePath();
    }

    public static int getFolderColor(String str, int i) {
        NotesCategoryTreeEntity categoryEntity;
        int displayNameColor = (TextUtils.isEmpty(str) || (categoryEntity = FolderManager.getInstance().getCategoryEntity(str)) == null) ? i : categoryEntity.getDisplayNameColor();
        return displayNameColor == -1 ? i : displayNameColor;
    }

    public static String getFolderName(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        NotesCategoryTreeEntity categoryEntity = FolderManager.getInstance().getCategoryEntity(str);
        if (categoryEntity != null) {
            return categoryEntity.getDisplayName();
        }
        AbstractC4539a.m3188B("getFolderName# categoryTreeEntity is null : folderUuid =", str, TAG);
        return str2;
    }

    public static boolean isFolderDeleted(@NonNull String str) {
        NotesCategoryTreeEntity categoryEntity = FolderManager.getInstance().getCategoryEntity(str);
        return (categoryEntity == null || categoryEntity.getIsDeleted() == 0) ? false : true;
    }
}
