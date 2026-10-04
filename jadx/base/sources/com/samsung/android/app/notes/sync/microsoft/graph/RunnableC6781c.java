package com.samsung.android.app.notes.sync.microsoft.graph;

import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.app.settings.detail.C8773x2edf0eff;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncCategoryTreeDao;
import com.samsung.android.support.senl.p148nt.data.repository.category.SoftParentFolderChecker;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import p032H.C0110a;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.microsoft.graph.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class RunnableC6781c implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4173a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f4174b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ C6785g f4175c;

    public /* synthetic */ RunnableC6781c(C6785g c6785g, Object obj, int i) {
        this.f4173a = i;
        this.f4175c = c6785g;
        this.f4174b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4173a) {
            case 0:
                C8773x2edf0eff c8773x2edf0eff = (C8773x2edf0eff) this.f4174b;
                C6785g c6785g = this.f4175c;
                ConcurrentHashMap concurrentHashMap = c6785g.f4182b;
                ConcurrentHashMap concurrentHashMap2 = c6785g.f4182b;
                ConcurrentHashMap concurrentHashMap3 = c6785g.f4181a;
                if (!concurrentHashMap.isEmpty()) {
                    concurrentHashMap3.putAll(concurrentHashMap2);
                    concurrentHashMap2.clear();
                    c6785g.m4947k(c8773x2edf0eff);
                } else if (!concurrentHashMap3.isEmpty()) {
                    c6785g.m4947k(c8773x2edf0eff);
                }
                break;
            case 1:
                C6785g c6785g2 = this.f4175c;
                c6785g2.getClass();
                BaseUtils.getApplicationContext().getApplicationContext();
                NotesDatabase notesDatabaseManager = NotesDatabaseManager.getInstance();
                SyncCategoryTreeDao syncCategoryTreeDao = notesDatabaseManager.getSyncCategoryTreeDao();
                notesDatabaseManager.getSyncDocumentDao();
                new SyncNoteDataRepository();
                new SoftParentFolderChecker(notesDatabaseManager.getCategoryTreeClosureDao());
                Iterator<String> it = syncCategoryTreeDao.getFeedEnabledFolders().iterator();
                while (it.hasNext()) {
                    C6785g.m4935a(c6785g2, it.next());
                }
                c6785g2.m4947k((C8773x2edf0eff) this.f4174b);
                break;
            default:
                String str = (String) this.f4174b;
                C6785g c6785g3 = this.f4175c;
                C6785g.m4935a(c6785g3, str);
                c6785g3.m4947k(new C0110a());
                break;
        }
    }
}
