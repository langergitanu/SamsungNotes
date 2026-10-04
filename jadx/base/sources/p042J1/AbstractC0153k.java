package p042J1;

import android.content.Context;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.app.notes.sync.p135db.C6735d;
import com.samsung.android.support.senl.p148nt.base.common.TimeManager;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.data.common.constants.CategoryConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import com.samsung.android.support.senl.p148nt.data.common.constants.PredefinedCategory;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncCategoryTreeDao;
import com.samsung.android.support.senl.p148nt.data.repository.category.SoftParentFolderChecker;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesMappedDocumentRepository;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import com.samsung.android.support.senl.p148nt.model.markdown.generator.model.MarkdownDocument;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import opennlp.tools.parser.Parse;
import p007B0.C0027j;

/* JADX INFO: renamed from: J1.k */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC0153k {

    /* JADX INFO: renamed from: a */
    public static C0027j f465a;

    /* JADX INFO: renamed from: b */
    public static C0027j f466b;

    static {
        new SimpleDateFormat("MM-dd_HH-mm-ss-SSS", Locale.getDefault());
    }

    /* JADX INFO: renamed from: a */
    public static String m372a(List list) {
        if (list == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Count : " + list.size() + "\n");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString().replace(",", "\n").replace(Parse.BRACKET_LCB, "\n ").replace("}", MarkdownDocument.NEW_LINE));
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: b */
    public static boolean m373b(Context context) {
        return context.getSharedPreferences("SyncLogger", 0).getBoolean("SyncLoggerEnabled", false);
    }

    /* JADX INFO: renamed from: c */
    public static void m374c(String str, String str2) {
        C0154l.m383a().m385c(TimeManager.getCurrentTime(), str, str2);
    }

    /* JADX INFO: renamed from: d */
    public static void m375d(String str) {
        C0154l c0154lM383a = C0154l.m383a();
        long currentTime = TimeManager.getCurrentTime();
        Debugger.m8607d("!SyncTimer", " > tet=" + c0154lM383a.m384b(currentTime - c0154lM383a.f472e) + ", t=" + c0154lM383a.m384b(currentTime) + ", et=" + c0154lM383a.m384b(currentTime - c0154lM383a.f469b) + SQLKeyword.COMMA + str + " at SyncOldNote");
        c0154lM383a.f469b = currentTime;
        c0154lM383a.f470c = currentTime;
    }

    /* JADX INFO: renamed from: e */
    public static void m376e(String str, String str2) {
        C0154l c0154lM383a = C0154l.m383a();
        long currentTime = TimeManager.getCurrentTime();
        Debugger.m8607d("!SyncTimer", "   > tet=" + c0154lM383a.m384b(currentTime - c0154lM383a.f472e) + ", t=" + c0154lM383a.m384b(currentTime) + ", et=" + c0154lM383a.m384b(currentTime - c0154lM383a.f470c) + SQLKeyword.COMMA + str2 + " at " + str);
        c0154lM383a.f470c = currentTime;
    }

    /* JADX INFO: renamed from: f */
    public static void m377f(String str, String str2) {
        C0154l c0154lM383a = C0154l.m383a();
        long currentTime = TimeManager.getCurrentTime();
        Debugger.m8607d("!SyncTimer", "[Stroke] tet=" + c0154lM383a.m384b(currentTime - c0154lM383a.f472e) + ", t=" + c0154lM383a.m384b(currentTime) + ", et=" + c0154lM383a.m384b(currentTime - c0154lM383a.f471d) + SQLKeyword.COMMA + str2 + " at " + str);
        c0154lM383a.f471d = currentTime;
    }

    /* JADX INFO: renamed from: g */
    public static C0152j m378g() {
        C0152j c0152j = new C0152j();
        c0152j.f458g = 0;
        c0152j.f462k = false;
        c0152j.f463l = false;
        c0152j.f464m = new SimpleDateFormat("MM-dd_HH-mm-ss-SSS", Locale.getDefault());
        return c0152j;
    }

    /* JADX INFO: renamed from: h */
    public static void m379h(Context context, String str) {
        if (m373b(context)) {
            SyncNoteDataRepository syncNoteDataRepository = new SyncNoteDataRepository();
            NotesMappedDocumentRepository notesMappedDocumentRepository = new NotesMappedDocumentRepository();
            C0152j c0152jM378g = m378g();
            c0152jM378g.f454c = ExternalDataConstants.DOCUMENT_TABLE_NAME;
            c0152jM378g.f453b = str;
            c0152jM378g.f455d = m372a(syncNoteDataRepository.dumpDocument());
            c0152jM378g.m371b(context);
            C0152j c0152jM378g2 = m378g();
            c0152jM378g2.f454c = "mappedDocument";
            c0152jM378g2.f453b = str;
            c0152jM378g2.f455d = m372a(notesMappedDocumentRepository.dumpMappedDocument());
            c0152jM378g2.m371b(context);
            C0152j c0152jM378g3 = m378g();
            c0152jM378g3.f454c = "syncInfo";
            c0152jM378g3.f453b = str;
            c0152jM378g3.f455d = m372a(syncNoteDataRepository.dumpSyncInfo());
            c0152jM378g3.m371b(context);
        }
    }

    /* JADX INFO: renamed from: i */
    public static void m380i(Context context) {
        if (m373b(context)) {
            context.getApplicationContext();
            NotesDatabase notesDatabaseManager = NotesDatabaseManager.getInstance();
            SyncCategoryTreeDao syncCategoryTreeDao = notesDatabaseManager.getSyncCategoryTreeDao();
            notesDatabaseManager.getSyncDocumentDao();
            new SyncNoteDataRepository();
            new SoftParentFolderChecker(notesDatabaseManager.getCategoryTreeClosureDao());
            C0152j c0152jM378g = m378g();
            c0152jM378g.f454c = "categoryTree";
            c0152jM378g.f453b = "createLocalNote_res";
            Debugger.m8615i("SyncCategoryTreeRepository", "dumpCategoryTree");
            c0152jM378g.f455d = m372a(syncCategoryTreeDao.getEntities());
            c0152jM378g.m371b(context);
            C0152j c0152jM378g2 = m378g();
            c0152jM378g2.f454c = "categoryTreeClosure";
            c0152jM378g2.f453b = "createLocalNote_res";
            Debugger.m8615i("SyncCategoryTreeRepository", "dumpCategoryTreeClosure");
            c0152jM378g2.f455d = m372a(syncCategoryTreeDao.dumpCategoryTreeClosure());
            c0152jM378g2.m371b(context);
        }
    }

    /* JADX INFO: renamed from: j */
    public static void m381j(Context context, String str) {
        Iterator it;
        boolean z;
        if (m373b(context)) {
            Debugger.m8607d("SyncLogger", "verifyFolder");
            C6735d c6735d = new C6735d(context);
            SyncNoteDataRepository syncNoteDataRepository = new SyncNoteDataRepository();
            HashMap mapM4830a = c6735d.m4830a();
            StringBuilder sb = new StringBuilder();
            Iterator it2 = mapM4830a.values().iterator();
            boolean z2 = false;
            while (it2.hasNext()) {
                FolderNodeItem folderNodeItem = (FolderNodeItem) it2.next();
                String str2 = folderNodeItem.parentFolderNodeId;
                String str3 = folderNodeItem.uUid;
                SyncNoteDataRepository syncNoteDataRepository2 = syncNoteDataRepository;
                if (str2.equals(PredefinedCategory.UNCATEGORIZED.getUuid())) {
                    it = it2;
                    z = z2;
                    if (folderNodeItem.state.equals(FolderNodeItem.SYNC_WDOC_FOLDER_NODE_STATE_TRASHED)) {
                        String strM773o = AbstractC0541b.m773o("folder ", str3, " is deleted correctly?");
                        sb.append(strM773o + "\n");
                        Debugger.m8609e("SyncLogger", strM773o);
                        z2 = true;
                    }
                    if (str2.contains(CategoryConstants.SEPARATOR) && !str2.contains("root") && !"1".equals(str2) && !folderNodeItem.state.equals("deleted")) {
                        FolderNodeItem folderNodeItem2 = (FolderNodeItem) mapM4830a.get(str2);
                        if (folderNodeItem2 == null) {
                            String strM774p = AbstractC0541b.m774p("folder ", str3, " -> no parentId = ", str2);
                            sb.append(strM774p + "\n");
                            Debugger.m8609e("SyncLogger", strM774p);
                        } else if (folderNodeItem2.syncModifiedTime < folderNodeItem.syncModifiedTime) {
                            String strM774p2 = AbstractC0541b.m774p("folder ", str3, " is later than ", str2);
                            sb.append(strM774p2 + "\n");
                            Debugger.m8609e("SyncLogger", strM774p2);
                        }
                        z2 = true;
                    }
                    it2 = it;
                    syncNoteDataRepository = syncNoteDataRepository2;
                } else {
                    it = it2;
                    z = z2;
                }
                z2 = z;
                if (str2.contains(CategoryConstants.SEPARATOR)) {
                }
                it2 = it;
                syncNoteDataRepository = syncNoteDataRepository2;
            }
            Iterator<NotesDocumentEntity> it3 = syncNoteDataRepository.dumpDocument().iterator();
            while (it3.hasNext()) {
                NotesDocumentEntity next = it3.next();
                String categoryUuid = next.getCategoryUuid();
                String uuid = next.getUuid();
                Iterator<NotesDocumentEntity> it4 = it3;
                if (next.getFilePath().endsWith(".sdoc") || categoryUuid.contains(CategoryConstants.SEPARATOR) || categoryUuid.contains("root") || "1".equals(categoryUuid) || next.getIsDeleted() == 1) {
                    it3 = it4;
                    z2 = z2;
                } else {
                    FolderNodeItem folderNodeItem3 = (FolderNodeItem) mapM4830a.get(categoryUuid);
                    if (folderNodeItem3 == null) {
                        String strM774p3 = AbstractC0541b.m774p("note ", uuid, " -> no parentId = ", categoryUuid);
                        sb.append("\n" + strM774p3);
                        Debugger.m8609e("SyncLogger", strM774p3);
                    } else {
                        boolean z3 = z2;
                        if (folderNodeItem3.syncModifiedTime < next.getCategoryServerTimeStamp().longValue()) {
                            String strM774p4 = AbstractC0541b.m774p("note ", uuid, " is later than ", categoryUuid);
                            sb.append(strM774p4 + "\n");
                            Debugger.m8609e("SyncLogger", strM774p4);
                        } else {
                            z2 = z3;
                            it3 = it4;
                        }
                    }
                    z2 = true;
                    it3 = it4;
                }
            }
            if (z2) {
                String string = sb.toString();
                C0152j c0152jM378g = m378g();
                c0152jM378g.f454c = "brokenFolder";
                c0152jM378g.f455d = string;
                c0152jM378g.m371b(context);
                m382k(context, str);
            }
        }
    }

    /* JADX INFO: renamed from: k */
    public static void m382k(Context context, String str) {
        if (m373b(context)) {
            context.getApplicationContext();
            NotesDatabase notesDatabaseManager = NotesDatabaseManager.getInstance();
            SyncCategoryTreeDao syncCategoryTreeDao = notesDatabaseManager.getSyncCategoryTreeDao();
            notesDatabaseManager.getSyncDocumentDao();
            new SyncNoteDataRepository();
            new SoftParentFolderChecker(notesDatabaseManager.getCategoryTreeClosureDao());
            SyncNoteDataRepository syncNoteDataRepository = new SyncNoteDataRepository();
            NotesMappedDocumentRepository notesMappedDocumentRepository = new NotesMappedDocumentRepository();
            C0152j c0152jM378g = m378g();
            c0152jM378g.f454c = "categoryTree";
            c0152jM378g.f453b = str;
            Debugger.m8615i("SyncCategoryTreeRepository", "dumpCategoryTree");
            c0152jM378g.f455d = m372a(syncCategoryTreeDao.getEntities());
            c0152jM378g.m371b(context);
            C0152j c0152jM378g2 = m378g();
            c0152jM378g2.f454c = "categoryTreeClosure";
            c0152jM378g2.f453b = str;
            Debugger.m8615i("SyncCategoryTreeRepository", "dumpCategoryTreeClosure");
            c0152jM378g2.f455d = m372a(syncCategoryTreeDao.dumpCategoryTreeClosure());
            c0152jM378g2.m371b(context);
            C0152j c0152jM378g3 = m378g();
            c0152jM378g3.f454c = ExternalDataConstants.DOCUMENT_TABLE_NAME;
            c0152jM378g3.f453b = str;
            c0152jM378g3.f455d = m372a(syncNoteDataRepository.dumpDocument());
            c0152jM378g3.m371b(context);
            C0152j c0152jM378g4 = m378g();
            c0152jM378g4.f454c = "mappedDocument";
            c0152jM378g4.f453b = str;
            c0152jM378g4.f455d = m372a(notesMappedDocumentRepository.dumpMappedDocument());
            c0152jM378g4.m371b(context);
        }
    }
}
