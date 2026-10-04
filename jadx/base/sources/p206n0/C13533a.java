package p206n0;

import android.content.Context;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p148nt.base.common.data.DataUpdateManager;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesDocumentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.DocumentCategoryTree;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncCategoryTreeDao;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncDocumentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.SyncCategoryTreeInfo;
import com.samsung.android.support.senl.p148nt.data.repository.category.SoftParentFolderChecker;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: n0.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C13533a {

    /* JADX INFO: renamed from: a */
    public final Context f9552a;

    /* JADX INFO: renamed from: b */
    public final SyncCategoryTreeDao f9553b;

    /* JADX INFO: renamed from: c */
    public final SyncDocumentDao f9554c;

    /* JADX INFO: renamed from: d */
    public final SoftParentFolderChecker f9555d;

    public C13533a(Context context) {
        this.f9552a = context.getApplicationContext();
        NotesDatabase notesDatabaseManager = NotesDatabaseManager.getInstance();
        this.f9553b = notesDatabaseManager.getSyncCategoryTreeDao();
        this.f9554c = notesDatabaseManager.getSyncDocumentDao();
        new SyncNoteDataRepository();
        this.f9555d = new SoftParentFolderChecker(notesDatabaseManager.getCategoryTreeClosureDao());
    }

    /* JADX INFO: renamed from: a */
    public final SyncCategoryTreeInfo m14279a(String str) {
        AbstractC4539a.m3190D("getSyncEntity ", str, "SyncCategoryTreeRepository");
        return this.f9553b.getSyncEntity(str);
    }

    /* JADX INFO: renamed from: b */
    public final void m14280b(SyncDocumentDao syncDocumentDao, DocumentCategoryTree documentCategoryTree, NotesFolder notesFolder, NotesFolder notesFolder2, HashMap map) {
        C13533a c13533a = this;
        DocumentCategoryTree documentCategoryTree2 = documentCategoryTree;
        if (notesFolder2 == null) {
            Debugger.m8609e("SyncCategoryTreeRepository", "mergeBySync, removedFolder is null!");
            return;
        }
        Debugger.m8615i("SyncCategoryTreeRepository", "mergeBySync, change folder from " + notesFolder2.getUuid() + " to " + notesFolder.getUuid());
        Iterator<NotesFolder> it = notesFolder2.getChildren().iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            SyncCategoryTreeDao syncCategoryTreeDao = c13533a.f9553b;
            if (!zHasNext) {
                syncCategoryTreeDao.deleteMovingCategory(notesFolder2.getUuid());
                c13533a.f9553b.delete(notesFolder2, notesFolder2.getServerTimeStamp().longValue() + 1, notesFolder2.getLastModifiedAt());
                Debugger.m8615i("SyncCategoryTreeRepository", "mergeBySync, change docs from " + notesFolder2.getUuid() + " to " + notesFolder.getUuid());
                syncDocumentDao.updateCategoryByCategoryUuidWithCategoryServerTimestampIncrease(notesFolder2.getUuid(), notesFolder.getUuid(), notesFolder.getServerTimeStamp().longValue());
                return;
            }
            NotesFolder next = it.next();
            NotesCategoryTreeEntity entityByParentUuidAndName = syncCategoryTreeDao.getEntityByParentUuidAndName(notesFolder.getUuid(), next.getUuid(), next.getDisplayName());
            if (entityByParentUuidAndName == null || entityByParentUuidAndName.getIsDeleted() != 0) {
                c13533a.f9555d.checkInvalidRelationShip(next.getUuid(), notesFolder.getUuid());
                c13533a.f9553b.move(next.getUuid(), notesFolder.getUuid(), notesFolder2.getServerTimeStamp().longValue(), notesFolder2.getLastModifiedAt());
            } else if (next.getServerTimeStamp().longValue() > entityByParentUuidAndName.getServerTimeStamp().longValue()) {
                c13533a.m14280b(syncDocumentDao, documentCategoryTree2, next, documentCategoryTree2.getFolder(entityByParentUuidAndName.getUuid()), map);
                c13533a = this;
            } else {
                c13533a = this;
                c13533a.m14280b(syncDocumentDao, documentCategoryTree2, documentCategoryTree2.getFolder(entityByParentUuidAndName.getUuid()), next, map);
                if (map != null) {
                    map.put(next.getUuid(), entityByParentUuidAndName.getUuid());
                }
            }
            documentCategoryTree2 = documentCategoryTree;
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m14281c(DocumentCategoryTree documentCategoryTree, NotesFolder notesFolder, NotesFolder notesFolder2) {
        if (notesFolder == null) {
            Debugger.m8609e("SyncCategoryTreeRepository", "setRestorePathToMerge, sourceFolder is null!");
            return;
        }
        NotesFolder folder = documentCategoryTree.getFolder(notesFolder2.getParentUuid());
        SyncCategoryTreeDao syncCategoryTreeDao = this.f9553b;
        syncCategoryTreeDao.setRestorePathToMerge(syncCategoryTreeDao.getTargetPath(notesFolder, folder), notesFolder);
    }

    /* JADX INFO: renamed from: d */
    public final void m14282d(NotesFolder notesFolder, String str, long j, NotesDocumentDao notesDocumentDao) {
        Debugger.m8614f("SyncCategoryTreeRepository", "updateToRecycleBin call updateToRecycleBinInternal, uuid : " + notesFolder.getUuid() + " , isDeleted : 1");
        List<String> allDocumentsInFolderTree = this.f9554c.getAllDocumentsInFolderTree(Collections.singleton(notesFolder.getUuid()));
        m14283e(notesFolder, notesDocumentDao, j);
        String uuid = notesFolder.getUuid();
        SyncCategoryTreeDao syncCategoryTreeDao = this.f9553b;
        syncCategoryTreeDao.deleteMovingCategory(uuid);
        syncCategoryTreeDao.moveToParent(notesFolder.getUuid(), str);
        DataUpdateManager.getInstance().onDocumentMovedToTrash(allDocumentsInFolderTree);
    }

    /* JADX INFO: renamed from: e */
    public final void m14283e(NotesFolder notesFolder, NotesDocumentDao notesDocumentDao, long j) {
        if (notesFolder == null) {
            return;
        }
        Iterator<NotesFolder> it = notesFolder.getChildren().iterator();
        while (it.hasNext()) {
            m14283e(it.next(), notesDocumentDao, j);
        }
        String uuid = notesFolder.getUuid();
        StringBuilder sb = new StringBuilder();
        sb.append(notesFolder.getParent().getRestorePath());
        String str = File.separator;
        sb.append(str);
        sb.append(notesFolder.getDisplayName());
        this.f9553b.moveToTrash(uuid, sb.toString(), j, j);
        notesDocumentDao.moveToRecycleBinByCategoryUuid(notesFolder.getUuid(), j, j, notesFolder.getParent().getRestorePath() + str + notesFolder.getDisplayName());
    }

    /* JADX INFO: renamed from: f */
    public final void m14284f(NotesFolder notesFolder, NotesDocumentDao notesDocumentDao, long j) {
        Debugger.m8614f("SyncCategoryTreeRepository", "updateToRestore call restoreInternal, uuid : " + notesFolder.getUuid() + " , isDeleted : 0");
        this.f9553b.restore(notesFolder, notesDocumentDao, j);
    }
}
