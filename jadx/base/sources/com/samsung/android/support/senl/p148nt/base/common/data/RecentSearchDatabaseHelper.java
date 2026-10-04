package com.samsung.android.support.senl.p148nt.base.common.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteFullException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.data.RecentSearchDatabaseHelper;
import com.samsung.android.support.senl.p148nt.base.common.data.RecentSearchProvider;
import com.samsung.android.support.senl.p148nt.base.common.util.StorageUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.p196io.CloseableKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p079T.RunnableC0284b;
import p127c3.RunnableC4208a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0003\u001c\u001d\u001eB\u0013\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u000fJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u001a\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0\u00192\u0006\u0010\u001a\u001a\u00020\u0015J\b\u0010\u001b\u001a\u00020\tH\u0002R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/data/RecentSearchDatabaseHelper;", "", "mContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mDbHelper", "Lcom/samsung/android/support/senl/nt/base/common/data/RecentSearchDatabaseHelper$DatabaseHelper;", "destroy", "", "insertSearchKeyword", "", Bixby2Constants.BIXBY_PARAM_KEYWORD, "", "deleteSearchKeyword", "", "id", "db", "Landroid/database/sqlite/SQLiteDatabase;", "deleteAllSearchKeywords", "deleteOldSearchKeywords", "", "querySearchKeywords", "Landroid/database/Cursor;", "querySearchKeywordList", "", "count", "sendNotificationChange", "DatabaseHelper", "AsyncExecutor", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class RecentSearchDatabaseHelper {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String DATABASE_NAME = "recent_search.db";
    private static final int DATABASE_VERSION = 2;
    private static final long INVALID_ID = -1;

    @NotNull
    private static final String TAG = "RecentSearchDatabaseHelper";

    @Nullable
    private static RecentSearchDatabaseHelper sInstance;

    @Nullable
    private final Context mContext;

    @Nullable
    private DatabaseHelper mDbHelper;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\u0005H\u0007J\u001c\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/data/RecentSearchDatabaseHelper$AsyncExecutor;", "", "<init>", "()V", "insertSearchKeyword", "", Bixby2Constants.BIXBY_PARAM_KEYWORD, "", "deleteSearchKeyword", "id", "", "deleteAllSearchKeywords", "querySearchKeywordList", "", "count", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class AsyncExecutor {

        @NotNull
        public static final AsyncExecutor INSTANCE = new AsyncExecutor();

        private AsyncExecutor() {
        }

        @JvmStatic
        public static final void deleteAllSearchKeywords() {
            AsyncTask.execute(new RunnableC0284b(26));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void deleteAllSearchKeywords$lambda$2() {
            RecentSearchDatabaseHelper companion = RecentSearchDatabaseHelper.INSTANCE.getInstance();
            if (companion != null) {
                companion.deleteAllSearchKeywords();
            }
        }

        @JvmStatic
        public static final void deleteSearchKeyword(final long id) {
            AsyncTask.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.base.common.data.a
                @Override // java.lang.Runnable
                public final void run() {
                    RecentSearchDatabaseHelper.AsyncExecutor.deleteSearchKeyword$lambda$1(id);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void deleteSearchKeyword$lambda$1(long j) {
            RecentSearchDatabaseHelper companion = RecentSearchDatabaseHelper.INSTANCE.getInstance();
            if (companion != null) {
                companion.deleteSearchKeyword(j);
            }
        }

        @JvmStatic
        public static final void insertSearchKeyword(@NotNull String keyword) {
            Intrinsics.checkNotNullParameter(keyword, "keyword");
            AsyncTask.execute(new RunnableC4208a(keyword, 2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void insertSearchKeyword$lambda$0(String str) {
            RecentSearchDatabaseHelper companion = RecentSearchDatabaseHelper.INSTANCE.getInstance();
            if (companion != null) {
                companion.insertSearchKeyword(str);
            }
        }

        @JvmStatic
        @NotNull
        public static final Map<String, Long> querySearchKeywordList(int count) {
            RecentSearchDatabaseHelper companion = RecentSearchDatabaseHelper.INSTANCE.getInstance();
            Intrinsics.checkNotNull(companion);
            return companion.querySearchKeywordList(count);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\r\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/data/RecentSearchDatabaseHelper$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "DATABASE_NAME", "DATABASE_VERSION", "", "INVALID_ID", "", "sInstance", "Lcom/samsung/android/support/senl/nt/base/common/data/RecentSearchDatabaseHelper;", "instance", "getInstance", "()Lcom/samsung/android/support/senl/nt/base/common/data/RecentSearchDatabaseHelper;", "createOrDeleteInstance", "isCreate", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final synchronized RecentSearchDatabaseHelper createOrDeleteInstance(boolean isCreate) {
            DefaultConstructorMarker defaultConstructorMarker = null;
            try {
                if (!isCreate) {
                    if (RecentSearchDatabaseHelper.sInstance != null) {
                        RecentSearchDatabaseHelper recentSearchDatabaseHelper = RecentSearchDatabaseHelper.sInstance;
                        Intrinsics.checkNotNull(recentSearchDatabaseHelper);
                        if (recentSearchDatabaseHelper.mDbHelper != null) {
                            RecentSearchDatabaseHelper recentSearchDatabaseHelper2 = RecentSearchDatabaseHelper.sInstance;
                            Intrinsics.checkNotNull(recentSearchDatabaseHelper2);
                            DatabaseHelper databaseHelper = recentSearchDatabaseHelper2.mDbHelper;
                            Intrinsics.checkNotNull(databaseHelper);
                            databaseHelper.close();
                            RecentSearchDatabaseHelper recentSearchDatabaseHelper3 = RecentSearchDatabaseHelper.sInstance;
                            Intrinsics.checkNotNull(recentSearchDatabaseHelper3);
                            recentSearchDatabaseHelper3.mDbHelper = null;
                        }
                    }
                    RecentSearchDatabaseHelper.sInstance = null;
                    return null;
                }
                if (RecentSearchDatabaseHelper.sInstance == null) {
                    RecentSearchDatabaseHelper.sInstance = new RecentSearchDatabaseHelper(BaseUtils.getApplicationContext(), defaultConstructorMarker);
                    RecentSearchDatabaseHelper recentSearchDatabaseHelper4 = RecentSearchDatabaseHelper.sInstance;
                    Intrinsics.checkNotNull(recentSearchDatabaseHelper4);
                    if (recentSearchDatabaseHelper4.mDbHelper == null) {
                        RecentSearchDatabaseHelper recentSearchDatabaseHelper5 = RecentSearchDatabaseHelper.sInstance;
                        Intrinsics.checkNotNull(recentSearchDatabaseHelper5);
                        RecentSearchDatabaseHelper recentSearchDatabaseHelper6 = RecentSearchDatabaseHelper.sInstance;
                        Intrinsics.checkNotNull(recentSearchDatabaseHelper6);
                        recentSearchDatabaseHelper5.mDbHelper = new DatabaseHelper(recentSearchDatabaseHelper6.mContext, RecentSearchDatabaseHelper.DATABASE_NAME, null, 2);
                    }
                } else {
                    RecentSearchDatabaseHelper recentSearchDatabaseHelper7 = RecentSearchDatabaseHelper.sInstance;
                    Intrinsics.checkNotNull(recentSearchDatabaseHelper7);
                    if (recentSearchDatabaseHelper7.mDbHelper == null) {
                        RecentSearchDatabaseHelper recentSearchDatabaseHelper8 = RecentSearchDatabaseHelper.sInstance;
                        Intrinsics.checkNotNull(recentSearchDatabaseHelper8);
                        RecentSearchDatabaseHelper recentSearchDatabaseHelper9 = RecentSearchDatabaseHelper.sInstance;
                        Intrinsics.checkNotNull(recentSearchDatabaseHelper9);
                        recentSearchDatabaseHelper8.mDbHelper = new DatabaseHelper(recentSearchDatabaseHelper9.mContext, RecentSearchDatabaseHelper.DATABASE_NAME, null, 2);
                    }
                }
                return RecentSearchDatabaseHelper.sInstance;
            } catch (Throwable th) {
                throw th;
            }
        }

        @Nullable
        public final RecentSearchDatabaseHelper getInstance() {
            return createOrDeleteInstance(true);
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0016¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/data/RecentSearchDatabaseHelper$DatabaseHelper;", "Landroid/database/sqlite/SQLiteOpenHelper;", "context", "Landroid/content/Context;", "name", "", "factory", "Landroid/database/sqlite/SQLiteDatabase$CursorFactory;", "version", "", "<init>", "(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V", "onCreate", "", "db", "Landroid/database/sqlite/SQLiteDatabase;", "onUpgrade", "oldVersion", "newVersion", "getWritableDatabase", "getReadableDatabase", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nRecentSearchDatabaseHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RecentSearchDatabaseHelper.kt\ncom/samsung/android/support/senl/nt/base/common/data/RecentSearchDatabaseHelper$DatabaseHelper\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,283:1\n1#2:284\n*E\n"})
    public static final class DatabaseHelper extends SQLiteOpenHelper {
        public DatabaseHelper(@Nullable Context context, @Nullable String str, @Nullable SQLiteDatabase.CursorFactory cursorFactory, int i) {
            super(context, str, cursorFactory, i);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        @NotNull
        public SQLiteDatabase getReadableDatabase() {
            SQLiteDatabase readableDatabase;
            try {
                readableDatabase = super.getReadableDatabase();
            } catch (Exception e) {
                Log.e(RecentSearchDatabaseHelper.TAG, "failed to open database : Exception : " + e.getMessage() + "\n");
                readableDatabase = null;
            }
            if (readableDatabase != null) {
                return readableDatabase;
            }
            throw new IllegalStateException("getReadableDatabase : Couldn't open database");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        @NotNull
        public synchronized SQLiteDatabase getWritableDatabase() {
            SQLiteDatabase writableDatabase;
            try {
                writableDatabase = super.getWritableDatabase();
            } catch (Exception e) {
                Log.e(RecentSearchDatabaseHelper.TAG, "failed to open database : Exception : " + e.getMessage() + "\n");
                writableDatabase = null;
            }
            if (writableDatabase == null) {
                throw new IllegalStateException("getWritableDatabase : Couldn't open database");
            }
            return writableDatabase;
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(@NotNull SQLiteDatabase db) {
            Intrinsics.checkNotNullParameter(db, "db");
            Log.i(RecentSearchDatabaseHelper.TAG, "DatabaseHelper onCreate");
            db.execSQL("create table recent_search(_id integer primary key autoincrement, search_keyword text not null, update_time integer not null);");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(@NotNull SQLiteDatabase db, int oldVersion, int newVersion) {
            Intrinsics.checkNotNullParameter(db, "db");
            Log.i(RecentSearchDatabaseHelper.TAG, "DatabaseHelper onUpgrade");
            db.execSQL("drop table if exists recent_search");
            onCreate(db);
        }
    }

    public /* synthetic */ RecentSearchDatabaseHelper(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    private final int deleteOldSearchKeywords(SQLiteDatabase db) {
        try {
            return db.delete("recent_search", "_id in (select _id from recent_search ORDER BY _id desc limit -1 offset 30)", null);
        } catch (SQLException e) {
            Log.e(TAG, "deleteOldSearchKeywords()", e);
            throw e;
        }
    }

    private final void sendNotificationChange() {
        Context context = this.mContext;
        Intrinsics.checkNotNull(context);
        context.getContentResolver().notifyChange(RecentSearchProvider.INSTANCE.getUri(this.mContext), null);
    }

    public final boolean deleteAllSearchKeywords() {
        int iDelete;
        DatabaseHelper databaseHelper = this.mDbHelper;
        Intrinsics.checkNotNull(databaseHelper);
        try {
            iDelete = databaseHelper.getWritableDatabase().delete("recent_search", null, null);
        } catch (SQLiteFullException e) {
            e = e;
            iDelete = 0;
        }
        try {
            sendNotificationChange();
        } catch (SQLiteFullException e2) {
            e = e2;
            AbstractC2322a.m1636z("deleteAllSearchKeywords : SQLiteFullException occurred", e.getMessage(), TAG);
        }
        return iDelete > 0;
    }

    public final boolean deleteSearchKeyword(long id) {
        int iDelete;
        DatabaseHelper databaseHelper = this.mDbHelper;
        Intrinsics.checkNotNull(databaseHelper);
        try {
            iDelete = databaseHelper.getWritableDatabase().delete("recent_search", "_id = ?", new String[]{String.valueOf(id)});
        } catch (SQLiteFullException e) {
            e = e;
            iDelete = 0;
        }
        try {
            sendNotificationChange();
        } catch (SQLiteFullException e2) {
            e = e2;
            Log.e(TAG, "deleteSearchKeyword(" + id + ") : SQLiteFullException occurred" + e.getMessage());
        }
        return iDelete > 0;
    }

    public final void destroy() {
        INSTANCE.createOrDeleteInstance(false);
    }

    public final long insertSearchKeyword(@NotNull String keyword) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        if (TextUtils.isEmpty(keyword) || !StorageUtils.isAvailableMinimumMemory()) {
            return -1L;
        }
        DatabaseHelper databaseHelper = this.mDbHelper;
        Intrinsics.checkNotNull(databaseHelper);
        SQLiteDatabase writableDatabase = databaseHelper.getWritableDatabase();
        long jInsert = 0;
        try {
            deleteSearchKeyword(keyword, writableDatabase);
            ContentValues contentValues = new ContentValues();
            contentValues.put("search_keyword", keyword);
            contentValues.put("update_time", Long.valueOf(System.currentTimeMillis()));
            jInsert = writableDatabase.insert("recent_search", null, contentValues);
            deleteOldSearchKeywords(writableDatabase);
        } catch (SQLiteFullException e) {
            Log.e(TAG, "insertSearchKeyword(" + keyword + ") : SQLiteFullException occurred " + e.getMessage());
        }
        sendNotificationChange();
        return jInsert;
    }

    @NotNull
    public final Map<String, Long> querySearchKeywordList(int count) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        DatabaseHelper databaseHelper = this.mDbHelper;
        Intrinsics.checkNotNull(databaseHelper);
        try {
            Cursor cursorQuery = databaseHelper.getReadableDatabase().query("recent_search", RecentSearchProvider.Constants.INSTANCE.getQUERY_PROJECTION(), null, null, null, null, "_id DESC");
            try {
                Cursor cursor = cursorQuery;
                if (cursor != null) {
                    while (cursor.moveToNext() && linkedHashMap.size() < count) {
                        linkedHashMap.put(cursor.getString(1), Long.valueOf(cursor.getLong(0)));
                    }
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(cursorQuery, null);
                return linkedHashMap;
            } finally {
            }
        } catch (SQLiteFullException e) {
            AbstractC2322a.m1636z("querySearchKeywords : SQLiteFullException occurred : ", e.getMessage(), TAG);
            return linkedHashMap;
        }
    }

    @Nullable
    public final Cursor querySearchKeywords() {
        try {
            DatabaseHelper databaseHelper = this.mDbHelper;
            Intrinsics.checkNotNull(databaseHelper);
            return databaseHelper.getReadableDatabase().query("recent_search", RecentSearchProvider.Constants.INSTANCE.getQUERY_PROJECTION(), null, null, null, null, "_id DESC");
        } catch (SQLiteFullException e) {
            AbstractC2322a.m1636z("querySearchKeywords : SQLiteFullException occurred : ", e.getMessage(), TAG);
            return null;
        }
    }

    private RecentSearchDatabaseHelper(Context context) {
        this.mContext = context;
    }

    public final boolean deleteSearchKeyword(@NotNull String keyword, @NotNull SQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(db, "db");
        if (TextUtils.isEmpty(keyword)) {
            return false;
        }
        try {
            return db.delete("recent_search", "search_keyword = ? COLLATE NOCASE", new String[]{keyword}) > 0;
        } catch (SQLException e) {
            Log.e(TAG, "deleteSearchKeyword(" + keyword + ")", e);
            throw e;
        }
    }
}
