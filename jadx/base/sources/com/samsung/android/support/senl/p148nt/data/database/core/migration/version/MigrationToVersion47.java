package com.samsung.android.support.senl.p148nt.data.database.core.migration.version;

import android.database.Cursor;
import android.os.Build;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.room.migration.Migration;
import androidx.sqlite.p113db.SupportSQLiteDatabase;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.constants.Constants;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.database.core.converter.NotesDataConverter;
import com.samsung.android.support.senl.p148nt.data.database.core.sqlite.NotesSQLiteCursorFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class MigrationToVersion47 extends Migration {
    private static long HUGE_DATABASE_SIZE = 0;
    private static final int MIGRATION_TEXT_SEARCH_MAX_RETRY_COUNT = 5;
    private static final String PREF_KEY_MIGRATION_TEXT_SEARCH_RETRY_COUNT = "migration_text_search_retry_count";
    public static final String PREF_KEY_SEPARATE_SEARCH_DATA = "separate_search_data";
    private static final String TAG = DataLogger.createTag("MigrationToVersion47");

    static {
        HUGE_DATABASE_SIZE = 104857600L;
        if (Build.VERSION.SDK_INT <= 28) {
            HUGE_DATABASE_SIZE = 52428800L;
        }
    }

    public MigrationToVersion47() {
        super(46, 47);
    }

    private static int calculateInterval(int i) {
        int iMax = Math.max(1, 50 - (i * 10));
        return Build.VERSION.SDK_INT <= 28 ? iMax : iMax * 2;
    }

    public static boolean checkMaxRetryTextSearchMigration(SupportSQLiteDatabase supportSQLiteDatabase, @NonNull List<Pair<Integer, Integer>> list) {
        if (list.isEmpty()) {
            return false;
        }
        try {
            if (countUpTextSearchMigrationRetryCount() <= 5) {
                return false;
            }
            try {
                supportSQLiteDatabase.beginTransaction();
                for (Pair<Integer, Integer> pair : list) {
                    supportSQLiteDatabase.execSQL("UPDATE OR ABORT sdoc SET strippedContent='' WHERE _id >= ? AND _id <= ?", new Object[]{String.valueOf(((Integer) pair.first).intValue()), String.valueOf(((Integer) pair.second).intValue())});
                }
                supportSQLiteDatabase.setTransactionSuccessful();
            } catch (Exception e) {
                DataLogger.m12303e(TAG, "checkMaxRetryTextSearchMigration, e : " + e.getMessage());
            }
            supportSQLiteDatabase.endTransaction();
            return true;
        } catch (Throwable th) {
            supportSQLiteDatabase.endTransaction();
            throw th;
        }
    }

    private static int countUpTextSearchMigrationRetryCount() {
        int textSearchMigrationRetryCount = getTextSearchMigrationRetryCount() + 1;
        SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).putInt(PREF_KEY_MIGRATION_TEXT_SEARCH_RETRY_COUNT, textSearchMigrationRetryCount);
        return textSearchMigrationRetryCount;
    }

    public static boolean executeTextSearchMigration(SupportSQLiteDatabase supportSQLiteDatabase) {
        return executeTextSearchMigrationReturningIndex(supportSQLiteDatabase).isEmpty();
    }

    @NonNull
    public static List<Pair<Integer, Integer>> executeTextSearchMigrationReturningIndex(SupportSQLiteDatabase supportSQLiteDatabase) {
        NotesSQLiteCursorFactory.setCursorSize(20);
        ArrayList arrayList = new ArrayList();
        int iCalculateInterval = calculateInterval(getTextSearchMigrationRetryCount());
        try {
            Cursor cursorQuery = supportSQLiteDatabase.query("SELECT MAX(_id) FROM sdoc");
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        int i = 0;
                        int i2 = cursorQuery.getInt(0);
                        DataLogger.m12302d(TAG, "execute#call, MAX_ROW_ID : " + i2);
                        while (i < i2) {
                            int i4 = i + 1;
                            i += iCalculateInterval;
                            int iMin = Math.min(i, i2);
                            if (!migrateSearchData(supportSQLiteDatabase, i4, iMin)) {
                                arrayList.add(Pair.create(Integer.valueOf(i4), Integer.valueOf(iMin)));
                            }
                        }
                    }
                } finally {
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Exception unused) {
            arrayList.add(Pair.create(1, Integer.valueOf(iCalculateInterval)));
        }
        NotesSQLiteCursorFactory.setCursorSize(-1);
        return arrayList;
    }

    private static int getTextSearchMigrationRetryCount() {
        return SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).getInt(PREF_KEY_MIGRATION_TEXT_SEARCH_RETRY_COUNT, 0);
    }

    private static boolean migrateSearchData(@NonNull SupportSQLiteDatabase supportSQLiteDatabase, int i, int i2) {
        String str = TAG;
        DataLogger.m12307i(str, "migrateSearchData, start : " + i + ", end : " + i2);
        try {
            try {
                supportSQLiteDatabase.beginTransaction();
                DataLogger.m12302d(str, "execute#call, INSERT OR REPLACE INTO , start : " + i + ", end : " + i2);
                supportSQLiteDatabase.execSQL("INSERT OR REPLACE INTO `text_search` (`sdocUUID`, `strippedContent`, `filePath`) SELECT `UUID`, `strippedContent`, `filePath` FROM sdoc WHERE _id >= ? AND _id <= ? AND LENGTH(strippedContent) > 0", new Object[]{String.valueOf(i), String.valueOf(i2)});
                DataLogger.m12302d(str, "execute#call, UPDATE OR ABORT , start : " + i + ", end : " + i2);
                Cursor cursorQuery = supportSQLiteDatabase.query("SELECT UUID, content FROM sdoc WHERE isLock=0 AND _id >= ? AND _id <= ? AND (LENGTH(content) > 300 OR LENGTH(strippedContent) > 0)", new Object[]{String.valueOf(i), String.valueOf(i2)});
                try {
                    int columnIndex = cursorQuery.getColumnIndex("UUID");
                    int columnIndex2 = cursorQuery.getColumnIndex("content");
                    if (columnIndex < 0 || columnIndex2 < 0) {
                        DataLogger.m12309w(str, "migrate, there is no data");
                    } else {
                        while (cursorQuery.moveToNext()) {
                            String string = cursorQuery.getString(columnIndex);
                            String strByteToString = NotesDataConverter.byteToString(cursorQuery.getBlob(columnIndex2));
                            supportSQLiteDatabase.execSQL("UPDATE OR ABORT sdoc SET content=?, strippedContent='' WHERE UUID=?", new String[]{strByteToString.substring(0, Math.min(300, strByteToString.length())), string});
                        }
                    }
                    cursorQuery.close();
                    supportSQLiteDatabase.setTransactionSuccessful();
                    supportSQLiteDatabase.endTransaction();
                    return true;
                } catch (Throwable th) {
                    if (cursorQuery != null) {
                        try {
                            cursorQuery.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (Exception e) {
                DataLogger.m12303e(TAG, "migrateSearchData, e : " + e.getMessage());
                supportSQLiteDatabase.endTransaction();
                return false;
            }
        } catch (Throwable th3) {
            supportSQLiteDatabase.endTransaction();
            throw th3;
        }
    }

    @Override // androidx.room.migration.Migration
    public void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
        String str = TAG;
        DataLogger.m12307i(str, "migrate, start");
        supportSQLiteDatabase.beginTransaction();
        supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `text_search` (`sdocUUID` TEXT NOT NULL, `strippedContent` BLOB NOT NULL, `filePath` TEXT NOT NULL, PRIMARY KEY(`sdocUUID`), FOREIGN KEY(`sdocUUID`) REFERENCES `sdoc`(`UUID`) ON UPDATE CASCADE ON DELETE CASCADE )");
        supportSQLiteDatabase.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `index_text_search_sdocUUID` ON `text_search` (`sdocUUID`)");
        supportSQLiteDatabase.setTransactionSuccessful();
        supportSQLiteDatabase.endTransaction();
        File databasePath = BaseUtils.getApplicationContext().getDatabasePath("sdoc.db");
        if ((databasePath != null && databasePath.length() >= HUGE_DATABASE_SIZE) || !executeTextSearchMigration(supportSQLiteDatabase)) {
            SharedPreferencesCompat.getInstance(Constants.APP_LAUNCH_PREFERENCE).putBoolean(PREF_KEY_SEPARATE_SEARCH_DATA, true);
            DataLogger.m12305f(str, "migrate, need to show progress dialog");
        }
        DataLogger.m12305f(str, "migrate end, need to separate search data");
    }
}
