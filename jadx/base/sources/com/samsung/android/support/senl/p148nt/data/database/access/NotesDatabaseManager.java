package com.samsung.android.support.senl.p148nt.data.database.access;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.p113db.SupportSQLiteDatabase;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.base.common.log.AppLaunchLog;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.common.utils.DataUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.migration.Migrations;
import com.samsung.android.support.senl.p148nt.data.database.core.sqlite.NotesSQLiteOpenHelperFactory;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class NotesDatabaseManager {
    private static final String TAG = DataLogger.createTag("NotesDatabaseManager");
    private static volatile NotesDatabase sDatabaseInstance;

    private NotesDatabaseManager() {
    }

    private static NotesDatabase getDatabase(boolean z) {
        AbstractC11014a.m12335t("getDatabase, inMemory : ", TAG, z);
        return z ? (NotesDatabase) Room.inMemoryDatabaseBuilder(DataUtils.getContext(), NotesDatabase.class).allowMainThreadQueries().fallbackToDestructiveMigration().openHelperFactory(new NotesSQLiteOpenHelperFactory()).addMigrations(Migrations.MIGRATIONS).build() : (NotesDatabase) Room.databaseBuilder(DataUtils.getContext(), NotesDatabase.class, "sdoc.db").allowMainThreadQueries().fallbackToDestructiveMigration().openHelperFactory(new NotesSQLiteOpenHelperFactory()).addCallback(new RoomDatabase.Callback() { // from class: com.samsung.android.support.senl.nt.data.database.access.NotesDatabaseManager.1
            @Override // androidx.room.RoomDatabase.Callback
            public void onCreate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
                super.onCreate(supportSQLiteDatabase);
                DataLogger.m12305f(NotesDatabaseManager.TAG, "onCreate, version : " + supportSQLiteDatabase.getVersion());
            }

            @Override // androidx.room.RoomDatabase.Callback
            public void onDestructiveMigration(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
                AtomicBoolean atomicBoolean = Migrations.NEED_TO_BE_CLEARED_DATA;
                atomicBoolean.set(true);
                DataLogger.m12305f(NotesDatabaseManager.TAG, "onDestructiveMigration, version : " + supportSQLiteDatabase.getVersion() + ", NEED_TO_BE_CLEARED_DATA : " + atomicBoolean.get());
                if (SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).getInt(Constants.PREFERENCE_NOTICE_FOR_UT, -1) < 5) {
                    SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).putInt(Constants.PREFERENCE_NOTICE_FOR_UT, 5);
                }
                super.onDestructiveMigration(supportSQLiteDatabase);
            }
        }).addMigrations(Migrations.MIGRATIONS).build();
    }

    @NonNull
    public static NotesDatabase getInMemoryInstance() {
        return getInstance(true);
    }

    @NonNull
    public static NotesDatabase getInstance() {
        return getInstance(false);
    }

    @NonNull
    public static SupportSQLiteDatabase getWritableDatabase() {
        return getInstance().getOpenHelper().getWritableDatabase();
    }

    public static void init() {
        AppLaunchLog.m8606d(TAG, "init", true);
    }

    public static void releaseInstance() {
        if (sDatabaseInstance != null) {
            synchronized (NotesDatabase.class) {
                try {
                    NotesDatabase notesDatabase = sDatabaseInstance;
                    if (notesDatabase != null) {
                        notesDatabase.close();
                    }
                    sDatabaseInstance = null;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @NonNull
    private static NotesDatabase getInstance(boolean z) {
        NotesDatabase database;
        NotesDatabase notesDatabase = sDatabaseInstance;
        if (notesDatabase != null) {
            return notesDatabase;
        }
        synchronized (NotesDatabase.class) {
            try {
                database = sDatabaseInstance;
                if (database == null) {
                    database = getDatabase(z);
                    sDatabaseInstance = database;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return database;
    }
}
