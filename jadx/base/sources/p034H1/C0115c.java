package p034H1;

import android.content.Context;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.p135db.C6748q;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.diagmon.DiagMonLogger;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.SyncState;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import p042J1.C0145c;
import p235r0.C14435a;

/* JADX INFO: renamed from: H1.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0115c {

    /* JADX INFO: renamed from: a */
    public final String f366a;

    public C0115c(String str) {
        this.f366a = str;
    }

    /* JADX INFO: renamed from: b */
    public static boolean m276b(C6748q c6748q) {
        return (c6748q.m4880h() & 32768) == 32768;
    }

    /* JADX INFO: renamed from: a */
    public final void m277a(Context context, C6748q c6748q) {
        Debugger.m8615i("LowVersionNote", "handleLowVersionNote() : docUuid = " + c6748q.f4132e);
        String strM322g = C0145c.m322g();
        String str = this.f366a;
        C0145c.m310R("SyncControlLowVersionNote", str, strM322g);
        if (!m276b(c6748q)) {
            Context applicationContext = BaseUtils.getApplicationContext();
            SyncNoteDataRepository syncNoteDataRepositoryM3196f = AbstractC4539a.m3196f(applicationContext, applicationContext);
            NotesDataRepositoryFactory.newInstance(applicationContext).createDocumentTempDataRepository();
            NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
            syncNoteDataRepositoryM3196f.addNoteSyncStateFlag(str, 32768L);
        }
        if (!SyncState.isAppUpdateNeeded(context)) {
            SyncState.setAppUpdateNeeded(context, true);
        }
        C14435a c14435a = new C14435a();
        c14435a.f165b = "APP_ERROR";
        c14435a.f164a = new Exception(DiagMonLogger.getExceptionMsg((String) c14435a.f165b, 100, ""));
        c14435a.m62a();
    }
}
