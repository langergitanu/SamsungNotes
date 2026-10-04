package com.samsung.android.support.senl.p148nt.data.database.core.sqlite;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.sqlite.p113db.SupportSQLiteDatabase;
import androidx.sqlite.p113db.SupportSQLiteOpenHelper;
import com.samsung.android.support.senl.p145cm.base.framework.app.SQLiteOpenHelperCompat;
import com.samsung.android.support.senl.p148nt.base.common.util.FileUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class NotesSQLiteOpenHelper implements SupportSQLiteOpenHelper {
    private static final String TAG = DataLogger.createTag("NotesSQLiteOpenHelper");
    private final OpenHelper mDelegate;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class OpenHelper extends SQLiteOpenHelper {
        private static final String WIPE_CHECK_FILE_SUFFIX = "-wipecheck";
        private final SupportSQLiteOpenHelper.Callback mCallback;
        private final NotesSQLiteDatabase[] mDbRef;
        private boolean mMigrated;

        public OpenHelper(Context context, String str, NotesSQLiteDatabase[] notesSQLiteDatabaseArr, SupportSQLiteOpenHelper.Callback callback) {
            super(context, str, new NotesSQLiteCursorFactory(null), callback.version, createDatabaseErrorHandler(notesSQLiteDatabaseArr, callback));
            this.mCallback = callback;
            this.mDbRef = notesSQLiteDatabaseArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void backupDatabaseFile(String str) {
            if (str.equalsIgnoreCase(":memory:") || str.trim().length() == 0) {
                DataLogger.m12303e(NotesSQLiteOpenHelper.TAG, "!@ Corruption in memory DB");
                return;
            }
            try {
                if (new File(str.concat(".backup")).exists()) {
                    DataLogger.m12303e(NotesSQLiteOpenHelper.TAG, "!@ DB Corruption has happened before this");
                    if (!deleteDatabaseFile(str.concat(".backup"))) {
                        DataLogger.m12303e(NotesSQLiteOpenHelper.TAG, "!@ File delete failed!");
                    }
                }
                renameDatabaseFile(str, str.concat(".backup"));
                boolean zRenameTo = new File(str).renameTo(new File(str.concat(".backup")));
                DataLogger.m12303e(NotesSQLiteOpenHelper.TAG, "!@ rename to backup file, ret : " + zRenameTo);
            } catch (Exception unused) {
                DataLogger.m12303e(NotesSQLiteOpenHelper.TAG, "!@ openDatabase - Exception during copying and renaming");
            }
        }

        @VisibleForTesting
        public static DatabaseErrorHandler createDatabaseErrorHandler(final NotesSQLiteDatabase[] notesSQLiteDatabaseArr, final SupportSQLiteOpenHelper.Callback callback) {
            return new DatabaseErrorHandler() { // from class: com.samsung.android.support.senl.nt.data.database.core.sqlite.NotesSQLiteOpenHelper.OpenHelper.1
                @Override // android.database.DatabaseErrorHandler
                public void onCorruption(SQLiteDatabase sQLiteDatabase) {
                    if (sQLiteDatabase.isOpen() && sQLiteDatabase.isDatabaseIntegrityOk()) {
                        return;
                    }
                    DataLogger.m12302d(NotesSQLiteOpenHelper.TAG, "we will backup this file first!!!");
                    OpenHelper.backupDatabaseFile(sQLiteDatabase.getPath());
                    callback.onCorruption(OpenHelper.getWrappedDb(notesSQLiteDatabaseArr, sQLiteDatabase));
                }
            };
        }

        private static boolean deleteDatabaseFile(String str) {
            boolean zDelete = new File(str).delete();
            if (zDelete) {
                FileUtils.deleteFile(str + "-journal");
                FileUtils.deleteFile(str + "-wal");
                FileUtils.deleteFile(str + "-shm");
                FileUtils.deleteFile(str + "-se");
                FileUtils.deleteFile(str + WIPE_CHECK_FILE_SUFFIX);
            }
            return zDelete;
        }

        private static void renameDatabaseFile(String str, String str2) {
            AbstractC11014a.m12335t("renameDatabaseFile - to, ret : ", NotesSQLiteOpenHelper.TAG, new File(str).renameTo(new File(str2)));
            renameFile(str, str2, "-journal");
            renameFile(str, str2, "-wal");
            renameFile(str, str2, "-shm");
            renameFile(str, str2, "-se");
            FileUtils.deleteFile(str + WIPE_CHECK_FILE_SUFFIX);
        }

        private static void renameFile(String str, String str2, String str3) {
            File file = new File(AbstractC0541b.m756B(str, str3));
            if (file.exists()) {
                boolean zRenameTo = file.renameTo(new File(AbstractC0541b.m756B(str2, str3)));
                DataLogger.m12307i(NotesSQLiteOpenHelper.TAG, "renameFile - postfix : " + str3 + ", ret : " + zRenameTo);
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
        public synchronized void close() {
            super.close();
            this.mDbRef[0] = null;
        }

        public synchronized SupportSQLiteDatabase getReadableSupportDatabase() {
            this.mMigrated = false;
            SQLiteDatabase readableDatabase = super.getReadableDatabase();
            if (!this.mMigrated) {
                return getWrappedDb(readableDatabase);
            }
            close();
            return getReadableSupportDatabase();
        }

        public NotesSQLiteDatabase getWrappedDb(SQLiteDatabase sQLiteDatabase) {
            return getWrappedDb(this.mDbRef, sQLiteDatabase);
        }

        public synchronized SupportSQLiteDatabase getWritableSupportDatabase() {
            this.mMigrated = false;
            SQLiteDatabase writableDatabase = super.getWritableDatabase();
            if (!this.mMigrated) {
                return getWrappedDb(writableDatabase);
            }
            close();
            return getWritableSupportDatabase();
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onConfigure(SQLiteDatabase sQLiteDatabase) {
            DatabaseUtils.longForQuery(sQLiteDatabase, "PRAGMA wal_autocheckpoint=1000", null);
            DatabaseUtils.longForQuery(sQLiteDatabase, "PRAGMA journal_size_limit=8388608", null);
            this.mCallback.onConfigure(getWrappedDb(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            this.mCallback.onCreate(getWrappedDb(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.mMigrated = true;
            this.mCallback.onDowngrade(getWrappedDb(sQLiteDatabase), i, i2);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (this.mMigrated) {
                return;
            }
            this.mCallback.onOpen(getWrappedDb(sQLiteDatabase));
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            this.mMigrated = true;
            this.mCallback.onUpgrade(getWrappedDb(sQLiteDatabase), i, i2);
        }

        public static NotesSQLiteDatabase getWrappedDb(NotesSQLiteDatabase[] notesSQLiteDatabaseArr, SQLiteDatabase sQLiteDatabase) {
            NotesSQLiteDatabase notesSQLiteDatabase = notesSQLiteDatabaseArr[0];
            if (notesSQLiteDatabase == null || !notesSQLiteDatabase.isDelegate(sQLiteDatabase)) {
                notesSQLiteDatabaseArr[0] = new NotesSQLiteDatabase(sQLiteDatabase);
            }
            return notesSQLiteDatabaseArr[0];
        }
    }

    public NotesSQLiteOpenHelper(Context context, String str, SupportSQLiteOpenHelper.Callback callback) {
        this.mDelegate = createDelegate(context, str, callback);
        enableDataRecovery();
    }

    private void enableDataRecovery() {
        SQLiteOpenHelperCompat.INSTANCE.getInstance().enableDataRecovery(this.mDelegate);
    }

    @Override // androidx.sqlite.p113db.SupportSQLiteOpenHelper, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.mDelegate.close();
    }

    @VisibleForTesting
    public OpenHelper createDelegate(Context context, String str, SupportSQLiteOpenHelper.Callback callback) {
        return new OpenHelper(context, str, new NotesSQLiteDatabase[1], callback);
    }

    @Override // androidx.sqlite.p113db.SupportSQLiteOpenHelper
    public String getDatabaseName() {
        return this.mDelegate.getDatabaseName();
    }

    @Override // androidx.sqlite.p113db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getReadableDatabase() {
        return this.mDelegate.getReadableSupportDatabase();
    }

    @Override // androidx.sqlite.p113db.SupportSQLiteOpenHelper
    public SupportSQLiteDatabase getWritableDatabase() {
        return this.mDelegate.getWritableSupportDatabase();
    }

    @Override // androidx.sqlite.p113db.SupportSQLiteOpenHelper
    public void setWriteAheadLoggingEnabled(boolean z) {
        this.mDelegate.setWriteAheadLoggingEnabled(z);
    }
}
