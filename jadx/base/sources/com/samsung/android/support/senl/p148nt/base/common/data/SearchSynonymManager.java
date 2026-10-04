package com.samsung.android.support.senl.p148nt.base.common.data;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteFullException;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import android.util.Log;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.data.SynonymCreateDbDialog;
import com.samsung.android.support.senl.p148nt.base.common.util.StorageUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.p196io.CloseableKt;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0005\u0018\u0000 \u00182\u00020\u0001:\u0003\u0016\u0017\u0018B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\tH\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u00142\u0006\u0010\u0015\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/data/SearchSynonymManager;", "Lcom/samsung/android/support/senl/nt/base/common/data/SynonymCreateDbDialog$OnClickListener;", "<init>", "()V", "mDbHelper", "Lcom/samsung/android/support/senl/nt/base/common/data/SearchSynonymManager$DatabaseHelper;", "mCurrentVersion", "", "onConfirmCreate", "", "onConfirmShow", "onConfirmDelete", "createSynonymDB", "copyDbFromAssets", "makeDbfile", "Ljava/io/File;", "fileName", "", "dbFile", "getSearchKeyword", "", Bixby2Constants.BIXBY_PARAM_KEYWORD, "DatabaseHelper", "Constants", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nSearchSynonymManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SearchSynonymManager.kt\ncom/samsung/android/support/senl/nt/base/common/data/SearchSynonymManager\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,230:1\n739#2,9:231\n37#3:240\n36#3,3:241\n*S KotlinDebug\n*F\n+ 1 SearchSynonymManager.kt\ncom/samsung/android/support/senl/nt/base/common/data/SearchSynonymManager\n*L\n128#1:231,9\n128#1:240\n128#1:241,3\n*E\n"})
public final class SearchSynonymManager implements SynonymCreateDbDialog.OnClickListener {
    private static final int CURRENT_SYNONYM_DB_VERSION = 1;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String DATABASE_NAME = "synonym_search.db";
    private static final int DATABASE_VERSION = 2;

    @NotNull
    private static final String DB_EXTENSIONS = ".db";

    @NotNull
    private static final String DB_SHM_EXTENSIONS = ".db-shm";

    @NotNull
    private static final String DB_WAL_EXTENSIONS = ".db-wal";

    @NotNull
    private static final String DIVIDER = ";";

    @NotNull
    private static final String SYNONYM_DB_VERSION = "SYNONYM_DB_VERSION";

    @NotNull
    public static final String TAG = "SearchSynonymManager";

    @Nullable
    private static SearchSynonymManager sInstance;
    private int mCurrentVersion;

    @NotNull
    private final DatabaseHelper mDbHelper;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u00108FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0003\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/data/SearchSynonymManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "DATABASE_NAME", "DATABASE_VERSION", "", "DIVIDER", SearchSynonymManager.SYNONYM_DB_VERSION, "CURRENT_SYNONYM_DB_VERSION", "DB_EXTENSIONS", "DB_SHM_EXTENSIONS", "DB_WAL_EXTENSIONS", "sInstance", "Lcom/samsung/android/support/senl/nt/base/common/data/SearchSynonymManager;", "instance", "getInstance$annotations", "getInstance", "()Lcom/samsung/android/support/senl/nt/base/common/data/SearchSynonymManager;", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        @NotNull
        public final SearchSynonymManager getInstance() {
            if (SearchSynonymManager.sInstance == null) {
                SearchSynonymManager.sInstance = new SearchSynonymManager(null);
            }
            SearchSynonymManager searchSynonymManager = SearchSynonymManager.sInstance;
            Intrinsics.checkNotNull(searchSynonymManager, "null cannot be cast to non-null type com.samsung.android.support.senl.nt.base.common.data.SearchSynonymManager");
            return searchSynonymManager;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/data/SearchSynonymManager$Constants;", "", "Companion", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public interface Constants {
        public static final int COLUMN_SEARCH_VALUE = 2;

        @NotNull
        public static final String CREATE_DB = "create table synonym_search(_id integer primary key autoincrement, search_keyword text not null, search_values text not null);";

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = Companion.$$INSTANCE;

        @NotNull
        public static final String DROP_TABLE = "drop table if exists synonym_search";

        @NotNull
        public static final String SEARCH_KEYWORD = "search_keyword";

        @NotNull
        public static final String SEARCH_VALUE = "search_values";

        @NotNull
        public static final String TABLE_NAME = "synonym_search";

        @NotNull
        public static final String _ID = "_id";

        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0010\u001a\u00020\u0011X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/data/SearchSynonymManager$Constants$Companion;", "", "<init>", "()V", "TABLE_NAME", "", "_ID", "SEARCH_KEYWORD", "SEARCH_VALUE", "CREATE_DB", "DROP_TABLE", "QUERY_PROJECTION", "", "getQUERY_PROJECTION", "()[Ljava/lang/String;", "[Ljava/lang/String;", "COLUMN_SEARCH_VALUE", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
        public static final class Companion {
            public static final int COLUMN_SEARCH_VALUE = 2;

            @NotNull
            public static final String CREATE_DB = "create table synonym_search(_id integer primary key autoincrement, search_keyword text not null, search_values text not null);";

            @NotNull
            public static final String DROP_TABLE = "drop table if exists synonym_search";

            @NotNull
            public static final String SEARCH_KEYWORD = "search_keyword";

            @NotNull
            public static final String SEARCH_VALUE = "search_values";

            @NotNull
            public static final String TABLE_NAME = "synonym_search";

            @NotNull
            public static final String _ID = "_id";
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            @NotNull
            private static final String[] QUERY_PROJECTION = {"_id", "search_keyword", "search_values"};

            private Companion() {
            }

            @NotNull
            public final String[] getQUERY_PROJECTION() {
                return QUERY_PROJECTION;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J \u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0016¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/data/SearchSynonymManager$DatabaseHelper;", "Landroid/database/sqlite/SQLiteOpenHelper;", "context", "Landroid/content/Context;", "name", "", "factory", "Landroid/database/sqlite/SQLiteDatabase$CursorFactory;", "version", "", "<init>", "(Landroid/content/Context;Ljava/lang/String;Landroid/database/sqlite/SQLiteDatabase$CursorFactory;I)V", "onCreate", "", "db", "Landroid/database/sqlite/SQLiteDatabase;", "onUpgrade", "oldVersion", "newVersion", "getWritableDatabase", "getReadableDatabase", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nSearchSynonymManager.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SearchSynonymManager.kt\ncom/samsung/android/support/senl/nt/base/common/data/SearchSynonymManager$DatabaseHelper\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,230:1\n1#2:231\n*E\n"})
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
                Log.e(SearchSynonymManager.TAG, "failed to open database : Exception : " + e.getMessage() + "\n");
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
                Log.e(SearchSynonymManager.TAG, "failed to open database : Exception : " + e.getMessage() + "\n");
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
            Log.i(SearchSynonymManager.TAG, "DatabaseHelper onCreate");
            db.execSQL("create table synonym_search(_id integer primary key autoincrement, search_keyword text not null, search_values text not null);");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(@NotNull SQLiteDatabase db, int oldVersion, int newVersion) {
            Intrinsics.checkNotNullParameter(db, "db");
            Log.i(SearchSynonymManager.TAG, "DatabaseHelper onUpgrade");
            db.execSQL("drop table if exists synonym_search");
            onCreate(db);
        }
    }

    public /* synthetic */ SearchSynonymManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final void copyDbFromAssets() throws IOException {
        File fileMakeDbfile = makeDbfile(DATABASE_NAME);
        if (fileMakeDbfile != null) {
            copyDbFromAssets(fileMakeDbfile, DATABASE_NAME);
        }
        File fileMakeDbfile2 = makeDbfile("synonym_search.db-shm");
        if (fileMakeDbfile2 != null) {
            copyDbFromAssets(fileMakeDbfile2, "synonym_search.db-shm");
        }
        File fileMakeDbfile3 = makeDbfile("synonym_search.db-wal");
        if (fileMakeDbfile3 != null) {
            copyDbFromAssets(fileMakeDbfile3, "synonym_search.db-wal");
        }
        Log.e(TAG, "copyDbFromAssets");
    }

    private final void createSynonymDB() throws IOException {
        if (this.mCurrentVersion == 1) {
            return;
        }
        if (!StorageUtils.isAvailableMemoryForNewMemo()) {
            Log.e(TAG, "createSynonymDB : not isAvailableMemoryForNewMemo");
            return;
        }
        copyDbFromAssets();
        this.mCurrentVersion = 1;
        SharedPreferencesCompat.INSTANCE.getInstance().putInt(SYNONYM_DB_VERSION, this.mCurrentVersion);
    }

    @NotNull
    public static final SearchSynonymManager getInstance() {
        return INSTANCE.getInstance();
    }

    private final File makeDbfile(String fileName) {
        Context applicationContext = BaseUtils.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext);
        File databasePath = applicationContext.getDatabasePath(fileName);
        if (databasePath == null) {
            return null;
        }
        if (databasePath.getParentFile() != null) {
            File parentFile = databasePath.getParentFile();
            Intrinsics.checkNotNull(parentFile);
            if (!parentFile.exists()) {
                File parentFile2 = databasePath.getParentFile();
                Intrinsics.checkNotNull(parentFile2);
                parentFile2.mkdir();
            }
        }
        if (databasePath.exists()) {
            databasePath.delete();
        }
        try {
            databasePath.createNewFile();
            return databasePath;
        } catch (IOException e) {
            AbstractC2322a.m1636z("copyDbFromAssets : occurred", e.getMessage(), TAG);
            return databasePath;
        }
    }

    @NotNull
    public final synchronized Collection<String> getSearchKeyword(@NotNull String keyword) {
        HashSet hashSet;
        List listEmptyList;
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        createSynonymDB();
        hashSet = new HashSet();
        try {
            Cursor cursorQuery = this.mDbHelper.getReadableDatabase().query("synonym_search", Constants.INSTANCE.getQUERY_PROJECTION(), "search_keyword = ? COLLATE NOCASE", new String[]{keyword}, null, null, null);
            try {
                Cursor cursor = cursorQuery;
                while (cursor.moveToNext()) {
                    String string = cursor.getString(2);
                    if (!TextUtils.isEmpty(string)) {
                        Intrinsics.checkNotNull(string);
                        List<String> listSplit = new Regex(";").split(string, 0);
                        if (listSplit.isEmpty()) {
                            listEmptyList = CollectionsKt.emptyList();
                            String[] strArr = (String[]) listEmptyList.toArray(new String[0]);
                            hashSet.addAll(CollectionsKt.listOf(Arrays.copyOf(strArr, strArr.length)));
                        } else {
                            ListIterator<String> listIterator = listSplit.listIterator(listSplit.size());
                            while (listIterator.hasPrevious()) {
                                if (listIterator.previous().length() != 0) {
                                    listEmptyList = CollectionsKt.take(listSplit, listIterator.nextIndex() + 1);
                                    break;
                                }
                            }
                            listEmptyList = CollectionsKt.emptyList();
                            String[] strArr2 = (String[]) listEmptyList.toArray(new String[0]);
                            hashSet.addAll(CollectionsKt.listOf(Arrays.copyOf(strArr2, strArr2.length)));
                        }
                    }
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(cursorQuery, null);
            } finally {
            }
        } catch (SQLiteFullException e) {
            Log.e(TAG, "querySearchKeywords : SQLiteFullException occurred : " + e.getMessage());
        } catch (SQLException e2) {
            Log.e(TAG, "querySearchKeywords : SQLiteFullException occurred : " + e2.getMessage());
        }
        return hashSet;
    }

    @Override // com.samsung.android.support.senl.nt.base.common.data.SynonymCreateDbDialog.OnClickListener
    public void onConfirmCreate() {
    }

    @Override // com.samsung.android.support.senl.nt.base.common.data.SynonymCreateDbDialog.OnClickListener
    public void onConfirmDelete() {
        int iDelete;
        try {
            iDelete = this.mDbHelper.getWritableDatabase().delete("synonym_search", null, null);
        } catch (SQLiteFullException e) {
            AbstractC2322a.m1636z("onConfirmDelete : SQLiteFullException occurred", e.getMessage(), TAG);
            iDelete = 0;
        }
        Log.e(TAG, "onConfirmDelete : " + (iDelete > 0));
    }

    @Override // com.samsung.android.support.senl.nt.base.common.data.SynonymCreateDbDialog.OnClickListener
    public void onConfirmShow() {
    }

    private SearchSynonymManager() {
        this.mDbHelper = new DatabaseHelper(BaseUtils.getApplicationContext(), DATABASE_NAME, null, 2);
        this.mCurrentVersion = SharedPreferencesCompat.INSTANCE.getInstance().getInt(SYNONYM_DB_VERSION, 0);
    }

    private final void copyDbFromAssets(File dbFile, String fileName) throws IOException {
        Context applicationContext = BaseUtils.getApplicationContext();
        Intrinsics.checkNotNull(applicationContext);
        InputStream inputStreamOpen = applicationContext.getResources().getAssets().open(fileName, 3);
        Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "open(...)");
        FileOutputStream fileOutputStream = new FileOutputStream(dbFile);
        try {
            try {
                byte[] bArr = new byte[2048];
                int i = 0;
                while (i != -1) {
                    i = inputStreamOpen.read(bArr);
                    fileOutputStream.write(bArr);
                }
            } catch (IOException e) {
                Log.e(TAG, "copyDbFromAssets : occurred" + e.getMessage());
            }
        } finally {
            inputStreamOpen.close();
            fileOutputStream.close();
        }
    }
}
