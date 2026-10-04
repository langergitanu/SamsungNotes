package com.samsung.android.support.senl.p148nt.data.database.access;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.p113db.SupportSQLiteDatabase;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.DataUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.sqlite.NotesSQLiteOpenHelperFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class NotesExtraDatabaseManager {
    private static final String TAG = DataLogger.createTag("NotesExtraDatabaseManager");
    private static volatile NotesExtraDatabase sDatabaseInstance;

    private NotesExtraDatabaseManager() {
    }

    private static NotesExtraDatabase getDatabase() {
        DataLogger.m12307i(TAG, "getDatabase");
        return (NotesExtraDatabase) Room.databaseBuilder(DataUtils.getContext(), NotesExtraDatabase.class, NotesExtraDatabase.DATABASE_NAME).allowMainThreadQueries().fallbackToDestructiveMigration().openHelperFactory(new NotesSQLiteOpenHelperFactory()).addCallback(new RoomDatabase.Callback() { // from class: com.samsung.android.support.senl.nt.data.database.access.NotesExtraDatabaseManager.1
            @Override // androidx.room.RoomDatabase.Callback
            public void onCreate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
                super.onCreate(supportSQLiteDatabase);
                DataLogger.m12305f(NotesExtraDatabaseManager.TAG, "onCreate, version : " + supportSQLiteDatabase.getVersion());
            }

            @Override // androidx.room.RoomDatabase.Callback
            public void onDestructiveMigration(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
                DataLogger.m12305f(NotesExtraDatabaseManager.TAG, "onDestructiveMigration, version : " + supportSQLiteDatabase.getVersion());
                super.onDestructiveMigration(supportSQLiteDatabase);
            }
        }).build();
    }

    @NonNull
    public static NotesExtraDatabase getInstance() {
        if (sDatabaseInstance != null) {
            return sDatabaseInstance;
        }
        synchronized (NotesExtraDatabase.class) {
            try {
                if (sDatabaseInstance == null) {
                    sDatabaseInstance = getDatabase();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return sDatabaseInstance;
    }

    @NonNull
    public static SupportSQLiteDatabase getWritableDatabase() {
        return getInstance().getOpenHelper().getWritableDatabase();
    }
}
