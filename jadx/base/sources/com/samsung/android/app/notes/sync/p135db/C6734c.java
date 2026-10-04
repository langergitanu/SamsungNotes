package com.samsung.android.app.notes.sync.p135db;

import android.content.Context;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.repository.NotesDataRepositoryFactory;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.db.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6734c {

    /* JADX INFO: renamed from: a */
    public final SyncNoteDataRepository f4096a;

    public C6734c(Context context) {
        this.f4096a = NotesDataRepositoryFactory.newInstance(context).createSyncNoteDataRepository();
        NotesDataRepositoryFactory.newInstance(context).createDocumentTagRepository();
        NotesDataRepositoryFactory.newInstance(context).createNotesDocumentPageRepository();
        NotesDataRepositoryFactory.newInstance(context).createMappedDocumentRepository();
        NotesDatabaseManager.getInstance().getSyncDelayInfoDao();
    }
}
