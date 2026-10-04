package com.samsung.android.app.notes.sync.p135db;

import android.content.Context;
import android.text.TextUtils;
import androidx.compose.animation.core.AnimationKt;
import com.microsoft.identity.common.internal.util.StringUtil;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.FolderUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.DocumentCategoryTree;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import p206n0.C13533a;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.db.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class C6735d {

    /* JADX INFO: renamed from: a */
    public final C13533a f4097a;

    public C6735d(Context context) {
        this.f4097a = new C13533a(context);
    }

    /* JADX INFO: renamed from: b */
    public static FolderNodeItem m4826b(NotesCategoryTreeEntity notesCategoryTreeEntity) {
        FolderNodeItem folderNodeItem = new FolderNodeItem();
        folderNodeItem.uUid = notesCategoryTreeEntity.getUuid();
        folderNodeItem.type = "folder";
        if ("uncategorized:///".equals(notesCategoryTreeEntity.getParentUuid()) || "trash:///".equals(notesCategoryTreeEntity.getParentUuid())) {
            folderNodeItem.parentFolderNodeId = "root";
        } else {
            folderNodeItem.parentFolderNodeId = notesCategoryTreeEntity.getParentUuid();
        }
        folderNodeItem.syncModifiedTime = notesCategoryTreeEntity.getServerTimeStamp().longValue();
        folderNodeItem.createdTime = notesCategoryTreeEntity.getCreatedAt();
        folderNodeItem.lastModifiedTime = notesCategoryTreeEntity.getLastModifiedAt();
        folderNodeItem.recycleBinMovedTime = notesCategoryTreeEntity.getRecycleBinTimeMoved();
        if (FolderUtils.isValidFolderName(notesCategoryTreeEntity.getDisplayName())) {
            folderNodeItem.name = notesCategoryTreeEntity.getDisplayName();
        } else {
            folderNodeItem.name = FolderUtils.getNewFolderName(System.currentTimeMillis() % AnimationKt.MillisToNanos);
        }
        String str = notesCategoryTreeEntity.getIsDeleted() == 1 ? "deleted" : notesCategoryTreeEntity.getIsDeleted() == 2 ? FolderNodeItem.SYNC_WDOC_FOLDER_NODE_STATE_TRASHED : FolderNodeItem.SYNC_WDOC_FOLDER_NODE_STATE_NORMAL;
        folderNodeItem.state = str;
        if (!str.equals(FolderNodeItem.SYNC_WDOC_FOLDER_NODE_STATE_NORMAL)) {
            String restorePath = notesCategoryTreeEntity.getRestorePath();
            folderNodeItem.restorePath = restorePath;
            if (TextUtils.isEmpty(restorePath)) {
                folderNodeItem.restorePath = "uncategorized:///";
            }
        }
        folderNodeItem.isSyncWithMS = notesCategoryTreeEntity.isSyncWithMS();
        folderNodeItem.displayNameColor = notesCategoryTreeEntity.getDisplayNameColor();
        folderNodeItem.reorder = notesCategoryTreeEntity.getReorder().intValue();
        return folderNodeItem;
    }

    /* JADX INFO: renamed from: c */
    public static FolderNodeItem m4827c(NotesCategoryTreeEntity notesCategoryTreeEntity) {
        FolderNodeItem folderNodeItem = new FolderNodeItem();
        folderNodeItem.uUid = notesCategoryTreeEntity.getUuid();
        folderNodeItem.type = "folder";
        if ("uncategorized:///".equals(notesCategoryTreeEntity.getParentUuid()) || "trash:///".equals(notesCategoryTreeEntity.getParentUuid())) {
            folderNodeItem.parentFolderNodeId = "root";
        } else {
            folderNodeItem.parentFolderNodeId = notesCategoryTreeEntity.getParentUuid();
        }
        folderNodeItem.syncModifiedTime = notesCategoryTreeEntity.getServerTimeStamp().longValue();
        folderNodeItem.createdTime = notesCategoryTreeEntity.getCreatedAt();
        folderNodeItem.lastModifiedTime = notesCategoryTreeEntity.getLastModifiedAt();
        folderNodeItem.recycleBinMovedTime = notesCategoryTreeEntity.getRecycleBinTimeMoved();
        if (FolderUtils.isValidFolderName(notesCategoryTreeEntity.getDisplayName())) {
            folderNodeItem.name = notesCategoryTreeEntity.getDisplayName();
            return folderNodeItem;
        }
        folderNodeItem.name = FolderUtils.getNewFolderName(System.currentTimeMillis() % AnimationKt.MillisToNanos);
        return folderNodeItem;
    }

    /* JADX INFO: renamed from: d */
    public static boolean m4828d(String str) {
        return PredefinedCategory.UNCATEGORIZED.getUuid().equals(str) || PredefinedCategory.OLD_NOTES.getUuid().equals(str) || PredefinedCategory.RECYCLE_BIN.getUuid().equals(str) || PredefinedCategory.SHARED_NOTE_BOOK.getUuid().equals(str) || PredefinedCategory.COEDIT_NOTES.getUuid().equals(str);
    }

    /* JADX INFO: renamed from: e */
    public static boolean m4829e(String str, String str2) {
        return (TextUtils.isEmpty(str2) || m4828d(str) || PredefinedCategory.OLD_NOTES.getUuid().equals(str2)) ? false : true;
    }

    /* JADX INFO: renamed from: a */
    public final HashMap m4830a() {
        HashMap map;
        C13533a c13533a = this.f4097a;
        DocumentCategoryTree documentCategoryTree = new DocumentCategoryTree(c13533a.f9553b.getAllNotesFoldersForSync());
        Collection<NotesFolder> collectionValues = documentCategoryTree.getFolderMap().values();
        HashMap map2 = new HashMap();
        Iterator<NotesFolder> it = collectionValues.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            NotesFolder next = it.next();
            if (m4829e(next.getUuid(), next.getParentUuid())) {
                FolderNodeItem folderNodeItemM4827c = m4827c(next);
                String str = next.getIsDeleted() != 1 ? next.getIsDeleted() == 2 ? FolderNodeItem.SYNC_WDOC_FOLDER_NODE_STATE_TRASHED : FolderNodeItem.SYNC_WDOC_FOLDER_NODE_STATE_NORMAL : "deleted";
                folderNodeItemM4827c.state = str;
                if (str.equals(FolderNodeItem.SYNC_WDOC_FOLDER_NODE_STATE_TRASHED)) {
                    String restorePath = next.getRestorePath();
                    folderNodeItemM4827c.restorePath = restorePath;
                    if (restorePath == null || restorePath.isEmpty()) {
                        folderNodeItemM4827c.restorePath = "uncategorized:///";
                    }
                } else {
                    folderNodeItemM4827c.restorePath = next.getRestorePath();
                }
                folderNodeItemM4827c.isSyncWithMS = next.isSyncWithMS();
                folderNodeItemM4827c.displayNameColor = next.getDisplayNameColor();
                folderNodeItemM4827c.reorder = next.getReorder().intValue();
                map2.put(folderNodeItemM4827c.uUid, folderNodeItemM4827c);
            }
        }
        Debugger.m8615i("SyncCategoryTreeRepository", "getAllDeletedCategoryEntityForSync");
        List<NotesCategoryTreeEntity> allDeletedCategoryEntityForSync = c13533a.f9553b.getAllDeletedCategoryEntityForSync();
        if (allDeletedCategoryEntityForSync == null) {
            map = new HashMap();
        } else {
            HashMap map3 = new HashMap();
            for (NotesCategoryTreeEntity notesCategoryTreeEntity : allDeletedCategoryEntityForSync) {
                if (documentCategoryTree.getFolder(notesCategoryTreeEntity.getUuid()) == null && !PredefinedCategory.UNCATEGORIZED.getUuid().equals(notesCategoryTreeEntity.getUuid())) {
                    PredefinedCategory predefinedCategory = PredefinedCategory.OLD_NOTES;
                    if (!predefinedCategory.getUuid().equals(notesCategoryTreeEntity.getUuid()) && !PredefinedCategory.RECYCLE_BIN.getUuid().equals(notesCategoryTreeEntity.getUuid()) && !StringUtil.isEmpty(notesCategoryTreeEntity.getParentUuid()) && !notesCategoryTreeEntity.getParentUuid().equals(predefinedCategory.getUuid())) {
                        FolderNodeItem folderNodeItemM4827c2 = m4827c(notesCategoryTreeEntity);
                        folderNodeItemM4827c2.state = "deleted";
                        map3.put(folderNodeItemM4827c2.uUid, folderNodeItemM4827c2);
                    }
                }
            }
            map = map3;
        }
        map2.putAll(map);
        return map2;
    }
}
