package com.samsung.android.support.senl.p148nt.data.repository.common;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseRepository {
    private final NotesDatabase mDatabase;

    public BaseRepository(@NonNull NotesDatabase notesDatabase) {
        this.mDatabase = notesDatabase;
    }

    public NotesDatabase getDatabase() {
        return this.mDatabase;
    }

    public <T> T runInTransaction(@NonNull Callable<T> callable) {
        return (T) this.mDatabase.runInTransaction(callable);
    }
}
