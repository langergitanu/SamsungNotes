package com.samsung.android.support.senl.p148nt.data.repository.template;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.access.NotesDatabaseManager;
import com.samsung.android.support.senl.p148nt.data.database.core.document.dao.NotesTemplateDao;
import com.samsung.android.support.senl.p148nt.data.database.core.document.entity.NotesTemplateEntity;
import com.samsung.android.support.senl.p148nt.data.repository.common.BaseRepository;
import java.util.Collection;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class NotesTemplateRepository extends BaseRepository {
    private static final String TAG = DataLogger.createTag("NotesTemplateRepository");
    private final NotesTemplateDao mNotesTemplateDao;

    public NotesTemplateRepository() {
        super(NotesDatabaseManager.getInstance());
        this.mNotesTemplateDao = getDatabase().getNotesTemplateDao();
    }

    public void deleteByPath(@NonNull Collection<String> collection) {
        this.mNotesTemplateDao.deleteByPath(collection);
    }

    public LiveData<List<NotesTemplateEntity>> getAll_LiveData(boolean z) {
        return this.mNotesTemplateDao.getAll_LiveData(z);
    }

    @Nullable
    public NotesTemplateEntity getEntity(@NonNull String str) {
        return this.mNotesTemplateDao.getEntity(str);
    }

    public void updateTitle(@NonNull String str, @NonNull String str2) {
        String str3 = TAG;
        StringBuilder sbM15l = AbstractC0000a.m15l("updateTitle, uuid: ", str, ", title: ");
        sbM15l.append(DataLogger.getEncode(str2));
        DataLogger.m12307i(str3, sbM15l.toString());
        this.mNotesTemplateDao.updateTitle(str, str2);
    }

    public void upsert(@NonNull NotesTemplateEntity notesTemplateEntity) {
        this.mNotesTemplateDao.upsert(notesTemplateEntity);
    }

    public LiveData<List<NotesTemplateEntity>> getAll_LiveData(boolean z, int i) {
        return this.mNotesTemplateDao.getAll_LiveData(z, i);
    }

    public void upsert(@NonNull Collection<NotesTemplateEntity> collection) {
        AbstractC0000a.m28y(collection, new StringBuilder("upsert, size: "), TAG);
        this.mNotesTemplateDao.upsert((Collection) collection);
    }
}
