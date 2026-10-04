package p017D1;

import android.content.Context;
import android.text.TextUtils;
import androidx.glance.AbstractC2821a;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.app.notes.sync.p135db.C6747p;
import com.samsung.android.app.notes.sync.p135db.C6749r;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncState;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import p022E1.C0077c;
import p022E1.C0082h;
import p042J1.AbstractC0153k;
import p042J1.C0145c;
import p042J1.C0152j;
import p253w1.InterfaceC14510a;

/* JADX INFO: renamed from: D1.j */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0069j extends AbstractC0060a {

    /* JADX INFO: renamed from: f */
    public final FolderNodeItem f247f;

    public C0069j(C0077c c0077c, C0082h c0082h, InterfaceC14510a interfaceC14510a, FolderNodeItem folderNodeItem) {
        super(c0077c, c0082h, interfaceC14510a, null, folderNodeItem.uUid);
        this.f247f = folderNodeItem;
        new C6747p(c0077c.f262e);
    }

    /* JADX INFO: renamed from: a */
    public final void m159a(String str) {
        NotesDocumentEntity notesDocumentEntity;
        SyncNoteDataRepository syncNoteDataRepository;
        String str2;
        long recycleBinTimeMoved;
        String path;
        StringBuilder sb = new StringBuilder("perform() : ");
        String str3 = this.f241e;
        AbstractC2821a.m2207B(sb, str3, " by ", str, " at ");
        FolderNodeItem folderNodeItem = this.f247f;
        sb.append(folderNodeItem.syncModifiedTime);
        Debugger.m8615i("SyncNote/SyncSDocxTrashDeletedLocalNote", sb.toString());
        C0152j c0152jM378g = AbstractC0153k.m378g();
        c0152jM378g.f454c = "SyncSDocxTrashDeletedLocalNote";
        c0152jM378g.f455d = str3;
        C0077c c0077c = this.f237a;
        Context context = c0077c.f262e;
        C6749r c6749r = c0077c.f266i;
        Context context2 = c0077c.f262e;
        c0152jM378g.m371b(context);
        if (str3 != null) {
            try {
                notesDocumentEntity = NotesDataRepositoryFactory.newInstance(context2).createDocumentDataRepository().get(str3);
                SyncNoteDataRepository syncNoteDataRepositoryCreateSyncNoteDataRepository = NotesDataRepositoryFactory.newInstance(context2).createSyncNoteDataRepository();
                NotesDataRepositoryFactory.newInstance(context2).createDocumentCoverRepository();
                NotesDataRepositoryFactory.newInstance(context2).createDocumentTempDataRepository();
                NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
                syncNoteDataRepository = syncNoteDataRepositoryCreateSyncNoteDataRepository;
                str2 = str3;
            } catch (Throwable th) {
                AbstractC0153k.m379h(context2, "deleteLocalNote_res");
                throw th;
            }
        } else {
            notesDocumentEntity = null;
            str2 = null;
            syncNoteDataRepository = null;
        }
        if (notesDocumentEntity != null) {
            NotesDocumentEntity notesDocumentEntity2 = notesDocumentEntity;
            if ((syncNoteDataRepository != null ? syncNoteDataRepository.getConflictStrategy(str2) : 0) == 2) {
                new C0065f(this.f237a, this.f238b, this.f239c, null, this.f241e).m153a(str, 0L);
                AbstractC0153k.m379h(context2, "deleteLocalNote_res");
                return;
            }
            if (notesDocumentEntity2.getIsDeleted() == 1) {
                c6749r.m4885a(str3, str);
            } else {
                if (notesDocumentEntity2.getIsDeleted() == 0) {
                    recycleBinTimeMoved = System.currentTimeMillis();
                    Debugger.m8615i("SyncNote/SyncSDocxTrashDeletedLocalNote", "recycleBinMovedTime = " + recycleBinTimeMoved + " as the current device time");
                } else {
                    recycleBinTimeMoved = notesDocumentEntity2.getRecycleBinTimeMoved();
                    Debugger.m8615i("SyncNote/SyncSDocxTrashDeletedLocalNote", "recycleBinMovedTime = " + recycleBinTimeMoved + " as the previous time");
                }
                long j = recycleBinTimeMoved;
                if (TextUtils.isEmpty(folderNodeItem.restorePath)) {
                    Debugger.m8609e("SyncNote/SyncSDocxTrashDeletedLocalNote", "restorePath from the server is NULL!");
                    if (TextUtils.isEmpty(notesDocumentEntity2.getAbsolutePath())) {
                        Debugger.m8609e("SyncNote/SyncSDocxTrashDeletedLocalNote", "restorePath from the local is also NULL!");
                        path = PredefinedCategory.UNCATEGORIZED.getPath();
                    } else {
                        path = notesDocumentEntity2.getAbsolutePath();
                    }
                } else {
                    path = folderNodeItem.restorePath;
                }
                String str4 = path;
                if (syncNoteDataRepository != null && syncNoteDataRepository.isConflicted(str2) == 1) {
                    Debugger.m8615i("SyncNote/SyncSDocxTrashDeletedLocalNote", "conflicted note " + str3 + " is a deleted state remotely and so clear the sync info!");
                    c6749r.f4134b.resetDeletedNoteInServer(str3);
                }
                c0077c.f266i.m4889e(this.f241e, folderNodeItem.parentFolderNodeId, 0, folderNodeItem.syncModifiedTime, j, FolderNodeItem.SYNC_WDOC_FOLDER_NODE_STATE_TRASHED, str4);
                if (notesDocumentEntity2.getIsDirty() == 1) {
                    c6749r.m4888d(0, str3);
                }
                c6749r.f4134b.trashDeletedNoteInServer(str3, folderNodeItem.syncModifiedTime);
                c6749r.f4136d.m15037k(str3);
                if (((syncNoteDataRepository != null ? syncNoteDataRepository.getNoteSyncState(str2) : 0L) & 32768) == 32768) {
                    Context applicationContext = BaseUtils.getApplicationContext();
                    NotesDataRepositoryFactory.newInstance(applicationContext).createDocumentDataRepository();
                    SyncNoteDataRepository syncNoteDataRepositoryCreateSyncNoteDataRepository2 = NotesDataRepositoryFactory.newInstance(applicationContext).createSyncNoteDataRepository();
                    NotesDataRepositoryFactory.newInstance(applicationContext).createDocumentTempDataRepository();
                    NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
                    syncNoteDataRepositoryCreateSyncNoteDataRepository2.removeNoteSyncStateFlag(str3, 32768L);
                }
                C0145c.m302J("SyncControlLowVersionNote", str3);
                SyncState.addDontSyncNewNote(str3, folderNodeItem.syncModifiedTime);
                C6742k.m4841o().m4855l(str3);
            }
        }
        AbstractC0153k.m379h(context2, "deleteLocalNote_res");
    }
}
