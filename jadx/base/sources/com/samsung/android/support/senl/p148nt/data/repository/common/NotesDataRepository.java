package com.samsung.android.support.senl.p148nt.data.repository.common;

import android.content.Context;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabase;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public abstract class NotesDataRepository<Entity> {
    public static final String TAG = DataLogger.createTag("NotesDataRepository");
    private final Context mContext;
    private final NotesDatabase mDatabase = NotesDatabaseManager.getInstance();

    public NotesDataRepository(@NonNull Context context) {
        this.mContext = context.getApplicationContext();
    }

    public abstract void deleteByUuid(@NonNull String str);

    @NonNull
    public Context getContext() {
        return this.mContext;
    }

    @NonNull
    public NotesDatabase getDatabase() {
        return this.mDatabase;
    }

    public abstract void insert(@NonNull Entity entity);

    public void runInTransaction(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        getDatabase().runInTransaction(runnable);
    }

    public abstract void update(@NonNull Entity entity);
}
