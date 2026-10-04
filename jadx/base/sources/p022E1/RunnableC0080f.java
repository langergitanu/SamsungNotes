package p022E1;

import android.content.Context;
import android.view.View;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.extension.stickymemo.composer.sip.SipController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncCategoryTreeDao;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncDocumentDao;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.category.FolderTimeUtils;
import com.samsung.android.support.senl.p148nt.data.repository.category.SoftParentFolderChecker;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;

/* JADX INFO: renamed from: E1.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class RunnableC0080f implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f280a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ long f281b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f282c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f283d;

    public /* synthetic */ RunnableC0080f(Object obj, Object obj2, long j, int i) {
        this.f280a = i;
        this.f282c = obj;
        this.f283d = obj2;
        this.f281b = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f280a) {
            case 0:
                C0082h c0082h = (C0082h) this.f282c;
                String str = (String) this.f283d;
                C0077c c0077c = c0082h.f286b;
                Context context = c0077c.f262e;
                SyncNoteDataRepository syncNoteDataRepositoryM3196f = AbstractC4539a.m3196f(context, context);
                NotesDataRepositoryFactory.newInstance(context).createDocumentTempDataRepository();
                NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
                long j = this.f281b;
                syncNoteDataRepositoryM3196f.updateCategoryServerTimestamp(str, j);
                c0077c.f262e.getApplicationContext();
                NotesDatabase notesDatabaseManager = NotesDatabaseManager.getInstance();
                SyncCategoryTreeDao syncCategoryTreeDao = notesDatabaseManager.getSyncCategoryTreeDao();
                SyncDocumentDao syncDocumentDao = notesDatabaseManager.getSyncDocumentDao();
                new SyncNoteDataRepository();
                new SoftParentFolderChecker(notesDatabaseManager.getCategoryTreeClosureDao());
                Debugger.m8615i("SyncCategoryTreeRepository", "repairParentFolderTimeForNote, docUuid : " + str);
                String categoryUuid = syncDocumentDao.getCategoryUuid(str);
                Debugger.m8615i("SyncCategoryTreeRepository", "repairFolderTime, folderUuid : " + categoryUuid);
                FolderTimeUtils.updateServerTimeUpward(syncCategoryTreeDao, syncCategoryTreeDao.getEntity(categoryUuid), j);
                break;
            case 1:
                SipController.delayForceToShow$lambda$0((SipController) this.f282c, (View) this.f283d, this.f281b);
                break;
            default:
                ((SoftInputManager) this.f282c).lambda$delayForceToShow$0((View) this.f283d, this.f281b);
                break;
        }
    }
}
