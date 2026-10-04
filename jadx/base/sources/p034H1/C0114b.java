package p034H1;

import android.content.Context;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.p135db.C6748q;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import p042J1.C0145c;

/* JADX INFO: renamed from: H1.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0114b {

    /* JADX INFO: renamed from: a */
    public final String f365a;

    public C0114b(String str) {
        this.f365a = str;
    }

    /* JADX INFO: renamed from: a */
    public final void m275a(C6748q c6748q) {
        long jM4880h = c6748q.m4880h() & 512;
        String str = this.f365a;
        if (jM4880h == 512) {
            Context applicationContext = BaseUtils.getApplicationContext();
            SyncNoteDataRepository syncNoteDataRepositoryM3196f = AbstractC4539a.m3196f(applicationContext, applicationContext);
            NotesDataRepositoryFactory.newInstance(applicationContext).createDocumentTempDataRepository();
            NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
            syncNoteDataRepositoryM3196f.removeNoteSyncStateFlag(str, 512L);
        }
        if ((c6748q.m4880h() & 65536) == 65536) {
            Context applicationContext2 = BaseUtils.getApplicationContext();
            SyncNoteDataRepository syncNoteDataRepositoryM3196f2 = AbstractC4539a.m3196f(applicationContext2, applicationContext2);
            NotesDataRepositoryFactory.newInstance(applicationContext2).createDocumentTempDataRepository();
            NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
            syncNoteDataRepositoryM3196f2.removeNoteSyncStateFlag(str, 65536L);
        }
        C0145c.m302J("SyncControlExceedObjectNote", str);
    }
}
