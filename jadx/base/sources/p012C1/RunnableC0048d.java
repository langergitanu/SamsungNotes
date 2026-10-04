package p012C1;

import android.content.Context;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.work.Configuration;
import androidx.work.WorkerParameters;
import androidx.work.impl.utils.futures.SettableFuture;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import androidx.work.multiprocess.RemoteWorkerWrapper;
import androidx.work.multiprocess.RemoteWorkerWrapperKt;
import com.samsung.android.app.notes.sync.p135db.C6732a;
import com.samsung.android.app.notes.sync.p135db.C6735d;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.app.notes.sync.p135db.C6748q;
import com.samsung.android.app.notes.sync.p135db.C6749r;
import com.samsung.android.support.senl.p148nt.base.common.TimeManager;
import com.samsung.android.support.senl.p148nt.base.common.data.DataUpdateManager;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.DocumentCategoryTree;
import com.samsung.android.support.senl.p148nt.data.database.core.document.folder.NotesFolder;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncCategoryTreeDao;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncDocumentDao;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.DocSyncEntry;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.SyncCategoryTreeInfo;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.category.SoftParentFolderChecker;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentWriteResolver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import p001A.AbstractC0000a;
import p017D1.C0069j;
import p022E1.C0077c;
import p022E1.C0082h;
import p022E1.RunnableC0080f;
import p034H1.C0113a;
import p042J1.C0145c;
import p186h1.C12020a;
import p206n0.C13533a;
import p259y0.AbstractC14517a;

/* JADX INFO: renamed from: C1.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class RunnableC0048d implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f197a = 0;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f198b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f199c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f200d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ Object f201e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ Object f202f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ Object f203g;

    /* JADX INFO: renamed from: h */
    public final /* synthetic */ Object f204h;

    public /* synthetic */ RunnableC0048d(C0049e c0049e, HashMap map, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, ArrayList arrayList5) {
        this.f198b = c0049e;
        this.f199c = map;
        this.f200d = arrayList;
        this.f202f = arrayList2;
        this.f203g = arrayList3;
        this.f204h = arrayList4;
        this.f201e = arrayList5;
    }

    /* JADX WARN: Removed duplicated region for block: B:366:0x0bde  */
    /* JADX WARN: Removed duplicated region for block: B:367:0x0be1  */
    /* JADX WARN: Removed duplicated region for block: B:381:0x0c0c  */
    /* JADX WARN: Removed duplicated region for block: B:385:0x0c35  */
    /* JADX WARN: Removed duplicated region for block: B:386:0x0c40  */
    /* JADX WARN: Removed duplicated region for block: B:388:0x0c44  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void run() {
        C0049e c0049e;
        NotesFolder folder;
        String absolutePath;
        C13533a c13533a;
        SyncDocumentDao syncDocumentDao;
        String absolutePath2;
        Context context;
        SyncDocumentDao syncDocumentDao2;
        NotesDocumentEntity notesDocumentEntityM9f;
        SyncCategoryTreeInfo syncCategoryTreeInfo;
        HashMap map;
        C6749r c6749r;
        C0077c c0077c;
        List<SyncCategoryTreeInfo> list;
        C0049e c0049e2;
        C0082h c0082h;
        Context context2;
        char c;
        SyncCategoryTreeInfo next;
        C0077c c0077c2;
        C0082h c0082h2;
        SyncNoteDataRepository syncNoteDataRepositoryCreateSyncNoteDataRepository;
        SyncNoteDataRepository syncNoteDataRepositoryCreateSyncNoteDataRepository2;
        String str;
        Context context3;
        HashMap map2;
        C0049e c0049e3;
        switch (this.f197a) {
            case 0:
                C0049e c0049e4 = (C0049e) this.f198b;
                C0082h c0082h3 = c0049e4.f206b;
                HashMap map3 = (HashMap) this.f199c;
                List list2 = (List) this.f200d;
                ArrayList arrayList = (ArrayList) this.f202f;
                ArrayList<NotesCategoryTreeEntity> arrayList2 = (ArrayList) this.f203g;
                ArrayList arrayList3 = (ArrayList) this.f204h;
                List list3 = (List) this.f201e;
                ArrayList<NotesCategoryTreeEntity> arrayList4 = c0049e4.f208d;
                C0077c c0077c3 = c0049e4.f205a;
                Context context4 = c0077c3.f262e;
                C12020a c12020a = c0077c3.f268k;
                HashMap map4 = c0077c3.f269l;
                C6749r c6749r2 = c0077c3.f266i;
                HashMap map5 = c0077c3.f270m;
                context4.getApplicationContext();
                NotesDatabase notesDatabaseManager = NotesDatabaseManager.getInstance();
                SyncCategoryTreeDao syncCategoryTreeDao = notesDatabaseManager.getSyncCategoryTreeDao();
                notesDatabaseManager.getSyncDocumentDao();
                new SyncNoteDataRepository();
                new SoftParentFolderChecker(notesDatabaseManager.getCategoryTreeClosureDao());
                String str2 = "getSyncEntityList ";
                Debugger.m8615i("SyncCategoryTreeRepository", "getSyncEntityList ");
                for (SyncCategoryTreeInfo syncCategoryTreeInfo2 : syncCategoryTreeDao.getSyncEntityList()) {
                    List list4 = list3;
                    map3.put(syncCategoryTreeInfo2.getUUID(), syncCategoryTreeInfo2);
                    c6749r2 = c6749r2;
                    list3 = list4;
                }
                List<FolderNodeItem> list5 = list3;
                C6749r c6749r3 = c6749r2;
                new C13533a(context4);
                Iterator it = list2.iterator();
                while (true) {
                    long recycle_bin_time_moved = -1;
                    Iterator it2 = it;
                    if (!it.hasNext()) {
                        String str3 = str2;
                        C0082h c0082h4 = c0082h3;
                        C0077c c0077c4 = c0077c3;
                        Context context5 = context4;
                        HashMap map6 = map5;
                        C0049e c0049e5 = c0049e4;
                        if (arrayList.isEmpty() && arrayList2.isEmpty() && arrayList3.isEmpty()) {
                            c0049e = c0049e5;
                        } else {
                            c12020a.getClass();
                            C13533a c13533a2 = (C13533a) c12020a.f8772b;
                            if (!arrayList.isEmpty()) {
                                Logger.m8700f("FolderWriteResolver", "createFolderDb, entityList: " + arrayList);
                            }
                            c13533a2.getClass();
                            SyncCategoryTreeDao syncCategoryTreeDao2 = c13533a2.f9553b;
                            SoftParentFolderChecker softParentFolderChecker = c13533a2.f9555d;
                            Debugger.m8615i("SyncCategoryTreeRepository", "insertFolderBySync ");
                            softParentFolderChecker.checkInvalidRelationShip(arrayList);
                            syncCategoryTreeDao2.insertFolder(arrayList);
                            if (!arrayList2.isEmpty()) {
                                Logger.m8700f("FolderWriteResolver", "updateFolderDb, entityList: " + arrayList2);
                            }
                            Debugger.m8615i("SyncCategoryTreeRepository", "updateFolderBySync ");
                            for (NotesCategoryTreeEntity notesCategoryTreeEntity : arrayList2) {
                                Debugger.m8615i("SyncCategoryTreeRepository", "dumpCategoryTreeClosure, entity : " + notesCategoryTreeEntity);
                                softParentFolderChecker.checkInvalidRelationShip(notesCategoryTreeEntity.getUuid(), notesCategoryTreeEntity.getParentUuid());
                                syncCategoryTreeDao2.update(notesCategoryTreeEntity);
                            }
                            c12020a.m13632K(arrayList3);
                            Debugger.m8615i("SyncCategoryTreeRepository", "remakeFolder, entityList : " + arrayList3);
                            Context context6 = c13533a2.f9552a;
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            long currentTime = TimeManager.getCurrentTime(c13533a2.f9552a);
                            SyncDocumentDao syncDocumentDao3 = c13533a2.f9554c;
                            Iterator it3 = arrayList3.iterator();
                            while (it3.hasNext()) {
                                for (NotesCategoryTreeEntity notesCategoryTreeEntity2 : syncCategoryTreeDao2.getEntityListByParentUuid((String) it3.next())) {
                                    if (notesCategoryTreeEntity2.getIsDeleted() == 0) {
                                        context = context6;
                                        syncDocumentDao2 = syncDocumentDao3;
                                        c13533a2.f9553b.move(context, syncDocumentDao2, notesCategoryTreeEntity2.getUuid(), PredefinedCategory.UNCATEGORIZED.getUuid(), currentTime, jCurrentTimeMillis);
                                    } else {
                                        context = context6;
                                        syncDocumentDao2 = syncDocumentDao3;
                                        if (notesCategoryTreeEntity2.getIsDeleted() == 2) {
                                            c13533a2.f9553b.move(context, syncDocumentDao2, notesCategoryTreeEntity2.getUuid(), PredefinedCategory.RECYCLE_BIN.getUuid(), currentTime, jCurrentTimeMillis);
                                        }
                                    }
                                    context6 = context;
                                    syncDocumentDao3 = syncDocumentDao2;
                                }
                            }
                            Debugger.m8615i("SyncCategoryTreeRepository", "remakeTreeClosure, entityList : " + arrayList4);
                            for (NotesCategoryTreeEntity notesCategoryTreeEntity3 : arrayList4) {
                                String uuid = notesCategoryTreeEntity3.getUuid();
                                String parentUuid = notesCategoryTreeEntity3.getParentUuid();
                                softParentFolderChecker.checkInvalidRelationShip(uuid, parentUuid);
                                syncCategoryTreeDao2.deleteMovingCategory(uuid);
                                syncCategoryTreeDao2.moveToParent(uuid, parentUuid);
                            }
                            SyncDocumentDao syncDocumentDao4 = c13533a2.f9554c;
                            DocumentCategoryTree allDocumentCategoryTree = syncCategoryTreeDao2.getAllDocumentCategoryTree(false);
                            for (NotesCategoryTreeEntity notesCategoryTreeEntity4 : arrayList4) {
                                if (notesCategoryTreeEntity4.getIsDeleted() == 0) {
                                    NotesFolder folder2 = allDocumentCategoryTree.getFolder(notesCategoryTreeEntity4.getUuid());
                                    if (folder2 != null && (absolutePath2 = folder2.getAbsolutePath()) != null) {
                                        if (absolutePath2.contains(PredefinedCategory.RECYCLE_BIN.getPath())) {
                                            c13533a2.m14282d(folder2, folder2.getParentUuid(), folder2.getParent().getServerTimeStamp().longValue(), syncDocumentDao4);
                                        } else {
                                            Iterator<NotesFolder> it4 = folder2.getChildren().iterator();
                                            while (it4.hasNext()) {
                                                if (it4.next().getIsDeleted() == 2) {
                                                    c13533a2.m14284f(folder2, syncDocumentDao4, folder2.getServerTimeStamp().longValue());
                                                }
                                            }
                                        }
                                    }
                                } else if (notesCategoryTreeEntity4.getIsDeleted() == 2 && (folder = allDocumentCategoryTree.getFolder(notesCategoryTreeEntity4.getUuid())) != null && (absolutePath = folder.getParent().getAbsolutePath()) != null) {
                                    if (absolutePath.contains(PredefinedCategory.UNCATEGORIZED.getPath())) {
                                        c13533a2.m14284f(folder, syncDocumentDao4, folder.getParent().getServerTimeStamp().longValue());
                                    } else {
                                        for (NotesFolder notesFolder : folder.getChildren()) {
                                            if (notesFolder.getIsDeleted() == 0) {
                                                c13533a = c13533a2;
                                                syncDocumentDao = syncDocumentDao4;
                                                c13533a.m14282d(notesFolder, notesFolder.getParentUuid(), folder.getServerTimeStamp().longValue(), syncDocumentDao);
                                            } else {
                                                c13533a = c13533a2;
                                                syncDocumentDao = syncDocumentDao4;
                                            }
                                            c13533a2 = c13533a;
                                            syncDocumentDao4 = syncDocumentDao;
                                        }
                                    }
                                }
                                c13533a2 = c13533a2;
                                syncDocumentDao4 = syncDocumentDao4;
                            }
                            DataUpdateManager.getInstance().onDataUpdated(1, 3);
                            c0049e = c0049e5;
                            c0049e.m89f(arrayList);
                            c0049e.m89f(arrayList2);
                        }
                        context5.getApplicationContext();
                        NotesDatabase notesDatabaseManager2 = NotesDatabaseManager.getInstance();
                        SyncCategoryTreeDao syncCategoryTreeDao3 = notesDatabaseManager2.getSyncCategoryTreeDao();
                        notesDatabaseManager2.getSyncDocumentDao();
                        new SyncNoteDataRepository();
                        new SoftParentFolderChecker(notesDatabaseManager2.getCategoryTreeClosureDao());
                        Debugger.m8615i("SyncCategoryTreeRepository", str3);
                        List<SyncCategoryTreeInfo> syncEntityList = syncCategoryTreeDao3.getSyncEntityList();
                        for (FolderNodeItem folderNodeItem : list5) {
                            DocSyncEntry docSyncEntry = new SyncNoteDataRepository().getDocSyncEntry(folderNodeItem.uUid);
                            if (docSyncEntry == null) {
                                map = map6;
                                map.put(folderNodeItem.uUid, folderNodeItem);
                            } else {
                                map = map6;
                                String filePath = docSyncEntry.getFilePath();
                                if (TextUtils.isEmpty(filePath) || !filePath.endsWith(".sdoc")) {
                                    long j = folderNodeItem.syncModifiedTime;
                                    long jLongValue = docSyncEntry.getCategoryServerTimeStamp().longValue();
                                    if (j > jLongValue) {
                                        long jLongValue2 = docSyncEntry.getServerTimestamp().longValue();
                                        if (j <= jLongValue2) {
                                            C0082h c0082h5 = c0082h4;
                                            c0077c2 = c0077c4;
                                            Debugger.m8609e("SyncFolder", "handleEachNoteDuringDownSync() : Repair the FolderServerTimestamp of note " + folderNodeItem.uUid);
                                            String str4 = folderNodeItem.uUid;
                                            c0082h5.getClass();
                                            FolderManager folderManager = FolderManager.getInstance();
                                            c6749r = c6749r3;
                                            RunnableC0080f runnableC0080f = new RunnableC0080f(c0082h5, str4, jLongValue2, 0);
                                            c0082h2 = c0082h5;
                                            folderManager.executeOperation(runnableC0080f);
                                        } else if (folderNodeItem.state.equals("deleted")) {
                                            C0077c c0077c5 = c0077c4;
                                            new C0069j(c0077c5, c0082h4, c0049e.f207c, folderNodeItem).m159a("SyncFolder");
                                            map.put(folderNodeItem.uUid, folderNodeItem);
                                            c0077c = c0077c5;
                                            c6749r = c6749r3;
                                            context2 = context5;
                                            list = syncEntityList;
                                            map6 = map;
                                            context5 = context2;
                                            c0077c4 = c0077c;
                                            syncEntityList = list;
                                            c6749r3 = c6749r;
                                        } else {
                                            c0082h2 = c0082h4;
                                            c0077c2 = c0077c4;
                                            if (!folderNodeItem.state.equals(FolderNodeItem.SYNC_WDOC_FOLDER_NODE_STATE_TRASHED)) {
                                                c6749r = c6749r3;
                                                if (docSyncEntry.getIsDeleted() == 1) {
                                                    Debugger.m8615i("SyncFolder", "handleEachNoteDuringDownSync() : deleted note " + folderNodeItem.uUid + " will be set to folder " + folderNodeItem.parentFolderNodeId);
                                                    String str5 = folderNodeItem.uUid;
                                                    if (str5 != null) {
                                                        NotesDataRepositoryFactory.newInstance(context5).createDocumentDataRepository().get(str5);
                                                        syncNoteDataRepositoryCreateSyncNoteDataRepository = NotesDataRepositoryFactory.newInstance(context5).createSyncNoteDataRepository();
                                                        NotesDataRepositoryFactory.newInstance(context5).createDocumentCoverRepository();
                                                        NotesDataRepositoryFactory.newInstance(context5).createDocumentTempDataRepository();
                                                        NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
                                                    } else {
                                                        str5 = null;
                                                        syncNoteDataRepositoryCreateSyncNoteDataRepository = null;
                                                    }
                                                    String serverId = syncNoteDataRepositoryCreateSyncNoteDataRepository != null ? syncNoteDataRepositoryCreateSyncNoteDataRepository.getServerId(str5) : "";
                                                    c6749r.m4885a(folderNodeItem.uUid, "DeletedButWillBeUpdated");
                                                    C6742k.m4841o().m4847G(AbstractC14517a.m15162v(0, folderNodeItem.uUid, serverId));
                                                    map.put(folderNodeItem.uUid, folderNodeItem);
                                                } else {
                                                    c0049e.m91i(folderNodeItem, folderNodeItem.recycleBinMovedTime);
                                                }
                                            } else if (docSyncEntry.getIsDeleted() == 1) {
                                                Debugger.m8615i("SyncFolder", "handleEachNoteDuringDownSync() : deleted note " + folderNodeItem.uUid + " will be trashed and set to " + folderNodeItem.parentFolderNodeId);
                                                String str6 = folderNodeItem.uUid;
                                                if (str6 != null) {
                                                    NotesDataRepositoryFactory.newInstance(context5).createDocumentDataRepository().get(str6);
                                                    syncNoteDataRepositoryCreateSyncNoteDataRepository2 = NotesDataRepositoryFactory.newInstance(context5).createSyncNoteDataRepository();
                                                    NotesDataRepositoryFactory.newInstance(context5).createDocumentCoverRepository();
                                                    NotesDataRepositoryFactory.newInstance(context5).createDocumentTempDataRepository();
                                                    NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
                                                } else {
                                                    str6 = null;
                                                    syncNoteDataRepositoryCreateSyncNoteDataRepository2 = null;
                                                }
                                                String serverId2 = syncNoteDataRepositoryCreateSyncNoteDataRepository2 != null ? syncNoteDataRepositoryCreateSyncNoteDataRepository2.getServerId(str6) : "";
                                                c6749r = c6749r3;
                                                c6749r.m4885a(folderNodeItem.uUid, "DeletedButWillBeUpdated");
                                                C6742k.m4841o().m4847G(AbstractC14517a.m15162v(0, folderNodeItem.uUid, serverId2));
                                                map.put(folderNodeItem.uUid, folderNodeItem);
                                            } else {
                                                c6749r = c6749r3;
                                                if (docSyncEntry.getIsDeleted() == 2) {
                                                    Debugger.m8614f("SyncFolder", "handleEachNoteDuringDownSync() : trashed note " + folderNodeItem.uUid + " is trashed again and set to " + folderNodeItem.parentFolderNodeId);
                                                    c0049e.m91i(folderNodeItem, folderNodeItem.recycleBinMovedTime);
                                                } else {
                                                    Debugger.m8614f("SyncFolder", "handleEachNoteDuringDownSync() : normal note " + folderNodeItem.uUid + " is trashed now and set to " + folderNodeItem.parentFolderNodeId);
                                                    c0049e.m91i(folderNodeItem, System.currentTimeMillis());
                                                }
                                            }
                                        }
                                        list = syncEntityList;
                                        c0082h4 = c0082h2;
                                        c0077c = c0077c2;
                                        context2 = context5;
                                    } else {
                                        c6749r = c6749r3;
                                        C0082h c0082h6 = c0082h4;
                                        c0077c = c0077c4;
                                        if (j < jLongValue) {
                                            String categoryUuid = docSyncEntry.getCategoryUuid();
                                            String uuid2 = docSyncEntry.getUuid();
                                            long jLongValue3 = docSyncEntry.getCategoryServerTimeStamp().longValue();
                                            if (folderNodeItem.state.equals("deleted") && docSyncEntry.getIsDirty() == 1 && docSyncEntry.getIsDeleted() != 1) {
                                                context2 = context5;
                                                new C0113a(uuid2).m270a(new C6748q(context2, uuid2));
                                            } else {
                                                context2 = context5;
                                            }
                                            int isDeleted = docSyncEntry.getIsDeleted();
                                            C0077c c0077c6 = c0082h6.f286b;
                                            if (isDeleted == 2) {
                                                Context context7 = c0077c6.f262e;
                                                C13533a c13533a3 = new C13533a(context7);
                                                if (!TextUtils.isEmpty(categoryUuid) && !PredefinedCategory.RECYCLE_BIN.getUuid().equals(categoryUuid)) {
                                                    SyncCategoryTreeInfo syncCategoryTreeInfoM14279a = c13533a3.m14279a(categoryUuid);
                                                    if ((syncCategoryTreeInfoM14279a != null ? syncCategoryTreeInfoM14279a.getIsDeleted() : 0) == 0) {
                                                        if (syncCategoryTreeInfoM14279a == null) {
                                                            syncCategoryTreeInfoM14279a = c13533a3.m14279a(categoryUuid);
                                                            list = syncEntityList;
                                                        } else {
                                                            list = syncEntityList;
                                                            if (!categoryUuid.equals(syncCategoryTreeInfoM14279a.getUUID())) {
                                                                syncCategoryTreeInfoM14279a = c13533a3.m14279a(categoryUuid);
                                                            }
                                                        }
                                                        if ((syncCategoryTreeInfoM14279a != null ? syncCategoryTreeInfoM14279a.getServerTimestamp() : -1L) < jLongValue3) {
                                                            c0049e2 = c0049e;
                                                            ArrayList arrayList5 = new ArrayList();
                                                            arrayList5.add(uuid2);
                                                            c0082h = c0082h6;
                                                            Debugger.m8612ef("SyncProcessTask$SyncOperationSDocx", AbstractC0541b.m775q("checkRepairNoteFolder() : repair recycleBin state note ", uuid2, " of folder ", categoryUuid, " to recycleBin"));
                                                            DocumentWriteResolver.delete(context7, arrayList5, 2, "SyncProcessTask$SyncOperationSDocx");
                                                        } else {
                                                            c0049e2 = c0049e;
                                                            c0082h = c0082h6;
                                                            Debugger.m8612ef("SyncProcessTask$SyncOperationSDocx", AbstractC0541b.m775q("checkRepairNoteFolder() : repair recycleBin state note ", uuid2, " of folder ", categoryUuid, " to normal"));
                                                            NotesDataRepositoryFactory.newInstance(context7).createDocumentDataRepository();
                                                            SyncNoteDataRepository syncNoteDataRepositoryCreateSyncNoteDataRepository3 = NotesDataRepositoryFactory.newInstance(context7).createSyncNoteDataRepository();
                                                            NotesDataRepositoryFactory.newInstance(context7).createDocumentTempDataRepository();
                                                            NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
                                                            syncNoteDataRepositoryCreateSyncNoteDataRepository3.setNoteDeleted(uuid2, 0);
                                                        }
                                                    }
                                                }
                                            }
                                            list = syncEntityList;
                                            c0082h4 = c0082h6;
                                        } else {
                                            list = syncEntityList;
                                            c0049e2 = c0049e;
                                            c0082h = c0082h6;
                                            context2 = context5;
                                            String uuid3 = docSyncEntry.getUuid();
                                            if (docSyncEntry.getCategoryIsDirty() == 1) {
                                                c6749r.f4134b.updateDirtyCategory(uuid3, 0);
                                            }
                                            if (docSyncEntry.getIsDirty() == 0) {
                                                if (docSyncEntry.getIsDeleted() == 1) {
                                                    Debugger.m8614f("SyncFolder", "handleSameTimeNoteItems, deleted uuid : " + uuid3);
                                                    c = 3;
                                                    c6749r.m4886b(3, uuid3, "handleSameTimeNoteItems");
                                                } else {
                                                    c = 3;
                                                    String categoryUuid2 = docSyncEntry.getCategoryUuid();
                                                    Iterator<SyncCategoryTreeInfo> it5 = list.iterator();
                                                    while (true) {
                                                        if (it5.hasNext()) {
                                                            next = it5.next();
                                                            if (categoryUuid2.equals(next.getUUID())) {
                                                            }
                                                        } else {
                                                            next = null;
                                                        }
                                                    }
                                                    if (docSyncEntry.getIsDeleted() == 2) {
                                                        PredefinedCategory predefinedCategory = PredefinedCategory.UNCATEGORIZED;
                                                        if (predefinedCategory.getUuid().equals(docSyncEntry.getCategoryUuid())) {
                                                            Debugger.m8614f("SyncFolder", "handleNoteIsTrashedAndFolderExists, trashed -> normal, uncategorized uuid : " + docSyncEntry.getUuid());
                                                            C6749r c6749r4 = c0077c.f266i;
                                                            String uuid4 = docSyncEntry.getUuid();
                                                            String uuid5 = predefinedCategory.getUuid();
                                                            long jLongValue4 = docSyncEntry.getCategoryServerTimeStamp().longValue();
                                                            docSyncEntry.getLastModifiedAt();
                                                            c6749r4.m4889e(uuid4, uuid5, 1, jLongValue4, 0L, FolderNodeItem.SYNC_WDOC_FOLDER_NODE_STATE_NORMAL, "");
                                                        } else if (!PredefinedCategory.RECYCLE_BIN.getUuid().equals(docSyncEntry.getCategoryUuid())) {
                                                            if (next != null) {
                                                                SyncCategoryTreeInfo syncCategoryTreeInfo3 = next;
                                                                c0049e = c0049e2;
                                                                c0082h4 = c0082h;
                                                                c0049e.m86c(docSyncEntry, docSyncEntry.getCategoryUuid(), false, syncCategoryTreeInfo3.getIsDeleted(), syncCategoryTreeInfo3.getServerTimestamp());
                                                            } else {
                                                                c0049e = c0049e2;
                                                                c0082h4 = c0082h;
                                                                NotesCategoryTreeEntity notesCategoryTreeEntity5 = (NotesCategoryTreeEntity) map4.get(docSyncEntry.getCategoryUuid());
                                                                if (notesCategoryTreeEntity5 == null) {
                                                                    Debugger.m8609e("SyncFolder", "repairSameTimeNoteItems() : trashed but no parent, uuid : " + docSyncEntry.getUuid());
                                                                } else {
                                                                    c0049e.m86c(docSyncEntry, docSyncEntry.getCategoryUuid(), true, notesCategoryTreeEntity5.getIsDeleted(), notesCategoryTreeEntity5.getServerTimeStamp().longValue());
                                                                }
                                                            }
                                                        }
                                                    } else {
                                                        SyncCategoryTreeInfo syncCategoryTreeInfo4 = next;
                                                        c0049e = c0049e2;
                                                        c0082h4 = c0082h;
                                                        PredefinedCategory predefinedCategory2 = PredefinedCategory.UNCATEGORIZED;
                                                        if (!predefinedCategory2.getUuid().equals(docSyncEntry.getCategoryUuid())) {
                                                            if (PredefinedCategory.RECYCLE_BIN.getUuid().equals(docSyncEntry.getCategoryUuid())) {
                                                                Debugger.m8614f("SyncFolder", "handleNoteIsTrashedAndFolderExists, parent is a trash so set uncategorized : " + docSyncEntry.getUuid());
                                                                C6749r c6749r5 = c0077c.f266i;
                                                                String uuid6 = docSyncEntry.getUuid();
                                                                String uuid7 = predefinedCategory2.getUuid();
                                                                long jLongValue5 = docSyncEntry.getCategoryServerTimeStamp().longValue();
                                                                docSyncEntry.getLastModifiedAt();
                                                                c6749r5.m4889e(uuid6, uuid7, 1, jLongValue5, 0L, FolderNodeItem.SYNC_WDOC_FOLDER_NODE_STATE_NORMAL, "");
                                                            } else if (syncCategoryTreeInfo4 != null) {
                                                                c0049e.m85b(docSyncEntry, syncCategoryTreeInfo4, false, syncCategoryTreeInfo4.getIsDeleted(), syncCategoryTreeInfo4.getServerTimestamp());
                                                            } else {
                                                                NotesCategoryTreeEntity notesCategoryTreeEntity6 = (NotesCategoryTreeEntity) map4.get(docSyncEntry.getCategoryUuid());
                                                                if (notesCategoryTreeEntity6 == null) {
                                                                    Debugger.m8609e("SyncFolder", "repairSameTimeNoteItems() : normal but no parent, uuid : " + docSyncEntry.getUuid());
                                                                } else {
                                                                    c0049e.m85b(docSyncEntry, null, true, notesCategoryTreeEntity6.getIsDeleted(), notesCategoryTreeEntity6.getServerTimeStamp().longValue());
                                                                }
                                                            }
                                                        }
                                                    }
                                                    map6 = map;
                                                    context5 = context2;
                                                    c0077c4 = c0077c;
                                                    syncEntityList = list;
                                                    c6749r3 = c6749r;
                                                }
                                                c0049e = c0049e2;
                                                c0082h4 = c0082h;
                                                map6 = map;
                                                context5 = context2;
                                                c0077c4 = c0077c;
                                                syncEntityList = list;
                                                c6749r3 = c6749r;
                                            }
                                        }
                                        c0049e = c0049e2;
                                        c0082h4 = c0082h;
                                    }
                                    map6 = map;
                                    context5 = context2;
                                    c0077c4 = c0077c;
                                    syncEntityList = list;
                                    c6749r3 = c6749r;
                                } else {
                                    map.put(folderNodeItem.uUid, folderNodeItem);
                                    Debugger.m8615i("SyncFolder", "handleEachNoteDuringDownSync() : pass old note item, UUID = " + folderNodeItem.uUid);
                                }
                            }
                            c6749r = c6749r3;
                            c0077c = c0077c4;
                            context2 = context5;
                            list = syncEntityList;
                            map6 = map;
                            context5 = context2;
                            c0077c4 = c0077c;
                            syncEntityList = list;
                            c6749r3 = c6749r;
                        }
                        C0077c c0077c7 = c0077c4;
                        Context context8 = context5;
                        boolean z = false;
                        if (!C0145c.m323h("sync_v2_pref", "repairTrashedNoteAfterAppUpdate", false)) {
                            SyncNoteDataRepository syncNoteDataRepositoryCreateSyncNoteDataRepository4 = NotesDataRepositoryFactory.newInstance(context8).createSyncNoteDataRepository();
                            NotesDataRepositoryFactory.newInstance(context8).createDocumentTagRepository();
                            NotesDataRepositoryFactory.newInstance(context8).createNotesDocumentPageRepository();
                            NotesDataRepositoryFactory.newInstance(context8).createMappedDocumentRepository();
                            NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
                            List<String> normalSdocxUuidList = syncNoteDataRepositoryCreateSyncNoteDataRepository4.getNormalSdocxUuidList();
                            context8.getApplicationContext();
                            NotesDatabase notesDatabaseManager3 = NotesDatabaseManager.getInstance();
                            SyncCategoryTreeDao syncCategoryTreeDao4 = notesDatabaseManager3.getSyncCategoryTreeDao();
                            notesDatabaseManager3.getSyncDocumentDao();
                            new SyncNoteDataRepository();
                            new SoftParentFolderChecker(notesDatabaseManager3.getCategoryTreeClosureDao());
                            SyncCategoryTreeInfo syncEntity = null;
                            for (String str7 : normalSdocxUuidList) {
                                if (str7 != null) {
                                    notesDocumentEntityM9f = AbstractC0000a.m9f(context8, str7);
                                    AbstractC0000a.m18o(context8, context8, context8);
                                } else {
                                    notesDocumentEntityM9f = null;
                                }
                                if ((notesDocumentEntityM9f != null ? notesDocumentEntityM9f.getIsDeleted() : 1) == 2) {
                                    String categoryUuid3 = notesDocumentEntityM9f != null ? notesDocumentEntityM9f.getCategoryUuid() : null;
                                    if (categoryUuid3 != null) {
                                        if (syncEntity == null) {
                                            Debugger.m8607d("SyncCategoryTreeRepository", "getSyncEntity ".concat(categoryUuid3));
                                            syncEntity = syncCategoryTreeDao4.getSyncEntity(categoryUuid3);
                                        } else {
                                            if (!categoryUuid3.equals(syncEntity.getUUID())) {
                                                Debugger.m8607d("SyncCategoryTreeRepository", "getSyncEntity ".concat(categoryUuid3));
                                                SyncCategoryTreeInfo syncCategoryTreeInfo5 = syncEntity;
                                                syncEntity = syncCategoryTreeDao4.getSyncEntity(categoryUuid3);
                                                syncCategoryTreeInfo = syncCategoryTreeInfo5;
                                            }
                                            if (syncEntity == null) {
                                                syncEntity = syncCategoryTreeInfo;
                                                z = true;
                                            } else {
                                                syncEntity = syncCategoryTreeInfo;
                                                z = false;
                                            }
                                        }
                                        syncCategoryTreeInfo = syncEntity;
                                        if (syncEntity == null) {
                                        }
                                    }
                                    if (!z) {
                                        if (TextUtils.isEmpty(categoryUuid3)) {
                                            folderNodeItem = null;
                                            if (folderNodeItem != null && "deleted".equals(folderNodeItem.state)) {
                                                Debugger.m8614f("SyncFolder", "repairTrashedNote() : docUuid = " + str7 + " to uncategorized:///");
                                                C6749r c6749r6 = c0077c7.f266i;
                                                String uuid8 = PredefinedCategory.UNCATEGORIZED.getUuid();
                                                long jLongValue6 = notesDocumentEntityM9f == null ? notesDocumentEntityM9f.getServerTimestamp().longValue() : -1L;
                                                if (notesDocumentEntityM9f != null) {
                                                    notesDocumentEntityM9f.getLastModifiedAt();
                                                }
                                                c6749r6.m4889e(str7, uuid8, 1, jLongValue6, 0L, FolderNodeItem.SYNC_WDOC_FOLDER_NODE_STATE_NORMAL, "");
                                            }
                                        } else {
                                            for (FolderNodeItem folderNodeItem2 : list5) {
                                                if (categoryUuid3.equals(folderNodeItem2.uUid)) {
                                                    if (folderNodeItem2 != null) {
                                                        Debugger.m8614f("SyncFolder", "repairTrashedNote() : docUuid = " + str7 + " to uncategorized:///");
                                                        C6749r c6749r62 = c0077c7.f266i;
                                                        String uuid82 = PredefinedCategory.UNCATEGORIZED.getUuid();
                                                        if (notesDocumentEntityM9f == null) {
                                                        }
                                                        if (notesDocumentEntityM9f != null) {
                                                        }
                                                        c6749r62.m4889e(str7, uuid82, 1, jLongValue6, 0L, FolderNodeItem.SYNC_WDOC_FOLDER_NODE_STATE_NORMAL, "");
                                                    }
                                                }
                                            }
                                            folderNodeItem2 = null;
                                            if (folderNodeItem2 != null) {
                                            }
                                        }
                                    }
                                    z = false;
                                }
                            }
                            C0145c.m304L("sync_v2_pref", "repairTrashedNoteAfterAppUpdate", true);
                        }
                        break;
                    } else {
                        NotesCategoryTreeEntity notesCategoryTreeEntity7 = (NotesCategoryTreeEntity) it2.next();
                        C0082h c0082h7 = c0082h3;
                        C0077c c0077c8 = c0077c3;
                        if (C6735d.m4829e(notesCategoryTreeEntity7.getUuid(), notesCategoryTreeEntity7.getParentUuid())) {
                            C6732a c6732a = new C6732a(context4, map3);
                            String uuid9 = notesCategoryTreeEntity7.getUuid();
                            SyncCategoryTreeInfo syncCategoryTreeInfoM4825f = c6732a.m4825f(uuid9);
                            long serverTimestamp = syncCategoryTreeInfoM4825f != null ? syncCategoryTreeInfoM4825f.getServerTimestamp() : -1L;
                            long jLongValue7 = notesCategoryTreeEntity7.getServerTimeStamp().longValue();
                            HashMap map7 = map3;
                            if (jLongValue7 > serverTimestamp) {
                                context3 = context4;
                                map2 = map5;
                                str = str2;
                                if (notesCategoryTreeEntity7.getIsDeleted() != 1) {
                                    if (notesCategoryTreeEntity7.getIsDeleted() == 2) {
                                        notesCategoryTreeEntity7.setRecycleBinTimeMoved(System.currentTimeMillis());
                                        Debugger.m8615i("SyncFolder", "handleEachFolderDuringDownSync() : server folder " + uuid9 + " is latest and trashed like now");
                                    } else {
                                        Debugger.m8615i("SyncFolder", "handleEachFolderDuringDownSync() : server folder " + uuid9 + " is latest");
                                    }
                                    if (serverTimestamp == -1) {
                                        arrayList.add(notesCategoryTreeEntity7);
                                    } else {
                                        arrayList2.add(notesCategoryTreeEntity7);
                                    }
                                    arrayList4.add(notesCategoryTreeEntity7);
                                    c0049e3 = c0049e4;
                                } else if (serverTimestamp != -1) {
                                    Debugger.m8615i("SyncFolder", "handleEachFolderDuringDownSync() : server folder " + uuid9 + " is deleted");
                                    if (PredefinedCategory.SCREEN_OFF_MEMO.getUuid().equals(uuid9) || PredefinedCategory.MATH_NOTES.getUuid().equals(uuid9)) {
                                        c0049e3 = c0049e4;
                                        notesCategoryTreeEntity7.setParentUuid(PredefinedCategory.UNCATEGORIZED.getUuid());
                                        notesCategoryTreeEntity7.setServerTimeStamp(Long.valueOf(notesCategoryTreeEntity7.getServerTimeStamp().longValue() + 1));
                                        notesCategoryTreeEntity7.setIsDeleted(0);
                                        arrayList2.add(notesCategoryTreeEntity7);
                                    } else {
                                        Iterator it6 = arrayList.iterator();
                                        while (true) {
                                            if (!it6.hasNext()) {
                                                SyncCategoryTreeInfo syncCategoryTreeInfoM4825f2 = c6732a.m4825f(uuid9);
                                                if ((syncCategoryTreeInfoM4825f2 != null ? syncCategoryTreeInfoM4825f2.getIsDeleted() : 0) == 0) {
                                                    recycle_bin_time_moved = TimeManager.getCurrentTime();
                                                } else {
                                                    SyncCategoryTreeInfo syncCategoryTreeInfoM4825f3 = c6732a.m4825f(uuid9);
                                                    if (syncCategoryTreeInfoM4825f3 != null) {
                                                        recycle_bin_time_moved = syncCategoryTreeInfoM4825f3.getRecycle_bin_time_moved();
                                                    }
                                                }
                                                c0049e3 = c0049e4;
                                                notesCategoryTreeEntity7.setRecycleBinTimeMoved(recycle_bin_time_moved);
                                                if (TextUtils.isEmpty(notesCategoryTreeEntity7.getRestorePath())) {
                                                    Debugger.m8609e("SyncFolder", "restorePath from the server is NULL!");
                                                    SyncCategoryTreeInfo syncCategoryTreeInfoM4825f4 = c6732a.m4825f(uuid9);
                                                    if (TextUtils.isEmpty(syncCategoryTreeInfoM4825f4 != null ? syncCategoryTreeInfoM4825f4.getPath() : "")) {
                                                        Debugger.m8609e("SyncFolder", "restorePath from the local is also NULL!");
                                                        notesCategoryTreeEntity7.setRestorePath(PredefinedCategory.UNCATEGORIZED.getPath());
                                                    } else {
                                                        SyncCategoryTreeInfo syncCategoryTreeInfoM4825f5 = c6732a.m4825f(uuid9);
                                                        notesCategoryTreeEntity7.setRestorePath(syncCategoryTreeInfoM4825f5 != null ? syncCategoryTreeInfoM4825f5.getPath() : "");
                                                    }
                                                }
                                                notesCategoryTreeEntity7.setIsDeleted(2);
                                                Debugger.m8615i("SyncFolder", "handleEachFolderDuringDownSync() : server folder " + uuid9 + " was deleted but is trashed");
                                                arrayList2.add(notesCategoryTreeEntity7);
                                            } else if (((NotesCategoryTreeEntity) it6.next()).getDisplayName().equals(notesCategoryTreeEntity7.getDisplayName()) && TextUtils.isEmpty(notesCategoryTreeEntity7.getRestorePath())) {
                                                arrayList3.add(uuid9);
                                                c0049e3 = c0049e4;
                                            }
                                        }
                                        map4.put(uuid9, notesCategoryTreeEntity7);
                                    }
                                } else {
                                    c0049e3 = c0049e4;
                                    map4.put(uuid9, notesCategoryTreeEntity7);
                                }
                            } else {
                                str = str2;
                                context3 = context4;
                                map2 = map5;
                                c0049e3 = c0049e4;
                                if (jLongValue7 < serverTimestamp) {
                                    Debugger.m8615i("SyncFolder", "handleEachFolderDuringDownSync() : local folder " + uuid9 + " is latest");
                                    SyncCategoryTreeInfo syncCategoryTreeInfoM4825f6 = c6732a.m4825f(uuid9);
                                    if ((syncCategoryTreeInfoM4825f6 != null ? syncCategoryTreeInfoM4825f6.getDisplayNameColor() : 0) == -1 && notesCategoryTreeEntity7.getDisplayNameColor() != -1) {
                                        ((C13533a) c12020a.f8772b).f9553b.setDisplayNameColor(uuid9, notesCategoryTreeEntity7.getDisplayNameColor());
                                    }
                                    SyncCategoryTreeInfo syncCategoryTreeInfoM4825f7 = c6732a.m4825f(uuid9);
                                    if ((syncCategoryTreeInfoM4825f7 != null ? syncCategoryTreeInfoM4825f7.getOrderBy() : 0) == 999999 && notesCategoryTreeEntity7.getReorder().intValue() != 999999) {
                                        ((C13533a) c12020a.f8772b).f9553b.setOrderBy(uuid9, notesCategoryTreeEntity7.getReorder().intValue());
                                    }
                                } else {
                                    SyncCategoryTreeInfo syncCategoryTreeInfoM4825f8 = c6732a.m4825f(uuid9);
                                    if ((syncCategoryTreeInfoM4825f8 != null ? syncCategoryTreeInfoM4825f8.getDisplayNameColor() : 0) == -1 && notesCategoryTreeEntity7.getDisplayNameColor() != -1) {
                                        ((C13533a) c12020a.f8772b).f9553b.setDisplayNameColor(uuid9, notesCategoryTreeEntity7.getDisplayNameColor());
                                    }
                                    SyncCategoryTreeInfo syncCategoryTreeInfoM4825f9 = c6732a.m4825f(uuid9);
                                    if ((syncCategoryTreeInfoM4825f9 != null ? syncCategoryTreeInfoM4825f9.getOrderBy() : 0) == 999999 && notesCategoryTreeEntity7.getReorder().intValue() != 999999) {
                                        ((C13533a) c12020a.f8772b).f9553b.setOrderBy(uuid9, notesCategoryTreeEntity7.getReorder().intValue());
                                    }
                                    SyncCategoryTreeInfo syncCategoryTreeInfoM4825f10 = c6732a.m4825f(uuid9);
                                    if ((syncCategoryTreeInfoM4825f10 != null ? syncCategoryTreeInfoM4825f10.getIsDirty() : 0) != 0) {
                                        ((C13533a) c12020a.f8772b).f9553b.updateIsDirty(uuid9, 0);
                                    }
                                    if (notesCategoryTreeEntity7.getIsDeleted() == 1) {
                                        SyncCategoryTreeInfo syncCategoryTreeInfoM4825f11 = c6732a.m4825f(uuid9);
                                        if ((syncCategoryTreeInfoM4825f11 != null ? syncCategoryTreeInfoM4825f11.getIsDeleted() : 0) == 0) {
                                            Debugger.m8609e("SyncFolder", "handleEachFolderDuringDownSync() : local folder " + uuid9 + " is not deleted");
                                        } else {
                                            SyncCategoryTreeInfo syncCategoryTreeInfoM4825f12 = c6732a.m4825f(uuid9);
                                            if ((syncCategoryTreeInfoM4825f12 != null ? syncCategoryTreeInfoM4825f12.getIsDeleted() : 0) == 1) {
                                                arrayList3.add(uuid9);
                                                map4.put(uuid9, notesCategoryTreeEntity7);
                                            } else {
                                                Debugger.m8615i("SyncFolder", "handleEachFolderDuringDownSync() : local folder " + uuid9 + " could be trashed after deletion");
                                            }
                                        }
                                    }
                                }
                            }
                            c0049e4 = c0049e3;
                            it = it2;
                            c0082h3 = c0082h7;
                            c0077c3 = c0077c8;
                            map3 = map7;
                            context4 = context3;
                            map5 = map2;
                            str2 = str;
                        } else {
                            it = it2;
                            c0082h3 = c0082h7;
                            c0077c3 = c0077c8;
                        }
                    }
                }
                break;
            default:
                RemoteWorkerWrapperKt.RemoteWorkerWrapper$lambda$1((SettableFuture) this.f198b, (Configuration) this.f199c, (Context) this.f200d, (String) this.f201e, (WorkerParameters) this.f202f, (TaskExecutor) this.f203g, (RemoteWorkerWrapper) this.f204h);
                break;
        }
    }

    public /* synthetic */ RunnableC0048d(SettableFuture settableFuture, Configuration configuration, Context context, String str, WorkerParameters workerParameters, TaskExecutor taskExecutor, RemoteWorkerWrapper remoteWorkerWrapper) {
        this.f198b = settableFuture;
        this.f199c = configuration;
        this.f200d = context;
        this.f201e = str;
        this.f202f = workerParameters;
        this.f203g = taskExecutor;
        this.f204h = remoteWorkerWrapper;
    }
}
