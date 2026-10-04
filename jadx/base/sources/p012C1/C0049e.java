package p012C1;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.p135db.C6734c;
import com.samsung.android.app.notes.sync.p135db.C6735d;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.app.notes.sync.p135db.C6748q;
import com.samsung.android.app.notes.sync.p135db.C6749r;
import com.samsung.android.app.notes.sync.synchronization.managers.C6903f;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.DocumentCategoryTree;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import com.samsung.android.support.senl.p148nt.data.database.core.schema.SyncDBSchema;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncCategoryTreeDao;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncDocumentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.DocSyncEntry;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.SyncCategoryTreeInfo;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.category.FolderTimeUtils;
import com.samsung.android.support.senl.p148nt.data.repository.category.SoftParentFolderChecker;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p001A.AbstractC0000a;
import p004A2.RunnableC0015b;
import p007B0.C0021d;
import p022E1.C0077c;
import p022E1.C0082h;
import p026F1.C0097a;
import p042J1.AbstractC0153k;
import p042J1.C0145c;
import p042J1.C0152j;
import p044K.C0158a;
import p079T.AbstractC0299q;
import p086V.C0322h;
import p186h1.C12020a;
import p206n0.C13533a;
import p253w1.InterfaceC14510a;
import p255x1.C14512a;

/* JADX INFO: renamed from: C1.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0049e {

    /* JADX INFO: renamed from: a */
    public final C0077c f205a;

    /* JADX INFO: renamed from: b */
    public final C0082h f206b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC14510a f207c;

    /* JADX INFO: renamed from: d */
    public final ArrayList f208d = new ArrayList();

    public C0049e(C0077c c0077c, C0082h c0082h, InterfaceC14510a interfaceC14510a) {
        this.f205a = c0077c;
        this.f206b = c0082h;
        this.f207c = interfaceC14510a;
    }

    /* JADX INFO: renamed from: g */
    public static void m83g(HashMap map, FolderNodeItem folderNodeItem) {
        if ("root".equals(folderNodeItem.parentFolderNodeId)) {
            return;
        }
        long j = folderNodeItem.syncModifiedTime;
        String str = folderNodeItem.parentFolderNodeId;
        FolderNodeItem folderNodeItem2 = (FolderNodeItem) map.get(str);
        if (folderNodeItem2 != null) {
            if (j > folderNodeItem2.syncModifiedTime) {
                folderNodeItem2.syncModifiedTime = j;
            }
            m83g(map, folderNodeItem2);
            return;
        }
        folderNodeItem.parentFolderNodeId = "root";
        if ("folder".equals(folderNodeItem.type)) {
            StringBuilder sbM15l = AbstractC0000a.m15l("repairSyncModifiedTimeOfFolderNodes() : There is no parent ", str, " of the folder ");
            sbM15l.append(folderNodeItem.uUid);
            Debugger.m8612ef("SyncFolder", sbM15l.toString());
        } else {
            StringBuilder sbM15l2 = AbstractC0000a.m15l("repairSyncModifiedTimeOfFolderNodes() : There is no parent ", str, " of the note ");
            sbM15l2.append(folderNodeItem.uUid);
            Debugger.m8612ef("SyncFolder", sbM15l2.toString());
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m84a(HashMap map, FolderNodeItem folderNodeItem) {
        if ("root".equals(folderNodeItem.parentFolderNodeId)) {
            return;
        }
        String str = folderNodeItem.parentFolderNodeId;
        if (map.containsKey(str)) {
            return;
        }
        C0077c c0077c = this.f205a;
        HashMap map2 = c0077c.f269l;
        Context context = c0077c.f262e;
        NotesCategoryTreeEntity entity = (NotesCategoryTreeEntity) map2.get(str);
        if (entity == null) {
            context.getApplicationContext();
            NotesDatabase notesDatabaseManager = NotesDatabaseManager.getInstance();
            SyncCategoryTreeDao syncCategoryTreeDao = notesDatabaseManager.getSyncCategoryTreeDao();
            notesDatabaseManager.getSyncDocumentDao();
            new SyncNoteDataRepository();
            new SoftParentFolderChecker(notesDatabaseManager.getCategoryTreeClosureDao());
            Debugger.m8607d("SyncCategoryTreeRepository", "getEntity " + str);
            entity = syncCategoryTreeDao.getEntity(str);
        }
        if (entity != null) {
            new C13533a(context);
            FolderNodeItem folderNodeItemM4826b = C6735d.m4826b(entity);
            map.put(folderNodeItemM4826b.uUid, folderNodeItemM4826b);
            m84a(map, folderNodeItemM4826b);
            return;
        }
        folderNodeItem.parentFolderNodeId = "root";
        if ("folder".equals(folderNodeItem.type)) {
            StringBuilder sbM15l = AbstractC0000a.m15l("addIgnoredFolderNode() : There is no parent ", str, " of the folder ");
            sbM15l.append(folderNodeItem.uUid);
            Debugger.m8612ef("SyncFolder", sbM15l.toString());
        } else {
            StringBuilder sbM15l2 = AbstractC0000a.m15l("addIgnoredFolderNode() : There is no parent ", str, " of the note ");
            sbM15l2.append(folderNodeItem.uUid);
            Debugger.m8612ef("SyncFolder", sbM15l2.toString());
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m85b(DocSyncEntry docSyncEntry, SyncCategoryTreeInfo syncCategoryTreeInfo, boolean z, int i, long j) {
        long jLongValue = docSyncEntry.getCategoryServerTimeStamp().longValue();
        C0077c c0077c = this.f205a;
        if (i == 2) {
            if (j >= jLongValue) {
                Debugger.m8612ef("SyncFolder", "handleNoteIsNormalAndFolderExists, normal but parent is trashed, uuid : " + docSyncEntry.getUuid());
                C6749r c6749r = c0077c.f266i;
                String uuid = docSyncEntry.getUuid();
                String uuid2 = syncCategoryTreeInfo.getUUID();
                long jLongValue2 = docSyncEntry.getCategoryServerTimeStamp().longValue();
                docSyncEntry.getLastModifiedAt();
                c6749r.m4889e(uuid, uuid2, 1, jLongValue2, syncCategoryTreeInfo.getRecycle_bin_time_moved(), FolderNodeItem.SYNC_WDOC_FOLDER_NODE_STATE_TRASHED, "");
                return;
            }
            return;
        }
        if (i != 1) {
            if (z) {
                Debugger.m8609e("SyncFolder", "handleNoteIsNormalAndFolderExists, normal but parent exists only in a server, uuid : " + docSyncEntry.getUuid());
                return;
            }
            return;
        }
        if (j >= jLongValue) {
            Debugger.m8614f("SyncFolder", "handleNoteIsNormalAndFolderExists, deleted uuid : " + docSyncEntry.getUuid());
            c0077c.f266i.m4886b(5, docSyncEntry.getUuid(), "handleNoteIsNormalAndFolderExists");
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m86c(DocSyncEntry docSyncEntry, String str, boolean z, int i, long j) {
        long jLongValue = docSyncEntry.getCategoryServerTimeStamp().longValue();
        C0077c c0077c = this.f205a;
        if (i == 0) {
            if (j >= jLongValue) {
                StringBuilder sbM3200j = AbstractC4539a.m3200j("handleNoteIsTrashedAndFolderExists, trashed -> normal, isServerOnly = ", ", uuid : ", z);
                sbM3200j.append(docSyncEntry.getUuid());
                Debugger.m8614f("SyncFolder", sbM3200j.toString());
                C6749r c6749r = c0077c.f266i;
                String uuid = docSyncEntry.getUuid();
                long jLongValue2 = docSyncEntry.getCategoryServerTimeStamp().longValue();
                docSyncEntry.getLastModifiedAt();
                c6749r.m4889e(uuid, str, 1, jLongValue2, 0L, FolderNodeItem.SYNC_WDOC_FOLDER_NODE_STATE_NORMAL, "");
                return;
            }
            return;
        }
        if (i == 1) {
            if (j >= jLongValue) {
                Debugger.m8614f("SyncFolder", "handleNoteIsTrashedAndFolderExists, deleted uuid : " + docSyncEntry.getUuid());
            } else {
                Debugger.m8614f("SyncFolder", "handleNoteIsTrashedAndFolderExists, deleted uuid : " + docSyncEntry.getUuid() + "serverTimeStampOfFolder = " + j + ", serverTimeStampOfNote = " + jLongValue);
            }
            c0077c.f266i.m4886b(5, docSyncEntry.getUuid(), "handleNoteIsTrashedAndFolderExists");
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m87d(SyncException syncException) throws SyncException {
        String str;
        C0077c c0077c = this.f205a;
        if (AbstractC0153k.m373b(c0077c.f262e)) {
            Context context = c0077c.f262e;
            if (AbstractC0153k.m373b(context)) {
                C0152j c0152jM378g = AbstractC0153k.m378g();
                c0152jM378g.f455d = Log.getStackTraceString(syncException);
                c0152jM378g.f463l = true;
                c0152jM378g.f454c = "error";
                c0152jM378g.m371b(context);
            }
        }
        if (syncException.getExceptionCode() == 327) {
            Debugger.m8613ef("SyncFolder", "handleSyncError: ", syncException);
            return;
        }
        if (syncException.getExceptionCode() == 326) {
            Debugger.m8610e("SyncFolder", "handleSyncError: ", syncException);
            return;
        }
        if (syncException.getExceptionCode() != 315) {
            throw syncException;
        }
        String str2 = "eyJ2ZXJzaW9uIjowLCJlbmNyeXB0ZWRHdWlkIjoiIiwicmVxdWVzdFRpbWVTdGFtcCI6MCwibW9kaWZpZWRUaW1lIjowLCJhcHBWZXJzaW9uIjoiMCIsInNka1ZlcnNpb24iOiIwIiwicHVycG9zZSI6IklOSVRJQUwiLCJ0eXBlIjoiRk9MREVSIn0=";
        if (syncException.getStatusCode() != 400) {
            if (syncException.getStatusCode() == 405) {
                Debugger.m8612ef("SyncFolder", "handle Server error, statusCode = " + syncException.getStatusCode() + ", msg = " + syncException.getMessage());
                return;
            }
            if (syncException.getStatusCode() != 409) {
                throw syncException;
            }
            Debugger.m8612ef("SyncFolder", "handle Server error, statusCode = " + syncException.getStatusCode() + ", msg = " + syncException.getMessage());
            c0077c.f272o = "eyJ2ZXJzaW9uIjowLCJlbmNyeXB0ZWRHdWlkIjoiIiwicmVxdWVzdFRpbWVTdGFtcCI6MCwibW9kaWZpZWRUaW1lIjowLCJhcHBWZXJzaW9uIjoiMCIsInNka1ZlcnNpb24iOiIwIiwicHVycG9zZSI6IklOSVRJQUwiLCJ0eXBlIjoiRk9MREVSIn0=";
            return;
        }
        Debugger.m8612ef("SyncFolder", "handle Server error, statusCode = " + syncException.getStatusCode() + ", msg = " + syncException.getMessage());
        C0077c c0077c2 = this.f206b.f286b;
        Context context2 = c0077c2.f262e;
        C6749r c6749r = c0077c2.f266i;
        HashMap mapM4830a = new C6735d(context2).m4830a();
        Iterator it = mapM4830a.values().iterator();
        while (it.hasNext()) {
            FolderNodeItem folderNodeItem = (FolderNodeItem) it.next();
            String str3 = folderNodeItem.parentFolderNodeId;
            String str4 = folderNodeItem.uUid;
            PredefinedCategory predefinedCategory = PredefinedCategory.UNCATEGORIZED;
            Context context3 = context2;
            Iterator it2 = it;
            C0077c c0077c3 = c0077c;
            if (predefinedCategory.getUuid().equals(str3) && FolderNodeItem.SYNC_WDOC_FOLDER_NODE_STATE_TRASHED.equals(folderNodeItem.state)) {
                StringBuilder sb = new StringBuilder("repairFoldersAndNotes() : folder ");
                sb.append(str4);
                str = str2;
                sb.append(" is deleted correctly?");
                Debugger.m8609e("SyncProcessTask$SyncOperationSDocx", sb.toString());
            } else {
                str = str2;
            }
            if (!str3.equals("root")) {
                FolderNodeItem folderNodeItem2 = (FolderNodeItem) mapM4830a.get(str3);
                if (folderNodeItem2 == null) {
                    if (FolderNodeItem.SYNC_WDOC_FOLDER_NODE_STATE_NORMAL.equals(folderNodeItem.state)) {
                        Debugger.m8612ef("SyncProcessTask$SyncOperationSDocx", "repairFoldersAndNotes() : folder " + str4 + " -> no parentId = " + str3);
                        C12020a c12020a = c0077c2.f268k;
                        String uuid = predefinedCategory.getUuid();
                        long j = folderNodeItem.syncModifiedTime + 1;
                        C13533a c13533a = (C13533a) c12020a.f8772b;
                        SoftParentFolderChecker softParentFolderChecker = c13533a.f9555d;
                        softParentFolderChecker.checkInvalidRelationShip(str4, uuid);
                        c13533a.f9553b.updateParentFolder(str4, uuid, j, 1);
                        softParentFolderChecker.checkInvalidRelationShip(str4, uuid);
                        SyncCategoryTreeDao syncCategoryTreeDao = c13533a.f9553b;
                        syncCategoryTreeDao.deleteMovingCategory(str4);
                        syncCategoryTreeDao.moveToParent(str4, uuid);
                    } else if (FolderNodeItem.SYNC_WDOC_FOLDER_NODE_STATE_TRASHED.equals(folderNodeItem.state)) {
                        Debugger.m8612ef("SyncProcessTask$SyncOperationSDocx", "repairFoldersAndNotes() : trashed folder " + str4 + " -> no parentId = " + str3);
                    }
                } else if (folderNodeItem2.syncModifiedTime < folderNodeItem.syncModifiedTime) {
                    Debugger.m8609e("SyncProcessTask$SyncOperationSDocx", "repairFoldersAndNotes() : folder " + str4 + " is later than " + str3);
                    context3.getApplicationContext();
                    NotesDatabase notesDatabaseManager = NotesDatabaseManager.getInstance();
                    SyncCategoryTreeDao syncCategoryTreeDao2 = notesDatabaseManager.getSyncCategoryTreeDao();
                    notesDatabaseManager.getSyncDocumentDao();
                    new SyncNoteDataRepository();
                    new SoftParentFolderChecker(notesDatabaseManager.getCategoryTreeClosureDao());
                    String str5 = folderNodeItem.uUid;
                    long j2 = folderNodeItem.syncModifiedTime;
                    Debugger.m8615i("SyncCategoryTreeRepository", "repairFolderTime, folderUuid : " + str5);
                    FolderTimeUtils.updateServerTimeUpward(syncCategoryTreeDao2, syncCategoryTreeDao2.getEntity(str5), j2);
                }
            }
            context2 = context3;
            it = it2;
            c0077c = c0077c3;
            str2 = str;
        }
        C0077c c0077c4 = c0077c;
        Context context4 = context2;
        String str6 = str2;
        for (NotesDocumentEntity notesDocumentEntity : new SyncNoteDataRepository().dumpDocument()) {
            String categoryUuid = notesDocumentEntity.getCategoryUuid();
            String uuid2 = notesDocumentEntity.getUuid();
            if (!notesDocumentEntity.getFilePath().endsWith(".sdoc") && !C6735d.m4828d(categoryUuid)) {
                FolderNodeItem folderNodeItem3 = (FolderNodeItem) mapM4830a.get(categoryUuid);
                if (folderNodeItem3 != null) {
                    if (FolderNodeItem.SYNC_WDOC_FOLDER_NODE_STATE_NORMAL.equals(folderNodeItem3.state) && notesDocumentEntity.getIsDeleted() == 2) {
                        Debugger.m8612ef("SyncProcessTask$SyncOperationSDocx", "repairFoldersAndNotes() : [3]trashed note " + uuid2 + " is set to normal!");
                        c6749r.f4134b.setNoteDeleted(uuid2, 0);
                    }
                    if (folderNodeItem3.syncModifiedTime < notesDocumentEntity.getCategoryServerTimeStamp().longValue()) {
                        Debugger.m8612ef("SyncProcessTask$SyncOperationSDocx", "repairFoldersAndNotes() : [4]note " + uuid2 + " is later than " + categoryUuid);
                        context4.getApplicationContext();
                        NotesDatabase notesDatabaseManager2 = NotesDatabaseManager.getInstance();
                        SyncCategoryTreeDao syncCategoryTreeDao3 = notesDatabaseManager2.getSyncCategoryTreeDao();
                        notesDatabaseManager2.getSyncDocumentDao();
                        new SyncNoteDataRepository();
                        new SoftParentFolderChecker(notesDatabaseManager2.getCategoryTreeClosureDao());
                        String str7 = folderNodeItem3.uUid;
                        long jLongValue = notesDocumentEntity.getCategoryServerTimeStamp().longValue();
                        Debugger.m8615i("SyncCategoryTreeRepository", "repairFolderTime, folderUuid : " + str7);
                        FolderTimeUtils.updateServerTimeUpward(syncCategoryTreeDao3, syncCategoryTreeDao3.getEntity(str7), jLongValue);
                    }
                } else if (notesDocumentEntity.getIsDeleted() == 1) {
                    if (notesDocumentEntity.getIsDirty() == 0) {
                        c6749r.m4886b(5, uuid2, "[1]repairFoldersAndNotes");
                    }
                } else if (notesDocumentEntity.getIsDeleted() == 0) {
                    Debugger.m8612ef("SyncProcessTask$SyncOperationSDocx", "repairFoldersAndNotes() : [2]normal note " + uuid2 + " -> no parentId = " + categoryUuid);
                    C6749r c6749r2 = c0077c2.f266i;
                    String uuid3 = PredefinedCategory.UNCATEGORIZED.getUuid();
                    long jLongValue2 = notesDocumentEntity.getServerTimestamp().longValue();
                    notesDocumentEntity.getLastModifiedAt();
                    c6749r2.m4889e(uuid2, uuid3, 1, jLongValue2, 0L, FolderNodeItem.SYNC_WDOC_FOLDER_NODE_STATE_NORMAL, "");
                }
            }
        }
        c0077c4.f272o = str6;
        AbstractC0299q.m621c("b");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e6  */
    /* JADX INFO: renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m88e() {
        C6903f c6903f;
        C0082h c0082h;
        InterfaceC14510a interfaceC14510a;
        C6903f c6903f2;
        C6742k c6742kM15111b;
        C6742k c6742k;
        C0049e c0049e;
        String str;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        HashMap map;
        C0021d c0021d;
        String str2;
        C0049e c0049e2;
        NotesDocumentEntity notesDocumentEntityM9f;
        Iterator it;
        int isDeleted;
        C6903f c6903f3;
        String absolutePath;
        C0077c c0077c = this.f205a;
        Context context = c0077c.f262e;
        C6903f c6903f4 = c0077c.f265h;
        Context context2 = c0077c.f262e;
        AbstractC0153k.m373b(context);
        C0082h c0082h2 = this.f206b;
        InterfaceC14510a interfaceC14510a2 = this.f207c;
        c0082h2.m219f(interfaceC14510a2, "downSyncServerChanges");
        if (C0145c.m323h("sync_v2_pref", "repairOldNoteAfterAppUpdate2", false)) {
            c6903f = c6903f4;
            c0082h = c0082h2;
            interfaceC14510a = interfaceC14510a2;
        } else {
            Debugger.m8615i("SyncFolder", "repairOldNote()");
            List uUIDList = C0322h.m670a().f831q.getUUIDList(context2);
            if (!uUIDList.isEmpty()) {
                SyncNoteDataRepository syncNoteDataRepositoryCreateSyncNoteDataRepository = NotesDataRepositoryFactory.newInstance(context2).createSyncNoteDataRepository();
                NotesDatabaseManager.getInstance().getSyncInfoDao();
                DocumentCategoryTree allDocumentCategoryTree = NotesDataRepositoryFactory.newInstance(context2).createDocumentCategoryTreeRepository().getAllDocumentCategoryTree(false);
                Iterator it2 = uUIDList.iterator();
                while (it2.hasNext()) {
                    String str3 = (String) it2.next();
                    NotesDocumentEntity notesDocumentEntity = (str3 != null ? new C6748q(context2, str3) : null).f4128a;
                    String categoryUuid = notesDocumentEntity != null ? notesDocumentEntity.getCategoryUuid() : "";
                    if (notesDocumentEntity != null) {
                        it = it2;
                        isDeleted = "trash:///".equals(notesDocumentEntity.getCategoryUuid()) ? notesDocumentEntity.getIsDeleted() : 0;
                        C0082h c0082h3 = c0082h2;
                        InterfaceC14510a interfaceC14510a3 = interfaceC14510a2;
                        if (isDeleted != 0) {
                            if ("UUID_UNCATEGORIZED".equals(categoryUuid) || "old:///".equals(categoryUuid) || "uncategorized:///".equals(categoryUuid) || allDocumentCategoryTree.getFolder(categoryUuid) == null) {
                                Debugger.m8614f("SyncFolder", AbstractC0541b.m775q("repairOldNote() : Folder ", categoryUuid, " of doc ", str3, " is set to OldUncategorized"));
                                syncNoteDataRepositoryCreateSyncNoteDataRepository.updateNoteCategory(str3, "1");
                            }
                            c6903f3 = c6903f4;
                        } else {
                            if (notesDocumentEntity != null) {
                                c6903f3 = c6903f4;
                                absolutePath = notesDocumentEntity.getAbsolutePath();
                            } else {
                                c6903f3 = c6903f4;
                                absolutePath = "";
                            }
                            if ("uncategorized:///".equals(absolutePath)) {
                                Debugger.m8614f("SyncFolder", AbstractC0541b.m776r(new StringBuilder("repairOldNote() : path "), notesDocumentEntity != null ? notesDocumentEntity.getAbsolutePath() : "", " of doc ", str3, " is set to OldUncategorized"));
                                syncNoteDataRepositoryCreateSyncNoteDataRepository.updateAbsolutePath(str3, "1");
                            }
                            if (allDocumentCategoryTree.getFolder(categoryUuid) == null) {
                                Debugger.m8614f("SyncFolder", AbstractC0541b.m775q("repairOldNote() : Folder ", categoryUuid, " of doc ", str3, " is set to trash"));
                                syncNoteDataRepositoryCreateSyncNoteDataRepository.updateNoteCategory(str3, "trash:///");
                            }
                        }
                        it2 = it;
                        c6903f4 = c6903f3;
                        c0082h2 = c0082h3;
                        interfaceC14510a2 = interfaceC14510a3;
                    } else {
                        it = it2;
                    }
                    C0082h c0082h32 = c0082h2;
                    InterfaceC14510a interfaceC14510a32 = interfaceC14510a2;
                    if (isDeleted != 0) {
                    }
                    it2 = it;
                    c6903f4 = c6903f3;
                    c0082h2 = c0082h32;
                    interfaceC14510a2 = interfaceC14510a32;
                }
            }
            c6903f = c6903f4;
            c0082h = c0082h2;
            interfaceC14510a = interfaceC14510a2;
            C0145c.m304L("sync_v2_pref", "repairOldNoteAfterAppUpdate2", true);
        }
        AbstractC0153k.m374c("SyncFolder", "Folder (downSync)");
        AbstractC0153k.m381j(context2, "downSync");
        C0097a c0097a = new C0097a();
        if (!"eyJ2ZXJzaW9uIjowLCJlbmNyeXB0ZWRHdWlkIjoiIiwicmVxdWVzdFRpbWVTdGFtcCI6MCwibW9kaWZpZWRUaW1lIjowLCJhcHBWZXJzaW9uIjoiMCIsInNka1ZlcnNpb24iOiIwIiwicHVycG9zZSI6IklOSVRJQUwiLCJ0eXBlIjoiRk9MREVSIn0=".equals(C0145c.m331p("sync_v2_pref", "folderLastChangePoint", "eyJ2ZXJzaW9uIjowLCJlbmNyeXB0ZWRHdWlkIjoiIiwicmVxdWVzdFRpbWVTdGFtcCI6MCwibW9kaWZpZWRUaW1lIjowLCJhcHBWZXJzaW9uIjoiMCIsInNka1ZlcnNpb24iOiIwIiwicHVycG9zZSI6IklOSVRJQUwiLCJ0eXBlIjoiRk9MREVSIn0=")) && !C0145c.m323h("sync_v2_pref", "repairTrashedNoteAfterAppUpdate", false)) {
            c0077c.f272o = "eyJ2ZXJzaW9uIjowLCJlbmNyeXB0ZWRHdWlkIjoiIiwicmVxdWVzdFRpbWVTdGFtcCI6MCwibW9kaWZpZWRUaW1lIjowLCJhcHBWZXJzaW9uIjoiMCIsInNka1ZlcnNpb24iOiIwIiwicHVycG9zZSI6IklOSVRJQUwiLCJ0eXBlIjoiRk9MREVSIn0=";
        }
        try {
            c6903f2 = c6903f;
        } catch (SyncException e) {
            e = e;
            c6903f2 = c6903f;
        }
        try {
            c6742kM15111b = new C14512a(c6903f2, context2, c0097a, C0145c.m331p("sync_v2_pref", "folderLastChangePoint", "eyJ2ZXJzaW9uIjowLCJlbmNyeXB0ZWRHdWlkIjoiIiwicmVxdWVzdFRpbWVTdGFtcCI6MCwibW9kaWZpZWRUaW1lIjowLCJhcHBWZXJzaW9uIjoiMCIsInNka1ZlcnNpb24iOiIwIiwicHVycG9zZSI6IklOSVRJQUwiLCJ0eXBlIjoiRk9MREVSIn0=")).m15111b();
        } catch (SyncException e2) {
            e = e2;
            if (e.getStatusCode() != 403) {
                throw e;
            }
            c0082h.m221h();
            c6742kM15111b = new C14512a(c6903f2, context2, c0097a, C0145c.m331p("sync_v2_pref", "folderLastChangePoint", "eyJ2ZXJzaW9uIjowLCJlbmNyeXB0ZWRHdWlkIjoiIiwicmVxdWVzdFRpbWVTdGFtcCI6MCwibW9kaWZpZWRUaW1lIjowLCJhcHBWZXJzaW9uIjoiMCIsInNka1ZlcnNpb24iOiIwIiwicHVycG9zZSI6IklOSVRJQUwiLCJ0eXBlIjoiRk9MREVSIn0=")).m15111b();
        }
        if (((C0021d) c6742kM15111b.f4111c) == null) {
            Debugger.m8615i("SyncFolder", "getFolderChangeFromServer() : None");
            C0152j c0152jM378g = AbstractC0153k.m378g();
            c0152jM378g.f454c = "No server folder change";
            c0152jM378g.m371b(context2);
            if (!TextUtils.isEmpty((String) c6742kM15111b.f4110b)) {
                c0077c.f272o = (String) c6742kM15111b.f4110b;
            }
            c6742k = null;
        } else {
            c0077c.f269l.clear();
            c0077c.f270m.clear();
            c6742k = c6742kM15111b;
        }
        if (c6742k == null) {
            c0049e2 = this;
            str2 = "sync_v2_pref";
            str = "SyncFolder";
        } else {
            if (AbstractC4539a.m3210t() && NotesSAConstants.DETAIL_SEARCH_INSIDE_FOLDERS_ON.equals(c0097a.f319b) && !((C0021d) c6742k.f4111c).f112a) {
                c0049e = this;
                FolderManager.getInstance().executeOperation(new CallableC0047c(c0049e, 0, c6742k, c0097a));
            } else {
                c0049e = this;
            }
            try {
                arrayList = new ArrayList();
                try {
                    arrayList2 = new ArrayList();
                    arrayList3 = new ArrayList();
                    map = new HashMap();
                    c0021d = (C0021d) c6742k.f4111c;
                    str2 = "sync_v2_pref";
                    str = "SyncFolder";
                    c0049e2 = this;
                } catch (Throwable th) {
                    th = th;
                    str = "SyncFolder";
                }
            } catch (Throwable th2) {
                th = th2;
                str = "SyncFolder";
            }
            try {
                FolderManager.getInstance().executeOperation(new RunnableC0048d(c0049e2, map, c0021d.f114c, arrayList, arrayList2, arrayList3, c0021d.f115d));
                try {
                    AbstractC0153k.m382k(context2, "getFolderChanges_res");
                } catch (Exception e3) {
                    AbstractC0000a.m21r(e3, new StringBuilder("updateFoldersAndNotesDbWithFolderChange : fail to writeDbDump = "), str);
                }
                AbstractC0153k.m381j(context2, "downSync");
                c0077c.f272o = (String) c6742k.f4110b;
            } catch (Throwable th3) {
                th = th3;
                Throwable th4 = th;
                try {
                    AbstractC0153k.m382k(context2, "getFolderChanges_res");
                    throw th4;
                } catch (Exception e5) {
                    AbstractC0000a.m21r(e5, new StringBuilder("updateFoldersAndNotesDbWithFolderChange : fail to writeDbDump = "), str);
                    throw th4;
                }
            }
        }
        c0082h.m219f(interfaceC14510a, "downSyncServerChanges!");
        String str4 = str2;
        if (!C0145c.m323h(str4, "repairTrashedFolderAfterAppUpdate", false)) {
            FolderManager.getInstance().executeOperation(new RunnableC0015b(c0049e2, 1));
        }
        if (!C0145c.m323h(str4, "repairSharedNoteAfterAppUpdate2", false)) {
            C6749r c6749r = c0077c.f266i;
            SyncNoteDataRepository syncNoteDataRepositoryCreateSyncNoteDataRepository2 = NotesDataRepositoryFactory.newInstance(context2).createSyncNoteDataRepository();
            NotesDataRepositoryFactory.newInstance(context2).createDocumentTagRepository();
            NotesDataRepositoryFactory.newInstance(context2).createNotesDocumentPageRepository();
            NotesDataRepositoryFactory.newInstance(context2).createMappedDocumentRepository();
            NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
            for (String str5 : syncNoteDataRepositoryCreateSyncNoteDataRepository2.getUuidListInvalidSharedNote()) {
                if (str5 != null) {
                    notesDocumentEntityM9f = AbstractC0000a.m9f(context2, str5);
                    AbstractC0000a.m18o(context2, context2, context2);
                } else {
                    notesDocumentEntityM9f = null;
                }
                if ((notesDocumentEntityM9f != null ? notesDocumentEntityM9f.getIsDeleted() : 1) == 0) {
                    if (UUIDUtils.isCoeditUuid(str5)) {
                        Debugger.m8614f(str, "repairCoeditNote() : uuid = " + str5 + " to coedit:///");
                        c6749r.f4134b.setNoteFolder(str5, "coedit:///");
                    } else {
                        Debugger.m8614f(str, "repairSharedNote() : uuid = " + str5 + " to shared:///");
                        c6749r.f4134b.setNoteFolder(str5, "shared:///");
                    }
                }
            }
            C0145c.m304L(str4, "repairSharedNoteAfterAppUpdate2", true);
        }
        C0158a.m407a().getClass();
        if (!C0158a.m410f()) {
            AbstractC0153k.m374c(str, "Folder (upSync)");
            AbstractC0153k.m381j(context2, SyncDBSchema.SyncDelayInfo.UP_SYNC);
            if (C0145c.m323h("pref_sync_logging", "pref_sync_number_of_deleted_notes_reported", false)) {
                C0145c.m304L("pref_sync_logging", "pref_sync_number_of_deleted_notes_reported", false);
                Context applicationContext = BaseUtils.getApplicationContext();
                if (applicationContext == null) {
                    Debugger.m8609e("SyncSALoggingHelper", "handleEventId5043() : appContext is null!");
                } else {
                    SyncNoteDataRepository syncNoteDataRepositoryCreateSyncNoteDataRepository3 = NotesDataRepositoryFactory.newInstance(applicationContext).createSyncNoteDataRepository();
                    NotesDataRepositoryFactory.newInstance(applicationContext).createDocumentTagRepository();
                    NotesDataRepositoryFactory.newInstance(applicationContext).createNotesDocumentPageRepository();
                    NotesDataRepositoryFactory.newInstance(applicationContext).createMappedDocumentRepository();
                    NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
                    int i = 0;
                    for (NotesDocumentEntity notesDocumentEntity2 : syncNoteDataRepositoryCreateSyncNoteDataRepository3.getIsDirtyList(1)) {
                        if (notesDocumentEntity2.isSdocx()) {
                            String uuid = notesDocumentEntity2.getUuid();
                            if (!"coedit:///".equals(notesDocumentEntity2.getCategoryUuid()) && !UUIDUtils.isCoeditUuid(uuid)) {
                                if (notesDocumentEntity2.getIsDeleted() == 1) {
                                    i++;
                                }
                            }
                        }
                    }
                    AbstractC0299q.m604N("5043", Integer.toString(i));
                }
            }
            FolderManager.getInstance().executeOperation(new CallableC0046b(c0049e2, 0));
        }
        AbstractC0153k.m373b(context2);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0156  */
    /* JADX INFO: renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m89f(ArrayList arrayList) {
        SyncCategoryTreeInfo syncCategoryTreeInfoM14279a;
        C0077c c0077c = this.f205a;
        C13533a c13533a = (C13533a) c0077c.f268k.f8772b;
        c13533a.getClass();
        Debugger.m8615i("SyncCategoryTreeRepository", "mergeFolderBySync ");
        SyncDocumentDao syncDocumentDao = c13533a.f9554c;
        SyncCategoryTreeDao syncCategoryTreeDao = c13533a.f9553b;
        HashMap map = new HashMap();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            NotesCategoryTreeEntity notesCategoryTreeEntity = (NotesCategoryTreeEntity) it.next();
            NotesCategoryTreeEntity entityByParentUuidAndName = syncCategoryTreeDao.getEntityByParentUuidAndName(notesCategoryTreeEntity.getParentUuid(), notesCategoryTreeEntity.getUuid(), notesCategoryTreeEntity.getDisplayName());
            if (entityByParentUuidAndName != null) {
                DocumentCategoryTree allDocumentCategoryTree = syncCategoryTreeDao.getAllDocumentCategoryTree(false);
                if (notesCategoryTreeEntity.getServerTimeStamp().longValue() > entityByParentUuidAndName.getServerTimeStamp().longValue()) {
                    NotesFolder folder = allDocumentCategoryTree.getFolder(notesCategoryTreeEntity.getUuid());
                    NotesFolder folder2 = allDocumentCategoryTree.getFolder(entityByParentUuidAndName.getUuid());
                    if (folder == null) {
                        Debugger.m8612ef("SyncCategoryTreeRepository", "mergeFolderBySync() : fail to get targetFolder " + notesCategoryTreeEntity.getUuid());
                    } else {
                        c13533a.m14281c(allDocumentCategoryTree, folder2, folder);
                        c13533a.m14280b(syncDocumentDao, allDocumentCategoryTree, folder, folder2, map);
                    }
                } else {
                    NotesFolder folder3 = allDocumentCategoryTree.getFolder(entityByParentUuidAndName.getUuid());
                    NotesFolder folder4 = allDocumentCategoryTree.getFolder(notesCategoryTreeEntity.getUuid());
                    if (folder3 == null) {
                        Debugger.m8612ef("SyncCategoryTreeRepository", "mergeFolderBySync() : fail to get targetFolder " + notesCategoryTreeEntity.getUuid());
                    } else {
                        c13533a.m14281c(allDocumentCategoryTree, folder4, folder3);
                        c13533a.m14280b(syncDocumentDao, allDocumentCategoryTree, folder3, folder4, map);
                        map.put(notesCategoryTreeEntity.getUuid(), entityByParentUuidAndName.getUuid());
                    }
                }
            }
        }
        if (map.isEmpty()) {
            return;
        }
        HashMap map2 = c0077c.f270m;
        if (map2.isEmpty()) {
            return;
        }
        for (Map.Entry entry : map2.entrySet()) {
            String str = (String) entry.getKey();
            FolderNodeItem folderNodeItem = (FolderNodeItem) entry.getValue();
            String str2 = (String) map.get(folderNodeItem.parentFolderNodeId);
            C13533a c13533a2 = new C13533a(c0077c.f262e);
            if (!TextUtils.isEmpty(str2)) {
                folderNodeItem.parentFolderNodeId = str2;
                SyncCategoryTreeInfo syncCategoryTreeInfoM14279a2 = c13533a2.m14279a(str2);
                folderNodeItem.syncModifiedTime = syncCategoryTreeInfoM14279a2 != null ? syncCategoryTreeInfoM14279a2.getServerTimestamp() : -1L;
                if (syncCategoryTreeInfoM14279a2 == null) {
                    syncCategoryTreeInfoM14279a2 = c13533a2.m14279a(str2);
                } else {
                    if (!str2.equals(syncCategoryTreeInfoM14279a2.getUUID())) {
                        syncCategoryTreeInfoM14279a = syncCategoryTreeInfoM14279a2;
                        syncCategoryTreeInfoM14279a2 = c13533a2.m14279a(str2);
                    }
                    folderNodeItem.lastModifiedTime = syncCategoryTreeInfoM14279a2 == null ? syncCategoryTreeInfoM14279a2.getLastModifiedAt() : -1L;
                    if (syncCategoryTreeInfoM14279a != null || !str2.equals(syncCategoryTreeInfoM14279a.getUUID())) {
                    }
                    folderNodeItem.recycleBinMovedTime = syncCategoryTreeInfoM14279a != null ? syncCategoryTreeInfoM14279a.getRecycle_bin_time_moved() : -1L;
                }
                syncCategoryTreeInfoM14279a = syncCategoryTreeInfoM14279a2;
                folderNodeItem.lastModifiedTime = syncCategoryTreeInfoM14279a2 == null ? syncCategoryTreeInfoM14279a2.getLastModifiedAt() : -1L;
                syncCategoryTreeInfoM14279a = syncCategoryTreeInfoM14279a != null ? c13533a2.m14279a(str2) : c13533a2.m14279a(str2);
                folderNodeItem.recycleBinMovedTime = syncCategoryTreeInfoM14279a != null ? syncCategoryTreeInfoM14279a.getRecycle_bin_time_moved() : -1L;
            }
            map2.put(str, folderNodeItem);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0114  */
    /* JADX INFO: renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m90h(ArrayList arrayList) {
        SyncCategoryTreeInfo syncCategoryTreeInfo;
        NotesDocumentEntity notesDocumentEntityM9f;
        ArrayList arrayList2 = new ArrayList();
        C0077c c0077c = this.f205a;
        Context context = c0077c.f262e;
        C12020a c12020a = c0077c.f268k;
        context.getApplicationContext();
        NotesDatabase notesDatabaseManager = NotesDatabaseManager.getInstance();
        SyncCategoryTreeDao syncCategoryTreeDao = notesDatabaseManager.getSyncCategoryTreeDao();
        notesDatabaseManager.getSyncDocumentDao();
        new SyncNoteDataRepository();
        new SoftParentFolderChecker(notesDatabaseManager.getCategoryTreeClosureDao());
        ArrayList arrayList3 = new ArrayList();
        Debugger.m8607d("SyncCategoryTreeRepository", "getDirtyList, dirtyFlag: 1");
        Iterator<NotesCategoryTreeEntity> it = syncCategoryTreeDao.getDirtyList(1).iterator();
        while (it.hasNext()) {
            arrayList3.add(it.next().getUuid());
        }
        C6734c c6734c = c0077c.f267j;
        c6734c.getClass();
        ArrayList arrayList4 = new ArrayList();
        for (NotesDocumentEntity notesDocumentEntity : c6734c.f4096a.getIsCategoryDirtyList(1, true)) {
            if (notesDocumentEntity.isSdocx()) {
                String uuid = notesDocumentEntity.getUuid();
                if (!"coedit:///".equals(notesDocumentEntity.getCategoryUuid()) && !UUIDUtils.isGenUuid(uuid)) {
                    arrayList4.add(uuid);
                }
            }
        }
        Iterator it2 = arrayList.iterator();
        SyncCategoryTreeInfo syncEntity = null;
        while (it2.hasNext()) {
            FolderNodeItem folderNodeItem = (FolderNodeItem) it2.next();
            if ("folder".equals(folderNodeItem.type)) {
                if (arrayList3.contains(folderNodeItem.uUid)) {
                    if (folderNodeItem.state.equals("deleted")) {
                        arrayList2.add(folderNodeItem.uUid);
                    } else {
                        String str = folderNodeItem.uUid;
                        if (syncEntity == null) {
                            Debugger.m8607d("SyncCategoryTreeRepository", "getSyncEntity " + str);
                            syncEntity = syncCategoryTreeDao.getSyncEntity(str);
                        } else {
                            if (!str.equals(syncEntity.getUUID())) {
                                Debugger.m8607d("SyncCategoryTreeRepository", "getSyncEntity " + str);
                                SyncCategoryTreeInfo syncCategoryTreeInfo2 = syncEntity;
                                syncEntity = syncCategoryTreeDao.getSyncEntity(str);
                                syncCategoryTreeInfo = syncCategoryTreeInfo2;
                            }
                            if ((syncEntity == null ? syncEntity.getServerTimestamp() : -1L) == folderNodeItem.syncModifiedTime) {
                                ((C13533a) c12020a.f8772b).f9553b.updateIsDirty(folderNodeItem.uUid, 0);
                            }
                            syncEntity = syncCategoryTreeInfo;
                        }
                        syncCategoryTreeInfo = syncEntity;
                        if ((syncEntity == null ? syncEntity.getServerTimestamp() : -1L) == folderNodeItem.syncModifiedTime) {
                        }
                        syncEntity = syncCategoryTreeInfo;
                    }
                }
            } else if (arrayList4.contains(folderNodeItem.uUid)) {
                Context context2 = c0077c.f262e;
                String str2 = folderNodeItem.uUid;
                if (str2 != null) {
                    notesDocumentEntityM9f = AbstractC0000a.m9f(context2, str2);
                    AbstractC0000a.m18o(context2, context2, context2);
                } else {
                    notesDocumentEntityM9f = null;
                }
                if ((notesDocumentEntityM9f != null ? notesDocumentEntityM9f.getCategoryServerTimeStamp().longValue() : -1L) == folderNodeItem.syncModifiedTime) {
                    c0077c.f266i.f4134b.updateDirtyCategory(folderNodeItem.uUid, 0);
                }
            }
        }
        c12020a.m13632K(arrayList2);
    }

    /* JADX INFO: renamed from: i */
    public final void m91i(FolderNodeItem folderNodeItem, long j) {
        this.f205a.f266i.m4889e(folderNodeItem.uUid, folderNodeItem.parentFolderNodeId, folderNodeItem.isCategoryDirty, folderNodeItem.syncModifiedTime, j, folderNodeItem.state, folderNodeItem.restorePath);
    }
}
