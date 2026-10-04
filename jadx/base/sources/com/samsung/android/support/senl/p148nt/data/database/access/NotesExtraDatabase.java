package com.samsung.android.support.senl.p148nt.data.database.access;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import com.samsung.android.support.senl.p148nt.data.database.core.converter.NotesDataConverter;
import com.samsung.android.support.senl.p148nt.data.database.temp.infra.dao.DeletedNoteDao;
import com.samsung.android.support.senl.p148nt.data.database.temp.infra.entity.DeletedNoteEntity;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@TypeConverters({NotesDataConverter.class})
@Database(entities = {DeletedNoteEntity.class}, version = 1)
public abstract class NotesExtraDatabase extends RoomDatabase {
    public static final String DATABASE_NAME = "notes_extra.db";

    public abstract DeletedNoteDao deletedNoteDao();
}
