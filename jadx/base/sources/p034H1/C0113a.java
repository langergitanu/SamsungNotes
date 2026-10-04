package p034H1;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.p135db.C6748q;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import p001A.AbstractC0000a;
import p234q1.C14433b;

/* JADX INFO: renamed from: H1.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0113a {

    /* JADX INFO: renamed from: a */
    public final String f364a;

    public C0113a(String str) {
        this.f364a = str;
    }

    /* JADX INFO: renamed from: a */
    public final void m270a(C6748q c6748q) {
        if (c6748q.m4884l()) {
            Context applicationContext = BaseUtils.getApplicationContext();
            NotesDataRepositoryFactory.newInstance(applicationContext).createDocumentDataRepository();
            SyncNoteDataRepository syncNoteDataRepositoryCreateSyncNoteDataRepository = NotesDataRepositoryFactory.newInstance(applicationContext).createSyncNoteDataRepository();
            NotesDataRepositoryFactory.newInstance(applicationContext).createDocumentTempDataRepository();
            new C14433b(12);
            StringBuilder sb = new StringBuilder("resetConflicted() : ");
            String str = this.f364a;
            sb.append(str);
            Debugger.m8614f("WDocWriteResolver", sb.toString());
            syncNoteDataRepositoryCreateSyncNoteDataRepository.updateConflict(str, 0, "", 0);
            Debugger.m8615i("ConflictedNote", "clear() : " + str);
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m271b(String str, String str2) {
        Context applicationContext = BaseUtils.getApplicationContext();
        SyncNoteDataRepository syncNoteDataRepositoryM3196f = AbstractC4539a.m3196f(applicationContext, applicationContext);
        NotesDataRepositoryFactory.newInstance(applicationContext).createDocumentTempDataRepository();
        NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
        boolean zIsEmpty = TextUtils.isEmpty(str);
        String str3 = this.f364a;
        if (zIsEmpty) {
            Debugger.m8612ef("WDocWriteResolver", "setConflicted() : " + str3 + " by the remote device!");
            str = "";
        } else {
            StringBuilder sbM15l = AbstractC0000a.m15l("setConflicted() : ", str3, " by ");
            sbM15l.append(Logger.getEncode(str));
            Debugger.m8614f("WDocWriteResolver", sbM15l.toString());
        }
        syncNoteDataRepositoryM3196f.updateConflict(str3, 1, str, 0);
        Debugger.m8615i("ConflictedNote", "conflictNote() : ".concat(str2));
    }

    /* JADX INFO: renamed from: c */
    public final boolean m272c(C6748q c6748q, String str) {
        if (c6748q.m4884l()) {
            int iM4874b = c6748q.m4874b();
            if (iM4874b == 0) {
                Debugger.m8615i("ConflictedNote", "handleConflictedNoteAndIsDownloadNeeded() : No user choice!");
                return false;
            }
            if (iM4874b == 3) {
                m271b(str, "Local note is update and conflicted!");
                return false;
            }
        } else if (c6748q.m4879g() == 1) {
            m271b(str, "Local note is update and conflicted!");
            return false;
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x007e, code lost:
    
        if (r6.equals(r8) == false) goto L26;
     */
    /* JADX INFO: renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean m273d(C6748q c6748q, String str, String str2) {
        boolean zM4884l = c6748q.m4884l();
        String str3 = this.f364a;
        if (zM4884l) {
            int iM4874b = c6748q.m4874b();
            Debugger.m8615i("ConflictedNote", "handleConflictedNoteAndIsUploadNeeded() : conflictStrategy of " + str3 + " = " + iM4874b);
            if (iM4874b == 0) {
                Debugger.m8615i("ConflictedNote", "handleConflictedNoteAndIsUploadNeeded() : No user choice!");
                return false;
            }
            if (iM4874b != 1) {
                if (iM4874b == 2) {
                    Debugger.m8615i("ConflictedNote", "handleConflictedNoteAndIsUploadNeeded() : Cancel to upload the note!");
                }
            }
            return false;
        }
        if (TextUtils.isEmpty(c6748q.m4873a())) {
            Debugger.m8615i("ConflictedNote", "handleConflictedNoteAndIsUploadNeeded() : commit id of " + str3 + " is empty!");
            return false;
        }
        String strM4873a = c6748q.m4873a();
        if (TextUtils.isEmpty(str2)) {
            Debugger.m8612ef("ConflictedNote", "isCommitIdSame() : commitIdOfServerNote is empty");
        } else if (TextUtils.isEmpty(strM4873a)) {
            Debugger.m8612ef("ConflictedNote", "isCommitIdSame() : commitIdOfLocalNote is empty");
        }
        Debugger.m8615i("ConflictedNote", "Note is conflicted : different commitId");
        m271b(str, "Local note is updated after compareForUpsync!");
        return false;
        return true;
    }

    /* JADX INFO: renamed from: e */
    public final void m274e(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            Debugger.m8612ef("ConflictedNote", "updateCommitId() : No serverCommitId");
            return;
        }
        if (str2.equals(str)) {
            return;
        }
        Context applicationContext = BaseUtils.getApplicationContext();
        SyncNoteDataRepository syncNoteDataRepositoryM3196f = AbstractC4539a.m3196f(applicationContext, applicationContext);
        NotesDataRepositoryFactory.newInstance(applicationContext).createDocumentTempDataRepository();
        new C14433b(12);
        AbstractC4539a.m3190D("setCommitId() : ", str2, "WDocWriteResolver");
        syncNoteDataRepositoryM3196f.updateCommitId(this.f364a, str2);
    }
}
