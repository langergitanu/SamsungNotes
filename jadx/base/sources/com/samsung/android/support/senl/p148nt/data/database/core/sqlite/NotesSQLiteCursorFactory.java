package com.samsung.android.support.senl.p148nt.data.database.core.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.sqlite.p113db.SupportSQLiteQuery;
import com.samsung.android.imagetranslation.util.AbstractC7150s;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.data.common.log.DataLogger;
import java.io.File;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class NotesSQLiteCursorFactory implements SQLiteDatabase.CursorFactory {

    /* JADX INFO: renamed from: MB */
    private static final long f7419MB = 1048576;
    private static final String TAG = DataLogger.createTag("NotesSQLiteCursorFactory");
    private static int sCursorSize = -1;
    private static long sSdocDbSizeMB = -1;
    private final SupportSQLiteQuery mSupportSQLiteQuery;

    public NotesSQLiteCursorFactory(@Nullable SupportSQLiteQuery supportSQLiteQuery) {
        this.mSupportSQLiteQuery = supportSQLiteQuery;
    }

    @VisibleForTesting
    public static void clear() {
        sCursorSize = -1;
        sSdocDbSizeMB = -1L;
    }

    private static long getSdocDbSizeMB() {
        long j = sSdocDbSizeMB;
        if (j >= 0) {
            return j;
        }
        String str = TAG;
        DataLogger.m12307i(str, "getDbSize");
        Context applicationContext = BaseUtils.getApplicationContext();
        if (applicationContext == null) {
            return 0L;
        }
        File databasePath = applicationContext.getDatabasePath("sdoc.db");
        if (!databasePath.exists()) {
            return 0L;
        }
        long length = databasePath.length();
        DataLogger.m12307i(str, "getDbSize:" + length + " bytes");
        long j2 = length / 1048576;
        sSdocDbSizeMB = j2;
        return j2;
    }

    public static synchronized void setCursorSize(int i) {
        sCursorSize = i;
    }

    @Override // android.database.sqlite.SQLiteDatabase.CursorFactory
    public Cursor newCursor(SQLiteDatabase sQLiteDatabase, SQLiteCursorDriver sQLiteCursorDriver, String str, SQLiteQuery sQLiteQuery) {
        SupportSQLiteQuery supportSQLiteQuery = this.mSupportSQLiteQuery;
        if (supportSQLiteQuery != null) {
            supportSQLiteQuery.bindTo(new NotesSQLiteProgram(sQLiteQuery));
        }
        SQLiteCursor sQLiteCursor = new SQLiteCursor(sQLiteCursorDriver, str, sQLiteQuery);
        if (Build.VERSION.SDK_INT >= 28) {
            int i = sCursorSize;
            if (i > 0) {
                DataLogger.m12307i(TAG, "PREF_KEY_CHANGE_CURSOR_SIZE : " + i);
                sQLiteCursor.setWindow(AbstractC7150s.m5500d(((long) i) * 1048576));
                return sQLiteCursor;
            }
            long sdocDbSizeMB = getSdocDbSizeMB();
            if (sdocDbSizeMB < 50) {
                sQLiteCursor.setWindow(AbstractC7150s.m5499c());
                return sQLiteCursor;
            }
            if (sdocDbSizeMB < 100) {
                sQLiteCursor.setWindow(AbstractC11263a.m12429d());
                return sQLiteCursor;
            }
            if (sdocDbSizeMB < 150) {
                sQLiteCursor.setWindow(AbstractC11263a.m12433h());
                return sQLiteCursor;
            }
            if (sdocDbSizeMB < 200) {
                sQLiteCursor.setWindow(AbstractC11263a.m12434i());
                return sQLiteCursor;
            }
            sQLiteCursor.setWindow(AbstractC11263a.m12435j());
        }
        return sQLiteCursor;
    }
}
