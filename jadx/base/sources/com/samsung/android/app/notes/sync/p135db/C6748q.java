package com.samsung.android.app.notes.sync.p135db;

import android.content.Context;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesDocumentEntity;
import com.samsung.android.support.senl.p148nt.data.database.core.document.tuple.DocumentCoverStateTuple;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.cover.NotesDocumentCoverRepository;
import com.samsung.android.support.senl.p148nt.data.repository.document.DocumentTempDataRepository;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import p001A.AbstractC0000a;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.db.q */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6748q {

    /* JADX INFO: renamed from: a */
    public final NotesDocumentEntity f4128a;

    /* JADX INFO: renamed from: b */
    public final SyncNoteDataRepository f4129b;

    /* JADX INFO: renamed from: c */
    public final NotesDocumentCoverRepository f4130c;

    /* JADX INFO: renamed from: d */
    public final DocumentTempDataRepository f4131d;

    /* JADX INFO: renamed from: e */
    public final String f4132e;

    public C6748q(Context context, String str) {
        this.f4128a = null;
        this.f4129b = null;
        this.f4130c = null;
        this.f4131d = null;
        if (str != null) {
            this.f4128a = AbstractC0000a.m9f(context, str);
            this.f4129b = NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository();
            this.f4130c = NotesDataRepositoryFactory.newInstance(context).createDocumentCoverRepository();
            this.f4131d = NotesDataRepositoryFactory.newInstance(context).createDocumentTempDataRepository();
            NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
            this.f4132e = str;
        }
    }

    /* JADX INFO: renamed from: a */
    public final String m4873a() {
        SyncNoteDataRepository syncNoteDataRepository = this.f4129b;
        return syncNoteDataRepository != null ? syncNoteDataRepository.getCommitId(this.f4132e) : "";
    }

    /* JADX INFO: renamed from: b */
    public final int m4874b() {
        SyncNoteDataRepository syncNoteDataRepository = this.f4129b;
        if (syncNoteDataRepository != null) {
            return syncNoteDataRepository.getConflictStrategy(this.f4132e);
        }
        return 0;
    }

    /* JADX INFO: renamed from: c */
    public final DocumentCoverStateTuple m4875c() {
        NotesDocumentCoverRepository notesDocumentCoverRepository = this.f4130c;
        if (notesDocumentCoverRepository != null) {
            return notesDocumentCoverRepository.getCoverStateTuple(this.f4132e);
        }
        return null;
    }

    /* JADX INFO: renamed from: d */
    public final String m4876d() {
        NotesDocumentEntity notesDocumentEntity = this.f4128a;
        if (notesDocumentEntity != null) {
            return notesDocumentEntity.getMsSyncAccountId();
        }
        return null;
    }

    /* JADX INFO: renamed from: e */
    public final String m4877e() {
        NotesDocumentEntity notesDocumentEntity = this.f4128a;
        if (notesDocumentEntity != null) {
            return notesDocumentEntity.getMsSyncDocumentUuid();
        }
        return null;
    }

    /* JADX INFO: renamed from: f */
    public final int m4878f() {
        NotesDocumentEntity notesDocumentEntity = this.f4128a;
        if (notesDocumentEntity != null) {
            return notesDocumentEntity.getIsDeleted();
        }
        return 1;
    }

    /* JADX INFO: renamed from: g */
    public final int m4879g() {
        NotesDocumentEntity notesDocumentEntity = this.f4128a;
        if (notesDocumentEntity != null) {
            return notesDocumentEntity.getIsDirty();
        }
        return 0;
    }

    /* JADX INFO: renamed from: h */
    public final long m4880h() {
        SyncNoteDataRepository syncNoteDataRepository = this.f4129b;
        if (syncNoteDataRepository != null) {
            return syncNoteDataRepository.getNoteSyncState(this.f4132e);
        }
        return 0L;
    }

    /* JADX INFO: renamed from: i */
    public final String m4881i() {
        SyncNoteDataRepository syncNoteDataRepository = this.f4129b;
        return syncNoteDataRepository != null ? syncNoteDataRepository.getServerId(this.f4132e) : "";
    }

    /* JADX INFO: renamed from: j */
    public final int m4882j() {
        SyncNoteDataRepository syncNoteDataRepository = this.f4129b;
        if (syncNoteDataRepository != null) {
            return syncNoteDataRepository.getStrokeGrouped(this.f4132e);
        }
        return 0;
    }

    /* JADX INFO: renamed from: k */
    public final long m4883k() {
        NotesDocumentEntity notesDocumentEntity = this.f4128a;
        if (notesDocumentEntity != null) {
            return notesDocumentEntity.getServerTimestamp().longValue();
        }
        return -1L;
    }

    /* JADX INFO: renamed from: l */
    public final boolean m4884l() {
        SyncNoteDataRepository syncNoteDataRepository = this.f4129b;
        return syncNoteDataRepository != null && syncNoteDataRepository.isConflicted(this.f4132e) == 1;
    }
}
