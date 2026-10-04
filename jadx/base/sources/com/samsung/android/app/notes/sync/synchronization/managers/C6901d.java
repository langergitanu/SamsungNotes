package com.samsung.android.app.notes.sync.synchronization.managers;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.p135db.C6748q;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.document.NotesDocumentRepository;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import p001A.AbstractC0000a;
import p022E1.C0077c;
import p034H1.C0114b;
import p034H1.C0115c;
import p042J1.C0145c;
import p079T.AbstractC0299q;
import p173d0.C11971a;
import p234q1.C14433b;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.synchronization.managers.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6901d {

    /* JADX INFO: renamed from: a */
    public final Context f4469a = BaseUtils.getApplicationContext();

    /* JADX INFO: renamed from: b */
    public static void m5112b(C6748q c6748q, C0077c c0077c) throws SyncException {
        String str = c6748q.f4132e;
        NotesDocumentEntity notesDocumentEntity = c6748q.f4128a;
        if (((notesDocumentEntity != null ? notesDocumentEntity.getCorrupted() : 0) & 1) == 1) {
            if (AbstractC0299q.m650u(str) == 0) {
                Debugger.m8612ef("CorruptedNote", "isCorruptedDbState() : " + str + " wont be uploaded!");
                C0145c.m308P(c6748q.m4883k(), "SyncControlCorruptedNote", str);
            }
            if (c6748q.m4883k() == AbstractC0299q.m650u(str)) {
                throw new SyncException(338, "Corrupted Note!");
            }
        }
        C0114b c0114b = new C0114b(str);
        int iM4882j = c6748q.m4882j();
        if ((c6748q.m4880h() & 512) == 512 && c6748q.m4883k() == C0145c.m328m(0L, "SyncControlExceedObjectNote", str)) {
            if (iM4882j == 0) {
                throw new SyncException(338, "Too many objects!");
            }
            c0114b.m275a(c6748q);
        } else if ((c6748q.m4880h() & 65536) == 65536 && c6748q.m4883k() == C0145c.m328m(0L, "SyncControlExceedObjectNote", str)) {
            throw new SyncException(338, "Too many objects!!");
        }
        if (c6748q.m4883k() == C0145c.m328m(0L, "SyncControlInvalidDataSizeNote", str)) {
            throw new SyncException(338, "Invalid data size");
        }
        if (c6748q.m4883k() == C0145c.m328m(0L, "SyncControlResourceLackingNote", str)) {
            throw new SyncException(338, "Resource Lacking Note");
        }
        if (c6748q.m4883k() == C0145c.m328m(0L, "SyncControlOutOfMemoryNote", str)) {
            throw new SyncException(338, "Out of memory");
        }
        if (c6748q.m4883k() == C0145c.m328m(0L, "SyncControlInvalidFileHashNote", str)) {
            throw new SyncException(338, "Invalid data size");
        }
        if ((c6748q.m4880h() & 8192) == 8192 && c6748q.m4883k() == C0145c.m328m(0L, "SyncControlOver1GbNote", str)) {
            c0077c.f259b = false;
            c0077c.f261d = false;
            throw new SyncException(338, "Over 1Gb Note!");
        }
        if (c6748q.m4883k() == C0145c.m328m(0L, "SyncControlInvalidPayloadNote", str)) {
            throw new SyncException(338, "Invalid payload");
        }
        if (C0115c.m276b(c6748q)) {
            String strM331p = C0145c.m331p("SyncControlLowVersionNote", str, "");
            if (!(TextUtils.isEmpty(strM331p) ? true : true ^ strM331p.equals(C0145c.m322g()))) {
                throw new SyncException(338, "Low Version");
            }
            if (C0115c.m276b(c6748q)) {
                Context applicationContext = BaseUtils.getApplicationContext();
                SyncNoteDataRepository syncNoteDataRepositoryM3196f = AbstractC4539a.m3196f(applicationContext, applicationContext);
                NotesDataRepositoryFactory.newInstance(applicationContext).createDocumentTempDataRepository();
                NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
                syncNoteDataRepositoryM3196f.removeNoteSyncStateFlag(str, 32768L);
            }
            C0145c.m302J("SyncControlLowVersionNote", str);
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m5113d(C6748q c6748q) {
        String str = c6748q.f4132e;
        NotesDocumentEntity notesDocumentEntity = c6748q.f4128a;
        if (((notesDocumentEntity != null ? notesDocumentEntity.getCorrupted() : 0) & 1) == 1) {
            if (AbstractC0299q.m650u(str) == 0) {
                Debugger.m8612ef("CorruptedNote", "isCorruptedDbState() : " + str + " wont be uploaded!");
                C0145c.m308P(c6748q.m4883k(), "SyncControlCorruptedNote", str);
            }
            Context applicationContext = BaseUtils.getApplicationContext();
            NotesDocumentRepository notesDocumentRepositoryCreateDocumentDataRepository = NotesDataRepositoryFactory.newInstance(applicationContext).createDocumentDataRepository();
            NotesDataRepositoryFactory.newInstance(applicationContext).createSyncNoteDataRepository();
            NotesDataRepositoryFactory.newInstance(applicationContext).createDocumentTempDataRepository();
            NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
            notesDocumentRepositoryCreateDocumentDataRepository.updateCorrupted(str, (notesDocumentEntity != null ? notesDocumentEntity.getCorrupted() : 0) & (-2));
        }
        C0145c.m302J("SyncControlCorruptedNote", str);
        new C0114b(str).m275a(c6748q);
        if ((c6748q.m4880h() & 1024) == 1024) {
            Context applicationContext2 = BaseUtils.getApplicationContext();
            SyncNoteDataRepository syncNoteDataRepositoryM3196f = AbstractC4539a.m3196f(applicationContext2, applicationContext2);
            NotesDataRepositoryFactory.newInstance(applicationContext2).createDocumentTempDataRepository();
            NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
            syncNoteDataRepositoryM3196f.removeNoteSyncStateFlag(str, 1024L);
        }
        C0145c.m302J("SyncControlInvalidDataSizeNote", str);
        if ((c6748q.m4880h() & 2048) == 2048) {
            Context applicationContext3 = BaseUtils.getApplicationContext();
            SyncNoteDataRepository syncNoteDataRepositoryM3196f2 = AbstractC4539a.m3196f(applicationContext3, applicationContext3);
            NotesDataRepositoryFactory.newInstance(applicationContext3).createDocumentTempDataRepository();
            NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
            syncNoteDataRepositoryM3196f2.removeNoteSyncStateFlag(str, 2048L);
        }
        C0145c.m302J("SyncControlResourceLackingNote", str);
        if (C0145c.m328m(0L, "SyncControlOutOfMemoryNote", str) > 0) {
            C0145c.m302J("SyncControlOutOfMemoryNote", str);
        }
        if ((c6748q.m4880h() & 4096) == 4096) {
            Context applicationContext4 = BaseUtils.getApplicationContext();
            SyncNoteDataRepository syncNoteDataRepositoryM3196f3 = AbstractC4539a.m3196f(applicationContext4, applicationContext4);
            NotesDataRepositoryFactory.newInstance(applicationContext4).createDocumentTempDataRepository();
            NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
            syncNoteDataRepositoryM3196f3.removeNoteSyncStateFlag(str, 4096L);
        }
        C0145c.m302J("SyncControlInvalidFileHashNote", str);
        if ((c6748q.m4880h() & 8192) == 8192) {
            Context applicationContext5 = BaseUtils.getApplicationContext();
            SyncNoteDataRepository syncNoteDataRepositoryM3196f4 = AbstractC4539a.m3196f(applicationContext5, applicationContext5);
            NotesDataRepositoryFactory.newInstance(applicationContext5).createDocumentTempDataRepository();
            NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
            syncNoteDataRepositoryM3196f4.removeNoteSyncStateFlag(str, 8192L);
        }
        C0145c.m302J("SyncControlOver1GbNote", str);
        if ((c6748q.m4880h() & 16384) == 16384) {
            Context applicationContext6 = BaseUtils.getApplicationContext();
            SyncNoteDataRepository syncNoteDataRepositoryM3196f5 = AbstractC4539a.m3196f(applicationContext6, applicationContext6);
            NotesDataRepositoryFactory.newInstance(applicationContext6).createDocumentTempDataRepository();
            NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
            syncNoteDataRepositoryM3196f5.removeNoteSyncStateFlag(str, 16384L);
        }
        C0145c.m302J("SyncControlInvalidPayloadNote", str);
        if ((c6748q.m4880h() & 32768) == 32768) {
            Context applicationContext7 = BaseUtils.getApplicationContext();
            SyncNoteDataRepository syncNoteDataRepositoryM3196f6 = AbstractC4539a.m3196f(applicationContext7, applicationContext7);
            NotesDataRepositoryFactory.newInstance(applicationContext7).createDocumentTempDataRepository();
            NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
            syncNoteDataRepositoryM3196f6.removeNoteSyncStateFlag(str, 32768L);
        }
        C0145c.m302J("SyncControlLowVersionNote", str);
    }

    /* JADX INFO: renamed from: a */
    public final void m5114a(C11971a c11971a) {
        NotesDocumentEntity notesDocumentEntityM9f;
        SyncNoteDataRepository syncNoteDataRepositoryCreateSyncNoteDataRepository;
        String str = c11971a.f8532p;
        if (str != null) {
            Context context = this.f4469a;
            notesDocumentEntityM9f = AbstractC0000a.m9f(context, str);
            syncNoteDataRepositoryCreateSyncNoteDataRepository = NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository();
            NotesDataRepositoryFactory.newInstance(context).createDocumentCoverRepository();
            NotesDataRepositoryFactory.newInstance(context).createDocumentTempDataRepository();
            NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
        } else {
            str = null;
            notesDocumentEntityM9f = null;
            syncNoteDataRepositoryCreateSyncNoteDataRepository = null;
        }
        long jLongValue = notesDocumentEntityM9f != null ? notesDocumentEntityM9f.getServerTimestamp().longValue() : -1L;
        String str2 = c11971a.f8532p;
        if (jLongValue > c11971a.f8533q) {
            if (syncNoteDataRepositoryCreateSyncNoteDataRepository != null && syncNoteDataRepositoryCreateSyncNoteDataRepository.isConflicted(str) == 1) {
                if ((syncNoteDataRepositoryCreateSyncNoteDataRepository != null ? syncNoteDataRepositoryCreateSyncNoteDataRepository.getConflictStrategy(str) : 0) == 1) {
                    return;
                }
            }
            if (syncNoteDataRepositoryCreateSyncNoteDataRepository != null && syncNoteDataRepositoryCreateSyncNoteDataRepository.isConflicted(str) == 1) {
                if ((syncNoteDataRepositoryCreateSyncNoteDataRepository != null ? syncNoteDataRepositoryCreateSyncNoteDataRepository.getConflictStrategy(str) : 0) == 2) {
                    return;
                }
            }
            if (((notesDocumentEntityM9f != null ? notesDocumentEntityM9f.getCorrupted() : 0) & 1) != 1) {
                if (((syncNoteDataRepositoryCreateSyncNoteDataRepository != null ? syncNoteDataRepositoryCreateSyncNoteDataRepository.getNoteSyncState(str) : 0L) & 1024) != 1024) {
                    throw new SyncException(351, "The local note is updated!");
                }
            } else if (AbstractC0299q.m650u(str2) == 0) {
                Debugger.m8612ef("CorruptedNote", "isCorruptedDbState() : " + str2 + " wont be uploaded!");
                C0145c.m308P(notesDocumentEntityM9f != null ? notesDocumentEntityM9f.getServerTimestamp().longValue() : -1L, "SyncControlCorruptedNote", str2);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m5115c(C6748q c6748q) {
        String str = c6748q.f4132e;
        if (c6748q.m4879g() != 0) {
            Context context = this.f4469a;
            NotesDataRepositoryFactory.newInstance(context).createDocumentDataRepository();
            SyncNoteDataRepository syncNoteDataRepositoryCreateSyncNoteDataRepository = NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository();
            NotesDataRepositoryFactory.newInstance(context).createDocumentTempDataRepository();
            new C14433b(12);
            syncNoteDataRepositoryCreateSyncNoteDataRepository.updateDirty(str, 0);
        }
    }
}
