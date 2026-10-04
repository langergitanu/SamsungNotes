package com.samsung.android.app.notes.sync.microsoft.graph;

import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.DBUtil;
import androidx.sqlite.p113db.SupportSQLiteStatement;
import com.google.android.gms.common.data.AbstractC4539a;
import com.microsoft.identity.common.logging.Logger;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.microsoft.graph.task.ConnectedNotesTask;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.app.notes.sync.synchronization.managers.C6903f;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.settings.detail.C8773x2edf0eff;
import com.samsung.android.support.senl.p148nt.base.common.ComposerManager;
import com.samsung.android.support.senl.p148nt.base.common.log.MSLogger;
import com.samsung.android.support.senl.p148nt.base.common.util.PageCacheUtils;
import com.samsung.android.support.senl.p148nt.base.common.util.UUIDUtils;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesCategoryTreeEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.FeedSyncEntry;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import com.samsung.android.support.senl.p148nt.model.folder.FolderManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import p001A.AbstractC0000a;
import p007B0.C0020c;
import p016D0.C0059d;
import p021E0.InterfaceC0074a;
import p025F0.AbstractC0089d;
import p025F0.C0090e;
import p025F0.C0091f;
import p025F0.C0092g;
import p025F0.C0093h;
import p025F0.C0094i;
import p029G0.C0104a;
import p042J1.C0145c;
import p044K.C0158a;
import p211o0.C13567a;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.microsoft.graph.g */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6785g {

    /* JADX INFO: renamed from: c */
    public final ExecutorService f4183c = AbstractC4539a.m3201k("GraphManager");

    /* JADX INFO: renamed from: d */
    public GraphManager$State f4184d = GraphManager$State.NONE;

    /* JADX INFO: renamed from: e */
    public boolean f4185e = false;

    /* JADX INFO: renamed from: f */
    public boolean f4186f = false;

    /* JADX INFO: renamed from: g */
    public WeakReference f4187g = null;

    /* JADX INFO: renamed from: a */
    public final ConcurrentHashMap f4181a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b */
    public final ConcurrentHashMap f4182b = new ConcurrentHashMap();

    public C6785g() {
        Logger.setAllowLogcat(true);
    }

    /* JADX INFO: renamed from: a */
    public static void m4935a(C6785g c6785g, String str) {
        Iterator<FeedSyncEntry> it;
        GraphItem$RequestType graphItem$RequestType;
        String msSyncDocumentUuid;
        c6785g.getClass();
        Context applicationContext = BaseUtils.getApplicationContext();
        NotesDataRepositoryFactory.newInstance(applicationContext).createSyncNoteDataRepository();
        NotesDataRepositoryFactory.newInstance(applicationContext).createDocumentTagRepository();
        NotesDataRepositoryFactory.newInstance(applicationContext).createNotesDocumentPageRepository();
        NotesDataRepositoryFactory.newInstance(applicationContext).createMappedDocumentRepository();
        NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
        NotesCategoryTreeEntity categoryEntity = FolderManager.getInstance().getCategoryEntity(str);
        if (categoryEntity == null || categoryEntity.isSyncWithMS() == 0) {
            return;
        }
        MSLogger.m8632d("GraphManager", "add addFeedCreateOrUpdateRequiredNotes. folderUuid :" + str);
        List<FeedSyncEntry> noteFeedListByCategoryUuid = new SyncNoteDataRepository().getNoteFeedListByCategoryUuid(str);
        MSLogger.m8632d("GraphManager", "add addFeedCreateOrUpdateRequiredNotes. item size :" + noteFeedListByCategoryUuid.size());
        if (noteFeedListByCategoryUuid.isEmpty()) {
            return;
        }
        GraphItem$RequestType graphItem$RequestType2 = GraphItem$RequestType.NONE;
        ConcurrentHashMap concurrentHashMap = c6785g.f4181a;
        if (noteFeedListByCategoryUuid.isEmpty()) {
            MSLogger.m8632d("GraphManager", "invalid request.");
            return;
        }
        String strM229a = AbstractC0089d.m229a();
        MSLogger.m8632d("GraphManager", "addItem. count : " + noteFeedListByCategoryUuid.size());
        Iterator<FeedSyncEntry> it2 = noteFeedListByCategoryUuid.iterator();
        while (it2.hasNext()) {
            FeedSyncEntry next = it2.next();
            if (next != null && !concurrentHashMap.containsKey(next.getUuid()) && m4939i(next, graphItem$RequestType2)) {
                if ((TextUtils.isEmpty(strM229a) || strM229a.equals(next.getMsSyncAccountId())) && next.getServerTimestamp().longValue() <= next.getMsLastSyncTime() && next.getIsDirty() == 0) {
                    MSLogger.m8632d("GraphManager", "Skip item. , time : " + next.getServerTimestamp() + " <= " + next.getMsLastSyncTime() + ", isDirty : " + next.getIsDirty());
                    it = it2;
                } else {
                    String uuid = next.getUuid();
                    String filePath = next.getFilePath();
                    String msSyncDocumentUuid2 = next.getMsSyncDocumentUuid();
                    long createdAt = next.getCreatedAt();
                    long lastModifiedAt = next.getLastModifiedAt();
                    MSLogger.m8632d("GraphManager", "convertRequestType. prev : " + graphItem$RequestType2);
                    if (graphItem$RequestType2 == GraphItem$RequestType.NONE) {
                        String strM229a2 = AbstractC0089d.m229a();
                        String msSyncAccountId = next.getMsSyncAccountId();
                        it = it2;
                        MSLogger.m8632d("GraphManager", "getConnectedNotesId. ");
                        if (strM229a2.equals(msSyncAccountId)) {
                            msSyncDocumentUuid = next.getMsSyncDocumentUuid();
                        } else {
                            MSLogger.m8632d("GraphManager", "Mismatch. Document account");
                            msSyncDocumentUuid = null;
                        }
                        graphItem$RequestType = TextUtils.isEmpty(msSyncDocumentUuid) ? GraphItem$RequestType.CREATE : GraphItem$RequestType.UPDATE;
                    } else {
                        it = it2;
                        graphItem$RequestType = graphItem$RequestType2;
                    }
                    MSLogger.m8632d("GraphManager", "convertRequestType. post : " + graphItem$RequestType);
                    C6779a c6779a = new C6779a(uuid, filePath, msSyncDocumentUuid2, createdAt, lastModifiedAt, graphItem$RequestType, next.getIsLock(), next.getServerTimestamp().longValue());
                    MSLogger.m8632d("GraphManager", "addItem. uuid : " + next.getUuid() + ", requestType : " + graphItem$RequestType2);
                    concurrentHashMap.put(next.getUuid(), c6779a);
                }
                it2 = it;
            }
        }
    }

    /* JADX INFO: renamed from: e */
    public static GraphItem$RequestType m4936e(String str, GraphItem$RequestType graphItem$RequestType) {
        NotesDocumentEntity notesDocumentEntityM9f;
        MSLogger.m8632d("GraphManager", "convertRequestType. prev : " + graphItem$RequestType);
        if (graphItem$RequestType == GraphItem$RequestType.NONE) {
            Context applicationContext = BaseUtils.getApplicationContext();
            String msSyncDocumentUuid = null;
            if (str != null) {
                notesDocumentEntityM9f = AbstractC0000a.m9f(applicationContext, str);
                AbstractC0000a.m18o(applicationContext, applicationContext, applicationContext);
            } else {
                notesDocumentEntityM9f = null;
            }
            if (notesDocumentEntityM9f != null) {
                String strM229a = AbstractC0089d.m229a();
                String msSyncAccountId = notesDocumentEntityM9f.getMsSyncAccountId();
                MSLogger.m8632d("GraphManager", "getConnectedNotesId. ");
                if (strM229a.equals(msSyncAccountId)) {
                    msSyncDocumentUuid = notesDocumentEntityM9f.getMsSyncDocumentUuid();
                } else {
                    MSLogger.m8632d("GraphManager", "Mismatch. Document account");
                }
            }
            graphItem$RequestType = TextUtils.isEmpty(msSyncDocumentUuid) ? GraphItem$RequestType.CREATE : GraphItem$RequestType.UPDATE;
        }
        MSLogger.m8632d("GraphManager", "convertRequestType. post : " + graphItem$RequestType);
        return graphItem$RequestType;
    }

    /* JADX INFO: renamed from: g */
    public static boolean m4937g() {
        return C13567a.m14371a().m14372c() && AbstractC4539a.m3210t();
    }

    /* JADX INFO: renamed from: h */
    public static boolean m4938h() {
        boolean zM298F = C0145c.m298F(BaseUtils.getApplicationContext());
        if (zM298F || C0145c.m299G(BaseUtils.getApplicationContext())) {
            return zM298F;
        }
        if (SharedPreferencesCompat.getInstance("Settings").getBoolean("key_sync_while_roaming", false)) {
            return true;
        }
        boolean z = !C0145c.m293A(BaseUtils.getApplicationContext());
        MSLogger.m8632d("GraphManager", "Do not sync while roaming. isNetworkValid : " + z);
        return z;
    }

    /* JADX INFO: renamed from: i */
    public static boolean m4939i(FeedSyncEntry feedSyncEntry, GraphItem$RequestType graphItem$RequestType) {
        if (C0158a.m407a().m416i()) {
            if (graphItem$RequestType == GraphItem$RequestType.DELETE) {
                return true;
            }
            if (feedSyncEntry != null && !UUIDUtils.isGenUuid(feedSyncEntry.getUuid()) && !m4937g()) {
                String categoryUuid = feedSyncEntry.getCategoryUuid();
                if (feedSyncEntry.getIsLock() > 0 && graphItem$RequestType != GraphItem$RequestType.UPDATE) {
                    MSLogger.m8632d("GraphManager", "isValid. LockType : " + feedSyncEntry.getIsLock());
                    return false;
                }
                MSLogger.m8632d("GraphManager", "isValid. categoryUuid : " + categoryUuid);
                Context applicationContext = BaseUtils.getApplicationContext();
                NotesDataRepositoryFactory.newInstance(applicationContext).createSyncNoteDataRepository();
                NotesDataRepositoryFactory.newInstance(applicationContext).createDocumentTagRepository();
                NotesDataRepositoryFactory.newInstance(applicationContext).createNotesDocumentPageRepository();
                NotesDataRepositoryFactory.newInstance(applicationContext).createMappedDocumentRepository();
                NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
                NotesCategoryTreeEntity categoryEntity = FolderManager.getInstance().getCategoryEntity(categoryUuid);
                if (categoryEntity != null && categoryEntity.isSyncWithMS() != 0) {
                    MSLogger.m8632d("GraphManager", "Valid. Add request submit item. categoryUuid : " + categoryUuid);
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: j */
    public static void m4940j(String str) {
        MSLogger.m8632d("GraphManager", "removeConnectedNotes, uuid : " + str);
        Context applicationContext = BaseUtils.getApplicationContext();
        SyncNoteDataRepository syncNoteDataRepositoryM3196f = AbstractC4539a.m3196f(applicationContext, applicationContext);
        NotesDataRepositoryFactory.newInstance(applicationContext).createDocumentTempDataRepository();
        NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
        syncNoteDataRepositoryM3196f.updateMsConnectedNotes(str, "", "", 1);
    }

    /* JADX INFO: renamed from: o */
    public static void m4941o(int i, String str, String str2) {
        MSLogger.m8632d("GraphManager", "updateConnectedNotes, uuid : " + str + ", connectedNotesId : " + str2);
        Context applicationContext = BaseUtils.getApplicationContext();
        SyncNoteDataRepository syncNoteDataRepositoryM3196f = AbstractC4539a.m3196f(applicationContext, applicationContext);
        NotesDataRepositoryFactory.newInstance(applicationContext).createDocumentTempDataRepository();
        NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
        syncNoteDataRepositoryM3196f.updateMsConnectedNotes(str, AbstractC0089d.m229a(), str2, i);
    }

    /* JADX INFO: renamed from: p */
    public static void m4942p(String str, String str2) {
        MSLogger.m8632d("GraphManager", "updateConnectedNotesId, uuid : " + str + ", connectedNotesId : " + str2);
        Context applicationContext = BaseUtils.getApplicationContext();
        SyncNoteDataRepository syncNoteDataRepositoryM3196f = AbstractC4539a.m3196f(applicationContext, applicationContext);
        NotesDataRepositoryFactory.newInstance(applicationContext).createDocumentTempDataRepository();
        NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
        syncNoteDataRepositoryM3196f.updateMsConnectedNotesId(str, AbstractC0089d.m229a(), str2);
    }

    /* JADX INFO: renamed from: b */
    public final void m4943b(String str, String str2, GraphItem$RequestType graphItem$RequestType) {
        C6779a c6779a;
        MSLogger.m8632d("GraphManager", "addFailedDocument. uuid : " + str);
        ConcurrentHashMap concurrentHashMap = this.f4182b;
        if (concurrentHashMap.get(str) != null) {
            MSLogger.m8632d("GraphManager", "This item is already included.");
            return;
        }
        if (graphItem$RequestType == GraphItem$RequestType.DELETE) {
            c6779a = new C6779a(str, "", str2, 0L, 0L, graphItem$RequestType, 0, 0L);
        } else {
            FeedSyncEntry noteFeedEntryByUuid = new SyncNoteDataRepository().getNoteFeedEntryByUuid(str);
            c6779a = noteFeedEntryByUuid != null ? new C6779a(str, noteFeedEntryByUuid.getFilePath(), str2, noteFeedEntryByUuid.getCreatedAt(), noteFeedEntryByUuid.getLastModifiedAt(), m4936e(str, graphItem$RequestType), noteFeedEntryByUuid.getIsLock(), noteFeedEntryByUuid.getServerTimestamp().longValue()) : null;
        }
        if (c6779a != null) {
            concurrentHashMap.put(str, c6779a);
            return;
        }
        MSLogger.m8633e("GraphManager", "item is null. uuid : " + str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0105 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0011 A[SYNTHETIC] */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m4944c() {
        Object c6779a;
        for (C0092g c0092g : new C0093h(BaseUtils.getApplicationContext()).m237b()) {
            String str = c0092g.f301a;
            GraphItem$RequestType graphItem$RequestType = GraphItem$RequestType.values()[c0092g.f302b];
            FeedSyncEntry noteFeedEntryByUuid = new SyncNoteDataRepository().getNoteFeedEntryByUuid(str);
            if (m4939i(noteFeedEntryByUuid, graphItem$RequestType)) {
                MSLogger.m8632d("GraphManager", "addItem. uuid : " + str + ", requestType : " + graphItem$RequestType);
                GraphItem$RequestType graphItem$RequestType2 = GraphItem$RequestType.DELETE;
                Object string = null;
                if (graphItem$RequestType == graphItem$RequestType2) {
                    C0093h c0093h = new C0093h(BaseUtils.getApplicationContext());
                    int iOrdinal = graphItem$RequestType2.ordinal();
                    RoomDatabase roomDatabase = (RoomDatabase) c0093h.f303a.f297a;
                    RoomSQLiteQuery roomSQLiteQueryAcquire = RoomSQLiteQuery.acquire("SELECT msDocumentId FROM graph_sync WHERE docUuid =? AND commandType = ? LIMIT 1", 2);
                    if (str == null) {
                        roomSQLiteQueryAcquire.bindNull(1);
                    } else {
                        roomSQLiteQueryAcquire.bindString(1, str);
                    }
                    roomSQLiteQueryAcquire.bindLong(2, iOrdinal);
                    roomDatabase.assertNotSuspendingTransaction();
                    Cursor cursorQuery = DBUtil.query(roomDatabase, roomSQLiteQueryAcquire, false, null);
                    try {
                        if (cursorQuery.moveToFirst() && !cursorQuery.isNull(0)) {
                            string = cursorQuery.getString(0);
                        }
                        String str2 = string;
                        cursorQuery.close();
                        roomSQLiteQueryAcquire.release();
                        c6779a = new C6779a(str, "", str2, 0L, 0L, graphItem$RequestType, 0, 0L);
                    } catch (Throwable th) {
                        cursorQuery.close();
                        roomSQLiteQueryAcquire.release();
                        throw th;
                    }
                } else {
                    if (noteFeedEntryByUuid != null) {
                        c6779a = new C6779a(str, noteFeedEntryByUuid.getFilePath(), noteFeedEntryByUuid.getMsSyncDocumentUuid(), noteFeedEntryByUuid.getCreatedAt(), noteFeedEntryByUuid.getLastModifiedAt(), m4936e(str, graphItem$RequestType), noteFeedEntryByUuid.getIsLock(), noteFeedEntryByUuid.getServerTimestamp().longValue());
                    }
                    if (string == null) {
                        this.f4181a.put(str, string);
                    }
                }
                string = c6779a;
                if (string == null) {
                }
            } else {
                MSLogger.m8632d("GraphManager", "invalid request. uuid : " + str);
                new C0093h(BaseUtils.getApplicationContext()).m238c(str, graphItem$RequestType.ordinal());
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m4945d(String str, GraphItem$RequestType graphItem$RequestType, long j, String str2, String str3) {
        if (this.f4185e) {
            if (!this.f4186f) {
                if (C0145c.m323h("GRAPH_PREFERENCE", "key_is_skipped_feed_sync_exist", false)) {
                    return;
                }
                C0145c.m304L("GRAPH_PREFERENCE", "key_is_skipped_feed_sync_exist", true);
                return;
            }
            if ((graphItem$RequestType == GraphItem$RequestType.DELETE && TextUtils.isEmpty(str3)) || UUIDUtils.isGenUuid(str)) {
                return;
            }
            if (m4937g()) {
                m4949m(false);
                this.f4182b.clear();
                MSLogger.m8632d("GraphManager", "clear document list");
                this.f4181a.clear();
                C0145c.m304L("GRAPH_PREFERENCE", "key_is_skipped_feed_sync_exist", false);
                MSLogger.m8633e("GraphManager", "Edp does not support feed. disable feed");
                return;
            }
            C0093h c0093h = new C0093h(BaseUtils.getApplicationContext());
            Iterator it = c0093h.m237b().iterator();
            while (it.hasNext()) {
                if (((C0092g) it.next()).f301a.equals(str)) {
                    MSLogger.m8632d("GraphManager", "skip add queue, uuid : " + str + ", requestType : " + graphItem$RequestType);
                    return;
                }
            }
            if (str2 == null) {
                str2 = "";
            }
            int iOrdinal = graphItem$RequestType.ordinal();
            C0091f c0091f = c0093h.f303a;
            RoomDatabase roomDatabase = (RoomDatabase) c0091f.f297a;
            roomDatabase.assertNotSuspendingTransaction();
            C0090e c0090e = (C0090e) c0091f.f298b;
            SupportSQLiteStatement supportSQLiteStatementAcquire = c0090e.acquire();
            if (str == null) {
                supportSQLiteStatementAcquire.bindNull(1);
            } else {
                supportSQLiteStatementAcquire.bindString(1, str);
            }
            supportSQLiteStatementAcquire.bindLong(2, iOrdinal);
            supportSQLiteStatementAcquire.bindLong(3, j);
            supportSQLiteStatementAcquire.bindString(4, str2);
            if (str3 == null) {
                supportSQLiteStatementAcquire.bindNull(5);
            } else {
                supportSQLiteStatementAcquire.bindString(5, str3);
            }
            roomDatabase.beginTransaction();
            try {
                supportSQLiteStatementAcquire.executeInsert();
                roomDatabase.setTransactionSuccessful();
            } finally {
                roomDatabase.endTransaction();
                c0090e.release(supportSQLiteStatementAcquire);
            }
        }
    }

    /* JADX INFO: renamed from: f */
    public final void m4946f() {
        this.f4184d = GraphManager$State.NONE;
        this.f4185e = C0145c.m323h("GRAPH_PREFERENCE", "sign_in", false);
        this.f4186f = C0145c.m323h("GRAPH_PREFERENCE", "enable", false);
    }

    /* JADX INFO: renamed from: k */
    public final void m4947k(InterfaceC0074a interfaceC0074a) {
        MSLogger.m8632d("GraphManager", "requestSubmitAsync");
        if (!C0158a.m407a().m417k()) {
            MSLogger.m8632d("GraphManager", "Samsung Cloud Sync is not enabled. Ignore request");
            return;
        }
        if (!m4938h()) {
            MSLogger.m8632d("GraphManager", "Network is not valid. Ignore request");
            return;
        }
        if (this.f4186f) {
            ConcurrentHashMap concurrentHashMap = this.f4181a;
            if (!concurrentHashMap.isEmpty()) {
                MSLogger.m8632d("GraphManager", "item count : " + concurrentHashMap.size());
                GraphManager$State graphManager$State = this.f4184d;
                GraphManager$State graphManager$State2 = GraphManager$State.SYNCING;
                if (graphManager$State == graphManager$State2) {
                    MSLogger.m8632d("GraphManager", "runTask, state is syncing");
                } else {
                    this.f4184d = graphManager$State2;
                    new ConnectedNotesTask(BaseUtils.getApplicationContext(), 1080, new C6782d(this, interfaceC0074a)).executeOnExecutor(this.f4183c, new ArrayList(concurrentHashMap.values()));
                }
                MSLogger.m8632d("GraphManager", "clear document list");
                concurrentHashMap.clear();
                C0145c.m304L("GRAPH_PREFERENCE", "key_is_skipped_feed_sync_exist", false);
                return;
            }
        }
        MSLogger.m8632d("GraphManager", "Unable to request submit. enable : " + this.f4186f);
    }

    /* JADX INFO: renamed from: l */
    public final void m4948l() {
        if (this.f4185e && this.f4186f) {
            C0059d.m139g(BaseUtils.getApplicationContext()).m141d(new C6783e(this));
        }
    }

    /* JADX INFO: renamed from: m */
    public final void m4949m(boolean z) {
        MSLogger.m8632d("GraphManager", "setEnable : " + z);
        this.f4186f = z;
        C0145c.m304L("GRAPH_PREFERENCE", "enable", z);
    }

    /* JADX INFO: renamed from: n */
    public final boolean m4950n(C8773x2edf0eff c8773x2edf0eff) {
        m4944c();
        StringBuilder sb = new StringBuilder("syncNow. failed size : ");
        ConcurrentHashMap concurrentHashMap = this.f4182b;
        sb.append(concurrentHashMap.size());
        sb.append(", item size : ");
        ConcurrentHashMap concurrentHashMap2 = this.f4181a;
        sb.append(concurrentHashMap2.size());
        MSLogger.m8632d("GraphManager", sb.toString());
        if (!concurrentHashMap.isEmpty() || !concurrentHashMap2.isEmpty()) {
            new SenlThreadFactory("GraphManager-syncNow").newThread(new RunnableC6781c(this, c8773x2edf0eff, 0)).start();
            return true;
        }
        if (this.f4184d != GraphManager$State.SYNCING) {
            boolean zM323h = C0145c.m323h("GRAPH_PREFERENCE", "key_is_skipped_feed_sync_exist", false);
            MSLogger.m8632d("GraphManager", "isSkippedFeedSyncExist : " + zM323h);
            if (zM323h) {
                FolderManager.getInstance().executeOperation(new RunnableC6781c(this, c8773x2edf0eff, 1));
                return false;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:92:0x0287 A[LOOP:0: B:90:0x0281->B:92:0x0287, LOOP_END] */
    /* JADX INFO: renamed from: q */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m4951q() throws Throwable {
        String str;
        NotesDocumentEntity notesDocumentEntity;
        Iterator it;
        C0094i c0094i;
        Iterator it2;
        m4944c();
        MSLogger.m8632d("GraphManager", "requestSubmit");
        if (!C0158a.m407a().m417k()) {
            MSLogger.m8632d("GraphManager", "Samsung Cloud Sync is not enabled. Ignore request");
            return;
        }
        if (!m4938h()) {
            MSLogger.m8632d("GraphManager", "Network is not valid. Ignore request");
            return;
        }
        if (this.f4186f) {
            ConcurrentHashMap concurrentHashMap = this.f4181a;
            if (!concurrentHashMap.isEmpty()) {
                MSLogger.m8632d("GraphManager", "item count : " + concurrentHashMap.size());
                ArrayList arrayList = new ArrayList();
                GraphManager$State graphManager$State = this.f4184d;
                GraphManager$State graphManager$State2 = GraphManager$State.SYNCING;
                String str2 = "GRAPH_PREFERENCE";
                if (graphManager$State == graphManager$State2) {
                    MSLogger.m8632d("GraphManager", "perform, state is syncing");
                    str = "GRAPH_PREFERENCE";
                } else {
                    this.f4184d = graphManager$State2;
                    try {
                    } catch (RuntimeException e) {
                        e = e;
                        str = str2;
                    } catch (Exception e2) {
                        e = e2;
                        str = str2;
                    }
                    if (C0158a.m407a().m416i()) {
                        MSLogger.m8632d("GraphManager", "perform item count : " + concurrentHashMap.values().size());
                        Iterator it3 = concurrentHashMap.values().iterator();
                        while (it3.hasNext()) {
                            C6779a c6779a = (C6779a) it3.next();
                            String str3 = c6779a.f4164a;
                            long j = c6779a.f4167d;
                            long j2 = c6779a.f4168e;
                            String str4 = c6779a.f4166c;
                            GraphItem$RequestType graphItem$RequestType = c6779a.f4169f;
                            String str5 = str2;
                            try {
                                long j3 = c6779a.f4171h;
                                if (this.f4184d == GraphManager$State.CANCELED) {
                                    MSLogger.m8632d("GraphManager", "State is Canceled. break");
                                    str = str5;
                                    break;
                                }
                                try {
                                    if (!C0145c.m323h(str5, "enable", false) || !C0145c.m323h(str5, "sign_in", false) || !C0158a.m407a().m417k() || !m4938h() || ComposerManager.getInstance().isRunningOnEditMode()) {
                                        str = str5;
                                        MSLogger.m8632d("GraphManager", "Feed is not usable");
                                        break;
                                    }
                                    MSLogger.m8632d("GraphManager", "requestType : " + graphItem$RequestType + ", uuid : " + str3 + ", connectedNotesId : " + str4);
                                    GraphItem$RequestType graphItem$RequestType2 = GraphItem$RequestType.DELETE;
                                    if (graphItem$RequestType == graphItem$RequestType2) {
                                        new C0093h(BaseUtils.getApplicationContext()).m238c(str3, graphItem$RequestType2.ordinal());
                                        new C0020c(str4, str3).m45a();
                                        it = it3;
                                        str = str5;
                                    } else {
                                        Context applicationContext = BaseUtils.getApplicationContext();
                                        if (str3 != null) {
                                            notesDocumentEntity = NotesDataRepositoryFactory.newInstance(applicationContext).createDocumentDataRepository().get(str3);
                                            NotesDataRepositoryFactory.newInstance(applicationContext).createSyncNoteDataRepository();
                                            NotesDataRepositoryFactory.newInstance(applicationContext).createDocumentCoverRepository();
                                            NotesDataRepositoryFactory.newInstance(applicationContext).createDocumentTempDataRepository();
                                            NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
                                        } else {
                                            notesDocumentEntity = null;
                                        }
                                        if (notesDocumentEntity == null || notesDocumentEntity.getIsDeleted() != 0) {
                                            it = it3;
                                            str = str5;
                                            new C0093h(BaseUtils.getApplicationContext()).m238c(str3, graphItem$RequestType.ordinal());
                                        } else {
                                            it = it3;
                                            C0104a c0104a = new C0104a(BaseUtils.getApplicationContext(), c6779a.f4165b, PageCacheUtils.createPageThumbnailCacheDirectory(BaseUtils.getApplicationContext(), c6779a.f4164a, 1080), 1080, 20, false);
                                            List listM250d = c0104a.m250d();
                                            if (c6779a.f4170g > 0) {
                                                str = str5;
                                                try {
                                                    c0094i = new C0094i(graphItem$RequestType, str4, str3, c0104a.m248a(), new ArrayList(), null, j, j2, true, j3, c0104a.f347o);
                                                } catch (RuntimeException e3) {
                                                    e = e3;
                                                    MSLogger.m8633e("GraphManager", "RuntimeException occurred. Failed. " + e.getMessage());
                                                    this.f4184d = GraphManager$State.IDLE;
                                                    MSLogger.m8632d("GraphManager", "clear document list. size : " + arrayList.size());
                                                    it2 = arrayList.iterator();
                                                    while (it2.hasNext()) {
                                                    }
                                                    C0145c.m304L(str, "key_is_skipped_feed_sync_exist", false);
                                                    return;
                                                } catch (Exception e5) {
                                                    e = e5;
                                                    AbstractC6670b.m4753n(e, new StringBuilder("Failed. "), "GraphManager");
                                                    this.f4184d = GraphManager$State.IDLE;
                                                    MSLogger.m8632d("GraphManager", "clear document list. size : " + arrayList.size());
                                                    it2 = arrayList.iterator();
                                                    while (it2.hasNext()) {
                                                    }
                                                    C0145c.m304L(str, "key_is_skipped_feed_sync_exist", false);
                                                    return;
                                                }
                                            } else {
                                                str = str5;
                                                c0094i = new C0094i(graphItem$RequestType, str4, str3, c0104a.m248a(), listM250d, c0104a.f337e, j, j2, false, j3, c0104a.f347o);
                                            }
                                            GraphItem$RequestType graphItem$RequestType3 = GraphItem$RequestType.CREATE;
                                            if (graphItem$RequestType == graphItem$RequestType3 || TextUtils.isEmpty(str4)) {
                                                new C0093h(BaseUtils.getApplicationContext()).m238c(str3, graphItem$RequestType3.ordinal());
                                                new C6903f(c0094i).m5124h();
                                            } else {
                                                new C0093h(BaseUtils.getApplicationContext()).m238c(str3, GraphItem$RequestType.UPDATE.ordinal());
                                                new C6742k(c0094i).m4861s();
                                            }
                                        }
                                    }
                                    arrayList.add(str3);
                                    str2 = str;
                                    it3 = it;
                                } catch (RuntimeException e6) {
                                    e = e6;
                                    str = str5;
                                } catch (Exception e7) {
                                    e = e7;
                                    str = str5;
                                }
                            } catch (RuntimeException e8) {
                                e = e8;
                                str = str5;
                            } catch (Exception e9) {
                                e = e9;
                                str = str5;
                            }
                        }
                        str = str2;
                        this.f4184d = GraphManager$State.IDLE;
                    } else {
                        str = str2;
                        this.f4184d = GraphManager$State.IDLE;
                    }
                }
                MSLogger.m8632d("GraphManager", "clear document list. size : " + arrayList.size());
                it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    concurrentHashMap.remove((String) it2.next());
                }
                C0145c.m304L(str, "key_is_skipped_feed_sync_exist", false);
                return;
            }
        }
        MSLogger.m8632d("GraphManager", "Unable to request submit. enable : " + this.f4186f);
    }
}
