package p012C1;

import android.content.Context;
import android.text.TextUtils;
import androidx.work.impl.utils.IdGenerator;
import com.google.firebase.installations.FirebaseInstallations;
import com.microsoft.identity.common.internal.util.StringUtil;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.p135db.C6734c;
import com.samsung.android.app.notes.sync.p135db.C6735d;
import com.samsung.android.support.senl.p148nt.app.main.livesharing.LiveSharingActivity;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncCategoryTreeDao;
import com.samsung.android.support.senl.p148nt.data.repository.category.SoftParentFolderChecker;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import com.samsung.android.support.senl.p148nt.model.restore.document.DuplicatedDatabaseDetector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import org.apache.commons.lang3.Functions;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableCallable;
import p001A.AbstractC0000a;
import p007B0.C0027j;
import p022E1.C0077c;
import p026F1.C0097a;
import p042J1.AbstractC0153k;
import p079T.AbstractC0299q;
import p206n0.C13533a;
import p255x1.C14512a;

/* JADX INFO: renamed from: C1.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class CallableC0046b implements Callable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f191a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f192b;

    public /* synthetic */ CallableC0046b(Object obj, int i) {
        this.f191a = i;
        this.f192b = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        ArrayList<FolderNodeItem> arrayList;
        StringBuilder sb;
        switch (this.f191a) {
            case 0:
                C0049e c0049e = (C0049e) this.f192b;
                C0077c c0077c = c0049e.f205a;
                c0077c.f262e.getApplicationContext();
                NotesDatabase notesDatabaseManager = NotesDatabaseManager.getInstance();
                SyncCategoryTreeDao syncCategoryTreeDao = notesDatabaseManager.getSyncCategoryTreeDao();
                notesDatabaseManager.getSyncDocumentDao();
                new SyncNoteDataRepository();
                new SoftParentFolderChecker(notesDatabaseManager.getCategoryTreeClosureDao());
                int totalNumberOfFolders = syncCategoryTreeDao.getTotalNumberOfFolders();
                C6734c c6734c = c0077c.f267j;
                Debugger.m8615i("SyncFolder", "upSyncLocalChanges() : Current folder # = " + totalNumberOfFolders + ", SDocx # = " + c6734c.f4096a.getTotalNumberOfSDocx());
                HashMap map = new HashMap();
                Context context = c0077c.f262e;
                C13533a c13533a = new C13533a(context);
                HashMap map2 = new HashMap();
                Debugger.m8615i("SyncCategoryTreeRepository", "getAllDirtyCategoryEntityForSync");
                List<NotesCategoryTreeEntity> allDirtyCategoryEntityForSync = c13533a.f9553b.getAllDirtyCategoryEntityForSync();
                if (allDirtyCategoryEntityForSync != null) {
                    for (NotesCategoryTreeEntity notesCategoryTreeEntity : allDirtyCategoryEntityForSync) {
                        if (notesCategoryTreeEntity.getIsDirty() != 0 && C6735d.m4829e(notesCategoryTreeEntity.getUuid(), notesCategoryTreeEntity.getParentUuid())) {
                            FolderNodeItem folderNodeItemM4826b = C6735d.m4826b(notesCategoryTreeEntity);
                            map2.put(folderNodeItemM4826b.uUid, folderNodeItemM4826b);
                        }
                    }
                }
                List<FolderNodeItem> dirtyFolderNodeItemList = c6734c.f4096a.getDirtyFolderNodeItemList();
                if (dirtyFolderNodeItemList != null) {
                    for (FolderNodeItem folderNodeItem : dirtyFolderNodeItemList) {
                        if (TextUtils.isEmpty(folderNodeItem.categoryUuid) || "uncategorized:///".equals(folderNodeItem.categoryUuid) || "trash:///".equals(folderNodeItem.categoryUuid)) {
                            folderNodeItem.parentFolderNodeId = "root";
                        } else {
                            folderNodeItem.parentFolderNodeId = folderNodeItem.categoryUuid;
                        }
                        int i = folderNodeItem.isDeleted;
                        String str = i == 1 ? "deleted" : i == 2 ? FolderNodeItem.SYNC_WDOC_FOLDER_NODE_STATE_TRASHED : FolderNodeItem.SYNC_WDOC_FOLDER_NODE_STATE_NORMAL;
                        folderNodeItem.state = str;
                        folderNodeItem.type = FolderNodeItem.SYNC_SDOCX_FOLDER_NODE_TYPE_NOTE;
                        if (!str.equals(FolderNodeItem.SYNC_WDOC_FOLDER_NODE_STATE_NORMAL) && StringUtil.isEmpty(folderNodeItem.restorePath)) {
                            folderNodeItem.restorePath = "uncategorized:///";
                            Debugger.m8609e("DocumentListReadResolver", "getFolderNodeList() : No restorePath in " + folderNodeItem.uUid);
                        }
                    }
                    arrayList = new ArrayList(dirtyFolderNodeItemList);
                } else {
                    Debugger.m8615i("DocumentListReadResolver", "getFolderNodeList() : No folderNodeItemList!");
                    arrayList = new ArrayList();
                }
                int size = map2.size();
                int size2 = arrayList.size();
                Debugger.m8615i("SyncFolder", "makeFolderNodeListV2() : folder = " + size + " , note = " + size2);
                if (size > 0 || size2 > 0) {
                    for (FolderNodeItem folderNodeItem2 : map2.values()) {
                        map.put(folderNodeItem2.uUid, folderNodeItem2);
                    }
                    Iterator it = map2.values().iterator();
                    while (it.hasNext()) {
                        c0049e.m84a(map, (FolderNodeItem) it.next());
                    }
                    for (FolderNodeItem folderNodeItem3 : arrayList) {
                        map.put(folderNodeItem3.uUid, folderNodeItem3);
                    }
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        c0049e.m84a(map, (FolderNodeItem) it2.next());
                    }
                    Iterator it3 = map.values().iterator();
                    while (it3.hasNext()) {
                        C0049e.m83g(map, (FolderNodeItem) it3.next());
                    }
                }
                ArrayList arrayList2 = new ArrayList(map.values());
                try {
                    try {
                        if (arrayList2.isEmpty()) {
                            Debugger.m8615i("SyncFolder", "upSyncLocalChanges() : None");
                        } else {
                            AbstractC0299q.f771d = true;
                            new C14512a(c0077c.f265h, context, new C0097a(), new C0027j(arrayList2, c0077c)).m15112c();
                            c0049e.m90h(arrayList2);
                        }
                        try {
                            if (arrayList2.isEmpty()) {
                                return null;
                            }
                            AbstractC0153k.m382k(context, "updateFolders_res");
                            return null;
                        } catch (Exception e) {
                            e = e;
                            sb = new StringBuilder("upSyncLocalChanges() : fail to writeDbDump = ");
                            AbstractC0000a.m21r(e, sb, "SyncFolder");
                            return null;
                        }
                    } catch (Exception e2) {
                        if (!(e2 instanceof SyncException)) {
                            throw e2;
                        }
                        c0049e.m87d((SyncException) e2);
                        try {
                            if (arrayList2.isEmpty()) {
                                return null;
                            }
                            AbstractC0153k.m382k(context, "updateFolders_res");
                            return null;
                        } catch (Exception e3) {
                            e = e3;
                            sb = new StringBuilder("upSyncLocalChanges() : fail to writeDbDump = ");
                            AbstractC0000a.m21r(e, sb, "SyncFolder");
                            return null;
                        }
                    }
                } finally {
                }
            case 1:
                return IdGenerator.nextAlarmManagerId$lambda$1((IdGenerator) this.f192b);
            case 2:
                return ((FirebaseInstallations) this.f192b).deleteFirebaseInstallationId();
            case 3:
                return ((LiveSharingActivity) this.f192b).lambda$importNoteToSpace$0();
            case 4:
                return ((DuplicatedDatabaseDetector) this.f192b).lambda$execute$1();
            case 5:
                return Functions.call((Functions.FailableCallable) this.f192b);
            default:
                return Failable.call((FailableCallable) this.f192b);
        }
    }
}
